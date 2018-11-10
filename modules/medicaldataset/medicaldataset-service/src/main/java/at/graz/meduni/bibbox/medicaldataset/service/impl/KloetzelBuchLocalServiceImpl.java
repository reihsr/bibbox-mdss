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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchKloetzelBuchException;
import at.graz.meduni.bibbox.medicaldataset.model.KloetzelBuch;
import at.graz.meduni.bibbox.medicaldataset.service.base.KloetzelBuchLocalServiceBaseImpl;

/**
 * The implementation of the kloetzel buch local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KloetzelBuchLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchLocalServiceUtil
 */
public class KloetzelBuchLocalServiceImpl
	extends KloetzelBuchLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.medicaldataset.service.KloetzelBuchLocalServiceUtil} to access the kloetzel buch local service.
	 */
	
	public KloetzelBuch addKloetzelBuch(long medicalRecordId, long histonumberStart, long histonumberEnd, int histonumberRunning, long histonumber, int kloetzelBuchRunning, String oid, String bid,
			String area, String type, String acronym, String text, String info, int count, int numberOfPieces, int kbStatus, int sort, String color, Date kbDate, String day, String pocessinguser, String organizationUnit,
			ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		long kloetzelBuchId = counterLocalService.increment();
		KloetzelBuch kloetzelBuch = kloetzelBuchPersistence.create(kloetzelBuchId);
		
		kloetzelBuch.setUuid(serviceContext.getUuid());
		
		kloetzelBuch.setGroupId(groupId);
		kloetzelBuch.setCompanyId(user.getCompanyId());
		kloetzelBuch.setUserId(userId);
		kloetzelBuch.setUserName(user.getFullName());
		kloetzelBuch.setCreateDate(serviceContext.getCreateDate(now));
		kloetzelBuch.setModifiedDate(serviceContext.getCreateDate(now));
		
		kloetzelBuch.setMedicalRecordId(medicalRecordId);
		
		kloetzelBuch.setHistonumberStart(histonumberStart);
		kloetzelBuch.setHistonumberEnd(histonumberEnd);
		kloetzelBuch.setHistonumberRunning(histonumberRunning);
		kloetzelBuch.setHistonumber(histonumber);
		kloetzelBuch.setKloetzelBuchRunning(kloetzelBuchRunning);
		kloetzelBuch.setOid(oid);
		kloetzelBuch.setBid(bid);
		
		kloetzelBuch.setArea(area);
		kloetzelBuch.setType(type);
		kloetzelBuch.setAcronym(acronym);
		kloetzelBuch.setText(text);
		kloetzelBuch.setInfo(info);
		kloetzelBuch.setCount(count);
		kloetzelBuch.setNumberOfPieces(numberOfPieces);
		kloetzelBuch.setKbStatus(kbStatus);
		kloetzelBuch.setSort(sort);
		kloetzelBuch.setColor(color);
		kloetzelBuch.setKbDate(kbDate);
		kloetzelBuch.setDay(day);
		kloetzelBuch.setPocessinguser(pocessinguser);
		kloetzelBuch.setOrganizationUnit(organizationUnit);
		
		kloetzelBuch.setExpandoBridgeAttributes(serviceContext);
		
		kloetzelBuchPersistence.update(kloetzelBuch);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, KloetzelBuch.class.getName(), kloetzelBuchId, false, true, true);
		
		return kloetzelBuch;
	}
	
	public KloetzelBuch addKloetzelBuch(long medicalRecordId, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		long kloetzelBuchId = counterLocalService.increment();
		KloetzelBuch kloetzelBuch = kloetzelBuchPersistence.create(kloetzelBuchId);
		
		kloetzelBuch.setUuid(serviceContext.getUuid());
		
		kloetzelBuch.setGroupId(groupId);
		kloetzelBuch.setCompanyId(user.getCompanyId());
		kloetzelBuch.setUserId(userId);
		kloetzelBuch.setUserName(user.getFullName());
		kloetzelBuch.setCreateDate(serviceContext.getCreateDate(now));
		kloetzelBuch.setModifiedDate(serviceContext.getCreateDate(now));
		
		kloetzelBuch.setMedicalRecordId(medicalRecordId);
		
		kloetzelBuch.setExpandoBridgeAttributes(serviceContext);
		
		kloetzelBuchPersistence.update(kloetzelBuch);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, KloetzelBuch.class.getName(), kloetzelBuchId, false, true, true);
		
		return kloetzelBuch;
	}
	
	public KloetzelBuch updateloetzelBuch(long kloetzelBuchId, long medicalRecordId, long histonumberStart, long histonumberEnd, int histonumberRunning, long histonumber, int kloetzelBuchRunning, String oid, String bid,
			String area, String type, String acronym, String text, String info, int count, int numberOfPieces, int kbStatus, int sort, String color, Date kbDate, String day, String pocessinguser, String organizationUnit,
			ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		KloetzelBuch kloetzelBuch = getKloetzelBuch(kloetzelBuchId);
		
		kloetzelBuch.setUserId(userId);
		kloetzelBuch.setUserName(user.getFullName());
		kloetzelBuch.setModifiedDate(serviceContext.getCreateDate(now));
		
		kloetzelBuch.setMedicalRecordId(medicalRecordId);
		
		kloetzelBuch.setHistonumberStart(histonumberStart);
		kloetzelBuch.setHistonumberEnd(histonumberEnd);
		kloetzelBuch.setHistonumberRunning(histonumberRunning);
		kloetzelBuch.setHistonumber(histonumber);
		kloetzelBuch.setKloetzelBuchRunning(kloetzelBuchRunning);
		kloetzelBuch.setOid(oid);
		kloetzelBuch.setBid(bid);
		
		kloetzelBuch.setArea(area);
		kloetzelBuch.setType(type);
		kloetzelBuch.setAcronym(acronym);
		kloetzelBuch.setText(text);
		kloetzelBuch.setInfo(info);
		kloetzelBuch.setCount(count);
		kloetzelBuch.setNumberOfPieces(numberOfPieces);
		kloetzelBuch.setKbStatus(kbStatus);
		kloetzelBuch.setSort(sort);
		kloetzelBuch.setColor(color);
		kloetzelBuch.setKbDate(kbDate);
		kloetzelBuch.setDay(day);
		kloetzelBuch.setPocessinguser(pocessinguser);
		kloetzelBuch.setOrganizationUnit(organizationUnit);
		
		kloetzelBuchPersistence.update(kloetzelBuch);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), KloetzelBuch.class.getName(), kloetzelBuchId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return kloetzelBuch;
	}
	
	public KloetzelBuch updateloetzelBuch(KloetzelBuch kloetzelBuch, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		kloetzelBuch.setUserId(userId);
		kloetzelBuch.setUserName(user.getFullName());
		kloetzelBuch.setModifiedDate(serviceContext.getCreateDate(now));
		
		kloetzelBuchPersistence.update(kloetzelBuch);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), KloetzelBuch.class.getName(), kloetzelBuch.getKloetzelBuchId(), serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return kloetzelBuch;
	}
	
	public List<KloetzelBuch> getKloetzelBuchs(long groupId) {
		return kloetzelBuchPersistence.findByGroupId(groupId);
	}
	
	public List<KloetzelBuch> getKloetzelBuchs(long groupId, int start, int end) {
		return kloetzelBuchPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<KloetzelBuch> getKloetzelBuchs(long groupId, int start, int end, OrderByComparator<KloetzelBuch> ob) {
		return kloetzelBuchPersistence.findByGroupId(groupId, start, end, ob);
	}
	
	public int getKloetzelBuchCount(long groupId) {
		return kloetzelBuchPersistence.countByGroupId(groupId);
	}
	
	public KloetzelBuch getKloetzelBuchForMedicalRecord(long medicalRecordId) throws NoSuchKloetzelBuchException {
		return kloetzelBuchPersistence.findByMedicalRecord(medicalRecordId);
	}
}