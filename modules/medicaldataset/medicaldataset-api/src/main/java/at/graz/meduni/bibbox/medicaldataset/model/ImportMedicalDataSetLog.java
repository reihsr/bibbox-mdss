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

package at.graz.meduni.bibbox.medicaldataset.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ImportMedicalDataSetLog service. Represents a row in the &quot;FOO_ImportMedicalDataSetLog&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetLogModel
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogImpl
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogImpl")
@ProviderType
public interface ImportMedicalDataSetLog extends ImportMedicalDataSetLogModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetLogImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ImportMedicalDataSetLog, Long> IMPORT_MEDICAL_DATA_SET_LOG_ID_ACCESSOR =
		new Accessor<ImportMedicalDataSetLog, Long>() {
			@Override
			public Long get(ImportMedicalDataSetLog importMedicalDataSetLog) {
				return importMedicalDataSetLog.getImportMedicalDataSetLogId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ImportMedicalDataSetLog> getTypeClass() {
				return ImportMedicalDataSetLog.class;
			}
		};
}