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

import at.graz.meduni.bibbox.digitalpathology.model.wsihash;

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
 * The cache model class for representing wsihash in entity cache.
 *
 * @author robert
 * @see wsihash
 * @generated
 */
@ProviderType
public class wsihashCacheModel implements CacheModel<wsihash>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof wsihashCacheModel)) {
			return false;
		}

		wsihashCacheModel wsihashCacheModel = (wsihashCacheModel)obj;

		if (wsihashId == wsihashCacheModel.wsihashId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, wsihashId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", wsihashId=");
		sb.append(wsihashId);
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
		sb.append(", wsiId=");
		sb.append(wsiId);
		sb.append(", filename=");
		sb.append(filename);
		sb.append(", hash=");
		sb.append(hash);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public wsihash toEntityModel() {
		wsihashImpl wsihashImpl = new wsihashImpl();

		if (uuid == null) {
			wsihashImpl.setUuid(StringPool.BLANK);
		}
		else {
			wsihashImpl.setUuid(uuid);
		}

		wsihashImpl.setWsihashId(wsihashId);
		wsihashImpl.setGroupId(groupId);
		wsihashImpl.setCompanyId(companyId);
		wsihashImpl.setUserId(userId);

		if (userName == null) {
			wsihashImpl.setUserName(StringPool.BLANK);
		}
		else {
			wsihashImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			wsihashImpl.setCreateDate(null);
		}
		else {
			wsihashImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			wsihashImpl.setModifiedDate(null);
		}
		else {
			wsihashImpl.setModifiedDate(new Date(modifiedDate));
		}

		wsihashImpl.setStatus(status);
		wsihashImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			wsihashImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			wsihashImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			wsihashImpl.setStatusDate(null);
		}
		else {
			wsihashImpl.setStatusDate(new Date(statusDate));
		}

		wsihashImpl.setWsiId(wsiId);

		if (filename == null) {
			wsihashImpl.setFilename(StringPool.BLANK);
		}
		else {
			wsihashImpl.setFilename(filename);
		}

		if (hash == null) {
			wsihashImpl.setHash(StringPool.BLANK);
		}
		else {
			wsihashImpl.setHash(hash);
		}

		wsihashImpl.resetOriginalValues();

		return wsihashImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		wsihashId = objectInput.readLong();

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

		wsiId = objectInput.readLong();
		filename = objectInput.readUTF();
		hash = objectInput.readUTF();
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

		objectOutput.writeLong(wsihashId);

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

		objectOutput.writeLong(wsiId);

		if (filename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filename);
		}

		if (hash == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hash);
		}
	}

	public String uuid;
	public long wsihashId;
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
	public long wsiId;
	public String filename;
	public String hash;
}