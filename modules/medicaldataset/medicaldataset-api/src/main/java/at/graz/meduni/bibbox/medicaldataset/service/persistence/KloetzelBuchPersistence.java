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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException;
import at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the kloetzel buch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.persistence.impl.KloetzelBuchPersistenceImpl
 * @see KloetzelBuchUtil
 * @generated
 */
@ProviderType
public interface KloetzelBuchPersistence extends BasePersistence<KloetzelBuch> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KloetzelBuchUtil} to access the kloetzel buch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the kloetzel buchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching kloetzel buchs
	*/
	public java.util.List<KloetzelBuch> findByUuid(java.lang.String uuid);

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
	public java.util.List<KloetzelBuch> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<KloetzelBuch> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator);

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
	public java.util.List<KloetzelBuch> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first kloetzel buch in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the first kloetzel buch in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator);

	/**
	* Returns the last kloetzel buch in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the last kloetzel buch in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator);

	/**
	* Returns the kloetzel buchs before and after the current kloetzel buch in the ordered set where uuid = &#63;.
	*
	* @param kloetzelBuchId the primary key of the current kloetzel buch
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kloetzel buch
	* @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	*/
	public KloetzelBuch[] findByUuid_PrevAndNext(long kloetzelBuchId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException;

	/**
	* Removes all the kloetzel buchs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of kloetzel buchs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching kloetzel buchs
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the kloetzel buch where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchKloetzelBuchException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the kloetzel buch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the kloetzel buch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the kloetzel buch where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the kloetzel buch that was removed
	*/
	public KloetzelBuch removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the number of kloetzel buchs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching kloetzel buchs
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the kloetzel buchs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching kloetzel buchs
	*/
	public java.util.List<KloetzelBuch> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<KloetzelBuch> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<KloetzelBuch> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator);

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
	public java.util.List<KloetzelBuch> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the first kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator);

	/**
	* Returns the last kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the last kloetzel buch in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator);

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
	public KloetzelBuch[] findByUuid_C_PrevAndNext(long kloetzelBuchId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException;

	/**
	* Removes all the kloetzel buchs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of kloetzel buchs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching kloetzel buchs
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the kloetzel buchs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching kloetzel buchs
	*/
	public java.util.List<KloetzelBuch> findByGroupId(long groupId);

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
	public java.util.List<KloetzelBuch> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<KloetzelBuch> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator);

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
	public java.util.List<KloetzelBuch> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first kloetzel buch in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the first kloetzel buch in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator);

	/**
	* Returns the last kloetzel buch in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the last kloetzel buch in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator);

	/**
	* Returns the kloetzel buchs before and after the current kloetzel buch in the ordered set where groupId = &#63;.
	*
	* @param kloetzelBuchId the primary key of the current kloetzel buch
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kloetzel buch
	* @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	*/
	public KloetzelBuch[] findByGroupId_PrevAndNext(long kloetzelBuchId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator)
		throws NoSuchKloetzelBuchException;

	/**
	* Removes all the kloetzel buchs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of kloetzel buchs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching kloetzel buchs
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the kloetzel buch where medicalRecordId = &#63; or throws a {@link NoSuchKloetzelBuchException} if it could not be found.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching kloetzel buch
	* @throws NoSuchKloetzelBuchException if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch findByMedicalRecord(long medicalRecordId)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the kloetzel buch where medicalRecordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param medicalRecordId the medical record ID
	* @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch fetchByMedicalRecord(long medicalRecordId);

	/**
	* Returns the kloetzel buch where medicalRecordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param medicalRecordId the medical record ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public KloetzelBuch fetchByMedicalRecord(long medicalRecordId,
		boolean retrieveFromCache);

	/**
	* Removes the kloetzel buch where medicalRecordId = &#63; from the database.
	*
	* @param medicalRecordId the medical record ID
	* @return the kloetzel buch that was removed
	*/
	public KloetzelBuch removeByMedicalRecord(long medicalRecordId)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the number of kloetzel buchs where medicalRecordId = &#63;.
	*
	* @param medicalRecordId the medical record ID
	* @return the number of matching kloetzel buchs
	*/
	public int countByMedicalRecord(long medicalRecordId);

	/**
	* Caches the kloetzel buch in the entity cache if it is enabled.
	*
	* @param kloetzelBuch the kloetzel buch
	*/
	public void cacheResult(KloetzelBuch kloetzelBuch);

	/**
	* Caches the kloetzel buchs in the entity cache if it is enabled.
	*
	* @param kloetzelBuchs the kloetzel buchs
	*/
	public void cacheResult(java.util.List<KloetzelBuch> kloetzelBuchs);

	/**
	* Creates a new kloetzel buch with the primary key. Does not add the kloetzel buch to the database.
	*
	* @param kloetzelBuchId the primary key for the new kloetzel buch
	* @return the new kloetzel buch
	*/
	public KloetzelBuch create(long kloetzelBuchId);

	/**
	* Removes the kloetzel buch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kloetzelBuchId the primary key of the kloetzel buch
	* @return the kloetzel buch that was removed
	* @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	*/
	public KloetzelBuch remove(long kloetzelBuchId)
		throws NoSuchKloetzelBuchException;

	public KloetzelBuch updateImpl(KloetzelBuch kloetzelBuch);

	/**
	* Returns the kloetzel buch with the primary key or throws a {@link NoSuchKloetzelBuchException} if it could not be found.
	*
	* @param kloetzelBuchId the primary key of the kloetzel buch
	* @return the kloetzel buch
	* @throws NoSuchKloetzelBuchException if a kloetzel buch with the primary key could not be found
	*/
	public KloetzelBuch findByPrimaryKey(long kloetzelBuchId)
		throws NoSuchKloetzelBuchException;

	/**
	* Returns the kloetzel buch with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param kloetzelBuchId the primary key of the kloetzel buch
	* @return the kloetzel buch, or <code>null</code> if a kloetzel buch with the primary key could not be found
	*/
	public KloetzelBuch fetchByPrimaryKey(long kloetzelBuchId);

	@Override
	public java.util.Map<java.io.Serializable, KloetzelBuch> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the kloetzel buchs.
	*
	* @return the kloetzel buchs
	*/
	public java.util.List<KloetzelBuch> findAll();

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
	public java.util.List<KloetzelBuch> findAll(int start, int end);

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
	public java.util.List<KloetzelBuch> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator);

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
	public java.util.List<KloetzelBuch> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KloetzelBuch> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the kloetzel buchs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of kloetzel buchs.
	*
	* @return the number of kloetzel buchs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}