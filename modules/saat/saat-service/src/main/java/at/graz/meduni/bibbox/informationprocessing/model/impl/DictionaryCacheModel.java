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

import at.graz.meduni.bibbox.informationprocessing.model.Dictionary;

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
 * The cache model class for representing Dictionary in entity cache.
 *
 * @author robert
 * @see Dictionary
 * @generated
 */
@ProviderType
public class DictionaryCacheModel implements CacheModel<Dictionary>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictionaryCacheModel)) {
			return false;
		}

		DictionaryCacheModel dictionaryCacheModel = (DictionaryCacheModel)obj;

		if (dictionaryId == dictionaryCacheModel.dictionaryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dictionaryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dictionaryId=");
		sb.append(dictionaryId);
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
		sb.append(", synonym=");
		sb.append(synonym);
		sb.append(", pattern=");
		sb.append(pattern);
		sb.append(", code=");
		sb.append(code);
		sb.append(", code_type=");
		sb.append(code_type);
		sb.append(", code_value=");
		sb.append(code_value);
		sb.append(", root=");
		sb.append(root);
		sb.append(", negation=");
		sb.append(negation);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", priority_mode=");
		sb.append(priority_mode);
		sb.append(", before_synonym=");
		sb.append(before_synonym);
		sb.append(", after_synonym=");
		sb.append(after_synonym);
		sb.append(", foreword=");
		sb.append(foreword);
		sb.append(", ending=");
		sb.append(ending);
		sb.append(", sentence=");
		sb.append(sentence);
		sb.append(", occure=");
		sb.append(occure);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dictionary toEntityModel() {
		DictionaryImpl dictionaryImpl = new DictionaryImpl();

		if (uuid == null) {
			dictionaryImpl.setUuid(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setUuid(uuid);
		}

		dictionaryImpl.setDictionaryId(dictionaryId);
		dictionaryImpl.setGroupId(groupId);
		dictionaryImpl.setCompanyId(companyId);
		dictionaryImpl.setUserId(userId);

		if (userName == null) {
			dictionaryImpl.setUserName(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dictionaryImpl.setCreateDate(null);
		}
		else {
			dictionaryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dictionaryImpl.setModifiedDate(null);
		}
		else {
			dictionaryImpl.setModifiedDate(new Date(modifiedDate));
		}

		dictionaryImpl.setStatus(status);
		dictionaryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dictionaryImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dictionaryImpl.setStatusDate(null);
		}
		else {
			dictionaryImpl.setStatusDate(new Date(statusDate));
		}

		if (synonym == null) {
			dictionaryImpl.setSynonym(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setSynonym(synonym);
		}

		if (pattern == null) {
			dictionaryImpl.setPattern(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setPattern(pattern);
		}

		dictionaryImpl.setCode(code);

		if (code_type == null) {
			dictionaryImpl.setCode_type(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCode_type(code_type);
		}

		if (code_value == null) {
			dictionaryImpl.setCode_value(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCode_value(code_value);
		}

		dictionaryImpl.setRoot(root);
		dictionaryImpl.setNegation(negation);
		dictionaryImpl.setPriority(priority);
		dictionaryImpl.setPriority_mode(priority_mode);
		dictionaryImpl.setBefore_synonym(before_synonym);
		dictionaryImpl.setAfter_synonym(after_synonym);
		dictionaryImpl.setForeword(foreword);
		dictionaryImpl.setEnding(ending);
		dictionaryImpl.setSentence(sentence);
		dictionaryImpl.setOccure(occure);

		dictionaryImpl.resetOriginalValues();

		return dictionaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dictionaryId = objectInput.readLong();

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
		synonym = objectInput.readUTF();
		pattern = objectInput.readUTF();

		code = objectInput.readBoolean();
		code_type = objectInput.readUTF();
		code_value = objectInput.readUTF();

		root = objectInput.readBoolean();

		negation = objectInput.readBoolean();

		priority = objectInput.readInt();

		priority_mode = objectInput.readBoolean();

		before_synonym = objectInput.readInt();

		after_synonym = objectInput.readInt();

		foreword = objectInput.readBoolean();

		ending = objectInput.readBoolean();

		sentence = objectInput.readBoolean();

		occure = objectInput.readBoolean();
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

		objectOutput.writeLong(dictionaryId);

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

		if (synonym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(synonym);
		}

		if (pattern == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pattern);
		}

		objectOutput.writeBoolean(code);

		if (code_type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code_type);
		}

		if (code_value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code_value);
		}

		objectOutput.writeBoolean(root);

		objectOutput.writeBoolean(negation);

		objectOutput.writeInt(priority);

		objectOutput.writeBoolean(priority_mode);

		objectOutput.writeInt(before_synonym);

		objectOutput.writeInt(after_synonym);

		objectOutput.writeBoolean(foreword);

		objectOutput.writeBoolean(ending);

		objectOutput.writeBoolean(sentence);

		objectOutput.writeBoolean(occure);
	}

	public String uuid;
	public long dictionaryId;
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
	public String synonym;
	public String pattern;
	public boolean code;
	public String code_type;
	public String code_value;
	public boolean root;
	public boolean negation;
	public int priority;
	public boolean priority_mode;
	public int before_synonym;
	public int after_synonym;
	public boolean foreword;
	public boolean ending;
	public boolean sentence;
	public boolean occure;
}