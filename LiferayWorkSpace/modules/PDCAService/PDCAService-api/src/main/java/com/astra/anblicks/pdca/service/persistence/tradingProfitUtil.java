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

import com.astra.anblicks.pdca.model.tradingProfit;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the trading profit service. This utility wraps {@link com.astra.anblicks.pdca.service.persistence.impl.tradingProfitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see tradingProfitPersistence
 * @see com.astra.anblicks.pdca.service.persistence.impl.tradingProfitPersistenceImpl
 * @generated
 */
@ProviderType
public class tradingProfitUtil {
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
	public static void clearCache(tradingProfit tradingProfit) {
		getPersistence().clearCache(tradingProfit);
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
	public static List<tradingProfit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<tradingProfit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<tradingProfit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<tradingProfit> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static tradingProfit update(tradingProfit tradingProfit) {
		return getPersistence().update(tradingProfit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static tradingProfit update(tradingProfit tradingProfit,
		ServiceContext serviceContext) {
		return getPersistence().update(tradingProfit, serviceContext);
	}

	/**
	* Returns all the trading profits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching trading profits
	*/
	public static List<tradingProfit> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the trading profits where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of trading profits
	* @param end the upper bound of the range of trading profits (not inclusive)
	* @return the range of matching trading profits
	*/
	public static List<tradingProfit> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the trading profits where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of trading profits
	* @param end the upper bound of the range of trading profits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trading profits
	*/
	public static List<tradingProfit> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<tradingProfit> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the trading profits where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of trading profits
	* @param end the upper bound of the range of trading profits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching trading profits
	*/
	public static List<tradingProfit> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<tradingProfit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first trading profit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trading profit
	* @throws NoSuchtradingProfitException if a matching trading profit could not be found
	*/
	public static tradingProfit findByUuid_First(java.lang.String uuid,
		OrderByComparator<tradingProfit> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchtradingProfitException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first trading profit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trading profit, or <code>null</code> if a matching trading profit could not be found
	*/
	public static tradingProfit fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<tradingProfit> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last trading profit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trading profit
	* @throws NoSuchtradingProfitException if a matching trading profit could not be found
	*/
	public static tradingProfit findByUuid_Last(java.lang.String uuid,
		OrderByComparator<tradingProfit> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchtradingProfitException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last trading profit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trading profit, or <code>null</code> if a matching trading profit could not be found
	*/
	public static tradingProfit fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<tradingProfit> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the trading profits before and after the current trading profit in the ordered set where uuid = &#63;.
	*
	* @param tradingProfitId the primary key of the current trading profit
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trading profit
	* @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	*/
	public static tradingProfit[] findByUuid_PrevAndNext(long tradingProfitId,
		java.lang.String uuid,
		OrderByComparator<tradingProfit> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchtradingProfitException {
		return getPersistence()
				   .findByUuid_PrevAndNext(tradingProfitId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the trading profits where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of trading profits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching trading profits
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the trading profits where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching trading profits
	*/
	public static List<tradingProfit> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the trading profits where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of trading profits
	* @param end the upper bound of the range of trading profits (not inclusive)
	* @return the range of matching trading profits
	*/
	public static List<tradingProfit> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the trading profits where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of trading profits
	* @param end the upper bound of the range of trading profits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trading profits
	*/
	public static List<tradingProfit> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<tradingProfit> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the trading profits where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of trading profits
	* @param end the upper bound of the range of trading profits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching trading profits
	*/
	public static List<tradingProfit> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<tradingProfit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trading profit
	* @throws NoSuchtradingProfitException if a matching trading profit could not be found
	*/
	public static tradingProfit findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<tradingProfit> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchtradingProfitException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trading profit, or <code>null</code> if a matching trading profit could not be found
	*/
	public static tradingProfit fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<tradingProfit> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trading profit
	* @throws NoSuchtradingProfitException if a matching trading profit could not be found
	*/
	public static tradingProfit findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<tradingProfit> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchtradingProfitException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trading profit, or <code>null</code> if a matching trading profit could not be found
	*/
	public static tradingProfit fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<tradingProfit> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the trading profits before and after the current trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param tradingProfitId the primary key of the current trading profit
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trading profit
	* @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	*/
	public static tradingProfit[] findByUuid_C_PrevAndNext(
		long tradingProfitId, java.lang.String uuid, long companyId,
		OrderByComparator<tradingProfit> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchtradingProfitException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(tradingProfitId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the trading profits where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of trading profits where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching trading profits
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Caches the trading profit in the entity cache if it is enabled.
	*
	* @param tradingProfit the trading profit
	*/
	public static void cacheResult(tradingProfit tradingProfit) {
		getPersistence().cacheResult(tradingProfit);
	}

	/**
	* Caches the trading profits in the entity cache if it is enabled.
	*
	* @param tradingProfits the trading profits
	*/
	public static void cacheResult(List<tradingProfit> tradingProfits) {
		getPersistence().cacheResult(tradingProfits);
	}

	/**
	* Creates a new trading profit with the primary key. Does not add the trading profit to the database.
	*
	* @param tradingProfitId the primary key for the new trading profit
	* @return the new trading profit
	*/
	public static tradingProfit create(long tradingProfitId) {
		return getPersistence().create(tradingProfitId);
	}

	/**
	* Removes the trading profit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tradingProfitId the primary key of the trading profit
	* @return the trading profit that was removed
	* @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	*/
	public static tradingProfit remove(long tradingProfitId)
		throws com.astra.anblicks.pdca.exception.NoSuchtradingProfitException {
		return getPersistence().remove(tradingProfitId);
	}

	public static tradingProfit updateImpl(tradingProfit tradingProfit) {
		return getPersistence().updateImpl(tradingProfit);
	}

	/**
	* Returns the trading profit with the primary key or throws a {@link NoSuchtradingProfitException} if it could not be found.
	*
	* @param tradingProfitId the primary key of the trading profit
	* @return the trading profit
	* @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	*/
	public static tradingProfit findByPrimaryKey(long tradingProfitId)
		throws com.astra.anblicks.pdca.exception.NoSuchtradingProfitException {
		return getPersistence().findByPrimaryKey(tradingProfitId);
	}

	/**
	* Returns the trading profit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tradingProfitId the primary key of the trading profit
	* @return the trading profit, or <code>null</code> if a trading profit with the primary key could not be found
	*/
	public static tradingProfit fetchByPrimaryKey(long tradingProfitId) {
		return getPersistence().fetchByPrimaryKey(tradingProfitId);
	}

	public static java.util.Map<java.io.Serializable, tradingProfit> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the trading profits.
	*
	* @return the trading profits
	*/
	public static List<tradingProfit> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the trading profits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of trading profits
	* @param end the upper bound of the range of trading profits (not inclusive)
	* @return the range of trading profits
	*/
	public static List<tradingProfit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the trading profits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of trading profits
	* @param end the upper bound of the range of trading profits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of trading profits
	*/
	public static List<tradingProfit> findAll(int start, int end,
		OrderByComparator<tradingProfit> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the trading profits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of trading profits
	* @param end the upper bound of the range of trading profits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of trading profits
	*/
	public static List<tradingProfit> findAll(int start, int end,
		OrderByComparator<tradingProfit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the trading profits from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of trading profits.
	*
	* @return the number of trading profits
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static tradingProfitPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<tradingProfitPersistence, tradingProfitPersistence> _serviceTracker =
		ServiceTrackerFactory.open(tradingProfitPersistence.class);
}