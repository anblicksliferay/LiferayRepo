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
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.typeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.typeServiceSoap
 * @generated
 */
@ProviderType
public class typeSoap implements Serializable {
	public static typeSoap toSoapModel(type model) {
		typeSoap soapModel = new typeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setTypeName(model.getTypeName());

		return soapModel;
	}

	public static typeSoap[] toSoapModels(type[] models) {
		typeSoap[] soapModels = new typeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static typeSoap[][] toSoapModels(type[][] models) {
		typeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new typeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new typeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static typeSoap[] toSoapModels(List<type> models) {
		List<typeSoap> soapModels = new ArrayList<typeSoap>(models.size());

		for (type model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new typeSoap[soapModels.size()]);
	}

	public typeSoap() {
	}

	public long getPrimaryKey() {
		return _typeId;
	}

	public void setPrimaryKey(long pk) {
		setTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public String getTypeName() {
		return _typeName;
	}

	public void setTypeName(String typeName) {
		_typeName = typeName;
	}

	private String _uuid;
	private long _typeId;
	private String _typeName;
}