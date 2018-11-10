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
 * This class is a wrapper for {@link ImportMedicalDataSetFieldMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetFieldMap
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetFieldMapWrapper
	implements ImportMedicalDataSetFieldMap,
		ModelWrapper<ImportMedicalDataSetFieldMap> {
	public ImportMedicalDataSetFieldMapWrapper(
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		_importMedicalDataSetFieldMap = importMedicalDataSetFieldMap;
	}

	@Override
	public Class<?> getModelClass() {
		return ImportMedicalDataSetFieldMap.class;
	}

	@Override
	public String getModelClassName() {
		return ImportMedicalDataSetFieldMap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("importMedicalDataSetFieldMapId",
			getImportMedicalDataSetFieldMapId());
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
		attributes.put("importField", getImportField());
		attributes.put("importFieldPath", getImportFieldPath());
		attributes.put("sampleValue", getSampleValue());
		attributes.put("TableName", getTableName());
		attributes.put("TableField", getTableField());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long importMedicalDataSetFieldMapId = (Long)attributes.get(
				"importMedicalDataSetFieldMapId");

		if (importMedicalDataSetFieldMapId != null) {
			setImportMedicalDataSetFieldMapId(importMedicalDataSetFieldMapId);
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

		String importField = (String)attributes.get("importField");

		if (importField != null) {
			setImportField(importField);
		}

		String importFieldPath = (String)attributes.get("importFieldPath");

		if (importFieldPath != null) {
			setImportFieldPath(importFieldPath);
		}

		String sampleValue = (String)attributes.get("sampleValue");

		if (sampleValue != null) {
			setSampleValue(sampleValue);
		}

		String TableName = (String)attributes.get("TableName");

		if (TableName != null) {
			setTableName(TableName);
		}

		String TableField = (String)attributes.get("TableField");

		if (TableField != null) {
			setTableField(TableField);
		}
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap toEscapedModel() {
		return new ImportMedicalDataSetFieldMapWrapper(_importMedicalDataSetFieldMap.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap toUnescapedModel() {
		return new ImportMedicalDataSetFieldMapWrapper(_importMedicalDataSetFieldMap.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this import medical data set field map is approved.
	*
	* @return <code>true</code> if this import medical data set field map is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _importMedicalDataSetFieldMap.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _importMedicalDataSetFieldMap.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this import medical data set field map is denied.
	*
	* @return <code>true</code> if this import medical data set field map is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _importMedicalDataSetFieldMap.isDenied();
	}

	/**
	* Returns <code>true</code> if this import medical data set field map is a draft.
	*
	* @return <code>true</code> if this import medical data set field map is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _importMedicalDataSetFieldMap.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _importMedicalDataSetFieldMap.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this import medical data set field map is expired.
	*
	* @return <code>true</code> if this import medical data set field map is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _importMedicalDataSetFieldMap.isExpired();
	}

	/**
	* Returns <code>true</code> if this import medical data set field map is inactive.
	*
	* @return <code>true</code> if this import medical data set field map is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _importMedicalDataSetFieldMap.isInactive();
	}

	/**
	* Returns <code>true</code> if this import medical data set field map is incomplete.
	*
	* @return <code>true</code> if this import medical data set field map is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _importMedicalDataSetFieldMap.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _importMedicalDataSetFieldMap.isNew();
	}

	@Override
	public boolean isNotSelected() {
		return _importMedicalDataSetFieldMap.isNotSelected();
	}

	/**
	* Returns <code>true</code> if this import medical data set field map is pending.
	*
	* @return <code>true</code> if this import medical data set field map is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _importMedicalDataSetFieldMap.isPending();
	}

	/**
	* Returns <code>true</code> if this import medical data set field map is scheduled.
	*
	* @return <code>true</code> if this import medical data set field map is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _importMedicalDataSetFieldMap.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _importMedicalDataSetFieldMap.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> toCacheModel() {
		return _importMedicalDataSetFieldMap.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		return _importMedicalDataSetFieldMap.compareTo(importMedicalDataSetFieldMap);
	}

	/**
	* Returns the status of this import medical data set field map.
	*
	* @return the status of this import medical data set field map
	*/
	@Override
	public int getStatus() {
		return _importMedicalDataSetFieldMap.getStatus();
	}

	@Override
	public int hashCode() {
		return _importMedicalDataSetFieldMap.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _importMedicalDataSetFieldMap.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ImportMedicalDataSetFieldMapWrapper((ImportMedicalDataSetFieldMap)_importMedicalDataSetFieldMap.clone());
	}

	/**
	* Returns the import field of this import medical data set field map.
	*
	* @return the import field of this import medical data set field map
	*/
	@Override
	public java.lang.String getImportField() {
		return _importMedicalDataSetFieldMap.getImportField();
	}

	/**
	* Returns the import field path of this import medical data set field map.
	*
	* @return the import field path of this import medical data set field map
	*/
	@Override
	public java.lang.String getImportFieldPath() {
		return _importMedicalDataSetFieldMap.getImportFieldPath();
	}

	/**
	* Returns the sample value of this import medical data set field map.
	*
	* @return the sample value of this import medical data set field map
	*/
	@Override
	public java.lang.String getSampleValue() {
		return _importMedicalDataSetFieldMap.getSampleValue();
	}

	/**
	* Returns the status by user name of this import medical data set field map.
	*
	* @return the status by user name of this import medical data set field map
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _importMedicalDataSetFieldMap.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this import medical data set field map.
	*
	* @return the status by user uuid of this import medical data set field map
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _importMedicalDataSetFieldMap.getStatusByUserUuid();
	}

	/**
	* Returns the table field of this import medical data set field map.
	*
	* @return the table field of this import medical data set field map
	*/
	@Override
	public java.lang.String getTableField() {
		return _importMedicalDataSetFieldMap.getTableField();
	}

	/**
	* Returns the table name of this import medical data set field map.
	*
	* @return the table name of this import medical data set field map
	*/
	@Override
	public java.lang.String getTableName() {
		return _importMedicalDataSetFieldMap.getTableName();
	}

	/**
	* Returns the user name of this import medical data set field map.
	*
	* @return the user name of this import medical data set field map
	*/
	@Override
	public java.lang.String getUserName() {
		return _importMedicalDataSetFieldMap.getUserName();
	}

	/**
	* Returns the user uuid of this import medical data set field map.
	*
	* @return the user uuid of this import medical data set field map
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _importMedicalDataSetFieldMap.getUserUuid();
	}

	/**
	* Returns the uuid of this import medical data set field map.
	*
	* @return the uuid of this import medical data set field map
	*/
	@Override
	public java.lang.String getUuid() {
		return _importMedicalDataSetFieldMap.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _importMedicalDataSetFieldMap.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _importMedicalDataSetFieldMap.toXmlString();
	}

	/**
	* Returns the create date of this import medical data set field map.
	*
	* @return the create date of this import medical data set field map
	*/
	@Override
	public Date getCreateDate() {
		return _importMedicalDataSetFieldMap.getCreateDate();
	}

	/**
	* Returns the modified date of this import medical data set field map.
	*
	* @return the modified date of this import medical data set field map
	*/
	@Override
	public Date getModifiedDate() {
		return _importMedicalDataSetFieldMap.getModifiedDate();
	}

	/**
	* Returns the status date of this import medical data set field map.
	*
	* @return the status date of this import medical data set field map
	*/
	@Override
	public Date getStatusDate() {
		return _importMedicalDataSetFieldMap.getStatusDate();
	}

	/**
	* Returns the company ID of this import medical data set field map.
	*
	* @return the company ID of this import medical data set field map
	*/
	@Override
	public long getCompanyId() {
		return _importMedicalDataSetFieldMap.getCompanyId();
	}

	/**
	* Returns the group ID of this import medical data set field map.
	*
	* @return the group ID of this import medical data set field map
	*/
	@Override
	public long getGroupId() {
		return _importMedicalDataSetFieldMap.getGroupId();
	}

	/**
	* Returns the import medical data set field map ID of this import medical data set field map.
	*
	* @return the import medical data set field map ID of this import medical data set field map
	*/
	@Override
	public long getImportMedicalDataSetFieldMapId() {
		return _importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId();
	}

	/**
	* Returns the import medical data set ID of this import medical data set field map.
	*
	* @return the import medical data set ID of this import medical data set field map
	*/
	@Override
	public long getImportMedicalDataSetId() {
		return _importMedicalDataSetFieldMap.getImportMedicalDataSetId();
	}

	/**
	* Returns the primary key of this import medical data set field map.
	*
	* @return the primary key of this import medical data set field map
	*/
	@Override
	public long getPrimaryKey() {
		return _importMedicalDataSetFieldMap.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this import medical data set field map.
	*
	* @return the status by user ID of this import medical data set field map
	*/
	@Override
	public long getStatusByUserId() {
		return _importMedicalDataSetFieldMap.getStatusByUserId();
	}

	/**
	* Returns the user ID of this import medical data set field map.
	*
	* @return the user ID of this import medical data set field map
	*/
	@Override
	public long getUserId() {
		return _importMedicalDataSetFieldMap.getUserId();
	}

	@Override
	public void persist() {
		_importMedicalDataSetFieldMap.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_importMedicalDataSetFieldMap.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this import medical data set field map.
	*
	* @param companyId the company ID of this import medical data set field map
	*/
	@Override
	public void setCompanyId(long companyId) {
		_importMedicalDataSetFieldMap.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this import medical data set field map.
	*
	* @param createDate the create date of this import medical data set field map
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_importMedicalDataSetFieldMap.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_importMedicalDataSetFieldMap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_importMedicalDataSetFieldMap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_importMedicalDataSetFieldMap.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this import medical data set field map.
	*
	* @param groupId the group ID of this import medical data set field map
	*/
	@Override
	public void setGroupId(long groupId) {
		_importMedicalDataSetFieldMap.setGroupId(groupId);
	}

	/**
	* Sets the import field of this import medical data set field map.
	*
	* @param importField the import field of this import medical data set field map
	*/
	@Override
	public void setImportField(java.lang.String importField) {
		_importMedicalDataSetFieldMap.setImportField(importField);
	}

	/**
	* Sets the import field path of this import medical data set field map.
	*
	* @param importFieldPath the import field path of this import medical data set field map
	*/
	@Override
	public void setImportFieldPath(java.lang.String importFieldPath) {
		_importMedicalDataSetFieldMap.setImportFieldPath(importFieldPath);
	}

	/**
	* Sets the import medical data set field map ID of this import medical data set field map.
	*
	* @param importMedicalDataSetFieldMapId the import medical data set field map ID of this import medical data set field map
	*/
	@Override
	public void setImportMedicalDataSetFieldMapId(
		long importMedicalDataSetFieldMapId) {
		_importMedicalDataSetFieldMap.setImportMedicalDataSetFieldMapId(importMedicalDataSetFieldMapId);
	}

	/**
	* Sets the import medical data set ID of this import medical data set field map.
	*
	* @param importMedicalDataSetId the import medical data set ID of this import medical data set field map
	*/
	@Override
	public void setImportMedicalDataSetId(long importMedicalDataSetId) {
		_importMedicalDataSetFieldMap.setImportMedicalDataSetId(importMedicalDataSetId);
	}

	/**
	* Sets the modified date of this import medical data set field map.
	*
	* @param modifiedDate the modified date of this import medical data set field map
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_importMedicalDataSetFieldMap.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_importMedicalDataSetFieldMap.setNew(n);
	}

	/**
	* Sets the primary key of this import medical data set field map.
	*
	* @param primaryKey the primary key of this import medical data set field map
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_importMedicalDataSetFieldMap.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_importMedicalDataSetFieldMap.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sample value of this import medical data set field map.
	*
	* @param sampleValue the sample value of this import medical data set field map
	*/
	@Override
	public void setSampleValue(java.lang.String sampleValue) {
		_importMedicalDataSetFieldMap.setSampleValue(sampleValue);
	}

	/**
	* Sets the status of this import medical data set field map.
	*
	* @param status the status of this import medical data set field map
	*/
	@Override
	public void setStatus(int status) {
		_importMedicalDataSetFieldMap.setStatus(status);
	}

	/**
	* Sets the status by user ID of this import medical data set field map.
	*
	* @param statusByUserId the status by user ID of this import medical data set field map
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_importMedicalDataSetFieldMap.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this import medical data set field map.
	*
	* @param statusByUserName the status by user name of this import medical data set field map
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_importMedicalDataSetFieldMap.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this import medical data set field map.
	*
	* @param statusByUserUuid the status by user uuid of this import medical data set field map
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_importMedicalDataSetFieldMap.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this import medical data set field map.
	*
	* @param statusDate the status date of this import medical data set field map
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_importMedicalDataSetFieldMap.setStatusDate(statusDate);
	}

	/**
	* Sets the table field of this import medical data set field map.
	*
	* @param TableField the table field of this import medical data set field map
	*/
	@Override
	public void setTableField(java.lang.String TableField) {
		_importMedicalDataSetFieldMap.setTableField(TableField);
	}

	/**
	* Sets the table name of this import medical data set field map.
	*
	* @param TableName the table name of this import medical data set field map
	*/
	@Override
	public void setTableName(java.lang.String TableName) {
		_importMedicalDataSetFieldMap.setTableName(TableName);
	}

	/**
	* Sets the user ID of this import medical data set field map.
	*
	* @param userId the user ID of this import medical data set field map
	*/
	@Override
	public void setUserId(long userId) {
		_importMedicalDataSetFieldMap.setUserId(userId);
	}

	/**
	* Sets the user name of this import medical data set field map.
	*
	* @param userName the user name of this import medical data set field map
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_importMedicalDataSetFieldMap.setUserName(userName);
	}

	/**
	* Sets the user uuid of this import medical data set field map.
	*
	* @param userUuid the user uuid of this import medical data set field map
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_importMedicalDataSetFieldMap.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this import medical data set field map.
	*
	* @param uuid the uuid of this import medical data set field map
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_importMedicalDataSetFieldMap.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImportMedicalDataSetFieldMapWrapper)) {
			return false;
		}

		ImportMedicalDataSetFieldMapWrapper importMedicalDataSetFieldMapWrapper = (ImportMedicalDataSetFieldMapWrapper)obj;

		if (Objects.equals(_importMedicalDataSetFieldMap,
					importMedicalDataSetFieldMapWrapper._importMedicalDataSetFieldMap)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _importMedicalDataSetFieldMap.getStagedModelType();
	}

	@Override
	public ImportMedicalDataSetFieldMap getWrappedModel() {
		return _importMedicalDataSetFieldMap;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _importMedicalDataSetFieldMap.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _importMedicalDataSetFieldMap.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_importMedicalDataSetFieldMap.resetOriginalValues();
	}

	private final ImportMedicalDataSetFieldMap _importMedicalDataSetFieldMap;
}