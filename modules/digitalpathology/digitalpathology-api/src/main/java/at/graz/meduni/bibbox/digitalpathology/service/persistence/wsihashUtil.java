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

import at.graz.meduni.bibbox.digitalpathology.model.wsihash;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the wsihash service. This utility wraps {@link at.graz.meduni.bibbox.digitalpathology.service.persistence.impl.wsihashPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see wsihashPersistence
 * @see at.graz.meduni.bibbox.digitalpathology.service.persistence.impl.wsihashPersistenceImpl
 * @generated
 */
@ProviderType
public class wsihashUtil {
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
	public static void clearCache(wsihash wsihash) {
		getPersistence().clearCache(wsihash);
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
	public static List<wsihash> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<wsihash> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<wsihash> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<wsihash> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static wsihash update(wsihash wsihash) {
		return getPersistence().update(wsihash);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static wsihash update(wsihash wsihash, ServiceContext serviceContext) {
		return getPersistence().update(wsihash, serviceContext);
	}

	/**
	* Returns all the wsihashs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching wsihashs
	*/
	public static List<wsihash> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the wsihashs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @return the range of matching wsihashs
	*/
	public static List<wsihash> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the wsihashs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsihashs
	*/
	public static List<wsihash> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<wsihash> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the wsihashs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsihashs
	*/
	public static List<wsihash> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<wsihash> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first wsihash in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public static wsihash findByUuid_First(java.lang.String uuid,
		OrderByComparator<wsihash> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first wsihash in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public static wsihash fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<wsihash> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last wsihash in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public static wsihash findByUuid_Last(java.lang.String uuid,
		OrderByComparator<wsihash> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last wsihash in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public static wsihash fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<wsihash> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the wsihashs before and after the current wsihash in the ordered set where uuid = &#63;.
	*
	* @param wsihashId the primary key of the current wsihash
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsihash
	* @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	*/
	public static wsihash[] findByUuid_PrevAndNext(long wsihashId,
		java.lang.String uuid, OrderByComparator<wsihash> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence()
				   .findByUuid_PrevAndNext(wsihashId, uuid, orderByComparator);
	}

	/**
	* Removes all the wsihashs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of wsihashs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching wsihashs
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the wsihash where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchwsihashException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public static wsihash findByUUID_G(java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the wsihash where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public static wsihash fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the wsihash where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public static wsihash fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the wsihash where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the wsihash that was removed
	*/
	public static wsihash removeByUUID_G(java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of wsihashs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching wsihashs
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the wsihashs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching wsihashs
	*/
	public static List<wsihash> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the wsihashs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @return the range of matching wsihashs
	*/
	public static List<wsihash> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the wsihashs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsihashs
	*/
	public static List<wsihash> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<wsihash> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the wsihashs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsihashs
	*/
	public static List<wsihash> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<wsihash> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public static wsihash findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<wsihash> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public static wsihash fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<wsihash> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public static wsihash findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<wsihash> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public static wsihash fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<wsihash> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the wsihashs before and after the current wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param wsihashId the primary key of the current wsihash
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsihash
	* @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	*/
	public static wsihash[] findByUuid_C_PrevAndNext(long wsihashId,
		java.lang.String uuid, long companyId,
		OrderByComparator<wsihash> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(wsihashId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the wsihashs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of wsihashs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching wsihashs
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the wsihashs where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @return the matching wsihashs
	*/
	public static List<wsihash> findByWsi(long wsiId) {
		return getPersistence().findByWsi(wsiId);
	}

	/**
	* Returns a range of all the wsihashs where wsiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wsiId the wsi ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @return the range of matching wsihashs
	*/
	public static List<wsihash> findByWsi(long wsiId, int start, int end) {
		return getPersistence().findByWsi(wsiId, start, end);
	}

	/**
	* Returns an ordered range of all the wsihashs where wsiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wsiId the wsi ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsihashs
	*/
	public static List<wsihash> findByWsi(long wsiId, int start, int end,
		OrderByComparator<wsihash> orderByComparator) {
		return getPersistence().findByWsi(wsiId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the wsihashs where wsiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wsiId the wsi ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsihashs
	*/
	public static List<wsihash> findByWsi(long wsiId, int start, int end,
		OrderByComparator<wsihash> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByWsi(wsiId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first wsihash in the ordered set where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public static wsihash findByWsi_First(long wsiId,
		OrderByComparator<wsihash> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence().findByWsi_First(wsiId, orderByComparator);
	}

	/**
	* Returns the first wsihash in the ordered set where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public static wsihash fetchByWsi_First(long wsiId,
		OrderByComparator<wsihash> orderByComparator) {
		return getPersistence().fetchByWsi_First(wsiId, orderByComparator);
	}

	/**
	* Returns the last wsihash in the ordered set where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public static wsihash findByWsi_Last(long wsiId,
		OrderByComparator<wsihash> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence().findByWsi_Last(wsiId, orderByComparator);
	}

	/**
	* Returns the last wsihash in the ordered set where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public static wsihash fetchByWsi_Last(long wsiId,
		OrderByComparator<wsihash> orderByComparator) {
		return getPersistence().fetchByWsi_Last(wsiId, orderByComparator);
	}

	/**
	* Returns the wsihashs before and after the current wsihash in the ordered set where wsiId = &#63;.
	*
	* @param wsihashId the primary key of the current wsihash
	* @param wsiId the wsi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsihash
	* @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	*/
	public static wsihash[] findByWsi_PrevAndNext(long wsihashId, long wsiId,
		OrderByComparator<wsihash> orderByComparator)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence()
				   .findByWsi_PrevAndNext(wsihashId, wsiId, orderByComparator);
	}

	/**
	* Removes all the wsihashs where wsiId = &#63; from the database.
	*
	* @param wsiId the wsi ID
	*/
	public static void removeByWsi(long wsiId) {
		getPersistence().removeByWsi(wsiId);
	}

	/**
	* Returns the number of wsihashs where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @return the number of matching wsihashs
	*/
	public static int countByWsi(long wsiId) {
		return getPersistence().countByWsi(wsiId);
	}

	/**
	* Caches the wsihash in the entity cache if it is enabled.
	*
	* @param wsihash the wsihash
	*/
	public static void cacheResult(wsihash wsihash) {
		getPersistence().cacheResult(wsihash);
	}

	/**
	* Caches the wsihashs in the entity cache if it is enabled.
	*
	* @param wsihashs the wsihashs
	*/
	public static void cacheResult(List<wsihash> wsihashs) {
		getPersistence().cacheResult(wsihashs);
	}

	/**
	* Creates a new wsihash with the primary key. Does not add the wsihash to the database.
	*
	* @param wsihashId the primary key for the new wsihash
	* @return the new wsihash
	*/
	public static wsihash create(long wsihashId) {
		return getPersistence().create(wsihashId);
	}

	/**
	* Removes the wsihash with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wsihashId the primary key of the wsihash
	* @return the wsihash that was removed
	* @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	*/
	public static wsihash remove(long wsihashId)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence().remove(wsihashId);
	}

	public static wsihash updateImpl(wsihash wsihash) {
		return getPersistence().updateImpl(wsihash);
	}

	/**
	* Returns the wsihash with the primary key or throws a {@link NoSuchwsihashException} if it could not be found.
	*
	* @param wsihashId the primary key of the wsihash
	* @return the wsihash
	* @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	*/
	public static wsihash findByPrimaryKey(long wsihashId)
		throws at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException {
		return getPersistence().findByPrimaryKey(wsihashId);
	}

	/**
	* Returns the wsihash with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wsihashId the primary key of the wsihash
	* @return the wsihash, or <code>null</code> if a wsihash with the primary key could not be found
	*/
	public static wsihash fetchByPrimaryKey(long wsihashId) {
		return getPersistence().fetchByPrimaryKey(wsihashId);
	}

	public static java.util.Map<java.io.Serializable, wsihash> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the wsihashs.
	*
	* @return the wsihashs
	*/
	public static List<wsihash> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the wsihashs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @return the range of wsihashs
	*/
	public static List<wsihash> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the wsihashs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of wsihashs
	*/
	public static List<wsihash> findAll(int start, int end,
		OrderByComparator<wsihash> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the wsihashs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of wsihashs
	*/
	public static List<wsihash> findAll(int start, int end,
		OrderByComparator<wsihash> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the wsihashs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of wsihashs.
	*
	* @return the number of wsihashs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static wsihashPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<wsihashPersistence, wsihashPersistence> _serviceTracker =
		ServiceTrackerFactory.open(wsihashPersistence.class);
}