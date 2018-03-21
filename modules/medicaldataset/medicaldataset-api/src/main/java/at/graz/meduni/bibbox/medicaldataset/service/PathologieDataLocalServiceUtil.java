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

package at.graz.meduni.bibbox.medicaldataset.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for PathologieData. This utility wraps
 * {@link at.graz.meduni.bibbox.medicaldataset.service.impl.PathologieDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PathologieDataLocalService
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.PathologieDataLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.PathologieDataLocalServiceImpl
 * @generated
 */
@ProviderType
public class PathologieDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.PathologieDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the pathologie data to the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieData the pathologie data
	* @return the pathologie data that was added
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologieData addPathologieData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologieData pathologieData) {
		return getService().addPathologieData(pathologieData);
	}

	/**
	* Creates a new pathologie data with the primary key. Does not add the pathologie data to the database.
	*
	* @param pathologieDataId the primary key for the new pathologie data
	* @return the new pathologie data
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologieData createPathologieData(
		long pathologieDataId) {
		return getService().createPathologieData(pathologieDataId);
	}

	/**
	* Deletes the pathologie data from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieData the pathologie data
	* @return the pathologie data that was removed
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologieData deletePathologieData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologieData pathologieData) {
		return getService().deletePathologieData(pathologieData);
	}

	/**
	* Deletes the pathologie data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data that was removed
	* @throws PortalException if a pathologie data with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologieData deletePathologieData(
		long pathologieDataId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePathologieData(pathologieDataId);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.PathologieData fetchPathologieData(
		long pathologieDataId) {
		return getService().fetchPathologieData(pathologieDataId);
	}

	/**
	* Returns the pathologie data matching the UUID and group.
	*
	* @param uuid the pathologie data's UUID
	* @param groupId the primary key of the group
	* @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologieData fetchPathologieDataByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchPathologieDataByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the pathologie data with the primary key.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data
	* @throws PortalException if a pathologie data with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologieData getPathologieData(
		long pathologieDataId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPathologieData(pathologieDataId);
	}

	/**
	* Returns the pathologie data matching the UUID and group.
	*
	* @param uuid the pathologie data's UUID
	* @param groupId the primary key of the group
	* @return the matching pathologie data
	* @throws PortalException if a matching pathologie data could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologieData getPathologieDataByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPathologieDataByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the pathologie data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pathologieData the pathologie data
	* @return the pathologie data that was updated
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologieData updatePathologieData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologieData pathologieData) {
		return getService().updatePathologieData(pathologieData);
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
	* Returns the number of pathologie datas.
	*
	* @return the number of pathologie datas
	*/
	public static int getPathologieDatasCount() {
		return getService().getPathologieDatasCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the pathologie datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @return the range of pathologie datas
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> getPathologieDatas(
		int start, int end) {
		return getService().getPathologieDatas(start, end);
	}

	/**
	* Returns all the pathologie datas matching the UUID and company.
	*
	* @param uuid the UUID of the pathologie datas
	* @param companyId the primary key of the company
	* @return the matching pathologie datas, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> getPathologieDatasByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getPathologieDatasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of pathologie datas matching the UUID and company.
	*
	* @param uuid the UUID of the pathologie datas
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of pathologie datas
	* @param end the upper bound of the range of pathologie datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching pathologie datas, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> getPathologieDatasByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> orderByComparator) {
		return getService()
				   .getPathologieDatasByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
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

	public static PathologieDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PathologieDataLocalService, PathologieDataLocalService> _serviceTracker =
		ServiceTrackerFactory.open(PathologieDataLocalService.class);
}