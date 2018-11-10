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
 * The extended model interface for the ImportMedicalDataSetFieldMap service. Represents a row in the &quot;medicaldataset_ImportMedicalDataSetFieldMap&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ImportMedicalDataSetFieldMapModel
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapImpl
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapImpl")
@ProviderType
public interface ImportMedicalDataSetFieldMap
	extends ImportMedicalDataSetFieldMapModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.medicaldataset.model.impl.ImportMedicalDataSetFieldMapImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ImportMedicalDataSetFieldMap, Long> IMPORT_MEDICAL_DATA_SET_FIELD_MAP_ID_ACCESSOR =
		new Accessor<ImportMedicalDataSetFieldMap, Long>() {
			@Override
			public Long get(
				ImportMedicalDataSetFieldMap importMedicalDataSetFieldMap) {
				return importMedicalDataSetFieldMap.getImportMedicalDataSetFieldMapId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ImportMedicalDataSetFieldMap> getTypeClass() {
				return ImportMedicalDataSetFieldMap.class;
			}
		};

	public boolean isNotSelected();
}