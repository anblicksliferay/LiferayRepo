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

package com.test.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.test.exception.NoSuchtestableException;

import com.test.model.impl.testableImpl;
import com.test.model.impl.testableModelImpl;
import com.test.model.testable;

import com.test.service.persistence.testablePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the testable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see testablePersistence
 * @see com.test.service.persistence.testableUtil
 * @generated
 */
@ProviderType
public class testablePersistenceImpl extends BasePersistenceImpl<testable>
	implements testablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link testableUtil} to access the testable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = testableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(testableModelImpl.ENTITY_CACHE_ENABLED,
			testableModelImpl.FINDER_CACHE_ENABLED, testableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(testableModelImpl.ENTITY_CACHE_ENABLED,
			testableModelImpl.FINDER_CACHE_ENABLED, testableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(testableModelImpl.ENTITY_CACHE_ENABLED,
			testableModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public testablePersistenceImpl() {
		setModelClass(testable.class);
	}

	/**
	 * Caches the testable in the entity cache if it is enabled.
	 *
	 * @param testable the testable
	 */
	@Override
	public void cacheResult(testable testable) {
		entityCache.putResult(testableModelImpl.ENTITY_CACHE_ENABLED,
			testableImpl.class, testable.getPrimaryKey(), testable);

		testable.resetOriginalValues();
	}

	/**
	 * Caches the testables in the entity cache if it is enabled.
	 *
	 * @param testables the testables
	 */
	@Override
	public void cacheResult(List<testable> testables) {
		for (testable testable : testables) {
			if (entityCache.getResult(testableModelImpl.ENTITY_CACHE_ENABLED,
						testableImpl.class, testable.getPrimaryKey()) == null) {
				cacheResult(testable);
			}
			else {
				testable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all testables.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(testableImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the testable.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(testable testable) {
		entityCache.removeResult(testableModelImpl.ENTITY_CACHE_ENABLED,
			testableImpl.class, testable.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<testable> testables) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (testable testable : testables) {
			entityCache.removeResult(testableModelImpl.ENTITY_CACHE_ENABLED,
				testableImpl.class, testable.getPrimaryKey());
		}
	}

	/**
	 * Creates a new testable with the primary key. Does not add the testable to the database.
	 *
	 * @param aid the primary key for the new testable
	 * @return the new testable
	 */
	@Override
	public testable create(int aid) {
		testable testable = new testableImpl();

		testable.setNew(true);
		testable.setPrimaryKey(aid);

		return testable;
	}

	/**
	 * Removes the testable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param aid the primary key of the testable
	 * @return the testable that was removed
	 * @throws NoSuchtestableException if a testable with the primary key could not be found
	 */
	@Override
	public testable remove(int aid) throws NoSuchtestableException {
		return remove((Serializable)aid);
	}

	/**
	 * Removes the testable with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the testable
	 * @return the testable that was removed
	 * @throws NoSuchtestableException if a testable with the primary key could not be found
	 */
	@Override
	public testable remove(Serializable primaryKey)
		throws NoSuchtestableException {
		Session session = null;

		try {
			session = openSession();

			testable testable = (testable)session.get(testableImpl.class,
					primaryKey);

			if (testable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchtestableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(testable);
		}
		catch (NoSuchtestableException nsee) {
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
	protected testable removeImpl(testable testable) {
		testable = toUnwrappedModel(testable);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(testable)) {
				testable = (testable)session.get(testableImpl.class,
						testable.getPrimaryKeyObj());
			}

			if (testable != null) {
				session.delete(testable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (testable != null) {
			clearCache(testable);
		}

		return testable;
	}

	@Override
	public testable updateImpl(testable testable) {
		testable = toUnwrappedModel(testable);

		boolean isNew = testable.isNew();

		Session session = null;

		try {
			session = openSession();

			if (testable.isNew()) {
				session.save(testable);

				testable.setNew(false);
			}
			else {
				testable = (testable)session.merge(testable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(testableModelImpl.ENTITY_CACHE_ENABLED,
			testableImpl.class, testable.getPrimaryKey(), testable, false);

		testable.resetOriginalValues();

		return testable;
	}

	protected testable toUnwrappedModel(testable testable) {
		if (testable instanceof testableImpl) {
			return testable;
		}

		testableImpl testableImpl = new testableImpl();

		testableImpl.setNew(testable.isNew());
		testableImpl.setPrimaryKey(testable.getPrimaryKey());

		testableImpl.setAid(testable.getAid());
		testableImpl.setAname(testable.getAname());

		return testableImpl;
	}

	/**
	 * Returns the testable with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the testable
	 * @return the testable
	 * @throws NoSuchtestableException if a testable with the primary key could not be found
	 */
	@Override
	public testable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchtestableException {
		testable testable = fetchByPrimaryKey(primaryKey);

		if (testable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchtestableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return testable;
	}

	/**
	 * Returns the testable with the primary key or throws a {@link NoSuchtestableException} if it could not be found.
	 *
	 * @param aid the primary key of the testable
	 * @return the testable
	 * @throws NoSuchtestableException if a testable with the primary key could not be found
	 */
	@Override
	public testable findByPrimaryKey(int aid) throws NoSuchtestableException {
		return findByPrimaryKey((Serializable)aid);
	}

	/**
	 * Returns the testable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the testable
	 * @return the testable, or <code>null</code> if a testable with the primary key could not be found
	 */
	@Override
	public testable fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(testableModelImpl.ENTITY_CACHE_ENABLED,
				testableImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		testable testable = (testable)serializable;

		if (testable == null) {
			Session session = null;

			try {
				session = openSession();

				testable = (testable)session.get(testableImpl.class, primaryKey);

				if (testable != null) {
					cacheResult(testable);
				}
				else {
					entityCache.putResult(testableModelImpl.ENTITY_CACHE_ENABLED,
						testableImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(testableModelImpl.ENTITY_CACHE_ENABLED,
					testableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return testable;
	}

	/**
	 * Returns the testable with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param aid the primary key of the testable
	 * @return the testable, or <code>null</code> if a testable with the primary key could not be found
	 */
	@Override
	public testable fetchByPrimaryKey(int aid) {
		return fetchByPrimaryKey((Serializable)aid);
	}

	@Override
	public Map<Serializable, testable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, testable> map = new HashMap<Serializable, testable>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			testable testable = fetchByPrimaryKey(primaryKey);

			if (testable != null) {
				map.put(primaryKey, testable);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(testableModelImpl.ENTITY_CACHE_ENABLED,
					testableImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (testable)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TESTABLE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((int)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (testable testable : (List<testable>)q.list()) {
				map.put(testable.getPrimaryKeyObj(), testable);

				cacheResult(testable);

				uncachedPrimaryKeys.remove(testable.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(testableModelImpl.ENTITY_CACHE_ENABLED,
					testableImpl.class, primaryKey, nullModel);
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
	 * Returns all the testables.
	 *
	 * @return the testables
	 */
	@Override
	public List<testable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<testable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<testable> findAll(int start, int end,
		OrderByComparator<testable> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<testable> findAll(int start, int end,
		OrderByComparator<testable> orderByComparator, boolean retrieveFromCache) {
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

		List<testable> list = null;

		if (retrieveFromCache) {
			list = (List<testable>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TESTABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TESTABLE;

				if (pagination) {
					sql = sql.concat(testableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<testable>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<testable>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the testables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (testable testable : findAll()) {
			remove(testable);
		}
	}

	/**
	 * Returns the number of testables.
	 *
	 * @return the number of testables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TESTABLE);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return testableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the testable persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(testableImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TESTABLE = "SELECT testable FROM testable testable";
	private static final String _SQL_SELECT_TESTABLE_WHERE_PKS_IN = "SELECT testable FROM testable testable WHERE aid IN (";
	private static final String _SQL_COUNT_TESTABLE = "SELECT COUNT(testable) FROM testable testable";
	private static final String _ORDER_BY_ENTITY_ALIAS = "testable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No testable exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(testablePersistenceImpl.class);
}