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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetException;
import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet;
import at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetImpl;
import at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetModelImpl;
import at.graz.meduni.bibbox.medicaldataset.service.persistence.ImportMedicalDataSetPersistence;

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
 * The persistence implementation for the import medical data set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.ImportMedicalDataSetUtil
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetPersistenceImpl extends BasePersistenceImpl<ImportMedicalDataSet>
	implements ImportMedicalDataSetPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImportMedicalDataSetUtil} to access the import medical data set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImportMedicalDataSetImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ImportMedicalDataSetModelImpl.UUID_COLUMN_BITMASK |
			ImportMedicalDataSetModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the import medical data sets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @return the range of matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByUuid(String uuid, int start,
		int end, OrderByComparator<ImportMedicalDataSet> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByUuid(String uuid, int start,
		int end, OrderByComparator<ImportMedicalDataSet> orderByComparator,
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

		List<ImportMedicalDataSet> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSet>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSet importMedicalDataSet : list) {
					if (!Objects.equals(uuid, importMedicalDataSet.getUuid())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASET_WHERE);

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
				query.append(ImportMedicalDataSetModelImpl.ORDER_BY_JPQL);
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
					list = (List<ImportMedicalDataSet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSet>)QueryUtil.list(q,
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
	 * Returns the first import medical data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet findByUuid_First(String uuid,
		OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = fetchByUuid_First(uuid,
				orderByComparator);

		if (importMedicalDataSet != null) {
			return importMedicalDataSet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetException(msg.toString());
	}

	/**
	 * Returns the first import medical data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet fetchByUuid_First(String uuid,
		OrderByComparator<ImportMedicalDataSet> orderByComparator) {
		List<ImportMedicalDataSet> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet findByUuid_Last(String uuid,
		OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = fetchByUuid_Last(uuid,
				orderByComparator);

		if (importMedicalDataSet != null) {
			return importMedicalDataSet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetException(msg.toString());
	}

	/**
	 * Returns the last import medical data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet fetchByUuid_Last(String uuid,
		OrderByComparator<ImportMedicalDataSet> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSet> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data sets before and after the current import medical data set in the ordered set where uuid = &#63;.
	 *
	 * @param importMedicalDataSetId the primary key of the current import medical data set
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSet[] findByUuid_PrevAndNext(
		long importMedicalDataSetId, String uuid,
		OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = findByPrimaryKey(importMedicalDataSetId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSet[] array = new ImportMedicalDataSetImpl[3];

			array[0] = getByUuid_PrevAndNext(session, importMedicalDataSet,
					uuid, orderByComparator, true);

			array[1] = importMedicalDataSet;

			array[2] = getByUuid_PrevAndNext(session, importMedicalDataSet,
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

	protected ImportMedicalDataSet getByUuid_PrevAndNext(Session session,
		ImportMedicalDataSet importMedicalDataSet, String uuid,
		OrderByComparator<ImportMedicalDataSet> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASET_WHERE);

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
			query.append(ImportMedicalDataSetModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data sets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ImportMedicalDataSet importMedicalDataSet : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importMedicalDataSet);
		}
	}

	/**
	 * Returns the number of import medical data sets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching import medical data sets
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "importMedicalDataSet.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "importMedicalDataSet.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(importMedicalDataSet.uuid IS NULL OR importMedicalDataSet.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ImportMedicalDataSetModelImpl.UUID_COLUMN_BITMASK |
			ImportMedicalDataSetModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the import medical data set where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchImportMedicalDataSetException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet findByUUID_G(String uuid, long groupId)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = fetchByUUID_G(uuid, groupId);

		if (importMedicalDataSet == null) {
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

			throw new NoSuchImportMedicalDataSetException(msg.toString());
		}

		return importMedicalDataSet;
	}

	/**
	 * Returns the import medical data set where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the import medical data set where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ImportMedicalDataSet) {
			ImportMedicalDataSet importMedicalDataSet = (ImportMedicalDataSet)result;

			if (!Objects.equals(uuid, importMedicalDataSet.getUuid()) ||
					(groupId != importMedicalDataSet.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_IMPORTMEDICALDATASET_WHERE);

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

				List<ImportMedicalDataSet> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ImportMedicalDataSet importMedicalDataSet = list.get(0);

					result = importMedicalDataSet;

					cacheResult(importMedicalDataSet);

					if ((importMedicalDataSet.getUuid() == null) ||
							!importMedicalDataSet.getUuid().equals(uuid) ||
							(importMedicalDataSet.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, importMedicalDataSet);
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
			return (ImportMedicalDataSet)result;
		}
	}

	/**
	 * Removes the import medical data set where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the import medical data set that was removed
	 */
	@Override
	public ImportMedicalDataSet removeByUUID_G(String uuid, long groupId)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = findByUUID_G(uuid, groupId);

		return remove(importMedicalDataSet);
	}

	/**
	 * Returns the number of import medical data sets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching import medical data sets
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "importMedicalDataSet.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "importMedicalDataSet.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(importMedicalDataSet.uuid IS NULL OR importMedicalDataSet.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "importMedicalDataSet.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ImportMedicalDataSetModelImpl.UUID_COLUMN_BITMASK |
			ImportMedicalDataSetModelImpl.COMPANYID_COLUMN_BITMASK |
			ImportMedicalDataSetModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the import medical data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @return the range of matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<ImportMedicalDataSet> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<ImportMedicalDataSet> orderByComparator,
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

		List<ImportMedicalDataSet> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSet>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSet importMedicalDataSet : list) {
					if (!Objects.equals(uuid, importMedicalDataSet.getUuid()) ||
							(companyId != importMedicalDataSet.getCompanyId())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASET_WHERE);

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
				query.append(ImportMedicalDataSetModelImpl.ORDER_BY_JPQL);
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
					list = (List<ImportMedicalDataSet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSet>)QueryUtil.list(q,
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
	 * Returns the first import medical data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (importMedicalDataSet != null) {
			return importMedicalDataSet;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetException(msg.toString());
	}

	/**
	 * Returns the first import medical data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet fetchByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator) {
		List<ImportMedicalDataSet> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (importMedicalDataSet != null) {
			return importMedicalDataSet;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetException(msg.toString());
	}

	/**
	 * Returns the last import medical data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSet> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data sets before and after the current import medical data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param importMedicalDataSetId the primary key of the current import medical data set
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSet[] findByUuid_C_PrevAndNext(
		long importMedicalDataSetId, String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = findByPrimaryKey(importMedicalDataSetId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSet[] array = new ImportMedicalDataSetImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, importMedicalDataSet,
					uuid, companyId, orderByComparator, true);

			array[1] = importMedicalDataSet;

			array[2] = getByUuid_C_PrevAndNext(session, importMedicalDataSet,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportMedicalDataSet getByUuid_C_PrevAndNext(Session session,
		ImportMedicalDataSet importMedicalDataSet, String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASET_WHERE);

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
			query.append(ImportMedicalDataSetModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data sets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ImportMedicalDataSet importMedicalDataSet : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importMedicalDataSet);
		}
	}

	/**
	 * Returns the number of import medical data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching import medical data sets
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASET_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "importMedicalDataSet.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "importMedicalDataSet.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(importMedicalDataSet.uuid IS NULL OR importMedicalDataSet.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "importMedicalDataSet.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ImportMedicalDataSetModelImpl.GROUPID_COLUMN_BITMASK |
			ImportMedicalDataSetModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the import medical data sets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @return the range of matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByGroupId(long groupId, int start,
		int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByGroupId(long groupId, int start,
		int end, OrderByComparator<ImportMedicalDataSet> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findByGroupId(long groupId, int start,
		int end, OrderByComparator<ImportMedicalDataSet> orderByComparator,
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

		List<ImportMedicalDataSet> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSet>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSet importMedicalDataSet : list) {
					if ((groupId != importMedicalDataSet.getGroupId())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASET_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImportMedicalDataSetModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ImportMedicalDataSet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSet>)QueryUtil.list(q,
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
	 * Returns the first import medical data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet findByGroupId_First(long groupId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = fetchByGroupId_First(groupId,
				orderByComparator);

		if (importMedicalDataSet != null) {
			return importMedicalDataSet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetException(msg.toString());
	}

	/**
	 * Returns the first import medical data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet fetchByGroupId_First(long groupId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator) {
		List<ImportMedicalDataSet> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet findByGroupId_Last(long groupId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (importMedicalDataSet != null) {
			return importMedicalDataSet;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetException(msg.toString());
	}

	/**
	 * Returns the last import medical data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	 */
	@Override
	public ImportMedicalDataSet fetchByGroupId_Last(long groupId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSet> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data sets before and after the current import medical data set in the ordered set where groupId = &#63;.
	 *
	 * @param importMedicalDataSetId the primary key of the current import medical data set
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSet[] findByGroupId_PrevAndNext(
		long importMedicalDataSetId, long groupId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = findByPrimaryKey(importMedicalDataSetId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSet[] array = new ImportMedicalDataSetImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, importMedicalDataSet,
					groupId, orderByComparator, true);

			array[1] = importMedicalDataSet;

			array[2] = getByGroupId_PrevAndNext(session, importMedicalDataSet,
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

	protected ImportMedicalDataSet getByGroupId_PrevAndNext(Session session,
		ImportMedicalDataSet importMedicalDataSet, long groupId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASET_WHERE);

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
			query.append(ImportMedicalDataSetModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the import medical data sets that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching import medical data sets that the user has permission to view
	 */
	@Override
	public List<ImportMedicalDataSet> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data sets that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @return the range of matching import medical data sets that the user has permission to view
	 */
	@Override
	public List<ImportMedicalDataSet> filterFindByGroupId(long groupId,
		int start, int end) {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data sets that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data sets that the user has permission to view
	 */
	@Override
	public List<ImportMedicalDataSet> filterFindByGroupId(long groupId,
		int start, int end,
		OrderByComparator<ImportMedicalDataSet> orderByComparator) {
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
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASET_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASET_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASET_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ImportMedicalDataSetModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ImportMedicalDataSetModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ImportMedicalDataSet.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, ImportMedicalDataSetImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, ImportMedicalDataSetImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ImportMedicalDataSet>)QueryUtil.list(q, getDialect(),
				start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the import medical data sets before and after the current import medical data set in the ordered set of import medical data sets that the user has permission to view where groupId = &#63;.
	 *
	 * @param importMedicalDataSetId the primary key of the current import medical data set
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSet[] filterFindByGroupId_PrevAndNext(
		long importMedicalDataSetId, long groupId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(importMedicalDataSetId, groupId,
				orderByComparator);
		}

		ImportMedicalDataSet importMedicalDataSet = findByPrimaryKey(importMedicalDataSetId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSet[] array = new ImportMedicalDataSetImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session,
					importMedicalDataSet, groupId, orderByComparator, true);

			array[1] = importMedicalDataSet;

			array[2] = filterGetByGroupId_PrevAndNext(session,
					importMedicalDataSet, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportMedicalDataSet filterGetByGroupId_PrevAndNext(
		Session session, ImportMedicalDataSet importMedicalDataSet,
		long groupId,
		OrderByComparator<ImportMedicalDataSet> orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASET_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASET_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASET_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ImportMedicalDataSetModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ImportMedicalDataSetModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ImportMedicalDataSet.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, ImportMedicalDataSetImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, ImportMedicalDataSetImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSet);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSet> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data sets where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ImportMedicalDataSet importMedicalDataSet : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importMedicalDataSet);
		}
	}

	/**
	 * Returns the number of import medical data sets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching import medical data sets
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASET_WHERE);

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
	 * Returns the number of import medical data sets that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching import medical data sets that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_IMPORTMEDICALDATASET_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ImportMedicalDataSet.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "importMedicalDataSet.groupId = ?";

	public ImportMedicalDataSetPersistenceImpl() {
		setModelClass(ImportMedicalDataSet.class);

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
	 * Caches the import medical data set in the entity cache if it is enabled.
	 *
	 * @param importMedicalDataSet the import medical data set
	 */
	@Override
	public void cacheResult(ImportMedicalDataSet importMedicalDataSet) {
		entityCache.putResult(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class,
			importMedicalDataSet.getPrimaryKey(), importMedicalDataSet);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				importMedicalDataSet.getUuid(),
				importMedicalDataSet.getGroupId()
			}, importMedicalDataSet);

		importMedicalDataSet.resetOriginalValues();
	}

	/**
	 * Caches the import medical data sets in the entity cache if it is enabled.
	 *
	 * @param importMedicalDataSets the import medical data sets
	 */
	@Override
	public void cacheResult(List<ImportMedicalDataSet> importMedicalDataSets) {
		for (ImportMedicalDataSet importMedicalDataSet : importMedicalDataSets) {
			if (entityCache.getResult(
						ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
						ImportMedicalDataSetImpl.class,
						importMedicalDataSet.getPrimaryKey()) == null) {
				cacheResult(importMedicalDataSet);
			}
			else {
				importMedicalDataSet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all import medical data sets.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImportMedicalDataSetImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the import medical data set.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImportMedicalDataSet importMedicalDataSet) {
		entityCache.removeResult(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class, importMedicalDataSet.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ImportMedicalDataSetModelImpl)importMedicalDataSet,
			true);
	}

	@Override
	public void clearCache(List<ImportMedicalDataSet> importMedicalDataSets) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ImportMedicalDataSet importMedicalDataSet : importMedicalDataSets) {
			entityCache.removeResult(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
				ImportMedicalDataSetImpl.class,
				importMedicalDataSet.getPrimaryKey());

			clearUniqueFindersCache((ImportMedicalDataSetModelImpl)importMedicalDataSet,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ImportMedicalDataSetModelImpl importMedicalDataSetModelImpl) {
		Object[] args = new Object[] {
				importMedicalDataSetModelImpl.getUuid(),
				importMedicalDataSetModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			importMedicalDataSetModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ImportMedicalDataSetModelImpl importMedicalDataSetModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					importMedicalDataSetModelImpl.getUuid(),
					importMedicalDataSetModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((importMedicalDataSetModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					importMedicalDataSetModelImpl.getOriginalUuid(),
					importMedicalDataSetModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new import medical data set with the primary key. Does not add the import medical data set to the database.
	 *
	 * @param importMedicalDataSetId the primary key for the new import medical data set
	 * @return the new import medical data set
	 */
	@Override
	public ImportMedicalDataSet create(long importMedicalDataSetId) {
		ImportMedicalDataSet importMedicalDataSet = new ImportMedicalDataSetImpl();

		importMedicalDataSet.setNew(true);
		importMedicalDataSet.setPrimaryKey(importMedicalDataSetId);

		String uuid = PortalUUIDUtil.generate();

		importMedicalDataSet.setUuid(uuid);

		importMedicalDataSet.setCompanyId(companyProvider.getCompanyId());

		return importMedicalDataSet;
	}

	/**
	 * Removes the import medical data set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param importMedicalDataSetId the primary key of the import medical data set
	 * @return the import medical data set that was removed
	 * @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSet remove(long importMedicalDataSetId)
		throws NoSuchImportMedicalDataSetException {
		return remove((Serializable)importMedicalDataSetId);
	}

	/**
	 * Removes the import medical data set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the import medical data set
	 * @return the import medical data set that was removed
	 * @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSet remove(Serializable primaryKey)
		throws NoSuchImportMedicalDataSetException {
		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSet importMedicalDataSet = (ImportMedicalDataSet)session.get(ImportMedicalDataSetImpl.class,
					primaryKey);

			if (importMedicalDataSet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImportMedicalDataSetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(importMedicalDataSet);
		}
		catch (NoSuchImportMedicalDataSetException nsee) {
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
	protected ImportMedicalDataSet removeImpl(
		ImportMedicalDataSet importMedicalDataSet) {
		importMedicalDataSet = toUnwrappedModel(importMedicalDataSet);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(importMedicalDataSet)) {
				importMedicalDataSet = (ImportMedicalDataSet)session.get(ImportMedicalDataSetImpl.class,
						importMedicalDataSet.getPrimaryKeyObj());
			}

			if (importMedicalDataSet != null) {
				session.delete(importMedicalDataSet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (importMedicalDataSet != null) {
			clearCache(importMedicalDataSet);
		}

		return importMedicalDataSet;
	}

	@Override
	public ImportMedicalDataSet updateImpl(
		ImportMedicalDataSet importMedicalDataSet) {
		importMedicalDataSet = toUnwrappedModel(importMedicalDataSet);

		boolean isNew = importMedicalDataSet.isNew();

		ImportMedicalDataSetModelImpl importMedicalDataSetModelImpl = (ImportMedicalDataSetModelImpl)importMedicalDataSet;

		if (Validator.isNull(importMedicalDataSet.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			importMedicalDataSet.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (importMedicalDataSet.getCreateDate() == null)) {
			if (serviceContext == null) {
				importMedicalDataSet.setCreateDate(now);
			}
			else {
				importMedicalDataSet.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!importMedicalDataSetModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				importMedicalDataSet.setModifiedDate(now);
			}
			else {
				importMedicalDataSet.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (importMedicalDataSet.isNew()) {
				session.save(importMedicalDataSet);

				importMedicalDataSet.setNew(false);
			}
			else {
				importMedicalDataSet = (ImportMedicalDataSet)session.merge(importMedicalDataSet);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ImportMedicalDataSetModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { importMedicalDataSetModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					importMedicalDataSetModelImpl.getUuid(),
					importMedicalDataSetModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { importMedicalDataSetModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((importMedicalDataSetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { importMedicalDataSetModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((importMedicalDataSetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetModelImpl.getOriginalUuid(),
						importMedicalDataSetModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						importMedicalDataSetModelImpl.getUuid(),
						importMedicalDataSetModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((importMedicalDataSetModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { importMedicalDataSetModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		entityCache.putResult(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetImpl.class,
			importMedicalDataSet.getPrimaryKey(), importMedicalDataSet, false);

		clearUniqueFindersCache(importMedicalDataSetModelImpl, false);
		cacheUniqueFindersCache(importMedicalDataSetModelImpl);

		importMedicalDataSet.resetOriginalValues();

		return importMedicalDataSet;
	}

	protected ImportMedicalDataSet toUnwrappedModel(
		ImportMedicalDataSet importMedicalDataSet) {
		if (importMedicalDataSet instanceof ImportMedicalDataSetImpl) {
			return importMedicalDataSet;
		}

		ImportMedicalDataSetImpl importMedicalDataSetImpl = new ImportMedicalDataSetImpl();

		importMedicalDataSetImpl.setNew(importMedicalDataSet.isNew());
		importMedicalDataSetImpl.setPrimaryKey(importMedicalDataSet.getPrimaryKey());

		importMedicalDataSetImpl.setUuid(importMedicalDataSet.getUuid());
		importMedicalDataSetImpl.setImportMedicalDataSetId(importMedicalDataSet.getImportMedicalDataSetId());
		importMedicalDataSetImpl.setGroupId(importMedicalDataSet.getGroupId());
		importMedicalDataSetImpl.setCompanyId(importMedicalDataSet.getCompanyId());
		importMedicalDataSetImpl.setUserId(importMedicalDataSet.getUserId());
		importMedicalDataSetImpl.setUserName(importMedicalDataSet.getUserName());
		importMedicalDataSetImpl.setCreateDate(importMedicalDataSet.getCreateDate());
		importMedicalDataSetImpl.setModifiedDate(importMedicalDataSet.getModifiedDate());
		importMedicalDataSetImpl.setStatus(importMedicalDataSet.getStatus());
		importMedicalDataSetImpl.setStatusByUserId(importMedicalDataSet.getStatusByUserId());
		importMedicalDataSetImpl.setStatusByUserName(importMedicalDataSet.getStatusByUserName());
		importMedicalDataSetImpl.setStatusDate(importMedicalDataSet.getStatusDate());
		importMedicalDataSetImpl.setImportName(importMedicalDataSet.getImportName());
		importMedicalDataSetImpl.setImportType(importMedicalDataSet.getImportType());
		importMedicalDataSetImpl.setImiJobId(importMedicalDataSet.getImiJobId());
		importMedicalDataSetImpl.setDescription(importMedicalDataSet.getDescription());
		importMedicalDataSetImpl.setFileName(importMedicalDataSet.getFileName());
		importMedicalDataSetImpl.setFilePath(importMedicalDataSet.getFilePath());
		importMedicalDataSetImpl.setFileId(importMedicalDataSet.getFileId());
		importMedicalDataSetImpl.setImportCount(importMedicalDataSet.getImportCount());
		importMedicalDataSetImpl.setImportStatus(importMedicalDataSet.getImportStatus());

		return importMedicalDataSetImpl;
	}

	/**
	 * Returns the import medical data set with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the import medical data set
	 * @return the import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImportMedicalDataSetException {
		ImportMedicalDataSet importMedicalDataSet = fetchByPrimaryKey(primaryKey);

		if (importMedicalDataSet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImportMedicalDataSetException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return importMedicalDataSet;
	}

	/**
	 * Returns the import medical data set with the primary key or throws a {@link NoSuchImportMedicalDataSetException} if it could not be found.
	 *
	 * @param importMedicalDataSetId the primary key of the import medical data set
	 * @return the import medical data set
	 * @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSet findByPrimaryKey(long importMedicalDataSetId)
		throws NoSuchImportMedicalDataSetException {
		return findByPrimaryKey((Serializable)importMedicalDataSetId);
	}

	/**
	 * Returns the import medical data set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the import medical data set
	 * @return the import medical data set, or <code>null</code> if a import medical data set with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSet fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
				ImportMedicalDataSetImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ImportMedicalDataSet importMedicalDataSet = (ImportMedicalDataSet)serializable;

		if (importMedicalDataSet == null) {
			Session session = null;

			try {
				session = openSession();

				importMedicalDataSet = (ImportMedicalDataSet)session.get(ImportMedicalDataSetImpl.class,
						primaryKey);

				if (importMedicalDataSet != null) {
					cacheResult(importMedicalDataSet);
				}
				else {
					entityCache.putResult(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
						ImportMedicalDataSetImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
					ImportMedicalDataSetImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return importMedicalDataSet;
	}

	/**
	 * Returns the import medical data set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param importMedicalDataSetId the primary key of the import medical data set
	 * @return the import medical data set, or <code>null</code> if a import medical data set with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSet fetchByPrimaryKey(long importMedicalDataSetId) {
		return fetchByPrimaryKey((Serializable)importMedicalDataSetId);
	}

	@Override
	public Map<Serializable, ImportMedicalDataSet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ImportMedicalDataSet> map = new HashMap<Serializable, ImportMedicalDataSet>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ImportMedicalDataSet importMedicalDataSet = fetchByPrimaryKey(primaryKey);

			if (importMedicalDataSet != null) {
				map.put(primaryKey, importMedicalDataSet);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
					ImportMedicalDataSetImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ImportMedicalDataSet)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_IMPORTMEDICALDATASET_WHERE_PKS_IN);

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

			for (ImportMedicalDataSet importMedicalDataSet : (List<ImportMedicalDataSet>)q.list()) {
				map.put(importMedicalDataSet.getPrimaryKeyObj(),
					importMedicalDataSet);

				cacheResult(importMedicalDataSet);

				uncachedPrimaryKeys.remove(importMedicalDataSet.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ImportMedicalDataSetModelImpl.ENTITY_CACHE_ENABLED,
					ImportMedicalDataSetImpl.class, primaryKey, nullModel);
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
	 * Returns all the import medical data sets.
	 *
	 * @return the import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @return the range of import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findAll(int start, int end,
		OrderByComparator<ImportMedicalDataSet> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import medical data sets
	 * @param end the upper bound of the range of import medical data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of import medical data sets
	 */
	@Override
	public List<ImportMedicalDataSet> findAll(int start, int end,
		OrderByComparator<ImportMedicalDataSet> orderByComparator,
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

		List<ImportMedicalDataSet> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSet>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_IMPORTMEDICALDATASET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMPORTMEDICALDATASET;

				if (pagination) {
					sql = sql.concat(ImportMedicalDataSetModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ImportMedicalDataSet>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSet>)QueryUtil.list(q,
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
	 * Removes all the import medical data sets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ImportMedicalDataSet importMedicalDataSet : findAll()) {
			remove(importMedicalDataSet);
		}
	}

	/**
	 * Returns the number of import medical data sets.
	 *
	 * @return the number of import medical data sets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IMPORTMEDICALDATASET);

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
		return ImportMedicalDataSetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the import medical data set persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ImportMedicalDataSetImpl.class.getName());
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
	private static final String _SQL_SELECT_IMPORTMEDICALDATASET = "SELECT importMedicalDataSet FROM ImportMedicalDataSet importMedicalDataSet";
	private static final String _SQL_SELECT_IMPORTMEDICALDATASET_WHERE_PKS_IN = "SELECT importMedicalDataSet FROM ImportMedicalDataSet importMedicalDataSet WHERE importMedicalDataSetId IN (";
	private static final String _SQL_SELECT_IMPORTMEDICALDATASET_WHERE = "SELECT importMedicalDataSet FROM ImportMedicalDataSet importMedicalDataSet WHERE ";
	private static final String _SQL_COUNT_IMPORTMEDICALDATASET = "SELECT COUNT(importMedicalDataSet) FROM ImportMedicalDataSet importMedicalDataSet";
	private static final String _SQL_COUNT_IMPORTMEDICALDATASET_WHERE = "SELECT COUNT(importMedicalDataSet) FROM ImportMedicalDataSet importMedicalDataSet WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "importMedicalDataSet.importMedicalDataSetId";
	private static final String _FILTER_SQL_SELECT_IMPORTMEDICALDATASET_WHERE = "SELECT DISTINCT {importMedicalDataSet.*} FROM medicaldataset_ImportMedicalDataSet importMedicalDataSet WHERE ";
	private static final String _FILTER_SQL_SELECT_IMPORTMEDICALDATASET_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {medicaldataset_ImportMedicalDataSet.*} FROM (SELECT DISTINCT importMedicalDataSet.importMedicalDataSetId FROM medicaldataset_ImportMedicalDataSet importMedicalDataSet WHERE ";
	private static final String _FILTER_SQL_SELECT_IMPORTMEDICALDATASET_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN medicaldataset_ImportMedicalDataSet ON TEMP_TABLE.importMedicalDataSetId = medicaldataset_ImportMedicalDataSet.importMedicalDataSetId";
	private static final String _FILTER_SQL_COUNT_IMPORTMEDICALDATASET_WHERE = "SELECT COUNT(DISTINCT importMedicalDataSet.importMedicalDataSetId) AS COUNT_VALUE FROM medicaldataset_ImportMedicalDataSet importMedicalDataSet WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "importMedicalDataSet";
	private static final String _FILTER_ENTITY_TABLE = "medicaldataset_ImportMedicalDataSet";
	private static final String _ORDER_BY_ENTITY_ALIAS = "importMedicalDataSet.";
	private static final String _ORDER_BY_ENTITY_TABLE = "medicaldataset_ImportMedicalDataSet.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ImportMedicalDataSet exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ImportMedicalDataSet exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ImportMedicalDataSetPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}