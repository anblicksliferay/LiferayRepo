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

package com.astra.anblicks.pdca.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.astra.anblicks.pdca.model.itemDescription;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing itemDescription in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see itemDescription
 * @generated
 */
@ProviderType
public class itemDescriptionCacheModel implements CacheModel<itemDescription>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof itemDescriptionCacheModel)) {
			return false;
		}

		itemDescriptionCacheModel itemDescriptionCacheModel = (itemDescriptionCacheModel)obj;

		if (itemDescriptionId == itemDescriptionCacheModel.itemDescriptionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, itemDescriptionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", itemDescriptionId=");
		sb.append(itemDescriptionId);
		sb.append(", itemDescriptionName=");
		sb.append(itemDescriptionName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public itemDescription toEntityModel() {
		itemDescriptionImpl itemDescriptionImpl = new itemDescriptionImpl();

		if (uuid == null) {
			itemDescriptionImpl.setUuid(StringPool.BLANK);
		}
		else {
			itemDescriptionImpl.setUuid(uuid);
		}

		itemDescriptionImpl.setItemDescriptionId(itemDescriptionId);

		if (itemDescriptionName == null) {
			itemDescriptionImpl.setItemDescriptionName(StringPool.BLANK);
		}
		else {
			itemDescriptionImpl.setItemDescriptionName(itemDescriptionName);
		}

		itemDescriptionImpl.resetOriginalValues();

		return itemDescriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		itemDescriptionId = objectInput.readLong();
		itemDescriptionName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(itemDescriptionId);

		if (itemDescriptionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemDescriptionName);
		}
	}

	public String uuid;
	public long itemDescriptionId;
	public String itemDescriptionName;
}