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

package at.graz.meduni.bibbox.digitalpathology.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the wsi service. Represents a row in the &quot;DP_wsi&quot; database table, with each column mapped to a property of this class.
 *
 * @author robert
 * @see wsiModel
 * @see at.graz.meduni.bibbox.digitalpathology.model.impl.wsiImpl
 * @see at.graz.meduni.bibbox.digitalpathology.model.impl.wsiModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.digitalpathology.model.impl.wsiImpl")
@ProviderType
public interface wsi extends wsiModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.digitalpathology.model.impl.wsiImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<wsi, Long> WSI_ID_ACCESSOR = new Accessor<wsi, Long>() {
			@Override
			public Long get(wsi wsi) {
				return wsi.getWsiId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<wsi> getTypeClass() {
				return wsi.class;
			}
		};
}