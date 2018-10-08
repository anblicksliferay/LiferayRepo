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

package com.astra.anblicks.pdca.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link cla_kpiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see cla_kpiLocalService
 * @generated
 */
@ProviderType
public class cla_kpiLocalServiceWrapper implements cla_kpiLocalService,
	ServiceWrapper<cla_kpiLocalService> {
	public cla_kpiLocalServiceWrapper(cla_kpiLocalService cla_kpiLocalService) {
		_cla_kpiLocalService = cla_kpiLocalService;
	}

	/**
	* Adds the cla_kpi to the database. Also notifies the appropriate model listeners.
	*
	* @param cla_kpi the cla_kpi
	* @return the cla_kpi that was added
	*/
	@Override
	public com.astra.anblicks.pdca.model.cla_kpi addcla_kpi(
		com.astra.anblicks.pdca.model.cla_kpi cla_kpi) {
		return _cla_kpiLocalService.addcla_kpi(cla_kpi);
	}

	/**
	* Creates a new cla_kpi with the primary key. Does not add the cla_kpi to the database.
	*
	* @param claKpiId the primary key for the new cla_kpi
	* @return the new cla_kpi
	*/
	@Override
	public com.astra.anblicks.pdca.model.cla_kpi createcla_kpi(long claKpiId) {
		return _cla_kpiLocalService.createcla_kpi(claKpiId);
	}

	/**
	* Deletes the cla_kpi from the database. Also notifies the appropriate model listeners.
	*
	* @param cla_kpi the cla_kpi
	* @return the cla_kpi that was removed
	*/
	@Override
	public com.astra.anblicks.pdca.model.cla_kpi deletecla_kpi(
		com.astra.anblicks.pdca.model.cla_kpi cla_kpi) {
		return _cla_kpiLocalService.deletecla_kpi(cla_kpi);
	}

	/**
	* Deletes the cla_kpi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param claKpiId the primary key of the cla_kpi
	* @return the cla_kpi that was removed
	* @throws PortalException if a cla_kpi with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.cla_kpi deletecla_kpi(long claKpiId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cla_kpiLocalService.deletecla_kpi(claKpiId);
	}

	@Override
	public com.astra.anblicks.pdca.model.cla_kpi fetchcla_kpi(long claKpiId) {
		return _cla_kpiLocalService.fetchcla_kpi(claKpiId);
	}

	/**
	* Returns the cla_kpi with the primary key.
	*
	* @param claKpiId the primary key of the cla_kpi
	* @return the cla_kpi
	* @throws PortalException if a cla_kpi with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.cla_kpi getcla_kpi(long claKpiId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cla_kpiLocalService.getcla_kpi(claKpiId);
	}

	/**
	* Updates the cla_kpi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cla_kpi the cla_kpi
	* @return the cla_kpi that was updated
	*/
	@Override
	public com.astra.anblicks.pdca.model.cla_kpi updatecla_kpi(
		com.astra.anblicks.pdca.model.cla_kpi cla_kpi) {
		return _cla_kpiLocalService.updatecla_kpi(cla_kpi);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _cla_kpiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cla_kpiLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _cla_kpiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cla_kpiLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cla_kpiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of cla_kpis.
	*
	* @return the number of cla_kpis
	*/
	@Override
	public int getcla_kpisCount() {
		return _cla_kpiLocalService.getcla_kpisCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _cla_kpiLocalService.getOSGiServiceIdentifier();
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
		return _cla_kpiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.cla_kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cla_kpiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.cla_kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _cla_kpiLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the cla_kpis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.cla_kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cla_kpis
	* @param end the upper bound of the range of cla_kpis (not inclusive)
	* @return the range of cla_kpis
	*/
	@Override
	public java.util.List<com.astra.anblicks.pdca.model.cla_kpi> getcla_kpis(
		int start, int end) {
		return _cla_kpiLocalService.getcla_kpis(start, end);
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
		return _cla_kpiLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cla_kpiLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public cla_kpiLocalService getWrappedService() {
		return _cla_kpiLocalService;
	}

	@Override
	public void setWrappedService(cla_kpiLocalService cla_kpiLocalService) {
		_cla_kpiLocalService = cla_kpiLocalService;
	}

	private cla_kpiLocalService _cla_kpiLocalService;
}