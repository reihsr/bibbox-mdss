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
import at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLinkModel;
import at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLinkSoap;

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
 * The base model implementation for the DictionaryDictionaryLink service. Represents a row in the &quot;SAAT_DictionaryDictionaryLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DictionaryDictionaryLinkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DictionaryDictionaryLinkImpl}.
 * </p>
 *
 * @author robert
 * @see DictionaryDictionaryLinkImpl
 * @see DictionaryDictionaryLink
 * @see DictionaryDictionaryLinkModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DictionaryDictionaryLinkModelImpl extends BaseModelImpl<DictionaryDictionaryLink>
	implements DictionaryDictionaryLinkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dictionary dictionary link model instance should use the {@link DictionaryDictionaryLink} interface instead.
	 */
	public static final String TABLE_NAME = "SAAT_DictionaryDictionaryLink";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "dictionarydictionarylinkId", Types.BIGINT },
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
			{ "dictionaryId", Types.BIGINT },
			{ "linkdictionaryId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dictionarydictionarylinkId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("dictionaryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("linkdictionaryId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table SAAT_DictionaryDictionaryLink (uuid_ VARCHAR(75) null,dictionarydictionarylinkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,dictionaryId LONG,linkdictionaryId LONG)";
	public static final String TABLE_SQL_DROP = "drop table SAAT_DictionaryDictionaryLink";
	public static final String ORDER_BY_JPQL = " ORDER BY dictionaryDictionaryLink.dictionaryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SAAT_DictionaryDictionaryLink.dictionaryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(at.graz.meduni.bibbox.informationprocessing.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(at.graz.meduni.bibbox.informationprocessing.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(at.graz.meduni.bibbox.informationprocessing.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long DICTIONARYID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long LINKDICTIONARYID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DictionaryDictionaryLink toModel(
		DictionaryDictionaryLinkSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DictionaryDictionaryLink model = new DictionaryDictionaryLinkImpl();

		model.setUuid(soapModel.getUuid());
		model.setDictionarydictionarylinkId(soapModel.getDictionarydictionarylinkId());
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
		model.setDictionaryId(soapModel.getDictionaryId());
		model.setLinkdictionaryId(soapModel.getLinkdictionaryId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DictionaryDictionaryLink> toModels(
		DictionaryDictionaryLinkSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DictionaryDictionaryLink> models = new ArrayList<DictionaryDictionaryLink>(soapModels.length);

		for (DictionaryDictionaryLinkSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(at.graz.meduni.bibbox.informationprocessing.service.util.ServiceProps.get(
				"lock.expiration.time.at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink"));

	public DictionaryDictionaryLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dictionarydictionarylinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictionarydictionarylinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictionarydictionarylinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DictionaryDictionaryLink.class;
	}

	@Override
	public String getModelClassName() {
		return DictionaryDictionaryLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dictionarydictionarylinkId",
			getDictionarydictionarylinkId());
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
		attributes.put("dictionaryId", getDictionaryId());
		attributes.put("linkdictionaryId", getLinkdictionaryId());

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

		Long dictionarydictionarylinkId = (Long)attributes.get(
				"dictionarydictionarylinkId");

		if (dictionarydictionarylinkId != null) {
			setDictionarydictionarylinkId(dictionarydictionarylinkId);
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

		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
		}

		Long linkdictionaryId = (Long)attributes.get("linkdictionaryId");

		if (linkdictionaryId != null) {
			setLinkdictionaryId(linkdictionaryId);
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
	public long getDictionarydictionarylinkId() {
		return _dictionarydictionarylinkId;
	}

	@Override
	public void setDictionarydictionarylinkId(long dictionarydictionarylinkId) {
		_dictionarydictionarylinkId = dictionarydictionarylinkId;
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
	public long getDictionaryId() {
		return _dictionaryId;
	}

	@Override
	public void setDictionaryId(long dictionaryId) {
		_columnBitmask = -1L;

		if (!_setOriginalDictionaryId) {
			_setOriginalDictionaryId = true;

			_originalDictionaryId = _dictionaryId;
		}

		_dictionaryId = dictionaryId;
	}

	public long getOriginalDictionaryId() {
		return _originalDictionaryId;
	}

	@JSON
	@Override
	public long getLinkdictionaryId() {
		return _linkdictionaryId;
	}

	@Override
	public void setLinkdictionaryId(long linkdictionaryId) {
		_columnBitmask |= LINKDICTIONARYID_COLUMN_BITMASK;

		if (!_setOriginalLinkdictionaryId) {
			_setOriginalLinkdictionaryId = true;

			_originalLinkdictionaryId = _linkdictionaryId;
		}

		_linkdictionaryId = linkdictionaryId;
	}

	public long getOriginalLinkdictionaryId() {
		return _originalLinkdictionaryId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				DictionaryDictionaryLink.class.getName()));
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
			DictionaryDictionaryLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DictionaryDictionaryLink toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DictionaryDictionaryLink)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DictionaryDictionaryLinkImpl dictionaryDictionaryLinkImpl = new DictionaryDictionaryLinkImpl();

		dictionaryDictionaryLinkImpl.setUuid(getUuid());
		dictionaryDictionaryLinkImpl.setDictionarydictionarylinkId(getDictionarydictionarylinkId());
		dictionaryDictionaryLinkImpl.setGroupId(getGroupId());
		dictionaryDictionaryLinkImpl.setCompanyId(getCompanyId());
		dictionaryDictionaryLinkImpl.setUserId(getUserId());
		dictionaryDictionaryLinkImpl.setUserName(getUserName());
		dictionaryDictionaryLinkImpl.setCreateDate(getCreateDate());
		dictionaryDictionaryLinkImpl.setModifiedDate(getModifiedDate());
		dictionaryDictionaryLinkImpl.setStatus(getStatus());
		dictionaryDictionaryLinkImpl.setStatusByUserId(getStatusByUserId());
		dictionaryDictionaryLinkImpl.setStatusByUserName(getStatusByUserName());
		dictionaryDictionaryLinkImpl.setStatusDate(getStatusDate());
		dictionaryDictionaryLinkImpl.setDictionaryId(getDictionaryId());
		dictionaryDictionaryLinkImpl.setLinkdictionaryId(getLinkdictionaryId());

		dictionaryDictionaryLinkImpl.resetOriginalValues();

		return dictionaryDictionaryLinkImpl;
	}

	@Override
	public int compareTo(DictionaryDictionaryLink dictionaryDictionaryLink) {
		int value = 0;

		if (getDictionaryId() < dictionaryDictionaryLink.getDictionaryId()) {
			value = -1;
		}
		else if (getDictionaryId() > dictionaryDictionaryLink.getDictionaryId()) {
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

		if (!(obj instanceof DictionaryDictionaryLink)) {
			return false;
		}

		DictionaryDictionaryLink dictionaryDictionaryLink = (DictionaryDictionaryLink)obj;

		long primaryKey = dictionaryDictionaryLink.getPrimaryKey();

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
		DictionaryDictionaryLinkModelImpl dictionaryDictionaryLinkModelImpl = this;

		dictionaryDictionaryLinkModelImpl._originalUuid = dictionaryDictionaryLinkModelImpl._uuid;

		dictionaryDictionaryLinkModelImpl._originalGroupId = dictionaryDictionaryLinkModelImpl._groupId;

		dictionaryDictionaryLinkModelImpl._setOriginalGroupId = false;

		dictionaryDictionaryLinkModelImpl._originalCompanyId = dictionaryDictionaryLinkModelImpl._companyId;

		dictionaryDictionaryLinkModelImpl._setOriginalCompanyId = false;

		dictionaryDictionaryLinkModelImpl._setModifiedDate = false;

		dictionaryDictionaryLinkModelImpl._originalDictionaryId = dictionaryDictionaryLinkModelImpl._dictionaryId;

		dictionaryDictionaryLinkModelImpl._setOriginalDictionaryId = false;

		dictionaryDictionaryLinkModelImpl._originalLinkdictionaryId = dictionaryDictionaryLinkModelImpl._linkdictionaryId;

		dictionaryDictionaryLinkModelImpl._setOriginalLinkdictionaryId = false;

		dictionaryDictionaryLinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DictionaryDictionaryLink> toCacheModel() {
		DictionaryDictionaryLinkCacheModel dictionaryDictionaryLinkCacheModel = new DictionaryDictionaryLinkCacheModel();

		dictionaryDictionaryLinkCacheModel.uuid = getUuid();

		String uuid = dictionaryDictionaryLinkCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dictionaryDictionaryLinkCacheModel.uuid = null;
		}

		dictionaryDictionaryLinkCacheModel.dictionarydictionarylinkId = getDictionarydictionarylinkId();

		dictionaryDictionaryLinkCacheModel.groupId = getGroupId();

		dictionaryDictionaryLinkCacheModel.companyId = getCompanyId();

		dictionaryDictionaryLinkCacheModel.userId = getUserId();

		dictionaryDictionaryLinkCacheModel.userName = getUserName();

		String userName = dictionaryDictionaryLinkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dictionaryDictionaryLinkCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dictionaryDictionaryLinkCacheModel.createDate = createDate.getTime();
		}
		else {
			dictionaryDictionaryLinkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dictionaryDictionaryLinkCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dictionaryDictionaryLinkCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dictionaryDictionaryLinkCacheModel.status = getStatus();

		dictionaryDictionaryLinkCacheModel.statusByUserId = getStatusByUserId();

		dictionaryDictionaryLinkCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = dictionaryDictionaryLinkCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			dictionaryDictionaryLinkCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			dictionaryDictionaryLinkCacheModel.statusDate = statusDate.getTime();
		}
		else {
			dictionaryDictionaryLinkCacheModel.statusDate = Long.MIN_VALUE;
		}

		dictionaryDictionaryLinkCacheModel.dictionaryId = getDictionaryId();

		dictionaryDictionaryLinkCacheModel.linkdictionaryId = getLinkdictionaryId();

		return dictionaryDictionaryLinkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", dictionarydictionarylinkId=");
		sb.append(getDictionarydictionarylinkId());
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
		sb.append(", dictionaryId=");
		sb.append(getDictionaryId());
		sb.append(", linkdictionaryId=");
		sb.append(getLinkdictionaryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dictionarydictionarylinkId</column-name><column-value><![CDATA[");
		sb.append(getDictionarydictionarylinkId());
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
			"<column><column-name>dictionaryId</column-name><column-value><![CDATA[");
		sb.append(getDictionaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkdictionaryId</column-name><column-value><![CDATA[");
		sb.append(getLinkdictionaryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DictionaryDictionaryLink.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DictionaryDictionaryLink.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _dictionarydictionarylinkId;
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
	private long _dictionaryId;
	private long _originalDictionaryId;
	private boolean _setOriginalDictionaryId;
	private long _linkdictionaryId;
	private long _originalLinkdictionaryId;
	private boolean _setOriginalLinkdictionaryId;
	private long _columnBitmask;
	private DictionaryDictionaryLink _escapedModel;
}