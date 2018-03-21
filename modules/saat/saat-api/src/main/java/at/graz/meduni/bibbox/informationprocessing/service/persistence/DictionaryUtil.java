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

package at.graz.meduni.bibbox.informationprocessing.service.persistence;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.informationprocessing.model.Dictionary;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the dictionary service. This utility wraps {@link at.graz.meduni.bibbox.informationprocessing.service.persistence.impl.DictionaryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see DictionaryPersistence
 * @see at.graz.meduni.bibbox.informationprocessing.service.persistence.impl.DictionaryPersistenceImpl
 * @generated
 */
@ProviderType
public class DictionaryUtil {
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
	public static void clearCache(Dictionary dictionary) {
		getPersistence().clearCache(dictionary);
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
	public static List<Dictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Dictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Dictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Dictionary update(Dictionary dictionary) {
		return getPersistence().update(dictionary);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Dictionary update(Dictionary dictionary,
		ServiceContext serviceContext) {
		return getPersistence().update(dictionary, serviceContext);
	}

	/**
	* Returns all the dictionaries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching dictionaries
	*/
	public static List<Dictionary> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the dictionaries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of matching dictionaries
	*/
	public static List<Dictionary> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionaries
	*/
	public static List<Dictionary> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionaries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dictionaries
	*/
	public static List<Dictionary> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Dictionary> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dictionary in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public static Dictionary findByUuid_First(java.lang.String uuid,
		OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first dictionary in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public static Dictionary findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set where uuid = &#63;.
	*
	* @param dictionaryId the primary key of the current dictionary
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public static Dictionary[] findByUuid_PrevAndNext(long dictionaryId,
		java.lang.String uuid, OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(dictionaryId, uuid, orderByComparator);
	}

	/**
	* Removes all the dictionaries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of dictionaries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching dictionaries
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the dictionary where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDictionaryException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public static Dictionary findByUUID_G(java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the dictionary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the dictionary where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the dictionary where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the dictionary that was removed
	*/
	public static Dictionary removeByUUID_G(java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of dictionaries where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching dictionaries
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the dictionaries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching dictionaries
	*/
	public static List<Dictionary> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the dictionaries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of matching dictionaries
	*/
	public static List<Dictionary> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionaries
	*/
	public static List<Dictionary> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionaries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dictionaries
	*/
	public static List<Dictionary> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Dictionary> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first dictionary in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public static Dictionary findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first dictionary in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public static Dictionary findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param dictionaryId the primary key of the current dictionary
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public static Dictionary[] findByUuid_C_PrevAndNext(long dictionaryId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(dictionaryId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the dictionaries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of dictionaries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching dictionaries
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the dictionaries where root = &#63; and groupId = &#63;.
	*
	* @param root the root
	* @param groupId the group ID
	* @return the matching dictionaries
	*/
	public static List<Dictionary> findByRoot(boolean root, long groupId) {
		return getPersistence().findByRoot(root, groupId);
	}

	/**
	* Returns a range of all the dictionaries where root = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param root the root
	* @param groupId the group ID
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of matching dictionaries
	*/
	public static List<Dictionary> findByRoot(boolean root, long groupId,
		int start, int end) {
		return getPersistence().findByRoot(root, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries where root = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param root the root
	* @param groupId the group ID
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionaries
	*/
	public static List<Dictionary> findByRoot(boolean root, long groupId,
		int start, int end, OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .findByRoot(root, groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionaries where root = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param root the root
	* @param groupId the group ID
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dictionaries
	*/
	public static List<Dictionary> findByRoot(boolean root, long groupId,
		int start, int end, OrderByComparator<Dictionary> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByRoot(root, groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dictionary in the ordered set where root = &#63; and groupId = &#63;.
	*
	* @param root the root
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public static Dictionary findByRoot_First(boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence()
				   .findByRoot_First(root, groupId, orderByComparator);
	}

	/**
	* Returns the first dictionary in the ordered set where root = &#63; and groupId = &#63;.
	*
	* @param root the root
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByRoot_First(boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .fetchByRoot_First(root, groupId, orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where root = &#63; and groupId = &#63;.
	*
	* @param root the root
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public static Dictionary findByRoot_Last(boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence().findByRoot_Last(root, groupId, orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where root = &#63; and groupId = &#63;.
	*
	* @param root the root
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByRoot_Last(boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .fetchByRoot_Last(root, groupId, orderByComparator);
	}

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set where root = &#63; and groupId = &#63;.
	*
	* @param dictionaryId the primary key of the current dictionary
	* @param root the root
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public static Dictionary[] findByRoot_PrevAndNext(long dictionaryId,
		boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence()
				   .findByRoot_PrevAndNext(dictionaryId, root, groupId,
			orderByComparator);
	}

	/**
	* Returns all the dictionaries that the user has permission to view where root = &#63; and groupId = &#63;.
	*
	* @param root the root
	* @param groupId the group ID
	* @return the matching dictionaries that the user has permission to view
	*/
	public static List<Dictionary> filterFindByRoot(boolean root, long groupId) {
		return getPersistence().filterFindByRoot(root, groupId);
	}

	/**
	* Returns a range of all the dictionaries that the user has permission to view where root = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param root the root
	* @param groupId the group ID
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of matching dictionaries that the user has permission to view
	*/
	public static List<Dictionary> filterFindByRoot(boolean root, long groupId,
		int start, int end) {
		return getPersistence().filterFindByRoot(root, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries that the user has permissions to view where root = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param root the root
	* @param groupId the group ID
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionaries that the user has permission to view
	*/
	public static List<Dictionary> filterFindByRoot(boolean root, long groupId,
		int start, int end, OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .filterFindByRoot(root, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set of dictionaries that the user has permission to view where root = &#63; and groupId = &#63;.
	*
	* @param dictionaryId the primary key of the current dictionary
	* @param root the root
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public static Dictionary[] filterFindByRoot_PrevAndNext(long dictionaryId,
		boolean root, long groupId,
		OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence()
				   .filterFindByRoot_PrevAndNext(dictionaryId, root, groupId,
			orderByComparator);
	}

	/**
	* Removes all the dictionaries where root = &#63; and groupId = &#63; from the database.
	*
	* @param root the root
	* @param groupId the group ID
	*/
	public static void removeByRoot(boolean root, long groupId) {
		getPersistence().removeByRoot(root, groupId);
	}

	/**
	* Returns the number of dictionaries where root = &#63; and groupId = &#63;.
	*
	* @param root the root
	* @param groupId the group ID
	* @return the number of matching dictionaries
	*/
	public static int countByRoot(boolean root, long groupId) {
		return getPersistence().countByRoot(root, groupId);
	}

	/**
	* Returns the number of dictionaries that the user has permission to view where root = &#63; and groupId = &#63;.
	*
	* @param root the root
	* @param groupId the group ID
	* @return the number of matching dictionaries that the user has permission to view
	*/
	public static int filterCountByRoot(boolean root, long groupId) {
		return getPersistence().filterCountByRoot(root, groupId);
	}

	/**
	* Returns the dictionary where dictionaryId = &#63; and groupId = &#63; or throws a {@link NoSuchDictionaryException} if it could not be found.
	*
	* @param dictionaryId the dictionary ID
	* @param groupId the group ID
	* @return the matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public static Dictionary findByDirectory(long dictionaryId, long groupId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence().findByDirectory(dictionaryId, groupId);
	}

	/**
	* Returns the dictionary where dictionaryId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dictionaryId the dictionary ID
	* @param groupId the group ID
	* @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByDirectory(long dictionaryId, long groupId) {
		return getPersistence().fetchByDirectory(dictionaryId, groupId);
	}

	/**
	* Returns the dictionary where dictionaryId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dictionaryId the dictionary ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByDirectory(long dictionaryId, long groupId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByDirectory(dictionaryId, groupId, retrieveFromCache);
	}

	/**
	* Removes the dictionary where dictionaryId = &#63; and groupId = &#63; from the database.
	*
	* @param dictionaryId the dictionary ID
	* @param groupId the group ID
	* @return the dictionary that was removed
	*/
	public static Dictionary removeByDirectory(long dictionaryId, long groupId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence().removeByDirectory(dictionaryId, groupId);
	}

	/**
	* Returns the number of dictionaries where dictionaryId = &#63; and groupId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param groupId the group ID
	* @return the number of matching dictionaries
	*/
	public static int countByDirectory(long dictionaryId, long groupId) {
		return getPersistence().countByDirectory(dictionaryId, groupId);
	}

	/**
	* Caches the dictionary in the entity cache if it is enabled.
	*
	* @param dictionary the dictionary
	*/
	public static void cacheResult(Dictionary dictionary) {
		getPersistence().cacheResult(dictionary);
	}

	/**
	* Caches the dictionaries in the entity cache if it is enabled.
	*
	* @param dictionaries the dictionaries
	*/
	public static void cacheResult(List<Dictionary> dictionaries) {
		getPersistence().cacheResult(dictionaries);
	}

	/**
	* Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	*
	* @param dictionaryId the primary key for the new dictionary
	* @return the new dictionary
	*/
	public static Dictionary create(long dictionaryId) {
		return getPersistence().create(dictionaryId);
	}

	/**
	* Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary that was removed
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public static Dictionary remove(long dictionaryId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence().remove(dictionaryId);
	}

	public static Dictionary updateImpl(Dictionary dictionary) {
		return getPersistence().updateImpl(dictionary);
	}

	/**
	* Returns the dictionary with the primary key or throws a {@link NoSuchDictionaryException} if it could not be found.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public static Dictionary findByPrimaryKey(long dictionaryId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return getPersistence().findByPrimaryKey(dictionaryId);
	}

	/**
	* Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	*/
	public static Dictionary fetchByPrimaryKey(long dictionaryId) {
		return getPersistence().fetchByPrimaryKey(dictionaryId);
	}

	public static java.util.Map<java.io.Serializable, Dictionary> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the dictionaries.
	*
	* @return the dictionaries
	*/
	public static List<Dictionary> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of dictionaries
	*/
	public static List<Dictionary> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dictionaries
	*/
	public static List<Dictionary> findAll(int start, int end,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of dictionaries
	*/
	public static List<Dictionary> findAll(int start, int end,
		OrderByComparator<Dictionary> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the dictionaries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dictionaries.
	*
	* @return the number of dictionaries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DictionaryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DictionaryPersistence, DictionaryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DictionaryPersistence.class);
}