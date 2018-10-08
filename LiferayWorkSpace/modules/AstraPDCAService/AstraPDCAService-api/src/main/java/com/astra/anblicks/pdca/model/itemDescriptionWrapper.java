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
 * This class is a wrapper for {@link itemDescription}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see itemDescription
 * @generated
 */
@ProviderType
public class itemDescriptionWrapper implements itemDescription,
	ModelWrapper<itemDescription> {
	public itemDescriptionWrapper(itemDescription itemDescription) {
		_itemDescription = itemDescription;
	}

	@Override
	public Class<?> getModelClass() {
		return itemDescription.class;
	}

	@Override
	public String getModelClassName() {
		return itemDescription.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("itemDescriptionId", getItemDescriptionId());
		attributes.put("itemDescriptionName", getItemDescriptionName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long itemDescriptionId = (Long)attributes.get("itemDescriptionId");

		if (itemDescriptionId != null) {
			setItemDescriptionId(itemDescriptionId);
		}

		String itemDescriptionName = (String)attributes.get(
				"itemDescriptionName");

		if (itemDescriptionName != null) {
			setItemDescriptionName(itemDescriptionName);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _itemDescription.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _itemDescription.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _itemDescription.isNew();
	}

	@Override
	public com.astra.anblicks.pdca.model.itemDescription toEscapedModel() {
		return new itemDescriptionWrapper(_itemDescription.toEscapedModel());
	}

	@Override
	public com.astra.anblicks.pdca.model.itemDescription toUnescapedModel() {
		return new itemDescriptionWrapper(_itemDescription.toUnescapedModel());
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _itemDescription.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.astra.anblicks.pdca.model.itemDescription> toCacheModel() {
		return _itemDescription.toCacheModel();
	}

	@Override
	public int compareTo(
		com.astra.anblicks.pdca.model.itemDescription itemDescription) {
		return _itemDescription.compareTo(itemDescription);
	}

	@Override
	public int hashCode() {
		return _itemDescription.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemDescription.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new itemDescriptionWrapper((itemDescription)_itemDescription.clone());
	}

	/**
	* Returns the item description name of this item description.
	*
	* @return the item description name of this item description
	*/
	@Override
	public java.lang.String getItemDescriptionName() {
		return _itemDescription.getItemDescriptionName();
	}

	/**
	* Returns the uuid of this item description.
	*
	* @return the uuid of this item description
	*/
	@Override
	public java.lang.String getUuid() {
		return _itemDescription.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _itemDescription.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _itemDescription.toXmlString();
	}

	/**
	* Returns the item description ID of this item description.
	*
	* @return the item description ID of this item description
	*/
	@Override
	public long getItemDescriptionId() {
		return _itemDescription.getItemDescriptionId();
	}

	/**
	* Returns the primary key of this item description.
	*
	* @return the primary key of this item description
	*/
	@Override
	public long getPrimaryKey() {
		return _itemDescription.getPrimaryKey();
	}

	@Override
	public void persist() {
		_itemDescription.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_itemDescription.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_itemDescription.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_itemDescription.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_itemDescription.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the item description ID of this item description.
	*
	* @param itemDescriptionId the item description ID of this item description
	*/
	@Override
	public void setItemDescriptionId(long itemDescriptionId) {
		_itemDescription.setItemDescriptionId(itemDescriptionId);
	}

	/**
	* Sets the item description name of this item description.
	*
	* @param itemDescriptionName the item description name of this item description
	*/
	@Override
	public void setItemDescriptionName(java.lang.String itemDescriptionName) {
		_itemDescription.setItemDescriptionName(itemDescriptionName);
	}

	@Override
	public void setNew(boolean n) {
		_itemDescription.setNew(n);
	}

	/**
	* Sets the primary key of this item description.
	*
	* @param primaryKey the primary key of this item description
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_itemDescription.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_itemDescription.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this item description.
	*
	* @param uuid the uuid of this item description
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_itemDescription.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof itemDescriptionWrapper)) {
			return false;
		}

		itemDescriptionWrapper itemDescriptionWrapper = (itemDescriptionWrapper)obj;

		if (Objects.equals(_itemDescription,
					itemDescriptionWrapper._itemDescription)) {
			return true;
		}

		return false;
	}

	@Override
	public itemDescription getWrappedModel() {
		return _itemDescription;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _itemDescription.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _itemDescription.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_itemDescription.resetOriginalValues();
	}

	private final itemDescription _itemDescription;
}