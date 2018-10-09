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
 * Provides the local service utility for itemDescription. This utility wraps
 * {@link com.astra.anblicks.pdca.service.impl.itemDescriptionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see itemDescriptionLocalService
 * @see com.astra.anblicks.pdca.service.base.itemDescriptionLocalServiceBaseImpl
 * @see com.astra.anblicks.pdca.service.impl.itemDescriptionLocalServiceImpl
 * @generated
 */
@ProviderType
public class itemDescriptionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.astra.anblicks.pdca.service.impl.itemDescriptionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the item description to the database. Also notifies the appropriate model listeners.
	*
	* @param itemDescription the item description
	* @return the item description that was added
	*/
	public static com.astra.anblicks.pdca.model.itemDescription additemDescription(
		com.astra.anblicks.pdca.model.itemDescription itemDescription) {
		return getService().additemDescription(itemDescription);
	}

	/**
	* Creates a new item description with the primary key. Does not add the item description to the database.
	*
	* @param itemDescriptionId the primary key for the new item description
	* @return the new item description
	*/
	public static com.astra.anblicks.pdca.model.itemDescription createitemDescription(
		long itemDescriptionId) {
		return getService().createitemDescription(itemDescriptionId);
	}

	/**
	* Deletes the item description from the database. Also notifies the appropriate model listeners.
	*
	* @param itemDescription the item description
	* @return the item description that was removed
	*/
	public static com.astra.anblicks.pdca.model.itemDescription deleteitemDescription(
		com.astra.anblicks.pdca.model.itemDescription itemDescription) {
		return getService().deleteitemDescription(itemDescription);
	}

	/**
	* Deletes the item description with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemDescriptionId the primary key of the item description
	* @return the item description that was removed
	* @throws PortalException if a item description with the primary key could not be found
	*/
	public static com.astra.anblicks.pdca.model.itemDescription deleteitemDescription(
		long itemDescriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteitemDescription(itemDescriptionId);
	}

	public static com.astra.anblicks.pdca.model.itemDescription fetchitemDescription(
		long itemDescriptionId) {
		return getService().fetchitemDescription(itemDescriptionId);
	}

	/**
	* Returns the item description with the primary key.
	*
	* @param itemDescriptionId the primary key of the item description
	* @return the item description
	* @throws PortalException if a item description with the primary key could not be found
	*/
	public static com.astra.anblicks.pdca.model.itemDescription getitemDescription(
		long itemDescriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getitemDescription(itemDescriptionId);
	}

	/**
	* Updates the item description in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param itemDescription the item description
	* @return the item description that was updated
	*/
	public static com.astra.anblicks.pdca.model.itemDescription updateitemDescription(
		com.astra.anblicks.pdca.model.itemDescription itemDescription) {
		return getService().updateitemDescription(itemDescription);
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
	* Returns the number of item descriptions.
	*
	* @return the number of item descriptions
	*/
	public static int getitemDescriptionsCount() {
		return getService().getitemDescriptionsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the item descriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item descriptions
	* @param end the upper bound of the range of item descriptions (not inclusive)
	* @return the range of item descriptions
	*/
	public static java.util.List<com.astra.anblicks.pdca.model.itemDescription> getitemDescriptions(
		int start, int end) {
		return getService().getitemDescriptions(start, end);
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

	public static itemDescriptionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<itemDescriptionLocalService, itemDescriptionLocalService> _serviceTracker =
		ServiceTrackerFactory.open(itemDescriptionLocalService.class);
}