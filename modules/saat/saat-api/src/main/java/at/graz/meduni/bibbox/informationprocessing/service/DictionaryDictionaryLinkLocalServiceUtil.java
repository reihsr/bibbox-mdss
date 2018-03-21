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

package at.graz.meduni.bibbox.informationprocessing.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for DictionaryDictionaryLink. This utility wraps
 * {@link at.graz.meduni.bibbox.informationprocessing.service.impl.DictionaryDictionaryLinkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author robert
 * @see DictionaryDictionaryLinkLocalService
 * @see at.graz.meduni.bibbox.informationprocessing.service.base.DictionaryDictionaryLinkLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.informationprocessing.service.impl.DictionaryDictionaryLinkLocalServiceImpl
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.informationprocessing.service.impl.DictionaryDictionaryLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dictionary dictionary link to the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	* @return the dictionary dictionary link that was added
	*/
	public static at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink addDictionaryDictionaryLink(
		at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		return getService().addDictionaryDictionaryLink(dictionaryDictionaryLink);
	}

	/**
	* Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	*
	* @param dictionarydictionarylinkId the primary key for the new dictionary dictionary link
	* @return the new dictionary dictionary link
	*/
	public static at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink createDictionaryDictionaryLink(
		long dictionarydictionarylinkId) {
		return getService()
				   .createDictionaryDictionaryLink(dictionarydictionarylinkId);
	}

	/**
	* Deletes the dictionary dictionary link from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	*/
	public static at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink deleteDictionaryDictionaryLink(
		at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		return getService()
				   .deleteDictionaryDictionaryLink(dictionaryDictionaryLink);
	}

	/**
	* Deletes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	* @throws PortalException if a dictionary dictionary link with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink deleteDictionaryDictionaryLink(
		long dictionarydictionarylinkId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteDictionaryDictionaryLink(dictionarydictionarylinkId);
	}

	public static at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink fetchDictionaryDictionaryLink(
		long dictionarydictionarylinkId) {
		return getService()
				   .fetchDictionaryDictionaryLink(dictionarydictionarylinkId);
	}

	/**
	* Returns the dictionary dictionary link matching the UUID and group.
	*
	* @param uuid the dictionary dictionary link's UUID
	* @param groupId the primary key of the group
	* @return the matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink fetchDictionaryDictionaryLinkByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService()
				   .fetchDictionaryDictionaryLinkByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the dictionary dictionary link with the primary key.
	*
	* @param dictionarydictionarylinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link
	* @throws PortalException if a dictionary dictionary link with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink getDictionaryDictionaryLink(
		long dictionarydictionarylinkId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getDictionaryDictionaryLink(dictionarydictionarylinkId);
	}

	/**
	* Returns the dictionary dictionary link matching the UUID and group.
	*
	* @param uuid the dictionary dictionary link's UUID
	* @param groupId the primary key of the group
	* @return the matching dictionary dictionary link
	* @throws PortalException if a matching dictionary dictionary link could not be found
	*/
	public static at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink getDictionaryDictionaryLinkByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getDictionaryDictionaryLinkByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the dictionary dictionary link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	* @return the dictionary dictionary link that was updated
	*/
	public static at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink updateDictionaryDictionaryLink(
		at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		return getService()
				   .updateDictionaryDictionaryLink(dictionaryDictionaryLink);
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
	* Returns the number of dictionary dictionary links.
	*
	* @return the number of dictionary dictionary links
	*/
	public static int getDictionaryDictionaryLinksCount() {
		return getService().getDictionaryDictionaryLinksCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of dictionary dictionary links
	*/
	public static java.util.List<at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink> getDictionaryDictionaryLinks(
		int start, int end) {
		return getService().getDictionaryDictionaryLinks(start, end);
	}

	/**
	* Returns all the dictionary dictionary links matching the UUID and company.
	*
	* @param uuid the UUID of the dictionary dictionary links
	* @param companyId the primary key of the company
	* @return the matching dictionary dictionary links, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink> getDictionaryDictionaryLinksByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .getDictionaryDictionaryLinksByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of dictionary dictionary links matching the UUID and company.
	*
	* @param uuid the UUID of the dictionary dictionary links
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching dictionary dictionary links, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink> getDictionaryDictionaryLinksByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.informationprocessing.model.DictionaryDictionaryLink> orderByComparator) {
		return getService()
				   .getDictionaryDictionaryLinksByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
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

	public static DictionaryDictionaryLinkLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DictionaryDictionaryLinkLocalService, DictionaryDictionaryLinkLocalService> _serviceTracker =
		ServiceTrackerFactory.open(DictionaryDictionaryLinkLocalService.class);
}