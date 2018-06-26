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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetLogException;
import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the import medical data set log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.ImportMedicalDataSetLogPersistenceImpl
 * @see ImportMedicalDataSetLogUtil
 * @generated
 */
@ProviderType
public interface ImportMedicalDataSetLogPersistence extends BasePersistence<ImportMedicalDataSetLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImportMedicalDataSetLogUtil} to access the import medical data set log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the import medical data set logs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching import medical data set logs
	*/
	public java.util.List<ImportMedicalDataSetLog> findByUuid(
		java.lang.String uuid);

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
	public java.util.List<ImportMedicalDataSetLog> findByUuid(
		java.lang.String uuid, int start, int end);

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
	public java.util.List<ImportMedicalDataSetLog> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

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
	public java.util.List<ImportMedicalDataSetLog> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first import medical data set log in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the first import medical data set log in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

	/**
	* Returns the last import medical data set log in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the last import medical data set log in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

	/**
	* Returns the import medical data set logs before and after the current import medical data set log in the ordered set where uuid = &#63;.
	*
	* @param importMedicalDataSetLogId the primary key of the current import medical data set log
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	*/
	public ImportMedicalDataSetLog[] findByUuid_PrevAndNext(
		long importMedicalDataSetLogId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Removes all the import medical data set logs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of import medical data set logs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching import medical data set logs
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the import medical data set log where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchImportMedicalDataSetLogException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog findByUUID_G(java.lang.String uuid,
		long groupId) throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the import medical data set log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog fetchByUUID_G(java.lang.String uuid,
		long groupId);

	/**
	* Returns the import medical data set log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache);

	/**
	* Removes the import medical data set log where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the import medical data set log that was removed
	*/
	public ImportMedicalDataSetLog removeByUUID_G(java.lang.String uuid,
		long groupId) throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the number of import medical data set logs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching import medical data set logs
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the import medical data set logs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching import medical data set logs
	*/
	public java.util.List<ImportMedicalDataSetLog> findByUuid_C(
		java.lang.String uuid, long companyId);

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
	public java.util.List<ImportMedicalDataSetLog> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end);

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
	public java.util.List<ImportMedicalDataSetLog> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

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
	public java.util.List<ImportMedicalDataSetLog> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the first import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

	/**
	* Returns the last import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the last import medical data set log in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

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
	public ImportMedicalDataSetLog[] findByUuid_C_PrevAndNext(
		long importMedicalDataSetLogId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Removes all the import medical data set logs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of import medical data set logs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching import medical data set logs
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the import medical data set logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching import medical data set logs
	*/
	public java.util.List<ImportMedicalDataSetLog> findByGroupId(long groupId);

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
	public java.util.List<ImportMedicalDataSetLog> findByGroupId(long groupId,
		int start, int end);

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
	public java.util.List<ImportMedicalDataSetLog> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

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
	public java.util.List<ImportMedicalDataSetLog> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first import medical data set log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the first import medical data set log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

	/**
	* Returns the last import medical data set log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the last import medical data set log in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

	/**
	* Returns the import medical data set logs before and after the current import medical data set log in the ordered set where groupId = &#63;.
	*
	* @param importMedicalDataSetLogId the primary key of the current import medical data set log
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	*/
	public ImportMedicalDataSetLog[] findByGroupId_PrevAndNext(
		long importMedicalDataSetLogId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns all the import medical data set logs that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching import medical data set logs that the user has permission to view
	*/
	public java.util.List<ImportMedicalDataSetLog> filterFindByGroupId(
		long groupId);

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
	public java.util.List<ImportMedicalDataSetLog> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<ImportMedicalDataSetLog> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

	/**
	* Returns the import medical data set logs before and after the current import medical data set log in the ordered set of import medical data set logs that the user has permission to view where groupId = &#63;.
	*
	* @param importMedicalDataSetLogId the primary key of the current import medical data set log
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	*/
	public ImportMedicalDataSetLog[] filterFindByGroupId_PrevAndNext(
		long importMedicalDataSetLogId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Removes all the import medical data set logs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of import medical data set logs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching import medical data set logs
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the number of import medical data set logs that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching import medical data set logs that the user has permission to view
	*/
	public int filterCountByGroupId(long groupId);

	/**
	* Returns all the import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63;.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	* @return the matching import medical data set logs
	*/
	public java.util.List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus);

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
	public java.util.List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus, int start, int end);

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
	public java.util.List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

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
	public java.util.List<ImportMedicalDataSetLog> findByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog findByImportMedicalDataSetAndImportStatus_First(
		long importMedicalDataSetId, int importStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the first import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog fetchByImportMedicalDataSetAndImportStatus_First(
		long importMedicalDataSetId, int importStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

	/**
	* Returns the last import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog findByImportMedicalDataSetAndImportStatus_Last(
		long importMedicalDataSetId, int importStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the last import medical data set log in the ordered set where importMedicalDataSetId = &#63; and importStatus = &#63;.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public ImportMedicalDataSetLog fetchByImportMedicalDataSetAndImportStatus_Last(
		long importMedicalDataSetId, int importStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

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
	public ImportMedicalDataSetLog[] findByImportMedicalDataSetAndImportStatus_PrevAndNext(
		long importMedicalDataSetLogId, long importMedicalDataSetId,
		int importStatus,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Removes all the import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63; from the database.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	*/
	public void removeByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus);

	/**
	* Returns the number of import medical data set logs where importMedicalDataSetId = &#63; and importStatus = &#63;.
	*
	* @param importMedicalDataSetId the import medical data set ID
	* @param importStatus the import status
	* @return the number of matching import medical data set logs
	*/
	public int countByImportMedicalDataSetAndImportStatus(
		long importMedicalDataSetId, int importStatus);

	/**
	* Caches the import medical data set log in the entity cache if it is enabled.
	*
	* @param importMedicalDataSetLog the import medical data set log
	*/
	public void cacheResult(ImportMedicalDataSetLog importMedicalDataSetLog);

	/**
	* Caches the import medical data set logs in the entity cache if it is enabled.
	*
	* @param importMedicalDataSetLogs the import medical data set logs
	*/
	public void cacheResult(
		java.util.List<ImportMedicalDataSetLog> importMedicalDataSetLogs);

	/**
	* Creates a new import medical data set log with the primary key. Does not add the import medical data set log to the database.
	*
	* @param importMedicalDataSetLogId the primary key for the new import medical data set log
	* @return the new import medical data set log
	*/
	public ImportMedicalDataSetLog create(long importMedicalDataSetLogId);

	/**
	* Removes the import medical data set log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetLogId the primary key of the import medical data set log
	* @return the import medical data set log that was removed
	* @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	*/
	public ImportMedicalDataSetLog remove(long importMedicalDataSetLogId)
		throws NoSuchImportMedicalDataSetLogException;

	public ImportMedicalDataSetLog updateImpl(
		ImportMedicalDataSetLog importMedicalDataSetLog);

	/**
	* Returns the import medical data set log with the primary key or throws a {@link NoSuchImportMedicalDataSetLogException} if it could not be found.
	*
	* @param importMedicalDataSetLogId the primary key of the import medical data set log
	* @return the import medical data set log
	* @throws NoSuchImportMedicalDataSetLogException if a import medical data set log with the primary key could not be found
	*/
	public ImportMedicalDataSetLog findByPrimaryKey(
		long importMedicalDataSetLogId)
		throws NoSuchImportMedicalDataSetLogException;

	/**
	* Returns the import medical data set log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param importMedicalDataSetLogId the primary key of the import medical data set log
	* @return the import medical data set log, or <code>null</code> if a import medical data set log with the primary key could not be found
	*/
	public ImportMedicalDataSetLog fetchByPrimaryKey(
		long importMedicalDataSetLogId);

	@Override
	public java.util.Map<java.io.Serializable, ImportMedicalDataSetLog> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the import medical data set logs.
	*
	* @return the import medical data set logs
	*/
	public java.util.List<ImportMedicalDataSetLog> findAll();

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
	public java.util.List<ImportMedicalDataSetLog> findAll(int start, int end);

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
	public java.util.List<ImportMedicalDataSetLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator);

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
	public java.util.List<ImportMedicalDataSetLog> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSetLog> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the import medical data set logs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of import medical data set logs.
	*
	* @return the number of import medical data set logs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}