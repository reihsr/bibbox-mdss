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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImportMedicalDataSetFieldMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetFieldMapLocalService
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetFieldMapLocalServiceWrapper
	implements ImportMedicalDataSetFieldMapLocalService,
		ServiceWrapper<ImportMedicalDataSetFieldMapLocalService> {
	public ImportMedicalDataSetFieldMapLocalServiceWrapper(
		ImportMedicalDataSetFieldMapLocalService importMedicalDataSetFieldMapLocalService) {
		_importMedicalDataSetFieldMapLocalService = importMedicalDataSetFieldMapLocalService;
	}

	/**
	* Adds the import medical data set field map to the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMap the import medical data set field map
	* @return the import medical data set field map that was added
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap addImportMedicalDataSetFieldMap(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		return _importMedicalDataSetFieldMapLocalService.addImportMedicalDataSetFieldMap(importMedicalDataSetFieldMap);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap addImportMedicalDataSetFieldMap(
		long importMedicalDataSetId, java.lang.String importField,
		java.lang.String importFieldPath, java.lang.String sampleValue,
		java.lang.String TableName, java.lang.String TableField,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetFieldMapLocalService.addImportMedicalDataSetFieldMap(importMedicalDataSetId,
			importField, importFieldPath, sampleValue, TableName, TableField,
			serviceContext);
	}

	/**
	* Creates a new import medical data set field map with the primary key. Does not add the import medical data set field map to the database.
	*
	* @param importMedicalDataSetFieldMapId the primary key for the new import medical data set field map
	* @return the new import medical data set field map
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap createImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId) {
		return _importMedicalDataSetFieldMapLocalService.createImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId);
	}

	/**
	* Deletes the import medical data set field map from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMap the import medical data set field map
	* @return the import medical data set field map that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap deleteImportMedicalDataSetFieldMap(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		return _importMedicalDataSetFieldMapLocalService.deleteImportMedicalDataSetFieldMap(importMedicalDataSetFieldMap);
	}

	/**
	* Deletes the import medical data set field map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMapId the primary key of the import medical data set field map
	* @return the import medical data set field map that was removed
	* @throws PortalException if a import medical data set field map with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap deleteImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetFieldMapLocalService.deleteImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap fetchImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId) {
		return _importMedicalDataSetFieldMapLocalService.fetchImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId);
	}

	/**
	* Returns the import medical data set field map matching the UUID and group.
	*
	* @param uuid the import medical data set field map's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap fetchImportMedicalDataSetFieldMapByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _importMedicalDataSetFieldMapLocalService.fetchImportMedicalDataSetFieldMapByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the import medical data set field map with the primary key.
	*
	* @param importMedicalDataSetFieldMapId the primary key of the import medical data set field map
	* @return the import medical data set field map
	* @throws PortalException if a import medical data set field map with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap getImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId);
	}

	/**
	* Returns the import medical data set field map matching the UUID and group.
	*
	* @param uuid the import medical data set field map's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set field map
	* @throws PortalException if a matching import medical data set field map could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap getImportMedicalDataSetFieldMapByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMapByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the import medical data set field map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMap the import medical data set field map
	* @return the import medical data set field map that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
		return _importMedicalDataSetFieldMapLocalService.updateImportMedicalDataSetFieldMap(importMedicalDataSetFieldMap);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetFieldMapLocalService.updateImportMedicalDataSetFieldMap(importMedicalDataSetFieldMap,
			serviceContext);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId, long importMedicalDataSetId,
		java.lang.String importField, java.lang.String importFieldPath,
		java.lang.String sampleValue, java.lang.String TableName,
		java.lang.String TableField,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetFieldMapLocalService.updateImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId,
			importMedicalDataSetId, importField, importFieldPath, sampleValue,
			TableName, TableField, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _importMedicalDataSetFieldMapLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _importMedicalDataSetFieldMapLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _importMedicalDataSetFieldMapLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _importMedicalDataSetFieldMapLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetFieldMapLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetFieldMapLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getImportMedicalDataSetFieldMapCount(long groupId) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMapCount(groupId);
	}

	@Override
	public int getImportMedicalDataSetFieldMapCountFromImportMedicalDataSet(
		long importMedicalDataSetId) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMapCountFromImportMedicalDataSet(importMedicalDataSetId);
	}

	/**
	* Returns the number of import medical data set field maps.
	*
	* @return the number of import medical data set field maps
	*/
	@Override
	public int getImportMedicalDataSetFieldMapsCount() {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMapsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _importMedicalDataSetFieldMapLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _importMedicalDataSetFieldMapLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _importMedicalDataSetFieldMapLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _importMedicalDataSetFieldMapLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		int start, int end) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMaps(start,
			end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		long groupId) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMaps(groupId);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		long groupId, int start, int end) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMaps(groupId,
			start, end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> ob) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMaps(groupId,
			start, end, ob);
	}

	/**
	* Returns all the import medical data set field maps matching the UUID and company.
	*
	* @param uuid the UUID of the import medical data set field maps
	* @param companyId the primary key of the company
	* @return the matching import medical data set field maps, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMapsByUuidAndCompanyId(uuid,
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
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> orderByComparator) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMapsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(
		long importMedicalDataSetId) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(importMedicalDataSetId);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(importMedicalDataSetId,
			start, end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap> ob) {
		return _importMedicalDataSetFieldMapLocalService.getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(importMedicalDataSetId,
			start, end, ob);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _importMedicalDataSetFieldMapLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _importMedicalDataSetFieldMapLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ImportMedicalDataSetFieldMapLocalService getWrappedService() {
		return _importMedicalDataSetFieldMapLocalService;
	}

	@Override
	public void setWrappedService(
		ImportMedicalDataSetFieldMapLocalService importMedicalDataSetFieldMapLocalService) {
		_importMedicalDataSetFieldMapLocalService = importMedicalDataSetFieldMapLocalService;
	}

	private ImportMedicalDataSetFieldMapLocalService _importMedicalDataSetFieldMapLocalService;
}