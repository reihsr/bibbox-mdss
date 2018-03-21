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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException;
import at.graz.meduni.bibbox.medicaldataset.model.PathologieData;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the pathologie data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.PathologieDataPersistenceImpl
 * @see PathologieDataUtil
 * @generated
 */
@ProviderType
public interface PathologieDataPersistence extends BasePersistence<PathologieData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PathologieDataUtil} to access the pathologie data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the pathologie datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching pathologie datas
	*/
	public java.util.List<PathologieData> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the pathologie datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the pathologie datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns an ordered range of all the pathologie datas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pathologie data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public PathologieData findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Returns the first pathologie data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public PathologieData fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns the last pathologie data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public PathologieData findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Returns the last pathologie data in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public PathologieData fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns the pathologie datas before and after the current pathologie data in the ordered set where uuid = &#63;.
	*
	* @param pathologieDataId the primary key of the current pathologie data
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public PathologieData[] findByUuid_PrevAndNext(long pathologieDataId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Removes all the pathologie datas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of pathologie datas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching pathologie datas
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the pathologie data where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchPathologieDataException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public PathologieData findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchPathologieDataException;

	/**
	* Returns the pathologie data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public PathologieData fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the pathologie data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public PathologieData fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the pathologie data where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the pathologie data that was removed
	*/
	public PathologieData removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchPathologieDataException;

	/**
	* Returns the number of pathologie datas where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching pathologie datas
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the pathologie datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching pathologie datas
	*/
	public java.util.List<PathologieData> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the pathologie datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the pathologie datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns an ordered range of all the pathologie datas where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public PathologieData findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Returns the first pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public PathologieData fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns the last pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public PathologieData findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Returns the last pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public PathologieData fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns the pathologie datas before and after the current pathologie data in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param pathologieDataId the primary key of the current pathologie data
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public PathologieData[] findByUuid_C_PrevAndNext(long pathologieDataId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Removes all the pathologie datas where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of pathologie datas where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching pathologie datas
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the pathologie datas where material = &#63;.
	*
	* @param material the material
	* @return the matching pathologie datas
	*/
	public java.util.List<PathologieData> findByMaterial(
		java.lang.String material);

	/**
	* Returns a range of all the pathologie datas where material = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param material the material
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByMaterial(
		java.lang.String material, int start, int end);

	/**
	* Returns an ordered range of all the pathologie datas where material = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param material the material
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByMaterial(
		java.lang.String material, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns an ordered range of all the pathologie datas where material = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param material the material
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByMaterial(
		java.lang.String material, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pathologie data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public PathologieData findByMaterial_First(java.lang.String material,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Returns the first pathologie data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public PathologieData fetchByMaterial_First(java.lang.String material,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns the last pathologie data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public PathologieData findByMaterial_Last(java.lang.String material,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Returns the last pathologie data in the ordered set where material = &#63;.
	*
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public PathologieData fetchByMaterial_Last(java.lang.String material,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns the pathologie datas before and after the current pathologie data in the ordered set where material = &#63;.
	*
	* @param pathologieDataId the primary key of the current pathologie data
	* @param material the material
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public PathologieData[] findByMaterial_PrevAndNext(long pathologieDataId,
		java.lang.String material,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Removes all the pathologie datas where material = &#63; from the database.
	*
	* @param material the material
	*/
	public void removeByMaterial(java.lang.String material);

	/**
	* Returns the number of pathologie datas where material = &#63;.
	*
	* @param material the material
	* @return the number of matching pathologie datas
	*/
	public int countByMaterial(java.lang.String material);

	/**
	* Returns all the pathologie datas where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching pathologie datas
	*/
	public java.util.List<PathologieData> findByMedicalRecord(
		long medicalRecordId);

	/**
	* Returns a range of all the pathologie datas where medicalRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param medicalRecordId the medical record ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByMedicalRecord(
		long medicalRecordId, int start, int end);

	/**
	* Returns an ordered range of all the pathologie datas where medicalRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param medicalRecordId the medical record ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByMedicalRecord(
		long medicalRecordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns an ordered range of all the pathologie datas where medicalRecordId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param medicalRecordId the medical record ID
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching pathologie datas
	*/
	public java.util.List<PathologieData> findByMedicalRecord(
		long medicalRecordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first pathologie data in the ordered set where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public PathologieData findByMedicalRecord_First(long medicalRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Returns the first pathologie data in the ordered set where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public PathologieData fetchByMedicalRecord_First(long medicalRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns the last pathologie data in the ordered set where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data
	* @throws NoSuchPathologieDataException if a matching pathologie data could not be found
	*/
	public PathologieData findByMedicalRecord_Last(long medicalRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Returns the last pathologie data in the ordered set where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public PathologieData fetchByMedicalRecord_Last(long medicalRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns the pathologie datas before and after the current pathologie data in the ordered set where medicalRecordId = &#63;.
	*
	* @param pathologieDataId the primary key of the current pathologie data
	* @param medicalRecordId the medical record ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public PathologieData[] findByMedicalRecord_PrevAndNext(
		long pathologieDataId, long medicalRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator)
		throws NoSuchPathologieDataException;

	/**
	* Removes all the pathologie datas where medicalRecordId = &#63; from the database.
	*
	* @param medicalRecordId the medical record ID
	*/
	public void removeByMedicalRecord(long medicalRecordId);

	/**
	* Returns the number of pathologie datas where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @return the number of matching pathologie datas
	*/
	public int countByMedicalRecord(long medicalRecordId);

	/**
	* Caches the pathologie data in the entity cache if it is enabled.
	*
	* @param pathologieData the pathologie data
	*/
	public void cacheResult(PathologieData pathologieData);

	/**
	* Caches the pathologie datas in the entity cache if it is enabled.
	*
	* @param pathologieDatas the pathologie datas
	*/
	public void cacheResult(java.util.List<PathologieData> pathologieDatas);

	/**
	* Creates a new pathologie data with the primary key. Does not add the pathologie data to the database.
	*
	* @param pathologieDataId the primary key for the new pathologie data
	* @return the new pathologie data
	*/
	public PathologieData create(long pathologieDataId);

	/**
	* Removes the pathologie data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data that was removed
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public PathologieData remove(long pathologieDataId)
		throws NoSuchPathologieDataException;

	public PathologieData updateImpl(PathologieData pathologieData);

	/**
	* Returns the pathologie data with the primary key or throws a {@link NoSuchPathologieDataException} if it could not be found.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data
	* @throws NoSuchPathologieDataException if a pathologie data with the primary key could not be found
	*/
	public PathologieData findByPrimaryKey(long pathologieDataId)
		throws NoSuchPathologieDataException;

	/**
	* Returns the pathologie data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data, or <code>null</code> if a pathologie data with the primary key could not be found
	*/
	public PathologieData fetchByPrimaryKey(long pathologieDataId);

	@Override
	public java.util.Map<java.io.Serializable, PathologieData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the pathologie datas.
	*
	* @return the pathologie datas
	*/
	public java.util.List<PathologieData> findAll();

	/**
	* Returns a range of all the pathologie datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of pathologie datas
	*/
	public java.util.List<PathologieData> findAll(int start, int end);

	/**
	* Returns an ordered range of all the pathologie datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pathologie datas
	*/
	public java.util.List<PathologieData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator);

	/**
	* Returns an ordered range of all the pathologie datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of pathologie datas
	*/
	public java.util.List<PathologieData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PathologieData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the pathologie datas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of pathologie datas.
	*
	* @return the number of pathologie datas
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}