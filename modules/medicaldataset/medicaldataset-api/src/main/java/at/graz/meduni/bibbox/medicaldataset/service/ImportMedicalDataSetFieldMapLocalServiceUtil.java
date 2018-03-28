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
 * Provides the local service utility for ImportMedicalDataSetFieldMap. This utility wraps
 * {@link at.graz.meduni.bibbox.medicaldataset.service.impl.ImportMedicalDataSetFieldMapLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetFieldMapLocalService
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.ImportMedicalDataSetFieldMapLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.ImportMedicalDataSetFieldMapLocalServiceImpl
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetFieldMapLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.ImportMedicalDataSetFieldMapLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the import medical data set field map to the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMap the import medical data set field map
	* @return the import medical data set field map that was added
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap addImportMedicalDataSetFieldMap(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		return getService()
				   .addImportMedicalDataSetFieldMap(importMedicalDataSetFieldMap);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap addImportMedicalDataSetFieldMap(
		long importMedicalDataSetId, java.lang.String importField,
		java.lang.String importFieldPath, java.lang.String TableName,
		java.lang.String TableField,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addImportMedicalDataSetFieldMap(importMedicalDataSetId,
			importField, importFieldPath, TableName, TableField, serviceContext);
	}

	/**
	* Creates a new import medical data set field map with the primary key. Does not add the import medical data set field map to the database.
	*
	* @param importMedicalDataSetFieldMapId the primary key for the new import medical data set field map
	* @return the new import medical data set field map
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap createImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId) {
		return getService()
				   .createImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId);
	}

	/**
	* Deletes the import medical data set field map from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMap the import medical data set field map
	* @return the import medical data set field map that was removed
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap deleteImportMedicalDataSetFieldMap(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		return getService()
				   .deleteImportMedicalDataSetFieldMap(importMedicalDataSetFieldMap);
	}

	/**
	* Deletes the import medical data set field map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMapId the primary key of the import medical data set field map
	* @return the import medical data set field map that was removed
	* @throws PortalException if a import medical data set field map with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap deleteImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap fetchImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId) {
		return getService()
				   .fetchImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId);
	}

	/**
	* Returns the import medical data set field map matching the UUID and group.
	*
	* @param uuid the import medical data set field map's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap fetchImportMedicalDataSetFieldMapByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService()
				   .fetchImportMedicalDataSetFieldMapByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the import medical data set field map with the primary key.
	*
	* @param importMedicalDataSetFieldMapId the primary key of the import medical data set field map
	* @return the import medical data set field map
	* @throws PortalException if a import medical data set field map with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap getImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId);
	}

	/**
	* Returns the import medical data set field map matching the UUID and group.
	*
	* @param uuid the import medical data set field map's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set field map
	* @throws PortalException if a matching import medical data set field map could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap getImportMedicalDataSetFieldMapByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getImportMedicalDataSetFieldMapByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the import medical data set field map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMap the import medical data set field map
	* @return the import medical data set field map that was updated
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		return getService()
				   .updateImportMedicalDataSetFieldMap(importMedicalDataSetFieldMap);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateImportMedicalDataSetFieldMap(importMedicalDataSetFieldMap,
			serviceContext);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId, long importMedicalDataSetId,
		java.lang.String importField, java.lang.String importFieldPath,
		java.lang.String TableName, java.lang.String TableField,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId,
			importMedicalDataSetId, importField, importFieldPath, TableName,
			TableField, serviceContext);
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

	public static int getImportMedicalDataSetFieldMapCount(long groupId) {
		return getService().getImportMedicalDataSetFieldMapCount(groupId);
	}

	public static int getImportMedicalDataSetFieldMapCountFromImportMedicalDataSet(
		long importMedicalDataSetId) {
		return getService()
				   .getImportMedicalDataSetFieldMapCountFromImportMedicalDataSet(importMedicalDataSetId);
	}

	/**
	* Returns the number of import medical data set field maps.
	*
	* @return the number of import medical data set field maps
	*/
	public static int getImportMedicalDataSetFieldMapsCount() {
		return getService().getImportMedicalDataSetFieldMapsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the import medical data set field maps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of import medical data set field maps
	* @param end the upper bound of the range of import medical data set field maps (not inclusive)
	* @return the range of import medical data set field maps
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		int start, int end) {
		return getService().getImportMedicalDataSetFieldMaps(start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		long groupId) {
		return getService().getImportMedicalDataSetFieldMaps(groupId);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		long groupId, int start, int end) {
		return getService().getImportMedicalDataSetFieldMaps(groupId, start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> ob) {
		return getService()
				   .getImportMedicalDataSetFieldMaps(groupId, start, end, ob);
	}

	/**
	* Returns all the import medical data set field maps matching the UUID and company.
	*
	* @param uuid the UUID of the import medical data set field maps
	* @param companyId the primary key of the company
	* @return the matching import medical data set field maps, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .getImportMedicalDataSetFieldMapsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of import medical data set field maps matching the UUID and company.
	*
	* @param uuid the UUID of the import medical data set field maps
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of import medical data set field maps
	* @param end the upper bound of the range of import medical data set field maps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching import medical data set field maps, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> orderByComparator) {
		return getService()
				   .getImportMedicalDataSetFieldMapsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(
		long importMedicalDataSetId) {
		return getService()
				   .getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(importMedicalDataSetId);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end) {
		return getService()
				   .getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(importMedicalDataSetId,
			start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> ob) {
		return getService()
				   .getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(importMedicalDataSetId,
			start, end, ob);
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

	public static ImportMedicalDataSetFieldMapLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ImportMedicalDataSetFieldMapLocalService, ImportMedicalDataSetFieldMapLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ImportMedicalDataSetFieldMapLocalService.class);
}