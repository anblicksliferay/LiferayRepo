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

import com.astra.anblicks.pdca.exception.NoSuchperiodException;
import com.astra.anblicks.pdca.model.period;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.persistence.impl.periodPersistenceImpl
 * @see periodUtil
 * @generated
 */
@ProviderType
public interface periodPersistence extends BasePersistence<period> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link periodUtil} to access the period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the periods where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching periods
	*/
	public java.util.List<period> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the periods where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link periodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of periods
	* @param end the upper bound of the range of periods (not inclusive)
	* @return the range of matching periods
	*/
	public java.util.List<period> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the periods where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link periodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of periods
	* @param end the upper bound of the range of periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching periods
	*/
	public java.util.List<period> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<period> orderByComparator);

	/**
	* Returns an ordered range of all the periods where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link periodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of periods
	* @param end the upper bound of the range of periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching periods
	*/
	public java.util.List<period> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<period> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first period in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching period
	* @throws NoSuchperiodException if a matching period could not be found
	*/
	public period findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<period> orderByComparator)
		throws NoSuchperiodException;

	/**
	* Returns the first period in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching period, or <code>null</code> if a matching period could not be found
	*/
	public period fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<period> orderByComparator);

	/**
	* Returns the last period in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching period
	* @throws NoSuchperiodException if a matching period could not be found
	*/
	public period findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<period> orderByComparator)
		throws NoSuchperiodException;

	/**
	* Returns the last period in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching period, or <code>null</code> if a matching period could not be found
	*/
	public period fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<period> orderByComparator);

	/**
	* Returns the periods before and after the current period in the ordered set where uuid = &#63;.
	*
	* @param periodId the primary key of the current period
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next period
	* @throws NoSuchperiodException if a period with the primary key could not be found
	*/
	public period[] findByUuid_PrevAndNext(long periodId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<period> orderByComparator)
		throws NoSuchperiodException;

	/**
	* Removes all the periods where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of periods where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching periods
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the period in the entity cache if it is enabled.
	*
	* @param period the period
	*/
	public void cacheResult(period period);

	/**
	* Caches the periods in the entity cache if it is enabled.
	*
	* @param periods the periods
	*/
	public void cacheResult(java.util.List<period> periods);

	/**
	* Creates a new period with the primary key. Does not add the period to the database.
	*
	* @param periodId the primary key for the new period
	* @return the new period
	*/
	public period create(long periodId);

	/**
	* Removes the period with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param periodId the primary key of the period
	* @return the period that was removed
	* @throws NoSuchperiodException if a period with the primary key could not be found
	*/
	public period remove(long periodId) throws NoSuchperiodException;

	public period updateImpl(period period);

	/**
	* Returns the period with the primary key or throws a {@link NoSuchperiodException} if it could not be found.
	*
	* @param periodId the primary key of the period
	* @return the period
	* @throws NoSuchperiodException if a period with the primary key could not be found
	*/
	public period findByPrimaryKey(long periodId) throws NoSuchperiodException;

	/**
	* Returns the period with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param periodId the primary key of the period
	* @return the period, or <code>null</code> if a period with the primary key could not be found
	*/
	public period fetchByPrimaryKey(long periodId);

	@Override
	public java.util.Map<java.io.Serializable, period> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the periods.
	*
	* @return the periods
	*/
	public java.util.List<period> findAll();

	/**
	* Returns a range of all the periods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link periodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of periods
	* @param end the upper bound of the range of periods (not inclusive)
	* @return the range of periods
	*/
	public java.util.List<period> findAll(int start, int end);

	/**
	* Returns an ordered range of all the periods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link periodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of periods
	* @param end the upper bound of the range of periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of periods
	*/
	public java.util.List<period> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<period> orderByComparator);

	/**
	* Returns an ordered range of all the periods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link periodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of periods
	* @param end the upper bound of the range of periods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of periods
	*/
	public java.util.List<period> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<period> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the periods from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of periods.
	*
	* @return the number of periods
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}