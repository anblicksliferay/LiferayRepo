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

import com.astra.anblicks.pdca.exception.NoSuchitemDescriptionException;
import com.astra.anblicks.pdca.model.impl.itemDescriptionImpl;
import com.astra.anblicks.pdca.model.impl.itemDescriptionModelImpl;
import com.astra.anblicks.pdca.model.itemDescription;
import com.astra.anblicks.pdca.service.persistence.itemDescriptionPersistence;

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
 * The persistence implementation for the item description service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see itemDescriptionPersistence
 * @see com.astra.anblicks.pdca.service.persistence.itemDescriptionUtil
 * @generated
 */
@ProviderType
public class itemDescriptionPersistenceImpl extends BasePersistenceImpl<itemDescription>
	implements itemDescriptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link itemDescriptionUtil} to access the item description persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = itemDescriptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			itemDescriptionModelImpl.FINDER_CACHE_ENABLED,
			itemDescriptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			itemDescriptionModelImpl.FINDER_CACHE_ENABLED,
			itemDescriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			itemDescriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			itemDescriptionModelImpl.FINDER_CACHE_ENABLED,
			itemDescriptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			itemDescriptionModelImpl.FINDER_CACHE_ENABLED,
			itemDescriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			itemDescriptionModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			itemDescriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the item descriptions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching item descriptions
	 */
	@Override
	public List<itemDescription> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item descriptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of item descriptions
	 * @param end the upper bound of the range of item descriptions (not inclusive)
	 * @return the range of matching item descriptions
	 */
	@Override
	public List<itemDescription> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the item descriptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of item descriptions
	 * @param end the upper bound of the range of item descriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching item descriptions
	 */
	@Override
	public List<itemDescription> findByUuid(String uuid, int start, int end,
		OrderByComparator<itemDescription> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the item descriptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of item descriptions
	 * @param end the upper bound of the range of item descriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching item descriptions
	 */
	@Override
	public List<itemDescription> findByUuid(String uuid, int start, int end,
		OrderByComparator<itemDescription> orderByComparator,
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

		List<itemDescription> list = null;

		if (retrieveFromCache) {
			list = (List<itemDescription>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (itemDescription itemDescription : list) {
					if (!Objects.equals(uuid, itemDescription.getUuid())) {
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

			query.append(_SQL_SELECT_ITEMDESCRIPTION_WHERE);

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
				query.append(itemDescriptionModelImpl.ORDER_BY_JPQL);
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
					list = (List<itemDescription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<itemDescription>)QueryUtil.list(q,
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
	 * Returns the first item description in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item description
	 * @throws NoSuchitemDescriptionException if a matching item description could not be found
	 */
	@Override
	public itemDescription findByUuid_First(String uuid,
		OrderByComparator<itemDescription> orderByComparator)
		throws NoSuchitemDescriptionException {
		itemDescription itemDescription = fetchByUuid_First(uuid,
				orderByComparator);

		if (itemDescription != null) {
			return itemDescription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchitemDescriptionException(msg.toString());
	}

	/**
	 * Returns the first item description in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching item description, or <code>null</code> if a matching item description could not be found
	 */
	@Override
	public itemDescription fetchByUuid_First(String uuid,
		OrderByComparator<itemDescription> orderByComparator) {
		List<itemDescription> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last item description in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item description
	 * @throws NoSuchitemDescriptionException if a matching item description could not be found
	 */
	@Override
	public itemDescription findByUuid_Last(String uuid,
		OrderByComparator<itemDescription> orderByComparator)
		throws NoSuchitemDescriptionException {
		itemDescription itemDescription = fetchByUuid_Last(uuid,
				orderByComparator);

		if (itemDescription != null) {
			return itemDescription;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchitemDescriptionException(msg.toString());
	}

	/**
	 * Returns the last item description in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching item description, or <code>null</code> if a matching item description could not be found
	 */
	@Override
	public itemDescription fetchByUuid_Last(String uuid,
		OrderByComparator<itemDescription> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<itemDescription> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the item descriptions before and after the current item description in the ordered set where uuid = &#63;.
	 *
	 * @param itemDescriptionId the primary key of the current item description
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next item description
	 * @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	 */
	@Override
	public itemDescription[] findByUuid_PrevAndNext(long itemDescriptionId,
		String uuid, OrderByComparator<itemDescription> orderByComparator)
		throws NoSuchitemDescriptionException {
		itemDescription itemDescription = findByPrimaryKey(itemDescriptionId);

		Session session = null;

		try {
			session = openSession();

			itemDescription[] array = new itemDescriptionImpl[3];

			array[0] = getByUuid_PrevAndNext(session, itemDescription, uuid,
					orderByComparator, true);

			array[1] = itemDescription;

			array[2] = getByUuid_PrevAndNext(session, itemDescription, uuid,
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

	protected itemDescription getByUuid_PrevAndNext(Session session,
		itemDescription itemDescription, String uuid,
		OrderByComparator<itemDescription> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ITEMDESCRIPTION_WHERE);

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
			query.append(itemDescriptionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(itemDescription);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<itemDescription> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the item descriptions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (itemDescription itemDescription : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(itemDescription);
		}
	}

	/**
	 * Returns the number of item descriptions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching item descriptions
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ITEMDESCRIPTION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "itemDescription.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "itemDescription.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(itemDescription.uuid IS NULL OR itemDescription.uuid = '')";

	public itemDescriptionPersistenceImpl() {
		setModelClass(itemDescription.class);

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
	 * Caches the item description in the entity cache if it is enabled.
	 *
	 * @param itemDescription the item description
	 */
	@Override
	public void cacheResult(itemDescription itemDescription) {
		entityCache.putResult(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			itemDescriptionImpl.class, itemDescription.getPrimaryKey(),
			itemDescription);

		itemDescription.resetOriginalValues();
	}

	/**
	 * Caches the item descriptions in the entity cache if it is enabled.
	 *
	 * @param itemDescriptions the item descriptions
	 */
	@Override
	public void cacheResult(List<itemDescription> itemDescriptions) {
		for (itemDescription itemDescription : itemDescriptions) {
			if (entityCache.getResult(
						itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
						itemDescriptionImpl.class,
						itemDescription.getPrimaryKey()) == null) {
				cacheResult(itemDescription);
			}
			else {
				itemDescription.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all item descriptions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(itemDescriptionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the item description.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(itemDescription itemDescription) {
		entityCache.removeResult(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			itemDescriptionImpl.class, itemDescription.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<itemDescription> itemDescriptions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (itemDescription itemDescription : itemDescriptions) {
			entityCache.removeResult(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
				itemDescriptionImpl.class, itemDescription.getPrimaryKey());
		}
	}

	/**
	 * Creates a new item description with the primary key. Does not add the item description to the database.
	 *
	 * @param itemDescriptionId the primary key for the new item description
	 * @return the new item description
	 */
	@Override
	public itemDescription create(long itemDescriptionId) {
		itemDescription itemDescription = new itemDescriptionImpl();

		itemDescription.setNew(true);
		itemDescription.setPrimaryKey(itemDescriptionId);

		String uuid = PortalUUIDUtil.generate();

		itemDescription.setUuid(uuid);

		return itemDescription;
	}

	/**
	 * Removes the item description with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param itemDescriptionId the primary key of the item description
	 * @return the item description that was removed
	 * @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	 */
	@Override
	public itemDescription remove(long itemDescriptionId)
		throws NoSuchitemDescriptionException {
		return remove((Serializable)itemDescriptionId);
	}

	/**
	 * Removes the item description with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the item description
	 * @return the item description that was removed
	 * @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	 */
	@Override
	public itemDescription remove(Serializable primaryKey)
		throws NoSuchitemDescriptionException {
		Session session = null;

		try {
			session = openSession();

			itemDescription itemDescription = (itemDescription)session.get(itemDescriptionImpl.class,
					primaryKey);

			if (itemDescription == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchitemDescriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(itemDescription);
		}
		catch (NoSuchitemDescriptionException nsee) {
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
	protected itemDescription removeImpl(itemDescription itemDescription) {
		itemDescription = toUnwrappedModel(itemDescription);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(itemDescription)) {
				itemDescription = (itemDescription)session.get(itemDescriptionImpl.class,
						itemDescription.getPrimaryKeyObj());
			}

			if (itemDescription != null) {
				session.delete(itemDescription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (itemDescription != null) {
			clearCache(itemDescription);
		}

		return itemDescription;
	}

	@Override
	public itemDescription updateImpl(itemDescription itemDescription) {
		itemDescription = toUnwrappedModel(itemDescription);

		boolean isNew = itemDescription.isNew();

		itemDescriptionModelImpl itemDescriptionModelImpl = (itemDescriptionModelImpl)itemDescription;

		if (Validator.isNull(itemDescription.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			itemDescription.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (itemDescription.isNew()) {
				session.save(itemDescription);

				itemDescription.setNew(false);
			}
			else {
				itemDescription = (itemDescription)session.merge(itemDescription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!itemDescriptionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { itemDescriptionModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((itemDescriptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						itemDescriptionModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { itemDescriptionModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			itemDescriptionImpl.class, itemDescription.getPrimaryKey(),
			itemDescription, false);

		itemDescription.resetOriginalValues();

		return itemDescription;
	}

	protected itemDescription toUnwrappedModel(itemDescription itemDescription) {
		if (itemDescription instanceof itemDescriptionImpl) {
			return itemDescription;
		}

		itemDescriptionImpl itemDescriptionImpl = new itemDescriptionImpl();

		itemDescriptionImpl.setNew(itemDescription.isNew());
		itemDescriptionImpl.setPrimaryKey(itemDescription.getPrimaryKey());

		itemDescriptionImpl.setUuid(itemDescription.getUuid());
		itemDescriptionImpl.setItemDescriptionId(itemDescription.getItemDescriptionId());
		itemDescriptionImpl.setItemDescriptionName(itemDescription.getItemDescriptionName());

		return itemDescriptionImpl;
	}

	/**
	 * Returns the item description with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the item description
	 * @return the item description
	 * @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	 */
	@Override
	public itemDescription findByPrimaryKey(Serializable primaryKey)
		throws NoSuchitemDescriptionException {
		itemDescription itemDescription = fetchByPrimaryKey(primaryKey);

		if (itemDescription == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchitemDescriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return itemDescription;
	}

	/**
	 * Returns the item description with the primary key or throws a {@link NoSuchitemDescriptionException} if it could not be found.
	 *
	 * @param itemDescriptionId the primary key of the item description
	 * @return the item description
	 * @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	 */
	@Override
	public itemDescription findByPrimaryKey(long itemDescriptionId)
		throws NoSuchitemDescriptionException {
		return findByPrimaryKey((Serializable)itemDescriptionId);
	}

	/**
	 * Returns the item description with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the item description
	 * @return the item description, or <code>null</code> if a item description with the primary key could not be found
	 */
	@Override
	public itemDescription fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
				itemDescriptionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		itemDescription itemDescription = (itemDescription)serializable;

		if (itemDescription == null) {
			Session session = null;

			try {
				session = openSession();

				itemDescription = (itemDescription)session.get(itemDescriptionImpl.class,
						primaryKey);

				if (itemDescription != null) {
					cacheResult(itemDescription);
				}
				else {
					entityCache.putResult(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
						itemDescriptionImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
					itemDescriptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return itemDescription;
	}

	/**
	 * Returns the item description with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param itemDescriptionId the primary key of the item description
	 * @return the item description, or <code>null</code> if a item description with the primary key could not be found
	 */
	@Override
	public itemDescription fetchByPrimaryKey(long itemDescriptionId) {
		return fetchByPrimaryKey((Serializable)itemDescriptionId);
	}

	@Override
	public Map<Serializable, itemDescription> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, itemDescription> map = new HashMap<Serializable, itemDescription>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			itemDescription itemDescription = fetchByPrimaryKey(primaryKey);

			if (itemDescription != null) {
				map.put(primaryKey, itemDescription);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
					itemDescriptionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (itemDescription)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ITEMDESCRIPTION_WHERE_PKS_IN);

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

			for (itemDescription itemDescription : (List<itemDescription>)q.list()) {
				map.put(itemDescription.getPrimaryKeyObj(), itemDescription);

				cacheResult(itemDescription);

				uncachedPrimaryKeys.remove(itemDescription.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(itemDescriptionModelImpl.ENTITY_CACHE_ENABLED,
					itemDescriptionImpl.class, primaryKey, nullModel);
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
	 * Returns all the item descriptions.
	 *
	 * @return the item descriptions
	 */
	@Override
	public List<itemDescription> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the item descriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item descriptions
	 * @param end the upper bound of the range of item descriptions (not inclusive)
	 * @return the range of item descriptions
	 */
	@Override
	public List<itemDescription> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the item descriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item descriptions
	 * @param end the upper bound of the range of item descriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of item descriptions
	 */
	@Override
	public List<itemDescription> findAll(int start, int end,
		OrderByComparator<itemDescription> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the item descriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link itemDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of item descriptions
	 * @param end the upper bound of the range of item descriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of item descriptions
	 */
	@Override
	public List<itemDescription> findAll(int start, int end,
		OrderByComparator<itemDescription> orderByComparator,
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

		List<itemDescription> list = null;

		if (retrieveFromCache) {
			list = (List<itemDescription>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ITEMDESCRIPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ITEMDESCRIPTION;

				if (pagination) {
					sql = sql.concat(itemDescriptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<itemDescription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<itemDescription>)QueryUtil.list(q,
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
	 * Removes all the item descriptions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (itemDescription itemDescription : findAll()) {
			remove(itemDescription);
		}
	}

	/**
	 * Returns the number of item descriptions.
	 *
	 * @return the number of item descriptions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ITEMDESCRIPTION);

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
		return itemDescriptionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the item description persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(itemDescriptionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ITEMDESCRIPTION = "SELECT itemDescription FROM itemDescription itemDescription";
	private static final String _SQL_SELECT_ITEMDESCRIPTION_WHERE_PKS_IN = "SELECT itemDescription FROM itemDescription itemDescription WHERE itemDescriptionId IN (";
	private static final String _SQL_SELECT_ITEMDESCRIPTION_WHERE = "SELECT itemDescription FROM itemDescription itemDescription WHERE ";
	private static final String _SQL_COUNT_ITEMDESCRIPTION = "SELECT COUNT(itemDescription) FROM itemDescription itemDescription";
	private static final String _SQL_COUNT_ITEMDESCRIPTION_WHERE = "SELECT COUNT(itemDescription) FROM itemDescription itemDescription WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "itemDescription.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No itemDescription exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No itemDescription exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(itemDescriptionPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}