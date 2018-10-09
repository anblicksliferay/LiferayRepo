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

package com.astra.anblicks.pdca.service.base;

import aQute.bnd.annotation.ProviderType;

import com.astra.anblicks.pdca.model.achivementFormula;
import com.astra.anblicks.pdca.service.achivementFormulaLocalService;
import com.astra.anblicks.pdca.service.persistence.achivementFormulaPersistence;
import com.astra.anblicks.pdca.service.persistence.cla_kpiPersistence;
import com.astra.anblicks.pdca.service.persistence.companyPersistence;
import com.astra.anblicks.pdca.service.persistence.itemDescriptionPersistence;
import com.astra.anblicks.pdca.service.persistence.kpiPersistence;
import com.astra.anblicks.pdca.service.persistence.periodPersistence;
import com.astra.anblicks.pdca.service.persistence.tradingProfitPersistence;
import com.astra.anblicks.pdca.service.persistence.typePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the achivement formula local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.astra.anblicks.pdca.service.impl.achivementFormulaLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.impl.achivementFormulaLocalServiceImpl
 * @see com.astra.anblicks.pdca.service.achivementFormulaLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class achivementFormulaLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements achivementFormulaLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.astra.anblicks.pdca.service.achivementFormulaLocalServiceUtil} to access the achivement formula local service.
	 */

	/**
	 * Adds the achivement formula to the database. Also notifies the appropriate model listeners.
	 *
	 * @param achivementFormula the achivement formula
	 * @return the achivement formula that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public achivementFormula addachivementFormula(
		achivementFormula achivementFormula) {
		achivementFormula.setNew(true);

		return achivementFormulaPersistence.update(achivementFormula);
	}

	/**
	 * Creates a new achivement formula with the primary key. Does not add the achivement formula to the database.
	 *
	 * @param achivementFormulaId the primary key for the new achivement formula
	 * @return the new achivement formula
	 */
	@Override
	public achivementFormula createachivementFormula(long achivementFormulaId) {
		return achivementFormulaPersistence.create(achivementFormulaId);
	}

	/**
	 * Deletes the achivement formula with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param achivementFormulaId the primary key of the achivement formula
	 * @return the achivement formula that was removed
	 * @throws PortalException if a achivement formula with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public achivementFormula deleteachivementFormula(long achivementFormulaId)
		throws PortalException {
		return achivementFormulaPersistence.remove(achivementFormulaId);
	}

	/**
	 * Deletes the achivement formula from the database. Also notifies the appropriate model listeners.
	 *
	 * @param achivementFormula the achivement formula
	 * @return the achivement formula that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public achivementFormula deleteachivementFormula(
		achivementFormula achivementFormula) {
		return achivementFormulaPersistence.remove(achivementFormula);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(achivementFormula.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return achivementFormulaPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.achivementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return achivementFormulaPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.achivementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return achivementFormulaPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return achivementFormulaPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return achivementFormulaPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public achivementFormula fetchachivementFormula(long achivementFormulaId) {
		return achivementFormulaPersistence.fetchByPrimaryKey(achivementFormulaId);
	}

	/**
	 * Returns the achivement formula with the primary key.
	 *
	 * @param achivementFormulaId the primary key of the achivement formula
	 * @return the achivement formula
	 * @throws PortalException if a achivement formula with the primary key could not be found
	 */
	@Override
	public achivementFormula getachivementFormula(long achivementFormulaId)
		throws PortalException {
		return achivementFormulaPersistence.findByPrimaryKey(achivementFormulaId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(achivementFormulaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(achivementFormula.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("achivementFormulaId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(achivementFormulaLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(achivementFormula.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"achivementFormulaId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(achivementFormulaLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(achivementFormula.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("achivementFormulaId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return achivementFormulaLocalService.deleteachivementFormula((achivementFormula)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return achivementFormulaPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the achivement formulas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.achivementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of achivement formulas
	 * @param end the upper bound of the range of achivement formulas (not inclusive)
	 * @return the range of achivement formulas
	 */
	@Override
	public List<achivementFormula> getachivementFormulas(int start, int end) {
		return achivementFormulaPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of achivement formulas.
	 *
	 * @return the number of achivement formulas
	 */
	@Override
	public int getachivementFormulasCount() {
		return achivementFormulaPersistence.countAll();
	}

	/**
	 * Updates the achivement formula in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param achivementFormula the achivement formula
	 * @return the achivement formula that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public achivementFormula updateachivementFormula(
		achivementFormula achivementFormula) {
		return achivementFormulaPersistence.update(achivementFormula);
	}

	/**
	 * Returns the achivement formula local service.
	 *
	 * @return the achivement formula local service
	 */
	public achivementFormulaLocalService getachivementFormulaLocalService() {
		return achivementFormulaLocalService;
	}

	/**
	 * Sets the achivement formula local service.
	 *
	 * @param achivementFormulaLocalService the achivement formula local service
	 */
	public void setachivementFormulaLocalService(
		achivementFormulaLocalService achivementFormulaLocalService) {
		this.achivementFormulaLocalService = achivementFormulaLocalService;
	}

	/**
	 * Returns the achivement formula persistence.
	 *
	 * @return the achivement formula persistence
	 */
	public achivementFormulaPersistence getachivementFormulaPersistence() {
		return achivementFormulaPersistence;
	}

	/**
	 * Sets the achivement formula persistence.
	 *
	 * @param achivementFormulaPersistence the achivement formula persistence
	 */
	public void setachivementFormulaPersistence(
		achivementFormulaPersistence achivementFormulaPersistence) {
		this.achivementFormulaPersistence = achivementFormulaPersistence;
	}

	/**
	 * Returns the cla_kpi local service.
	 *
	 * @return the cla_kpi local service
	 */
	public com.astra.anblicks.pdca.service.cla_kpiLocalService getcla_kpiLocalService() {
		return cla_kpiLocalService;
	}

	/**
	 * Sets the cla_kpi local service.
	 *
	 * @param cla_kpiLocalService the cla_kpi local service
	 */
	public void setcla_kpiLocalService(
		com.astra.anblicks.pdca.service.cla_kpiLocalService cla_kpiLocalService) {
		this.cla_kpiLocalService = cla_kpiLocalService;
	}

	/**
	 * Returns the cla_kpi persistence.
	 *
	 * @return the cla_kpi persistence
	 */
	public cla_kpiPersistence getcla_kpiPersistence() {
		return cla_kpiPersistence;
	}

	/**
	 * Sets the cla_kpi persistence.
	 *
	 * @param cla_kpiPersistence the cla_kpi persistence
	 */
	public void setcla_kpiPersistence(cla_kpiPersistence cla_kpiPersistence) {
		this.cla_kpiPersistence = cla_kpiPersistence;
	}

	/**
	 * Returns the company local service.
	 *
	 * @return the company local service
	 */
	public com.astra.anblicks.pdca.service.companyLocalService getcompanyLocalService() {
		return companyLocalService;
	}

	/**
	 * Sets the company local service.
	 *
	 * @param companyLocalService the company local service
	 */
	public void setcompanyLocalService(
		com.astra.anblicks.pdca.service.companyLocalService companyLocalService) {
		this.companyLocalService = companyLocalService;
	}

	/**
	 * Returns the company persistence.
	 *
	 * @return the company persistence
	 */
	public companyPersistence getcompanyPersistence() {
		return companyPersistence;
	}

	/**
	 * Sets the company persistence.
	 *
	 * @param companyPersistence the company persistence
	 */
	public void setcompanyPersistence(companyPersistence companyPersistence) {
		this.companyPersistence = companyPersistence;
	}

	/**
	 * Returns the item description local service.
	 *
	 * @return the item description local service
	 */
	public com.astra.anblicks.pdca.service.itemDescriptionLocalService getitemDescriptionLocalService() {
		return itemDescriptionLocalService;
	}

	/**
	 * Sets the item description local service.
	 *
	 * @param itemDescriptionLocalService the item description local service
	 */
	public void setitemDescriptionLocalService(
		com.astra.anblicks.pdca.service.itemDescriptionLocalService itemDescriptionLocalService) {
		this.itemDescriptionLocalService = itemDescriptionLocalService;
	}

	/**
	 * Returns the item description persistence.
	 *
	 * @return the item description persistence
	 */
	public itemDescriptionPersistence getitemDescriptionPersistence() {
		return itemDescriptionPersistence;
	}

	/**
	 * Sets the item description persistence.
	 *
	 * @param itemDescriptionPersistence the item description persistence
	 */
	public void setitemDescriptionPersistence(
		itemDescriptionPersistence itemDescriptionPersistence) {
		this.itemDescriptionPersistence = itemDescriptionPersistence;
	}

	/**
	 * Returns the kpi local service.
	 *
	 * @return the kpi local service
	 */
	public com.astra.anblicks.pdca.service.kpiLocalService getkpiLocalService() {
		return kpiLocalService;
	}

	/**
	 * Sets the kpi local service.
	 *
	 * @param kpiLocalService the kpi local service
	 */
	public void setkpiLocalService(
		com.astra.anblicks.pdca.service.kpiLocalService kpiLocalService) {
		this.kpiLocalService = kpiLocalService;
	}

	/**
	 * Returns the kpi persistence.
	 *
	 * @return the kpi persistence
	 */
	public kpiPersistence getkpiPersistence() {
		return kpiPersistence;
	}

	/**
	 * Sets the kpi persistence.
	 *
	 * @param kpiPersistence the kpi persistence
	 */
	public void setkpiPersistence(kpiPersistence kpiPersistence) {
		this.kpiPersistence = kpiPersistence;
	}

	/**
	 * Returns the period local service.
	 *
	 * @return the period local service
	 */
	public com.astra.anblicks.pdca.service.periodLocalService getperiodLocalService() {
		return periodLocalService;
	}

	/**
	 * Sets the period local service.
	 *
	 * @param periodLocalService the period local service
	 */
	public void setperiodLocalService(
		com.astra.anblicks.pdca.service.periodLocalService periodLocalService) {
		this.periodLocalService = periodLocalService;
	}

	/**
	 * Returns the period persistence.
	 *
	 * @return the period persistence
	 */
	public periodPersistence getperiodPersistence() {
		return periodPersistence;
	}

	/**
	 * Sets the period persistence.
	 *
	 * @param periodPersistence the period persistence
	 */
	public void setperiodPersistence(periodPersistence periodPersistence) {
		this.periodPersistence = periodPersistence;
	}

	/**
	 * Returns the trading profit local service.
	 *
	 * @return the trading profit local service
	 */
	public com.astra.anblicks.pdca.service.tradingProfitLocalService gettradingProfitLocalService() {
		return tradingProfitLocalService;
	}

	/**
	 * Sets the trading profit local service.
	 *
	 * @param tradingProfitLocalService the trading profit local service
	 */
	public void settradingProfitLocalService(
		com.astra.anblicks.pdca.service.tradingProfitLocalService tradingProfitLocalService) {
		this.tradingProfitLocalService = tradingProfitLocalService;
	}

	/**
	 * Returns the trading profit persistence.
	 *
	 * @return the trading profit persistence
	 */
	public tradingProfitPersistence gettradingProfitPersistence() {
		return tradingProfitPersistence;
	}

	/**
	 * Sets the trading profit persistence.
	 *
	 * @param tradingProfitPersistence the trading profit persistence
	 */
	public void settradingProfitPersistence(
		tradingProfitPersistence tradingProfitPersistence) {
		this.tradingProfitPersistence = tradingProfitPersistence;
	}

	/**
	 * Returns the type local service.
	 *
	 * @return the type local service
	 */
	public com.astra.anblicks.pdca.service.typeLocalService gettypeLocalService() {
		return typeLocalService;
	}

	/**
	 * Sets the type local service.
	 *
	 * @param typeLocalService the type local service
	 */
	public void settypeLocalService(
		com.astra.anblicks.pdca.service.typeLocalService typeLocalService) {
		this.typeLocalService = typeLocalService;
	}

	/**
	 * Returns the type persistence.
	 *
	 * @return the type persistence
	 */
	public typePersistence gettypePersistence() {
		return typePersistence;
	}

	/**
	 * Sets the type persistence.
	 *
	 * @param typePersistence the type persistence
	 */
	public void settypePersistence(typePersistence typePersistence) {
		this.typePersistence = typePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.astra.anblicks.pdca.model.achivementFormula",
			achivementFormulaLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.astra.anblicks.pdca.model.achivementFormula");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return achivementFormulaLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return achivementFormula.class;
	}

	protected String getModelClassName() {
		return achivementFormula.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = achivementFormulaPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = achivementFormulaLocalService.class)
	protected achivementFormulaLocalService achivementFormulaLocalService;
	@BeanReference(type = achivementFormulaPersistence.class)
	protected achivementFormulaPersistence achivementFormulaPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.cla_kpiLocalService.class)
	protected com.astra.anblicks.pdca.service.cla_kpiLocalService cla_kpiLocalService;
	@BeanReference(type = cla_kpiPersistence.class)
	protected cla_kpiPersistence cla_kpiPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.companyLocalService.class)
	protected com.astra.anblicks.pdca.service.companyLocalService companyLocalService;
	@BeanReference(type = companyPersistence.class)
	protected companyPersistence companyPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.itemDescriptionLocalService.class)
	protected com.astra.anblicks.pdca.service.itemDescriptionLocalService itemDescriptionLocalService;
	@BeanReference(type = itemDescriptionPersistence.class)
	protected itemDescriptionPersistence itemDescriptionPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.kpiLocalService.class)
	protected com.astra.anblicks.pdca.service.kpiLocalService kpiLocalService;
	@BeanReference(type = kpiPersistence.class)
	protected kpiPersistence kpiPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.periodLocalService.class)
	protected com.astra.anblicks.pdca.service.periodLocalService periodLocalService;
	@BeanReference(type = periodPersistence.class)
	protected periodPersistence periodPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.tradingProfitLocalService.class)
	protected com.astra.anblicks.pdca.service.tradingProfitLocalService tradingProfitLocalService;
	@BeanReference(type = tradingProfitPersistence.class)
	protected tradingProfitPersistence tradingProfitPersistence;
	@BeanReference(type = com.astra.anblicks.pdca.service.typeLocalService.class)
	protected com.astra.anblicks.pdca.service.typeLocalService typeLocalService;
	@BeanReference(type = typePersistence.class)
	protected typePersistence typePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}