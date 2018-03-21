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
 * This class is a wrapper for {@link Dictionary}.
 * </p>
 *
 * @author robert
 * @see Dictionary
 * @generated
 */
@ProviderType
public class DictionaryWrapper implements Dictionary, ModelWrapper<Dictionary> {
	public DictionaryWrapper(Dictionary dictionary) {
		_dictionary = dictionary;
	}

	@Override
	public Class<?> getModelClass() {
		return Dictionary.class;
	}

	@Override
	public String getModelClassName() {
		return Dictionary.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dictionaryId", getDictionaryId());
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
		attributes.put("synonym", getSynonym());
		attributes.put("pattern", getPattern());
		attributes.put("code", getCode());
		attributes.put("code_type", getCode_type());
		attributes.put("code_value", getCode_value());
		attributes.put("root", getRoot());
		attributes.put("negation", getNegation());
		attributes.put("priority", getPriority());
		attributes.put("priority_mode", getPriority_mode());
		attributes.put("before_synonym", getBefore_synonym());
		attributes.put("after_synonym", getAfter_synonym());
		attributes.put("foreword", getForeword());
		attributes.put("ending", getEnding());
		attributes.put("sentence", getSentence());
		attributes.put("occure", getOccure());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
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

		String synonym = (String)attributes.get("synonym");

		if (synonym != null) {
			setSynonym(synonym);
		}

		String pattern = (String)attributes.get("pattern");

		if (pattern != null) {
			setPattern(pattern);
		}

		Boolean code = (Boolean)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String code_type = (String)attributes.get("code_type");

		if (code_type != null) {
			setCode_type(code_type);
		}

		String code_value = (String)attributes.get("code_value");

		if (code_value != null) {
			setCode_value(code_value);
		}

		Boolean root = (Boolean)attributes.get("root");

		if (root != null) {
			setRoot(root);
		}

		Boolean negation = (Boolean)attributes.get("negation");

		if (negation != null) {
			setNegation(negation);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Boolean priority_mode = (Boolean)attributes.get("priority_mode");

		if (priority_mode != null) {
			setPriority_mode(priority_mode);
		}

		Integer before_synonym = (Integer)attributes.get("before_synonym");

		if (before_synonym != null) {
			setBefore_synonym(before_synonym);
		}

		Integer after_synonym = (Integer)attributes.get("after_synonym");

		if (after_synonym != null) {
			setAfter_synonym(after_synonym);
		}

		Boolean foreword = (Boolean)attributes.get("foreword");

		if (foreword != null) {
			setForeword(foreword);
		}

		Boolean ending = (Boolean)attributes.get("ending");

		if (ending != null) {
			setEnding(ending);
		}

		Boolean sentence = (Boolean)attributes.get("sentence");

		if (sentence != null) {
			setSentence(sentence);
		}

		Boolean occure = (Boolean)attributes.get("occure");

		if (occure != null) {
			setOccure(occure);
		}
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary toEscapedModel() {
		return new DictionaryWrapper(_dictionary.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary toUnescapedModel() {
		return new DictionaryWrapper(_dictionary.toUnescapedModel());
	}

	/**
	* Returns the code of this dictionary.
	*
	* @return the code of this dictionary
	*/
	@Override
	public boolean getCode() {
		return _dictionary.getCode();
	}

	/**
	* Returns the ending of this dictionary.
	*
	* @return the ending of this dictionary
	*/
	@Override
	public boolean getEnding() {
		return _dictionary.getEnding();
	}

	/**
	* Returns the foreword of this dictionary.
	*
	* @return the foreword of this dictionary
	*/
	@Override
	public boolean getForeword() {
		return _dictionary.getForeword();
	}

	/**
	* Returns the negation of this dictionary.
	*
	* @return the negation of this dictionary
	*/
	@Override
	public boolean getNegation() {
		return _dictionary.getNegation();
	}

	/**
	* Returns the occure of this dictionary.
	*
	* @return the occure of this dictionary
	*/
	@Override
	public boolean getOccure() {
		return _dictionary.getOccure();
	}

	/**
	* Returns the priority_mode of this dictionary.
	*
	* @return the priority_mode of this dictionary
	*/
	@Override
	public boolean getPriority_mode() {
		return _dictionary.getPriority_mode();
	}

	/**
	* Returns the root of this dictionary.
	*
	* @return the root of this dictionary
	*/
	@Override
	public boolean getRoot() {
		return _dictionary.getRoot();
	}

	/**
	* Returns the sentence of this dictionary.
	*
	* @return the sentence of this dictionary
	*/
	@Override
	public boolean getSentence() {
		return _dictionary.getSentence();
	}

	/**
	* Returns <code>true</code> if this dictionary is approved.
	*
	* @return <code>true</code> if this dictionary is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _dictionary.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _dictionary.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this dictionary is code.
	*
	* @return <code>true</code> if this dictionary is code; <code>false</code> otherwise
	*/
	@Override
	public boolean isCode() {
		return _dictionary.isCode();
	}

	/**
	* Returns <code>true</code> if this dictionary is denied.
	*
	* @return <code>true</code> if this dictionary is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _dictionary.isDenied();
	}

	/**
	* Returns <code>true</code> if this dictionary is a draft.
	*
	* @return <code>true</code> if this dictionary is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _dictionary.isDraft();
	}

	/**
	* Returns <code>true</code> if this dictionary is ending.
	*
	* @return <code>true</code> if this dictionary is ending; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnding() {
		return _dictionary.isEnding();
	}

	@Override
	public boolean isEscapedModel() {
		return _dictionary.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this dictionary is expired.
	*
	* @return <code>true</code> if this dictionary is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _dictionary.isExpired();
	}

	/**
	* Returns <code>true</code> if this dictionary is foreword.
	*
	* @return <code>true</code> if this dictionary is foreword; <code>false</code> otherwise
	*/
	@Override
	public boolean isForeword() {
		return _dictionary.isForeword();
	}

	/**
	* Returns <code>true</code> if this dictionary is inactive.
	*
	* @return <code>true</code> if this dictionary is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _dictionary.isInactive();
	}

	/**
	* Returns <code>true</code> if this dictionary is incomplete.
	*
	* @return <code>true</code> if this dictionary is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _dictionary.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this dictionary is negation.
	*
	* @return <code>true</code> if this dictionary is negation; <code>false</code> otherwise
	*/
	@Override
	public boolean isNegation() {
		return _dictionary.isNegation();
	}

	@Override
	public boolean isNew() {
		return _dictionary.isNew();
	}

	/**
	* Returns <code>true</code> if this dictionary is occure.
	*
	* @return <code>true</code> if this dictionary is occure; <code>false</code> otherwise
	*/
	@Override
	public boolean isOccure() {
		return _dictionary.isOccure();
	}

	/**
	* Returns <code>true</code> if this dictionary is pending.
	*
	* @return <code>true</code> if this dictionary is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _dictionary.isPending();
	}

	/**
	* Returns <code>true</code> if this dictionary is priority_mode.
	*
	* @return <code>true</code> if this dictionary is priority_mode; <code>false</code> otherwise
	*/
	@Override
	public boolean isPriority_mode() {
		return _dictionary.isPriority_mode();
	}

	/**
	* Returns <code>true</code> if this dictionary is root.
	*
	* @return <code>true</code> if this dictionary is root; <code>false</code> otherwise
	*/
	@Override
	public boolean isRoot() {
		return _dictionary.isRoot();
	}

	/**
	* Returns <code>true</code> if this dictionary is scheduled.
	*
	* @return <code>true</code> if this dictionary is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _dictionary.isScheduled();
	}

	/**
	* Returns <code>true</code> if this dictionary is sentence.
	*
	* @return <code>true</code> if this dictionary is sentence; <code>false</code> otherwise
	*/
	@Override
	public boolean isSentence() {
		return _dictionary.isSentence();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dictionary.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.informationprocessing.model.Dictionary> toCacheModel() {
		return _dictionary.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.informationprocessing.model.Dictionary dictionary) {
		return _dictionary.compareTo(dictionary);
	}

	/**
	* Returns the after_synonym of this dictionary.
	*
	* @return the after_synonym of this dictionary
	*/
	@Override
	public int getAfter_synonym() {
		return _dictionary.getAfter_synonym();
	}

	/**
	* Returns the before_synonym of this dictionary.
	*
	* @return the before_synonym of this dictionary
	*/
	@Override
	public int getBefore_synonym() {
		return _dictionary.getBefore_synonym();
	}

	/**
	* Returns the priority of this dictionary.
	*
	* @return the priority of this dictionary
	*/
	@Override
	public int getPriority() {
		return _dictionary.getPriority();
	}

	/**
	* Returns the status of this dictionary.
	*
	* @return the status of this dictionary
	*/
	@Override
	public int getStatus() {
		return _dictionary.getStatus();
	}

	@Override
	public int hashCode() {
		return _dictionary.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictionary.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DictionaryWrapper((Dictionary)_dictionary.clone());
	}

	/**
	* Returns the code_type of this dictionary.
	*
	* @return the code_type of this dictionary
	*/
	@Override
	public java.lang.String getCode_type() {
		return _dictionary.getCode_type();
	}

	/**
	* Returns the code_value of this dictionary.
	*
	* @return the code_value of this dictionary
	*/
	@Override
	public java.lang.String getCode_value() {
		return _dictionary.getCode_value();
	}

	/**
	* Returns the pattern of this dictionary.
	*
	* @return the pattern of this dictionary
	*/
	@Override
	public java.lang.String getPattern() {
		return _dictionary.getPattern();
	}

	/**
	* Returns the status by user name of this dictionary.
	*
	* @return the status by user name of this dictionary
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _dictionary.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this dictionary.
	*
	* @return the status by user uuid of this dictionary
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _dictionary.getStatusByUserUuid();
	}

	/**
	* Returns the synonym of this dictionary.
	*
	* @return the synonym of this dictionary
	*/
	@Override
	public java.lang.String getSynonym() {
		return _dictionary.getSynonym();
	}

	/**
	* Returns the user name of this dictionary.
	*
	* @return the user name of this dictionary
	*/
	@Override
	public java.lang.String getUserName() {
		return _dictionary.getUserName();
	}

	/**
	* Returns the user uuid of this dictionary.
	*
	* @return the user uuid of this dictionary
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _dictionary.getUserUuid();
	}

	/**
	* Returns the uuid of this dictionary.
	*
	* @return the uuid of this dictionary
	*/
	@Override
	public java.lang.String getUuid() {
		return _dictionary.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _dictionary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictionary.toXmlString();
	}

	/**
	* Returns the create date of this dictionary.
	*
	* @return the create date of this dictionary
	*/
	@Override
	public Date getCreateDate() {
		return _dictionary.getCreateDate();
	}

	/**
	* Returns the modified date of this dictionary.
	*
	* @return the modified date of this dictionary
	*/
	@Override
	public Date getModifiedDate() {
		return _dictionary.getModifiedDate();
	}

	/**
	* Returns the status date of this dictionary.
	*
	* @return the status date of this dictionary
	*/
	@Override
	public Date getStatusDate() {
		return _dictionary.getStatusDate();
	}

	/**
	* Returns the company ID of this dictionary.
	*
	* @return the company ID of this dictionary
	*/
	@Override
	public long getCompanyId() {
		return _dictionary.getCompanyId();
	}

	/**
	* Returns the dictionary ID of this dictionary.
	*
	* @return the dictionary ID of this dictionary
	*/
	@Override
	public long getDictionaryId() {
		return _dictionary.getDictionaryId();
	}

	/**
	* Returns the group ID of this dictionary.
	*
	* @return the group ID of this dictionary
	*/
	@Override
	public long getGroupId() {
		return _dictionary.getGroupId();
	}

	/**
	* Returns the primary key of this dictionary.
	*
	* @return the primary key of this dictionary
	*/
	@Override
	public long getPrimaryKey() {
		return _dictionary.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this dictionary.
	*
	* @return the status by user ID of this dictionary
	*/
	@Override
	public long getStatusByUserId() {
		return _dictionary.getStatusByUserId();
	}

	/**
	* Returns the user ID of this dictionary.
	*
	* @return the user ID of this dictionary
	*/
	@Override
	public long getUserId() {
		return _dictionary.getUserId();
	}

	@Override
	public void persist() {
		_dictionary.persist();
	}

	/**
	* Sets the after_synonym of this dictionary.
	*
	* @param after_synonym the after_synonym of this dictionary
	*/
	@Override
	public void setAfter_synonym(int after_synonym) {
		_dictionary.setAfter_synonym(after_synonym);
	}

	/**
	* Sets the before_synonym of this dictionary.
	*
	* @param before_synonym the before_synonym of this dictionary
	*/
	@Override
	public void setBefore_synonym(int before_synonym) {
		_dictionary.setBefore_synonym(before_synonym);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictionary.setCachedModel(cachedModel);
	}

	/**
	* Sets whether this dictionary is code.
	*
	* @param code the code of this dictionary
	*/
	@Override
	public void setCode(boolean code) {
		_dictionary.setCode(code);
	}

	/**
	* Sets the code_type of this dictionary.
	*
	* @param code_type the code_type of this dictionary
	*/
	@Override
	public void setCode_type(java.lang.String code_type) {
		_dictionary.setCode_type(code_type);
	}

	/**
	* Sets the code_value of this dictionary.
	*
	* @param code_value the code_value of this dictionary
	*/
	@Override
	public void setCode_value(java.lang.String code_value) {
		_dictionary.setCode_value(code_value);
	}

	/**
	* Sets the company ID of this dictionary.
	*
	* @param companyId the company ID of this dictionary
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dictionary.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this dictionary.
	*
	* @param createDate the create date of this dictionary
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_dictionary.setCreateDate(createDate);
	}

	/**
	* Sets the dictionary ID of this dictionary.
	*
	* @param dictionaryId the dictionary ID of this dictionary
	*/
	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionary.setDictionaryId(dictionaryId);
	}

	/**
	* Sets whether this dictionary is ending.
	*
	* @param ending the ending of this dictionary
	*/
	@Override
	public void setEnding(boolean ending) {
		_dictionary.setEnding(ending);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dictionary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dictionary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dictionary.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this dictionary is foreword.
	*
	* @param foreword the foreword of this dictionary
	*/
	@Override
	public void setForeword(boolean foreword) {
		_dictionary.setForeword(foreword);
	}

	/**
	* Sets the group ID of this dictionary.
	*
	* @param groupId the group ID of this dictionary
	*/
	@Override
	public void setGroupId(long groupId) {
		_dictionary.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this dictionary.
	*
	* @param modifiedDate the modified date of this dictionary
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_dictionary.setModifiedDate(modifiedDate);
	}

	/**
	* Sets whether this dictionary is negation.
	*
	* @param negation the negation of this dictionary
	*/
	@Override
	public void setNegation(boolean negation) {
		_dictionary.setNegation(negation);
	}

	@Override
	public void setNew(boolean n) {
		_dictionary.setNew(n);
	}

	/**
	* Sets whether this dictionary is occure.
	*
	* @param occure the occure of this dictionary
	*/
	@Override
	public void setOccure(boolean occure) {
		_dictionary.setOccure(occure);
	}

	/**
	* Sets the pattern of this dictionary.
	*
	* @param pattern the pattern of this dictionary
	*/
	@Override
	public void setPattern(java.lang.String pattern) {
		_dictionary.setPattern(pattern);
	}

	/**
	* Sets the primary key of this dictionary.
	*
	* @param primaryKey the primary key of this dictionary
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictionary.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dictionary.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the priority of this dictionary.
	*
	* @param priority the priority of this dictionary
	*/
	@Override
	public void setPriority(int priority) {
		_dictionary.setPriority(priority);
	}

	/**
	* Sets whether this dictionary is priority_mode.
	*
	* @param priority_mode the priority_mode of this dictionary
	*/
	@Override
	public void setPriority_mode(boolean priority_mode) {
		_dictionary.setPriority_mode(priority_mode);
	}

	/**
	* Sets whether this dictionary is root.
	*
	* @param root the root of this dictionary
	*/
	@Override
	public void setRoot(boolean root) {
		_dictionary.setRoot(root);
	}

	/**
	* Sets whether this dictionary is sentence.
	*
	* @param sentence the sentence of this dictionary
	*/
	@Override
	public void setSentence(boolean sentence) {
		_dictionary.setSentence(sentence);
	}

	/**
	* Sets the status of this dictionary.
	*
	* @param status the status of this dictionary
	*/
	@Override
	public void setStatus(int status) {
		_dictionary.setStatus(status);
	}

	/**
	* Sets the status by user ID of this dictionary.
	*
	* @param statusByUserId the status by user ID of this dictionary
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_dictionary.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this dictionary.
	*
	* @param statusByUserName the status by user name of this dictionary
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_dictionary.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this dictionary.
	*
	* @param statusByUserUuid the status by user uuid of this dictionary
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_dictionary.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this dictionary.
	*
	* @param statusDate the status date of this dictionary
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_dictionary.setStatusDate(statusDate);
	}

	/**
	* Sets the synonym of this dictionary.
	*
	* @param synonym the synonym of this dictionary
	*/
	@Override
	public void setSynonym(java.lang.String synonym) {
		_dictionary.setSynonym(synonym);
	}

	/**
	* Sets the user ID of this dictionary.
	*
	* @param userId the user ID of this dictionary
	*/
	@Override
	public void setUserId(long userId) {
		_dictionary.setUserId(userId);
	}

	/**
	* Sets the user name of this dictionary.
	*
	* @param userName the user name of this dictionary
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_dictionary.setUserName(userName);
	}

	/**
	* Sets the user uuid of this dictionary.
	*
	* @param userUuid the user uuid of this dictionary
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dictionary.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this dictionary.
	*
	* @param uuid the uuid of this dictionary
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_dictionary.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictionaryWrapper)) {
			return false;
		}

		DictionaryWrapper dictionaryWrapper = (DictionaryWrapper)obj;

		if (Objects.equals(_dictionary, dictionaryWrapper._dictionary)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _dictionary.getStagedModelType();
	}

	@Override
	public Dictionary getWrappedModel() {
		return _dictionary;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dictionary.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dictionary.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dictionary.resetOriginalValues();
	}

	private final Dictionary _dictionary;
}