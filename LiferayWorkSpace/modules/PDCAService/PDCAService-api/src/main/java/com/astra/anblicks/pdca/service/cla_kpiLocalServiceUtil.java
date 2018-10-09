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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for cla_kpi. This utility wraps
 * {@link com.astra.anblicks.pdca.service.impl.cla_kpiLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see cla_kpiLocalService
 * @see com.astra.anblicks.pdca.service.base.cla_kpiLocalServiceBaseImpl
 * @see com.astra.anblicks.pdca.service.impl.cla_kpiLocalServiceImpl
 * @generated
 */
@ProviderType
public class cla_kpiLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.astra.anblicks.pdca.service.impl.cla_kpiLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cla_kpi to the database. Also notifies the appropriate model listeners.
	*
	* @param cla_kpi the cla_kpi
	* @return the cla_kpi that was added
	*/
	public static com.astra.anblicks.pdca.model.cla_kpi addcla_kpi(
		com.astra.anblicks.pdca.model.cla_kpi cla_kpi) {
		return getService().addcla_kpi(cla_kpi);
	}

	/**
	* Creates a new cla_kpi with the primary key. Does not add the cla_kpi to the database.
	*
	* @param claKpiId the primary key for the new cla_kpi
	* @return the new cla_kpi
	*/
	public static com.astra.anblicks.pdca.model.cla_kpi createcla_kpi(
		long claKpiId) {
		return getService().createcla_kpi(claKpiId);
	}

	/**
	* Deletes the cla_kpi from the database. Also notifies the appropriate model listeners.
	*
	* @param cla_kpi the cla_kpi
	* @return the cla_kpi that was removed
	*/
	public static com.astra.anblicks.pdca.model.cla_kpi deletecla_kpi(
		com.astra.anblicks.pdca.model.cla_kpi cla_kpi) {
		return getService().deletecla_kpi(cla_kpi);
	}

	/**
	* Deletes the cla_kpi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param claKpiId the primary key of the cla_kpi
	* @return the cla_kpi that was removed
	* @throws PortalException if a cla_kpi with the primary key could not be found
	*/
	public static com.astra.anblicks.pdca.model.cla_kpi deletecla_kpi(
		long claKpiId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletecla_kpi(claKpiId);
	}

	public static com.astra.anblicks.pdca.model.cla_kpi fetchcla_kpi(
		long claKpiId) {
		return getService().fetchcla_kpi(claKpiId);
	}

	/**
	* Returns the cla_kpi with the primary key.
	*
	* @param claKpiId the primary key of the cla_kpi
	* @return the cla_kpi
	* @throws PortalException if a cla_kpi with the primary key could not be found
	*/
	public static com.astra.anblicks.pdca.model.cla_kpi getcla_kpi(
		long claKpiId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getcla_kpi(claKpiId);
	}

	/**
	* Updates the cla_kpi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cla_kpi the cla_kpi
	* @return the cla_kpi that was updated
	*/
	public static com.astra.anblicks.pdca.model.cla_kpi updatecla_kpi(
		com.astra.anblicks.pdca.model.cla_kpi cla_kpi) {
		return getService().updatecla_kpi(cla_kpi);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of cla_kpis.
	*
	* @return the number of cla_kpis
	*/
	public static int getcla_kpisCount() {
		return getService().getcla_kpisCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
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
	public static java.util.List<com.astra.anblicks.pdca.model.cla_kpi> getcla_kpis(
		int start, int end) {
		return getService().getcla_kpis(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static cla_kpiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<cla_kpiLocalService, cla_kpiLocalService> _serviceTracker =
		ServiceTrackerFactory.open(cla_kpiLocalService.class);
}