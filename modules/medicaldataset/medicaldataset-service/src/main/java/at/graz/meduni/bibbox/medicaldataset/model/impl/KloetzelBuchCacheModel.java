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

import at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch;

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
 * The cache model class for representing KloetzelBuch in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see KloetzelBuch
 * @generated
 */
@ProviderType
public class KloetzelBuchCacheModel implements CacheModel<KloetzelBuch>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KloetzelBuchCacheModel)) {
			return false;
		}

		KloetzelBuchCacheModel kloetzelBuchCacheModel = (KloetzelBuchCacheModel)obj;

		if (kloetzelBuchId == kloetzelBuchCacheModel.kloetzelBuchId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, kloetzelBuchId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(69);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", kloetzelBuchId=");
		sb.append(kloetzelBuchId);
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
		sb.append(", medicalRecordId=");
		sb.append(medicalRecordId);
		sb.append(", histonumberStart=");
		sb.append(histonumberStart);
		sb.append(", histonumberEnd=");
		sb.append(histonumberEnd);
		sb.append(", histonumberRunning=");
		sb.append(histonumberRunning);
		sb.append(", histonumber=");
		sb.append(histonumber);
		sb.append(", kloetzelBuchRunning=");
		sb.append(kloetzelBuchRunning);
		sb.append(", oid=");
		sb.append(oid);
		sb.append(", bid=");
		sb.append(bid);
		sb.append(", area=");
		sb.append(area);
		sb.append(", type=");
		sb.append(type);
		sb.append(", acronym=");
		sb.append(acronym);
		sb.append(", text=");
		sb.append(text);
		sb.append(", info=");
		sb.append(info);
		sb.append(", count=");
		sb.append(count);
		sb.append(", numberOfPieces=");
		sb.append(numberOfPieces);
		sb.append(", kbStatus=");
		sb.append(kbStatus);
		sb.append(", sort=");
		sb.append(sort);
		sb.append(", color=");
		sb.append(color);
		sb.append(", kbDate=");
		sb.append(kbDate);
		sb.append(", day=");
		sb.append(day);
		sb.append(", pocessinguser=");
		sb.append(pocessinguser);
		sb.append(", organizationUnit=");
		sb.append(organizationUnit);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KloetzelBuch toEntityModel() {
		KloetzelBuchImpl kloetzelBuchImpl = new KloetzelBuchImpl();

		if (uuid == null) {
			kloetzelBuchImpl.setUuid(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setUuid(uuid);
		}

		kloetzelBuchImpl.setKloetzelBuchId(kloetzelBuchId);
		kloetzelBuchImpl.setGroupId(groupId);
		kloetzelBuchImpl.setCompanyId(companyId);
		kloetzelBuchImpl.setUserId(userId);

		if (userName == null) {
			kloetzelBuchImpl.setUserName(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kloetzelBuchImpl.setCreateDate(null);
		}
		else {
			kloetzelBuchImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kloetzelBuchImpl.setModifiedDate(null);
		}
		else {
			kloetzelBuchImpl.setModifiedDate(new Date(modifiedDate));
		}

		kloetzelBuchImpl.setStatus(status);
		kloetzelBuchImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			kloetzelBuchImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			kloetzelBuchImpl.setStatusDate(null);
		}
		else {
			kloetzelBuchImpl.setStatusDate(new Date(statusDate));
		}

		kloetzelBuchImpl.setMedicalRecordId(medicalRecordId);
		kloetzelBuchImpl.setHistonumberStart(histonumberStart);
		kloetzelBuchImpl.setHistonumberEnd(histonumberEnd);
		kloetzelBuchImpl.setHistonumberRunning(histonumberRunning);
		kloetzelBuchImpl.setHistonumber(histonumber);
		kloetzelBuchImpl.setKloetzelBuchRunning(kloetzelBuchRunning);

		if (oid == null) {
			kloetzelBuchImpl.setOid(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setOid(oid);
		}

		if (bid == null) {
			kloetzelBuchImpl.setBid(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setBid(bid);
		}

		if (area == null) {
			kloetzelBuchImpl.setArea(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setArea(area);
		}

		if (type == null) {
			kloetzelBuchImpl.setType(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setType(type);
		}

		if (acronym == null) {
			kloetzelBuchImpl.setAcronym(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setAcronym(acronym);
		}

		if (text == null) {
			kloetzelBuchImpl.setText(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setText(text);
		}

		if (info == null) {
			kloetzelBuchImpl.setInfo(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setInfo(info);
		}

		kloetzelBuchImpl.setCount(count);
		kloetzelBuchImpl.setNumberOfPieces(numberOfPieces);
		kloetzelBuchImpl.setKbStatus(kbStatus);
		kloetzelBuchImpl.setSort(sort);

		if (color == null) {
			kloetzelBuchImpl.setColor(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setColor(color);
		}

		if (kbDate == Long.MIN_VALUE) {
			kloetzelBuchImpl.setKbDate(null);
		}
		else {
			kloetzelBuchImpl.setKbDate(new Date(kbDate));
		}

		if (day == null) {
			kloetzelBuchImpl.setDay(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setDay(day);
		}

		if (pocessinguser == null) {
			kloetzelBuchImpl.setPocessinguser(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setPocessinguser(pocessinguser);
		}

		if (organizationUnit == null) {
			kloetzelBuchImpl.setOrganizationUnit(StringPool.BLANK);
		}
		else {
			kloetzelBuchImpl.setOrganizationUnit(organizationUnit);
		}

		kloetzelBuchImpl.resetOriginalValues();

		return kloetzelBuchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		kloetzelBuchId = objectInput.readLong();

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

		medicalRecordId = objectInput.readLong();

		histonumberStart = objectInput.readLong();

		histonumberEnd = objectInput.readLong();

		histonumberRunning = objectInput.readInt();

		histonumber = objectInput.readLong();

		kloetzelBuchRunning = objectInput.readInt();
		oid = objectInput.readUTF();
		bid = objectInput.readUTF();
		area = objectInput.readUTF();
		type = objectInput.readUTF();
		acronym = objectInput.readUTF();
		text = objectInput.readUTF();
		info = objectInput.readUTF();

		count = objectInput.readInt();

		numberOfPieces = objectInput.readInt();

		kbStatus = objectInput.readInt();

		sort = objectInput.readInt();
		color = objectInput.readUTF();
		kbDate = objectInput.readLong();
		day = objectInput.readUTF();
		pocessinguser = objectInput.readUTF();
		organizationUnit = objectInput.readUTF();
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

		objectOutput.writeLong(kloetzelBuchId);

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

		objectOutput.writeLong(medicalRecordId);

		objectOutput.writeLong(histonumberStart);

		objectOutput.writeLong(histonumberEnd);

		objectOutput.writeInt(histonumberRunning);

		objectOutput.writeLong(histonumber);

		objectOutput.writeInt(kloetzelBuchRunning);

		if (oid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(oid);
		}

		if (bid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bid);
		}

		if (area == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(area);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (acronym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(acronym);
		}

		if (text == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(text);
		}

		if (info == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(info);
		}

		objectOutput.writeInt(count);

		objectOutput.writeInt(numberOfPieces);

		objectOutput.writeInt(kbStatus);

		objectOutput.writeInt(sort);

		if (color == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(color);
		}

		objectOutput.writeLong(kbDate);

		if (day == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(day);
		}

		if (pocessinguser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pocessinguser);
		}

		if (organizationUnit == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(organizationUnit);
		}
	}

	public String uuid;
	public long kloetzelBuchId;
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
	public long medicalRecordId;
	public long histonumberStart;
	public long histonumberEnd;
	public int histonumberRunning;
	public long histonumber;
	public int kloetzelBuchRunning;
	public String oid;
	public String bid;
	public String area;
	public String type;
	public String acronym;
	public String text;
	public String info;
	public int count;
	public int numberOfPieces;
	public int kbStatus;
	public int sort;
	public String color;
	public long kbDate;
	public String day;
	public String pocessinguser;
	public String organizationUnit;
}