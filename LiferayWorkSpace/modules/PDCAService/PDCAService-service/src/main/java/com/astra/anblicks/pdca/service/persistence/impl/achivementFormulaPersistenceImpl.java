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

import com.astra.anblicks.pdca.exception.NoSuchachivementFormulaException;
import com.astra.anblicks.pdca.model.achivementFormula;
import com.astra.anblicks.pdca.model.impl.achivementFormulaImpl;
import com.astra.anblicks.pdca.model.impl.achivementFormulaModelImpl;
import com.astra.anblicks.pdca.service.persistence.achivementFormulaPersistence;

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
 * The persistence implementation for the achivement formula service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see achivementFormulaPersistence
 * @see com.astra.anblicks.pdca.service.persistence.achivementFormulaUtil
 * @generated
 */
@ProviderType
public class achivementFormulaPersistenceImpl extends BasePersistenceImpl<achivementFormula>
	implements achivementFormulaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link achivementFormulaUtil} to access the achivement formula persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = achivementFormulaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			achivementFormulaModelImpl.FINDER_CACHE_ENABLED,
			achivementFormulaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			achivementFormulaModelImpl.FINDER_CACHE_ENABLED,
			achivementFormulaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			achivementFormulaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			achivementFormulaModelImpl.FINDER_CACHE_ENABLED,
			achivementFormulaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			achivementFormulaModelImpl.FINDER_CACHE_ENABLED,
			achivementFormulaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			achivementFormulaModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			achivementFormulaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the achivement formulas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching achivement formulas
	 */
	@Override
	public List<achivementFormula> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<achivementFormula> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<achivementFormula> findByUuid(String uuid, int start, int end,
		OrderByComparator<achivementFormula> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<achivementFormula> findByUuid(String uuid, int start, int end,
		OrderByComparator<achivementFormula> orderByComparator,
		boolean retrieveFromCache) {
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

		List<achivementFormula> list = null;

		if (retrieveFromCache) {
			list = (List<achivementFormula>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (achivementFormula achivementFormula : list) {
					if (!Objects.equals(uuid, achivementFormula.getUuid())) {
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

			query.append(_SQL_SELECT_ACHIVEMENTFORMULA_WHERE);

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
				query.append(achivementFormulaModelImpl.ORDER_BY_JPQL);
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
					list = (List<achivementFormula>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<achivementFormula>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first achivement formula in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching achivement formula
	 * @throws NoSuchachivementFormulaException if a matching achivement formula could not be found
	 */
	@Override
	public achivementFormula findByUuid_First(String uuid,
		OrderByComparator<achivementFormula> orderByComparator)
		throws NoSuchachivementFormulaException {
		achivementFormula achivementFormula = fetchByUuid_First(uuid,
				orderByComparator);

		if (achivementFormula != null) {
			return achivementFormula;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchachivementFormulaException(msg.toString());
	}

	/**
	 * Returns the first achivement formula in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching achivement formula, or <code>null</code> if a matching achivement formula could not be found
	 */
	@Override
	public achivementFormula fetchByUuid_First(String uuid,
		OrderByComparator<achivementFormula> orderByComparator) {
		List<achivementFormula> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last achivement formula in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching achivement formula
	 * @throws NoSuchachivementFormulaException if a matching achivement formula could not be found
	 */
	@Override
	public achivementFormula findByUuid_Last(String uuid,
		OrderByComparator<achivementFormula> orderByComparator)
		throws NoSuchachivementFormulaException {
		achivementFormula achivementFormula = fetchByUuid_Last(uuid,
				orderByComparator);

		if (achivementFormula != null) {
			return achivementFormula;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchachivementFormulaException(msg.toString());
	}

	/**
	 * Returns the last achivement formula in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching achivement formula, or <code>null</code> if a matching achivement formula could not be found
	 */
	@Override
	public achivementFormula fetchByUuid_Last(String uuid,
		OrderByComparator<achivementFormula> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<achivementFormula> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public achivementFormula[] findByUuid_PrevAndNext(
		long achivementFormulaId, String uuid,
		OrderByComparator<achivementFormula> orderByComparator)
		throws NoSuchachivementFormulaException {
		achivementFormula achivementFormula = findByPrimaryKey(achivementFormulaId);

		Session session = null;

		try {
			session = openSession();

			achivementFormula[] array = new achivementFormulaImpl[3];

			array[0] = getByUuid_PrevAndNext(session, achivementFormula, uuid,
					orderByComparator, true);

			array[1] = achivementFormula;

			array[2] = getByUuid_PrevAndNext(session, achivementFormula, uuid,
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

	protected achivementFormula getByUuid_PrevAndNext(Session session,
		achivementFormula achivementFormula, String uuid,
		OrderByComparator<achivementFormula> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACHIVEMENTFORMULA_WHERE);

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
			query.append(achivementFormulaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(achivementFormula);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<achivementFormula> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the achivement formulas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (achivementFormula achivementFormula : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(achivementFormula);
		}
	}

	/**
	 * Returns the number of achivement formulas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching achivement formulas
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACHIVEMENTFORMULA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "achivementFormula.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "achivementFormula.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(achivementFormula.uuid IS NULL OR achivementFormula.uuid = '')";

	public achivementFormulaPersistenceImpl() {
		setModelClass(achivementFormula.class);

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
	 * Caches the achivement formula in the entity cache if it is enabled.
	 *
	 * @param achivementFormula the achivement formula
	 */
	@Override
	public void cacheResult(achivementFormula achivementFormula) {
		entityCache.putResult(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			achivementFormulaImpl.class, achivementFormula.getPrimaryKey(),
			achivementFormula);

		achivementFormula.resetOriginalValues();
	}

	/**
	 * Caches the achivement formulas in the entity cache if it is enabled.
	 *
	 * @param achivementFormulas the achivement formulas
	 */
	@Override
	public void cacheResult(List<achivementFormula> achivementFormulas) {
		for (achivementFormula achivementFormula : achivementFormulas) {
			if (entityCache.getResult(
						achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
						achivementFormulaImpl.class,
						achivementFormula.getPrimaryKey()) == null) {
				cacheResult(achivementFormula);
			}
			else {
				achivementFormula.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all achivement formulas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(achivementFormulaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the achivement formula.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(achivementFormula achivementFormula) {
		entityCache.removeResult(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			achivementFormulaImpl.class, achivementFormula.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<achivementFormula> achivementFormulas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (achivementFormula achivementFormula : achivementFormulas) {
			entityCache.removeResult(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
				achivementFormulaImpl.class, achivementFormula.getPrimaryKey());
		}
	}

	/**
	 * Creates a new achivement formula with the primary key. Does not add the achivement formula to the database.
	 *
	 * @param achivementFormulaId the primary key for the new achivement formula
	 * @return the new achivement formula
	 */
	@Override
	public achivementFormula create(long achivementFormulaId) {
		achivementFormula achivementFormula = new achivementFormulaImpl();

		achivementFormula.setNew(true);
		achivementFormula.setPrimaryKey(achivementFormulaId);

		String uuid = PortalUUIDUtil.generate();

		achivementFormula.setUuid(uuid);

		return achivementFormula;
	}

	/**
	 * Removes the achivement formula with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param achivementFormulaId the primary key of the achivement formula
	 * @return the achivement formula that was removed
	 * @throws NoSuchachivementFormulaException if a achivement formula with the primary key could not be found
	 */
	@Override
	public achivementFormula remove(long achivementFormulaId)
		throws NoSuchachivementFormulaException {
		return remove((Serializable)achivementFormulaId);
	}

	/**
	 * Removes the achivement formula with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the achivement formula
	 * @return the achivement formula that was removed
	 * @throws NoSuchachivementFormulaException if a achivement formula with the primary key could not be found
	 */
	@Override
	public achivementFormula remove(Serializable primaryKey)
		throws NoSuchachivementFormulaException {
		Session session = null;

		try {
			session = openSession();

			achivementFormula achivementFormula = (achivementFormula)session.get(achivementFormulaImpl.class,
					primaryKey);

			if (achivementFormula == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchachivementFormulaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(achivementFormula);
		}
		catch (NoSuchachivementFormulaException nsee) {
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
	protected achivementFormula removeImpl(achivementFormula achivementFormula) {
		achivementFormula = toUnwrappedModel(achivementFormula);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(achivementFormula)) {
				achivementFormula = (achivementFormula)session.get(achivementFormulaImpl.class,
						achivementFormula.getPrimaryKeyObj());
			}

			if (achivementFormula != null) {
				session.delete(achivementFormula);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (achivementFormula != null) {
			clearCache(achivementFormula);
		}

		return achivementFormula;
	}

	@Override
	public achivementFormula updateImpl(achivementFormula achivementFormula) {
		achivementFormula = toUnwrappedModel(achivementFormula);

		boolean isNew = achivementFormula.isNew();

		achivementFormulaModelImpl achivementFormulaModelImpl = (achivementFormulaModelImpl)achivementFormula;

		if (Validator.isNull(achivementFormula.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			achivementFormula.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (achivementFormula.isNew()) {
				session.save(achivementFormula);

				achivementFormula.setNew(false);
			}
			else {
				achivementFormula = (achivementFormula)session.merge(achivementFormula);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!achivementFormulaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { achivementFormulaModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((achivementFormulaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						achivementFormulaModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { achivementFormulaModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			achivementFormulaImpl.class, achivementFormula.getPrimaryKey(),
			achivementFormula, false);

		achivementFormula.resetOriginalValues();

		return achivementFormula;
	}

	protected achivementFormula toUnwrappedModel(
		achivementFormula achivementFormula) {
		if (achivementFormula instanceof achivementFormulaImpl) {
			return achivementFormula;
		}

		achivementFormulaImpl achivementFormulaImpl = new achivementFormulaImpl();

		achivementFormulaImpl.setNew(achivementFormula.isNew());
		achivementFormulaImpl.setPrimaryKey(achivementFormula.getPrimaryKey());

		achivementFormulaImpl.setUuid(achivementFormula.getUuid());
		achivementFormulaImpl.setAchivementFormulaId(achivementFormula.getAchivementFormulaId());
		achivementFormulaImpl.setAchivementFormula(achivementFormula.getAchivementFormula());
		achivementFormulaImpl.setItemDescriptionId(achivementFormula.getItemDescriptionId());

		return achivementFormulaImpl;
	}

	/**
	 * Returns the achivement formula with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the achivement formula
	 * @return the achivement formula
	 * @throws NoSuchachivementFormulaException if a achivement formula with the primary key could not be found
	 */
	@Override
	public achivementFormula findByPrimaryKey(Serializable primaryKey)
		throws NoSuchachivementFormulaException {
		achivementFormula achivementFormula = fetchByPrimaryKey(primaryKey);

		if (achivementFormula == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchachivementFormulaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return achivementFormula;
	}

	/**
	 * Returns the achivement formula with the primary key or throws a {@link NoSuchachivementFormulaException} if it could not be found.
	 *
	 * @param achivementFormulaId the primary key of the achivement formula
	 * @return the achivement formula
	 * @throws NoSuchachivementFormulaException if a achivement formula with the primary key could not be found
	 */
	@Override
	public achivementFormula findByPrimaryKey(long achivementFormulaId)
		throws NoSuchachivementFormulaException {
		return findByPrimaryKey((Serializable)achivementFormulaId);
	}

	/**
	 * Returns the achivement formula with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the achivement formula
	 * @return the achivement formula, or <code>null</code> if a achivement formula with the primary key could not be found
	 */
	@Override
	public achivementFormula fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
				achivementFormulaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		achivementFormula achivementFormula = (achivementFormula)serializable;

		if (achivementFormula == null) {
			Session session = null;

			try {
				session = openSession();

				achivementFormula = (achivementFormula)session.get(achivementFormulaImpl.class,
						primaryKey);

				if (achivementFormula != null) {
					cacheResult(achivementFormula);
				}
				else {
					entityCache.putResult(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
						achivementFormulaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
					achivementFormulaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return achivementFormula;
	}

	/**
	 * Returns the achivement formula with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param achivementFormulaId the primary key of the achivement formula
	 * @return the achivement formula, or <code>null</code> if a achivement formula with the primary key could not be found
	 */
	@Override
	public achivementFormula fetchByPrimaryKey(long achivementFormulaId) {
		return fetchByPrimaryKey((Serializable)achivementFormulaId);
	}

	@Override
	public Map<Serializable, achivementFormula> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, achivementFormula> map = new HashMap<Serializable, achivementFormula>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			achivementFormula achivementFormula = fetchByPrimaryKey(primaryKey);

			if (achivementFormula != null) {
				map.put(primaryKey, achivementFormula);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
					achivementFormulaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (achivementFormula)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ACHIVEMENTFORMULA_WHERE_PKS_IN);

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

			for (achivementFormula achivementFormula : (List<achivementFormula>)q.list()) {
				map.put(achivementFormula.getPrimaryKeyObj(), achivementFormula);

				cacheResult(achivementFormula);

				uncachedPrimaryKeys.remove(achivementFormula.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(achivementFormulaModelImpl.ENTITY_CACHE_ENABLED,
					achivementFormulaImpl.class, primaryKey, nullModel);
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
	 * Returns all the achivement formulas.
	 *
	 * @return the achivement formulas
	 */
	@Override
	public List<achivementFormula> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<achivementFormula> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<achivementFormula> findAll(int start, int end,
		OrderByComparator<achivementFormula> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<achivementFormula> findAll(int start, int end,
		OrderByComparator<achivementFormula> orderByComparator,
		boolean retrieveFromCache) {
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

		List<achivementFormula> list = null;

		if (retrieveFromCache) {
			list = (List<achivementFormula>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ACHIVEMENTFORMULA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACHIVEMENTFORMULA;

				if (pagination) {
					sql = sql.concat(achivementFormulaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<achivementFormula>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<achivementFormula>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the achivement formulas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (achivementFormula achivementFormula : findAll()) {
			remove(achivementFormula);
		}
	}

	/**
	 * Returns the number of achivement formulas.
	 *
	 * @return the number of achivement formulas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ACHIVEMENTFORMULA);

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
		return achivementFormulaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the achivement formula persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(achivementFormulaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ACHIVEMENTFORMULA = "SELECT achivementFormula FROM achivementFormula achivementFormula";
	private static final String _SQL_SELECT_ACHIVEMENTFORMULA_WHERE_PKS_IN = "SELECT achivementFormula FROM achivementFormula achivementFormula WHERE achivementFormulaId IN (";
	private static final String _SQL_SELECT_ACHIVEMENTFORMULA_WHERE = "SELECT achivementFormula FROM achivementFormula achivementFormula WHERE ";
	private static final String _SQL_COUNT_ACHIVEMENTFORMULA = "SELECT COUNT(achivementFormula) FROM achivementFormula achivementFormula";
	private static final String _SQL_COUNT_ACHIVEMENTFORMULA_WHERE = "SELECT COUNT(achivementFormula) FROM achivementFormula achivementFormula WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "achivementFormula.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No achivementFormula exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No achivementFormula exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(achivementFormulaPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}