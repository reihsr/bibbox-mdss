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

import at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the medical record service. This utility wraps {@link at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.MedicalRecordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MedicalRecordPersistence
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.MedicalRecordPersistenceImpl
 * @generated
 */
@ProviderType
public class MedicalRecordUtil {
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
	public static void clearCache(MedicalRecord medicalRecord) {
		getPersistence().clearCache(medicalRecord);
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
	public static List<MedicalRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MedicalRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MedicalRecord> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MedicalRecord update(MedicalRecord medicalRecord) {
		return getPersistence().update(medicalRecord);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MedicalRecord update(MedicalRecord medicalRecord,
		ServiceContext serviceContext) {
		return getPersistence().update(medicalRecord, serviceContext);
	}

	/**
	* Returns all the medical records where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching medical records
	*/
	public static List<MedicalRecord> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the medical records where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @return the range of matching medical records
	*/
	public static List<MedicalRecord> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the medical records where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching medical records
	*/
	public static List<MedicalRecord> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the medical records where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching medical records
	*/
	public static List<MedicalRecord> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first medical record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public static MedicalRecord findByUuid_First(java.lang.String uuid,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first medical record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public static MedicalRecord fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last medical record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public static MedicalRecord findByUuid_Last(java.lang.String uuid,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last medical record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public static MedicalRecord fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the medical records before and after the current medical record in the ordered set where uuid = &#63;.
	*
	* @param medicalRecordId the primary key of the current medical record
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next medical record
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public static MedicalRecord[] findByUuid_PrevAndNext(long medicalRecordId,
		java.lang.String uuid,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence()
				   .findByUuid_PrevAndNext(medicalRecordId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the medical records where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of medical records where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching medical records
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the medical record where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchMedicalRecordException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public static MedicalRecord findByUUID_G(java.lang.String uuid, long groupId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the medical record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public static MedicalRecord fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the medical record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public static MedicalRecord fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the medical record where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the medical record that was removed
	*/
	public static MedicalRecord removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of medical records where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching medical records
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the medical records where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching medical records
	*/
	public static List<MedicalRecord> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the medical records where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @return the range of matching medical records
	*/
	public static List<MedicalRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the medical records where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching medical records
	*/
	public static List<MedicalRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the medical records where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching medical records
	*/
	public static List<MedicalRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public static MedicalRecord findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public static MedicalRecord fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public static MedicalRecord findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public static MedicalRecord fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the medical records before and after the current medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param medicalRecordId the primary key of the current medical record
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next medical record
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public static MedicalRecord[] findByUuid_C_PrevAndNext(
		long medicalRecordId, java.lang.String uuid, long companyId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(medicalRecordId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the medical records where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of medical records where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching medical records
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the medical records where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching medical records
	*/
	public static List<MedicalRecord> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the medical records where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @return the range of matching medical records
	*/
	public static List<MedicalRecord> findByGroupId(long groupId, int start,
		int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the medical records where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching medical records
	*/
	public static List<MedicalRecord> findByGroupId(long groupId, int start,
		int end, OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the medical records where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching medical records
	*/
	public static List<MedicalRecord> findByGroupId(long groupId, int start,
		int end, OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first medical record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public static MedicalRecord findByGroupId_First(long groupId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first medical record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public static MedicalRecord fetchByGroupId_First(long groupId,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last medical record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public static MedicalRecord findByGroupId_Last(long groupId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last medical record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public static MedicalRecord fetchByGroupId_Last(long groupId,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the medical records before and after the current medical record in the ordered set where groupId = &#63;.
	*
	* @param medicalRecordId the primary key of the current medical record
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next medical record
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public static MedicalRecord[] findByGroupId_PrevAndNext(
		long medicalRecordId, long groupId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(medicalRecordId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the medical records that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching medical records that the user has permission to view
	*/
	public static List<MedicalRecord> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the medical records that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @return the range of matching medical records that the user has permission to view
	*/
	public static List<MedicalRecord> filterFindByGroupId(long groupId,
		int start, int end) {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the medical records that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching medical records that the user has permission to view
	*/
	public static List<MedicalRecord> filterFindByGroupId(long groupId,
		int start, int end, OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the medical records before and after the current medical record in the ordered set of medical records that the user has permission to view where groupId = &#63;.
	*
	* @param medicalRecordId the primary key of the current medical record
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next medical record
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public static MedicalRecord[] filterFindByGroupId_PrevAndNext(
		long medicalRecordId, long groupId,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(medicalRecordId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the medical records where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of medical records where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching medical records
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of medical records that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching medical records that the user has permission to view
	*/
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the medical records where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @return the matching medical records
	*/
	public static List<MedicalRecord> findByINumber(long iNumber) {
		return getPersistence().findByINumber(iNumber);
	}

	/**
	* Returns a range of all the medical records where iNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param iNumber the i number
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @return the range of matching medical records
	*/
	public static List<MedicalRecord> findByINumber(long iNumber, int start,
		int end) {
		return getPersistence().findByINumber(iNumber, start, end);
	}

	/**
	* Returns an ordered range of all the medical records where iNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param iNumber the i number
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching medical records
	*/
	public static List<MedicalRecord> findByINumber(long iNumber, int start,
		int end, OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence()
				   .findByINumber(iNumber, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the medical records where iNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param iNumber the i number
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching medical records
	*/
	public static List<MedicalRecord> findByINumber(long iNumber, int start,
		int end, OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByINumber(iNumber, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first medical record in the ordered set where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public static MedicalRecord findByINumber_First(long iNumber,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence().findByINumber_First(iNumber, orderByComparator);
	}

	/**
	* Returns the first medical record in the ordered set where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public static MedicalRecord fetchByINumber_First(long iNumber,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence().fetchByINumber_First(iNumber, orderByComparator);
	}

	/**
	* Returns the last medical record in the ordered set where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public static MedicalRecord findByINumber_Last(long iNumber,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence().findByINumber_Last(iNumber, orderByComparator);
	}

	/**
	* Returns the last medical record in the ordered set where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public static MedicalRecord fetchByINumber_Last(long iNumber,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence().fetchByINumber_Last(iNumber, orderByComparator);
	}

	/**
	* Returns the medical records before and after the current medical record in the ordered set where iNumber = &#63;.
	*
	* @param medicalRecordId the primary key of the current medical record
	* @param iNumber the i number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next medical record
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public static MedicalRecord[] findByINumber_PrevAndNext(
		long medicalRecordId, long iNumber,
		OrderByComparator<MedicalRecord> orderByComparator)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence()
				   .findByINumber_PrevAndNext(medicalRecordId, iNumber,
			orderByComparator);
	}

	/**
	* Removes all the medical records where iNumber = &#63; from the database.
	*
	* @param iNumber the i number
	*/
	public static void removeByINumber(long iNumber) {
		getPersistence().removeByINumber(iNumber);
	}

	/**
	* Returns the number of medical records where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @return the number of matching medical records
	*/
	public static int countByINumber(long iNumber) {
		return getPersistence().countByINumber(iNumber);
	}

	/**
	* Caches the medical record in the entity cache if it is enabled.
	*
	* @param medicalRecord the medical record
	*/
	public static void cacheResult(MedicalRecord medicalRecord) {
		getPersistence().cacheResult(medicalRecord);
	}

	/**
	* Caches the medical records in the entity cache if it is enabled.
	*
	* @param medicalRecords the medical records
	*/
	public static void cacheResult(List<MedicalRecord> medicalRecords) {
		getPersistence().cacheResult(medicalRecords);
	}

	/**
	* Creates a new medical record with the primary key. Does not add the medical record to the database.
	*
	* @param medicalRecordId the primary key for the new medical record
	* @return the new medical record
	*/
	public static MedicalRecord create(long medicalRecordId) {
		return getPersistence().create(medicalRecordId);
	}

	/**
	* Removes the medical record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param medicalRecordId the primary key of the medical record
	* @return the medical record that was removed
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public static MedicalRecord remove(long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence().remove(medicalRecordId);
	}

	public static MedicalRecord updateImpl(MedicalRecord medicalRecord) {
		return getPersistence().updateImpl(medicalRecord);
	}

	/**
	* Returns the medical record with the primary key or throws a {@link NoSuchMedicalRecordException} if it could not be found.
	*
	* @param medicalRecordId the primary key of the medical record
	* @return the medical record
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public static MedicalRecord findByPrimaryKey(long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException {
		return getPersistence().findByPrimaryKey(medicalRecordId);
	}

	/**
	* Returns the medical record with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param medicalRecordId the primary key of the medical record
	* @return the medical record, or <code>null</code> if a medical record with the primary key could not be found
	*/
	public static MedicalRecord fetchByPrimaryKey(long medicalRecordId) {
		return getPersistence().fetchByPrimaryKey(medicalRecordId);
	}

	public static java.util.Map<java.io.Serializable, MedicalRecord> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the medical records.
	*
	* @return the medical records
	*/
	public static List<MedicalRecord> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the medical records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @return the range of medical records
	*/
	public static List<MedicalRecord> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the medical records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of medical records
	*/
	public static List<MedicalRecord> findAll(int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the medical records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of medical records
	*/
	public static List<MedicalRecord> findAll(int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the medical records from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of medical records.
	*
	* @return the number of medical records
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static MedicalRecordPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MedicalRecordPersistence, MedicalRecordPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MedicalRecordPersistence.class);
}