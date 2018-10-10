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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.test.exception.NoSuchtestableException;

import com.test.model.testable;

/**
 * The persistence interface for the testable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.test.service.persistence.impl.testablePersistenceImpl
 * @see testableUtil
 * @generated
 */
@ProviderType
public interface testablePersistence extends BasePersistence<testable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link testableUtil} to access the testable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the testable in the entity cache if it is enabled.
	*
	* @param testable the testable
	*/
	public void cacheResult(testable testable);

	/**
	* Caches the testables in the entity cache if it is enabled.
	*
	* @param testables the testables
	*/
	public void cacheResult(java.util.List<testable> testables);

	/**
	* Creates a new testable with the primary key. Does not add the testable to the database.
	*
	* @param aid the primary key for the new testable
	* @return the new testable
	*/
	public testable create(int aid);

	/**
	* Removes the testable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aid the primary key of the testable
	* @return the testable that was removed
	* @throws NoSuchtestableException if a testable with the primary key could not be found
	*/
	public testable remove(int aid) throws NoSuchtestableException;

	public testable updateImpl(testable testable);

	/**
	* Returns the testable with the primary key or throws a {@link NoSuchtestableException} if it could not be found.
	*
	* @param aid the primary key of the testable
	* @return the testable
	* @throws NoSuchtestableException if a testable with the primary key could not be found
	*/
	public testable findByPrimaryKey(int aid) throws NoSuchtestableException;

	/**
	* Returns the testable with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param aid the primary key of the testable
	* @return the testable, or <code>null</code> if a testable with the primary key could not be found
	*/
	public testable fetchByPrimaryKey(int aid);

	@Override
	public java.util.Map<java.io.Serializable, testable> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the testables.
	*
	* @return the testables
	*/
	public java.util.List<testable> findAll();

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
	public java.util.List<testable> findAll(int start, int end);

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
	public java.util.List<testable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<testable> orderByComparator);

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
	public java.util.List<testable> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<testable> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the testables from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of testables.
	*
	* @return the number of testables
	*/
	public int countAll();
}