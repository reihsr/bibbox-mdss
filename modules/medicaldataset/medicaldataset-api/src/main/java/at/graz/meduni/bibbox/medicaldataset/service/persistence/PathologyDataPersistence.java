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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException;
import at.graz.meduni.bibbox.medicaldataset.model.PathologyData;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the pathology data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.PathologyDataPersistenceImpl
 * @see PathologyDataUtil
 * @generated
 */
@ProviderType
public interface PathologyDataPersistence extends BasePersistence<PathologyData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PathologyDataUtil} to access the pathology data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the pathology datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching pathology datas
	*/
	public java.util.List<PathologyData> findByUuid(java.lang.String uuid);

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
	public java.util.List<PathologyData> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<PathologyData> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

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
	public java.util.List<PathologyData> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pathology data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public PathologyData findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Returns the first pathology data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

	/**
	* Returns the last pathology data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public PathologyData findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Returns the last pathology data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

	/**
	* Returns the pathology datas before and after the current pathology data in the ordered set where uuid = &#63;.
	*
	* @param pathologyDataId the primary key of the current pathology data
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathology data
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public PathologyData[] findByUuid_PrevAndNext(long pathologyDataId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Removes all the pathology datas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of pathology datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching pathology datas
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the pathology data where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPathologyDataException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public PathologyData findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchPathologyDataException;

	/**
	* Returns the pathology data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the pathology data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the pathology data where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the pathology data that was removed
	*/
	public PathologyData removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchPathologyDataException;

	/**
	* Returns the number of pathology datas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching pathology datas
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the pathology datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching pathology datas
	*/
	public java.util.List<PathologyData> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<PathologyData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<PathologyData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

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
	public java.util.List<PathologyData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public PathologyData findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Returns the first pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

	/**
	* Returns the last pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public PathologyData findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Returns the last pathology data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

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
	public PathologyData[] findByUuid_C_PrevAndNext(long pathologyDataId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Removes all the pathology datas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of pathology datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching pathology datas
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the pathology datas where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching pathology datas
	*/
	public java.util.List<PathologyData> findByGroupId(long groupId);

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
	public java.util.List<PathologyData> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<PathologyData> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

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
	public java.util.List<PathologyData> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pathology data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public PathologyData findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Returns the first pathology data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

	/**
	* Returns the last pathology data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public PathologyData findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Returns the last pathology data in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

	/**
	* Returns the pathology datas before and after the current pathology data in the ordered set where groupId = &#63;.
	*
	* @param pathologyDataId the primary key of the current pathology data
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathology data
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public PathologyData[] findByGroupId_PrevAndNext(long pathologyDataId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Removes all the pathology datas where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of pathology datas where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching pathology datas
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the pathology datas where material = &#63;.
	*
	* @param material the material
	* @return the matching pathology datas
	*/
	public java.util.List<PathologyData> findByMaterial(
		java.lang.String material);

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
	public java.util.List<PathologyData> findByMaterial(
		java.lang.String material, int start, int end);

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
	public java.util.List<PathologyData> findByMaterial(
		java.lang.String material, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

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
	public java.util.List<PathologyData> findByMaterial(
		java.lang.String material, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pathology data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public PathologyData findByMaterial_First(java.lang.String material,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Returns the first pathology data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByMaterial_First(java.lang.String material,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

	/**
	* Returns the last pathology data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public PathologyData findByMaterial_Last(java.lang.String material,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Returns the last pathology data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByMaterial_Last(java.lang.String material,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

	/**
	* Returns the pathology datas before and after the current pathology data in the ordered set where material = &#63;.
	*
	* @param pathologyDataId the primary key of the current pathology data
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathology data
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public PathologyData[] findByMaterial_PrevAndNext(long pathologyDataId,
		java.lang.String material,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator)
		throws NoSuchPathologyDataException;

	/**
	* Removes all the pathology datas where material = &#63; from the database.
	*
	* @param material the material
	*/
	public void removeByMaterial(java.lang.String material);

	/**
	* Returns the number of pathology datas where material = &#63;.
	*
	* @param material the material
	* @return the number of matching pathology datas
	*/
	public int countByMaterial(java.lang.String material);

	/**
	* Returns the pathology data where medicalRecordId = &#63; or throws a {@link NoSuchPathologyDataException} if it could not be found.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching pathology data
	* @throws NoSuchPathologyDataException if a matching pathology data could not be found
	*/
	public PathologyData findByMedicalRecord(long medicalRecordId)
		throws NoSuchPathologyDataException;

	/**
	* Returns the pathology data where medicalRecordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByMedicalRecord(long medicalRecordId);

	/**
	* Returns the pathology data where medicalRecordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param medicalRecordId the medical record ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public PathologyData fetchByMedicalRecord(long medicalRecordId,
		boolean retrieveFromCache);

	/**
	* Removes the pathology data where medicalRecordId = &#63; from the database.
	*
	* @param medicalRecordId the medical record ID
	* @return the pathology data that was removed
	*/
	public PathologyData removeByMedicalRecord(long medicalRecordId)
		throws NoSuchPathologyDataException;

	/**
	* Returns the number of pathology datas where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @return the number of matching pathology datas
	*/
	public int countByMedicalRecord(long medicalRecordId);

	/**
	* Caches the pathology data in the entity cache if it is enabled.
	*
	* @param pathologyData the pathology data
	*/
	public void cacheResult(PathologyData pathologyData);

	/**
	* Caches the pathology datas in the entity cache if it is enabled.
	*
	* @param pathologyDatas the pathology datas
	*/
	public void cacheResult(java.util.List<PathologyData> pathologyDatas);

	/**
	* Creates a new pathology data with the primary key. Does not add the pathology data to the database.
	*
	* @param pathologyDataId the primary key for the new pathology data
	* @return the new pathology data
	*/
	public PathologyData create(long pathologyDataId);

	/**
	* Removes the pathology data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologyDataId the primary key of the pathology data
	* @return the pathology data that was removed
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public PathologyData remove(long pathologyDataId)
		throws NoSuchPathologyDataException;

	public PathologyData updateImpl(PathologyData pathologyData);

	/**
	* Returns the pathology data with the primary key or throws a {@link NoSuchPathologyDataException} if it could not be found.
	*
	* @param pathologyDataId the primary key of the pathology data
	* @return the pathology data
	* @throws NoSuchPathologyDataException if a pathology data with the primary key could not be found
	*/
	public PathologyData findByPrimaryKey(long pathologyDataId)
		throws NoSuchPathologyDataException;

	/**
	* Returns the pathology data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pathologyDataId the primary key of the pathology data
	* @return the pathology data, or <code>null</code> if a pathology data with the primary key could not be found
	*/
	public PathologyData fetchByPrimaryKey(long pathologyDataId);

	@Override
	public java.util.Map<java.io.Serializable, PathologyData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the pathology datas.
	*
	* @return the pathology datas
	*/
	public java.util.List<PathologyData> findAll();

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
	public java.util.List<PathologyData> findAll(int start, int end);

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
	public java.util.List<PathologyData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator);

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
	public java.util.List<PathologyData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologyData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the pathology datas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of pathology datas.
	*
	* @return the number of pathology datas
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}