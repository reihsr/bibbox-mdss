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
 * Provides the local service utility for ImportMedicalDataSetLog. This utility wraps
 * {@link at.graz.meduni.bibbox.medicaldataset.service.impl.ImportMedicalDataSetLogLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLogLocalService
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.ImportMedicalDataSetLogLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.ImportMedicalDataSetLogLocalServiceImpl
 * @generated
 */
@ProviderType
public class ImportMedicalDataSetLogLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.ImportMedicalDataSetLogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the import medical data set log to the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetLog the import medical data set log
	* @return the import medical data set log that was added
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog addImportMedicalDataSetLog(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog importMedicalDataSetLog) {
		return getService().addImportMedicalDataSetLog(importMedicalDataSetLog);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog addImportMedicalDataSetLog(
		long importMedicalDataSetId, int importStatus,
		java.lang.String importStatusLog,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addImportMedicalDataSetLog(importMedicalDataSetId,
			importStatus, importStatusLog, serviceContext);
	}

	/**
	* Creates a new import medical data set log with the primary key. Does not add the import medical data set log to the database.
	*
	* @param importMedicalDataSetLogId the primary key for the new import medical data set log
	* @return the new import medical data set log
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog createImportMedicalDataSetLog(
		long importMedicalDataSetLogId) {
		return getService()
				   .createImportMedicalDataSetLog(importMedicalDataSetLogId);
	}

	/**
	* Deletes the import medical data set log from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetLog the import medical data set log
	* @return the import medical data set log that was removed
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog deleteImportMedicalDataSetLog(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog importMedicalDataSetLog) {
		return getService()
				   .deleteImportMedicalDataSetLog(importMedicalDataSetLog);
	}

	/**
	* Deletes the import medical data set log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetLogId the primary key of the import medical data set log
	* @return the import medical data set log that was removed
	* @throws PortalException if a import medical data set log with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog deleteImportMedicalDataSetLog(
		long importMedicalDataSetLogId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteImportMedicalDataSetLog(importMedicalDataSetLogId);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog fetchImportMedicalDataSetLog(
		long importMedicalDataSetLogId) {
		return getService()
				   .fetchImportMedicalDataSetLog(importMedicalDataSetLogId);
	}

	/**
	* Returns the import medical data set log matching the UUID and group.
	*
	* @param uuid the import medical data set log's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set log, or <code>null</code> if a matching import medical data set log could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog fetchImportMedicalDataSetLogByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService()
				   .fetchImportMedicalDataSetLogByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the import medical data set log with the primary key.
	*
	* @param importMedicalDataSetLogId the primary key of the import medical data set log
	* @return the import medical data set log
	* @throws PortalException if a import medical data set log with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog getImportMedicalDataSetLog(
		long importMedicalDataSetLogId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getImportMedicalDataSetLog(importMedicalDataSetLogId);
	}

	/**
	* Returns the import medical data set log matching the UUID and group.
	*
	* @param uuid the import medical data set log's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set log
	* @throws PortalException if a matching import medical data set log could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog getImportMedicalDataSetLogByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getImportMedicalDataSetLogByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the import medical data set log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetLog the import medical data set log
	* @return the import medical data set log that was updated
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog updateImportMedicalDataSetLog(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog importMedicalDataSetLog) {
		return getService()
				   .updateImportMedicalDataSetLog(importMedicalDataSetLog);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog updateImportMedicalDataSetLog(
		at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog importMedicalDataSetLog,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateImportMedicalDataSetLog(importMedicalDataSetLog,
			serviceContext);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog updateImportMedicalDataSetLog(
		long importMedicalDataSetLogId, long importMedicalDataSetId,
		int importStatus, java.lang.String importStatusLog,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateImportMedicalDataSetLog(importMedicalDataSetLogId,
			importMedicalDataSetId, importStatus, importStatusLog,
			serviceContext);
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
	* Returns the number of import medical data set logs.
	*
	* @return the number of import medical data set logs
	*/
	public static int getImportMedicalDataSetLogsCount() {
		return getService().getImportMedicalDataSetLogsCount();
	}

	public static int getImportMedicalDataSetLogsCount(long groupId) {
		return getService().getImportMedicalDataSetLogsCount(groupId);
	}

	public static int getImportMedicalDataSetLogsFromImportsAtStatusCount(
		long importMedicalDataSetId, int importStatus) {
		return getService()
				   .getImportMedicalDataSetLogsFromImportsAtStatusCount(importMedicalDataSetId,
			importStatus);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetFromImportsAtStatusLogs(
		long importMedicalDataSetId, int importStatus) {
		return getService()
				   .getImportMedicalDataSetFromImportsAtStatusLogs(importMedicalDataSetId,
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
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogs(
		int start, int end) {
		return getService().getImportMedicalDataSetLogs(start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogs(
		long groupId) {
		return getService().getImportMedicalDataSetLogs(groupId);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogs(
		long groupId, int start, int end) {
		return getService().getImportMedicalDataSetLogs(groupId, start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogs(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> ob) {
		return getService().getImportMedicalDataSetLogs(groupId, start, end, ob);
	}

	/**
	* Returns all the import medical data set logs matching the UUID and company.
	*
	* @param uuid the UUID of the import medical data set logs
	* @param companyId the primary key of the company
	* @return the matching import medical data set logs, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService()
				   .getImportMedicalDataSetLogsByUuidAndCompanyId(uuid,
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
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> orderByComparator) {
		return getService()
				   .getImportMedicalDataSetLogsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogsFromImportsAtStatus(
		long importMedicalDataSetId, int importStatus, int start, int end) {
		return getService()
				   .getImportMedicalDataSetLogsFromImportsAtStatus(importMedicalDataSetId,
			importStatus, start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> getImportMedicalDataSetLogsFromImportsAtStatus(
		long importMedicalDataSetId, int importStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog> ob) {
		return getService()
				   .getImportMedicalDataSetLogsFromImportsAtStatus(importMedicalDataSetId,
			importStatus, start, end, ob);
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

	public static ImportMedicalDataSetLogLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ImportMedicalDataSetLogLocalService, ImportMedicalDataSetLogLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ImportMedicalDataSetLogLocalService.class);
}