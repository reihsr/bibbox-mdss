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

import at.graz.meduni.bibbox.medicaldataset.model.ImportMedicalDataSetLog;
import at.graz.meduni.bibbox.medicaldataset.service.ImportMedicalDataSetLogLocalServiceUtil;

/**
 * The extended model base implementation for the ImportMedicalDataSetLog service. Represents a row in the &quot;medicaldataset_ImportMedicalDataSetLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ImportMedicalDataSetLogImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLogImpl
 * @see ImportMedicalDataSetLog
 * @generated
 */
@ProviderType
public abstract class ImportMedicalDataSetLogBaseImpl
	extends ImportMedicalDataSetLogModelImpl implements ImportMedicalDataSetLog {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a import medical data set log model instance should use the {@link ImportMedicalDataSetLog} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			ImportMedicalDataSetLogLocalServiceUtil.addImportMedicalDataSetLog(this);
		}
		else {
			ImportMedicalDataSetLogLocalServiceUtil.updateImportMedicalDataSetLog(this);
		}
	}
}