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

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap;

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
 * The cache model class for representing ImportMedicalDataSetFieldMap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetFieldMap
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetFieldMapCacheModel implements CacheModel<ImportMedicalDataSetFieldMap>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImportMedicalDataSetFieldMapCacheModel)) {
			return false;
		}

		ImportMedicalDataSetFieldMapCacheModel importMedicalDataSetFieldMapCacheModel =
			(ImportMedicalDataSetFieldMapCacheModel)obj;

		if (importMedicalDataSetFieldMapId == importMedicalDataSetFieldMapCacheModel.importMedicalDataSetFieldMapId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, importMedicalDataSetFieldMapId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", importMedicalDataSetFieldMapId=");
		sb.append(importMedicalDataSetFieldMapId);
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
		sb.append(", importField=");
		sb.append(importField);
		sb.append(", importFieldPath=");
		sb.append(importFieldPath);
		sb.append(", TableName=");
		sb.append(TableName);
		sb.append(", TableField=");
		sb.append(TableField);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImportMedicalDataSetFieldMap toEntityModel() {
		ImportMedicalDataSetFieldMapImpl importMedicalDataSetFieldMapImpl = new ImportMedicalDataSetFieldMapImpl();

		if (uuid == null) {
			importMedicalDataSetFieldMapImpl.setUuid(StringPool.BLANK);
		}
		else {
			importMedicalDataSetFieldMapImpl.setUuid(uuid);
		}

		importMedicalDataSetFieldMapImpl.setImportMedicalDataSetFieldMapId(importMedicalDataSetFieldMapId);
		importMedicalDataSetFieldMapImpl.setGroupId(groupId);
		importMedicalDataSetFieldMapImpl.setCompanyId(companyId);
		importMedicalDataSetFieldMapImpl.setUserId(userId);

		if (userName == null) {
			importMedicalDataSetFieldMapImpl.setUserName(StringPool.BLANK);
		}
		else {
			importMedicalDataSetFieldMapImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			importMedicalDataSetFieldMapImpl.setCreateDate(null);
		}
		else {
			importMedicalDataSetFieldMapImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			importMedicalDataSetFieldMapImpl.setModifiedDate(null);
		}
		else {
			importMedicalDataSetFieldMapImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		importMedicalDataSetFieldMapImpl.setStatus(status);
		importMedicalDataSetFieldMapImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			importMedicalDataSetFieldMapImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			importMedicalDataSetFieldMapImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			importMedicalDataSetFieldMapImpl.setStatusDate(null);
		}
		else {
			importMedicalDataSetFieldMapImpl.setStatusDate(new Date(statusDate));
		}

		importMedicalDataSetFieldMapImpl.setImportMedicalDataSetId(importMedicalDataSetId);

		if (importField == null) {
			importMedicalDataSetFieldMapImpl.setImportField(StringPool.BLANK);
		}
		else {
			importMedicalDataSetFieldMapImpl.setImportField(importField);
		}

		if (importFieldPath == null) {
			importMedicalDataSetFieldMapImpl.setImportFieldPath(StringPool.BLANK);
		}
		else {
			importMedicalDataSetFieldMapImpl.setImportFieldPath(importFieldPath);
		}

		if (TableName == null) {
			importMedicalDataSetFieldMapImpl.setTableName(StringPool.BLANK);
		}
		else {
			importMedicalDataSetFieldMapImpl.setTableName(TableName);
		}

		if (TableField == null) {
			importMedicalDataSetFieldMapImpl.setTableField(StringPool.BLANK);
		}
		else {
			importMedicalDataSetFieldMapImpl.setTableField(TableField);
		}

		importMedicalDataSetFieldMapImpl.resetOriginalValues();

		return importMedicalDataSetFieldMapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		importMedicalDataSetFieldMapId = objectInput.readLong();

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
		importField = objectInput.readUTF();
		importFieldPath = objectInput.readUTF();
		TableName = objectInput.readUTF();
		TableField = objectInput.readUTF();
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

		objectOutput.writeLong(importMedicalDataSetFieldMapId);

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

		if (importField == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(importField);
		}

		if (importFieldPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(importFieldPath);
		}

		if (TableName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(TableName);
		}

		if (TableField == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(TableField);
		}
	}

	public String uuid;
	public long importMedicalDataSetFieldMapId;
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
	public String importField;
	public String importFieldPath;
	public String TableName;
	public String TableField;
}