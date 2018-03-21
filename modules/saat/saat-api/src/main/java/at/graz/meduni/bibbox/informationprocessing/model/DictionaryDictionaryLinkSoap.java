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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.informationprocessing.service.http.DictionaryDictionaryLinkServiceSoap}.
 *
 * @author robert
 * @see at.graz.meduni.bibbox.informationprocessing.service.http.DictionaryDictionaryLinkServiceSoap
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkSoap implements Serializable {
	public static DictionaryDictionaryLinkSoap toSoapModel(
		DictionaryDictionaryLink model) {
		DictionaryDictionaryLinkSoap soapModel = new DictionaryDictionaryLinkSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDictionarydictionarylinkId(model.getDictionarydictionarylinkId());
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
		soapModel.setDictionaryId(model.getDictionaryId());
		soapModel.setLinkdictionaryId(model.getLinkdictionaryId());

		return soapModel;
	}

	public static DictionaryDictionaryLinkSoap[] toSoapModels(
		DictionaryDictionaryLink[] models) {
		DictionaryDictionaryLinkSoap[] soapModels = new DictionaryDictionaryLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DictionaryDictionaryLinkSoap[][] toSoapModels(
		DictionaryDictionaryLink[][] models) {
		DictionaryDictionaryLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DictionaryDictionaryLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DictionaryDictionaryLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DictionaryDictionaryLinkSoap[] toSoapModels(
		List<DictionaryDictionaryLink> models) {
		List<DictionaryDictionaryLinkSoap> soapModels = new ArrayList<DictionaryDictionaryLinkSoap>(models.size());

		for (DictionaryDictionaryLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DictionaryDictionaryLinkSoap[soapModels.size()]);
	}

	public DictionaryDictionaryLinkSoap() {
	}

	public long getPrimaryKey() {
		return _dictionarydictionarylinkId;
	}

	public void setPrimaryKey(long pk) {
		setDictionarydictionarylinkId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDictionarydictionarylinkId() {
		return _dictionarydictionarylinkId;
	}

	public void setDictionarydictionarylinkId(long dictionarydictionarylinkId) {
		_dictionarydictionarylinkId = dictionarydictionarylinkId;
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

	public long getDictionaryId() {
		return _dictionaryId;
	}

	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;
	}

	public long getLinkdictionaryId() {
		return _linkdictionaryId;
	}

	public void setLinkdictionaryId(long linkdictionaryId) {
		_linkdictionaryId = linkdictionaryId;
	}

	private String _uuid;
	private long _dictionarydictionarylinkId;
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
	private long _dictionaryId;
	private long _linkdictionaryId;
}