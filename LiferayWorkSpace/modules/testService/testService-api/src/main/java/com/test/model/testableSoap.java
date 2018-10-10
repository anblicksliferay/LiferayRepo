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

package com.test.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.test.service.http.testableServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.test.service.http.testableServiceSoap
 * @generated
 */
@ProviderType
public class testableSoap implements Serializable {
	public static testableSoap toSoapModel(testable model) {
		testableSoap soapModel = new testableSoap();

		soapModel.setAid(model.getAid());
		soapModel.setAname(model.getAname());

		return soapModel;
	}

	public static testableSoap[] toSoapModels(testable[] models) {
		testableSoap[] soapModels = new testableSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static testableSoap[][] toSoapModels(testable[][] models) {
		testableSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new testableSoap[models.length][models[0].length];
		}
		else {
			soapModels = new testableSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static testableSoap[] toSoapModels(List<testable> models) {
		List<testableSoap> soapModels = new ArrayList<testableSoap>(models.size());

		for (testable model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new testableSoap[soapModels.size()]);
	}

	public testableSoap() {
	}

	public int getPrimaryKey() {
		return _aid;
	}

	public void setPrimaryKey(int pk) {
		setAid(pk);
	}

	public int getAid() {
		return _aid;
	}

	public void setAid(int aid) {
		_aid = aid;
	}

	public String getAname() {
		return _aname;
	}

	public void setAname(String aname) {
		_aname = aname;
	}

	private int _aid;
	private String _aname;
}