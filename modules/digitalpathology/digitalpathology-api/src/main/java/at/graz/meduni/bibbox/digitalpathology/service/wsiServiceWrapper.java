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

package at.graz.meduni.bibbox.digitalpathology.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link wsiService}.
 *
 * @author robert
 * @see wsiService
 * @generated
 */
@ProviderType
public class wsiServiceWrapper implements wsiService,
	ServiceWrapper<wsiService> {
	public wsiServiceWrapper(wsiService wsiService) {
		_wsiService = wsiService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wsiService.getOSGiServiceIdentifier();
	}

	@Override
	public wsiService getWrappedService() {
		return _wsiService;
	}

	@Override
	public void setWrappedService(wsiService wsiService) {
		_wsiService = wsiService;
	}

	private wsiService _wsiService;
}