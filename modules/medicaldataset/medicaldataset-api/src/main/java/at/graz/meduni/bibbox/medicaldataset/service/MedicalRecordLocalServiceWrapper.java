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
 * Provides a wrapper for {@link MedicalRecordLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MedicalRecordLocalService
 * @generated
 */
@ProviderType
public class MedicalRecordLocalServiceWrapper
	implements MedicalRecordLocalService,
		ServiceWrapper<MedicalRecordLocalService> {
	public MedicalRecordLocalServiceWrapper(
		MedicalRecordLocalService medicalRecordLocalService) {
		_medicalRecordLocalService = medicalRecordLocalService;
	}

	/**
	* Adds the medical record to the database. Also notifies the appropriate model listeners.
	*
	* @param medicalRecord the medical record
	* @return the medical record that was added
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord addMedicalRecord(
		at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord medicalRecord) {
		return _medicalRecordLocalService.addMedicalRecord(medicalRecord);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord addMedicalRecord(
		long histonumberStart, long histonumberEnd, int histonumberRunning,
		long iNumber, long vPatentId, long vHistonNumber,
		java.lang.String area, long imiJobId, java.lang.String importFile,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _medicalRecordLocalService.addMedicalRecord(histonumberStart,
			histonumberEnd, histonumberRunning, iNumber, vPatentId,
			vHistonNumber, area, imiJobId, importFile, serviceContext);
	}

	/**
	* Creates a new medical record with the primary key. Does not add the medical record to the database.
	*
	* @param medicalRecordId the primary key for the new medical record
	* @return the new medical record
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord createMedicalRecord(
		long medicalRecordId) {
		return _medicalRecordLocalService.createMedicalRecord(medicalRecordId);
	}

	/**
	* Deletes the medical record from the database. Also notifies the appropriate model listeners.
	*
	* @param medicalRecord the medical record
	* @return the medical record that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord deleteMedicalRecord(
		at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord medicalRecord) {
		return _medicalRecordLocalService.deleteMedicalRecord(medicalRecord);
	}

	/**
	* Deletes the medical record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param medicalRecordId the primary key of the medical record
	* @return the medical record that was removed
	* @throws PortalException if a medical record with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord deleteMedicalRecord(
		long medicalRecordId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _medicalRecordLocalService.deleteMedicalRecord(medicalRecordId);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord fetchMedicalRecord(
		long medicalRecordId) {
		return _medicalRecordLocalService.fetchMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the medical record matching the UUID and group.
	*
	* @param uuid the medical record's UUID
	* @param groupId the primary key of the group
	* @return the matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord fetchMedicalRecordByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _medicalRecordLocalService.fetchMedicalRecordByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the medical record with the primary key.
	*
	* @param medicalRecordId the primary key of the medical record
	* @return the medical record
	* @throws PortalException if a medical record with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord getMedicalRecord(
		long medicalRecordId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _medicalRecordLocalService.getMedicalRecord(medicalRecordId);
	}

	/**
	* Returns the medical record matching the UUID and group.
	*
	* @param uuid the medical record's UUID
	* @param groupId the primary key of the group
	* @return the matching medical record
	* @throws PortalException if a matching medical record could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord getMedicalRecordByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _medicalRecordLocalService.getMedicalRecordByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the medical record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param medicalRecord the medical record
	* @return the medical record that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord updateMedicalRecord(
		at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord medicalRecord) {
		return _medicalRecordLocalService.updateMedicalRecord(medicalRecord);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord updateMedicalRecord(
		at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord medicalrecord,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _medicalRecordLocalService.updateMedicalRecord(medicalrecord,
			serviceContext);
	}

	@Override
	public at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord updateMedicalRecord(
		long medicalRecordId, long histonumberStart, long histonumberEnd,
		int histonumberRunning, long iNumber, long vPatentId,
		long vHistonNumber, java.lang.String area, long imiJobId,
		java.lang.String importFile,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _medicalRecordLocalService.updateMedicalRecord(medicalRecordId,
			histonumberStart, histonumberEnd, histonumberRunning, iNumber,
			vPatentId, vHistonNumber, area, imiJobId, importFile, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _medicalRecordLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _medicalRecordLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _medicalRecordLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _medicalRecordLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _medicalRecordLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _medicalRecordLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of medical records.
	*
	* @return the number of medical records
	*/
	@Override
	public int getMedicalRecordsCount() {
		return _medicalRecordLocalService.getMedicalRecordsCount();
	}

	@Override
	public int getMedicalRecordsCount(long groupId) {
		return _medicalRecordLocalService.getMedicalRecordsCount(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _medicalRecordLocalService.getOSGiServiceIdentifier();
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
		return _medicalRecordLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _medicalRecordLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _medicalRecordLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the medical records.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @return the range of medical records
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord> getMedicalRecords(
		int start, int end) {
		return _medicalRecordLocalService.getMedicalRecords(start, end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord> getMedicalRecords(
		long groupId) {
		return _medicalRecordLocalService.getMedicalRecords(groupId);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord> getMedicalRecords(
		long groupId, int start, int end) {
		return _medicalRecordLocalService.getMedicalRecords(groupId, start, end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord> getMedicalRecords(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord> ob) {
		return _medicalRecordLocalService.getMedicalRecords(groupId, start,
			end, ob);
	}

	/**
	* Returns all the medical records matching the UUID and company.
	*
	* @param uuid the UUID of the medical records
	* @param companyId the primary key of the company
	* @return the matching medical records, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord> getMedicalRecordsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _medicalRecordLocalService.getMedicalRecordsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of medical records matching the UUID and company.
	*
	* @param uuid the UUID of the medical records
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of medical records
	* @param end the upper bound of the range of medical records (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching medical records, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord> getMedicalRecordsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord> orderByComparator) {
		return _medicalRecordLocalService.getMedicalRecordsByUuidAndCompanyId(uuid,
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
		return _medicalRecordLocalService.dynamicQueryCount(dynamicQuery);
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
		return _medicalRecordLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public MedicalRecordLocalService getWrappedService() {
		return _medicalRecordLocalService;
	}

	@Override
	public void setWrappedService(
		MedicalRecordLocalService medicalRecordLocalService) {
		_medicalRecordLocalService = medicalRecordLocalService;
	}

	private MedicalRecordLocalService _medicalRecordLocalService;
}