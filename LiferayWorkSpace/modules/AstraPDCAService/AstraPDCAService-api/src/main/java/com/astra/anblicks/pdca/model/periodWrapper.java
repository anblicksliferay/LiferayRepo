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
 * This class is a wrapper for {@link period}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see period
 * @generated
 */
@ProviderType
public class periodWrapper implements period, ModelWrapper<period> {
	public periodWrapper(period period) {
		_period = period;
	}

	@Override
	public Class<?> getModelClass() {
		return period.class;
	}

	@Override
	public String getModelClassName() {
		return period.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("periodId", getPeriodId());
		attributes.put("periodName", getPeriodName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long periodId = (Long)attributes.get("periodId");

		if (periodId != null) {
			setPeriodId(periodId);
		}

		String periodName = (String)attributes.get("periodName");

		if (periodName != null) {
			setPeriodName(periodName);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _period.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _period.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _period.isNew();
	}

	@Override
	public com.astra.anblicks.pdca.model.period toEscapedModel() {
		return new periodWrapper(_period.toEscapedModel());
	}

	@Override
	public com.astra.anblicks.pdca.model.period toUnescapedModel() {
		return new periodWrapper(_period.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _period.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.astra.anblicks.pdca.model.period> toCacheModel() {
		return _period.toCacheModel();
	}

	@Override
	public int compareTo(com.astra.anblicks.pdca.model.period period) {
		return _period.compareTo(period);
	}

	@Override
	public int hashCode() {
		return _period.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _period.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new periodWrapper((period)_period.clone());
	}

	/**
	* Returns the period name of this period.
	*
	* @return the period name of this period
	*/
	@Override
	public java.lang.String getPeriodName() {
		return _period.getPeriodName();
	}

	/**
	* Returns the uuid of this period.
	*
	* @return the uuid of this period
	*/
	@Override
	public java.lang.String getUuid() {
		return _period.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _period.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _period.toXmlString();
	}

	/**
	* Returns the period ID of this period.
	*
	* @return the period ID of this period
	*/
	@Override
	public long getPeriodId() {
		return _period.getPeriodId();
	}

	/**
	* Returns the primary key of this period.
	*
	* @return the primary key of this period
	*/
	@Override
	public long getPrimaryKey() {
		return _period.getPrimaryKey();
	}

	@Override
	public void persist() {
		_period.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_period.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_period.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_period.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_period.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_period.setNew(n);
	}

	/**
	* Sets the period ID of this period.
	*
	* @param periodId the period ID of this period
	*/
	@Override
	public void setPeriodId(long periodId) {
		_period.setPeriodId(periodId);
	}

	/**
	* Sets the period name of this period.
	*
	* @param periodName the period name of this period
	*/
	@Override
	public void setPeriodName(java.lang.String periodName) {
		_period.setPeriodName(periodName);
	}

	/**
	* Sets the primary key of this period.
	*
	* @param primaryKey the primary key of this period
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_period.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_period.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this period.
	*
	* @param uuid the uuid of this period
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_period.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof periodWrapper)) {
			return false;
		}

		periodWrapper periodWrapper = (periodWrapper)obj;

		if (Objects.equals(_period, periodWrapper._period)) {
			return true;
		}

		return false;
	}

	@Override
	public period getWrappedModel() {
		return _period;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _period.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _period.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_period.resetOriginalValues();
	}

	private final period _period;
}