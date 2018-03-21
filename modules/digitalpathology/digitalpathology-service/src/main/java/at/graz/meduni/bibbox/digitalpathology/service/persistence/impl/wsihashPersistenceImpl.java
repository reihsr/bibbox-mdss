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

import at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException;
import at.graz.meduni.bibbox.digitalpathology.model.impl.wsihashImpl;
import at.graz.meduni.bibbox.digitalpathology.model.impl.wsihashModelImpl;
import at.graz.meduni.bibbox.digitalpathology.model.wsihash;
import at.graz.meduni.bibbox.digitalpathology.service.persistence.wsihashPersistence;

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
 * The persistence implementation for the wsihash service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see wsihashPersistence
 * @see at.graz.meduni.bibbox.digitalpathology.service.persistence.wsihashUtil
 * @generated
 */
@ProviderType
public class wsihashPersistenceImpl extends BasePersistenceImpl<wsihash>
	implements wsihashPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link wsihashUtil} to access the wsihash persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = wsihashImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, wsihashImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, wsihashImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, wsihashImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, wsihashImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			wsihashModelImpl.UUID_COLUMN_BITMASK |
			wsihashModelImpl.WSIID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the wsihashs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching wsihashs
	 */
	@Override
	public List<wsihash> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wsihashs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @return the range of matching wsihashs
	 */
	@Override
	public List<wsihash> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the wsihashs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wsihashs
	 */
	@Override
	public List<wsihash> findByUuid(String uuid, int start, int end,
		OrderByComparator<wsihash> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wsihashs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching wsihashs
	 */
	@Override
	public List<wsihash> findByUuid(String uuid, int start, int end,
		OrderByComparator<wsihash> orderByComparator, boolean retrieveFromCache) {
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

		List<wsihash> list = null;

		if (retrieveFromCache) {
			list = (List<wsihash>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (wsihash wsihash : list) {
					if (!Objects.equals(uuid, wsihash.getUuid())) {
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

			query.append(_SQL_SELECT_WSIHASH_WHERE);

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
				query.append(wsihashModelImpl.ORDER_BY_JPQL);
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
					list = (List<wsihash>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<wsihash>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first wsihash in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsihash
	 * @throws NoSuchwsihashException if a matching wsihash could not be found
	 */
	@Override
	public wsihash findByUuid_First(String uuid,
		OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException {
		wsihash wsihash = fetchByUuid_First(uuid, orderByComparator);

		if (wsihash != null) {
			return wsihash;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsihashException(msg.toString());
	}

	/**
	 * Returns the first wsihash in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsihash, or <code>null</code> if a matching wsihash could not be found
	 */
	@Override
	public wsihash fetchByUuid_First(String uuid,
		OrderByComparator<wsihash> orderByComparator) {
		List<wsihash> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last wsihash in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsihash
	 * @throws NoSuchwsihashException if a matching wsihash could not be found
	 */
	@Override
	public wsihash findByUuid_Last(String uuid,
		OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException {
		wsihash wsihash = fetchByUuid_Last(uuid, orderByComparator);

		if (wsihash != null) {
			return wsihash;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsihashException(msg.toString());
	}

	/**
	 * Returns the last wsihash in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsihash, or <code>null</code> if a matching wsihash could not be found
	 */
	@Override
	public wsihash fetchByUuid_Last(String uuid,
		OrderByComparator<wsihash> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<wsihash> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the wsihashs before and after the current wsihash in the ordered set where uuid = &#63;.
	 *
	 * @param wsihashId the primary key of the current wsihash
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wsihash
	 * @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	 */
	@Override
	public wsihash[] findByUuid_PrevAndNext(long wsihashId, String uuid,
		OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException {
		wsihash wsihash = findByPrimaryKey(wsihashId);

		Session session = null;

		try {
			session = openSession();

			wsihash[] array = new wsihashImpl[3];

			array[0] = getByUuid_PrevAndNext(session, wsihash, uuid,
					orderByComparator, true);

			array[1] = wsihash;

			array[2] = getByUuid_PrevAndNext(session, wsihash, uuid,
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

	protected wsihash getByUuid_PrevAndNext(Session session, wsihash wsihash,
		String uuid, OrderByComparator<wsihash> orderByComparator,
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

		query.append(_SQL_SELECT_WSIHASH_WHERE);

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
			query.append(wsihashModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wsihash);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<wsihash> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wsihashs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (wsihash wsihash : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(wsihash);
		}
	}

	/**
	 * Returns the number of wsihashs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching wsihashs
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WSIHASH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "wsihash.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "wsihash.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(wsihash.uuid IS NULL OR wsihash.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, wsihashImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			wsihashModelImpl.UUID_COLUMN_BITMASK |
			wsihashModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the wsihash where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchwsihashException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching wsihash
	 * @throws NoSuchwsihashException if a matching wsihash could not be found
	 */
	@Override
	public wsihash findByUUID_G(String uuid, long groupId)
		throws NoSuchwsihashException {
		wsihash wsihash = fetchByUUID_G(uuid, groupId);

		if (wsihash == null) {
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

			throw new NoSuchwsihashException(msg.toString());
		}

		return wsihash;
	}

	/**
	 * Returns the wsihash where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching wsihash, or <code>null</code> if a matching wsihash could not be found
	 */
	@Override
	public wsihash fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the wsihash where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching wsihash, or <code>null</code> if a matching wsihash could not be found
	 */
	@Override
	public wsihash fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof wsihash) {
			wsihash wsihash = (wsihash)result;

			if (!Objects.equals(uuid, wsihash.getUuid()) ||
					(groupId != wsihash.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_WSIHASH_WHERE);

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

				List<wsihash> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					wsihash wsihash = list.get(0);

					result = wsihash;

					cacheResult(wsihash);

					if ((wsihash.getUuid() == null) ||
							!wsihash.getUuid().equals(uuid) ||
							(wsihash.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, wsihash);
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
			return (wsihash)result;
		}
	}

	/**
	 * Removes the wsihash where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the wsihash that was removed
	 */
	@Override
	public wsihash removeByUUID_G(String uuid, long groupId)
		throws NoSuchwsihashException {
		wsihash wsihash = findByUUID_G(uuid, groupId);

		return remove(wsihash);
	}

	/**
	 * Returns the number of wsihashs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching wsihashs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WSIHASH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "wsihash.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "wsihash.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(wsihash.uuid IS NULL OR wsihash.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "wsihash.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, wsihashImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, wsihashImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			wsihashModelImpl.UUID_COLUMN_BITMASK |
			wsihashModelImpl.COMPANYID_COLUMN_BITMASK |
			wsihashModelImpl.WSIID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the wsihashs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching wsihashs
	 */
	@Override
	public List<wsihash> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wsihashs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @return the range of matching wsihashs
	 */
	@Override
	public List<wsihash> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the wsihashs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wsihashs
	 */
	@Override
	public List<wsihash> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<wsihash> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wsihashs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching wsihashs
	 */
	@Override
	public List<wsihash> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<wsihash> orderByComparator,
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

		List<wsihash> list = null;

		if (retrieveFromCache) {
			list = (List<wsihash>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (wsihash wsihash : list) {
					if (!Objects.equals(uuid, wsihash.getUuid()) ||
							(companyId != wsihash.getCompanyId())) {
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

			query.append(_SQL_SELECT_WSIHASH_WHERE);

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
				query.append(wsihashModelImpl.ORDER_BY_JPQL);
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
					list = (List<wsihash>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<wsihash>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsihash
	 * @throws NoSuchwsihashException if a matching wsihash could not be found
	 */
	@Override
	public wsihash findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException {
		wsihash wsihash = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (wsihash != null) {
			return wsihash;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsihashException(msg.toString());
	}

	/**
	 * Returns the first wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsihash, or <code>null</code> if a matching wsihash could not be found
	 */
	@Override
	public wsihash fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<wsihash> orderByComparator) {
		List<wsihash> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsihash
	 * @throws NoSuchwsihashException if a matching wsihash could not be found
	 */
	@Override
	public wsihash findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException {
		wsihash wsihash = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (wsihash != null) {
			return wsihash;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsihashException(msg.toString());
	}

	/**
	 * Returns the last wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsihash, or <code>null</code> if a matching wsihash could not be found
	 */
	@Override
	public wsihash fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<wsihash> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<wsihash> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the wsihashs before and after the current wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param wsihashId the primary key of the current wsihash
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wsihash
	 * @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	 */
	@Override
	public wsihash[] findByUuid_C_PrevAndNext(long wsihashId, String uuid,
		long companyId, OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException {
		wsihash wsihash = findByPrimaryKey(wsihashId);

		Session session = null;

		try {
			session = openSession();

			wsihash[] array = new wsihashImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, wsihash, uuid,
					companyId, orderByComparator, true);

			array[1] = wsihash;

			array[2] = getByUuid_C_PrevAndNext(session, wsihash, uuid,
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

	protected wsihash getByUuid_C_PrevAndNext(Session session, wsihash wsihash,
		String uuid, long companyId,
		OrderByComparator<wsihash> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_WSIHASH_WHERE);

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
			query.append(wsihashModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(wsihash);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<wsihash> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wsihashs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (wsihash wsihash : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(wsihash);
		}
	}

	/**
	 * Returns the number of wsihashs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching wsihashs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_WSIHASH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "wsihash.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "wsihash.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(wsihash.uuid IS NULL OR wsihash.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "wsihash.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WSI = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, wsihashImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWsi",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WSI = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, wsihashImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWsi",
			new String[] { Long.class.getName() },
			wsihashModelImpl.WSIID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WSI = new FinderPath(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWsi",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the wsihashs where wsiId = &#63;.
	 *
	 * @param wsiId the wsi ID
	 * @return the matching wsihashs
	 */
	@Override
	public List<wsihash> findByWsi(long wsiId) {
		return findByWsi(wsiId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wsihashs where wsiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param wsiId the wsi ID
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @return the range of matching wsihashs
	 */
	@Override
	public List<wsihash> findByWsi(long wsiId, int start, int end) {
		return findByWsi(wsiId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the wsihashs where wsiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param wsiId the wsi ID
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching wsihashs
	 */
	@Override
	public List<wsihash> findByWsi(long wsiId, int start, int end,
		OrderByComparator<wsihash> orderByComparator) {
		return findByWsi(wsiId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wsihashs where wsiId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param wsiId the wsi ID
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching wsihashs
	 */
	@Override
	public List<wsihash> findByWsi(long wsiId, int start, int end,
		OrderByComparator<wsihash> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WSI;
			finderArgs = new Object[] { wsiId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WSI;
			finderArgs = new Object[] { wsiId, start, end, orderByComparator };
		}

		List<wsihash> list = null;

		if (retrieveFromCache) {
			list = (List<wsihash>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (wsihash wsihash : list) {
					if ((wsiId != wsihash.getWsiId())) {
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

			query.append(_SQL_SELECT_WSIHASH_WHERE);

			query.append(_FINDER_COLUMN_WSI_WSIID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(wsihashModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wsiId);

				if (!pagination) {
					list = (List<wsihash>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<wsihash>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first wsihash in the ordered set where wsiId = &#63;.
	 *
	 * @param wsiId the wsi ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsihash
	 * @throws NoSuchwsihashException if a matching wsihash could not be found
	 */
	@Override
	public wsihash findByWsi_First(long wsiId,
		OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException {
		wsihash wsihash = fetchByWsi_First(wsiId, orderByComparator);

		if (wsihash != null) {
			return wsihash;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("wsiId=");
		msg.append(wsiId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsihashException(msg.toString());
	}

	/**
	 * Returns the first wsihash in the ordered set where wsiId = &#63;.
	 *
	 * @param wsiId the wsi ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching wsihash, or <code>null</code> if a matching wsihash could not be found
	 */
	@Override
	public wsihash fetchByWsi_First(long wsiId,
		OrderByComparator<wsihash> orderByComparator) {
		List<wsihash> list = findByWsi(wsiId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last wsihash in the ordered set where wsiId = &#63;.
	 *
	 * @param wsiId the wsi ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsihash
	 * @throws NoSuchwsihashException if a matching wsihash could not be found
	 */
	@Override
	public wsihash findByWsi_Last(long wsiId,
		OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException {
		wsihash wsihash = fetchByWsi_Last(wsiId, orderByComparator);

		if (wsihash != null) {
			return wsihash;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("wsiId=");
		msg.append(wsiId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchwsihashException(msg.toString());
	}

	/**
	 * Returns the last wsihash in the ordered set where wsiId = &#63;.
	 *
	 * @param wsiId the wsi ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching wsihash, or <code>null</code> if a matching wsihash could not be found
	 */
	@Override
	public wsihash fetchByWsi_Last(long wsiId,
		OrderByComparator<wsihash> orderByComparator) {
		int count = countByWsi(wsiId);

		if (count == 0) {
			return null;
		}

		List<wsihash> list = findByWsi(wsiId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the wsihashs before and after the current wsihash in the ordered set where wsiId = &#63;.
	 *
	 * @param wsihashId the primary key of the current wsihash
	 * @param wsiId the wsi ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next wsihash
	 * @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	 */
	@Override
	public wsihash[] findByWsi_PrevAndNext(long wsihashId, long wsiId,
		OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException {
		wsihash wsihash = findByPrimaryKey(wsihashId);

		Session session = null;

		try {
			session = openSession();

			wsihash[] array = new wsihashImpl[3];

			array[0] = getByWsi_PrevAndNext(session, wsihash, wsiId,
					orderByComparator, true);

			array[1] = wsihash;

			array[2] = getByWsi_PrevAndNext(session, wsihash, wsiId,
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

	protected wsihash getByWsi_PrevAndNext(Session session, wsihash wsihash,
		long wsiId, OrderByComparator<wsihash> orderByComparator,
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

		query.append(_SQL_SELECT_WSIHASH_WHERE);

		query.append(_FINDER_COLUMN_WSI_WSIID_2);

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
			query.append(wsihashModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(wsiId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(wsihash);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<wsihash> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the wsihashs where wsiId = &#63; from the database.
	 *
	 * @param wsiId the wsi ID
	 */
	@Override
	public void removeByWsi(long wsiId) {
		for (wsihash wsihash : findByWsi(wsiId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(wsihash);
		}
	}

	/**
	 * Returns the number of wsihashs where wsiId = &#63;.
	 *
	 * @param wsiId the wsi ID
	 * @return the number of matching wsihashs
	 */
	@Override
	public int countByWsi(long wsiId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WSI;

		Object[] finderArgs = new Object[] { wsiId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WSIHASH_WHERE);

			query.append(_FINDER_COLUMN_WSI_WSIID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(wsiId);

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

	private static final String _FINDER_COLUMN_WSI_WSIID_2 = "wsihash.wsiId = ?";

	public wsihashPersistenceImpl() {
		setModelClass(wsihash.class);

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
	 * Caches the wsihash in the entity cache if it is enabled.
	 *
	 * @param wsihash the wsihash
	 */
	@Override
	public void cacheResult(wsihash wsihash) {
		entityCache.putResult(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashImpl.class, wsihash.getPrimaryKey(), wsihash);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { wsihash.getUuid(), wsihash.getGroupId() }, wsihash);

		wsihash.resetOriginalValues();
	}

	/**
	 * Caches the wsihashs in the entity cache if it is enabled.
	 *
	 * @param wsihashs the wsihashs
	 */
	@Override
	public void cacheResult(List<wsihash> wsihashs) {
		for (wsihash wsihash : wsihashs) {
			if (entityCache.getResult(wsihashModelImpl.ENTITY_CACHE_ENABLED,
						wsihashImpl.class, wsihash.getPrimaryKey()) == null) {
				cacheResult(wsihash);
			}
			else {
				wsihash.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wsihashs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(wsihashImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the wsihash.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(wsihash wsihash) {
		entityCache.removeResult(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashImpl.class, wsihash.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((wsihashModelImpl)wsihash, true);
	}

	@Override
	public void clearCache(List<wsihash> wsihashs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (wsihash wsihash : wsihashs) {
			entityCache.removeResult(wsihashModelImpl.ENTITY_CACHE_ENABLED,
				wsihashImpl.class, wsihash.getPrimaryKey());

			clearUniqueFindersCache((wsihashModelImpl)wsihash, true);
		}
	}

	protected void cacheUniqueFindersCache(wsihashModelImpl wsihashModelImpl) {
		Object[] args = new Object[] {
				wsihashModelImpl.getUuid(), wsihashModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			wsihashModelImpl, false);
	}

	protected void clearUniqueFindersCache(wsihashModelImpl wsihashModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					wsihashModelImpl.getUuid(), wsihashModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((wsihashModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					wsihashModelImpl.getOriginalUuid(),
					wsihashModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new wsihash with the primary key. Does not add the wsihash to the database.
	 *
	 * @param wsihashId the primary key for the new wsihash
	 * @return the new wsihash
	 */
	@Override
	public wsihash create(long wsihashId) {
		wsihash wsihash = new wsihashImpl();

		wsihash.setNew(true);
		wsihash.setPrimaryKey(wsihashId);

		String uuid = PortalUUIDUtil.generate();

		wsihash.setUuid(uuid);

		wsihash.setCompanyId(companyProvider.getCompanyId());

		return wsihash;
	}

	/**
	 * Removes the wsihash with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wsihashId the primary key of the wsihash
	 * @return the wsihash that was removed
	 * @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	 */
	@Override
	public wsihash remove(long wsihashId) throws NoSuchwsihashException {
		return remove((Serializable)wsihashId);
	}

	/**
	 * Removes the wsihash with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wsihash
	 * @return the wsihash that was removed
	 * @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	 */
	@Override
	public wsihash remove(Serializable primaryKey)
		throws NoSuchwsihashException {
		Session session = null;

		try {
			session = openSession();

			wsihash wsihash = (wsihash)session.get(wsihashImpl.class, primaryKey);

			if (wsihash == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchwsihashException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(wsihash);
		}
		catch (NoSuchwsihashException nsee) {
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
	protected wsihash removeImpl(wsihash wsihash) {
		wsihash = toUnwrappedModel(wsihash);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(wsihash)) {
				wsihash = (wsihash)session.get(wsihashImpl.class,
						wsihash.getPrimaryKeyObj());
			}

			if (wsihash != null) {
				session.delete(wsihash);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (wsihash != null) {
			clearCache(wsihash);
		}

		return wsihash;
	}

	@Override
	public wsihash updateImpl(wsihash wsihash) {
		wsihash = toUnwrappedModel(wsihash);

		boolean isNew = wsihash.isNew();

		wsihashModelImpl wsihashModelImpl = (wsihashModelImpl)wsihash;

		if (Validator.isNull(wsihash.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			wsihash.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (wsihash.getCreateDate() == null)) {
			if (serviceContext == null) {
				wsihash.setCreateDate(now);
			}
			else {
				wsihash.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!wsihashModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				wsihash.setModifiedDate(now);
			}
			else {
				wsihash.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (wsihash.isNew()) {
				session.save(wsihash);

				wsihash.setNew(false);
			}
			else {
				wsihash = (wsihash)session.merge(wsihash);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!wsihashModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { wsihashModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					wsihashModelImpl.getUuid(), wsihashModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { wsihashModelImpl.getWsiId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_WSI, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WSI,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((wsihashModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { wsihashModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { wsihashModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((wsihashModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						wsihashModelImpl.getOriginalUuid(),
						wsihashModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						wsihashModelImpl.getUuid(),
						wsihashModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((wsihashModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WSI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { wsihashModelImpl.getOriginalWsiId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WSI, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WSI,
					args);

				args = new Object[] { wsihashModelImpl.getWsiId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WSI, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WSI,
					args);
			}
		}

		entityCache.putResult(wsihashModelImpl.ENTITY_CACHE_ENABLED,
			wsihashImpl.class, wsihash.getPrimaryKey(), wsihash, false);

		clearUniqueFindersCache(wsihashModelImpl, false);
		cacheUniqueFindersCache(wsihashModelImpl);

		wsihash.resetOriginalValues();

		return wsihash;
	}

	protected wsihash toUnwrappedModel(wsihash wsihash) {
		if (wsihash instanceof wsihashImpl) {
			return wsihash;
		}

		wsihashImpl wsihashImpl = new wsihashImpl();

		wsihashImpl.setNew(wsihash.isNew());
		wsihashImpl.setPrimaryKey(wsihash.getPrimaryKey());

		wsihashImpl.setUuid(wsihash.getUuid());
		wsihashImpl.setWsihashId(wsihash.getWsihashId());
		wsihashImpl.setGroupId(wsihash.getGroupId());
		wsihashImpl.setCompanyId(wsihash.getCompanyId());
		wsihashImpl.setUserId(wsihash.getUserId());
		wsihashImpl.setUserName(wsihash.getUserName());
		wsihashImpl.setCreateDate(wsihash.getCreateDate());
		wsihashImpl.setModifiedDate(wsihash.getModifiedDate());
		wsihashImpl.setStatus(wsihash.getStatus());
		wsihashImpl.setStatusByUserId(wsihash.getStatusByUserId());
		wsihashImpl.setStatusByUserName(wsihash.getStatusByUserName());
		wsihashImpl.setStatusDate(wsihash.getStatusDate());
		wsihashImpl.setWsiId(wsihash.getWsiId());
		wsihashImpl.setFilename(wsihash.getFilename());
		wsihashImpl.setHash(wsihash.getHash());

		return wsihashImpl;
	}

	/**
	 * Returns the wsihash with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the wsihash
	 * @return the wsihash
	 * @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	 */
	@Override
	public wsihash findByPrimaryKey(Serializable primaryKey)
		throws NoSuchwsihashException {
		wsihash wsihash = fetchByPrimaryKey(primaryKey);

		if (wsihash == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchwsihashException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return wsihash;
	}

	/**
	 * Returns the wsihash with the primary key or throws a {@link NoSuchwsihashException} if it could not be found.
	 *
	 * @param wsihashId the primary key of the wsihash
	 * @return the wsihash
	 * @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	 */
	@Override
	public wsihash findByPrimaryKey(long wsihashId)
		throws NoSuchwsihashException {
		return findByPrimaryKey((Serializable)wsihashId);
	}

	/**
	 * Returns the wsihash with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wsihash
	 * @return the wsihash, or <code>null</code> if a wsihash with the primary key could not be found
	 */
	@Override
	public wsihash fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(wsihashModelImpl.ENTITY_CACHE_ENABLED,
				wsihashImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		wsihash wsihash = (wsihash)serializable;

		if (wsihash == null) {
			Session session = null;

			try {
				session = openSession();

				wsihash = (wsihash)session.get(wsihashImpl.class, primaryKey);

				if (wsihash != null) {
					cacheResult(wsihash);
				}
				else {
					entityCache.putResult(wsihashModelImpl.ENTITY_CACHE_ENABLED,
						wsihashImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(wsihashModelImpl.ENTITY_CACHE_ENABLED,
					wsihashImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return wsihash;
	}

	/**
	 * Returns the wsihash with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wsihashId the primary key of the wsihash
	 * @return the wsihash, or <code>null</code> if a wsihash with the primary key could not be found
	 */
	@Override
	public wsihash fetchByPrimaryKey(long wsihashId) {
		return fetchByPrimaryKey((Serializable)wsihashId);
	}

	@Override
	public Map<Serializable, wsihash> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, wsihash> map = new HashMap<Serializable, wsihash>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			wsihash wsihash = fetchByPrimaryKey(primaryKey);

			if (wsihash != null) {
				map.put(primaryKey, wsihash);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(wsihashModelImpl.ENTITY_CACHE_ENABLED,
					wsihashImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (wsihash)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WSIHASH_WHERE_PKS_IN);

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

			for (wsihash wsihash : (List<wsihash>)q.list()) {
				map.put(wsihash.getPrimaryKeyObj(), wsihash);

				cacheResult(wsihash);

				uncachedPrimaryKeys.remove(wsihash.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(wsihashModelImpl.ENTITY_CACHE_ENABLED,
					wsihashImpl.class, primaryKey, nullModel);
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
	 * Returns all the wsihashs.
	 *
	 * @return the wsihashs
	 */
	@Override
	public List<wsihash> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wsihashs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @return the range of wsihashs
	 */
	@Override
	public List<wsihash> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the wsihashs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wsihashs
	 */
	@Override
	public List<wsihash> findAll(int start, int end,
		OrderByComparator<wsihash> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wsihashs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wsihashs
	 * @param end the upper bound of the range of wsihashs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of wsihashs
	 */
	@Override
	public List<wsihash> findAll(int start, int end,
		OrderByComparator<wsihash> orderByComparator, boolean retrieveFromCache) {
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

		List<wsihash> list = null;

		if (retrieveFromCache) {
			list = (List<wsihash>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WSIHASH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WSIHASH;

				if (pagination) {
					sql = sql.concat(wsihashModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<wsihash>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<wsihash>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the wsihashs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (wsihash wsihash : findAll()) {
			remove(wsihash);
		}
	}

	/**
	 * Returns the number of wsihashs.
	 *
	 * @return the number of wsihashs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WSIHASH);

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
		return wsihashModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the wsihash persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(wsihashImpl.class.getName());
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
	private static final String _SQL_SELECT_WSIHASH = "SELECT wsihash FROM wsihash wsihash";
	private static final String _SQL_SELECT_WSIHASH_WHERE_PKS_IN = "SELECT wsihash FROM wsihash wsihash WHERE wsihashId IN (";
	private static final String _SQL_SELECT_WSIHASH_WHERE = "SELECT wsihash FROM wsihash wsihash WHERE ";
	private static final String _SQL_COUNT_WSIHASH = "SELECT COUNT(wsihash) FROM wsihash wsihash";
	private static final String _SQL_COUNT_WSIHASH_WHERE = "SELECT COUNT(wsihash) FROM wsihash wsihash WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wsihash.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No wsihash exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No wsihash exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(wsihashPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}