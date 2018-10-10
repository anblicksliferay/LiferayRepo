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

package com.test.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.test.model.testable;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the testable service. This utility wraps {@link com.test.service.persistence.impl.testablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see testablePersistence
 * @see com.test.service.persistence.impl.testablePersistenceImpl
 * @generated
 */
@ProviderType
public class testableUtil {
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
	public static void clearCache(testable testable) {
		getPersistence().clearCache(testable);
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
	public static List<testable> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<testable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<testable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<testable> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static testable update(testable testable) {
		return getPersistence().update(testable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static testable update(testable testable,
		ServiceContext serviceContext) {
		return getPersistence().update(testable, serviceContext);
	}

	/**
	* Caches the testable in the entity cache if it is enabled.
	*
	* @param testable the testable
	*/
	public static void cacheResult(testable testable) {
		getPersistence().cacheResult(testable);
	}

	/**
	* Caches the testables in the entity cache if it is enabled.
	*
	* @param testables the testables
	*/
	public static void cacheResult(List<testable> testables) {
		getPersistence().cacheResult(testables);
	}

	/**
	* Creates a new testable with the primary key. Does not add the testable to the database.
	*
	* @param aid the primary key for the new testable
	* @return the new testable
	*/
	public static testable create(int aid) {
		return getPersistence().create(aid);
	}

	/**
	* Removes the testable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aid the primary key of the testable
	* @return the testable that was removed
	* @throws NoSuchtestableException if a testable with the primary key could not be found
	*/
	public static testable remove(int aid)
		throws com.test.exception.NoSuchtestableException {
		return getPersistence().remove(aid);
	}

	public static testable updateImpl(testable testable) {
		return getPersistence().updateImpl(testable);
	}

	/**
	* Returns the testable with the primary key or throws a {@link NoSuchtestableException} if it could not be found.
	*
	* @param aid the primary key of the testable
	* @return the testable
	* @throws NoSuchtestableException if a testable with the primary key could not be found
	*/
	public static testable findByPrimaryKey(int aid)
		throws com.test.exception.NoSuchtestableException {
		return getPersistence().findByPrimaryKey(aid);
	}

	/**
	* Returns the testable with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param aid the primary key of the testable
	* @return the testable, or <code>null</code> if a testable with the primary key could not be found
	*/
	public static testable fetchByPrimaryKey(int aid) {
		return getPersistence().fetchByPrimaryKey(aid);
	}

	public static java.util.Map<java.io.Serializable, testable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the testables.
	*
	* @return the testables
	*/
	public static List<testable> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the testables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link testableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testables
	* @param end the upper bound of the range of testables (not inclusive)
	* @return the range of testables
	*/
	public static List<testable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the testables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link testableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testables
	* @param end the upper bound of the range of testables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of testables
	*/
	public static List<testable> findAll(int start, int end,
		OrderByComparator<testable> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the testables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link testableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of testables
	* @param end the upper bound of the range of testables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of testables
	*/
	public static List<testable> findAll(int start, int end,
		OrderByComparator<testable> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the testables from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of testables.
	*
	* @return the number of testables
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static testablePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<testablePersistence, testablePersistence> _serviceTracker =
		ServiceTrackerFactory.open(testablePersistence.class);
}