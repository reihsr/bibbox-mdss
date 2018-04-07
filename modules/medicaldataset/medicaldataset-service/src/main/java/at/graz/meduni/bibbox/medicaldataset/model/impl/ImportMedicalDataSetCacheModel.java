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

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet;

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
 * The cache model class for representing ImportMedicalDataSet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSet
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetCacheModel implements CacheModel<ImportMedicalDataSet>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImportMedicalDataSetCacheModel)) {
			return false;
		}

		ImportMedicalDataSetCacheModel importMedicalDataSetCacheModel = (ImportMedicalDataSetCacheModel)obj;

		if (importMedicalDataSetId == importMedicalDataSetCacheModel.importMedicalDataSetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, importMedicalDataSetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", importMedicalDataSetId=");
		sb.append(importMedicalDataSetId);
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
		sb.append(", importName=");
		sb.append(importName);
		sb.append(", importType=");
		sb.append(importType);
		sb.append(", imiJobId=");
		sb.append(imiJobId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", filePath=");
		sb.append(filePath);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append(", importStatus=");
		sb.append(importStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImportMedicalDataSet toEntityModel() {
		ImportMedicalDataSetImpl importMedicalDataSetImpl = new ImportMedicalDataSetImpl();

		if (uuid == null) {
			importMedicalDataSetImpl.setUuid(StringPool.BLANK);
		}
		else {
			importMedicalDataSetImpl.setUuid(uuid);
		}

		importMedicalDataSetImpl.setImportMedicalDataSetId(importMedicalDataSetId);
		importMedicalDataSetImpl.setGroupId(groupId);
		importMedicalDataSetImpl.setCompanyId(companyId);
		importMedicalDataSetImpl.setUserId(userId);

		if (userName == null) {
			importMedicalDataSetImpl.setUserName(StringPool.BLANK);
		}
		else {
			importMedicalDataSetImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			importMedicalDataSetImpl.setCreateDate(null);
		}
		else {
			importMedicalDataSetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			importMedicalDataSetImpl.setModifiedDate(null);
		}
		else {
			importMedicalDataSetImpl.setModifiedDate(new Date(modifiedDate));
		}

		importMedicalDataSetImpl.setStatus(status);
		importMedicalDataSetImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			importMedicalDataSetImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			importMedicalDataSetImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			importMedicalDataSetImpl.setStatusDate(null);
		}
		else {
			importMedicalDataSetImpl.setStatusDate(new Date(statusDate));
		}

		if (importName == null) {
			importMedicalDataSetImpl.setImportName(StringPool.BLANK);
		}
		else {
			importMedicalDataSetImpl.setImportName(importName);
		}

		if (importType == null) {
			importMedicalDataSetImpl.setImportType(StringPool.BLANK);
		}
		else {
			importMedicalDataSetImpl.setImportType(importType);
		}

		importMedicalDataSetImpl.setImiJobId(imiJobId);

		if (description == null) {
			importMedicalDataSetImpl.setDescription(StringPool.BLANK);
		}
		else {
			importMedicalDataSetImpl.setDescription(description);
		}

		if (fileName == null) {
			importMedicalDataSetImpl.setFileName(StringPool.BLANK);
		}
		else {
			importMedicalDataSetImpl.setFileName(fileName);
		}

		if (filePath == null) {
			importMedicalDataSetImpl.setFilePath(StringPool.BLANK);
		}
		else {
			importMedicalDataSetImpl.setFilePath(filePath);
		}

		importMedicalDataSetImpl.setFileId(fileId);
		importMedicalDataSetImpl.setImportStatus(importStatus);

		importMedicalDataSetImpl.resetOriginalValues();

		return importMedicalDataSetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		importMedicalDataSetId = objectInput.readLong();

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
		importName = objectInput.readUTF();
		importType = objectInput.readUTF();

		imiJobId = objectInput.readLong();
		description = objectInput.readUTF();
		fileName = objectInput.readUTF();
		filePath = objectInput.readUTF();

		fileId = objectInput.readLong();

		importStatus = objectInput.readInt();
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

		objectOutput.writeLong(importMedicalDataSetId);

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

		if (importName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(importName);
		}

		if (importType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(importType);
		}

		objectOutput.writeLong(imiJobId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (filePath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filePath);
		}

		objectOutput.writeLong(fileId);

		objectOutput.writeInt(importStatus);
	}

	public String uuid;
	public long importMedicalDataSetId;
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
	public String importName;
	public String importType;
	public long imiJobId;
	public String description;
	public String fileName;
	public String filePath;
	public long fileId;
	public int importStatus;
}