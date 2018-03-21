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

import at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException;
import at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink;
import at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryDictionaryLinkImpl;
import at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryDictionaryLinkModelImpl;
import at.graz.meduni.bibbox.informationprocessing.service.persistence.DictionaryDictionaryLinkPersistence;

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
 * The persistence implementation for the dictionary dictionary link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see DictionaryDictionaryLinkPersistence
 * @see at.graz.meduni.bibbox.informationprocessing.service.persistence.DictionaryDictionaryLinkUtil
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkPersistenceImpl extends BasePersistenceImpl<DictionaryDictionaryLink>
	implements DictionaryDictionaryLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictionaryDictionaryLinkUtil} to access the dictionary dictionary link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictionaryDictionaryLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DictionaryDictionaryLinkModelImpl.UUID_COLUMN_BITMASK |
			DictionaryDictionaryLinkModelImpl.DICTIONARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dictionary dictionary links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionary dictionary links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @return the range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByUuid(String uuid, int start,
		int end, OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByUuid(String uuid, int start,
		int end, OrderByComparator<DictionaryDictionaryLink> orderByComparator,
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

		List<DictionaryDictionaryLink> list = null;

		if (retrieveFromCache) {
			list = (List<DictionaryDictionaryLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DictionaryDictionaryLink dictionaryDictionaryLink : list) {
					if (!Objects.equals(uuid, dictionaryDictionaryLink.getUuid())) {
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

			query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

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
				query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
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
	 * Returns the first dictionary dictionary link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByUuid_First(String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByUuid_First(uuid,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the first dictionary dictionary link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByUuid_First(String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		List<DictionaryDictionaryLink> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByUuid_Last(String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByUuid_Last(uuid,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByUuid_Last(String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DictionaryDictionaryLink> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where uuid = &#63;.
	 *
	 * @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink[] findByUuid_PrevAndNext(
		long dictionarydictionarylinkId, String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = findByPrimaryKey(dictionarydictionarylinkId);

		Session session = null;

		try {
			session = openSession();

			DictionaryDictionaryLink[] array = new DictionaryDictionaryLinkImpl[3];

			array[0] = getByUuid_PrevAndNext(session, dictionaryDictionaryLink,
					uuid, orderByComparator, true);

			array[1] = dictionaryDictionaryLink;

			array[2] = getByUuid_PrevAndNext(session, dictionaryDictionaryLink,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DictionaryDictionaryLink getByUuid_PrevAndNext(Session session,
		DictionaryDictionaryLink dictionaryDictionaryLink, String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
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

		query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

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
			query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(dictionaryDictionaryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictionaryDictionaryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionary dictionary links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionaryDictionaryLink);
		}
	}

	/**
	 * Returns the number of dictionary dictionary links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dictionary dictionary links
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "dictionaryDictionaryLink.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "dictionaryDictionaryLink.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(dictionaryDictionaryLink.uuid IS NULL OR dictionaryDictionaryLink.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			DictionaryDictionaryLinkModelImpl.UUID_COLUMN_BITMASK |
			DictionaryDictionaryLinkModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the dictionary dictionary link where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDictionaryDictionaryLinkException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByUUID_G(String uuid, long groupId)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByUUID_G(uuid,
				groupId);

		if (dictionaryDictionaryLink == null) {
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

			throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
		}

		return dictionaryDictionaryLink;
	}

	/**
	 * Returns the dictionary dictionary link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the dictionary dictionary link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof DictionaryDictionaryLink) {
			DictionaryDictionaryLink dictionaryDictionaryLink = (DictionaryDictionaryLink)result;

			if (!Objects.equals(uuid, dictionaryDictionaryLink.getUuid()) ||
					(groupId != dictionaryDictionaryLink.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

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

				List<DictionaryDictionaryLink> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					DictionaryDictionaryLink dictionaryDictionaryLink = list.get(0);

					result = dictionaryDictionaryLink;

					cacheResult(dictionaryDictionaryLink);

					if ((dictionaryDictionaryLink.getUuid() == null) ||
							!dictionaryDictionaryLink.getUuid().equals(uuid) ||
							(dictionaryDictionaryLink.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, dictionaryDictionaryLink);
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
			return (DictionaryDictionaryLink)result;
		}
	}

	/**
	 * Removes the dictionary dictionary link where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the dictionary dictionary link that was removed
	 */
	@Override
	public DictionaryDictionaryLink removeByUUID_G(String uuid, long groupId)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = findByUUID_G(uuid,
				groupId);

		return remove(dictionaryDictionaryLink);
	}

	/**
	 * Returns the number of dictionary dictionary links where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching dictionary dictionary links
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "dictionaryDictionaryLink.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "dictionaryDictionaryLink.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(dictionaryDictionaryLink.uuid IS NULL OR dictionaryDictionaryLink.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "dictionaryDictionaryLink.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			DictionaryDictionaryLinkModelImpl.UUID_COLUMN_BITMASK |
			DictionaryDictionaryLinkModelImpl.COMPANYID_COLUMN_BITMASK |
			DictionaryDictionaryLinkModelImpl.DICTIONARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByUuid_C(String uuid,
		long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @return the range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
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

		List<DictionaryDictionaryLink> list = null;

		if (retrieveFromCache) {
			list = (List<DictionaryDictionaryLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DictionaryDictionaryLink dictionaryDictionaryLink : list) {
					if (!Objects.equals(uuid, dictionaryDictionaryLink.getUuid()) ||
							(companyId != dictionaryDictionaryLink.getCompanyId())) {
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

			query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

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
				query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
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
	 * Returns the first dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the first dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		List<DictionaryDictionaryLink> list = findByUuid_C(uuid, companyId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<DictionaryDictionaryLink> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink[] findByUuid_C_PrevAndNext(
		long dictionarydictionarylinkId, String uuid, long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = findByPrimaryKey(dictionarydictionarylinkId);

		Session session = null;

		try {
			session = openSession();

			DictionaryDictionaryLink[] array = new DictionaryDictionaryLinkImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session,
					dictionaryDictionaryLink, uuid, companyId,
					orderByComparator, true);

			array[1] = dictionaryDictionaryLink;

			array[2] = getByUuid_C_PrevAndNext(session,
					dictionaryDictionaryLink, uuid, companyId,
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

	protected DictionaryDictionaryLink getByUuid_C_PrevAndNext(
		Session session, DictionaryDictionaryLink dictionaryDictionaryLink,
		String uuid, long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
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

		query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

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
			query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(dictionaryDictionaryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictionaryDictionaryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionary dictionary links where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionaryDictionaryLink);
		}
	}

	/**
	 * Returns the number of dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching dictionary dictionary links
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "dictionaryDictionaryLink.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "dictionaryDictionaryLink.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(dictionaryDictionaryLink.uuid IS NULL OR dictionaryDictionaryLink.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "dictionaryDictionaryLink.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTIONARY =
		new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDictionary",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARY =
		new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDictionary",
			new String[] { Long.class.getName() },
			DictionaryDictionaryLinkModelImpl.DICTIONARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DICTIONARY = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDictionary",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dictionary dictionary links where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @return the matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByDictionary(long dictionaryId) {
		return findByDictionary(dictionaryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionary dictionary links where dictionaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionaryId the dictionary ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @return the range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByDictionary(long dictionaryId,
		int start, int end) {
		return findByDictionary(dictionaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where dictionaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionaryId the dictionary ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByDictionary(long dictionaryId,
		int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return findByDictionary(dictionaryId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where dictionaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionaryId the dictionary ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByDictionary(long dictionaryId,
		int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARY;
			finderArgs = new Object[] { dictionaryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DICTIONARY;
			finderArgs = new Object[] {
					dictionaryId,
					
					start, end, orderByComparator
				};
		}

		List<DictionaryDictionaryLink> list = null;

		if (retrieveFromCache) {
			list = (List<DictionaryDictionaryLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DictionaryDictionaryLink dictionaryDictionaryLink : list) {
					if ((dictionaryId != dictionaryDictionaryLink.getDictionaryId())) {
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

			query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

			query.append(_FINDER_COLUMN_DICTIONARY_DICTIONARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictionaryId);

				if (!pagination) {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
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
	 * Returns the first dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByDictionary_First(long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByDictionary_First(dictionaryId,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictionaryId=");
		msg.append(dictionaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the first dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByDictionary_First(long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		List<DictionaryDictionaryLink> list = findByDictionary(dictionaryId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByDictionary_Last(long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByDictionary_Last(dictionaryId,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictionaryId=");
		msg.append(dictionaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByDictionary_Last(long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		int count = countByDictionary(dictionaryId);

		if (count == 0) {
			return null;
		}

		List<DictionaryDictionaryLink> list = findByDictionary(dictionaryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	 *
	 * @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	 * @param dictionaryId the dictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink[] findByDictionary_PrevAndNext(
		long dictionarydictionarylinkId, long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = findByPrimaryKey(dictionarydictionarylinkId);

		Session session = null;

		try {
			session = openSession();

			DictionaryDictionaryLink[] array = new DictionaryDictionaryLinkImpl[3];

			array[0] = getByDictionary_PrevAndNext(session,
					dictionaryDictionaryLink, dictionaryId, orderByComparator,
					true);

			array[1] = dictionaryDictionaryLink;

			array[2] = getByDictionary_PrevAndNext(session,
					dictionaryDictionaryLink, dictionaryId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DictionaryDictionaryLink getByDictionary_PrevAndNext(
		Session session, DictionaryDictionaryLink dictionaryDictionaryLink,
		long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
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

		query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

		query.append(_FINDER_COLUMN_DICTIONARY_DICTIONARYID_2);

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
			query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictionaryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionaryDictionaryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictionaryDictionaryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionary dictionary links where dictionaryId = &#63; from the database.
	 *
	 * @param dictionaryId the dictionary ID
	 */
	@Override
	public void removeByDictionary(long dictionaryId) {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : findByDictionary(
				dictionaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionaryDictionaryLink);
		}
	}

	/**
	 * Returns the number of dictionary dictionary links where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @return the number of matching dictionary dictionary links
	 */
	@Override
	public int countByDictionary(long dictionaryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DICTIONARY;

		Object[] finderArgs = new Object[] { dictionaryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE);

			query.append(_FINDER_COLUMN_DICTIONARY_DICTIONARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictionaryId);

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

	private static final String _FINDER_COLUMN_DICTIONARY_DICTIONARYID_2 = "dictionaryDictionaryLink.dictionaryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LINK = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLink",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINK = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLink",
			new String[] { Long.class.getName() },
			DictionaryDictionaryLinkModelImpl.LINKDICTIONARYID_COLUMN_BITMASK |
			DictionaryDictionaryLinkModelImpl.DICTIONARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LINK = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLink",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dictionary dictionary links where linkdictionaryId = &#63;.
	 *
	 * @param linkdictionaryId the linkdictionary ID
	 * @return the matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByLink(long linkdictionaryId) {
		return findByLink(linkdictionaryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionary dictionary links where linkdictionaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param linkdictionaryId the linkdictionary ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @return the range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByLink(long linkdictionaryId,
		int start, int end) {
		return findByLink(linkdictionaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where linkdictionaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param linkdictionaryId the linkdictionary ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByLink(long linkdictionaryId,
		int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return findByLink(linkdictionaryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where linkdictionaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param linkdictionaryId the linkdictionary ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByLink(long linkdictionaryId,
		int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINK;
			finderArgs = new Object[] { linkdictionaryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LINK;
			finderArgs = new Object[] {
					linkdictionaryId,
					
					start, end, orderByComparator
				};
		}

		List<DictionaryDictionaryLink> list = null;

		if (retrieveFromCache) {
			list = (List<DictionaryDictionaryLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DictionaryDictionaryLink dictionaryDictionaryLink : list) {
					if ((linkdictionaryId != dictionaryDictionaryLink.getLinkdictionaryId())) {
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

			query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

			query.append(_FINDER_COLUMN_LINK_LINKDICTIONARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(linkdictionaryId);

				if (!pagination) {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
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
	 * Returns the first dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	 *
	 * @param linkdictionaryId the linkdictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByLink_First(long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByLink_First(linkdictionaryId,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("linkdictionaryId=");
		msg.append(linkdictionaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the first dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	 *
	 * @param linkdictionaryId the linkdictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByLink_First(long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		List<DictionaryDictionaryLink> list = findByLink(linkdictionaryId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	 *
	 * @param linkdictionaryId the linkdictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByLink_Last(long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByLink_Last(linkdictionaryId,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("linkdictionaryId=");
		msg.append(linkdictionaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	 *
	 * @param linkdictionaryId the linkdictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByLink_Last(long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		int count = countByLink(linkdictionaryId);

		if (count == 0) {
			return null;
		}

		List<DictionaryDictionaryLink> list = findByLink(linkdictionaryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	 *
	 * @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	 * @param linkdictionaryId the linkdictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink[] findByLink_PrevAndNext(
		long dictionarydictionarylinkId, long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = findByPrimaryKey(dictionarydictionarylinkId);

		Session session = null;

		try {
			session = openSession();

			DictionaryDictionaryLink[] array = new DictionaryDictionaryLinkImpl[3];

			array[0] = getByLink_PrevAndNext(session, dictionaryDictionaryLink,
					linkdictionaryId, orderByComparator, true);

			array[1] = dictionaryDictionaryLink;

			array[2] = getByLink_PrevAndNext(session, dictionaryDictionaryLink,
					linkdictionaryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DictionaryDictionaryLink getByLink_PrevAndNext(Session session,
		DictionaryDictionaryLink dictionaryDictionaryLink,
		long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
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

		query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

		query.append(_FINDER_COLUMN_LINK_LINKDICTIONARYID_2);

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
			query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(linkdictionaryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionaryDictionaryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictionaryDictionaryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionary dictionary links where linkdictionaryId = &#63; from the database.
	 *
	 * @param linkdictionaryId the linkdictionary ID
	 */
	@Override
	public void removeByLink(long linkdictionaryId) {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : findByLink(
				linkdictionaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionaryDictionaryLink);
		}
	}

	/**
	 * Returns the number of dictionary dictionary links where linkdictionaryId = &#63;.
	 *
	 * @param linkdictionaryId the linkdictionary ID
	 * @return the number of matching dictionary dictionary links
	 */
	@Override
	public int countByLink(long linkdictionaryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LINK;

		Object[] finderArgs = new Object[] { linkdictionaryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE);

			query.append(_FINDER_COLUMN_LINK_LINKDICTIONARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(linkdictionaryId);

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

	private static final String _FINDER_COLUMN_LINK_LINKDICTIONARYID_2 = "dictionaryDictionaryLink.linkdictionaryId = ?";

	public DictionaryDictionaryLinkPersistenceImpl() {
		setModelClass(DictionaryDictionaryLink.class);

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
	 * Caches the dictionary dictionary link in the entity cache if it is enabled.
	 *
	 * @param dictionaryDictionaryLink the dictionary dictionary link
	 */
	@Override
	public void cacheResult(DictionaryDictionaryLink dictionaryDictionaryLink) {
		entityCache.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			dictionaryDictionaryLink.getPrimaryKey(), dictionaryDictionaryLink);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				dictionaryDictionaryLink.getUuid(),
				dictionaryDictionaryLink.getGroupId()
			}, dictionaryDictionaryLink);

		dictionaryDictionaryLink.resetOriginalValues();
	}

	/**
	 * Caches the dictionary dictionary links in the entity cache if it is enabled.
	 *
	 * @param dictionaryDictionaryLinks the dictionary dictionary links
	 */
	@Override
	public void cacheResult(
		List<DictionaryDictionaryLink> dictionaryDictionaryLinks) {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : dictionaryDictionaryLinks) {
			if (entityCache.getResult(
						DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryDictionaryLinkImpl.class,
						dictionaryDictionaryLink.getPrimaryKey()) == null) {
				cacheResult(dictionaryDictionaryLink);
			}
			else {
				dictionaryDictionaryLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dictionary dictionary links.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DictionaryDictionaryLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dictionary dictionary link.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DictionaryDictionaryLink dictionaryDictionaryLink) {
		entityCache.removeResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			dictionaryDictionaryLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DictionaryDictionaryLinkModelImpl)dictionaryDictionaryLink,
			true);
	}

	@Override
	public void clearCache(
		List<DictionaryDictionaryLink> dictionaryDictionaryLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DictionaryDictionaryLink dictionaryDictionaryLink : dictionaryDictionaryLinks) {
			entityCache.removeResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryDictionaryLinkImpl.class,
				dictionaryDictionaryLink.getPrimaryKey());

			clearUniqueFindersCache((DictionaryDictionaryLinkModelImpl)dictionaryDictionaryLink,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		DictionaryDictionaryLinkModelImpl dictionaryDictionaryLinkModelImpl) {
		Object[] args = new Object[] {
				dictionaryDictionaryLinkModelImpl.getUuid(),
				dictionaryDictionaryLinkModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			dictionaryDictionaryLinkModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DictionaryDictionaryLinkModelImpl dictionaryDictionaryLinkModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					dictionaryDictionaryLinkModelImpl.getUuid(),
					dictionaryDictionaryLinkModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((dictionaryDictionaryLinkModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					dictionaryDictionaryLinkModelImpl.getOriginalUuid(),
					dictionaryDictionaryLinkModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	 *
	 * @param dictionarydictionarylinkId the primary key for the new dictionary dictionary link
	 * @return the new dictionary dictionary link
	 */
	@Override
	public DictionaryDictionaryLink create(long dictionarydictionarylinkId) {
		DictionaryDictionaryLink dictionaryDictionaryLink = new DictionaryDictionaryLinkImpl();

		dictionaryDictionaryLink.setNew(true);
		dictionaryDictionaryLink.setPrimaryKey(dictionarydictionarylinkId);

		String uuid = PortalUUIDUtil.generate();

		dictionaryDictionaryLink.setUuid(uuid);

		dictionaryDictionaryLink.setCompanyId(companyProvider.getCompanyId());

		return dictionaryDictionaryLink;
	}

	/**
	 * Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link that was removed
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink remove(long dictionarydictionarylinkId)
		throws NoSuchDictionaryDictionaryLinkException {
		return remove((Serializable)dictionarydictionarylinkId);
	}

	/**
	 * Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link that was removed
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink remove(Serializable primaryKey)
		throws NoSuchDictionaryDictionaryLinkException {
		Session session = null;

		try {
			session = openSession();

			DictionaryDictionaryLink dictionaryDictionaryLink = (DictionaryDictionaryLink)session.get(DictionaryDictionaryLinkImpl.class,
					primaryKey);

			if (dictionaryDictionaryLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictionaryDictionaryLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictionaryDictionaryLink);
		}
		catch (NoSuchDictionaryDictionaryLinkException nsee) {
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
	protected DictionaryDictionaryLink removeImpl(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		dictionaryDictionaryLink = toUnwrappedModel(dictionaryDictionaryLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictionaryDictionaryLink)) {
				dictionaryDictionaryLink = (DictionaryDictionaryLink)session.get(DictionaryDictionaryLinkImpl.class,
						dictionaryDictionaryLink.getPrimaryKeyObj());
			}

			if (dictionaryDictionaryLink != null) {
				session.delete(dictionaryDictionaryLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictionaryDictionaryLink != null) {
			clearCache(dictionaryDictionaryLink);
		}

		return dictionaryDictionaryLink;
	}

	@Override
	public DictionaryDictionaryLink updateImpl(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		dictionaryDictionaryLink = toUnwrappedModel(dictionaryDictionaryLink);

		boolean isNew = dictionaryDictionaryLink.isNew();

		DictionaryDictionaryLinkModelImpl dictionaryDictionaryLinkModelImpl = (DictionaryDictionaryLinkModelImpl)dictionaryDictionaryLink;

		if (Validator.isNull(dictionaryDictionaryLink.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dictionaryDictionaryLink.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (dictionaryDictionaryLink.getCreateDate() == null)) {
			if (serviceContext == null) {
				dictionaryDictionaryLink.setCreateDate(now);
			}
			else {
				dictionaryDictionaryLink.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!dictionaryDictionaryLinkModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dictionaryDictionaryLink.setModifiedDate(now);
			}
			else {
				dictionaryDictionaryLink.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (dictionaryDictionaryLink.isNew()) {
				session.save(dictionaryDictionaryLink);

				dictionaryDictionaryLink.setNew(false);
			}
			else {
				dictionaryDictionaryLink = (DictionaryDictionaryLink)session.merge(dictionaryDictionaryLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DictionaryDictionaryLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					dictionaryDictionaryLinkModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					dictionaryDictionaryLinkModelImpl.getUuid(),
					dictionaryDictionaryLinkModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] {
					dictionaryDictionaryLinkModelImpl.getDictionaryId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DICTIONARY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARY,
				args);

			args = new Object[] {
					dictionaryDictionaryLinkModelImpl.getLinkdictionaryId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LINK, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINK,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((dictionaryDictionaryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { dictionaryDictionaryLinkModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((dictionaryDictionaryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getOriginalUuid(),
						dictionaryDictionaryLinkModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getUuid(),
						dictionaryDictionaryLinkModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((dictionaryDictionaryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getOriginalDictionaryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DICTIONARY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARY,
					args);

				args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getDictionaryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DICTIONARY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DICTIONARY,
					args);
			}

			if ((dictionaryDictionaryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getOriginalLinkdictionaryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LINK, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINK,
					args);

				args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getLinkdictionaryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LINK, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINK,
					args);
			}
		}

		entityCache.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			dictionaryDictionaryLink.getPrimaryKey(), dictionaryDictionaryLink,
			false);

		clearUniqueFindersCache(dictionaryDictionaryLinkModelImpl, false);
		cacheUniqueFindersCache(dictionaryDictionaryLinkModelImpl);

		dictionaryDictionaryLink.resetOriginalValues();

		return dictionaryDictionaryLink;
	}

	protected DictionaryDictionaryLink toUnwrappedModel(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		if (dictionaryDictionaryLink instanceof DictionaryDictionaryLinkImpl) {
			return dictionaryDictionaryLink;
		}

		DictionaryDictionaryLinkImpl dictionaryDictionaryLinkImpl = new DictionaryDictionaryLinkImpl();

		dictionaryDictionaryLinkImpl.setNew(dictionaryDictionaryLink.isNew());
		dictionaryDictionaryLinkImpl.setPrimaryKey(dictionaryDictionaryLink.getPrimaryKey());

		dictionaryDictionaryLinkImpl.setUuid(dictionaryDictionaryLink.getUuid());
		dictionaryDictionaryLinkImpl.setDictionarydictionarylinkId(dictionaryDictionaryLink.getDictionarydictionarylinkId());
		dictionaryDictionaryLinkImpl.setGroupId(dictionaryDictionaryLink.getGroupId());
		dictionaryDictionaryLinkImpl.setCompanyId(dictionaryDictionaryLink.getCompanyId());
		dictionaryDictionaryLinkImpl.setUserId(dictionaryDictionaryLink.getUserId());
		dictionaryDictionaryLinkImpl.setUserName(dictionaryDictionaryLink.getUserName());
		dictionaryDictionaryLinkImpl.setCreateDate(dictionaryDictionaryLink.getCreateDate());
		dictionaryDictionaryLinkImpl.setModifiedDate(dictionaryDictionaryLink.getModifiedDate());
		dictionaryDictionaryLinkImpl.setStatus(dictionaryDictionaryLink.getStatus());
		dictionaryDictionaryLinkImpl.setStatusByUserId(dictionaryDictionaryLink.getStatusByUserId());
		dictionaryDictionaryLinkImpl.setStatusByUserName(dictionaryDictionaryLink.getStatusByUserName());
		dictionaryDictionaryLinkImpl.setStatusDate(dictionaryDictionaryLink.getStatusDate());
		dictionaryDictionaryLinkImpl.setDictionaryId(dictionaryDictionaryLink.getDictionaryId());
		dictionaryDictionaryLinkImpl.setLinkdictionaryId(dictionaryDictionaryLink.getLinkdictionaryId());

		return dictionaryDictionaryLinkImpl;
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByPrimaryKey(primaryKey);

		if (dictionaryDictionaryLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictionaryDictionaryLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictionaryDictionaryLink;
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or throws a {@link NoSuchDictionaryDictionaryLinkException} if it could not be found.
	 *
	 * @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByPrimaryKey(
		long dictionarydictionarylinkId)
		throws NoSuchDictionaryDictionaryLinkException {
		return findByPrimaryKey((Serializable)dictionarydictionarylinkId);
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryDictionaryLinkImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DictionaryDictionaryLink dictionaryDictionaryLink = (DictionaryDictionaryLink)serializable;

		if (dictionaryDictionaryLink == null) {
			Session session = null;

			try {
				session = openSession();

				dictionaryDictionaryLink = (DictionaryDictionaryLink)session.get(DictionaryDictionaryLinkImpl.class,
						primaryKey);

				if (dictionaryDictionaryLink != null) {
					cacheResult(dictionaryDictionaryLink);
				}
				else {
					entityCache.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryDictionaryLinkImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryDictionaryLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictionaryDictionaryLink;
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByPrimaryKey(
		long dictionarydictionarylinkId) {
		return fetchByPrimaryKey((Serializable)dictionarydictionarylinkId);
	}

	@Override
	public Map<Serializable, DictionaryDictionaryLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DictionaryDictionaryLink> map = new HashMap<Serializable, DictionaryDictionaryLink>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DictionaryDictionaryLink dictionaryDictionaryLink = fetchByPrimaryKey(primaryKey);

			if (dictionaryDictionaryLink != null) {
				map.put(primaryKey, dictionaryDictionaryLink);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryDictionaryLinkImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DictionaryDictionaryLink)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE_PKS_IN);

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

			for (DictionaryDictionaryLink dictionaryDictionaryLink : (List<DictionaryDictionaryLink>)q.list()) {
				map.put(dictionaryDictionaryLink.getPrimaryKeyObj(),
					dictionaryDictionaryLink);

				cacheResult(dictionaryDictionaryLink);

				uncachedPrimaryKeys.remove(dictionaryDictionaryLink.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryDictionaryLinkImpl.class, primaryKey, nullModel);
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
	 * Returns all the dictionary dictionary links.
	 *
	 * @return the dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionary dictionary links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @return the range of dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll(int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll(int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
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

		List<DictionaryDictionaryLink> list = null;

		if (retrieveFromCache) {
			list = (List<DictionaryDictionaryLink>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTIONARYDICTIONARYLINK;

				if (pagination) {
					sql = sql.concat(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
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
	 * Removes all the dictionary dictionary links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : findAll()) {
			remove(dictionaryDictionaryLink);
		}
	}

	/**
	 * Returns the number of dictionary dictionary links.
	 *
	 * @return the number of dictionary dictionary links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DICTIONARYDICTIONARYLINK);

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
		return DictionaryDictionaryLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dictionary dictionary link persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DictionaryDictionaryLinkImpl.class.getName());
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
	private static final String _SQL_SELECT_DICTIONARYDICTIONARYLINK = "SELECT dictionaryDictionaryLink FROM DictionaryDictionaryLink dictionaryDictionaryLink";
	private static final String _SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE_PKS_IN =
		"SELECT dictionaryDictionaryLink FROM DictionaryDictionaryLink dictionaryDictionaryLink WHERE dictionarydictionarylinkId IN (";
	private static final String _SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE = "SELECT dictionaryDictionaryLink FROM DictionaryDictionaryLink dictionaryDictionaryLink WHERE ";
	private static final String _SQL_COUNT_DICTIONARYDICTIONARYLINK = "SELECT COUNT(dictionaryDictionaryLink) FROM DictionaryDictionaryLink dictionaryDictionaryLink";
	private static final String _SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE = "SELECT COUNT(dictionaryDictionaryLink) FROM DictionaryDictionaryLink dictionaryDictionaryLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictionaryDictionaryLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DictionaryDictionaryLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DictionaryDictionaryLink exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DictionaryDictionaryLinkPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}