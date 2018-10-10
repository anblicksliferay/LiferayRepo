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

package com.test.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link testableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see testableLocalService
 * @generated
 */
@ProviderType
public class testableLocalServiceWrapper implements testableLocalService,
	ServiceWrapper<testableLocalService> {
	public testableLocalServiceWrapper(
		testableLocalService testableLocalService) {
		_testableLocalService = testableLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _testableLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _testableLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _testableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the testable to the database. Also notifies the appropriate model listeners.
	*
	* @param testable the testable
	* @return the testable that was added
	*/
	@Override
	public com.test.model.testable addtestable(com.test.model.testable testable) {
		return _testableLocalService.addtestable(testable);
	}

	/**
	* Creates a new testable with the primary key. Does not add the testable to the database.
	*
	* @param aid the primary key for the new testable
	* @return the new testable
	*/
	@Override
	public com.test.model.testable createtestable(int aid) {
		return _testableLocalService.createtestable(aid);
	}

	/**
	* Deletes the testable from the database. Also notifies the appropriate model listeners.
	*
	* @param testable the testable
	* @return the testable that was removed
	*/
	@Override
	public com.test.model.testable deletetestable(
		com.test.model.testable testable) {
		return _testableLocalService.deletetestable(testable);
	}

	/**
	* Deletes the testable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aid the primary key of the testable
	* @return the testable that was removed
	* @throws PortalException if a testable with the primary key could not be found
	*/
	@Override
	public com.test.model.testable deletetestable(int aid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testableLocalService.deletetestable(aid);
	}

	@Override
	public com.test.model.testable fetchtestable(int aid) {
		return _testableLocalService.fetchtestable(aid);
	}

	/**
	* Returns the testable with the primary key.
	*
	* @param aid the primary key of the testable
	* @return the testable
	* @throws PortalException if a testable with the primary key could not be found
	*/
	@Override
	public com.test.model.testable gettestable(int aid)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _testableLocalService.gettestable(aid);
	}

	/**
	* Updates the testable in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param testable the testable
	* @return the testable that was updated
	*/
	@Override
	public com.test.model.testable updatetestable(
		com.test.model.testable testable) {
		return _testableLocalService.updatetestable(testable);
	}

	/**
	* Returns the number of testables.
	*
	* @return the number of testables
	*/
	@Override
	public int gettestablesCount() {
		return _testableLocalService.gettestablesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _testableLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _testableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.model.impl.testableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _testableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.model.impl.testableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _testableLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the testables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.test.model.impl.testableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testables
	* @param end the upper bound of the range of testables (not inclusive)
	* @return the range of testables
	*/
	@Override
	public java.util.List<com.test.model.testable> gettestables(int start,
		int end) {
		return _testableLocalService.gettestables(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _testableLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _testableLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public testableLocalService getWrappedService() {
		return _testableLocalService;
	}

	@Override
	public void setWrappedService(testableLocalService testableLocalService) {
		_testableLocalService = testableLocalService;
	}

	private testableLocalService _testableLocalService;
}