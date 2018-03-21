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

package at.graz.meduni.bibbox.informationprocessing.model;

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
 * This class is a wrapper for {@link DictionaryDictionaryLink}.
 * </p>
 *
 * @author robert
 * @see DictionaryDictionaryLink
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkWrapper implements DictionaryDictionaryLink,
	ModelWrapper<DictionaryDictionaryLink> {
	public DictionaryDictionaryLinkWrapper(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		_dictionaryDictionaryLink = dictionaryDictionaryLink;
	}

	@Override
	public Class<?> getModelClass() {
		return DictionaryDictionaryLink.class;
	}

	@Override
	public String getModelClassName() {
		return DictionaryDictionaryLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dictionarydictionarylinkId",
			getDictionarydictionarylinkId());
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
		attributes.put("dictionaryId", getDictionaryId());
		attributes.put("linkdictionaryId", getLinkdictionaryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dictionarydictionarylinkId = (Long)attributes.get(
				"dictionarydictionarylinkId");

		if (dictionarydictionarylinkId != null) {
			setDictionarydictionarylinkId(dictionarydictionarylinkId);
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

		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
		}

		Long linkdictionaryId = (Long)attributes.get("linkdictionaryId");

		if (linkdictionaryId != null) {
			setLinkdictionaryId(linkdictionaryId);
		}
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink toEscapedModel() {
		return new DictionaryDictionaryLinkWrapper(_dictionaryDictionaryLink.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink toUnescapedModel() {
		return new DictionaryDictionaryLinkWrapper(_dictionaryDictionaryLink.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this dictionary dictionary link is approved.
	*
	* @return <code>true</code> if this dictionary dictionary link is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _dictionaryDictionaryLink.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _dictionaryDictionaryLink.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this dictionary dictionary link is denied.
	*
	* @return <code>true</code> if this dictionary dictionary link is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _dictionaryDictionaryLink.isDenied();
	}

	/**
	* Returns <code>true</code> if this dictionary dictionary link is a draft.
	*
	* @return <code>true</code> if this dictionary dictionary link is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _dictionaryDictionaryLink.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _dictionaryDictionaryLink.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this dictionary dictionary link is expired.
	*
	* @return <code>true</code> if this dictionary dictionary link is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _dictionaryDictionaryLink.isExpired();
	}

	/**
	* Returns <code>true</code> if this dictionary dictionary link is inactive.
	*
	* @return <code>true</code> if this dictionary dictionary link is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _dictionaryDictionaryLink.isInactive();
	}

	/**
	* Returns <code>true</code> if this dictionary dictionary link is incomplete.
	*
	* @return <code>true</code> if this dictionary dictionary link is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _dictionaryDictionaryLink.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _dictionaryDictionaryLink.isNew();
	}

	/**
	* Returns <code>true</code> if this dictionary dictionary link is pending.
	*
	* @return <code>true</code> if this dictionary dictionary link is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _dictionaryDictionaryLink.isPending();
	}

	/**
	* Returns <code>true</code> if this dictionary dictionary link is scheduled.
	*
	* @return <code>true</code> if this dictionary dictionary link is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _dictionaryDictionaryLink.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dictionaryDictionaryLink.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink> toCacheModel() {
		return _dictionaryDictionaryLink.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		return _dictionaryDictionaryLink.compareTo(dictionaryDictionaryLink);
	}

	/**
	* Returns the status of this dictionary dictionary link.
	*
	* @return the status of this dictionary dictionary link
	*/
	@Override
	public int getStatus() {
		return _dictionaryDictionaryLink.getStatus();
	}

	@Override
	public int hashCode() {
		return _dictionaryDictionaryLink.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictionaryDictionaryLink.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DictionaryDictionaryLinkWrapper((DictionaryDictionaryLink)_dictionaryDictionaryLink.clone());
	}

	/**
	* Returns the status by user name of this dictionary dictionary link.
	*
	* @return the status by user name of this dictionary dictionary link
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _dictionaryDictionaryLink.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this dictionary dictionary link.
	*
	* @return the status by user uuid of this dictionary dictionary link
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _dictionaryDictionaryLink.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this dictionary dictionary link.
	*
	* @return the user name of this dictionary dictionary link
	*/
	@Override
	public java.lang.String getUserName() {
		return _dictionaryDictionaryLink.getUserName();
	}

	/**
	* Returns the user uuid of this dictionary dictionary link.
	*
	* @return the user uuid of this dictionary dictionary link
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _dictionaryDictionaryLink.getUserUuid();
	}

	/**
	* Returns the uuid of this dictionary dictionary link.
	*
	* @return the uuid of this dictionary dictionary link
	*/
	@Override
	public java.lang.String getUuid() {
		return _dictionaryDictionaryLink.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _dictionaryDictionaryLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictionaryDictionaryLink.toXmlString();
	}

	/**
	* Returns the create date of this dictionary dictionary link.
	*
	* @return the create date of this dictionary dictionary link
	*/
	@Override
	public Date getCreateDate() {
		return _dictionaryDictionaryLink.getCreateDate();
	}

	/**
	* Returns the modified date of this dictionary dictionary link.
	*
	* @return the modified date of this dictionary dictionary link
	*/
	@Override
	public Date getModifiedDate() {
		return _dictionaryDictionaryLink.getModifiedDate();
	}

	/**
	* Returns the status date of this dictionary dictionary link.
	*
	* @return the status date of this dictionary dictionary link
	*/
	@Override
	public Date getStatusDate() {
		return _dictionaryDictionaryLink.getStatusDate();
	}

	/**
	* Returns the company ID of this dictionary dictionary link.
	*
	* @return the company ID of this dictionary dictionary link
	*/
	@Override
	public long getCompanyId() {
		return _dictionaryDictionaryLink.getCompanyId();
	}

	/**
	* Returns the dictionary ID of this dictionary dictionary link.
	*
	* @return the dictionary ID of this dictionary dictionary link
	*/
	@Override
	public long getDictionaryId() {
		return _dictionaryDictionaryLink.getDictionaryId();
	}

	/**
	* Returns the dictionarydictionarylink ID of this dictionary dictionary link.
	*
	* @return the dictionarydictionarylink ID of this dictionary dictionary link
	*/
	@Override
	public long getDictionarydictionarylinkId() {
		return _dictionaryDictionaryLink.getDictionarydictionarylinkId();
	}

	/**
	* Returns the group ID of this dictionary dictionary link.
	*
	* @return the group ID of this dictionary dictionary link
	*/
	@Override
	public long getGroupId() {
		return _dictionaryDictionaryLink.getGroupId();
	}

	/**
	* Returns the linkdictionary ID of this dictionary dictionary link.
	*
	* @return the linkdictionary ID of this dictionary dictionary link
	*/
	@Override
	public long getLinkdictionaryId() {
		return _dictionaryDictionaryLink.getLinkdictionaryId();
	}

	/**
	* Returns the primary key of this dictionary dictionary link.
	*
	* @return the primary key of this dictionary dictionary link
	*/
	@Override
	public long getPrimaryKey() {
		return _dictionaryDictionaryLink.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this dictionary dictionary link.
	*
	* @return the status by user ID of this dictionary dictionary link
	*/
	@Override
	public long getStatusByUserId() {
		return _dictionaryDictionaryLink.getStatusByUserId();
	}

	/**
	* Returns the user ID of this dictionary dictionary link.
	*
	* @return the user ID of this dictionary dictionary link
	*/
	@Override
	public long getUserId() {
		return _dictionaryDictionaryLink.getUserId();
	}

	@Override
	public void persist() {
		_dictionaryDictionaryLink.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictionaryDictionaryLink.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this dictionary dictionary link.
	*
	* @param companyId the company ID of this dictionary dictionary link
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dictionaryDictionaryLink.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this dictionary dictionary link.
	*
	* @param createDate the create date of this dictionary dictionary link
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_dictionaryDictionaryLink.setCreateDate(createDate);
	}

	/**
	* Sets the dictionary ID of this dictionary dictionary link.
	*
	* @param dictionaryId the dictionary ID of this dictionary dictionary link
	*/
	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionaryDictionaryLink.setDictionaryId(dictionaryId);
	}

	/**
	* Sets the dictionarydictionarylink ID of this dictionary dictionary link.
	*
	* @param dictionarydictionarylinkId the dictionarydictionarylink ID of this dictionary dictionary link
	*/
	@Override
	public void setDictionarydictionarylinkId(long dictionarydictionarylinkId) {
		_dictionaryDictionaryLink.setDictionarydictionarylinkId(dictionarydictionarylinkId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dictionaryDictionaryLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dictionaryDictionaryLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dictionaryDictionaryLink.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this dictionary dictionary link.
	*
	* @param groupId the group ID of this dictionary dictionary link
	*/
	@Override
	public void setGroupId(long groupId) {
		_dictionaryDictionaryLink.setGroupId(groupId);
	}

	/**
	* Sets the linkdictionary ID of this dictionary dictionary link.
	*
	* @param linkdictionaryId the linkdictionary ID of this dictionary dictionary link
	*/
	@Override
	public void setLinkdictionaryId(long linkdictionaryId) {
		_dictionaryDictionaryLink.setLinkdictionaryId(linkdictionaryId);
	}

	/**
	* Sets the modified date of this dictionary dictionary link.
	*
	* @param modifiedDate the modified date of this dictionary dictionary link
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_dictionaryDictionaryLink.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_dictionaryDictionaryLink.setNew(n);
	}

	/**
	* Sets the primary key of this dictionary dictionary link.
	*
	* @param primaryKey the primary key of this dictionary dictionary link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictionaryDictionaryLink.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dictionaryDictionaryLink.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this dictionary dictionary link.
	*
	* @param status the status of this dictionary dictionary link
	*/
	@Override
	public void setStatus(int status) {
		_dictionaryDictionaryLink.setStatus(status);
	}

	/**
	* Sets the status by user ID of this dictionary dictionary link.
	*
	* @param statusByUserId the status by user ID of this dictionary dictionary link
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_dictionaryDictionaryLink.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this dictionary dictionary link.
	*
	* @param statusByUserName the status by user name of this dictionary dictionary link
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_dictionaryDictionaryLink.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this dictionary dictionary link.
	*
	* @param statusByUserUuid the status by user uuid of this dictionary dictionary link
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_dictionaryDictionaryLink.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this dictionary dictionary link.
	*
	* @param statusDate the status date of this dictionary dictionary link
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_dictionaryDictionaryLink.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this dictionary dictionary link.
	*
	* @param userId the user ID of this dictionary dictionary link
	*/
	@Override
	public void setUserId(long userId) {
		_dictionaryDictionaryLink.setUserId(userId);
	}

	/**
	* Sets the user name of this dictionary dictionary link.
	*
	* @param userName the user name of this dictionary dictionary link
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_dictionaryDictionaryLink.setUserName(userName);
	}

	/**
	* Sets the user uuid of this dictionary dictionary link.
	*
	* @param userUuid the user uuid of this dictionary dictionary link
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dictionaryDictionaryLink.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this dictionary dictionary link.
	*
	* @param uuid the uuid of this dictionary dictionary link
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_dictionaryDictionaryLink.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictionaryDictionaryLinkWrapper)) {
			return false;
		}

		DictionaryDictionaryLinkWrapper dictionaryDictionaryLinkWrapper = (DictionaryDictionaryLinkWrapper)obj;

		if (Objects.equals(_dictionaryDictionaryLink,
					dictionaryDictionaryLinkWrapper._dictionaryDictionaryLink)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _dictionaryDictionaryLink.getStagedModelType();
	}

	@Override
	public DictionaryDictionaryLink getWrappedModel() {
		return _dictionaryDictionaryLink;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dictionaryDictionaryLink.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dictionaryDictionaryLink.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dictionaryDictionaryLink.resetOriginalValues();
	}

	private final DictionaryDictionaryLink _dictionaryDictionaryLink;
}