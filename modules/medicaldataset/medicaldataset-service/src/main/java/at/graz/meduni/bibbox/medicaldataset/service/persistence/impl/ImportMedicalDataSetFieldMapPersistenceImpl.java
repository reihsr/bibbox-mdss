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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetFieldMapException;
import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap;
import at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapImpl;
import at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapModelImpl;
import at.graz.meduni.bibbox.medicaldataset.service.persistence.ImportMedicalDataSetFieldMapPersistence;

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
 * The persistence implementation for the import medical data set field map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetFieldMapPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.ImportMedicalDataSetFieldMapUtil
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetFieldMapPersistenceImpl
	extends BasePersistenceImpl<ImportMedicalDataSetFieldMap>
	implements ImportMedicalDataSetFieldMapPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImportMedicalDataSetFieldMapUtil} to access the import medical data set field map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImportMedicalDataSetFieldMapImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ImportMedicalDataSetFieldMapModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the import medical data set field maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set field maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @return the range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByUuid(String uuid,
		int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator,
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

		List<ImportMedicalDataSetFieldMap> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSetFieldMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : list) {
					if (!Objects.equals(uuid,
								importMedicalDataSetFieldMap.getUuid())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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
				query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
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
					list = (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
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
	 * Returns the first import medical data set field map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByUuid_First(String uuid,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByUuid_First(uuid,
				orderByComparator);

		if (importMedicalDataSetFieldMap != null) {
			return importMedicalDataSetFieldMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetFieldMapException(msg.toString());
	}

	/**
	 * Returns the first import medical data set field map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByUuid_First(String uuid,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		List<ImportMedicalDataSetFieldMap> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set field map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByUuid_Last(String uuid,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByUuid_Last(uuid,
				orderByComparator);

		if (importMedicalDataSetFieldMap != null) {
			return importMedicalDataSetFieldMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetFieldMapException(msg.toString());
	}

	/**
	 * Returns the last import medical data set field map in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByUuid_Last(String uuid,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSetFieldMap> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data set field maps before and after the current import medical data set field map in the ordered set where uuid = &#63;.
	 *
	 * @param importMedicalDataSetFieldMapId the primary key of the current import medical data set field map
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap[] findByUuid_PrevAndNext(
		long importMedicalDataSetFieldMapId, String uuid,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = findByPrimaryKey(importMedicalDataSetFieldMapId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetFieldMap[] array = new ImportMedicalDataSetFieldMapImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					importMedicalDataSetFieldMap, uuid, orderByComparator, true);

			array[1] = importMedicalDataSetFieldMap;

			array[2] = getByUuid_PrevAndNext(session,
					importMedicalDataSetFieldMap, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImportMedicalDataSetFieldMap getByUuid_PrevAndNext(
		Session session,
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap, String uuid,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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
			query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSetFieldMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSetFieldMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data set field maps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importMedicalDataSetFieldMap);
		}
	}

	/**
	 * Returns the number of import medical data set field maps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching import medical data set field maps
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "importMedicalDataSetFieldMap.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "importMedicalDataSetFieldMap.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(importMedicalDataSetFieldMap.uuid IS NULL OR importMedicalDataSetFieldMap.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ImportMedicalDataSetFieldMapModelImpl.UUID_COLUMN_BITMASK |
			ImportMedicalDataSetFieldMapModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the import medical data set field map where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchImportMedicalDataSetFieldMapException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByUUID_G(String uuid, long groupId)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByUUID_G(uuid,
				groupId);

		if (importMedicalDataSetFieldMap == null) {
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

			throw new NoSuchImportMedicalDataSetFieldMapException(msg.toString());
		}

		return importMedicalDataSetFieldMap;
	}

	/**
	 * Returns the import medical data set field map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the import medical data set field map where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByUUID_G(String uuid,
		long groupId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ImportMedicalDataSetFieldMap) {
			ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = (ImportMedicalDataSetFieldMap)result;

			if (!Objects.equals(uuid, importMedicalDataSetFieldMap.getUuid()) ||
					(groupId != importMedicalDataSetFieldMap.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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

				List<ImportMedicalDataSetFieldMap> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = list.get(0);

					result = importMedicalDataSetFieldMap;

					cacheResult(importMedicalDataSetFieldMap);

					if ((importMedicalDataSetFieldMap.getUuid() == null) ||
							!importMedicalDataSetFieldMap.getUuid().equals(uuid) ||
							(importMedicalDataSetFieldMap.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, importMedicalDataSetFieldMap);
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
			return (ImportMedicalDataSetFieldMap)result;
		}
	}

	/**
	 * Removes the import medical data set field map where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the import medical data set field map that was removed
	 */
	@Override
	public ImportMedicalDataSetFieldMap removeByUUID_G(String uuid, long groupId)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = findByUUID_G(uuid,
				groupId);

		return remove(importMedicalDataSetFieldMap);
	}

	/**
	 * Returns the number of import medical data set field maps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching import medical data set field maps
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "importMedicalDataSetFieldMap.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "importMedicalDataSetFieldMap.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(importMedicalDataSetFieldMap.uuid IS NULL OR importMedicalDataSetFieldMap.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "importMedicalDataSetFieldMap.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ImportMedicalDataSetFieldMapModelImpl.UUID_COLUMN_BITMASK |
			ImportMedicalDataSetFieldMapModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the import medical data set field maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByUuid_C(String uuid,
		long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set field maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @return the range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByUuid_C(String uuid,
		long companyId, int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByUuid_C(String uuid,
		long companyId, int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator,
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

		List<ImportMedicalDataSetFieldMap> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSetFieldMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : list) {
					if (!Objects.equals(uuid,
								importMedicalDataSetFieldMap.getUuid()) ||
							(companyId != importMedicalDataSetFieldMap.getCompanyId())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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
				query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
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
					list = (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
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
	 * Returns the first import medical data set field map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (importMedicalDataSetFieldMap != null) {
			return importMedicalDataSetFieldMap;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetFieldMapException(msg.toString());
	}

	/**
	 * Returns the first import medical data set field map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByUuid_C_First(String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		List<ImportMedicalDataSetFieldMap> list = findByUuid_C(uuid, companyId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set field map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (importMedicalDataSetFieldMap != null) {
			return importMedicalDataSetFieldMap;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetFieldMapException(msg.toString());
	}

	/**
	 * Returns the last import medical data set field map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByUuid_C_Last(String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSetFieldMap> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data set field maps before and after the current import medical data set field map in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param importMedicalDataSetFieldMapId the primary key of the current import medical data set field map
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap[] findByUuid_C_PrevAndNext(
		long importMedicalDataSetFieldMapId, String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = findByPrimaryKey(importMedicalDataSetFieldMapId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetFieldMap[] array = new ImportMedicalDataSetFieldMapImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session,
					importMedicalDataSetFieldMap, uuid, companyId,
					orderByComparator, true);

			array[1] = importMedicalDataSetFieldMap;

			array[2] = getByUuid_C_PrevAndNext(session,
					importMedicalDataSetFieldMap, uuid, companyId,
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

	protected ImportMedicalDataSetFieldMap getByUuid_C_PrevAndNext(
		Session session,
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap, String uuid,
		long companyId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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
			query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSetFieldMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSetFieldMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data set field maps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importMedicalDataSetFieldMap);
		}
	}

	/**
	 * Returns the number of import medical data set field maps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching import medical data set field maps
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "importMedicalDataSetFieldMap.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "importMedicalDataSetFieldMap.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(importMedicalDataSetFieldMap.uuid IS NULL OR importMedicalDataSetFieldMap.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "importMedicalDataSetFieldMap.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ImportMedicalDataSetFieldMapModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupId", new String[] { Long.class.getName() });

	/**
	 * Returns all the import medical data set field maps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set field maps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @return the range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByGroupId(long groupId,
		int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByGroupId(long groupId,
		int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByGroupId(long groupId,
		int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator,
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

		List<ImportMedicalDataSetFieldMap> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSetFieldMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : list) {
					if ((groupId != importMedicalDataSetFieldMap.getGroupId())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
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
	 * Returns the first import medical data set field map in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByGroupId_First(long groupId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByGroupId_First(groupId,
				orderByComparator);

		if (importMedicalDataSetFieldMap != null) {
			return importMedicalDataSetFieldMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetFieldMapException(msg.toString());
	}

	/**
	 * Returns the first import medical data set field map in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByGroupId_First(long groupId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		List<ImportMedicalDataSetFieldMap> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set field map in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByGroupId_Last(long groupId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (importMedicalDataSetFieldMap != null) {
			return importMedicalDataSetFieldMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetFieldMapException(msg.toString());
	}

	/**
	 * Returns the last import medical data set field map in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByGroupId_Last(long groupId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSetFieldMap> list = findByGroupId(groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data set field maps before and after the current import medical data set field map in the ordered set where groupId = &#63;.
	 *
	 * @param importMedicalDataSetFieldMapId the primary key of the current import medical data set field map
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap[] findByGroupId_PrevAndNext(
		long importMedicalDataSetFieldMapId, long groupId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = findByPrimaryKey(importMedicalDataSetFieldMapId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetFieldMap[] array = new ImportMedicalDataSetFieldMapImpl[3];

			array[0] = getByGroupId_PrevAndNext(session,
					importMedicalDataSetFieldMap, groupId, orderByComparator,
					true);

			array[1] = importMedicalDataSetFieldMap;

			array[2] = getByGroupId_PrevAndNext(session,
					importMedicalDataSetFieldMap, groupId, orderByComparator,
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

	protected ImportMedicalDataSetFieldMap getByGroupId_PrevAndNext(
		Session session,
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap,
		long groupId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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
			query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSetFieldMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSetFieldMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the import medical data set field maps that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching import medical data set field maps that the user has permission to view
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set field maps that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @return the range of matching import medical data set field maps that the user has permission to view
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> filterFindByGroupId(
		long groupId, int start, int end) {
		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data set field maps that the user has permission to view
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
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
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ImportMedicalDataSetFieldMap.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS,
					ImportMedicalDataSetFieldMapImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE,
					ImportMedicalDataSetFieldMapImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			return (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
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
	 * Returns the import medical data set field maps before and after the current import medical data set field map in the ordered set of import medical data set field maps that the user has permission to view where groupId = &#63;.
	 *
	 * @param importMedicalDataSetFieldMapId the primary key of the current import medical data set field map
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap[] filterFindByGroupId_PrevAndNext(
		long importMedicalDataSetFieldMapId, long groupId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(importMedicalDataSetFieldMapId,
				groupId, orderByComparator);
		}

		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = findByPrimaryKey(importMedicalDataSetFieldMapId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetFieldMap[] array = new ImportMedicalDataSetFieldMapImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(session,
					importMedicalDataSetFieldMap, groupId, orderByComparator,
					true);

			array[1] = importMedicalDataSetFieldMap;

			array[2] = filterGetByGroupId_PrevAndNext(session,
					importMedicalDataSetFieldMap, groupId, orderByComparator,
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

	protected ImportMedicalDataSetFieldMap filterGetByGroupId_PrevAndNext(
		Session session,
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap,
		long groupId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator,
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
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ImportMedicalDataSetFieldMap.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS,
				ImportMedicalDataSetFieldMapImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE,
				ImportMedicalDataSetFieldMapImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSetFieldMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSetFieldMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data set field maps where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importMedicalDataSetFieldMap);
		}
	}

	/**
	 * Returns the number of import medical data set field maps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching import medical data set field maps
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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
	 * Returns the number of import medical data set field maps that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching import medical data set field maps that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				ImportMedicalDataSetFieldMap.class.getName(),
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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "importMedicalDataSetFieldMap.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IMPORTMEDICALDATASET =
		new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByImportMedicalDataSet",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASET =
		new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByImportMedicalDataSet",
			new String[] { Long.class.getName() },
			ImportMedicalDataSetFieldMapModelImpl.IMPORTMEDICALDATASETID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASET = new FinderPath(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByImportMedicalDataSet", new String[] { Long.class.getName() });

	/**
	 * Returns all the import medical data set field maps where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @return the matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByImportMedicalDataSet(
		long importMedicalDataSetId) {
		return findByImportMedicalDataSet(importMedicalDataSetId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set field maps where importMedicalDataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @return the range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end) {
		return findByImportMedicalDataSet(importMedicalDataSetId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps where importMedicalDataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		return findByImportMedicalDataSet(importMedicalDataSetId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps where importMedicalDataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findByImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator,
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

		List<ImportMedicalDataSetFieldMap> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSetFieldMap>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : list) {
					if ((importMedicalDataSetId != importMedicalDataSetFieldMap.getImportMedicalDataSetId())) {
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

			query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

			query.append(_FINDER_COLUMN_IMPORTMEDICALDATASET_IMPORTMEDICALDATASETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(importMedicalDataSetId);

				if (!pagination) {
					list = (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
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
	 * Returns the first import medical data set field map in the ordered set where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByImportMedicalDataSet_First(
		long importMedicalDataSetId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByImportMedicalDataSet_First(importMedicalDataSetId,
				orderByComparator);

		if (importMedicalDataSetFieldMap != null) {
			return importMedicalDataSetFieldMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("importMedicalDataSetId=");
		msg.append(importMedicalDataSetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetFieldMapException(msg.toString());
	}

	/**
	 * Returns the first import medical data set field map in the ordered set where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByImportMedicalDataSet_First(
		long importMedicalDataSetId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		List<ImportMedicalDataSetFieldMap> list = findByImportMedicalDataSet(importMedicalDataSetId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last import medical data set field map in the ordered set where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByImportMedicalDataSet_Last(
		long importMedicalDataSetId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByImportMedicalDataSet_Last(importMedicalDataSetId,
				orderByComparator);

		if (importMedicalDataSetFieldMap != null) {
			return importMedicalDataSetFieldMap;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("importMedicalDataSetId=");
		msg.append(importMedicalDataSetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImportMedicalDataSetFieldMapException(msg.toString());
	}

	/**
	 * Returns the last import medical data set field map in the ordered set where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByImportMedicalDataSet_Last(
		long importMedicalDataSetId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		int count = countByImportMedicalDataSet(importMedicalDataSetId);

		if (count == 0) {
			return null;
		}

		List<ImportMedicalDataSetFieldMap> list = findByImportMedicalDataSet(importMedicalDataSetId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the import medical data set field maps before and after the current import medical data set field map in the ordered set where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetFieldMapId the primary key of the current import medical data set field map
	 * @param importMedicalDataSetId the import medical data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap[] findByImportMedicalDataSet_PrevAndNext(
		long importMedicalDataSetFieldMapId, long importMedicalDataSetId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = findByPrimaryKey(importMedicalDataSetFieldMapId);

		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetFieldMap[] array = new ImportMedicalDataSetFieldMapImpl[3];

			array[0] = getByImportMedicalDataSet_PrevAndNext(session,
					importMedicalDataSetFieldMap, importMedicalDataSetId,
					orderByComparator, true);

			array[1] = importMedicalDataSetFieldMap;

			array[2] = getByImportMedicalDataSet_PrevAndNext(session,
					importMedicalDataSetFieldMap, importMedicalDataSetId,
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

	protected ImportMedicalDataSetFieldMap getByImportMedicalDataSet_PrevAndNext(
		Session session,
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap,
		long importMedicalDataSetId,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator,
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

		query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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
			query.append(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(importMedicalDataSetId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(importMedicalDataSetFieldMap);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImportMedicalDataSetFieldMap> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the import medical data set field maps where importMedicalDataSetId = &#63; from the database.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 */
	@Override
	public void removeByImportMedicalDataSet(long importMedicalDataSetId) {
		for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : findByImportMedicalDataSet(
				importMedicalDataSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(importMedicalDataSetFieldMap);
		}
	}

	/**
	 * Returns the number of import medical data set field maps where importMedicalDataSetId = &#63;.
	 *
	 * @param importMedicalDataSetId the import medical data set ID
	 * @return the number of matching import medical data set field maps
	 */
	@Override
	public int countByImportMedicalDataSet(long importMedicalDataSetId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASET;

		Object[] finderArgs = new Object[] { importMedicalDataSetId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMPORTMEDICALDATASETFIELDMAP_WHERE);

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
		"importMedicalDataSetFieldMap.importMedicalDataSetId = ?";

	public ImportMedicalDataSetFieldMapPersistenceImpl() {
		setModelClass(ImportMedicalDataSetFieldMap.class);

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
	 * Caches the import medical data set field map in the entity cache if it is enabled.
	 *
	 * @param importMedicalDataSetFieldMap the import medical data set field map
	 */
	@Override
	public void cacheResult(
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		entityCache.putResult(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			importMedicalDataSetFieldMap.getPrimaryKey(),
			importMedicalDataSetFieldMap);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				importMedicalDataSetFieldMap.getUuid(),
				importMedicalDataSetFieldMap.getGroupId()
			}, importMedicalDataSetFieldMap);

		importMedicalDataSetFieldMap.resetOriginalValues();
	}

	/**
	 * Caches the import medical data set field maps in the entity cache if it is enabled.
	 *
	 * @param importMedicalDataSetFieldMaps the import medical data set field maps
	 */
	@Override
	public void cacheResult(
		List<ImportMedicalDataSetFieldMap> importMedicalDataSetFieldMaps) {
		for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : importMedicalDataSetFieldMaps) {
			if (entityCache.getResult(
						ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
						ImportMedicalDataSetFieldMapImpl.class,
						importMedicalDataSetFieldMap.getPrimaryKey()) == null) {
				cacheResult(importMedicalDataSetFieldMap);
			}
			else {
				importMedicalDataSetFieldMap.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all import medical data set field maps.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImportMedicalDataSetFieldMapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the import medical data set field map.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		entityCache.removeResult(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			importMedicalDataSetFieldMap.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ImportMedicalDataSetFieldMapModelImpl)importMedicalDataSetFieldMap,
			true);
	}

	@Override
	public void clearCache(
		List<ImportMedicalDataSetFieldMap> importMedicalDataSetFieldMaps) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : importMedicalDataSetFieldMaps) {
			entityCache.removeResult(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
				ImportMedicalDataSetFieldMapImpl.class,
				importMedicalDataSetFieldMap.getPrimaryKey());

			clearUniqueFindersCache((ImportMedicalDataSetFieldMapModelImpl)importMedicalDataSetFieldMap,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ImportMedicalDataSetFieldMapModelImpl importMedicalDataSetFieldMapModelImpl) {
		Object[] args = new Object[] {
				importMedicalDataSetFieldMapModelImpl.getUuid(),
				importMedicalDataSetFieldMapModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			importMedicalDataSetFieldMapModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ImportMedicalDataSetFieldMapModelImpl importMedicalDataSetFieldMapModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					importMedicalDataSetFieldMapModelImpl.getUuid(),
					importMedicalDataSetFieldMapModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((importMedicalDataSetFieldMapModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					importMedicalDataSetFieldMapModelImpl.getOriginalUuid(),
					importMedicalDataSetFieldMapModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new import medical data set field map with the primary key. Does not add the import medical data set field map to the database.
	 *
	 * @param importMedicalDataSetFieldMapId the primary key for the new import medical data set field map
	 * @return the new import medical data set field map
	 */
	@Override
	public ImportMedicalDataSetFieldMap create(
		long importMedicalDataSetFieldMapId) {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = new ImportMedicalDataSetFieldMapImpl();

		importMedicalDataSetFieldMap.setNew(true);
		importMedicalDataSetFieldMap.setPrimaryKey(importMedicalDataSetFieldMapId);

		String uuid = PortalUUIDUtil.generate();

		importMedicalDataSetFieldMap.setUuid(uuid);

		importMedicalDataSetFieldMap.setCompanyId(companyProvider.getCompanyId());

		return importMedicalDataSetFieldMap;
	}

	/**
	 * Removes the import medical data set field map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param importMedicalDataSetFieldMapId the primary key of the import medical data set field map
	 * @return the import medical data set field map that was removed
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap remove(
		long importMedicalDataSetFieldMapId)
		throws NoSuchImportMedicalDataSetFieldMapException {
		return remove((Serializable)importMedicalDataSetFieldMapId);
	}

	/**
	 * Removes the import medical data set field map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the import medical data set field map
	 * @return the import medical data set field map that was removed
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap remove(Serializable primaryKey)
		throws NoSuchImportMedicalDataSetFieldMapException {
		Session session = null;

		try {
			session = openSession();

			ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = (ImportMedicalDataSetFieldMap)session.get(ImportMedicalDataSetFieldMapImpl.class,
					primaryKey);

			if (importMedicalDataSetFieldMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImportMedicalDataSetFieldMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(importMedicalDataSetFieldMap);
		}
		catch (NoSuchImportMedicalDataSetFieldMapException nsee) {
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
	protected ImportMedicalDataSetFieldMap removeImpl(
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		importMedicalDataSetFieldMap = toUnwrappedModel(importMedicalDataSetFieldMap);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(importMedicalDataSetFieldMap)) {
				importMedicalDataSetFieldMap = (ImportMedicalDataSetFieldMap)session.get(ImportMedicalDataSetFieldMapImpl.class,
						importMedicalDataSetFieldMap.getPrimaryKeyObj());
			}

			if (importMedicalDataSetFieldMap != null) {
				session.delete(importMedicalDataSetFieldMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (importMedicalDataSetFieldMap != null) {
			clearCache(importMedicalDataSetFieldMap);
		}

		return importMedicalDataSetFieldMap;
	}

	@Override
	public ImportMedicalDataSetFieldMap updateImpl(
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		importMedicalDataSetFieldMap = toUnwrappedModel(importMedicalDataSetFieldMap);

		boolean isNew = importMedicalDataSetFieldMap.isNew();

		ImportMedicalDataSetFieldMapModelImpl importMedicalDataSetFieldMapModelImpl =
			(ImportMedicalDataSetFieldMapModelImpl)importMedicalDataSetFieldMap;

		if (Validator.isNull(importMedicalDataSetFieldMap.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			importMedicalDataSetFieldMap.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (importMedicalDataSetFieldMap.getCreateDate() == null)) {
			if (serviceContext == null) {
				importMedicalDataSetFieldMap.setCreateDate(now);
			}
			else {
				importMedicalDataSetFieldMap.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!importMedicalDataSetFieldMapModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				importMedicalDataSetFieldMap.setModifiedDate(now);
			}
			else {
				importMedicalDataSetFieldMap.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (importMedicalDataSetFieldMap.isNew()) {
				session.save(importMedicalDataSetFieldMap);

				importMedicalDataSetFieldMap.setNew(false);
			}
			else {
				importMedicalDataSetFieldMap = (ImportMedicalDataSetFieldMap)session.merge(importMedicalDataSetFieldMap);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ImportMedicalDataSetFieldMapModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					importMedicalDataSetFieldMapModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					importMedicalDataSetFieldMapModelImpl.getUuid(),
					importMedicalDataSetFieldMapModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] {
					importMedicalDataSetFieldMapModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] {
					importMedicalDataSetFieldMapModelImpl.getImportMedicalDataSetId()
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
			if ((importMedicalDataSetFieldMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetFieldMapModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						importMedicalDataSetFieldMapModelImpl.getUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((importMedicalDataSetFieldMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetFieldMapModelImpl.getOriginalUuid(),
						importMedicalDataSetFieldMapModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						importMedicalDataSetFieldMapModelImpl.getUuid(),
						importMedicalDataSetFieldMapModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((importMedicalDataSetFieldMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetFieldMapModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						importMedicalDataSetFieldMapModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((importMedicalDataSetFieldMapModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importMedicalDataSetFieldMapModelImpl.getOriginalImportMedicalDataSetId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASET,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASET,
					args);

				args = new Object[] {
						importMedicalDataSetFieldMapModelImpl.getImportMedicalDataSetId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IMPORTMEDICALDATASET,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTMEDICALDATASET,
					args);
			}
		}

		entityCache.putResult(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
			ImportMedicalDataSetFieldMapImpl.class,
			importMedicalDataSetFieldMap.getPrimaryKey(),
			importMedicalDataSetFieldMap, false);

		clearUniqueFindersCache(importMedicalDataSetFieldMapModelImpl, false);
		cacheUniqueFindersCache(importMedicalDataSetFieldMapModelImpl);

		importMedicalDataSetFieldMap.resetOriginalValues();

		return importMedicalDataSetFieldMap;
	}

	protected ImportMedicalDataSetFieldMap toUnwrappedModel(
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		if (importMedicalDataSetFieldMap instanceof ImportMedicalDataSetFieldMapImpl) {
			return importMedicalDataSetFieldMap;
		}

		ImportMedicalDataSetFieldMapImpl importMedicalDataSetFieldMapImpl = new ImportMedicalDataSetFieldMapImpl();

		importMedicalDataSetFieldMapImpl.setNew(importMedicalDataSetFieldMap.isNew());
		importMedicalDataSetFieldMapImpl.setPrimaryKey(importMedicalDataSetFieldMap.getPrimaryKey());

		importMedicalDataSetFieldMapImpl.setUuid(importMedicalDataSetFieldMap.getUuid());
		importMedicalDataSetFieldMapImpl.setImportMedicalDataSetFieldMapId(importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId());
		importMedicalDataSetFieldMapImpl.setGroupId(importMedicalDataSetFieldMap.getGroupId());
		importMedicalDataSetFieldMapImpl.setCompanyId(importMedicalDataSetFieldMap.getCompanyId());
		importMedicalDataSetFieldMapImpl.setUserId(importMedicalDataSetFieldMap.getUserId());
		importMedicalDataSetFieldMapImpl.setUserName(importMedicalDataSetFieldMap.getUserName());
		importMedicalDataSetFieldMapImpl.setCreateDate(importMedicalDataSetFieldMap.getCreateDate());
		importMedicalDataSetFieldMapImpl.setModifiedDate(importMedicalDataSetFieldMap.getModifiedDate());
		importMedicalDataSetFieldMapImpl.setStatus(importMedicalDataSetFieldMap.getStatus());
		importMedicalDataSetFieldMapImpl.setStatusByUserId(importMedicalDataSetFieldMap.getStatusByUserId());
		importMedicalDataSetFieldMapImpl.setStatusByUserName(importMedicalDataSetFieldMap.getStatusByUserName());
		importMedicalDataSetFieldMapImpl.setStatusDate(importMedicalDataSetFieldMap.getStatusDate());
		importMedicalDataSetFieldMapImpl.setImportMedicalDataSetId(importMedicalDataSetFieldMap.getImportMedicalDataSetId());
		importMedicalDataSetFieldMapImpl.setImportField(importMedicalDataSetFieldMap.getImportField());
		importMedicalDataSetFieldMapImpl.setImportFieldPath(importMedicalDataSetFieldMap.getImportFieldPath());
		importMedicalDataSetFieldMapImpl.setSampleValue(importMedicalDataSetFieldMap.getSampleValue());
		importMedicalDataSetFieldMapImpl.setTableName(importMedicalDataSetFieldMap.getTableName());
		importMedicalDataSetFieldMapImpl.setTableField(importMedicalDataSetFieldMap.getTableField());

		return importMedicalDataSetFieldMapImpl;
	}

	/**
	 * Returns the import medical data set field map with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the import medical data set field map
	 * @return the import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchImportMedicalDataSetFieldMapException {
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByPrimaryKey(primaryKey);

		if (importMedicalDataSetFieldMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImportMedicalDataSetFieldMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return importMedicalDataSetFieldMap;
	}

	/**
	 * Returns the import medical data set field map with the primary key or throws a {@link NoSuchImportMedicalDataSetFieldMapException} if it could not be found.
	 *
	 * @param importMedicalDataSetFieldMapId the primary key of the import medical data set field map
	 * @return the import medical data set field map
	 * @throws NoSuchImportMedicalDataSetFieldMapException if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap findByPrimaryKey(
		long importMedicalDataSetFieldMapId)
		throws NoSuchImportMedicalDataSetFieldMapException {
		return findByPrimaryKey((Serializable)importMedicalDataSetFieldMapId);
	}

	/**
	 * Returns the import medical data set field map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the import medical data set field map
	 * @return the import medical data set field map, or <code>null</code> if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
				ImportMedicalDataSetFieldMapImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = (ImportMedicalDataSetFieldMap)serializable;

		if (importMedicalDataSetFieldMap == null) {
			Session session = null;

			try {
				session = openSession();

				importMedicalDataSetFieldMap = (ImportMedicalDataSetFieldMap)session.get(ImportMedicalDataSetFieldMapImpl.class,
						primaryKey);

				if (importMedicalDataSetFieldMap != null) {
					cacheResult(importMedicalDataSetFieldMap);
				}
				else {
					entityCache.putResult(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
						ImportMedicalDataSetFieldMapImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
					ImportMedicalDataSetFieldMapImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return importMedicalDataSetFieldMap;
	}

	/**
	 * Returns the import medical data set field map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param importMedicalDataSetFieldMapId the primary key of the import medical data set field map
	 * @return the import medical data set field map, or <code>null</code> if a import medical data set field map with the primary key could not be found
	 */
	@Override
	public ImportMedicalDataSetFieldMap fetchByPrimaryKey(
		long importMedicalDataSetFieldMapId) {
		return fetchByPrimaryKey((Serializable)importMedicalDataSetFieldMapId);
	}

	@Override
	public Map<Serializable, ImportMedicalDataSetFieldMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ImportMedicalDataSetFieldMap> map = new HashMap<Serializable, ImportMedicalDataSetFieldMap>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = fetchByPrimaryKey(primaryKey);

			if (importMedicalDataSetFieldMap != null) {
				map.put(primaryKey, importMedicalDataSetFieldMap);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
					ImportMedicalDataSetFieldMapImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(ImportMedicalDataSetFieldMap)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE_PKS_IN);

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

			for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : (List<ImportMedicalDataSetFieldMap>)q.list()) {
				map.put(importMedicalDataSetFieldMap.getPrimaryKeyObj(),
					importMedicalDataSetFieldMap);

				cacheResult(importMedicalDataSetFieldMap);

				uncachedPrimaryKeys.remove(importMedicalDataSetFieldMap.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ImportMedicalDataSetFieldMapModelImpl.ENTITY_CACHE_ENABLED,
					ImportMedicalDataSetFieldMapImpl.class, primaryKey,
					nullModel);
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
	 * Returns all the import medical data set field maps.
	 *
	 * @return the import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the import medical data set field maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @return the range of import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findAll(int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the import medical data set field maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of import medical data set field maps
	 * @param end the upper bound of the range of import medical data set field maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of import medical data set field maps
	 */
	@Override
	public List<ImportMedicalDataSetFieldMap> findAll(int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator,
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

		List<ImportMedicalDataSetFieldMap> list = null;

		if (retrieveFromCache) {
			list = (List<ImportMedicalDataSetFieldMap>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP;

				if (pagination) {
					sql = sql.concat(ImportMedicalDataSetFieldMapModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImportMedicalDataSetFieldMap>)QueryUtil.list(q,
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
	 * Removes all the import medical data set field maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap : findAll()) {
			remove(importMedicalDataSetFieldMap);
		}
	}

	/**
	 * Returns the number of import medical data set field maps.
	 *
	 * @return the number of import medical data set field maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IMPORTMEDICALDATASETFIELDMAP);

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
		return ImportMedicalDataSetFieldMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the import medical data set field map persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ImportMedicalDataSetFieldMapImpl.class.getName());
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
	private static final String _SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP = "SELECT importMedicalDataSetFieldMap FROM ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap";
	private static final String _SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE_PKS_IN =
		"SELECT importMedicalDataSetFieldMap FROM ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap WHERE importMedicalDataSetFieldMapId IN (";
	private static final String _SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE = "SELECT importMedicalDataSetFieldMap FROM ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap WHERE ";
	private static final String _SQL_COUNT_IMPORTMEDICALDATASETFIELDMAP = "SELECT COUNT(importMedicalDataSetFieldMap) FROM ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap";
	private static final String _SQL_COUNT_IMPORTMEDICALDATASETFIELDMAP_WHERE = "SELECT COUNT(importMedicalDataSetFieldMap) FROM ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "importMedicalDataSetFieldMap.importMedicalDataSetFieldMapId";
	private static final String _FILTER_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_WHERE =
		"SELECT DISTINCT {importMedicalDataSetFieldMap.*} FROM FOO_ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap WHERE ";
	private static final String _FILTER_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {FOO_ImportMedicalDataSetFieldMap.*} FROM (SELECT DISTINCT importMedicalDataSetFieldMap.importMedicalDataSetFieldMapId FROM FOO_ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap WHERE ";
	private static final String _FILTER_SQL_SELECT_IMPORTMEDICALDATASETFIELDMAP_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN FOO_ImportMedicalDataSetFieldMap ON TEMP_TABLE.importMedicalDataSetFieldMapId = FOO_ImportMedicalDataSetFieldMap.importMedicalDataSetFieldMapId";
	private static final String _FILTER_SQL_COUNT_IMPORTMEDICALDATASETFIELDMAP_WHERE =
		"SELECT COUNT(DISTINCT importMedicalDataSetFieldMap.importMedicalDataSetFieldMapId) AS COUNT_VALUE FROM FOO_ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "importMedicalDataSetFieldMap";
	private static final String _FILTER_ENTITY_TABLE = "FOO_ImportMedicalDataSetFieldMap";
	private static final String _ORDER_BY_ENTITY_ALIAS = "importMedicalDataSetFieldMap.";
	private static final String _ORDER_BY_ENTITY_TABLE = "FOO_ImportMedicalDataSetFieldMap.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ImportMedicalDataSetFieldMap exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ImportMedicalDataSetFieldMap exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ImportMedicalDataSetFieldMapPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}