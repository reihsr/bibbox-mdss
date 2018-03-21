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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.digitalpathology.service.http.wsiServiceSoap}.
 *
 * @author robert
 * @see at.graz.meduni.bibbox.digitalpathology.service.http.wsiServiceSoap
 * @generated
 */
@ProviderType
public class wsiSoap implements Serializable {
	public static wsiSoap toSoapModel(wsi model) {
		wsiSoap soapModel = new wsiSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setWsiId(model.getWsiId());
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
		soapModel.setFilename(model.getFilename());
		soapModel.setHashmrxs(model.getHashmrxs());
		soapModel.setScanstart(model.getScanstart());
		soapModel.setScanduration(model.getScanduration());

		return soapModel;
	}

	public static wsiSoap[] toSoapModels(wsi[] models) {
		wsiSoap[] soapModels = new wsiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static wsiSoap[][] toSoapModels(wsi[][] models) {
		wsiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new wsiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new wsiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static wsiSoap[] toSoapModels(List<wsi> models) {
		List<wsiSoap> soapModels = new ArrayList<wsiSoap>(models.size());

		for (wsi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new wsiSoap[soapModels.size()]);
	}

	public wsiSoap() {
	}

	public long getPrimaryKey() {
		return _wsiId;
	}

	public void setPrimaryKey(long pk) {
		setWsiId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getWsiId() {
		return _wsiId;
	}

	public void setWsiId(long wsiId) {
		_wsiId = wsiId;
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

	public String getFilename() {
		return _filename;
	}

	public void setFilename(String filename) {
		_filename = filename;
	}

	public String getHashmrxs() {
		return _hashmrxs;
	}

	public void setHashmrxs(String hashmrxs) {
		_hashmrxs = hashmrxs;
	}

	public Date getScanstart() {
		return _scanstart;
	}

	public void setScanstart(Date scanstart) {
		_scanstart = scanstart;
	}

	public long getScanduration() {
		return _scanduration;
	}

	public void setScanduration(long scanduration) {
		_scanduration = scanduration;
	}

	private String _uuid;
	private long _wsiId;
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
	private String _filename;
	private String _hashmrxs;
	private Date _scanstart;
	private long _scanduration;
}