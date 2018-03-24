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

import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologieDataException;
import at.graz.meduni.bibbox.medicaldataset.model.PathologieData;
import at.graz.meduni.bibbox.medicaldataset.service.base.PathologieDataLocalServiceBaseImpl;

/**
 * The implementation of the pathologie data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.medicaldataset.service.PathologieDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PathologieDataLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.medicaldataset.service.PathologieDataLocalServiceUtil
 */
public class PathologieDataLocalServiceImpl
	extends PathologieDataLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.medicaldataset.service.PathologieDataLocalServiceUtil} to access the pathologie data local service.
	 */
	
	public PathologieData addPathologieData(long medicalRecordId, Date receivedDate, Date validationDate, int patientAge, String sender, String extractionMethode, String reportingPhysician1, String reportingPhysician2,
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
		
		long pathologieDataId = counterLocalService.increment();
		PathologieData pathologieData = pathologieDataPersistence.create(pathologieDataId);
		
		pathologieData.setUuid(serviceContext.getUuid());
		
		pathologieData.setGroupId(groupId);
		pathologieData.setCompanyId(user.getCompanyId());
		pathologieData.setUserId(userId);
		pathologieData.setUserName(user.getFullName());
		pathologieData.setCreateDate(serviceContext.getCreateDate(now));
		pathologieData.setModifiedDate(serviceContext.getCreateDate(now));
		
		pathologieData.setMedicalRecordId(medicalRecordId);
		
		pathologieData.setReceivedDate(receivedDate);
		pathologieData.setValidationDate(validationDate);
		
		pathologieData.setPatientAge(patientAge);
		pathologieData.setSender(sender);
		pathologieData.setExtractionMethode(extractionMethode);
		pathologieData.setReportingPhysician1(reportingPhysician1);
		pathologieData.setReportingPhysician2(reportingPhysician2);
		pathologieData.setGynPhysician(gynPhysician);
		pathologieData.setValidationPhysician1(validationPhysician1);
		pathologieData.setValidationPhysician2(validationPhysician2);
		pathologieData.setReportStatus(reportStatus);
		pathologieData.setNumberOfBlockes(numberOfBlockes);
		pathologieData.setNumberOfSlides(numberOfSlides);
		
		pathologieData.setBasicDisease(basicDisease);
		pathologieData.setCauseOfDeath(causeOfDeath);
		pathologieData.setMaterial(materialExtended);
		pathologieData.setMaterialExtended(materialExtended);
		pathologieData.setMacroscopicDescription(macroscopicDescription);
		pathologieData.setMicroscopicDescription(microscopicDescription);
		pathologieData.setHistologicDescription(histologicDescription);
		pathologieData.setMolecularPathologicDescription(molecularPathologicDescription);
		pathologieData.setPathologicDiagnosis(neuroPathologicDiagnosis);
		pathologieData.setFrozenSectionDiagnosis(frozenSectionDiagnosis);
		pathologieData.setMolecularPathologicDiagnosis(molecularPathologicDiagnosis);
		pathologieData.setZytologieDiagnosis(zytologieDiagnosis);
		pathologieData.setNeuroPathologicDiagnosis(neuroPathologicDiagnosis);
		pathologieData.setComment(zytologiecomment);
		pathologieData.setZytologieDiagnosis(zytologieDiagnosis);
		
		pathologieData.setGrad(grad);
		pathologieData.setTnmp(tnmpn);
		pathologieData.setTnmt(tnmt);
		pathologieData.setTnmn(tnmn);
		pathologieData.setTnmm(tnmm);
		pathologieData.setTnmr(tnmr);
		pathologieData.setTnml(tnml);
		pathologieData.setTnmv(tnmv);
		pathologieData.setTnmpn(tnmpn);
		pathologieData.setDgcode1(dgcode1);
		pathologieData.setDgcode2(dgcode2);
		pathologieData.setPap(pap);
		pathologieData.setSmearQuality(smearQuality);
		
		pathologieData.setExpandoBridgeAttributes(serviceContext);
		
		pathologieDataPersistence.update(pathologieData);
		
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, PathologieData.class.getName(), pathologieDataId, false, true, true);
		
		return pathologieData;
	}
	
	public PathologieData updatePathologieData(long pathologieDataId, long medicalRecordId, Date receivedDate, Date validationDate, int patientAge, String sender, String extractionMethode, String reportingPhysician1, String reportingPhysician2,
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
		
		PathologieData pathologieData = getPathologieData(pathologieDataId);
		
		pathologieData.setUserId(userId);
		pathologieData.setUserName(user.getFullName());
		pathologieData.setModifiedDate(serviceContext.getCreateDate(now));
		
		pathologieData.setMedicalRecordId(medicalRecordId);
		
		pathologieData.setReceivedDate(receivedDate);
		pathologieData.setValidationDate(validationDate);
		
		pathologieData.setPatientAge(patientAge);
		pathologieData.setSender(sender);
		pathologieData.setExtractionMethode(extractionMethode);
		pathologieData.setReportingPhysician1(reportingPhysician1);
		pathologieData.setReportingPhysician2(reportingPhysician2);
		pathologieData.setGynPhysician(gynPhysician);
		pathologieData.setValidationPhysician1(validationPhysician1);
		pathologieData.setValidationPhysician2(validationPhysician2);
		pathologieData.setReportStatus(reportStatus);
		pathologieData.setNumberOfBlockes(numberOfBlockes);
		pathologieData.setNumberOfSlides(numberOfSlides);
		
		pathologieData.setBasicDisease(basicDisease);
		pathologieData.setCauseOfDeath(causeOfDeath);
		pathologieData.setMaterial(materialExtended);
		pathologieData.setMaterialExtended(materialExtended);
		pathologieData.setMacroscopicDescription(macroscopicDescription);
		pathologieData.setMicroscopicDescription(microscopicDescription);
		pathologieData.setHistologicDescription(histologicDescription);
		pathologieData.setMolecularPathologicDescription(molecularPathologicDescription);
		pathologieData.setPathologicDiagnosis(neuroPathologicDiagnosis);
		pathologieData.setFrozenSectionDiagnosis(frozenSectionDiagnosis);
		pathologieData.setMolecularPathologicDiagnosis(molecularPathologicDiagnosis);
		pathologieData.setZytologieDiagnosis(zytologieDiagnosis);
		pathologieData.setNeuroPathologicDiagnosis(neuroPathologicDiagnosis);
		pathologieData.setComment(zytologiecomment);
		pathologieData.setZytologieDiagnosis(zytologieDiagnosis);
		
		pathologieData.setGrad(grad);
		pathologieData.setTnmp(tnmpn);
		pathologieData.setTnmt(tnmt);
		pathologieData.setTnmn(tnmn);
		pathologieData.setTnmm(tnmm);
		pathologieData.setTnmr(tnmr);
		pathologieData.setTnml(tnml);
		pathologieData.setTnmv(tnmv);
		pathologieData.setTnmpn(tnmpn);
		pathologieData.setDgcode1(dgcode1);
		pathologieData.setDgcode2(dgcode2);
		pathologieData.setPap(pap);
		pathologieData.setSmearQuality(smearQuality);
		
		pathologieDataPersistence.update(pathologieData);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), PathologieData.class.getName(), pathologieDataId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return pathologieData;
	}
	
	public PathologieData updatePathologieData(PathologieData pathologieData, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		//Validate if something is needed
		
		pathologieData.setUserId(userId);
		pathologieData.setUserName(user.getFullName());
		pathologieData.setModifiedDate(serviceContext.getCreateDate(now));
		
		pathologieDataPersistence.update(pathologieData);
		
		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), PathologieData.class.getName(), pathologieData.getPathologieDataId(), serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		
		return pathologieData;
	}
	
	public List<PathologieData> getPathologieDatas(long groupId) {
		return pathologieDataPersistence.findByGroupId(groupId);
	}
	
	public List<PathologieData> getPathologieDatas(long groupId, int start, int end) {
		return pathologieDataPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<PathologieData> getPathologieDatas(long groupId, int start, int end, OrderByComparator<PathologieData> ob) {
		return pathologieDataPersistence.findByGroupId(groupId, start, end, ob);
	}
	
	public int getPathologieDataCount(long groupId) {
		return pathologieDataPersistence.countByGroupId(groupId);
	}
	
	public PathologieData getPathologieDataForMedicalRecord(long medicalRecordId) throws NoSuchPathologieDataException {
		return pathologieDataPersistence.findByMedicalRecord(medicalRecordId);
	}
}