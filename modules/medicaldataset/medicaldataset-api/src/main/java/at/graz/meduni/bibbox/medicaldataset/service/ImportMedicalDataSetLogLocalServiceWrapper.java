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
 * Provides a wrapper for {@link ImportMedicalDataSetLogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLogLocalService
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetLogLocalServiceWrapper
	implements ImportMedicalDataSetLogLocalService,
		ServiceWrapper<ImportMedicalDataSetLogLocalService> {
	public ImportMedicalDataSetLogLocalServiceWrapper(
		ImportMedicalDataSetLogLocalService importMedicalDataSetLogLocalService) {
		_importMedicalDataSetLogLocalService = importMedicalDataSetLogLocalService;
	}

	/**
	* Adds the import medical data set log to the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetLog the import medical data set log
	* @return the import medical data set log that was added
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog addImportMedicalDataSetLog(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog importMedicalDataSetLog) {
		return _importMedicalDataSetLogLocalService.addImportMedicalDataSetLog(importMedicalDataSetLog);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog addImportMedicalDataSetLog(
		long importMedicalDataSetId, int importStatus,
		java.lang.String importStatusLog,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLogLocalService.addImportMedicalDataSetLog(importMedicalDataSetId,
			importStatus, importStatusLog, serviceContext);
	}

	/**
	* Creates a new import medical data set log with the primary key. Does not add the import medical data set log to the database.
	*
	* @param importMedicalDataSetLogId the primary key for the new import medical data set log
	* @return the new import medical data set log
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog createImportMedicalDataSetLog(
		long importMedicalDataSetLogId) {
		return _importMedicalDataSetLogLocalService.createImportMedicalDataSetLog(importMedicalDataSetLogId);
	}

	/**
	* Deletes the import medical data set log from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetLog the import medical data set log
	* @return the import medical data set log that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog deleteImportMedicalDataSetLog(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog importMedicalDataSetLog) {
		return _importMedicalDataSetLogLocalService.deleteImportMedicalDataSetLog(importMedicalDataSetLog);
	}

	/**
	* Deletes the import medical data set log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetLogId the primary key of the import medical data set log
	* @return the import medical data set log that was removed
	* @throws PortalException if a import medical data set log with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog deleteImportMedicalDataSetLog(
		long importMedicalDataSetLogId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLogLocalService.deleteImportMedicalDataSetLog(importMedicalDataSetLogId);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog fetchImportMedicalDataSetLog(
		long importMedicalDataSetLogId) {
		return _importMedicalDataSetLogLocalService.fetchImportMedicalDataSetLog(importMedicalDataSetLogId);
	}

	/**
	* Returns the import medical data set log matching the UUID and group.
	*
	* @param uuid the import medical data set log's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog fetchImportMedicalDataSetLogByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _importMedicalDataSetLogLocalService.fetchImportMedicalDataSetLogByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the import medical data set log with the primary key.
	*
	* @param importMedicalDataSetLogId the primary key of the import medical data set log
	* @return the import medical data set log
	* @throws PortalException if a import medical data set log with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog getImportMedicalDataSetLog(
		long importMedicalDataSetLogId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLog(importMedicalDataSetLogId);
	}

	/**
	* Returns the import medical data set log matching the UUID and group.
	*
	* @param uuid the import medical data set log's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set log
	* @throws PortalException if a matching import medical data set log could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog getImportMedicalDataSetLogByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the import medical data set log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetLog the import medical data set log
	* @return the import medical data set log that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog updateImportMedicalDataSetLog(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog importMedicalDataSetLog) {
		return _importMedicalDataSetLogLocalService.updateImportMedicalDataSetLog(importMedicalDataSetLog);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog updateImportMedicalDataSetLog(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog importMedicalDataSetLog,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLogLocalService.updateImportMedicalDataSetLog(importMedicalDataSetLog,
			serviceContext);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog updateImportMedicalDataSetLog(
		long importMedicalDataSetLogId, long importMedicalDataSetId,
		int importStatus, java.lang.String importStatusLog,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLogLocalService.updateImportMedicalDataSetLog(importMedicalDataSetLogId,
			importMedicalDataSetId, importStatus, importStatusLog,
			serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _importMedicalDataSetLogLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _importMedicalDataSetLogLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _importMedicalDataSetLogLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _importMedicalDataSetLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _importMedicalDataSetLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of import medical data set logs.
	*
	* @return the number of import medical data set logs
	*/
	@Override
	public int getImportMedicalDataSetLogsCount() {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogsCount();
	}

	@Override
	public int getImportMedicalDataSetLogsCount(long groupId) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogsCount(groupId);
	}

	@Override
	public int getImportMedicalDataSetLogsFromImportsAtStatusCount(
		long importMedicalDataSetId, int importStatus) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogsFromImportsAtStatusCount(importMedicalDataSetId,
			importStatus);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _importMedicalDataSetLogLocalService.getOSGiServiceIdentifier();
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
		return _importMedicalDataSetLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _importMedicalDataSetLogLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _importMedicalDataSetLogLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetFromImportsAtStatusLogs(
		long importMedicalDataSetId, int importStatus) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetFromImportsAtStatusLogs(importMedicalDataSetId,
			importStatus);
	}

	/**
	* Returns a range of all the import medical data set logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of import medical data set logs
	* @param end the upper bound of the range of import medical data set logs (not inclusive)
	* @return the range of import medical data set logs
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogs(
		int start, int end) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogs(start,
			end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogs(
		long groupId) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogs(groupId);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogs(
		long groupId, int start, int end) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogs(groupId,
			start, end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogs(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> ob) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogs(groupId,
			start, end, ob);
	}

	/**
	* Returns all the import medical data set logs matching the UUID and company.
	*
	* @param uuid the UUID of the import medical data set logs
	* @param companyId the primary key of the company
	* @return the matching import medical data set logs, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of import medical data set logs matching the UUID and company.
	*
	* @param uuid the UUID of the import medical data set logs
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of import medical data set logs
	* @param end the upper bound of the range of import medical data set logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching import medical data set logs, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> orderByComparator) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogsFromImportsAtStatus(
		long importMedicalDataSetId, int importStatus, int start, int end) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogsFromImportsAtStatus(importMedicalDataSetId,
			importStatus, start, end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogsFromImportsAtStatus(
		long importMedicalDataSetId, int importStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> ob) {
		return _importMedicalDataSetLogLocalService.getImportMedicalDataSetLogsFromImportsAtStatus(importMedicalDataSetId,
			importStatus, start, end, ob);
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
		return _importMedicalDataSetLogLocalService.dynamicQueryCount(dynamicQuery);
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
		return _importMedicalDataSetLogLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ImportMedicalDataSetLogLocalService getWrappedService() {
		return _importMedicalDataSetLogLocalService;
	}

	@Override
	public void setWrappedService(
		ImportMedicalDataSetLogLocalService importMedicalDataSetLogLocalService) {
		_importMedicalDataSetLogLocalService = importMedicalDataSetLogLocalService;
	}

	private ImportMedicalDataSetLogLocalService _importMedicalDataSetLogLocalService;
}