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
 * This class is a wrapper for {@link MedicalRecord}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MedicalRecord
 * @generated
 */
@ProviderType
public class MedicalRecordWrapper implements MedicalRecord,
	ModelWrapper<MedicalRecord> {
	public MedicalRecordWrapper(MedicalRecord medicalRecord) {
		_medicalRecord = medicalRecord;
	}

	@Override
	public Class<?> getModelClass() {
		return MedicalRecord.class;
	}

	@Override
	public String getModelClassName() {
		return MedicalRecord.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("medicalRecordId", getMedicalRecordId());
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
		attributes.put("importMedicalDataSetId", getImportMedicalDataSetId());
		attributes.put("histonumberStart", getHistonumberStart());
		attributes.put("histonumberEnd", getHistonumberEnd());
		attributes.put("histonumberRunning", getHistonumberRunning());
		attributes.put("iNumber", getINumber());
		attributes.put("vPatientId", getVPatientId());
		attributes.put("vHistonNumber", getVHistonNumber());
		attributes.put("bbPseudonym", getBbPseudonym());
		attributes.put("area", getArea());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long medicalRecordId = (Long)attributes.get("medicalRecordId");

		if (medicalRecordId != null) {
			setMedicalRecordId(medicalRecordId);
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

		Long importMedicalDataSetId = (Long)attributes.get(
				"importMedicalDataSetId");

		if (importMedicalDataSetId != null) {
			setImportMedicalDataSetId(importMedicalDataSetId);
		}

		Long histonumberStart = (Long)attributes.get("histonumberStart");

		if (histonumberStart != null) {
			setHistonumberStart(histonumberStart);
		}

		Long histonumberEnd = (Long)attributes.get("histonumberEnd");

		if (histonumberEnd != null) {
			setHistonumberEnd(histonumberEnd);
		}

		Integer histonumberRunning = (Integer)attributes.get(
				"histonumberRunning");

		if (histonumberRunning != null) {
			setHistonumberRunning(histonumberRunning);
		}

		Long iNumber = (Long)attributes.get("iNumber");

		if (iNumber != null) {
			setINumber(iNumber);
		}

		Long vPatientId = (Long)attributes.get("vPatientId");

		if (vPatientId != null) {
			setVPatientId(vPatientId);
		}

		Long vHistonNumber = (Long)attributes.get("vHistonNumber");

		if (vHistonNumber != null) {
			setVHistonNumber(vHistonNumber);
		}

		Long bbPseudonym = (Long)attributes.get("bbPseudonym");

		if (bbPseudonym != null) {
			setBbPseudonym(bbPseudonym);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord toEscapedModel() {
		return new MedicalRecordWrapper(_medicalRecord.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord toUnescapedModel() {
		return new MedicalRecordWrapper(_medicalRecord.toUnescapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologyData getPathologyData() {
		return _medicalRecord.getPathologyData();
	}

	/**
	* Returns <code>true</code> if this medical record is approved.
	*
	* @return <code>true</code> if this medical record is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _medicalRecord.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _medicalRecord.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this medical record is denied.
	*
	* @return <code>true</code> if this medical record is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _medicalRecord.isDenied();
	}

	/**
	* Returns <code>true</code> if this medical record is a draft.
	*
	* @return <code>true</code> if this medical record is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _medicalRecord.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _medicalRecord.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this medical record is expired.
	*
	* @return <code>true</code> if this medical record is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _medicalRecord.isExpired();
	}

	/**
	* Returns <code>true</code> if this medical record is inactive.
	*
	* @return <code>true</code> if this medical record is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _medicalRecord.isInactive();
	}

	/**
	* Returns <code>true</code> if this medical record is incomplete.
	*
	* @return <code>true</code> if this medical record is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _medicalRecord.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _medicalRecord.isNew();
	}

	/**
	* Returns <code>true</code> if this medical record is pending.
	*
	* @return <code>true</code> if this medical record is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _medicalRecord.isPending();
	}

	/**
	* Returns <code>true</code> if this medical record is scheduled.
	*
	* @return <code>true</code> if this medical record is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _medicalRecord.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _medicalRecord.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord> toCacheModel() {
		return _medicalRecord.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord medicalRecord) {
		return _medicalRecord.compareTo(medicalRecord);
	}

	/**
	* Returns the histonumber running of this medical record.
	*
	* @return the histonumber running of this medical record
	*/
	@Override
	public int getHistonumberRunning() {
		return _medicalRecord.getHistonumberRunning();
	}

	/**
	* Returns the status of this medical record.
	*
	* @return the status of this medical record
	*/
	@Override
	public int getStatus() {
		return _medicalRecord.getStatus();
	}

	@Override
	public int hashCode() {
		return _medicalRecord.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _medicalRecord.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new MedicalRecordWrapper((MedicalRecord)_medicalRecord.clone());
	}

	/**
	* Returns the area of this medical record.
	*
	* @return the area of this medical record
	*/
	@Override
	public java.lang.String getArea() {
		return _medicalRecord.getArea();
	}

	/**
	* Returns the status by user name of this medical record.
	*
	* @return the status by user name of this medical record
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _medicalRecord.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this medical record.
	*
	* @return the status by user uuid of this medical record
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _medicalRecord.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this medical record.
	*
	* @return the user name of this medical record
	*/
	@Override
	public java.lang.String getUserName() {
		return _medicalRecord.getUserName();
	}

	/**
	* Returns the user uuid of this medical record.
	*
	* @return the user uuid of this medical record
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _medicalRecord.getUserUuid();
	}

	/**
	* Returns the uuid of this medical record.
	*
	* @return the uuid of this medical record
	*/
	@Override
	public java.lang.String getUuid() {
		return _medicalRecord.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _medicalRecord.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _medicalRecord.toXmlString();
	}

	/**
	* Returns the create date of this medical record.
	*
	* @return the create date of this medical record
	*/
	@Override
	public Date getCreateDate() {
		return _medicalRecord.getCreateDate();
	}

	/**
	* Returns the modified date of this medical record.
	*
	* @return the modified date of this medical record
	*/
	@Override
	public Date getModifiedDate() {
		return _medicalRecord.getModifiedDate();
	}

	/**
	* Returns the status date of this medical record.
	*
	* @return the status date of this medical record
	*/
	@Override
	public Date getStatusDate() {
		return _medicalRecord.getStatusDate();
	}

	/**
	* Returns the bb pseudonym of this medical record.
	*
	* @return the bb pseudonym of this medical record
	*/
	@Override
	public long getBbPseudonym() {
		return _medicalRecord.getBbPseudonym();
	}

	/**
	* Returns the company ID of this medical record.
	*
	* @return the company ID of this medical record
	*/
	@Override
	public long getCompanyId() {
		return _medicalRecord.getCompanyId();
	}

	/**
	* Returns the group ID of this medical record.
	*
	* @return the group ID of this medical record
	*/
	@Override
	public long getGroupId() {
		return _medicalRecord.getGroupId();
	}

	/**
	* Returns the histonumber end of this medical record.
	*
	* @return the histonumber end of this medical record
	*/
	@Override
	public long getHistonumberEnd() {
		return _medicalRecord.getHistonumberEnd();
	}

	/**
	* Returns the histonumber start of this medical record.
	*
	* @return the histonumber start of this medical record
	*/
	@Override
	public long getHistonumberStart() {
		return _medicalRecord.getHistonumberStart();
	}

	/**
	* Returns the i number of this medical record.
	*
	* @return the i number of this medical record
	*/
	@Override
	public long getINumber() {
		return _medicalRecord.getINumber();
	}

	/**
	* Returns the import medical data set ID of this medical record.
	*
	* @return the import medical data set ID of this medical record
	*/
	@Override
	public long getImportMedicalDataSetId() {
		return _medicalRecord.getImportMedicalDataSetId();
	}

	/**
	* Returns the medical record ID of this medical record.
	*
	* @return the medical record ID of this medical record
	*/
	@Override
	public long getMedicalRecordId() {
		return _medicalRecord.getMedicalRecordId();
	}

	/**
	* Returns the primary key of this medical record.
	*
	* @return the primary key of this medical record
	*/
	@Override
	public long getPrimaryKey() {
		return _medicalRecord.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this medical record.
	*
	* @return the status by user ID of this medical record
	*/
	@Override
	public long getStatusByUserId() {
		return _medicalRecord.getStatusByUserId();
	}

	/**
	* Returns the user ID of this medical record.
	*
	* @return the user ID of this medical record
	*/
	@Override
	public long getUserId() {
		return _medicalRecord.getUserId();
	}

	/**
	* Returns the v histon number of this medical record.
	*
	* @return the v histon number of this medical record
	*/
	@Override
	public long getVHistonNumber() {
		return _medicalRecord.getVHistonNumber();
	}

	/**
	* Returns the v patient ID of this medical record.
	*
	* @return the v patient ID of this medical record
	*/
	@Override
	public long getVPatientId() {
		return _medicalRecord.getVPatientId();
	}

	@Override
	public void persist() {
		_medicalRecord.persist();
	}

	/**
	* Sets the area of this medical record.
	*
	* @param area the area of this medical record
	*/
	@Override
	public void setArea(java.lang.String area) {
		_medicalRecord.setArea(area);
	}

	/**
	* Sets the bb pseudonym of this medical record.
	*
	* @param bbPseudonym the bb pseudonym of this medical record
	*/
	@Override
	public void setBbPseudonym(long bbPseudonym) {
		_medicalRecord.setBbPseudonym(bbPseudonym);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_medicalRecord.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this medical record.
	*
	* @param companyId the company ID of this medical record
	*/
	@Override
	public void setCompanyId(long companyId) {
		_medicalRecord.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this medical record.
	*
	* @param createDate the create date of this medical record
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_medicalRecord.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_medicalRecord.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_medicalRecord.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_medicalRecord.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this medical record.
	*
	* @param groupId the group ID of this medical record
	*/
	@Override
	public void setGroupId(long groupId) {
		_medicalRecord.setGroupId(groupId);
	}

	/**
	* Sets the histonumber end of this medical record.
	*
	* @param histonumberEnd the histonumber end of this medical record
	*/
	@Override
	public void setHistonumberEnd(long histonumberEnd) {
		_medicalRecord.setHistonumberEnd(histonumberEnd);
	}

	/**
	* Sets the histonumber running of this medical record.
	*
	* @param histonumberRunning the histonumber running of this medical record
	*/
	@Override
	public void setHistonumberRunning(int histonumberRunning) {
		_medicalRecord.setHistonumberRunning(histonumberRunning);
	}

	/**
	* Sets the histonumber start of this medical record.
	*
	* @param histonumberStart the histonumber start of this medical record
	*/
	@Override
	public void setHistonumberStart(long histonumberStart) {
		_medicalRecord.setHistonumberStart(histonumberStart);
	}

	/**
	* Sets the i number of this medical record.
	*
	* @param iNumber the i number of this medical record
	*/
	@Override
	public void setINumber(long iNumber) {
		_medicalRecord.setINumber(iNumber);
	}

	/**
	* Sets the import medical data set ID of this medical record.
	*
	* @param importMedicalDataSetId the import medical data set ID of this medical record
	*/
	@Override
	public void setImportMedicalDataSetId(long importMedicalDataSetId) {
		_medicalRecord.setImportMedicalDataSetId(importMedicalDataSetId);
	}

	/**
	* Sets the medical record ID of this medical record.
	*
	* @param medicalRecordId the medical record ID of this medical record
	*/
	@Override
	public void setMedicalRecordId(long medicalRecordId) {
		_medicalRecord.setMedicalRecordId(medicalRecordId);
	}

	/**
	* Sets the modified date of this medical record.
	*
	* @param modifiedDate the modified date of this medical record
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_medicalRecord.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_medicalRecord.setNew(n);
	}

	/**
	* Sets the primary key of this medical record.
	*
	* @param primaryKey the primary key of this medical record
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_medicalRecord.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_medicalRecord.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this medical record.
	*
	* @param status the status of this medical record
	*/
	@Override
	public void setStatus(int status) {
		_medicalRecord.setStatus(status);
	}

	/**
	* Sets the status by user ID of this medical record.
	*
	* @param statusByUserId the status by user ID of this medical record
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_medicalRecord.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this medical record.
	*
	* @param statusByUserName the status by user name of this medical record
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_medicalRecord.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this medical record.
	*
	* @param statusByUserUuid the status by user uuid of this medical record
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_medicalRecord.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this medical record.
	*
	* @param statusDate the status date of this medical record
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_medicalRecord.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this medical record.
	*
	* @param userId the user ID of this medical record
	*/
	@Override
	public void setUserId(long userId) {
		_medicalRecord.setUserId(userId);
	}

	/**
	* Sets the user name of this medical record.
	*
	* @param userName the user name of this medical record
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_medicalRecord.setUserName(userName);
	}

	/**
	* Sets the user uuid of this medical record.
	*
	* @param userUuid the user uuid of this medical record
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_medicalRecord.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this medical record.
	*
	* @param uuid the uuid of this medical record
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_medicalRecord.setUuid(uuid);
	}

	/**
	* Sets the v histon number of this medical record.
	*
	* @param vHistonNumber the v histon number of this medical record
	*/
	@Override
	public void setVHistonNumber(long vHistonNumber) {
		_medicalRecord.setVHistonNumber(vHistonNumber);
	}

	/**
	* Sets the v patient ID of this medical record.
	*
	* @param vPatientId the v patient ID of this medical record
	*/
	@Override
	public void setVPatientId(long vPatientId) {
		_medicalRecord.setVPatientId(vPatientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MedicalRecordWrapper)) {
			return false;
		}

		MedicalRecordWrapper medicalRecordWrapper = (MedicalRecordWrapper)obj;

		if (Objects.equals(_medicalRecord, medicalRecordWrapper._medicalRecord)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _medicalRecord.getStagedModelType();
	}

	@Override
	public MedicalRecord getWrappedModel() {
		return _medicalRecord;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _medicalRecord.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _medicalRecord.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_medicalRecord.resetOriginalValues();
	}

	private final MedicalRecord _medicalRecord;
}