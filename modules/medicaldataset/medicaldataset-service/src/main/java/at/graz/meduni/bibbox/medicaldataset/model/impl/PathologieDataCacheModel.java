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

package at.graz.meduni.bibbox.medicaldataset.model.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.medicaldataset.model.PathologieData;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PathologieData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PathologieData
 * @generated
 */
@ProviderType
public class PathologieDataCacheModel implements CacheModel<PathologieData>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PathologieDataCacheModel)) {
			return false;
		}

		PathologieDataCacheModel pathologieDataCacheModel = (PathologieDataCacheModel)obj;

		if (pathologieDataId == pathologieDataCacheModel.pathologieDataId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pathologieDataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(111);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", pathologieDataId=");
		sb.append(pathologieDataId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", medicalRecordId=");
		sb.append(medicalRecordId);
		sb.append(", receivedDate=");
		sb.append(receivedDate);
		sb.append(", validationDate=");
		sb.append(validationDate);
		sb.append(", patientAge=");
		sb.append(patientAge);
		sb.append(", sender=");
		sb.append(sender);
		sb.append(", extractionMethode=");
		sb.append(extractionMethode);
		sb.append(", reportingPhysician1=");
		sb.append(reportingPhysician1);
		sb.append(", reportingPhysician2=");
		sb.append(reportingPhysician2);
		sb.append(", gynPhysician=");
		sb.append(gynPhysician);
		sb.append(", validationPhysician1=");
		sb.append(validationPhysician1);
		sb.append(", validationPhysician2=");
		sb.append(validationPhysician2);
		sb.append(", reportStatus=");
		sb.append(reportStatus);
		sb.append(", numberOfBlockes=");
		sb.append(numberOfBlockes);
		sb.append(", numberOfSlides=");
		sb.append(numberOfSlides);
		sb.append(", basicDisease=");
		sb.append(basicDisease);
		sb.append(", causeOfDeath=");
		sb.append(causeOfDeath);
		sb.append(", material=");
		sb.append(material);
		sb.append(", materialExtended=");
		sb.append(materialExtended);
		sb.append(", macroscopicDescription=");
		sb.append(macroscopicDescription);
		sb.append(", microscopicDescription=");
		sb.append(microscopicDescription);
		sb.append(", histologicDescription=");
		sb.append(histologicDescription);
		sb.append(", molecularPathologicDescription=");
		sb.append(molecularPathologicDescription);
		sb.append(", zytologieDescription=");
		sb.append(zytologieDescription);
		sb.append(", pathologicDiagnosis=");
		sb.append(pathologicDiagnosis);
		sb.append(", frozenSectionDiagnosis=");
		sb.append(frozenSectionDiagnosis);
		sb.append(", molecularPathologicDiagnosis=");
		sb.append(molecularPathologicDiagnosis);
		sb.append(", zytologieDiagnosis=");
		sb.append(zytologieDiagnosis);
		sb.append(", neuroPathologicDiagnosis=");
		sb.append(neuroPathologicDiagnosis);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", zytologiecomment=");
		sb.append(zytologiecomment);
		sb.append(", grad=");
		sb.append(grad);
		sb.append(", tnmp=");
		sb.append(tnmp);
		sb.append(", tnmt=");
		sb.append(tnmt);
		sb.append(", tnmn=");
		sb.append(tnmn);
		sb.append(", tnmm=");
		sb.append(tnmm);
		sb.append(", tnmr=");
		sb.append(tnmr);
		sb.append(", tnml=");
		sb.append(tnml);
		sb.append(", tnmv=");
		sb.append(tnmv);
		sb.append(", tnmpn=");
		sb.append(tnmpn);
		sb.append(", dgcode1=");
		sb.append(dgcode1);
		sb.append(", dgcode2=");
		sb.append(dgcode2);
		sb.append(", pap=");
		sb.append(pap);
		sb.append(", smearQuality=");
		sb.append(smearQuality);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PathologieData toEntityModel() {
		PathologieDataImpl pathologieDataImpl = new PathologieDataImpl();

		if (uuid == null) {
			pathologieDataImpl.setUuid(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setUuid(uuid);
		}

		pathologieDataImpl.setPathologieDataId(pathologieDataId);
		pathologieDataImpl.setGroupId(groupId);
		pathologieDataImpl.setCompanyId(companyId);
		pathologieDataImpl.setUserId(userId);

		if (userName == null) {
			pathologieDataImpl.setUserName(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			pathologieDataImpl.setCreateDate(null);
		}
		else {
			pathologieDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			pathologieDataImpl.setModifiedDate(null);
		}
		else {
			pathologieDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		pathologieDataImpl.setStatus(status);
		pathologieDataImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			pathologieDataImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			pathologieDataImpl.setStatusDate(null);
		}
		else {
			pathologieDataImpl.setStatusDate(new Date(statusDate));
		}

		pathologieDataImpl.setMedicalRecordId(medicalRecordId);

		if (receivedDate == Long.MIN_VALUE) {
			pathologieDataImpl.setReceivedDate(null);
		}
		else {
			pathologieDataImpl.setReceivedDate(new Date(receivedDate));
		}

		if (validationDate == Long.MIN_VALUE) {
			pathologieDataImpl.setValidationDate(null);
		}
		else {
			pathologieDataImpl.setValidationDate(new Date(validationDate));
		}

		pathologieDataImpl.setPatientAge(patientAge);

		if (sender == null) {
			pathologieDataImpl.setSender(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setSender(sender);
		}

		if (extractionMethode == null) {
			pathologieDataImpl.setExtractionMethode(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setExtractionMethode(extractionMethode);
		}

		if (reportingPhysician1 == null) {
			pathologieDataImpl.setReportingPhysician1(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setReportingPhysician1(reportingPhysician1);
		}

		if (reportingPhysician2 == null) {
			pathologieDataImpl.setReportingPhysician2(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setReportingPhysician2(reportingPhysician2);
		}

		if (gynPhysician == null) {
			pathologieDataImpl.setGynPhysician(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setGynPhysician(gynPhysician);
		}

		if (validationPhysician1 == null) {
			pathologieDataImpl.setValidationPhysician1(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setValidationPhysician1(validationPhysician1);
		}

		if (validationPhysician2 == null) {
			pathologieDataImpl.setValidationPhysician2(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setValidationPhysician2(validationPhysician2);
		}

		if (reportStatus == null) {
			pathologieDataImpl.setReportStatus(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setReportStatus(reportStatus);
		}

		pathologieDataImpl.setNumberOfBlockes(numberOfBlockes);
		pathologieDataImpl.setNumberOfSlides(numberOfSlides);

		if (basicDisease == null) {
			pathologieDataImpl.setBasicDisease(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setBasicDisease(basicDisease);
		}

		if (causeOfDeath == null) {
			pathologieDataImpl.setCauseOfDeath(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setCauseOfDeath(causeOfDeath);
		}

		if (material == null) {
			pathologieDataImpl.setMaterial(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setMaterial(material);
		}

		if (materialExtended == null) {
			pathologieDataImpl.setMaterialExtended(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setMaterialExtended(materialExtended);
		}

		if (macroscopicDescription == null) {
			pathologieDataImpl.setMacroscopicDescription(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setMacroscopicDescription(macroscopicDescription);
		}

		if (microscopicDescription == null) {
			pathologieDataImpl.setMicroscopicDescription(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setMicroscopicDescription(microscopicDescription);
		}

		if (histologicDescription == null) {
			pathologieDataImpl.setHistologicDescription(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setHistologicDescription(histologicDescription);
		}

		if (molecularPathologicDescription == null) {
			pathologieDataImpl.setMolecularPathologicDescription(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setMolecularPathologicDescription(molecularPathologicDescription);
		}

		if (zytologieDescription == null) {
			pathologieDataImpl.setZytologieDescription(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setZytologieDescription(zytologieDescription);
		}

		if (pathologicDiagnosis == null) {
			pathologieDataImpl.setPathologicDiagnosis(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setPathologicDiagnosis(pathologicDiagnosis);
		}

		if (frozenSectionDiagnosis == null) {
			pathologieDataImpl.setFrozenSectionDiagnosis(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setFrozenSectionDiagnosis(frozenSectionDiagnosis);
		}

		if (molecularPathologicDiagnosis == null) {
			pathologieDataImpl.setMolecularPathologicDiagnosis(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setMolecularPathologicDiagnosis(molecularPathologicDiagnosis);
		}

		if (zytologieDiagnosis == null) {
			pathologieDataImpl.setZytologieDiagnosis(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setZytologieDiagnosis(zytologieDiagnosis);
		}

		if (neuroPathologicDiagnosis == null) {
			pathologieDataImpl.setNeuroPathologicDiagnosis(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setNeuroPathologicDiagnosis(neuroPathologicDiagnosis);
		}

		if (comment == null) {
			pathologieDataImpl.setComment(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setComment(comment);
		}

		if (zytologiecomment == null) {
			pathologieDataImpl.setZytologiecomment(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setZytologiecomment(zytologiecomment);
		}

		if (grad == null) {
			pathologieDataImpl.setGrad(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setGrad(grad);
		}

		if (tnmp == null) {
			pathologieDataImpl.setTnmp(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setTnmp(tnmp);
		}

		if (tnmt == null) {
			pathologieDataImpl.setTnmt(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setTnmt(tnmt);
		}

		if (tnmn == null) {
			pathologieDataImpl.setTnmn(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setTnmn(tnmn);
		}

		if (tnmm == null) {
			pathologieDataImpl.setTnmm(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setTnmm(tnmm);
		}

		if (tnmr == null) {
			pathologieDataImpl.setTnmr(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setTnmr(tnmr);
		}

		if (tnml == null) {
			pathologieDataImpl.setTnml(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setTnml(tnml);
		}

		if (tnmv == null) {
			pathologieDataImpl.setTnmv(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setTnmv(tnmv);
		}

		if (tnmpn == null) {
			pathologieDataImpl.setTnmpn(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setTnmpn(tnmpn);
		}

		if (dgcode1 == null) {
			pathologieDataImpl.setDgcode1(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setDgcode1(dgcode1);
		}

		if (dgcode2 == null) {
			pathologieDataImpl.setDgcode2(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setDgcode2(dgcode2);
		}

		if (pap == null) {
			pathologieDataImpl.setPap(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setPap(pap);
		}

		if (smearQuality == null) {
			pathologieDataImpl.setSmearQuality(StringPool.BLANK);
		}
		else {
			pathologieDataImpl.setSmearQuality(smearQuality);
		}

		pathologieDataImpl.resetOriginalValues();

		return pathologieDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		pathologieDataId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		medicalRecordId = objectInput.readLong();
		receivedDate = objectInput.readLong();
		validationDate = objectInput.readLong();

		patientAge = objectInput.readInt();
		sender = objectInput.readUTF();
		extractionMethode = objectInput.readUTF();
		reportingPhysician1 = objectInput.readUTF();
		reportingPhysician2 = objectInput.readUTF();
		gynPhysician = objectInput.readUTF();
		validationPhysician1 = objectInput.readUTF();
		validationPhysician2 = objectInput.readUTF();
		reportStatus = objectInput.readUTF();

		numberOfBlockes = objectInput.readInt();

		numberOfSlides = objectInput.readInt();
		basicDisease = objectInput.readUTF();
		causeOfDeath = objectInput.readUTF();
		material = objectInput.readUTF();
		materialExtended = objectInput.readUTF();
		macroscopicDescription = objectInput.readUTF();
		microscopicDescription = objectInput.readUTF();
		histologicDescription = objectInput.readUTF();
		molecularPathologicDescription = objectInput.readUTF();
		zytologieDescription = objectInput.readUTF();
		pathologicDiagnosis = objectInput.readUTF();
		frozenSectionDiagnosis = objectInput.readUTF();
		molecularPathologicDiagnosis = objectInput.readUTF();
		zytologieDiagnosis = objectInput.readUTF();
		neuroPathologicDiagnosis = objectInput.readUTF();
		comment = objectInput.readUTF();
		zytologiecomment = objectInput.readUTF();
		grad = objectInput.readUTF();
		tnmp = objectInput.readUTF();
		tnmt = objectInput.readUTF();
		tnmn = objectInput.readUTF();
		tnmm = objectInput.readUTF();
		tnmr = objectInput.readUTF();
		tnml = objectInput.readUTF();
		tnmv = objectInput.readUTF();
		tnmpn = objectInput.readUTF();
		dgcode1 = objectInput.readUTF();
		dgcode2 = objectInput.readUTF();
		pap = objectInput.readUTF();
		smearQuality = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(pathologieDataId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(medicalRecordId);
		objectOutput.writeLong(receivedDate);
		objectOutput.writeLong(validationDate);

		objectOutput.writeInt(patientAge);

		if (sender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sender);
		}

		if (extractionMethode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extractionMethode);
		}

		if (reportingPhysician1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportingPhysician1);
		}

		if (reportingPhysician2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportingPhysician2);
		}

		if (gynPhysician == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gynPhysician);
		}

		if (validationPhysician1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(validationPhysician1);
		}

		if (validationPhysician2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(validationPhysician2);
		}

		if (reportStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportStatus);
		}

		objectOutput.writeInt(numberOfBlockes);

		objectOutput.writeInt(numberOfSlides);

		if (basicDisease == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(basicDisease);
		}

		if (causeOfDeath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(causeOfDeath);
		}

		if (material == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(material);
		}

		if (materialExtended == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(materialExtended);
		}

		if (macroscopicDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(macroscopicDescription);
		}

		if (microscopicDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(microscopicDescription);
		}

		if (histologicDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(histologicDescription);
		}

		if (molecularPathologicDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(molecularPathologicDescription);
		}

		if (zytologieDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zytologieDescription);
		}

		if (pathologicDiagnosis == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pathologicDiagnosis);
		}

		if (frozenSectionDiagnosis == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(frozenSectionDiagnosis);
		}

		if (molecularPathologicDiagnosis == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(molecularPathologicDiagnosis);
		}

		if (zytologieDiagnosis == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zytologieDiagnosis);
		}

		if (neuroPathologicDiagnosis == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(neuroPathologicDiagnosis);
		}

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}

		if (zytologiecomment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zytologiecomment);
		}

		if (grad == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(grad);
		}

		if (tnmp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tnmp);
		}

		if (tnmt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tnmt);
		}

		if (tnmn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tnmn);
		}

		if (tnmm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tnmm);
		}

		if (tnmr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tnmr);
		}

		if (tnml == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tnml);
		}

		if (tnmv == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tnmv);
		}

		if (tnmpn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tnmpn);
		}

		if (dgcode1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dgcode1);
		}

		if (dgcode2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dgcode2);
		}

		if (pap == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pap);
		}

		if (smearQuality == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(smearQuality);
		}
	}

	public String uuid;
	public long pathologieDataId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long medicalRecordId;
	public long receivedDate;
	public long validationDate;
	public int patientAge;
	public String sender;
	public String extractionMethode;
	public String reportingPhysician1;
	public String reportingPhysician2;
	public String gynPhysician;
	public String validationPhysician1;
	public String validationPhysician2;
	public String reportStatus;
	public int numberOfBlockes;
	public int numberOfSlides;
	public String basicDisease;
	public String causeOfDeath;
	public String material;
	public String materialExtended;
	public String macroscopicDescription;
	public String microscopicDescription;
	public String histologicDescription;
	public String molecularPathologicDescription;
	public String zytologieDescription;
	public String pathologicDiagnosis;
	public String frozenSectionDiagnosis;
	public String molecularPathologicDiagnosis;
	public String zytologieDiagnosis;
	public String neuroPathologicDiagnosis;
	public String comment;
	public String zytologiecomment;
	public String grad;
	public String tnmp;
	public String tnmt;
	public String tnmn;
	public String tnmm;
	public String tnmr;
	public String tnml;
	public String tnmv;
	public String tnmpn;
	public String dgcode1;
	public String dgcode2;
	public String pap;
	public String smearQuality;
}