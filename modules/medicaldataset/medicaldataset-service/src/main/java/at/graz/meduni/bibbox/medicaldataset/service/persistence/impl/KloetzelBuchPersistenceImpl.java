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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException;
import at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch;
import at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchImpl;
import at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchModelImpl;
import at.graz.meduni.bibbox.medicaldataset.service.persistence.KloetzelBuchPersistence;

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
 * The persistence implementation for the kloetzel buch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KloetzelBuchPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.KloetzelBuchUtil
 * @generated
 */
@ProviderType
public class KloetzelBuchPersistenceImpl extends BasePersistenceImpl<KloetzelBuch>
	implements KloetzelBuchPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KloetzelBuchUtil} to access the kloetzel buch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KloetzelBuchImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, KloetzelBuchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, KloetzelBuchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, KloetzelBuchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, KloetzelBuchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			KloetzelBuchModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the kloetzel buchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kloetzel buchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @return the range of matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kloetzel buchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByUuid(String uuid, int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the kloetzel buchs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByUuid(String uuid, int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator,
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

		List<KloetzelBuch> list = null;

		if (retrieveFromCache) {
			list = (List<KloetzelBuch>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KloetzelBuch kloetzelBuch : list) {
					if (!Objects.equals(uuid, kloetzelBuch.getUuid())) {
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

			query.append(_SQL_SELECT_KLOETZELBUCH_WHERE);

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
				query.append(KloetzelBuchModelImpl.ORDER_BY_JPQL);
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
					list = (List<KloetzelBuch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KloetzelBuch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first kloetzel buch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch findByUuid_First(String uuid,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = fetchByUuid_First(uuid, orderByComparator);

		if (kloetzelBuch != null) {
			return kloetzelBuch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKloetzelBuchException(msg.toString());
	}

	/**
	 * Returns the first kloetzel buch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch fetchByUuid_First(String uuid,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		List<KloetzelBuch> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kloetzel buch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch findByUuid_Last(String uuid,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = fetchByUuid_Last(uuid, orderByComparator);

		if (kloetzelBuch != null) {
			return kloetzelBuch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKloetzelBuchException(msg.toString());
	}

	/**
	 * Returns the last kloetzel buch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch fetchByUuid_Last(String uuid,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<KloetzelBuch> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kloetzel buchs before and after the current kloetzel buch in the ordered set where uuid = &#63;.
	 *
	 * @param kloetzelBuchId the primary key of the current kloetzel buch
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	 */
	@Override
	public KloetzelBuch[] findByUuid_PrevAndNext(long kloetzelBuchId,
		String uuid, OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = findByPrimaryKey(kloetzelBuchId);

		Session session = null;

		try {
			session = openSession();

			KloetzelBuch[] array = new KloetzelBuchImpl[3];

			array[0] = getByUuid_PrevAndNext(session, kloetzelBuch, uuid,
					orderByComparator, true);

			array[1] = kloetzelBuch;

			array[2] = getByUuid_PrevAndNext(session, kloetzelBuch, uuid,
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

	protected KloetzelBuch getByUuid_PrevAndNext(Session session,
		KloetzelBuch kloetzelBuch, String uuid,
		OrderByComparator<KloetzelBuch> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KLOETZELBUCH_WHERE);

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
			query.append(KloetzelBuchModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(kloetzelBuch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KloetzelBuch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kloetzel buchs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (KloetzelBuch kloetzelBuch : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(kloetzelBuch);
		}
	}

	/**
	 * Returns the number of kloetzel buchs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching kloetzel buchs
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KLOETZELBUCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "kloetzelBuch.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "kloetzelBuch.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(kloetzelBuch.uuid IS NULL OR kloetzelBuch.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, KloetzelBuchImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			KloetzelBuchModelImpl.UUID_COLUMN_BITMASK |
			KloetzelBuchModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the kloetzel buch where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchKloetzelBuchException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch findByUUID_G(String uuid, long groupId)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = fetchByUUID_G(uuid, groupId);

		if (kloetzelBuch == null) {
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

			throw new NoSuchKloetzelBuchException(msg.toString());
		}

		return kloetzelBuch;
	}

	/**
	 * Returns the kloetzel buch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the kloetzel buch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof KloetzelBuch) {
			KloetzelBuch kloetzelBuch = (KloetzelBuch)result;

			if (!Objects.equals(uuid, kloetzelBuch.getUuid()) ||
					(groupId != kloetzelBuch.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_KLOETZELBUCH_WHERE);

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

				List<KloetzelBuch> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					KloetzelBuch kloetzelBuch = list.get(0);

					result = kloetzelBuch;

					cacheResult(kloetzelBuch);

					if ((kloetzelBuch.getUuid() == null) ||
							!kloetzelBuch.getUuid().equals(uuid) ||
							(kloetzelBuch.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, kloetzelBuch);
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
			return (KloetzelBuch)result;
		}
	}

	/**
	 * Removes the kloetzel buch where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the kloetzel buch that was removed
	 */
	@Override
	public KloetzelBuch removeByUUID_G(String uuid, long groupId)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = findByUUID_G(uuid, groupId);

		return remove(kloetzelBuch);
	}

	/**
	 * Returns the number of kloetzel buchs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching kloetzel buchs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KLOETZELBUCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "kloetzelBuch.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "kloetzelBuch.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(kloetzelBuch.uuid IS NULL OR kloetzelBuch.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "kloetzelBuch.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, KloetzelBuchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, KloetzelBuchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			KloetzelBuchModelImpl.UUID_COLUMN_BITMASK |
			KloetzelBuchModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the kloetzel buchs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kloetzel buchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @return the range of matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kloetzel buchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<KloetzelBuch> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the kloetzel buchs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<KloetzelBuch> orderByComparator,
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

		List<KloetzelBuch> list = null;

		if (retrieveFromCache) {
			list = (List<KloetzelBuch>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KloetzelBuch kloetzelBuch : list) {
					if (!Objects.equals(uuid, kloetzelBuch.getUuid()) ||
							(companyId != kloetzelBuch.getCompanyId())) {
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

			query.append(_SQL_SELECT_KLOETZELBUCH_WHERE);

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
				query.append(KloetzelBuchModelImpl.ORDER_BY_JPQL);
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
					list = (List<KloetzelBuch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KloetzelBuch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (kloetzelBuch != null) {
			return kloetzelBuch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKloetzelBuchException(msg.toString());
	}

	/**
	 * Returns the first kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		List<KloetzelBuch> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (kloetzelBuch != null) {
			return kloetzelBuch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKloetzelBuchException(msg.toString());
	}

	/**
	 * Returns the last kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<KloetzelBuch> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kloetzel buchs before and after the current kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param kloetzelBuchId the primary key of the current kloetzel buch
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	 */
	@Override
	public KloetzelBuch[] findByUuid_C_PrevAndNext(long kloetzelBuchId,
		String uuid, long companyId,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = findByPrimaryKey(kloetzelBuchId);

		Session session = null;

		try {
			session = openSession();

			KloetzelBuch[] array = new KloetzelBuchImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, kloetzelBuch, uuid,
					companyId, orderByComparator, true);

			array[1] = kloetzelBuch;

			array[2] = getByUuid_C_PrevAndNext(session, kloetzelBuch, uuid,
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

	protected KloetzelBuch getByUuid_C_PrevAndNext(Session session,
		KloetzelBuch kloetzelBuch, String uuid, long companyId,
		OrderByComparator<KloetzelBuch> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_KLOETZELBUCH_WHERE);

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
			query.append(KloetzelBuchModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(kloetzelBuch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KloetzelBuch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kloetzel buchs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (KloetzelBuch kloetzelBuch : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(kloetzelBuch);
		}
	}

	/**
	 * Returns the number of kloetzel buchs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching kloetzel buchs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KLOETZELBUCH_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "kloetzelBuch.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "kloetzelBuch.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(kloetzelBuch.uuid IS NULL OR kloetzelBuch.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "kloetzelBuch.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, KloetzelBuchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, KloetzelBuchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			KloetzelBuchModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the kloetzel buchs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kloetzel buchs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @return the range of matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kloetzel buchs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByGroupId(long groupId, int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the kloetzel buchs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findByGroupId(long groupId, int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator,
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

		List<KloetzelBuch> list = null;

		if (retrieveFromCache) {
			list = (List<KloetzelBuch>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KloetzelBuch kloetzelBuch : list) {
					if ((groupId != kloetzelBuch.getGroupId())) {
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

			query.append(_SQL_SELECT_KLOETZELBUCH_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(KloetzelBuchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<KloetzelBuch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KloetzelBuch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first kloetzel buch in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch findByGroupId_First(long groupId,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = fetchByGroupId_First(groupId,
				orderByComparator);

		if (kloetzelBuch != null) {
			return kloetzelBuch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKloetzelBuchException(msg.toString());
	}

	/**
	 * Returns the first kloetzel buch in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch fetchByGroupId_First(long groupId,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		List<KloetzelBuch> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kloetzel buch in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch findByGroupId_Last(long groupId,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (kloetzelBuch != null) {
			return kloetzelBuch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKloetzelBuchException(msg.toString());
	}

	/**
	 * Returns the last kloetzel buch in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch fetchByGroupId_Last(long groupId,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<KloetzelBuch> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kloetzel buchs before and after the current kloetzel buch in the ordered set where groupId = &#63;.
	 *
	 * @param kloetzelBuchId the primary key of the current kloetzel buch
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	 */
	@Override
	public KloetzelBuch[] findByGroupId_PrevAndNext(long kloetzelBuchId,
		long groupId, OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = findByPrimaryKey(kloetzelBuchId);

		Session session = null;

		try {
			session = openSession();

			KloetzelBuch[] array = new KloetzelBuchImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, kloetzelBuch, groupId,
					orderByComparator, true);

			array[1] = kloetzelBuch;

			array[2] = getByGroupId_PrevAndNext(session, kloetzelBuch, groupId,
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

	protected KloetzelBuch getByGroupId_PrevAndNext(Session session,
		KloetzelBuch kloetzelBuch, long groupId,
		OrderByComparator<KloetzelBuch> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KLOETZELBUCH_WHERE);

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
			query.append(KloetzelBuchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(kloetzelBuch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KloetzelBuch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kloetzel buchs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (KloetzelBuch kloetzelBuch : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(kloetzelBuch);
		}
	}

	/**
	 * Returns the number of kloetzel buchs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching kloetzel buchs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KLOETZELBUCH_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "kloetzelBuch.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_MEDICALRECORD = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, KloetzelBuchImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMedicalRecord",
			new String[] { Long.class.getName() },
			KloetzelBuchModelImpl.MEDICALRECORDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MEDICALRECORD = new FinderPath(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMedicalRecord",
			new String[] { Long.class.getName() });

	/**
	 * Returns the kloetzel buch where medicalRecordId = &#63; or throws a {@link NoSuchKloetzelBuchException} if it could not be found.
	 *
	 * @param medicalRecordId the medical record ID
	 * @return the matching kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch findByMedicalRecord(long medicalRecordId)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = fetchByMedicalRecord(medicalRecordId);

		if (kloetzelBuch == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("medicalRecordId=");
			msg.append(medicalRecordId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchKloetzelBuchException(msg.toString());
		}

		return kloetzelBuch;
	}

	/**
	 * Returns the kloetzel buch where medicalRecordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param medicalRecordId the medical record ID
	 * @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch fetchByMedicalRecord(long medicalRecordId) {
		return fetchByMedicalRecord(medicalRecordId, true);
	}

	/**
	 * Returns the kloetzel buch where medicalRecordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param medicalRecordId the medical record ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	 */
	@Override
	public KloetzelBuch fetchByMedicalRecord(long medicalRecordId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { medicalRecordId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_MEDICALRECORD,
					finderArgs, this);
		}

		if (result instanceof KloetzelBuch) {
			KloetzelBuch kloetzelBuch = (KloetzelBuch)result;

			if ((medicalRecordId != kloetzelBuch.getMedicalRecordId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_KLOETZELBUCH_WHERE);

			query.append(_FINDER_COLUMN_MEDICALRECORD_MEDICALRECORDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(medicalRecordId);

				List<KloetzelBuch> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_MEDICALRECORD,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"KloetzelBuchPersistenceImpl.fetchByMedicalRecord(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					KloetzelBuch kloetzelBuch = list.get(0);

					result = kloetzelBuch;

					cacheResult(kloetzelBuch);

					if ((kloetzelBuch.getMedicalRecordId() != medicalRecordId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_MEDICALRECORD,
							finderArgs, kloetzelBuch);
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
			return (KloetzelBuch)result;
		}
	}

	/**
	 * Removes the kloetzel buch where medicalRecordId = &#63; from the database.
	 *
	 * @param medicalRecordId the medical record ID
	 * @return the kloetzel buch that was removed
	 */
	@Override
	public KloetzelBuch removeByMedicalRecord(long medicalRecordId)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = findByMedicalRecord(medicalRecordId);

		return remove(kloetzelBuch);
	}

	/**
	 * Returns the number of kloetzel buchs where medicalRecordId = &#63;.
	 *
	 * @param medicalRecordId the medical record ID
	 * @return the number of matching kloetzel buchs
	 */
	@Override
	public int countByMedicalRecord(long medicalRecordId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MEDICALRECORD;

		Object[] finderArgs = new Object[] { medicalRecordId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KLOETZELBUCH_WHERE);

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

	private static final String _FINDER_COLUMN_MEDICALRECORD_MEDICALRECORDID_2 = "kloetzelBuch.medicalRecordId = ?";

	public KloetzelBuchPersistenceImpl() {
		setModelClass(KloetzelBuch.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
			dbColumnNames.put("type", "type_");
			dbColumnNames.put("text", "text_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the kloetzel buch in the entity cache if it is enabled.
	 *
	 * @param kloetzelBuch the kloetzel buch
	 */
	@Override
	public void cacheResult(KloetzelBuch kloetzelBuch) {
		entityCache.putResult(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchImpl.class, kloetzelBuch.getPrimaryKey(), kloetzelBuch);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { kloetzelBuch.getUuid(), kloetzelBuch.getGroupId() },
			kloetzelBuch);

		finderCache.putResult(FINDER_PATH_FETCH_BY_MEDICALRECORD,
			new Object[] { kloetzelBuch.getMedicalRecordId() }, kloetzelBuch);

		kloetzelBuch.resetOriginalValues();
	}

	/**
	 * Caches the kloetzel buchs in the entity cache if it is enabled.
	 *
	 * @param kloetzelBuchs the kloetzel buchs
	 */
	@Override
	public void cacheResult(List<KloetzelBuch> kloetzelBuchs) {
		for (KloetzelBuch kloetzelBuch : kloetzelBuchs) {
			if (entityCache.getResult(
						KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
						KloetzelBuchImpl.class, kloetzelBuch.getPrimaryKey()) == null) {
				cacheResult(kloetzelBuch);
			}
			else {
				kloetzelBuch.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kloetzel buchs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(KloetzelBuchImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kloetzel buch.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KloetzelBuch kloetzelBuch) {
		entityCache.removeResult(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchImpl.class, kloetzelBuch.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((KloetzelBuchModelImpl)kloetzelBuch, true);
	}

	@Override
	public void clearCache(List<KloetzelBuch> kloetzelBuchs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KloetzelBuch kloetzelBuch : kloetzelBuchs) {
			entityCache.removeResult(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
				KloetzelBuchImpl.class, kloetzelBuch.getPrimaryKey());

			clearUniqueFindersCache((KloetzelBuchModelImpl)kloetzelBuch, true);
		}
	}

	protected void cacheUniqueFindersCache(
		KloetzelBuchModelImpl kloetzelBuchModelImpl) {
		Object[] args = new Object[] {
				kloetzelBuchModelImpl.getUuid(),
				kloetzelBuchModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			kloetzelBuchModelImpl, false);

		args = new Object[] { kloetzelBuchModelImpl.getMedicalRecordId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_MEDICALRECORD, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_MEDICALRECORD, args,
			kloetzelBuchModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		KloetzelBuchModelImpl kloetzelBuchModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					kloetzelBuchModelImpl.getUuid(),
					kloetzelBuchModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((kloetzelBuchModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					kloetzelBuchModelImpl.getOriginalUuid(),
					kloetzelBuchModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					kloetzelBuchModelImpl.getMedicalRecordId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MEDICALRECORD, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MEDICALRECORD, args);
		}

		if ((kloetzelBuchModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MEDICALRECORD.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					kloetzelBuchModelImpl.getOriginalMedicalRecordId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MEDICALRECORD, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MEDICALRECORD, args);
		}
	}

	/**
	 * Creates a new kloetzel buch with the primary key. Does not add the kloetzel buch to the database.
	 *
	 * @param kloetzelBuchId the primary key for the new kloetzel buch
	 * @return the new kloetzel buch
	 */
	@Override
	public KloetzelBuch create(long kloetzelBuchId) {
		KloetzelBuch kloetzelBuch = new KloetzelBuchImpl();

		kloetzelBuch.setNew(true);
		kloetzelBuch.setPrimaryKey(kloetzelBuchId);

		String uuid = PortalUUIDUtil.generate();

		kloetzelBuch.setUuid(uuid);

		kloetzelBuch.setCompanyId(companyProvider.getCompanyId());

		return kloetzelBuch;
	}

	/**
	 * Removes the kloetzel buch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kloetzelBuchId the primary key of the kloetzel buch
	 * @return the kloetzel buch that was removed
	 * @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	 */
	@Override
	public KloetzelBuch remove(long kloetzelBuchId)
		throws NoSuchKloetzelBuchException {
		return remove((Serializable)kloetzelBuchId);
	}

	/**
	 * Removes the kloetzel buch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kloetzel buch
	 * @return the kloetzel buch that was removed
	 * @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	 */
	@Override
	public KloetzelBuch remove(Serializable primaryKey)
		throws NoSuchKloetzelBuchException {
		Session session = null;

		try {
			session = openSession();

			KloetzelBuch kloetzelBuch = (KloetzelBuch)session.get(KloetzelBuchImpl.class,
					primaryKey);

			if (kloetzelBuch == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKloetzelBuchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kloetzelBuch);
		}
		catch (NoSuchKloetzelBuchException nsee) {
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
	protected KloetzelBuch removeImpl(KloetzelBuch kloetzelBuch) {
		kloetzelBuch = toUnwrappedModel(kloetzelBuch);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kloetzelBuch)) {
				kloetzelBuch = (KloetzelBuch)session.get(KloetzelBuchImpl.class,
						kloetzelBuch.getPrimaryKeyObj());
			}

			if (kloetzelBuch != null) {
				session.delete(kloetzelBuch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kloetzelBuch != null) {
			clearCache(kloetzelBuch);
		}

		return kloetzelBuch;
	}

	@Override
	public KloetzelBuch updateImpl(KloetzelBuch kloetzelBuch) {
		kloetzelBuch = toUnwrappedModel(kloetzelBuch);

		boolean isNew = kloetzelBuch.isNew();

		KloetzelBuchModelImpl kloetzelBuchModelImpl = (KloetzelBuchModelImpl)kloetzelBuch;

		if (Validator.isNull(kloetzelBuch.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			kloetzelBuch.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (kloetzelBuch.getCreateDate() == null)) {
			if (serviceContext == null) {
				kloetzelBuch.setCreateDate(now);
			}
			else {
				kloetzelBuch.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!kloetzelBuchModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				kloetzelBuch.setModifiedDate(now);
			}
			else {
				kloetzelBuch.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (kloetzelBuch.isNew()) {
				session.save(kloetzelBuch);

				kloetzelBuch.setNew(false);
			}
			else {
				kloetzelBuch = (KloetzelBuch)session.merge(kloetzelBuch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!KloetzelBuchModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { kloetzelBuchModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					kloetzelBuchModelImpl.getUuid(),
					kloetzelBuchModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { kloetzelBuchModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((kloetzelBuchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kloetzelBuchModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { kloetzelBuchModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((kloetzelBuchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kloetzelBuchModelImpl.getOriginalUuid(),
						kloetzelBuchModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						kloetzelBuchModelImpl.getUuid(),
						kloetzelBuchModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((kloetzelBuchModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kloetzelBuchModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { kloetzelBuchModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		entityCache.putResult(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
			KloetzelBuchImpl.class, kloetzelBuch.getPrimaryKey(), kloetzelBuch,
			false);

		clearUniqueFindersCache(kloetzelBuchModelImpl, false);
		cacheUniqueFindersCache(kloetzelBuchModelImpl);

		kloetzelBuch.resetOriginalValues();

		return kloetzelBuch;
	}

	protected KloetzelBuch toUnwrappedModel(KloetzelBuch kloetzelBuch) {
		if (kloetzelBuch instanceof KloetzelBuchImpl) {
			return kloetzelBuch;
		}

		KloetzelBuchImpl kloetzelBuchImpl = new KloetzelBuchImpl();

		kloetzelBuchImpl.setNew(kloetzelBuch.isNew());
		kloetzelBuchImpl.setPrimaryKey(kloetzelBuch.getPrimaryKey());

		kloetzelBuchImpl.setUuid(kloetzelBuch.getUuid());
		kloetzelBuchImpl.setKloetzelBuchId(kloetzelBuch.getKloetzelBuchId());
		kloetzelBuchImpl.setGroupId(kloetzelBuch.getGroupId());
		kloetzelBuchImpl.setCompanyId(kloetzelBuch.getCompanyId());
		kloetzelBuchImpl.setUserId(kloetzelBuch.getUserId());
		kloetzelBuchImpl.setUserName(kloetzelBuch.getUserName());
		kloetzelBuchImpl.setCreateDate(kloetzelBuch.getCreateDate());
		kloetzelBuchImpl.setModifiedDate(kloetzelBuch.getModifiedDate());
		kloetzelBuchImpl.setStatus(kloetzelBuch.getStatus());
		kloetzelBuchImpl.setStatusByUserId(kloetzelBuch.getStatusByUserId());
		kloetzelBuchImpl.setStatusByUserName(kloetzelBuch.getStatusByUserName());
		kloetzelBuchImpl.setStatusDate(kloetzelBuch.getStatusDate());
		kloetzelBuchImpl.setMedicalRecordId(kloetzelBuch.getMedicalRecordId());
		kloetzelBuchImpl.setHistonumberStart(kloetzelBuch.getHistonumberStart());
		kloetzelBuchImpl.setHistonumberEnd(kloetzelBuch.getHistonumberEnd());
		kloetzelBuchImpl.setHistonumberRunning(kloetzelBuch.getHistonumberRunning());
		kloetzelBuchImpl.setHistonumber(kloetzelBuch.getHistonumber());
		kloetzelBuchImpl.setKloetzelBuchRunning(kloetzelBuch.getKloetzelBuchRunning());
		kloetzelBuchImpl.setOid(kloetzelBuch.getOid());
		kloetzelBuchImpl.setBid(kloetzelBuch.getBid());
		kloetzelBuchImpl.setArea(kloetzelBuch.getArea());
		kloetzelBuchImpl.setType(kloetzelBuch.getType());
		kloetzelBuchImpl.setAcronym(kloetzelBuch.getAcronym());
		kloetzelBuchImpl.setText(kloetzelBuch.getText());
		kloetzelBuchImpl.setInfo(kloetzelBuch.getInfo());
		kloetzelBuchImpl.setCount(kloetzelBuch.getCount());
		kloetzelBuchImpl.setNumberOfPieces(kloetzelBuch.getNumberOfPieces());
		kloetzelBuchImpl.setKbStatus(kloetzelBuch.getKbStatus());
		kloetzelBuchImpl.setSort(kloetzelBuch.getSort());
		kloetzelBuchImpl.setColor(kloetzelBuch.getColor());
		kloetzelBuchImpl.setKbDate(kloetzelBuch.getKbDate());
		kloetzelBuchImpl.setDay(kloetzelBuch.getDay());
		kloetzelBuchImpl.setPocessinguser(kloetzelBuch.getPocessinguser());
		kloetzelBuchImpl.setOrganizationUnit(kloetzelBuch.getOrganizationUnit());

		return kloetzelBuchImpl;
	}

	/**
	 * Returns the kloetzel buch with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kloetzel buch
	 * @return the kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	 */
	@Override
	public KloetzelBuch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKloetzelBuchException {
		KloetzelBuch kloetzelBuch = fetchByPrimaryKey(primaryKey);

		if (kloetzelBuch == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKloetzelBuchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kloetzelBuch;
	}

	/**
	 * Returns the kloetzel buch with the primary key or throws a {@link NoSuchKloetzelBuchException} if it could not be found.
	 *
	 * @param kloetzelBuchId the primary key of the kloetzel buch
	 * @return the kloetzel buch
	 * @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	 */
	@Override
	public KloetzelBuch findByPrimaryKey(long kloetzelBuchId)
		throws NoSuchKloetzelBuchException {
		return findByPrimaryKey((Serializable)kloetzelBuchId);
	}

	/**
	 * Returns the kloetzel buch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kloetzel buch
	 * @return the kloetzel buch, or <code>null</code> if a kloetzel buch with the primary key could not be found
	 */
	@Override
	public KloetzelBuch fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
				KloetzelBuchImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		KloetzelBuch kloetzelBuch = (KloetzelBuch)serializable;

		if (kloetzelBuch == null) {
			Session session = null;

			try {
				session = openSession();

				kloetzelBuch = (KloetzelBuch)session.get(KloetzelBuchImpl.class,
						primaryKey);

				if (kloetzelBuch != null) {
					cacheResult(kloetzelBuch);
				}
				else {
					entityCache.putResult(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
						KloetzelBuchImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
					KloetzelBuchImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kloetzelBuch;
	}

	/**
	 * Returns the kloetzel buch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param kloetzelBuchId the primary key of the kloetzel buch
	 * @return the kloetzel buch, or <code>null</code> if a kloetzel buch with the primary key could not be found
	 */
	@Override
	public KloetzelBuch fetchByPrimaryKey(long kloetzelBuchId) {
		return fetchByPrimaryKey((Serializable)kloetzelBuchId);
	}

	@Override
	public Map<Serializable, KloetzelBuch> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, KloetzelBuch> map = new HashMap<Serializable, KloetzelBuch>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			KloetzelBuch kloetzelBuch = fetchByPrimaryKey(primaryKey);

			if (kloetzelBuch != null) {
				map.put(primaryKey, kloetzelBuch);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
					KloetzelBuchImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (KloetzelBuch)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_KLOETZELBUCH_WHERE_PKS_IN);

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

			for (KloetzelBuch kloetzelBuch : (List<KloetzelBuch>)q.list()) {
				map.put(kloetzelBuch.getPrimaryKeyObj(), kloetzelBuch);

				cacheResult(kloetzelBuch);

				uncachedPrimaryKeys.remove(kloetzelBuch.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(KloetzelBuchModelImpl.ENTITY_CACHE_ENABLED,
					KloetzelBuchImpl.class, primaryKey, nullModel);
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
	 * Returns all the kloetzel buchs.
	 *
	 * @return the kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kloetzel buchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @return the range of kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kloetzel buchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findAll(int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the kloetzel buchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kloetzel buchs
	 * @param end the upper bound of the range of kloetzel buchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of kloetzel buchs
	 */
	@Override
	public List<KloetzelBuch> findAll(int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator,
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

		List<KloetzelBuch> list = null;

		if (retrieveFromCache) {
			list = (List<KloetzelBuch>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_KLOETZELBUCH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KLOETZELBUCH;

				if (pagination) {
					sql = sql.concat(KloetzelBuchModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KloetzelBuch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KloetzelBuch>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the kloetzel buchs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (KloetzelBuch kloetzelBuch : findAll()) {
			remove(kloetzelBuch);
		}
	}

	/**
	 * Returns the number of kloetzel buchs.
	 *
	 * @return the number of kloetzel buchs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KLOETZELBUCH);

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
		return KloetzelBuchModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the kloetzel buch persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(KloetzelBuchImpl.class.getName());
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
	private static final String _SQL_SELECT_KLOETZELBUCH = "SELECT kloetzelBuch FROM KloetzelBuch kloetzelBuch";
	private static final String _SQL_SELECT_KLOETZELBUCH_WHERE_PKS_IN = "SELECT kloetzelBuch FROM KloetzelBuch kloetzelBuch WHERE kloetzelBuchId IN (";
	private static final String _SQL_SELECT_KLOETZELBUCH_WHERE = "SELECT kloetzelBuch FROM KloetzelBuch kloetzelBuch WHERE ";
	private static final String _SQL_COUNT_KLOETZELBUCH = "SELECT COUNT(kloetzelBuch) FROM KloetzelBuch kloetzelBuch";
	private static final String _SQL_COUNT_KLOETZELBUCH_WHERE = "SELECT COUNT(kloetzelBuch) FROM KloetzelBuch kloetzelBuch WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kloetzelBuch.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KloetzelBuch exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KloetzelBuch exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(KloetzelBuchPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "type", "text"
			});
}