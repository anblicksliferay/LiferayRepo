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

import com.astra.anblicks.pdca.exception.NoSuchtradingProfitException;
import com.astra.anblicks.pdca.model.tradingProfit;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the trading profit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.persistence.impl.tradingProfitPersistenceImpl
 * @see tradingProfitUtil
 * @generated
 */
@ProviderType
public interface tradingProfitPersistence extends BasePersistence<tradingProfit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link tradingProfitUtil} to access the trading profit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the trading profits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching trading profits
	*/
	public java.util.List<tradingProfit> findByUuid(java.lang.String uuid);

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
	public java.util.List<tradingProfit> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<tradingProfit> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator);

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
	public java.util.List<tradingProfit> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first trading profit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trading profit
	* @throws NoSuchtradingProfitException if a matching trading profit could not be found
	*/
	public tradingProfit findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException;

	/**
	* Returns the first trading profit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trading profit, or <code>null</code> if a matching trading profit could not be found
	*/
	public tradingProfit fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator);

	/**
	* Returns the last trading profit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trading profit
	* @throws NoSuchtradingProfitException if a matching trading profit could not be found
	*/
	public tradingProfit findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException;

	/**
	* Returns the last trading profit in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trading profit, or <code>null</code> if a matching trading profit could not be found
	*/
	public tradingProfit fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator);

	/**
	* Returns the trading profits before and after the current trading profit in the ordered set where uuid = &#63;.
	*
	* @param tradingProfitId the primary key of the current trading profit
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trading profit
	* @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	*/
	public tradingProfit[] findByUuid_PrevAndNext(long tradingProfitId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException;

	/**
	* Removes all the trading profits where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of trading profits where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching trading profits
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the trading profits where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching trading profits
	*/
	public java.util.List<tradingProfit> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<tradingProfit> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<tradingProfit> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator);

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
	public java.util.List<tradingProfit> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trading profit
	* @throws NoSuchtradingProfitException if a matching trading profit could not be found
	*/
	public tradingProfit findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException;

	/**
	* Returns the first trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trading profit, or <code>null</code> if a matching trading profit could not be found
	*/
	public tradingProfit fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator);

	/**
	* Returns the last trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trading profit
	* @throws NoSuchtradingProfitException if a matching trading profit could not be found
	*/
	public tradingProfit findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException;

	/**
	* Returns the last trading profit in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trading profit, or <code>null</code> if a matching trading profit could not be found
	*/
	public tradingProfit fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator);

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
	public tradingProfit[] findByUuid_C_PrevAndNext(long tradingProfitId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator)
		throws NoSuchtradingProfitException;

	/**
	* Removes all the trading profits where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of trading profits where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching trading profits
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Caches the trading profit in the entity cache if it is enabled.
	*
	* @param tradingProfit the trading profit
	*/
	public void cacheResult(tradingProfit tradingProfit);

	/**
	* Caches the trading profits in the entity cache if it is enabled.
	*
	* @param tradingProfits the trading profits
	*/
	public void cacheResult(java.util.List<tradingProfit> tradingProfits);

	/**
	* Creates a new trading profit with the primary key. Does not add the trading profit to the database.
	*
	* @param tradingProfitId the primary key for the new trading profit
	* @return the new trading profit
	*/
	public tradingProfit create(long tradingProfitId);

	/**
	* Removes the trading profit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tradingProfitId the primary key of the trading profit
	* @return the trading profit that was removed
	* @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	*/
	public tradingProfit remove(long tradingProfitId)
		throws NoSuchtradingProfitException;

	public tradingProfit updateImpl(tradingProfit tradingProfit);

	/**
	* Returns the trading profit with the primary key or throws a {@link NoSuchtradingProfitException} if it could not be found.
	*
	* @param tradingProfitId the primary key of the trading profit
	* @return the trading profit
	* @throws NoSuchtradingProfitException if a trading profit with the primary key could not be found
	*/
	public tradingProfit findByPrimaryKey(long tradingProfitId)
		throws NoSuchtradingProfitException;

	/**
	* Returns the trading profit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tradingProfitId the primary key of the trading profit
	* @return the trading profit, or <code>null</code> if a trading profit with the primary key could not be found
	*/
	public tradingProfit fetchByPrimaryKey(long tradingProfitId);

	@Override
	public java.util.Map<java.io.Serializable, tradingProfit> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the trading profits.
	*
	* @return the trading profits
	*/
	public java.util.List<tradingProfit> findAll();

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
	public java.util.List<tradingProfit> findAll(int start, int end);

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
	public java.util.List<tradingProfit> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator);

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
	public java.util.List<tradingProfit> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<tradingProfit> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the trading profits from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of trading profits.
	*
	* @return the number of trading profits
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}