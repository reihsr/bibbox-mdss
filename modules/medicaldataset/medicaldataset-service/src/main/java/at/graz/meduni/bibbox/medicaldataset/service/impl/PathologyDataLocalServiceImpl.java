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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException;
import at.graz.meduni.bibbox.medicaldataset.model.PathologyData;
import at.graz.meduni.bibbox.medicaldataset.service.base.PathologyDataLocalServiceBaseImpl;

/**
 * The implementation of the pathology data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.medicaldataset.service.PathologyDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PathologyDataLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.PathologyDataLocalServiceUtil
 */
public class PathologyDataLocalServiceImpl
	extends PathologyDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.medicaldataset.service.PathologyDataLocalServiceUtil} to access the pathology data local service.
	 */
	public PathologyData addPathologyData(long medicalRecordId, Date receivedDate, Date validationDate, int patientAge, String sender, String extractionMethode, String reportingPhysician1, String reportingPhysician2,
			String gynPhysician, String validationPhysician1, String validationPhysician2, String reportStatus, int numberOfBlockes, int numberOfSlides,
			String basicDisease, String causeOfDeath, String material, String materialExtended, String macroscopicDescription, String microscopicDescription,
			String histologicDescription, String molecularPathologicDescription, String zytologieDescription, String pathologicDiagnosis, String frozenSectionDiagnosis,
			String molecularPathologicDiagnosis, String zytologieDiagnosis, String neuroPathologicDiagnosis, String comment, String zytologiecomment,
			String grad, String tnmp, String tnmt, String tnmn, String tnmm, String tnmr, String tnml, String tnmv, String tnmpn, String dgcode1, String dgcode2, String pap, String smearQuality,
			ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		long pathologyDataId = counterLocalService.increment();
		PathologyData pathologyData = pathologyDataPersistence.create(pathologyDataId);
		
		pathologyData.setUuid(serviceContext.getUuid());
		
		pathologyData.setGroupId(groupId);
		pathologyData.setCompanyId(user.getCompanyId());
		pathologyData.setUserId(userId);
		pathologyData.setUserName(user.getFullName());
		pathologyData.setCreateDate(serviceContext.getCreateDate(now));
		pathologyData.setModifiedDate(serviceContext.getCreateDate(now));
		
		pathologyData.setMedicalRecordId(medicalRecordId);
		
		pathologyData.setReceivedDate(receivedDate);
		pathologyData.setValidationDate(validationDate);
		
		pathologyData.setPatientAge(patientAge);
		pathologyData.setSender(sender);
		pathologyData.setExtractionMethode(extractionMethode);
		pathologyData.setReportingPhysician1(reportingPhysician1);
		pathologyData.setReportingPhysician2(reportingPhysician2);
		pathologyData.setGynPhysician(gynPhysician);
		pathologyData.setValidationPhysician1(validationPhysician1);
		pathologyData.setValidationPhysician2(validationPhysician2);
		pathologyData.setReportStatus(reportStatus);
		pathologyData.setNumberOfBlockes(numberOfBlockes);
		pathologyData.setNumberOfSlides(numberOfSlides);
		
		pathologyData.setBasicDisease(basicDisease);
		pathologyData.setCauseOfDeath(causeOfDeath);
		pathologyData.setMaterial(materialExtended);
		pathologyData.setMaterialExtended(materialExtended);
		pathologyData.setMacroscopicDescription(macroscopicDescription);
		pathologyData.setMicroscopicDescription(microscopicDescription);
		pathologyData.setHistologicDescription(histologicDescription);
		pathologyData.setMolecularPathologicDescription(molecularPathologicDescription);
		pathologyData.setPathologicDiagnosis(neuroPathologicDiagnosis);
		pathologyData.setFrozenSectionDiagnosis(frozenSectionDiagnosis);
		pathologyData.setMolecularPathologicDiagnosis(molecularPathologicDiagnosis);
		pathologyData.setZytologieDiagnosis(zytologieDiagnosis);
		pathologyData.setNeuroPathologicDiagnosis(neuroPathologicDiagnosis);
		pathologyData.setComment(zytologiecomment);
		pathologyData.setZytologieDiagnosis(zytologieDiagnosis);
		
		pathologyData.setGrad(grad);
		pathologyData.setTnmp(tnmpn);
		pathologyData.setTnmt(tnmt);
		pathologyData.setTnmn(tnmn);
		pathologyData.setTnmm(tnmm);
		pathologyData.setTnmr(tnmr);
		pathologyData.setTnml(tnml);
		pathologyData.setTnmv(tnmv);
		pathologyData.setTnmpn(tnmpn);
		pathologyData.setDgcode1(dgcode1);
		pathologyData.setDgcode2(dgcode2);
		pathologyData.setPap(pap);
		pathologyData.setSmearQuality(smearQuality);
		
		pathologyData.setExpandoBridgeAttributes(serviceContext);
		
		pathologyDataPersistence.update(pathologyData);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, PathologyData.class.getName(), pathologyDataId, false, true, true);
		
		return pathologyData;
	}
	
	public PathologyData addPathologyData(long medicalRecordId, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		long pathologyDataId = counterLocalService.increment();
		PathologyData pathologyData = pathologyDataPersistence.create(pathologyDataId);
		
		pathologyData.setUuid(serviceContext.getUuid());
		
		pathologyData.setGroupId(groupId);
		pathologyData.setCompanyId(user.getCompanyId());
		pathologyData.setUserId(userId);
		pathologyData.setUserName(user.getFullName());
		pathologyData.setCreateDate(serviceContext.getCreateDate(now));
		pathologyData.setModifiedDate(serviceContext.getCreateDate(now));
		
		pathologyData.setMedicalRecordId(medicalRecordId);
		
		pathologyData.setExpandoBridgeAttributes(serviceContext);
		
		pathologyDataPersistence.update(pathologyData);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, PathologyData.class.getName(), pathologyDataId, false, true, true);
		
		return pathologyData;
	}
	
	public PathologyData updatePathologyData(long pathologyDataId, long medicalRecordId, Date receivedDate, Date validationDate, int patientAge, String sender, String extractionMethode, String reportingPhysician1, String reportingPhysician2,
			String gynPhysician, String validationPhysician1, String validationPhysician2, String reportStatus, int numberOfBlockes, int numberOfSlides,
			String basicDisease, String causeOfDeath, String material, String materialExtended, String macroscopicDescription, String microscopicDescription,
			String histologicDescription, String molecularPathologicDescription, String zytologieDescription, String pathologicDiagnosis, String frozenSectionDiagnosis,
			String molecularPathologicDiagnosis, String zytologieDiagnosis, String neuroPathologicDiagnosis, String comment, String zytologiecomment,
			String grad, String tnmp, String tnmt, String tnmn, String tnmm, String tnmr, String tnml, String tnmv, String tnmpn, String dgcode1, String dgcode2, String pap, String smearQuality,
			ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		PathologyData pathologyData = getPathologyData(pathologyDataId);
		
		pathologyData.setUserId(userId);
		pathologyData.setUserName(user.getFullName());
		pathologyData.setModifiedDate(serviceContext.getCreateDate(now));
		
		pathologyData.setMedicalRecordId(medicalRecordId);
		
		pathologyData.setReceivedDate(receivedDate);
		pathologyData.setValidationDate(validationDate);
		
		pathologyData.setPatientAge(patientAge);
		pathologyData.setSender(sender);
		pathologyData.setExtractionMethode(extractionMethode);
		pathologyData.setReportingPhysician1(reportingPhysician1);
		pathologyData.setReportingPhysician2(reportingPhysician2);
		pathologyData.setGynPhysician(gynPhysician);
		pathologyData.setValidationPhysician1(validationPhysician1);
		pathologyData.setValidationPhysician2(validationPhysician2);
		pathologyData.setReportStatus(reportStatus);
		pathologyData.setNumberOfBlockes(numberOfBlockes);
		pathologyData.setNumberOfSlides(numberOfSlides);
		
		pathologyData.setBasicDisease(basicDisease);
		pathologyData.setCauseOfDeath(causeOfDeath);
		pathologyData.setMaterial(materialExtended);
		pathologyData.setMaterialExtended(materialExtended);
		pathologyData.setMacroscopicDescription(macroscopicDescription);
		pathologyData.setMicroscopicDescription(microscopicDescription);
		pathologyData.setHistologicDescription(histologicDescription);
		pathologyData.setMolecularPathologicDescription(molecularPathologicDescription);
		pathologyData.setPathologicDiagnosis(neuroPathologicDiagnosis);
		pathologyData.setFrozenSectionDiagnosis(frozenSectionDiagnosis);
		pathologyData.setMolecularPathologicDiagnosis(molecularPathologicDiagnosis);
		pathologyData.setZytologieDiagnosis(zytologieDiagnosis);
		pathologyData.setNeuroPathologicDiagnosis(neuroPathologicDiagnosis);
		pathologyData.setComment(zytologiecomment);
		pathologyData.setZytologieDiagnosis(zytologieDiagnosis);
		
		pathologyData.setGrad(grad);
		pathologyData.setTnmp(tnmpn);
		pathologyData.setTnmt(tnmt);
		pathologyData.setTnmn(tnmn);
		pathologyData.setTnmm(tnmm);
		pathologyData.setTnmr(tnmr);
		pathologyData.setTnml(tnml);
		pathologyData.setTnmv(tnmv);
		pathologyData.setTnmpn(tnmpn);
		pathologyData.setDgcode1(dgcode1);
		pathologyData.setDgcode2(dgcode2);
		pathologyData.setPap(pap);
		pathologyData.setSmearQuality(smearQuality);
		
		pathologyDataPersistence.update(pathologyData);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), PathologyData.class.getName(), pathologyDataId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return pathologyData;
	}
	
	public PathologyData updatePathologyData(PathologyData pathologyData, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		pathologyData.setUserId(userId);
		pathologyData.setUserName(user.getFullName());
		pathologyData.setModifiedDate(serviceContext.getCreateDate(now));
		
		pathologyDataPersistence.update(pathologyData);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), PathologyData.class.getName(), pathologyData.getPathologyDataId(), serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return pathologyData;
	}
	
	public List<PathologyData> getPathologyDatas(long groupId) {
		return pathologyDataPersistence.findByGroupId(groupId);
	}
	
	public List<PathologyData> getPathologyDatas(long groupId, int start, int end) {
		return pathologyDataPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<PathologyData> getPathologyDatas(long groupId, int start, int end, OrderByComparator<PathologyData> ob) {
		return pathologyDataPersistence.findByGroupId(groupId, start, end, ob);
	}
	
	public int getPathologyDataCount(long groupId) {
		return pathologyDataPersistence.countByGroupId(groupId);
	}
	
	public PathologyData getPathologyDataForMedicalRecord(long medicalRecordId) throws NoSuchPathologyDataException {
		return pathologyDataPersistence.findByMedicalRecord(medicalRecordId);
	}
}