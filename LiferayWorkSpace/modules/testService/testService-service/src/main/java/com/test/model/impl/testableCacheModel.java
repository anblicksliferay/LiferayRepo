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

package com.test.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.test.model.testable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing testable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see testable
 * @generated
 */
@ProviderType
public class testableCacheModel implements CacheModel<testable>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof testableCacheModel)) {
			return false;
		}

		testableCacheModel testableCacheModel = (testableCacheModel)obj;

		if (aid == testableCacheModel.aid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, aid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{aid=");
		sb.append(aid);
		sb.append(", aname=");
		sb.append(aname);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public testable toEntityModel() {
		testableImpl testableImpl = new testableImpl();

		testableImpl.setAid(aid);

		if (aname == null) {
			testableImpl.setAname(StringPool.BLANK);
		}
		else {
			testableImpl.setAname(aname);
		}

		testableImpl.resetOriginalValues();

		return testableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		aid = objectInput.readInt();
		aname = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(aid);

		if (aname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(aname);
		}
	}

	public int aid;
	public String aname;
}