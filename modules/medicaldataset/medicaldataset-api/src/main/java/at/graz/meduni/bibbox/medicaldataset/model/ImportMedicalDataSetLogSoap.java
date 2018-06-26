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

package at.graz.meduni.bibbox.medicaldataset.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.medicaldataset.service.http.ImportMedicalDataSetLogServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.http.ImportMedicalDataSetLogServiceSoap
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetLogSoap implements Serializable {
	public static ImportMedicalDataSetLogSoap toSoapModel(
		ImportMedicalDataSetLog model) {
		ImportMedicalDataSetLogSoap soapModel = new ImportMedicalDataSetLogSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setImportMedicalDataSetLogId(model.getImportMedicalDataSetLogId());
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
		soapModel.setImportMedicalDataSetId(model.getImportMedicalDataSetId());
		soapModel.setImportStatus(model.getImportStatus());
		soapModel.setImportStatusLog(model.getImportStatusLog());

		return soapModel;
	}

	public static ImportMedicalDataSetLogSoap[] toSoapModels(
		ImportMedicalDataSetLog[] models) {
		ImportMedicalDataSetLogSoap[] soapModels = new ImportMedicalDataSetLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImportMedicalDataSetLogSoap[][] toSoapModels(
		ImportMedicalDataSetLog[][] models) {
		ImportMedicalDataSetLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImportMedicalDataSetLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImportMedicalDataSetLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImportMedicalDataSetLogSoap[] toSoapModels(
		List<ImportMedicalDataSetLog> models) {
		List<ImportMedicalDataSetLogSoap> soapModels = new ArrayList<ImportMedicalDataSetLogSoap>(models.size());

		for (ImportMedicalDataSetLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImportMedicalDataSetLogSoap[soapModels.size()]);
	}

	public ImportMedicalDataSetLogSoap() {
	}

	public long getPrimaryKey() {
		return _importMedicalDataSetLogId;
	}

	public void setPrimaryKey(long pk) {
		setImportMedicalDataSetLogId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getImportMedicalDataSetLogId() {
		return _importMedicalDataSetLogId;
	}

	public void setImportMedicalDataSetLogId(long importMedicalDataSetLogId) {
		_importMedicalDataSetLogId = importMedicalDataSetLogId;
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

	public long getImportMedicalDataSetId() {
		return _importMedicalDataSetId;
	}

	public void setImportMedicalDataSetId(long importMedicalDataSetId) {
		_importMedicalDataSetId = importMedicalDataSetId;
	}

	public int getImportStatus() {
		return _importStatus;
	}

	public void setImportStatus(int importStatus) {
		_importStatus = importStatus;
	}

	public String getImportStatusLog() {
		return _importStatusLog;
	}

	public void setImportStatusLog(String importStatusLog) {
		_importStatusLog = importStatusLog;
	}

	private String _uuid;
	private long _importMedicalDataSetLogId;
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
	private long _importMedicalDataSetId;
	private int _importStatus;
	private String _importStatusLog;
}