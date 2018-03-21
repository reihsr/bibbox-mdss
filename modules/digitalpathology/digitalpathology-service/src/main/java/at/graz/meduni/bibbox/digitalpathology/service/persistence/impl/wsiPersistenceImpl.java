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

package at.graz.meduni.bibbox.digitalpathology.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException;
import at.graz.meduni.bibbox.digitalpathology.model.impl.wsiImpl;
import at.graz.meduni.bibbox.digitalpathology.model.impl.wsiModelImpl;
import at.graz.meduni.bibbox.digitalpathology.model.wsi;
import at.graz.meduni.bibbox.digitalpathology.service.persistence.wsiPersistence;

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
 * The persistence implementation for the wsi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see wsiPersistence
 * @see at.graz.meduni.bibbox.digitalpathology.service.persistence.wsiUtil
 * @generated
 */
@ProviderType
public class wsiPersistenceImpl extends BasePersistenceImpl<wsi>
	implements wsiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link wsiUtil} to access the wsi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = wsiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, wsiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, wsiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, wsiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, wsiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			wsiModelImpl.UUID_COLUMN_BITMASK |
			wsiModelImpl.SCANSTART_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the wsis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching wsis
	 */
	@Override
	public List<wsi> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wsis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @return the range of matching wsis
	 */
	@Override
	public List<wsi> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the wsis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wsis
	 */
	@Override
	public List<wsi> findByUuid(String uuid, int start, int end,
		OrderByComparator<wsi> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wsis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching wsis
	 */
	@Override
	public List<wsi> findByUuid(String uuid, int start, int end,
		OrderByComparator<wsi> orderByComparator, boolean retrieveFromCache) {
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

		List<wsi> list = null;

		if (retrieveFromCache) {
			list = (List<wsi>)finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (wsi wsi : list) {
					if (!Objects.equals(uuid, wsi.getUuid())) {
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

			query.append(_SQL_SELECT_WSI_WHERE);

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
				query.append(wsiModelImpl.ORDER_BY_JPQL);
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
					list = (List<wsi>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<wsi>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first wsi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsi
	 * @throws NoSuchwsiException if a matching wsi could not be found
	 */
	@Override
	public wsi findByUuid_First(String uuid,
		OrderByComparator<wsi> orderByComparator) throws NoSuchwsiException {
		wsi wsi = fetchByUuid_First(uuid, orderByComparator);

		if (wsi != null) {
			return wsi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsiException(msg.toString());
	}

	/**
	 * Returns the first wsi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsi, or <code>null</code> if a matching wsi could not be found
	 */
	@Override
	public wsi fetchByUuid_First(String uuid,
		OrderByComparator<wsi> orderByComparator) {
		List<wsi> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last wsi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsi
	 * @throws NoSuchwsiException if a matching wsi could not be found
	 */
	@Override
	public wsi findByUuid_Last(String uuid,
		OrderByComparator<wsi> orderByComparator) throws NoSuchwsiException {
		wsi wsi = fetchByUuid_Last(uuid, orderByComparator);

		if (wsi != null) {
			return wsi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsiException(msg.toString());
	}

	/**
	 * Returns the last wsi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsi, or <code>null</code> if a matching wsi could not be found
	 */
	@Override
	public wsi fetchByUuid_Last(String uuid,
		OrderByComparator<wsi> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<wsi> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the wsis before and after the current wsi in the ordered set where uuid = &#63;.
	 *
	 * @param wsiId the primary key of the current wsi
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wsi
	 * @throws NoSuchwsiException if a wsi with the primary key could not be found
	 */
	@Override
	public wsi[] findByUuid_PrevAndNext(long wsiId, String uuid,
		OrderByComparator<wsi> orderByComparator) throws NoSuchwsiException {
		wsi wsi = findByPrimaryKey(wsiId);

		Session session = null;

		try {
			session = openSession();

			wsi[] array = new wsiImpl[3];

			array[0] = getByUuid_PrevAndNext(session, wsi, uuid,
					orderByComparator, true);

			array[1] = wsi;

			array[2] = getByUuid_PrevAndNext(session, wsi, uuid,
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

	protected wsi getByUuid_PrevAndNext(Session session, wsi wsi, String uuid,
		OrderByComparator<wsi> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WSI_WHERE);

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
			query.append(wsiModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wsi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<wsi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wsis where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (wsi wsi : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(wsi);
		}
	}

	/**
	 * Returns the number of wsis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching wsis
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WSI_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "wsi.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "wsi.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(wsi.uuid IS NULL OR wsi.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, wsiImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			wsiModelImpl.UUID_COLUMN_BITMASK |
			wsiModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the wsi where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchwsiException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching wsi
	 * @throws NoSuchwsiException if a matching wsi could not be found
	 */
	@Override
	public wsi findByUUID_G(String uuid, long groupId)
		throws NoSuchwsiException {
		wsi wsi = fetchByUUID_G(uuid, groupId);

		if (wsi == null) {
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

			throw new NoSuchwsiException(msg.toString());
		}

		return wsi;
	}

	/**
	 * Returns the wsi where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching wsi, or <code>null</code> if a matching wsi could not be found
	 */
	@Override
	public wsi fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the wsi where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching wsi, or <code>null</code> if a matching wsi could not be found
	 */
	@Override
	public wsi fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof wsi) {
			wsi wsi = (wsi)result;

			if (!Objects.equals(uuid, wsi.getUuid()) ||
					(groupId != wsi.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_WSI_WHERE);

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

				List<wsi> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					wsi wsi = list.get(0);

					result = wsi;

					cacheResult(wsi);

					if ((wsi.getUuid() == null) || !wsi.getUuid().equals(uuid) ||
							(wsi.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, wsi);
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
			return (wsi)result;
		}
	}

	/**
	 * Removes the wsi where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the wsi that was removed
	 */
	@Override
	public wsi removeByUUID_G(String uuid, long groupId)
		throws NoSuchwsiException {
		wsi wsi = findByUUID_G(uuid, groupId);

		return remove(wsi);
	}

	/**
	 * Returns the number of wsis where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching wsis
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WSI_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "wsi.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "wsi.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(wsi.uuid IS NULL OR wsi.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "wsi.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, wsiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, wsiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			wsiModelImpl.UUID_COLUMN_BITMASK |
			wsiModelImpl.COMPANYID_COLUMN_BITMASK |
			wsiModelImpl.SCANSTART_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the wsis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching wsis
	 */
	@Override
	public List<wsi> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wsis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @return the range of matching wsis
	 */
	@Override
	public List<wsi> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the wsis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wsis
	 */
	@Override
	public List<wsi> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<wsi> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wsis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching wsis
	 */
	@Override
	public List<wsi> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<wsi> orderByComparator,
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

		List<wsi> list = null;

		if (retrieveFromCache) {
			list = (List<wsi>)finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (wsi wsi : list) {
					if (!Objects.equals(uuid, wsi.getUuid()) ||
							(companyId != wsi.getCompanyId())) {
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

			query.append(_SQL_SELECT_WSI_WHERE);

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
				query.append(wsiModelImpl.ORDER_BY_JPQL);
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
					list = (List<wsi>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<wsi>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsi
	 * @throws NoSuchwsiException if a matching wsi could not be found
	 */
	@Override
	public wsi findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<wsi> orderByComparator) throws NoSuchwsiException {
		wsi wsi = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (wsi != null) {
			return wsi;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsiException(msg.toString());
	}

	/**
	 * Returns the first wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsi, or <code>null</code> if a matching wsi could not be found
	 */
	@Override
	public wsi fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<wsi> orderByComparator) {
		List<wsi> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsi
	 * @throws NoSuchwsiException if a matching wsi could not be found
	 */
	@Override
	public wsi findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<wsi> orderByComparator) throws NoSuchwsiException {
		wsi wsi = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (wsi != null) {
			return wsi;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsiException(msg.toString());
	}

	/**
	 * Returns the last wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsi, or <code>null</code> if a matching wsi could not be found
	 */
	@Override
	public wsi fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<wsi> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<wsi> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the wsis before and after the current wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param wsiId the primary key of the current wsi
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wsi
	 * @throws NoSuchwsiException if a wsi with the primary key could not be found
	 */
	@Override
	public wsi[] findByUuid_C_PrevAndNext(long wsiId, String uuid,
		long companyId, OrderByComparator<wsi> orderByComparator)
		throws NoSuchwsiException {
		wsi wsi = findByPrimaryKey(wsiId);

		Session session = null;

		try {
			session = openSession();

			wsi[] array = new wsiImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, wsi, uuid, companyId,
					orderByComparator, true);

			array[1] = wsi;

			array[2] = getByUuid_C_PrevAndNext(session, wsi, uuid, companyId,
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

	protected wsi getByUuid_C_PrevAndNext(Session session, wsi wsi,
		String uuid, long companyId, OrderByComparator<wsi> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_WSI_WHERE);

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
			query.append(wsiModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wsi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<wsi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wsis where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (wsi wsi : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(wsi);
		}
	}

	/**
	 * Returns the number of wsis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching wsis
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WSI_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "wsi.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "wsi.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(wsi.uuid IS NULL OR wsi.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "wsi.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILENAME = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, wsiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFilename",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME =
		new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, wsiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFilename",
			new String[] { String.class.getName() },
			wsiModelImpl.FILENAME_COLUMN_BITMASK |
			wsiModelImpl.SCANSTART_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILENAME = new FinderPath(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFilename",
			new String[] { String.class.getName() });

	/**
	 * Returns all the wsis where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the matching wsis
	 */
	@Override
	public List<wsi> findByFilename(String filename) {
		return findByFilename(filename, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the wsis where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @return the range of matching wsis
	 */
	@Override
	public List<wsi> findByFilename(String filename, int start, int end) {
		return findByFilename(filename, start, end, null);
	}

	/**
	 * Returns an ordered range of all the wsis where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wsis
	 */
	@Override
	public List<wsi> findByFilename(String filename, int start, int end,
		OrderByComparator<wsi> orderByComparator) {
		return findByFilename(filename, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wsis where filename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param filename the filename
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching wsis
	 */
	@Override
	public List<wsi> findByFilename(String filename, int start, int end,
		OrderByComparator<wsi> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME;
			finderArgs = new Object[] { filename };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILENAME;
			finderArgs = new Object[] { filename, start, end, orderByComparator };
		}

		List<wsi> list = null;

		if (retrieveFromCache) {
			list = (List<wsi>)finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (wsi wsi : list) {
					if (!Objects.equals(filename, wsi.getFilename())) {
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

			query.append(_SQL_SELECT_WSI_WHERE);

			boolean bindFilename = false;

			if (filename == null) {
				query.append(_FINDER_COLUMN_FILENAME_FILENAME_1);
			}
			else if (filename.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
			}
			else {
				bindFilename = true;

				query.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(wsiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFilename) {
					qPos.add(filename);
				}

				if (!pagination) {
					list = (List<wsi>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<wsi>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first wsi in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsi
	 * @throws NoSuchwsiException if a matching wsi could not be found
	 */
	@Override
	public wsi findByFilename_First(String filename,
		OrderByComparator<wsi> orderByComparator) throws NoSuchwsiException {
		wsi wsi = fetchByFilename_First(filename, orderByComparator);

		if (wsi != null) {
			return wsi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("filename=");
		msg.append(filename);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsiException(msg.toString());
	}

	/**
	 * Returns the first wsi in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsi, or <code>null</code> if a matching wsi could not be found
	 */
	@Override
	public wsi fetchByFilename_First(String filename,
		OrderByComparator<wsi> orderByComparator) {
		List<wsi> list = findByFilename(filename, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last wsi in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsi
	 * @throws NoSuchwsiException if a matching wsi could not be found
	 */
	@Override
	public wsi findByFilename_Last(String filename,
		OrderByComparator<wsi> orderByComparator) throws NoSuchwsiException {
		wsi wsi = fetchByFilename_Last(filename, orderByComparator);

		if (wsi != null) {
			return wsi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("filename=");
		msg.append(filename);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsiException(msg.toString());
	}

	/**
	 * Returns the last wsi in the ordered set where filename = &#63;.
	 *
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsi, or <code>null</code> if a matching wsi could not be found
	 */
	@Override
	public wsi fetchByFilename_Last(String filename,
		OrderByComparator<wsi> orderByComparator) {
		int count = countByFilename(filename);

		if (count == 0) {
			return null;
		}

		List<wsi> list = findByFilename(filename, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the wsis before and after the current wsi in the ordered set where filename = &#63;.
	 *
	 * @param wsiId the primary key of the current wsi
	 * @param filename the filename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wsi
	 * @throws NoSuchwsiException if a wsi with the primary key could not be found
	 */
	@Override
	public wsi[] findByFilename_PrevAndNext(long wsiId, String filename,
		OrderByComparator<wsi> orderByComparator) throws NoSuchwsiException {
		wsi wsi = findByPrimaryKey(wsiId);

		Session session = null;

		try {
			session = openSession();

			wsi[] array = new wsiImpl[3];

			array[0] = getByFilename_PrevAndNext(session, wsi, filename,
					orderByComparator, true);

			array[1] = wsi;

			array[2] = getByFilename_PrevAndNext(session, wsi, filename,
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

	protected wsi getByFilename_PrevAndNext(Session session, wsi wsi,
		String filename, OrderByComparator<wsi> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WSI_WHERE);

		boolean bindFilename = false;

		if (filename == null) {
			query.append(_FINDER_COLUMN_FILENAME_FILENAME_1);
		}
		else if (filename.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
		}
		else {
			bindFilename = true;

			query.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
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
			query.append(wsiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFilename) {
			qPos.add(filename);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wsi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<wsi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wsis where filename = &#63; from the database.
	 *
	 * @param filename the filename
	 */
	@Override
	public void removeByFilename(String filename) {
		for (wsi wsi : findByFilename(filename, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(wsi);
		}
	}

	/**
	 * Returns the number of wsis where filename = &#63;.
	 *
	 * @param filename the filename
	 * @return the number of matching wsis
	 */
	@Override
	public int countByFilename(String filename) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILENAME;

		Object[] finderArgs = new Object[] { filename };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WSI_WHERE);

			boolean bindFilename = false;

			if (filename == null) {
				query.append(_FINDER_COLUMN_FILENAME_FILENAME_1);
			}
			else if (filename.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FILENAME_FILENAME_3);
			}
			else {
				bindFilename = true;

				query.append(_FINDER_COLUMN_FILENAME_FILENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFilename) {
					qPos.add(filename);
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

	private static final String _FINDER_COLUMN_FILENAME_FILENAME_1 = "wsi.filename IS NULL";
	private static final String _FINDER_COLUMN_FILENAME_FILENAME_2 = "wsi.filename = ?";
	private static final String _FINDER_COLUMN_FILENAME_FILENAME_3 = "(wsi.filename IS NULL OR wsi.filename = '')";

	public wsiPersistenceImpl() {
		setModelClass(wsi.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the wsi in the entity cache if it is enabled.
	 *
	 * @param wsi the wsi
	 */
	@Override
	public void cacheResult(wsi wsi) {
		entityCache.putResult(wsiModelImpl.ENTITY_CACHE_ENABLED, wsiImpl.class,
			wsi.getPrimaryKey(), wsi);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { wsi.getUuid(), wsi.getGroupId() }, wsi);

		wsi.resetOriginalValues();
	}

	/**
	 * Caches the wsis in the entity cache if it is enabled.
	 *
	 * @param wsis the wsis
	 */
	@Override
	public void cacheResult(List<wsi> wsis) {
		for (wsi wsi : wsis) {
			if (entityCache.getResult(wsiModelImpl.ENTITY_CACHE_ENABLED,
						wsiImpl.class, wsi.getPrimaryKey()) == null) {
				cacheResult(wsi);
			}
			else {
				wsi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wsis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(wsiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the wsi.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(wsi wsi) {
		entityCache.removeResult(wsiModelImpl.ENTITY_CACHE_ENABLED,
			wsiImpl.class, wsi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((wsiModelImpl)wsi, true);
	}

	@Override
	public void clearCache(List<wsi> wsis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (wsi wsi : wsis) {
			entityCache.removeResult(wsiModelImpl.ENTITY_CACHE_ENABLED,
				wsiImpl.class, wsi.getPrimaryKey());

			clearUniqueFindersCache((wsiModelImpl)wsi, true);
		}
	}

	protected void cacheUniqueFindersCache(wsiModelImpl wsiModelImpl) {
		Object[] args = new Object[] {
				wsiModelImpl.getUuid(), wsiModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, wsiModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(wsiModelImpl wsiModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					wsiModelImpl.getUuid(), wsiModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((wsiModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wsiModelImpl.getOriginalUuid(),
					wsiModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new wsi with the primary key. Does not add the wsi to the database.
	 *
	 * @param wsiId the primary key for the new wsi
	 * @return the new wsi
	 */
	@Override
	public wsi create(long wsiId) {
		wsi wsi = new wsiImpl();

		wsi.setNew(true);
		wsi.setPrimaryKey(wsiId);

		String uuid = PortalUUIDUtil.generate();

		wsi.setUuid(uuid);

		wsi.setCompanyId(companyProvider.getCompanyId());

		return wsi;
	}

	/**
	 * Removes the wsi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wsiId the primary key of the wsi
	 * @return the wsi that was removed
	 * @throws NoSuchwsiException if a wsi with the primary key could not be found
	 */
	@Override
	public wsi remove(long wsiId) throws NoSuchwsiException {
		return remove((Serializable)wsiId);
	}

	/**
	 * Removes the wsi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wsi
	 * @return the wsi that was removed
	 * @throws NoSuchwsiException if a wsi with the primary key could not be found
	 */
	@Override
	public wsi remove(Serializable primaryKey) throws NoSuchwsiException {
		Session session = null;

		try {
			session = openSession();

			wsi wsi = (wsi)session.get(wsiImpl.class, primaryKey);

			if (wsi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchwsiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wsi);
		}
		catch (NoSuchwsiException nsee) {
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
	protected wsi removeImpl(wsi wsi) {
		wsi = toUnwrappedModel(wsi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wsi)) {
				wsi = (wsi)session.get(wsiImpl.class, wsi.getPrimaryKeyObj());
			}

			if (wsi != null) {
				session.delete(wsi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wsi != null) {
			clearCache(wsi);
		}

		return wsi;
	}

	@Override
	public wsi updateImpl(wsi wsi) {
		wsi = toUnwrappedModel(wsi);

		boolean isNew = wsi.isNew();

		wsiModelImpl wsiModelImpl = (wsiModelImpl)wsi;

		if (Validator.isNull(wsi.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			wsi.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wsi.getCreateDate() == null)) {
			if (serviceContext == null) {
				wsi.setCreateDate(now);
			}
			else {
				wsi.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!wsiModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wsi.setModifiedDate(now);
			}
			else {
				wsi.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wsi.isNew()) {
				session.save(wsi);

				wsi.setNew(false);
			}
			else {
				wsi = (wsi)session.merge(wsi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!wsiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { wsiModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					wsiModelImpl.getUuid(), wsiModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { wsiModelImpl.getFilename() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FILENAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((wsiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { wsiModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { wsiModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((wsiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wsiModelImpl.getOriginalUuid(),
						wsiModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						wsiModelImpl.getUuid(), wsiModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((wsiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { wsiModelImpl.getOriginalFilename() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FILENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME,
					args);

				args = new Object[] { wsiModelImpl.getFilename() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FILENAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILENAME,
					args);
			}
		}

		entityCache.putResult(wsiModelImpl.ENTITY_CACHE_ENABLED, wsiImpl.class,
			wsi.getPrimaryKey(), wsi, false);

		clearUniqueFindersCache(wsiModelImpl, false);
		cacheUniqueFindersCache(wsiModelImpl);

		wsi.resetOriginalValues();

		return wsi;
	}

	protected wsi toUnwrappedModel(wsi wsi) {
		if (wsi instanceof wsiImpl) {
			return wsi;
		}

		wsiImpl wsiImpl = new wsiImpl();

		wsiImpl.setNew(wsi.isNew());
		wsiImpl.setPrimaryKey(wsi.getPrimaryKey());

		wsiImpl.setUuid(wsi.getUuid());
		wsiImpl.setWsiId(wsi.getWsiId());
		wsiImpl.setGroupId(wsi.getGroupId());
		wsiImpl.setCompanyId(wsi.getCompanyId());
		wsiImpl.setUserId(wsi.getUserId());
		wsiImpl.setUserName(wsi.getUserName());
		wsiImpl.setCreateDate(wsi.getCreateDate());
		wsiImpl.setModifiedDate(wsi.getModifiedDate());
		wsiImpl.setStatus(wsi.getStatus());
		wsiImpl.setStatusByUserId(wsi.getStatusByUserId());
		wsiImpl.setStatusByUserName(wsi.getStatusByUserName());
		wsiImpl.setStatusDate(wsi.getStatusDate());
		wsiImpl.setFilename(wsi.getFilename());
		wsiImpl.setHashmrxs(wsi.getHashmrxs());
		wsiImpl.setScanstart(wsi.getScanstart());
		wsiImpl.setScanduration(wsi.getScanduration());

		return wsiImpl;
	}

	/**
	 * Returns the wsi with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the wsi
	 * @return the wsi
	 * @throws NoSuchwsiException if a wsi with the primary key could not be found
	 */
	@Override
	public wsi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchwsiException {
		wsi wsi = fetchByPrimaryKey(primaryKey);

		if (wsi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchwsiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wsi;
	}

	/**
	 * Returns the wsi with the primary key or throws a {@link NoSuchwsiException} if it could not be found.
	 *
	 * @param wsiId the primary key of the wsi
	 * @return the wsi
	 * @throws NoSuchwsiException if a wsi with the primary key could not be found
	 */
	@Override
	public wsi findByPrimaryKey(long wsiId) throws NoSuchwsiException {
		return findByPrimaryKey((Serializable)wsiId);
	}

	/**
	 * Returns the wsi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wsi
	 * @return the wsi, or <code>null</code> if a wsi with the primary key could not be found
	 */
	@Override
	public wsi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(wsiModelImpl.ENTITY_CACHE_ENABLED,
				wsiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		wsi wsi = (wsi)serializable;

		if (wsi == null) {
			Session session = null;

			try {
				session = openSession();

				wsi = (wsi)session.get(wsiImpl.class, primaryKey);

				if (wsi != null) {
					cacheResult(wsi);
				}
				else {
					entityCache.putResult(wsiModelImpl.ENTITY_CACHE_ENABLED,
						wsiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(wsiModelImpl.ENTITY_CACHE_ENABLED,
					wsiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wsi;
	}

	/**
	 * Returns the wsi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wsiId the primary key of the wsi
	 * @return the wsi, or <code>null</code> if a wsi with the primary key could not be found
	 */
	@Override
	public wsi fetchByPrimaryKey(long wsiId) {
		return fetchByPrimaryKey((Serializable)wsiId);
	}

	@Override
	public Map<Serializable, wsi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, wsi> map = new HashMap<Serializable, wsi>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			wsi wsi = fetchByPrimaryKey(primaryKey);

			if (wsi != null) {
				map.put(primaryKey, wsi);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(wsiModelImpl.ENTITY_CACHE_ENABLED,
					wsiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (wsi)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WSI_WHERE_PKS_IN);

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

			for (wsi wsi : (List<wsi>)q.list()) {
				map.put(wsi.getPrimaryKeyObj(), wsi);

				cacheResult(wsi);

				uncachedPrimaryKeys.remove(wsi.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(wsiModelImpl.ENTITY_CACHE_ENABLED,
					wsiImpl.class, primaryKey, nullModel);
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
	 * Returns all the wsis.
	 *
	 * @return the wsis
	 */
	@Override
	public List<wsi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wsis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @return the range of wsis
	 */
	@Override
	public List<wsi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the wsis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wsis
	 */
	@Override
	public List<wsi> findAll(int start, int end,
		OrderByComparator<wsi> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wsis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wsis
	 * @param end the upper bound of the range of wsis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of wsis
	 */
	@Override
	public List<wsi> findAll(int start, int end,
		OrderByComparator<wsi> orderByComparator, boolean retrieveFromCache) {
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

		List<wsi> list = null;

		if (retrieveFromCache) {
			list = (List<wsi>)finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WSI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WSI;

				if (pagination) {
					sql = sql.concat(wsiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<wsi>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<wsi>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the wsis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (wsi wsi : findAll()) {
			remove(wsi);
		}
	}

	/**
	 * Returns the number of wsis.
	 *
	 * @return the number of wsis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WSI);

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
		return wsiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the wsi persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(wsiImpl.class.getName());
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
	private static final String _SQL_SELECT_WSI = "SELECT wsi FROM wsi wsi";
	private static final String _SQL_SELECT_WSI_WHERE_PKS_IN = "SELECT wsi FROM wsi wsi WHERE wsiId IN (";
	private static final String _SQL_SELECT_WSI_WHERE = "SELECT wsi FROM wsi wsi WHERE ";
	private static final String _SQL_COUNT_WSI = "SELECT COUNT(wsi) FROM wsi wsi";
	private static final String _SQL_COUNT_WSI_WHERE = "SELECT COUNT(wsi) FROM wsi wsi WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wsi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No wsi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No wsi exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(wsiPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}