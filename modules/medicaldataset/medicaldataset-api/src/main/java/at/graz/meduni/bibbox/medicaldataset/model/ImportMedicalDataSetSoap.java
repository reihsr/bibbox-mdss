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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.medicaldataset.service.http.ImportMedicalDataSetServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.http.ImportMedicalDataSetServiceSoap
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetSoap implements Serializable {
	public static ImportMedicalDataSetSoap toSoapModel(
		ImportMedicalDataSet model) {
		ImportMedicalDataSetSoap soapModel = new ImportMedicalDataSetSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setImportMedicalDataSetId(model.getImportMedicalDataSetId());
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
		soapModel.setImportName(model.getImportName());
		soapModel.setImportType(model.getImportType());
		soapModel.setImiJobId(model.getImiJobId());
		soapModel.setDescription(model.getDescription());
		soapModel.setFileName(model.getFileName());
		soapModel.setFilePath(model.getFilePath());
		soapModel.setFileId(model.getFileId());
		soapModel.setImportStatus(model.getImportStatus());

		return soapModel;
	}

	public static ImportMedicalDataSetSoap[] toSoapModels(
		ImportMedicalDataSet[] models) {
		ImportMedicalDataSetSoap[] soapModels = new ImportMedicalDataSetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImportMedicalDataSetSoap[][] toSoapModels(
		ImportMedicalDataSet[][] models) {
		ImportMedicalDataSetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImportMedicalDataSetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImportMedicalDataSetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImportMedicalDataSetSoap[] toSoapModels(
		List<ImportMedicalDataSet> models) {
		List<ImportMedicalDataSetSoap> soapModels = new ArrayList<ImportMedicalDataSetSoap>(models.size());

		for (ImportMedicalDataSet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImportMedicalDataSetSoap[soapModels.size()]);
	}

	public ImportMedicalDataSetSoap() {
	}

	public long getPrimaryKey() {
		return _importMedicalDataSetId;
	}

	public void setPrimaryKey(long pk) {
		setImportMedicalDataSetId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getImportMedicalDataSetId() {
		return _importMedicalDataSetId;
	}

	public void setImportMedicalDataSetId(long importMedicalDataSetId) {
		_importMedicalDataSetId = importMedicalDataSetId;
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

	public String getImportName() {
		return _importName;
	}

	public void setImportName(String importName) {
		_importName = importName;
	}

	public String getImportType() {
		return _importType;
	}

	public void setImportType(String importType) {
		_importType = importType;
	}

	public long getImiJobId() {
		return _imiJobId;
	}

	public void setImiJobId(long imiJobId) {
		_imiJobId = imiJobId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getFilePath() {
		return _filePath;
	}

	public void setFilePath(String filePath) {
		_filePath = filePath;
	}

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public int getImportStatus() {
		return _importStatus;
	}

	public void setImportStatus(int importStatus) {
		_importStatus = importStatus;
	}

	private String _uuid;
	private long _importMedicalDataSetId;
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
	private String _importName;
	private String _importType;
	private long _imiJobId;
	private String _description;
	private String _fileName;
	private String _filePath;
	private long _fileId;
	private int _importStatus;
}