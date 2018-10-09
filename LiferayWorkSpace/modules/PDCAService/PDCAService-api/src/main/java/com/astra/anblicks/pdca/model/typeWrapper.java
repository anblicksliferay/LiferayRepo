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
 * This class is a wrapper for {@link type}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see type
 * @generated
 */
@ProviderType
public class typeWrapper implements type, ModelWrapper<type> {
	public typeWrapper(type type) {
		_type = type;
	}

	@Override
	public Class<?> getModelClass() {
		return type.class;
	}

	@Override
	public String getModelClassName() {
		return type.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("typeId", getTypeId());
		attributes.put("typeName", getTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String typeName = (String)attributes.get("typeName");

		if (typeName != null) {
			setTypeName(typeName);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _type.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _type.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _type.isNew();
	}

	@Override
	public com.astra.anblicks.pdca.model.type toEscapedModel() {
		return new typeWrapper(_type.toEscapedModel());
	}

	@Override
	public com.astra.anblicks.pdca.model.type toUnescapedModel() {
		return new typeWrapper(_type.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _type.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.astra.anblicks.pdca.model.type> toCacheModel() {
		return _type.toCacheModel();
	}

	@Override
	public int compareTo(com.astra.anblicks.pdca.model.type type) {
		return _type.compareTo(type);
	}

	@Override
	public int hashCode() {
		return _type.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _type.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new typeWrapper((type)_type.clone());
	}

	/**
	* Returns the type name of this type.
	*
	* @return the type name of this type
	*/
	@Override
	public java.lang.String getTypeName() {
		return _type.getTypeName();
	}

	/**
	* Returns the uuid of this type.
	*
	* @return the uuid of this type
	*/
	@Override
	public java.lang.String getUuid() {
		return _type.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _type.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _type.toXmlString();
	}

	/**
	* Returns the primary key of this type.
	*
	* @return the primary key of this type
	*/
	@Override
	public long getPrimaryKey() {
		return _type.getPrimaryKey();
	}

	/**
	* Returns the type ID of this type.
	*
	* @return the type ID of this type
	*/
	@Override
	public long getTypeId() {
		return _type.getTypeId();
	}

	@Override
	public void persist() {
		_type.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_type.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_type.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_type.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_type.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_type.setNew(n);
	}

	/**
	* Sets the primary key of this type.
	*
	* @param primaryKey the primary key of this type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_type.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_type.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type ID of this type.
	*
	* @param typeId the type ID of this type
	*/
	@Override
	public void setTypeId(long typeId) {
		_type.setTypeId(typeId);
	}

	/**
	* Sets the type name of this type.
	*
	* @param typeName the type name of this type
	*/
	@Override
	public void setTypeName(java.lang.String typeName) {
		_type.setTypeName(typeName);
	}

	/**
	* Sets the uuid of this type.
	*
	* @param uuid the uuid of this type
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_type.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof typeWrapper)) {
			return false;
		}

		typeWrapper typeWrapper = (typeWrapper)obj;

		if (Objects.equals(_type, typeWrapper._type)) {
			return true;
		}

		return false;
	}

	@Override
	public type getWrappedModel() {
		return _type;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _type.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _type.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_type.resetOriginalValues();
	}

	private final type _type;
}