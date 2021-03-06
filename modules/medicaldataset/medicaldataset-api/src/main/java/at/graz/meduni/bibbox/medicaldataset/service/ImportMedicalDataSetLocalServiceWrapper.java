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
 * Provides a wrapper for {@link ImportMedicalDataSetLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLocalService
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetLocalServiceWrapper
	implements ImportMedicalDataSetLocalService,
		ServiceWrapper<ImportMedicalDataSetLocalService> {
	public ImportMedicalDataSetLocalServiceWrapper(
		ImportMedicalDataSetLocalService importMedicalDataSetLocalService) {
		_importMedicalDataSetLocalService = importMedicalDataSetLocalService;
	}

	/**
	* Adds the import medical data set to the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSet the import medical data set
	* @return the import medical data set that was added
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet addImportMedicalDataSet(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet importMedicalDataSet) {
		return _importMedicalDataSetLocalService.addImportMedicalDataSet(importMedicalDataSet);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet addImportMedicalDataSet(
		java.lang.String importName, java.lang.String importType,
		long imiJobId, java.lang.String description, java.lang.String fileName,
		java.lang.String filePath, long fileId, int importCount,
		int importStatus,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLocalService.addImportMedicalDataSet(importName,
			importType, imiJobId, description, fileName, filePath, fileId,
			importCount, importStatus, serviceContext);
	}

	/**
	* Creates a new import medical data set with the primary key. Does not add the import medical data set to the database.
	*
	* @param importMedicalDataSetId the primary key for the new import medical data set
	* @return the new import medical data set
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet createImportMedicalDataSet(
		long importMedicalDataSetId) {
		return _importMedicalDataSetLocalService.createImportMedicalDataSet(importMedicalDataSetId);
	}

	/**
	* Deletes the import medical data set from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSet the import medical data set
	* @return the import medical data set that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet deleteImportMedicalDataSet(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet importMedicalDataSet) {
		return _importMedicalDataSetLocalService.deleteImportMedicalDataSet(importMedicalDataSet);
	}

	/**
	* Deletes the import medical data set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetId the primary key of the import medical data set
	* @return the import medical data set that was removed
	* @throws PortalException if a import medical data set with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet deleteImportMedicalDataSet(
		long importMedicalDataSetId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLocalService.deleteImportMedicalDataSet(importMedicalDataSetId);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet fetchImportMedicalDataSet(
		long importMedicalDataSetId) {
		return _importMedicalDataSetLocalService.fetchImportMedicalDataSet(importMedicalDataSetId);
	}

	/**
	* Returns the import medical data set matching the UUID and group.
	*
	* @param uuid the import medical data set's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet fetchImportMedicalDataSetByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _importMedicalDataSetLocalService.fetchImportMedicalDataSetByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the import medical data set with the primary key.
	*
	* @param importMedicalDataSetId the primary key of the import medical data set
	* @return the import medical data set
	* @throws PortalException if a import medical data set with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet getImportMedicalDataSet(
		long importMedicalDataSetId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLocalService.getImportMedicalDataSet(importMedicalDataSetId);
	}

	/**
	* Returns the import medical data set matching the UUID and group.
	*
	* @param uuid the import medical data set's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set
	* @throws PortalException if a matching import medical data set could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet getImportMedicalDataSetByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLocalService.getImportMedicalDataSetByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the import medical data set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSet the import medical data set
	* @return the import medical data set that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet updateImportMedicalDataSet(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet importMedicalDataSet) {
		return _importMedicalDataSetLocalService.updateImportMedicalDataSet(importMedicalDataSet);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet updateImportMedicalDataSet(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet importMedicalDataSet,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLocalService.updateImportMedicalDataSet(importMedicalDataSet,
			serviceContext);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet updateImportMedicalDataSet(
		long importMedicalDataSetId, java.lang.String importName,
		java.lang.String importType, long imiJobId,
		java.lang.String description, java.lang.String fileName,
		java.lang.String filePath, long fileId, int importCount,
		int importStatus,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLocalService.updateImportMedicalDataSet(importMedicalDataSetId,
			importName, importType, imiJobId, description, fileName, filePath,
			fileId, importCount, importStatus, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _importMedicalDataSetLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _importMedicalDataSetLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _importMedicalDataSetLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _importMedicalDataSetLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getImportMedicalDataSetCount(long groupId) {
		return _importMedicalDataSetLocalService.getImportMedicalDataSetCount(groupId);
	}

	/**
	* Returns the number of import medical data sets.
	*
	* @return the number of import medical data sets
	*/
	@Override
	public int getImportMedicalDataSetsCount() {
		return _importMedicalDataSetLocalService.getImportMedicalDataSetsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _importMedicalDataSetLocalService.getOSGiServiceIdentifier();
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
		return _importMedicalDataSetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _importMedicalDataSetLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _importMedicalDataSetLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the import medical data sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @return the range of import medical data sets
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet> getImportMedicalDataSets(
		int start, int end) {
		return _importMedicalDataSetLocalService.getImportMedicalDataSets(start,
			end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet> getImportMedicalDataSets(
		long groupId) {
		return _importMedicalDataSetLocalService.getImportMedicalDataSets(groupId);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet> getImportMedicalDataSets(
		long groupId, int start, int end) {
		return _importMedicalDataSetLocalService.getImportMedicalDataSets(groupId,
			start, end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet> getImportMedicalDataSets(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet> ob) {
		return _importMedicalDataSetLocalService.getImportMedicalDataSets(groupId,
			start, end, ob);
	}

	/**
	* Returns all the import medical data sets matching the UUID and company.
	*
	* @param uuid the UUID of the import medical data sets
	* @param companyId the primary key of the company
	* @return the matching import medical data sets, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet> getImportMedicalDataSetsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _importMedicalDataSetLocalService.getImportMedicalDataSetsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of import medical data sets matching the UUID and company.
	*
	* @param uuid the UUID of the import medical data sets
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of import medical data sets
	* @param end the upper bound of the range of import medical data sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching import medical data sets, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet> getImportMedicalDataSetsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet> orderByComparator) {
		return _importMedicalDataSetLocalService.getImportMedicalDataSetsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
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
		return _importMedicalDataSetLocalService.dynamicQueryCount(dynamicQuery);
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
		return _importMedicalDataSetLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ImportMedicalDataSetLocalService getWrappedService() {
		return _importMedicalDataSetLocalService;
	}

	@Override
	public void setWrappedService(
		ImportMedicalDataSetLocalService importMedicalDataSetLocalService) {
		_importMedicalDataSetLocalService = importMedicalDataSetLocalService;
	}

	private ImportMedicalDataSetLocalService _importMedicalDataSetLocalService;
}