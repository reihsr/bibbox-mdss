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
 * The extended model interface for the KloetzelBuch service. Represents a row in the &quot;FOO_KloetzelBuch&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see KloetzelBuchModel
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchImpl
 * @see at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchImpl")
@ProviderType
public interface KloetzelBuch extends KloetzelBuchModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.medicaldataset.model.impl.KloetzelBuchImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<KloetzelBuch, Long> KLOETZEL_BUCH_ID_ACCESSOR = new Accessor<KloetzelBuch, Long>() {
			@Override
			public Long get(KloetzelBuch kloetzelBuch) {
				return kloetzelBuch.getKloetzelBuchId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<KloetzelBuch> getTypeClass() {
				return KloetzelBuch.class;
			}
		};
}