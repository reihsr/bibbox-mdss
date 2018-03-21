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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.medicaldataset.service.http.KloetzelBuchServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.http.KloetzelBuchServiceSoap
 * @generated
 */
@ProviderType
public class KloetzelBuchSoap implements Serializable {
	public static KloetzelBuchSoap toSoapModel(KloetzelBuch model) {
		KloetzelBuchSoap soapModel = new KloetzelBuchSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setKloetzelBuchId(model.getKloetzelBuchId());
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
		soapModel.setMedicalRecordId(model.getMedicalRecordId());
		soapModel.setHistonumberStart(model.getHistonumberStart());
		soapModel.setHistonumberEnd(model.getHistonumberEnd());
		soapModel.setHistonumberRunning(model.getHistonumberRunning());
		soapModel.setHistonumber(model.getHistonumber());
		soapModel.setKloetzelBuchRunning(model.getKloetzelBuchRunning());
		soapModel.setOid(model.getOid());
		soapModel.setBid(model.getBid());
		soapModel.setArea(model.getArea());
		soapModel.setType(model.getType());
		soapModel.setAcronym(model.getAcronym());
		soapModel.setText(model.getText());
		soapModel.setInfo(model.getInfo());
		soapModel.setCount(model.getCount());
		soapModel.setNumberOfPieces(model.getNumberOfPieces());
		soapModel.setKbStatus(model.getKbStatus());
		soapModel.setSort(model.getSort());
		soapModel.setColor(model.getColor());
		soapModel.setKbDate(model.getKbDate());
		soapModel.setDay(model.getDay());
		soapModel.setPocessinguser(model.getPocessinguser());
		soapModel.setOrganizationUnit(model.getOrganizationUnit());

		return soapModel;
	}

	public static KloetzelBuchSoap[] toSoapModels(KloetzelBuch[] models) {
		KloetzelBuchSoap[] soapModels = new KloetzelBuchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KloetzelBuchSoap[][] toSoapModels(KloetzelBuch[][] models) {
		KloetzelBuchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KloetzelBuchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KloetzelBuchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KloetzelBuchSoap[] toSoapModels(List<KloetzelBuch> models) {
		List<KloetzelBuchSoap> soapModels = new ArrayList<KloetzelBuchSoap>(models.size());

		for (KloetzelBuch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KloetzelBuchSoap[soapModels.size()]);
	}

	public KloetzelBuchSoap() {
	}

	public long getPrimaryKey() {
		return _kloetzelBuchId;
	}

	public void setPrimaryKey(long pk) {
		setKloetzelBuchId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getKloetzelBuchId() {
		return _kloetzelBuchId;
	}

	public void setKloetzelBuchId(long kloetzelBuchId) {
		_kloetzelBuchId = kloetzelBuchId;
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

	public long getMedicalRecordId() {
		return _medicalRecordId;
	}

	public void setMedicalRecordId(long medicalRecordId) {
		_medicalRecordId = medicalRecordId;
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

	public long getHistonumber() {
		return _histonumber;
	}

	public void setHistonumber(long histonumber) {
		_histonumber = histonumber;
	}

	public int getKloetzelBuchRunning() {
		return _kloetzelBuchRunning;
	}

	public void setKloetzelBuchRunning(int kloetzelBuchRunning) {
		_kloetzelBuchRunning = kloetzelBuchRunning;
	}

	public String getOid() {
		return _oid;
	}

	public void setOid(String oid) {
		_oid = oid;
	}

	public String getBid() {
		return _bid;
	}

	public void setBid(String bid) {
		_bid = bid;
	}

	public String getArea() {
		return _area;
	}

	public void setArea(String area) {
		_area = area;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getAcronym() {
		return _acronym;
	}

	public void setAcronym(String acronym) {
		_acronym = acronym;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public String getInfo() {
		return _info;
	}

	public void setInfo(String info) {
		_info = info;
	}

	public int getCount() {
		return _count;
	}

	public void setCount(int count) {
		_count = count;
	}

	public int getNumberOfPieces() {
		return _numberOfPieces;
	}

	public void setNumberOfPieces(int numberOfPieces) {
		_numberOfPieces = numberOfPieces;
	}

	public int getKbStatus() {
		return _kbStatus;
	}

	public void setKbStatus(int kbStatus) {
		_kbStatus = kbStatus;
	}

	public int getSort() {
		return _sort;
	}

	public void setSort(int sort) {
		_sort = sort;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	public Date getKbDate() {
		return _kbDate;
	}

	public void setKbDate(Date kbDate) {
		_kbDate = kbDate;
	}

	public String getDay() {
		return _day;
	}

	public void setDay(String day) {
		_day = day;
	}

	public String getPocessinguser() {
		return _pocessinguser;
	}

	public void setPocessinguser(String pocessinguser) {
		_pocessinguser = pocessinguser;
	}

	public String getOrganizationUnit() {
		return _organizationUnit;
	}

	public void setOrganizationUnit(String organizationUnit) {
		_organizationUnit = organizationUnit;
	}

	private String _uuid;
	private long _kloetzelBuchId;
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
	private long _medicalRecordId;
	private long _histonumberStart;
	private long _histonumberEnd;
	private int _histonumberRunning;
	private long _histonumber;
	private int _kloetzelBuchRunning;
	private String _oid;
	private String _bid;
	private String _area;
	private String _type;
	private String _acronym;
	private String _text;
	private String _info;
	private int _count;
	private int _numberOfPieces;
	private int _kbStatus;
	private int _sort;
	private String _color;
	private Date _kbDate;
	private String _day;
	private String _pocessinguser;
	private String _organizationUnit;
}