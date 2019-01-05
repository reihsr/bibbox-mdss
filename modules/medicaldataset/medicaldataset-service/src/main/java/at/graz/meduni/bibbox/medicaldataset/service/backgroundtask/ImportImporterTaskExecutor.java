package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet;
import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetFieldMapLocalServiceUtil;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLocalServiceUtil;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLogLocalServiceUtil;
import at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper.XMLParserFactory;
import at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper.XMLParserInterface;

@Component(immediate = true, property = {
		"background.task.executor.class.name=at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.ImportImporterTaskExecutor" }, service = BackgroundTaskExecutor.class)
public class ImportImporterTaskExecutor extends BaseBackgroundTaskExecutor {

	int importStatus_ = 25;
	long importMedicalDataSetId_ = 0;
	ImportImporterTaskMappingsHelper importImporterTaskMappingsHelper_ = null;
	ServiceContext serviceContext_ = null;
	HashMap<String, ImportMedicalDataSetFieldMap> fieldMap_ = new  HashMap<String, ImportMedicalDataSetFieldMap>();
	
	public ImportImporterTaskExecutor() {
		setBackgroundTaskStatusMessageTranslator(new ImportImporterTaskStatusMessageTranslator());
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		System.out.println("ImportImporterTaskExecutor START");
		Map taskContextMap = backgroundTask.getTaskContextMap();
		
		serviceContext_ = new ServiceContext();
		long scopeGroupId = Long.parseLong(taskContextMap.get("scopeGroupId").toString());
		long userId = Long.parseLong(taskContextMap.get("userId").toString());
		serviceContext_.setScopeGroupId(scopeGroupId);
		serviceContext_.setUserId(userId);
		
		importMedicalDataSetId_ = Long.parseLong(taskContextMap.get("importMedicalDataSetId").toString());
		ImportMedicalDataSet importMedicalDataSet = ImportMedicalDataSetLocalServiceUtil.getImportMedicalDataSet(importMedicalDataSetId_);
		importMedicalDataSet.setImportStatus(importStatus_);
		importMedicalDataSet = ImportMedicalDataSetLocalServiceUtil.updateImportMedicalDataSet(importMedicalDataSet);
		ImportMedicalDataSetLogLocalServiceUtil.addImportMedicalDataSetLog(importMedicalDataSetId_, importStatus_, "Stating Importing Task " + new Date().toString(), serviceContext_);
		
		importMedicalDataSets(importMedicalDataSet);
		
		ImportMedicalDataSetLogLocalServiceUtil.addImportMedicalDataSetLog(importMedicalDataSetId_, importStatus_, "Finished Importing Task " + new Date().toString(), serviceContext_);
		importMedicalDataSet.setImportStatus(100);
		importMedicalDataSet = ImportMedicalDataSetLocalServiceUtil.updateImportMedicalDataSet(importMedicalDataSet);
		System.out.println("ImportImporterTaskExecutor ENDED");
		return BackgroundTaskResult.SUCCESS;
	}
	
	private void importMedicalDataSets(ImportMedicalDataSet importMedicalDataSet) {
		try {
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(importMedicalDataSet.getFileId());
			ImportMedicalDataSetLogLocalServiceUtil.addImportMedicalDataSetLog(importMedicalDataSetId_, importStatus_, "File: " + fileEntry.getFileName(), serviceContext_);
			generateXMLWalkMap(importMedicalDataSet);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fileEntry.getContentStream());
			doc.getDocumentElement().normalize();
			ImportMedicalDataSetLogLocalServiceUtil.addImportMedicalDataSetLog(importMedicalDataSetId_, importStatus_, "Root element: " + doc.getDocumentElement().getNodeName(), serviceContext_);
			
			XMLParserFactory xmlParserFactory = new XMLParserFactory();
			XMLParserInterface xmlParserInterface = xmlParserFactory.getXMLParser(doc.getDocumentElement().getNodeName());
			xmlParserInterface.setDocument(doc);
			
			NodeList nodeListDetails = doc.getElementsByTagName("Details");
			extractDataFromNodeListDetails(nodeListDetails);
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void extractDataFromNodeListDetails(NodeList nodeListDetails) {
		for(int detailsListCounter = 0; detailsListCounter < nodeListDetails.getLength(); detailsListCounter++) {
			try {
				importImporterTaskMappingsHelper_.createObjects();
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
									importImporterTaskMappingsHelper_.updateObjectFields(fieldName, detailsSectionFieldValueNode.getNodeName(), detailsSectionFieldValueNode.getTextContent());
								}
							}
						}
					}
				}
				importImporterTaskMappingsHelper_.addStaticFields();
				importImporterTaskMappingsHelper_.updateDatabaseObjects();
			} catch(Exception e) {
				System.err.println("Error extractDataFromNodeListDetails: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	private void generateXMLWalkMap(ImportMedicalDataSet importMedicalDataSet) {
		List<ImportMedicalDataSetFieldMap> importMedicalDataSetFieldMaps = ImportMedicalDataSetFieldMapLocalServiceUtil.getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(importMedicalDataSet.getImportMedicalDataSetId());
		importImporterTaskMappingsHelper_ = new ImportImporterTaskMappingsHelper(importMedicalDataSetFieldMaps, importMedicalDataSet.getImportMedicalDataSetId(), serviceContext_.getUserId(), serviceContext_.getScopeGroupId());
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		System.out.println("ImportImporterTaskExecutor.getBackgroundTaskDisplay");
		return BackgroundTaskDisplayFactoryUtil.getBackgroundTaskDisplay(backgroundTask);
	}

	@Override
	public BackgroundTaskExecutor clone() {
		System.out.println("clone ImportImporterTaskExecutor");
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
