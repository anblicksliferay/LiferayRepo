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

package com.astra.anblicks.pdca.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link cla_kpiService}.
 *
 * @author Brian Wing Shun Chan
 * @see cla_kpiService
 * @generated
 */
@ProviderType
public class cla_kpiServiceWrapper implements cla_kpiService,
	ServiceWrapper<cla_kpiService> {
	public cla_kpiServiceWrapper(cla_kpiService cla_kpiService) {
		_cla_kpiService = cla_kpiService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _cla_kpiService.getOSGiServiceIdentifier();
	}

	@Override
	public cla_kpiService getWrappedService() {
		return _cla_kpiService;
	}

	@Override
	public void setWrappedService(cla_kpiService cla_kpiService) {
		_cla_kpiService = cla_kpiService;
	}

	private cla_kpiService _cla_kpiService;
}