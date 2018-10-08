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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.kpiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.kpiServiceSoap
 * @generated
 */
@ProviderType
public class kpiSoap implements Serializable {
	public static kpiSoap toSoapModel(kpi model) {
		kpiSoap soapModel = new kpiSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setKpiId(model.getKpiId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setWeight(model.getWeight());
		soapModel.setTarget(model.getTarget());
		soapModel.setYear(model.getYear());
		soapModel.setUnit(model.getUnit());
		soapModel.setAchivementFormulaId(model.getAchivementFormulaId());
		soapModel.setItemDescriptionName(model.getItemDescriptionName());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static kpiSoap[] toSoapModels(kpi[] models) {
		kpiSoap[] soapModels = new kpiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static kpiSoap[][] toSoapModels(kpi[][] models) {
		kpiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new kpiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new kpiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static kpiSoap[] toSoapModels(List<kpi> models) {
		List<kpiSoap> soapModels = new ArrayList<kpiSoap>(models.size());

		for (kpi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new kpiSoap[soapModels.size()]);
	}

	public kpiSoap() {
	}

	public long getPrimaryKey() {
		return _kpiId;
	}

	public void setPrimaryKey(long pk) {
		setKpiId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getKpiId() {
		return _kpiId;
	}

	public void setKpiId(long kpiId) {
		_kpiId = kpiId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public long getWeight() {
		return _weight;
	}

	public void setWeight(long weight) {
		_weight = weight;
	}

	public long getTarget() {
		return _target;
	}

	public void setTarget(long target) {
		_target = target;
	}

	public long getYear() {
		return _year;
	}

	public void setYear(long year) {
		_year = year;
	}

	public String getUnit() {
		return _unit;
	}

	public void setUnit(String unit) {
		_unit = unit;
	}

	public long getAchivementFormulaId() {
		return _achivementFormulaId;
	}

	public void setAchivementFormulaId(long achivementFormulaId) {
		_achivementFormulaId = achivementFormulaId;
	}

	public String getItemDescriptionName() {
		return _itemDescriptionName;
	}

	public void setItemDescriptionName(String itemDescriptionName) {
		_itemDescriptionName = itemDescriptionName;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _kpiId;
	private long _companyId;
	private long _typeId;
	private long _weight;
	private long _target;
	private long _year;
	private String _unit;
	private long _achivementFormulaId;
	private String _itemDescriptionName;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}