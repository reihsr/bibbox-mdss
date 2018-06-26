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

package at.graz.meduni.bibbox.medicaldataset.service.persistence;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the import medical data set log service. This utility wraps {@link at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.ImportMedicalDataSetLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLogPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.ImportMedicalDataSetLogPersistenceImpl
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetLogUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		ImportMedicalDataSetLog importMedicalDataSetLog) {
		getPersistence().clearCache(importMedicalDataSetLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ImportMedicalDataSetLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ImportMedicalDataSetLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ImportMedicalDataSetLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ImportMedicalDataSetLog update(
		ImportMedicalDataSetLog importMedicalDataSetLog) {
		return getPersistence().update(importMedicalDataSetLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ImportMedicalDataSetLog update(
		ImportMedicalDataSetLog importMedicalDataSetLog,
		ServiceContext serviceContext) {
		return getPersistence().update(importMedicalDataSetLog, serviceContext);
	}

	/**
	* Returns all the import medical data set logs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching import medical data set logs
	*/
	public static List<ImportMedicalDataSetLog> findByUuid(
		java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<ImportMedicalDataSetLog> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<ImportMedicalDataSetLog> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<ImportMedicalDataSetLog> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first import medical data set log in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog findByUuid_First(
		java.lang.String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first import medical data set log in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog fetchByUuid_First(
		java.lang.String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last import medical data set log in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog findByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last import medical data set log in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog fetchByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static ImportMedicalDataSetLog[] findByUuid_PrevAndNext(
		long importMedicalDataSetLogId, java.lang.String uuid,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence()
				   .findByUuid_PrevAndNext(importMedicalDataSetLogId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the import medical data set logs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of import medical data set logs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching import medical data set logs
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the import medical data set log where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchImportMedicalDataSetLogException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog findByUUID_G(java.lang.String uuid,
		long groupId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the import medical data set log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the import medical data set log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the import medical data set log where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the import medical data set log that was removed
	*/
	public static ImportMedicalDataSetLog removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of import medical data set logs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching import medical data set logs
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the import medical data set logs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching import medical data set logs
	*/
	public static List<ImportMedicalDataSetLog> findByUuid_C(
		java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<ImportMedicalDataSetLog> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<ImportMedicalDataSetLog> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
	public static List<ImportMedicalDataSetLog> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
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
	public static ImportMedicalDataSetLog findByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
	public static ImportMedicalDataSetLog findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
	public static ImportMedicalDataSetLog[] findByUuid_C_PrevAndNext(
		long importMedicalDataSetLogId, java.lang.String uuid, long companyId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(importMedicalDataSetLogId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the import medical data set logs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of import medical data set logs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching import medical data set logs
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the import medical data set logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching import medical data set logs
	*/
	public static List<ImportMedicalDataSetLog> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
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
	public static List<ImportMedicalDataSetLog> findByGroupId(long groupId,
		int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
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
	public static List<ImportMedicalDataSetLog> findByGroupId(long groupId,
		int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
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
	public static List<ImportMedicalDataSetLog> findByGroupId(long groupId,
		int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first import medical data set log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog findByGroupId_First(long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first import medical data set log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog fetchByGroupId_First(long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last import medical data set log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog findByGroupId_Last(long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last import medical data set log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog fetchByGroupId_Last(long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
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
	public static ImportMedicalDataSetLog[] findByGroupId_PrevAndNext(
		long importMedicalDataSetLogId, long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(importMedicalDataSetLogId,
			groupId, orderByComparator);
	}

	/**
	* Returns all the import medical data set logs that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching import medical data set logs that the user has permission to view
	*/
	public static List<ImportMedicalDataSetLog> filterFindByGroupId(
		long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
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
	public static List<ImportMedicalDataSetLog> filterFindByGroupId(
		long groupId, int start, int end) {
		return getPersistence().filterFindByGroupId(groupId, start, end);
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
	public static List<ImportMedicalDataSetLog> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
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
	public static ImportMedicalDataSetLog[] filterFindByGroupId_PrevAndNext(
		long importMedicalDataSetLogId, long groupId,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(importMedicalDataSetLogId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the import medical data set logs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of import medical data set logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching import medical data set logs
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of import medical data set logs that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching import medical data set logs that the user has permission to view
	*/
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63;.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	* @return the matching import medical data set logs
	*/
	public static List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus) {
		return getPersistence()
				   .findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
			importStatus);
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
	public static List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus, int start, int end) {
		return getPersistence()
				   .findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
			importStatus, start, end);
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
	public static List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence()
				   .findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
			importStatus, start, end, orderByComparator);
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
	public static List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus, int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
			importStatus, start, end, orderByComparator, retrieveFromCache);
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
	public static ImportMedicalDataSetLog findByImportMedicalDataSetAndImportStatus_First(
		long importMedicalDataSetId, int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence()
				   .findByImportMedicalDataSetAndImportStatus_First(importMedicalDataSetId,
			importStatus, orderByComparator);
	}

	/**
	* Returns the first import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog fetchByImportMedicalDataSetAndImportStatus_First(
		long importMedicalDataSetId, int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence()
				   .fetchByImportMedicalDataSetAndImportStatus_First(importMedicalDataSetId,
			importStatus, orderByComparator);
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
	public static ImportMedicalDataSetLog findByImportMedicalDataSetAndImportStatus_Last(
		long importMedicalDataSetId, int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence()
				   .findByImportMedicalDataSetAndImportStatus_Last(importMedicalDataSetId,
			importStatus, orderByComparator);
	}

	/**
	* Returns the last import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static ImportMedicalDataSetLog fetchByImportMedicalDataSetAndImportStatus_Last(
		long importMedicalDataSetId, int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence()
				   .fetchByImportMedicalDataSetAndImportStatus_Last(importMedicalDataSetId,
			importStatus, orderByComparator);
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
	public static ImportMedicalDataSetLog[] findByImportMedicalDataSetAndImportStatus_PrevAndNext(
		long importMedicalDataSetLogId, long importMedicalDataSetId,
		int importStatus,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence()
				   .findByImportMedicalDataSetAndImportStatus_PrevAndNext(importMedicalDataSetLogId,
			importMedicalDataSetId, importStatus, orderByComparator);
	}

	/**
	* Removes all the import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63; from the database.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	*/
	public static void removeByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus) {
		getPersistence()
			.removeByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
			importStatus);
	}

	/**
	* Returns the number of import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63;.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	* @return the number of matching import medical data set logs
	*/
	public static int countByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus) {
		return getPersistence()
				   .countByImportMedicalDataSetAndImportStatus(importMedicalDataSetId,
			importStatus);
	}

	/**
	* Caches the import medical data set log in the entity cache if it is enabled.
	*
	* @param importMedicalDataSetLog the import medical data set log
	*/
	public static void cacheResult(
		ImportMedicalDataSetLog importMedicalDataSetLog) {
		getPersistence().cacheResult(importMedicalDataSetLog);
	}

	/**
	* Caches the import medical data set logs in the entity cache if it is enabled.
	*
	* @param importMedicalDataSetLogs the import medical data set logs
	*/
	public static void cacheResult(
		List<ImportMedicalDataSetLog> importMedicalDataSetLogs) {
		getPersistence().cacheResult(importMedicalDataSetLogs);
	}

	/**
	* Creates a new import medical data set log with the primary key. Does not add the import medical data set log to the database.
	*
	* @param importMedicalDataSetLogId the primary key for the new import medical data set log
	* @return the new import medical data set log
	*/
	public static ImportMedicalDataSetLog create(long importMedicalDataSetLogId) {
		return getPersistence().create(importMedicalDataSetLogId);
	}

	/**
	* Removes the import medical data set log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetLogId the primary key of the import medical data set log
	* @return the import medical data set log that was removed
	* @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	*/
	public static ImportMedicalDataSetLog remove(long importMedicalDataSetLogId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence().remove(importMedicalDataSetLogId);
	}

	public static ImportMedicalDataSetLog updateImpl(
		ImportMedicalDataSetLog importMedicalDataSetLog) {
		return getPersistence().updateImpl(importMedicalDataSetLog);
	}

	/**
	* Returns the import medical data set log with the primary key or throws a {@link NoSuchImportMedicalDataSetLogException} if it could not be found.
	*
	* @param importMedicalDataSetLogId the primary key of the import medical data set log
	* @return the import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	*/
	public static ImportMedicalDataSetLog findByPrimaryKey(
		long importMedicalDataSetLogId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException {
		return getPersistence().findByPrimaryKey(importMedicalDataSetLogId);
	}

	/**
	* Returns the import medical data set log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param importMedicalDataSetLogId the primary key of the import medical data set log
	* @return the import medical data set log, or <code>null</code> if a import medical data set log with the primary key could not be found
	*/
	public static ImportMedicalDataSetLog fetchByPrimaryKey(
		long importMedicalDataSetLogId) {
		return getPersistence().fetchByPrimaryKey(importMedicalDataSetLogId);
	}

	public static java.util.Map<java.io.Serializable, ImportMedicalDataSetLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the import medical data set logs.
	*
	* @return the import medical data set logs
	*/
	public static List<ImportMedicalDataSetLog> findAll() {
		return getPersistence().findAll();
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
	public static List<ImportMedicalDataSetLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ImportMedicalDataSetLog> findAll(int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ImportMedicalDataSetLog> findAll(int start, int end,
		OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the import medical data set logs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of import medical data set logs.
	*
	* @return the number of import medical data set logs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ImportMedicalDataSetLogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ImportMedicalDataSetLogPersistence, ImportMedicalDataSetLogPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ImportMedicalDataSetLogPersistence.class);
}