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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link testable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see testable
 * @generated
 */
@ProviderType
public class testableWrapper implements testable, ModelWrapper<testable> {
	public testableWrapper(testable testable) {
		_testable = testable;
	}

	@Override
	public Class<?> getModelClass() {
		return testable.class;
	}

	@Override
	public String getModelClassName() {
		return testable.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("aid", getAid());
		attributes.put("aname", getAname());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer aid = (Integer)attributes.get("aid");

		if (aid != null) {
			setAid(aid);
		}

		String aname = (String)attributes.get("aname");

		if (aname != null) {
			setAname(aname);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _testable.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _testable.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _testable.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _testable.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.test.model.testable> toCacheModel() {
		return _testable.toCacheModel();
	}

	@Override
	public com.test.model.testable toEscapedModel() {
		return new testableWrapper(_testable.toEscapedModel());
	}

	@Override
	public com.test.model.testable toUnescapedModel() {
		return new testableWrapper(_testable.toUnescapedModel());
	}

	@Override
	public int compareTo(com.test.model.testable testable) {
		return _testable.compareTo(testable);
	}

	/**
	* Returns the aid of this testable.
	*
	* @return the aid of this testable
	*/
	@Override
	public int getAid() {
		return _testable.getAid();
	}

	/**
	* Returns the primary key of this testable.
	*
	* @return the primary key of this testable
	*/
	@Override
	public int getPrimaryKey() {
		return _testable.getPrimaryKey();
	}

	@Override
	public int hashCode() {
		return _testable.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _testable.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new testableWrapper((testable)_testable.clone());
	}

	/**
	* Returns the aname of this testable.
	*
	* @return the aname of this testable
	*/
	@Override
	public java.lang.String getAname() {
		return _testable.getAname();
	}

	@Override
	public java.lang.String toString() {
		return _testable.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _testable.toXmlString();
	}

	@Override
	public void persist() {
		_testable.persist();
	}

	/**
	* Sets the aid of this testable.
	*
	* @param aid the aid of this testable
	*/
	@Override
	public void setAid(int aid) {
		_testable.setAid(aid);
	}

	/**
	* Sets the aname of this testable.
	*
	* @param aname the aname of this testable
	*/
	@Override
	public void setAname(java.lang.String aname) {
		_testable.setAname(aname);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_testable.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_testable.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_testable.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_testable.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_testable.setNew(n);
	}

	/**
	* Sets the primary key of this testable.
	*
	* @param primaryKey the primary key of this testable
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_testable.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_testable.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof testableWrapper)) {
			return false;
		}

		testableWrapper testableWrapper = (testableWrapper)obj;

		if (Objects.equals(_testable, testableWrapper._testable)) {
			return true;
		}

		return false;
	}

	@Override
	public testable getWrappedModel() {
		return _testable;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _testable.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _testable.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_testable.resetOriginalValues();
	}

	private final testable _testable;
}