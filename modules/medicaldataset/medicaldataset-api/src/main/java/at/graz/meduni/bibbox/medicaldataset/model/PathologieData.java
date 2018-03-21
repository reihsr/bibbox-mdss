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
 * The extended model interface for the PathologieData service. Represents a row in the &quot;FOO_PathologieData&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PathologieDataModel
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataImpl
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataImpl")
@ProviderType
public interface PathologieData extends PathologieDataModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.medicaldataset.model.impl.PathologieDataImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PathologieData, Long> PATHOLOGIE_DATA_ID_ACCESSOR =
		new Accessor<PathologieData, Long>() {
			@Override
			public Long get(PathologieData pathologieData) {
				return pathologieData.getPathologieDataId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PathologieData> getTypeClass() {
				return PathologieData.class;
			}
		};
}