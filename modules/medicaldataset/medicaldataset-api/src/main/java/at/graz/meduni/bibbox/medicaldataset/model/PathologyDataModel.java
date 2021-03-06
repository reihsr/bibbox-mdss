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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PathologyData service. Represents a row in the &quot;medicaldataset_PathologyData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PathologyData
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataImpl
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataModelImpl
 * @generated
 */
@ProviderType
public interface PathologyDataModel extends BaseModel<PathologyData>,
	GroupedModel, ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a pathology data model instance should use the {@link PathologyData} interface instead.
	 */

	/**
	 * Returns the primary key of this pathology data.
	 *
	 * @return the primary key of this pathology data
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this pathology data.
	 *
	 * @param primaryKey the primary key of this pathology data
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this pathology data.
	 *
	 * @return the uuid of this pathology data
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this pathology data.
	 *
	 * @param uuid the uuid of this pathology data
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the pathology data ID of this pathology data.
	 *
	 * @return the pathology data ID of this pathology data
	 */
	public long getPathologyDataId();

	/**
	 * Sets the pathology data ID of this pathology data.
	 *
	 * @param pathologyDataId the pathology data ID of this pathology data
	 */
	public void setPathologyDataId(long pathologyDataId);

	/**
	 * Returns the group ID of this pathology data.
	 *
	 * @return the group ID of this pathology data
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this pathology data.
	 *
	 * @param groupId the group ID of this pathology data
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this pathology data.
	 *
	 * @return the company ID of this pathology data
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this pathology data.
	 *
	 * @param companyId the company ID of this pathology data
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this pathology data.
	 *
	 * @return the user ID of this pathology data
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this pathology data.
	 *
	 * @param userId the user ID of this pathology data
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this pathology data.
	 *
	 * @return the user uuid of this pathology data
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this pathology data.
	 *
	 * @param userUuid the user uuid of this pathology data
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this pathology data.
	 *
	 * @return the user name of this pathology data
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this pathology data.
	 *
	 * @param userName the user name of this pathology data
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this pathology data.
	 *
	 * @return the create date of this pathology data
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this pathology data.
	 *
	 * @param createDate the create date of this pathology data
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this pathology data.
	 *
	 * @return the modified date of this pathology data
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this pathology data.
	 *
	 * @param modifiedDate the modified date of this pathology data
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this pathology data.
	 *
	 * @return the status of this pathology data
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this pathology data.
	 *
	 * @param status the status of this pathology data
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this pathology data.
	 *
	 * @return the status by user ID of this pathology data
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this pathology data.
	 *
	 * @param statusByUserId the status by user ID of this pathology data
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this pathology data.
	 *
	 * @return the status by user uuid of this pathology data
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this pathology data.
	 *
	 * @param statusByUserUuid the status by user uuid of this pathology data
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this pathology data.
	 *
	 * @return the status by user name of this pathology data
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this pathology data.
	 *
	 * @param statusByUserName the status by user name of this pathology data
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this pathology data.
	 *
	 * @return the status date of this pathology data
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this pathology data.
	 *
	 * @param statusDate the status date of this pathology data
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the medical record ID of this pathology data.
	 *
	 * @return the medical record ID of this pathology data
	 */
	public long getMedicalRecordId();

	/**
	 * Sets the medical record ID of this pathology data.
	 *
	 * @param medicalRecordId the medical record ID of this pathology data
	 */
	public void setMedicalRecordId(long medicalRecordId);

	/**
	 * Returns the received date of this pathology data.
	 *
	 * @return the received date of this pathology data
	 */
	public Date getReceivedDate();

	/**
	 * Sets the received date of this pathology data.
	 *
	 * @param receivedDate the received date of this pathology data
	 */
	public void setReceivedDate(Date receivedDate);

	/**
	 * Returns the validation date of this pathology data.
	 *
	 * @return the validation date of this pathology data
	 */
	public Date getValidationDate();

	/**
	 * Sets the validation date of this pathology data.
	 *
	 * @param validationDate the validation date of this pathology data
	 */
	public void setValidationDate(Date validationDate);

	/**
	 * Returns the patient age of this pathology data.
	 *
	 * @return the patient age of this pathology data
	 */
	public int getPatientAge();

	/**
	 * Sets the patient age of this pathology data.
	 *
	 * @param patientAge the patient age of this pathology data
	 */
	public void setPatientAge(int patientAge);

	/**
	 * Returns the sender of this pathology data.
	 *
	 * @return the sender of this pathology data
	 */
	@AutoEscape
	public String getSender();

	/**
	 * Sets the sender of this pathology data.
	 *
	 * @param sender the sender of this pathology data
	 */
	public void setSender(String sender);

	/**
	 * Returns the extraction methode of this pathology data.
	 *
	 * @return the extraction methode of this pathology data
	 */
	@AutoEscape
	public String getExtractionMethode();

	/**
	 * Sets the extraction methode of this pathology data.
	 *
	 * @param extractionMethode the extraction methode of this pathology data
	 */
	public void setExtractionMethode(String extractionMethode);

	/**
	 * Returns the reporting physician1 of this pathology data.
	 *
	 * @return the reporting physician1 of this pathology data
	 */
	@AutoEscape
	public String getReportingPhysician1();

	/**
	 * Sets the reporting physician1 of this pathology data.
	 *
	 * @param reportingPhysician1 the reporting physician1 of this pathology data
	 */
	public void setReportingPhysician1(String reportingPhysician1);

	/**
	 * Returns the reporting physician2 of this pathology data.
	 *
	 * @return the reporting physician2 of this pathology data
	 */
	@AutoEscape
	public String getReportingPhysician2();

	/**
	 * Sets the reporting physician2 of this pathology data.
	 *
	 * @param reportingPhysician2 the reporting physician2 of this pathology data
	 */
	public void setReportingPhysician2(String reportingPhysician2);

	/**
	 * Returns the gyn physician of this pathology data.
	 *
	 * @return the gyn physician of this pathology data
	 */
	@AutoEscape
	public String getGynPhysician();

	/**
	 * Sets the gyn physician of this pathology data.
	 *
	 * @param gynPhysician the gyn physician of this pathology data
	 */
	public void setGynPhysician(String gynPhysician);

	/**
	 * Returns the validation physician1 of this pathology data.
	 *
	 * @return the validation physician1 of this pathology data
	 */
	@AutoEscape
	public String getValidationPhysician1();

	/**
	 * Sets the validation physician1 of this pathology data.
	 *
	 * @param validationPhysician1 the validation physician1 of this pathology data
	 */
	public void setValidationPhysician1(String validationPhysician1);

	/**
	 * Returns the validation physician2 of this pathology data.
	 *
	 * @return the validation physician2 of this pathology data
	 */
	@AutoEscape
	public String getValidationPhysician2();

	/**
	 * Sets the validation physician2 of this pathology data.
	 *
	 * @param validationPhysician2 the validation physician2 of this pathology data
	 */
	public void setValidationPhysician2(String validationPhysician2);

	/**
	 * Returns the report status of this pathology data.
	 *
	 * @return the report status of this pathology data
	 */
	@AutoEscape
	public String getReportStatus();

	/**
	 * Sets the report status of this pathology data.
	 *
	 * @param reportStatus the report status of this pathology data
	 */
	public void setReportStatus(String reportStatus);

	/**
	 * Returns the number of blockes of this pathology data.
	 *
	 * @return the number of blockes of this pathology data
	 */
	public int getNumberOfBlockes();

	/**
	 * Sets the number of blockes of this pathology data.
	 *
	 * @param numberOfBlockes the number of blockes of this pathology data
	 */
	public void setNumberOfBlockes(int numberOfBlockes);

	/**
	 * Returns the number of slides of this pathology data.
	 *
	 * @return the number of slides of this pathology data
	 */
	public int getNumberOfSlides();

	/**
	 * Sets the number of slides of this pathology data.
	 *
	 * @param numberOfSlides the number of slides of this pathology data
	 */
	public void setNumberOfSlides(int numberOfSlides);

	/**
	 * Returns the basic disease of this pathology data.
	 *
	 * @return the basic disease of this pathology data
	 */
	@AutoEscape
	public String getBasicDisease();

	/**
	 * Sets the basic disease of this pathology data.
	 *
	 * @param basicDisease the basic disease of this pathology data
	 */
	public void setBasicDisease(String basicDisease);

	/**
	 * Returns the cause of death of this pathology data.
	 *
	 * @return the cause of death of this pathology data
	 */
	@AutoEscape
	public String getCauseOfDeath();

	/**
	 * Sets the cause of death of this pathology data.
	 *
	 * @param causeOfDeath the cause of death of this pathology data
	 */
	public void setCauseOfDeath(String causeOfDeath);

	/**
	 * Returns the material of this pathology data.
	 *
	 * @return the material of this pathology data
	 */
	@AutoEscape
	public String getMaterial();

	/**
	 * Sets the material of this pathology data.
	 *
	 * @param material the material of this pathology data
	 */
	public void setMaterial(String material);

	/**
	 * Returns the material extended of this pathology data.
	 *
	 * @return the material extended of this pathology data
	 */
	@AutoEscape
	public String getMaterialExtended();

	/**
	 * Sets the material extended of this pathology data.
	 *
	 * @param materialExtended the material extended of this pathology data
	 */
	public void setMaterialExtended(String materialExtended);

	/**
	 * Returns the macroscopic description of this pathology data.
	 *
	 * @return the macroscopic description of this pathology data
	 */
	@AutoEscape
	public String getMacroscopicDescription();

	/**
	 * Sets the macroscopic description of this pathology data.
	 *
	 * @param macroscopicDescription the macroscopic description of this pathology data
	 */
	public void setMacroscopicDescription(String macroscopicDescription);

	/**
	 * Returns the microscopic description of this pathology data.
	 *
	 * @return the microscopic description of this pathology data
	 */
	@AutoEscape
	public String getMicroscopicDescription();

	/**
	 * Sets the microscopic description of this pathology data.
	 *
	 * @param microscopicDescription the microscopic description of this pathology data
	 */
	public void setMicroscopicDescription(String microscopicDescription);

	/**
	 * Returns the histologic description of this pathology data.
	 *
	 * @return the histologic description of this pathology data
	 */
	@AutoEscape
	public String getHistologicDescription();

	/**
	 * Sets the histologic description of this pathology data.
	 *
	 * @param histologicDescription the histologic description of this pathology data
	 */
	public void setHistologicDescription(String histologicDescription);

	/**
	 * Returns the molecular pathologic description of this pathology data.
	 *
	 * @return the molecular pathologic description of this pathology data
	 */
	@AutoEscape
	public String getMolecularPathologicDescription();

	/**
	 * Sets the molecular pathologic description of this pathology data.
	 *
	 * @param molecularPathologicDescription the molecular pathologic description of this pathology data
	 */
	public void setMolecularPathologicDescription(
		String molecularPathologicDescription);

	/**
	 * Returns the zytologie description of this pathology data.
	 *
	 * @return the zytologie description of this pathology data
	 */
	@AutoEscape
	public String getZytologieDescription();

	/**
	 * Sets the zytologie description of this pathology data.
	 *
	 * @param zytologieDescription the zytologie description of this pathology data
	 */
	public void setZytologieDescription(String zytologieDescription);

	/**
	 * Returns the pathologic diagnosis of this pathology data.
	 *
	 * @return the pathologic diagnosis of this pathology data
	 */
	@AutoEscape
	public String getPathologicDiagnosis();

	/**
	 * Sets the pathologic diagnosis of this pathology data.
	 *
	 * @param pathologicDiagnosis the pathologic diagnosis of this pathology data
	 */
	public void setPathologicDiagnosis(String pathologicDiagnosis);

	/**
	 * Returns the frozen section diagnosis of this pathology data.
	 *
	 * @return the frozen section diagnosis of this pathology data
	 */
	@AutoEscape
	public String getFrozenSectionDiagnosis();

	/**
	 * Sets the frozen section diagnosis of this pathology data.
	 *
	 * @param frozenSectionDiagnosis the frozen section diagnosis of this pathology data
	 */
	public void setFrozenSectionDiagnosis(String frozenSectionDiagnosis);

	/**
	 * Returns the molecular pathologic diagnosis of this pathology data.
	 *
	 * @return the molecular pathologic diagnosis of this pathology data
	 */
	@AutoEscape
	public String getMolecularPathologicDiagnosis();

	/**
	 * Sets the molecular pathologic diagnosis of this pathology data.
	 *
	 * @param molecularPathologicDiagnosis the molecular pathologic diagnosis of this pathology data
	 */
	public void setMolecularPathologicDiagnosis(
		String molecularPathologicDiagnosis);

	/**
	 * Returns the zytologie diagnosis of this pathology data.
	 *
	 * @return the zytologie diagnosis of this pathology data
	 */
	@AutoEscape
	public String getZytologieDiagnosis();

	/**
	 * Sets the zytologie diagnosis of this pathology data.
	 *
	 * @param zytologieDiagnosis the zytologie diagnosis of this pathology data
	 */
	public void setZytologieDiagnosis(String zytologieDiagnosis);

	/**
	 * Returns the neuro pathologic diagnosis of this pathology data.
	 *
	 * @return the neuro pathologic diagnosis of this pathology data
	 */
	@AutoEscape
	public String getNeuroPathologicDiagnosis();

	/**
	 * Sets the neuro pathologic diagnosis of this pathology data.
	 *
	 * @param neuroPathologicDiagnosis the neuro pathologic diagnosis of this pathology data
	 */
	public void setNeuroPathologicDiagnosis(String neuroPathologicDiagnosis);

	/**
	 * Returns the comment of this pathology data.
	 *
	 * @return the comment of this pathology data
	 */
	@AutoEscape
	public String getComment();

	/**
	 * Sets the comment of this pathology data.
	 *
	 * @param comment the comment of this pathology data
	 */
	public void setComment(String comment);

	/**
	 * Returns the zytologiecomment of this pathology data.
	 *
	 * @return the zytologiecomment of this pathology data
	 */
	@AutoEscape
	public String getZytologiecomment();

	/**
	 * Sets the zytologiecomment of this pathology data.
	 *
	 * @param zytologiecomment the zytologiecomment of this pathology data
	 */
	public void setZytologiecomment(String zytologiecomment);

	/**
	 * Returns the obduktionsart of this pathology data.
	 *
	 * @return the obduktionsart of this pathology data
	 */
	@AutoEscape
	public String getObduktionsart();

	/**
	 * Sets the obduktionsart of this pathology data.
	 *
	 * @param obduktionsart the obduktionsart of this pathology data
	 */
	public void setObduktionsart(String obduktionsart);

	/**
	 * Returns the grad of this pathology data.
	 *
	 * @return the grad of this pathology data
	 */
	@AutoEscape
	public String getGrad();

	/**
	 * Sets the grad of this pathology data.
	 *
	 * @param grad the grad of this pathology data
	 */
	public void setGrad(String grad);

	/**
	 * Returns the tnmp of this pathology data.
	 *
	 * @return the tnmp of this pathology data
	 */
	@AutoEscape
	public String getTnmp();

	/**
	 * Sets the tnmp of this pathology data.
	 *
	 * @param tnmp the tnmp of this pathology data
	 */
	public void setTnmp(String tnmp);

	/**
	 * Returns the tnmt of this pathology data.
	 *
	 * @return the tnmt of this pathology data
	 */
	@AutoEscape
	public String getTnmt();

	/**
	 * Sets the tnmt of this pathology data.
	 *
	 * @param tnmt the tnmt of this pathology data
	 */
	public void setTnmt(String tnmt);

	/**
	 * Returns the tnmn of this pathology data.
	 *
	 * @return the tnmn of this pathology data
	 */
	@AutoEscape
	public String getTnmn();

	/**
	 * Sets the tnmn of this pathology data.
	 *
	 * @param tnmn the tnmn of this pathology data
	 */
	public void setTnmn(String tnmn);

	/**
	 * Returns the tnmm of this pathology data.
	 *
	 * @return the tnmm of this pathology data
	 */
	@AutoEscape
	public String getTnmm();

	/**
	 * Sets the tnmm of this pathology data.
	 *
	 * @param tnmm the tnmm of this pathology data
	 */
	public void setTnmm(String tnmm);

	/**
	 * Returns the tnmr of this pathology data.
	 *
	 * @return the tnmr of this pathology data
	 */
	@AutoEscape
	public String getTnmr();

	/**
	 * Sets the tnmr of this pathology data.
	 *
	 * @param tnmr the tnmr of this pathology data
	 */
	public void setTnmr(String tnmr);

	/**
	 * Returns the tnml of this pathology data.
	 *
	 * @return the tnml of this pathology data
	 */
	@AutoEscape
	public String getTnml();

	/**
	 * Sets the tnml of this pathology data.
	 *
	 * @param tnml the tnml of this pathology data
	 */
	public void setTnml(String tnml);

	/**
	 * Returns the tnmv of this pathology data.
	 *
	 * @return the tnmv of this pathology data
	 */
	@AutoEscape
	public String getTnmv();

	/**
	 * Sets the tnmv of this pathology data.
	 *
	 * @param tnmv the tnmv of this pathology data
	 */
	public void setTnmv(String tnmv);

	/**
	 * Returns the tnmpn of this pathology data.
	 *
	 * @return the tnmpn of this pathology data
	 */
	@AutoEscape
	public String getTnmpn();

	/**
	 * Sets the tnmpn of this pathology data.
	 *
	 * @param tnmpn the tnmpn of this pathology data
	 */
	public void setTnmpn(String tnmpn);

	/**
	 * Returns the dgcode1 of this pathology data.
	 *
	 * @return the dgcode1 of this pathology data
	 */
	@AutoEscape
	public String getDgcode1();

	/**
	 * Sets the dgcode1 of this pathology data.
	 *
	 * @param dgcode1 the dgcode1 of this pathology data
	 */
	public void setDgcode1(String dgcode1);

	/**
	 * Returns the dgcode2 of this pathology data.
	 *
	 * @return the dgcode2 of this pathology data
	 */
	@AutoEscape
	public String getDgcode2();

	/**
	 * Sets the dgcode2 of this pathology data.
	 *
	 * @param dgcode2 the dgcode2 of this pathology data
	 */
	public void setDgcode2(String dgcode2);

	/**
	 * Returns the pap of this pathology data.
	 *
	 * @return the pap of this pathology data
	 */
	@AutoEscape
	public String getPap();

	/**
	 * Sets the pap of this pathology data.
	 *
	 * @param pap the pap of this pathology data
	 */
	public void setPap(String pap);

	/**
	 * Returns the smear quality of this pathology data.
	 *
	 * @return the smear quality of this pathology data
	 */
	@AutoEscape
	public String getSmearQuality();

	/**
	 * Sets the smear quality of this pathology data.
	 *
	 * @param smearQuality the smear quality of this pathology data
	 */
	public void setSmearQuality(String smearQuality);

	/**
	 * Returns <code>true</code> if this pathology data is approved.
	 *
	 * @return <code>true</code> if this pathology data is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this pathology data is denied.
	 *
	 * @return <code>true</code> if this pathology data is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this pathology data is a draft.
	 *
	 * @return <code>true</code> if this pathology data is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this pathology data is expired.
	 *
	 * @return <code>true</code> if this pathology data is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this pathology data is inactive.
	 *
	 * @return <code>true</code> if this pathology data is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this pathology data is incomplete.
	 *
	 * @return <code>true</code> if this pathology data is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this pathology data is pending.
	 *
	 * @return <code>true</code> if this pathology data is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this pathology data is scheduled.
	 *
	 * @return <code>true</code> if this pathology data is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.medicaldataset.model.PathologyData pathologyData);

	@Override
	public int hashCode();

	@Override
	public CacheModel<at.graz.meduni.bibbox.medicaldataset.model.PathologyData> toCacheModel();

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologyData toEscapedModel();

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologyData toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}