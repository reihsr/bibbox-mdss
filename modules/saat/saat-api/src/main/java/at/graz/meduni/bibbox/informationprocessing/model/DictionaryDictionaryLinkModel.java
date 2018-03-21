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
 * The base model interface for the DictionaryDictionaryLink service. Represents a row in the &quot;SAAT_DictionaryDictionaryLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryDictionaryLinkModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryDictionaryLinkImpl}.
 * </p>
 *
 * @author robert
 * @see DictionaryDictionaryLink
 * @see at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryDictionaryLinkImpl
 * @see at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryDictionaryLinkModelImpl
 * @generated
 */
@ProviderType
public interface DictionaryDictionaryLinkModel extends BaseModel<DictionaryDictionaryLink>,
	GroupedModel, ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dictionary dictionary link model instance should use the {@link DictionaryDictionaryLink} interface instead.
	 */

	/**
	 * Returns the primary key of this dictionary dictionary link.
	 *
	 * @return the primary key of this dictionary dictionary link
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dictionary dictionary link.
	 *
	 * @param primaryKey the primary key of this dictionary dictionary link
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this dictionary dictionary link.
	 *
	 * @return the uuid of this dictionary dictionary link
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this dictionary dictionary link.
	 *
	 * @param uuid the uuid of this dictionary dictionary link
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the dictionarydictionarylink ID of this dictionary dictionary link.
	 *
	 * @return the dictionarydictionarylink ID of this dictionary dictionary link
	 */
	public long getDictionarydictionarylinkId();

	/**
	 * Sets the dictionarydictionarylink ID of this dictionary dictionary link.
	 *
	 * @param dictionarydictionarylinkId the dictionarydictionarylink ID of this dictionary dictionary link
	 */
	public void setDictionarydictionarylinkId(long dictionarydictionarylinkId);

	/**
	 * Returns the group ID of this dictionary dictionary link.
	 *
	 * @return the group ID of this dictionary dictionary link
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this dictionary dictionary link.
	 *
	 * @param groupId the group ID of this dictionary dictionary link
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this dictionary dictionary link.
	 *
	 * @return the company ID of this dictionary dictionary link
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dictionary dictionary link.
	 *
	 * @param companyId the company ID of this dictionary dictionary link
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this dictionary dictionary link.
	 *
	 * @return the user ID of this dictionary dictionary link
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this dictionary dictionary link.
	 *
	 * @param userId the user ID of this dictionary dictionary link
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dictionary dictionary link.
	 *
	 * @return the user uuid of this dictionary dictionary link
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dictionary dictionary link.
	 *
	 * @param userUuid the user uuid of this dictionary dictionary link
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dictionary dictionary link.
	 *
	 * @return the user name of this dictionary dictionary link
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this dictionary dictionary link.
	 *
	 * @param userName the user name of this dictionary dictionary link
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dictionary dictionary link.
	 *
	 * @return the create date of this dictionary dictionary link
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this dictionary dictionary link.
	 *
	 * @param createDate the create date of this dictionary dictionary link
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dictionary dictionary link.
	 *
	 * @return the modified date of this dictionary dictionary link
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dictionary dictionary link.
	 *
	 * @param modifiedDate the modified date of this dictionary dictionary link
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this dictionary dictionary link.
	 *
	 * @return the status of this dictionary dictionary link
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this dictionary dictionary link.
	 *
	 * @param status the status of this dictionary dictionary link
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this dictionary dictionary link.
	 *
	 * @return the status by user ID of this dictionary dictionary link
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this dictionary dictionary link.
	 *
	 * @param statusByUserId the status by user ID of this dictionary dictionary link
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this dictionary dictionary link.
	 *
	 * @return the status by user uuid of this dictionary dictionary link
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this dictionary dictionary link.
	 *
	 * @param statusByUserUuid the status by user uuid of this dictionary dictionary link
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this dictionary dictionary link.
	 *
	 * @return the status by user name of this dictionary dictionary link
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this dictionary dictionary link.
	 *
	 * @param statusByUserName the status by user name of this dictionary dictionary link
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this dictionary dictionary link.
	 *
	 * @return the status date of this dictionary dictionary link
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this dictionary dictionary link.
	 *
	 * @param statusDate the status date of this dictionary dictionary link
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the dictionary ID of this dictionary dictionary link.
	 *
	 * @return the dictionary ID of this dictionary dictionary link
	 */
	public long getDictionaryId();

	/**
	 * Sets the dictionary ID of this dictionary dictionary link.
	 *
	 * @param dictionaryId the dictionary ID of this dictionary dictionary link
	 */
	public void setDictionaryId(long dictionaryId);

	/**
	 * Returns the linkdictionary ID of this dictionary dictionary link.
	 *
	 * @return the linkdictionary ID of this dictionary dictionary link
	 */
	public long getLinkdictionaryId();

	/**
	 * Sets the linkdictionary ID of this dictionary dictionary link.
	 *
	 * @param linkdictionaryId the linkdictionary ID of this dictionary dictionary link
	 */
	public void setLinkdictionaryId(long linkdictionaryId);

	/**
	 * Returns <code>true</code> if this dictionary dictionary link is approved.
	 *
	 * @return <code>true</code> if this dictionary dictionary link is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this dictionary dictionary link is denied.
	 *
	 * @return <code>true</code> if this dictionary dictionary link is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this dictionary dictionary link is a draft.
	 *
	 * @return <code>true</code> if this dictionary dictionary link is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this dictionary dictionary link is expired.
	 *
	 * @return <code>true</code> if this dictionary dictionary link is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this dictionary dictionary link is inactive.
	 *
	 * @return <code>true</code> if this dictionary dictionary link is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this dictionary dictionary link is incomplete.
	 *
	 * @return <code>true</code> if this dictionary dictionary link is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this dictionary dictionary link is pending.
	 *
	 * @return <code>true</code> if this dictionary dictionary link is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this dictionary dictionary link is scheduled.
	 *
	 * @return <code>true</code> if this dictionary dictionary link is scheduled; <code>false</code> otherwise
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
		at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink dictionaryDictionaryLink);

	@Override
	public int hashCode();

	@Override
	public CacheModel<at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink> toCacheModel();

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink toEscapedModel();

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}