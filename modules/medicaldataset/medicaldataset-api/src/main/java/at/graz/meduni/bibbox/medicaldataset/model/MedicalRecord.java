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
 * The extended model interface for the MedicalRecord service. Represents a row in the &quot;medicaldataset_MedicalRecord&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MedicalRecordModel
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordImpl
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordImpl")
@ProviderType
public interface MedicalRecord extends MedicalRecordModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.medicaldataset.model.impl.MedicalRecordImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MedicalRecord, Long> MEDICAL_RECORD_ID_ACCESSOR =
		new Accessor<MedicalRecord, Long>() {
			@Override
			public Long get(MedicalRecord medicalRecord) {
				return medicalRecord.getMedicalRecordId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MedicalRecord> getTypeClass() {
				return MedicalRecord.class;
			}
		};

	public at.graz.meduni.bibbox.medicaldataset.model.PathologyData getPathologyData();
}