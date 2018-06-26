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

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet;

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
 * Provides the local service interface for ImportMedicalDataSet. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLocalServiceUtil
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.ImportMedicalDataSetLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.ImportMedicalDataSetLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ImportMedicalDataSetLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImportMedicalDataSetLocalServiceUtil} to access the import medical data set local service. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.ImportMedicalDataSetLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the import medical data set to the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSet the import medical data set
	* @return the import medical data set that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ImportMedicalDataSet addImportMedicalDataSet(
		ImportMedicalDataSet importMedicalDataSet);

	public ImportMedicalDataSet addImportMedicalDataSet(
		java.lang.String importName, java.lang.String importType,
		long imiJobId, java.lang.String description, java.lang.String fileName,
		java.lang.String filePath, long fileId, int importCount,
		int importStatus, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Creates a new import medical data set with the primary key. Does not add the import medical data set to the database.
	*
	* @param importMedicalDataSetId the primary key for the new import medical data set
	* @return the new import medical data set
	*/
	public ImportMedicalDataSet createImportMedicalDataSet(
		long importMedicalDataSetId);

	/**
	* Deletes the import medical data set from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSet the import medical data set
	* @return the import medical data set that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public ImportMedicalDataSet deleteImportMedicalDataSet(
		ImportMedicalDataSet importMedicalDataSet);

	/**
	* Deletes the import medical data set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetId the primary key of the import medical data set
	* @return the import medical data set that was removed
	* @throws PortalException if a import medical data set with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public ImportMedicalDataSet deleteImportMedicalDataSet(
		long importMedicalDataSetId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportMedicalDataSet fetchImportMedicalDataSet(
		long importMedicalDataSetId);

	/**
	* Returns the import medical data set matching the UUID and group.
	*
	* @param uuid the import medical data set's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set, or <code>null</code> if a matching import medical data set could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportMedicalDataSet fetchImportMedicalDataSetByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	/**
	* Returns the import medical data set with the primary key.
	*
	* @param importMedicalDataSetId the primary key of the import medical data set
	* @return the import medical data set
	* @throws PortalException if a import medical data set with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportMedicalDataSet getImportMedicalDataSet(
		long importMedicalDataSetId) throws PortalException;

	/**
	* Returns the import medical data set matching the UUID and group.
	*
	* @param uuid the import medical data set's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set
	* @throws PortalException if a matching import medical data set could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportMedicalDataSet getImportMedicalDataSetByUuidAndGroupId(
		java.lang.String uuid, long groupId) throws PortalException;

	/**
	* Updates the import medical data set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSet the import medical data set
	* @return the import medical data set that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ImportMedicalDataSet updateImportMedicalDataSet(
		ImportMedicalDataSet importMedicalDataSet);

	public ImportMedicalDataSet updateImportMedicalDataSet(
		ImportMedicalDataSet importMedicalDataSet, ServiceContext serviceContext)
		throws PortalException;

	public ImportMedicalDataSet updateImportMedicalDataSet(
		long importMedicalDataSetId, java.lang.String importName,
		java.lang.String importType, long imiJobId,
		java.lang.String description, java.lang.String fileName,
		java.lang.String filePath, long fileId, int importCount,
		int importStatus, ServiceContext serviceContext)
		throws PortalException;

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
	public int getImportMedicalDataSetCount(long groupId);

	/**
	* Returns the number of import medical data sets.
	*
	* @return the number of import medical data sets
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getImportMedicalDataSetsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSet> getImportMedicalDataSets(int start,
		int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSet> getImportMedicalDataSets(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSet> getImportMedicalDataSets(long groupId,
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSet> getImportMedicalDataSets(long groupId,
		int start, int end, OrderByComparator<ImportMedicalDataSet> ob);

	/**
	* Returns all the import medical data sets matching the UUID and company.
	*
	* @param uuid the UUID of the import medical data sets
	* @param companyId the primary key of the company
	* @return the matching import medical data sets, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSet> getImportMedicalDataSetsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSet> getImportMedicalDataSetsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<ImportMedicalDataSet> orderByComparator);

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