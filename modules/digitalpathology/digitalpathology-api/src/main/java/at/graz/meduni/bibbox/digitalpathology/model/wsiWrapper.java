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

package at.graz.meduni.bibbox.digitalpathology.model;

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
 * This class is a wrapper for {@link wsi}.
 * </p>
 *
 * @author robert
 * @see wsi
 * @generated
 */
@ProviderType
public class wsiWrapper implements wsi, ModelWrapper<wsi> {
	public wsiWrapper(wsi wsi) {
		_wsi = wsi;
	}

	@Override
	public Class<?> getModelClass() {
		return wsi.class;
	}

	@Override
	public String getModelClassName() {
		return wsi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("wsiId", getWsiId());
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
		attributes.put("filename", getFilename());
		attributes.put("hashmrxs", getHashmrxs());
		attributes.put("scanstart", getScanstart());
		attributes.put("scanduration", getScanduration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long wsiId = (Long)attributes.get("wsiId");

		if (wsiId != null) {
			setWsiId(wsiId);
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

		String filename = (String)attributes.get("filename");

		if (filename != null) {
			setFilename(filename);
		}

		String hashmrxs = (String)attributes.get("hashmrxs");

		if (hashmrxs != null) {
			setHashmrxs(hashmrxs);
		}

		Date scanstart = (Date)attributes.get("scanstart");

		if (scanstart != null) {
			setScanstart(scanstart);
		}

		Long scanduration = (Long)attributes.get("scanduration");

		if (scanduration != null) {
			setScanduration(scanduration);
		}
	}

	@Override
	public at.graz.meduni.bibbox.digitalpathology.model.wsi toEscapedModel() {
		return new wsiWrapper(_wsi.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.digitalpathology.model.wsi toUnescapedModel() {
		return new wsiWrapper(_wsi.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this wsi is approved.
	*
	* @return <code>true</code> if this wsi is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _wsi.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _wsi.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this wsi is denied.
	*
	* @return <code>true</code> if this wsi is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _wsi.isDenied();
	}

	/**
	* Returns <code>true</code> if this wsi is a draft.
	*
	* @return <code>true</code> if this wsi is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _wsi.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _wsi.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this wsi is expired.
	*
	* @return <code>true</code> if this wsi is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _wsi.isExpired();
	}

	/**
	* Returns <code>true</code> if this wsi is inactive.
	*
	* @return <code>true</code> if this wsi is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _wsi.isInactive();
	}

	/**
	* Returns <code>true</code> if this wsi is incomplete.
	*
	* @return <code>true</code> if this wsi is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _wsi.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _wsi.isNew();
	}

	/**
	* Returns <code>true</code> if this wsi is pending.
	*
	* @return <code>true</code> if this wsi is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _wsi.isPending();
	}

	/**
	* Returns <code>true</code> if this wsi is scheduled.
	*
	* @return <code>true</code> if this wsi is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _wsi.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wsi.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.digitalpathology.model.wsi> toCacheModel() {
		return _wsi.toCacheModel();
	}

	@Override
	public int compareTo(at.graz.meduni.bibbox.digitalpathology.model.wsi wsi) {
		return _wsi.compareTo(wsi);
	}

	/**
	* Returns the status of this wsi.
	*
	* @return the status of this wsi
	*/
	@Override
	public int getStatus() {
		return _wsi.getStatus();
	}

	@Override
	public int hashCode() {
		return _wsi.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wsi.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new wsiWrapper((wsi)_wsi.clone());
	}

	/**
	* Returns the filename of this wsi.
	*
	* @return the filename of this wsi
	*/
	@Override
	public java.lang.String getFilename() {
		return _wsi.getFilename();
	}

	/**
	* Returns the hashmrxs of this wsi.
	*
	* @return the hashmrxs of this wsi
	*/
	@Override
	public java.lang.String getHashmrxs() {
		return _wsi.getHashmrxs();
	}

	/**
	* Returns the status by user name of this wsi.
	*
	* @return the status by user name of this wsi
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _wsi.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this wsi.
	*
	* @return the status by user uuid of this wsi
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _wsi.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this wsi.
	*
	* @return the user name of this wsi
	*/
	@Override
	public java.lang.String getUserName() {
		return _wsi.getUserName();
	}

	/**
	* Returns the user uuid of this wsi.
	*
	* @return the user uuid of this wsi
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _wsi.getUserUuid();
	}

	/**
	* Returns the uuid of this wsi.
	*
	* @return the uuid of this wsi
	*/
	@Override
	public java.lang.String getUuid() {
		return _wsi.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _wsi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wsi.toXmlString();
	}

	/**
	* Returns the create date of this wsi.
	*
	* @return the create date of this wsi
	*/
	@Override
	public Date getCreateDate() {
		return _wsi.getCreateDate();
	}

	/**
	* Returns the modified date of this wsi.
	*
	* @return the modified date of this wsi
	*/
	@Override
	public Date getModifiedDate() {
		return _wsi.getModifiedDate();
	}

	/**
	* Returns the scanstart of this wsi.
	*
	* @return the scanstart of this wsi
	*/
	@Override
	public Date getScanstart() {
		return _wsi.getScanstart();
	}

	/**
	* Returns the status date of this wsi.
	*
	* @return the status date of this wsi
	*/
	@Override
	public Date getStatusDate() {
		return _wsi.getStatusDate();
	}

	/**
	* Returns the company ID of this wsi.
	*
	* @return the company ID of this wsi
	*/
	@Override
	public long getCompanyId() {
		return _wsi.getCompanyId();
	}

	/**
	* Returns the group ID of this wsi.
	*
	* @return the group ID of this wsi
	*/
	@Override
	public long getGroupId() {
		return _wsi.getGroupId();
	}

	/**
	* Returns the primary key of this wsi.
	*
	* @return the primary key of this wsi
	*/
	@Override
	public long getPrimaryKey() {
		return _wsi.getPrimaryKey();
	}

	/**
	* Returns the scanduration of this wsi.
	*
	* @return the scanduration of this wsi
	*/
	@Override
	public long getScanduration() {
		return _wsi.getScanduration();
	}

	/**
	* Returns the status by user ID of this wsi.
	*
	* @return the status by user ID of this wsi
	*/
	@Override
	public long getStatusByUserId() {
		return _wsi.getStatusByUserId();
	}

	/**
	* Returns the user ID of this wsi.
	*
	* @return the user ID of this wsi
	*/
	@Override
	public long getUserId() {
		return _wsi.getUserId();
	}

	/**
	* Returns the wsi ID of this wsi.
	*
	* @return the wsi ID of this wsi
	*/
	@Override
	public long getWsiId() {
		return _wsi.getWsiId();
	}

	@Override
	public void persist() {
		_wsi.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wsi.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this wsi.
	*
	* @param companyId the company ID of this wsi
	*/
	@Override
	public void setCompanyId(long companyId) {
		_wsi.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this wsi.
	*
	* @param createDate the create date of this wsi
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wsi.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wsi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wsi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wsi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the filename of this wsi.
	*
	* @param filename the filename of this wsi
	*/
	@Override
	public void setFilename(java.lang.String filename) {
		_wsi.setFilename(filename);
	}

	/**
	* Sets the group ID of this wsi.
	*
	* @param groupId the group ID of this wsi
	*/
	@Override
	public void setGroupId(long groupId) {
		_wsi.setGroupId(groupId);
	}

	/**
	* Sets the hashmrxs of this wsi.
	*
	* @param hashmrxs the hashmrxs of this wsi
	*/
	@Override
	public void setHashmrxs(java.lang.String hashmrxs) {
		_wsi.setHashmrxs(hashmrxs);
	}

	/**
	* Sets the modified date of this wsi.
	*
	* @param modifiedDate the modified date of this wsi
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wsi.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wsi.setNew(n);
	}

	/**
	* Sets the primary key of this wsi.
	*
	* @param primaryKey the primary key of this wsi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wsi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wsi.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the scanduration of this wsi.
	*
	* @param scanduration the scanduration of this wsi
	*/
	@Override
	public void setScanduration(long scanduration) {
		_wsi.setScanduration(scanduration);
	}

	/**
	* Sets the scanstart of this wsi.
	*
	* @param scanstart the scanstart of this wsi
	*/
	@Override
	public void setScanstart(Date scanstart) {
		_wsi.setScanstart(scanstart);
	}

	/**
	* Sets the status of this wsi.
	*
	* @param status the status of this wsi
	*/
	@Override
	public void setStatus(int status) {
		_wsi.setStatus(status);
	}

	/**
	* Sets the status by user ID of this wsi.
	*
	* @param statusByUserId the status by user ID of this wsi
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_wsi.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this wsi.
	*
	* @param statusByUserName the status by user name of this wsi
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_wsi.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this wsi.
	*
	* @param statusByUserUuid the status by user uuid of this wsi
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_wsi.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this wsi.
	*
	* @param statusDate the status date of this wsi
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_wsi.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this wsi.
	*
	* @param userId the user ID of this wsi
	*/
	@Override
	public void setUserId(long userId) {
		_wsi.setUserId(userId);
	}

	/**
	* Sets the user name of this wsi.
	*
	* @param userName the user name of this wsi
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_wsi.setUserName(userName);
	}

	/**
	* Sets the user uuid of this wsi.
	*
	* @param userUuid the user uuid of this wsi
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_wsi.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this wsi.
	*
	* @param uuid the uuid of this wsi
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_wsi.setUuid(uuid);
	}

	/**
	* Sets the wsi ID of this wsi.
	*
	* @param wsiId the wsi ID of this wsi
	*/
	@Override
	public void setWsiId(long wsiId) {
		_wsi.setWsiId(wsiId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof wsiWrapper)) {
			return false;
		}

		wsiWrapper wsiWrapper = (wsiWrapper)obj;

		if (Objects.equals(_wsi, wsiWrapper._wsi)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _wsi.getStagedModelType();
	}

	@Override
	public wsi getWrappedModel() {
		return _wsi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wsi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wsi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wsi.resetOriginalValues();
	}

	private final wsi _wsi;
}