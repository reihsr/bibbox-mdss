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

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap;

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
 * Provides the local service interface for ImportMedicalDataSetFieldMap. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetFieldMapLocalServiceUtil
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.ImportMedicalDataSetFieldMapLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.ImportMedicalDataSetFieldMapLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ImportMedicalDataSetFieldMapLocalService
	extends BaseLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImportMedicalDataSetFieldMapLocalServiceUtil} to access the import medical data set field map local service. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.ImportMedicalDataSetFieldMapLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the import medical data set field map to the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMap the import medical data set field map
	* @return the import medical data set field map that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ImportMedicalDataSetFieldMap addImportMedicalDataSetFieldMap(
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap);

	public ImportMedicalDataSetFieldMap addImportMedicalDataSetFieldMap(
		long importMedicalDataSetId, java.lang.String importField,
		java.lang.String importFieldPath, java.lang.String sampleValue,
		java.lang.String TableName, java.lang.String TableField,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Creates a new import medical data set field map with the primary key. Does not add the import medical data set field map to the database.
	*
	* @param importMedicalDataSetFieldMapId the primary key for the new import medical data set field map
	* @return the new import medical data set field map
	*/
	public ImportMedicalDataSetFieldMap createImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId);

	/**
	* Deletes the import medical data set field map from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMap the import medical data set field map
	* @return the import medical data set field map that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public ImportMedicalDataSetFieldMap deleteImportMedicalDataSetFieldMap(
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap);

	/**
	* Deletes the import medical data set field map with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMapId the primary key of the import medical data set field map
	* @return the import medical data set field map that was removed
	* @throws PortalException if a import medical data set field map with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public ImportMedicalDataSetFieldMap deleteImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportMedicalDataSetFieldMap fetchImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId);

	/**
	* Returns the import medical data set field map matching the UUID and group.
	*
	* @param uuid the import medical data set field map's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set field map, or <code>null</code> if a matching import medical data set field map could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportMedicalDataSetFieldMap fetchImportMedicalDataSetFieldMapByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	/**
	* Returns the import medical data set field map with the primary key.
	*
	* @param importMedicalDataSetFieldMapId the primary key of the import medical data set field map
	* @return the import medical data set field map
	* @throws PortalException if a import medical data set field map with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportMedicalDataSetFieldMap getImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId) throws PortalException;

	/**
	* Returns the import medical data set field map matching the UUID and group.
	*
	* @param uuid the import medical data set field map's UUID
	* @param groupId the primary key of the group
	* @return the matching import medical data set field map
	* @throws PortalException if a matching import medical data set field map could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ImportMedicalDataSetFieldMap getImportMedicalDataSetFieldMapByUuidAndGroupId(
		java.lang.String uuid, long groupId) throws PortalException;

	/**
	* Updates the import medical data set field map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param importMedicalDataSetFieldMap the import medical data set field map
	* @return the import medical data set field map that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap);

	public ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap,
		ServiceContext serviceContext) throws PortalException;

	public ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(
		long importMedicalDataSetFieldMapId, long importMedicalDataSetId,
		java.lang.String importField, java.lang.String importFieldPath,
		java.lang.String sampleValue, java.lang.String TableName,
		java.lang.String TableField, ServiceContext serviceContext)
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
	public int getImportMedicalDataSetFieldMapCount(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getImportMedicalDataSetFieldMapCountFromImportMedicalDataSet(
		long importMedicalDataSetId);

	/**
	* Returns the number of import medical data set field maps.
	*
	* @return the number of import medical data set field maps
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getImportMedicalDataSetFieldMapsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(
		long groupId, int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> ob);

	/**
	* Returns all the import medical data set field maps matching the UUID and company.
	*
	* @param uuid the UUID of the import medical data set field maps
	* @param companyId the primary key of the company
	* @return the matching import medical data set field maps, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(
		long importMedicalDataSetId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(
		long importMedicalDataSetId, int start, int end,
		OrderByComparator<ImportMedicalDataSetFieldMap> ob);

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