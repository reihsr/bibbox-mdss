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

package at.graz.meduni.bibbox.medicaldataset.model.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MedicalRecord in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MedicalRecord
 * @generated
 */
@ProviderType
public class MedicalRecordCacheModel implements CacheModel<MedicalRecord>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MedicalRecordCacheModel)) {
			return false;
		}

		MedicalRecordCacheModel medicalRecordCacheModel = (MedicalRecordCacheModel)obj;

		if (medicalRecordId == medicalRecordCacheModel.medicalRecordId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, medicalRecordId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", medicalRecordId=");
		sb.append(medicalRecordId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", importMedicalDataSetId=");
		sb.append(importMedicalDataSetId);
		sb.append(", histonumberStart=");
		sb.append(histonumberStart);
		sb.append(", histonumberEnd=");
		sb.append(histonumberEnd);
		sb.append(", histonumberRunning=");
		sb.append(histonumberRunning);
		sb.append(", iNumber=");
		sb.append(iNumber);
		sb.append(", vPatientId=");
		sb.append(vPatientId);
		sb.append(", vHistonNumber=");
		sb.append(vHistonNumber);
		sb.append(", bbPseudonym=");
		sb.append(bbPseudonym);
		sb.append(", area=");
		sb.append(area);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MedicalRecord toEntityModel() {
		MedicalRecordImpl medicalRecordImpl = new MedicalRecordImpl();

		if (uuid == null) {
			medicalRecordImpl.setUuid(StringPool.BLANK);
		}
		else {
			medicalRecordImpl.setUuid(uuid);
		}

		medicalRecordImpl.setMedicalRecordId(medicalRecordId);
		medicalRecordImpl.setGroupId(groupId);
		medicalRecordImpl.setCompanyId(companyId);
		medicalRecordImpl.setUserId(userId);

		if (userName == null) {
			medicalRecordImpl.setUserName(StringPool.BLANK);
		}
		else {
			medicalRecordImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			medicalRecordImpl.setCreateDate(null);
		}
		else {
			medicalRecordImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			medicalRecordImpl.setModifiedDate(null);
		}
		else {
			medicalRecordImpl.setModifiedDate(new Date(modifiedDate));
		}

		medicalRecordImpl.setStatus(status);
		medicalRecordImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			medicalRecordImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			medicalRecordImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			medicalRecordImpl.setStatusDate(null);
		}
		else {
			medicalRecordImpl.setStatusDate(new Date(statusDate));
		}

		medicalRecordImpl.setImportMedicalDataSetId(importMedicalDataSetId);
		medicalRecordImpl.setHistonumberStart(histonumberStart);
		medicalRecordImpl.setHistonumberEnd(histonumberEnd);
		medicalRecordImpl.setHistonumberRunning(histonumberRunning);
		medicalRecordImpl.setINumber(iNumber);
		medicalRecordImpl.setVPatientId(vPatientId);
		medicalRecordImpl.setVHistonNumber(vHistonNumber);
		medicalRecordImpl.setBbPseudonym(bbPseudonym);

		if (area == null) {
			medicalRecordImpl.setArea(StringPool.BLANK);
		}
		else {
			medicalRecordImpl.setArea(area);
		}

		medicalRecordImpl.resetOriginalValues();

		return medicalRecordImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		medicalRecordId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		importMedicalDataSetId = objectInput.readLong();

		histonumberStart = objectInput.readLong();

		histonumberEnd = objectInput.readLong();

		histonumberRunning = objectInput.readInt();

		iNumber = objectInput.readLong();

		vPatientId = objectInput.readLong();

		vHistonNumber = objectInput.readLong();

		bbPseudonym = objectInput.readLong();
		area = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(medicalRecordId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(importMedicalDataSetId);

		objectOutput.writeLong(histonumberStart);

		objectOutput.writeLong(histonumberEnd);

		objectOutput.writeInt(histonumberRunning);

		objectOutput.writeLong(iNumber);

		objectOutput.writeLong(vPatientId);

		objectOutput.writeLong(vHistonNumber);

		objectOutput.writeLong(bbPseudonym);

		if (area == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(area);
		}
	}

	public String uuid;
	public long medicalRecordId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long importMedicalDataSetId;
	public long histonumberStart;
	public long histonumberEnd;
	public int histonumberRunning;
	public long iNumber;
	public long vPatientId;
	public long vHistonNumber;
	public long bbPseudonym;
	public String area;
}