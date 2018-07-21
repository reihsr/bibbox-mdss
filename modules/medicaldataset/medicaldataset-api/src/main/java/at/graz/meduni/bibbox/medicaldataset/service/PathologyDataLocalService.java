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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException;
import at.graz.meduni.bibbox.medicaldataset.model.PathologyData;

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

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for PathologyData. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PathologyDataLocalServiceUtil
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.PathologyDataLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.PathologyDataLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PathologyDataLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PathologyDataLocalServiceUtil} to access the pathology data local service. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.PathologyDataLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the pathology data to the database. Also notifies the appropriate model listeners.
	*
	* @param pathologyData the pathology data
	* @return the pathology data that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public PathologyData addPathologyData(PathologyData pathologyData);

	public PathologyData addPathologyData(long medicalRecordId,
		Date receivedDate, Date validationDate, int patientAge,
		java.lang.String sender, java.lang.String extractionMethode,
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
		ServiceContext serviceContext) throws PortalException;

	/**
	* Creates a new pathology data with the primary key. Does not add the pathology data to the database.
	*
	* @param pathologyDataId the primary key for the new pathology data
	* @return the new pathology data
	*/
	public PathologyData createPathologyData(long pathologyDataId);

	/**
	* Deletes the pathology data from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologyData the pathology data
	* @return the pathology data that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public PathologyData deletePathologyData(PathologyData pathologyData);

	/**
	* Deletes the pathology data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologyDataId the primary key of the pathology data
	* @return the pathology data that was removed
	* @throws PortalException if a pathology data with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public PathologyData deletePathologyData(long pathologyDataId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PathologyData fetchPathologyData(long pathologyDataId);

	/**
	* Returns the pathology data matching the UUID and group.
	*
	* @param uuid the pathology data's UUID
	* @param groupId the primary key of the group
	* @return the matching pathology data, or <code>null</code> if a matching pathology data could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PathologyData fetchPathologyDataByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	/**
	* Returns the pathology data with the primary key.
	*
	* @param pathologyDataId the primary key of the pathology data
	* @return the pathology data
	* @throws PortalException if a pathology data with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PathologyData getPathologyData(long pathologyDataId)
		throws PortalException;

	/**
	* Returns the pathology data matching the UUID and group.
	*
	* @param uuid the pathology data's UUID
	* @param groupId the primary key of the group
	* @return the matching pathology data
	* @throws PortalException if a matching pathology data could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PathologyData getPathologyDataByUuidAndGroupId(
		java.lang.String uuid, long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PathologyData getPathologyDataForMedicalRecord(long medicalRecordId)
		throws NoSuchPathologyDataException;

	/**
	* Updates the pathology data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pathologyData the pathology data
	* @return the pathology data that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public PathologyData updatePathologyData(PathologyData pathologyData);

	public PathologyData updatePathologyData(PathologyData pathologyData,
		ServiceContext serviceContext) throws PortalException;

	public PathologyData updatePathologyData(long pathologyDataId,
		long medicalRecordId, Date receivedDate, Date validationDate,
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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPathologyDataCount(long groupId);

	/**
	* Returns the number of pathology datas.
	*
	* @return the number of pathology datas
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPathologyDatasCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologyDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PathologyData> getPathologyDatas(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PathologyData> getPathologyDatas(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PathologyData> getPathologyDatas(long groupId, int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PathologyData> getPathologyDatas(long groupId, int start,
		int end, OrderByComparator<PathologyData> ob);

	/**
	* Returns all the pathology datas matching the UUID and company.
	*
	* @param uuid the UUID of the pathology datas
	* @param companyId the primary key of the company
	* @return the matching pathology datas, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PathologyData> getPathologyDatasByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PathologyData> getPathologyDatasByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<PathologyData> orderByComparator);

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