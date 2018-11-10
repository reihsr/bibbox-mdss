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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException;
import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog;
import at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogImpl;
import at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogModelImpl;
import at.graz.meduni.bibbox.medicaldataset.service.persistence.ImportMedicalDataSetLogPersistence;

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
 * The persistence implementation for the import medical data set log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLogPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.ImportMedicalDataSetLogUtil
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetLogPersistenceImpl extends BasePersistenceImpl<ImportMedicalDataSetLog>
	implements ImportMedicalDataSetLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImportMedicalDataSetLogUtil} to access the import medical data set log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImportMedicalDataSetLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ImportMedicalDataSetLogModelImpl.UUID_COLUMN_BITMASK |
			ImportMedicalDataSetLogModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the import medical data set logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @return the range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByUuid(String uuid, int start,
		int end, OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByUuid(String uuid, int start,
		int end, OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
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

		List<ImportMedicalDataSetLog> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSetLog>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSetLog importMedicalDataSetLog : list) {
					if (!Objects.equals(uuid, importMedicalDataSetLog.getUuid())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);

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
				query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
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
					list = (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
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
	 * Returns the first import medical data set log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByUuid_First(String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = fetchByUuid_First(uuid,
				orderByComparator);

		if (importMedicalDataSetLog != null) {
			return importMedicalDataSetLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetLogException(msg.toString());
	}

	/**
	 * Returns the first import medical data set log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByUuid_First(String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		List<ImportMedicalDataSetLog> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByUuid_Last(String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = fetchByUuid_Last(uuid,
				orderByComparator);

		if (importMedicalDataSetLog != null) {
			return importMedicalDataSetLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetLogException(msg.toString());
	}

	/**
	 * Returns the last import medical data set log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByUuid_Last(String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSetLog> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data set logs before and after the current import medical data set log in the ordered set where uuid = &#63;.
	 *
	 * @param importMedicalDataSetLogId the primary key of the current import medical data set log
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog[] findByUuid_PrevAndNext(
		long importMedicalDataSetLogId, String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = findByPrimaryKey(importMedicalDataSetLogId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetLog[] array = new ImportMedicalDataSetLogImpl[3];

			array[0] = getByUuid_PrevAndNext(session, importMedicalDataSetLog,
					uuid, orderByComparator, true);

			array[1] = importMedicalDataSetLog;

			array[2] = getByUuid_PrevAndNext(session, importMedicalDataSetLog,
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

	protected ImportMedicalDataSetLog getByUuid_PrevAndNext(Session session,
		ImportMedicalDataSetLog importMedicalDataSetLog, String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);

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
			query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSetLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSetLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data set logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ImportMedicalDataSetLog importMedicalDataSetLog : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importMedicalDataSetLog);
		}
	}

	/**
	 * Returns the number of import medical data set logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching import medical data set logs
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASETLOG_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "importMedicalDataSetLog.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "importMedicalDataSetLog.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(importMedicalDataSetLog.uuid IS NULL OR importMedicalDataSetLog.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ImportMedicalDataSetLogModelImpl.UUID_COLUMN_BITMASK |
			ImportMedicalDataSetLogModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the import medical data set log where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchImportMedicalDataSetLogException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByUUID_G(String uuid, long groupId)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = fetchByUUID_G(uuid,
				groupId);

		if (importMedicalDataSetLog == null) {
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

			throw new NoSuchImportMedicalDataSetLogException(msg.toString());
		}

		return importMedicalDataSetLog;
	}

	/**
	 * Returns the import medical data set log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the import medical data set log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ImportMedicalDataSetLog) {
			ImportMedicalDataSetLog importMedicalDataSetLog = (ImportMedicalDataSetLog)result;

			if (!Objects.equals(uuid, importMedicalDataSetLog.getUuid()) ||
					(groupId != importMedicalDataSetLog.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);

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

				List<ImportMedicalDataSetLog> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ImportMedicalDataSetLog importMedicalDataSetLog = list.get(0);

					result = importMedicalDataSetLog;

					cacheResult(importMedicalDataSetLog);

					if ((importMedicalDataSetLog.getUuid() == null) ||
							!importMedicalDataSetLog.getUuid().equals(uuid) ||
							(importMedicalDataSetLog.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, importMedicalDataSetLog);
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
			return (ImportMedicalDataSetLog)result;
		}
	}

	/**
	 * Removes the import medical data set log where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the import medical data set log that was removed
	 */
	@Override
	public ImportMedicalDataSetLog removeByUUID_G(String uuid, long groupId)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = findByUUID_G(uuid,
				groupId);

		return remove(importMedicalDataSetLog);
	}

	/**
	 * Returns the number of import medical data set logs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching import medical data set logs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASETLOG_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "importMedicalDataSetLog.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "importMedicalDataSetLog.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(importMedicalDataSetLog.uuid IS NULL OR importMedicalDataSetLog.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "importMedicalDataSetLog.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ImportMedicalDataSetLogModelImpl.UUID_COLUMN_BITMASK |
			ImportMedicalDataSetLogModelImpl.COMPANYID_COLUMN_BITMASK |
			ImportMedicalDataSetLogModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the import medical data set logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByUuid_C(String uuid,
		long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @return the range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
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

		List<ImportMedicalDataSetLog> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSetLog>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSetLog importMedicalDataSetLog : list) {
					if (!Objects.equals(uuid, importMedicalDataSetLog.getUuid()) ||
							(companyId != importMedicalDataSetLog.getCompanyId())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);

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
				query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
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
					list = (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
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
	 * Returns the first import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (importMedicalDataSetLog != null) {
			return importMedicalDataSetLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetLogException(msg.toString());
	}

	/**
	 * Returns the first import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		List<ImportMedicalDataSetLog> list = findByUuid_C(uuid, companyId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (importMedicalDataSetLog != null) {
			return importMedicalDataSetLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetLogException(msg.toString());
	}

	/**
	 * Returns the last import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSetLog> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data set logs before and after the current import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param importMedicalDataSetLogId the primary key of the current import medical data set log
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog[] findByUuid_C_PrevAndNext(
		long importMedicalDataSetLogId, String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = findByPrimaryKey(importMedicalDataSetLogId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetLog[] array = new ImportMedicalDataSetLogImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session,
					importMedicalDataSetLog, uuid, companyId,
					orderByComparator, true);

			array[1] = importMedicalDataSetLog;

			array[2] = getByUuid_C_PrevAndNext(session,
					importMedicalDataSetLog, uuid, companyId,
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

	protected ImportMedicalDataSetLog getByUuid_C_PrevAndNext(Session session,
		ImportMedicalDataSetLog importMedicalDataSetLog, String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);

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
			query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSetLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSetLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data set logs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ImportMedicalDataSetLog importMedicalDataSetLog : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importMedicalDataSetLog);
		}
	}

	/**
	 * Returns the number of import medical data set logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching import medical data set logs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASETLOG_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "importMedicalDataSetLog.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "importMedicalDataSetLog.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(importMedicalDataSetLog.uuid IS NULL OR importMedicalDataSetLog.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "importMedicalDataSetLog.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ImportMedicalDataSetLogModelImpl.GROUPID_COLUMN_BITMASK |
			ImportMedicalDataSetLogModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the import medical data set logs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set logs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @return the range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByGroupId(long groupId, int start,
		int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByGroupId(long groupId, int start,
		int end, OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByGroupId(long groupId, int start,
		int end, OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
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

		List<ImportMedicalDataSetLog> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSetLog>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSetLog importMedicalDataSetLog : list) {
					if ((groupId != importMedicalDataSetLog.getGroupId())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
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
	 * Returns the first import medical data set log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByGroupId_First(long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = fetchByGroupId_First(groupId,
				orderByComparator);

		if (importMedicalDataSetLog != null) {
			return importMedicalDataSetLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetLogException(msg.toString());
	}

	/**
	 * Returns the first import medical data set log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByGroupId_First(long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		List<ImportMedicalDataSetLog> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByGroupId_Last(long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (importMedicalDataSetLog != null) {
			return importMedicalDataSetLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetLogException(msg.toString());
	}

	/**
	 * Returns the last import medical data set log in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByGroupId_Last(long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSetLog> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data set logs before and after the current import medical data set log in the ordered set where groupId = &#63;.
	 *
	 * @param importMedicalDataSetLogId the primary key of the current import medical data set log
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog[] findByGroupId_PrevAndNext(
		long importMedicalDataSetLogId, long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = findByPrimaryKey(importMedicalDataSetLogId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetLog[] array = new ImportMedicalDataSetLogImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					importMedicalDataSetLog, groupId, orderByComparator, true);

			array[1] = importMedicalDataSetLog;

			array[2] = getByGroupId_PrevAndNext(session,
					importMedicalDataSetLog, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportMedicalDataSetLog getByGroupId_PrevAndNext(
		Session session, ImportMedicalDataSetLog importMedicalDataSetLog,
		long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);

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
			query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSetLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSetLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the import medical data set logs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching import medical data set logs that the user has permission to view
	 */
	@Override
	public List<ImportMedicalDataSetLog> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set logs that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @return the range of matching import medical data set logs that the user has permission to view
	 */
	@Override
	public List<ImportMedicalDataSetLog> filterFindByGroupId(long groupId,
		int start, int end) {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data set logs that the user has permission to view
	 */
	@Override
	public List<ImportMedicalDataSetLog> filterFindByGroupId(long groupId,
		int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
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
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETLOG_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETLOG_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ImportMedicalDataSetLog.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS,
					ImportMedicalDataSetLogImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE,
					ImportMedicalDataSetLogImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
				getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the import medical data set logs before and after the current import medical data set log in the ordered set of import medical data set logs that the user has permission to view where groupId = &#63;.
	 *
	 * @param importMedicalDataSetLogId the primary key of the current import medical data set log
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog[] filterFindByGroupId_PrevAndNext(
		long importMedicalDataSetLogId, long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(importMedicalDataSetLogId,
				groupId, orderByComparator);
		}

		ImportMedicalDataSetLog importMedicalDataSetLog = findByPrimaryKey(importMedicalDataSetLogId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetLog[] array = new ImportMedicalDataSetLogImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session,
					importMedicalDataSetLog, groupId, orderByComparator, true);

			array[1] = importMedicalDataSetLog;

			array[2] = filterGetByGroupId_PrevAndNext(session,
					importMedicalDataSetLog, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportMedicalDataSetLog filterGetByGroupId_PrevAndNext(
		Session session, ImportMedicalDataSetLog importMedicalDataSetLog,
		long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
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

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETLOG_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETLOG_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ImportMedicalDataSetLog.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ImportMedicalDataSetLogImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ImportMedicalDataSetLogImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSetLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSetLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data set logs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ImportMedicalDataSetLog importMedicalDataSetLog : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importMedicalDataSetLog);
		}
	}

	/**
	 * Returns the number of import medical data set logs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching import medical data set logs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASETLOG_WHERE);

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
	 * Returns the number of import medical data set logs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching import medical data set logs that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_IMPORTMEDICALDATASETLOG_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ImportMedicalDataSetLog.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "importMedicalDataSetLog.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS =
		new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByImportMedicalDataSetAndImportStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS =
		new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByImportMedicalDataSetAndImportStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ImportMedicalDataSetLogModelImpl.IMPORTMEDICALDATASETID_COLUMN_BITMASK |
			ImportMedicalDataSetLogModelImpl.IMPORTSTATUS_COLUMN_BITMASK |
			ImportMedicalDataSetLogModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS =
		new FinderPath(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByImportMedicalDataSetAndImportStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 * @return the matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus) {
		return findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
			importStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @return the range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus, int start, int end) {
		return findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
			importStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
			importStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS;
			finderArgs = new Object[] { importMedicalDataSetId, importStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS;
			finderArgs = new Object[] {
					importMedicalDataSetId, importStatus,
					
					start, end, orderByComparator
				};
		}

		List<ImportMedicalDataSetLog> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSetLog>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSetLog importMedicalDataSetLog : list) {
					if ((importMedicalDataSetId != importMedicalDataSetLog.getImportMedicalDataSetId()) ||
							(importStatus != importMedicalDataSetLog.getImportStatus())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);

			query.append(_FINDER_COLUMN_IMPORTMEDICALDATASETANDIMPORTSTATUS_IMPORTMEDICALDATASETID_2);

			query.append(_FINDER_COLUMN_IMPORTMEDICALDATASETANDIMPORTSTATUS_IMPORTSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importMedicalDataSetId);

				qPos.add(importStatus);

				if (!pagination) {
					list = (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
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
	 * Returns the first import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByImportMedicalDataSetAndImportStatus_First(
		long importMedicalDataSetId, int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = fetchByImportMedicalDataSetAndImportStatus_First(importMedicalDataSetId,
				importStatus, orderByComparator);

		if (importMedicalDataSetLog != null) {
			return importMedicalDataSetLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("importMedicalDataSetId=");
		msg.append(importMedicalDataSetId);

		msg.append(", importStatus=");
		msg.append(importStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetLogException(msg.toString());
	}

	/**
	 * Returns the first import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByImportMedicalDataSetAndImportStatus_First(
		long importMedicalDataSetId, int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		List<ImportMedicalDataSetLog> list = findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
				importStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByImportMedicalDataSetAndImportStatus_Last(
		long importMedicalDataSetId, int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = fetchByImportMedicalDataSetAndImportStatus_Last(importMedicalDataSetId,
				importStatus, orderByComparator);

		if (importMedicalDataSetLog != null) {
			return importMedicalDataSetLog;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("importMedicalDataSetId=");
		msg.append(importMedicalDataSetId);

		msg.append(", importStatus=");
		msg.append(importStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetLogException(msg.toString());
	}

	/**
	 * Returns the last import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByImportMedicalDataSetAndImportStatus_Last(
		long importMedicalDataSetId, int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		int count = countByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
				importStatus);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSetLog> list = findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
				importStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data set logs before and after the current import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	 *
	 * @param importMedicalDataSetLogId the primary key of the current import medical data set log
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog[] findByImportMedicalDataSetAndImportStatus_PrevAndNext(
		long importMedicalDataSetLogId, long importMedicalDataSetId,
		int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = findByPrimaryKey(importMedicalDataSetLogId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetLog[] array = new ImportMedicalDataSetLogImpl[3];

			array[0] = getByImportMedicalDataSetAndImportStatus_PrevAndNext(session,
					importMedicalDataSetLog, importMedicalDataSetId,
					importStatus, orderByComparator, true);

			array[1] = importMedicalDataSetLog;

			array[2] = getByImportMedicalDataSetAndImportStatus_PrevAndNext(session,
					importMedicalDataSetLog, importMedicalDataSetId,
					importStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportMedicalDataSetLog getByImportMedicalDataSetAndImportStatus_PrevAndNext(
		Session session, ImportMedicalDataSetLog importMedicalDataSetLog,
		long importMedicalDataSetId, int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE);

		query.append(_FINDER_COLUMN_IMPORTMEDICALDATASETANDIMPORTSTATUS_IMPORTMEDICALDATASETID_2);

		query.append(_FINDER_COLUMN_IMPORTMEDICALDATASETANDIMPORTSTATUS_IMPORTSTATUS_2);

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
			query.append(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(importMedicalDataSetId);

		qPos.add(importStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSetLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSetLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63; from the database.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 */
	@Override
	public void removeByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus) {
		for (ImportMedicalDataSetLog importMedicalDataSetLog : findByImportMedicalDataSetAndImportStatus(
				importMedicalDataSetId, importStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(importMedicalDataSetLog);
		}
	}

	/**
	 * Returns the number of import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param importStatus the import status
	 * @return the number of matching import medical data set logs
	 */
	@Override
	public int countByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS;

		Object[] finderArgs = new Object[] { importMedicalDataSetId, importStatus };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASETLOG_WHERE);

			query.append(_FINDER_COLUMN_IMPORTMEDICALDATASETANDIMPORTSTATUS_IMPORTMEDICALDATASETID_2);

			query.append(_FINDER_COLUMN_IMPORTMEDICALDATASETANDIMPORTSTATUS_IMPORTSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importMedicalDataSetId);

				qPos.add(importStatus);

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

	private static final String _FINDER_COLUMN_IMPORTMEDICALDATASETANDIMPORTSTATUS_IMPORTMEDICALDATASETID_2 =
		"importMedicalDataSetLog.importMedicalDataSetId = ? AND ";
	private static final String _FINDER_COLUMN_IMPORTMEDICALDATASETANDIMPORTSTATUS_IMPORTSTATUS_2 =
		"importMedicalDataSetLog.importStatus = ?";

	public ImportMedicalDataSetLogPersistenceImpl() {
		setModelClass(ImportMedicalDataSetLog.class);

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
	 * Caches the import medical data set log in the entity cache if it is enabled.
	 *
	 * @param importMedicalDataSetLog the import medical data set log
	 */
	@Override
	public void cacheResult(ImportMedicalDataSetLog importMedicalDataSetLog) {
		entityCache.putResult(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			importMedicalDataSetLog.getPrimaryKey(), importMedicalDataSetLog);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				importMedicalDataSetLog.getUuid(),
				importMedicalDataSetLog.getGroupId()
			}, importMedicalDataSetLog);

		importMedicalDataSetLog.resetOriginalValues();
	}

	/**
	 * Caches the import medical data set logs in the entity cache if it is enabled.
	 *
	 * @param importMedicalDataSetLogs the import medical data set logs
	 */
	@Override
	public void cacheResult(
		List<ImportMedicalDataSetLog> importMedicalDataSetLogs) {
		for (ImportMedicalDataSetLog importMedicalDataSetLog : importMedicalDataSetLogs) {
			if (entityCache.getResult(
						ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
						ImportMedicalDataSetLogImpl.class,
						importMedicalDataSetLog.getPrimaryKey()) == null) {
				cacheResult(importMedicalDataSetLog);
			}
			else {
				importMedicalDataSetLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all import medical data set logs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImportMedicalDataSetLogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the import medical data set log.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImportMedicalDataSetLog importMedicalDataSetLog) {
		entityCache.removeResult(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			importMedicalDataSetLog.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ImportMedicalDataSetLogModelImpl)importMedicalDataSetLog,
			true);
	}

	@Override
	public void clearCache(
		List<ImportMedicalDataSetLog> importMedicalDataSetLogs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ImportMedicalDataSetLog importMedicalDataSetLog : importMedicalDataSetLogs) {
			entityCache.removeResult(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
				ImportMedicalDataSetLogImpl.class,
				importMedicalDataSetLog.getPrimaryKey());

			clearUniqueFindersCache((ImportMedicalDataSetLogModelImpl)importMedicalDataSetLog,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ImportMedicalDataSetLogModelImpl importMedicalDataSetLogModelImpl) {
		Object[] args = new Object[] {
				importMedicalDataSetLogModelImpl.getUuid(),
				importMedicalDataSetLogModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			importMedicalDataSetLogModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ImportMedicalDataSetLogModelImpl importMedicalDataSetLogModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					importMedicalDataSetLogModelImpl.getUuid(),
					importMedicalDataSetLogModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((importMedicalDataSetLogModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					importMedicalDataSetLogModelImpl.getOriginalUuid(),
					importMedicalDataSetLogModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new import medical data set log with the primary key. Does not add the import medical data set log to the database.
	 *
	 * @param importMedicalDataSetLogId the primary key for the new import medical data set log
	 * @return the new import medical data set log
	 */
	@Override
	public ImportMedicalDataSetLog create(long importMedicalDataSetLogId) {
		ImportMedicalDataSetLog importMedicalDataSetLog = new ImportMedicalDataSetLogImpl();

		importMedicalDataSetLog.setNew(true);
		importMedicalDataSetLog.setPrimaryKey(importMedicalDataSetLogId);

		String uuid = PortalUUIDUtil.generate();

		importMedicalDataSetLog.setUuid(uuid);

		importMedicalDataSetLog.setCompanyId(companyProvider.getCompanyId());

		return importMedicalDataSetLog;
	}

	/**
	 * Removes the import medical data set log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param importMedicalDataSetLogId the primary key of the import medical data set log
	 * @return the import medical data set log that was removed
	 * @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog remove(long importMedicalDataSetLogId)
		throws NoSuchImportMedicalDataSetLogException {
		return remove((Serializable)importMedicalDataSetLogId);
	}

	/**
	 * Removes the import medical data set log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the import medical data set log
	 * @return the import medical data set log that was removed
	 * @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog remove(Serializable primaryKey)
		throws NoSuchImportMedicalDataSetLogException {
		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetLog importMedicalDataSetLog = (ImportMedicalDataSetLog)session.get(ImportMedicalDataSetLogImpl.class,
					primaryKey);

			if (importMedicalDataSetLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImportMedicalDataSetLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(importMedicalDataSetLog);
		}
		catch (NoSuchImportMedicalDataSetLogException nsee) {
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
	protected ImportMedicalDataSetLog removeImpl(
		ImportMedicalDataSetLog importMedicalDataSetLog) {
		importMedicalDataSetLog = toUnwrappedModel(importMedicalDataSetLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(importMedicalDataSetLog)) {
				importMedicalDataSetLog = (ImportMedicalDataSetLog)session.get(ImportMedicalDataSetLogImpl.class,
						importMedicalDataSetLog.getPrimaryKeyObj());
			}

			if (importMedicalDataSetLog != null) {
				session.delete(importMedicalDataSetLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (importMedicalDataSetLog != null) {
			clearCache(importMedicalDataSetLog);
		}

		return importMedicalDataSetLog;
	}

	@Override
	public ImportMedicalDataSetLog updateImpl(
		ImportMedicalDataSetLog importMedicalDataSetLog) {
		importMedicalDataSetLog = toUnwrappedModel(importMedicalDataSetLog);

		boolean isNew = importMedicalDataSetLog.isNew();

		ImportMedicalDataSetLogModelImpl importMedicalDataSetLogModelImpl = (ImportMedicalDataSetLogModelImpl)importMedicalDataSetLog;

		if (Validator.isNull(importMedicalDataSetLog.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			importMedicalDataSetLog.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (importMedicalDataSetLog.getCreateDate() == null)) {
			if (serviceContext == null) {
				importMedicalDataSetLog.setCreateDate(now);
			}
			else {
				importMedicalDataSetLog.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!importMedicalDataSetLogModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				importMedicalDataSetLog.setModifiedDate(now);
			}
			else {
				importMedicalDataSetLog.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (importMedicalDataSetLog.isNew()) {
				session.save(importMedicalDataSetLog);

				importMedicalDataSetLog.setNew(false);
			}
			else {
				importMedicalDataSetLog = (ImportMedicalDataSetLog)session.merge(importMedicalDataSetLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ImportMedicalDataSetLogModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					importMedicalDataSetLogModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					importMedicalDataSetLogModelImpl.getUuid(),
					importMedicalDataSetLogModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { importMedicalDataSetLogModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] {
					importMedicalDataSetLogModelImpl.getImportMedicalDataSetId(),
					importMedicalDataSetLogModelImpl.getImportStatus()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((importMedicalDataSetLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetLogModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { importMedicalDataSetLogModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((importMedicalDataSetLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetLogModelImpl.getOriginalUuid(),
						importMedicalDataSetLogModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						importMedicalDataSetLogModelImpl.getUuid(),
						importMedicalDataSetLogModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((importMedicalDataSetLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetLogModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						importMedicalDataSetLogModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((importMedicalDataSetLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetLogModelImpl.getOriginalImportMedicalDataSetId(),
						importMedicalDataSetLogModelImpl.getOriginalImportStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS,
					args);

				args = new Object[] {
						importMedicalDataSetLogModelImpl.getImportMedicalDataSetId(),
						importMedicalDataSetLogModelImpl.getImportStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASETANDIMPORTSTATUS,
					args);
			}
		}

		entityCache.putResult(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetLogImpl.class,
			importMedicalDataSetLog.getPrimaryKey(), importMedicalDataSetLog,
			false);

		clearUniqueFindersCache(importMedicalDataSetLogModelImpl, false);
		cacheUniqueFindersCache(importMedicalDataSetLogModelImpl);

		importMedicalDataSetLog.resetOriginalValues();

		return importMedicalDataSetLog;
	}

	protected ImportMedicalDataSetLog toUnwrappedModel(
		ImportMedicalDataSetLog importMedicalDataSetLog) {
		if (importMedicalDataSetLog instanceof ImportMedicalDataSetLogImpl) {
			return importMedicalDataSetLog;
		}

		ImportMedicalDataSetLogImpl importMedicalDataSetLogImpl = new ImportMedicalDataSetLogImpl();

		importMedicalDataSetLogImpl.setNew(importMedicalDataSetLog.isNew());
		importMedicalDataSetLogImpl.setPrimaryKey(importMedicalDataSetLog.getPrimaryKey());

		importMedicalDataSetLogImpl.setUuid(importMedicalDataSetLog.getUuid());
		importMedicalDataSetLogImpl.setImportMedicalDataSetLogId(importMedicalDataSetLog.getImportMedicalDataSetLogId());
		importMedicalDataSetLogImpl.setGroupId(importMedicalDataSetLog.getGroupId());
		importMedicalDataSetLogImpl.setCompanyId(importMedicalDataSetLog.getCompanyId());
		importMedicalDataSetLogImpl.setUserId(importMedicalDataSetLog.getUserId());
		importMedicalDataSetLogImpl.setUserName(importMedicalDataSetLog.getUserName());
		importMedicalDataSetLogImpl.setCreateDate(importMedicalDataSetLog.getCreateDate());
		importMedicalDataSetLogImpl.setModifiedDate(importMedicalDataSetLog.getModifiedDate());
		importMedicalDataSetLogImpl.setStatus(importMedicalDataSetLog.getStatus());
		importMedicalDataSetLogImpl.setStatusByUserId(importMedicalDataSetLog.getStatusByUserId());
		importMedicalDataSetLogImpl.setStatusByUserName(importMedicalDataSetLog.getStatusByUserName());
		importMedicalDataSetLogImpl.setStatusDate(importMedicalDataSetLog.getStatusDate());
		importMedicalDataSetLogImpl.setImportMedicalDataSetId(importMedicalDataSetLog.getImportMedicalDataSetId());
		importMedicalDataSetLogImpl.setImportStatus(importMedicalDataSetLog.getImportStatus());
		importMedicalDataSetLogImpl.setImportStatusLog(importMedicalDataSetLog.getImportStatusLog());

		return importMedicalDataSetLogImpl;
	}

	/**
	 * Returns the import medical data set log with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the import medical data set log
	 * @return the import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImportMedicalDataSetLogException {
		ImportMedicalDataSetLog importMedicalDataSetLog = fetchByPrimaryKey(primaryKey);

		if (importMedicalDataSetLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImportMedicalDataSetLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return importMedicalDataSetLog;
	}

	/**
	 * Returns the import medical data set log with the primary key or throws a {@link NoSuchImportMedicalDataSetLogException} if it could not be found.
	 *
	 * @param importMedicalDataSetLogId the primary key of the import medical data set log
	 * @return the import medical data set log
	 * @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog findByPrimaryKey(
		long importMedicalDataSetLogId)
		throws NoSuchImportMedicalDataSetLogException {
		return findByPrimaryKey((Serializable)importMedicalDataSetLogId);
	}

	/**
	 * Returns the import medical data set log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the import medical data set log
	 * @return the import medical data set log, or <code>null</code> if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
				ImportMedicalDataSetLogImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ImportMedicalDataSetLog importMedicalDataSetLog = (ImportMedicalDataSetLog)serializable;

		if (importMedicalDataSetLog == null) {
			Session session = null;

			try {
				session = openSession();

				importMedicalDataSetLog = (ImportMedicalDataSetLog)session.get(ImportMedicalDataSetLogImpl.class,
						primaryKey);

				if (importMedicalDataSetLog != null) {
					cacheResult(importMedicalDataSetLog);
				}
				else {
					entityCache.putResult(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
						ImportMedicalDataSetLogImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
					ImportMedicalDataSetLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return importMedicalDataSetLog;
	}

	/**
	 * Returns the import medical data set log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param importMedicalDataSetLogId the primary key of the import medical data set log
	 * @return the import medical data set log, or <code>null</code> if a import medical data set log with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetLog fetchByPrimaryKey(
		long importMedicalDataSetLogId) {
		return fetchByPrimaryKey((Serializable)importMedicalDataSetLogId);
	}

	@Override
	public Map<Serializable, ImportMedicalDataSetLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ImportMedicalDataSetLog> map = new HashMap<Serializable, ImportMedicalDataSetLog>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ImportMedicalDataSetLog importMedicalDataSetLog = fetchByPrimaryKey(primaryKey);

			if (importMedicalDataSetLog != null) {
				map.put(primaryKey, importMedicalDataSetLog);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
					ImportMedicalDataSetLogImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ImportMedicalDataSetLog)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE_PKS_IN);

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

			for (ImportMedicalDataSetLog importMedicalDataSetLog : (List<ImportMedicalDataSetLog>)q.list()) {
				map.put(importMedicalDataSetLog.getPrimaryKeyObj(),
					importMedicalDataSetLog);

				cacheResult(importMedicalDataSetLog);

				uncachedPrimaryKeys.remove(importMedicalDataSetLog.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ImportMedicalDataSetLogModelImpl.ENTITY_CACHE_ENABLED,
					ImportMedicalDataSetLogImpl.class, primaryKey, nullModel);
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
	 * Returns all the import medical data set logs.
	 *
	 * @return the import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @return the range of import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findAll(int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data set logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import medical data set logs
	 * @param end the upper bound of the range of import medical data set logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of import medical data set logs
	 */
	@Override
	public List<ImportMedicalDataSetLog> findAll(int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
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

		List<ImportMedicalDataSetLog> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSetLog>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_IMPORTMEDICALDATASETLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMPORTMEDICALDATASETLOG;

				if (pagination) {
					sql = sql.concat(ImportMedicalDataSetLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSetLog>)QueryUtil.list(q,
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
	 * Removes all the import medical data set logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ImportMedicalDataSetLog importMedicalDataSetLog : findAll()) {
			remove(importMedicalDataSetLog);
		}
	}

	/**
	 * Returns the number of import medical data set logs.
	 *
	 * @return the number of import medical data set logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IMPORTMEDICALDATASETLOG);

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
		return ImportMedicalDataSetLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the import medical data set log persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ImportMedicalDataSetLogImpl.class.getName());
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
	private static final String _SQL_SELECT_IMPORTMEDICALDATASETLOG = "SELECT importMedicalDataSetLog FROM ImportMedicalDataSetLog importMedicalDataSetLog";
	private static final String _SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE_PKS_IN =
		"SELECT importMedicalDataSetLog FROM ImportMedicalDataSetLog importMedicalDataSetLog WHERE importMedicalDataSetLogId IN (";
	private static final String _SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE = "SELECT importMedicalDataSetLog FROM ImportMedicalDataSetLog importMedicalDataSetLog WHERE ";
	private static final String _SQL_COUNT_IMPORTMEDICALDATASETLOG = "SELECT COUNT(importMedicalDataSetLog) FROM ImportMedicalDataSetLog importMedicalDataSetLog";
	private static final String _SQL_COUNT_IMPORTMEDICALDATASETLOG_WHERE = "SELECT COUNT(importMedicalDataSetLog) FROM ImportMedicalDataSetLog importMedicalDataSetLog WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "importMedicalDataSetLog.importMedicalDataSetLogId";
	private static final String _FILTER_SQL_SELECT_IMPORTMEDICALDATASETLOG_WHERE =
		"SELECT DISTINCT {importMedicalDataSetLog.*} FROM medicaldataset_ImportMedicalDataSetLog importMedicalDataSetLog WHERE ";
	private static final String _FILTER_SQL_SELECT_IMPORTMEDICALDATASETLOG_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {medicaldataset_ImportMedicalDataSetLog.*} FROM (SELECT DISTINCT importMedicalDataSetLog.importMedicalDataSetLogId FROM medicaldataset_ImportMedicalDataSetLog importMedicalDataSetLog WHERE ";
	private static final String _FILTER_SQL_SELECT_IMPORTMEDICALDATASETLOG_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN medicaldataset_ImportMedicalDataSetLog ON TEMP_TABLE.importMedicalDataSetLogId = medicaldataset_ImportMedicalDataSetLog.importMedicalDataSetLogId";
	private static final String _FILTER_SQL_COUNT_IMPORTMEDICALDATASETLOG_WHERE = "SELECT COUNT(DISTINCT importMedicalDataSetLog.importMedicalDataSetLogId) AS COUNT_VALUE FROM medicaldataset_ImportMedicalDataSetLog importMedicalDataSetLog WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "importMedicalDataSetLog";
	private static final String _FILTER_ENTITY_TABLE = "medicaldataset_ImportMedicalDataSetLog";
	private static final String _ORDER_BY_ENTITY_ALIAS = "importMedicalDataSetLog.";
	private static final String _ORDER_BY_ENTITY_TABLE = "medicaldataset_ImportMedicalDataSetLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ImportMedicalDataSetLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ImportMedicalDataSetLog exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ImportMedicalDataSetLogPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}