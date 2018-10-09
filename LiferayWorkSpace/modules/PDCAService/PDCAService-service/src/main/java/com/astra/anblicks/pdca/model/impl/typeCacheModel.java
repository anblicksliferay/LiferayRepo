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

import com.astra.anblicks.pdca.model.type;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing type in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see type
 * @generated
 */
@ProviderType
public class typeCacheModel implements CacheModel<type>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof typeCacheModel)) {
			return false;
		}

		typeCacheModel typeCacheModel = (typeCacheModel)obj;

		if (typeId == typeCacheModel.typeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, typeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", typeName=");
		sb.append(typeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public type toEntityModel() {
		typeImpl typeImpl = new typeImpl();

		if (uuid == null) {
			typeImpl.setUuid(StringPool.BLANK);
		}
		else {
			typeImpl.setUuid(uuid);
		}

		typeImpl.setTypeId(typeId);

		if (typeName == null) {
			typeImpl.setTypeName(StringPool.BLANK);
		}
		else {
			typeImpl.setTypeName(typeName);
		}

		typeImpl.resetOriginalValues();

		return typeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		typeId = objectInput.readLong();
		typeName = objectInput.readUTF();
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

		objectOutput.writeLong(typeId);

		if (typeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeName);
		}
	}

	public String uuid;
	public long typeId;
	public String typeName;
}