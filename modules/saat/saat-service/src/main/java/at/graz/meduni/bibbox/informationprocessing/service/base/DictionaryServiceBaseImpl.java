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

package at.graz.meduni.bibbox.informationprocessing.service.base;

import at.graz.meduni.bibbox.informationprocessing.model.Dictionary;
import at.graz.meduni.bibbox.informationprocessing.service.DictionaryService;
import at.graz.meduni.bibbox.informationprocessing.service.persistence.DictionaryDictionaryLinkPersistence;
import at.graz.meduni.bibbox.informationprocessing.service.persistence.DictionaryPersistence;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.kernel.service.persistence.AssetTagPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the dictionary remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.graz.meduni.bibbox.informationprocessing.service.impl.DictionaryServiceImpl}.
 * </p>
 *
 * @author robert
 * @see at.graz.meduni.bibbox.informationprocessing.service.impl.DictionaryServiceImpl
 * @see at.graz.meduni.bibbox.informationprocessing.service.DictionaryServiceUtil
 * @generated
 */
public abstract class DictionaryServiceBaseImpl extends BaseServiceImpl
	implements DictionaryService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.graz.meduni.bibbox.informationprocessing.service.DictionaryServiceUtil} to access the dictionary remote service.
	 */

	/**
	 * Returns the dictionary local service.
	 *
	 * @return the dictionary local service
	 */
	public at.graz.meduni.bibbox.informationprocessing.service.DictionaryLocalService getDictionaryLocalService() {
		return dictionaryLocalService;
	}

	/**
	 * Sets the dictionary local service.
	 *
	 * @param dictionaryLocalService the dictionary local service
	 */
	public void setDictionaryLocalService(
		at.graz.meduni.bibbox.informationprocessing.service.DictionaryLocalService dictionaryLocalService) {
		this.dictionaryLocalService = dictionaryLocalService;
	}

	/**
	 * Returns the dictionary remote service.
	 *
	 * @return the dictionary remote service
	 */
	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	/**
	 * Sets the dictionary remote service.
	 *
	 * @param dictionaryService the dictionary remote service
	 */
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	/**
	 * Returns the dictionary persistence.
	 *
	 * @return the dictionary persistence
	 */
	public DictionaryPersistence getDictionaryPersistence() {
		return dictionaryPersistence;
	}

	/**
	 * Sets the dictionary persistence.
	 *
	 * @param dictionaryPersistence the dictionary persistence
	 */
	public void setDictionaryPersistence(
		DictionaryPersistence dictionaryPersistence) {
		this.dictionaryPersistence = dictionaryPersistence;
	}

	/**
	 * Returns the dictionary dictionary link local service.
	 *
	 * @return the dictionary dictionary link local service
	 */
	public at.graz.meduni.bibbox.informationprocessing.service.DictionaryDictionaryLinkLocalService getDictionaryDictionaryLinkLocalService() {
		return dictionaryDictionaryLinkLocalService;
	}

	/**
	 * Sets the dictionary dictionary link local service.
	 *
	 * @param dictionaryDictionaryLinkLocalService the dictionary dictionary link local service
	 */
	public void setDictionaryDictionaryLinkLocalService(
		at.graz.meduni.bibbox.informationprocessing.service.DictionaryDictionaryLinkLocalService dictionaryDictionaryLinkLocalService) {
		this.dictionaryDictionaryLinkLocalService = dictionaryDictionaryLinkLocalService;
	}

	/**
	 * Returns the dictionary dictionary link remote service.
	 *
	 * @return the dictionary dictionary link remote service
	 */
	public at.graz.meduni.bibbox.informationprocessing.service.DictionaryDictionaryLinkService getDictionaryDictionaryLinkService() {
		return dictionaryDictionaryLinkService;
	}

	/**
	 * Sets the dictionary dictionary link remote service.
	 *
	 * @param dictionaryDictionaryLinkService the dictionary dictionary link remote service
	 */
	public void setDictionaryDictionaryLinkService(
		at.graz.meduni.bibbox.informationprocessing.service.DictionaryDictionaryLinkService dictionaryDictionaryLinkService) {
		this.dictionaryDictionaryLinkService = dictionaryDictionaryLinkService;
	}

	/**
	 * Returns the dictionary dictionary link persistence.
	 *
	 * @return the dictionary dictionary link persistence
	 */
	public DictionaryDictionaryLinkPersistence getDictionaryDictionaryLinkPersistence() {
		return dictionaryDictionaryLinkPersistence;
	}

	/**
	 * Sets the dictionary dictionary link persistence.
	 *
	 * @param dictionaryDictionaryLinkPersistence the dictionary dictionary link persistence
	 */
	public void setDictionaryDictionaryLinkPersistence(
		DictionaryDictionaryLinkPersistence dictionaryDictionaryLinkPersistence) {
		this.dictionaryDictionaryLinkPersistence = dictionaryDictionaryLinkPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.asset.kernel.service.AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public com.liferay.asset.kernel.service.AssetEntryService getAssetEntryService() {
		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(
		com.liferay.asset.kernel.service.AssetEntryService assetEntryService) {
		this.assetEntryService = assetEntryService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset tag local service.
	 *
	 * @return the asset tag local service
	 */
	public com.liferay.asset.kernel.service.AssetTagLocalService getAssetTagLocalService() {
		return assetTagLocalService;
	}

	/**
	 * Sets the asset tag local service.
	 *
	 * @param assetTagLocalService the asset tag local service
	 */
	public void setAssetTagLocalService(
		com.liferay.asset.kernel.service.AssetTagLocalService assetTagLocalService) {
		this.assetTagLocalService = assetTagLocalService;
	}

	/**
	 * Returns the asset tag remote service.
	 *
	 * @return the asset tag remote service
	 */
	public com.liferay.asset.kernel.service.AssetTagService getAssetTagService() {
		return assetTagService;
	}

	/**
	 * Sets the asset tag remote service.
	 *
	 * @param assetTagService the asset tag remote service
	 */
	public void setAssetTagService(
		com.liferay.asset.kernel.service.AssetTagService assetTagService) {
		this.assetTagService = assetTagService;
	}

	/**
	 * Returns the asset tag persistence.
	 *
	 * @return the asset tag persistence
	 */
	public AssetTagPersistence getAssetTagPersistence() {
		return assetTagPersistence;
	}

	/**
	 * Sets the asset tag persistence.
	 *
	 * @param assetTagPersistence the asset tag persistence
	 */
	public void setAssetTagPersistence(AssetTagPersistence assetTagPersistence) {
		this.assetTagPersistence = assetTagPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DictionaryService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Dictionary.class;
	}

	protected String getModelClassName() {
		return Dictionary.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dictionaryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = at.graz.meduni.bibbox.informationprocessing.service.DictionaryLocalService.class)
	protected at.graz.meduni.bibbox.informationprocessing.service.DictionaryLocalService dictionaryLocalService;
	@BeanReference(type = DictionaryService.class)
	protected DictionaryService dictionaryService;
	@BeanReference(type = DictionaryPersistence.class)
	protected DictionaryPersistence dictionaryPersistence;
	@BeanReference(type = at.graz.meduni.bibbox.informationprocessing.service.DictionaryDictionaryLinkLocalService.class)
	protected at.graz.meduni.bibbox.informationprocessing.service.DictionaryDictionaryLinkLocalService dictionaryDictionaryLinkLocalService;
	@BeanReference(type = at.graz.meduni.bibbox.informationprocessing.service.DictionaryDictionaryLinkService.class)
	protected at.graz.meduni.bibbox.informationprocessing.service.DictionaryDictionaryLinkService dictionaryDictionaryLinkService;
	@BeanReference(type = DictionaryDictionaryLinkPersistence.class)
	protected DictionaryDictionaryLinkPersistence dictionaryDictionaryLinkPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetEntryLocalService.class)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService assetEntryLocalService;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetEntryService.class)
	protected com.liferay.asset.kernel.service.AssetEntryService assetEntryService;
	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetTagLocalService.class)
	protected com.liferay.asset.kernel.service.AssetTagLocalService assetTagLocalService;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetTagService.class)
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;
	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
}