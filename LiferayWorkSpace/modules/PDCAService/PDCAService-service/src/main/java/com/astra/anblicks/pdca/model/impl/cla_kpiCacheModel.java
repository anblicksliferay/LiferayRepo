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

import com.astra.anblicks.pdca.model.cla_kpi;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing cla_kpi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see cla_kpi
 * @generated
 */
@ProviderType
public class cla_kpiCacheModel implements CacheModel<cla_kpi>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof cla_kpiCacheModel)) {
			return false;
		}

		cla_kpiCacheModel cla_kpiCacheModel = (cla_kpiCacheModel)obj;

		if (claKpiId == cla_kpiCacheModel.claKpiId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, claKpiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", claKpiId=");
		sb.append(claKpiId);
		sb.append(", kpiId=");
		sb.append(kpiId);
		sb.append(", periodId=");
		sb.append(periodId);
		sb.append(", ytd=");
		sb.append(ytd);
		sb.append(", ol=");
		sb.append(ol);
		sb.append(", claPoint=");
		sb.append(claPoint);
		sb.append(", achivement=");
		sb.append(achivement);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public cla_kpi toEntityModel() {
		cla_kpiImpl cla_kpiImpl = new cla_kpiImpl();

		if (uuid == null) {
			cla_kpiImpl.setUuid(StringPool.BLANK);
		}
		else {
			cla_kpiImpl.setUuid(uuid);
		}

		cla_kpiImpl.setClaKpiId(claKpiId);
		cla_kpiImpl.setKpiId(kpiId);
		cla_kpiImpl.setPeriodId(periodId);
		cla_kpiImpl.setYtd(ytd);
		cla_kpiImpl.setOl(ol);
		cla_kpiImpl.setClaPoint(claPoint);
		cla_kpiImpl.setAchivement(achivement);

		cla_kpiImpl.resetOriginalValues();

		return cla_kpiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		claKpiId = objectInput.readLong();

		kpiId = objectInput.readLong();

		periodId = objectInput.readLong();

		ytd = objectInput.readLong();

		ol = objectInput.readDouble();

		claPoint = objectInput.readDouble();

		achivement = objectInput.readDouble();
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

		objectOutput.writeLong(claKpiId);

		objectOutput.writeLong(kpiId);

		objectOutput.writeLong(periodId);

		objectOutput.writeLong(ytd);

		objectOutput.writeDouble(ol);

		objectOutput.writeDouble(claPoint);

		objectOutput.writeDouble(achivement);
	}

	public String uuid;
	public long claKpiId;
	public long kpiId;
	public long periodId;
	public long ytd;
	public double ol;
	public double claPoint;
	public double achivement;
}