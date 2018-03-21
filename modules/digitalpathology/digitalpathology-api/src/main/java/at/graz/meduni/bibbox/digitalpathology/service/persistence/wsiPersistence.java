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

import at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsiException;
import at.graz.meduni.bibbox.digitalpathology.model.wsi;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the wsi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see at.graz.meduni.bibbox.digitalpathology.service.persistence.impl.wsiPersistenceImpl
 * @see wsiUtil
 * @generated
 */
@ProviderType
public interface wsiPersistence extends BasePersistence<wsi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link wsiUtil} to access the wsi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the wsis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching wsis
	*/
	public java.util.List<wsi> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the wsis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @return the range of matching wsis
	*/
	public java.util.List<wsi> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the wsis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsis
	*/
	public java.util.List<wsi> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator);

	/**
	* Returns an ordered range of all the wsis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsis
	*/
	public java.util.List<wsi> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first wsi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public wsi findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator)
		throws NoSuchwsiException;

	/**
	* Returns the first wsi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public wsi fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator);

	/**
	* Returns the last wsi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public wsi findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator)
		throws NoSuchwsiException;

	/**
	* Returns the last wsi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public wsi fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator);

	/**
	* Returns the wsis before and after the current wsi in the ordered set where uuid = &#63;.
	*
	* @param wsiId the primary key of the current wsi
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsi
	* @throws NoSuchwsiException if a wsi with the primary key could not be found
	*/
	public wsi[] findByUuid_PrevAndNext(long wsiId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator)
		throws NoSuchwsiException;

	/**
	* Removes all the wsis where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of wsis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching wsis
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the wsi where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchwsiException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public wsi findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchwsiException;

	/**
	* Returns the wsi where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public wsi fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the wsi where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public wsi fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the wsi where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the wsi that was removed
	*/
	public wsi removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchwsiException;

	/**
	* Returns the number of wsis where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching wsis
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the wsis where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching wsis
	*/
	public java.util.List<wsi> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the wsis where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @return the range of matching wsis
	*/
	public java.util.List<wsi> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the wsis where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsis
	*/
	public java.util.List<wsi> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator);

	/**
	* Returns an ordered range of all the wsis where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsis
	*/
	public java.util.List<wsi> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public wsi findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator)
		throws NoSuchwsiException;

	/**
	* Returns the first wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public wsi fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator);

	/**
	* Returns the last wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public wsi findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator)
		throws NoSuchwsiException;

	/**
	* Returns the last wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public wsi fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator);

	/**
	* Returns the wsis before and after the current wsi in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param wsiId the primary key of the current wsi
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsi
	* @throws NoSuchwsiException if a wsi with the primary key could not be found
	*/
	public wsi[] findByUuid_C_PrevAndNext(long wsiId, java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator)
		throws NoSuchwsiException;

	/**
	* Removes all the wsis where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of wsis where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching wsis
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the wsis where filename = &#63;.
	*
	* @param filename the filename
	* @return the matching wsis
	*/
	public java.util.List<wsi> findByFilename(java.lang.String filename);

	/**
	* Returns a range of all the wsis where filename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filename the filename
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @return the range of matching wsis
	*/
	public java.util.List<wsi> findByFilename(java.lang.String filename,
		int start, int end);

	/**
	* Returns an ordered range of all the wsis where filename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filename the filename
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsis
	*/
	public java.util.List<wsi> findByFilename(java.lang.String filename,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator);

	/**
	* Returns an ordered range of all the wsis where filename = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param filename the filename
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsis
	*/
	public java.util.List<wsi> findByFilename(java.lang.String filename,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first wsi in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public wsi findByFilename_First(java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator)
		throws NoSuchwsiException;

	/**
	* Returns the first wsi in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public wsi fetchByFilename_First(java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator);

	/**
	* Returns the last wsi in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi
	* @throws NoSuchwsiException if a matching wsi could not be found
	*/
	public wsi findByFilename_Last(java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator)
		throws NoSuchwsiException;

	/**
	* Returns the last wsi in the ordered set where filename = &#63;.
	*
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public wsi fetchByFilename_Last(java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator);

	/**
	* Returns the wsis before and after the current wsi in the ordered set where filename = &#63;.
	*
	* @param wsiId the primary key of the current wsi
	* @param filename the filename
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsi
	* @throws NoSuchwsiException if a wsi with the primary key could not be found
	*/
	public wsi[] findByFilename_PrevAndNext(long wsiId,
		java.lang.String filename,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator)
		throws NoSuchwsiException;

	/**
	* Removes all the wsis where filename = &#63; from the database.
	*
	* @param filename the filename
	*/
	public void removeByFilename(java.lang.String filename);

	/**
	* Returns the number of wsis where filename = &#63;.
	*
	* @param filename the filename
	* @return the number of matching wsis
	*/
	public int countByFilename(java.lang.String filename);

	/**
	* Caches the wsi in the entity cache if it is enabled.
	*
	* @param wsi the wsi
	*/
	public void cacheResult(wsi wsi);

	/**
	* Caches the wsis in the entity cache if it is enabled.
	*
	* @param wsis the wsis
	*/
	public void cacheResult(java.util.List<wsi> wsis);

	/**
	* Creates a new wsi with the primary key. Does not add the wsi to the database.
	*
	* @param wsiId the primary key for the new wsi
	* @return the new wsi
	*/
	public wsi create(long wsiId);

	/**
	* Removes the wsi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wsiId the primary key of the wsi
	* @return the wsi that was removed
	* @throws NoSuchwsiException if a wsi with the primary key could not be found
	*/
	public wsi remove(long wsiId) throws NoSuchwsiException;

	public wsi updateImpl(wsi wsi);

	/**
	* Returns the wsi with the primary key or throws a {@link NoSuchwsiException} if it could not be found.
	*
	* @param wsiId the primary key of the wsi
	* @return the wsi
	* @throws NoSuchwsiException if a wsi with the primary key could not be found
	*/
	public wsi findByPrimaryKey(long wsiId) throws NoSuchwsiException;

	/**
	* Returns the wsi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wsiId the primary key of the wsi
	* @return the wsi, or <code>null</code> if a wsi with the primary key could not be found
	*/
	public wsi fetchByPrimaryKey(long wsiId);

	@Override
	public java.util.Map<java.io.Serializable, wsi> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the wsis.
	*
	* @return the wsis
	*/
	public java.util.List<wsi> findAll();

	/**
	* Returns a range of all the wsis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @return the range of wsis
	*/
	public java.util.List<wsi> findAll(int start, int end);

	/**
	* Returns an ordered range of all the wsis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of wsis
	*/
	public java.util.List<wsi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator);

	/**
	* Returns an ordered range of all the wsis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of wsis
	*/
	public java.util.List<wsi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the wsis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of wsis.
	*
	* @return the number of wsis
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}