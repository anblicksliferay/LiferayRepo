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
 * The extended model interface for the achivementFormula service. Represents a row in the &quot;pdca_achivementFormula&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see achivementFormulaModel
 * @see com.astra.anblicks.pdca.model.impl.achivementFormulaImpl
 * @see com.astra.anblicks.pdca.model.impl.achivementFormulaModelImpl
 * @generated
 */
@ImplementationClassName("com.astra.anblicks.pdca.model.impl.achivementFormulaImpl")
@ProviderType
public interface achivementFormula extends achivementFormulaModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.astra.anblicks.pdca.model.impl.achivementFormulaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<achivementFormula, Long> ACHIVEMENT_FORMULA_ID_ACCESSOR =
		new Accessor<achivementFormula, Long>() {
			@Override
			public Long get(achivementFormula achivementFormula) {
				return achivementFormula.getAchivementFormulaId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<achivementFormula> getTypeClass() {
				return achivementFormula.class;
			}
		};
}