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

package at.graz.meduni.bibbox.medicaldataset.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException;
import at.graz.meduni.bibbox.medicaldataset.model.PathologyData;
import at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataImpl;
import at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataModelImpl;
import at.graz.meduni.bibbox.medicaldataset.service.persistence.PathologyDataPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the pathology data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PathologyDataPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.PathologyDataUtil
 * @generated
 */
@ProviderType
public class PathologyDataPersistenceImpl extends BasePersistenceImpl<PathologyData>
	implements PathologyDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PathologyDataUtil} to access the pathology data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PathologyDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			PathologyDataModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the pathology datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pathology datas
	 */
	@Override
	public List<PathologyData> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pathology datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @return the range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathology datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByUuid(String uuid, int start, int end,
		OrderByComparator<PathologyData> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pathology datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByUuid(String uuid, int start, int end,
		OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<PathologyData> list = null;

		if (retrieveFromCache) {
			list = (List<PathologyData>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PathologyData pathologyData : list) {
					if (!Objects.equals(uuid, pathologyData.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PathologyDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<PathologyData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PathologyData>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first pathology data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathology data
	 * @throws NoSuchPathologyDataException if a matching pathology data could not be found
	 */
	@Override
	public PathologyData findByUuid_First(String uuid,
		OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByUuid_First(uuid, orderByComparator);

		if (pathologyData != null) {
			return pathologyData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologyDataException(msg.toString());
	}

	/**
	 * Returns the first pathology data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByUuid_First(String uuid,
		OrderByComparator<PathologyData> orderByComparator) {
		List<PathologyData> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pathology data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathology data
	 * @throws NoSuchPathologyDataException if a matching pathology data could not be found
	 */
	@Override
	public PathologyData findByUuid_Last(String uuid,
		OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByUuid_Last(uuid, orderByComparator);

		if (pathologyData != null) {
			return pathologyData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologyDataException(msg.toString());
	}

	/**
	 * Returns the last pathology data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByUuid_Last(String uuid,
		OrderByComparator<PathologyData> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PathologyData> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pathology datas before and after the current pathology data in the ordered set where uuid = &#63;.
	 *
	 * @param pathologyDataId the primary key of the current pathology data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pathology data
	 * @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData[] findByUuid_PrevAndNext(long pathologyDataId,
		String uuid, OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = findByPrimaryKey(pathologyDataId);

		Session session = null;

		try {
			session = openSession();

			PathologyData[] array = new PathologyDataImpl[3];

			array[0] = getByUuid_PrevAndNext(session, pathologyData, uuid,
					orderByComparator, true);

			array[1] = pathologyData;

			array[2] = getByUuid_PrevAndNext(session, pathologyData, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PathologyData getByUuid_PrevAndNext(Session session,
		PathologyData pathologyData, String uuid,
		OrderByComparator<PathologyData> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PathologyDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pathologyData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PathologyData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pathology datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PathologyData pathologyData : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(pathologyData);
		}
	}

	/**
	 * Returns the number of pathology datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pathology datas
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATHOLOGYDATA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "pathologyData.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "pathologyData.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(pathologyData.uuid IS NULL OR pathologyData.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PathologyDataModelImpl.UUID_COLUMN_BITMASK |
			PathologyDataModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the pathology data where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPathologyDataException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pathology data
	 * @throws NoSuchPathologyDataException if a matching pathology data could not be found
	 */
	@Override
	public PathologyData findByUUID_G(String uuid, long groupId)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByUUID_G(uuid, groupId);

		if (pathologyData == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPathologyDataException(msg.toString());
		}

		return pathologyData;
	}

	/**
	 * Returns the pathology data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the pathology data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PathologyData) {
			PathologyData pathologyData = (PathologyData)result;

			if (!Objects.equals(uuid, pathologyData.getUuid()) ||
					(groupId != pathologyData.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<PathologyData> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PathologyData pathologyData = list.get(0);

					result = pathologyData;

					cacheResult(pathologyData);

					if ((pathologyData.getUuid() == null) ||
							!pathologyData.getUuid().equals(uuid) ||
							(pathologyData.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, pathologyData);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PathologyData)result;
		}
	}

	/**
	 * Removes the pathology data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pathology data that was removed
	 */
	@Override
	public PathologyData removeByUUID_G(String uuid, long groupId)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = findByUUID_G(uuid, groupId);

		return remove(pathologyData);
	}

	/**
	 * Returns the number of pathology datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pathology datas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATHOLOGYDATA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "pathologyData.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "pathologyData.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(pathologyData.uuid IS NULL OR pathologyData.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "pathologyData.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PathologyDataModelImpl.UUID_COLUMN_BITMASK |
			PathologyDataModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the pathology datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pathology datas
	 */
	@Override
	public List<PathologyData> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pathology datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @return the range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathology datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<PathologyData> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pathology datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<PathologyData> list = null;

		if (retrieveFromCache) {
			list = (List<PathologyData>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PathologyData pathologyData : list) {
					if (!Objects.equals(uuid, pathologyData.getUuid()) ||
							(companyId != pathologyData.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PathologyDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<PathologyData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PathologyData>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathology data
	 * @throws NoSuchPathologyDataException if a matching pathology data could not be found
	 */
	@Override
	public PathologyData findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (pathologyData != null) {
			return pathologyData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologyDataException(msg.toString());
	}

	/**
	 * Returns the first pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<PathologyData> orderByComparator) {
		List<PathologyData> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathology data
	 * @throws NoSuchPathologyDataException if a matching pathology data could not be found
	 */
	@Override
	public PathologyData findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (pathologyData != null) {
			return pathologyData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologyDataException(msg.toString());
	}

	/**
	 * Returns the last pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<PathologyData> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PathologyData> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pathology datas before and after the current pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pathologyDataId the primary key of the current pathology data
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pathology data
	 * @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData[] findByUuid_C_PrevAndNext(long pathologyDataId,
		String uuid, long companyId,
		OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = findByPrimaryKey(pathologyDataId);

		Session session = null;

		try {
			session = openSession();

			PathologyData[] array = new PathologyDataImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, pathologyData, uuid,
					companyId, orderByComparator, true);

			array[1] = pathologyData;

			array[2] = getByUuid_C_PrevAndNext(session, pathologyData, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PathologyData getByUuid_C_PrevAndNext(Session session,
		PathologyData pathologyData, String uuid, long companyId,
		OrderByComparator<PathologyData> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PathologyDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pathologyData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PathologyData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pathology datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PathologyData pathologyData : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(pathologyData);
		}
	}

	/**
	 * Returns the number of pathology datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pathology datas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATHOLOGYDATA_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "pathologyData.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "pathologyData.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(pathologyData.uuid IS NULL OR pathologyData.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "pathologyData.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			PathologyDataModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the pathology datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching pathology datas
	 */
	@Override
	public List<PathologyData> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pathology datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @return the range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathology datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByGroupId(long groupId, int start, int end,
		OrderByComparator<PathologyData> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pathology datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByGroupId(long groupId, int start, int end,
		OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<PathologyData> list = null;

		if (retrieveFromCache) {
			list = (List<PathologyData>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PathologyData pathologyData : list) {
					if ((groupId != pathologyData.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PathologyDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<PathologyData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PathologyData>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first pathology data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathology data
	 * @throws NoSuchPathologyDataException if a matching pathology data could not be found
	 */
	@Override
	public PathologyData findByGroupId_First(long groupId,
		OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByGroupId_First(groupId,
				orderByComparator);

		if (pathologyData != null) {
			return pathologyData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologyDataException(msg.toString());
	}

	/**
	 * Returns the first pathology data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByGroupId_First(long groupId,
		OrderByComparator<PathologyData> orderByComparator) {
		List<PathologyData> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pathology data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathology data
	 * @throws NoSuchPathologyDataException if a matching pathology data could not be found
	 */
	@Override
	public PathologyData findByGroupId_Last(long groupId,
		OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (pathologyData != null) {
			return pathologyData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologyDataException(msg.toString());
	}

	/**
	 * Returns the last pathology data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByGroupId_Last(long groupId,
		OrderByComparator<PathologyData> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<PathologyData> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pathology datas before and after the current pathology data in the ordered set where groupId = &#63;.
	 *
	 * @param pathologyDataId the primary key of the current pathology data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pathology data
	 * @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData[] findByGroupId_PrevAndNext(long pathologyDataId,
		long groupId, OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = findByPrimaryKey(pathologyDataId);

		Session session = null;

		try {
			session = openSession();

			PathologyData[] array = new PathologyDataImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, pathologyData,
					groupId, orderByComparator, true);

			array[1] = pathologyData;

			array[2] = getByGroupId_PrevAndNext(session, pathologyData,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PathologyData getByGroupId_PrevAndNext(Session session,
		PathologyData pathologyData, long groupId,
		OrderByComparator<PathologyData> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PathologyDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pathologyData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PathologyData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the pathology datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching pathology datas that the user has permission to view
	 */
	@Override
	public List<PathologyData> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pathology datas that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @return the range of matching pathology datas that the user has permission to view
	 */
	@Override
	public List<PathologyData> filterFindByGroupId(long groupId, int start,
		int end) {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathology datas that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pathology datas that the user has permission to view
	 */
	@Override
	public List<PathologyData> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator<PathologyData> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PATHOLOGYDATA_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PATHOLOGYDATA_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PATHOLOGYDATA_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(PathologyDataModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PathologyDataModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PathologyData.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, PathologyDataImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, PathologyDataImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<PathologyData>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the pathology datas before and after the current pathology data in the ordered set of pathology datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param pathologyDataId the primary key of the current pathology data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pathology data
	 * @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData[] filterFindByGroupId_PrevAndNext(
		long pathologyDataId, long groupId,
		OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(pathologyDataId, groupId,
				orderByComparator);
		}

		PathologyData pathologyData = findByPrimaryKey(pathologyDataId);

		Session session = null;

		try {
			session = openSession();

			PathologyData[] array = new PathologyDataImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, pathologyData,
					groupId, orderByComparator, true);

			array[1] = pathologyData;

			array[2] = filterGetByGroupId_PrevAndNext(session, pathologyData,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PathologyData filterGetByGroupId_PrevAndNext(Session session,
		PathologyData pathologyData, long groupId,
		OrderByComparator<PathologyData> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PATHOLOGYDATA_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_PATHOLOGYDATA_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_PATHOLOGYDATA_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(PathologyDataModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(PathologyDataModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PathologyData.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, PathologyDataImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, PathologyDataImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pathologyData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PathologyData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pathology datas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (PathologyData pathologyData : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(pathologyData);
		}
	}

	/**
	 * Returns the number of pathology datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching pathology datas
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATHOLOGYDATA_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of pathology datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching pathology datas that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_PATHOLOGYDATA_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				PathologyData.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "pathologyData.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MATERIAL = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMaterial",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL =
		new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMaterial", new String[] { String.class.getName() },
			PathologyDataModelImpl.MATERIAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MATERIAL = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaterial",
			new String[] { String.class.getName() });

	/**
	 * Returns all the pathology datas where material = &#63;.
	 *
	 * @param material the material
	 * @return the matching pathology datas
	 */
	@Override
	public List<PathologyData> findByMaterial(String material) {
		return findByMaterial(material, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the pathology datas where material = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param material the material
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @return the range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByMaterial(String material, int start,
		int end) {
		return findByMaterial(material, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathology datas where material = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param material the material
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByMaterial(String material, int start,
		int end, OrderByComparator<PathologyData> orderByComparator) {
		return findByMaterial(material, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pathology datas where material = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param material the material
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pathology datas
	 */
	@Override
	public List<PathologyData> findByMaterial(String material, int start,
		int end, OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL;
			finderArgs = new Object[] { material };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MATERIAL;
			finderArgs = new Object[] { material, start, end, orderByComparator };
		}

		List<PathologyData> list = null;

		if (retrieveFromCache) {
			list = (List<PathologyData>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PathologyData pathologyData : list) {
					if (!Objects.equals(material, pathologyData.getMaterial())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE);

			boolean bindMaterial = false;

			if (material == null) {
				query.append(_FINDER_COLUMN_MATERIAL_MATERIAL_1);
			}
			else if (material.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MATERIAL_MATERIAL_3);
			}
			else {
				bindMaterial = true;

				query.append(_FINDER_COLUMN_MATERIAL_MATERIAL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PathologyDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMaterial) {
					qPos.add(material);
				}

				if (!pagination) {
					list = (List<PathologyData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PathologyData>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first pathology data in the ordered set where material = &#63;.
	 *
	 * @param material the material
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathology data
	 * @throws NoSuchPathologyDataException if a matching pathology data could not be found
	 */
	@Override
	public PathologyData findByMaterial_First(String material,
		OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByMaterial_First(material,
				orderByComparator);

		if (pathologyData != null) {
			return pathologyData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("material=");
		msg.append(material);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologyDataException(msg.toString());
	}

	/**
	 * Returns the first pathology data in the ordered set where material = &#63;.
	 *
	 * @param material the material
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByMaterial_First(String material,
		OrderByComparator<PathologyData> orderByComparator) {
		List<PathologyData> list = findByMaterial(material, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pathology data in the ordered set where material = &#63;.
	 *
	 * @param material the material
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathology data
	 * @throws NoSuchPathologyDataException if a matching pathology data could not be found
	 */
	@Override
	public PathologyData findByMaterial_Last(String material,
		OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByMaterial_Last(material,
				orderByComparator);

		if (pathologyData != null) {
			return pathologyData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("material=");
		msg.append(material);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologyDataException(msg.toString());
	}

	/**
	 * Returns the last pathology data in the ordered set where material = &#63;.
	 *
	 * @param material the material
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByMaterial_Last(String material,
		OrderByComparator<PathologyData> orderByComparator) {
		int count = countByMaterial(material);

		if (count == 0) {
			return null;
		}

		List<PathologyData> list = findByMaterial(material, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pathology datas before and after the current pathology data in the ordered set where material = &#63;.
	 *
	 * @param pathologyDataId the primary key of the current pathology data
	 * @param material the material
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pathology data
	 * @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData[] findByMaterial_PrevAndNext(long pathologyDataId,
		String material, OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = findByPrimaryKey(pathologyDataId);

		Session session = null;

		try {
			session = openSession();

			PathologyData[] array = new PathologyDataImpl[3];

			array[0] = getByMaterial_PrevAndNext(session, pathologyData,
					material, orderByComparator, true);

			array[1] = pathologyData;

			array[2] = getByMaterial_PrevAndNext(session, pathologyData,
					material, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PathologyData getByMaterial_PrevAndNext(Session session,
		PathologyData pathologyData, String material,
		OrderByComparator<PathologyData> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE);

		boolean bindMaterial = false;

		if (material == null) {
			query.append(_FINDER_COLUMN_MATERIAL_MATERIAL_1);
		}
		else if (material.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MATERIAL_MATERIAL_3);
		}
		else {
			bindMaterial = true;

			query.append(_FINDER_COLUMN_MATERIAL_MATERIAL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PathologyDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMaterial) {
			qPos.add(material);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pathologyData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PathologyData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pathology datas where material = &#63; from the database.
	 *
	 * @param material the material
	 */
	@Override
	public void removeByMaterial(String material) {
		for (PathologyData pathologyData : findByMaterial(material,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(pathologyData);
		}
	}

	/**
	 * Returns the number of pathology datas where material = &#63;.
	 *
	 * @param material the material
	 * @return the number of matching pathology datas
	 */
	@Override
	public int countByMaterial(String material) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MATERIAL;

		Object[] finderArgs = new Object[] { material };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATHOLOGYDATA_WHERE);

			boolean bindMaterial = false;

			if (material == null) {
				query.append(_FINDER_COLUMN_MATERIAL_MATERIAL_1);
			}
			else if (material.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MATERIAL_MATERIAL_3);
			}
			else {
				bindMaterial = true;

				query.append(_FINDER_COLUMN_MATERIAL_MATERIAL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMaterial) {
					qPos.add(material);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MATERIAL_MATERIAL_1 = "pathologyData.material IS NULL";
	private static final String _FINDER_COLUMN_MATERIAL_MATERIAL_2 = "pathologyData.material = ?";
	private static final String _FINDER_COLUMN_MATERIAL_MATERIAL_3 = "(pathologyData.material IS NULL OR pathologyData.material = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_MEDICALRECORD = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED,
			PathologyDataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMedicalRecord", new String[] { Long.class.getName() },
			PathologyDataModelImpl.MEDICALRECORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEDICALRECORD = new FinderPath(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMedicalRecord",
			new String[] { Long.class.getName() });

	/**
	 * Returns the pathology data where medicalRecordId = &#63; or throws a {@link NoSuchPathologyDataException} if it could not be found.
	 *
	 * @param medicalRecordId the medical record ID
	 * @return the matching pathology data
	 * @throws NoSuchPathologyDataException if a matching pathology data could not be found
	 */
	@Override
	public PathologyData findByMedicalRecord(long medicalRecordId)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByMedicalRecord(medicalRecordId);

		if (pathologyData == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("medicalRecordId=");
			msg.append(medicalRecordId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPathologyDataException(msg.toString());
		}

		return pathologyData;
	}

	/**
	 * Returns the pathology data where medicalRecordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param medicalRecordId the medical record ID
	 * @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByMedicalRecord(long medicalRecordId) {
		return fetchByMedicalRecord(medicalRecordId, true);
	}

	/**
	 * Returns the pathology data where medicalRecordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param medicalRecordId the medical record ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	 */
	@Override
	public PathologyData fetchByMedicalRecord(long medicalRecordId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { medicalRecordId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_MEDICALRECORD,
					finderArgs, this);
		}

		if (result instanceof PathologyData) {
			PathologyData pathologyData = (PathologyData)result;

			if ((medicalRecordId != pathologyData.getMedicalRecordId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE);

			query.append(_FINDER_COLUMN_MEDICALRECORD_MEDICALRECORDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(medicalRecordId);

				List<PathologyData> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_MEDICALRECORD,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"PathologyDataPersistenceImpl.fetchByMedicalRecord(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PathologyData pathologyData = list.get(0);

					result = pathologyData;

					cacheResult(pathologyData);

					if ((pathologyData.getMedicalRecordId() != medicalRecordId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_MEDICALRECORD,
							finderArgs, pathologyData);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_MEDICALRECORD,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PathologyData)result;
		}
	}

	/**
	 * Removes the pathology data where medicalRecordId = &#63; from the database.
	 *
	 * @param medicalRecordId the medical record ID
	 * @return the pathology data that was removed
	 */
	@Override
	public PathologyData removeByMedicalRecord(long medicalRecordId)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = findByMedicalRecord(medicalRecordId);

		return remove(pathologyData);
	}

	/**
	 * Returns the number of pathology datas where medicalRecordId = &#63;.
	 *
	 * @param medicalRecordId the medical record ID
	 * @return the number of matching pathology datas
	 */
	@Override
	public int countByMedicalRecord(long medicalRecordId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEDICALRECORD;

		Object[] finderArgs = new Object[] { medicalRecordId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATHOLOGYDATA_WHERE);

			query.append(_FINDER_COLUMN_MEDICALRECORD_MEDICALRECORDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(medicalRecordId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MEDICALRECORD_MEDICALRECORDID_2 = "pathologyData.medicalRecordId = ?";

	public PathologyDataPersistenceImpl() {
		setModelClass(PathologyData.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
			dbColumnNames.put("comment", "comment_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the pathology data in the entity cache if it is enabled.
	 *
	 * @param pathologyData the pathology data
	 */
	@Override
	public void cacheResult(PathologyData pathologyData) {
		entityCache.putResult(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataImpl.class, pathologyData.getPrimaryKey(),
			pathologyData);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { pathologyData.getUuid(), pathologyData.getGroupId() },
			pathologyData);

		finderCache.putResult(FINDER_PATH_FETCH_BY_MEDICALRECORD,
			new Object[] { pathologyData.getMedicalRecordId() }, pathologyData);

		pathologyData.resetOriginalValues();
	}

	/**
	 * Caches the pathology datas in the entity cache if it is enabled.
	 *
	 * @param pathologyDatas the pathology datas
	 */
	@Override
	public void cacheResult(List<PathologyData> pathologyDatas) {
		for (PathologyData pathologyData : pathologyDatas) {
			if (entityCache.getResult(
						PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
						PathologyDataImpl.class, pathologyData.getPrimaryKey()) == null) {
				cacheResult(pathologyData);
			}
			else {
				pathologyData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pathology datas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PathologyDataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pathology data.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PathologyData pathologyData) {
		entityCache.removeResult(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataImpl.class, pathologyData.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PathologyDataModelImpl)pathologyData, true);
	}

	@Override
	public void clearCache(List<PathologyData> pathologyDatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PathologyData pathologyData : pathologyDatas) {
			entityCache.removeResult(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
				PathologyDataImpl.class, pathologyData.getPrimaryKey());

			clearUniqueFindersCache((PathologyDataModelImpl)pathologyData, true);
		}
	}

	protected void cacheUniqueFindersCache(
		PathologyDataModelImpl pathologyDataModelImpl) {
		Object[] args = new Object[] {
				pathologyDataModelImpl.getUuid(),
				pathologyDataModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			pathologyDataModelImpl, false);

		args = new Object[] { pathologyDataModelImpl.getMedicalRecordId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_MEDICALRECORD, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_MEDICALRECORD, args,
			pathologyDataModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PathologyDataModelImpl pathologyDataModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					pathologyDataModelImpl.getUuid(),
					pathologyDataModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((pathologyDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					pathologyDataModelImpl.getOriginalUuid(),
					pathologyDataModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					pathologyDataModelImpl.getMedicalRecordId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MEDICALRECORD, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MEDICALRECORD, args);
		}

		if ((pathologyDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MEDICALRECORD.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					pathologyDataModelImpl.getOriginalMedicalRecordId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MEDICALRECORD, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MEDICALRECORD, args);
		}
	}

	/**
	 * Creates a new pathology data with the primary key. Does not add the pathology data to the database.
	 *
	 * @param pathologyDataId the primary key for the new pathology data
	 * @return the new pathology data
	 */
	@Override
	public PathologyData create(long pathologyDataId) {
		PathologyData pathologyData = new PathologyDataImpl();

		pathologyData.setNew(true);
		pathologyData.setPrimaryKey(pathologyDataId);

		String uuid = PortalUUIDUtil.generate();

		pathologyData.setUuid(uuid);

		pathologyData.setCompanyId(companyProvider.getCompanyId());

		return pathologyData;
	}

	/**
	 * Removes the pathology data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pathologyDataId the primary key of the pathology data
	 * @return the pathology data that was removed
	 * @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData remove(long pathologyDataId)
		throws NoSuchPathologyDataException {
		return remove((Serializable)pathologyDataId);
	}

	/**
	 * Removes the pathology data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pathology data
	 * @return the pathology data that was removed
	 * @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData remove(Serializable primaryKey)
		throws NoSuchPathologyDataException {
		Session session = null;

		try {
			session = openSession();

			PathologyData pathologyData = (PathologyData)session.get(PathologyDataImpl.class,
					primaryKey);

			if (pathologyData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPathologyDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pathologyData);
		}
		catch (NoSuchPathologyDataException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PathologyData removeImpl(PathologyData pathologyData) {
		pathologyData = toUnwrappedModel(pathologyData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pathologyData)) {
				pathologyData = (PathologyData)session.get(PathologyDataImpl.class,
						pathologyData.getPrimaryKeyObj());
			}

			if (pathologyData != null) {
				session.delete(pathologyData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (pathologyData != null) {
			clearCache(pathologyData);
		}

		return pathologyData;
	}

	@Override
	public PathologyData updateImpl(PathologyData pathologyData) {
		pathologyData = toUnwrappedModel(pathologyData);

		boolean isNew = pathologyData.isNew();

		PathologyDataModelImpl pathologyDataModelImpl = (PathologyDataModelImpl)pathologyData;

		if (Validator.isNull(pathologyData.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			pathologyData.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (pathologyData.getCreateDate() == null)) {
			if (serviceContext == null) {
				pathologyData.setCreateDate(now);
			}
			else {
				pathologyData.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!pathologyDataModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				pathologyData.setModifiedDate(now);
			}
			else {
				pathologyData.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (pathologyData.isNew()) {
				session.save(pathologyData);

				pathologyData.setNew(false);
			}
			else {
				pathologyData = (PathologyData)session.merge(pathologyData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PathologyDataModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { pathologyDataModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					pathologyDataModelImpl.getUuid(),
					pathologyDataModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { pathologyDataModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] { pathologyDataModelImpl.getMaterial() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MATERIAL, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((pathologyDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pathologyDataModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { pathologyDataModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((pathologyDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pathologyDataModelImpl.getOriginalUuid(),
						pathologyDataModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						pathologyDataModelImpl.getUuid(),
						pathologyDataModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((pathologyDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pathologyDataModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { pathologyDataModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((pathologyDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pathologyDataModelImpl.getOriginalMaterial()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MATERIAL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL,
					args);

				args = new Object[] { pathologyDataModelImpl.getMaterial() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MATERIAL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL,
					args);
			}
		}

		entityCache.putResult(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologyDataImpl.class, pathologyData.getPrimaryKey(),
			pathologyData, false);

		clearUniqueFindersCache(pathologyDataModelImpl, false);
		cacheUniqueFindersCache(pathologyDataModelImpl);

		pathologyData.resetOriginalValues();

		return pathologyData;
	}

	protected PathologyData toUnwrappedModel(PathologyData pathologyData) {
		if (pathologyData instanceof PathologyDataImpl) {
			return pathologyData;
		}

		PathologyDataImpl pathologyDataImpl = new PathologyDataImpl();

		pathologyDataImpl.setNew(pathologyData.isNew());
		pathologyDataImpl.setPrimaryKey(pathologyData.getPrimaryKey());

		pathologyDataImpl.setUuid(pathologyData.getUuid());
		pathologyDataImpl.setPathologyDataId(pathologyData.getPathologyDataId());
		pathologyDataImpl.setGroupId(pathologyData.getGroupId());
		pathologyDataImpl.setCompanyId(pathologyData.getCompanyId());
		pathologyDataImpl.setUserId(pathologyData.getUserId());
		pathologyDataImpl.setUserName(pathologyData.getUserName());
		pathologyDataImpl.setCreateDate(pathologyData.getCreateDate());
		pathologyDataImpl.setModifiedDate(pathologyData.getModifiedDate());
		pathologyDataImpl.setStatus(pathologyData.getStatus());
		pathologyDataImpl.setStatusByUserId(pathologyData.getStatusByUserId());
		pathologyDataImpl.setStatusByUserName(pathologyData.getStatusByUserName());
		pathologyDataImpl.setStatusDate(pathologyData.getStatusDate());
		pathologyDataImpl.setMedicalRecordId(pathologyData.getMedicalRecordId());
		pathologyDataImpl.setReceivedDate(pathologyData.getReceivedDate());
		pathologyDataImpl.setValidationDate(pathologyData.getValidationDate());
		pathologyDataImpl.setPatientAge(pathologyData.getPatientAge());
		pathologyDataImpl.setSender(pathologyData.getSender());
		pathologyDataImpl.setExtractionMethode(pathologyData.getExtractionMethode());
		pathologyDataImpl.setReportingPhysician1(pathologyData.getReportingPhysician1());
		pathologyDataImpl.setReportingPhysician2(pathologyData.getReportingPhysician2());
		pathologyDataImpl.setGynPhysician(pathologyData.getGynPhysician());
		pathologyDataImpl.setValidationPhysician1(pathologyData.getValidationPhysician1());
		pathologyDataImpl.setValidationPhysician2(pathologyData.getValidationPhysician2());
		pathologyDataImpl.setReportStatus(pathologyData.getReportStatus());
		pathologyDataImpl.setNumberOfBlockes(pathologyData.getNumberOfBlockes());
		pathologyDataImpl.setNumberOfSlides(pathologyData.getNumberOfSlides());
		pathologyDataImpl.setBasicDisease(pathologyData.getBasicDisease());
		pathologyDataImpl.setCauseOfDeath(pathologyData.getCauseOfDeath());
		pathologyDataImpl.setMaterial(pathologyData.getMaterial());
		pathologyDataImpl.setMaterialExtended(pathologyData.getMaterialExtended());
		pathologyDataImpl.setMacroscopicDescription(pathologyData.getMacroscopicDescription());
		pathologyDataImpl.setMicroscopicDescription(pathologyData.getMicroscopicDescription());
		pathologyDataImpl.setHistologicDescription(pathologyData.getHistologicDescription());
		pathologyDataImpl.setMolecularPathologicDescription(pathologyData.getMolecularPathologicDescription());
		pathologyDataImpl.setZytologieDescription(pathologyData.getZytologieDescription());
		pathologyDataImpl.setPathologicDiagnosis(pathologyData.getPathologicDiagnosis());
		pathologyDataImpl.setFrozenSectionDiagnosis(pathologyData.getFrozenSectionDiagnosis());
		pathologyDataImpl.setMolecularPathologicDiagnosis(pathologyData.getMolecularPathologicDiagnosis());
		pathologyDataImpl.setZytologieDiagnosis(pathologyData.getZytologieDiagnosis());
		pathologyDataImpl.setNeuroPathologicDiagnosis(pathologyData.getNeuroPathologicDiagnosis());
		pathologyDataImpl.setComment(pathologyData.getComment());
		pathologyDataImpl.setZytologiecomment(pathologyData.getZytologiecomment());
		pathologyDataImpl.setGrad(pathologyData.getGrad());
		pathologyDataImpl.setTnmp(pathologyData.getTnmp());
		pathologyDataImpl.setTnmt(pathologyData.getTnmt());
		pathologyDataImpl.setTnmn(pathologyData.getTnmn());
		pathologyDataImpl.setTnmm(pathologyData.getTnmm());
		pathologyDataImpl.setTnmr(pathologyData.getTnmr());
		pathologyDataImpl.setTnml(pathologyData.getTnml());
		pathologyDataImpl.setTnmv(pathologyData.getTnmv());
		pathologyDataImpl.setTnmpn(pathologyData.getTnmpn());
		pathologyDataImpl.setDgcode1(pathologyData.getDgcode1());
		pathologyDataImpl.setDgcode2(pathologyData.getDgcode2());
		pathologyDataImpl.setPap(pathologyData.getPap());
		pathologyDataImpl.setSmearQuality(pathologyData.getSmearQuality());

		return pathologyDataImpl;
	}

	/**
	 * Returns the pathology data with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pathology data
	 * @return the pathology data
	 * @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPathologyDataException {
		PathologyData pathologyData = fetchByPrimaryKey(primaryKey);

		if (pathologyData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPathologyDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return pathologyData;
	}

	/**
	 * Returns the pathology data with the primary key or throws a {@link NoSuchPathologyDataException} if it could not be found.
	 *
	 * @param pathologyDataId the primary key of the pathology data
	 * @return the pathology data
	 * @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData findByPrimaryKey(long pathologyDataId)
		throws NoSuchPathologyDataException {
		return findByPrimaryKey((Serializable)pathologyDataId);
	}

	/**
	 * Returns the pathology data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pathology data
	 * @return the pathology data, or <code>null</code> if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
				PathologyDataImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PathologyData pathologyData = (PathologyData)serializable;

		if (pathologyData == null) {
			Session session = null;

			try {
				session = openSession();

				pathologyData = (PathologyData)session.get(PathologyDataImpl.class,
						primaryKey);

				if (pathologyData != null) {
					cacheResult(pathologyData);
				}
				else {
					entityCache.putResult(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
						PathologyDataImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
					PathologyDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return pathologyData;
	}

	/**
	 * Returns the pathology data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pathologyDataId the primary key of the pathology data
	 * @return the pathology data, or <code>null</code> if a pathology data with the primary key could not be found
	 */
	@Override
	public PathologyData fetchByPrimaryKey(long pathologyDataId) {
		return fetchByPrimaryKey((Serializable)pathologyDataId);
	}

	@Override
	public Map<Serializable, PathologyData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PathologyData> map = new HashMap<Serializable, PathologyData>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PathologyData pathologyData = fetchByPrimaryKey(primaryKey);

			if (pathologyData != null) {
				map.put(primaryKey, pathologyData);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
					PathologyDataImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PathologyData)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PATHOLOGYDATA_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (PathologyData pathologyData : (List<PathologyData>)q.list()) {
				map.put(pathologyData.getPrimaryKeyObj(), pathologyData);

				cacheResult(pathologyData);

				uncachedPrimaryKeys.remove(pathologyData.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PathologyDataModelImpl.ENTITY_CACHE_ENABLED,
					PathologyDataImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the pathology datas.
	 *
	 * @return the pathology datas
	 */
	@Override
	public List<PathologyData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pathology datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @return the range of pathology datas
	 */
	@Override
	public List<PathologyData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathology datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pathology datas
	 */
	@Override
	public List<PathologyData> findAll(int start, int end,
		OrderByComparator<PathologyData> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pathology datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pathology datas
	 * @param end the upper bound of the range of pathology datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pathology datas
	 */
	@Override
	public List<PathologyData> findAll(int start, int end,
		OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PathologyData> list = null;

		if (retrieveFromCache) {
			list = (List<PathologyData>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PATHOLOGYDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PATHOLOGYDATA;

				if (pagination) {
					sql = sql.concat(PathologyDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PathologyData>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PathologyData>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the pathology datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PathologyData pathologyData : findAll()) {
			remove(pathologyData);
		}
	}

	/**
	 * Returns the number of pathology datas.
	 *
	 * @return the number of pathology datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PATHOLOGYDATA);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PathologyDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pathology data persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PathologyDataImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PATHOLOGYDATA = "SELECT pathologyData FROM PathologyData pathologyData";
	private static final String _SQL_SELECT_PATHOLOGYDATA_WHERE_PKS_IN = "SELECT pathologyData FROM PathologyData pathologyData WHERE pathologyDataId IN (";
	private static final String _SQL_SELECT_PATHOLOGYDATA_WHERE = "SELECT pathologyData FROM PathologyData pathologyData WHERE ";
	private static final String _SQL_COUNT_PATHOLOGYDATA = "SELECT COUNT(pathologyData) FROM PathologyData pathologyData";
	private static final String _SQL_COUNT_PATHOLOGYDATA_WHERE = "SELECT COUNT(pathologyData) FROM PathologyData pathologyData WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "pathologyData.pathologyDataId";
	private static final String _FILTER_SQL_SELECT_PATHOLOGYDATA_WHERE = "SELECT DISTINCT {pathologyData.*} FROM medicaldataset_PathologyData pathologyData WHERE ";
	private static final String _FILTER_SQL_SELECT_PATHOLOGYDATA_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {medicaldataset_PathologyData.*} FROM (SELECT DISTINCT pathologyData.pathologyDataId FROM medicaldataset_PathologyData pathologyData WHERE ";
	private static final String _FILTER_SQL_SELECT_PATHOLOGYDATA_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN medicaldataset_PathologyData ON TEMP_TABLE.pathologyDataId = medicaldataset_PathologyData.pathologyDataId";
	private static final String _FILTER_SQL_COUNT_PATHOLOGYDATA_WHERE = "SELECT COUNT(DISTINCT pathologyData.pathologyDataId) AS COUNT_VALUE FROM medicaldataset_PathologyData pathologyData WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "pathologyData";
	private static final String _FILTER_ENTITY_TABLE = "medicaldataset_PathologyData";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pathologyData.";
	private static final String _ORDER_BY_ENTITY_TABLE = "medicaldataset_PathologyData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PathologyData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PathologyData exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PathologyDataPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "comment"
			});
}