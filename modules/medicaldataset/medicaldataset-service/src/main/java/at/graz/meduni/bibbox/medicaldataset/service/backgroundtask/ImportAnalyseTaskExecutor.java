package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.osgi.service.component.annotations.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplayFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet;
import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetFieldMapLocalServiceUtil;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLocalServiceUtil;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLogLocalServiceUtil;
import at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper.XMLParserFactory;
import at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper.XMLParserInterface;

@Component(
	immediate = true, 
	property = {"background.task.executor.class.name=at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.ImportAnalyseTaskExecutor"}, 
	service = BackgroundTaskExecutor.class
)
public class ImportAnalyseTaskExecutor extends BaseBackgroundTaskExecutor {
	
	int importStatus_ = 5;
	int detailsListCounterMax_ = 1;
	long importMedicalDataSetId_ = 0;
	ServiceContext serviceContext_ = null;
	HashMap<String, ImportMedicalDataSetFieldMap> fieldMap_ = new  HashMap<String, ImportMedicalDataSetFieldMap>();
	
	public ImportAnalyseTaskExecutor() {
		setBackgroundTaskStatusMessageTranslator(new ImportAnalyseTaskStatusMessageTranslator());
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		long timeStart = System.currentTimeMillis();
		System.out.println("ImportAnalyseTaskExecutor START");
		try {
			Map taskContextMap = backgroundTask.getTaskContextMap();
			String importType = taskContextMap.get("importType").toString();
			
			serviceContext_ = new ServiceContext();
			long scopeGroupId = Long.parseLong(taskContextMap.get("scopeGroupId").toString());
			long userId = Long.parseLong(taskContextMap.get("userId").toString());
			serviceContext_.setScopeGroupId(scopeGroupId);
			serviceContext_.setUserId(userId);
			
			importMedicalDataSetId_ = Long.parseLong(taskContextMap.get("importMedicalDataSetId").toString());
			ImportMedicalDataSet importMedicalDataSet = ImportMedicalDataSetLocalServiceUtil.getImportMedicalDataSet(importMedicalDataSetId_);
			importMedicalDataSet.setImportStatus(importStatus_);
			importMedicalDataSet = ImportMedicalDataSetLocalServiceUtil.updateImportMedicalDataSet(importMedicalDataSet);
			ImportMedicalDataSetLogLocalServiceUtil.addImportMedicalDataSetLog(importMedicalDataSetId_, importStatus_, "Stating Analysis Task " + new Date().toString(), serviceContext_);
			
			System.out.println("ImportAnalyseTaskExecutor: with Type: " + importType);
			int numberOfFields = 0;
			if(importType.equals("PathologyDataSet") || importType.equals("Kloezelbuch")) {
				numberOfFields = analyseXMLFile(importMedicalDataSet);
			}
			
			importMedicalDataSet.setImportStatus(10);
			importMedicalDataSet.setImportCount(numberOfFields);
			importMedicalDataSet = ImportMedicalDataSetLocalServiceUtil.updateImportMedicalDataSet(importMedicalDataSet);
		} catch(Exception ex) {
			System.err.println("Error in ImportAnalyseTaskExecutor: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		long timeNeeded = System.currentTimeMillis() - timeStart;
		System.out.println("ImportAnalyseTaskExecutor ENDED (needed " + timeNeeded + "ms)");
		return BackgroundTaskResult.SUCCESS;
	}
	
	//https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
	private int analyseXMLFile(ImportMedicalDataSet importMedicalDataSet) {
		int numberOfFields = 0;
		try {
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(importMedicalDataSet.getFileId());
			ImportMedicalDataSetLogLocalServiceUtil.addImportMedicalDataSetLog(importMedicalDataSetId_, importStatus_, "File: " + fileEntry.getFileName(), serviceContext_);
			System.out.println("Loading File: " + fileEntry.getFileName());
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fileEntry.getContentStream());
			doc.getDocumentElement().normalize();
			ImportMedicalDataSetLogLocalServiceUtil.addImportMedicalDataSetLog(importMedicalDataSetId_, importStatus_, "Root element: " + doc.getDocumentElement().getNodeName(), serviceContext_);
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			
			XMLParserFactory xmlParserFactory = new XMLParserFactory();
			XMLParserInterface xmlParserInterface = xmlParserFactory.getXMLParser(doc.getDocumentElement().getNodeName());
			xmlParserInterface.setDocument(doc);
			xmlParserInterface.setServiceContext(serviceContext_);
			
			// Analyse Footer
			HashMap<String, String> footerData = xmlParserInterface.getXMLFooter();
			numberOfFields = Integer.parseInt(footerData.get("AnzENUM"));
			System.out.println(footerData.get("lblAnzENUM") + " " + numberOfFields);
			ImportMedicalDataSetLogLocalServiceUtil.addImportMedicalDataSetLog(importMedicalDataSetId_, importStatus_, footerData.get("lblAnzENUM") + " " + numberOfFields, serviceContext_);
			
			// Analyse Data Fields
			HashMap<String, String> structureData = xmlParserInterface.generateXMLDataStructureForMapping();
			System.out.println("Analysed Entries: " + structureData.get("Analysed Entries") + " | Analysed Fields: " + structureData.get("Analysed Fields"));
			ImportMedicalDataSetLogLocalServiceUtil.addImportMedicalDataSetLog(importMedicalDataSetId_, importStatus_, "Analysed Entries: " + structureData.get("Analysed Entries") + " | Analysed Fields: " + structureData.get("Analysed Fields"), serviceContext_);
			
			// TODO: Remove old version
			//NodeList nodeListDetails = doc.getElementsByTagName("Details");
			//extractDataFromNodeListDetails(nodeListDetails);
			
		} catch (PortalException e) {
			System.err.println("Error in ImportAnalyseTaskExecutor.analyseXMLFile: " + e.getMessage());
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			System.err.println("Error in ImportAnalyseTaskExecutor.analyseXMLFile: " + e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			System.err.println("Error in ImportAnalyseTaskExecutor.analyseXMLFile: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error in ImportAnalyseTaskExecutor.analyseXMLFile: " + e.getMessage());
			e.printStackTrace();
		}
		return numberOfFields;
	}
	
	private void extractDataFromNodeListDetails(NodeList nodeListDetails) {
		for(int detailsListCounter = 0; detailsListCounter < detailsListCounterMax_; detailsListCounter++) {
			Node detailsNode = nodeListDetails.item(detailsListCounter);
			NodeList nodeListDetailsSection = detailsNode.getChildNodes();
			for(int detailsSectionListCounter = 0; detailsSectionListCounter < nodeListDetailsSection.getLength(); detailsSectionListCounter++) {
				Node detailsSectionNode = nodeListDetailsSection.item(detailsSectionListCounter);
				if(detailsSectionNode.getNodeName().equals("Section")) {
					NodeList nodeListDetailsSectionField = detailsSectionNode.getChildNodes();
					for(int detailsSectionFieldListCounter = 0; detailsSectionFieldListCounter < nodeListDetailsSectionField.getLength(); detailsSectionFieldListCounter++) {
						Node detailsSectionFieldNode = nodeListDetailsSectionField.item(detailsSectionFieldListCounter);
						if(detailsSectionFieldNode.getNodeName().equals("Field")) {
							Element detailsSectionFieldElement = (Element) detailsSectionFieldNode;
							String fieldName = detailsSectionFieldElement.getAttribute("Name");
							NodeList nodeListDetailsSectionFieldValue = detailsSectionFieldNode.getChildNodes();
							for(int detailsSectionFieldValueListCounter = 0; detailsSectionFieldValueListCounter < nodeListDetailsSectionFieldValue.getLength(); detailsSectionFieldValueListCounter++) {
								Node detailsSectionFieldValueNode = nodeListDetailsSectionFieldValue.item(detailsSectionFieldValueListCounter);
								updateFieldMap(fieldName, "CrystalReport>Details>Section>Field>" + detailsSectionFieldValueNode.getNodeName(), detailsSectionFieldValueNode.getNodeName(), detailsSectionFieldValueNode.getTextContent());
								//System.out.println("-- " + fieldName + ": " + detailsSectionFieldValueNode.getNodeName() + " - " + detailsSectionFieldValueNode.getTextContent());
								//TODO: filedPath not correct, Missing the field names somthing like: 
								// Path: CrystalReport>Details>Section>Field::Attribute|Name:EINGANGSDATUM1>FormattedValue
							}
						}
					}
				}
			}
		}
		updateImportMedicalDataSetFieldMap();
	}

	private void updateFieldMap(String fieldName, String fieldPath, String valueFormat, String sampleValue) {
		try {
			ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = null;
			if(fieldMap_.containsKey(fieldName)) {
				importMedicalDataSetFieldMap = fieldMap_.get(fieldName);
			} else {
				importMedicalDataSetFieldMap = ImportMedicalDataSetFieldMapLocalServiceUtil.addImportMedicalDataSetFieldMap(importMedicalDataSetId_, fieldName, "[]", "[]", "", "", serviceContext_);
			}
			importMedicalDataSetFieldMap.setSampleValue(updateJASONArrayWithString(importMedicalDataSetFieldMap.getSampleValue(), fieldPath, sampleValue));
			JSONObject jasonObject = JSONFactoryUtil.createJSONObject();
			jasonObject.put("path", fieldPath);
			if(fieldPath.endsWith("FormattedValue")) {
				jasonObject.put("selected", "true");
			} else {
				jasonObject.put("selected", "false");
			}
			importMedicalDataSetFieldMap.setImportFieldPath(updateJASONArrayWithString(importMedicalDataSetFieldMap.getImportFieldPath(), jasonObject));
			
			fieldMap_.remove(fieldName);
			fieldMap_.put(fieldName, importMedicalDataSetFieldMap);
		} catch (PortalException e) {
			System.err.println("Error in ImportAnalyseTaskExecutor.updateFieldMap: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private String updateJASONArrayWithString(String existingJsonString, String keyString, String valueString) {
		try {
			JSONArray sampleValueArray = JSONFactoryUtil.createJSONArray(existingJsonString);
			if(keyString == null) {
				sampleValueArray.put(valueString);
			} else {
				JSONObject jasonObject = JSONFactoryUtil.createJSONObject();
				jasonObject.put(keyString, valueString);
				sampleValueArray.put(jasonObject);
			}
			return sampleValueArray.toJSONString();
		} catch (JSONException e) {
			System.err.println("Error in ImportAnalyseTaskExecutor.updateJASONArrayWithString: " + e.getMessage());
			e.printStackTrace();
		}
		return existingJsonString;
	}
	
	private String updateJASONArrayWithString(String existingJsonString, JSONObject jasonObject) {
		try {
			JSONArray sampleValueArray = JSONFactoryUtil.createJSONArray(existingJsonString);
			sampleValueArray.put(jasonObject);
			return sampleValueArray.toJSONString();
		} catch (JSONException e) {
			System.err.println("Error in ImportAnalyseTaskExecutor.updateJASONArrayWithString: " + e.getMessage());
			e.printStackTrace();
		}
		return existingJsonString;
	}
	
	private void updateImportMedicalDataSetFieldMap() {
		for(String fieldName : fieldMap_.keySet()) {
			ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fieldMap_.get(fieldName);
			ImportMedicalDataSetFieldMapLocalServiceUtil.updateImportMedicalDataSetFieldMap(importMedicalDataSetFieldMap);
		}
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		System.out.println("ImportAnalyseTaskExecutor.getBackgroundTaskDisplay");
		return BackgroundTaskDisplayFactoryUtil.getBackgroundTaskDisplay(backgroundTask);
	}

	@Override
	public BackgroundTaskExecutor clone() {
		System.out.println("clone ImportAnalyseTaskExecutor");
		return this;
	}
	
	@Override
	public boolean isSerial() {
		return true;
	}
	
	@Override
	public int getIsolationLevel() {
		return BackgroundTaskConstants.ISOLATION_LEVEL_TASK_NAME;
	}
}
