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

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSet;
import at.graz.meduni.bibbox.medicaldataset.service.base.ImportMedicalDataSetLocalServiceBaseImpl;

/**
 * The implementation of the import medical data set local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLocalServiceUtil
 */
public class ImportMedicalDataSetLocalServiceImpl
	extends ImportMedicalDataSetLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLocalServiceUtil} to access the import medical data set local service.
	 */
	
	public ImportMedicalDataSet addImportMedicalDataSet(String importName, String importType, long imiJobId, String description, String fileName, String filePath, int importStatus, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		long importMedicalDataSetId = counterLocalService.increment();
		ImportMedicalDataSet importMedicalDataSet = importMedicalDataSetPersistence.create(importMedicalDataSetId);
		
		importMedicalDataSet.setUuid(serviceContext.getUuid());
		
		importMedicalDataSet.setGroupId(groupId);
		importMedicalDataSet.setCompanyId(user.getCompanyId());
		importMedicalDataSet.setUserId(userId);
		importMedicalDataSet.setUserName(user.getFullName());
		importMedicalDataSet.setCreateDate(serviceContext.getCreateDate(now));
		importMedicalDataSet.setModifiedDate(serviceContext.getCreateDate(now));
		
		importMedicalDataSet.setImportName(importName);
		importMedicalDataSet.setImportType(importType);
		importMedicalDataSet.setImiJobId(imiJobId);
		importMedicalDataSet.setDescription(description);
		importMedicalDataSet.setFileName(fileName);
		importMedicalDataSet.setFilePath(filePath);
		importMedicalDataSet.setImportStatus(importStatus);
		
		importMedicalDataSet.setExpandoBridgeAttributes(serviceContext);
		
		importMedicalDataSetPersistence.update(importMedicalDataSet);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, ImportMedicalDataSet.class.getName(), importMedicalDataSetId, false, true, true);
		
		return importMedicalDataSet;
	}
	
	public ImportMedicalDataSet updateImportMedicalDataSet(long importMedicalDataSetId, String importName, String importType, long imiJobId, String description, String fileName, String filePath, int importStatus, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		ImportMedicalDataSet importMedicalDataSet = getImportMedicalDataSet(importMedicalDataSetId);
		
		importMedicalDataSet.setUuid(serviceContext.getUuid());
		
		importMedicalDataSet.setUserId(userId);
		importMedicalDataSet.setUserName(user.getFullName());
		importMedicalDataSet.setModifiedDate(serviceContext.getCreateDate(now));
		
		importMedicalDataSetPersistence.update(importMedicalDataSet);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), ImportMedicalDataSet.class.getName(), importMedicalDataSetId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return importMedicalDataSet;
	}
	
	public ImportMedicalDataSet updateImportMedicalDataSet(ImportMedicalDataSet importMedicalDataSet, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		importMedicalDataSet.setUuid(serviceContext.getUuid());
		
		importMedicalDataSet.setUserId(userId);
		importMedicalDataSet.setUserName(user.getFullName());
		importMedicalDataSet.setModifiedDate(serviceContext.getCreateDate(now));
		
		importMedicalDataSetPersistence.update(importMedicalDataSet);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), ImportMedicalDataSet.class.getName(), importMedicalDataSet.getImportMedicalDataSetId(), serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return importMedicalDataSet;
	}
	
	public List<ImportMedicalDataSet> getImportMedicalDataSets(long groupId) {
		return importMedicalDataSetPersistence.findByGroupId(groupId);
	}
	
	public List<ImportMedicalDataSet> getImportMedicalDataSets(long groupId, int start, int end) {
		return importMedicalDataSetPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<ImportMedicalDataSet> getImportMedicalDataSets(long groupId, int start, int end, OrderByComparator<ImportMedicalDataSet> ob) {
		return importMedicalDataSetPersistence.findByGroupId(groupId, start, end, ob);
	}
	
	public int getImportMedicalDataSetCount(long groupId) {
		return importMedicalDataSetPersistence.countByGroupId(groupId);
	}
}