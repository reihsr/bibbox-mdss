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

package at.graz.meduni.bibbox.digitalpathology.service;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.digitalpathology.model.wsihash;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for wsihash. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author robert
 * @see wsihashLocalServiceUtil
 * @see at.graz.meduni.bibbox.digitalpathology.service.base.wsihashLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.digitalpathology.service.impl.wsihashLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface wsihashLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link wsihashLocalServiceUtil} to access the wsihash local service. Add custom service methods to {@link at.graz.meduni.bibbox.digitalpathology.service.impl.wsihashLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the wsihash to the database. Also notifies the appropriate model listeners.
	*
	* @param wsihash the wsihash
	* @return the wsihash that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public wsihash addwsihash(wsihash wsihash);

	/**
	* Creates a new wsihash with the primary key. Does not add the wsihash to the database.
	*
	* @param wsihashId the primary key for the new wsihash
	* @return the new wsihash
	*/
	public wsihash createwsihash(long wsihashId);

	/**
	* Deletes the wsihash from the database. Also notifies the appropriate model listeners.
	*
	* @param wsihash the wsihash
	* @return the wsihash that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public wsihash deletewsihash(wsihash wsihash);

	/**
	* Deletes the wsihash with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wsihashId the primary key of the wsihash
	* @return the wsihash that was removed
	* @throws PortalException if a wsihash with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public wsihash deletewsihash(long wsihashId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public wsihash fetchwsihash(long wsihashId);

	/**
	* Returns the wsihash matching the UUID and group.
	*
	* @param uuid the wsihash's UUID
	* @param groupId the primary key of the group
	* @return the matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public wsihash fetchwsihashByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	/**
	* Returns the wsihash with the primary key.
	*
	* @param wsihashId the primary key of the wsihash
	* @return the wsihash
	* @throws PortalException if a wsihash with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public wsihash getwsihash(long wsihashId) throws PortalException;

	/**
	* Returns the wsihash matching the UUID and group.
	*
	* @param uuid the wsihash's UUID
	* @param groupId the primary key of the group
	* @return the matching wsihash
	* @throws PortalException if a matching wsihash could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public wsihash getwsihashByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	/**
	* Updates the wsihash in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wsihash the wsihash
	* @return the wsihash that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public wsihash updatewsihash(wsihash wsihash);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of wsihashs.
	*
	* @return the number of wsihashs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getwsihashsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.digitalpathology.model.impl.wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.digitalpathology.model.impl.wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the wsihashs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.digitalpathology.model.impl.wsihashModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @return the range of wsihashs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<wsihash> getwsihashs(int start, int end);

	/**
	* Returns all the wsihashs matching the UUID and company.
	*
	* @param uuid the UUID of the wsihashs
	* @param companyId the primary key of the company
	* @return the matching wsihashs, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<wsihash> getwsihashsByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of wsihashs matching the UUID and company.
	*
	* @param uuid the UUID of the wsihashs
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of wsihashs
	* @param end the upper bound of the range of wsihashs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching wsihashs, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<wsihash> getwsihashsByUuidAndCompanyId(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<wsihash> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}