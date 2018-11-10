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
 * The extended model interface for the ImportMedicalDataSet service. Represents a row in the &quot;medicaldataset_ImportMedicalDataSet&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetModel
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetImpl
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetImpl")
@ProviderType
public interface ImportMedicalDataSet extends ImportMedicalDataSetModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ImportMedicalDataSet, Long> IMPORT_MEDICAL_DATA_SET_ID_ACCESSOR =
		new Accessor<ImportMedicalDataSet, Long>() {
			@Override
			public Long get(ImportMedicalDataSet importMedicalDataSet) {
				return importMedicalDataSet.getImportMedicalDataSetId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ImportMedicalDataSet> getTypeClass() {
				return ImportMedicalDataSet.class;
			}
		};
}