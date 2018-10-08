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
 * Provides a wrapper for {@link achivementFormulaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see achivementFormulaLocalService
 * @generated
 */
@ProviderType
public class achivementFormulaLocalServiceWrapper
	implements achivementFormulaLocalService,
		ServiceWrapper<achivementFormulaLocalService> {
	public achivementFormulaLocalServiceWrapper(
		achivementFormulaLocalService achivementFormulaLocalService) {
		_achivementFormulaLocalService = achivementFormulaLocalService;
	}

	/**
	* Adds the achivement formula to the database. Also notifies the appropriate model listeners.
	*
	* @param achivementFormula the achivement formula
	* @return the achivement formula that was added
	*/
	@Override
	public com.astra.anblicks.pdca.model.achivementFormula addachivementFormula(
		com.astra.anblicks.pdca.model.achivementFormula achivementFormula) {
		return _achivementFormulaLocalService.addachivementFormula(achivementFormula);
	}

	/**
	* Creates a new achivement formula with the primary key. Does not add the achivement formula to the database.
	*
	* @param achivementFormulaId the primary key for the new achivement formula
	* @return the new achivement formula
	*/
	@Override
	public com.astra.anblicks.pdca.model.achivementFormula createachivementFormula(
		long achivementFormulaId) {
		return _achivementFormulaLocalService.createachivementFormula(achivementFormulaId);
	}

	/**
	* Deletes the achivement formula from the database. Also notifies the appropriate model listeners.
	*
	* @param achivementFormula the achivement formula
	* @return the achivement formula that was removed
	*/
	@Override
	public com.astra.anblicks.pdca.model.achivementFormula deleteachivementFormula(
		com.astra.anblicks.pdca.model.achivementFormula achivementFormula) {
		return _achivementFormulaLocalService.deleteachivementFormula(achivementFormula);
	}

	/**
	* Deletes the achivement formula with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param achivementFormulaId the primary key of the achivement formula
	* @return the achivement formula that was removed
	* @throws PortalException if a achivement formula with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.achivementFormula deleteachivementFormula(
		long achivementFormulaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _achivementFormulaLocalService.deleteachivementFormula(achivementFormulaId);
	}

	@Override
	public com.astra.anblicks.pdca.model.achivementFormula fetchachivementFormula(
		long achivementFormulaId) {
		return _achivementFormulaLocalService.fetchachivementFormula(achivementFormulaId);
	}

	/**
	* Returns the achivement formula with the primary key.
	*
	* @param achivementFormulaId the primary key of the achivement formula
	* @return the achivement formula
	* @throws PortalException if a achivement formula with the primary key could not be found
	*/
	@Override
	public com.astra.anblicks.pdca.model.achivementFormula getachivementFormula(
		long achivementFormulaId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _achivementFormulaLocalService.getachivementFormula(achivementFormulaId);
	}

	/**
	* Updates the achivement formula in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param achivementFormula the achivement formula
	* @return the achivement formula that was updated
	*/
	@Override
	public com.astra.anblicks.pdca.model.achivementFormula updateachivementFormula(
		com.astra.anblicks.pdca.model.achivementFormula achivementFormula) {
		return _achivementFormulaLocalService.updateachivementFormula(achivementFormula);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _achivementFormulaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _achivementFormulaLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _achivementFormulaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _achivementFormulaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _achivementFormulaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of achivement formulas.
	*
	* @return the number of achivement formulas
	*/
	@Override
	public int getachivementFormulasCount() {
		return _achivementFormulaLocalService.getachivementFormulasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _achivementFormulaLocalService.getOSGiServiceIdentifier();
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
		return _achivementFormulaLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _achivementFormulaLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _achivementFormulaLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
	public java.util.List<com.astra.anblicks.pdca.model.achivementFormula> getachivementFormulas(
		int start, int end) {
		return _achivementFormulaLocalService.getachivementFormulas(start, end);
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
		return _achivementFormulaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _achivementFormulaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public achivementFormulaLocalService getWrappedService() {
		return _achivementFormulaLocalService;
	}

	@Override
	public void setWrappedService(
		achivementFormulaLocalService achivementFormulaLocalService) {
		_achivementFormulaLocalService = achivementFormulaLocalService;
	}

	private achivementFormulaLocalService _achivementFormulaLocalService;
}