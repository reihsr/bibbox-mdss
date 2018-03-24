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

package at.graz.meduni.bibbox.digitalpathology.model.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.digitalpathology.model.wsihash;
import at.graz.meduni.bibbox.digitalpathology.service.wsihashLocalServiceUtil;

/**
 * The extended model base implementation for the wsihash service. Represents a row in the &quot;DP_wsihash&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link wsihashImpl}.
 * </p>
 *
 * @author robert
 * @see wsihashImpl
 * @see wsihash
 * @generated
 */
@ProviderType
public abstract class wsihashBaseImpl extends wsihashModelImpl
	implements wsihash {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a wsihash model instance should use the {@link wsihash} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			wsihashLocalServiceUtil.addwsihash(this);
		}
		else {
			wsihashLocalServiceUtil.updatewsihash(this);
		}
	}
}