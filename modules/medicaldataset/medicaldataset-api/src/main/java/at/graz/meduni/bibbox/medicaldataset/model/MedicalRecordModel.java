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
 * The base model interface for the MedicalRecord service. Represents a row in the &quot;FOO_MedicalRecord&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MedicalRecord
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordImpl
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordModelImpl
 * @generated
 */
@ProviderType
public interface MedicalRecordModel extends BaseModel<MedicalRecord>,
	GroupedModel, ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a medical record model instance should use the {@link MedicalRecord} interface instead.
	 */

	/**
	 * Returns the primary key of this medical record.
	 *
	 * @return the primary key of this medical record
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this medical record.
	 *
	 * @param primaryKey the primary key of this medical record
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this medical record.
	 *
	 * @return the uuid of this medical record
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this medical record.
	 *
	 * @param uuid the uuid of this medical record
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the medical record ID of this medical record.
	 *
	 * @return the medical record ID of this medical record
	 */
	public long getMedicalRecordId();

	/**
	 * Sets the medical record ID of this medical record.
	 *
	 * @param medicalRecordId the medical record ID of this medical record
	 */
	public void setMedicalRecordId(long medicalRecordId);

	/**
	 * Returns the group ID of this medical record.
	 *
	 * @return the group ID of this medical record
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this medical record.
	 *
	 * @param groupId the group ID of this medical record
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this medical record.
	 *
	 * @return the company ID of this medical record
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this medical record.
	 *
	 * @param companyId the company ID of this medical record
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this medical record.
	 *
	 * @return the user ID of this medical record
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this medical record.
	 *
	 * @param userId the user ID of this medical record
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this medical record.
	 *
	 * @return the user uuid of this medical record
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this medical record.
	 *
	 * @param userUuid the user uuid of this medical record
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this medical record.
	 *
	 * @return the user name of this medical record
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this medical record.
	 *
	 * @param userName the user name of this medical record
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this medical record.
	 *
	 * @return the create date of this medical record
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this medical record.
	 *
	 * @param createDate the create date of this medical record
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this medical record.
	 *
	 * @return the modified date of this medical record
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this medical record.
	 *
	 * @param modifiedDate the modified date of this medical record
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this medical record.
	 *
	 * @return the status of this medical record
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this medical record.
	 *
	 * @param status the status of this medical record
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this medical record.
	 *
	 * @return the status by user ID of this medical record
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this medical record.
	 *
	 * @param statusByUserId the status by user ID of this medical record
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this medical record.
	 *
	 * @return the status by user uuid of this medical record
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this medical record.
	 *
	 * @param statusByUserUuid the status by user uuid of this medical record
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this medical record.
	 *
	 * @return the status by user name of this medical record
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this medical record.
	 *
	 * @param statusByUserName the status by user name of this medical record
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this medical record.
	 *
	 * @return the status date of this medical record
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this medical record.
	 *
	 * @param statusDate the status date of this medical record
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the histonumber start of this medical record.
	 *
	 * @return the histonumber start of this medical record
	 */
	public long getHistonumberStart();

	/**
	 * Sets the histonumber start of this medical record.
	 *
	 * @param histonumberStart the histonumber start of this medical record
	 */
	public void setHistonumberStart(long histonumberStart);

	/**
	 * Returns the histonumber end of this medical record.
	 *
	 * @return the histonumber end of this medical record
	 */
	public long getHistonumberEnd();

	/**
	 * Sets the histonumber end of this medical record.
	 *
	 * @param histonumberEnd the histonumber end of this medical record
	 */
	public void setHistonumberEnd(long histonumberEnd);

	/**
	 * Returns the histonumber running of this medical record.
	 *
	 * @return the histonumber running of this medical record
	 */
	public int getHistonumberRunning();

	/**
	 * Sets the histonumber running of this medical record.
	 *
	 * @param histonumberRunning the histonumber running of this medical record
	 */
	public void setHistonumberRunning(int histonumberRunning);

	/**
	 * Returns the i number of this medical record.
	 *
	 * @return the i number of this medical record
	 */
	public long getINumber();

	/**
	 * Sets the i number of this medical record.
	 *
	 * @param iNumber the i number of this medical record
	 */
	public void setINumber(long iNumber);

	/**
	 * Returns the v patent ID of this medical record.
	 *
	 * @return the v patent ID of this medical record
	 */
	public long getVPatentId();

	/**
	 * Sets the v patent ID of this medical record.
	 *
	 * @param vPatentId the v patent ID of this medical record
	 */
	public void setVPatentId(long vPatentId);

	/**
	 * Returns the v histon number of this medical record.
	 *
	 * @return the v histon number of this medical record
	 */
	public long getVHistonNumber();

	/**
	 * Sets the v histon number of this medical record.
	 *
	 * @param vHistonNumber the v histon number of this medical record
	 */
	public void setVHistonNumber(long vHistonNumber);

	/**
	 * Returns the area of this medical record.
	 *
	 * @return the area of this medical record
	 */
	@AutoEscape
	public String getArea();

	/**
	 * Sets the area of this medical record.
	 *
	 * @param area the area of this medical record
	 */
	public void setArea(String area);

	/**
	 * Returns the imi job ID of this medical record.
	 *
	 * @return the imi job ID of this medical record
	 */
	public long getImiJobId();

	/**
	 * Sets the imi job ID of this medical record.
	 *
	 * @param imiJobId the imi job ID of this medical record
	 */
	public void setImiJobId(long imiJobId);

	/**
	 * Returns the import file of this medical record.
	 *
	 * @return the import file of this medical record
	 */
	@AutoEscape
	public String getImportFile();

	/**
	 * Sets the import file of this medical record.
	 *
	 * @param importFile the import file of this medical record
	 */
	public void setImportFile(String importFile);

	/**
	 * Returns <code>true</code> if this medical record is approved.
	 *
	 * @return <code>true</code> if this medical record is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this medical record is denied.
	 *
	 * @return <code>true</code> if this medical record is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this medical record is a draft.
	 *
	 * @return <code>true</code> if this medical record is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this medical record is expired.
	 *
	 * @return <code>true</code> if this medical record is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this medical record is inactive.
	 *
	 * @return <code>true</code> if this medical record is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this medical record is incomplete.
	 *
	 * @return <code>true</code> if this medical record is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this medical record is pending.
	 *
	 * @return <code>true</code> if this medical record is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this medical record is scheduled.
	 *
	 * @return <code>true</code> if this medical record is scheduled; <code>false</code> otherwise
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
		at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord medicalRecord);

	@Override
	public int hashCode();

	@Override
	public CacheModel<at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord> toCacheModel();

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord toEscapedModel();

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}