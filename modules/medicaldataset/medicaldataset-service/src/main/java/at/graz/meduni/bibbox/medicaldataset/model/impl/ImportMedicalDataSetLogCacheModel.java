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

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog;

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
 * The cache model class for representing ImportMedicalDataSetLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLog
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetLogCacheModel implements CacheModel<ImportMedicalDataSetLog>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImportMedicalDataSetLogCacheModel)) {
			return false;
		}

		ImportMedicalDataSetLogCacheModel importMedicalDataSetLogCacheModel = (ImportMedicalDataSetLogCacheModel)obj;

		if (importMedicalDataSetLogId == importMedicalDataSetLogCacheModel.importMedicalDataSetLogId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, importMedicalDataSetLogId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", importMedicalDataSetLogId=");
		sb.append(importMedicalDataSetLogId);
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
		sb.append(", importStatus=");
		sb.append(importStatus);
		sb.append(", importStatusLog=");
		sb.append(importStatusLog);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImportMedicalDataSetLog toEntityModel() {
		ImportMedicalDataSetLogImpl importMedicalDataSetLogImpl = new ImportMedicalDataSetLogImpl();

		if (uuid == null) {
			importMedicalDataSetLogImpl.setUuid(StringPool.BLANK);
		}
		else {
			importMedicalDataSetLogImpl.setUuid(uuid);
		}

		importMedicalDataSetLogImpl.setImportMedicalDataSetLogId(importMedicalDataSetLogId);
		importMedicalDataSetLogImpl.setGroupId(groupId);
		importMedicalDataSetLogImpl.setCompanyId(companyId);
		importMedicalDataSetLogImpl.setUserId(userId);

		if (userName == null) {
			importMedicalDataSetLogImpl.setUserName(StringPool.BLANK);
		}
		else {
			importMedicalDataSetLogImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			importMedicalDataSetLogImpl.setCreateDate(null);
		}
		else {
			importMedicalDataSetLogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			importMedicalDataSetLogImpl.setModifiedDate(null);
		}
		else {
			importMedicalDataSetLogImpl.setModifiedDate(new Date(modifiedDate));
		}

		importMedicalDataSetLogImpl.setStatus(status);
		importMedicalDataSetLogImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			importMedicalDataSetLogImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			importMedicalDataSetLogImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			importMedicalDataSetLogImpl.setStatusDate(null);
		}
		else {
			importMedicalDataSetLogImpl.setStatusDate(new Date(statusDate));
		}

		importMedicalDataSetLogImpl.setImportMedicalDataSetId(importMedicalDataSetId);
		importMedicalDataSetLogImpl.setImportStatus(importStatus);

		if (importStatusLog == null) {
			importMedicalDataSetLogImpl.setImportStatusLog(StringPool.BLANK);
		}
		else {
			importMedicalDataSetLogImpl.setImportStatusLog(importStatusLog);
		}

		importMedicalDataSetLogImpl.resetOriginalValues();

		return importMedicalDataSetLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		importMedicalDataSetLogId = objectInput.readLong();

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

		importStatus = objectInput.readInt();
		importStatusLog = objectInput.readUTF();
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

		objectOutput.writeLong(importMedicalDataSetLogId);

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

		objectOutput.writeInt(importStatus);

		if (importStatusLog == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(importStatusLog);
		}
	}

	public String uuid;
	public long importMedicalDataSetLogId;
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
	public int importStatus;
	public String importStatusLog;
}