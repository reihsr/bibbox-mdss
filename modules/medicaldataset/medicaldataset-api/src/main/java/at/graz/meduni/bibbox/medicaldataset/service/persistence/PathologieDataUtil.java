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

import at.graz.meduni.bibbox.medicaldataset.model.PathologieData;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the pathologie data service. This utility wraps {@link at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.PathologieDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PathologieDataPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.PathologieDataPersistenceImpl
 * @generated
 */
@ProviderType
public class PathologieDataUtil {
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
	public static void clearCache(PathologieData pathologieData) {
		getPersistence().clearCache(pathologieData);
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
	public static List<PathologieData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PathologieData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PathologieData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PathologieData update(PathologieData pathologieData) {
		return getPersistence().update(pathologieData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PathologieData update(PathologieData pathologieData,
		ServiceContext serviceContext) {
		return getPersistence().update(pathologieData, serviceContext);
	}

	/**
	* Returns all the pathologie datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching pathologie datas
	*/
	public static List<PathologieData> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the pathologie datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of matching pathologie datas
	*/
	public static List<PathologieData> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the pathologie datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathologie datas
	*/
	public static List<PathologieData> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the pathologie datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathologie datas
	*/
	public static List<PathologieData> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first pathologie data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public static PathologieData findByUuid_First(java.lang.String uuid,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first pathologie data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last pathologie data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public static PathologieData findByUuid_Last(java.lang.String uuid,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last pathologie data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the pathologie datas before and after the current pathologie data in the ordered set where uuid = &#63;.
	*
	* @param pathologieDataId the primary key of the current pathologie data
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public static PathologieData[] findByUuid_PrevAndNext(
		long pathologieDataId, java.lang.String uuid,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence()
				   .findByUuid_PrevAndNext(pathologieDataId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the pathologie datas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of pathologie datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching pathologie datas
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the pathologie data where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPathologieDataException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public static PathologieData findByUUID_G(java.lang.String uuid,
		long groupId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the pathologie data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the pathologie data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the pathologie data where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the pathologie data that was removed
	*/
	public static PathologieData removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of pathologie datas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching pathologie datas
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the pathologie datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching pathologie datas
	*/
	public static List<PathologieData> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the pathologie datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of matching pathologie datas
	*/
	public static List<PathologieData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the pathologie datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathologie datas
	*/
	public static List<PathologieData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the pathologie datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathologie datas
	*/
	public static List<PathologieData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public static PathologieData findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public static PathologieData findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the pathologie datas before and after the current pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param pathologieDataId the primary key of the current pathologie data
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public static PathologieData[] findByUuid_C_PrevAndNext(
		long pathologieDataId, java.lang.String uuid, long companyId,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(pathologieDataId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the pathologie datas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of pathologie datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching pathologie datas
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the pathologie datas where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching pathologie datas
	*/
	public static List<PathologieData> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the pathologie datas where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of matching pathologie datas
	*/
	public static List<PathologieData> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the pathologie datas where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathologie datas
	*/
	public static List<PathologieData> findByGroupId(long groupId, int start,
		int end, OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the pathologie datas where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathologie datas
	*/
	public static List<PathologieData> findByGroupId(long groupId, int start,
		int end, OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first pathologie data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public static PathologieData findByGroupId_First(long groupId,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first pathologie data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByGroupId_First(long groupId,
		OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last pathologie data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public static PathologieData findByGroupId_Last(long groupId,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last pathologie data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByGroupId_Last(long groupId,
		OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the pathologie datas before and after the current pathologie data in the ordered set where groupId = &#63;.
	*
	* @param pathologieDataId the primary key of the current pathologie data
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public static PathologieData[] findByGroupId_PrevAndNext(
		long pathologieDataId, long groupId,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(pathologieDataId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the pathologie datas that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching pathologie datas that the user has permission to view
	*/
	public static List<PathologieData> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the pathologie datas that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of matching pathologie datas that the user has permission to view
	*/
	public static List<PathologieData> filterFindByGroupId(long groupId,
		int start, int end) {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the pathologie datas that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathologie datas that the user has permission to view
	*/
	public static List<PathologieData> filterFindByGroupId(long groupId,
		int start, int end, OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the pathologie datas before and after the current pathologie data in the ordered set of pathologie datas that the user has permission to view where groupId = &#63;.
	*
	* @param pathologieDataId the primary key of the current pathologie data
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public static PathologieData[] filterFindByGroupId_PrevAndNext(
		long pathologieDataId, long groupId,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(pathologieDataId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the pathologie datas where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of pathologie datas where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching pathologie datas
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of pathologie datas that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching pathologie datas that the user has permission to view
	*/
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the pathologie datas where material = &#63;.
	*
	* @param material the material
	* @return the matching pathologie datas
	*/
	public static List<PathologieData> findByMaterial(java.lang.String material) {
		return getPersistence().findByMaterial(material);
	}

	/**
	* Returns a range of all the pathologie datas where material = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param material the material
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of matching pathologie datas
	*/
	public static List<PathologieData> findByMaterial(
		java.lang.String material, int start, int end) {
		return getPersistence().findByMaterial(material, start, end);
	}

	/**
	* Returns an ordered range of all the pathologie datas where material = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param material the material
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathologie datas
	*/
	public static List<PathologieData> findByMaterial(
		java.lang.String material, int start, int end,
		OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence()
				   .findByMaterial(material, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the pathologie datas where material = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param material the material
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathologie datas
	*/
	public static List<PathologieData> findByMaterial(
		java.lang.String material, int start, int end,
		OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMaterial(material, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first pathologie data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public static PathologieData findByMaterial_First(
		java.lang.String material,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().findByMaterial_First(material, orderByComparator);
	}

	/**
	* Returns the first pathologie data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByMaterial_First(
		java.lang.String material,
		OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence()
				   .fetchByMaterial_First(material, orderByComparator);
	}

	/**
	* Returns the last pathologie data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public static PathologieData findByMaterial_Last(
		java.lang.String material,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().findByMaterial_Last(material, orderByComparator);
	}

	/**
	* Returns the last pathologie data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByMaterial_Last(
		java.lang.String material,
		OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence().fetchByMaterial_Last(material, orderByComparator);
	}

	/**
	* Returns the pathologie datas before and after the current pathologie data in the ordered set where material = &#63;.
	*
	* @param pathologieDataId the primary key of the current pathologie data
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public static PathologieData[] findByMaterial_PrevAndNext(
		long pathologieDataId, java.lang.String material,
		OrderByComparator<PathologieData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence()
				   .findByMaterial_PrevAndNext(pathologieDataId, material,
			orderByComparator);
	}

	/**
	* Removes all the pathologie datas where material = &#63; from the database.
	*
	* @param material the material
	*/
	public static void removeByMaterial(java.lang.String material) {
		getPersistence().removeByMaterial(material);
	}

	/**
	* Returns the number of pathologie datas where material = &#63;.
	*
	* @param material the material
	* @return the number of matching pathologie datas
	*/
	public static int countByMaterial(java.lang.String material) {
		return getPersistence().countByMaterial(material);
	}

	/**
	* Returns the pathologie data where medicalRecordId = &#63; or throws a {@link NoSuchPathologieDataException} if it could not be found.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public static PathologieData findByMedicalRecord(long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().findByMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the pathologie data where medicalRecordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByMedicalRecord(long medicalRecordId) {
		return getPersistence().fetchByMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the pathologie data where medicalRecordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param medicalRecordId the medical record ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static PathologieData fetchByMedicalRecord(long medicalRecordId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByMedicalRecord(medicalRecordId, retrieveFromCache);
	}

	/**
	* Removes the pathologie data where medicalRecordId = &#63; from the database.
	*
	* @param medicalRecordId the medical record ID
	* @return the pathologie data that was removed
	*/
	public static PathologieData removeByMedicalRecord(long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().removeByMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the number of pathologie datas where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @return the number of matching pathologie datas
	*/
	public static int countByMedicalRecord(long medicalRecordId) {
		return getPersistence().countByMedicalRecord(medicalRecordId);
	}

	/**
	* Caches the pathologie data in the entity cache if it is enabled.
	*
	* @param pathologieData the pathologie data
	*/
	public static void cacheResult(PathologieData pathologieData) {
		getPersistence().cacheResult(pathologieData);
	}

	/**
	* Caches the pathologie datas in the entity cache if it is enabled.
	*
	* @param pathologieDatas the pathologie datas
	*/
	public static void cacheResult(List<PathologieData> pathologieDatas) {
		getPersistence().cacheResult(pathologieDatas);
	}

	/**
	* Creates a new pathologie data with the primary key. Does not add the pathologie data to the database.
	*
	* @param pathologieDataId the primary key for the new pathologie data
	* @return the new pathologie data
	*/
	public static PathologieData create(long pathologieDataId) {
		return getPersistence().create(pathologieDataId);
	}

	/**
	* Removes the pathologie data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data that was removed
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public static PathologieData remove(long pathologieDataId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().remove(pathologieDataId);
	}

	public static PathologieData updateImpl(PathologieData pathologieData) {
		return getPersistence().updateImpl(pathologieData);
	}

	/**
	* Returns the pathologie data with the primary key or throws a {@link NoSuchPathologieDataException} if it could not be found.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public static PathologieData findByPrimaryKey(long pathologieDataId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return getPersistence().findByPrimaryKey(pathologieDataId);
	}

	/**
	* Returns the pathologie data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data, or <code>null</code> if a pathologie data with the primary key could not be found
	*/
	public static PathologieData fetchByPrimaryKey(long pathologieDataId) {
		return getPersistence().fetchByPrimaryKey(pathologieDataId);
	}

	public static java.util.Map<java.io.Serializable, PathologieData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the pathologie datas.
	*
	* @return the pathologie datas
	*/
	public static List<PathologieData> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the pathologie datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of pathologie datas
	*/
	public static List<PathologieData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the pathologie datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pathologie datas
	*/
	public static List<PathologieData> findAll(int start, int end,
		OrderByComparator<PathologieData> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the pathologie datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of pathologie datas
	*/
	public static List<PathologieData> findAll(int start, int end,
		OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the pathologie datas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of pathologie datas.
	*
	* @return the number of pathologie datas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PathologieDataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PathologieDataPersistence, PathologieDataPersistence> _serviceTracker =
		ServiceTrackerFactory.open(PathologieDataPersistence.class);
}