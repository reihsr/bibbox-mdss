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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.medicaldataset.service.http.MedicalRecordServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.http.MedicalRecordServiceSoap
 * @generated
 */
@ProviderType
public class MedicalRecordSoap implements Serializable {
	public static MedicalRecordSoap toSoapModel(MedicalRecord model) {
		MedicalRecordSoap soapModel = new MedicalRecordSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMedicalRecordId(model.getMedicalRecordId());
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
		soapModel.setHistonumberStart(model.getHistonumberStart());
		soapModel.setHistonumberEnd(model.getHistonumberEnd());
		soapModel.setHistonumberRunning(model.getHistonumberRunning());
		soapModel.setINumber(model.getINumber());
		soapModel.setVPatientId(model.getVPatientId());
		soapModel.setVHistonNumber(model.getVHistonNumber());
		soapModel.setArea(model.getArea());

		return soapModel;
	}

	public static MedicalRecordSoap[] toSoapModels(MedicalRecord[] models) {
		MedicalRecordSoap[] soapModels = new MedicalRecordSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MedicalRecordSoap[][] toSoapModels(MedicalRecord[][] models) {
		MedicalRecordSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MedicalRecordSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MedicalRecordSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MedicalRecordSoap[] toSoapModels(List<MedicalRecord> models) {
		List<MedicalRecordSoap> soapModels = new ArrayList<MedicalRecordSoap>(models.size());

		for (MedicalRecord model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MedicalRecordSoap[soapModels.size()]);
	}

	public MedicalRecordSoap() {
	}

	public long getPrimaryKey() {
		return _medicalRecordId;
	}

	public void setPrimaryKey(long pk) {
		setMedicalRecordId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMedicalRecordId() {
		return _medicalRecordId;
	}

	public void setMedicalRecordId(long medicalRecordId) {
		_medicalRecordId = medicalRecordId;
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

	public long getHistonumberStart() {
		return _histonumberStart;
	}

	public void setHistonumberStart(long histonumberStart) {
		_histonumberStart = histonumberStart;
	}

	public long getHistonumberEnd() {
		return _histonumberEnd;
	}

	public void setHistonumberEnd(long histonumberEnd) {
		_histonumberEnd = histonumberEnd;
	}

	public int getHistonumberRunning() {
		return _histonumberRunning;
	}

	public void setHistonumberRunning(int histonumberRunning) {
		_histonumberRunning = histonumberRunning;
	}

	public long getINumber() {
		return _iNumber;
	}

	public void setINumber(long iNumber) {
		_iNumber = iNumber;
	}

	public long getVPatientId() {
		return _vPatientId;
	}

	public void setVPatientId(long vPatientId) {
		_vPatientId = vPatientId;
	}

	public long getVHistonNumber() {
		return _vHistonNumber;
	}

	public void setVHistonNumber(long vHistonNumber) {
		_vHistonNumber = vHistonNumber;
	}

	public String getArea() {
		return _area;
	}

	public void setArea(String area) {
		_area = area;
	}

	private String _uuid;
	private long _medicalRecordId;
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
	private long _histonumberStart;
	private long _histonumberEnd;
	private int _histonumberRunning;
	private long _iNumber;
	private long _vPatientId;
	private long _vHistonNumber;
	private String _area;
}