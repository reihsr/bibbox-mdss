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

package at.graz.meduni.bibbox.medicaldataset.service.base;

import at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch;
import at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchService;
import at.graz.meduni.bibbox.medicaldataset.service.persistence.KloetzelBuchPersistence;
import at.graz.meduni.bibbox.medicaldataset.service.persistence.MedicalRecordPersistence;
import at.graz.meduni.bibbox.medicaldataset.service.persistence.PathologieDataPersistence;

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
 * Provides the base implementation for the kloetzel buch remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.graz.meduni.bibbox.medicaldataset.service.impl.KloetzelBuchServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see at.graz.meduni.bibbox.medicaldataset.service.impl.KloetzelBuchServiceImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchServiceUtil
 * @generated
 */
public abstract class KloetzelBuchServiceBaseImpl extends BaseServiceImpl
	implements KloetzelBuchService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchServiceUtil} to access the kloetzel buch remote service.
	 */

	/**
	 * Returns the kloetzel buch local service.
	 *
	 * @return the kloetzel buch local service
	 */
	public at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchLocalService getKloetzelBuchLocalService() {
		return kloetzelBuchLocalService;
	}

	/**
	 * Sets the kloetzel buch local service.
	 *
	 * @param kloetzelBuchLocalService the kloetzel buch local service
	 */
	public void setKloetzelBuchLocalService(
		at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchLocalService kloetzelBuchLocalService) {
		this.kloetzelBuchLocalService = kloetzelBuchLocalService;
	}

	/**
	 * Returns the kloetzel buch remote service.
	 *
	 * @return the kloetzel buch remote service
	 */
	public KloetzelBuchService getKloetzelBuchService() {
		return kloetzelBuchService;
	}

	/**
	 * Sets the kloetzel buch remote service.
	 *
	 * @param kloetzelBuchService the kloetzel buch remote service
	 */
	public void setKloetzelBuchService(KloetzelBuchService kloetzelBuchService) {
		this.kloetzelBuchService = kloetzelBuchService;
	}

	/**
	 * Returns the kloetzel buch persistence.
	 *
	 * @return the kloetzel buch persistence
	 */
	public KloetzelBuchPersistence getKloetzelBuchPersistence() {
		return kloetzelBuchPersistence;
	}

	/**
	 * Sets the kloetzel buch persistence.
	 *
	 * @param kloetzelBuchPersistence the kloetzel buch persistence
	 */
	public void setKloetzelBuchPersistence(
		KloetzelBuchPersistence kloetzelBuchPersistence) {
		this.kloetzelBuchPersistence = kloetzelBuchPersistence;
	}

	/**
	 * Returns the medical record local service.
	 *
	 * @return the medical record local service
	 */
	public at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalService getMedicalRecordLocalService() {
		return medicalRecordLocalService;
	}

	/**
	 * Sets the medical record local service.
	 *
	 * @param medicalRecordLocalService the medical record local service
	 */
	public void setMedicalRecordLocalService(
		at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalService medicalRecordLocalService) {
		this.medicalRecordLocalService = medicalRecordLocalService;
	}

	/**
	 * Returns the medical record remote service.
	 *
	 * @return the medical record remote service
	 */
	public at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordService getMedicalRecordService() {
		return medicalRecordService;
	}

	/**
	 * Sets the medical record remote service.
	 *
	 * @param medicalRecordService the medical record remote service
	 */
	public void setMedicalRecordService(
		at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordService medicalRecordService) {
		this.medicalRecordService = medicalRecordService;
	}

	/**
	 * Returns the medical record persistence.
	 *
	 * @return the medical record persistence
	 */
	public MedicalRecordPersistence getMedicalRecordPersistence() {
		return medicalRecordPersistence;
	}

	/**
	 * Sets the medical record persistence.
	 *
	 * @param medicalRecordPersistence the medical record persistence
	 */
	public void setMedicalRecordPersistence(
		MedicalRecordPersistence medicalRecordPersistence) {
		this.medicalRecordPersistence = medicalRecordPersistence;
	}

	/**
	 * Returns the pathologie data local service.
	 *
	 * @return the pathologie data local service
	 */
	public at.graz.meduni.bibbox.medicaldataset.service.PathologieDataLocalService getPathologieDataLocalService() {
		return pathologieDataLocalService;
	}

	/**
	 * Sets the pathologie data local service.
	 *
	 * @param pathologieDataLocalService the pathologie data local service
	 */
	public void setPathologieDataLocalService(
		at.graz.meduni.bibbox.medicaldataset.service.PathologieDataLocalService pathologieDataLocalService) {
		this.pathologieDataLocalService = pathologieDataLocalService;
	}

	/**
	 * Returns the pathologie data remote service.
	 *
	 * @return the pathologie data remote service
	 */
	public at.graz.meduni.bibbox.medicaldataset.service.PathologieDataService getPathologieDataService() {
		return pathologieDataService;
	}

	/**
	 * Sets the pathologie data remote service.
	 *
	 * @param pathologieDataService the pathologie data remote service
	 */
	public void setPathologieDataService(
		at.graz.meduni.bibbox.medicaldataset.service.PathologieDataService pathologieDataService) {
		this.pathologieDataService = pathologieDataService;
	}

	/**
	 * Returns the pathologie data persistence.
	 *
	 * @return the pathologie data persistence
	 */
	public PathologieDataPersistence getPathologieDataPersistence() {
		return pathologieDataPersistence;
	}

	/**
	 * Sets the pathologie data persistence.
	 *
	 * @param pathologieDataPersistence the pathologie data persistence
	 */
	public void setPathologieDataPersistence(
		PathologieDataPersistence pathologieDataPersistence) {
		this.pathologieDataPersistence = pathologieDataPersistence;
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
		return KloetzelBuchService.class.getName();
	}

	protected Class<?> getModelClass() {
		return KloetzelBuch.class;
	}

	protected String getModelClassName() {
		return KloetzelBuch.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = kloetzelBuchPersistence.getDataSource();

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

	@BeanReference(type = at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchLocalService.class)
	protected at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchLocalService kloetzelBuchLocalService;
	@BeanReference(type = KloetzelBuchService.class)
	protected KloetzelBuchService kloetzelBuchService;
	@BeanReference(type = KloetzelBuchPersistence.class)
	protected KloetzelBuchPersistence kloetzelBuchPersistence;
	@BeanReference(type = at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalService.class)
	protected at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalService medicalRecordLocalService;
	@BeanReference(type = at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordService.class)
	protected at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordService medicalRecordService;
	@BeanReference(type = MedicalRecordPersistence.class)
	protected MedicalRecordPersistence medicalRecordPersistence;
	@BeanReference(type = at.graz.meduni.bibbox.medicaldataset.service.PathologieDataLocalService.class)
	protected at.graz.meduni.bibbox.medicaldataset.service.PathologieDataLocalService pathologieDataLocalService;
	@BeanReference(type = at.graz.meduni.bibbox.medicaldataset.service.PathologieDataService.class)
	protected at.graz.meduni.bibbox.medicaldataset.service.PathologieDataService pathologieDataService;
	@BeanReference(type = PathologieDataPersistence.class)
	protected PathologieDataPersistence pathologieDataPersistence;
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