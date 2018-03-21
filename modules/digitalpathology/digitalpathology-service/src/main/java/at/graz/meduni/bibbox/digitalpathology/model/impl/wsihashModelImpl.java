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
import at.graz.meduni.bibbox.digitalpathology.model.wsihashModel;
import at.graz.meduni.bibbox.digitalpathology.model.wsihashSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the wsihash service. Represents a row in the &quot;DP_wsihash&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link wsihashModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link wsihashImpl}.
 * </p>
 *
 * @author robert
 * @see wsihashImpl
 * @see wsihash
 * @see wsihashModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class wsihashModelImpl extends BaseModelImpl<wsihash>
	implements wsihashModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a wsihash model instance should use the {@link wsihash} interface instead.
	 */
	public static final String TABLE_NAME = "DP_wsihash";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "wsihashId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "wsiId", Types.BIGINT },
			{ "filename", Types.VARCHAR },
			{ "hash", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("wsihashId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("wsiId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("filename", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("hash", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table DP_wsihash (uuid_ VARCHAR(75) null,wsihashId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,wsiId LONG,filename VARCHAR(75) null,hash VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table DP_wsihash";
	public static final String ORDER_BY_JPQL = " ORDER BY wsihash.wsiId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY DP_wsihash.wsiId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(at.graz.meduni.bibbox.digitalpathology.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.at.graz.meduni.bibbox.digitalpathology.model.wsihash"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(at.graz.meduni.bibbox.digitalpathology.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.at.graz.meduni.bibbox.digitalpathology.model.wsihash"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(at.graz.meduni.bibbox.digitalpathology.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.at.graz.meduni.bibbox.digitalpathology.model.wsihash"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long WSIID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static wsihash toModel(wsihashSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		wsihash model = new wsihashImpl();

		model.setUuid(soapModel.getUuid());
		model.setWsihashId(soapModel.getWsihashId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setWsiId(soapModel.getWsiId());
		model.setFilename(soapModel.getFilename());
		model.setHash(soapModel.getHash());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<wsihash> toModels(wsihashSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<wsihash> models = new ArrayList<wsihash>(soapModels.length);

		for (wsihashSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(at.graz.meduni.bibbox.digitalpathology.service.util.ServiceProps.get(
				"lock.expiration.time.at.graz.meduni.bibbox.digitalpathology.model.wsihash"));

	public wsihashModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _wsihashId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWsihashId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _wsihashId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return wsihash.class;
	}

	@Override
	public String getModelClassName() {
		return wsihash.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("wsihashId", getWsihashId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("wsiId", getWsiId());
		attributes.put("filename", getFilename());
		attributes.put("hash", getHash());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long wsihashId = (Long)attributes.get("wsihashId");

		if (wsihashId != null) {
			setWsihashId(wsihashId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long wsiId = (Long)attributes.get("wsiId");

		if (wsiId != null) {
			setWsiId(wsiId);
		}

		String filename = (String)attributes.get("filename");

		if (filename != null) {
			setFilename(filename);
		}

		String hash = (String)attributes.get("hash");

		if (hash != null) {
			setHash(hash);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getWsihashId() {
		return _wsihashId;
	}

	@Override
	public void setWsihashId(long wsihashId) {
		_wsihashId = wsihashId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@JSON
	@Override
	public long getWsiId() {
		return _wsiId;
	}

	@Override
	public void setWsiId(long wsiId) {
		_columnBitmask = -1L;

		if (!_setOriginalWsiId) {
			_setOriginalWsiId = true;

			_originalWsiId = _wsiId;
		}

		_wsiId = wsiId;
	}

	public long getOriginalWsiId() {
		return _originalWsiId;
	}

	@JSON
	@Override
	public String getFilename() {
		if (_filename == null) {
			return StringPool.BLANK;
		}
		else {
			return _filename;
		}
	}

	@Override
	public void setFilename(String filename) {
		_filename = filename;
	}

	@JSON
	@Override
	public String getHash() {
		if (_hash == null) {
			return StringPool.BLANK;
		}
		else {
			return _hash;
		}
	}

	@Override
	public void setHash(String hash) {
		_hash = hash;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				wsihash.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			wsihash.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public wsihash toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (wsihash)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		wsihashImpl wsihashImpl = new wsihashImpl();

		wsihashImpl.setUuid(getUuid());
		wsihashImpl.setWsihashId(getWsihashId());
		wsihashImpl.setGroupId(getGroupId());
		wsihashImpl.setCompanyId(getCompanyId());
		wsihashImpl.setUserId(getUserId());
		wsihashImpl.setUserName(getUserName());
		wsihashImpl.setCreateDate(getCreateDate());
		wsihashImpl.setModifiedDate(getModifiedDate());
		wsihashImpl.setStatus(getStatus());
		wsihashImpl.setStatusByUserId(getStatusByUserId());
		wsihashImpl.setStatusByUserName(getStatusByUserName());
		wsihashImpl.setStatusDate(getStatusDate());
		wsihashImpl.setWsiId(getWsiId());
		wsihashImpl.setFilename(getFilename());
		wsihashImpl.setHash(getHash());

		wsihashImpl.resetOriginalValues();

		return wsihashImpl;
	}

	@Override
	public int compareTo(wsihash wsihash) {
		int value = 0;

		if (getWsiId() < wsihash.getWsiId()) {
			value = -1;
		}
		else if (getWsiId() > wsihash.getWsiId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof wsihash)) {
			return false;
		}

		wsihash wsihash = (wsihash)obj;

		long primaryKey = wsihash.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		wsihashModelImpl wsihashModelImpl = this;

		wsihashModelImpl._originalUuid = wsihashModelImpl._uuid;

		wsihashModelImpl._originalGroupId = wsihashModelImpl._groupId;

		wsihashModelImpl._setOriginalGroupId = false;

		wsihashModelImpl._originalCompanyId = wsihashModelImpl._companyId;

		wsihashModelImpl._setOriginalCompanyId = false;

		wsihashModelImpl._setModifiedDate = false;

		wsihashModelImpl._originalWsiId = wsihashModelImpl._wsiId;

		wsihashModelImpl._setOriginalWsiId = false;

		wsihashModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<wsihash> toCacheModel() {
		wsihashCacheModel wsihashCacheModel = new wsihashCacheModel();

		wsihashCacheModel.uuid = getUuid();

		String uuid = wsihashCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			wsihashCacheModel.uuid = null;
		}

		wsihashCacheModel.wsihashId = getWsihashId();

		wsihashCacheModel.groupId = getGroupId();

		wsihashCacheModel.companyId = getCompanyId();

		wsihashCacheModel.userId = getUserId();

		wsihashCacheModel.userName = getUserName();

		String userName = wsihashCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			wsihashCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			wsihashCacheModel.createDate = createDate.getTime();
		}
		else {
			wsihashCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			wsihashCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			wsihashCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		wsihashCacheModel.status = getStatus();

		wsihashCacheModel.statusByUserId = getStatusByUserId();

		wsihashCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = wsihashCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			wsihashCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			wsihashCacheModel.statusDate = statusDate.getTime();
		}
		else {
			wsihashCacheModel.statusDate = Long.MIN_VALUE;
		}

		wsihashCacheModel.wsiId = getWsiId();

		wsihashCacheModel.filename = getFilename();

		String filename = wsihashCacheModel.filename;

		if ((filename != null) && (filename.length() == 0)) {
			wsihashCacheModel.filename = null;
		}

		wsihashCacheModel.hash = getHash();

		String hash = wsihashCacheModel.hash;

		if ((hash != null) && (hash.length() == 0)) {
			wsihashCacheModel.hash = null;
		}

		return wsihashCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", wsihashId=");
		sb.append(getWsihashId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", wsiId=");
		sb.append(getWsiId());
		sb.append(", filename=");
		sb.append(getFilename());
		sb.append(", hash=");
		sb.append(getHash());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.bibbox.digitalpathology.model.wsihash");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wsihashId</column-name><column-value><![CDATA[");
		sb.append(getWsihashId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wsiId</column-name><column-value><![CDATA[");
		sb.append(getWsiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filename</column-name><column-value><![CDATA[");
		sb.append(getFilename());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hash</column-name><column-value><![CDATA[");
		sb.append(getHash());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = wsihash.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			wsihash.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _wsihashId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _wsiId;
	private long _originalWsiId;
	private boolean _setOriginalWsiId;
	private String _filename;
	private String _hash;
	private long _columnBitmask;
	private wsihash _escapedModel;
}