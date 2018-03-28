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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchImportMedicalDataSetException;
import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the import medical data set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.ImportMedicalDataSetPersistenceImpl
 * @see ImportMedicalDataSetUtil
 * @generated
 */
@ProviderType
public interface ImportMedicalDataSetPersistence extends BasePersistence<ImportMedicalDataSet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImportMedicalDataSetUtil} to access the import medical data set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the import medical data sets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByUuid(
		java.lang.String uuid);

	/**
	* Returns a range of all the import medical data sets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @return the range of matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByUuid(
		java.lang.String uuid, int start, int end);

	/**
	* Returns an ordered range of all the import medical data sets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns an ordered range of all the import medical data sets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first import medical data set in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set
	* @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Returns the first import medical data set in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns the last import medical data set in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set
	* @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Returns the last import medical data set in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns the import medical data sets before and after the current import medical data set in the ordered set where uuid = &#63;.
	*
	* @param importMedicalDataSetId the primary key of the current import medical data set
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next import medical data set
	* @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	*/
	public ImportMedicalDataSet[] findByUuid_PrevAndNext(
		long importMedicalDataSetId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Removes all the import medical data sets where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of import medical data sets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching import medical data sets
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the import medical data set where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchImportMedicalDataSetException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching import medical data set
	* @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Returns the import medical data set where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet fetchByUUID_G(java.lang.String uuid,
		long groupId);

	/**
	* Returns the import medical data set where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache);

	/**
	* Removes the import medical data set where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the import medical data set that was removed
	*/
	public ImportMedicalDataSet removeByUUID_G(java.lang.String uuid,
		long groupId) throws NoSuchImportMedicalDataSetException;

	/**
	* Returns the number of import medical data sets where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching import medical data sets
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the import medical data sets where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByUuid_C(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of all the import medical data sets where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @return the range of matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end);

	/**
	* Returns an ordered range of all the import medical data sets where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns an ordered range of all the import medical data sets where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first import medical data set in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set
	* @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Returns the first import medical data set in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns the last import medical data set in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set
	* @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Returns the last import medical data set in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns the import medical data sets before and after the current import medical data set in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param importMedicalDataSetId the primary key of the current import medical data set
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next import medical data set
	* @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	*/
	public ImportMedicalDataSet[] findByUuid_C_PrevAndNext(
		long importMedicalDataSetId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Removes all the import medical data sets where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of import medical data sets where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching import medical data sets
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the import medical data sets where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByGroupId(long groupId);

	/**
	* Returns a range of all the import medical data sets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @return the range of matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByGroupId(long groupId,
		int start, int end);

	/**
	* Returns an ordered range of all the import medical data sets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns an ordered range of all the import medical data sets where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first import medical data set in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set
	* @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Returns the first import medical data set in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns the last import medical data set in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set
	* @throws NoSuchImportMedicalDataSetException if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Returns the last import medical data set in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	*/
	public ImportMedicalDataSet fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns the import medical data sets before and after the current import medical data set in the ordered set where groupId = &#63;.
	*
	* @param importMedicalDataSetId the primary key of the current import medical data set
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next import medical data set
	* @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	*/
	public ImportMedicalDataSet[] findByGroupId_PrevAndNext(
		long importMedicalDataSetId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Returns all the import medical data sets that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching import medical data sets that the user has permission to view
	*/
	public java.util.List<ImportMedicalDataSet> filterFindByGroupId(
		long groupId);

	/**
	* Returns a range of all the import medical data sets that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @return the range of matching import medical data sets that the user has permission to view
	*/
	public java.util.List<ImportMedicalDataSet> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	* Returns an ordered range of all the import medical data sets that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching import medical data sets that the user has permission to view
	*/
	public java.util.List<ImportMedicalDataSet> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns the import medical data sets before and after the current import medical data set in the ordered set of import medical data sets that the user has permission to view where groupId = &#63;.
	*
	* @param importMedicalDataSetId the primary key of the current import medical data set
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next import medical data set
	* @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	*/
	public ImportMedicalDataSet[] filterFindByGroupId_PrevAndNext(
		long importMedicalDataSetId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Removes all the import medical data sets where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of import medical data sets where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching import medical data sets
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the number of import medical data sets that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching import medical data sets that the user has permission to view
	*/
	public int filterCountByGroupId(long groupId);

	/**
	* Caches the import medical data set in the entity cache if it is enabled.
	*
	* @param importMedicalDataSet the import medical data set
	*/
	public void cacheResult(ImportMedicalDataSet importMedicalDataSet);

	/**
	* Caches the import medical data sets in the entity cache if it is enabled.
	*
	* @param importMedicalDataSets the import medical data sets
	*/
	public void cacheResult(
		java.util.List<ImportMedicalDataSet> importMedicalDataSets);

	/**
	* Creates a new import medical data set with the primary key. Does not add the import medical data set to the database.
	*
	* @param importMedicalDataSetId the primary key for the new import medical data set
	* @return the new import medical data set
	*/
	public ImportMedicalDataSet create(long importMedicalDataSetId);

	/**
	* Removes the import medical data set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetId the primary key of the import medical data set
	* @return the import medical data set that was removed
	* @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	*/
	public ImportMedicalDataSet remove(long importMedicalDataSetId)
		throws NoSuchImportMedicalDataSetException;

	public ImportMedicalDataSet updateImpl(
		ImportMedicalDataSet importMedicalDataSet);

	/**
	* Returns the import medical data set with the primary key or throws a {@link NoSuchImportMedicalDataSetException} if it could not be found.
	*
	* @param importMedicalDataSetId the primary key of the import medical data set
	* @return the import medical data set
	* @throws NoSuchImportMedicalDataSetException if a import medical data set with the primary key could not be found
	*/
	public ImportMedicalDataSet findByPrimaryKey(long importMedicalDataSetId)
		throws NoSuchImportMedicalDataSetException;

	/**
	* Returns the import medical data set with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param importMedicalDataSetId the primary key of the import medical data set
	* @return the import medical data set, or <code>null</code> if a import medical data set with the primary key could not be found
	*/
	public ImportMedicalDataSet fetchByPrimaryKey(long importMedicalDataSetId);

	@Override
	public java.util.Map<java.io.Serializable, ImportMedicalDataSet> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the import medical data sets.
	*
	* @return the import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findAll();

	/**
	* Returns a range of all the import medical data sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @return the range of import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findAll(int start, int end);

	/**
	* Returns an ordered range of all the import medical data sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator);

	/**
	* Returns an ordered range of all the import medical data sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of import medical data sets
	*/
	public java.util.List<ImportMedicalDataSet> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImportMedicalDataSet> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the import medical data sets from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of import medical data sets.
	*
	* @return the number of import medical data sets
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}