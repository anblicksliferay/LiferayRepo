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

package com.astra.anblicks.pdca.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link tradingProfitLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see tradingProfitLocalService
 * @generated
 */
@ProviderType
public class tradingProfitLocalServiceWrapper
	implements tradingProfitLocalService,
		ServiceWrapper<tradingProfitLocalService> {
	public tradingProfitLocalServiceWrapper(
		tradingProfitLocalService tradingProfitLocalService) {
		_tradingProfitLocalService = tradingProfitLocalService;
	}

	/**
	* Adds the trading profit to the database. Also notifies the appropriate model listeners.
	*
	* @param tradingProfit the trading profit
	* @return the trading profit that was added
	*/
	@Override
	public com.astra.anblicks.pdca.model.tradingProfit addtradingProfit(
		com.astra.anblicks.pdca.model.tradingProfit tradingProfit) {
		return _tradingProfitLocalService.addtradingProfit(tradingProfit);
	}

	/**
	* Creates a new trading profit with the primary key. Does not add the trading profit to the database.
	*
	* @param tradingProfitId the primary key for the new trading profit
	* @return the new trading profit
	*/
	@Override
	public com.astra.anblicks.pdca.model.tradingProfit createtradingProfit(
		long tradingProfitId) {
		return _tradingProfitLocalService.createtradingProfit(tradingProfitId);
	}

	/**
	* Deletes the trading profit from the database. Also notifies the appropriate model listeners.
	*
	* @param tradingProfit the trading profit
	* @return the trading profit that was removed
	*/
	@Override
	public com.astra.anblicks.pdca.model.tradingProfit deletetradingProfit(
		com.astra.anblicks.pdca.model.tradingProfit tradingProfit) {
		return _tradingProfitLocalService.deletetradingProfit(tradingProfit);
	}

	/**
	* Deletes the trading profit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tradingProfitId the primary key of the trading profit
	* @return the trading profit that was removed
	* @throws PortalException if a trading profit with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.tradingProfit deletetradingProfit(
		long tradingProfitId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tradingProfitLocalService.deletetradingProfit(tradingProfitId);
	}

	@Override
	public com.astra.anblicks.pdca.model.tradingProfit fetchtradingProfit(
		long tradingProfitId) {
		return _tradingProfitLocalService.fetchtradingProfit(tradingProfitId);
	}

	/**
	* Returns the trading profit with the matching UUID and company.
	*
	* @param uuid the trading profit's UUID
	* @param companyId the primary key of the company
	* @return the matching trading profit, or <code>null</code> if a matching trading profit could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.tradingProfit fetchtradingProfitByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _tradingProfitLocalService.fetchtradingProfitByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the trading profit with the primary key.
	*
	* @param tradingProfitId the primary key of the trading profit
	* @return the trading profit
	* @throws PortalException if a trading profit with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.tradingProfit gettradingProfit(
		long tradingProfitId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tradingProfitLocalService.gettradingProfit(tradingProfitId);
	}

	/**
	* Returns the trading profit with the matching UUID and company.
	*
	* @param uuid the trading profit's UUID
	* @param companyId the primary key of the company
	* @return the matching trading profit
	* @throws PortalException if a matching trading profit could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.tradingProfit gettradingProfitByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tradingProfitLocalService.gettradingProfitByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Updates the trading profit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tradingProfit the trading profit
	* @return the trading profit that was updated
	*/
	@Override
	public com.astra.anblicks.pdca.model.tradingProfit updatetradingProfit(
		com.astra.anblicks.pdca.model.tradingProfit tradingProfit) {
		return _tradingProfitLocalService.updatetradingProfit(tradingProfit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tradingProfitLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tradingProfitLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _tradingProfitLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tradingProfitLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tradingProfitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of trading profits.
	*
	* @return the number of trading profits
	*/
	@Override
	public int gettradingProfitsCount() {
		return _tradingProfitLocalService.gettradingProfitsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tradingProfitLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _tradingProfitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _tradingProfitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _tradingProfitLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the trading profits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.astra.anblicks.pdca.model.impl.tradingProfitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of trading profits
	* @param end the upper bound of the range of trading profits (not inclusive)
	* @return the range of trading profits
	*/
	@Override
	public java.util.List<com.astra.anblicks.pdca.model.tradingProfit> gettradingProfits(
		int start, int end) {
		return _tradingProfitLocalService.gettradingProfits(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _tradingProfitLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _tradingProfitLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public tradingProfitLocalService getWrappedService() {
		return _tradingProfitLocalService;
	}

	@Override
	public void setWrappedService(
		tradingProfitLocalService tradingProfitLocalService) {
		_tradingProfitLocalService = tradingProfitLocalService;
	}

	private tradingProfitLocalService _tradingProfitLocalService;
}