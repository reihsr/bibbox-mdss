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
 * The base model interface for the Dictionary service. Represents a row in the &quot;SAAT_Dictionary&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryImpl}.
 * </p>
 *
 * @author robert
 * @see Dictionary
 * @see at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryImpl
 * @see at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryModelImpl
 * @generated
 */
@ProviderType
public interface DictionaryModel extends BaseModel<Dictionary>, GroupedModel,
	ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dictionary model instance should use the {@link Dictionary} interface instead.
	 */

	/**
	 * Returns the primary key of this dictionary.
	 *
	 * @return the primary key of this dictionary
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dictionary.
	 *
	 * @param primaryKey the primary key of this dictionary
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this dictionary.
	 *
	 * @return the uuid of this dictionary
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this dictionary.
	 *
	 * @param uuid the uuid of this dictionary
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the dictionary ID of this dictionary.
	 *
	 * @return the dictionary ID of this dictionary
	 */
	public long getDictionaryId();

	/**
	 * Sets the dictionary ID of this dictionary.
	 *
	 * @param dictionaryId the dictionary ID of this dictionary
	 */
	public void setDictionaryId(long dictionaryId);

	/**
	 * Returns the group ID of this dictionary.
	 *
	 * @return the group ID of this dictionary
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this dictionary.
	 *
	 * @param groupId the group ID of this dictionary
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this dictionary.
	 *
	 * @return the company ID of this dictionary
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dictionary.
	 *
	 * @param companyId the company ID of this dictionary
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this dictionary.
	 *
	 * @return the user ID of this dictionary
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this dictionary.
	 *
	 * @param userId the user ID of this dictionary
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dictionary.
	 *
	 * @return the user uuid of this dictionary
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dictionary.
	 *
	 * @param userUuid the user uuid of this dictionary
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dictionary.
	 *
	 * @return the user name of this dictionary
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this dictionary.
	 *
	 * @param userName the user name of this dictionary
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dictionary.
	 *
	 * @return the create date of this dictionary
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this dictionary.
	 *
	 * @param createDate the create date of this dictionary
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dictionary.
	 *
	 * @return the modified date of this dictionary
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dictionary.
	 *
	 * @param modifiedDate the modified date of this dictionary
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this dictionary.
	 *
	 * @return the status of this dictionary
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this dictionary.
	 *
	 * @param status the status of this dictionary
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this dictionary.
	 *
	 * @return the status by user ID of this dictionary
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this dictionary.
	 *
	 * @param statusByUserId the status by user ID of this dictionary
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this dictionary.
	 *
	 * @return the status by user uuid of this dictionary
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this dictionary.
	 *
	 * @param statusByUserUuid the status by user uuid of this dictionary
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this dictionary.
	 *
	 * @return the status by user name of this dictionary
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this dictionary.
	 *
	 * @param statusByUserName the status by user name of this dictionary
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this dictionary.
	 *
	 * @return the status date of this dictionary
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this dictionary.
	 *
	 * @param statusDate the status date of this dictionary
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the synonym of this dictionary.
	 *
	 * @return the synonym of this dictionary
	 */
	@AutoEscape
	public String getSynonym();

	/**
	 * Sets the synonym of this dictionary.
	 *
	 * @param synonym the synonym of this dictionary
	 */
	public void setSynonym(String synonym);

	/**
	 * Returns the pattern of this dictionary.
	 *
	 * @return the pattern of this dictionary
	 */
	@AutoEscape
	public String getPattern();

	/**
	 * Sets the pattern of this dictionary.
	 *
	 * @param pattern the pattern of this dictionary
	 */
	public void setPattern(String pattern);

	/**
	 * Returns the code of this dictionary.
	 *
	 * @return the code of this dictionary
	 */
	public boolean getCode();

	/**
	 * Returns <code>true</code> if this dictionary is code.
	 *
	 * @return <code>true</code> if this dictionary is code; <code>false</code> otherwise
	 */
	public boolean isCode();

	/**
	 * Sets whether this dictionary is code.
	 *
	 * @param code the code of this dictionary
	 */
	public void setCode(boolean code);

	/**
	 * Returns the code_type of this dictionary.
	 *
	 * @return the code_type of this dictionary
	 */
	@AutoEscape
	public String getCode_type();

	/**
	 * Sets the code_type of this dictionary.
	 *
	 * @param code_type the code_type of this dictionary
	 */
	public void setCode_type(String code_type);

	/**
	 * Returns the code_value of this dictionary.
	 *
	 * @return the code_value of this dictionary
	 */
	@AutoEscape
	public String getCode_value();

	/**
	 * Sets the code_value of this dictionary.
	 *
	 * @param code_value the code_value of this dictionary
	 */
	public void setCode_value(String code_value);

	/**
	 * Returns the root of this dictionary.
	 *
	 * @return the root of this dictionary
	 */
	public boolean getRoot();

	/**
	 * Returns <code>true</code> if this dictionary is root.
	 *
	 * @return <code>true</code> if this dictionary is root; <code>false</code> otherwise
	 */
	public boolean isRoot();

	/**
	 * Sets whether this dictionary is root.
	 *
	 * @param root the root of this dictionary
	 */
	public void setRoot(boolean root);

	/**
	 * Returns the negation of this dictionary.
	 *
	 * @return the negation of this dictionary
	 */
	public boolean getNegation();

	/**
	 * Returns <code>true</code> if this dictionary is negation.
	 *
	 * @return <code>true</code> if this dictionary is negation; <code>false</code> otherwise
	 */
	public boolean isNegation();

	/**
	 * Sets whether this dictionary is negation.
	 *
	 * @param negation the negation of this dictionary
	 */
	public void setNegation(boolean negation);

	/**
	 * Returns the priority of this dictionary.
	 *
	 * @return the priority of this dictionary
	 */
	public int getPriority();

	/**
	 * Sets the priority of this dictionary.
	 *
	 * @param priority the priority of this dictionary
	 */
	public void setPriority(int priority);

	/**
	 * Returns the priority_mode of this dictionary.
	 *
	 * @return the priority_mode of this dictionary
	 */
	public boolean getPriority_mode();

	/**
	 * Returns <code>true</code> if this dictionary is priority_mode.
	 *
	 * @return <code>true</code> if this dictionary is priority_mode; <code>false</code> otherwise
	 */
	public boolean isPriority_mode();

	/**
	 * Sets whether this dictionary is priority_mode.
	 *
	 * @param priority_mode the priority_mode of this dictionary
	 */
	public void setPriority_mode(boolean priority_mode);

	/**
	 * Returns the before_synonym of this dictionary.
	 *
	 * @return the before_synonym of this dictionary
	 */
	public int getBefore_synonym();

	/**
	 * Sets the before_synonym of this dictionary.
	 *
	 * @param before_synonym the before_synonym of this dictionary
	 */
	public void setBefore_synonym(int before_synonym);

	/**
	 * Returns the after_synonym of this dictionary.
	 *
	 * @return the after_synonym of this dictionary
	 */
	public int getAfter_synonym();

	/**
	 * Sets the after_synonym of this dictionary.
	 *
	 * @param after_synonym the after_synonym of this dictionary
	 */
	public void setAfter_synonym(int after_synonym);

	/**
	 * Returns the foreword of this dictionary.
	 *
	 * @return the foreword of this dictionary
	 */
	public boolean getForeword();

	/**
	 * Returns <code>true</code> if this dictionary is foreword.
	 *
	 * @return <code>true</code> if this dictionary is foreword; <code>false</code> otherwise
	 */
	public boolean isForeword();

	/**
	 * Sets whether this dictionary is foreword.
	 *
	 * @param foreword the foreword of this dictionary
	 */
	public void setForeword(boolean foreword);

	/**
	 * Returns the ending of this dictionary.
	 *
	 * @return the ending of this dictionary
	 */
	public boolean getEnding();

	/**
	 * Returns <code>true</code> if this dictionary is ending.
	 *
	 * @return <code>true</code> if this dictionary is ending; <code>false</code> otherwise
	 */
	public boolean isEnding();

	/**
	 * Sets whether this dictionary is ending.
	 *
	 * @param ending the ending of this dictionary
	 */
	public void setEnding(boolean ending);

	/**
	 * Returns the sentence of this dictionary.
	 *
	 * @return the sentence of this dictionary
	 */
	public boolean getSentence();

	/**
	 * Returns <code>true</code> if this dictionary is sentence.
	 *
	 * @return <code>true</code> if this dictionary is sentence; <code>false</code> otherwise
	 */
	public boolean isSentence();

	/**
	 * Sets whether this dictionary is sentence.
	 *
	 * @param sentence the sentence of this dictionary
	 */
	public void setSentence(boolean sentence);

	/**
	 * Returns the occure of this dictionary.
	 *
	 * @return the occure of this dictionary
	 */
	public boolean getOccure();

	/**
	 * Returns <code>true</code> if this dictionary is occure.
	 *
	 * @return <code>true</code> if this dictionary is occure; <code>false</code> otherwise
	 */
	public boolean isOccure();

	/**
	 * Sets whether this dictionary is occure.
	 *
	 * @param occure the occure of this dictionary
	 */
	public void setOccure(boolean occure);

	/**
	 * Returns <code>true</code> if this dictionary is approved.
	 *
	 * @return <code>true</code> if this dictionary is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this dictionary is denied.
	 *
	 * @return <code>true</code> if this dictionary is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this dictionary is a draft.
	 *
	 * @return <code>true</code> if this dictionary is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this dictionary is expired.
	 *
	 * @return <code>true</code> if this dictionary is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this dictionary is inactive.
	 *
	 * @return <code>true</code> if this dictionary is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this dictionary is incomplete.
	 *
	 * @return <code>true</code> if this dictionary is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this dictionary is pending.
	 *
	 * @return <code>true</code> if this dictionary is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this dictionary is scheduled.
	 *
	 * @return <code>true</code> if this dictionary is scheduled; <code>false</code> otherwise
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
		at.graz.meduni.bibbox.informationprocessing.model.Dictionary dictionary);

	@Override
	public int hashCode();

	@Override
	public CacheModel<at.graz.meduni.bibbox.informationprocessing.model.Dictionary> toCacheModel();

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary toEscapedModel();

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}