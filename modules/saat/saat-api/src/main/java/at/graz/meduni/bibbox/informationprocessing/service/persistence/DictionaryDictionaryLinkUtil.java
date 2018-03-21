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

import at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the dictionary dictionary link service. This utility wraps {@link at.graz.meduni.bibbox.informationprocessing.service.persistence.impl.DictionaryDictionaryLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see DictionaryDictionaryLinkPersistence
 * @see at.graz.meduni.bibbox.informationprocessing.service.persistence.impl.DictionaryDictionaryLinkPersistenceImpl
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkUtil {
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
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		getPersistence().clearCache(dictionaryDictionaryLink);
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
	public static List<DictionaryDictionaryLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DictionaryDictionaryLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DictionaryDictionaryLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DictionaryDictionaryLink update(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		return getPersistence().update(dictionaryDictionaryLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DictionaryDictionaryLink update(
		DictionaryDictionaryLink dictionaryDictionaryLink,
		ServiceContext serviceContext) {
		return getPersistence().update(dictionaryDictionaryLink, serviceContext);
	}

	/**
	* Returns all the dictionary dictionary links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByUuid(
		java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the dictionary dictionary links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByUuid(
		java.lang.String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByUuid(
		java.lang.String uuid, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByUuid_First(
		java.lang.String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByUuid_First(
		java.lang.String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByUuid_Last(
		java.lang.String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where uuid = &#63;.
	*
	* @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink[] findByUuid_PrevAndNext(
		long dictionarydictionarylinkId, java.lang.String uuid,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByUuid_PrevAndNext(dictionarydictionarylinkId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the dictionary dictionary links where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of dictionary dictionary links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching dictionary dictionary links
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the dictionary dictionary link where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDictionaryDictionaryLinkException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByUUID_G(java.lang.String uuid,
		long groupId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the dictionary dictionary link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByUUID_G(
		java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the dictionary dictionary link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the dictionary dictionary link where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the dictionary dictionary link that was removed
	*/
	public static DictionaryDictionaryLink removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of dictionary dictionary links where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching dictionary dictionary links
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByUuid_C(
		java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink[] findByUuid_C_PrevAndNext(
		long dictionarydictionarylinkId, java.lang.String uuid, long companyId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(dictionarydictionarylinkId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the dictionary dictionary links where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching dictionary dictionary links
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the dictionary dictionary links where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @return the matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByDictionary(
		long dictionaryId) {
		return getPersistence().findByDictionary(dictionaryId);
	}

	/**
	* Returns a range of all the dictionary dictionary links where dictionaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionaryId the dictionary ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByDictionary(
		long dictionaryId, int start, int end) {
		return getPersistence().findByDictionary(dictionaryId, start, end);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where dictionaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionaryId the dictionary ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByDictionary(
		long dictionaryId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .findByDictionary(dictionaryId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where dictionaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionaryId the dictionary ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByDictionary(
		long dictionaryId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDictionary(dictionaryId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByDictionary_First(
		long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByDictionary_First(dictionaryId, orderByComparator);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByDictionary_First(
		long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .fetchByDictionary_First(dictionaryId, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByDictionary_Last(
		long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByDictionary_Last(dictionaryId, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByDictionary_Last(
		long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .fetchByDictionary_Last(dictionaryId, orderByComparator);
	}

	/**
	* Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink[] findByDictionary_PrevAndNext(
		long dictionarydictionarylinkId, long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByDictionary_PrevAndNext(dictionarydictionarylinkId,
			dictionaryId, orderByComparator);
	}

	/**
	* Removes all the dictionary dictionary links where dictionaryId = &#63; from the database.
	*
	* @param dictionaryId the dictionary ID
	*/
	public static void removeByDictionary(long dictionaryId) {
		getPersistence().removeByDictionary(dictionaryId);
	}

	/**
	* Returns the number of dictionary dictionary links where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @return the number of matching dictionary dictionary links
	*/
	public static int countByDictionary(long dictionaryId) {
		return getPersistence().countByDictionary(dictionaryId);
	}

	/**
	* Returns all the dictionary dictionary links where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @return the matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByLink(
		long linkdictionaryId) {
		return getPersistence().findByLink(linkdictionaryId);
	}

	/**
	* Returns a range of all the dictionary dictionary links where linkdictionaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByLink(
		long linkdictionaryId, int start, int end) {
		return getPersistence().findByLink(linkdictionaryId, start, end);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where linkdictionaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByLink(
		long linkdictionaryId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .findByLink(linkdictionaryId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where linkdictionaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByLink(
		long linkdictionaryId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByLink(linkdictionaryId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByLink_First(
		long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByLink_First(linkdictionaryId, orderByComparator);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByLink_First(
		long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .fetchByLink_First(linkdictionaryId, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByLink_Last(
		long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByLink_Last(linkdictionaryId, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByLink_Last(
		long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .fetchByLink_Last(linkdictionaryId, orderByComparator);
	}

	/**
	* Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	*
	* @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	* @param linkdictionaryId the linkdictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink[] findByLink_PrevAndNext(
		long dictionarydictionarylinkId, long linkdictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByLink_PrevAndNext(dictionarydictionarylinkId,
			linkdictionaryId, orderByComparator);
	}

	/**
	* Removes all the dictionary dictionary links where linkdictionaryId = &#63; from the database.
	*
	* @param linkdictionaryId the linkdictionary ID
	*/
	public static void removeByLink(long linkdictionaryId) {
		getPersistence().removeByLink(linkdictionaryId);
	}

	/**
	* Returns the number of dictionary dictionary links where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @return the number of matching dictionary dictionary links
	*/
	public static int countByLink(long linkdictionaryId) {
		return getPersistence().countByLink(linkdictionaryId);
	}

	/**
	* Caches the dictionary dictionary link in the entity cache if it is enabled.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	*/
	public static void cacheResult(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		getPersistence().cacheResult(dictionaryDictionaryLink);
	}

	/**
	* Caches the dictionary dictionary links in the entity cache if it is enabled.
	*
	* @param dictionaryDictionaryLinks the dictionary dictionary links
	*/
	public static void cacheResult(
		List<DictionaryDictionaryLink> dictionaryDictionaryLinks) {
		getPersistence().cacheResult(dictionaryDictionaryLinks);
	}

	/**
	* Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	*
	* @param dictionarydictionarylinkId the primary key for the new dictionary dictionary link
	* @return the new dictionary dictionary link
	*/
	public static DictionaryDictionaryLink create(
		long dictionarydictionarylinkId) {
		return getPersistence().create(dictionarydictionarylinkId);
	}

	/**
	* Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink remove(
		long dictionarydictionarylinkId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence().remove(dictionarydictionarylinkId);
	}

	public static DictionaryDictionaryLink updateImpl(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		return getPersistence().updateImpl(dictionaryDictionaryLink);
	}

	/**
	* Returns the dictionary dictionary link with the primary key or throws a {@link NoSuchDictionaryDictionaryLinkException} if it could not be found.
	*
	* @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink findByPrimaryKey(
		long dictionarydictionarylinkId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence().findByPrimaryKey(dictionarydictionarylinkId);
	}

	/**
	* Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink fetchByPrimaryKey(
		long dictionarydictionarylinkId) {
		return getPersistence().fetchByPrimaryKey(dictionarydictionarylinkId);
	}

	public static java.util.Map<java.io.Serializable, DictionaryDictionaryLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the dictionary dictionary links.
	*
	* @return the dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findAll(int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findAll(int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the dictionary dictionary links from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dictionary dictionary links.
	*
	* @return the number of dictionary dictionary links
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DictionaryDictionaryLinkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DictionaryDictionaryLinkPersistence, DictionaryDictionaryLinkPersistence> _serviceTracker =
		ServiceTrackerFactory.open(DictionaryDictionaryLinkPersistence.class);
}