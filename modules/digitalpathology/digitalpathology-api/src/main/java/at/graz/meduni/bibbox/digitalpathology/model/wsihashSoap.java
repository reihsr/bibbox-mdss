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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.digitalpathology.service.http.wsihashServiceSoap}.
 *
 * @author robert
 * @see at.graz.meduni.bibbox.digitalpathology.service.http.wsihashServiceSoap
 * @generated
 */
@ProviderType
public class wsihashSoap implements Serializable {
	public static wsihashSoap toSoapModel(wsihash model) {
		wsihashSoap soapModel = new wsihashSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setWsihashId(model.getWsihashId());
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
		soapModel.setWsiId(model.getWsiId());
		soapModel.setFilename(model.getFilename());
		soapModel.setHash(model.getHash());

		return soapModel;
	}

	public static wsihashSoap[] toSoapModels(wsihash[] models) {
		wsihashSoap[] soapModels = new wsihashSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static wsihashSoap[][] toSoapModels(wsihash[][] models) {
		wsihashSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new wsihashSoap[models.length][models[0].length];
		}
		else {
			soapModels = new wsihashSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static wsihashSoap[] toSoapModels(List<wsihash> models) {
		List<wsihashSoap> soapModels = new ArrayList<wsihashSoap>(models.size());

		for (wsihash model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new wsihashSoap[soapModels.size()]);
	}

	public wsihashSoap() {
	}

	public long getPrimaryKey() {
		return _wsihashId;
	}

	public void setPrimaryKey(long pk) {
		setWsihashId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getWsihashId() {
		return _wsihashId;
	}

	public void setWsihashId(long wsihashId) {
		_wsihashId = wsihashId;
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

	public long getWsiId() {
		return _wsiId;
	}

	public void setWsiId(long wsiId) {
		_wsiId = wsiId;
	}

	public String getFilename() {
		return _filename;
	}

	public void setFilename(String filename) {
		_filename = filename;
	}

	public String getHash() {
		return _hash;
	}

	public void setHash(String hash) {
		_hash = hash;
	}

	private String _uuid;
	private long _wsihashId;
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
	private long _wsiId;
	private String _filename;
	private String _hash;
}