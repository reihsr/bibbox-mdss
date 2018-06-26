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
 * This class is a wrapper for {@link ImportMedicalDataSet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSet
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetWrapper implements ImportMedicalDataSet,
	ModelWrapper<ImportMedicalDataSet> {
	public ImportMedicalDataSetWrapper(
		ImportMedicalDataSet importMedicalDataSet) {
		_importMedicalDataSet = importMedicalDataSet;
	}

	@Override
	public Class<?> getModelClass() {
		return ImportMedicalDataSet.class;
	}

	@Override
	public String getModelClassName() {
		return ImportMedicalDataSet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("importMedicalDataSetId", getImportMedicalDataSetId());
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
		attributes.put("importName", getImportName());
		attributes.put("importType", getImportType());
		attributes.put("imiJobId", getImiJobId());
		attributes.put("description", getDescription());
		attributes.put("fileName", getFileName());
		attributes.put("filePath", getFilePath());
		attributes.put("fileId", getFileId());
		attributes.put("importCount", getImportCount());
		attributes.put("importStatus", getImportStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long importMedicalDataSetId = (Long)attributes.get(
				"importMedicalDataSetId");

		if (importMedicalDataSetId != null) {
			setImportMedicalDataSetId(importMedicalDataSetId);
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

		String importName = (String)attributes.get("importName");

		if (importName != null) {
			setImportName(importName);
		}

		String importType = (String)attributes.get("importType");

		if (importType != null) {
			setImportType(importType);
		}

		Long imiJobId = (Long)attributes.get("imiJobId");

		if (imiJobId != null) {
			setImiJobId(imiJobId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String filePath = (String)attributes.get("filePath");

		if (filePath != null) {
			setFilePath(filePath);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		Integer importCount = (Integer)attributes.get("importCount");

		if (importCount != null) {
			setImportCount(importCount);
		}

		Integer importStatus = (Integer)attributes.get("importStatus");

		if (importStatus != null) {
			setImportStatus(importStatus);
		}
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet toEscapedModel() {
		return new ImportMedicalDataSetWrapper(_importMedicalDataSet.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet toUnescapedModel() {
		return new ImportMedicalDataSetWrapper(_importMedicalDataSet.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this import medical data set is approved.
	*
	* @return <code>true</code> if this import medical data set is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _importMedicalDataSet.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _importMedicalDataSet.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this import medical data set is denied.
	*
	* @return <code>true</code> if this import medical data set is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _importMedicalDataSet.isDenied();
	}

	/**
	* Returns <code>true</code> if this import medical data set is a draft.
	*
	* @return <code>true</code> if this import medical data set is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _importMedicalDataSet.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _importMedicalDataSet.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this import medical data set is expired.
	*
	* @return <code>true</code> if this import medical data set is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _importMedicalDataSet.isExpired();
	}

	/**
	* Returns <code>true</code> if this import medical data set is inactive.
	*
	* @return <code>true</code> if this import medical data set is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _importMedicalDataSet.isInactive();
	}

	/**
	* Returns <code>true</code> if this import medical data set is incomplete.
	*
	* @return <code>true</code> if this import medical data set is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _importMedicalDataSet.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _importMedicalDataSet.isNew();
	}

	/**
	* Returns <code>true</code> if this import medical data set is pending.
	*
	* @return <code>true</code> if this import medical data set is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _importMedicalDataSet.isPending();
	}

	/**
	* Returns <code>true</code> if this import medical data set is scheduled.
	*
	* @return <code>true</code> if this import medical data set is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _importMedicalDataSet.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _importMedicalDataSet.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet> toCacheModel() {
		return _importMedicalDataSet.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet importMedicalDataSet) {
		return _importMedicalDataSet.compareTo(importMedicalDataSet);
	}

	/**
	* Returns the import count of this import medical data set.
	*
	* @return the import count of this import medical data set
	*/
	@Override
	public int getImportCount() {
		return _importMedicalDataSet.getImportCount();
	}

	/**
	* Returns the import status of this import medical data set.
	*
	* @return the import status of this import medical data set
	*/
	@Override
	public int getImportStatus() {
		return _importMedicalDataSet.getImportStatus();
	}

	/**
	* Returns the status of this import medical data set.
	*
	* @return the status of this import medical data set
	*/
	@Override
	public int getStatus() {
		return _importMedicalDataSet.getStatus();
	}

	@Override
	public int hashCode() {
		return _importMedicalDataSet.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _importMedicalDataSet.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ImportMedicalDataSetWrapper((ImportMedicalDataSet)_importMedicalDataSet.clone());
	}

	/**
	* Returns the description of this import medical data set.
	*
	* @return the description of this import medical data set
	*/
	@Override
	public java.lang.String getDescription() {
		return _importMedicalDataSet.getDescription();
	}

	/**
	* Returns the file name of this import medical data set.
	*
	* @return the file name of this import medical data set
	*/
	@Override
	public java.lang.String getFileName() {
		return _importMedicalDataSet.getFileName();
	}

	/**
	* Returns the file path of this import medical data set.
	*
	* @return the file path of this import medical data set
	*/
	@Override
	public java.lang.String getFilePath() {
		return _importMedicalDataSet.getFilePath();
	}

	/**
	* Returns the import name of this import medical data set.
	*
	* @return the import name of this import medical data set
	*/
	@Override
	public java.lang.String getImportName() {
		return _importMedicalDataSet.getImportName();
	}

	/**
	* Returns the import type of this import medical data set.
	*
	* @return the import type of this import medical data set
	*/
	@Override
	public java.lang.String getImportType() {
		return _importMedicalDataSet.getImportType();
	}

	/**
	* Returns the status by user name of this import medical data set.
	*
	* @return the status by user name of this import medical data set
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _importMedicalDataSet.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this import medical data set.
	*
	* @return the status by user uuid of this import medical data set
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _importMedicalDataSet.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this import medical data set.
	*
	* @return the user name of this import medical data set
	*/
	@Override
	public java.lang.String getUserName() {
		return _importMedicalDataSet.getUserName();
	}

	/**
	* Returns the user uuid of this import medical data set.
	*
	* @return the user uuid of this import medical data set
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _importMedicalDataSet.getUserUuid();
	}

	/**
	* Returns the uuid of this import medical data set.
	*
	* @return the uuid of this import medical data set
	*/
	@Override
	public java.lang.String getUuid() {
		return _importMedicalDataSet.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _importMedicalDataSet.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _importMedicalDataSet.toXmlString();
	}

	/**
	* Returns the create date of this import medical data set.
	*
	* @return the create date of this import medical data set
	*/
	@Override
	public Date getCreateDate() {
		return _importMedicalDataSet.getCreateDate();
	}

	/**
	* Returns the modified date of this import medical data set.
	*
	* @return the modified date of this import medical data set
	*/
	@Override
	public Date getModifiedDate() {
		return _importMedicalDataSet.getModifiedDate();
	}

	/**
	* Returns the status date of this import medical data set.
	*
	* @return the status date of this import medical data set
	*/
	@Override
	public Date getStatusDate() {
		return _importMedicalDataSet.getStatusDate();
	}

	/**
	* Returns the company ID of this import medical data set.
	*
	* @return the company ID of this import medical data set
	*/
	@Override
	public long getCompanyId() {
		return _importMedicalDataSet.getCompanyId();
	}

	/**
	* Returns the file ID of this import medical data set.
	*
	* @return the file ID of this import medical data set
	*/
	@Override
	public long getFileId() {
		return _importMedicalDataSet.getFileId();
	}

	/**
	* Returns the group ID of this import medical data set.
	*
	* @return the group ID of this import medical data set
	*/
	@Override
	public long getGroupId() {
		return _importMedicalDataSet.getGroupId();
	}

	/**
	* Returns the imi job ID of this import medical data set.
	*
	* @return the imi job ID of this import medical data set
	*/
	@Override
	public long getImiJobId() {
		return _importMedicalDataSet.getImiJobId();
	}

	/**
	* Returns the import medical data set ID of this import medical data set.
	*
	* @return the import medical data set ID of this import medical data set
	*/
	@Override
	public long getImportMedicalDataSetId() {
		return _importMedicalDataSet.getImportMedicalDataSetId();
	}

	/**
	* Returns the primary key of this import medical data set.
	*
	* @return the primary key of this import medical data set
	*/
	@Override
	public long getPrimaryKey() {
		return _importMedicalDataSet.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this import medical data set.
	*
	* @return the status by user ID of this import medical data set
	*/
	@Override
	public long getStatusByUserId() {
		return _importMedicalDataSet.getStatusByUserId();
	}

	/**
	* Returns the user ID of this import medical data set.
	*
	* @return the user ID of this import medical data set
	*/
	@Override
	public long getUserId() {
		return _importMedicalDataSet.getUserId();
	}

	@Override
	public void persist() {
		_importMedicalDataSet.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_importMedicalDataSet.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this import medical data set.
	*
	* @param companyId the company ID of this import medical data set
	*/
	@Override
	public void setCompanyId(long companyId) {
		_importMedicalDataSet.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this import medical data set.
	*
	* @param createDate the create date of this import medical data set
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_importMedicalDataSet.setCreateDate(createDate);
	}

	/**
	* Sets the description of this import medical data set.
	*
	* @param description the description of this import medical data set
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_importMedicalDataSet.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_importMedicalDataSet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_importMedicalDataSet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_importMedicalDataSet.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file ID of this import medical data set.
	*
	* @param fileId the file ID of this import medical data set
	*/
	@Override
	public void setFileId(long fileId) {
		_importMedicalDataSet.setFileId(fileId);
	}

	/**
	* Sets the file name of this import medical data set.
	*
	* @param fileName the file name of this import medical data set
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_importMedicalDataSet.setFileName(fileName);
	}

	/**
	* Sets the file path of this import medical data set.
	*
	* @param filePath the file path of this import medical data set
	*/
	@Override
	public void setFilePath(java.lang.String filePath) {
		_importMedicalDataSet.setFilePath(filePath);
	}

	/**
	* Sets the group ID of this import medical data set.
	*
	* @param groupId the group ID of this import medical data set
	*/
	@Override
	public void setGroupId(long groupId) {
		_importMedicalDataSet.setGroupId(groupId);
	}

	/**
	* Sets the imi job ID of this import medical data set.
	*
	* @param imiJobId the imi job ID of this import medical data set
	*/
	@Override
	public void setImiJobId(long imiJobId) {
		_importMedicalDataSet.setImiJobId(imiJobId);
	}

	/**
	* Sets the import count of this import medical data set.
	*
	* @param importCount the import count of this import medical data set
	*/
	@Override
	public void setImportCount(int importCount) {
		_importMedicalDataSet.setImportCount(importCount);
	}

	/**
	* Sets the import medical data set ID of this import medical data set.
	*
	* @param importMedicalDataSetId the import medical data set ID of this import medical data set
	*/
	@Override
	public void setImportMedicalDataSetId(long importMedicalDataSetId) {
		_importMedicalDataSet.setImportMedicalDataSetId(importMedicalDataSetId);
	}

	/**
	* Sets the import name of this import medical data set.
	*
	* @param importName the import name of this import medical data set
	*/
	@Override
	public void setImportName(java.lang.String importName) {
		_importMedicalDataSet.setImportName(importName);
	}

	/**
	* Sets the import status of this import medical data set.
	*
	* @param importStatus the import status of this import medical data set
	*/
	@Override
	public void setImportStatus(int importStatus) {
		_importMedicalDataSet.setImportStatus(importStatus);
	}

	/**
	* Sets the import type of this import medical data set.
	*
	* @param importType the import type of this import medical data set
	*/
	@Override
	public void setImportType(java.lang.String importType) {
		_importMedicalDataSet.setImportType(importType);
	}

	/**
	* Sets the modified date of this import medical data set.
	*
	* @param modifiedDate the modified date of this import medical data set
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_importMedicalDataSet.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_importMedicalDataSet.setNew(n);
	}

	/**
	* Sets the primary key of this import medical data set.
	*
	* @param primaryKey the primary key of this import medical data set
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_importMedicalDataSet.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_importMedicalDataSet.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this import medical data set.
	*
	* @param status the status of this import medical data set
	*/
	@Override
	public void setStatus(int status) {
		_importMedicalDataSet.setStatus(status);
	}

	/**
	* Sets the status by user ID of this import medical data set.
	*
	* @param statusByUserId the status by user ID of this import medical data set
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_importMedicalDataSet.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this import medical data set.
	*
	* @param statusByUserName the status by user name of this import medical data set
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_importMedicalDataSet.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this import medical data set.
	*
	* @param statusByUserUuid the status by user uuid of this import medical data set
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_importMedicalDataSet.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this import medical data set.
	*
	* @param statusDate the status date of this import medical data set
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_importMedicalDataSet.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this import medical data set.
	*
	* @param userId the user ID of this import medical data set
	*/
	@Override
	public void setUserId(long userId) {
		_importMedicalDataSet.setUserId(userId);
	}

	/**
	* Sets the user name of this import medical data set.
	*
	* @param userName the user name of this import medical data set
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_importMedicalDataSet.setUserName(userName);
	}

	/**
	* Sets the user uuid of this import medical data set.
	*
	* @param userUuid the user uuid of this import medical data set
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_importMedicalDataSet.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this import medical data set.
	*
	* @param uuid the uuid of this import medical data set
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_importMedicalDataSet.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImportMedicalDataSetWrapper)) {
			return false;
		}

		ImportMedicalDataSetWrapper importMedicalDataSetWrapper = (ImportMedicalDataSetWrapper)obj;

		if (Objects.equals(_importMedicalDataSet,
					importMedicalDataSetWrapper._importMedicalDataSet)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _importMedicalDataSet.getStagedModelType();
	}

	@Override
	public ImportMedicalDataSet getWrappedModel() {
		return _importMedicalDataSet;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _importMedicalDataSet.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _importMedicalDataSet.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_importMedicalDataSet.resetOriginalValues();
	}

	private final ImportMedicalDataSet _importMedicalDataSet;
}