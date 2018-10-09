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
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.companyServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.companyServiceSoap
 * @generated
 */
@ProviderType
public class companySoap implements Serializable {
	public static companySoap toSoapModel(company model) {
		companySoap soapModel = new companySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCompanyName(model.getCompanyName());

		return soapModel;
	}

	public static companySoap[] toSoapModels(company[] models) {
		companySoap[] soapModels = new companySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static companySoap[][] toSoapModels(company[][] models) {
		companySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new companySoap[models.length][models[0].length];
		}
		else {
			soapModels = new companySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static companySoap[] toSoapModels(List<company> models) {
		List<companySoap> soapModels = new ArrayList<companySoap>(models.size());

		for (company model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new companySoap[soapModels.size()]);
	}

	public companySoap() {
	}

	public long getPrimaryKey() {
		return _companyId;
	}

	public void setPrimaryKey(long pk) {
		setCompanyId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	private String _uuid;
	private long _companyId;
	private String _companyName;
}