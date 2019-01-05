package at.graz.meduni.bibbox.medicaldataset.service.backgroundtask;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap;
import at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch;
import at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord;
import at.graz.meduni.bibbox.medicaldataset.model.PathologyData;
import at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchLocalServiceUtil;
import at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalServiceUtil;
import at.graz.meduni.bibbox.medicaldataset.service.PathologyDataLocalServiceUtil;

public class ImportImporterTaskMappingsHelper {

	ArrayList<String> path_ = new ArrayList<String>();
	HashMap<String, ImportImporterTaskMapHelper> taskMaps_ = new HashMap<String, ImportImporterTaskMapHelper>();
	long importMedicalDataSetId_ = 0;
	HashSet<String> objectsToCreate = new HashSet<String>();
	MedicalRecord medicalRecord_ = null;
	PathologyData pathologyData_ = null;
	KloetzelBuch kloetzelBuch_ = null;
	ServiceContext serviceContext_ = null;
	
	String DEFAULT_PATTERN = "dd.MM.yyyy";
	DateFormat dateFormatter_ = new SimpleDateFormat(DEFAULT_PATTERN);
	
	public ImportImporterTaskMappingsHelper(List<ImportMedicalDataSetFieldMap> importMedicalDataSetFieldMaps, long importMedicalDataSetId, long userId, long scopeGroupId) {
		importMedicalDataSetId_ = importMedicalDataSetId;
		serviceContext_ = new ServiceContext();
		serviceContext_.setScopeGroupId(scopeGroupId);
		serviceContext_.setUserId(userId);
		for(ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : importMedicalDataSetFieldMaps) {
			if(importMedicalDataSetFieldMap.isNotSelected()) {
				continue;
			}
			ImportImporterTaskMapHelper importImporterTaskMapHelper = new ImportImporterTaskMapHelper(importMedicalDataSetFieldMap);
			taskMaps_.put(importImporterTaskMapHelper.getFieldName(), importImporterTaskMapHelper);
			if(!objectsToCreate.contains(importMedicalDataSetFieldMap.getTableName())) {
				objectsToCreate.add(importMedicalDataSetFieldMap.getTableName());
			}
		}
	}
	
	public void createObjects() {
		if(objectsToCreate.contains("MedicalRecord")) {
			try {
				medicalRecord_ = MedicalRecordLocalServiceUtil.addMedicalRecord(importMedicalDataSetId_, serviceContext_);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(objectsToCreate.contains("PathologieData")) {
			try {
				pathologyData_ = PathologyDataLocalServiceUtil.addPathologyData(medicalRecord_.getMedicalRecordId(), serviceContext_);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(objectsToCreate.contains("KloetzelBuch")) {
			try {
				kloetzelBuch_ = KloetzelBuchLocalServiceUtil.addKloetzelBuch(medicalRecord_.getMedicalRecordId(), serviceContext_);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateObjectFields(String fieldName, String fieldNameValue, String value) {
		if(fieldNameValue.equals("Value"))
			return;
		ImportImporterTaskMapHelper importImporterTaskMapHelper = taskMaps_.get(fieldName);
		if(importImporterTaskMapHelper != null) {
			if(importImporterTaskMapHelper.getTableName().equals("MedicalRecord")) {
				updateObjectFieldMedicalRecord(importImporterTaskMapHelper.getTableColumn(), value);
			}
			if(importImporterTaskMapHelper.getTableName().equals("PathologieData")) {
				updateObjectFieldPathologieData(importImporterTaskMapHelper.getTableColumn(), value);
			}
			if(importImporterTaskMapHelper.getTableName().equals("KloetzelBuch")) {
				updateObjectFieldKloetzelBuch(importImporterTaskMapHelper.getTableColumn(), value);
			}
		} /*else {
			System.out.println("NULL: fieldName:" + fieldName + " fieldNameValue:" + fieldNameValue + " value:" + value);
		}*/
	}
	
	public void addStaticFields() {
		for(String key : taskMaps_.keySet()) {
			if(key.startsWith("Global")) {
				ImportImporterTaskMapHelper importImporterTaskMapHelper = taskMaps_.get(key);
				if(importImporterTaskMapHelper.getTableName().equals("MedicalRecord")) {
					updateObjectFieldMedicalRecord(importImporterTaskMapHelper.getTableColumn(), importImporterTaskMapHelper.getGlobalValue());
				}
				if(importImporterTaskMapHelper.getTableName().equals("PathologieData")) {
					updateObjectFieldPathologieData(importImporterTaskMapHelper.getTableColumn(), importImporterTaskMapHelper.getGlobalValue());
				}
				if(importImporterTaskMapHelper.getTableName().equals("KloetzelBuch")) {
					updateObjectFieldKloetzelBuch(importImporterTaskMapHelper.getTableColumn(), importImporterTaskMapHelper.getGlobalValue());
				}
			}
		}
	}
	
	public void updateDatabaseObjects() {
		if(medicalRecord_ != null) {
			medicalRecord_ = MedicalRecordLocalServiceUtil.updateMedicalRecord(medicalRecord_);
			medicalRecord_ = null;
		}
		if(pathologyData_ != null) {
			pathologyData_ = PathologyDataLocalServiceUtil.updatePathologyData(pathologyData_);
			pathologyData_ = null;
		}
		if(kloetzelBuch_ != null) {
			kloetzelBuch_ = KloetzelBuchLocalServiceUtil.updateKloetzelBuch(kloetzelBuch_);
			kloetzelBuch_ = null;
		}
	}
	
	private void updateObjectFieldMedicalRecord(String field, String value) {
		if(field.equals("histonumberStart") && value != null && !value.equals("")) {
			medicalRecord_.setHistonumberStart(Long.parseLong(value));
		} else if(field.equals("histonumberEnd") && value != null && !value.equals("")) {
			medicalRecord_.setHistonumberEnd(Long.parseLong(value));
		} else if(field.equals("histonumberRunning") && value != null && !value.equals("")) {
			medicalRecord_.setHistonumberRunning(Integer.parseInt(value));
		} else if(field.equals("iNumber") && value != null && !value.equals("")) {
			medicalRecord_.setINumber(Long.parseLong(value));
		} else if(field.equals("vPatentId") && value != null && !value.equals("")) {
			medicalRecord_.setVPatientId(Long.parseLong(value));
		} else if(field.equals("vHistonNumber") && value != null && !value.equals("")) {
			medicalRecord_.setVHistonNumber(Long.parseLong(value));
		} else if(field.equals("area") && value != null && !value.equals("")) {
			medicalRecord_.setArea(value);
		} else if(field.equals("bbPseudonym") && value != null && !value.equals("")) {
			medicalRecord_.setBbPseudonym(Long.parseLong(value));
		}
	}
	
	private void updateObjectFieldPathologieData(String field, String value) {
		try {
			if(field.equals("receivedDate") && value != null && !value.equals("")) {
					pathologyData_.setReceivedDate(dateFormatter_.parse(value));
			} else if(field.equals("validationDate") && value != null && !value.equals("")) {
				pathologyData_.setValidationDate(dateFormatter_.parse(value));
			} else if(field.equals("patientAge") && value != null && !value.equals("")) {
				pathologyData_.setPatientAge(Integer.parseInt(value));
			} else if(field.equals("sender")) {
				pathologyData_.setSender(value);
			} else if(field.equals("sender")) {
				pathologyData_.setSender(value);
			} else if(field.equals("extractionMethode")) {
				pathologyData_.setExtractionMethode(value);
			} else if(field.equals("reportingPhysician1")) {
				pathologyData_.setReportingPhysician1(value);
			} else if(field.equals("reportingPhysician2")) {
				pathologyData_.setReportingPhysician2(value);
			} else if(field.equals("gynPhysician")) {
				pathologyData_.setGynPhysician(value);
			} else if(field.equals("validationPhysician1")) {
				pathologyData_.setValidationPhysician1(value);
			} else if(field.equals("validationPhysician2")) {
				pathologyData_.setValidationPhysician2(value);
			} else if(field.equals("reportStatus")) {
				pathologyData_.setReportStatus(value);
			} else if(field.equals("numberOfBlockes") && value != null && !value.equals("")) {
				pathologyData_.setNumberOfBlockes(Integer.parseInt(value));
			} else if(field.equals("numberOfSlides") && value != null && !value.equals("")) {
				pathologyData_.setNumberOfSlides(Integer.parseInt(value));
			} else if(field.equals("basicDisease")) {
				pathologyData_.setBasicDisease(value);
			} else if(field.equals("causeOfDeath")) {
				pathologyData_.setCauseOfDeath(value);
			} else if(field.equals("material")) {
				pathologyData_.setMaterial(value);
			} else if(field.equals("materialExtended")) {
				pathologyData_.setMaterialExtended(value);
			} else if(field.equals("macroscopicDescription")) {
				pathologyData_.setMacroscopicDescription(value);
			} else if(field.equals("microscopicDescription")) {
				pathologyData_.setMicroscopicDescription(value);
			} else if(field.equals("histologicDescription")) {
				pathologyData_.setHistologicDescription(value);
			} else if(field.equals("molecularPathologicDescription")) {
				pathologyData_.setMolecularPathologicDescription(value);
			} else if(field.equals("zytologieDescription")) {
				pathologyData_.setZytologieDescription(value);
			} else if(field.equals("pathologicDiagnosis")) {
				pathologyData_.setPathologicDiagnosis(value);
			} else if(field.equals("frozenSectionDiagnosis")) {
				pathologyData_.setFrozenSectionDiagnosis(value);
			} else if(field.equals("molecularPathologicDiagnosis")) {
				pathologyData_.setMolecularPathologicDiagnosis(value);
			} else if(field.equals("zytologieDiagnosis")) {
				pathologyData_.setZytologieDiagnosis(value);
			} else if(field.equals("neuroPathologicDiagnosis")) {
				pathologyData_.setNeuroPathologicDiagnosis(value);
			} else if(field.equals("comment")) {
				pathologyData_.setComment(value);
			} else if(field.equals("zytologiecomment")) {
				pathologyData_.setZytologiecomment(value);
			} else if(field.equals("obduktionsart")) {
				pathologyData_.setObduktionsart(value);
			}  else if(field.equals("grad")) {
				pathologyData_.setGrad(value);
			} else if(field.equals("tnmp")) {
				pathologyData_.setTnmp(value);
			} else if(field.equals("tnmt")) {
				pathologyData_.setTnmt(value);
			} else if(field.equals("tnmn")) {
				pathologyData_.setTnmn(value);
			} else if(field.equals("tnmm")) {
				pathologyData_.setTnmm(value);
			} else if(field.equals("tnmr")) {
				pathologyData_.setTnmr(value);
			} else if(field.equals("tnml")) {
				pathologyData_.setTnml(value);
			} else if(field.equals("tnmv")) {
				pathologyData_.setTnmv(value);
			} else if(field.equals("tnmpn")) {
				pathologyData_.setTnmpn(value);
			} else if(field.equals("dgcode1")) {
				pathologyData_.setDgcode1(value);
			} else if(field.equals("dgcode2")) {
				pathologyData_.setDgcode2(value);
			} else if(field.equals("pap")) {
				pathologyData_.setPap(value);
			} else if(field.equals("smearQuality")) {
				pathologyData_.setSmearQuality(value);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateObjectFieldKloetzelBuch(String field, String value) {
		try {
			if(field.equals("histonumberStart") && value != null && !value.equals("")) {
				kloetzelBuch_.setHistonumberStart(Long.parseLong(value));
			} else if(field.equals("histonumberEnd") && value != null && !value.equals("")) {
				kloetzelBuch_.setHistonumberEnd(Long.parseLong(value));
			} else if(field.equals("histonumberRunning") && value != null && !value.equals("")) {
				kloetzelBuch_.setHistonumberRunning(Integer.parseInt(value));
			} else if(field.equals("histonumber") && value != null && !value.equals("")) {
				kloetzelBuch_.setHistonumber(Long.parseLong(value));
			} else if(field.equals("kloetzelBuchRunning") && value != null && !value.equals("")) {
				kloetzelBuch_.setKloetzelBuchRunning(Integer.parseInt(value));
			} else if(field.equals("oid")) {
				kloetzelBuch_.setOid(value);
			} else if(field.equals("bid")) {
				kloetzelBuch_.setBid(value);
			} else if(field.equals("area")) {
				kloetzelBuch_.setArea(value);
			} else if(field.equals("type")) {
				kloetzelBuch_.setType(value);
			} else if(field.equals("acronym")) {
				kloetzelBuch_.setAcronym(value);
			} else if(field.equals("text")) {
				kloetzelBuch_.setText(value);
			} else if(field.equals("info")) {
				kloetzelBuch_.setInfo(value);
			} else if(field.equals("count") && value != null && !value.equals("")) {
				kloetzelBuch_.setCount(Integer.parseInt(value));
			} else if(field.equals("numberOfPieces") && value != null && !value.equals("")) {
				kloetzelBuch_.setNumberOfPieces(Integer.parseInt(value));
			} else if(field.equals("kbStatus") && value != null && !value.equals("")) {
				kloetzelBuch_.setKbStatus(Integer.parseInt(value));
			} else if(field.equals("sort") && value != null && !value.equals("")) {
				kloetzelBuch_.setSort(Integer.parseInt(value));
			} else if(field.equals("color")) {
				kloetzelBuch_.setColor(value);
			} else if(field.equals("color")) {
				kloetzelBuch_.setColor(value);
			} else if(field.equals("kbDate") && value != null && !value.equals("")) {
				kloetzelBuch_.setKbDate(dateFormatter_.parse(value));
			} else if(field.equals("day")) {
				kloetzelBuch_.setDay(value);
			} else if(field.equals("pocessinguser")) {
				kloetzelBuch_.setPocessinguser(value);
			} else if(field.equals("organizationUnit")) {
				kloetzelBuch_.setOrganizationUnit(value);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*
 * 
 */
