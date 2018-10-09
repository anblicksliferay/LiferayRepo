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

package com.astra.anblicks.pdca.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.astra.anblicks.pdca.model.itemDescription;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the item description service. This utility wraps {@link com.astra.anblicks.pdca.service.persistence.impl.itemDescriptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see itemDescriptionPersistence
 * @see com.astra.anblicks.pdca.service.persistence.impl.itemDescriptionPersistenceImpl
 * @generated
 */
@ProviderType
public class itemDescriptionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(itemDescription itemDescription) {
		getPersistence().clearCache(itemDescription);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<itemDescription> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<itemDescription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<itemDescription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<itemDescription> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static itemDescription update(itemDescription itemDescription) {
		return getPersistence().update(itemDescription);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static itemDescription update(itemDescription itemDescription,
		ServiceContext serviceContext) {
		return getPersistence().update(itemDescription, serviceContext);
	}

	/**
	* Returns all the item descriptions where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching item descriptions
	*/
	public static List<itemDescription> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the item descriptions where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of item descriptions
	* @param end the upper bound of the range of item descriptions (not inclusive)
	* @return the range of matching item descriptions
	*/
	public static List<itemDescription> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the item descriptions where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of item descriptions
	* @param end the upper bound of the range of item descriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching item descriptions
	*/
	public static List<itemDescription> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<itemDescription> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the item descriptions where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of item descriptions
	* @param end the upper bound of the range of item descriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching item descriptions
	*/
	public static List<itemDescription> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<itemDescription> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first item description in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item description
	* @throws NoSuchitemDescriptionException if a matching item description could not be found
	*/
	public static itemDescription findByUuid_First(java.lang.String uuid,
		OrderByComparator<itemDescription> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchitemDescriptionException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first item description in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item description, or <code>null</code> if a matching item description could not be found
	*/
	public static itemDescription fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<itemDescription> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last item description in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item description
	* @throws NoSuchitemDescriptionException if a matching item description could not be found
	*/
	public static itemDescription findByUuid_Last(java.lang.String uuid,
		OrderByComparator<itemDescription> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchitemDescriptionException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last item description in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item description, or <code>null</code> if a matching item description could not be found
	*/
	public static itemDescription fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<itemDescription> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the item descriptions before and after the current item description in the ordered set where uuid = &#63;.
	*
	* @param itemDescriptionId the primary key of the current item description
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item description
	* @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	*/
	public static itemDescription[] findByUuid_PrevAndNext(
		long itemDescriptionId, java.lang.String uuid,
		OrderByComparator<itemDescription> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchitemDescriptionException {
		return getPersistence()
				   .findByUuid_PrevAndNext(itemDescriptionId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the item descriptions where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of item descriptions where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching item descriptions
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the item description in the entity cache if it is enabled.
	*
	* @param itemDescription the item description
	*/
	public static void cacheResult(itemDescription itemDescription) {
		getPersistence().cacheResult(itemDescription);
	}

	/**
	* Caches the item descriptions in the entity cache if it is enabled.
	*
	* @param itemDescriptions the item descriptions
	*/
	public static void cacheResult(List<itemDescription> itemDescriptions) {
		getPersistence().cacheResult(itemDescriptions);
	}

	/**
	* Creates a new item description with the primary key. Does not add the item description to the database.
	*
	* @param itemDescriptionId the primary key for the new item description
	* @return the new item description
	*/
	public static itemDescription create(long itemDescriptionId) {
		return getPersistence().create(itemDescriptionId);
	}

	/**
	* Removes the item description with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemDescriptionId the primary key of the item description
	* @return the item description that was removed
	* @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	*/
	public static itemDescription remove(long itemDescriptionId)
		throws com.astra.anblicks.pdca.exception.NoSuchitemDescriptionException {
		return getPersistence().remove(itemDescriptionId);
	}

	public static itemDescription updateImpl(itemDescription itemDescription) {
		return getPersistence().updateImpl(itemDescription);
	}

	/**
	* Returns the item description with the primary key or throws a {@link NoSuchitemDescriptionException} if it could not be found.
	*
	* @param itemDescriptionId the primary key of the item description
	* @return the item description
	* @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	*/
	public static itemDescription findByPrimaryKey(long itemDescriptionId)
		throws com.astra.anblicks.pdca.exception.NoSuchitemDescriptionException {
		return getPersistence().findByPrimaryKey(itemDescriptionId);
	}

	/**
	* Returns the item description with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemDescriptionId the primary key of the item description
	* @return the item description, or <code>null</code> if a item description with the primary key could not be found
	*/
	public static itemDescription fetchByPrimaryKey(long itemDescriptionId) {
		return getPersistence().fetchByPrimaryKey(itemDescriptionId);
	}

	public static java.util.Map<java.io.Serializable, itemDescription> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the item descriptions.
	*
	* @return the item descriptions
	*/
	public static List<itemDescription> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the item descriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item descriptions
	* @param end the upper bound of the range of item descriptions (not inclusive)
	* @return the range of item descriptions
	*/
	public static List<itemDescription> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the item descriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item descriptions
	* @param end the upper bound of the range of item descriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of item descriptions
	*/
	public static List<itemDescription> findAll(int start, int end,
		OrderByComparator<itemDescription> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the item descriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of item descriptions
	* @param end the upper bound of the range of item descriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of item descriptions
	*/
	public static List<itemDescription> findAll(int start, int end,
		OrderByComparator<itemDescription> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the item descriptions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of item descriptions.
	*
	* @return the number of item descriptions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static itemDescriptionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<itemDescriptionPersistence, itemDescriptionPersistence> _serviceTracker =
		ServiceTrackerFactory.open(itemDescriptionPersistence.class);
}