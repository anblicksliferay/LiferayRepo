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

import com.astra.anblicks.pdca.model.achivementFormula;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing achivementFormula in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see achivementFormula
 * @generated
 */
@ProviderType
public class achivementFormulaCacheModel implements CacheModel<achivementFormula>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof achivementFormulaCacheModel)) {
			return false;
		}

		achivementFormulaCacheModel achivementFormulaCacheModel = (achivementFormulaCacheModel)obj;

		if (achivementFormulaId == achivementFormulaCacheModel.achivementFormulaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, achivementFormulaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", achivementFormulaId=");
		sb.append(achivementFormulaId);
		sb.append(", achivementFormula=");
		sb.append(achivementFormula);
		sb.append(", itemDescriptionId=");
		sb.append(itemDescriptionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public achivementFormula toEntityModel() {
		achivementFormulaImpl achivementFormulaImpl = new achivementFormulaImpl();

		if (uuid == null) {
			achivementFormulaImpl.setUuid(StringPool.BLANK);
		}
		else {
			achivementFormulaImpl.setUuid(uuid);
		}

		achivementFormulaImpl.setAchivementFormulaId(achivementFormulaId);

		if (achivementFormula == null) {
			achivementFormulaImpl.setAchivementFormula(StringPool.BLANK);
		}
		else {
			achivementFormulaImpl.setAchivementFormula(achivementFormula);
		}

		achivementFormulaImpl.setItemDescriptionId(itemDescriptionId);

		achivementFormulaImpl.resetOriginalValues();

		return achivementFormulaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		achivementFormulaId = objectInput.readLong();
		achivementFormula = objectInput.readUTF();

		itemDescriptionId = objectInput.readLong();
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

		objectOutput.writeLong(achivementFormulaId);

		if (achivementFormula == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(achivementFormula);
		}

		objectOutput.writeLong(itemDescriptionId);
	}

	public String uuid;
	public long achivementFormulaId;
	public String achivementFormula;
	public long itemDescriptionId;
}