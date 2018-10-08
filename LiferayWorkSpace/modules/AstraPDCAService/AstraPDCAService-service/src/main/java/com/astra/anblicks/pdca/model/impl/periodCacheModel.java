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

import com.astra.anblicks.pdca.model.period;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing period in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see period
 * @generated
 */
@ProviderType
public class periodCacheModel implements CacheModel<period>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof periodCacheModel)) {
			return false;
		}

		periodCacheModel periodCacheModel = (periodCacheModel)obj;

		if (periodId == periodCacheModel.periodId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, periodId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", periodId=");
		sb.append(periodId);
		sb.append(", periodName=");
		sb.append(periodName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public period toEntityModel() {
		periodImpl periodImpl = new periodImpl();

		if (uuid == null) {
			periodImpl.setUuid(StringPool.BLANK);
		}
		else {
			periodImpl.setUuid(uuid);
		}

		periodImpl.setPeriodId(periodId);

		if (periodName == null) {
			periodImpl.setPeriodName(StringPool.BLANK);
		}
		else {
			periodImpl.setPeriodName(periodName);
		}

		periodImpl.resetOriginalValues();

		return periodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		periodId = objectInput.readLong();
		periodName = objectInput.readUTF();
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

		objectOutput.writeLong(periodId);

		if (periodName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(periodName);
		}
	}

	public String uuid;
	public long periodId;
	public String periodName;
}