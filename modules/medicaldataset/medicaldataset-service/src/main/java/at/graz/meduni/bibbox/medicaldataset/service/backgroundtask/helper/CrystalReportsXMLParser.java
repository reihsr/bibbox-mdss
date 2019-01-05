package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask.helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.HashMap;
import java.util.HashSet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetFieldMapLocalServiceUtil;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLogLocalServiceUtil;

public class CrystalReportsXMLParser implements XMLParserInterface {

	Document document_ = null;
	ServiceContext serviceContext_ = null;
	long importMedicalDataSetId_ = 0;
	
	@Override
	public String getXMLParser() {
		return "CrystalReport";
	}
	
	@Override
	public void setDocument(Document document) {
		document_ = document;
		document_.getDocumentElement().normalize();
	}
	
	@Override
	public void setServiceContext(ServiceContext serviceContext) {
		serviceContext_ = serviceContext;
	}
	
	@Override
	public void setImportMedicalDataSetId(long importMedicalDataSetId) {
		importMedicalDataSetId_ = importMedicalDataSetId;
	}
	
	/*
	 * ------------------------------------------------------
	 * Report Footer reading
	 */
	
	@Override
	public HashMap<String, String> getXMLFooter() {
		return getReportFooter();
	}

	public HashMap<String, String> getReportFooter() {
		NodeList nodeListReportFooter = document_.getElementsByTagName("ReportFooter");
		for (int nodeCounter = 0; nodeCounter < nodeListReportFooter.getLength(); nodeCounter++) {
			Node reportFooterNode = nodeListReportFooter.item(nodeCounter);
			return analyseReportFooter(reportFooterNode.getChildNodes());
		}
		return null;
	}
	
	private HashMap<String, String> analyseReportFooter(NodeList nodeListReportFooterSection) {
		for (int nodeCounter = 0; nodeCounter < nodeListReportFooterSection.getLength(); nodeCounter++) {
			Node reportFooterSectionNode = nodeListReportFooterSection.item(nodeCounter);
			if(reportFooterSectionNode.getNodeName().equals("Section")) {
				return analyseReportFooterSection(reportFooterSectionNode.getChildNodes());
			}
		}
		return null;
	}
	
	private HashMap<String, String> analyseReportFooterSection(NodeList nodeListReportFooterSectionFields) {
		String label = "";
		String data = "";
		HashMap<String, String> reportFooter = new HashMap<String, String>();
		for (int nodeCounter = 0; nodeCounter < nodeListReportFooterSectionFields.getLength(); nodeCounter++) {
			Node reportFooterSectionFieldsNode = nodeListReportFooterSectionFields.item(nodeCounter);
			if(reportFooterSectionFieldsNode.getNodeName().equals("Text")) {
				label = analyseReportFooterSectionText(reportFooterSectionFieldsNode.getChildNodes());
			}
			if(reportFooterSectionFieldsNode.getNodeName().equals("Field")) {
				data = analyseReportFooterSectionField(reportFooterSectionFieldsNode.getChildNodes());
			}
		}
		reportFooter.put("lblAnzENUM", label);
		reportFooter.put("AnzENUM", data);
		return reportFooter;
	}
	
	private String analyseReportFooterSectionText(NodeList nodeListReportFooterSectionTextValues) {
		for (int nodeCounter = 0; nodeCounter < nodeListReportFooterSectionTextValues.getLength(); nodeCounter++) {
			String tmp = getNodeTextContent(nodeListReportFooterSectionTextValues.item(nodeCounter), "TextValue");
			if(tmp != null) {
				return tmp;
			}
		}
		return null;
	}
	
	private String analyseReportFooterSectionField(NodeList nodeListReportFooterSectionFieldValues) {
		for (int nodeCounter = 0; nodeCounter < nodeListReportFooterSectionFieldValues.getLength(); nodeCounter++) {
			String tmp = getNodeTextContent(nodeListReportFooterSectionFieldValues.item(nodeCounter), "Value");
			if(tmp != null) {
				return tmp;
			}
		}
		return null;
	}
	
	private String getNodeTextContent(Node node, String nodeName) {
		if(node.getNodeName().equals(nodeName)) {
			return node.getTextContent();
		}
		return null;
	}
	
	/*
	 * ------------------------------------------------------
	 * Data reading
	 */
	
	int analyseFirstDataElements_ = 5;
	HashMap<String, ImportMedicalDataSetFieldMap> fieldMap_ = null;
	boolean generateStructure_ = true;
	
	@Override
	public HashMap<String, String> generateXMLDataStructureForMapping() {
		System.out.println("Generate Data Structure from XML for Import Data Mapping");
		System.out.println("Analyse first " + analyseFirstDataElements_ + " Data elements.");
		fieldMap_ = new  HashMap<String, ImportMedicalDataSetFieldMap>();
		generateStructure_ = true;
		// Run analysis
		int analysedElements = nextDataFromDetails(analyseFirstDataElements_);
		HashMap<String, String> value = new HashMap<String, String>();
		value.put("Analysed Entries", String.valueOf(analysedElements));
		value.put("Analysed Fields", String.valueOf(fieldMap_.size()));
		return value;
	}
	
	@Override
	public String getXMLData() {
		System.out.println("Extract Data with Mapping");
		generateStructure_ = false;
		// Run data mapping
		nextDataFromDetails(0);
		
		return "";
	}
	
	private int nextDataFromDetails(int nodeListDetailsCount) {
		NodeList nodeListDetails = document_.getElementsByTagName("Details");
		int analysedElements = 0;
		if(nodeListDetailsCount == 0) {
			nodeListDetailsCount = nodeListDetails.getLength();
		}
		for (int nodeCounter = 0; nodeCounter < nodeListDetailsCount; nodeCounter++) {
			System.out.println("CrystalReportsXMLParser.getDataFromDetails()::nodeCounter: " + nodeCounter);
			Node nodeDetails = nodeListDetails.item(nodeCounter);
			analyseDetailsNode(nodeDetails.getChildNodes());
			analysedElements++;
		}
		return analysedElements;
	}
	
	private void analyseDetailsNode(NodeList nodeListDetails) {
		for (int nodeCounter = 0; nodeCounter < nodeListDetails.getLength(); nodeCounter++) {
			Node detailsSectionNode = nodeListDetails.item(nodeCounter);
			if(detailsSectionNode.getNodeName().equals("Section")) {
				analyseDetailsSection(detailsSectionNode.getChildNodes());
			}
		}
	}
	
	private void analyseDetailsSection(NodeList nodeListDetailsSection) {
		for (int nodeCounter = 0; nodeCounter < nodeListDetailsSection.getLength(); nodeCounter++) {
			Node detailsSectionFieldsNode = nodeListDetailsSection.item(nodeCounter);
			if(detailsSectionFieldsNode.getNodeName().equals("Field")) {
				Element detailsSectionFieldElement = (Element) detailsSectionFieldsNode;
				if(generateStructure_) {
					analyseDetailsSectionGenerateStructure(detailsSectionFieldElement.getAttribute("Name"), detailsSectionFieldsNode.getChildNodes());
				} else {
					// TODO: Mapping implementations
				}
			}
		}
	}
	
	private void analyseDetailsSectionGenerateStructure(String fieldName, NodeList nodeListDetailsSectionFieldValue) {
		try {
			ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = null;
			if(fieldMap_.containsKey(fieldName)) {
				importMedicalDataSetFieldMap = fieldMap_.get(fieldName);
			} else {
				importMedicalDataSetFieldMap = ImportMedicalDataSetFieldMapLocalServiceUtil.addImportMedicalDataSetFieldMap(importMedicalDataSetId_, fieldName, "[]", "[]", "", "", serviceContext_);
			}
			
			analyseDetailsSectionField(importMedicalDataSetFieldMap, fieldName, nodeListDetailsSectionFieldValue);
			
			fieldMap_.replace(fieldName, importMedicalDataSetFieldMap);
		} catch (PortalException e) {
			System.err.println("Error in CrystalReportsXMLParser.analyseDetailsSectionGenerateStructure: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private ImportMedicalDataSetFieldMap analyseDetailsSectionField(ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap, String fieldName, NodeList nodeListDetailsSectionFieldValue) {
		for (int nodeCounter = 0; nodeCounter < nodeListDetailsSectionFieldValue.getLength(); nodeCounter++) {
			Node detailsSectionFieldsValueNode = nodeListDetailsSectionFieldValue.item(nodeCounter);
			importMedicalDataSetFieldMap.setFieldsData("CrystalReport>Details>Section>Field>" + fieldName + ">" + detailsSectionFieldsValueNode.getNodeName(), detailsSectionFieldsValueNode.getTextContent());
		}
		return importMedicalDataSetFieldMap;
	}

	

	

	

	
	
	/*private void extractDataFromNodeListDetails(NodeList nodeListDetails) {
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
	}*/
}
