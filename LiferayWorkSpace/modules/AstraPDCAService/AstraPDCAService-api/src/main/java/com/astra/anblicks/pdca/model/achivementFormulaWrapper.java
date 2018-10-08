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
 * This class is a wrapper for {@link achivementFormula}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see achivementFormula
 * @generated
 */
@ProviderType
public class achivementFormulaWrapper implements achivementFormula,
	ModelWrapper<achivementFormula> {
	public achivementFormulaWrapper(achivementFormula achivementFormula) {
		_achivementFormula = achivementFormula;
	}

	@Override
	public Class<?> getModelClass() {
		return achivementFormula.class;
	}

	@Override
	public String getModelClassName() {
		return achivementFormula.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("achivementFormulaId", getAchivementFormulaId());
		attributes.put("achivementFormula", getAchivementFormula());
		attributes.put("itemDescriptionId", getItemDescriptionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long achivementFormulaId = (Long)attributes.get("achivementFormulaId");

		if (achivementFormulaId != null) {
			setAchivementFormulaId(achivementFormulaId);
		}

		String achivementFormula = (String)attributes.get("achivementFormula");

		if (achivementFormula != null) {
			setAchivementFormula(achivementFormula);
		}

		Long itemDescriptionId = (Long)attributes.get("itemDescriptionId");

		if (itemDescriptionId != null) {
			setItemDescriptionId(itemDescriptionId);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _achivementFormula.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _achivementFormula.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _achivementFormula.isNew();
	}

	@Override
	public com.astra.anblicks.pdca.model.achivementFormula toEscapedModel() {
		return new achivementFormulaWrapper(_achivementFormula.toEscapedModel());
	}

	@Override
	public com.astra.anblicks.pdca.model.achivementFormula toUnescapedModel() {
		return new achivementFormulaWrapper(_achivementFormula.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _achivementFormula.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.astra.anblicks.pdca.model.achivementFormula> toCacheModel() {
		return _achivementFormula.toCacheModel();
	}

	@Override
	public int compareTo(
		com.astra.anblicks.pdca.model.achivementFormula achivementFormula) {
		return _achivementFormula.compareTo(achivementFormula);
	}

	@Override
	public int hashCode() {
		return _achivementFormula.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _achivementFormula.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new achivementFormulaWrapper((achivementFormula)_achivementFormula.clone());
	}

	/**
	* Returns the achivement formula of this achivement formula.
	*
	* @return the achivement formula of this achivement formula
	*/
	@Override
	public java.lang.String getAchivementFormula() {
		return _achivementFormula.getAchivementFormula();
	}

	/**
	* Returns the uuid of this achivement formula.
	*
	* @return the uuid of this achivement formula
	*/
	@Override
	public java.lang.String getUuid() {
		return _achivementFormula.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _achivementFormula.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _achivementFormula.toXmlString();
	}

	/**
	* Returns the achivement formula ID of this achivement formula.
	*
	* @return the achivement formula ID of this achivement formula
	*/
	@Override
	public long getAchivementFormulaId() {
		return _achivementFormula.getAchivementFormulaId();
	}

	/**
	* Returns the item description ID of this achivement formula.
	*
	* @return the item description ID of this achivement formula
	*/
	@Override
	public long getItemDescriptionId() {
		return _achivementFormula.getItemDescriptionId();
	}

	/**
	* Returns the primary key of this achivement formula.
	*
	* @return the primary key of this achivement formula
	*/
	@Override
	public long getPrimaryKey() {
		return _achivementFormula.getPrimaryKey();
	}

	@Override
	public void persist() {
		_achivementFormula.persist();
	}

	/**
	* Sets the achivement formula of this achivement formula.
	*
	* @param achivementFormula the achivement formula of this achivement formula
	*/
	@Override
	public void setAchivementFormula(java.lang.String achivementFormula) {
		_achivementFormula.setAchivementFormula(achivementFormula);
	}

	/**
	* Sets the achivement formula ID of this achivement formula.
	*
	* @param achivementFormulaId the achivement formula ID of this achivement formula
	*/
	@Override
	public void setAchivementFormulaId(long achivementFormulaId) {
		_achivementFormula.setAchivementFormulaId(achivementFormulaId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_achivementFormula.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_achivementFormula.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_achivementFormula.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_achivementFormula.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the item description ID of this achivement formula.
	*
	* @param itemDescriptionId the item description ID of this achivement formula
	*/
	@Override
	public void setItemDescriptionId(long itemDescriptionId) {
		_achivementFormula.setItemDescriptionId(itemDescriptionId);
	}

	@Override
	public void setNew(boolean n) {
		_achivementFormula.setNew(n);
	}

	/**
	* Sets the primary key of this achivement formula.
	*
	* @param primaryKey the primary key of this achivement formula
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_achivementFormula.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_achivementFormula.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this achivement formula.
	*
	* @param uuid the uuid of this achivement formula
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_achivementFormula.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof achivementFormulaWrapper)) {
			return false;
		}

		achivementFormulaWrapper achivementFormulaWrapper = (achivementFormulaWrapper)obj;

		if (Objects.equals(_achivementFormula,
					achivementFormulaWrapper._achivementFormula)) {
			return true;
		}

		return false;
	}

	@Override
	public achivementFormula getWrappedModel() {
		return _achivementFormula;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _achivementFormula.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _achivementFormula.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_achivementFormula.resetOriginalValues();
	}

	private final achivementFormula _achivementFormula;
}