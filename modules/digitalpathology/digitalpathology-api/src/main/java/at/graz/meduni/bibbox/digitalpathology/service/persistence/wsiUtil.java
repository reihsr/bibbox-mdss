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

package at.graz.meduni.bibbox.digitalpathology.service.persistence;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.digitalpathology.model.wsi;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the wsi service. This utility wraps {@link at.graz.meduni.bibbox.digitalpathology.service.persistence.impl.wsiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see wsiPersistence
 * @see at.graz.meduni.bibbox.digitalpathology.service.persistence.impl.wsiPersistenceImpl
 * @generated
 */
@ProviderType
public class wsiUtil {
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
	public static void clearCache(wsi wsi) {
		getPersistence().clearCache(wsi);
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
	public static List<wsi> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<wsi> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<wsi> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<wsi> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static wsi update(wsi wsi) {
		return getPersistence().update(wsi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static wsi update(wsi wsi, ServiceContext serviceContext) {
		return getPersistence().update(wsi, serviceContext);
	}

	/**
	* Returns all the wsis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching wsis
	*/
	public static List<wsi> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the wsis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @return the range of matching wsis
	*/
	public static List<wsi> findByUuid(java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the wsis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsis
	*/
	public static List<wsi> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<wsi> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the wsis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsis
	*/
	public static List<wsi> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<wsi> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first wsi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public static wsi findByUuid_First(java.lang.String uuid,
		OrderByComparator<wsi> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first wsi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public static wsi fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<wsi> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last wsi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public static wsi findByUuid_Last(java.lang.String uuid,
		OrderByComparator<wsi> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last wsi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public static wsi fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<wsi> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the wsis before and after the current wsi in the ordered set where uuid = &#63;.
	*
	* @param wsiId the primary key of the current wsi
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsi
	* @throws NoSuchwsiException if a wsi with the primary key could not be found
	*/
	public static wsi[] findByUuid_PrevAndNext(long wsiId,
		java.lang.String uuid, OrderByComparator<wsi> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence()
				   .findByUuid_PrevAndNext(wsiId, uuid, orderByComparator);
	}

	/**
	* Removes all the wsis where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of wsis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching wsis
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the wsi where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchwsiException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public static wsi findByUUID_G(java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the wsi where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public static wsi fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the wsi where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public static wsi fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the wsi where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the wsi that was removed
	*/
	public static wsi removeByUUID_G(java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of wsis where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching wsis
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the wsis where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching wsis
	*/
	public static List<wsi> findByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the wsis where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @return the range of matching wsis
	*/
	public static List<wsi> findByUuid_C(java.lang.String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the wsis where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsis
	*/
	public static List<wsi> findByUuid_C(java.lang.String uuid, long companyId,
		int start, int end, OrderByComparator<wsi> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the wsis where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsis
	*/
	public static List<wsi> findByUuid_C(java.lang.String uuid, long companyId,
		int start, int end, OrderByComparator<wsi> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public static wsi findByUuid_C_First(java.lang.String uuid, long companyId,
		OrderByComparator<wsi> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public static wsi fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<wsi> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public static wsi findByUuid_C_Last(java.lang.String uuid, long companyId,
		OrderByComparator<wsi> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public static wsi fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		OrderByComparator<wsi> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the wsis before and after the current wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param wsiId the primary key of the current wsi
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsi
	* @throws NoSuchwsiException if a wsi with the primary key could not be found
	*/
	public static wsi[] findByUuid_C_PrevAndNext(long wsiId,
		java.lang.String uuid, long companyId,
		OrderByComparator<wsi> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(wsiId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the wsis where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of wsis where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching wsis
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the wsis where filename = &#63;.
	*
	* @param filename the filename
	* @return the matching wsis
	*/
	public static List<wsi> findByFilename(java.lang.String filename) {
		return getPersistence().findByFilename(filename);
	}

	/**
	* Returns a range of all the wsis where filename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filename the filename
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @return the range of matching wsis
	*/
	public static List<wsi> findByFilename(java.lang.String filename,
		int start, int end) {
		return getPersistence().findByFilename(filename, start, end);
	}

	/**
	* Returns an ordered range of all the wsis where filename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filename the filename
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsis
	*/
	public static List<wsi> findByFilename(java.lang.String filename,
		int start, int end, OrderByComparator<wsi> orderByComparator) {
		return getPersistence()
				   .findByFilename(filename, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the wsis where filename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filename the filename
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsis
	*/
	public static List<wsi> findByFilename(java.lang.String filename,
		int start, int end, OrderByComparator<wsi> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFilename(filename, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first wsi in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public static wsi findByFilename_First(java.lang.String filename,
		OrderByComparator<wsi> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence().findByFilename_First(filename, orderByComparator);
	}

	/**
	* Returns the first wsi in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public static wsi fetchByFilename_First(java.lang.String filename,
		OrderByComparator<wsi> orderByComparator) {
		return getPersistence()
				   .fetchByFilename_First(filename, orderByComparator);
	}

	/**
	* Returns the last wsi in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public static wsi findByFilename_Last(java.lang.String filename,
		OrderByComparator<wsi> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence().findByFilename_Last(filename, orderByComparator);
	}

	/**
	* Returns the last wsi in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public static wsi fetchByFilename_Last(java.lang.String filename,
		OrderByComparator<wsi> orderByComparator) {
		return getPersistence().fetchByFilename_Last(filename, orderByComparator);
	}

	/**
	* Returns the wsis before and after the current wsi in the ordered set where filename = &#63;.
	*
	* @param wsiId the primary key of the current wsi
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsi
	* @throws NoSuchwsiException if a wsi with the primary key could not be found
	*/
	public static wsi[] findByFilename_PrevAndNext(long wsiId,
		java.lang.String filename, OrderByComparator<wsi> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence()
				   .findByFilename_PrevAndNext(wsiId, filename,
			orderByComparator);
	}

	/**
	* Removes all the wsis where filename = &#63; from the database.
	*
	* @param filename the filename
	*/
	public static void removeByFilename(java.lang.String filename) {
		getPersistence().removeByFilename(filename);
	}

	/**
	* Returns the number of wsis where filename = &#63;.
	*
	* @param filename the filename
	* @return the number of matching wsis
	*/
	public static int countByFilename(java.lang.String filename) {
		return getPersistence().countByFilename(filename);
	}

	/**
	* Caches the wsi in the entity cache if it is enabled.
	*
	* @param wsi the wsi
	*/
	public static void cacheResult(wsi wsi) {
		getPersistence().cacheResult(wsi);
	}

	/**
	* Caches the wsis in the entity cache if it is enabled.
	*
	* @param wsis the wsis
	*/
	public static void cacheResult(List<wsi> wsis) {
		getPersistence().cacheResult(wsis);
	}

	/**
	* Creates a new wsi with the primary key. Does not add the wsi to the database.
	*
	* @param wsiId the primary key for the new wsi
	* @return the new wsi
	*/
	public static wsi create(long wsiId) {
		return getPersistence().create(wsiId);
	}

	/**
	* Removes the wsi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wsiId the primary key of the wsi
	* @return the wsi that was removed
	* @throws NoSuchwsiException if a wsi with the primary key could not be found
	*/
	public static wsi remove(long wsiId)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence().remove(wsiId);
	}

	public static wsi updateImpl(wsi wsi) {
		return getPersistence().updateImpl(wsi);
	}

	/**
	* Returns the wsi with the primary key or throws a {@link NoSuchwsiException} if it could not be found.
	*
	* @param wsiId the primary key of the wsi
	* @return the wsi
	* @throws NoSuchwsiException if a wsi with the primary key could not be found
	*/
	public static wsi findByPrimaryKey(long wsiId)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException {
		return getPersistence().findByPrimaryKey(wsiId);
	}

	/**
	* Returns the wsi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wsiId the primary key of the wsi
	* @return the wsi, or <code>null</code> if a wsi with the primary key could not be found
	*/
	public static wsi fetchByPrimaryKey(long wsiId) {
		return getPersistence().fetchByPrimaryKey(wsiId);
	}

	public static java.util.Map<java.io.Serializable, wsi> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the wsis.
	*
	* @return the wsis
	*/
	public static List<wsi> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the wsis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @return the range of wsis
	*/
	public static List<wsi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the wsis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of wsis
	*/
	public static List<wsi> findAll(int start, int end,
		OrderByComparator<wsi> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the wsis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of wsis
	*/
	public static List<wsi> findAll(int start, int end,
		OrderByComparator<wsi> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the wsis from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of wsis.
	*
	* @return the number of wsis
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static wsiPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<wsiPersistence, wsiPersistence> _serviceTracker =
		ServiceTrackerFactory.open(wsiPersistence.class);
}