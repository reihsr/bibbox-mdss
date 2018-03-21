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

package at.graz.meduni.bibbox.informationprocessing.model.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink;

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
 * The cache model class for representing DictionaryDictionaryLink in entity cache.
 *
 * @author robert
 * @see DictionaryDictionaryLink
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkCacheModel implements CacheModel<DictionaryDictionaryLink>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictionaryDictionaryLinkCacheModel)) {
			return false;
		}

		DictionaryDictionaryLinkCacheModel dictionaryDictionaryLinkCacheModel = (DictionaryDictionaryLinkCacheModel)obj;

		if (dictionarydictionarylinkId == dictionaryDictionaryLinkCacheModel.dictionarydictionarylinkId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dictionarydictionarylinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dictionarydictionarylinkId=");
		sb.append(dictionarydictionarylinkId);
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
		sb.append(", dictionaryId=");
		sb.append(dictionaryId);
		sb.append(", linkdictionaryId=");
		sb.append(linkdictionaryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DictionaryDictionaryLink toEntityModel() {
		DictionaryDictionaryLinkImpl dictionaryDictionaryLinkImpl = new DictionaryDictionaryLinkImpl();

		if (uuid == null) {
			dictionaryDictionaryLinkImpl.setUuid(StringPool.BLANK);
		}
		else {
			dictionaryDictionaryLinkImpl.setUuid(uuid);
		}

		dictionaryDictionaryLinkImpl.setDictionarydictionarylinkId(dictionarydictionarylinkId);
		dictionaryDictionaryLinkImpl.setGroupId(groupId);
		dictionaryDictionaryLinkImpl.setCompanyId(companyId);
		dictionaryDictionaryLinkImpl.setUserId(userId);

		if (userName == null) {
			dictionaryDictionaryLinkImpl.setUserName(StringPool.BLANK);
		}
		else {
			dictionaryDictionaryLinkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dictionaryDictionaryLinkImpl.setCreateDate(null);
		}
		else {
			dictionaryDictionaryLinkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dictionaryDictionaryLinkImpl.setModifiedDate(null);
		}
		else {
			dictionaryDictionaryLinkImpl.setModifiedDate(new Date(modifiedDate));
		}

		dictionaryDictionaryLinkImpl.setStatus(status);
		dictionaryDictionaryLinkImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dictionaryDictionaryLinkImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			dictionaryDictionaryLinkImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dictionaryDictionaryLinkImpl.setStatusDate(null);
		}
		else {
			dictionaryDictionaryLinkImpl.setStatusDate(new Date(statusDate));
		}

		dictionaryDictionaryLinkImpl.setDictionaryId(dictionaryId);
		dictionaryDictionaryLinkImpl.setLinkdictionaryId(linkdictionaryId);

		dictionaryDictionaryLinkImpl.resetOriginalValues();

		return dictionaryDictionaryLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dictionarydictionarylinkId = objectInput.readLong();

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

		dictionaryId = objectInput.readLong();

		linkdictionaryId = objectInput.readLong();
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

		objectOutput.writeLong(dictionarydictionarylinkId);

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

		objectOutput.writeLong(dictionaryId);

		objectOutput.writeLong(linkdictionaryId);
	}

	public String uuid;
	public long dictionarydictionarylinkId;
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
	public long dictionaryId;
	public long linkdictionaryId;
}