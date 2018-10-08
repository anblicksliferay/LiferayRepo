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
 * This class is used by SOAP remote services, specifically {@link com.astra.anblicks.pdca.service.http.itemDescriptionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.http.itemDescriptionServiceSoap
 * @generated
 */
@ProviderType
public class itemDescriptionSoap implements Serializable {
	public static itemDescriptionSoap toSoapModel(itemDescription model) {
		itemDescriptionSoap soapModel = new itemDescriptionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setItemDescriptionId(model.getItemDescriptionId());
		soapModel.setItemDescriptionName(model.getItemDescriptionName());

		return soapModel;
	}

	public static itemDescriptionSoap[] toSoapModels(itemDescription[] models) {
		itemDescriptionSoap[] soapModels = new itemDescriptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static itemDescriptionSoap[][] toSoapModels(
		itemDescription[][] models) {
		itemDescriptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new itemDescriptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new itemDescriptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static itemDescriptionSoap[] toSoapModels(
		List<itemDescription> models) {
		List<itemDescriptionSoap> soapModels = new ArrayList<itemDescriptionSoap>(models.size());

		for (itemDescription model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new itemDescriptionSoap[soapModels.size()]);
	}

	public itemDescriptionSoap() {
	}

	public long getPrimaryKey() {
		return _itemDescriptionId;
	}

	public void setPrimaryKey(long pk) {
		setItemDescriptionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getItemDescriptionId() {
		return _itemDescriptionId;
	}

	public void setItemDescriptionId(long itemDescriptionId) {
		_itemDescriptionId = itemDescriptionId;
	}

	public String getItemDescriptionName() {
		return _itemDescriptionName;
	}

	public void setItemDescriptionName(String itemDescriptionName) {
		_itemDescriptionName = itemDescriptionName;
	}

	private String _uuid;
	private long _itemDescriptionId;
	private String _itemDescriptionName;
}