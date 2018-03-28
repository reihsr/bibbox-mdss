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

import at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for MedicalRecord. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MedicalRecordLocalServiceUtil
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.MedicalRecordLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.MedicalRecordLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MedicalRecordLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MedicalRecordLocalServiceUtil} to access the medical record local service. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.MedicalRecordLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the medical record to the database. Also notifies the appropriate model listeners.
	*
	* @param medicalRecord the medical record
	* @return the medical record that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord);

	public MedicalRecord addMedicalRecord(long importMedicalDataSetId,
		long histonumberStart, long histonumberEnd, int histonumberRunning,
		long iNumber, long vPatentId, long vHistonNumber,
		java.lang.String area, long imiJobId, java.lang.String importFile,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Creates a new medical record with the primary key. Does not add the medical record to the database.
	*
	* @param medicalRecordId the primary key for the new medical record
	* @return the new medical record
	*/
	public MedicalRecord createMedicalRecord(long medicalRecordId);

	/**
	* Deletes the medical record from the database. Also notifies the appropriate model listeners.
	*
	* @param medicalRecord the medical record
	* @return the medical record that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public MedicalRecord deleteMedicalRecord(MedicalRecord medicalRecord);

	/**
	* Deletes the medical record with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param medicalRecordId the primary key of the medical record
	* @return the medical record that was removed
	* @throws PortalException if a medical record with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public MedicalRecord deleteMedicalRecord(long medicalRecordId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MedicalRecord fetchMedicalRecord(long medicalRecordId);

	/**
	* Returns the medical record matching the UUID and group.
	*
	* @param uuid the medical record's UUID
	* @param groupId the primary key of the group
	* @return the matching medical record, or <code>null</code> if a matching medical record could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MedicalRecord fetchMedicalRecordByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	/**
	* Returns the medical record with the primary key.
	*
	* @param medicalRecordId the primary key of the medical record
	* @return the medical record
	* @throws PortalException if a medical record with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MedicalRecord getMedicalRecord(long medicalRecordId)
		throws PortalException;

	/**
	* Returns the medical record matching the UUID and group.
	*
	* @param uuid the medical record's UUID
	* @param groupId the primary key of the group
	* @return the matching medical record
	* @throws PortalException if a matching medical record could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MedicalRecord getMedicalRecordByUuidAndGroupId(
		java.lang.String uuid, long groupId) throws PortalException;

	/**
	* Updates the medical record in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param medicalRecord the medical record
	* @return the medical record that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord);

	public MedicalRecord updateMedicalRecord(MedicalRecord medicalrecord,
		ServiceContext serviceContext) throws PortalException;

	public MedicalRecord updateMedicalRecord(long medicalRecordId,
		long importMedicalDataSetId, long histonumberStart,
		long histonumberEnd, int histonumberRunning, long iNumber,
		long vPatentId, long vHistonNumber, java.lang.String area,
		long imiJobId, java.lang.String importFile,
		ServiceContext serviceContext) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of medical records.
	*
	* @return the number of medical records
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMedicalRecordsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMedicalRecordsCount(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMedicalRecordsCountFromImport(long importMedicalDataSetId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MedicalRecord> getMedicalRecords(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MedicalRecord> getMedicalRecords(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MedicalRecord> getMedicalRecords(long groupId, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MedicalRecord> getMedicalRecords(long groupId, int start,
		int end, OrderByComparator<MedicalRecord> ob);

	/**
	* Returns all the medical records matching the UUID and company.
	*
	* @param uuid the UUID of the medical records
	* @param companyId the primary key of the company
	* @return the matching medical records, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MedicalRecord> getMedicalRecordsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MedicalRecord> getMedicalRecordsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<MedicalRecord> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MedicalRecord> getMedicalRecordsFromImport(
		long importMedicalDataSetId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MedicalRecord> getMedicalRecordsFromImport(
		long importMedicalDataSetId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MedicalRecord> getMedicalRecordsFromImport(
		long importMedicalDataSetId, int start, int end,
		OrderByComparator<MedicalRecord> ob);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}