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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.informationprocessing.service.http.DictionaryServiceSoap}.
 *
 * @author robert
 * @see at.graz.meduni.bibbox.informationprocessing.service.http.DictionaryServiceSoap
 * @generated
 */
@ProviderType
public class DictionarySoap implements Serializable {
	public static DictionarySoap toSoapModel(Dictionary model) {
		DictionarySoap soapModel = new DictionarySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDictionaryId(model.getDictionaryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setSynonym(model.getSynonym());
		soapModel.setPattern(model.getPattern());
		soapModel.setCode(model.getCode());
		soapModel.setCode_type(model.getCode_type());
		soapModel.setCode_value(model.getCode_value());
		soapModel.setRoot(model.getRoot());
		soapModel.setNegation(model.getNegation());
		soapModel.setPriority(model.getPriority());
		soapModel.setPriority_mode(model.getPriority_mode());
		soapModel.setBefore_synonym(model.getBefore_synonym());
		soapModel.setAfter_synonym(model.getAfter_synonym());
		soapModel.setForeword(model.getForeword());
		soapModel.setEnding(model.getEnding());
		soapModel.setSentence(model.getSentence());
		soapModel.setOccure(model.getOccure());

		return soapModel;
	}

	public static DictionarySoap[] toSoapModels(Dictionary[] models) {
		DictionarySoap[] soapModels = new DictionarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DictionarySoap[][] toSoapModels(Dictionary[][] models) {
		DictionarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DictionarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DictionarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DictionarySoap[] toSoapModels(List<Dictionary> models) {
		List<DictionarySoap> soapModels = new ArrayList<DictionarySoap>(models.size());

		for (Dictionary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DictionarySoap[soapModels.size()]);
	}

	public DictionarySoap() {
	}

	public long getPrimaryKey() {
		return _dictionaryId;
	}

	public void setPrimaryKey(long pk) {
		setDictionaryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDictionaryId() {
		return _dictionaryId;
	}

	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getSynonym() {
		return _synonym;
	}

	public void setSynonym(String synonym) {
		_synonym = synonym;
	}

	public String getPattern() {
		return _pattern;
	}

	public void setPattern(String pattern) {
		_pattern = pattern;
	}

	public boolean getCode() {
		return _code;
	}

	public boolean isCode() {
		return _code;
	}

	public void setCode(boolean code) {
		_code = code;
	}

	public String getCode_type() {
		return _code_type;
	}

	public void setCode_type(String code_type) {
		_code_type = code_type;
	}

	public String getCode_value() {
		return _code_value;
	}

	public void setCode_value(String code_value) {
		_code_value = code_value;
	}

	public boolean getRoot() {
		return _root;
	}

	public boolean isRoot() {
		return _root;
	}

	public void setRoot(boolean root) {
		_root = root;
	}

	public boolean getNegation() {
		return _negation;
	}

	public boolean isNegation() {
		return _negation;
	}

	public void setNegation(boolean negation) {
		_negation = negation;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	public boolean getPriority_mode() {
		return _priority_mode;
	}

	public boolean isPriority_mode() {
		return _priority_mode;
	}

	public void setPriority_mode(boolean priority_mode) {
		_priority_mode = priority_mode;
	}

	public int getBefore_synonym() {
		return _before_synonym;
	}

	public void setBefore_synonym(int before_synonym) {
		_before_synonym = before_synonym;
	}

	public int getAfter_synonym() {
		return _after_synonym;
	}

	public void setAfter_synonym(int after_synonym) {
		_after_synonym = after_synonym;
	}

	public boolean getForeword() {
		return _foreword;
	}

	public boolean isForeword() {
		return _foreword;
	}

	public void setForeword(boolean foreword) {
		_foreword = foreword;
	}

	public boolean getEnding() {
		return _ending;
	}

	public boolean isEnding() {
		return _ending;
	}

	public void setEnding(boolean ending) {
		_ending = ending;
	}

	public boolean getSentence() {
		return _sentence;
	}

	public boolean isSentence() {
		return _sentence;
	}

	public void setSentence(boolean sentence) {
		_sentence = sentence;
	}

	public boolean getOccure() {
		return _occure;
	}

	public boolean isOccure() {
		return _occure;
	}

	public void setOccure(boolean occure) {
		_occure = occure;
	}

	private String _uuid;
	private long _dictionaryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _synonym;
	private String _pattern;
	private boolean _code;
	private String _code_type;
	private String _code_value;
	private boolean _root;
	private boolean _negation;
	private int _priority;
	private boolean _priority_mode;
	private int _before_synonym;
	private int _after_synonym;
	private boolean _foreword;
	private boolean _ending;
	private boolean _sentence;
	private boolean _occure;
}