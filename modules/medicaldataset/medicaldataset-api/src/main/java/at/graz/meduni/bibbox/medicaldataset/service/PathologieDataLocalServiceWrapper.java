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
 * Provides a wrapper for {@link PathologieDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PathologieDataLocalService
 * @generated
 */
@ProviderType
public class PathologieDataLocalServiceWrapper
	implements PathologieDataLocalService,
		ServiceWrapper<PathologieDataLocalService> {
	public PathologieDataLocalServiceWrapper(
		PathologieDataLocalService pathologieDataLocalService) {
		_pathologieDataLocalService = pathologieDataLocalService;
	}

	/**
	* Adds the pathologie data to the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieData the pathologie data
	* @return the pathologie data that was added
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData addPathologieData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologieData pathologieData) {
		return _pathologieDataLocalService.addPathologieData(pathologieData);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData addPathologieData(
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
		java.lang.String zytologiecomment, java.lang.String grad,
		java.lang.String tnmp, java.lang.String tnmt, java.lang.String tnmn,
		java.lang.String tnmm, java.lang.String tnmr, java.lang.String tnml,
		java.lang.String tnmv, java.lang.String tnmpn,
		java.lang.String dgcode1, java.lang.String dgcode2,
		java.lang.String pap, java.lang.String smearQuality,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pathologieDataLocalService.addPathologieData(medicalRecordId,
			receivedDate, validationDate, patientAge, sender,
			extractionMethode, reportingPhysician1, reportingPhysician2,
			gynPhysician, validationPhysician1, validationPhysician2,
			reportStatus, numberOfBlockes, numberOfSlides, basicDisease,
			causeOfDeath, material, materialExtended, macroscopicDescription,
			microscopicDescription, histologicDescription,
			molecularPathologicDescription, zytologieDescription,
			pathologicDiagnosis, frozenSectionDiagnosis,
			molecularPathologicDiagnosis, zytologieDiagnosis,
			neuroPathologicDiagnosis, comment, zytologiecomment, grad, tnmp,
			tnmt, tnmn, tnmm, tnmr, tnml, tnmv, tnmpn, dgcode1, dgcode2, pap,
			smearQuality, serviceContext);
	}

	/**
	* Creates a new pathologie data with the primary key. Does not add the pathologie data to the database.
	*
	* @param pathologieDataId the primary key for the new pathologie data
	* @return the new pathologie data
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData createPathologieData(
		long pathologieDataId) {
		return _pathologieDataLocalService.createPathologieData(pathologieDataId);
	}

	/**
	* Deletes the pathologie data from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieData the pathologie data
	* @return the pathologie data that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData deletePathologieData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologieData pathologieData) {
		return _pathologieDataLocalService.deletePathologieData(pathologieData);
	}

	/**
	* Deletes the pathologie data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data that was removed
	* @throws PortalException if a pathologie data with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData deletePathologieData(
		long pathologieDataId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pathologieDataLocalService.deletePathologieData(pathologieDataId);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData fetchPathologieData(
		long pathologieDataId) {
		return _pathologieDataLocalService.fetchPathologieData(pathologieDataId);
	}

	/**
	* Returns the pathologie data matching the UUID and group.
	*
	* @param uuid the pathologie data's UUID
	* @param groupId the primary key of the group
	* @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData fetchPathologieDataByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _pathologieDataLocalService.fetchPathologieDataByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the pathologie data with the primary key.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data
	* @throws PortalException if a pathologie data with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData getPathologieData(
		long pathologieDataId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pathologieDataLocalService.getPathologieData(pathologieDataId);
	}

	/**
	* Returns the pathologie data matching the UUID and group.
	*
	* @param uuid the pathologie data's UUID
	* @param groupId the primary key of the group
	* @return the matching pathologie data
	* @throws PortalException if a matching pathologie data could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData getPathologieDataByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pathologieDataLocalService.getPathologieDataByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData getPathologieDataForMedicalRecord(
		long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException {
		return _pathologieDataLocalService.getPathologieDataForMedicalRecord(medicalRecordId);
	}

	/**
	* Updates the pathologie data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pathologieData the pathologie data
	* @return the pathologie data that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData updatePathologieData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologieData pathologieData) {
		return _pathologieDataLocalService.updatePathologieData(pathologieData);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData updatePathologieData(
		at.graz.meduni.bibbox.medicaldataset.model.PathologieData pathologieData,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pathologieDataLocalService.updatePathologieData(pathologieData,
			serviceContext);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.PathologieData updatePathologieData(
		long pathologieDataId, long medicalRecordId,
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
		java.lang.String zytologiecomment, java.lang.String grad,
		java.lang.String tnmp, java.lang.String tnmt, java.lang.String tnmn,
		java.lang.String tnmm, java.lang.String tnmr, java.lang.String tnml,
		java.lang.String tnmv, java.lang.String tnmpn,
		java.lang.String dgcode1, java.lang.String dgcode2,
		java.lang.String pap, java.lang.String smearQuality,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pathologieDataLocalService.updatePathologieData(pathologieDataId,
			medicalRecordId, receivedDate, validationDate, patientAge, sender,
			extractionMethode, reportingPhysician1, reportingPhysician2,
			gynPhysician, validationPhysician1, validationPhysician2,
			reportStatus, numberOfBlockes, numberOfSlides, basicDisease,
			causeOfDeath, material, materialExtended, macroscopicDescription,
			microscopicDescription, histologicDescription,
			molecularPathologicDescription, zytologieDescription,
			pathologicDiagnosis, frozenSectionDiagnosis,
			molecularPathologicDiagnosis, zytologieDiagnosis,
			neuroPathologicDiagnosis, comment, zytologiecomment, grad, tnmp,
			tnmt, tnmn, tnmm, tnmr, tnml, tnmv, tnmpn, dgcode1, dgcode2, pap,
			smearQuality, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _pathologieDataLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pathologieDataLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _pathologieDataLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _pathologieDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pathologieDataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pathologieDataLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getPathologieDataCount(long groupId) {
		return _pathologieDataLocalService.getPathologieDataCount(groupId);
	}

	/**
	* Returns the number of pathologie datas.
	*
	* @return the number of pathologie datas
	*/
	@Override
	public int getPathologieDatasCount() {
		return _pathologieDataLocalService.getPathologieDatasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _pathologieDataLocalService.getOSGiServiceIdentifier();
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
		return _pathologieDataLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _pathologieDataLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _pathologieDataLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> getPathologieDatas(
		int start, int end) {
		return _pathologieDataLocalService.getPathologieDatas(start, end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> getPathologieDatas(
		long groupId) {
		return _pathologieDataLocalService.getPathologieDatas(groupId);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> getPathologieDatas(
		long groupId, int start, int end) {
		return _pathologieDataLocalService.getPathologieDatas(groupId, start,
			end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> getPathologieDatas(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> ob) {
		return _pathologieDataLocalService.getPathologieDatas(groupId, start,
			end, ob);
	}

	/**
	* Returns all the pathologie datas matching the UUID and company.
	*
	* @param uuid the UUID of the pathologie datas
	* @param companyId the primary key of the company
	* @return the matching pathologie datas, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> getPathologieDatasByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _pathologieDataLocalService.getPathologieDatasByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> getPathologieDatasByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.PathologieData> orderByComparator) {
		return _pathologieDataLocalService.getPathologieDatasByUuidAndCompanyId(uuid,
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
		return _pathologieDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _pathologieDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public PathologieDataLocalService getWrappedService() {
		return _pathologieDataLocalService;
	}

	@Override
	public void setWrappedService(
		PathologieDataLocalService pathologieDataLocalService) {
		_pathologieDataLocalService = pathologieDataLocalService;
	}

	private PathologieDataLocalService _pathologieDataLocalService;
}