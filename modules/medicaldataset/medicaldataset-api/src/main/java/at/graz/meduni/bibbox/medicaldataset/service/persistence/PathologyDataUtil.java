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

import at.graz.meduni.bibbox.medicaldataset.model.PathologyData;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the pathology data service. This utility wraps {@link at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.PathologyDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PathologyDataPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.PathologyDataPersistenceImpl
 * @generated
 */
@ProviderType
public class PathologyDataUtil {
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
	public static void clearCache(PathologyData pathologyData) {
		getPersistence().clearCache(pathologyData);
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
	public static List<PathologyData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PathologyData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PathologyData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PathologyData update(PathologyData pathologyData) {
		return getPersistence().update(pathologyData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PathologyData update(PathologyData pathologyData,
		ServiceContext serviceContext) {
		return getPersistence().update(pathologyData, serviceContext);
	}

	/**
	* Returns all the pathology datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching pathology datas
	*/
	public static List<PathologyData> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the pathology datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @return the range of matching pathology datas
	*/
	public static List<PathologyData> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the pathology datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathology datas
	*/
	public static List<PathologyData> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the pathology datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathology datas
	*/
	public static List<PathologyData> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first pathology data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public static PathologyData findByUuid_First(java.lang.String uuid,
		OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first pathology data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last pathology data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public static PathologyData findByUuid_Last(java.lang.String uuid,
		OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last pathology data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the pathology datas before and after the current pathology data in the ordered set where uuid = &#63;.
	*
	* @param pathologyDataId the primary key of the current pathology data
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathology data
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public static PathologyData[] findByUuid_PrevAndNext(long pathologyDataId,
		java.lang.String uuid,
		OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence()
				   .findByUuid_PrevAndNext(pathologyDataId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the pathology datas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of pathology datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching pathology datas
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the pathology data where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPathologyDataException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public static PathologyData findByUUID_G(java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the pathology data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the pathology data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the pathology data where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the pathology data that was removed
	*/
	public static PathologyData removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of pathology datas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching pathology datas
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the pathology datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching pathology datas
	*/
	public static List<PathologyData> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the pathology datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @return the range of matching pathology datas
	*/
	public static List<PathologyData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the pathology datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathology datas
	*/
	public static List<PathologyData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the pathology datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathology datas
	*/
	public static List<PathologyData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public static PathologyData findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public static PathologyData findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the pathology datas before and after the current pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param pathologyDataId the primary key of the current pathology data
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathology data
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public static PathologyData[] findByUuid_C_PrevAndNext(
		long pathologyDataId, java.lang.String uuid, long companyId,
		OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(pathologyDataId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the pathology datas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of pathology datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching pathology datas
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the pathology datas where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching pathology datas
	*/
	public static List<PathologyData> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the pathology datas where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @return the range of matching pathology datas
	*/
	public static List<PathologyData> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the pathology datas where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathology datas
	*/
	public static List<PathologyData> findByGroupId(long groupId, int start,
		int end, OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the pathology datas where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathology datas
	*/
	public static List<PathologyData> findByGroupId(long groupId, int start,
		int end, OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first pathology data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public static PathologyData findByGroupId_First(long groupId,
		OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first pathology data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByGroupId_First(long groupId,
		OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last pathology data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public static PathologyData findByGroupId_Last(long groupId,
		OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last pathology data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByGroupId_Last(long groupId,
		OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the pathology datas before and after the current pathology data in the ordered set where groupId = &#63;.
	*
	* @param pathologyDataId the primary key of the current pathology data
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathology data
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public static PathologyData[] findByGroupId_PrevAndNext(
		long pathologyDataId, long groupId,
		OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(pathologyDataId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the pathology datas where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of pathology datas where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching pathology datas
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the pathology datas where material = &#63;.
	*
	* @param material the material
	* @return the matching pathology datas
	*/
	public static List<PathologyData> findByMaterial(java.lang.String material) {
		return getPersistence().findByMaterial(material);
	}

	/**
	* Returns a range of all the pathology datas where material = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param material the material
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @return the range of matching pathology datas
	*/
	public static List<PathologyData> findByMaterial(
		java.lang.String material, int start, int end) {
		return getPersistence().findByMaterial(material, start, end);
	}

	/**
	* Returns an ordered range of all the pathology datas where material = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param material the material
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathology datas
	*/
	public static List<PathologyData> findByMaterial(
		java.lang.String material, int start, int end,
		OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence()
				   .findByMaterial(material, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the pathology datas where material = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param material the material
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathology datas
	*/
	public static List<PathologyData> findByMaterial(
		java.lang.String material, int start, int end,
		OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMaterial(material, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first pathology data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public static PathologyData findByMaterial_First(
		java.lang.String material,
		OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().findByMaterial_First(material, orderByComparator);
	}

	/**
	* Returns the first pathology data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByMaterial_First(
		java.lang.String material,
		OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence()
				   .fetchByMaterial_First(material, orderByComparator);
	}

	/**
	* Returns the last pathology data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public static PathologyData findByMaterial_Last(java.lang.String material,
		OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().findByMaterial_Last(material, orderByComparator);
	}

	/**
	* Returns the last pathology data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByMaterial_Last(
		java.lang.String material,
		OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence().fetchByMaterial_Last(material, orderByComparator);
	}

	/**
	* Returns the pathology datas before and after the current pathology data in the ordered set where material = &#63;.
	*
	* @param pathologyDataId the primary key of the current pathology data
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathology data
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public static PathologyData[] findByMaterial_PrevAndNext(
		long pathologyDataId, java.lang.String material,
		OrderByComparator<PathologyData> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence()
				   .findByMaterial_PrevAndNext(pathologyDataId, material,
			orderByComparator);
	}

	/**
	* Removes all the pathology datas where material = &#63; from the database.
	*
	* @param material the material
	*/
	public static void removeByMaterial(java.lang.String material) {
		getPersistence().removeByMaterial(material);
	}

	/**
	* Returns the number of pathology datas where material = &#63;.
	*
	* @param material the material
	* @return the number of matching pathology datas
	*/
	public static int countByMaterial(java.lang.String material) {
		return getPersistence().countByMaterial(material);
	}

	/**
	* Returns the pathology data where medicalRecordId = &#63; or throws a {@link NoSuchPathologyDataException} if it could not be found.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public static PathologyData findByMedicalRecord(long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().findByMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the pathology data where medicalRecordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByMedicalRecord(long medicalRecordId) {
		return getPersistence().fetchByMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the pathology data where medicalRecordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param medicalRecordId the medical record ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static PathologyData fetchByMedicalRecord(long medicalRecordId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByMedicalRecord(medicalRecordId, retrieveFromCache);
	}

	/**
	* Removes the pathology data where medicalRecordId = &#63; from the database.
	*
	* @param medicalRecordId the medical record ID
	* @return the pathology data that was removed
	*/
	public static PathologyData removeByMedicalRecord(long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().removeByMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the number of pathology datas where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @return the number of matching pathology datas
	*/
	public static int countByMedicalRecord(long medicalRecordId) {
		return getPersistence().countByMedicalRecord(medicalRecordId);
	}

	/**
	* Caches the pathology data in the entity cache if it is enabled.
	*
	* @param pathologyData the pathology data
	*/
	public static void cacheResult(PathologyData pathologyData) {
		getPersistence().cacheResult(pathologyData);
	}

	/**
	* Caches the pathology datas in the entity cache if it is enabled.
	*
	* @param pathologyDatas the pathology datas
	*/
	public static void cacheResult(List<PathologyData> pathologyDatas) {
		getPersistence().cacheResult(pathologyDatas);
	}

	/**
	* Creates a new pathology data with the primary key. Does not add the pathology data to the database.
	*
	* @param pathologyDataId the primary key for the new pathology data
	* @return the new pathology data
	*/
	public static PathologyData create(long pathologyDataId) {
		return getPersistence().create(pathologyDataId);
	}

	/**
	* Removes the pathology data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologyDataId the primary key of the pathology data
	* @return the pathology data that was removed
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public static PathologyData remove(long pathologyDataId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().remove(pathologyDataId);
	}

	public static PathologyData updateImpl(PathologyData pathologyData) {
		return getPersistence().updateImpl(pathologyData);
	}

	/**
	* Returns the pathology data with the primary key or throws a {@link NoSuchPathologyDataException} if it could not be found.
	*
	* @param pathologyDataId the primary key of the pathology data
	* @return the pathology data
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public static PathologyData findByPrimaryKey(long pathologyDataId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getPersistence().findByPrimaryKey(pathologyDataId);
	}

	/**
	* Returns the pathology data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pathologyDataId the primary key of the pathology data
	* @return the pathology data, or <code>null</code> if a pathology data with the primary key could not be found
	*/
	public static PathologyData fetchByPrimaryKey(long pathologyDataId) {
		return getPersistence().fetchByPrimaryKey(pathologyDataId);
	}

	public static java.util.Map<java.io.Serializable, PathologyData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the pathology datas.
	*
	* @return the pathology datas
	*/
	public static List<PathologyData> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the pathology datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @return the range of pathology datas
	*/
	public static List<PathologyData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the pathology datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pathology datas
	*/
	public static List<PathologyData> findAll(int start, int end,
		OrderByComparator<PathologyData> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the pathology datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of pathology datas
	*/
	public static List<PathologyData> findAll(int start, int end,
		OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the pathology datas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of pathology datas.
	*
	* @return the number of pathology datas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PathologyDataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PathologyDataPersistence, PathologyDataPersistence> _serviceTracker =
		ServiceTrackerFactory.open(PathologyDataPersistence.class);
}