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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the type service. Represents a row in the &quot;astra_type&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.astra.anblicks.pdca.model.impl.typeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.astra.anblicks.pdca.model.impl.typeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see type
 * @see com.astra.anblicks.pdca.model.impl.typeImpl
 * @see com.astra.anblicks.pdca.model.impl.typeModelImpl
 * @generated
 */
@ProviderType
public interface typeModel extends BaseModel<type> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a type model instance should use the {@link type} interface instead.
	 */

	/**
	 * Returns the primary key of this type.
	 *
	 * @return the primary key of this type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this type.
	 *
	 * @param primaryKey the primary key of this type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this type.
	 *
	 * @return the uuid of this type
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this type.
	 *
	 * @param uuid the uuid of this type
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the type ID of this type.
	 *
	 * @return the type ID of this type
	 */
	public long getTypeId();

	/**
	 * Sets the type ID of this type.
	 *
	 * @param typeId the type ID of this type
	 */
	public void setTypeId(long typeId);

	/**
	 * Returns the type name of this type.
	 *
	 * @return the type name of this type
	 */
	@AutoEscape
	public String getTypeName();

	/**
	 * Sets the type name of this type.
	 *
	 * @param typeName the type name of this type
	 */
	public void setTypeName(String typeName);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.astra.anblicks.pdca.model.type type);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.astra.anblicks.pdca.model.type> toCacheModel();

	@Override
	public com.astra.anblicks.pdca.model.type toEscapedModel();

	@Override
	public com.astra.anblicks.pdca.model.type toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}