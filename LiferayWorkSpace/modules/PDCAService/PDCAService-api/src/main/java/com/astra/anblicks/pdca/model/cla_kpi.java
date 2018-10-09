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

package com.astra.anblicks.pdca.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the cla_kpi service. Represents a row in the &quot;pdca_cla_kpi&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see cla_kpiModel
 * @see com.astra.anblicks.pdca.model.impl.cla_kpiImpl
 * @see com.astra.anblicks.pdca.model.impl.cla_kpiModelImpl
 * @generated
 */
@ImplementationClassName("com.astra.anblicks.pdca.model.impl.cla_kpiImpl")
@ProviderType
public interface cla_kpi extends cla_kpiModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.astra.anblicks.pdca.model.impl.cla_kpiImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<cla_kpi, Long> CLA_KPI_ID_ACCESSOR = new Accessor<cla_kpi, Long>() {
			@Override
			public Long get(cla_kpi cla_kpi) {
				return cla_kpi.getClaKpiId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<cla_kpi> getTypeClass() {
				return cla_kpi.class;
			}
		};
}