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
 * Provides the local service utility for KloetzelBuch. This utility wraps
 * {@link at.graz.meduni.bibbox.medicaldataset.service.impl.KloetzelBuchLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see KloetzelBuchLocalService
 * @see at.graz.meduni.bibbox.medicaldataset.service.base.KloetzelBuchLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.KloetzelBuchLocalServiceImpl
 * @generated
 */
@ProviderType
public class KloetzelBuchLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.medicaldataset.service.impl.KloetzelBuchLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the kloetzel buch to the database. Also notifies the appropriate model listeners.
	*
	* @param kloetzelBuch the kloetzel buch
	* @return the kloetzel buch that was added
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch addKloetzelBuch(
		at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch kloetzelBuch) {
		return getService().addKloetzelBuch(kloetzelBuch);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch addKloetzelBuch(
		long medicalRecordId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addKloetzelBuch(medicalRecordId, serviceContext);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch addKloetzelBuch(
		long medicalRecordId, long histonumberStart, long histonumberEnd,
		int histonumberRunning, long histonumber, int kloetzelBuchRunning,
		java.lang.String oid, java.lang.String bid, java.lang.String area,
		java.lang.String type, java.lang.String acronym, java.lang.String text,
		java.lang.String info, int count, int numberOfPieces, int kbStatus,
		int sort, java.lang.String color, java.util.Date kbDate,
		java.lang.String day, java.lang.String pocessinguser,
		java.lang.String organizationUnit,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addKloetzelBuch(medicalRecordId, histonumberStart,
			histonumberEnd, histonumberRunning, histonumber,
			kloetzelBuchRunning, oid, bid, area, type, acronym, text, info,
			count, numberOfPieces, kbStatus, sort, color, kbDate, day,
			pocessinguser, organizationUnit, serviceContext);
	}

	/**
	* Creates a new kloetzel buch with the primary key. Does not add the kloetzel buch to the database.
	*
	* @param kloetzelBuchId the primary key for the new kloetzel buch
	* @return the new kloetzel buch
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch createKloetzelBuch(
		long kloetzelBuchId) {
		return getService().createKloetzelBuch(kloetzelBuchId);
	}

	/**
	* Deletes the kloetzel buch from the database. Also notifies the appropriate model listeners.
	*
	* @param kloetzelBuch the kloetzel buch
	* @return the kloetzel buch that was removed
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch deleteKloetzelBuch(
		at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch kloetzelBuch) {
		return getService().deleteKloetzelBuch(kloetzelBuch);
	}

	/**
	* Deletes the kloetzel buch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kloetzelBuchId the primary key of the kloetzel buch
	* @return the kloetzel buch that was removed
	* @throws PortalException if a kloetzel buch with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch deleteKloetzelBuch(
		long kloetzelBuchId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteKloetzelBuch(kloetzelBuchId);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch fetchKloetzelBuch(
		long kloetzelBuchId) {
		return getService().fetchKloetzelBuch(kloetzelBuchId);
	}

	/**
	* Returns the kloetzel buch matching the UUID and group.
	*
	* @param uuid the kloetzel buch's UUID
	* @param groupId the primary key of the group
	* @return the matching kloetzel buch, or <code>null</code> if a matching kloetzel buch could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch fetchKloetzelBuchByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchKloetzelBuchByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the kloetzel buch with the primary key.
	*
	* @param kloetzelBuchId the primary key of the kloetzel buch
	* @return the kloetzel buch
	* @throws PortalException if a kloetzel buch with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch getKloetzelBuch(
		long kloetzelBuchId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getKloetzelBuch(kloetzelBuchId);
	}

	/**
	* Returns the kloetzel buch matching the UUID and group.
	*
	* @param uuid the kloetzel buch's UUID
	* @param groupId the primary key of the group
	* @return the matching kloetzel buch
	* @throws PortalException if a matching kloetzel buch could not be found
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch getKloetzelBuchByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getKloetzelBuchByUuidAndGroupId(uuid, groupId);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch getKloetzelBuchForMedicalRecord(
		long medicalRecordId)
		throws at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException {
		return getService().getKloetzelBuchForMedicalRecord(medicalRecordId);
	}

	/**
	* Updates the kloetzel buch in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kloetzelBuch the kloetzel buch
	* @return the kloetzel buch that was updated
	*/
	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch updateKloetzelBuch(
		at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch kloetzelBuch) {
		return getService().updateKloetzelBuch(kloetzelBuch);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch updateloetzelBuch(
		at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch kloetzelBuch,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().updateloetzelBuch(kloetzelBuch, serviceContext);
	}

	public static at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch updateloetzelBuch(
		long kloetzelBuchId, long medicalRecordId, long histonumberStart,
		long histonumberEnd, int histonumberRunning, long histonumber,
		int kloetzelBuchRunning, java.lang.String oid, java.lang.String bid,
		java.lang.String area, java.lang.String type, java.lang.String acronym,
		java.lang.String text, java.lang.String info, int count,
		int numberOfPieces, int kbStatus, int sort, java.lang.String color,
		java.util.Date kbDate, java.lang.String day,
		java.lang.String pocessinguser, java.lang.String organizationUnit,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateloetzelBuch(kloetzelBuchId, medicalRecordId,
			histonumberStart, histonumberEnd, histonumberRunning, histonumber,
			kloetzelBuchRunning, oid, bid, area, type, acronym, text, info,
			count, numberOfPieces, kbStatus, sort, color, kbDate, day,
			pocessinguser, organizationUnit, serviceContext);
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

	public static int getKloetzelBuchCount(long groupId) {
		return getService().getKloetzelBuchCount(groupId);
	}

	/**
	* Returns the number of kloetzel buchs.
	*
	* @return the number of kloetzel buchs
	*/
	public static int getKloetzelBuchsCount() {
		return getService().getKloetzelBuchsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch> getKloetzelBuchs(
		int start, int end) {
		return getService().getKloetzelBuchs(start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch> getKloetzelBuchs(
		long groupId) {
		return getService().getKloetzelBuchs(groupId);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch> getKloetzelBuchs(
		long groupId, int start, int end) {
		return getService().getKloetzelBuchs(groupId, start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch> getKloetzelBuchs(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch> ob) {
		return getService().getKloetzelBuchs(groupId, start, end, ob);
	}

	/**
	* Returns all the kloetzel buchs matching the UUID and company.
	*
	* @param uuid the UUID of the kloetzel buchs
	* @param companyId the primary key of the company
	* @return the matching kloetzel buchs, or an empty list if no matches were found
	*/
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch> getKloetzelBuchsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getKloetzelBuchsByUuidAndCompanyId(uuid, companyId);
	}

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
	public static java.util.List<at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch> getKloetzelBuchsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch> orderByComparator) {
		return getService()
				   .getKloetzelBuchsByUuidAndCompanyId(uuid, companyId, start,
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

	public static KloetzelBuchLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<KloetzelBuchLocalService, KloetzelBuchLocalService> _serviceTracker =
		ServiceTrackerFactory.open(KloetzelBuchLocalService.class);
}