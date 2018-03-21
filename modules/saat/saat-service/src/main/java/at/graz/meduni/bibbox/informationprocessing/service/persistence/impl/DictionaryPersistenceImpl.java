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

package at.graz.meduni.bibbox.informationprocessing.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException;
import at.graz.meduni.bibbox.informationprocessing.model.Dictionary;
import at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryImpl;
import at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryModelImpl;
import at.graz.meduni.bibbox.informationprocessing.service.persistence.DictionaryPersistence;

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
 * The persistence implementation for the dictionary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see DictionaryPersistence
 * @see at.graz.meduni.bibbox.informationprocessing.service.persistence.DictionaryUtil
 * @generated
 */
@ProviderType
public class DictionaryPersistenceImpl extends BasePersistenceImpl<Dictionary>
	implements DictionaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictionaryUtil} to access the dictionary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictionaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DictionaryModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dictionaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dictionaries
	 */
	@Override
	public List<Dictionary> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByUuid(String uuid, int start, int end,
		OrderByComparator<Dictionary> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionaries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByUuid(String uuid, int start, int end,
		OrderByComparator<Dictionary> orderByComparator,
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

		List<Dictionary> list = null;

		if (retrieveFromCache) {
			list = (List<Dictionary>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Dictionary dictionary : list) {
					if (!Objects.equals(uuid, dictionary.getUuid())) {
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

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

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
				query.append(DictionaryModelImpl.ORDER_BY_JPQL);
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
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dictionary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary
	 * @throws NoSuchDictionaryException if a matching dictionary could not be found
	 */
	@Override
	public Dictionary findByUuid_First(String uuid,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByUuid_First(uuid, orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the first dictionary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByUuid_First(String uuid,
		OrderByComparator<Dictionary> orderByComparator) {
		List<Dictionary> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary
	 * @throws NoSuchDictionaryException if a matching dictionary could not be found
	 */
	@Override
	public Dictionary findByUuid_Last(String uuid,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByUuid_Last(uuid, orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the last dictionary in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByUuid_Last(String uuid,
		OrderByComparator<Dictionary> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Dictionary> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionaries before and after the current dictionary in the ordered set where uuid = &#63;.
	 *
	 * @param dictionaryId the primary key of the current dictionary
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary[] findByUuid_PrevAndNext(long dictionaryId, String uuid,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = findByPrimaryKey(dictionaryId);

		Session session = null;

		try {
			session = openSession();

			Dictionary[] array = new DictionaryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, dictionary, uuid,
					orderByComparator, true);

			array[1] = dictionary;

			array[2] = getByUuid_PrevAndNext(session, dictionary, uuid,
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

	protected Dictionary getByUuid_PrevAndNext(Session session,
		Dictionary dictionary, String uuid,
		OrderByComparator<Dictionary> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTIONARY_WHERE);

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
			query.append(DictionaryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(dictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionaries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Dictionary dictionary : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dictionaries
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "dictionary.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "dictionary.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(dictionary.uuid IS NULL OR dictionary.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			DictionaryModelImpl.UUID_COLUMN_BITMASK |
			DictionaryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the dictionary where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDictionaryException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dictionary
	 * @throws NoSuchDictionaryException if a matching dictionary could not be found
	 */
	@Override
	public Dictionary findByUUID_G(String uuid, long groupId)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByUUID_G(uuid, groupId);

		if (dictionary == null) {
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

			throw new NoSuchDictionaryException(msg.toString());
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dictionary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Dictionary) {
			Dictionary dictionary = (Dictionary)result;

			if (!Objects.equals(uuid, dictionary.getUuid()) ||
					(groupId != dictionary.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

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

				List<Dictionary> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Dictionary dictionary = list.get(0);

					result = dictionary;

					cacheResult(dictionary);

					if ((dictionary.getUuid() == null) ||
							!dictionary.getUuid().equals(uuid) ||
							(dictionary.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, dictionary);
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
			return (Dictionary)result;
		}
	}

	/**
	 * Removes the dictionary where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dictionary that was removed
	 */
	@Override
	public Dictionary removeByUUID_G(String uuid, long groupId)
		throws NoSuchDictionaryException {
		Dictionary dictionary = findByUUID_G(uuid, groupId);

		return remove(dictionary);
	}

	/**
	 * Returns the number of dictionaries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dictionaries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "dictionary.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "dictionary.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(dictionary.uuid IS NULL OR dictionary.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "dictionary.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			DictionaryModelImpl.UUID_COLUMN_BITMASK |
			DictionaryModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the dictionaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dictionaries
	 */
	@Override
	public List<Dictionary> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Dictionary> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionaries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Dictionary> orderByComparator,
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

		List<Dictionary> list = null;

		if (retrieveFromCache) {
			list = (List<Dictionary>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Dictionary dictionary : list) {
					if (!Objects.equals(uuid, dictionary.getUuid()) ||
							(companyId != dictionary.getCompanyId())) {
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

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

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
				query.append(DictionaryModelImpl.ORDER_BY_JPQL);
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
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dictionary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary
	 * @throws NoSuchDictionaryException if a matching dictionary could not be found
	 */
	@Override
	public Dictionary findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the first dictionary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Dictionary> orderByComparator) {
		List<Dictionary> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary
	 * @throws NoSuchDictionaryException if a matching dictionary could not be found
	 */
	@Override
	public Dictionary findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the last dictionary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Dictionary> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Dictionary> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionaries before and after the current dictionary in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dictionaryId the primary key of the current dictionary
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary[] findByUuid_C_PrevAndNext(long dictionaryId,
		String uuid, long companyId,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = findByPrimaryKey(dictionaryId);

		Session session = null;

		try {
			session = openSession();

			Dictionary[] array = new DictionaryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, dictionary, uuid,
					companyId, orderByComparator, true);

			array[1] = dictionary;

			array[2] = getByUuid_C_PrevAndNext(session, dictionary, uuid,
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

	protected Dictionary getByUuid_C_PrevAndNext(Session session,
		Dictionary dictionary, String uuid, long companyId,
		OrderByComparator<Dictionary> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DICTIONARY_WHERE);

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
			query.append(DictionaryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(dictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionaries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Dictionary dictionary : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dictionaries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "dictionary.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "dictionary.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(dictionary.uuid IS NULL OR dictionary.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "dictionary.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOT = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoot",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoot",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			DictionaryModelImpl.ROOT_COLUMN_BITMASK |
			DictionaryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ROOT = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoot",
			new String[] { Boolean.class.getName(), Long.class.getName() });

	/**
	 * Returns all the dictionaries where root = &#63; and groupId = &#63;.
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @return the matching dictionaries
	 */
	@Override
	public List<Dictionary> findByRoot(boolean root, long groupId) {
		return findByRoot(root, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dictionaries where root = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByRoot(boolean root, long groupId, int start,
		int end) {
		return findByRoot(root, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries where root = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByRoot(boolean root, long groupId, int start,
		int end, OrderByComparator<Dictionary> orderByComparator) {
		return findByRoot(root, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionaries where root = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByRoot(boolean root, long groupId, int start,
		int end, OrderByComparator<Dictionary> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT;
			finderArgs = new Object[] { root, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROOT;
			finderArgs = new Object[] {
					root, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Dictionary> list = null;

		if (retrieveFromCache) {
			list = (List<Dictionary>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Dictionary dictionary : list) {
					if ((root != dictionary.getRoot()) ||
							(groupId != dictionary.getGroupId())) {
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

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

			query.append(_FINDER_COLUMN_ROOT_ROOT_2);

			query.append(_FINDER_COLUMN_ROOT_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(root);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dictionary in the ordered set where root = &#63; and groupId = &#63;.
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary
	 * @throws NoSuchDictionaryException if a matching dictionary could not be found
	 */
	@Override
	public Dictionary findByRoot_First(boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByRoot_First(root, groupId,
				orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("root=");
		msg.append(root);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the first dictionary in the ordered set where root = &#63; and groupId = &#63;.
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByRoot_First(boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator) {
		List<Dictionary> list = findByRoot(root, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary in the ordered set where root = &#63; and groupId = &#63;.
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary
	 * @throws NoSuchDictionaryException if a matching dictionary could not be found
	 */
	@Override
	public Dictionary findByRoot_Last(boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByRoot_Last(root, groupId,
				orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("root=");
		msg.append(root);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the last dictionary in the ordered set where root = &#63; and groupId = &#63;.
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByRoot_Last(boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator) {
		int count = countByRoot(root, groupId);

		if (count == 0) {
			return null;
		}

		List<Dictionary> list = findByRoot(root, groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionaries before and after the current dictionary in the ordered set where root = &#63; and groupId = &#63;.
	 *
	 * @param dictionaryId the primary key of the current dictionary
	 * @param root the root
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary[] findByRoot_PrevAndNext(long dictionaryId, boolean root,
		long groupId, OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = findByPrimaryKey(dictionaryId);

		Session session = null;

		try {
			session = openSession();

			Dictionary[] array = new DictionaryImpl[3];

			array[0] = getByRoot_PrevAndNext(session, dictionary, root,
					groupId, orderByComparator, true);

			array[1] = dictionary;

			array[2] = getByRoot_PrevAndNext(session, dictionary, root,
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

	protected Dictionary getByRoot_PrevAndNext(Session session,
		Dictionary dictionary, boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_DICTIONARY_WHERE);

		query.append(_FINDER_COLUMN_ROOT_ROOT_2);

		query.append(_FINDER_COLUMN_ROOT_GROUPID_2);

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
			query.append(DictionaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(root);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dictionaries that the user has permission to view where root = &#63; and groupId = &#63;.
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @return the matching dictionaries that the user has permission to view
	 */
	@Override
	public List<Dictionary> filterFindByRoot(boolean root, long groupId) {
		return filterFindByRoot(root, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionaries that the user has permission to view where root = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of matching dictionaries that the user has permission to view
	 */
	@Override
	public List<Dictionary> filterFindByRoot(boolean root, long groupId,
		int start, int end) {
		return filterFindByRoot(root, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries that the user has permissions to view where root = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionaries that the user has permission to view
	 */
	@Override
	public List<Dictionary> filterFindByRoot(boolean root, long groupId,
		int start, int end, OrderByComparator<Dictionary> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByRoot(root, groupId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByFields().length * 2));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DICTIONARY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DICTIONARY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_ROOT_ROOT_2);

		query.append(_FINDER_COLUMN_ROOT_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DICTIONARY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DictionaryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DictionaryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Dictionary.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, DictionaryImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, DictionaryImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(root);

			qPos.add(groupId);

			return (List<Dictionary>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the dictionaries before and after the current dictionary in the ordered set of dictionaries that the user has permission to view where root = &#63; and groupId = &#63;.
	 *
	 * @param dictionaryId the primary key of the current dictionary
	 * @param root the root
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary[] filterFindByRoot_PrevAndNext(long dictionaryId,
		boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByRoot_PrevAndNext(dictionaryId, root, groupId,
				orderByComparator);
		}

		Dictionary dictionary = findByPrimaryKey(dictionaryId);

		Session session = null;

		try {
			session = openSession();

			Dictionary[] array = new DictionaryImpl[3];

			array[0] = filterGetByRoot_PrevAndNext(session, dictionary, root,
					groupId, orderByComparator, true);

			array[1] = dictionary;

			array[2] = filterGetByRoot_PrevAndNext(session, dictionary, root,
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

	protected Dictionary filterGetByRoot_PrevAndNext(Session session,
		Dictionary dictionary, boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DICTIONARY_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_DICTIONARY_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_ROOT_ROOT_2);

		query.append(_FINDER_COLUMN_ROOT_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_DICTIONARY_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(DictionaryModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(DictionaryModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Dictionary.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, DictionaryImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, DictionaryImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(root);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionaries where root = &#63; and groupId = &#63; from the database.
	 *
	 * @param root the root
	 * @param groupId the group ID
	 */
	@Override
	public void removeByRoot(boolean root, long groupId) {
		for (Dictionary dictionary : findByRoot(root, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries where root = &#63; and groupId = &#63;.
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @return the number of matching dictionaries
	 */
	@Override
	public int countByRoot(boolean root, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ROOT;

		Object[] finderArgs = new Object[] { root, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

			query.append(_FINDER_COLUMN_ROOT_ROOT_2);

			query.append(_FINDER_COLUMN_ROOT_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(root);

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
	 * Returns the number of dictionaries that the user has permission to view where root = &#63; and groupId = &#63;.
	 *
	 * @param root the root
	 * @param groupId the group ID
	 * @return the number of matching dictionaries that the user has permission to view
	 */
	@Override
	public int filterCountByRoot(boolean root, long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByRoot(root, groupId);
		}

		StringBundler query = new StringBundler(3);

		query.append(_FILTER_SQL_COUNT_DICTIONARY_WHERE);

		query.append(_FINDER_COLUMN_ROOT_ROOT_2);

		query.append(_FINDER_COLUMN_ROOT_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				Dictionary.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(root);

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

	private static final String _FINDER_COLUMN_ROOT_ROOT_2 = "dictionary.root = ? AND ";
	private static final String _FINDER_COLUMN_ROOT_GROUPID_2 = "dictionary.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_DIRECTORY = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDirectory",
			new String[] { Long.class.getName(), Long.class.getName() },
			DictionaryModelImpl.DICTIONARYID_COLUMN_BITMASK |
			DictionaryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIRECTORY = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDirectory",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the dictionary where dictionaryId = &#63; and groupId = &#63; or throws a {@link NoSuchDictionaryException} if it could not be found.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param groupId the group ID
	 * @return the matching dictionary
	 * @throws NoSuchDictionaryException if a matching dictionary could not be found
	 */
	@Override
	public Dictionary findByDirectory(long dictionaryId, long groupId)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByDirectory(dictionaryId, groupId);

		if (dictionary == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dictionaryId=");
			msg.append(dictionaryId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDictionaryException(msg.toString());
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary where dictionaryId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param groupId the group ID
	 * @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByDirectory(long dictionaryId, long groupId) {
		return fetchByDirectory(dictionaryId, groupId, true);
	}

	/**
	 * Returns the dictionary where dictionaryId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByDirectory(long dictionaryId, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { dictionaryId, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_DIRECTORY,
					finderArgs, this);
		}

		if (result instanceof Dictionary) {
			Dictionary dictionary = (Dictionary)result;

			if ((dictionaryId != dictionary.getDictionaryId()) ||
					(groupId != dictionary.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

			query.append(_FINDER_COLUMN_DIRECTORY_DICTIONARYID_2);

			query.append(_FINDER_COLUMN_DIRECTORY_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictionaryId);

				qPos.add(groupId);

				List<Dictionary> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_DIRECTORY,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DictionaryPersistenceImpl.fetchByDirectory(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Dictionary dictionary = list.get(0);

					result = dictionary;

					cacheResult(dictionary);

					if ((dictionary.getDictionaryId() != dictionaryId) ||
							(dictionary.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_DIRECTORY,
							finderArgs, dictionary);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_DIRECTORY,
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
			return (Dictionary)result;
		}
	}

	/**
	 * Removes the dictionary where dictionaryId = &#63; and groupId = &#63; from the database.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param groupId the group ID
	 * @return the dictionary that was removed
	 */
	@Override
	public Dictionary removeByDirectory(long dictionaryId, long groupId)
		throws NoSuchDictionaryException {
		Dictionary dictionary = findByDirectory(dictionaryId, groupId);

		return remove(dictionary);
	}

	/**
	 * Returns the number of dictionaries where dictionaryId = &#63; and groupId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param groupId the group ID
	 * @return the number of matching dictionaries
	 */
	@Override
	public int countByDirectory(long dictionaryId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIRECTORY;

		Object[] finderArgs = new Object[] { dictionaryId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

			query.append(_FINDER_COLUMN_DIRECTORY_DICTIONARYID_2);

			query.append(_FINDER_COLUMN_DIRECTORY_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictionaryId);

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

	private static final String _FINDER_COLUMN_DIRECTORY_DICTIONARYID_2 = "dictionary.dictionaryId = ? AND ";
	private static final String _FINDER_COLUMN_DIRECTORY_GROUPID_2 = "dictionary.groupId = ?";

	public DictionaryPersistenceImpl() {
		setModelClass(Dictionary.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
			dbColumnNames.put("code", "code_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the dictionary in the entity cache if it is enabled.
	 *
	 * @param dictionary the dictionary
	 */
	@Override
	public void cacheResult(Dictionary dictionary) {
		entityCache.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey(), dictionary);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { dictionary.getUuid(), dictionary.getGroupId() },
			dictionary);

		finderCache.putResult(FINDER_PATH_FETCH_BY_DIRECTORY,
			new Object[] { dictionary.getDictionaryId(), dictionary.getGroupId() },
			dictionary);

		dictionary.resetOriginalValues();
	}

	/**
	 * Caches the dictionaries in the entity cache if it is enabled.
	 *
	 * @param dictionaries the dictionaries
	 */
	@Override
	public void cacheResult(List<Dictionary> dictionaries) {
		for (Dictionary dictionary : dictionaries) {
			if (entityCache.getResult(
						DictionaryModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryImpl.class, dictionary.getPrimaryKey()) == null) {
				cacheResult(dictionary);
			}
			else {
				dictionary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dictionaries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DictionaryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dictionary.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dictionary dictionary) {
		entityCache.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DictionaryModelImpl)dictionary, true);
	}

	@Override
	public void clearCache(List<Dictionary> dictionaries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dictionary dictionary : dictionaries) {
			entityCache.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryImpl.class, dictionary.getPrimaryKey());

			clearUniqueFindersCache((DictionaryModelImpl)dictionary, true);
		}
	}

	protected void cacheUniqueFindersCache(
		DictionaryModelImpl dictionaryModelImpl) {
		Object[] args = new Object[] {
				dictionaryModelImpl.getUuid(), dictionaryModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			dictionaryModelImpl, false);

		args = new Object[] {
				dictionaryModelImpl.getDictionaryId(),
				dictionaryModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_DIRECTORY, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_DIRECTORY, args,
			dictionaryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DictionaryModelImpl dictionaryModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					dictionaryModelImpl.getUuid(),
					dictionaryModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((dictionaryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					dictionaryModelImpl.getOriginalUuid(),
					dictionaryModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					dictionaryModelImpl.getDictionaryId(),
					dictionaryModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DIRECTORY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DIRECTORY, args);
		}

		if ((dictionaryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DIRECTORY.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					dictionaryModelImpl.getOriginalDictionaryId(),
					dictionaryModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DIRECTORY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DIRECTORY, args);
		}
	}

	/**
	 * Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	 *
	 * @param dictionaryId the primary key for the new dictionary
	 * @return the new dictionary
	 */
	@Override
	public Dictionary create(long dictionaryId) {
		Dictionary dictionary = new DictionaryImpl();

		dictionary.setNew(true);
		dictionary.setPrimaryKey(dictionaryId);

		String uuid = PortalUUIDUtil.generate();

		dictionary.setUuid(uuid);

		dictionary.setCompanyId(companyProvider.getCompanyId());

		return dictionary;
	}

	/**
	 * Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary that was removed
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary remove(long dictionaryId)
		throws NoSuchDictionaryException {
		return remove((Serializable)dictionaryId);
	}

	/**
	 * Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary that was removed
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary remove(Serializable primaryKey)
		throws NoSuchDictionaryException {
		Session session = null;

		try {
			session = openSession();

			Dictionary dictionary = (Dictionary)session.get(DictionaryImpl.class,
					primaryKey);

			if (dictionary == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictionaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictionary);
		}
		catch (NoSuchDictionaryException nsee) {
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
	protected Dictionary removeImpl(Dictionary dictionary) {
		dictionary = toUnwrappedModel(dictionary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictionary)) {
				dictionary = (Dictionary)session.get(DictionaryImpl.class,
						dictionary.getPrimaryKeyObj());
			}

			if (dictionary != null) {
				session.delete(dictionary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictionary != null) {
			clearCache(dictionary);
		}

		return dictionary;
	}

	@Override
	public Dictionary updateImpl(Dictionary dictionary) {
		dictionary = toUnwrappedModel(dictionary);

		boolean isNew = dictionary.isNew();

		DictionaryModelImpl dictionaryModelImpl = (DictionaryModelImpl)dictionary;

		if (Validator.isNull(dictionary.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dictionary.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (dictionary.getCreateDate() == null)) {
			if (serviceContext == null) {
				dictionary.setCreateDate(now);
			}
			else {
				dictionary.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!dictionaryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dictionary.setModifiedDate(now);
			}
			else {
				dictionary.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (dictionary.isNew()) {
				session.save(dictionary);

				dictionary.setNew(false);
			}
			else {
				dictionary = (Dictionary)session.merge(dictionary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DictionaryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { dictionaryModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					dictionaryModelImpl.getUuid(),
					dictionaryModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] {
					dictionaryModelImpl.getRoot(),
					dictionaryModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ROOT, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((dictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { dictionaryModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((dictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryModelImpl.getOriginalUuid(),
						dictionaryModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						dictionaryModelImpl.getUuid(),
						dictionaryModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((dictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryModelImpl.getOriginalRoot(),
						dictionaryModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ROOT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT,
					args);

				args = new Object[] {
						dictionaryModelImpl.getRoot(),
						dictionaryModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ROOT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROOT,
					args);
			}
		}

		entityCache.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey(), dictionary, false);

		clearUniqueFindersCache(dictionaryModelImpl, false);
		cacheUniqueFindersCache(dictionaryModelImpl);

		dictionary.resetOriginalValues();

		return dictionary;
	}

	protected Dictionary toUnwrappedModel(Dictionary dictionary) {
		if (dictionary instanceof DictionaryImpl) {
			return dictionary;
		}

		DictionaryImpl dictionaryImpl = new DictionaryImpl();

		dictionaryImpl.setNew(dictionary.isNew());
		dictionaryImpl.setPrimaryKey(dictionary.getPrimaryKey());

		dictionaryImpl.setUuid(dictionary.getUuid());
		dictionaryImpl.setDictionaryId(dictionary.getDictionaryId());
		dictionaryImpl.setGroupId(dictionary.getGroupId());
		dictionaryImpl.setCompanyId(dictionary.getCompanyId());
		dictionaryImpl.setUserId(dictionary.getUserId());
		dictionaryImpl.setUserName(dictionary.getUserName());
		dictionaryImpl.setCreateDate(dictionary.getCreateDate());
		dictionaryImpl.setModifiedDate(dictionary.getModifiedDate());
		dictionaryImpl.setStatus(dictionary.getStatus());
		dictionaryImpl.setStatusByUserId(dictionary.getStatusByUserId());
		dictionaryImpl.setStatusByUserName(dictionary.getStatusByUserName());
		dictionaryImpl.setStatusDate(dictionary.getStatusDate());
		dictionaryImpl.setSynonym(dictionary.getSynonym());
		dictionaryImpl.setPattern(dictionary.getPattern());
		dictionaryImpl.setCode(dictionary.isCode());
		dictionaryImpl.setCode_type(dictionary.getCode_type());
		dictionaryImpl.setCode_value(dictionary.getCode_value());
		dictionaryImpl.setRoot(dictionary.isRoot());
		dictionaryImpl.setNegation(dictionary.isNegation());
		dictionaryImpl.setPriority(dictionary.getPriority());
		dictionaryImpl.setPriority_mode(dictionary.isPriority_mode());
		dictionaryImpl.setBefore_synonym(dictionary.getBefore_synonym());
		dictionaryImpl.setAfter_synonym(dictionary.getAfter_synonym());
		dictionaryImpl.setForeword(dictionary.isForeword());
		dictionaryImpl.setEnding(dictionary.isEnding());
		dictionaryImpl.setSentence(dictionary.isSentence());
		dictionaryImpl.setOccure(dictionary.isOccure());

		return dictionaryImpl;
	}

	/**
	 * Returns the dictionary with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByPrimaryKey(primaryKey);

		if (dictionary == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictionaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary with the primary key or throws a {@link NoSuchDictionaryException} if it could not be found.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary findByPrimaryKey(long dictionaryId)
		throws NoSuchDictionaryException {
		return findByPrimaryKey((Serializable)dictionaryId);
	}

	/**
	 * Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Dictionary dictionary = (Dictionary)serializable;

		if (dictionary == null) {
			Session session = null;

			try {
				session = openSession();

				dictionary = (Dictionary)session.get(DictionaryImpl.class,
						primaryKey);

				if (dictionary != null) {
					cacheResult(dictionary);
				}
				else {
					entityCache.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary fetchByPrimaryKey(long dictionaryId) {
		return fetchByPrimaryKey((Serializable)dictionaryId);
	}

	@Override
	public Map<Serializable, Dictionary> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Dictionary> map = new HashMap<Serializable, Dictionary>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Dictionary dictionary = fetchByPrimaryKey(primaryKey);

			if (dictionary != null) {
				map.put(primaryKey, dictionary);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Dictionary)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DICTIONARY_WHERE_PKS_IN);

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

			for (Dictionary dictionary : (List<Dictionary>)q.list()) {
				map.put(dictionary.getPrimaryKeyObj(), dictionary);

				cacheResult(dictionary);

				uncachedPrimaryKeys.remove(dictionary.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryImpl.class, primaryKey, nullModel);
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
	 * Returns all the dictionaries.
	 *
	 * @return the dictionaries
	 */
	@Override
	public List<Dictionary> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of dictionaries
	 */
	@Override
	public List<Dictionary> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dictionaries
	 */
	@Override
	public List<Dictionary> findAll(int start, int end,
		OrderByComparator<Dictionary> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of dictionaries
	 */
	@Override
	public List<Dictionary> findAll(int start, int end,
		OrderByComparator<Dictionary> orderByComparator,
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

		List<Dictionary> list = null;

		if (retrieveFromCache) {
			list = (List<Dictionary>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DICTIONARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTIONARY;

				if (pagination) {
					sql = sql.concat(DictionaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dictionaries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Dictionary dictionary : findAll()) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries.
	 *
	 * @return the number of dictionaries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DICTIONARY);

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
		return DictionaryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dictionary persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DictionaryImpl.class.getName());
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
	private static final String _SQL_SELECT_DICTIONARY = "SELECT dictionary FROM Dictionary dictionary";
	private static final String _SQL_SELECT_DICTIONARY_WHERE_PKS_IN = "SELECT dictionary FROM Dictionary dictionary WHERE dictionaryId IN (";
	private static final String _SQL_SELECT_DICTIONARY_WHERE = "SELECT dictionary FROM Dictionary dictionary WHERE ";
	private static final String _SQL_COUNT_DICTIONARY = "SELECT COUNT(dictionary) FROM Dictionary dictionary";
	private static final String _SQL_COUNT_DICTIONARY_WHERE = "SELECT COUNT(dictionary) FROM Dictionary dictionary WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "dictionary.dictionaryId";
	private static final String _FILTER_SQL_SELECT_DICTIONARY_WHERE = "SELECT DISTINCT {dictionary.*} FROM SAAT_Dictionary dictionary WHERE ";
	private static final String _FILTER_SQL_SELECT_DICTIONARY_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {SAAT_Dictionary.*} FROM (SELECT DISTINCT dictionary.dictionaryId FROM SAAT_Dictionary dictionary WHERE ";
	private static final String _FILTER_SQL_SELECT_DICTIONARY_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN SAAT_Dictionary ON TEMP_TABLE.dictionaryId = SAAT_Dictionary.dictionaryId";
	private static final String _FILTER_SQL_COUNT_DICTIONARY_WHERE = "SELECT COUNT(DISTINCT dictionary.dictionaryId) AS COUNT_VALUE FROM SAAT_Dictionary dictionary WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "dictionary";
	private static final String _FILTER_ENTITY_TABLE = "SAAT_Dictionary";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictionary.";
	private static final String _ORDER_BY_ENTITY_TABLE = "SAAT_Dictionary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dictionary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Dictionary exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DictionaryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
}