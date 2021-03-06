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
 * Provides the local service utility for PathologyData. This utility wraps
 * {@link at.graz.meduni.bibbox.medicaldataset.service.impl.PathologyDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PathologyDataLocalService
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.PathologyDataLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.PathologyDataLocalServiceImpl
 * @generated
 */
@ProviderType
public class PathologyDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.PathologyDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the pathology data to the database. Also notifies the appropriate model listeners.
	*
	* @param pathologyData the pathology data
	* @return the pathology data that was added
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData addPathologyData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologyData pathologyData) {
		return getService().addPathologyData(pathologyData);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData addPathologyData(
		long medicalRecordId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addPathologyData(medicalRecordId, serviceContext);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData addPathologyData(
		long medicalRecordId, java.util.Date receivedDate,
		java.util.Date validationDate, int patientAge, java.lang.String sender,
		java.lang.String extractionMethode,
		java.lang.String reportingPhysician1,
		java.lang.String reportingPhysician2, java.lang.String gynPhysician,
		java.lang.String validationPhysician1,
		java.lang.String validationPhysician2, java.lang.String reportStatus,
		int numberOfBlockes, int numberOfSlides, java.lang.String basicDisease,
		java.lang.String causeOfDeath, java.lang.String material,
		java.lang.String materialExtended,
		java.lang.String macroscopicDescription,
		java.lang.String microscopicDescription,
		java.lang.String histologicDescription,
		java.lang.String molecularPathologicDescription,
		java.lang.String zytologieDescription,
		java.lang.String pathologicDiagnosis,
		java.lang.String frozenSectionDiagnosis,
		java.lang.String molecularPathologicDiagnosis,
		java.lang.String zytologieDiagnosis,
		java.lang.String neuroPathologicDiagnosis, java.lang.String comment,
		java.lang.String zytologiecomment, java.lang.String obduktionsart,
		java.lang.String grad, java.lang.String tnmp, java.lang.String tnmt,
		java.lang.String tnmn, java.lang.String tnmm, java.lang.String tnmr,
		java.lang.String tnml, java.lang.String tnmv, java.lang.String tnmpn,
		java.lang.String dgcode1, java.lang.String dgcode2,
		java.lang.String pap, java.lang.String smearQuality,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addPathologyData(medicalRecordId, receivedDate,
			validationDate, patientAge, sender, extractionMethode,
			reportingPhysician1, reportingPhysician2, gynPhysician,
			validationPhysician1, validationPhysician2, reportStatus,
			numberOfBlockes, numberOfSlides, basicDisease, causeOfDeath,
			material, materialExtended, macroscopicDescription,
			microscopicDescription, histologicDescription,
			molecularPathologicDescription, zytologieDescription,
			pathologicDiagnosis, frozenSectionDiagnosis,
			molecularPathologicDiagnosis, zytologieDiagnosis,
			neuroPathologicDiagnosis, comment, zytologiecomment, obduktionsart,
			grad, tnmp, tnmt, tnmn, tnmm, tnmr, tnml, tnmv, tnmpn, dgcode1,
			dgcode2, pap, smearQuality, serviceContext);
	}

	/**
	* Creates a new pathology data with the primary key. Does not add the pathology data to the database.
	*
	* @param pathologyDataId the primary key for the new pathology data
	* @return the new pathology data
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData createPathologyData(
		long pathologyDataId) {
		return getService().createPathologyData(pathologyDataId);
	}

	/**
	* Deletes the pathology data from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologyData the pathology data
	* @return the pathology data that was removed
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData deletePathologyData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologyData pathologyData) {
		return getService().deletePathologyData(pathologyData);
	}

	/**
	* Deletes the pathology data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologyDataId the primary key of the pathology data
	* @return the pathology data that was removed
	* @throws PortalException if a pathology data with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData deletePathologyData(
		long pathologyDataId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePathologyData(pathologyDataId);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData fetchPathologyData(
		long pathologyDataId) {
		return getService().fetchPathologyData(pathologyDataId);
	}

	/**
	* Returns the pathology data matching the UUID and group.
	*
	* @param uuid the pathology data's UUID
	* @param groupId the primary key of the group
	* @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData fetchPathologyDataByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchPathologyDataByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the pathology data with the primary key.
	*
	* @param pathologyDataId the primary key of the pathology data
	* @return the pathology data
	* @throws PortalException if a pathology data with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData getPathologyData(
		long pathologyDataId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPathologyData(pathologyDataId);
	}

	/**
	* Returns the pathology data matching the UUID and group.
	*
	* @param uuid the pathology data's UUID
	* @param groupId the primary key of the group
	* @return the matching pathology data
	* @throws PortalException if a matching pathology data could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData getPathologyDataByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPathologyDataByUuidAndGroupId(uuid, groupId);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData getPathologyDataForMedicalRecord(
		long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException {
		return getService().getPathologyDataForMedicalRecord(medicalRecordId);
	}

	/**
	* Updates the pathology data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pathologyData the pathology data
	* @return the pathology data that was updated
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData updatePathologyData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologyData pathologyData) {
		return getService().updatePathologyData(pathologyData);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData updatePathologyData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologyData pathologyData,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().updatePathologyData(pathologyData, serviceContext);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.PathologyData updatePathologyData(
		long pathologyDataId, long medicalRecordId,
		java.util.Date receivedDate, java.util.Date validationDate,
		int patientAge, java.lang.String sender,
		java.lang.String extractionMethode,
		java.lang.String reportingPhysician1,
		java.lang.String reportingPhysician2, java.lang.String gynPhysician,
		java.lang.String validationPhysician1,
		java.lang.String validationPhysician2, java.lang.String reportStatus,
		int numberOfBlockes, int numberOfSlides, java.lang.String basicDisease,
		java.lang.String causeOfDeath, java.lang.String material,
		java.lang.String materialExtended,
		java.lang.String macroscopicDescription,
		java.lang.String microscopicDescription,
		java.lang.String histologicDescription,
		java.lang.String molecularPathologicDescription,
		java.lang.String zytologieDescription,
		java.lang.String pathologicDiagnosis,
		java.lang.String frozenSectionDiagnosis,
		java.lang.String molecularPathologicDiagnosis,
		java.lang.String zytologieDiagnosis,
		java.lang.String neuroPathologicDiagnosis, java.lang.String comment,
		java.lang.String zytologiecomment, java.lang.String obduktionsart,
		java.lang.String grad, java.lang.String tnmp, java.lang.String tnmt,
		java.lang.String tnmn, java.lang.String tnmm, java.lang.String tnmr,
		java.lang.String tnml, java.lang.String tnmv, java.lang.String tnmpn,
		java.lang.String dgcode1, java.lang.String dgcode2,
		java.lang.String pap, java.lang.String smearQuality,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updatePathologyData(pathologyDataId, medicalRecordId,
			receivedDate, validationDate, patientAge, sender,
			extractionMethode, reportingPhysician1, reportingPhysician2,
			gynPhysician, validationPhysician1, validationPhysician2,
			reportStatus, numberOfBlockes, numberOfSlides, basicDisease,
			causeOfDeath, material, materialExtended, macroscopicDescription,
			microscopicDescription, histologicDescription,
			molecularPathologicDescription, zytologieDescription,
			pathologicDiagnosis, frozenSectionDiagnosis,
			molecularPathologicDiagnosis, zytologieDiagnosis,
			neuroPathologicDiagnosis, comment, zytologiecomment, obduktionsart,
			grad, tnmp, tnmt, tnmn, tnmm, tnmr, tnml, tnmv, tnmpn, dgcode1,
			dgcode2, pap, smearQuality, serviceContext);
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

	public static int getPathologyDataCount(long groupId) {
		return getService().getPathologyDataCount(groupId);
	}

	/**
	* Returns the number of pathology datas.
	*
	* @return the number of pathology datas
	*/
	public static int getPathologyDatasCount() {
		return getService().getPathologyDatasCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the pathology datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @return the range of pathology datas
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologyData> getPathologyDatas(
		int start, int end) {
		return getService().getPathologyDatas(start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologyData> getPathologyDatas(
		long groupId) {
		return getService().getPathologyDatas(groupId);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologyData> getPathologyDatas(
		long groupId, int start, int end) {
		return getService().getPathologyDatas(groupId, start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologyData> getPathologyDatas(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.PathologyData> ob) {
		return getService().getPathologyDatas(groupId, start, end, ob);
	}

	/**
	* Returns all the pathology datas matching the UUID and company.
	*
	* @param uuid the UUID of the pathology datas
	* @param companyId the primary key of the company
	* @return the matching pathology datas, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologyData> getPathologyDatasByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getPathologyDatasByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of pathology datas matching the UUID and company.
	*
	* @param uuid the UUID of the pathology datas
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of pathology datas
	* @param end the upper bound of the range of pathology datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching pathology datas, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologyData> getPathologyDatasByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.PathologyData> orderByComparator) {
		return getService()
				   .getPathologyDatasByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
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

	public static PathologyDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PathologyDataLocalService, PathologyDataLocalService> _serviceTracker =
		ServiceTrackerFactory.open(PathologyDataLocalService.class);
}