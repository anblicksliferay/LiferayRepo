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

import com.astra.anblicks.pdca.exception.NoSuchachivementFormulaException;
import com.astra.anblicks.pdca.model.achivementFormula;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the achivement formula service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.persistence.impl.achivementFormulaPersistenceImpl
 * @see achivementFormulaUtil
 * @generated
 */
@ProviderType
public interface achivementFormulaPersistence extends BasePersistence<achivementFormula> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link achivementFormulaUtil} to access the achivement formula persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the achivement formulas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching achivement formulas
	*/
	public java.util.List<achivementFormula> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the achivement formulas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link achivementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of achivement formulas
	* @param end the upper bound of the range of achivement formulas (not inclusive)
	* @return the range of matching achivement formulas
	*/
	public java.util.List<achivementFormula> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the achivement formulas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link achivementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of achivement formulas
	* @param end the upper bound of the range of achivement formulas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching achivement formulas
	*/
	public java.util.List<achivementFormula> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<achivementFormula> orderByComparator);

	/**
	* Returns an ordered range of all the achivement formulas where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link achivementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of achivement formulas
	* @param end the upper bound of the range of achivement formulas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching achivement formulas
	*/
	public java.util.List<achivementFormula> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<achivementFormula> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first achivement formula in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching achivement formula
	* @throws NoSuchachivementFormulaException if a matching achivement formula could not be found
	*/
	public achivementFormula findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<achivementFormula> orderByComparator)
		throws NoSuchachivementFormulaException;

	/**
	* Returns the first achivement formula in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching achivement formula, or <code>null</code> if a matching achivement formula could not be found
	*/
	public achivementFormula fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<achivementFormula> orderByComparator);

	/**
	* Returns the last achivement formula in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching achivement formula
	* @throws NoSuchachivementFormulaException if a matching achivement formula could not be found
	*/
	public achivementFormula findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<achivementFormula> orderByComparator)
		throws NoSuchachivementFormulaException;

	/**
	* Returns the last achivement formula in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching achivement formula, or <code>null</code> if a matching achivement formula could not be found
	*/
	public achivementFormula fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<achivementFormula> orderByComparator);

	/**
	* Returns the achivement formulas before and after the current achivement formula in the ordered set where uuid = &#63;.
	*
	* @param achivementFormulaId the primary key of the current achivement formula
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next achivement formula
	* @throws NoSuchachivementFormulaException if a achivement formula with the primary key could not be found
	*/
	public achivementFormula[] findByUuid_PrevAndNext(
		long achivementFormulaId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<achivementFormula> orderByComparator)
		throws NoSuchachivementFormulaException;

	/**
	* Removes all the achivement formulas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of achivement formulas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching achivement formulas
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the achivement formula in the entity cache if it is enabled.
	*
	* @param achivementFormula the achivement formula
	*/
	public void cacheResult(achivementFormula achivementFormula);

	/**
	* Caches the achivement formulas in the entity cache if it is enabled.
	*
	* @param achivementFormulas the achivement formulas
	*/
	public void cacheResult(
		java.util.List<achivementFormula> achivementFormulas);

	/**
	* Creates a new achivement formula with the primary key. Does not add the achivement formula to the database.
	*
	* @param achivementFormulaId the primary key for the new achivement formula
	* @return the new achivement formula
	*/
	public achivementFormula create(long achivementFormulaId);

	/**
	* Removes the achivement formula with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param achivementFormulaId the primary key of the achivement formula
	* @return the achivement formula that was removed
	* @throws NoSuchachivementFormulaException if a achivement formula with the primary key could not be found
	*/
	public achivementFormula remove(long achivementFormulaId)
		throws NoSuchachivementFormulaException;

	public achivementFormula updateImpl(achivementFormula achivementFormula);

	/**
	* Returns the achivement formula with the primary key or throws a {@link NoSuchachivementFormulaException} if it could not be found.
	*
	* @param achivementFormulaId the primary key of the achivement formula
	* @return the achivement formula
	* @throws NoSuchachivementFormulaException if a achivement formula with the primary key could not be found
	*/
	public achivementFormula findByPrimaryKey(long achivementFormulaId)
		throws NoSuchachivementFormulaException;

	/**
	* Returns the achivement formula with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param achivementFormulaId the primary key of the achivement formula
	* @return the achivement formula, or <code>null</code> if a achivement formula with the primary key could not be found
	*/
	public achivementFormula fetchByPrimaryKey(long achivementFormulaId);

	@Override
	public java.util.Map<java.io.Serializable, achivementFormula> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the achivement formulas.
	*
	* @return the achivement formulas
	*/
	public java.util.List<achivementFormula> findAll();

	/**
	* Returns a range of all the achivement formulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link achivementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of achivement formulas
	* @param end the upper bound of the range of achivement formulas (not inclusive)
	* @return the range of achivement formulas
	*/
	public java.util.List<achivementFormula> findAll(int start, int end);

	/**
	* Returns an ordered range of all the achivement formulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link achivementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of achivement formulas
	* @param end the upper bound of the range of achivement formulas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of achivement formulas
	*/
	public java.util.List<achivementFormula> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<achivementFormula> orderByComparator);

	/**
	* Returns an ordered range of all the achivement formulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link achivementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of achivement formulas
	* @param end the upper bound of the range of achivement formulas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of achivement formulas
	*/
	public java.util.List<achivementFormula> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<achivementFormula> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the achivement formulas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of achivement formulas.
	*
	* @return the number of achivement formulas
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}