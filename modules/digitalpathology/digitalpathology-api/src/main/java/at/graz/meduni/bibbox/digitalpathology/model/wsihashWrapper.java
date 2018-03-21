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
 * This class is a wrapper for {@link wsihash}.
 * </p>
 *
 * @author robert
 * @see wsihash
 * @generated
 */
@ProviderType
public class wsihashWrapper implements wsihash, ModelWrapper<wsihash> {
	public wsihashWrapper(wsihash wsihash) {
		_wsihash = wsihash;
	}

	@Override
	public Class<?> getModelClass() {
		return wsihash.class;
	}

	@Override
	public String getModelClassName() {
		return wsihash.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("wsihashId", getWsihashId());
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
		attributes.put("wsiId", getWsiId());
		attributes.put("filename", getFilename());
		attributes.put("hash", getHash());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long wsihashId = (Long)attributes.get("wsihashId");

		if (wsihashId != null) {
			setWsihashId(wsihashId);
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

		Long wsiId = (Long)attributes.get("wsiId");

		if (wsiId != null) {
			setWsiId(wsiId);
		}

		String filename = (String)attributes.get("filename");

		if (filename != null) {
			setFilename(filename);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}
	}

	@Override
	public at.graz.meduni.bibbox.digitalpathology.model.wsihash toEscapedModel() {
		return new wsihashWrapper(_wsihash.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.digitalpathology.model.wsihash toUnescapedModel() {
		return new wsihashWrapper(_wsihash.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this wsihash is approved.
	*
	* @return <code>true</code> if this wsihash is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _wsihash.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _wsihash.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this wsihash is denied.
	*
	* @return <code>true</code> if this wsihash is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _wsihash.isDenied();
	}

	/**
	* Returns <code>true</code> if this wsihash is a draft.
	*
	* @return <code>true</code> if this wsihash is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _wsihash.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _wsihash.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this wsihash is expired.
	*
	* @return <code>true</code> if this wsihash is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _wsihash.isExpired();
	}

	/**
	* Returns <code>true</code> if this wsihash is inactive.
	*
	* @return <code>true</code> if this wsihash is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _wsihash.isInactive();
	}

	/**
	* Returns <code>true</code> if this wsihash is incomplete.
	*
	* @return <code>true</code> if this wsihash is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _wsihash.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _wsihash.isNew();
	}

	/**
	* Returns <code>true</code> if this wsihash is pending.
	*
	* @return <code>true</code> if this wsihash is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _wsihash.isPending();
	}

	/**
	* Returns <code>true</code> if this wsihash is scheduled.
	*
	* @return <code>true</code> if this wsihash is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _wsihash.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _wsihash.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.digitalpathology.model.wsihash> toCacheModel() {
		return _wsihash.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.digitalpathology.model.wsihash wsihash) {
		return _wsihash.compareTo(wsihash);
	}

	/**
	* Returns the status of this wsihash.
	*
	* @return the status of this wsihash
	*/
	@Override
	public int getStatus() {
		return _wsihash.getStatus();
	}

	@Override
	public int hashCode() {
		return _wsihash.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wsihash.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new wsihashWrapper((wsihash)_wsihash.clone());
	}

	/**
	* Returns the filename of this wsihash.
	*
	* @return the filename of this wsihash
	*/
	@Override
	public java.lang.String getFilename() {
		return _wsihash.getFilename();
	}

	/**
	* Returns the hash of this wsihash.
	*
	* @return the hash of this wsihash
	*/
	@Override
	public java.lang.String getHash() {
		return _wsihash.getHash();
	}

	/**
	* Returns the status by user name of this wsihash.
	*
	* @return the status by user name of this wsihash
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _wsihash.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this wsihash.
	*
	* @return the status by user uuid of this wsihash
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _wsihash.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this wsihash.
	*
	* @return the user name of this wsihash
	*/
	@Override
	public java.lang.String getUserName() {
		return _wsihash.getUserName();
	}

	/**
	* Returns the user uuid of this wsihash.
	*
	* @return the user uuid of this wsihash
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _wsihash.getUserUuid();
	}

	/**
	* Returns the uuid of this wsihash.
	*
	* @return the uuid of this wsihash
	*/
	@Override
	public java.lang.String getUuid() {
		return _wsihash.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _wsihash.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _wsihash.toXmlString();
	}

	/**
	* Returns the create date of this wsihash.
	*
	* @return the create date of this wsihash
	*/
	@Override
	public Date getCreateDate() {
		return _wsihash.getCreateDate();
	}

	/**
	* Returns the modified date of this wsihash.
	*
	* @return the modified date of this wsihash
	*/
	@Override
	public Date getModifiedDate() {
		return _wsihash.getModifiedDate();
	}

	/**
	* Returns the status date of this wsihash.
	*
	* @return the status date of this wsihash
	*/
	@Override
	public Date getStatusDate() {
		return _wsihash.getStatusDate();
	}

	/**
	* Returns the company ID of this wsihash.
	*
	* @return the company ID of this wsihash
	*/
	@Override
	public long getCompanyId() {
		return _wsihash.getCompanyId();
	}

	/**
	* Returns the group ID of this wsihash.
	*
	* @return the group ID of this wsihash
	*/
	@Override
	public long getGroupId() {
		return _wsihash.getGroupId();
	}

	/**
	* Returns the primary key of this wsihash.
	*
	* @return the primary key of this wsihash
	*/
	@Override
	public long getPrimaryKey() {
		return _wsihash.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this wsihash.
	*
	* @return the status by user ID of this wsihash
	*/
	@Override
	public long getStatusByUserId() {
		return _wsihash.getStatusByUserId();
	}

	/**
	* Returns the user ID of this wsihash.
	*
	* @return the user ID of this wsihash
	*/
	@Override
	public long getUserId() {
		return _wsihash.getUserId();
	}

	/**
	* Returns the wsi ID of this wsihash.
	*
	* @return the wsi ID of this wsihash
	*/
	@Override
	public long getWsiId() {
		return _wsihash.getWsiId();
	}

	/**
	* Returns the wsihash ID of this wsihash.
	*
	* @return the wsihash ID of this wsihash
	*/
	@Override
	public long getWsihashId() {
		return _wsihash.getWsihashId();
	}

	@Override
	public void persist() {
		_wsihash.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_wsihash.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this wsihash.
	*
	* @param companyId the company ID of this wsihash
	*/
	@Override
	public void setCompanyId(long companyId) {
		_wsihash.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this wsihash.
	*
	* @param createDate the create date of this wsihash
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_wsihash.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_wsihash.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_wsihash.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_wsihash.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the filename of this wsihash.
	*
	* @param filename the filename of this wsihash
	*/
	@Override
	public void setFilename(java.lang.String filename) {
		_wsihash.setFilename(filename);
	}

	/**
	* Sets the group ID of this wsihash.
	*
	* @param groupId the group ID of this wsihash
	*/
	@Override
	public void setGroupId(long groupId) {
		_wsihash.setGroupId(groupId);
	}

	/**
	* Sets the hash of this wsihash.
	*
	* @param hash the hash of this wsihash
	*/
	@Override
	public void setHash(java.lang.String hash) {
		_wsihash.setHash(hash);
	}

	/**
	* Sets the modified date of this wsihash.
	*
	* @param modifiedDate the modified date of this wsihash
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_wsihash.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_wsihash.setNew(n);
	}

	/**
	* Sets the primary key of this wsihash.
	*
	* @param primaryKey the primary key of this wsihash
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_wsihash.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_wsihash.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this wsihash.
	*
	* @param status the status of this wsihash
	*/
	@Override
	public void setStatus(int status) {
		_wsihash.setStatus(status);
	}

	/**
	* Sets the status by user ID of this wsihash.
	*
	* @param statusByUserId the status by user ID of this wsihash
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_wsihash.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this wsihash.
	*
	* @param statusByUserName the status by user name of this wsihash
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_wsihash.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this wsihash.
	*
	* @param statusByUserUuid the status by user uuid of this wsihash
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_wsihash.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this wsihash.
	*
	* @param statusDate the status date of this wsihash
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_wsihash.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this wsihash.
	*
	* @param userId the user ID of this wsihash
	*/
	@Override
	public void setUserId(long userId) {
		_wsihash.setUserId(userId);
	}

	/**
	* Sets the user name of this wsihash.
	*
	* @param userName the user name of this wsihash
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_wsihash.setUserName(userName);
	}

	/**
	* Sets the user uuid of this wsihash.
	*
	* @param userUuid the user uuid of this wsihash
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_wsihash.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this wsihash.
	*
	* @param uuid the uuid of this wsihash
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_wsihash.setUuid(uuid);
	}

	/**
	* Sets the wsi ID of this wsihash.
	*
	* @param wsiId the wsi ID of this wsihash
	*/
	@Override
	public void setWsiId(long wsiId) {
		_wsihash.setWsiId(wsiId);
	}

	/**
	* Sets the wsihash ID of this wsihash.
	*
	* @param wsihashId the wsihash ID of this wsihash
	*/
	@Override
	public void setWsihashId(long wsihashId) {
		_wsihash.setWsihashId(wsihashId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof wsihashWrapper)) {
			return false;
		}

		wsihashWrapper wsihashWrapper = (wsihashWrapper)obj;

		if (Objects.equals(_wsihash, wsihashWrapper._wsihash)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _wsihash.getStagedModelType();
	}

	@Override
	public wsihash getWrappedModel() {
		return _wsihash;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _wsihash.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _wsihash.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_wsihash.resetOriginalValues();
	}

	private final wsihash _wsihash;
}