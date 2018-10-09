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

package com.astra.anblicks.pdca.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.astra.anblicks.pdca.exception.NoSuchcla_kpiException;
import com.astra.anblicks.pdca.model.cla_kpi;
import com.astra.anblicks.pdca.model.impl.cla_kpiImpl;
import com.astra.anblicks.pdca.model.impl.cla_kpiModelImpl;
import com.astra.anblicks.pdca.service.persistence.cla_kpiPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the cla_kpi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see cla_kpiPersistence
 * @see com.astra.anblicks.pdca.service.persistence.cla_kpiUtil
 * @generated
 */
@ProviderType
public class cla_kpiPersistenceImpl extends BasePersistenceImpl<cla_kpi>
	implements cla_kpiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link cla_kpiUtil} to access the cla_kpi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = cla_kpiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
			cla_kpiModelImpl.FINDER_CACHE_ENABLED, cla_kpiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
			cla_kpiModelImpl.FINDER_CACHE_ENABLED, cla_kpiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
			cla_kpiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
			cla_kpiModelImpl.FINDER_CACHE_ENABLED, cla_kpiImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
			cla_kpiModelImpl.FINDER_CACHE_ENABLED, cla_kpiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			cla_kpiModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
			cla_kpiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the cla_kpis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cla_kpis
	 */
	@Override
	public List<cla_kpi> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<cla_kpi> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<cla_kpi> findByUuid(String uuid, int start, int end,
		OrderByComparator<cla_kpi> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<cla_kpi> findByUuid(String uuid, int start, int end,
		OrderByComparator<cla_kpi> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<cla_kpi> list = null;

		if (retrieveFromCache) {
			list = (List<cla_kpi>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (cla_kpi cla_kpi : list) {
					if (!Objects.equals(uuid, cla_kpi.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CLA_KPI_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(cla_kpiModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<cla_kpi>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<cla_kpi>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first cla_kpi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cla_kpi
	 * @throws NoSuchcla_kpiException if a matching cla_kpi could not be found
	 */
	@Override
	public cla_kpi findByUuid_First(String uuid,
		OrderByComparator<cla_kpi> orderByComparator)
		throws NoSuchcla_kpiException {
		cla_kpi cla_kpi = fetchByUuid_First(uuid, orderByComparator);

		if (cla_kpi != null) {
			return cla_kpi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcla_kpiException(msg.toString());
	}

	/**
	 * Returns the first cla_kpi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cla_kpi, or <code>null</code> if a matching cla_kpi could not be found
	 */
	@Override
	public cla_kpi fetchByUuid_First(String uuid,
		OrderByComparator<cla_kpi> orderByComparator) {
		List<cla_kpi> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cla_kpi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cla_kpi
	 * @throws NoSuchcla_kpiException if a matching cla_kpi could not be found
	 */
	@Override
	public cla_kpi findByUuid_Last(String uuid,
		OrderByComparator<cla_kpi> orderByComparator)
		throws NoSuchcla_kpiException {
		cla_kpi cla_kpi = fetchByUuid_Last(uuid, orderByComparator);

		if (cla_kpi != null) {
			return cla_kpi;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchcla_kpiException(msg.toString());
	}

	/**
	 * Returns the last cla_kpi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cla_kpi, or <code>null</code> if a matching cla_kpi could not be found
	 */
	@Override
	public cla_kpi fetchByUuid_Last(String uuid,
		OrderByComparator<cla_kpi> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<cla_kpi> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cla_kpis before and after the current cla_kpi in the ordered set where uuid = &#63;.
	 *
	 * @param claKpiId the primary key of the current cla_kpi
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cla_kpi
	 * @throws NoSuchcla_kpiException if a cla_kpi with the primary key could not be found
	 */
	@Override
	public cla_kpi[] findByUuid_PrevAndNext(long claKpiId, String uuid,
		OrderByComparator<cla_kpi> orderByComparator)
		throws NoSuchcla_kpiException {
		cla_kpi cla_kpi = findByPrimaryKey(claKpiId);

		Session session = null;

		try {
			session = openSession();

			cla_kpi[] array = new cla_kpiImpl[3];

			array[0] = getByUuid_PrevAndNext(session, cla_kpi, uuid,
					orderByComparator, true);

			array[1] = cla_kpi;

			array[2] = getByUuid_PrevAndNext(session, cla_kpi, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected cla_kpi getByUuid_PrevAndNext(Session session, cla_kpi cla_kpi,
		String uuid, OrderByComparator<cla_kpi> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CLA_KPI_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(cla_kpiModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cla_kpi);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<cla_kpi> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cla_kpis where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (cla_kpi cla_kpi : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(cla_kpi);
		}
	}

	/**
	 * Returns the number of cla_kpis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cla_kpis
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CLA_KPI_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "cla_kpi.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "cla_kpi.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(cla_kpi.uuid IS NULL OR cla_kpi.uuid = '')";

	public cla_kpiPersistenceImpl() {
		setModelClass(cla_kpi.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the cla_kpi in the entity cache if it is enabled.
	 *
	 * @param cla_kpi the cla_kpi
	 */
	@Override
	public void cacheResult(cla_kpi cla_kpi) {
		entityCache.putResult(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
			cla_kpiImpl.class, cla_kpi.getPrimaryKey(), cla_kpi);

		cla_kpi.resetOriginalValues();
	}

	/**
	 * Caches the cla_kpis in the entity cache if it is enabled.
	 *
	 * @param cla_kpis the cla_kpis
	 */
	@Override
	public void cacheResult(List<cla_kpi> cla_kpis) {
		for (cla_kpi cla_kpi : cla_kpis) {
			if (entityCache.getResult(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
						cla_kpiImpl.class, cla_kpi.getPrimaryKey()) == null) {
				cacheResult(cla_kpi);
			}
			else {
				cla_kpi.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cla_kpis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(cla_kpiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cla_kpi.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(cla_kpi cla_kpi) {
		entityCache.removeResult(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
			cla_kpiImpl.class, cla_kpi.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<cla_kpi> cla_kpis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (cla_kpi cla_kpi : cla_kpis) {
			entityCache.removeResult(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
				cla_kpiImpl.class, cla_kpi.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cla_kpi with the primary key. Does not add the cla_kpi to the database.
	 *
	 * @param claKpiId the primary key for the new cla_kpi
	 * @return the new cla_kpi
	 */
	@Override
	public cla_kpi create(long claKpiId) {
		cla_kpi cla_kpi = new cla_kpiImpl();

		cla_kpi.setNew(true);
		cla_kpi.setPrimaryKey(claKpiId);

		String uuid = PortalUUIDUtil.generate();

		cla_kpi.setUuid(uuid);

		return cla_kpi;
	}

	/**
	 * Removes the cla_kpi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claKpiId the primary key of the cla_kpi
	 * @return the cla_kpi that was removed
	 * @throws NoSuchcla_kpiException if a cla_kpi with the primary key could not be found
	 */
	@Override
	public cla_kpi remove(long claKpiId) throws NoSuchcla_kpiException {
		return remove((Serializable)claKpiId);
	}

	/**
	 * Removes the cla_kpi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cla_kpi
	 * @return the cla_kpi that was removed
	 * @throws NoSuchcla_kpiException if a cla_kpi with the primary key could not be found
	 */
	@Override
	public cla_kpi remove(Serializable primaryKey)
		throws NoSuchcla_kpiException {
		Session session = null;

		try {
			session = openSession();

			cla_kpi cla_kpi = (cla_kpi)session.get(cla_kpiImpl.class, primaryKey);

			if (cla_kpi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcla_kpiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cla_kpi);
		}
		catch (NoSuchcla_kpiException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected cla_kpi removeImpl(cla_kpi cla_kpi) {
		cla_kpi = toUnwrappedModel(cla_kpi);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cla_kpi)) {
				cla_kpi = (cla_kpi)session.get(cla_kpiImpl.class,
						cla_kpi.getPrimaryKeyObj());
			}

			if (cla_kpi != null) {
				session.delete(cla_kpi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cla_kpi != null) {
			clearCache(cla_kpi);
		}

		return cla_kpi;
	}

	@Override
	public cla_kpi updateImpl(cla_kpi cla_kpi) {
		cla_kpi = toUnwrappedModel(cla_kpi);

		boolean isNew = cla_kpi.isNew();

		cla_kpiModelImpl cla_kpiModelImpl = (cla_kpiModelImpl)cla_kpi;

		if (Validator.isNull(cla_kpi.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			cla_kpi.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (cla_kpi.isNew()) {
				session.save(cla_kpi);

				cla_kpi.setNew(false);
			}
			else {
				cla_kpi = (cla_kpi)session.merge(cla_kpi);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!cla_kpiModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { cla_kpiModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((cla_kpiModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cla_kpiModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { cla_kpiModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
			cla_kpiImpl.class, cla_kpi.getPrimaryKey(), cla_kpi, false);

		cla_kpi.resetOriginalValues();

		return cla_kpi;
	}

	protected cla_kpi toUnwrappedModel(cla_kpi cla_kpi) {
		if (cla_kpi instanceof cla_kpiImpl) {
			return cla_kpi;
		}

		cla_kpiImpl cla_kpiImpl = new cla_kpiImpl();

		cla_kpiImpl.setNew(cla_kpi.isNew());
		cla_kpiImpl.setPrimaryKey(cla_kpi.getPrimaryKey());

		cla_kpiImpl.setUuid(cla_kpi.getUuid());
		cla_kpiImpl.setClaKpiId(cla_kpi.getClaKpiId());
		cla_kpiImpl.setKpiId(cla_kpi.getKpiId());
		cla_kpiImpl.setPeriodId(cla_kpi.getPeriodId());
		cla_kpiImpl.setYtd(cla_kpi.getYtd());
		cla_kpiImpl.setOl(cla_kpi.getOl());
		cla_kpiImpl.setClaPoint(cla_kpi.getClaPoint());
		cla_kpiImpl.setAchivement(cla_kpi.getAchivement());

		return cla_kpiImpl;
	}

	/**
	 * Returns the cla_kpi with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cla_kpi
	 * @return the cla_kpi
	 * @throws NoSuchcla_kpiException if a cla_kpi with the primary key could not be found
	 */
	@Override
	public cla_kpi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcla_kpiException {
		cla_kpi cla_kpi = fetchByPrimaryKey(primaryKey);

		if (cla_kpi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcla_kpiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cla_kpi;
	}

	/**
	 * Returns the cla_kpi with the primary key or throws a {@link NoSuchcla_kpiException} if it could not be found.
	 *
	 * @param claKpiId the primary key of the cla_kpi
	 * @return the cla_kpi
	 * @throws NoSuchcla_kpiException if a cla_kpi with the primary key could not be found
	 */
	@Override
	public cla_kpi findByPrimaryKey(long claKpiId)
		throws NoSuchcla_kpiException {
		return findByPrimaryKey((Serializable)claKpiId);
	}

	/**
	 * Returns the cla_kpi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cla_kpi
	 * @return the cla_kpi, or <code>null</code> if a cla_kpi with the primary key could not be found
	 */
	@Override
	public cla_kpi fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
				cla_kpiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		cla_kpi cla_kpi = (cla_kpi)serializable;

		if (cla_kpi == null) {
			Session session = null;

			try {
				session = openSession();

				cla_kpi = (cla_kpi)session.get(cla_kpiImpl.class, primaryKey);

				if (cla_kpi != null) {
					cacheResult(cla_kpi);
				}
				else {
					entityCache.putResult(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
						cla_kpiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
					cla_kpiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cla_kpi;
	}

	/**
	 * Returns the cla_kpi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claKpiId the primary key of the cla_kpi
	 * @return the cla_kpi, or <code>null</code> if a cla_kpi with the primary key could not be found
	 */
	@Override
	public cla_kpi fetchByPrimaryKey(long claKpiId) {
		return fetchByPrimaryKey((Serializable)claKpiId);
	}

	@Override
	public Map<Serializable, cla_kpi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, cla_kpi> map = new HashMap<Serializable, cla_kpi>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			cla_kpi cla_kpi = fetchByPrimaryKey(primaryKey);

			if (cla_kpi != null) {
				map.put(primaryKey, cla_kpi);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
					cla_kpiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (cla_kpi)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CLA_KPI_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (cla_kpi cla_kpi : (List<cla_kpi>)q.list()) {
				map.put(cla_kpi.getPrimaryKeyObj(), cla_kpi);

				cacheResult(cla_kpi);

				uncachedPrimaryKeys.remove(cla_kpi.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(cla_kpiModelImpl.ENTITY_CACHE_ENABLED,
					cla_kpiImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the cla_kpis.
	 *
	 * @return the cla_kpis
	 */
	@Override
	public List<cla_kpi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<cla_kpi> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<cla_kpi> findAll(int start, int end,
		OrderByComparator<cla_kpi> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<cla_kpi> findAll(int start, int end,
		OrderByComparator<cla_kpi> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<cla_kpi> list = null;

		if (retrieveFromCache) {
			list = (List<cla_kpi>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CLA_KPI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CLA_KPI;

				if (pagination) {
					sql = sql.concat(cla_kpiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<cla_kpi>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<cla_kpi>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cla_kpis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (cla_kpi cla_kpi : findAll()) {
			remove(cla_kpi);
		}
	}

	/**
	 * Returns the number of cla_kpis.
	 *
	 * @return the number of cla_kpis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CLA_KPI);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return cla_kpiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cla_kpi persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(cla_kpiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CLA_KPI = "SELECT cla_kpi FROM cla_kpi cla_kpi";
	private static final String _SQL_SELECT_CLA_KPI_WHERE_PKS_IN = "SELECT cla_kpi FROM cla_kpi cla_kpi WHERE claKpiId IN (";
	private static final String _SQL_SELECT_CLA_KPI_WHERE = "SELECT cla_kpi FROM cla_kpi cla_kpi WHERE ";
	private static final String _SQL_COUNT_CLA_KPI = "SELECT COUNT(cla_kpi) FROM cla_kpi cla_kpi";
	private static final String _SQL_COUNT_CLA_KPI_WHERE = "SELECT COUNT(cla_kpi) FROM cla_kpi cla_kpi WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cla_kpi.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No cla_kpi exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No cla_kpi exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(cla_kpiPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}