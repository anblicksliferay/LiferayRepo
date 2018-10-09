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
 * This class is a wrapper for {@link cla_kpi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cla_kpi
 * @generated
 */
@ProviderType
public class cla_kpiWrapper implements cla_kpi, ModelWrapper<cla_kpi> {
	public cla_kpiWrapper(cla_kpi cla_kpi) {
		_cla_kpi = cla_kpi;
	}

	@Override
	public Class<?> getModelClass() {
		return cla_kpi.class;
	}

	@Override
	public String getModelClassName() {
		return cla_kpi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("claKpiId", getClaKpiId());
		attributes.put("kpiId", getKpiId());
		attributes.put("periodId", getPeriodId());
		attributes.put("ytd", getYtd());
		attributes.put("ol", getOl());
		attributes.put("claPoint", getClaPoint());
		attributes.put("achivement", getAchivement());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long claKpiId = (Long)attributes.get("claKpiId");

		if (claKpiId != null) {
			setClaKpiId(claKpiId);
		}

		Long kpiId = (Long)attributes.get("kpiId");

		if (kpiId != null) {
			setKpiId(kpiId);
		}

		Long periodId = (Long)attributes.get("periodId");

		if (periodId != null) {
			setPeriodId(periodId);
		}

		Long ytd = (Long)attributes.get("ytd");

		if (ytd != null) {
			setYtd(ytd);
		}

		Double ol = (Double)attributes.get("ol");

		if (ol != null) {
			setOl(ol);
		}

		Double claPoint = (Double)attributes.get("claPoint");

		if (claPoint != null) {
			setClaPoint(claPoint);
		}

		Double achivement = (Double)attributes.get("achivement");

		if (achivement != null) {
			setAchivement(achivement);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _cla_kpi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _cla_kpi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cla_kpi.isNew();
	}

	@Override
	public com.astra.anblicks.pdca.model.cla_kpi toEscapedModel() {
		return new cla_kpiWrapper(_cla_kpi.toEscapedModel());
	}

	@Override
	public com.astra.anblicks.pdca.model.cla_kpi toUnescapedModel() {
		return new cla_kpiWrapper(_cla_kpi.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cla_kpi.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.astra.anblicks.pdca.model.cla_kpi> toCacheModel() {
		return _cla_kpi.toCacheModel();
	}

	/**
	* Returns the achivement of this cla_kpi.
	*
	* @return the achivement of this cla_kpi
	*/
	@Override
	public double getAchivement() {
		return _cla_kpi.getAchivement();
	}

	/**
	* Returns the cla point of this cla_kpi.
	*
	* @return the cla point of this cla_kpi
	*/
	@Override
	public double getClaPoint() {
		return _cla_kpi.getClaPoint();
	}

	/**
	* Returns the ol of this cla_kpi.
	*
	* @return the ol of this cla_kpi
	*/
	@Override
	public double getOl() {
		return _cla_kpi.getOl();
	}

	@Override
	public int compareTo(com.astra.anblicks.pdca.model.cla_kpi cla_kpi) {
		return _cla_kpi.compareTo(cla_kpi);
	}

	@Override
	public int hashCode() {
		return _cla_kpi.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cla_kpi.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new cla_kpiWrapper((cla_kpi)_cla_kpi.clone());
	}

	/**
	* Returns the uuid of this cla_kpi.
	*
	* @return the uuid of this cla_kpi
	*/
	@Override
	public java.lang.String getUuid() {
		return _cla_kpi.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _cla_kpi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cla_kpi.toXmlString();
	}

	/**
	* Returns the cla kpi ID of this cla_kpi.
	*
	* @return the cla kpi ID of this cla_kpi
	*/
	@Override
	public long getClaKpiId() {
		return _cla_kpi.getClaKpiId();
	}

	/**
	* Returns the kpi ID of this cla_kpi.
	*
	* @return the kpi ID of this cla_kpi
	*/
	@Override
	public long getKpiId() {
		return _cla_kpi.getKpiId();
	}

	/**
	* Returns the period ID of this cla_kpi.
	*
	* @return the period ID of this cla_kpi
	*/
	@Override
	public long getPeriodId() {
		return _cla_kpi.getPeriodId();
	}

	/**
	* Returns the primary key of this cla_kpi.
	*
	* @return the primary key of this cla_kpi
	*/
	@Override
	public long getPrimaryKey() {
		return _cla_kpi.getPrimaryKey();
	}

	/**
	* Returns the ytd of this cla_kpi.
	*
	* @return the ytd of this cla_kpi
	*/
	@Override
	public long getYtd() {
		return _cla_kpi.getYtd();
	}

	@Override
	public void persist() {
		_cla_kpi.persist();
	}

	/**
	* Sets the achivement of this cla_kpi.
	*
	* @param achivement the achivement of this cla_kpi
	*/
	@Override
	public void setAchivement(double achivement) {
		_cla_kpi.setAchivement(achivement);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cla_kpi.setCachedModel(cachedModel);
	}

	/**
	* Sets the cla kpi ID of this cla_kpi.
	*
	* @param claKpiId the cla kpi ID of this cla_kpi
	*/
	@Override
	public void setClaKpiId(long claKpiId) {
		_cla_kpi.setClaKpiId(claKpiId);
	}

	/**
	* Sets the cla point of this cla_kpi.
	*
	* @param claPoint the cla point of this cla_kpi
	*/
	@Override
	public void setClaPoint(double claPoint) {
		_cla_kpi.setClaPoint(claPoint);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cla_kpi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_cla_kpi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cla_kpi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the kpi ID of this cla_kpi.
	*
	* @param kpiId the kpi ID of this cla_kpi
	*/
	@Override
	public void setKpiId(long kpiId) {
		_cla_kpi.setKpiId(kpiId);
	}

	@Override
	public void setNew(boolean n) {
		_cla_kpi.setNew(n);
	}

	/**
	* Sets the ol of this cla_kpi.
	*
	* @param ol the ol of this cla_kpi
	*/
	@Override
	public void setOl(double ol) {
		_cla_kpi.setOl(ol);
	}

	/**
	* Sets the period ID of this cla_kpi.
	*
	* @param periodId the period ID of this cla_kpi
	*/
	@Override
	public void setPeriodId(long periodId) {
		_cla_kpi.setPeriodId(periodId);
	}

	/**
	* Sets the primary key of this cla_kpi.
	*
	* @param primaryKey the primary key of this cla_kpi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cla_kpi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cla_kpi.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this cla_kpi.
	*
	* @param uuid the uuid of this cla_kpi
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_cla_kpi.setUuid(uuid);
	}

	/**
	* Sets the ytd of this cla_kpi.
	*
	* @param ytd the ytd of this cla_kpi
	*/
	@Override
	public void setYtd(long ytd) {
		_cla_kpi.setYtd(ytd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof cla_kpiWrapper)) {
			return false;
		}

		cla_kpiWrapper cla_kpiWrapper = (cla_kpiWrapper)obj;

		if (Objects.equals(_cla_kpi, cla_kpiWrapper._cla_kpi)) {
			return true;
		}

		return false;
	}

	@Override
	public cla_kpi getWrappedModel() {
		return _cla_kpi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cla_kpi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cla_kpi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cla_kpi.resetOriginalValues();
	}

	private final cla_kpi _cla_kpi;
}