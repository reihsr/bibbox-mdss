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
import at.graz.meduni.bibbox.medicaldataset.exception.NoSuchPathologyDataException;
import at.graz.meduni.bibbox.medicaldataset.model.PathologyData;
import at.graz.meduni.bibbox.medicaldataset.service.PathologyDataLocalServiceUtil;

/**
 * The extended model implementation for the MedicalRecord service. Represents a row in the &quot;FOO_MedicalRecord&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class MedicalRecordImpl extends MedicalRecordBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a medical record model instance should use the {@link at.graz.meduni.bibbox.medicaldataset.model.MedicalRecord} interface instead.
	 */
	public MedicalRecordImpl() {
	}
	
	private PathologyData pathologyData_ = null;
	
	public PathologyData getPathologyData() {
		if(pathologyData_ == null) {
			try {
				pathologyData_ = PathologyDataLocalServiceUtil.getPathologyDataForMedicalRecord(this.getMedicalRecordId());
			} catch (NoSuchPathologyDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pathologyData_;
	}
}