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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the KloetzelBuch service. Represents a row in the &quot;medicaldataset_KloetzelBuch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KloetzelBuch
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchImpl
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchModelImpl
 * @generated
 */
@ProviderType
public interface KloetzelBuchModel extends BaseModel<KloetzelBuch>, GroupedModel,
	ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kloetzel buch model instance should use the {@link KloetzelBuch} interface instead.
	 */

	/**
	 * Returns the primary key of this kloetzel buch.
	 *
	 * @return the primary key of this kloetzel buch
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kloetzel buch.
	 *
	 * @param primaryKey the primary key of this kloetzel buch
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this kloetzel buch.
	 *
	 * @return the uuid of this kloetzel buch
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this kloetzel buch.
	 *
	 * @param uuid the uuid of this kloetzel buch
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the kloetzel buch ID of this kloetzel buch.
	 *
	 * @return the kloetzel buch ID of this kloetzel buch
	 */
	public long getKloetzelBuchId();

	/**
	 * Sets the kloetzel buch ID of this kloetzel buch.
	 *
	 * @param kloetzelBuchId the kloetzel buch ID of this kloetzel buch
	 */
	public void setKloetzelBuchId(long kloetzelBuchId);

	/**
	 * Returns the group ID of this kloetzel buch.
	 *
	 * @return the group ID of this kloetzel buch
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this kloetzel buch.
	 *
	 * @param groupId the group ID of this kloetzel buch
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this kloetzel buch.
	 *
	 * @return the company ID of this kloetzel buch
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this kloetzel buch.
	 *
	 * @param companyId the company ID of this kloetzel buch
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this kloetzel buch.
	 *
	 * @return the user ID of this kloetzel buch
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this kloetzel buch.
	 *
	 * @param userId the user ID of this kloetzel buch
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this kloetzel buch.
	 *
	 * @return the user uuid of this kloetzel buch
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this kloetzel buch.
	 *
	 * @param userUuid the user uuid of this kloetzel buch
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this kloetzel buch.
	 *
	 * @return the user name of this kloetzel buch
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this kloetzel buch.
	 *
	 * @param userName the user name of this kloetzel buch
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this kloetzel buch.
	 *
	 * @return the create date of this kloetzel buch
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this kloetzel buch.
	 *
	 * @param createDate the create date of this kloetzel buch
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this kloetzel buch.
	 *
	 * @return the modified date of this kloetzel buch
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kloetzel buch.
	 *
	 * @param modifiedDate the modified date of this kloetzel buch
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this kloetzel buch.
	 *
	 * @return the status of this kloetzel buch
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this kloetzel buch.
	 *
	 * @param status the status of this kloetzel buch
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this kloetzel buch.
	 *
	 * @return the status by user ID of this kloetzel buch
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this kloetzel buch.
	 *
	 * @param statusByUserId the status by user ID of this kloetzel buch
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this kloetzel buch.
	 *
	 * @return the status by user uuid of this kloetzel buch
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this kloetzel buch.
	 *
	 * @param statusByUserUuid the status by user uuid of this kloetzel buch
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this kloetzel buch.
	 *
	 * @return the status by user name of this kloetzel buch
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this kloetzel buch.
	 *
	 * @param statusByUserName the status by user name of this kloetzel buch
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this kloetzel buch.
	 *
	 * @return the status date of this kloetzel buch
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this kloetzel buch.
	 *
	 * @param statusDate the status date of this kloetzel buch
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the medical record ID of this kloetzel buch.
	 *
	 * @return the medical record ID of this kloetzel buch
	 */
	public long getMedicalRecordId();

	/**
	 * Sets the medical record ID of this kloetzel buch.
	 *
	 * @param medicalRecordId the medical record ID of this kloetzel buch
	 */
	public void setMedicalRecordId(long medicalRecordId);

	/**
	 * Returns the histonumber start of this kloetzel buch.
	 *
	 * @return the histonumber start of this kloetzel buch
	 */
	public long getHistonumberStart();

	/**
	 * Sets the histonumber start of this kloetzel buch.
	 *
	 * @param histonumberStart the histonumber start of this kloetzel buch
	 */
	public void setHistonumberStart(long histonumberStart);

	/**
	 * Returns the histonumber end of this kloetzel buch.
	 *
	 * @return the histonumber end of this kloetzel buch
	 */
	public long getHistonumberEnd();

	/**
	 * Sets the histonumber end of this kloetzel buch.
	 *
	 * @param histonumberEnd the histonumber end of this kloetzel buch
	 */
	public void setHistonumberEnd(long histonumberEnd);

	/**
	 * Returns the histonumber running of this kloetzel buch.
	 *
	 * @return the histonumber running of this kloetzel buch
	 */
	public int getHistonumberRunning();

	/**
	 * Sets the histonumber running of this kloetzel buch.
	 *
	 * @param histonumberRunning the histonumber running of this kloetzel buch
	 */
	public void setHistonumberRunning(int histonumberRunning);

	/**
	 * Returns the histonumber of this kloetzel buch.
	 *
	 * @return the histonumber of this kloetzel buch
	 */
	public long getHistonumber();

	/**
	 * Sets the histonumber of this kloetzel buch.
	 *
	 * @param histonumber the histonumber of this kloetzel buch
	 */
	public void setHistonumber(long histonumber);

	/**
	 * Returns the kloetzel buch running of this kloetzel buch.
	 *
	 * @return the kloetzel buch running of this kloetzel buch
	 */
	public int getKloetzelBuchRunning();

	/**
	 * Sets the kloetzel buch running of this kloetzel buch.
	 *
	 * @param kloetzelBuchRunning the kloetzel buch running of this kloetzel buch
	 */
	public void setKloetzelBuchRunning(int kloetzelBuchRunning);

	/**
	 * Returns the oid of this kloetzel buch.
	 *
	 * @return the oid of this kloetzel buch
	 */
	@AutoEscape
	public String getOid();

	/**
	 * Sets the oid of this kloetzel buch.
	 *
	 * @param oid the oid of this kloetzel buch
	 */
	public void setOid(String oid);

	/**
	 * Returns the bid of this kloetzel buch.
	 *
	 * @return the bid of this kloetzel buch
	 */
	@AutoEscape
	public String getBid();

	/**
	 * Sets the bid of this kloetzel buch.
	 *
	 * @param bid the bid of this kloetzel buch
	 */
	public void setBid(String bid);

	/**
	 * Returns the area of this kloetzel buch.
	 *
	 * @return the area of this kloetzel buch
	 */
	@AutoEscape
	public String getArea();

	/**
	 * Sets the area of this kloetzel buch.
	 *
	 * @param area the area of this kloetzel buch
	 */
	public void setArea(String area);

	/**
	 * Returns the type of this kloetzel buch.
	 *
	 * @return the type of this kloetzel buch
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this kloetzel buch.
	 *
	 * @param type the type of this kloetzel buch
	 */
	public void setType(String type);

	/**
	 * Returns the acronym of this kloetzel buch.
	 *
	 * @return the acronym of this kloetzel buch
	 */
	@AutoEscape
	public String getAcronym();

	/**
	 * Sets the acronym of this kloetzel buch.
	 *
	 * @param acronym the acronym of this kloetzel buch
	 */
	public void setAcronym(String acronym);

	/**
	 * Returns the text of this kloetzel buch.
	 *
	 * @return the text of this kloetzel buch
	 */
	@AutoEscape
	public String getText();

	/**
	 * Sets the text of this kloetzel buch.
	 *
	 * @param text the text of this kloetzel buch
	 */
	public void setText(String text);

	/**
	 * Returns the info of this kloetzel buch.
	 *
	 * @return the info of this kloetzel buch
	 */
	@AutoEscape
	public String getInfo();

	/**
	 * Sets the info of this kloetzel buch.
	 *
	 * @param info the info of this kloetzel buch
	 */
	public void setInfo(String info);

	/**
	 * Returns the count of this kloetzel buch.
	 *
	 * @return the count of this kloetzel buch
	 */
	public int getCount();

	/**
	 * Sets the count of this kloetzel buch.
	 *
	 * @param count the count of this kloetzel buch
	 */
	public void setCount(int count);

	/**
	 * Returns the number of pieces of this kloetzel buch.
	 *
	 * @return the number of pieces of this kloetzel buch
	 */
	public int getNumberOfPieces();

	/**
	 * Sets the number of pieces of this kloetzel buch.
	 *
	 * @param numberOfPieces the number of pieces of this kloetzel buch
	 */
	public void setNumberOfPieces(int numberOfPieces);

	/**
	 * Returns the kb status of this kloetzel buch.
	 *
	 * @return the kb status of this kloetzel buch
	 */
	public int getKbStatus();

	/**
	 * Sets the kb status of this kloetzel buch.
	 *
	 * @param kbStatus the kb status of this kloetzel buch
	 */
	public void setKbStatus(int kbStatus);

	/**
	 * Returns the sort of this kloetzel buch.
	 *
	 * @return the sort of this kloetzel buch
	 */
	public int getSort();

	/**
	 * Sets the sort of this kloetzel buch.
	 *
	 * @param sort the sort of this kloetzel buch
	 */
	public void setSort(int sort);

	/**
	 * Returns the color of this kloetzel buch.
	 *
	 * @return the color of this kloetzel buch
	 */
	@AutoEscape
	public String getColor();

	/**
	 * Sets the color of this kloetzel buch.
	 *
	 * @param color the color of this kloetzel buch
	 */
	public void setColor(String color);

	/**
	 * Returns the kb date of this kloetzel buch.
	 *
	 * @return the kb date of this kloetzel buch
	 */
	public Date getKbDate();

	/**
	 * Sets the kb date of this kloetzel buch.
	 *
	 * @param kbDate the kb date of this kloetzel buch
	 */
	public void setKbDate(Date kbDate);

	/**
	 * Returns the day of this kloetzel buch.
	 *
	 * @return the day of this kloetzel buch
	 */
	@AutoEscape
	public String getDay();

	/**
	 * Sets the day of this kloetzel buch.
	 *
	 * @param day the day of this kloetzel buch
	 */
	public void setDay(String day);

	/**
	 * Returns the pocessinguser of this kloetzel buch.
	 *
	 * @return the pocessinguser of this kloetzel buch
	 */
	@AutoEscape
	public String getPocessinguser();

	/**
	 * Sets the pocessinguser of this kloetzel buch.
	 *
	 * @param pocessinguser the pocessinguser of this kloetzel buch
	 */
	public void setPocessinguser(String pocessinguser);

	/**
	 * Returns the organization unit of this kloetzel buch.
	 *
	 * @return the organization unit of this kloetzel buch
	 */
	@AutoEscape
	public String getOrganizationUnit();

	/**
	 * Sets the organization unit of this kloetzel buch.
	 *
	 * @param organizationUnit the organization unit of this kloetzel buch
	 */
	public void setOrganizationUnit(String organizationUnit);

	/**
	 * Returns <code>true</code> if this kloetzel buch is approved.
	 *
	 * @return <code>true</code> if this kloetzel buch is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this kloetzel buch is denied.
	 *
	 * @return <code>true</code> if this kloetzel buch is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this kloetzel buch is a draft.
	 *
	 * @return <code>true</code> if this kloetzel buch is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this kloetzel buch is expired.
	 *
	 * @return <code>true</code> if this kloetzel buch is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this kloetzel buch is inactive.
	 *
	 * @return <code>true</code> if this kloetzel buch is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this kloetzel buch is incomplete.
	 *
	 * @return <code>true</code> if this kloetzel buch is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this kloetzel buch is pending.
	 *
	 * @return <code>true</code> if this kloetzel buch is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this kloetzel buch is scheduled.
	 *
	 * @return <code>true</code> if this kloetzel buch is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch kloetzelBuch);

	@Override
	public int hashCode();

	@Override
	public CacheModel<at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch> toCacheModel();

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch toEscapedModel();

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}