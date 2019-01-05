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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog;
import at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord;
import at.graz.meduni.bibbox.medicaldataset.service.base.ImportMedicalDataSetLogLocalServiceBaseImpl;

/**
 * The implementation of the import medical data set log local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLogLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLogLocalServiceUtil
 */
public class ImportMedicalDataSetLogLocalServiceImpl
	extends ImportMedicalDataSetLogLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLogLocalServiceUtil} to access the import medical data set log local service.
	 */
	
	public ImportMedicalDataSetLog addImportMedicalDataSetLog(long importMedicalDataSetId, int importStatus, String importStatusLog, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		
		long importMedicalDataSetLogId = counterLocalService.increment();
		ImportMedicalDataSetLog importMedicalDataSetLog = importMedicalDataSetLogPersistence.create(importMedicalDataSetLogId);
		
		importMedicalDataSetLog.setUuid(serviceContext.getUuid());
		
		importMedicalDataSetLog.setGroupId(groupId);
		importMedicalDataSetLog.setCompanyId(user.getCompanyId());
		importMedicalDataSetLog.setUserId(userId);
		importMedicalDataSetLog.setUserName(user.getFullName());
		importMedicalDataSetLog.setCreateDate(serviceContext.getCreateDate(now));
		importMedicalDataSetLog.setModifiedDate(serviceContext.getCreateDate(now));
		
		importMedicalDataSetLog.setImportMedicalDataSetId(importMedicalDataSetId);
		
		importMedicalDataSetLog.setImportStatus(importStatus);
		importMedicalDataSetLog.setImportStatusLog(importStatusLog);
		
		importMedicalDataSetLogPersistence.update(importMedicalDataSetLog);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, ImportMedicalDataSetLog.class.getName(), importMedicalDataSetLogId, false, true, true);
		
		return importMedicalDataSetLog;
	}
	
	public ImportMedicalDataSetLog updateImportMedicalDataSetLog(long importMedicalDataSetLogId, long importMedicalDataSetId, int importStatus, String importStatusLog, ServiceContext serviceContext) throws PortalException {
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		
		ImportMedicalDataSetLog importMedicalDataSetLog = getImportMedicalDataSetLog(importMedicalDataSetLogId);
		
		importMedicalDataSetLog.setUserId(userId);
		importMedicalDataSetLog.setUserName(user.getFullName());
		importMedicalDataSetLog.setModifiedDate(serviceContext.getCreateDate(now));
		
		importMedicalDataSetLog.setImportMedicalDataSetId(importMedicalDataSetId);
		
		importMedicalDataSetLog.setImportStatus(importStatus);
		importMedicalDataSetLog.setImportStatusLog(importStatusLog);
		
		importMedicalDataSetLog.setExpandoBridgeAttributes(serviceContext);
		
		importMedicalDataSetLogPersistence.update(importMedicalDataSetLog);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), ImportMedicalDataSetLog.class.getName(), importMedicalDataSetLogId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return importMedicalDataSetLog;
	}
	
	public ImportMedicalDataSetLog updateImportMedicalDataSetLog(ImportMedicalDataSetLog importMedicalDataSetLog, ServiceContext serviceContext) throws PortalException {
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		
		importMedicalDataSetLog.setUserId(userId);
		importMedicalDataSetLog.setUserName(user.getFullName());
		importMedicalDataSetLog.setModifiedDate(serviceContext.getCreateDate(now));
		
		importMedicalDataSetLogPersistence.update(importMedicalDataSetLog);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), ImportMedicalDataSetLog.class.getName(), importMedicalDataSetLog.getImportMedicalDataSetLogId(), serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return importMedicalDataSetLog;
	}
	
	public List<ImportMedicalDataSetLog> getImportMedicalDataSetLogs(long groupId) {
		return importMedicalDataSetLogPersistence.findByGroupId(groupId);
	}
	
	public List<ImportMedicalDataSetLog> getImportMedicalDataSetLogs(long groupId, int start, int end) {
		return importMedicalDataSetLogPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<ImportMedicalDataSetLog> getImportMedicalDataSetLogs(long groupId, int start, int end, OrderByComparator<ImportMedicalDataSetLog> ob) {
		return importMedicalDataSetLogPersistence.findByGroupId(groupId, start, end, ob);
	}
	
	public int getImportMedicalDataSetLogsCount(long groupId) {
		return importMedicalDataSetLogPersistence.countByGroupId(groupId);
	}
	
	public List<ImportMedicalDataSetLog> getImportMedicalDataSetLogsFromImportsAtStatus(long importMedicalDataSetId, int importStatus) {
		List<ImportMedicalDataSetLog> returnvalue = null;//importMedicalDataSetLogPersistence.findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId, importStatus);
		if(returnvalue == null) {
			returnvalue = new ArrayList<ImportMedicalDataSetLog>();
		}
		return returnvalue;
	}
	
	public List<ImportMedicalDataSetLog> getImportMedicalDataSetLogsFromImportsAtStatus(long importMedicalDataSetId, int importStatus, int start, int end) {
		return importMedicalDataSetLogPersistence.findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId, importStatus, start, end);
	}
	
	public List<ImportMedicalDataSetLog> getImportMedicalDataSetLogsFromImportsAtStatus(long importMedicalDataSetId, int importStatus, int start, int end, OrderByComparator<ImportMedicalDataSetLog> ob) {
		return importMedicalDataSetLogPersistence.findByImportMedicalDataSetAndImportStatus(importMedicalDataSetId, importStatus, start, end, ob);
	}
	
	public int getImportMedicalDataSetLogsFromImportsAtStatusCount(long importMedicalDataSetId, int importStatus) {
		return importMedicalDataSetLogPersistence.countByImportMedicalDataSetAndImportStatus(importMedicalDataSetId, importStatus);
	}
	
	public List<ImportMedicalDataSetLog> getImportMedicalDataSetFromImports(long importMedicalDataSetId) {
		return importMedicalDataSetLogPersistence.findByImportMedicalDataSet(importMedicalDataSetId);
	}
	
	public List<ImportMedicalDataSetLog> getImportMedicalDataSetLogsFromImports(long importMedicalDataSetId, int start, int end) {
		return importMedicalDataSetLogPersistence.findByImportMedicalDataSet(importMedicalDataSetId, start, end);
	}
	
	public List<ImportMedicalDataSetLog> getImportMedicalDataSetLogsFromImports(long importMedicalDataSetId, int start, int end, OrderByComparator<ImportMedicalDataSetLog> ob) {
		return importMedicalDataSetLogPersistence.findByImportMedicalDataSet(importMedicalDataSetId, start, end, ob);
	}
	
	public int getImportMedicalDataSetLogsFromImportsCount(long importMedicalDataSetId) {
		return importMedicalDataSetLogPersistence.countByImportMedicalDataSet(importMedicalDataSetId);
	}
}