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

import com.astra.anblicks.pdca.model.tradingProfit;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing tradingProfit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see tradingProfit
 * @generated
 */
@ProviderType
public class tradingProfitCacheModel implements CacheModel<tradingProfit>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof tradingProfitCacheModel)) {
			return false;
		}

		tradingProfitCacheModel tradingProfitCacheModel = (tradingProfitCacheModel)obj;

		if (tradingProfitId == tradingProfitCacheModel.tradingProfitId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tradingProfitId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", tradingProfitId=");
		sb.append(tradingProfitId);
		sb.append(", periodId=");
		sb.append(periodId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", year=");
		sb.append(year);
		sb.append(", npat=");
		sb.append(npat);
		sb.append(", netForex=");
		sb.append(netForex);
		sb.append(", ppeDispos=");
		sb.append(ppeDispos);
		sb.append(", revalutionOnPropertyInvestment=");
		sb.append(revalutionOnPropertyInvestment);
		sb.append(", investment=");
		sb.append(investment);
		sb.append(", taxExpense=");
		sb.append(taxExpense);
		sb.append(", impairmentOnAsset=");
		sb.append(impairmentOnAsset);
		sb.append(", others=");
		sb.append(others);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public tradingProfit toEntityModel() {
		tradingProfitImpl tradingProfitImpl = new tradingProfitImpl();

		if (uuid == null) {
			tradingProfitImpl.setUuid(StringPool.BLANK);
		}
		else {
			tradingProfitImpl.setUuid(uuid);
		}

		tradingProfitImpl.setTradingProfitId(tradingProfitId);
		tradingProfitImpl.setPeriodId(periodId);
		tradingProfitImpl.setCompanyId(companyId);
		tradingProfitImpl.setYear(year);
		tradingProfitImpl.setNpat(npat);
		tradingProfitImpl.setNetForex(netForex);
		tradingProfitImpl.setPpeDispos(ppeDispos);
		tradingProfitImpl.setRevalutionOnPropertyInvestment(revalutionOnPropertyInvestment);
		tradingProfitImpl.setInvestment(investment);
		tradingProfitImpl.setTaxExpense(taxExpense);
		tradingProfitImpl.setImpairmentOnAsset(impairmentOnAsset);
		tradingProfitImpl.setOthers(others);

		tradingProfitImpl.resetOriginalValues();

		return tradingProfitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		tradingProfitId = objectInput.readLong();

		periodId = objectInput.readLong();

		companyId = objectInput.readLong();

		year = objectInput.readLong();

		npat = objectInput.readDouble();

		netForex = objectInput.readDouble();

		ppeDispos = objectInput.readDouble();

		revalutionOnPropertyInvestment = objectInput.readDouble();

		investment = objectInput.readDouble();

		taxExpense = objectInput.readDouble();

		impairmentOnAsset = objectInput.readDouble();

		others = objectInput.readDouble();
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

		objectOutput.writeLong(tradingProfitId);

		objectOutput.writeLong(periodId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(year);

		objectOutput.writeDouble(npat);

		objectOutput.writeDouble(netForex);

		objectOutput.writeDouble(ppeDispos);

		objectOutput.writeDouble(revalutionOnPropertyInvestment);

		objectOutput.writeDouble(investment);

		objectOutput.writeDouble(taxExpense);

		objectOutput.writeDouble(impairmentOnAsset);

		objectOutput.writeDouble(others);
	}

	public String uuid;
	public long tradingProfitId;
	public long periodId;
	public long companyId;
	public long year;
	public double npat;
	public double netForex;
	public double ppeDispos;
	public double revalutionOnPropertyInvestment;
	public double investment;
	public double taxExpense;
	public double impairmentOnAsset;
	public double others;
}