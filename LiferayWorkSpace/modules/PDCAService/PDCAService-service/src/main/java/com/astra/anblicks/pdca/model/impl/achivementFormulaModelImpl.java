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
import com.astra.anblicks.pdca.model.achivementFormulaModel;
import com.astra.anblicks.pdca.model.achivementFormulaSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the achivementFormula service. Represents a row in the &quot;pdca_achivementFormula&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link achivementFormulaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link achivementFormulaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see achivementFormulaImpl
 * @see achivementFormula
 * @see achivementFormulaModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class achivementFormulaModelImpl extends BaseModelImpl<achivementFormula>
	implements achivementFormulaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a achivement formula model instance should use the {@link achivementFormula} interface instead.
	 */
	public static final String TABLE_NAME = "pdca_achivementFormula";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "achivementFormulaId", Types.BIGINT },
			{ "achivementFormula", Types.VARCHAR },
			{ "itemDescriptionId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("achivementFormulaId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("achivementFormula", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("itemDescriptionId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table pdca_achivementFormula (uuid_ VARCHAR(75) null,achivementFormulaId LONG not null primary key,achivementFormula VARCHAR(75) null,itemDescriptionId LONG)";
	public static final String TABLE_SQL_DROP = "drop table pdca_achivementFormula";
	public static final String ORDER_BY_JPQL = " ORDER BY achivementFormula.achivementFormulaId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY pdca_achivementFormula.achivementFormulaId ASC";
	public static final String DATA_SOURCE = "extDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.astra.anblicks.pdca.model.achivementFormula"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.astra.anblicks.pdca.model.achivementFormula"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.astra.anblicks.pdca.model.achivementFormula"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long ACHIVEMENTFORMULAID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static achivementFormula toModel(achivementFormulaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		achivementFormula model = new achivementFormulaImpl();

		model.setUuid(soapModel.getUuid());
		model.setAchivementFormulaId(soapModel.getAchivementFormulaId());
		model.setAchivementFormula(soapModel.getAchivementFormula());
		model.setItemDescriptionId(soapModel.getItemDescriptionId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<achivementFormula> toModels(
		achivementFormulaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<achivementFormula> models = new ArrayList<achivementFormula>(soapModels.length);

		for (achivementFormulaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.astra.anblicks.pdca.service.util.ServiceProps.get(
				"lock.expiration.time.com.astra.anblicks.pdca.model.achivementFormula"));

	public achivementFormulaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _achivementFormulaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAchivementFormulaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _achivementFormulaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return achivementFormula.class;
	}

	@Override
	public String getModelClassName() {
		return achivementFormula.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("achivementFormulaId", getAchivementFormulaId());
		attributes.put("achivementFormula", getAchivementFormula());
		attributes.put("itemDescriptionId", getItemDescriptionId());

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

		Long achivementFormulaId = (Long)attributes.get("achivementFormulaId");

		if (achivementFormulaId != null) {
			setAchivementFormulaId(achivementFormulaId);
		}

		String achivementFormula = (String)attributes.get("achivementFormula");

		if (achivementFormula != null) {
			setAchivementFormula(achivementFormula);
		}

		Long itemDescriptionId = (Long)attributes.get("itemDescriptionId");

		if (itemDescriptionId != null) {
			setItemDescriptionId(itemDescriptionId);
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
	public long getAchivementFormulaId() {
		return _achivementFormulaId;
	}

	@Override
	public void setAchivementFormulaId(long achivementFormulaId) {
		_achivementFormulaId = achivementFormulaId;
	}

	@JSON
	@Override
	public String getAchivementFormula() {
		if (_achivementFormula == null) {
			return StringPool.BLANK;
		}
		else {
			return _achivementFormula;
		}
	}

	@Override
	public void setAchivementFormula(String achivementFormula) {
		_achivementFormula = achivementFormula;
	}

	@JSON
	@Override
	public long getItemDescriptionId() {
		return _itemDescriptionId;
	}

	@Override
	public void setItemDescriptionId(long itemDescriptionId) {
		_itemDescriptionId = itemDescriptionId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			achivementFormula.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public achivementFormula toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (achivementFormula)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		achivementFormulaImpl achivementFormulaImpl = new achivementFormulaImpl();

		achivementFormulaImpl.setUuid(getUuid());
		achivementFormulaImpl.setAchivementFormulaId(getAchivementFormulaId());
		achivementFormulaImpl.setAchivementFormula(getAchivementFormula());
		achivementFormulaImpl.setItemDescriptionId(getItemDescriptionId());

		achivementFormulaImpl.resetOriginalValues();

		return achivementFormulaImpl;
	}

	@Override
	public int compareTo(achivementFormula achivementFormula) {
		long primaryKey = achivementFormula.getPrimaryKey();

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

		if (!(obj instanceof achivementFormula)) {
			return false;
		}

		achivementFormula achivementFormula = (achivementFormula)obj;

		long primaryKey = achivementFormula.getPrimaryKey();

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
		achivementFormulaModelImpl achivementFormulaModelImpl = this;

		achivementFormulaModelImpl._originalUuid = achivementFormulaModelImpl._uuid;

		achivementFormulaModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<achivementFormula> toCacheModel() {
		achivementFormulaCacheModel achivementFormulaCacheModel = new achivementFormulaCacheModel();

		achivementFormulaCacheModel.uuid = getUuid();

		String uuid = achivementFormulaCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			achivementFormulaCacheModel.uuid = null;
		}

		achivementFormulaCacheModel.achivementFormulaId = getAchivementFormulaId();

		achivementFormulaCacheModel.achivementFormula = getAchivementFormula();

		String achivementFormula = achivementFormulaCacheModel.achivementFormula;

		if ((achivementFormula != null) && (achivementFormula.length() == 0)) {
			achivementFormulaCacheModel.achivementFormula = null;
		}

		achivementFormulaCacheModel.itemDescriptionId = getItemDescriptionId();

		return achivementFormulaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", achivementFormulaId=");
		sb.append(getAchivementFormulaId());
		sb.append(", achivementFormula=");
		sb.append(getAchivementFormula());
		sb.append(", itemDescriptionId=");
		sb.append(getItemDescriptionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.astra.anblicks.pdca.model.achivementFormula");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>achivementFormulaId</column-name><column-value><![CDATA[");
		sb.append(getAchivementFormulaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>achivementFormula</column-name><column-value><![CDATA[");
		sb.append(getAchivementFormula());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemDescriptionId</column-name><column-value><![CDATA[");
		sb.append(getItemDescriptionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = achivementFormula.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			achivementFormula.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _achivementFormulaId;
	private String _achivementFormula;
	private long _itemDescriptionId;
	private long _columnBitmask;
	private achivementFormula _escapedModel;
}