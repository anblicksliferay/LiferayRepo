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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link company}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see company
 * @generated
 */
@ProviderType
public class companyWrapper implements company, ModelWrapper<company> {
	public companyWrapper(company company) {
		_company = company;
	}

	@Override
	public Class<?> getModelClass() {
		return company.class;
	}

	@Override
	public String getModelClassName() {
		return company.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("companyId", getCompanyId());
		attributes.put("companyName", getCompanyName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _company.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _company.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _company.isNew();
	}

	@Override
	public com.astra.anblicks.pdca.model.company toEscapedModel() {
		return new companyWrapper(_company.toEscapedModel());
	}

	@Override
	public com.astra.anblicks.pdca.model.company toUnescapedModel() {
		return new companyWrapper(_company.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _company.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.astra.anblicks.pdca.model.company> toCacheModel() {
		return _company.toCacheModel();
	}

	@Override
	public int compareTo(com.astra.anblicks.pdca.model.company company) {
		return _company.compareTo(company);
	}

	@Override
	public int hashCode() {
		return _company.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _company.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new companyWrapper((company)_company.clone());
	}

	/**
	* Returns the company name of this company.
	*
	* @return the company name of this company
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _company.getCompanyName();
	}

	/**
	* Returns the uuid of this company.
	*
	* @return the uuid of this company
	*/
	@Override
	public java.lang.String getUuid() {
		return _company.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _company.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _company.toXmlString();
	}

	/**
	* Returns the company ID of this company.
	*
	* @return the company ID of this company
	*/
	@Override
	public long getCompanyId() {
		return _company.getCompanyId();
	}

	/**
	* Returns the primary key of this company.
	*
	* @return the primary key of this company
	*/
	@Override
	public long getPrimaryKey() {
		return _company.getPrimaryKey();
	}

	@Override
	public void persist() {
		_company.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_company.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this company.
	*
	* @param companyId the company ID of this company
	*/
	@Override
	public void setCompanyId(long companyId) {
		_company.setCompanyId(companyId);
	}

	/**
	* Sets the company name of this company.
	*
	* @param companyName the company name of this company
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_company.setCompanyName(companyName);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_company.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_company.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_company.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_company.setNew(n);
	}

	/**
	* Sets the primary key of this company.
	*
	* @param primaryKey the primary key of this company
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_company.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_company.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this company.
	*
	* @param uuid the uuid of this company
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_company.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof companyWrapper)) {
			return false;
		}

		companyWrapper companyWrapper = (companyWrapper)obj;

		if (Objects.equals(_company, companyWrapper._company)) {
			return true;
		}

		return false;
	}

	@Override
	public company getWrappedModel() {
		return _company;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _company.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _company.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_company.resetOriginalValues();
	}

	private final company _company;
}