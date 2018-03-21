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

import at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryDictionaryLinkException;
import at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the dictionary dictionary link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robert
 * @see at.graz.meduni.bibbox.informationprocessing.service.persistence.impl.DictionaryDictionaryLinkPersistenceImpl
 * @see DictionaryDictionaryLinkUtil
 * @generated
 */
@ProviderType
public interface DictionaryDictionaryLinkPersistence extends BasePersistence<DictionaryDictionaryLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DictionaryDictionaryLinkUtil} to access the dictionary dictionary link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dictionary dictionary links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching dictionary dictionary links
	*/
	public java.util.List<DictionaryDictionaryLink> findByUuid(
		java.lang.String uuid);

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
	public java.util.List<DictionaryDictionaryLink> findByUuid(
		java.lang.String uuid, int start, int end);

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
	public java.util.List<DictionaryDictionaryLink> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

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
	public java.util.List<DictionaryDictionaryLink> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dictionary dictionary link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the first dictionary dictionary link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

	/**
	* Returns the last dictionary dictionary link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the last dictionary dictionary link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

	/**
	* Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where uuid = &#63;.
	*
	* @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public DictionaryDictionaryLink[] findByUuid_PrevAndNext(
		long dictionarydictionarylinkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Removes all the dictionary dictionary links where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of dictionary dictionary links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching dictionary dictionary links
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the dictionary dictionary link where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchDictionaryDictionaryLinkException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink findByUUID_G(java.lang.String uuid,
		long groupId) throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the dictionary dictionary link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink fetchByUUID_G(java.lang.String uuid,
		long groupId);

	/**
	* Returns the dictionary dictionary link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache);

	/**
	* Removes the dictionary dictionary link where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the dictionary dictionary link that was removed
	*/
	public DictionaryDictionaryLink removeByUUID_G(java.lang.String uuid,
		long groupId) throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the number of dictionary dictionary links where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching dictionary dictionary links
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching dictionary dictionary links
	*/
	public java.util.List<DictionaryDictionaryLink> findByUuid_C(
		java.lang.String uuid, long companyId);

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
	public java.util.List<DictionaryDictionaryLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end);

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
	public java.util.List<DictionaryDictionaryLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

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
	public java.util.List<DictionaryDictionaryLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the first dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

	/**
	* Returns the last dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the last dictionary dictionary link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

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
	public DictionaryDictionaryLink[] findByUuid_C_PrevAndNext(
		long dictionarydictionarylinkId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Removes all the dictionary dictionary links where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of dictionary dictionary links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching dictionary dictionary links
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the dictionary dictionary links where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @return the matching dictionary dictionary links
	*/
	public java.util.List<DictionaryDictionaryLink> findByDictionary(
		long dictionaryId);

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
	public java.util.List<DictionaryDictionaryLink> findByDictionary(
		long dictionaryId, int start, int end);

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
	public java.util.List<DictionaryDictionaryLink> findByDictionary(
		long dictionaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

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
	public java.util.List<DictionaryDictionaryLink> findByDictionary(
		long dictionaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink findByDictionary_First(long dictionaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink fetchByDictionary_First(long dictionaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink findByDictionary_Last(long dictionaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink fetchByDictionary_Last(long dictionaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

	/**
	* Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public DictionaryDictionaryLink[] findByDictionary_PrevAndNext(
		long dictionarydictionarylinkId, long dictionaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Removes all the dictionary dictionary links where dictionaryId = &#63; from the database.
	*
	* @param dictionaryId the dictionary ID
	*/
	public void removeByDictionary(long dictionaryId);

	/**
	* Returns the number of dictionary dictionary links where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @return the number of matching dictionary dictionary links
	*/
	public int countByDictionary(long dictionaryId);

	/**
	* Returns all the dictionary dictionary links where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @return the matching dictionary dictionary links
	*/
	public java.util.List<DictionaryDictionaryLink> findByLink(
		long linkdictionaryId);

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
	public java.util.List<DictionaryDictionaryLink> findByLink(
		long linkdictionaryId, int start, int end);

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
	public java.util.List<DictionaryDictionaryLink> findByLink(
		long linkdictionaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

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
	public java.util.List<DictionaryDictionaryLink> findByLink(
		long linkdictionaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink findByLink_First(long linkdictionaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the first dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink fetchByLink_First(long linkdictionaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

	/**
	* Returns the last dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink findByLink_Last(long linkdictionaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the last dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public DictionaryDictionaryLink fetchByLink_Last(long linkdictionaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

	/**
	* Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where linkdictionaryId = &#63;.
	*
	* @param dictionarydictionarylinkId the primary key of the current dictionary dictionary link
	* @param linkdictionaryId the linkdictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public DictionaryDictionaryLink[] findByLink_PrevAndNext(
		long dictionarydictionarylinkId, long linkdictionaryId,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Removes all the dictionary dictionary links where linkdictionaryId = &#63; from the database.
	*
	* @param linkdictionaryId the linkdictionary ID
	*/
	public void removeByLink(long linkdictionaryId);

	/**
	* Returns the number of dictionary dictionary links where linkdictionaryId = &#63;.
	*
	* @param linkdictionaryId the linkdictionary ID
	* @return the number of matching dictionary dictionary links
	*/
	public int countByLink(long linkdictionaryId);

	/**
	* Caches the dictionary dictionary link in the entity cache if it is enabled.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	*/
	public void cacheResult(DictionaryDictionaryLink dictionaryDictionaryLink);

	/**
	* Caches the dictionary dictionary links in the entity cache if it is enabled.
	*
	* @param dictionaryDictionaryLinks the dictionary dictionary links
	*/
	public void cacheResult(
		java.util.List<DictionaryDictionaryLink> dictionaryDictionaryLinks);

	/**
	* Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	*
	* @param dictionarydictionarylinkId the primary key for the new dictionary dictionary link
	* @return the new dictionary dictionary link
	*/
	public DictionaryDictionaryLink create(long dictionarydictionarylinkId);

	/**
	* Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public DictionaryDictionaryLink remove(long dictionarydictionarylinkId)
		throws NoSuchDictionaryDictionaryLinkException;

	public DictionaryDictionaryLink updateImpl(
		DictionaryDictionaryLink dictionaryDictionaryLink);

	/**
	* Returns the dictionary dictionary link with the primary key or throws a {@link NoSuchDictionaryDictionaryLinkException} if it could not be found.
	*
	* @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public DictionaryDictionaryLink findByPrimaryKey(
		long dictionarydictionarylinkId)
		throws NoSuchDictionaryDictionaryLinkException;

	/**
	* Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	*/
	public DictionaryDictionaryLink fetchByPrimaryKey(
		long dictionarydictionarylinkId);

	@Override
	public java.util.Map<java.io.Serializable, DictionaryDictionaryLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the dictionary dictionary links.
	*
	* @return the dictionary dictionary links
	*/
	public java.util.List<DictionaryDictionaryLink> findAll();

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
	public java.util.List<DictionaryDictionaryLink> findAll(int start, int end);

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
	public java.util.List<DictionaryDictionaryLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator);

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
	public java.util.List<DictionaryDictionaryLink> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the dictionary dictionary links from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of dictionary dictionary links.
	*
	* @return the number of dictionary dictionary links
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}