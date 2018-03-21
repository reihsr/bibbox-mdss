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

import at.graz.meduni.bibbox.medicaldataset.model.PathologieData;

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
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for PathologieData. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PathologieDataLocalServiceUtil
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.PathologieDataLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.PathologieDataLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PathologieDataLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PathologieDataLocalServiceUtil} to access the pathologie data local service. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.PathologieDataLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the pathologie data to the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieData the pathologie data
	* @return the pathologie data that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public PathologieData addPathologieData(PathologieData pathologieData);

	/**
	* Creates a new pathologie data with the primary key. Does not add the pathologie data to the database.
	*
	* @param pathologieDataId the primary key for the new pathologie data
	* @return the new pathologie data
	*/
	public PathologieData createPathologieData(long pathologieDataId);

	/**
	* Deletes the pathologie data from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieData the pathologie data
	* @return the pathologie data that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public PathologieData deletePathologieData(PathologieData pathologieData);

	/**
	* Deletes the pathologie data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data that was removed
	* @throws PortalException if a pathologie data with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public PathologieData deletePathologieData(long pathologieDataId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PathologieData fetchPathologieData(long pathologieDataId);

	/**
	* Returns the pathologie data matching the UUID and group.
	*
	* @param uuid the pathologie data's UUID
	* @param groupId the primary key of the group
	* @return the matching pathologie data, or <code>null</code> if a matching pathologie data could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PathologieData fetchPathologieDataByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	/**
	* Returns the pathologie data with the primary key.
	*
	* @param pathologieDataId the primary key of the pathologie data
	* @return the pathologie data
	* @throws PortalException if a pathologie data with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PathologieData getPathologieData(long pathologieDataId)
		throws PortalException;

	/**
	* Returns the pathologie data matching the UUID and group.
	*
	* @param uuid the pathologie data's UUID
	* @param groupId the primary key of the group
	* @return the matching pathologie data
	* @throws PortalException if a matching pathologie data could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PathologieData getPathologieDataByUuidAndGroupId(
		java.lang.String uuid, long groupId) throws PortalException;

	/**
	* Updates the pathologie data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pathologieData the pathologie data
	* @return the pathologie data that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public PathologieData updatePathologieData(PathologieData pathologieData);

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
	* Returns the number of pathologie datas.
	*
	* @return the number of pathologie datas
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPathologieDatasCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PathologieData> getPathologieDatas(int start, int end);

	/**
	* Returns all the pathologie datas matching the UUID and company.
	*
	* @param uuid the UUID of the pathologie datas
	* @param companyId the primary key of the company
	* @return the matching pathologie datas, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PathologieData> getPathologieDatasByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PathologieData> getPathologieDatasByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<PathologieData> orderByComparator);

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