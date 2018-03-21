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

import at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord;
import at.graz.meduni.bibbox.medicaldataset.service.base.MedicalRecordLocalServiceBaseImpl;

/**
 * The implementation of the medical record local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MedicalRecordLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalServiceUtil
 */
public class MedicalRecordLocalServiceImpl
	extends MedicalRecordLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.medicaldataset.service.MedicalRecordLocalServiceUtil} to access the medical record local service.
	 */
	
	public MedicalRecord addMedicalRecord(long histonumberStart, long histonumberEnd, int histonumberRunning, long iNumber, long vPatentId, long vHistonNumber, String area, long imiJobId, String importFile, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		long medicalRecordId = counterLocalService.increment();
		MedicalRecord medicalrecord = medicalRecordPersistence.create(medicalRecordId);
		
		medicalrecord.setUuid(serviceContext.getUuid());
		
		medicalrecord.setGroupId(groupId);
		medicalrecord.setCompanyId(user.getCompanyId());
		medicalrecord.setUserId(userId);
		medicalrecord.setUserName(user.getFullName());
		medicalrecord.setCreateDate(serviceContext.getCreateDate(now));
		medicalrecord.setModifiedDate(serviceContext.getCreateDate(now));
		
		medicalrecord.setHistonumberStart(histonumberStart);
		medicalrecord.setHistonumberEnd(histonumberEnd);
		medicalrecord.setHistonumberRunning(histonumberRunning);
		medicalrecord.setINumber(iNumber);
		medicalrecord.setVPatentId(vPatentId);
		medicalrecord.setVHistonNumber(vHistonNumber);
		
		medicalrecord.setArea(area);
		
		medicalrecord.setImiJobId(imiJobId);
		medicalrecord.setImportFile(importFile);
		
		medicalrecord.setExpandoBridgeAttributes(serviceContext);
		
		medicalRecordPersistence.update(medicalrecord);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, MedicalRecord.class.getName(), medicalRecordId, false, true, true);
		
		return medicalrecord;
	}
	
	/*
	public MedicalRecord addMedicalRecord(MedicalRecord medicalrecord, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		
		long medicalRecordId = counterLocalService.increment();
		MedicalRecord medicalrecord = medicalRecordPersistence.create(medicalRecordId);
		
		medicalrecord.setUuid(serviceContext.getUuid());
		
		medicalrecord.setGroupId(groupId);
		medicalrecord.setCompanyId(user.getCompanyId());
		medicalrecord.setUserId(userId);
		medicalrecord.setUserName(user.getFullName());
		medicalrecord.setCreateDate(serviceContext.getCreateDate(now));
		medicalrecord.setModifiedDate(serviceContext.getCreateDate(now));
		
		medicalrecord.setExpandoBridgeAttributes(serviceContext);
		
		medicalRecordPersistence.update(medicalrecord);
		
		return medicalrecord;
	}*/
	
	public MedicalRecord updateMedicalRecord(long medicalRecordId, long histonumberStart, long histonumberEnd, int histonumberRunning, long iNumber, long vPatentId, long vHistonNumber, String area, long imiJobId, String importFile, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		MedicalRecord medicalrecord = getMedicalRecord(medicalRecordId);
		
		medicalrecord.setUserId(userId);
		medicalrecord.setUserName(user.getFullName());
		medicalrecord.setModifiedDate(serviceContext.getCreateDate(now));
		
		medicalrecord.setHistonumberStart(histonumberStart);
		medicalrecord.setHistonumberEnd(histonumberEnd);
		medicalrecord.setHistonumberRunning(histonumberRunning);
		medicalrecord.setINumber(iNumber);
		medicalrecord.setVPatentId(vPatentId);
		medicalrecord.setVHistonNumber(vHistonNumber);
		
		medicalrecord.setArea(area);
		
		medicalrecord.setImiJobId(imiJobId);
		medicalrecord.setImportFile(importFile);
		
		medicalRecordPersistence.update(medicalrecord);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), MedicalRecord.class.getName(), medicalRecordId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return medicalrecord;
	}
	
	public MedicalRecord updateMedicalRecord(MedicalRecord medicalrecord, ServiceContext serviceContext) throws PortalException {
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		
		medicalrecord.setUserId(userId);
		medicalrecord.setUserName(user.getFullName());
		medicalrecord.setModifiedDate(serviceContext.getCreateDate(now));
		
		medicalRecordPersistence.update(medicalrecord);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), MedicalRecord.class.getName(), medicalrecord.getMedicalRecordId(), serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return medicalrecord;
	}
	
	public List<MedicalRecord> getMedicalRecords(long groupId) {
		return medicalRecordPersistence.findByGroupId(groupId);
	}
	
	public List<MedicalRecord> getMedicalRecords(long groupId, int start, int end) {
		return medicalRecordPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<MedicalRecord> getMedicalRecords(long groupId, int start, int end, OrderByComparator<MedicalRecord> ob) {
		return medicalRecordPersistence.findByGroupId(groupId, start, end, ob);
	}
	
	public int getMedicalRecordsCount(long groupId) {
		return medicalRecordPersistence.countByGroupId(groupId);
	}
}