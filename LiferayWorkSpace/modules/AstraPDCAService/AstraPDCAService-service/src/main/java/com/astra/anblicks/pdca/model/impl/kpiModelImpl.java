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

import com.astra.anblicks.pdca.model.kpi;
import com.astra.anblicks.pdca.model.kpiModel;
import com.astra.anblicks.pdca.model.kpiSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the kpi service. Represents a row in the &quot;astra_kpi&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link kpiModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link kpiImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see kpiImpl
 * @see kpi
 * @see kpiModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class kpiModelImpl extends BaseModelImpl<kpi> implements kpiModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kpi model instance should use the {@link kpi} interface instead.
	 */
	public static final String TABLE_NAME = "astra_kpi";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "kpiId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "typeId", Types.BIGINT },
			{ "weight", Types.BIGINT },
			{ "target", Types.BIGINT },
			{ "year", Types.BIGINT },
			{ "unit", Types.VARCHAR },
			{ "achivementFormulaId", Types.BIGINT },
			{ "itemDescriptionName", Types.VARCHAR },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("kpiId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("typeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("weight", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("target", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("year", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("unit", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("achivementFormulaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("itemDescriptionName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table astra_kpi (uuid_ VARCHAR(75) null,kpiId LONG not null primary key,companyId LONG,typeId LONG,weight LONG,target LONG,year LONG,unit VARCHAR(75) null,achivementFormulaId LONG,itemDescriptionName VARCHAR(75) null,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table astra_kpi";
	public static final String ORDER_BY_JPQL = " ORDER BY kpi.kpiId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY astra_kpi.kpiId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.astra.anblicks.pdca.model.kpi"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.astra.anblicks.pdca.model.kpi"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.astra.anblicks.pdca.model.kpi"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long KPIID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static kpi toModel(kpiSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		kpi model = new kpiImpl();

		model.setUuid(soapModel.getUuid());
		model.setKpiId(soapModel.getKpiId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setTypeId(soapModel.getTypeId());
		model.setWeight(soapModel.getWeight());
		model.setTarget(soapModel.getTarget());
		model.setYear(soapModel.getYear());
		model.setUnit(soapModel.getUnit());
		model.setAchivementFormulaId(soapModel.getAchivementFormulaId());
		model.setItemDescriptionName(soapModel.getItemDescriptionName());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<kpi> toModels(kpiSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<kpi> models = new ArrayList<kpi>(soapModels.length);

		for (kpiSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"lock.expiration.time.com.astra.anblicks.pdca.model.kpi"));

	public kpiModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _kpiId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKpiId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kpiId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return kpi.class;
	}

	@Override
	public String getModelClassName() {
		return kpi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("kpiId", getKpiId());
		attributes.put("companyId", getCompanyId());
		attributes.put("typeId", getTypeId());
		attributes.put("weight", getWeight());
		attributes.put("target", getTarget());
		attributes.put("year", getYear());
		attributes.put("unit", getUnit());
		attributes.put("achivementFormulaId", getAchivementFormulaId());
		attributes.put("itemDescriptionName", getItemDescriptionName());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long kpiId = (Long)attributes.get("kpiId");

		if (kpiId != null) {
			setKpiId(kpiId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		Long weight = (Long)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Long target = (Long)attributes.get("target");

		if (target != null) {
			setTarget(target);
		}

		Long year = (Long)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String unit = (String)attributes.get("unit");

		if (unit != null) {
			setUnit(unit);
		}

		Long achivementFormulaId = (Long)attributes.get("achivementFormulaId");

		if (achivementFormulaId != null) {
			setAchivementFormulaId(achivementFormulaId);
		}

		String itemDescriptionName = (String)attributes.get(
				"itemDescriptionName");

		if (itemDescriptionName != null) {
			setItemDescriptionName(itemDescriptionName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getKpiId() {
		return _kpiId;
	}

	@Override
	public void setKpiId(long kpiId) {
		_kpiId = kpiId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	@JSON
	@Override
	public long getWeight() {
		return _weight;
	}

	@Override
	public void setWeight(long weight) {
		_weight = weight;
	}

	@JSON
	@Override
	public long getTarget() {
		return _target;
	}

	@Override
	public void setTarget(long target) {
		_target = target;
	}

	@JSON
	@Override
	public long getYear() {
		return _year;
	}

	@Override
	public void setYear(long year) {
		_year = year;
	}

	@JSON
	@Override
	public String getUnit() {
		if (_unit == null) {
			return StringPool.BLANK;
		}
		else {
			return _unit;
		}
	}

	@Override
	public void setUnit(String unit) {
		_unit = unit;
	}

	@JSON
	@Override
	public long getAchivementFormulaId() {
		return _achivementFormulaId;
	}

	@Override
	public void setAchivementFormulaId(long achivementFormulaId) {
		_achivementFormulaId = achivementFormulaId;
	}

	@JSON
	@Override
	public String getItemDescriptionName() {
		if (_itemDescriptionName == null) {
			return StringPool.BLANK;
		}
		else {
			return _itemDescriptionName;
		}
	}

	@Override
	public void setItemDescriptionName(String itemDescriptionName) {
		_itemDescriptionName = itemDescriptionName;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				kpi.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			kpi.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public kpi toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (kpi)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		kpiImpl kpiImpl = new kpiImpl();

		kpiImpl.setUuid(getUuid());
		kpiImpl.setKpiId(getKpiId());
		kpiImpl.setCompanyId(getCompanyId());
		kpiImpl.setTypeId(getTypeId());
		kpiImpl.setWeight(getWeight());
		kpiImpl.setTarget(getTarget());
		kpiImpl.setYear(getYear());
		kpiImpl.setUnit(getUnit());
		kpiImpl.setAchivementFormulaId(getAchivementFormulaId());
		kpiImpl.setItemDescriptionName(getItemDescriptionName());
		kpiImpl.setUserId(getUserId());
		kpiImpl.setUserName(getUserName());
		kpiImpl.setCreateDate(getCreateDate());
		kpiImpl.setModifiedDate(getModifiedDate());

		kpiImpl.resetOriginalValues();

		return kpiImpl;
	}

	@Override
	public int compareTo(kpi kpi) {
		long primaryKey = kpi.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof kpi)) {
			return false;
		}

		kpi kpi = (kpi)obj;

		long primaryKey = kpi.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		kpiModelImpl kpiModelImpl = this;

		kpiModelImpl._originalUuid = kpiModelImpl._uuid;

		kpiModelImpl._originalCompanyId = kpiModelImpl._companyId;

		kpiModelImpl._setOriginalCompanyId = false;

		kpiModelImpl._setModifiedDate = false;

		kpiModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<kpi> toCacheModel() {
		kpiCacheModel kpiCacheModel = new kpiCacheModel();

		kpiCacheModel.uuid = getUuid();

		String uuid = kpiCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			kpiCacheModel.uuid = null;
		}

		kpiCacheModel.kpiId = getKpiId();

		kpiCacheModel.companyId = getCompanyId();

		kpiCacheModel.typeId = getTypeId();

		kpiCacheModel.weight = getWeight();

		kpiCacheModel.target = getTarget();

		kpiCacheModel.year = getYear();

		kpiCacheModel.unit = getUnit();

		String unit = kpiCacheModel.unit;

		if ((unit != null) && (unit.length() == 0)) {
			kpiCacheModel.unit = null;
		}

		kpiCacheModel.achivementFormulaId = getAchivementFormulaId();

		kpiCacheModel.itemDescriptionName = getItemDescriptionName();

		String itemDescriptionName = kpiCacheModel.itemDescriptionName;

		if ((itemDescriptionName != null) &&
				(itemDescriptionName.length() == 0)) {
			kpiCacheModel.itemDescriptionName = null;
		}

		kpiCacheModel.userId = getUserId();

		kpiCacheModel.userName = getUserName();

		String userName = kpiCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kpiCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kpiCacheModel.createDate = createDate.getTime();
		}
		else {
			kpiCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kpiCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kpiCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return kpiCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", kpiId=");
		sb.append(getKpiId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", typeId=");
		sb.append(getTypeId());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append(", target=");
		sb.append(getTarget());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", unit=");
		sb.append(getUnit());
		sb.append(", achivementFormulaId=");
		sb.append(getAchivementFormulaId());
		sb.append(", itemDescriptionName=");
		sb.append(getItemDescriptionName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.astra.anblicks.pdca.model.kpi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kpiId</column-name><column-value><![CDATA[");
		sb.append(getKpiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight</column-name><column-value><![CDATA[");
		sb.append(getWeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>target</column-name><column-value><![CDATA[");
		sb.append(getTarget());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unit</column-name><column-value><![CDATA[");
		sb.append(getUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>achivementFormulaId</column-name><column-value><![CDATA[");
		sb.append(getAchivementFormulaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemDescriptionName</column-name><column-value><![CDATA[");
		sb.append(getItemDescriptionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = kpi.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			kpi.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _kpiId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _typeId;
	private long _weight;
	private long _target;
	private long _year;
	private String _unit;
	private long _achivementFormulaId;
	private String _itemDescriptionName;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private kpi _escapedModel;
}