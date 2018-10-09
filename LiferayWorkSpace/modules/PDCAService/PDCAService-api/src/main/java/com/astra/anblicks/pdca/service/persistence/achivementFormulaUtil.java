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

import com.astra.anblicks.pdca.model.achivementFormula;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the achivement formula service. This utility wraps {@link com.astra.anblicks.pdca.service.persistence.impl.achivementFormulaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see achivementFormulaPersistence
 * @see com.astra.anblicks.pdca.service.persistence.impl.achivementFormulaPersistenceImpl
 * @generated
 */
@ProviderType
public class achivementFormulaUtil {
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
	public static void clearCache(achivementFormula achivementFormula) {
		getPersistence().clearCache(achivementFormula);
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
	public static List<achivementFormula> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<achivementFormula> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<achivementFormula> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<achivementFormula> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static achivementFormula update(achivementFormula achivementFormula) {
		return getPersistence().update(achivementFormula);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static achivementFormula update(
		achivementFormula achivementFormula, ServiceContext serviceContext) {
		return getPersistence().update(achivementFormula, serviceContext);
	}

	/**
	* Returns all the achivement formulas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching achivement formulas
	*/
	public static List<achivementFormula> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<achivementFormula> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<achivementFormula> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<achivementFormula> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<achivementFormula> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<achivementFormula> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first achivement formula in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching achivement formula
	* @throws NoSuchachivementFormulaException if a matching achivement formula could not be found
	*/
	public static achivementFormula findByUuid_First(java.lang.String uuid,
		OrderByComparator<achivementFormula> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchachivementFormulaException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first achivement formula in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching achivement formula, or <code>null</code> if a matching achivement formula could not be found
	*/
	public static achivementFormula fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<achivementFormula> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last achivement formula in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching achivement formula
	* @throws NoSuchachivementFormulaException if a matching achivement formula could not be found
	*/
	public static achivementFormula findByUuid_Last(java.lang.String uuid,
		OrderByComparator<achivementFormula> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchachivementFormulaException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last achivement formula in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching achivement formula, or <code>null</code> if a matching achivement formula could not be found
	*/
	public static achivementFormula fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<achivementFormula> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the achivement formulas before and after the current achivement formula in the ordered set where uuid = &#63;.
	*
	* @param achivementFormulaId the primary key of the current achivement formula
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next achivement formula
	* @throws NoSuchachivementFormulaException if a achivement formula with the primary key could not be found
	*/
	public static achivementFormula[] findByUuid_PrevAndNext(
		long achivementFormulaId, java.lang.String uuid,
		OrderByComparator<achivementFormula> orderByComparator)
		throws com.astra.anblicks.pdca.exception.NoSuchachivementFormulaException {
		return getPersistence()
				   .findByUuid_PrevAndNext(achivementFormulaId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the achivement formulas where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of achivement formulas where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching achivement formulas
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the achivement formula in the entity cache if it is enabled.
	*
	* @param achivementFormula the achivement formula
	*/
	public static void cacheResult(achivementFormula achivementFormula) {
		getPersistence().cacheResult(achivementFormula);
	}

	/**
	* Caches the achivement formulas in the entity cache if it is enabled.
	*
	* @param achivementFormulas the achivement formulas
	*/
	public static void cacheResult(List<achivementFormula> achivementFormulas) {
		getPersistence().cacheResult(achivementFormulas);
	}

	/**
	* Creates a new achivement formula with the primary key. Does not add the achivement formula to the database.
	*
	* @param achivementFormulaId the primary key for the new achivement formula
	* @return the new achivement formula
	*/
	public static achivementFormula create(long achivementFormulaId) {
		return getPersistence().create(achivementFormulaId);
	}

	/**
	* Removes the achivement formula with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param achivementFormulaId the primary key of the achivement formula
	* @return the achivement formula that was removed
	* @throws NoSuchachivementFormulaException if a achivement formula with the primary key could not be found
	*/
	public static achivementFormula remove(long achivementFormulaId)
		throws com.astra.anblicks.pdca.exception.NoSuchachivementFormulaException {
		return getPersistence().remove(achivementFormulaId);
	}

	public static achivementFormula updateImpl(
		achivementFormula achivementFormula) {
		return getPersistence().updateImpl(achivementFormula);
	}

	/**
	* Returns the achivement formula with the primary key or throws a {@link NoSuchachivementFormulaException} if it could not be found.
	*
	* @param achivementFormulaId the primary key of the achivement formula
	* @return the achivement formula
	* @throws NoSuchachivementFormulaException if a achivement formula with the primary key could not be found
	*/
	public static achivementFormula findByPrimaryKey(long achivementFormulaId)
		throws com.astra.anblicks.pdca.exception.NoSuchachivementFormulaException {
		return getPersistence().findByPrimaryKey(achivementFormulaId);
	}

	/**
	* Returns the achivement formula with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param achivementFormulaId the primary key of the achivement formula
	* @return the achivement formula, or <code>null</code> if a achivement formula with the primary key could not be found
	*/
	public static achivementFormula fetchByPrimaryKey(long achivementFormulaId) {
		return getPersistence().fetchByPrimaryKey(achivementFormulaId);
	}

	public static java.util.Map<java.io.Serializable, achivementFormula> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the achivement formulas.
	*
	* @return the achivement formulas
	*/
	public static List<achivementFormula> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<achivementFormula> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<achivementFormula> findAll(int start, int end,
		OrderByComparator<achivementFormula> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<achivementFormula> findAll(int start, int end,
		OrderByComparator<achivementFormula> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the achivement formulas from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of achivement formulas.
	*
	* @return the number of achivement formulas
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static achivementFormulaPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<achivementFormulaPersistence, achivementFormulaPersistence> _serviceTracker =
		ServiceTrackerFactory.open(achivementFormulaPersistence.class);
}