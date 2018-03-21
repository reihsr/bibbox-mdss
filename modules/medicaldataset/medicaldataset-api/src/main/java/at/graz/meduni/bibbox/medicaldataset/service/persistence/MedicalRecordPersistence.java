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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchMedicalRecordException;
import at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the medical record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.MedicalRecordPersistenceImpl
 * @see MedicalRecordUtil
 * @generated
 */
@ProviderType
public interface MedicalRecordPersistence extends BasePersistence<MedicalRecord> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MedicalRecordUtil} to access the medical record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the medical records where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching medical records
	*/
	public java.util.List<MedicalRecord> findByUuid(java.lang.String uuid);

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
	public java.util.List<MedicalRecord> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<MedicalRecord> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

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
	public java.util.List<MedicalRecord> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first medical record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public MedicalRecord findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the first medical record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public MedicalRecord fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

	/**
	* Returns the last medical record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public MedicalRecord findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the last medical record in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public MedicalRecord fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

	/**
	* Returns the medical records before and after the current medical record in the ordered set where uuid = &#63;.
	*
	* @param medicalRecordId the primary key of the current medical record
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next medical record
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public MedicalRecord[] findByUuid_PrevAndNext(long medicalRecordId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Removes all the medical records where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of medical records where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching medical records
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the medical record where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchMedicalRecordException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public MedicalRecord findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the medical record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public MedicalRecord fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the medical record where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public MedicalRecord fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the medical record where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the medical record that was removed
	*/
	public MedicalRecord removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the number of medical records where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching medical records
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the medical records where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching medical records
	*/
	public java.util.List<MedicalRecord> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<MedicalRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<MedicalRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

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
	public java.util.List<MedicalRecord> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public MedicalRecord findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the first medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public MedicalRecord fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

	/**
	* Returns the last medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public MedicalRecord findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the last medical record in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public MedicalRecord fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

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
	public MedicalRecord[] findByUuid_C_PrevAndNext(long medicalRecordId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Removes all the medical records where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of medical records where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching medical records
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the medical records where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching medical records
	*/
	public java.util.List<MedicalRecord> findByGroupId(long groupId);

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
	public java.util.List<MedicalRecord> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<MedicalRecord> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

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
	public java.util.List<MedicalRecord> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first medical record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public MedicalRecord findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the first medical record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public MedicalRecord fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

	/**
	* Returns the last medical record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public MedicalRecord findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the last medical record in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public MedicalRecord fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

	/**
	* Returns the medical records before and after the current medical record in the ordered set where groupId = &#63;.
	*
	* @param medicalRecordId the primary key of the current medical record
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next medical record
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public MedicalRecord[] findByGroupId_PrevAndNext(long medicalRecordId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Removes all the medical records where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of medical records where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching medical records
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the medical records where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @return the matching medical records
	*/
	public java.util.List<MedicalRecord> findByINumber(long iNumber);

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
	public java.util.List<MedicalRecord> findByINumber(long iNumber, int start,
		int end);

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
	public java.util.List<MedicalRecord> findByINumber(long iNumber, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

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
	public java.util.List<MedicalRecord> findByINumber(long iNumber, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first medical record in the ordered set where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public MedicalRecord findByINumber_First(long iNumber,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the first medical record in the ordered set where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public MedicalRecord fetchByINumber_First(long iNumber,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

	/**
	* Returns the last medical record in the ordered set where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record
	* @throws NoSuchMedicalRecordException if a matching medical record could not be found
	*/
	public MedicalRecord findByINumber_Last(long iNumber,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the last medical record in the ordered set where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	public MedicalRecord fetchByINumber_Last(long iNumber,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

	/**
	* Returns the medical records before and after the current medical record in the ordered set where iNumber = &#63;.
	*
	* @param medicalRecordId the primary key of the current medical record
	* @param iNumber the i number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next medical record
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public MedicalRecord[] findByINumber_PrevAndNext(long medicalRecordId,
		long iNumber,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator)
		throws NoSuchMedicalRecordException;

	/**
	* Removes all the medical records where iNumber = &#63; from the database.
	*
	* @param iNumber the i number
	*/
	public void removeByINumber(long iNumber);

	/**
	* Returns the number of medical records where iNumber = &#63;.
	*
	* @param iNumber the i number
	* @return the number of matching medical records
	*/
	public int countByINumber(long iNumber);

	/**
	* Caches the medical record in the entity cache if it is enabled.
	*
	* @param medicalRecord the medical record
	*/
	public void cacheResult(MedicalRecord medicalRecord);

	/**
	* Caches the medical records in the entity cache if it is enabled.
	*
	* @param medicalRecords the medical records
	*/
	public void cacheResult(java.util.List<MedicalRecord> medicalRecords);

	/**
	* Creates a new medical record with the primary key. Does not add the medical record to the database.
	*
	* @param medicalRecordId the primary key for the new medical record
	* @return the new medical record
	*/
	public MedicalRecord create(long medicalRecordId);

	/**
	* Removes the medical record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param medicalRecordId the primary key of the medical record
	* @return the medical record that was removed
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public MedicalRecord remove(long medicalRecordId)
		throws NoSuchMedicalRecordException;

	public MedicalRecord updateImpl(MedicalRecord medicalRecord);

	/**
	* Returns the medical record with the primary key or throws a {@link NoSuchMedicalRecordException} if it could not be found.
	*
	* @param medicalRecordId the primary key of the medical record
	* @return the medical record
	* @throws NoSuchMedicalRecordException if a medical record with the primary key could not be found
	*/
	public MedicalRecord findByPrimaryKey(long medicalRecordId)
		throws NoSuchMedicalRecordException;

	/**
	* Returns the medical record with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param medicalRecordId the primary key of the medical record
	* @return the medical record, or <code>null</code> if a medical record with the primary key could not be found
	*/
	public MedicalRecord fetchByPrimaryKey(long medicalRecordId);

	@Override
	public java.util.Map<java.io.Serializable, MedicalRecord> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the medical records.
	*
	* @return the medical records
	*/
	public java.util.List<MedicalRecord> findAll();

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
	public java.util.List<MedicalRecord> findAll(int start, int end);

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
	public java.util.List<MedicalRecord> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator);

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
	public java.util.List<MedicalRecord> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MedicalRecord> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the medical records from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of medical records.
	*
	* @return the number of medical records
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}