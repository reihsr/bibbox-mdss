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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException;
import at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord;
import at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordImpl;
import at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordModelImpl;
import at.graz.meduni.bibbox.medicaldataset.service.persistence.MedicalRecordPersistence;

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
 * The persistence implementation for the medical record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MedicalRecordPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.MedicalRecordUtil
 * @generated
 */
@ProviderType
public class MedicalRecordPersistenceImpl extends BasePersistenceImpl<MedicalRecord>
	implements MedicalRecordPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MedicalRecordUtil} to access the medical record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MedicalRecordImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] { String.class.getName() },
			MedicalRecordModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the medical records where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching medical records
	 */
	@Override
	public List<MedicalRecord> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medical records where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @return the range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medical records where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByUuid(String uuid, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medical records where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByUuid(String uuid, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator,
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

		List<MedicalRecord> list = null;

		if (retrieveFromCache) {
			list = (List<MedicalRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MedicalRecord medicalRecord : list) {
					if (!Objects.equals(uuid, medicalRecord.getUuid())) {
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

			query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

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
				query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
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
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first medical record in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByUuid_First(String uuid,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByUuid_First(uuid, orderByComparator);

		if (medicalRecord != null) {
			return medicalRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMedicalRecordException(msg.toString());
	}

	/**
	 * Returns the first medical record in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByUuid_First(String uuid,
		OrderByComparator<MedicalRecord> orderByComparator) {
		List<MedicalRecord> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last medical record in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByUuid_Last(String uuid,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByUuid_Last(uuid, orderByComparator);

		if (medicalRecord != null) {
			return medicalRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMedicalRecordException(msg.toString());
	}

	/**
	 * Returns the last medical record in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByUuid_Last(String uuid,
		OrderByComparator<MedicalRecord> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MedicalRecord> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the medical records before and after the current medical record in the ordered set where uuid = &#63;.
	 *
	 * @param medicalRecordId the primary key of the current medical record
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next medical record
	 * @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord[] findByUuid_PrevAndNext(long medicalRecordId,
		String uuid, OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = findByPrimaryKey(medicalRecordId);

		Session session = null;

		try {
			session = openSession();

			MedicalRecord[] array = new MedicalRecordImpl[3];

			array[0] = getByUuid_PrevAndNext(session, medicalRecord, uuid,
					orderByComparator, true);

			array[1] = medicalRecord;

			array[2] = getByUuid_PrevAndNext(session, medicalRecord, uuid,
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

	protected MedicalRecord getByUuid_PrevAndNext(Session session,
		MedicalRecord medicalRecord, String uuid,
		OrderByComparator<MedicalRecord> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

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
			query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(medicalRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MedicalRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the medical records where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MedicalRecord medicalRecord : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(medicalRecord);
		}
	}

	/**
	 * Returns the number of medical records where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching medical records
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEDICALRECORD_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "medicalRecord.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "medicalRecord.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(medicalRecord.uuid IS NULL OR medicalRecord.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			MedicalRecordModelImpl.UUID_COLUMN_BITMASK |
			MedicalRecordModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the medical record where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchMedicalRecordException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByUUID_G(String uuid, long groupId)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByUUID_G(uuid, groupId);

		if (medicalRecord == null) {
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

			throw new NoSuchMedicalRecordException(msg.toString());
		}

		return medicalRecord;
	}

	/**
	 * Returns the medical record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the medical record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof MedicalRecord) {
			MedicalRecord medicalRecord = (MedicalRecord)result;

			if (!Objects.equals(uuid, medicalRecord.getUuid()) ||
					(groupId != medicalRecord.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

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

				List<MedicalRecord> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					MedicalRecord medicalRecord = list.get(0);

					result = medicalRecord;

					cacheResult(medicalRecord);

					if ((medicalRecord.getUuid() == null) ||
							!medicalRecord.getUuid().equals(uuid) ||
							(medicalRecord.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, medicalRecord);
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
			return (MedicalRecord)result;
		}
	}

	/**
	 * Removes the medical record where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the medical record that was removed
	 */
	@Override
	public MedicalRecord removeByUUID_G(String uuid, long groupId)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = findByUUID_G(uuid, groupId);

		return remove(medicalRecord);
	}

	/**
	 * Returns the number of medical records where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching medical records
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEDICALRECORD_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "medicalRecord.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "medicalRecord.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(medicalRecord.uuid IS NULL OR medicalRecord.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "medicalRecord.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			MedicalRecordModelImpl.UUID_COLUMN_BITMASK |
			MedicalRecordModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the medical records where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching medical records
	 */
	@Override
	public List<MedicalRecord> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medical records where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @return the range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medical records where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<MedicalRecord> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medical records where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<MedicalRecord> orderByComparator,
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

		List<MedicalRecord> list = null;

		if (retrieveFromCache) {
			list = (List<MedicalRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MedicalRecord medicalRecord : list) {
					if (!Objects.equals(uuid, medicalRecord.getUuid()) ||
							(companyId != medicalRecord.getCompanyId())) {
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

			query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

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
				query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
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
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (medicalRecord != null) {
			return medicalRecord;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMedicalRecordException(msg.toString());
	}

	/**
	 * Returns the first medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<MedicalRecord> orderByComparator) {
		List<MedicalRecord> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (medicalRecord != null) {
			return medicalRecord;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMedicalRecordException(msg.toString());
	}

	/**
	 * Returns the last medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<MedicalRecord> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MedicalRecord> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the medical records before and after the current medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param medicalRecordId the primary key of the current medical record
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next medical record
	 * @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord[] findByUuid_C_PrevAndNext(long medicalRecordId,
		String uuid, long companyId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = findByPrimaryKey(medicalRecordId);

		Session session = null;

		try {
			session = openSession();

			MedicalRecord[] array = new MedicalRecordImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, medicalRecord, uuid,
					companyId, orderByComparator, true);

			array[1] = medicalRecord;

			array[2] = getByUuid_C_PrevAndNext(session, medicalRecord, uuid,
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

	protected MedicalRecord getByUuid_C_PrevAndNext(Session session,
		MedicalRecord medicalRecord, String uuid, long companyId,
		OrderByComparator<MedicalRecord> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

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
			query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(medicalRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MedicalRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the medical records where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MedicalRecord medicalRecord : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(medicalRecord);
		}
	}

	/**
	 * Returns the number of medical records where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching medical records
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MEDICALRECORD_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "medicalRecord.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "medicalRecord.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(medicalRecord.uuid IS NULL OR medicalRecord.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "medicalRecord.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			MedicalRecordModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the medical records where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching medical records
	 */
	@Override
	public List<MedicalRecord> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medical records where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @return the range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medical records where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByGroupId(long groupId, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medical records where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByGroupId(long groupId, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator,
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

		List<MedicalRecord> list = null;

		if (retrieveFromCache) {
			list = (List<MedicalRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MedicalRecord medicalRecord : list) {
					if ((groupId != medicalRecord.getGroupId())) {
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

			query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first medical record in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByGroupId_First(long groupId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByGroupId_First(groupId,
				orderByComparator);

		if (medicalRecord != null) {
			return medicalRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMedicalRecordException(msg.toString());
	}

	/**
	 * Returns the first medical record in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByGroupId_First(long groupId,
		OrderByComparator<MedicalRecord> orderByComparator) {
		List<MedicalRecord> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last medical record in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByGroupId_Last(long groupId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (medicalRecord != null) {
			return medicalRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMedicalRecordException(msg.toString());
	}

	/**
	 * Returns the last medical record in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByGroupId_Last(long groupId,
		OrderByComparator<MedicalRecord> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<MedicalRecord> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the medical records before and after the current medical record in the ordered set where groupId = &#63;.
	 *
	 * @param medicalRecordId the primary key of the current medical record
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next medical record
	 * @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord[] findByGroupId_PrevAndNext(long medicalRecordId,
		long groupId, OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = findByPrimaryKey(medicalRecordId);

		Session session = null;

		try {
			session = openSession();

			MedicalRecord[] array = new MedicalRecordImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, medicalRecord,
					groupId, orderByComparator, true);

			array[1] = medicalRecord;

			array[2] = getByGroupId_PrevAndNext(session, medicalRecord,
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

	protected MedicalRecord getByGroupId_PrevAndNext(Session session,
		MedicalRecord medicalRecord, long groupId,
		OrderByComparator<MedicalRecord> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

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
			query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(medicalRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MedicalRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the medical records that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching medical records that the user has permission to view
	 */
	@Override
	public List<MedicalRecord> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medical records that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @return the range of matching medical records that the user has permission to view
	 */
	@Override
	public List<MedicalRecord> filterFindByGroupId(long groupId, int start,
		int end) {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medical records that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medical records that the user has permission to view
	 */
	@Override
	public List<MedicalRecord> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator<MedicalRecord> orderByComparator) {
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
			query.append(_FILTER_SQL_SELECT_MEDICALRECORD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_MEDICALRECORD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MEDICALRECORD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(MedicalRecordModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				MedicalRecord.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, MedicalRecordImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, MedicalRecordImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<MedicalRecord>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the medical records before and after the current medical record in the ordered set of medical records that the user has permission to view where groupId = &#63;.
	 *
	 * @param medicalRecordId the primary key of the current medical record
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next medical record
	 * @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord[] filterFindByGroupId_PrevAndNext(
		long medicalRecordId, long groupId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(medicalRecordId, groupId,
				orderByComparator);
		}

		MedicalRecord medicalRecord = findByPrimaryKey(medicalRecordId);

		Session session = null;

		try {
			session = openSession();

			MedicalRecord[] array = new MedicalRecordImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session, medicalRecord,
					groupId, orderByComparator, true);

			array[1] = medicalRecord;

			array[2] = filterGetByGroupId_PrevAndNext(session, medicalRecord,
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

	protected MedicalRecord filterGetByGroupId_PrevAndNext(Session session,
		MedicalRecord medicalRecord, long groupId,
		OrderByComparator<MedicalRecord> orderByComparator, boolean previous) {
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
			query.append(_FILTER_SQL_SELECT_MEDICALRECORD_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_MEDICALRECORD_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_MEDICALRECORD_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(MedicalRecordModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				MedicalRecord.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, MedicalRecordImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, MedicalRecordImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(medicalRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MedicalRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the medical records where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (MedicalRecord medicalRecord : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(medicalRecord);
		}
	}

	/**
	 * Returns the number of medical records where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching medical records
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEDICALRECORD_WHERE);

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
	 * Returns the number of medical records that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching medical records that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_MEDICALRECORD_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				MedicalRecord.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "medicalRecord.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INUMBER = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByINumber",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INUMBER =
		new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByINumber", new String[] { Long.class.getName() },
			MedicalRecordModelImpl.INUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INUMBER = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByINumber",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the medical records where iNumber = &#63;.
	 *
	 * @param iNumber the i number
	 * @return the matching medical records
	 */
	@Override
	public List<MedicalRecord> findByINumber(long iNumber) {
		return findByINumber(iNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medical records where iNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param iNumber the i number
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @return the range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByINumber(long iNumber, int start, int end) {
		return findByINumber(iNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medical records where iNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param iNumber the i number
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByINumber(long iNumber, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return findByINumber(iNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medical records where iNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param iNumber the i number
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByINumber(long iNumber, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INUMBER;
			finderArgs = new Object[] { iNumber };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INUMBER;
			finderArgs = new Object[] { iNumber, start, end, orderByComparator };
		}

		List<MedicalRecord> list = null;

		if (retrieveFromCache) {
			list = (List<MedicalRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MedicalRecord medicalRecord : list) {
					if ((iNumber != medicalRecord.getINumber())) {
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

			query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

			query.append(_FINDER_COLUMN_INUMBER_INUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(iNumber);

				if (!pagination) {
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first medical record in the ordered set where iNumber = &#63;.
	 *
	 * @param iNumber the i number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByINumber_First(long iNumber,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByINumber_First(iNumber,
				orderByComparator);

		if (medicalRecord != null) {
			return medicalRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("iNumber=");
		msg.append(iNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMedicalRecordException(msg.toString());
	}

	/**
	 * Returns the first medical record in the ordered set where iNumber = &#63;.
	 *
	 * @param iNumber the i number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByINumber_First(long iNumber,
		OrderByComparator<MedicalRecord> orderByComparator) {
		List<MedicalRecord> list = findByINumber(iNumber, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last medical record in the ordered set where iNumber = &#63;.
	 *
	 * @param iNumber the i number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByINumber_Last(long iNumber,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByINumber_Last(iNumber,
				orderByComparator);

		if (medicalRecord != null) {
			return medicalRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("iNumber=");
		msg.append(iNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMedicalRecordException(msg.toString());
	}

	/**
	 * Returns the last medical record in the ordered set where iNumber = &#63;.
	 *
	 * @param iNumber the i number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByINumber_Last(long iNumber,
		OrderByComparator<MedicalRecord> orderByComparator) {
		int count = countByINumber(iNumber);

		if (count == 0) {
			return null;
		}

		List<MedicalRecord> list = findByINumber(iNumber, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the medical records before and after the current medical record in the ordered set where iNumber = &#63;.
	 *
	 * @param medicalRecordId the primary key of the current medical record
	 * @param iNumber the i number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next medical record
	 * @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord[] findByINumber_PrevAndNext(long medicalRecordId,
		long iNumber, OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = findByPrimaryKey(medicalRecordId);

		Session session = null;

		try {
			session = openSession();

			MedicalRecord[] array = new MedicalRecordImpl[3];

			array[0] = getByINumber_PrevAndNext(session, medicalRecord,
					iNumber, orderByComparator, true);

			array[1] = medicalRecord;

			array[2] = getByINumber_PrevAndNext(session, medicalRecord,
					iNumber, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MedicalRecord getByINumber_PrevAndNext(Session session,
		MedicalRecord medicalRecord, long iNumber,
		OrderByComparator<MedicalRecord> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

		query.append(_FINDER_COLUMN_INUMBER_INUMBER_2);

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
			query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(iNumber);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(medicalRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MedicalRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the medical records where iNumber = &#63; from the database.
	 *
	 * @param iNumber the i number
	 */
	@Override
	public void removeByINumber(long iNumber) {
		for (MedicalRecord medicalRecord : findByINumber(iNumber,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(medicalRecord);
		}
	}

	/**
	 * Returns the number of medical records where iNumber = &#63;.
	 *
	 * @param iNumber the i number
	 * @return the number of matching medical records
	 */
	@Override
	public int countByINumber(long iNumber) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INUMBER;

		Object[] finderArgs = new Object[] { iNumber };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEDICALRECORD_WHERE);

			query.append(_FINDER_COLUMN_INUMBER_INUMBER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(iNumber);

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

	private static final String _FINDER_COLUMN_INUMBER_INUMBER_2 = "medicalRecord.iNumber = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IMPORTMEDICALDATASET =
		new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByImportMedicalDataSet",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASET =
		new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED,
			MedicalRecordImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByImportMedicalDataSet",
			new String[] { Long.class.getName() },
			MedicalRecordModelImpl.IMPORTMEDICALDATASETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASET = new FinderPath(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByImportMedicalDataSet", new String[] { Long.class.getName() });

	/**
	 * Returns all the medical records where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @return the matching medical records
	 */
	@Override
	public List<MedicalRecord> findByImportMedicalDataSet(
		long importMedicalDataSetId) {
		return findByImportMedicalDataSet(importMedicalDataSetId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medical records where importMedicalDataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @return the range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end) {
		return findByImportMedicalDataSet(importMedicalDataSetId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the medical records where importMedicalDataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return findByImportMedicalDataSet(importMedicalDataSetId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medical records where importMedicalDataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching medical records
	 */
	@Override
	public List<MedicalRecord> findByImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASET;
			finderArgs = new Object[] { importMedicalDataSetId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IMPORTMEDICALDATASET;
			finderArgs = new Object[] {
					importMedicalDataSetId,
					
					start, end, orderByComparator
				};
		}

		List<MedicalRecord> list = null;

		if (retrieveFromCache) {
			list = (List<MedicalRecord>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MedicalRecord medicalRecord : list) {
					if ((importMedicalDataSetId != medicalRecord.getImportMedicalDataSetId())) {
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

			query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

			query.append(_FINDER_COLUMN_IMPORTMEDICALDATASET_IMPORTMEDICALDATASETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importMedicalDataSetId);

				if (!pagination) {
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first medical record in the ordered set where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByImportMedicalDataSet_First(
		long importMedicalDataSetId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByImportMedicalDataSet_First(importMedicalDataSetId,
				orderByComparator);

		if (medicalRecord != null) {
			return medicalRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("importMedicalDataSetId=");
		msg.append(importMedicalDataSetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMedicalRecordException(msg.toString());
	}

	/**
	 * Returns the first medical record in the ordered set where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByImportMedicalDataSet_First(
		long importMedicalDataSetId,
		OrderByComparator<MedicalRecord> orderByComparator) {
		List<MedicalRecord> list = findByImportMedicalDataSet(importMedicalDataSetId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last medical record in the ordered set where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching medical record
	 * @throws NoSuchMedicalRecordException if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord findByImportMedicalDataSet_Last(
		long importMedicalDataSetId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByImportMedicalDataSet_Last(importMedicalDataSetId,
				orderByComparator);

		if (medicalRecord != null) {
			return medicalRecord;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("importMedicalDataSetId=");
		msg.append(importMedicalDataSetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMedicalRecordException(msg.toString());
	}

	/**
	 * Returns the last medical record in the ordered set where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	 */
	@Override
	public MedicalRecord fetchByImportMedicalDataSet_Last(
		long importMedicalDataSetId,
		OrderByComparator<MedicalRecord> orderByComparator) {
		int count = countByImportMedicalDataSet(importMedicalDataSetId);

		if (count == 0) {
			return null;
		}

		List<MedicalRecord> list = findByImportMedicalDataSet(importMedicalDataSetId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the medical records before and after the current medical record in the ordered set where importMedicalDataSetId = &#63;.
	 *
	 * @param medicalRecordId the primary key of the current medical record
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next medical record
	 * @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord[] findByImportMedicalDataSet_PrevAndNext(
		long medicalRecordId, long importMedicalDataSetId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = findByPrimaryKey(medicalRecordId);

		Session session = null;

		try {
			session = openSession();

			MedicalRecord[] array = new MedicalRecordImpl[3];

			array[0] = getByImportMedicalDataSet_PrevAndNext(session,
					medicalRecord, importMedicalDataSetId, orderByComparator,
					true);

			array[1] = medicalRecord;

			array[2] = getByImportMedicalDataSet_PrevAndNext(session,
					medicalRecord, importMedicalDataSetId, orderByComparator,
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

	protected MedicalRecord getByImportMedicalDataSet_PrevAndNext(
		Session session, MedicalRecord medicalRecord,
		long importMedicalDataSetId,
		OrderByComparator<MedicalRecord> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MEDICALRECORD_WHERE);

		query.append(_FINDER_COLUMN_IMPORTMEDICALDATASET_IMPORTMEDICALDATASETID_2);

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
			query.append(MedicalRecordModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(importMedicalDataSetId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(medicalRecord);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MedicalRecord> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the medical records where importMedicalDataSetId = &#63; from the database.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 */
	@Override
	public void removeByImportMedicalDataSet(long importMedicalDataSetId) {
		for (MedicalRecord medicalRecord : findByImportMedicalDataSet(
				importMedicalDataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(medicalRecord);
		}
	}

	/**
	 * Returns the number of medical records where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @return the number of matching medical records
	 */
	@Override
	public int countByImportMedicalDataSet(long importMedicalDataSetId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASET;

		Object[] finderArgs = new Object[] { importMedicalDataSetId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MEDICALRECORD_WHERE);

			query.append(_FINDER_COLUMN_IMPORTMEDICALDATASET_IMPORTMEDICALDATASETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importMedicalDataSetId);

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

	private static final String _FINDER_COLUMN_IMPORTMEDICALDATASET_IMPORTMEDICALDATASETID_2 =
		"medicalRecord.importMedicalDataSetId = ?";

	public MedicalRecordPersistenceImpl() {
		setModelClass(MedicalRecord.class);

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
	 * Caches the medical record in the entity cache if it is enabled.
	 *
	 * @param medicalRecord the medical record
	 */
	@Override
	public void cacheResult(MedicalRecord medicalRecord) {
		entityCache.putResult(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordImpl.class, medicalRecord.getPrimaryKey(),
			medicalRecord);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { medicalRecord.getUuid(), medicalRecord.getGroupId() },
			medicalRecord);

		medicalRecord.resetOriginalValues();
	}

	/**
	 * Caches the medical records in the entity cache if it is enabled.
	 *
	 * @param medicalRecords the medical records
	 */
	@Override
	public void cacheResult(List<MedicalRecord> medicalRecords) {
		for (MedicalRecord medicalRecord : medicalRecords) {
			if (entityCache.getResult(
						MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
						MedicalRecordImpl.class, medicalRecord.getPrimaryKey()) == null) {
				cacheResult(medicalRecord);
			}
			else {
				medicalRecord.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all medical records.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MedicalRecordImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the medical record.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MedicalRecord medicalRecord) {
		entityCache.removeResult(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordImpl.class, medicalRecord.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MedicalRecordModelImpl)medicalRecord, true);
	}

	@Override
	public void clearCache(List<MedicalRecord> medicalRecords) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MedicalRecord medicalRecord : medicalRecords) {
			entityCache.removeResult(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
				MedicalRecordImpl.class, medicalRecord.getPrimaryKey());

			clearUniqueFindersCache((MedicalRecordModelImpl)medicalRecord, true);
		}
	}

	protected void cacheUniqueFindersCache(
		MedicalRecordModelImpl medicalRecordModelImpl) {
		Object[] args = new Object[] {
				medicalRecordModelImpl.getUuid(),
				medicalRecordModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			medicalRecordModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		MedicalRecordModelImpl medicalRecordModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					medicalRecordModelImpl.getUuid(),
					medicalRecordModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((medicalRecordModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					medicalRecordModelImpl.getOriginalUuid(),
					medicalRecordModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new medical record with the primary key. Does not add the medical record to the database.
	 *
	 * @param medicalRecordId the primary key for the new medical record
	 * @return the new medical record
	 */
	@Override
	public MedicalRecord create(long medicalRecordId) {
		MedicalRecord medicalRecord = new MedicalRecordImpl();

		medicalRecord.setNew(true);
		medicalRecord.setPrimaryKey(medicalRecordId);

		String uuid = PortalUUIDUtil.generate();

		medicalRecord.setUuid(uuid);

		medicalRecord.setCompanyId(companyProvider.getCompanyId());

		return medicalRecord;
	}

	/**
	 * Removes the medical record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param medicalRecordId the primary key of the medical record
	 * @return the medical record that was removed
	 * @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord remove(long medicalRecordId)
		throws NoSuchMedicalRecordException {
		return remove((Serializable)medicalRecordId);
	}

	/**
	 * Removes the medical record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the medical record
	 * @return the medical record that was removed
	 * @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord remove(Serializable primaryKey)
		throws NoSuchMedicalRecordException {
		Session session = null;

		try {
			session = openSession();

			MedicalRecord medicalRecord = (MedicalRecord)session.get(MedicalRecordImpl.class,
					primaryKey);

			if (medicalRecord == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMedicalRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(medicalRecord);
		}
		catch (NoSuchMedicalRecordException nsee) {
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
	protected MedicalRecord removeImpl(MedicalRecord medicalRecord) {
		medicalRecord = toUnwrappedModel(medicalRecord);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(medicalRecord)) {
				medicalRecord = (MedicalRecord)session.get(MedicalRecordImpl.class,
						medicalRecord.getPrimaryKeyObj());
			}

			if (medicalRecord != null) {
				session.delete(medicalRecord);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (medicalRecord != null) {
			clearCache(medicalRecord);
		}

		return medicalRecord;
	}

	@Override
	public MedicalRecord updateImpl(MedicalRecord medicalRecord) {
		medicalRecord = toUnwrappedModel(medicalRecord);

		boolean isNew = medicalRecord.isNew();

		MedicalRecordModelImpl medicalRecordModelImpl = (MedicalRecordModelImpl)medicalRecord;

		if (Validator.isNull(medicalRecord.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			medicalRecord.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (medicalRecord.getCreateDate() == null)) {
			if (serviceContext == null) {
				medicalRecord.setCreateDate(now);
			}
			else {
				medicalRecord.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!medicalRecordModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				medicalRecord.setModifiedDate(now);
			}
			else {
				medicalRecord.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (medicalRecord.isNew()) {
				session.save(medicalRecord);

				medicalRecord.setNew(false);
			}
			else {
				medicalRecord = (MedicalRecord)session.merge(medicalRecord);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MedicalRecordModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { medicalRecordModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					medicalRecordModelImpl.getUuid(),
					medicalRecordModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { medicalRecordModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] { medicalRecordModelImpl.getINumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_INUMBER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INUMBER,
				args);

			args = new Object[] {
					medicalRecordModelImpl.getImportMedicalDataSetId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASET,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASET,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((medicalRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						medicalRecordModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { medicalRecordModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((medicalRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						medicalRecordModelImpl.getOriginalUuid(),
						medicalRecordModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						medicalRecordModelImpl.getUuid(),
						medicalRecordModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((medicalRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						medicalRecordModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { medicalRecordModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((medicalRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						medicalRecordModelImpl.getOriginalINumber()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INUMBER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INUMBER,
					args);

				args = new Object[] { medicalRecordModelImpl.getINumber() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INUMBER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INUMBER,
					args);
			}

			if ((medicalRecordModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						medicalRecordModelImpl.getOriginalImportMedicalDataSetId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASET,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASET,
					args);

				args = new Object[] {
						medicalRecordModelImpl.getImportMedicalDataSetId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASET,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASET,
					args);
			}
		}

		entityCache.putResult(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
			MedicalRecordImpl.class, medicalRecord.getPrimaryKey(),
			medicalRecord, false);

		clearUniqueFindersCache(medicalRecordModelImpl, false);
		cacheUniqueFindersCache(medicalRecordModelImpl);

		medicalRecord.resetOriginalValues();

		return medicalRecord;
	}

	protected MedicalRecord toUnwrappedModel(MedicalRecord medicalRecord) {
		if (medicalRecord instanceof MedicalRecordImpl) {
			return medicalRecord;
		}

		MedicalRecordImpl medicalRecordImpl = new MedicalRecordImpl();

		medicalRecordImpl.setNew(medicalRecord.isNew());
		medicalRecordImpl.setPrimaryKey(medicalRecord.getPrimaryKey());

		medicalRecordImpl.setUuid(medicalRecord.getUuid());
		medicalRecordImpl.setMedicalRecordId(medicalRecord.getMedicalRecordId());
		medicalRecordImpl.setGroupId(medicalRecord.getGroupId());
		medicalRecordImpl.setCompanyId(medicalRecord.getCompanyId());
		medicalRecordImpl.setUserId(medicalRecord.getUserId());
		medicalRecordImpl.setUserName(medicalRecord.getUserName());
		medicalRecordImpl.setCreateDate(medicalRecord.getCreateDate());
		medicalRecordImpl.setModifiedDate(medicalRecord.getModifiedDate());
		medicalRecordImpl.setStatus(medicalRecord.getStatus());
		medicalRecordImpl.setStatusByUserId(medicalRecord.getStatusByUserId());
		medicalRecordImpl.setStatusByUserName(medicalRecord.getStatusByUserName());
		medicalRecordImpl.setStatusDate(medicalRecord.getStatusDate());
		medicalRecordImpl.setImportMedicalDataSetId(medicalRecord.getImportMedicalDataSetId());
		medicalRecordImpl.setHistonumberStart(medicalRecord.getHistonumberStart());
		medicalRecordImpl.setHistonumberEnd(medicalRecord.getHistonumberEnd());
		medicalRecordImpl.setHistonumberRunning(medicalRecord.getHistonumberRunning());
		medicalRecordImpl.setINumber(medicalRecord.getINumber());
		medicalRecordImpl.setVPatientId(medicalRecord.getVPatientId());
		medicalRecordImpl.setVHistonNumber(medicalRecord.getVHistonNumber());
		medicalRecordImpl.setBbPseudonym(medicalRecord.getBbPseudonym());
		medicalRecordImpl.setArea(medicalRecord.getArea());

		return medicalRecordImpl;
	}

	/**
	 * Returns the medical record with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the medical record
	 * @return the medical record
	 * @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMedicalRecordException {
		MedicalRecord medicalRecord = fetchByPrimaryKey(primaryKey);

		if (medicalRecord == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMedicalRecordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return medicalRecord;
	}

	/**
	 * Returns the medical record with the primary key or throws a {@link NoSuchMedicalRecordException} if it could not be found.
	 *
	 * @param medicalRecordId the primary key of the medical record
	 * @return the medical record
	 * @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord findByPrimaryKey(long medicalRecordId)
		throws NoSuchMedicalRecordException {
		return findByPrimaryKey((Serializable)medicalRecordId);
	}

	/**
	 * Returns the medical record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the medical record
	 * @return the medical record, or <code>null</code> if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
				MedicalRecordImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MedicalRecord medicalRecord = (MedicalRecord)serializable;

		if (medicalRecord == null) {
			Session session = null;

			try {
				session = openSession();

				medicalRecord = (MedicalRecord)session.get(MedicalRecordImpl.class,
						primaryKey);

				if (medicalRecord != null) {
					cacheResult(medicalRecord);
				}
				else {
					entityCache.putResult(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
						MedicalRecordImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
					MedicalRecordImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return medicalRecord;
	}

	/**
	 * Returns the medical record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param medicalRecordId the primary key of the medical record
	 * @return the medical record, or <code>null</code> if a medical record with the primary key could not be found
	 */
	@Override
	public MedicalRecord fetchByPrimaryKey(long medicalRecordId) {
		return fetchByPrimaryKey((Serializable)medicalRecordId);
	}

	@Override
	public Map<Serializable, MedicalRecord> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MedicalRecord> map = new HashMap<Serializable, MedicalRecord>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MedicalRecord medicalRecord = fetchByPrimaryKey(primaryKey);

			if (medicalRecord != null) {
				map.put(primaryKey, medicalRecord);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
					MedicalRecordImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MedicalRecord)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MEDICALRECORD_WHERE_PKS_IN);

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

			for (MedicalRecord medicalRecord : (List<MedicalRecord>)q.list()) {
				map.put(medicalRecord.getPrimaryKeyObj(), medicalRecord);

				cacheResult(medicalRecord);

				uncachedPrimaryKeys.remove(medicalRecord.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MedicalRecordModelImpl.ENTITY_CACHE_ENABLED,
					MedicalRecordImpl.class, primaryKey, nullModel);
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
	 * Returns all the medical records.
	 *
	 * @return the medical records
	 */
	@Override
	public List<MedicalRecord> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medical records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @return the range of medical records
	 */
	@Override
	public List<MedicalRecord> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the medical records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of medical records
	 */
	@Override
	public List<MedicalRecord> findAll(int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medical records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of medical records
	 * @param end the upper bound of the range of medical records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of medical records
	 */
	@Override
	public List<MedicalRecord> findAll(int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator,
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

		List<MedicalRecord> list = null;

		if (retrieveFromCache) {
			list = (List<MedicalRecord>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MEDICALRECORD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEDICALRECORD;

				if (pagination) {
					sql = sql.concat(MedicalRecordModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MedicalRecord>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the medical records from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MedicalRecord medicalRecord : findAll()) {
			remove(medicalRecord);
		}
	}

	/**
	 * Returns the number of medical records.
	 *
	 * @return the number of medical records
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MEDICALRECORD);

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
		return MedicalRecordModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the medical record persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MedicalRecordImpl.class.getName());
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
	private static final String _SQL_SELECT_MEDICALRECORD = "SELECT medicalRecord FROM MedicalRecord medicalRecord";
	private static final String _SQL_SELECT_MEDICALRECORD_WHERE_PKS_IN = "SELECT medicalRecord FROM MedicalRecord medicalRecord WHERE medicalRecordId IN (";
	private static final String _SQL_SELECT_MEDICALRECORD_WHERE = "SELECT medicalRecord FROM MedicalRecord medicalRecord WHERE ";
	private static final String _SQL_COUNT_MEDICALRECORD = "SELECT COUNT(medicalRecord) FROM MedicalRecord medicalRecord";
	private static final String _SQL_COUNT_MEDICALRECORD_WHERE = "SELECT COUNT(medicalRecord) FROM MedicalRecord medicalRecord WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "medicalRecord.medicalRecordId";
	private static final String _FILTER_SQL_SELECT_MEDICALRECORD_WHERE = "SELECT DISTINCT {medicalRecord.*} FROM medicaldataset_MedicalRecord medicalRecord WHERE ";
	private static final String _FILTER_SQL_SELECT_MEDICALRECORD_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {medicaldataset_MedicalRecord.*} FROM (SELECT DISTINCT medicalRecord.medicalRecordId FROM medicaldataset_MedicalRecord medicalRecord WHERE ";
	private static final String _FILTER_SQL_SELECT_MEDICALRECORD_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN medicaldataset_MedicalRecord ON TEMP_TABLE.medicalRecordId = medicaldataset_MedicalRecord.medicalRecordId";
	private static final String _FILTER_SQL_COUNT_MEDICALRECORD_WHERE = "SELECT COUNT(DISTINCT medicalRecord.medicalRecordId) AS COUNT_VALUE FROM medicaldataset_MedicalRecord medicalRecord WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "medicalRecord";
	private static final String _FILTER_ENTITY_TABLE = "medicaldataset_MedicalRecord";
	private static final String _ORDER_BY_ENTITY_ALIAS = "medicalRecord.";
	private static final String _ORDER_BY_ENTITY_TABLE = "medicaldataset_MedicalRecord.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MedicalRecord exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MedicalRecord exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MedicalRecordPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}