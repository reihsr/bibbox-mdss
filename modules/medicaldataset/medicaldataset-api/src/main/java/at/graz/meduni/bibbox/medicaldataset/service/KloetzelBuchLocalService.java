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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException;
import at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch;

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
 * Provides the local service interface for KloetzelBuch. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see KloetzelBuchLocalServiceUtil
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.KloetzelBuchLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.KloetzelBuchLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface KloetzelBuchLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KloetzelBuchLocalServiceUtil} to access the kloetzel buch local service. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.KloetzelBuchLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the kloetzel buch to the database. Also notifies the appropriate model listeners.
	*
	* @param kloetzelBuch the kloetzel buch
	* @return the kloetzel buch that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public KloetzelBuch addKloetzelBuch(KloetzelBuch kloetzelBuch);

	public KloetzelBuch addKloetzelBuch(long medicalRecordId,
		ServiceContext serviceContext) throws PortalException;

	public KloetzelBuch addKloetzelBuch(long medicalRecordId,
		long histonumberStart, long histonumberEnd, int histonumberRunning,
		long histonumber, int kloetzelBuchRunning, java.lang.String oid,
		java.lang.String bid, java.lang.String area, java.lang.String type,
		java.lang.String acronym, java.lang.String text, java.lang.String info,
		int count, int numberOfPieces, int kbStatus, int sort,
		java.lang.String color, Date kbDate, java.lang.String day,
		java.lang.String pocessinguser, java.lang.String organizationUnit,
		ServiceContext serviceContext) throws PortalException;

	/**
	* Creates a new kloetzel buch with the primary key. Does not add the kloetzel buch to the database.
	*
	* @param kloetzelBuchId the primary key for the new kloetzel buch
	* @return the new kloetzel buch
	*/
	public KloetzelBuch createKloetzelBuch(long kloetzelBuchId);

	/**
	* Deletes the kloetzel buch from the database. Also notifies the appropriate model listeners.
	*
	* @param kloetzelBuch the kloetzel buch
	* @return the kloetzel buch that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public KloetzelBuch deleteKloetzelBuch(KloetzelBuch kloetzelBuch);

	/**
	* Deletes the kloetzel buch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kloetzelBuchId the primary key of the kloetzel buch
	* @return the kloetzel buch that was removed
	* @throws PortalException if a kloetzel buch with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public KloetzelBuch deleteKloetzelBuch(long kloetzelBuchId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public KloetzelBuch fetchKloetzelBuch(long kloetzelBuchId);

	/**
	* Returns the kloetzel buch matching the UUID and group.
	*
	* @param uuid the kloetzel buch's UUID
	* @param groupId the primary key of the group
	* @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public KloetzelBuch fetchKloetzelBuchByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	/**
	* Returns the kloetzel buch with the primary key.
	*
	* @param kloetzelBuchId the primary key of the kloetzel buch
	* @return the kloetzel buch
	* @throws PortalException if a kloetzel buch with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public KloetzelBuch getKloetzelBuch(long kloetzelBuchId)
		throws PortalException;

	/**
	* Returns the kloetzel buch matching the UUID and group.
	*
	* @param uuid the kloetzel buch's UUID
	* @param groupId the primary key of the group
	* @return the matching kloetzel buch
	* @throws PortalException if a matching kloetzel buch could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public KloetzelBuch getKloetzelBuchByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public KloetzelBuch getKloetzelBuchForMedicalRecord(long medicalRecordId)
		throws NoSuchKloetzelBuchException;

	/**
	* Updates the kloetzel buch in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kloetzelBuch the kloetzel buch
	* @return the kloetzel buch that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public KloetzelBuch updateKloetzelBuch(KloetzelBuch kloetzelBuch);

	public KloetzelBuch updateloetzelBuch(KloetzelBuch kloetzelBuch,
		ServiceContext serviceContext) throws PortalException;

	public KloetzelBuch updateloetzelBuch(long kloetzelBuchId,
		long medicalRecordId, long histonumberStart, long histonumberEnd,
		int histonumberRunning, long histonumber, int kloetzelBuchRunning,
		java.lang.String oid, java.lang.String bid, java.lang.String area,
		java.lang.String type, java.lang.String acronym, java.lang.String text,
		java.lang.String info, int count, int numberOfPieces, int kbStatus,
		int sort, java.lang.String color, Date kbDate, java.lang.String day,
		java.lang.String pocessinguser, java.lang.String organizationUnit,
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
	public int getKloetzelBuchCount(long groupId);

	/**
	* Returns the number of kloetzel buchs.
	*
	* @return the number of kloetzel buchs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getKloetzelBuchsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the kloetzel buchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @return the range of kloetzel buchs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<KloetzelBuch> getKloetzelBuchs(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<KloetzelBuch> getKloetzelBuchs(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<KloetzelBuch> getKloetzelBuchs(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<KloetzelBuch> getKloetzelBuchs(long groupId, int start,
		int end, OrderByComparator<KloetzelBuch> ob);

	/**
	* Returns all the kloetzel buchs matching the UUID and company.
	*
	* @param uuid the UUID of the kloetzel buchs
	* @param companyId the primary key of the company
	* @return the matching kloetzel buchs, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<KloetzelBuch> getKloetzelBuchsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of kloetzel buchs matching the UUID and company.
	*
	* @param uuid the UUID of the kloetzel buchs
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of kloetzel buchs
	* @param end the upper bound of the range of kloetzel buchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching kloetzel buchs, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<KloetzelBuch> getKloetzelBuchsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<KloetzelBuch> orderByComparator);

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