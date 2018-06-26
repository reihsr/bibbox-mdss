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

package at.graz.meduni.bibbox.medicaldataset.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetFieldMap;
import at.graz.meduni.bibbox.medicaldataset.service.base.ImportMedicalDataSetFieldMapLocalServiceBaseImpl;

/**
 * The implementation of the import medical data set field map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetFieldMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetFieldMapLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetFieldMapLocalServiceUtil
 */
public class ImportMedicalDataSetFieldMapLocalServiceImpl
	extends ImportMedicalDataSetFieldMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetFieldMapLocalServiceUtil} to access the import medical data set field map local service.
	 */
	
	public ImportMedicalDataSetFieldMap addImportMedicalDataSetFieldMap(long importMedicalDataSetId, String importField, String importFieldPath, String sampleValue, String TableName, String TableField, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		long importMedicalDataSetFieldMapId = counterLocalService.increment();
		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = importMedicalDataSetFieldMapPersistence.create(importMedicalDataSetFieldMapId);
		
		importMedicalDataSetFieldMap.setUuid(serviceContext.getUuid());
		
		importMedicalDataSetFieldMap.setGroupId(groupId);
		importMedicalDataSetFieldMap.setCompanyId(user.getCompanyId());
		importMedicalDataSetFieldMap.setUserId(userId);
		importMedicalDataSetFieldMap.setUserName(user.getFullName());
		importMedicalDataSetFieldMap.setCreateDate(serviceContext.getCreateDate(now));
		importMedicalDataSetFieldMap.setModifiedDate(serviceContext.getCreateDate(now));
		
		importMedicalDataSetFieldMap.setImportMedicalDataSetId(importMedicalDataSetId);
		importMedicalDataSetFieldMap.setImportField(importField);
		importMedicalDataSetFieldMap.setImportFieldPath(importFieldPath);
		importMedicalDataSetFieldMap.setSampleValue(sampleValue);
		importMedicalDataSetFieldMap.setTableName(TableName);
		importMedicalDataSetFieldMap.setTableField(TableField);
		
		importMedicalDataSetFieldMap.setExpandoBridgeAttributes(serviceContext);
		
		importMedicalDataSetFieldMapPersistence.update(importMedicalDataSetFieldMap);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, ImportMedicalDataSetFieldMap.class.getName(), importMedicalDataSetFieldMapId, false, true, true);
		
		return importMedicalDataSetFieldMap;
	}
	
	public ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(long importMedicalDataSetFieldMapId, long importMedicalDataSetId, String importField, String importFieldPath, String sampleValue, String TableName, String TableField, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed

		ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap = getImportMedicalDataSetFieldMap(importMedicalDataSetFieldMapId);
		
		importMedicalDataSetFieldMap.setUuid(serviceContext.getUuid());

		importMedicalDataSetFieldMap.setUserId(userId);
		importMedicalDataSetFieldMap.setUserName(user.getFullName());
		importMedicalDataSetFieldMap.setModifiedDate(serviceContext.getCreateDate(now));
		
		importMedicalDataSetFieldMap.setImportMedicalDataSetId(importMedicalDataSetId);
		importMedicalDataSetFieldMap.setImportField(importFieldPath);
		importMedicalDataSetFieldMap.setImportFieldPath(importFieldPath);
		importMedicalDataSetFieldMap.setSampleValue(sampleValue);
		importMedicalDataSetFieldMap.setTableName(TableName);
		importMedicalDataSetFieldMap.setTableField(TableField);
		
		importMedicalDataSetFieldMapPersistence.update(importMedicalDataSetFieldMap);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), ImportMedicalDataSetFieldMap.class.getName(), importMedicalDataSetFieldMapId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return importMedicalDataSetFieldMap;
	}
	
	public ImportMedicalDataSetFieldMap updateImportMedicalDataSetFieldMap(ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		importMedicalDataSetFieldMap.setUuid(serviceContext.getUuid());
		
		importMedicalDataSetFieldMap.setUserId(userId);
		importMedicalDataSetFieldMap.setUserName(user.getFullName());
		importMedicalDataSetFieldMap.setModifiedDate(serviceContext.getCreateDate(now));
		
		importMedicalDataSetFieldMapPersistence.update(importMedicalDataSetFieldMap);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), ImportMedicalDataSetFieldMap.class.getName(), importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId(), serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return importMedicalDataSetFieldMap;
	}
	
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(long groupId) {
		return importMedicalDataSetFieldMapPersistence.findByGroupId(groupId);
	}
	
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(long groupId, int start, int end) {
		return importMedicalDataSetFieldMapPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMaps(long groupId, int start, int end, OrderByComparator<ImportMedicalDataSetFieldMap> ob) {
		return importMedicalDataSetFieldMapPersistence.findByGroupId(groupId, start, end, ob);
	}
	
	public int getImportMedicalDataSetFieldMapCount(long groupId) {
		return importMedicalDataSetFieldMapPersistence.countByGroupId(groupId);
	}
	
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(long importMedicalDataSetId) {
		return importMedicalDataSetFieldMapPersistence.findByImportMedicalDataSet(importMedicalDataSetId);
	}
	
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(long importMedicalDataSetId, int start, int end) {
		return importMedicalDataSetFieldMapPersistence.findByImportMedicalDataSet(importMedicalDataSetId, start, end);
	}
	
	public List<ImportMedicalDataSetFieldMap> getImportMedicalDataSetFieldMapsFromImportMedicalDataSet(long importMedicalDataSetId, int start, int end, OrderByComparator<ImportMedicalDataSetFieldMap> ob) {
		return importMedicalDataSetFieldMapPersistence.findByImportMedicalDataSet(importMedicalDataSetId, start, end, ob);
	}
	
	public int getImportMedicalDataSetFieldMapCountFromImportMedicalDataSet(long importMedicalDataSetId) {
		return importMedicalDataSetFieldMapPersistence.countByImportMedicalDataSet(importMedicalDataSetId);
	}
}