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
 * This class is a wrapper for {@link KloetzelBuch}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KloetzelBuch
 * @generated
 */
@ProviderType
public class KloetzelBuchWrapper implements KloetzelBuch,
	ModelWrapper<KloetzelBuch> {
	public KloetzelBuchWrapper(KloetzelBuch kloetzelBuch) {
		_kloetzelBuch = kloetzelBuch;
	}

	@Override
	public Class<?> getModelClass() {
		return KloetzelBuch.class;
	}

	@Override
	public String getModelClassName() {
		return KloetzelBuch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("kloetzelBuchId", getKloetzelBuchId());
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
		attributes.put("medicalRecordId", getMedicalRecordId());
		attributes.put("histonumberStart", getHistonumberStart());
		attributes.put("histonumberEnd", getHistonumberEnd());
		attributes.put("histonumberRunning", getHistonumberRunning());
		attributes.put("histonumber", getHistonumber());
		attributes.put("kloetzelBuchRunning", getKloetzelBuchRunning());
		attributes.put("oid", getOid());
		attributes.put("bid", getBid());
		attributes.put("area", getArea());
		attributes.put("type", getType());
		attributes.put("acronym", getAcronym());
		attributes.put("text", getText());
		attributes.put("info", getInfo());
		attributes.put("count", getCount());
		attributes.put("numberOfPieces", getNumberOfPieces());
		attributes.put("kbStatus", getKbStatus());
		attributes.put("sort", getSort());
		attributes.put("color", getColor());
		attributes.put("kbDate", getKbDate());
		attributes.put("day", getDay());
		attributes.put("pocessinguser", getPocessinguser());
		attributes.put("organizationUnit", getOrganizationUnit());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long kloetzelBuchId = (Long)attributes.get("kloetzelBuchId");

		if (kloetzelBuchId != null) {
			setKloetzelBuchId(kloetzelBuchId);
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

		Long medicalRecordId = (Long)attributes.get("medicalRecordId");

		if (medicalRecordId != null) {
			setMedicalRecordId(medicalRecordId);
		}

		Long histonumberStart = (Long)attributes.get("histonumberStart");

		if (histonumberStart != null) {
			setHistonumberStart(histonumberStart);
		}

		Long histonumberEnd = (Long)attributes.get("histonumberEnd");

		if (histonumberEnd != null) {
			setHistonumberEnd(histonumberEnd);
		}

		Integer histonumberRunning = (Integer)attributes.get(
				"histonumberRunning");

		if (histonumberRunning != null) {
			setHistonumberRunning(histonumberRunning);
		}

		Long histonumber = (Long)attributes.get("histonumber");

		if (histonumber != null) {
			setHistonumber(histonumber);
		}

		Integer kloetzelBuchRunning = (Integer)attributes.get(
				"kloetzelBuchRunning");

		if (kloetzelBuchRunning != null) {
			setKloetzelBuchRunning(kloetzelBuchRunning);
		}

		String oid = (String)attributes.get("oid");

		if (oid != null) {
			setOid(oid);
		}

		String bid = (String)attributes.get("bid");

		if (bid != null) {
			setBid(bid);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String acronym = (String)attributes.get("acronym");

		if (acronym != null) {
			setAcronym(acronym);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}

		String info = (String)attributes.get("info");

		if (info != null) {
			setInfo(info);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		Integer numberOfPieces = (Integer)attributes.get("numberOfPieces");

		if (numberOfPieces != null) {
			setNumberOfPieces(numberOfPieces);
		}

		Integer kbStatus = (Integer)attributes.get("kbStatus");

		if (kbStatus != null) {
			setKbStatus(kbStatus);
		}

		Integer sort = (Integer)attributes.get("sort");

		if (sort != null) {
			setSort(sort);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		Date kbDate = (Date)attributes.get("kbDate");

		if (kbDate != null) {
			setKbDate(kbDate);
		}

		String day = (String)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		String pocessinguser = (String)attributes.get("pocessinguser");

		if (pocessinguser != null) {
			setPocessinguser(pocessinguser);
		}

		String organizationUnit = (String)attributes.get("organizationUnit");

		if (organizationUnit != null) {
			setOrganizationUnit(organizationUnit);
		}
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch toEscapedModel() {
		return new KloetzelBuchWrapper(_kloetzelBuch.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch toUnescapedModel() {
		return new KloetzelBuchWrapper(_kloetzelBuch.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this kloetzel buch is approved.
	*
	* @return <code>true</code> if this kloetzel buch is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _kloetzelBuch.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _kloetzelBuch.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this kloetzel buch is denied.
	*
	* @return <code>true</code> if this kloetzel buch is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _kloetzelBuch.isDenied();
	}

	/**
	* Returns <code>true</code> if this kloetzel buch is a draft.
	*
	* @return <code>true</code> if this kloetzel buch is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _kloetzelBuch.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _kloetzelBuch.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this kloetzel buch is expired.
	*
	* @return <code>true</code> if this kloetzel buch is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _kloetzelBuch.isExpired();
	}

	/**
	* Returns <code>true</code> if this kloetzel buch is inactive.
	*
	* @return <code>true</code> if this kloetzel buch is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _kloetzelBuch.isInactive();
	}

	/**
	* Returns <code>true</code> if this kloetzel buch is incomplete.
	*
	* @return <code>true</code> if this kloetzel buch is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _kloetzelBuch.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _kloetzelBuch.isNew();
	}

	/**
	* Returns <code>true</code> if this kloetzel buch is pending.
	*
	* @return <code>true</code> if this kloetzel buch is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _kloetzelBuch.isPending();
	}

	/**
	* Returns <code>true</code> if this kloetzel buch is scheduled.
	*
	* @return <code>true</code> if this kloetzel buch is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _kloetzelBuch.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _kloetzelBuch.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch> toCacheModel() {
		return _kloetzelBuch.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch kloetzelBuch) {
		return _kloetzelBuch.compareTo(kloetzelBuch);
	}

	/**
	* Returns the count of this kloetzel buch.
	*
	* @return the count of this kloetzel buch
	*/
	@Override
	public int getCount() {
		return _kloetzelBuch.getCount();
	}

	/**
	* Returns the histonumber running of this kloetzel buch.
	*
	* @return the histonumber running of this kloetzel buch
	*/
	@Override
	public int getHistonumberRunning() {
		return _kloetzelBuch.getHistonumberRunning();
	}

	/**
	* Returns the kb status of this kloetzel buch.
	*
	* @return the kb status of this kloetzel buch
	*/
	@Override
	public int getKbStatus() {
		return _kloetzelBuch.getKbStatus();
	}

	/**
	* Returns the kloetzel buch running of this kloetzel buch.
	*
	* @return the kloetzel buch running of this kloetzel buch
	*/
	@Override
	public int getKloetzelBuchRunning() {
		return _kloetzelBuch.getKloetzelBuchRunning();
	}

	/**
	* Returns the number of pieces of this kloetzel buch.
	*
	* @return the number of pieces of this kloetzel buch
	*/
	@Override
	public int getNumberOfPieces() {
		return _kloetzelBuch.getNumberOfPieces();
	}

	/**
	* Returns the sort of this kloetzel buch.
	*
	* @return the sort of this kloetzel buch
	*/
	@Override
	public int getSort() {
		return _kloetzelBuch.getSort();
	}

	/**
	* Returns the status of this kloetzel buch.
	*
	* @return the status of this kloetzel buch
	*/
	@Override
	public int getStatus() {
		return _kloetzelBuch.getStatus();
	}

	@Override
	public int hashCode() {
		return _kloetzelBuch.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kloetzelBuch.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new KloetzelBuchWrapper((KloetzelBuch)_kloetzelBuch.clone());
	}

	/**
	* Returns the acronym of this kloetzel buch.
	*
	* @return the acronym of this kloetzel buch
	*/
	@Override
	public java.lang.String getAcronym() {
		return _kloetzelBuch.getAcronym();
	}

	/**
	* Returns the area of this kloetzel buch.
	*
	* @return the area of this kloetzel buch
	*/
	@Override
	public java.lang.String getArea() {
		return _kloetzelBuch.getArea();
	}

	/**
	* Returns the bid of this kloetzel buch.
	*
	* @return the bid of this kloetzel buch
	*/
	@Override
	public java.lang.String getBid() {
		return _kloetzelBuch.getBid();
	}

	/**
	* Returns the color of this kloetzel buch.
	*
	* @return the color of this kloetzel buch
	*/
	@Override
	public java.lang.String getColor() {
		return _kloetzelBuch.getColor();
	}

	/**
	* Returns the day of this kloetzel buch.
	*
	* @return the day of this kloetzel buch
	*/
	@Override
	public java.lang.String getDay() {
		return _kloetzelBuch.getDay();
	}

	/**
	* Returns the info of this kloetzel buch.
	*
	* @return the info of this kloetzel buch
	*/
	@Override
	public java.lang.String getInfo() {
		return _kloetzelBuch.getInfo();
	}

	/**
	* Returns the oid of this kloetzel buch.
	*
	* @return the oid of this kloetzel buch
	*/
	@Override
	public java.lang.String getOid() {
		return _kloetzelBuch.getOid();
	}

	/**
	* Returns the organization unit of this kloetzel buch.
	*
	* @return the organization unit of this kloetzel buch
	*/
	@Override
	public java.lang.String getOrganizationUnit() {
		return _kloetzelBuch.getOrganizationUnit();
	}

	/**
	* Returns the pocessinguser of this kloetzel buch.
	*
	* @return the pocessinguser of this kloetzel buch
	*/
	@Override
	public java.lang.String getPocessinguser() {
		return _kloetzelBuch.getPocessinguser();
	}

	/**
	* Returns the status by user name of this kloetzel buch.
	*
	* @return the status by user name of this kloetzel buch
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _kloetzelBuch.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this kloetzel buch.
	*
	* @return the status by user uuid of this kloetzel buch
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _kloetzelBuch.getStatusByUserUuid();
	}

	/**
	* Returns the text of this kloetzel buch.
	*
	* @return the text of this kloetzel buch
	*/
	@Override
	public java.lang.String getText() {
		return _kloetzelBuch.getText();
	}

	/**
	* Returns the type of this kloetzel buch.
	*
	* @return the type of this kloetzel buch
	*/
	@Override
	public java.lang.String getType() {
		return _kloetzelBuch.getType();
	}

	/**
	* Returns the user name of this kloetzel buch.
	*
	* @return the user name of this kloetzel buch
	*/
	@Override
	public java.lang.String getUserName() {
		return _kloetzelBuch.getUserName();
	}

	/**
	* Returns the user uuid of this kloetzel buch.
	*
	* @return the user uuid of this kloetzel buch
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _kloetzelBuch.getUserUuid();
	}

	/**
	* Returns the uuid of this kloetzel buch.
	*
	* @return the uuid of this kloetzel buch
	*/
	@Override
	public java.lang.String getUuid() {
		return _kloetzelBuch.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _kloetzelBuch.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kloetzelBuch.toXmlString();
	}

	/**
	* Returns the create date of this kloetzel buch.
	*
	* @return the create date of this kloetzel buch
	*/
	@Override
	public Date getCreateDate() {
		return _kloetzelBuch.getCreateDate();
	}

	/**
	* Returns the kb date of this kloetzel buch.
	*
	* @return the kb date of this kloetzel buch
	*/
	@Override
	public Date getKbDate() {
		return _kloetzelBuch.getKbDate();
	}

	/**
	* Returns the modified date of this kloetzel buch.
	*
	* @return the modified date of this kloetzel buch
	*/
	@Override
	public Date getModifiedDate() {
		return _kloetzelBuch.getModifiedDate();
	}

	/**
	* Returns the status date of this kloetzel buch.
	*
	* @return the status date of this kloetzel buch
	*/
	@Override
	public Date getStatusDate() {
		return _kloetzelBuch.getStatusDate();
	}

	/**
	* Returns the company ID of this kloetzel buch.
	*
	* @return the company ID of this kloetzel buch
	*/
	@Override
	public long getCompanyId() {
		return _kloetzelBuch.getCompanyId();
	}

	/**
	* Returns the group ID of this kloetzel buch.
	*
	* @return the group ID of this kloetzel buch
	*/
	@Override
	public long getGroupId() {
		return _kloetzelBuch.getGroupId();
	}

	/**
	* Returns the histonumber of this kloetzel buch.
	*
	* @return the histonumber of this kloetzel buch
	*/
	@Override
	public long getHistonumber() {
		return _kloetzelBuch.getHistonumber();
	}

	/**
	* Returns the histonumber end of this kloetzel buch.
	*
	* @return the histonumber end of this kloetzel buch
	*/
	@Override
	public long getHistonumberEnd() {
		return _kloetzelBuch.getHistonumberEnd();
	}

	/**
	* Returns the histonumber start of this kloetzel buch.
	*
	* @return the histonumber start of this kloetzel buch
	*/
	@Override
	public long getHistonumberStart() {
		return _kloetzelBuch.getHistonumberStart();
	}

	/**
	* Returns the kloetzel buch ID of this kloetzel buch.
	*
	* @return the kloetzel buch ID of this kloetzel buch
	*/
	@Override
	public long getKloetzelBuchId() {
		return _kloetzelBuch.getKloetzelBuchId();
	}

	/**
	* Returns the medical record ID of this kloetzel buch.
	*
	* @return the medical record ID of this kloetzel buch
	*/
	@Override
	public long getMedicalRecordId() {
		return _kloetzelBuch.getMedicalRecordId();
	}

	/**
	* Returns the primary key of this kloetzel buch.
	*
	* @return the primary key of this kloetzel buch
	*/
	@Override
	public long getPrimaryKey() {
		return _kloetzelBuch.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this kloetzel buch.
	*
	* @return the status by user ID of this kloetzel buch
	*/
	@Override
	public long getStatusByUserId() {
		return _kloetzelBuch.getStatusByUserId();
	}

	/**
	* Returns the user ID of this kloetzel buch.
	*
	* @return the user ID of this kloetzel buch
	*/
	@Override
	public long getUserId() {
		return _kloetzelBuch.getUserId();
	}

	@Override
	public void persist() {
		_kloetzelBuch.persist();
	}

	/**
	* Sets the acronym of this kloetzel buch.
	*
	* @param acronym the acronym of this kloetzel buch
	*/
	@Override
	public void setAcronym(java.lang.String acronym) {
		_kloetzelBuch.setAcronym(acronym);
	}

	/**
	* Sets the area of this kloetzel buch.
	*
	* @param area the area of this kloetzel buch
	*/
	@Override
	public void setArea(java.lang.String area) {
		_kloetzelBuch.setArea(area);
	}

	/**
	* Sets the bid of this kloetzel buch.
	*
	* @param bid the bid of this kloetzel buch
	*/
	@Override
	public void setBid(java.lang.String bid) {
		_kloetzelBuch.setBid(bid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kloetzelBuch.setCachedModel(cachedModel);
	}

	/**
	* Sets the color of this kloetzel buch.
	*
	* @param color the color of this kloetzel buch
	*/
	@Override
	public void setColor(java.lang.String color) {
		_kloetzelBuch.setColor(color);
	}

	/**
	* Sets the company ID of this kloetzel buch.
	*
	* @param companyId the company ID of this kloetzel buch
	*/
	@Override
	public void setCompanyId(long companyId) {
		_kloetzelBuch.setCompanyId(companyId);
	}

	/**
	* Sets the count of this kloetzel buch.
	*
	* @param count the count of this kloetzel buch
	*/
	@Override
	public void setCount(int count) {
		_kloetzelBuch.setCount(count);
	}

	/**
	* Sets the create date of this kloetzel buch.
	*
	* @param createDate the create date of this kloetzel buch
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_kloetzelBuch.setCreateDate(createDate);
	}

	/**
	* Sets the day of this kloetzel buch.
	*
	* @param day the day of this kloetzel buch
	*/
	@Override
	public void setDay(java.lang.String day) {
		_kloetzelBuch.setDay(day);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_kloetzelBuch.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_kloetzelBuch.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_kloetzelBuch.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this kloetzel buch.
	*
	* @param groupId the group ID of this kloetzel buch
	*/
	@Override
	public void setGroupId(long groupId) {
		_kloetzelBuch.setGroupId(groupId);
	}

	/**
	* Sets the histonumber of this kloetzel buch.
	*
	* @param histonumber the histonumber of this kloetzel buch
	*/
	@Override
	public void setHistonumber(long histonumber) {
		_kloetzelBuch.setHistonumber(histonumber);
	}

	/**
	* Sets the histonumber end of this kloetzel buch.
	*
	* @param histonumberEnd the histonumber end of this kloetzel buch
	*/
	@Override
	public void setHistonumberEnd(long histonumberEnd) {
		_kloetzelBuch.setHistonumberEnd(histonumberEnd);
	}

	/**
	* Sets the histonumber running of this kloetzel buch.
	*
	* @param histonumberRunning the histonumber running of this kloetzel buch
	*/
	@Override
	public void setHistonumberRunning(int histonumberRunning) {
		_kloetzelBuch.setHistonumberRunning(histonumberRunning);
	}

	/**
	* Sets the histonumber start of this kloetzel buch.
	*
	* @param histonumberStart the histonumber start of this kloetzel buch
	*/
	@Override
	public void setHistonumberStart(long histonumberStart) {
		_kloetzelBuch.setHistonumberStart(histonumberStart);
	}

	/**
	* Sets the info of this kloetzel buch.
	*
	* @param info the info of this kloetzel buch
	*/
	@Override
	public void setInfo(java.lang.String info) {
		_kloetzelBuch.setInfo(info);
	}

	/**
	* Sets the kb date of this kloetzel buch.
	*
	* @param kbDate the kb date of this kloetzel buch
	*/
	@Override
	public void setKbDate(Date kbDate) {
		_kloetzelBuch.setKbDate(kbDate);
	}

	/**
	* Sets the kb status of this kloetzel buch.
	*
	* @param kbStatus the kb status of this kloetzel buch
	*/
	@Override
	public void setKbStatus(int kbStatus) {
		_kloetzelBuch.setKbStatus(kbStatus);
	}

	/**
	* Sets the kloetzel buch ID of this kloetzel buch.
	*
	* @param kloetzelBuchId the kloetzel buch ID of this kloetzel buch
	*/
	@Override
	public void setKloetzelBuchId(long kloetzelBuchId) {
		_kloetzelBuch.setKloetzelBuchId(kloetzelBuchId);
	}

	/**
	* Sets the kloetzel buch running of this kloetzel buch.
	*
	* @param kloetzelBuchRunning the kloetzel buch running of this kloetzel buch
	*/
	@Override
	public void setKloetzelBuchRunning(int kloetzelBuchRunning) {
		_kloetzelBuch.setKloetzelBuchRunning(kloetzelBuchRunning);
	}

	/**
	* Sets the medical record ID of this kloetzel buch.
	*
	* @param medicalRecordId the medical record ID of this kloetzel buch
	*/
	@Override
	public void setMedicalRecordId(long medicalRecordId) {
		_kloetzelBuch.setMedicalRecordId(medicalRecordId);
	}

	/**
	* Sets the modified date of this kloetzel buch.
	*
	* @param modifiedDate the modified date of this kloetzel buch
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_kloetzelBuch.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_kloetzelBuch.setNew(n);
	}

	/**
	* Sets the number of pieces of this kloetzel buch.
	*
	* @param numberOfPieces the number of pieces of this kloetzel buch
	*/
	@Override
	public void setNumberOfPieces(int numberOfPieces) {
		_kloetzelBuch.setNumberOfPieces(numberOfPieces);
	}

	/**
	* Sets the oid of this kloetzel buch.
	*
	* @param oid the oid of this kloetzel buch
	*/
	@Override
	public void setOid(java.lang.String oid) {
		_kloetzelBuch.setOid(oid);
	}

	/**
	* Sets the organization unit of this kloetzel buch.
	*
	* @param organizationUnit the organization unit of this kloetzel buch
	*/
	@Override
	public void setOrganizationUnit(java.lang.String organizationUnit) {
		_kloetzelBuch.setOrganizationUnit(organizationUnit);
	}

	/**
	* Sets the pocessinguser of this kloetzel buch.
	*
	* @param pocessinguser the pocessinguser of this kloetzel buch
	*/
	@Override
	public void setPocessinguser(java.lang.String pocessinguser) {
		_kloetzelBuch.setPocessinguser(pocessinguser);
	}

	/**
	* Sets the primary key of this kloetzel buch.
	*
	* @param primaryKey the primary key of this kloetzel buch
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kloetzelBuch.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_kloetzelBuch.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sort of this kloetzel buch.
	*
	* @param sort the sort of this kloetzel buch
	*/
	@Override
	public void setSort(int sort) {
		_kloetzelBuch.setSort(sort);
	}

	/**
	* Sets the status of this kloetzel buch.
	*
	* @param status the status of this kloetzel buch
	*/
	@Override
	public void setStatus(int status) {
		_kloetzelBuch.setStatus(status);
	}

	/**
	* Sets the status by user ID of this kloetzel buch.
	*
	* @param statusByUserId the status by user ID of this kloetzel buch
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_kloetzelBuch.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this kloetzel buch.
	*
	* @param statusByUserName the status by user name of this kloetzel buch
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_kloetzelBuch.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this kloetzel buch.
	*
	* @param statusByUserUuid the status by user uuid of this kloetzel buch
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_kloetzelBuch.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this kloetzel buch.
	*
	* @param statusDate the status date of this kloetzel buch
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_kloetzelBuch.setStatusDate(statusDate);
	}

	/**
	* Sets the text of this kloetzel buch.
	*
	* @param text the text of this kloetzel buch
	*/
	@Override
	public void setText(java.lang.String text) {
		_kloetzelBuch.setText(text);
	}

	/**
	* Sets the type of this kloetzel buch.
	*
	* @param type the type of this kloetzel buch
	*/
	@Override
	public void setType(java.lang.String type) {
		_kloetzelBuch.setType(type);
	}

	/**
	* Sets the user ID of this kloetzel buch.
	*
	* @param userId the user ID of this kloetzel buch
	*/
	@Override
	public void setUserId(long userId) {
		_kloetzelBuch.setUserId(userId);
	}

	/**
	* Sets the user name of this kloetzel buch.
	*
	* @param userName the user name of this kloetzel buch
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_kloetzelBuch.setUserName(userName);
	}

	/**
	* Sets the user uuid of this kloetzel buch.
	*
	* @param userUuid the user uuid of this kloetzel buch
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_kloetzelBuch.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this kloetzel buch.
	*
	* @param uuid the uuid of this kloetzel buch
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_kloetzelBuch.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KloetzelBuchWrapper)) {
			return false;
		}

		KloetzelBuchWrapper kloetzelBuchWrapper = (KloetzelBuchWrapper)obj;

		if (Objects.equals(_kloetzelBuch, kloetzelBuchWrapper._kloetzelBuch)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _kloetzelBuch.getStagedModelType();
	}

	@Override
	public KloetzelBuch getWrappedModel() {
		return _kloetzelBuch;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _kloetzelBuch.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _kloetzelBuch.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_kloetzelBuch.resetOriginalValues();
	}

	private final KloetzelBuch _kloetzelBuch;
}