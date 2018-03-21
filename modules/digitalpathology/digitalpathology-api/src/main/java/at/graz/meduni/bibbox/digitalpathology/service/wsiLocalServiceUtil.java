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
 * Provides the local service utility for wsi. This utility wraps
 * {@link at.graz.meduni.bibbox.digitalpathology.service.impl.wsiLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author robert
 * @see wsiLocalService
 * @see at.graz.meduni.bibbox.digitalpathology.service.base.wsiLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.digitalpathology.service.impl.wsiLocalServiceImpl
 * @generated
 */
@ProviderType
public class wsiLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.digitalpathology.service.impl.wsiLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the wsi to the database. Also notifies the appropriate model listeners.
	*
	* @param wsi the wsi
	* @return the wsi that was added
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsi addwsi(
		at.graz.meduni.bibbox.digitalpathology.model.wsi wsi) {
		return getService().addwsi(wsi);
	}

	/**
	* Creates a new wsi with the primary key. Does not add the wsi to the database.
	*
	* @param wsiId the primary key for the new wsi
	* @return the new wsi
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsi createwsi(
		long wsiId) {
		return getService().createwsi(wsiId);
	}

	/**
	* Deletes the wsi from the database. Also notifies the appropriate model listeners.
	*
	* @param wsi the wsi
	* @return the wsi that was removed
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsi deletewsi(
		at.graz.meduni.bibbox.digitalpathology.model.wsi wsi) {
		return getService().deletewsi(wsi);
	}

	/**
	* Deletes the wsi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wsiId the primary key of the wsi
	* @return the wsi that was removed
	* @throws PortalException if a wsi with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsi deletewsi(
		long wsiId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletewsi(wsiId);
	}

	public static at.graz.meduni.bibbox.digitalpathology.model.wsi fetchwsi(
		long wsiId) {
		return getService().fetchwsi(wsiId);
	}

	/**
	* Returns the wsi matching the UUID and group.
	*
	* @param uuid the wsi's UUID
	* @param groupId the primary key of the group
	* @return the matching wsi, or <code>null</code> if a matching wsi could not be found
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsi fetchwsiByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchwsiByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the wsi with the primary key.
	*
	* @param wsiId the primary key of the wsi
	* @return the wsi
	* @throws PortalException if a wsi with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsi getwsi(
		long wsiId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getwsi(wsiId);
	}

	/**
	* Returns the wsi matching the UUID and group.
	*
	* @param uuid the wsi's UUID
	* @param groupId the primary key of the group
	* @return the matching wsi
	* @throws PortalException if a matching wsi could not be found
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsi getwsiByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getwsiByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the wsi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wsi the wsi
	* @return the wsi that was updated
	*/
	public static at.graz.meduni.bibbox.digitalpathology.model.wsi updatewsi(
		at.graz.meduni.bibbox.digitalpathology.model.wsi wsi) {
		return getService().updatewsi(wsi);
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
	* Returns the number of wsis.
	*
	* @return the number of wsis
	*/
	public static int getwsisCount() {
		return getService().getwsisCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.digitalpathology.model.impl.wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.digitalpathology.model.impl.wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the wsis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.digitalpathology.model.impl.wsiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @return the range of wsis
	*/
	public static java.util.List<at.graz.meduni.bibbox.digitalpathology.model.wsi> getwsis(
		int start, int end) {
		return getService().getwsis(start, end);
	}

	/**
	* Returns all the wsis matching the UUID and company.
	*
	* @param uuid the UUID of the wsis
	* @param companyId the primary key of the company
	* @return the matching wsis, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.digitalpathology.model.wsi> getwsisByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getwsisByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of wsis matching the UUID and company.
	*
	* @param uuid the UUID of the wsis
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of wsis
	* @param end the upper bound of the range of wsis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching wsis, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.digitalpathology.model.wsi> getwsisByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.digitalpathology.model.wsi> orderByComparator) {
		return getService()
				   .getwsisByUuidAndCompanyId(uuid, companyId, start, end,
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

	public static wsiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<wsiLocalService, wsiLocalService> _serviceTracker =
		ServiceTrackerFactory.open(wsiLocalService.class);
}