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

import at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the kloetzel buch service. This utility wraps {@link at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.KloetzelBuchPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KloetzelBuchPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.KloetzelBuchPersistenceImpl
 * @generated
 */
@ProviderType
public class KloetzelBuchUtil {
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
	public static void clearCache(KloetzelBuch kloetzelBuch) {
		getPersistence().clearCache(kloetzelBuch);
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
	public static List<KloetzelBuch> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KloetzelBuch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KloetzelBuch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static KloetzelBuch update(KloetzelBuch kloetzelBuch) {
		return getPersistence().update(kloetzelBuch);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static KloetzelBuch update(KloetzelBuch kloetzelBuch,
		ServiceContext serviceContext) {
		return getPersistence().update(kloetzelBuch, serviceContext);
	}

	/**
	* Returns all the kloetzel buchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the kloetzel buchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @return the range of matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the kloetzel buchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the kloetzel buchs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<KloetzelBuch> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first kloetzel buch in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch findByUuid_First(java.lang.String uuid,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first kloetzel buch in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last kloetzel buch in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch findByUuid_Last(java.lang.String uuid,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last kloetzel buch in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the kloetzel buchs before and after the current kloetzel buch in the ordered set where uuid = &#63;.
	*
	* @param kloetzelBuchId the primary key of the current kloetzel buch
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kloetzel buch
	* @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	*/
	public static KloetzelBuch[] findByUuid_PrevAndNext(long kloetzelBuchId,
		java.lang.String uuid, OrderByComparator<KloetzelBuch> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence()
				   .findByUuid_PrevAndNext(kloetzelBuchId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the kloetzel buchs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of kloetzel buchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching kloetzel buchs
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the kloetzel buch where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchKloetzelBuchException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch findByUUID_G(java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the kloetzel buch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the kloetzel buch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the kloetzel buch where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the kloetzel buch that was removed
	*/
	public static KloetzelBuch removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of kloetzel buchs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching kloetzel buchs
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the kloetzel buchs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the kloetzel buchs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @return the range of matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the kloetzel buchs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the kloetzel buchs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<KloetzelBuch> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<KloetzelBuch> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the kloetzel buchs before and after the current kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param kloetzelBuchId the primary key of the current kloetzel buch
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kloetzel buch
	* @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	*/
	public static KloetzelBuch[] findByUuid_C_PrevAndNext(long kloetzelBuchId,
		java.lang.String uuid, long companyId,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(kloetzelBuchId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the kloetzel buchs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of kloetzel buchs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching kloetzel buchs
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the kloetzel buchs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the kloetzel buchs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @return the range of matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the kloetzel buchs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByGroupId(long groupId, int start,
		int end, OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the kloetzel buchs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching kloetzel buchs
	*/
	public static List<KloetzelBuch> findByGroupId(long groupId, int start,
		int end, OrderByComparator<KloetzelBuch> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first kloetzel buch in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch findByGroupId_First(long groupId,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first kloetzel buch in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch fetchByGroupId_First(long groupId,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last kloetzel buch in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch findByGroupId_Last(long groupId,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last kloetzel buch in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch fetchByGroupId_Last(long groupId,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the kloetzel buchs before and after the current kloetzel buch in the ordered set where groupId = &#63;.
	*
	* @param kloetzelBuchId the primary key of the current kloetzel buch
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kloetzel buch
	* @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	*/
	public static KloetzelBuch[] findByGroupId_PrevAndNext(
		long kloetzelBuchId, long groupId,
		OrderByComparator<KloetzelBuch> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(kloetzelBuchId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the kloetzel buchs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of kloetzel buchs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching kloetzel buchs
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the kloetzel buch where medicalRecordId = &#63; or throws a {@link NoSuchKloetzelBuchException} if it could not be found.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch findByMedicalRecord(long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence().findByMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the kloetzel buch where medicalRecordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch fetchByMedicalRecord(long medicalRecordId) {
		return getPersistence().fetchByMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the kloetzel buch where medicalRecordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param medicalRecordId the medical record ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static KloetzelBuch fetchByMedicalRecord(long medicalRecordId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByMedicalRecord(medicalRecordId, retrieveFromCache);
	}

	/**
	* Removes the kloetzel buch where medicalRecordId = &#63; from the database.
	*
	* @param medicalRecordId the medical record ID
	* @return the kloetzel buch that was removed
	*/
	public static KloetzelBuch removeByMedicalRecord(long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence().removeByMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the number of kloetzel buchs where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @return the number of matching kloetzel buchs
	*/
	public static int countByMedicalRecord(long medicalRecordId) {
		return getPersistence().countByMedicalRecord(medicalRecordId);
	}

	/**
	* Caches the kloetzel buch in the entity cache if it is enabled.
	*
	* @param kloetzelBuch the kloetzel buch
	*/
	public static void cacheResult(KloetzelBuch kloetzelBuch) {
		getPersistence().cacheResult(kloetzelBuch);
	}

	/**
	* Caches the kloetzel buchs in the entity cache if it is enabled.
	*
	* @param kloetzelBuchs the kloetzel buchs
	*/
	public static void cacheResult(List<KloetzelBuch> kloetzelBuchs) {
		getPersistence().cacheResult(kloetzelBuchs);
	}

	/**
	* Creates a new kloetzel buch with the primary key. Does not add the kloetzel buch to the database.
	*
	* @param kloetzelBuchId the primary key for the new kloetzel buch
	* @return the new kloetzel buch
	*/
	public static KloetzelBuch create(long kloetzelBuchId) {
		return getPersistence().create(kloetzelBuchId);
	}

	/**
	* Removes the kloetzel buch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kloetzelBuchId the primary key of the kloetzel buch
	* @return the kloetzel buch that was removed
	* @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	*/
	public static KloetzelBuch remove(long kloetzelBuchId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence().remove(kloetzelBuchId);
	}

	public static KloetzelBuch updateImpl(KloetzelBuch kloetzelBuch) {
		return getPersistence().updateImpl(kloetzelBuch);
	}

	/**
	* Returns the kloetzel buch with the primary key or throws a {@link NoSuchKloetzelBuchException} if it could not be found.
	*
	* @param kloetzelBuchId the primary key of the kloetzel buch
	* @return the kloetzel buch
	* @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	*/
	public static KloetzelBuch findByPrimaryKey(long kloetzelBuchId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getPersistence().findByPrimaryKey(kloetzelBuchId);
	}

	/**
	* Returns the kloetzel buch with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param kloetzelBuchId the primary key of the kloetzel buch
	* @return the kloetzel buch, or <code>null</code> if a kloetzel buch with the primary key could not be found
	*/
	public static KloetzelBuch fetchByPrimaryKey(long kloetzelBuchId) {
		return getPersistence().fetchByPrimaryKey(kloetzelBuchId);
	}

	public static java.util.Map<java.io.Serializable, KloetzelBuch> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the kloetzel buchs.
	*
	* @return the kloetzel buchs
	*/
	public static List<KloetzelBuch> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the kloetzel buchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @return the range of kloetzel buchs
	*/
	public static List<KloetzelBuch> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the kloetzel buchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of kloetzel buchs
	*/
	public static List<KloetzelBuch> findAll(int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the kloetzel buchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of kloetzel buchs
	*/
	public static List<KloetzelBuch> findAll(int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the kloetzel buchs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of kloetzel buchs.
	*
	* @return the number of kloetzel buchs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static KloetzelBuchPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<KloetzelBuchPersistence, KloetzelBuchPersistence> _serviceTracker =
		ServiceTrackerFactory.open(KloetzelBuchPersistence.class);
}