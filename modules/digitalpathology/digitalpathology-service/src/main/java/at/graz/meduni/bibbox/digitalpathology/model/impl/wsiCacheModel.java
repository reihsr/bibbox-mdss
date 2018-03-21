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

package at.graz.meduni.bibbox.digitalpathology.model.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.digitalpathology.model.wsi;

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
 * The cache model class for representing wsi in entity cache.
 *
 * @author robert
 * @see wsi
 * @generated
 */
@ProviderType
public class wsiCacheModel implements CacheModel<wsi>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof wsiCacheModel)) {
			return false;
		}

		wsiCacheModel wsiCacheModel = (wsiCacheModel)obj;

		if (wsiId == wsiCacheModel.wsiId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, wsiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", wsiId=");
		sb.append(wsiId);
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
		sb.append(", filename=");
		sb.append(filename);
		sb.append(", hashmrxs=");
		sb.append(hashmrxs);
		sb.append(", scanstart=");
		sb.append(scanstart);
		sb.append(", scanduration=");
		sb.append(scanduration);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public wsi toEntityModel() {
		wsiImpl wsiImpl = new wsiImpl();

		if (uuid == null) {
			wsiImpl.setUuid(StringPool.BLANK);
		}
		else {
			wsiImpl.setUuid(uuid);
		}

		wsiImpl.setWsiId(wsiId);
		wsiImpl.setGroupId(groupId);
		wsiImpl.setCompanyId(companyId);
		wsiImpl.setUserId(userId);

		if (userName == null) {
			wsiImpl.setUserName(StringPool.BLANK);
		}
		else {
			wsiImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			wsiImpl.setCreateDate(null);
		}
		else {
			wsiImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wsiImpl.setModifiedDate(null);
		}
		else {
			wsiImpl.setModifiedDate(new Date(modifiedDate));
		}

		wsiImpl.setStatus(status);
		wsiImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			wsiImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			wsiImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			wsiImpl.setStatusDate(null);
		}
		else {
			wsiImpl.setStatusDate(new Date(statusDate));
		}

		if (filename == null) {
			wsiImpl.setFilename(StringPool.BLANK);
		}
		else {
			wsiImpl.setFilename(filename);
		}

		if (hashmrxs == null) {
			wsiImpl.setHashmrxs(StringPool.BLANK);
		}
		else {
			wsiImpl.setHashmrxs(hashmrxs);
		}

		if (scanstart == Long.MIN_VALUE) {
			wsiImpl.setScanstart(null);
		}
		else {
			wsiImpl.setScanstart(new Date(scanstart));
		}

		wsiImpl.setScanduration(scanduration);

		wsiImpl.resetOriginalValues();

		return wsiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		wsiId = objectInput.readLong();

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
		filename = objectInput.readUTF();
		hashmrxs = objectInput.readUTF();
		scanstart = objectInput.readLong();

		scanduration = objectInput.readLong();
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

		objectOutput.writeLong(wsiId);

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

		if (filename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filename);
		}

		if (hashmrxs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hashmrxs);
		}

		objectOutput.writeLong(scanstart);

		objectOutput.writeLong(scanduration);
	}

	public String uuid;
	public long wsiId;
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
	public String filename;
	public String hashmrxs;
	public long scanstart;
	public long scanduration;
}