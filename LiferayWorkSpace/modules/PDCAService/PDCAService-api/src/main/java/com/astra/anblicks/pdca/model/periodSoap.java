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
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.periodServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.periodServiceSoap
 * @generated
 */
@ProviderType
public class periodSoap implements Serializable {
	public static periodSoap toSoapModel(period model) {
		periodSoap soapModel = new periodSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setPeriodName(model.getPeriodName());

		return soapModel;
	}

	public static periodSoap[] toSoapModels(period[] models) {
		periodSoap[] soapModels = new periodSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static periodSoap[][] toSoapModels(period[][] models) {
		periodSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new periodSoap[models.length][models[0].length];
		}
		else {
			soapModels = new periodSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static periodSoap[] toSoapModels(List<period> models) {
		List<periodSoap> soapModels = new ArrayList<periodSoap>(models.size());

		for (period model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new periodSoap[soapModels.size()]);
	}

	public periodSoap() {
	}

	public long getPrimaryKey() {
		return _periodId;
	}

	public void setPrimaryKey(long pk) {
		setPeriodId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(long periodId) {
		_periodId = periodId;
	}

	public String getPeriodName() {
		return _periodName;
	}

	public void setPeriodName(String periodName) {
		_periodName = periodName;
	}

	private String _uuid;
	private long _periodId;
	private String _periodName;
}