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

import com.astra.anblicks.pdca.exception.NoSuchcla_kpiException;
import com.astra.anblicks.pdca.model.cla_kpi;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the cla_kpi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.persistence.impl.cla_kpiPersistenceImpl
 * @see cla_kpiUtil
 * @generated
 */
@ProviderType
public interface cla_kpiPersistence extends BasePersistence<cla_kpi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link cla_kpiUtil} to access the cla_kpi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cla_kpis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching cla_kpis
	*/
	public java.util.List<cla_kpi> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the cla_kpis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cla_kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of cla_kpis
	* @param end the upper bound of the range of cla_kpis (not inclusive)
	* @return the range of matching cla_kpis
	*/
	public java.util.List<cla_kpi> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the cla_kpis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cla_kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of cla_kpis
	* @param end the upper bound of the range of cla_kpis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cla_kpis
	*/
	public java.util.List<cla_kpi> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<cla_kpi> orderByComparator);

	/**
	* Returns an ordered range of all the cla_kpis where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cla_kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of cla_kpis
	* @param end the upper bound of the range of cla_kpis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching cla_kpis
	*/
	public java.util.List<cla_kpi> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<cla_kpi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first cla_kpi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cla_kpi
	* @throws NoSuchcla_kpiException if a matching cla_kpi could not be found
	*/
	public cla_kpi findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<cla_kpi> orderByComparator)
		throws NoSuchcla_kpiException;

	/**
	* Returns the first cla_kpi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cla_kpi, or <code>null</code> if a matching cla_kpi could not be found
	*/
	public cla_kpi fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<cla_kpi> orderByComparator);

	/**
	* Returns the last cla_kpi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cla_kpi
	* @throws NoSuchcla_kpiException if a matching cla_kpi could not be found
	*/
	public cla_kpi findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<cla_kpi> orderByComparator)
		throws NoSuchcla_kpiException;

	/**
	* Returns the last cla_kpi in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cla_kpi, or <code>null</code> if a matching cla_kpi could not be found
	*/
	public cla_kpi fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<cla_kpi> orderByComparator);

	/**
	* Returns the cla_kpis before and after the current cla_kpi in the ordered set where uuid = &#63;.
	*
	* @param claKpiId the primary key of the current cla_kpi
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cla_kpi
	* @throws NoSuchcla_kpiException if a cla_kpi with the primary key could not be found
	*/
	public cla_kpi[] findByUuid_PrevAndNext(long claKpiId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<cla_kpi> orderByComparator)
		throws NoSuchcla_kpiException;

	/**
	* Removes all the cla_kpis where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of cla_kpis where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching cla_kpis
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the cla_kpi in the entity cache if it is enabled.
	*
	* @param cla_kpi the cla_kpi
	*/
	public void cacheResult(cla_kpi cla_kpi);

	/**
	* Caches the cla_kpis in the entity cache if it is enabled.
	*
	* @param cla_kpis the cla_kpis
	*/
	public void cacheResult(java.util.List<cla_kpi> cla_kpis);

	/**
	* Creates a new cla_kpi with the primary key. Does not add the cla_kpi to the database.
	*
	* @param claKpiId the primary key for the new cla_kpi
	* @return the new cla_kpi
	*/
	public cla_kpi create(long claKpiId);

	/**
	* Removes the cla_kpi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param claKpiId the primary key of the cla_kpi
	* @return the cla_kpi that was removed
	* @throws NoSuchcla_kpiException if a cla_kpi with the primary key could not be found
	*/
	public cla_kpi remove(long claKpiId) throws NoSuchcla_kpiException;

	public cla_kpi updateImpl(cla_kpi cla_kpi);

	/**
	* Returns the cla_kpi with the primary key or throws a {@link NoSuchcla_kpiException} if it could not be found.
	*
	* @param claKpiId the primary key of the cla_kpi
	* @return the cla_kpi
	* @throws NoSuchcla_kpiException if a cla_kpi with the primary key could not be found
	*/
	public cla_kpi findByPrimaryKey(long claKpiId)
		throws NoSuchcla_kpiException;

	/**
	* Returns the cla_kpi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param claKpiId the primary key of the cla_kpi
	* @return the cla_kpi, or <code>null</code> if a cla_kpi with the primary key could not be found
	*/
	public cla_kpi fetchByPrimaryKey(long claKpiId);

	@Override
	public java.util.Map<java.io.Serializable, cla_kpi> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the cla_kpis.
	*
	* @return the cla_kpis
	*/
	public java.util.List<cla_kpi> findAll();

	/**
	* Returns a range of all the cla_kpis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cla_kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cla_kpis
	* @param end the upper bound of the range of cla_kpis (not inclusive)
	* @return the range of cla_kpis
	*/
	public java.util.List<cla_kpi> findAll(int start, int end);

	/**
	* Returns an ordered range of all the cla_kpis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cla_kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cla_kpis
	* @param end the upper bound of the range of cla_kpis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cla_kpis
	*/
	public java.util.List<cla_kpi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cla_kpi> orderByComparator);

	/**
	* Returns an ordered range of all the cla_kpis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link cla_kpiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cla_kpis
	* @param end the upper bound of the range of cla_kpis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of cla_kpis
	*/
	public java.util.List<cla_kpi> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<cla_kpi> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the cla_kpis from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of cla_kpis.
	*
	* @return the number of cla_kpis
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}