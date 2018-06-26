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
 * This class is a wrapper for {@link ImportMedicalDataSetLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLog
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetLogWrapper implements ImportMedicalDataSetLog,
	ModelWrapper<ImportMedicalDataSetLog> {
	public ImportMedicalDataSetLogWrapper(
		ImportMedicalDataSetLog importMedicalDataSetLog) {
		_importMedicalDataSetLog = importMedicalDataSetLog;
	}

	@Override
	public Class<?> getModelClass() {
		return ImportMedicalDataSetLog.class;
	}

	@Override
	public String getModelClassName() {
		return ImportMedicalDataSetLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("importMedicalDataSetLogId",
			getImportMedicalDataSetLogId());
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
		attributes.put("importStatus", getImportStatus());
		attributes.put("importStatusLog", getImportStatusLog());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long importMedicalDataSetLogId = (Long)attributes.get(
				"importMedicalDataSetLogId");

		if (importMedicalDataSetLogId != null) {
			setImportMedicalDataSetLogId(importMedicalDataSetLogId);
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

		Integer importStatus = (Integer)attributes.get("importStatus");

		if (importStatus != null) {
			setImportStatus(importStatus);
		}

		String importStatusLog = (String)attributes.get("importStatusLog");

		if (importStatusLog != null) {
			setImportStatusLog(importStatusLog);
		}
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog toEscapedModel() {
		return new ImportMedicalDataSetLogWrapper(_importMedicalDataSetLog.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog toUnescapedModel() {
		return new ImportMedicalDataSetLogWrapper(_importMedicalDataSetLog.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this import medical data set log is approved.
	*
	* @return <code>true</code> if this import medical data set log is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _importMedicalDataSetLog.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _importMedicalDataSetLog.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this import medical data set log is denied.
	*
	* @return <code>true</code> if this import medical data set log is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _importMedicalDataSetLog.isDenied();
	}

	/**
	* Returns <code>true</code> if this import medical data set log is a draft.
	*
	* @return <code>true</code> if this import medical data set log is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _importMedicalDataSetLog.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _importMedicalDataSetLog.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this import medical data set log is expired.
	*
	* @return <code>true</code> if this import medical data set log is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _importMedicalDataSetLog.isExpired();
	}

	/**
	* Returns <code>true</code> if this import medical data set log is inactive.
	*
	* @return <code>true</code> if this import medical data set log is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _importMedicalDataSetLog.isInactive();
	}

	/**
	* Returns <code>true</code> if this import medical data set log is incomplete.
	*
	* @return <code>true</code> if this import medical data set log is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _importMedicalDataSetLog.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _importMedicalDataSetLog.isNew();
	}

	/**
	* Returns <code>true</code> if this import medical data set log is pending.
	*
	* @return <code>true</code> if this import medical data set log is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _importMedicalDataSetLog.isPending();
	}

	/**
	* Returns <code>true</code> if this import medical data set log is scheduled.
	*
	* @return <code>true</code> if this import medical data set log is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _importMedicalDataSetLog.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _importMedicalDataSetLog.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> toCacheModel() {
		return _importMedicalDataSetLog.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog importMedicalDataSetLog) {
		return _importMedicalDataSetLog.compareTo(importMedicalDataSetLog);
	}

	/**
	* Returns the import status of this import medical data set log.
	*
	* @return the import status of this import medical data set log
	*/
	@Override
	public int getImportStatus() {
		return _importMedicalDataSetLog.getImportStatus();
	}

	/**
	* Returns the status of this import medical data set log.
	*
	* @return the status of this import medical data set log
	*/
	@Override
	public int getStatus() {
		return _importMedicalDataSetLog.getStatus();
	}

	@Override
	public int hashCode() {
		return _importMedicalDataSetLog.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _importMedicalDataSetLog.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ImportMedicalDataSetLogWrapper((ImportMedicalDataSetLog)_importMedicalDataSetLog.clone());
	}

	/**
	* Returns the import status log of this import medical data set log.
	*
	* @return the import status log of this import medical data set log
	*/
	@Override
	public java.lang.String getImportStatusLog() {
		return _importMedicalDataSetLog.getImportStatusLog();
	}

	/**
	* Returns the status by user name of this import medical data set log.
	*
	* @return the status by user name of this import medical data set log
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _importMedicalDataSetLog.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this import medical data set log.
	*
	* @return the status by user uuid of this import medical data set log
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _importMedicalDataSetLog.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this import medical data set log.
	*
	* @return the user name of this import medical data set log
	*/
	@Override
	public java.lang.String getUserName() {
		return _importMedicalDataSetLog.getUserName();
	}

	/**
	* Returns the user uuid of this import medical data set log.
	*
	* @return the user uuid of this import medical data set log
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _importMedicalDataSetLog.getUserUuid();
	}

	/**
	* Returns the uuid of this import medical data set log.
	*
	* @return the uuid of this import medical data set log
	*/
	@Override
	public java.lang.String getUuid() {
		return _importMedicalDataSetLog.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _importMedicalDataSetLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _importMedicalDataSetLog.toXmlString();
	}

	/**
	* Returns the create date of this import medical data set log.
	*
	* @return the create date of this import medical data set log
	*/
	@Override
	public Date getCreateDate() {
		return _importMedicalDataSetLog.getCreateDate();
	}

	/**
	* Returns the modified date of this import medical data set log.
	*
	* @return the modified date of this import medical data set log
	*/
	@Override
	public Date getModifiedDate() {
		return _importMedicalDataSetLog.getModifiedDate();
	}

	/**
	* Returns the status date of this import medical data set log.
	*
	* @return the status date of this import medical data set log
	*/
	@Override
	public Date getStatusDate() {
		return _importMedicalDataSetLog.getStatusDate();
	}

	/**
	* Returns the company ID of this import medical data set log.
	*
	* @return the company ID of this import medical data set log
	*/
	@Override
	public long getCompanyId() {
		return _importMedicalDataSetLog.getCompanyId();
	}

	/**
	* Returns the group ID of this import medical data set log.
	*
	* @return the group ID of this import medical data set log
	*/
	@Override
	public long getGroupId() {
		return _importMedicalDataSetLog.getGroupId();
	}

	/**
	* Returns the import medical data set ID of this import medical data set log.
	*
	* @return the import medical data set ID of this import medical data set log
	*/
	@Override
	public long getImportMedicalDataSetId() {
		return _importMedicalDataSetLog.getImportMedicalDataSetId();
	}

	/**
	* Returns the import medical data set log ID of this import medical data set log.
	*
	* @return the import medical data set log ID of this import medical data set log
	*/
	@Override
	public long getImportMedicalDataSetLogId() {
		return _importMedicalDataSetLog.getImportMedicalDataSetLogId();
	}

	/**
	* Returns the primary key of this import medical data set log.
	*
	* @return the primary key of this import medical data set log
	*/
	@Override
	public long getPrimaryKey() {
		return _importMedicalDataSetLog.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this import medical data set log.
	*
	* @return the status by user ID of this import medical data set log
	*/
	@Override
	public long getStatusByUserId() {
		return _importMedicalDataSetLog.getStatusByUserId();
	}

	/**
	* Returns the user ID of this import medical data set log.
	*
	* @return the user ID of this import medical data set log
	*/
	@Override
	public long getUserId() {
		return _importMedicalDataSetLog.getUserId();
	}

	@Override
	public void persist() {
		_importMedicalDataSetLog.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_importMedicalDataSetLog.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this import medical data set log.
	*
	* @param companyId the company ID of this import medical data set log
	*/
	@Override
	public void setCompanyId(long companyId) {
		_importMedicalDataSetLog.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this import medical data set log.
	*
	* @param createDate the create date of this import medical data set log
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_importMedicalDataSetLog.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_importMedicalDataSetLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_importMedicalDataSetLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_importMedicalDataSetLog.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this import medical data set log.
	*
	* @param groupId the group ID of this import medical data set log
	*/
	@Override
	public void setGroupId(long groupId) {
		_importMedicalDataSetLog.setGroupId(groupId);
	}

	/**
	* Sets the import medical data set ID of this import medical data set log.
	*
	* @param importMedicalDataSetId the import medical data set ID of this import medical data set log
	*/
	@Override
	public void setImportMedicalDataSetId(long importMedicalDataSetId) {
		_importMedicalDataSetLog.setImportMedicalDataSetId(importMedicalDataSetId);
	}

	/**
	* Sets the import medical data set log ID of this import medical data set log.
	*
	* @param importMedicalDataSetLogId the import medical data set log ID of this import medical data set log
	*/
	@Override
	public void setImportMedicalDataSetLogId(long importMedicalDataSetLogId) {
		_importMedicalDataSetLog.setImportMedicalDataSetLogId(importMedicalDataSetLogId);
	}

	/**
	* Sets the import status of this import medical data set log.
	*
	* @param importStatus the import status of this import medical data set log
	*/
	@Override
	public void setImportStatus(int importStatus) {
		_importMedicalDataSetLog.setImportStatus(importStatus);
	}

	/**
	* Sets the import status log of this import medical data set log.
	*
	* @param importStatusLog the import status log of this import medical data set log
	*/
	@Override
	public void setImportStatusLog(java.lang.String importStatusLog) {
		_importMedicalDataSetLog.setImportStatusLog(importStatusLog);
	}

	/**
	* Sets the modified date of this import medical data set log.
	*
	* @param modifiedDate the modified date of this import medical data set log
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_importMedicalDataSetLog.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_importMedicalDataSetLog.setNew(n);
	}

	/**
	* Sets the primary key of this import medical data set log.
	*
	* @param primaryKey the primary key of this import medical data set log
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_importMedicalDataSetLog.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_importMedicalDataSetLog.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this import medical data set log.
	*
	* @param status the status of this import medical data set log
	*/
	@Override
	public void setStatus(int status) {
		_importMedicalDataSetLog.setStatus(status);
	}

	/**
	* Sets the status by user ID of this import medical data set log.
	*
	* @param statusByUserId the status by user ID of this import medical data set log
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_importMedicalDataSetLog.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this import medical data set log.
	*
	* @param statusByUserName the status by user name of this import medical data set log
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_importMedicalDataSetLog.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this import medical data set log.
	*
	* @param statusByUserUuid the status by user uuid of this import medical data set log
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_importMedicalDataSetLog.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this import medical data set log.
	*
	* @param statusDate the status date of this import medical data set log
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_importMedicalDataSetLog.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this import medical data set log.
	*
	* @param userId the user ID of this import medical data set log
	*/
	@Override
	public void setUserId(long userId) {
		_importMedicalDataSetLog.setUserId(userId);
	}

	/**
	* Sets the user name of this import medical data set log.
	*
	* @param userName the user name of this import medical data set log
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_importMedicalDataSetLog.setUserName(userName);
	}

	/**
	* Sets the user uuid of this import medical data set log.
	*
	* @param userUuid the user uuid of this import medical data set log
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_importMedicalDataSetLog.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this import medical data set log.
	*
	* @param uuid the uuid of this import medical data set log
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_importMedicalDataSetLog.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImportMedicalDataSetLogWrapper)) {
			return false;
		}

		ImportMedicalDataSetLogWrapper importMedicalDataSetLogWrapper = (ImportMedicalDataSetLogWrapper)obj;

		if (Objects.equals(_importMedicalDataSetLog,
					importMedicalDataSetLogWrapper._importMedicalDataSetLog)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _importMedicalDataSetLog.getStagedModelType();
	}

	@Override
	public ImportMedicalDataSetLog getWrappedModel() {
		return _importMedicalDataSetLog;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _importMedicalDataSetLog.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _importMedicalDataSetLog.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_importMedicalDataSetLog.resetOriginalValues();
	}

	private final ImportMedicalDataSetLog _importMedicalDataSetLog;
}