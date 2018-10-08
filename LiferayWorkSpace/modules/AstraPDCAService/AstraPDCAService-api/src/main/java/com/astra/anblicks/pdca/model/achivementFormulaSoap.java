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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.achivementFormulaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.achivementFormulaServiceSoap
 * @generated
 */
@ProviderType
public class achivementFormulaSoap implements Serializable {
	public static achivementFormulaSoap toSoapModel(achivementFormula model) {
		achivementFormulaSoap soapModel = new achivementFormulaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAchivementFormulaId(model.getAchivementFormulaId());
		soapModel.setAchivementFormula(model.getAchivementFormula());
		soapModel.setItemDescriptionId(model.getItemDescriptionId());

		return soapModel;
	}

	public static achivementFormulaSoap[] toSoapModels(
		achivementFormula[] models) {
		achivementFormulaSoap[] soapModels = new achivementFormulaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static achivementFormulaSoap[][] toSoapModels(
		achivementFormula[][] models) {
		achivementFormulaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new achivementFormulaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new achivementFormulaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static achivementFormulaSoap[] toSoapModels(
		List<achivementFormula> models) {
		List<achivementFormulaSoap> soapModels = new ArrayList<achivementFormulaSoap>(models.size());

		for (achivementFormula model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new achivementFormulaSoap[soapModels.size()]);
	}

	public achivementFormulaSoap() {
	}

	public long getPrimaryKey() {
		return _achivementFormulaId;
	}

	public void setPrimaryKey(long pk) {
		setAchivementFormulaId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAchivementFormulaId() {
		return _achivementFormulaId;
	}

	public void setAchivementFormulaId(long achivementFormulaId) {
		_achivementFormulaId = achivementFormulaId;
	}

	public String getAchivementFormula() {
		return _achivementFormula;
	}

	public void setAchivementFormula(String achivementFormula) {
		_achivementFormula = achivementFormula;
	}

	public long getItemDescriptionId() {
		return _itemDescriptionId;
	}

	public void setItemDescriptionId(long itemDescriptionId) {
		_itemDescriptionId = itemDescriptionId;
	}

	private String _uuid;
	private long _achivementFormulaId;
	private String _achivementFormula;
	private long _itemDescriptionId;
}