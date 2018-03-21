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

package at.graz.meduni.bibbox.informationprocessing.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DictionaryLocalService}.
 *
 * @author robert
 * @see DictionaryLocalService
 * @generated
 */
@ProviderType
public class DictionaryLocalServiceWrapper implements DictionaryLocalService,
	ServiceWrapper<DictionaryLocalService> {
	public DictionaryLocalServiceWrapper(
		DictionaryLocalService dictionaryLocalService) {
		_dictionaryLocalService = dictionaryLocalService;
	}

	/**
	* Adds the dictionary to the database. Also notifies the appropriate model listeners.
	*
	* @param dictionary the dictionary
	* @return the dictionary that was added
	*/
	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary addDictionary(
		at.graz.meduni.bibbox.informationprocessing.model.Dictionary dictionary) {
		return _dictionaryLocalService.addDictionary(dictionary);
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary addDictionary(
		at.graz.meduni.bibbox.informationprocessing.model.Dictionary dictionary,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.addDictionary(dictionary, serviceContext);
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary addDictionary(
		java.lang.String synonym, java.lang.String pattern, boolean code,
		java.lang.String code_type, java.lang.String code_value, boolean root,
		boolean negation, int priority, boolean priority_mode,
		int before_synonym, int after_synonym, boolean foreword,
		boolean ending, boolean sentence, boolean occure, long userId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.addDictionary(synonym, pattern, code,
			code_type, code_value, root, negation, priority, priority_mode,
			before_synonym, after_synonym, foreword, ending, sentence, occure,
			userId, serviceContext);
	}

	/**
	* Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	*
	* @param dictionaryId the primary key for the new dictionary
	* @return the new dictionary
	*/
	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary createDictionary(
		long dictionaryId) {
		return _dictionaryLocalService.createDictionary(dictionaryId);
	}

	/**
	* Deletes the dictionary from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionary the dictionary
	* @return the dictionary that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary deleteDictionary(
		at.graz.meduni.bibbox.informationprocessing.model.Dictionary dictionary) {
		return _dictionaryLocalService.deleteDictionary(dictionary);
	}

	/**
	* Deletes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary that was removed
	* @throws PortalException if a dictionary with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary deleteDictionary(
		long dictionaryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.deleteDictionary(dictionaryId);
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary deleteEntry(
		long dictionaryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.deleteEntry(dictionaryId);
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary deleteEntry(
		long dictionaryId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.deleteEntry(dictionaryId, serviceContext);
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary fetchDictionary(
		long dictionaryId) {
		return _dictionaryLocalService.fetchDictionary(dictionaryId);
	}

	/**
	* Returns the dictionary matching the UUID and group.
	*
	* @param uuid the dictionary's UUID
	* @param groupId the primary key of the group
	* @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary fetchDictionaryByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _dictionaryLocalService.fetchDictionaryByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the dictionary with the primary key.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary
	* @throws PortalException if a dictionary with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary getDictionary(
		long dictionaryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.getDictionary(dictionaryId);
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary getDictionary(
		long dictionaryId, long groupId)
		throws at.graz.meduni.bibbox.informationprocessing.exception.NoSuchDictionaryException {
		return _dictionaryLocalService.getDictionary(dictionaryId, groupId);
	}

	/**
	* Returns the dictionary matching the UUID and group.
	*
	* @param uuid the dictionary's UUID
	* @param groupId the primary key of the group
	* @return the matching dictionary
	* @throws PortalException if a matching dictionary could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary getDictionaryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.getDictionaryByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the dictionary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictionary the dictionary
	* @return the dictionary that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary updateDictionary(
		at.graz.meduni.bibbox.informationprocessing.model.Dictionary dictionary) {
		return _dictionaryLocalService.updateDictionary(dictionary);
	}

	@Override
	public at.graz.meduni.bibbox.informationprocessing.model.Dictionary updateDictionary(
		long dictionaryId, java.lang.String synonym, java.lang.String pattern,
		boolean code, java.lang.String code_type, java.lang.String code_value,
		boolean root, boolean negation, int priority, boolean priority_mode,
		int before_synonym, int after_synonym, boolean foreword,
		boolean ending, boolean sentence, boolean occure, long userId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.updateDictionary(dictionaryId, synonym,
			pattern, code, code_type, code_value, root, negation, priority,
			priority_mode, before_synonym, after_synonym, foreword, ending,
			sentence, occure, userId, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dictionaryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dictionaryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _dictionaryLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dictionaryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of dictionaries.
	*
	* @return the number of dictionaries
	*/
	@Override
	public int getDictionariesCount() {
		return _dictionaryLocalService.getDictionariesCount();
	}

	@Override
	public int getRootCount(long groupId) {
		return _dictionaryLocalService.getRootCount(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dictionaryLocalService.getOSGiServiceIdentifier();
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
		return _dictionaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dictionaryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dictionaryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.informationprocessing.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of dictionaries
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.informationprocessing.model.Dictionary> getDictionaries(
		int start, int end) {
		return _dictionaryLocalService.getDictionaries(start, end);
	}

	/**
	* Returns all the dictionaries matching the UUID and company.
	*
	* @param uuid the UUID of the dictionaries
	* @param companyId the primary key of the company
	* @return the matching dictionaries, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.informationprocessing.model.Dictionary> getDictionariesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _dictionaryLocalService.getDictionariesByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of dictionaries matching the UUID and company.
	*
	* @param uuid the UUID of the dictionaries
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching dictionaries, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.informationprocessing.model.Dictionary> getDictionariesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.informationprocessing.model.Dictionary> orderByComparator) {
		return _dictionaryLocalService.getDictionariesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.informationprocessing.model.Dictionary> getRoot(
		long groupId) {
		return _dictionaryLocalService.getRoot(groupId);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.informationprocessing.model.Dictionary> getRoot(
		long groupId, int start, int end) {
		return _dictionaryLocalService.getRoot(groupId, start, end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.informationprocessing.model.Dictionary> getRoot(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<at.graz.meduni.bibbox.informationprocessing.model.Dictionary> obc) {
		return _dictionaryLocalService.getRoot(groupId, start, end, obc);
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
		return _dictionaryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dictionaryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public DictionaryLocalService getWrappedService() {
		return _dictionaryLocalService;
	}

	@Override
	public void setWrappedService(DictionaryLocalService dictionaryLocalService) {
		_dictionaryLocalService = dictionaryLocalService;
	}

	private DictionaryLocalService _dictionaryLocalService;
}