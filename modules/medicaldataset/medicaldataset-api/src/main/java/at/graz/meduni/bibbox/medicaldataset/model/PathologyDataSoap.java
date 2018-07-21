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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.medicaldataset.service.http.PathologyDataServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.http.PathologyDataServiceSoap
 * @generated
 */
@ProviderType
public class PathologyDataSoap implements Serializable {
	public static PathologyDataSoap toSoapModel(PathologyData model) {
		PathologyDataSoap soapModel = new PathologyDataSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPathologyDataId(model.getPathologyDataId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setMedicalRecordId(model.getMedicalRecordId());
		soapModel.setReceivedDate(model.getReceivedDate());
		soapModel.setValidationDate(model.getValidationDate());
		soapModel.setPatientAge(model.getPatientAge());
		soapModel.setSender(model.getSender());
		soapModel.setExtractionMethode(model.getExtractionMethode());
		soapModel.setReportingPhysician1(model.getReportingPhysician1());
		soapModel.setReportingPhysician2(model.getReportingPhysician2());
		soapModel.setGynPhysician(model.getGynPhysician());
		soapModel.setValidationPhysician1(model.getValidationPhysician1());
		soapModel.setValidationPhysician2(model.getValidationPhysician2());
		soapModel.setReportStatus(model.getReportStatus());
		soapModel.setNumberOfBlockes(model.getNumberOfBlockes());
		soapModel.setNumberOfSlides(model.getNumberOfSlides());
		soapModel.setBasicDisease(model.getBasicDisease());
		soapModel.setCauseOfDeath(model.getCauseOfDeath());
		soapModel.setMaterial(model.getMaterial());
		soapModel.setMaterialExtended(model.getMaterialExtended());
		soapModel.setMacroscopicDescription(model.getMacroscopicDescription());
		soapModel.setMicroscopicDescription(model.getMicroscopicDescription());
		soapModel.setHistologicDescription(model.getHistologicDescription());
		soapModel.setMolecularPathologicDescription(model.getMolecularPathologicDescription());
		soapModel.setZytologieDescription(model.getZytologieDescription());
		soapModel.setPathologicDiagnosis(model.getPathologicDiagnosis());
		soapModel.setFrozenSectionDiagnosis(model.getFrozenSectionDiagnosis());
		soapModel.setMolecularPathologicDiagnosis(model.getMolecularPathologicDiagnosis());
		soapModel.setZytologieDiagnosis(model.getZytologieDiagnosis());
		soapModel.setNeuroPathologicDiagnosis(model.getNeuroPathologicDiagnosis());
		soapModel.setComment(model.getComment());
		soapModel.setZytologiecomment(model.getZytologiecomment());
		soapModel.setGrad(model.getGrad());
		soapModel.setTnmp(model.getTnmp());
		soapModel.setTnmt(model.getTnmt());
		soapModel.setTnmn(model.getTnmn());
		soapModel.setTnmm(model.getTnmm());
		soapModel.setTnmr(model.getTnmr());
		soapModel.setTnml(model.getTnml());
		soapModel.setTnmv(model.getTnmv());
		soapModel.setTnmpn(model.getTnmpn());
		soapModel.setDgcode1(model.getDgcode1());
		soapModel.setDgcode2(model.getDgcode2());
		soapModel.setPap(model.getPap());
		soapModel.setSmearQuality(model.getSmearQuality());

		return soapModel;
	}

	public static PathologyDataSoap[] toSoapModels(PathologyData[] models) {
		PathologyDataSoap[] soapModels = new PathologyDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PathologyDataSoap[][] toSoapModels(PathologyData[][] models) {
		PathologyDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PathologyDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PathologyDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PathologyDataSoap[] toSoapModels(List<PathologyData> models) {
		List<PathologyDataSoap> soapModels = new ArrayList<PathologyDataSoap>(models.size());

		for (PathologyData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PathologyDataSoap[soapModels.size()]);
	}

	public PathologyDataSoap() {
	}

	public long getPrimaryKey() {
		return _pathologyDataId;
	}

	public void setPrimaryKey(long pk) {
		setPathologyDataId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPathologyDataId() {
		return _pathologyDataId;
	}

	public void setPathologyDataId(long pathologyDataId) {
		_pathologyDataId = pathologyDataId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getMedicalRecordId() {
		return _medicalRecordId;
	}

	public void setMedicalRecordId(long medicalRecordId) {
		_medicalRecordId = medicalRecordId;
	}

	public Date getReceivedDate() {
		return _receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		_receivedDate = receivedDate;
	}

	public Date getValidationDate() {
		return _validationDate;
	}

	public void setValidationDate(Date validationDate) {
		_validationDate = validationDate;
	}

	public int getPatientAge() {
		return _patientAge;
	}

	public void setPatientAge(int patientAge) {
		_patientAge = patientAge;
	}

	public String getSender() {
		return _sender;
	}

	public void setSender(String sender) {
		_sender = sender;
	}

	public String getExtractionMethode() {
		return _extractionMethode;
	}

	public void setExtractionMethode(String extractionMethode) {
		_extractionMethode = extractionMethode;
	}

	public String getReportingPhysician1() {
		return _reportingPhysician1;
	}

	public void setReportingPhysician1(String reportingPhysician1) {
		_reportingPhysician1 = reportingPhysician1;
	}

	public String getReportingPhysician2() {
		return _reportingPhysician2;
	}

	public void setReportingPhysician2(String reportingPhysician2) {
		_reportingPhysician2 = reportingPhysician2;
	}

	public String getGynPhysician() {
		return _gynPhysician;
	}

	public void setGynPhysician(String gynPhysician) {
		_gynPhysician = gynPhysician;
	}

	public String getValidationPhysician1() {
		return _validationPhysician1;
	}

	public void setValidationPhysician1(String validationPhysician1) {
		_validationPhysician1 = validationPhysician1;
	}

	public String getValidationPhysician2() {
		return _validationPhysician2;
	}

	public void setValidationPhysician2(String validationPhysician2) {
		_validationPhysician2 = validationPhysician2;
	}

	public String getReportStatus() {
		return _reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		_reportStatus = reportStatus;
	}

	public int getNumberOfBlockes() {
		return _numberOfBlockes;
	}

	public void setNumberOfBlockes(int numberOfBlockes) {
		_numberOfBlockes = numberOfBlockes;
	}

	public int getNumberOfSlides() {
		return _numberOfSlides;
	}

	public void setNumberOfSlides(int numberOfSlides) {
		_numberOfSlides = numberOfSlides;
	}

	public String getBasicDisease() {
		return _basicDisease;
	}

	public void setBasicDisease(String basicDisease) {
		_basicDisease = basicDisease;
	}

	public String getCauseOfDeath() {
		return _causeOfDeath;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		_causeOfDeath = causeOfDeath;
	}

	public String getMaterial() {
		return _material;
	}

	public void setMaterial(String material) {
		_material = material;
	}

	public String getMaterialExtended() {
		return _materialExtended;
	}

	public void setMaterialExtended(String materialExtended) {
		_materialExtended = materialExtended;
	}

	public String getMacroscopicDescription() {
		return _macroscopicDescription;
	}

	public void setMacroscopicDescription(String macroscopicDescription) {
		_macroscopicDescription = macroscopicDescription;
	}

	public String getMicroscopicDescription() {
		return _microscopicDescription;
	}

	public void setMicroscopicDescription(String microscopicDescription) {
		_microscopicDescription = microscopicDescription;
	}

	public String getHistologicDescription() {
		return _histologicDescription;
	}

	public void setHistologicDescription(String histologicDescription) {
		_histologicDescription = histologicDescription;
	}

	public String getMolecularPathologicDescription() {
		return _molecularPathologicDescription;
	}

	public void setMolecularPathologicDescription(
		String molecularPathologicDescription) {
		_molecularPathologicDescription = molecularPathologicDescription;
	}

	public String getZytologieDescription() {
		return _zytologieDescription;
	}

	public void setZytologieDescription(String zytologieDescription) {
		_zytologieDescription = zytologieDescription;
	}

	public String getPathologicDiagnosis() {
		return _pathologicDiagnosis;
	}

	public void setPathologicDiagnosis(String pathologicDiagnosis) {
		_pathologicDiagnosis = pathologicDiagnosis;
	}

	public String getFrozenSectionDiagnosis() {
		return _frozenSectionDiagnosis;
	}

	public void setFrozenSectionDiagnosis(String frozenSectionDiagnosis) {
		_frozenSectionDiagnosis = frozenSectionDiagnosis;
	}

	public String getMolecularPathologicDiagnosis() {
		return _molecularPathologicDiagnosis;
	}

	public void setMolecularPathologicDiagnosis(
		String molecularPathologicDiagnosis) {
		_molecularPathologicDiagnosis = molecularPathologicDiagnosis;
	}

	public String getZytologieDiagnosis() {
		return _zytologieDiagnosis;
	}

	public void setZytologieDiagnosis(String zytologieDiagnosis) {
		_zytologieDiagnosis = zytologieDiagnosis;
	}

	public String getNeuroPathologicDiagnosis() {
		return _neuroPathologicDiagnosis;
	}

	public void setNeuroPathologicDiagnosis(String neuroPathologicDiagnosis) {
		_neuroPathologicDiagnosis = neuroPathologicDiagnosis;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public String getZytologiecomment() {
		return _zytologiecomment;
	}

	public void setZytologiecomment(String zytologiecomment) {
		_zytologiecomment = zytologiecomment;
	}

	public String getGrad() {
		return _grad;
	}

	public void setGrad(String grad) {
		_grad = grad;
	}

	public String getTnmp() {
		return _tnmp;
	}

	public void setTnmp(String tnmp) {
		_tnmp = tnmp;
	}

	public String getTnmt() {
		return _tnmt;
	}

	public void setTnmt(String tnmt) {
		_tnmt = tnmt;
	}

	public String getTnmn() {
		return _tnmn;
	}

	public void setTnmn(String tnmn) {
		_tnmn = tnmn;
	}

	public String getTnmm() {
		return _tnmm;
	}

	public void setTnmm(String tnmm) {
		_tnmm = tnmm;
	}

	public String getTnmr() {
		return _tnmr;
	}

	public void setTnmr(String tnmr) {
		_tnmr = tnmr;
	}

	public String getTnml() {
		return _tnml;
	}

	public void setTnml(String tnml) {
		_tnml = tnml;
	}

	public String getTnmv() {
		return _tnmv;
	}

	public void setTnmv(String tnmv) {
		_tnmv = tnmv;
	}

	public String getTnmpn() {
		return _tnmpn;
	}

	public void setTnmpn(String tnmpn) {
		_tnmpn = tnmpn;
	}

	public String getDgcode1() {
		return _dgcode1;
	}

	public void setDgcode1(String dgcode1) {
		_dgcode1 = dgcode1;
	}

	public String getDgcode2() {
		return _dgcode2;
	}

	public void setDgcode2(String dgcode2) {
		_dgcode2 = dgcode2;
	}

	public String getPap() {
		return _pap;
	}

	public void setPap(String pap) {
		_pap = pap;
	}

	public String getSmearQuality() {
		return _smearQuality;
	}

	public void setSmearQuality(String smearQuality) {
		_smearQuality = smearQuality;
	}

	private String _uuid;
	private long _pathologyDataId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _medicalRecordId;
	private Date _receivedDate;
	private Date _validationDate;
	private int _patientAge;
	private String _sender;
	private String _extractionMethode;
	private String _reportingPhysician1;
	private String _reportingPhysician2;
	private String _gynPhysician;
	private String _validationPhysician1;
	private String _validationPhysician2;
	private String _reportStatus;
	private int _numberOfBlockes;
	private int _numberOfSlides;
	private String _basicDisease;
	private String _causeOfDeath;
	private String _material;
	private String _materialExtended;
	private String _macroscopicDescription;
	private String _microscopicDescription;
	private String _histologicDescription;
	private String _molecularPathologicDescription;
	private String _zytologieDescription;
	private String _pathologicDiagnosis;
	private String _frozenSectionDiagnosis;
	private String _molecularPathologicDiagnosis;
	private String _zytologieDiagnosis;
	private String _neuroPathologicDiagnosis;
	private String _comment;
	private String _zytologiecomment;
	private String _grad;
	private String _tnmp;
	private String _tnmt;
	private String _tnmn;
	private String _tnmm;
	private String _tnmr;
	private String _tnml;
	private String _tnmv;
	private String _tnmpn;
	private String _dgcode1;
	private String _dgcode2;
	private String _pap;
	private String _smearQuality;
}