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
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.cla_kpiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.cla_kpiServiceSoap
 * @generated
 */
@ProviderType
public class cla_kpiSoap implements Serializable {
	public static cla_kpiSoap toSoapModel(cla_kpi model) {
		cla_kpiSoap soapModel = new cla_kpiSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setClaKpiId(model.getClaKpiId());
		soapModel.setKpiId(model.getKpiId());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setYtd(model.getYtd());
		soapModel.setOl(model.getOl());
		soapModel.setClaPoint(model.getClaPoint());
		soapModel.setAchivement(model.getAchivement());

		return soapModel;
	}

	public static cla_kpiSoap[] toSoapModels(cla_kpi[] models) {
		cla_kpiSoap[] soapModels = new cla_kpiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static cla_kpiSoap[][] toSoapModels(cla_kpi[][] models) {
		cla_kpiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new cla_kpiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new cla_kpiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static cla_kpiSoap[] toSoapModels(List<cla_kpi> models) {
		List<cla_kpiSoap> soapModels = new ArrayList<cla_kpiSoap>(models.size());

		for (cla_kpi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new cla_kpiSoap[soapModels.size()]);
	}

	public cla_kpiSoap() {
	}

	public long getPrimaryKey() {
		return _claKpiId;
	}

	public void setPrimaryKey(long pk) {
		setClaKpiId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getClaKpiId() {
		return _claKpiId;
	}

	public void setClaKpiId(long claKpiId) {
		_claKpiId = claKpiId;
	}

	public long getKpiId() {
		return _kpiId;
	}

	public void setKpiId(long kpiId) {
		_kpiId = kpiId;
	}

	public long getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(long periodId) {
		_periodId = periodId;
	}

	public long getYtd() {
		return _ytd;
	}

	public void setYtd(long ytd) {
		_ytd = ytd;
	}

	public double getOl() {
		return _ol;
	}

	public void setOl(double ol) {
		_ol = ol;
	}

	public double getClaPoint() {
		return _claPoint;
	}

	public void setClaPoint(double claPoint) {
		_claPoint = claPoint;
	}

	public double getAchivement() {
		return _achivement;
	}

	public void setAchivement(double achivement) {
		_achivement = achivement;
	}

	private String _uuid;
	private long _claKpiId;
	private long _kpiId;
	private long _periodId;
	private long _ytd;
	private double _ol;
	private double _claPoint;
	private double _achivement;
}