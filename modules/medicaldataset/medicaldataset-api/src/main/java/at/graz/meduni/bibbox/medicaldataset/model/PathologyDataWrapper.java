/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package at.graz.meduni.bibbox.medicaldataset.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link PathologyData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PathologyData
 * @generated
 */
@ProviderType
public class PathologyDataWrapper implements PathologyData,
	ModelWrapper<PathologyData> {
	public PathologyDataWrapper(PathologyData pathologyData) {
		_pathologyData = pathologyData;
	}

	@Override
	public Class<?> getModelClass() {
		return PathologyData.class;
	}

	@Override
	public String getModelClassName() {
		return PathologyData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("pathologyDataId", getPathologyDataId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("medicalRecordId", getMedicalRecordId());
		attributes.put("receivedDate", getReceivedDate());
		attributes.put("validationDate", getValidationDate());
		attributes.put("patientAge", getPatientAge());
		attributes.put("sender", getSender());
		attributes.put("extractionMethode", getExtractionMethode());
		attributes.put("reportingPhysician1", getReportingPhysician1());
		attributes.put("reportingPhysician2", getReportingPhysician2());
		attributes.put("gynPhysician", getGynPhysician());
		attributes.put("validationPhysician1", getValidationPhysician1());
		attributes.put("validationPhysician2", getValidationPhysician2());
		attributes.put("reportStatus", getReportStatus());
		attributes.put("numberOfBlockes", getNumberOfBlockes());
		attributes.put("numberOfSlides", getNumberOfSlides());
		attributes.put("basicDisease", getBasicDisease());
		attributes.put("causeOfDeath", getCauseOfDeath());
		attributes.put("material", getMaterial());
		attributes.put("materialExtended", getMaterialExtended());
		attributes.put("macroscopicDescription", getMacroscopicDescription());
		attributes.put("microscopicDescription", getMicroscopicDescription());
		attributes.put("histologicDescription", getHistologicDescription());
		attributes.put("molecularPathologicDescription",
			getMolecularPathologicDescription());
		attributes.put("zytologieDescription", getZytologieDescription());
		attributes.put("pathologicDiagnosis", getPathologicDiagnosis());
		attributes.put("frozenSectionDiagnosis", getFrozenSectionDiagnosis());
		attributes.put("molecularPathologicDiagnosis",
			getMolecularPathologicDiagnosis());
		attributes.put("zytologieDiagnosis", getZytologieDiagnosis());
		attributes.put("neuroPathologicDiagnosis", getNeuroPathologicDiagnosis());
		attributes.put("comment", getComment());
		attributes.put("zytologiecomment", getZytologiecomment());
		attributes.put("grad", getGrad());
		attributes.put("tnmp", getTnmp());
		attributes.put("tnmt", getTnmt());
		attributes.put("tnmn", getTnmn());
		attributes.put("tnmm", getTnmm());
		attributes.put("tnmr", getTnmr());
		attributes.put("tnml", getTnml());
		attributes.put("tnmv", getTnmv());
		attributes.put("tnmpn", getTnmpn());
		attributes.put("dgcode1", getDgcode1());
		attributes.put("dgcode2", getDgcode2());
		attributes.put("pap", getPap());
		attributes.put("smearQuality", getSmearQuality());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long pathologyDataId = (Long)attributes.get("pathologyDataId");

		if (pathologyDataId != null) {
			setPathologyDataId(pathologyDataId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long medicalRecordId = (Long)attributes.get("medicalRecordId");

		if (medicalRecordId != null) {
			setMedicalRecordId(medicalRecordId);
		}

		Date receivedDate = (Date)attributes.get("receivedDate");

		if (receivedDate != null) {
			setReceivedDate(receivedDate);
		}

		Date validationDate = (Date)attributes.get("validationDate");

		if (validationDate != null) {
			setValidationDate(validationDate);
		}

		Integer patientAge = (Integer)attributes.get("patientAge");

		if (patientAge != null) {
			setPatientAge(patientAge);
		}

		String sender = (String)attributes.get("sender");

		if (sender != null) {
			setSender(sender);
		}

		String extractionMethode = (String)attributes.get("extractionMethode");

		if (extractionMethode != null) {
			setExtractionMethode(extractionMethode);
		}

		String reportingPhysician1 = (String)attributes.get(
				"reportingPhysician1");

		if (reportingPhysician1 != null) {
			setReportingPhysician1(reportingPhysician1);
		}

		String reportingPhysician2 = (String)attributes.get(
				"reportingPhysician2");

		if (reportingPhysician2 != null) {
			setReportingPhysician2(reportingPhysician2);
		}

		String gynPhysician = (String)attributes.get("gynPhysician");

		if (gynPhysician != null) {
			setGynPhysician(gynPhysician);
		}

		String validationPhysician1 = (String)attributes.get(
				"validationPhysician1");

		if (validationPhysician1 != null) {
			setValidationPhysician1(validationPhysician1);
		}

		String validationPhysician2 = (String)attributes.get(
				"validationPhysician2");

		if (validationPhysician2 != null) {
			setValidationPhysician2(validationPhysician2);
		}

		String reportStatus = (String)attributes.get("reportStatus");

		if (reportStatus != null) {
			setReportStatus(reportStatus);
		}

		Integer numberOfBlockes = (Integer)attributes.get("numberOfBlockes");

		if (numberOfBlockes != null) {
			setNumberOfBlockes(numberOfBlockes);
		}

		Integer numberOfSlides = (Integer)attributes.get("numberOfSlides");

		if (numberOfSlides != null) {
			setNumberOfSlides(numberOfSlides);
		}

		String basicDisease = (String)attributes.get("basicDisease");

		if (basicDisease != null) {
			setBasicDisease(basicDisease);
		}

		String causeOfDeath = (String)attributes.get("causeOfDeath");

		if (causeOfDeath != null) {
			setCauseOfDeath(causeOfDeath);
		}

		String material = (String)attributes.get("material");

		if (material != null) {
			setMaterial(material);
		}

		String materialExtended = (String)attributes.get("materialExtended");

		if (materialExtended != null) {
			setMaterialExtended(materialExtended);
		}

		String macroscopicDescription = (String)attributes.get(
				"macroscopicDescription");

		if (macroscopicDescription != null) {
			setMacroscopicDescription(macroscopicDescription);
		}

		String microscopicDescription = (String)attributes.get(
				"microscopicDescription");

		if (microscopicDescription != null) {
			setMicroscopicDescription(microscopicDescription);
		}

		String histologicDescription = (String)attributes.get(
				"histologicDescription");

		if (histologicDescription != null) {
			setHistologicDescription(histologicDescription);
		}

		String molecularPathologicDescription = (String)attributes.get(
				"molecularPathologicDescription");

		if (molecularPathologicDescription != null) {
			setMolecularPathologicDescription(molecularPathologicDescription);
		}

		String zytologieDescription = (String)attributes.get(
				"zytologieDescription");

		if (zytologieDescription != null) {
			setZytologieDescription(zytologieDescription);
		}

		String pathologicDiagnosis = (String)attributes.get(
				"pathologicDiagnosis");

		if (pathologicDiagnosis != null) {
			setPathologicDiagnosis(pathologicDiagnosis);
		}

		String frozenSectionDiagnosis = (String)attributes.get(
				"frozenSectionDiagnosis");

		if (frozenSectionDiagnosis != null) {
			setFrozenSectionDiagnosis(frozenSectionDiagnosis);
		}

		String molecularPathologicDiagnosis = (String)attributes.get(
				"molecularPathologicDiagnosis");

		if (molecularPathologicDiagnosis != null) {
			setMolecularPathologicDiagnosis(molecularPathologicDiagnosis);
		}

		String zytologieDiagnosis = (String)attributes.get("zytologieDiagnosis");

		if (zytologieDiagnosis != null) {
			setZytologieDiagnosis(zytologieDiagnosis);
		}

		String neuroPathologicDiagnosis = (String)attributes.get(
				"neuroPathologicDiagnosis");

		if (neuroPathologicDiagnosis != null) {
			setNeuroPathologicDiagnosis(neuroPathologicDiagnosis);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		String zytologiecomment = (String)attributes.get("zytologiecomment");

		if (zytologiecomment != null) {
			setZytologiecomment(zytologiecomment);
		}

		String grad = (String)attributes.get("grad");

		if (grad != null) {
			setGrad(grad);
		}

		String tnmp = (String)attributes.get("tnmp");

		if (tnmp != null) {
			setTnmp(tnmp);
		}

		String tnmt = (String)attributes.get("tnmt");

		if (tnmt != null) {
			setTnmt(tnmt);
		}

		String tnmn = (String)attributes.get("tnmn");

		if (tnmn != null) {
			setTnmn(tnmn);
		}

		String tnmm = (String)attributes.get("tnmm");

		if (tnmm != null) {
			setTnmm(tnmm);
		}

		String tnmr = (String)attributes.get("tnmr");

		if (tnmr != null) {
			setTnmr(tnmr);
		}

		String tnml = (String)attributes.get("tnml");

		if (tnml != null) {
			setTnml(tnml);
		}

		String tnmv = (String)attributes.get("tnmv");

		if (tnmv != null) {
			setTnmv(tnmv);
		}

		String tnmpn = (String)attributes.get("tnmpn");

		if (tnmpn != null) {
			setTnmpn(tnmpn);
		}

		String dgcode1 = (String)attributes.get("dgcode1");

		if (dgcode1 != null) {
			setDgcode1(dgcode1);
		}

		String dgcode2 = (String)attributes.get("dgcode2");

		if (dgcode2 != null) {
			setDgcode2(dgcode2);
		}

		String pap = (String)attributes.get("pap");

		if (pap != null) {
			setPap(pap);
		}

		String smearQuality = (String)attributes.get("smearQuality");

		if (smearQuality != null) {
			setSmearQuality(smearQuality);
		}
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologyData toEscapedModel() {
		return new PathologyDataWrapper(_pathologyData.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologyData toUnescapedModel() {
		return new PathologyDataWrapper(_pathologyData.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this pathology data is approved.
	*
	* @return <code>true</code> if this pathology data is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _pathologyData.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _pathologyData.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this pathology data is denied.
	*
	* @return <code>true</code> if this pathology data is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _pathologyData.isDenied();
	}

	/**
	* Returns <code>true</code> if this pathology data is a draft.
	*
	* @return <code>true</code> if this pathology data is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _pathologyData.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _pathologyData.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this pathology data is expired.
	*
	* @return <code>true</code> if this pathology data is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _pathologyData.isExpired();
	}

	/**
	* Returns <code>true</code> if this pathology data is inactive.
	*
	* @return <code>true</code> if this pathology data is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _pathologyData.isInactive();
	}

	/**
	* Returns <code>true</code> if this pathology data is incomplete.
	*
	* @return <code>true</code> if this pathology data is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _pathologyData.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _pathologyData.isNew();
	}

	/**
	* Returns <code>true</code> if this pathology data is pending.
	*
	* @return <code>true</code> if this pathology data is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _pathologyData.isPending();
	}

	/**
	* Returns <code>true</code> if this pathology data is scheduled.
	*
	* @return <code>true</code> if this pathology data is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _pathologyData.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _pathologyData.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.medicaldataset.model.PathologyData> toCacheModel() {
		return _pathologyData.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.medicaldataset.model.PathologyData pathologyData) {
		return _pathologyData.compareTo(pathologyData);
	}

	/**
	* Returns the number of blockes of this pathology data.
	*
	* @return the number of blockes of this pathology data
	*/
	@Override
	public int getNumberOfBlockes() {
		return _pathologyData.getNumberOfBlockes();
	}

	/**
	* Returns the number of slides of this pathology data.
	*
	* @return the number of slides of this pathology data
	*/
	@Override
	public int getNumberOfSlides() {
		return _pathologyData.getNumberOfSlides();
	}

	/**
	* Returns the patient age of this pathology data.
	*
	* @return the patient age of this pathology data
	*/
	@Override
	public int getPatientAge() {
		return _pathologyData.getPatientAge();
	}

	/**
	* Returns the status of this pathology data.
	*
	* @return the status of this pathology data
	*/
	@Override
	public int getStatus() {
		return _pathologyData.getStatus();
	}

	@Override
	public int hashCode() {
		return _pathologyData.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pathologyData.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PathologyDataWrapper((PathologyData)_pathologyData.clone());
	}

	/**
	* Returns the basic disease of this pathology data.
	*
	* @return the basic disease of this pathology data
	*/
	@Override
	public java.lang.String getBasicDisease() {
		return _pathologyData.getBasicDisease();
	}

	/**
	* Returns the cause of death of this pathology data.
	*
	* @return the cause of death of this pathology data
	*/
	@Override
	public java.lang.String getCauseOfDeath() {
		return _pathologyData.getCauseOfDeath();
	}

	/**
	* Returns the comment of this pathology data.
	*
	* @return the comment of this pathology data
	*/
	@Override
	public java.lang.String getComment() {
		return _pathologyData.getComment();
	}

	/**
	* Returns the dgcode1 of this pathology data.
	*
	* @return the dgcode1 of this pathology data
	*/
	@Override
	public java.lang.String getDgcode1() {
		return _pathologyData.getDgcode1();
	}

	/**
	* Returns the dgcode2 of this pathology data.
	*
	* @return the dgcode2 of this pathology data
	*/
	@Override
	public java.lang.String getDgcode2() {
		return _pathologyData.getDgcode2();
	}

	/**
	* Returns the extraction methode of this pathology data.
	*
	* @return the extraction methode of this pathology data
	*/
	@Override
	public java.lang.String getExtractionMethode() {
		return _pathologyData.getExtractionMethode();
	}

	/**
	* Returns the frozen section diagnosis of this pathology data.
	*
	* @return the frozen section diagnosis of this pathology data
	*/
	@Override
	public java.lang.String getFrozenSectionDiagnosis() {
		return _pathologyData.getFrozenSectionDiagnosis();
	}

	/**
	* Returns the grad of this pathology data.
	*
	* @return the grad of this pathology data
	*/
	@Override
	public java.lang.String getGrad() {
		return _pathologyData.getGrad();
	}

	/**
	* Returns the gyn physician of this pathology data.
	*
	* @return the gyn physician of this pathology data
	*/
	@Override
	public java.lang.String getGynPhysician() {
		return _pathologyData.getGynPhysician();
	}

	/**
	* Returns the histologic description of this pathology data.
	*
	* @return the histologic description of this pathology data
	*/
	@Override
	public java.lang.String getHistologicDescription() {
		return _pathologyData.getHistologicDescription();
	}

	/**
	* Returns the macroscopic description of this pathology data.
	*
	* @return the macroscopic description of this pathology data
	*/
	@Override
	public java.lang.String getMacroscopicDescription() {
		return _pathologyData.getMacroscopicDescription();
	}

	/**
	* Returns the material of this pathology data.
	*
	* @return the material of this pathology data
	*/
	@Override
	public java.lang.String getMaterial() {
		return _pathologyData.getMaterial();
	}

	/**
	* Returns the material extended of this pathology data.
	*
	* @return the material extended of this pathology data
	*/
	@Override
	public java.lang.String getMaterialExtended() {
		return _pathologyData.getMaterialExtended();
	}

	/**
	* Returns the microscopic description of this pathology data.
	*
	* @return the microscopic description of this pathology data
	*/
	@Override
	public java.lang.String getMicroscopicDescription() {
		return _pathologyData.getMicroscopicDescription();
	}

	/**
	* Returns the molecular pathologic description of this pathology data.
	*
	* @return the molecular pathologic description of this pathology data
	*/
	@Override
	public java.lang.String getMolecularPathologicDescription() {
		return _pathologyData.getMolecularPathologicDescription();
	}

	/**
	* Returns the molecular pathologic diagnosis of this pathology data.
	*
	* @return the molecular pathologic diagnosis of this pathology data
	*/
	@Override
	public java.lang.String getMolecularPathologicDiagnosis() {
		return _pathologyData.getMolecularPathologicDiagnosis();
	}

	/**
	* Returns the neuro pathologic diagnosis of this pathology data.
	*
	* @return the neuro pathologic diagnosis of this pathology data
	*/
	@Override
	public java.lang.String getNeuroPathologicDiagnosis() {
		return _pathologyData.getNeuroPathologicDiagnosis();
	}

	/**
	* Returns the pap of this pathology data.
	*
	* @return the pap of this pathology data
	*/
	@Override
	public java.lang.String getPap() {
		return _pathologyData.getPap();
	}

	/**
	* Returns the pathologic diagnosis of this pathology data.
	*
	* @return the pathologic diagnosis of this pathology data
	*/
	@Override
	public java.lang.String getPathologicDiagnosis() {
		return _pathologyData.getPathologicDiagnosis();
	}

	/**
	* Returns the report status of this pathology data.
	*
	* @return the report status of this pathology data
	*/
	@Override
	public java.lang.String getReportStatus() {
		return _pathologyData.getReportStatus();
	}

	/**
	* Returns the reporting physician1 of this pathology data.
	*
	* @return the reporting physician1 of this pathology data
	*/
	@Override
	public java.lang.String getReportingPhysician1() {
		return _pathologyData.getReportingPhysician1();
	}

	/**
	* Returns the reporting physician2 of this pathology data.
	*
	* @return the reporting physician2 of this pathology data
	*/
	@Override
	public java.lang.String getReportingPhysician2() {
		return _pathologyData.getReportingPhysician2();
	}

	/**
	* Returns the sender of this pathology data.
	*
	* @return the sender of this pathology data
	*/
	@Override
	public java.lang.String getSender() {
		return _pathologyData.getSender();
	}

	/**
	* Returns the smear quality of this pathology data.
	*
	* @return the smear quality of this pathology data
	*/
	@Override
	public java.lang.String getSmearQuality() {
		return _pathologyData.getSmearQuality();
	}

	/**
	* Returns the status by user name of this pathology data.
	*
	* @return the status by user name of this pathology data
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _pathologyData.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this pathology data.
	*
	* @return the status by user uuid of this pathology data
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _pathologyData.getStatusByUserUuid();
	}

	/**
	* Returns the tnml of this pathology data.
	*
	* @return the tnml of this pathology data
	*/
	@Override
	public java.lang.String getTnml() {
		return _pathologyData.getTnml();
	}

	/**
	* Returns the tnmm of this pathology data.
	*
	* @return the tnmm of this pathology data
	*/
	@Override
	public java.lang.String getTnmm() {
		return _pathologyData.getTnmm();
	}

	/**
	* Returns the tnmn of this pathology data.
	*
	* @return the tnmn of this pathology data
	*/
	@Override
	public java.lang.String getTnmn() {
		return _pathologyData.getTnmn();
	}

	/**
	* Returns the tnmp of this pathology data.
	*
	* @return the tnmp of this pathology data
	*/
	@Override
	public java.lang.String getTnmp() {
		return _pathologyData.getTnmp();
	}

	/**
	* Returns the tnmpn of this pathology data.
	*
	* @return the tnmpn of this pathology data
	*/
	@Override
	public java.lang.String getTnmpn() {
		return _pathologyData.getTnmpn();
	}

	/**
	* Returns the tnmr of this pathology data.
	*
	* @return the tnmr of this pathology data
	*/
	@Override
	public java.lang.String getTnmr() {
		return _pathologyData.getTnmr();
	}

	/**
	* Returns the tnmt of this pathology data.
	*
	* @return the tnmt of this pathology data
	*/
	@Override
	public java.lang.String getTnmt() {
		return _pathologyData.getTnmt();
	}

	/**
	* Returns the tnmv of this pathology data.
	*
	* @return the tnmv of this pathology data
	*/
	@Override
	public java.lang.String getTnmv() {
		return _pathologyData.getTnmv();
	}

	/**
	* Returns the user name of this pathology data.
	*
	* @return the user name of this pathology data
	*/
	@Override
	public java.lang.String getUserName() {
		return _pathologyData.getUserName();
	}

	/**
	* Returns the user uuid of this pathology data.
	*
	* @return the user uuid of this pathology data
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _pathologyData.getUserUuid();
	}

	/**
	* Returns the uuid of this pathology data.
	*
	* @return the uuid of this pathology data
	*/
	@Override
	public java.lang.String getUuid() {
		return _pathologyData.getUuid();
	}

	/**
	* Returns the validation physician1 of this pathology data.
	*
	* @return the validation physician1 of this pathology data
	*/
	@Override
	public java.lang.String getValidationPhysician1() {
		return _pathologyData.getValidationPhysician1();
	}

	/**
	* Returns the validation physician2 of this pathology data.
	*
	* @return the validation physician2 of this pathology data
	*/
	@Override
	public java.lang.String getValidationPhysician2() {
		return _pathologyData.getValidationPhysician2();
	}

	/**
	* Returns the zytologie description of this pathology data.
	*
	* @return the zytologie description of this pathology data
	*/
	@Override
	public java.lang.String getZytologieDescription() {
		return _pathologyData.getZytologieDescription();
	}

	/**
	* Returns the zytologie diagnosis of this pathology data.
	*
	* @return the zytologie diagnosis of this pathology data
	*/
	@Override
	public java.lang.String getZytologieDiagnosis() {
		return _pathologyData.getZytologieDiagnosis();
	}

	/**
	* Returns the zytologiecomment of this pathology data.
	*
	* @return the zytologiecomment of this pathology data
	*/
	@Override
	public java.lang.String getZytologiecomment() {
		return _pathologyData.getZytologiecomment();
	}

	@Override
	public java.lang.String toString() {
		return _pathologyData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _pathologyData.toXmlString();
	}

	/**
	* Returns the create date of this pathology data.
	*
	* @return the create date of this pathology data
	*/
	@Override
	public Date getCreateDate() {
		return _pathologyData.getCreateDate();
	}

	/**
	* Returns the modified date of this pathology data.
	*
	* @return the modified date of this pathology data
	*/
	@Override
	public Date getModifiedDate() {
		return _pathologyData.getModifiedDate();
	}

	/**
	* Returns the received date of this pathology data.
	*
	* @return the received date of this pathology data
	*/
	@Override
	public Date getReceivedDate() {
		return _pathologyData.getReceivedDate();
	}

	/**
	* Returns the status date of this pathology data.
	*
	* @return the status date of this pathology data
	*/
	@Override
	public Date getStatusDate() {
		return _pathologyData.getStatusDate();
	}

	/**
	* Returns the validation date of this pathology data.
	*
	* @return the validation date of this pathology data
	*/
	@Override
	public Date getValidationDate() {
		return _pathologyData.getValidationDate();
	}

	/**
	* Returns the company ID of this pathology data.
	*
	* @return the company ID of this pathology data
	*/
	@Override
	public long getCompanyId() {
		return _pathologyData.getCompanyId();
	}

	/**
	* Returns the group ID of this pathology data.
	*
	* @return the group ID of this pathology data
	*/
	@Override
	public long getGroupId() {
		return _pathologyData.getGroupId();
	}

	/**
	* Returns the medical record ID of this pathology data.
	*
	* @return the medical record ID of this pathology data
	*/
	@Override
	public long getMedicalRecordId() {
		return _pathologyData.getMedicalRecordId();
	}

	/**
	* Returns the pathology data ID of this pathology data.
	*
	* @return the pathology data ID of this pathology data
	*/
	@Override
	public long getPathologyDataId() {
		return _pathologyData.getPathologyDataId();
	}

	/**
	* Returns the primary key of this pathology data.
	*
	* @return the primary key of this pathology data
	*/
	@Override
	public long getPrimaryKey() {
		return _pathologyData.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this pathology data.
	*
	* @return the status by user ID of this pathology data
	*/
	@Override
	public long getStatusByUserId() {
		return _pathologyData.getStatusByUserId();
	}

	/**
	* Returns the user ID of this pathology data.
	*
	* @return the user ID of this pathology data
	*/
	@Override
	public long getUserId() {
		return _pathologyData.getUserId();
	}

	@Override
	public void persist() {
		_pathologyData.persist();
	}

	/**
	* Sets the basic disease of this pathology data.
	*
	* @param basicDisease the basic disease of this pathology data
	*/
	@Override
	public void setBasicDisease(java.lang.String basicDisease) {
		_pathologyData.setBasicDisease(basicDisease);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pathologyData.setCachedModel(cachedModel);
	}

	/**
	* Sets the cause of death of this pathology data.
	*
	* @param causeOfDeath the cause of death of this pathology data
	*/
	@Override
	public void setCauseOfDeath(java.lang.String causeOfDeath) {
		_pathologyData.setCauseOfDeath(causeOfDeath);
	}

	/**
	* Sets the comment of this pathology data.
	*
	* @param comment the comment of this pathology data
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_pathologyData.setComment(comment);
	}

	/**
	* Sets the company ID of this pathology data.
	*
	* @param companyId the company ID of this pathology data
	*/
	@Override
	public void setCompanyId(long companyId) {
		_pathologyData.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this pathology data.
	*
	* @param createDate the create date of this pathology data
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_pathologyData.setCreateDate(createDate);
	}

	/**
	* Sets the dgcode1 of this pathology data.
	*
	* @param dgcode1 the dgcode1 of this pathology data
	*/
	@Override
	public void setDgcode1(java.lang.String dgcode1) {
		_pathologyData.setDgcode1(dgcode1);
	}

	/**
	* Sets the dgcode2 of this pathology data.
	*
	* @param dgcode2 the dgcode2 of this pathology data
	*/
	@Override
	public void setDgcode2(java.lang.String dgcode2) {
		_pathologyData.setDgcode2(dgcode2);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_pathologyData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_pathologyData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_pathologyData.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the extraction methode of this pathology data.
	*
	* @param extractionMethode the extraction methode of this pathology data
	*/
	@Override
	public void setExtractionMethode(java.lang.String extractionMethode) {
		_pathologyData.setExtractionMethode(extractionMethode);
	}

	/**
	* Sets the frozen section diagnosis of this pathology data.
	*
	* @param frozenSectionDiagnosis the frozen section diagnosis of this pathology data
	*/
	@Override
	public void setFrozenSectionDiagnosis(
		java.lang.String frozenSectionDiagnosis) {
		_pathologyData.setFrozenSectionDiagnosis(frozenSectionDiagnosis);
	}

	/**
	* Sets the grad of this pathology data.
	*
	* @param grad the grad of this pathology data
	*/
	@Override
	public void setGrad(java.lang.String grad) {
		_pathologyData.setGrad(grad);
	}

	/**
	* Sets the group ID of this pathology data.
	*
	* @param groupId the group ID of this pathology data
	*/
	@Override
	public void setGroupId(long groupId) {
		_pathologyData.setGroupId(groupId);
	}

	/**
	* Sets the gyn physician of this pathology data.
	*
	* @param gynPhysician the gyn physician of this pathology data
	*/
	@Override
	public void setGynPhysician(java.lang.String gynPhysician) {
		_pathologyData.setGynPhysician(gynPhysician);
	}

	/**
	* Sets the histologic description of this pathology data.
	*
	* @param histologicDescription the histologic description of this pathology data
	*/
	@Override
	public void setHistologicDescription(java.lang.String histologicDescription) {
		_pathologyData.setHistologicDescription(histologicDescription);
	}

	/**
	* Sets the macroscopic description of this pathology data.
	*
	* @param macroscopicDescription the macroscopic description of this pathology data
	*/
	@Override
	public void setMacroscopicDescription(
		java.lang.String macroscopicDescription) {
		_pathologyData.setMacroscopicDescription(macroscopicDescription);
	}

	/**
	* Sets the material of this pathology data.
	*
	* @param material the material of this pathology data
	*/
	@Override
	public void setMaterial(java.lang.String material) {
		_pathologyData.setMaterial(material);
	}

	/**
	* Sets the material extended of this pathology data.
	*
	* @param materialExtended the material extended of this pathology data
	*/
	@Override
	public void setMaterialExtended(java.lang.String materialExtended) {
		_pathologyData.setMaterialExtended(materialExtended);
	}

	/**
	* Sets the medical record ID of this pathology data.
	*
	* @param medicalRecordId the medical record ID of this pathology data
	*/
	@Override
	public void setMedicalRecordId(long medicalRecordId) {
		_pathologyData.setMedicalRecordId(medicalRecordId);
	}

	/**
	* Sets the microscopic description of this pathology data.
	*
	* @param microscopicDescription the microscopic description of this pathology data
	*/
	@Override
	public void setMicroscopicDescription(
		java.lang.String microscopicDescription) {
		_pathologyData.setMicroscopicDescription(microscopicDescription);
	}

	/**
	* Sets the modified date of this pathology data.
	*
	* @param modifiedDate the modified date of this pathology data
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_pathologyData.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the molecular pathologic description of this pathology data.
	*
	* @param molecularPathologicDescription the molecular pathologic description of this pathology data
	*/
	@Override
	public void setMolecularPathologicDescription(
		java.lang.String molecularPathologicDescription) {
		_pathologyData.setMolecularPathologicDescription(molecularPathologicDescription);
	}

	/**
	* Sets the molecular pathologic diagnosis of this pathology data.
	*
	* @param molecularPathologicDiagnosis the molecular pathologic diagnosis of this pathology data
	*/
	@Override
	public void setMolecularPathologicDiagnosis(
		java.lang.String molecularPathologicDiagnosis) {
		_pathologyData.setMolecularPathologicDiagnosis(molecularPathologicDiagnosis);
	}

	/**
	* Sets the neuro pathologic diagnosis of this pathology data.
	*
	* @param neuroPathologicDiagnosis the neuro pathologic diagnosis of this pathology data
	*/
	@Override
	public void setNeuroPathologicDiagnosis(
		java.lang.String neuroPathologicDiagnosis) {
		_pathologyData.setNeuroPathologicDiagnosis(neuroPathologicDiagnosis);
	}

	@Override
	public void setNew(boolean n) {
		_pathologyData.setNew(n);
	}

	/**
	* Sets the number of blockes of this pathology data.
	*
	* @param numberOfBlockes the number of blockes of this pathology data
	*/
	@Override
	public void setNumberOfBlockes(int numberOfBlockes) {
		_pathologyData.setNumberOfBlockes(numberOfBlockes);
	}

	/**
	* Sets the number of slides of this pathology data.
	*
	* @param numberOfSlides the number of slides of this pathology data
	*/
	@Override
	public void setNumberOfSlides(int numberOfSlides) {
		_pathologyData.setNumberOfSlides(numberOfSlides);
	}

	/**
	* Sets the pap of this pathology data.
	*
	* @param pap the pap of this pathology data
	*/
	@Override
	public void setPap(java.lang.String pap) {
		_pathologyData.setPap(pap);
	}

	/**
	* Sets the pathologic diagnosis of this pathology data.
	*
	* @param pathologicDiagnosis the pathologic diagnosis of this pathology data
	*/
	@Override
	public void setPathologicDiagnosis(java.lang.String pathologicDiagnosis) {
		_pathologyData.setPathologicDiagnosis(pathologicDiagnosis);
	}

	/**
	* Sets the pathology data ID of this pathology data.
	*
	* @param pathologyDataId the pathology data ID of this pathology data
	*/
	@Override
	public void setPathologyDataId(long pathologyDataId) {
		_pathologyData.setPathologyDataId(pathologyDataId);
	}

	/**
	* Sets the patient age of this pathology data.
	*
	* @param patientAge the patient age of this pathology data
	*/
	@Override
	public void setPatientAge(int patientAge) {
		_pathologyData.setPatientAge(patientAge);
	}

	/**
	* Sets the primary key of this pathology data.
	*
	* @param primaryKey the primary key of this pathology data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_pathologyData.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_pathologyData.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the received date of this pathology data.
	*
	* @param receivedDate the received date of this pathology data
	*/
	@Override
	public void setReceivedDate(Date receivedDate) {
		_pathologyData.setReceivedDate(receivedDate);
	}

	/**
	* Sets the report status of this pathology data.
	*
	* @param reportStatus the report status of this pathology data
	*/
	@Override
	public void setReportStatus(java.lang.String reportStatus) {
		_pathologyData.setReportStatus(reportStatus);
	}

	/**
	* Sets the reporting physician1 of this pathology data.
	*
	* @param reportingPhysician1 the reporting physician1 of this pathology data
	*/
	@Override
	public void setReportingPhysician1(java.lang.String reportingPhysician1) {
		_pathologyData.setReportingPhysician1(reportingPhysician1);
	}

	/**
	* Sets the reporting physician2 of this pathology data.
	*
	* @param reportingPhysician2 the reporting physician2 of this pathology data
	*/
	@Override
	public void setReportingPhysician2(java.lang.String reportingPhysician2) {
		_pathologyData.setReportingPhysician2(reportingPhysician2);
	}

	/**
	* Sets the sender of this pathology data.
	*
	* @param sender the sender of this pathology data
	*/
	@Override
	public void setSender(java.lang.String sender) {
		_pathologyData.setSender(sender);
	}

	/**
	* Sets the smear quality of this pathology data.
	*
	* @param smearQuality the smear quality of this pathology data
	*/
	@Override
	public void setSmearQuality(java.lang.String smearQuality) {
		_pathologyData.setSmearQuality(smearQuality);
	}

	/**
	* Sets the status of this pathology data.
	*
	* @param status the status of this pathology data
	*/
	@Override
	public void setStatus(int status) {
		_pathologyData.setStatus(status);
	}

	/**
	* Sets the status by user ID of this pathology data.
	*
	* @param statusByUserId the status by user ID of this pathology data
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_pathologyData.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this pathology data.
	*
	* @param statusByUserName the status by user name of this pathology data
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_pathologyData.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this pathology data.
	*
	* @param statusByUserUuid the status by user uuid of this pathology data
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_pathologyData.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this pathology data.
	*
	* @param statusDate the status date of this pathology data
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_pathologyData.setStatusDate(statusDate);
	}

	/**
	* Sets the tnml of this pathology data.
	*
	* @param tnml the tnml of this pathology data
	*/
	@Override
	public void setTnml(java.lang.String tnml) {
		_pathologyData.setTnml(tnml);
	}

	/**
	* Sets the tnmm of this pathology data.
	*
	* @param tnmm the tnmm of this pathology data
	*/
	@Override
	public void setTnmm(java.lang.String tnmm) {
		_pathologyData.setTnmm(tnmm);
	}

	/**
	* Sets the tnmn of this pathology data.
	*
	* @param tnmn the tnmn of this pathology data
	*/
	@Override
	public void setTnmn(java.lang.String tnmn) {
		_pathologyData.setTnmn(tnmn);
	}

	/**
	* Sets the tnmp of this pathology data.
	*
	* @param tnmp the tnmp of this pathology data
	*/
	@Override
	public void setTnmp(java.lang.String tnmp) {
		_pathologyData.setTnmp(tnmp);
	}

	/**
	* Sets the tnmpn of this pathology data.
	*
	* @param tnmpn the tnmpn of this pathology data
	*/
	@Override
	public void setTnmpn(java.lang.String tnmpn) {
		_pathologyData.setTnmpn(tnmpn);
	}

	/**
	* Sets the tnmr of this pathology data.
	*
	* @param tnmr the tnmr of this pathology data
	*/
	@Override
	public void setTnmr(java.lang.String tnmr) {
		_pathologyData.setTnmr(tnmr);
	}

	/**
	* Sets the tnmt of this pathology data.
	*
	* @param tnmt the tnmt of this pathology data
	*/
	@Override
	public void setTnmt(java.lang.String tnmt) {
		_pathologyData.setTnmt(tnmt);
	}

	/**
	* Sets the tnmv of this pathology data.
	*
	* @param tnmv the tnmv of this pathology data
	*/
	@Override
	public void setTnmv(java.lang.String tnmv) {
		_pathologyData.setTnmv(tnmv);
	}

	/**
	* Sets the user ID of this pathology data.
	*
	* @param userId the user ID of this pathology data
	*/
	@Override
	public void setUserId(long userId) {
		_pathologyData.setUserId(userId);
	}

	/**
	* Sets the user name of this pathology data.
	*
	* @param userName the user name of this pathology data
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_pathologyData.setUserName(userName);
	}

	/**
	* Sets the user uuid of this pathology data.
	*
	* @param userUuid the user uuid of this pathology data
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_pathologyData.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this pathology data.
	*
	* @param uuid the uuid of this pathology data
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_pathologyData.setUuid(uuid);
	}

	/**
	* Sets the validation date of this pathology data.
	*
	* @param validationDate the validation date of this pathology data
	*/
	@Override
	public void setValidationDate(Date validationDate) {
		_pathologyData.setValidationDate(validationDate);
	}

	/**
	* Sets the validation physician1 of this pathology data.
	*
	* @param validationPhysician1 the validation physician1 of this pathology data
	*/
	@Override
	public void setValidationPhysician1(java.lang.String validationPhysician1) {
		_pathologyData.setValidationPhysician1(validationPhysician1);
	}

	/**
	* Sets the validation physician2 of this pathology data.
	*
	* @param validationPhysician2 the validation physician2 of this pathology data
	*/
	@Override
	public void setValidationPhysician2(java.lang.String validationPhysician2) {
		_pathologyData.setValidationPhysician2(validationPhysician2);
	}

	/**
	* Sets the zytologie description of this pathology data.
	*
	* @param zytologieDescription the zytologie description of this pathology data
	*/
	@Override
	public void setZytologieDescription(java.lang.String zytologieDescription) {
		_pathologyData.setZytologieDescription(zytologieDescription);
	}

	/**
	* Sets the zytologie diagnosis of this pathology data.
	*
	* @param zytologieDiagnosis the zytologie diagnosis of this pathology data
	*/
	@Override
	public void setZytologieDiagnosis(java.lang.String zytologieDiagnosis) {
		_pathologyData.setZytologieDiagnosis(zytologieDiagnosis);
	}

	/**
	* Sets the zytologiecomment of this pathology data.
	*
	* @param zytologiecomment the zytologiecomment of this pathology data
	*/
	@Override
	public void setZytologiecomment(java.lang.String zytologiecomment) {
		_pathologyData.setZytologiecomment(zytologiecomment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PathologyDataWrapper)) {
			return false;
		}

		PathologyDataWrapper pathologyDataWrapper = (PathologyDataWrapper)obj;

		if (Objects.equals(_pathologyData, pathologyDataWrapper._pathologyData)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _pathologyData.getStagedModelType();
	}

	@Override
	public PathologyData getWrappedModel() {
		return _pathologyData;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _pathologyData.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _pathologyData.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_pathologyData.resetOriginalValues();
	}

	private final PathologyData _pathologyData;
}