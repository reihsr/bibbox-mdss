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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for wsihash. This utility wraps
 * {@link at.graz.meduni.bibbox.digitalpathology.service.impl.wsihashLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author robert
 * @see wsihashLocalService
 * @see at.graz.meduni.bibbox.digitalpathology.service.base.wsihashLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.digitalpathology.service.impl.wsihashLocalServiceImpl
 * @generated
 */
@ProviderType
public class wsihashLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.digitalpathology.service.impl.wsihashLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the wsihash to the database. Also notifies the appropriate model listeners.
	*
	* @param wsihash the wsihash
	* @return the wsihash that was added
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsihash addwsihash(
		at.graz.meduni.bibbox.digitalpathology.model.wsihash wsihash) {
		return getService().addwsihash(wsihash);
	}

	/**
	* Creates a new wsihash with the primary key. Does not add the wsihash to the database.
	*
	* @param wsihashId the primary key for the new wsihash
	* @return the new wsihash
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsihash createwsihash(
		long wsihashId) {
		return getService().createwsihash(wsihashId);
	}

	/**
	* Deletes the wsihash from the database. Also notifies the appropriate model listeners.
	*
	* @param wsihash the wsihash
	* @return the wsihash that was removed
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsihash deletewsihash(
		at.graz.meduni.bibbox.digitalpathology.model.wsihash wsihash) {
		return getService().deletewsihash(wsihash);
	}

	/**
	* Deletes the wsihash with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wsihashId the primary key of the wsihash
	* @return the wsihash that was removed
	* @throws PortalException if a wsihash with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsihash deletewsihash(
		long wsihashId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletewsihash(wsihashId);
	}

	public static at.graz.meduni.bibbox.digitalpathology.model.wsihash fetchwsihash(
		long wsihashId) {
		return getService().fetchwsihash(wsihashId);
	}

	/**
	* Returns the wsihash matching the UUID and group.
	*
	* @param uuid the wsihash's UUID
	* @param groupId the primary key of the group
	* @return the matching wsihash, or <code>null</code> if a matching wsihash could not be found
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsihash fetchwsihashByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchwsihashByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the wsihash with the primary key.
	*
	* @param wsihashId the primary key of the wsihash
	* @return the wsihash
	* @throws PortalException if a wsihash with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsihash getwsihash(
		long wsihashId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getwsihash(wsihashId);
	}

	/**
	* Returns the wsihash matching the UUID and group.
	*
	* @param uuid the wsihash's UUID
	* @param groupId the primary key of the group
	* @return the matching wsihash
	* @throws PortalException if a matching wsihash could not be found
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsihash getwsihashByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getwsihashByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the wsihash in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wsihash the wsihash
	* @return the wsihash that was updated
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsihash updatewsihash(
		at.graz.meduni.bibbox.digitalpathology.model.wsihash wsihash) {
		return getService().updatewsihash(wsihash);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of wsihashs.
	*
	* @return the number of wsihashs
	*/
	public static int getwsihashsCount() {
		return getService().getwsihashsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

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
	public static java.util.List<at.graz.meduni.bibbox.digitalpathology.model.wsihash> getwsihashs(
		int start, int end) {
		return getService().getwsihashs(start, end);
	}

	/**
	* Returns all the wsihashs matching the UUID and company.
	*
	* @param uuid the UUID of the wsihashs
	* @param companyId the primary key of the company
	* @return the matching wsihashs, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.digitalpathology.model.wsihash> getwsihashsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getwsihashsByUuidAndCompanyId(uuid, companyId);
	}

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
	public static java.util.List<at.graz.meduni.bibbox.digitalpathology.model.wsihash> getwsihashsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.digitalpathology.model.wsihash> orderByComparator) {
		return getService()
				   .getwsihashsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static wsihashLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<wsihashLocalService, wsihashLocalService> _serviceTracker =
		ServiceTrackerFactory.open(wsihashLocalService.class);
}