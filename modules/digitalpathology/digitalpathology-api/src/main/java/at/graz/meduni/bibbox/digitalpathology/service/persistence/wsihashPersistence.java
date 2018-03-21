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

import at.graz.meduni.bibbox.digitalpathology.exception.NoSuchwsihashException;
import at.graz.meduni.bibbox.digitalpathology.model.wsihash;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the wsihash service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see at.graz.meduni.bibbox.digitalpathology.service.persistence.impl.wsihashPersistenceImpl
 * @see wsihashUtil
 * @generated
 */
@ProviderType
public interface wsihashPersistence extends BasePersistence<wsihash> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link wsihashUtil} to access the wsihash persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the wsihashs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching wsihashs
	*/
	public java.util.List<wsihash> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the wsihashs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @return the range of matching wsihashs
	*/
	public java.util.List<wsihash> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the wsihashs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsihashs
	*/
	public java.util.List<wsihash> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns an ordered range of all the wsihashs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsihashs
	*/
	public java.util.List<wsihash> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first wsihash in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public wsihash findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException;

	/**
	* Returns the first wsihash in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public wsihash fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns the last wsihash in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public wsihash findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException;

	/**
	* Returns the last wsihash in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public wsihash fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns the wsihashs before and after the current wsihash in the ordered set where uuid = &#63;.
	*
	* @param wsihashId the primary key of the current wsihash
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsihash
	* @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	*/
	public wsihash[] findByUuid_PrevAndNext(long wsihashId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException;

	/**
	* Removes all the wsihashs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of wsihashs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching wsihashs
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the wsihash where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchwsihashException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public wsihash findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchwsihashException;

	/**
	* Returns the wsihash where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public wsihash fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the wsihash where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public wsihash fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the wsihash where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the wsihash that was removed
	*/
	public wsihash removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchwsihashException;

	/**
	* Returns the number of wsihashs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching wsihashs
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the wsihashs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching wsihashs
	*/
	public java.util.List<wsihash> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the wsihashs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @return the range of matching wsihashs
	*/
	public java.util.List<wsihash> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the wsihashs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsihashs
	*/
	public java.util.List<wsihash> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns an ordered range of all the wsihashs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsihashs
	*/
	public java.util.List<wsihash> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public wsihash findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException;

	/**
	* Returns the first wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public wsihash fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns the last wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public wsihash findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException;

	/**
	* Returns the last wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public wsihash fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns the wsihashs before and after the current wsihash in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param wsihashId the primary key of the current wsihash
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsihash
	* @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	*/
	public wsihash[] findByUuid_C_PrevAndNext(long wsihashId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException;

	/**
	* Removes all the wsihashs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of wsihashs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching wsihashs
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the wsihashs where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @return the matching wsihashs
	*/
	public java.util.List<wsihash> findByWsi(long wsiId);

	/**
	* Returns a range of all the wsihashs where wsiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wsiId the wsi ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @return the range of matching wsihashs
	*/
	public java.util.List<wsihash> findByWsi(long wsiId, int start, int end);

	/**
	* Returns an ordered range of all the wsihashs where wsiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wsiId the wsi ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching wsihashs
	*/
	public java.util.List<wsihash> findByWsi(long wsiId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns an ordered range of all the wsihashs where wsiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param wsiId the wsi ID
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching wsihashs
	*/
	public java.util.List<wsihash> findByWsi(long wsiId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first wsihash in the ordered set where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public wsihash findByWsi_First(long wsiId,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException;

	/**
	* Returns the first wsihash in the ordered set where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public wsihash fetchByWsi_First(long wsiId,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns the last wsihash in the ordered set where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash
	* @throws NoSuchwsihashException if a matching wsihash could not be found
	*/
	public wsihash findByWsi_Last(long wsiId,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException;

	/**
	* Returns the last wsihash in the ordered set where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public wsihash fetchByWsi_Last(long wsiId,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns the wsihashs before and after the current wsihash in the ordered set where wsiId = &#63;.
	*
	* @param wsihashId the primary key of the current wsihash
	* @param wsiId the wsi ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next wsihash
	* @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	*/
	public wsihash[] findByWsi_PrevAndNext(long wsihashId, long wsiId,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator)
		throws NoSuchwsihashException;

	/**
	* Removes all the wsihashs where wsiId = &#63; from the database.
	*
	* @param wsiId the wsi ID
	*/
	public void removeByWsi(long wsiId);

	/**
	* Returns the number of wsihashs where wsiId = &#63;.
	*
	* @param wsiId the wsi ID
	* @return the number of matching wsihashs
	*/
	public int countByWsi(long wsiId);

	/**
	* Caches the wsihash in the entity cache if it is enabled.
	*
	* @param wsihash the wsihash
	*/
	public void cacheResult(wsihash wsihash);

	/**
	* Caches the wsihashs in the entity cache if it is enabled.
	*
	* @param wsihashs the wsihashs
	*/
	public void cacheResult(java.util.List<wsihash> wsihashs);

	/**
	* Creates a new wsihash with the primary key. Does not add the wsihash to the database.
	*
	* @param wsihashId the primary key for the new wsihash
	* @return the new wsihash
	*/
	public wsihash create(long wsihashId);

	/**
	* Removes the wsihash with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wsihashId the primary key of the wsihash
	* @return the wsihash that was removed
	* @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	*/
	public wsihash remove(long wsihashId) throws NoSuchwsihashException;

	public wsihash updateImpl(wsihash wsihash);

	/**
	* Returns the wsihash with the primary key or throws a {@link NoSuchwsihashException} if it could not be found.
	*
	* @param wsihashId the primary key of the wsihash
	* @return the wsihash
	* @throws NoSuchwsihashException if a wsihash with the primary key could not be found
	*/
	public wsihash findByPrimaryKey(long wsihashId)
		throws NoSuchwsihashException;

	/**
	* Returns the wsihash with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param wsihashId the primary key of the wsihash
	* @return the wsihash, or <code>null</code> if a wsihash with the primary key could not be found
	*/
	public wsihash fetchByPrimaryKey(long wsihashId);

	@Override
	public java.util.Map<java.io.Serializable, wsihash> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the wsihashs.
	*
	* @return the wsihashs
	*/
	public java.util.List<wsihash> findAll();

	/**
	* Returns a range of all the wsihashs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @return the range of wsihashs
	*/
	public java.util.List<wsihash> findAll(int start, int end);

	/**
	* Returns an ordered range of all the wsihashs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of wsihashs
	*/
	public java.util.List<wsihash> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns an ordered range of all the wsihashs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of wsihashs
	*/
	public java.util.List<wsihash> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<wsihash> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the wsihashs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of wsihashs.
	*
	* @return the number of wsihashs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}