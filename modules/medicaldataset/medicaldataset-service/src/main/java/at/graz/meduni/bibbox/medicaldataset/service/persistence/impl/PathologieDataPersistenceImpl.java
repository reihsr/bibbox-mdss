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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException;
import at.graz.meduni.bibbox.medicaldataset.model.PathologieData;
import at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataImpl;
import at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataModelImpl;
import at.graz.meduni.bibbox.medicaldataset.service.persistence.PathologieDataPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
 * The persistence implementation for the pathologie data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PathologieDataPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.PathologieDataUtil
 * @generated
 */
@ProviderType
public class PathologieDataPersistenceImpl extends BasePersistenceImpl<PathologieData>
	implements PathologieDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PathologieDataUtil} to access the pathologie data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PathologieDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PathologieDataModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the pathologie datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pathologie datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @return the range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathologie datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByUuid(String uuid, int start, int end,
		OrderByComparator<PathologieData> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pathologie datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByUuid(String uuid, int start, int end,
		OrderByComparator<PathologieData> orderByComparator,
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

		List<PathologieData> list = null;

		if (retrieveFromCache) {
			list = (List<PathologieData>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PathologieData pathologieData : list) {
					if (!Objects.equals(uuid, pathologieData.getUuid())) {
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

			query.append(_SQL_SELECT_PATHOLOGIEDATA_WHERE);

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
				query.append(PathologieDataModelImpl.ORDER_BY_JPQL);
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
					list = (List<PathologieData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PathologieData>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first pathologie data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathologie data
	 * @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData findByUuid_First(String uuid,
		OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = fetchByUuid_First(uuid,
				orderByComparator);

		if (pathologieData != null) {
			return pathologieData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologieDataException(msg.toString());
	}

	/**
	 * Returns the first pathologie data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData fetchByUuid_First(String uuid,
		OrderByComparator<PathologieData> orderByComparator) {
		List<PathologieData> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pathologie data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathologie data
	 * @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData findByUuid_Last(String uuid,
		OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = fetchByUuid_Last(uuid, orderByComparator);

		if (pathologieData != null) {
			return pathologieData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologieDataException(msg.toString());
	}

	/**
	 * Returns the last pathologie data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData fetchByUuid_Last(String uuid,
		OrderByComparator<PathologieData> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PathologieData> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pathologie datas before and after the current pathologie data in the ordered set where uuid = &#63;.
	 *
	 * @param pathologieDataId the primary key of the current pathologie data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pathologie data
	 * @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	 */
	@Override
	public PathologieData[] findByUuid_PrevAndNext(long pathologieDataId,
		String uuid, OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = findByPrimaryKey(pathologieDataId);

		Session session = null;

		try {
			session = openSession();

			PathologieData[] array = new PathologieDataImpl[3];

			array[0] = getByUuid_PrevAndNext(session, pathologieData, uuid,
					orderByComparator, true);

			array[1] = pathologieData;

			array[2] = getByUuid_PrevAndNext(session, pathologieData, uuid,
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

	protected PathologieData getByUuid_PrevAndNext(Session session,
		PathologieData pathologieData, String uuid,
		OrderByComparator<PathologieData> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATHOLOGIEDATA_WHERE);

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
			query.append(PathologieDataModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(pathologieData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PathologieData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pathologie datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PathologieData pathologieData : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(pathologieData);
		}
	}

	/**
	 * Returns the number of pathologie datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching pathologie datas
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATHOLOGIEDATA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "pathologieData.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "pathologieData.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(pathologieData.uuid IS NULL OR pathologieData.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			PathologieDataModelImpl.UUID_COLUMN_BITMASK |
			PathologieDataModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the pathologie data where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPathologieDataException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pathologie data
	 * @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData findByUUID_G(String uuid, long groupId)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = fetchByUUID_G(uuid, groupId);

		if (pathologieData == null) {
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

			throw new NoSuchPathologieDataException(msg.toString());
		}

		return pathologieData;
	}

	/**
	 * Returns the pathologie data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the pathologie data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof PathologieData) {
			PathologieData pathologieData = (PathologieData)result;

			if (!Objects.equals(uuid, pathologieData.getUuid()) ||
					(groupId != pathologieData.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PATHOLOGIEDATA_WHERE);

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

				List<PathologieData> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					PathologieData pathologieData = list.get(0);

					result = pathologieData;

					cacheResult(pathologieData);

					if ((pathologieData.getUuid() == null) ||
							!pathologieData.getUuid().equals(uuid) ||
							(pathologieData.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, pathologieData);
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
			return (PathologieData)result;
		}
	}

	/**
	 * Removes the pathologie data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the pathologie data that was removed
	 */
	@Override
	public PathologieData removeByUUID_G(String uuid, long groupId)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = findByUUID_G(uuid, groupId);

		return remove(pathologieData);
	}

	/**
	 * Returns the number of pathologie datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching pathologie datas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATHOLOGIEDATA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "pathologieData.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "pathologieData.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(pathologieData.uuid IS NULL OR pathologieData.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "pathologieData.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PathologieDataModelImpl.UUID_COLUMN_BITMASK |
			PathologieDataModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the pathologie datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pathologie datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @return the range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathologie datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<PathologieData> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pathologie datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<PathologieData> orderByComparator,
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

		List<PathologieData> list = null;

		if (retrieveFromCache) {
			list = (List<PathologieData>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PathologieData pathologieData : list) {
					if (!Objects.equals(uuid, pathologieData.getUuid()) ||
							(companyId != pathologieData.getCompanyId())) {
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

			query.append(_SQL_SELECT_PATHOLOGIEDATA_WHERE);

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
				query.append(PathologieDataModelImpl.ORDER_BY_JPQL);
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
					list = (List<PathologieData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PathologieData>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathologie data
	 * @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (pathologieData != null) {
			return pathologieData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologieDataException(msg.toString());
	}

	/**
	 * Returns the first pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<PathologieData> orderByComparator) {
		List<PathologieData> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathologie data
	 * @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (pathologieData != null) {
			return pathologieData;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologieDataException(msg.toString());
	}

	/**
	 * Returns the last pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<PathologieData> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PathologieData> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pathologie datas before and after the current pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param pathologieDataId the primary key of the current pathologie data
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pathologie data
	 * @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	 */
	@Override
	public PathologieData[] findByUuid_C_PrevAndNext(long pathologieDataId,
		String uuid, long companyId,
		OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = findByPrimaryKey(pathologieDataId);

		Session session = null;

		try {
			session = openSession();

			PathologieData[] array = new PathologieDataImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, pathologieData, uuid,
					companyId, orderByComparator, true);

			array[1] = pathologieData;

			array[2] = getByUuid_C_PrevAndNext(session, pathologieData, uuid,
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

	protected PathologieData getByUuid_C_PrevAndNext(Session session,
		PathologieData pathologieData, String uuid, long companyId,
		OrderByComparator<PathologieData> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PATHOLOGIEDATA_WHERE);

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
			query.append(PathologieDataModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(pathologieData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PathologieData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pathologie datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PathologieData pathologieData : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(pathologieData);
		}
	}

	/**
	 * Returns the number of pathologie datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching pathologie datas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PATHOLOGIEDATA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "pathologieData.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "pathologieData.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(pathologieData.uuid IS NULL OR pathologieData.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "pathologieData.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MATERIAL = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMaterial",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL =
		new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMaterial",
			new String[] { String.class.getName() },
			PathologieDataModelImpl.MATERIAL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MATERIAL = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMaterial",
			new String[] { String.class.getName() });

	/**
	 * Returns all the pathologie datas where material = &#63;.
	 *
	 * @param material the material
	 * @return the matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByMaterial(String material) {
		return findByMaterial(material, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the pathologie datas where material = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param material the material
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @return the range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByMaterial(String material, int start,
		int end) {
		return findByMaterial(material, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathologie datas where material = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param material the material
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByMaterial(String material, int start,
		int end, OrderByComparator<PathologieData> orderByComparator) {
		return findByMaterial(material, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pathologie datas where material = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param material the material
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByMaterial(String material, int start,
		int end, OrderByComparator<PathologieData> orderByComparator,
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

		List<PathologieData> list = null;

		if (retrieveFromCache) {
			list = (List<PathologieData>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PathologieData pathologieData : list) {
					if (!Objects.equals(material, pathologieData.getMaterial())) {
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

			query.append(_SQL_SELECT_PATHOLOGIEDATA_WHERE);

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
				query.append(PathologieDataModelImpl.ORDER_BY_JPQL);
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
					list = (List<PathologieData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PathologieData>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first pathologie data in the ordered set where material = &#63;.
	 *
	 * @param material the material
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathologie data
	 * @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData findByMaterial_First(String material,
		OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = fetchByMaterial_First(material,
				orderByComparator);

		if (pathologieData != null) {
			return pathologieData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("material=");
		msg.append(material);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologieDataException(msg.toString());
	}

	/**
	 * Returns the first pathologie data in the ordered set where material = &#63;.
	 *
	 * @param material the material
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData fetchByMaterial_First(String material,
		OrderByComparator<PathologieData> orderByComparator) {
		List<PathologieData> list = findByMaterial(material, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pathologie data in the ordered set where material = &#63;.
	 *
	 * @param material the material
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathologie data
	 * @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData findByMaterial_Last(String material,
		OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = fetchByMaterial_Last(material,
				orderByComparator);

		if (pathologieData != null) {
			return pathologieData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("material=");
		msg.append(material);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologieDataException(msg.toString());
	}

	/**
	 * Returns the last pathologie data in the ordered set where material = &#63;.
	 *
	 * @param material the material
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData fetchByMaterial_Last(String material,
		OrderByComparator<PathologieData> orderByComparator) {
		int count = countByMaterial(material);

		if (count == 0) {
			return null;
		}

		List<PathologieData> list = findByMaterial(material, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pathologie datas before and after the current pathologie data in the ordered set where material = &#63;.
	 *
	 * @param pathologieDataId the primary key of the current pathologie data
	 * @param material the material
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pathologie data
	 * @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	 */
	@Override
	public PathologieData[] findByMaterial_PrevAndNext(long pathologieDataId,
		String material, OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = findByPrimaryKey(pathologieDataId);

		Session session = null;

		try {
			session = openSession();

			PathologieData[] array = new PathologieDataImpl[3];

			array[0] = getByMaterial_PrevAndNext(session, pathologieData,
					material, orderByComparator, true);

			array[1] = pathologieData;

			array[2] = getByMaterial_PrevAndNext(session, pathologieData,
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

	protected PathologieData getByMaterial_PrevAndNext(Session session,
		PathologieData pathologieData, String material,
		OrderByComparator<PathologieData> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATHOLOGIEDATA_WHERE);

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
			query.append(PathologieDataModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(pathologieData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PathologieData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pathologie datas where material = &#63; from the database.
	 *
	 * @param material the material
	 */
	@Override
	public void removeByMaterial(String material) {
		for (PathologieData pathologieData : findByMaterial(material,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(pathologieData);
		}
	}

	/**
	 * Returns the number of pathologie datas where material = &#63;.
	 *
	 * @param material the material
	 * @return the number of matching pathologie datas
	 */
	@Override
	public int countByMaterial(String material) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MATERIAL;

		Object[] finderArgs = new Object[] { material };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATHOLOGIEDATA_WHERE);

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

	private static final String _FINDER_COLUMN_MATERIAL_MATERIAL_1 = "pathologieData.material IS NULL";
	private static final String _FINDER_COLUMN_MATERIAL_MATERIAL_2 = "pathologieData.material = ?";
	private static final String _FINDER_COLUMN_MATERIAL_MATERIAL_3 = "(pathologieData.material IS NULL OR pathologieData.material = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MEDICALRECORD =
		new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMedicalRecord",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEDICALRECORD =
		new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED,
			PathologieDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMedicalRecord",
			new String[] { Long.class.getName() },
			PathologieDataModelImpl.MEDICALRECORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEDICALRECORD = new FinderPath(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMedicalRecord",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the pathologie datas where medicalRecordId = &#63;.
	 *
	 * @param medicalRecordId the medical record ID
	 * @return the matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByMedicalRecord(long medicalRecordId) {
		return findByMedicalRecord(medicalRecordId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pathologie datas where medicalRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param medicalRecordId the medical record ID
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @return the range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByMedicalRecord(long medicalRecordId,
		int start, int end) {
		return findByMedicalRecord(medicalRecordId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathologie datas where medicalRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param medicalRecordId the medical record ID
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByMedicalRecord(long medicalRecordId,
		int start, int end, OrderByComparator<PathologieData> orderByComparator) {
		return findByMedicalRecord(medicalRecordId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pathologie datas where medicalRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param medicalRecordId the medical record ID
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching pathologie datas
	 */
	@Override
	public List<PathologieData> findByMedicalRecord(long medicalRecordId,
		int start, int end,
		OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEDICALRECORD;
			finderArgs = new Object[] { medicalRecordId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MEDICALRECORD;
			finderArgs = new Object[] {
					medicalRecordId,
					
					start, end, orderByComparator
				};
		}

		List<PathologieData> list = null;

		if (retrieveFromCache) {
			list = (List<PathologieData>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PathologieData pathologieData : list) {
					if ((medicalRecordId != pathologieData.getMedicalRecordId())) {
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

			query.append(_SQL_SELECT_PATHOLOGIEDATA_WHERE);

			query.append(_FINDER_COLUMN_MEDICALRECORD_MEDICALRECORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PathologieDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(medicalRecordId);

				if (!pagination) {
					list = (List<PathologieData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PathologieData>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first pathologie data in the ordered set where medicalRecordId = &#63;.
	 *
	 * @param medicalRecordId the medical record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathologie data
	 * @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData findByMedicalRecord_First(long medicalRecordId,
		OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = fetchByMedicalRecord_First(medicalRecordId,
				orderByComparator);

		if (pathologieData != null) {
			return pathologieData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("medicalRecordId=");
		msg.append(medicalRecordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologieDataException(msg.toString());
	}

	/**
	 * Returns the first pathologie data in the ordered set where medicalRecordId = &#63;.
	 *
	 * @param medicalRecordId the medical record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData fetchByMedicalRecord_First(long medicalRecordId,
		OrderByComparator<PathologieData> orderByComparator) {
		List<PathologieData> list = findByMedicalRecord(medicalRecordId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last pathologie data in the ordered set where medicalRecordId = &#63;.
	 *
	 * @param medicalRecordId the medical record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathologie data
	 * @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData findByMedicalRecord_Last(long medicalRecordId,
		OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = fetchByMedicalRecord_Last(medicalRecordId,
				orderByComparator);

		if (pathologieData != null) {
			return pathologieData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("medicalRecordId=");
		msg.append(medicalRecordId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPathologieDataException(msg.toString());
	}

	/**
	 * Returns the last pathologie data in the ordered set where medicalRecordId = &#63;.
	 *
	 * @param medicalRecordId the medical record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	 */
	@Override
	public PathologieData fetchByMedicalRecord_Last(long medicalRecordId,
		OrderByComparator<PathologieData> orderByComparator) {
		int count = countByMedicalRecord(medicalRecordId);

		if (count == 0) {
			return null;
		}

		List<PathologieData> list = findByMedicalRecord(medicalRecordId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the pathologie datas before and after the current pathologie data in the ordered set where medicalRecordId = &#63;.
	 *
	 * @param pathologieDataId the primary key of the current pathologie data
	 * @param medicalRecordId the medical record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next pathologie data
	 * @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	 */
	@Override
	public PathologieData[] findByMedicalRecord_PrevAndNext(
		long pathologieDataId, long medicalRecordId,
		OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = findByPrimaryKey(pathologieDataId);

		Session session = null;

		try {
			session = openSession();

			PathologieData[] array = new PathologieDataImpl[3];

			array[0] = getByMedicalRecord_PrevAndNext(session, pathologieData,
					medicalRecordId, orderByComparator, true);

			array[1] = pathologieData;

			array[2] = getByMedicalRecord_PrevAndNext(session, pathologieData,
					medicalRecordId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PathologieData getByMedicalRecord_PrevAndNext(Session session,
		PathologieData pathologieData, long medicalRecordId,
		OrderByComparator<PathologieData> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PATHOLOGIEDATA_WHERE);

		query.append(_FINDER_COLUMN_MEDICALRECORD_MEDICALRECORDID_2);

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
			query.append(PathologieDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(medicalRecordId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(pathologieData);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PathologieData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the pathologie datas where medicalRecordId = &#63; from the database.
	 *
	 * @param medicalRecordId the medical record ID
	 */
	@Override
	public void removeByMedicalRecord(long medicalRecordId) {
		for (PathologieData pathologieData : findByMedicalRecord(
				medicalRecordId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(pathologieData);
		}
	}

	/**
	 * Returns the number of pathologie datas where medicalRecordId = &#63;.
	 *
	 * @param medicalRecordId the medical record ID
	 * @return the number of matching pathologie datas
	 */
	@Override
	public int countByMedicalRecord(long medicalRecordId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEDICALRECORD;

		Object[] finderArgs = new Object[] { medicalRecordId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PATHOLOGIEDATA_WHERE);

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

	private static final String _FINDER_COLUMN_MEDICALRECORD_MEDICALRECORDID_2 = "pathologieData.medicalRecordId = ?";

	public PathologieDataPersistenceImpl() {
		setModelClass(PathologieData.class);

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
	 * Caches the pathologie data in the entity cache if it is enabled.
	 *
	 * @param pathologieData the pathologie data
	 */
	@Override
	public void cacheResult(PathologieData pathologieData) {
		entityCache.putResult(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataImpl.class, pathologieData.getPrimaryKey(),
			pathologieData);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { pathologieData.getUuid(), pathologieData.getGroupId() },
			pathologieData);

		pathologieData.resetOriginalValues();
	}

	/**
	 * Caches the pathologie datas in the entity cache if it is enabled.
	 *
	 * @param pathologieDatas the pathologie datas
	 */
	@Override
	public void cacheResult(List<PathologieData> pathologieDatas) {
		for (PathologieData pathologieData : pathologieDatas) {
			if (entityCache.getResult(
						PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
						PathologieDataImpl.class, pathologieData.getPrimaryKey()) == null) {
				cacheResult(pathologieData);
			}
			else {
				pathologieData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pathologie datas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PathologieDataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pathologie data.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PathologieData pathologieData) {
		entityCache.removeResult(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataImpl.class, pathologieData.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PathologieDataModelImpl)pathologieData, true);
	}

	@Override
	public void clearCache(List<PathologieData> pathologieDatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PathologieData pathologieData : pathologieDatas) {
			entityCache.removeResult(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
				PathologieDataImpl.class, pathologieData.getPrimaryKey());

			clearUniqueFindersCache((PathologieDataModelImpl)pathologieData,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		PathologieDataModelImpl pathologieDataModelImpl) {
		Object[] args = new Object[] {
				pathologieDataModelImpl.getUuid(),
				pathologieDataModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			pathologieDataModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PathologieDataModelImpl pathologieDataModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					pathologieDataModelImpl.getUuid(),
					pathologieDataModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((pathologieDataModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					pathologieDataModelImpl.getOriginalUuid(),
					pathologieDataModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new pathologie data with the primary key. Does not add the pathologie data to the database.
	 *
	 * @param pathologieDataId the primary key for the new pathologie data
	 * @return the new pathologie data
	 */
	@Override
	public PathologieData create(long pathologieDataId) {
		PathologieData pathologieData = new PathologieDataImpl();

		pathologieData.setNew(true);
		pathologieData.setPrimaryKey(pathologieDataId);

		String uuid = PortalUUIDUtil.generate();

		pathologieData.setUuid(uuid);

		pathologieData.setCompanyId(companyProvider.getCompanyId());

		return pathologieData;
	}

	/**
	 * Removes the pathologie data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pathologieDataId the primary key of the pathologie data
	 * @return the pathologie data that was removed
	 * @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	 */
	@Override
	public PathologieData remove(long pathologieDataId)
		throws NoSuchPathologieDataException {
		return remove((Serializable)pathologieDataId);
	}

	/**
	 * Removes the pathologie data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pathologie data
	 * @return the pathologie data that was removed
	 * @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	 */
	@Override
	public PathologieData remove(Serializable primaryKey)
		throws NoSuchPathologieDataException {
		Session session = null;

		try {
			session = openSession();

			PathologieData pathologieData = (PathologieData)session.get(PathologieDataImpl.class,
					primaryKey);

			if (pathologieData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPathologieDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pathologieData);
		}
		catch (NoSuchPathologieDataException nsee) {
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
	protected PathologieData removeImpl(PathologieData pathologieData) {
		pathologieData = toUnwrappedModel(pathologieData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pathologieData)) {
				pathologieData = (PathologieData)session.get(PathologieDataImpl.class,
						pathologieData.getPrimaryKeyObj());
			}

			if (pathologieData != null) {
				session.delete(pathologieData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (pathologieData != null) {
			clearCache(pathologieData);
		}

		return pathologieData;
	}

	@Override
	public PathologieData updateImpl(PathologieData pathologieData) {
		pathologieData = toUnwrappedModel(pathologieData);

		boolean isNew = pathologieData.isNew();

		PathologieDataModelImpl pathologieDataModelImpl = (PathologieDataModelImpl)pathologieData;

		if (Validator.isNull(pathologieData.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			pathologieData.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (pathologieData.getCreateDate() == null)) {
			if (serviceContext == null) {
				pathologieData.setCreateDate(now);
			}
			else {
				pathologieData.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!pathologieDataModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				pathologieData.setModifiedDate(now);
			}
			else {
				pathologieData.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (pathologieData.isNew()) {
				session.save(pathologieData);

				pathologieData.setNew(false);
			}
			else {
				pathologieData = (PathologieData)session.merge(pathologieData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PathologieDataModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { pathologieDataModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					pathologieDataModelImpl.getUuid(),
					pathologieDataModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { pathologieDataModelImpl.getMaterial() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MATERIAL, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL,
				args);

			args = new Object[] { pathologieDataModelImpl.getMedicalRecordId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MEDICALRECORD, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEDICALRECORD,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((pathologieDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pathologieDataModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { pathologieDataModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((pathologieDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pathologieDataModelImpl.getOriginalUuid(),
						pathologieDataModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						pathologieDataModelImpl.getUuid(),
						pathologieDataModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((pathologieDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pathologieDataModelImpl.getOriginalMaterial()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MATERIAL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL,
					args);

				args = new Object[] { pathologieDataModelImpl.getMaterial() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MATERIAL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MATERIAL,
					args);
			}

			if ((pathologieDataModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEDICALRECORD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						pathologieDataModelImpl.getOriginalMedicalRecordId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEDICALRECORD,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEDICALRECORD,
					args);

				args = new Object[] { pathologieDataModelImpl.getMedicalRecordId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MEDICALRECORD,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MEDICALRECORD,
					args);
			}
		}

		entityCache.putResult(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
			PathologieDataImpl.class, pathologieData.getPrimaryKey(),
			pathologieData, false);

		clearUniqueFindersCache(pathologieDataModelImpl, false);
		cacheUniqueFindersCache(pathologieDataModelImpl);

		pathologieData.resetOriginalValues();

		return pathologieData;
	}

	protected PathologieData toUnwrappedModel(PathologieData pathologieData) {
		if (pathologieData instanceof PathologieDataImpl) {
			return pathologieData;
		}

		PathologieDataImpl pathologieDataImpl = new PathologieDataImpl();

		pathologieDataImpl.setNew(pathologieData.isNew());
		pathologieDataImpl.setPrimaryKey(pathologieData.getPrimaryKey());

		pathologieDataImpl.setUuid(pathologieData.getUuid());
		pathologieDataImpl.setPathologieDataId(pathologieData.getPathologieDataId());
		pathologieDataImpl.setGroupId(pathologieData.getGroupId());
		pathologieDataImpl.setCompanyId(pathologieData.getCompanyId());
		pathologieDataImpl.setUserId(pathologieData.getUserId());
		pathologieDataImpl.setUserName(pathologieData.getUserName());
		pathologieDataImpl.setCreateDate(pathologieData.getCreateDate());
		pathologieDataImpl.setModifiedDate(pathologieData.getModifiedDate());
		pathologieDataImpl.setStatus(pathologieData.getStatus());
		pathologieDataImpl.setStatusByUserId(pathologieData.getStatusByUserId());
		pathologieDataImpl.setStatusByUserName(pathologieData.getStatusByUserName());
		pathologieDataImpl.setStatusDate(pathologieData.getStatusDate());
		pathologieDataImpl.setMedicalRecordId(pathologieData.getMedicalRecordId());
		pathologieDataImpl.setReceivedDate(pathologieData.getReceivedDate());
		pathologieDataImpl.setValidationDate(pathologieData.getValidationDate());
		pathologieDataImpl.setPatientAge(pathologieData.getPatientAge());
		pathologieDataImpl.setSender(pathologieData.getSender());
		pathologieDataImpl.setExtractionMethode(pathologieData.getExtractionMethode());
		pathologieDataImpl.setReportingPhysician1(pathologieData.getReportingPhysician1());
		pathologieDataImpl.setReportingPhysician2(pathologieData.getReportingPhysician2());
		pathologieDataImpl.setGynPhysician(pathologieData.getGynPhysician());
		pathologieDataImpl.setValidationPhysician1(pathologieData.getValidationPhysician1());
		pathologieDataImpl.setValidationPhysician2(pathologieData.getValidationPhysician2());
		pathologieDataImpl.setReportStatus(pathologieData.getReportStatus());
		pathologieDataImpl.setNumberOfBlockes(pathologieData.getNumberOfBlockes());
		pathologieDataImpl.setNumberOfSlides(pathologieData.getNumberOfSlides());
		pathologieDataImpl.setBasicDisease(pathologieData.getBasicDisease());
		pathologieDataImpl.setCauseOfDeath(pathologieData.getCauseOfDeath());
		pathologieDataImpl.setMaterial(pathologieData.getMaterial());
		pathologieDataImpl.setMaterialExtended(pathologieData.getMaterialExtended());
		pathologieDataImpl.setMacroscopicDescription(pathologieData.getMacroscopicDescription());
		pathologieDataImpl.setMicroscopicDescription(pathologieData.getMicroscopicDescription());
		pathologieDataImpl.setHistologicDescription(pathologieData.getHistologicDescription());
		pathologieDataImpl.setMolecularPathologicDescription(pathologieData.getMolecularPathologicDescription());
		pathologieDataImpl.setZytologieDescription(pathologieData.getZytologieDescription());
		pathologieDataImpl.setPathologicDiagnosis(pathologieData.getPathologicDiagnosis());
		pathologieDataImpl.setFrozenSectionDiagnosis(pathologieData.getFrozenSectionDiagnosis());
		pathologieDataImpl.setMolecularPathologicDiagnosis(pathologieData.getMolecularPathologicDiagnosis());
		pathologieDataImpl.setZytologieDiagnosis(pathologieData.getZytologieDiagnosis());
		pathologieDataImpl.setNeuroPathologicDiagnosis(pathologieData.getNeuroPathologicDiagnosis());
		pathologieDataImpl.setComment(pathologieData.getComment());
		pathologieDataImpl.setZytologiecomment(pathologieData.getZytologiecomment());
		pathologieDataImpl.setGrad(pathologieData.getGrad());
		pathologieDataImpl.setTnmp(pathologieData.getTnmp());
		pathologieDataImpl.setTnmt(pathologieData.getTnmt());
		pathologieDataImpl.setTnmn(pathologieData.getTnmn());
		pathologieDataImpl.setTnmm(pathologieData.getTnmm());
		pathologieDataImpl.setTnmr(pathologieData.getTnmr());
		pathologieDataImpl.setTnml(pathologieData.getTnml());
		pathologieDataImpl.setTnmv(pathologieData.getTnmv());
		pathologieDataImpl.setTnmpn(pathologieData.getTnmpn());
		pathologieDataImpl.setDgcode1(pathologieData.getDgcode1());
		pathologieDataImpl.setDgcode2(pathologieData.getDgcode2());
		pathologieDataImpl.setPap(pathologieData.getPap());
		pathologieDataImpl.setSmearQuality(pathologieData.getSmearQuality());

		return pathologieDataImpl;
	}

	/**
	 * Returns the pathologie data with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pathologie data
	 * @return the pathologie data
	 * @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	 */
	@Override
	public PathologieData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPathologieDataException {
		PathologieData pathologieData = fetchByPrimaryKey(primaryKey);

		if (pathologieData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPathologieDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return pathologieData;
	}

	/**
	 * Returns the pathologie data with the primary key or throws a {@link NoSuchPathologieDataException} if it could not be found.
	 *
	 * @param pathologieDataId the primary key of the pathologie data
	 * @return the pathologie data
	 * @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	 */
	@Override
	public PathologieData findByPrimaryKey(long pathologieDataId)
		throws NoSuchPathologieDataException {
		return findByPrimaryKey((Serializable)pathologieDataId);
	}

	/**
	 * Returns the pathologie data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pathologie data
	 * @return the pathologie data, or <code>null</code> if a pathologie data with the primary key could not be found
	 */
	@Override
	public PathologieData fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
				PathologieDataImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PathologieData pathologieData = (PathologieData)serializable;

		if (pathologieData == null) {
			Session session = null;

			try {
				session = openSession();

				pathologieData = (PathologieData)session.get(PathologieDataImpl.class,
						primaryKey);

				if (pathologieData != null) {
					cacheResult(pathologieData);
				}
				else {
					entityCache.putResult(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
						PathologieDataImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
					PathologieDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return pathologieData;
	}

	/**
	 * Returns the pathologie data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pathologieDataId the primary key of the pathologie data
	 * @return the pathologie data, or <code>null</code> if a pathologie data with the primary key could not be found
	 */
	@Override
	public PathologieData fetchByPrimaryKey(long pathologieDataId) {
		return fetchByPrimaryKey((Serializable)pathologieDataId);
	}

	@Override
	public Map<Serializable, PathologieData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PathologieData> map = new HashMap<Serializable, PathologieData>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PathologieData pathologieData = fetchByPrimaryKey(primaryKey);

			if (pathologieData != null) {
				map.put(primaryKey, pathologieData);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
					PathologieDataImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PathologieData)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PATHOLOGIEDATA_WHERE_PKS_IN);

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

			for (PathologieData pathologieData : (List<PathologieData>)q.list()) {
				map.put(pathologieData.getPrimaryKeyObj(), pathologieData);

				cacheResult(pathologieData);

				uncachedPrimaryKeys.remove(pathologieData.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PathologieDataModelImpl.ENTITY_CACHE_ENABLED,
					PathologieDataImpl.class, primaryKey, nullModel);
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
	 * Returns all the pathologie datas.
	 *
	 * @return the pathologie datas
	 */
	@Override
	public List<PathologieData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pathologie datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @return the range of pathologie datas
	 */
	@Override
	public List<PathologieData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pathologie datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pathologie datas
	 */
	@Override
	public List<PathologieData> findAll(int start, int end,
		OrderByComparator<PathologieData> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pathologie datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pathologie datas
	 * @param end the upper bound of the range of pathologie datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pathologie datas
	 */
	@Override
	public List<PathologieData> findAll(int start, int end,
		OrderByComparator<PathologieData> orderByComparator,
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

		List<PathologieData> list = null;

		if (retrieveFromCache) {
			list = (List<PathologieData>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PATHOLOGIEDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PATHOLOGIEDATA;

				if (pagination) {
					sql = sql.concat(PathologieDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PathologieData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PathologieData>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the pathologie datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PathologieData pathologieData : findAll()) {
			remove(pathologieData);
		}
	}

	/**
	 * Returns the number of pathologie datas.
	 *
	 * @return the number of pathologie datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PATHOLOGIEDATA);

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
		return PathologieDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pathologie data persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PathologieDataImpl.class.getName());
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
	private static final String _SQL_SELECT_PATHOLOGIEDATA = "SELECT pathologieData FROM PathologieData pathologieData";
	private static final String _SQL_SELECT_PATHOLOGIEDATA_WHERE_PKS_IN = "SELECT pathologieData FROM PathologieData pathologieData WHERE pathologieDataId IN (";
	private static final String _SQL_SELECT_PATHOLOGIEDATA_WHERE = "SELECT pathologieData FROM PathologieData pathologieData WHERE ";
	private static final String _SQL_COUNT_PATHOLOGIEDATA = "SELECT COUNT(pathologieData) FROM PathologieData pathologieData";
	private static final String _SQL_COUNT_PATHOLOGIEDATA_WHERE = "SELECT COUNT(pathologieData) FROM PathologieData pathologieData WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pathologieData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PathologieData exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PathologieData exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PathologieDataPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "comment"
			});
}