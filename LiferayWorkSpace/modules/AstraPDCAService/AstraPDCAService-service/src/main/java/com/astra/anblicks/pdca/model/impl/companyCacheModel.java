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

import com.astra.anblicks.pdca.model.company;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing company in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see company
 * @generated
 */
@ProviderType
public class companyCacheModel implements CacheModel<company>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof companyCacheModel)) {
			return false;
		}

		companyCacheModel companyCacheModel = (companyCacheModel)obj;

		if (companyId == companyCacheModel.companyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, companyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public company toEntityModel() {
		companyImpl companyImpl = new companyImpl();

		if (uuid == null) {
			companyImpl.setUuid(StringPool.BLANK);
		}
		else {
			companyImpl.setUuid(uuid);
		}

		companyImpl.setCompanyId(companyId);

		if (companyName == null) {
			companyImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			companyImpl.setCompanyName(companyName);
		}

		companyImpl.resetOriginalValues();

		return companyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		companyId = objectInput.readLong();
		companyName = objectInput.readUTF();
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

		objectOutput.writeLong(companyId);

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}
	}

	public String uuid;
	public long companyId;
	public String companyName;
}