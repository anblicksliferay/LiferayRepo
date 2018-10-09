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

import com.astra.anblicks.pdca.exception.NoSuchitemDescriptionException;
import com.astra.anblicks.pdca.model.itemDescription;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the item description service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.astra.anblicks.pdca.service.persistence.impl.itemDescriptionPersistenceImpl
 * @see itemDescriptionUtil
 * @generated
 */
@ProviderType
public interface itemDescriptionPersistence extends BasePersistence<itemDescription> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link itemDescriptionUtil} to access the item description persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the item descriptions where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching item descriptions
	*/
	public java.util.List<itemDescription> findByUuid(java.lang.String uuid);

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
	public java.util.List<itemDescription> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<itemDescription> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<itemDescription> orderByComparator);

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
	public java.util.List<itemDescription> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<itemDescription> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first item description in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item description
	* @throws NoSuchitemDescriptionException if a matching item description could not be found
	*/
	public itemDescription findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<itemDescription> orderByComparator)
		throws NoSuchitemDescriptionException;

	/**
	* Returns the first item description in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching item description, or <code>null</code> if a matching item description could not be found
	*/
	public itemDescription fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<itemDescription> orderByComparator);

	/**
	* Returns the last item description in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item description
	* @throws NoSuchitemDescriptionException if a matching item description could not be found
	*/
	public itemDescription findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<itemDescription> orderByComparator)
		throws NoSuchitemDescriptionException;

	/**
	* Returns the last item description in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching item description, or <code>null</code> if a matching item description could not be found
	*/
	public itemDescription fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<itemDescription> orderByComparator);

	/**
	* Returns the item descriptions before and after the current item description in the ordered set where uuid = &#63;.
	*
	* @param itemDescriptionId the primary key of the current item description
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next item description
	* @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	*/
	public itemDescription[] findByUuid_PrevAndNext(long itemDescriptionId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<itemDescription> orderByComparator)
		throws NoSuchitemDescriptionException;

	/**
	* Removes all the item descriptions where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of item descriptions where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching item descriptions
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Caches the item description in the entity cache if it is enabled.
	*
	* @param itemDescription the item description
	*/
	public void cacheResult(itemDescription itemDescription);

	/**
	* Caches the item descriptions in the entity cache if it is enabled.
	*
	* @param itemDescriptions the item descriptions
	*/
	public void cacheResult(java.util.List<itemDescription> itemDescriptions);

	/**
	* Creates a new item description with the primary key. Does not add the item description to the database.
	*
	* @param itemDescriptionId the primary key for the new item description
	* @return the new item description
	*/
	public itemDescription create(long itemDescriptionId);

	/**
	* Removes the item description with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemDescriptionId the primary key of the item description
	* @return the item description that was removed
	* @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	*/
	public itemDescription remove(long itemDescriptionId)
		throws NoSuchitemDescriptionException;

	public itemDescription updateImpl(itemDescription itemDescription);

	/**
	* Returns the item description with the primary key or throws a {@link NoSuchitemDescriptionException} if it could not be found.
	*
	* @param itemDescriptionId the primary key of the item description
	* @return the item description
	* @throws NoSuchitemDescriptionException if a item description with the primary key could not be found
	*/
	public itemDescription findByPrimaryKey(long itemDescriptionId)
		throws NoSuchitemDescriptionException;

	/**
	* Returns the item description with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemDescriptionId the primary key of the item description
	* @return the item description, or <code>null</code> if a item description with the primary key could not be found
	*/
	public itemDescription fetchByPrimaryKey(long itemDescriptionId);

	@Override
	public java.util.Map<java.io.Serializable, itemDescription> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the item descriptions.
	*
	* @return the item descriptions
	*/
	public java.util.List<itemDescription> findAll();

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
	public java.util.List<itemDescription> findAll(int start, int end);

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
	public java.util.List<itemDescription> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<itemDescription> orderByComparator);

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
	public java.util.List<itemDescription> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<itemDescription> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the item descriptions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of item descriptions.
	*
	* @return the number of item descriptions
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}