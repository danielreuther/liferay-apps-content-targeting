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

package com.liferay.content.targeting.report.campaign.newsletter.model.impl;

import com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion;
import com.liferay.content.targeting.report.campaign.newsletter.model.ABVersionModel;
import com.liferay.content.targeting.report.campaign.newsletter.model.ABVersionSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ABVersion service. Represents a row in the &quot;CT_ABReport_ABVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.content.targeting.report.campaign.newsletter.model.ABVersionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ABVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ABVersionImpl
 * @see com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion
 * @see com.liferay.content.targeting.report.campaign.newsletter.model.ABVersionModel
 * @generated
 */
@JSON(strict = true)
public class ABVersionModelImpl extends BaseModelImpl<ABVersion>
	implements ABVersionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a a b version model instance should use the {@link com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion} interface instead.
	 */
	public static final String TABLE_NAME = "CT_ABReport_ABVersion";
	public static final Object[][] TABLE_COLUMNS = {
			{ "abversionId", Types.BIGINT },
			{ "campaignId", Types.BIGINT },
			{ "alias_", Types.VARCHAR },
			{ "viewsCount", Types.INTEGER },
			{ "goalCount", Types.INTEGER },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table CT_ABReport_ABVersion (abversionId LONG not null primary key,campaignId LONG,alias_ VARCHAR(75) null,viewsCount INTEGER,goalCount INTEGER,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table CT_ABReport_ABVersion";
	public static final String ORDER_BY_JPQL = " ORDER BY abVersion.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CT_ABReport_ABVersion.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion"),
			true);
	public static long ALIAS_COLUMN_BITMASK = 1L;
	public static long CAMPAIGNID_COLUMN_BITMASK = 2L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ABVersion toModel(ABVersionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ABVersion model = new ABVersionImpl();

		model.setAbversionId(soapModel.getAbversionId());
		model.setCampaignId(soapModel.getCampaignId());
		model.setAlias(soapModel.getAlias());
		model.setViewsCount(soapModel.getViewsCount());
		model.setGoalCount(soapModel.getGoalCount());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ABVersion> toModels(ABVersionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ABVersion> models = new ArrayList<ABVersion>(soapModels.length);

		for (ABVersionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion"));

	public ABVersionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _abversionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAbversionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _abversionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ABVersion.class;
	}

	@Override
	public String getModelClassName() {
		return ABVersion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("abversionId", getAbversionId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("alias", getAlias());
		attributes.put("viewsCount", getViewsCount());
		attributes.put("goalCount", getGoalCount());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long abversionId = (Long)attributes.get("abversionId");

		if (abversionId != null) {
			setAbversionId(abversionId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
		}

		Integer viewsCount = (Integer)attributes.get("viewsCount");

		if (viewsCount != null) {
			setViewsCount(viewsCount);
		}

		Integer goalCount = (Integer)attributes.get("goalCount");

		if (goalCount != null) {
			setGoalCount(goalCount);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@JSON
	@Override
	public long getAbversionId() {
		return _abversionId;
	}

	@Override
	public void setAbversionId(long abversionId) {
		_abversionId = abversionId;
	}

	@JSON
	@Override
	public long getCampaignId() {
		return _campaignId;
	}

	@Override
	public void setCampaignId(long campaignId) {
		_columnBitmask |= CAMPAIGNID_COLUMN_BITMASK;

		if (!_setOriginalCampaignId) {
			_setOriginalCampaignId = true;

			_originalCampaignId = _campaignId;
		}

		_campaignId = campaignId;
	}

	public long getOriginalCampaignId() {
		return _originalCampaignId;
	}

	@JSON
	@Override
	public String getAlias() {
		if (_alias == null) {
			return StringPool.BLANK;
		}
		else {
			return _alias;
		}
	}

	@Override
	public void setAlias(String alias) {
		_columnBitmask |= ALIAS_COLUMN_BITMASK;

		if (_originalAlias == null) {
			_originalAlias = _alias;
		}

		_alias = alias;
	}

	public String getOriginalAlias() {
		return GetterUtil.getString(_originalAlias);
	}

	@JSON
	@Override
	public int getViewsCount() {
		return _viewsCount;
	}

	@Override
	public void setViewsCount(int viewsCount) {
		_viewsCount = viewsCount;
	}

	@JSON
	@Override
	public int getGoalCount() {
		return _goalCount;
	}

	@Override
	public void setGoalCount(int goalCount) {
		_goalCount = goalCount;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ABVersion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ABVersion toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ABVersion)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ABVersionImpl abVersionImpl = new ABVersionImpl();

		abVersionImpl.setAbversionId(getAbversionId());
		abVersionImpl.setCampaignId(getCampaignId());
		abVersionImpl.setAlias(getAlias());
		abVersionImpl.setViewsCount(getViewsCount());
		abVersionImpl.setGoalCount(getGoalCount());
		abVersionImpl.setModifiedDate(getModifiedDate());

		abVersionImpl.resetOriginalValues();

		return abVersionImpl;
	}

	@Override
	public int compareTo(ABVersion abVersion) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				abVersion.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ABVersion)) {
			return false;
		}

		ABVersion abVersion = (ABVersion)obj;

		long primaryKey = abVersion.getPrimaryKey();

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
	public void resetOriginalValues() {
		ABVersionModelImpl abVersionModelImpl = this;

		abVersionModelImpl._originalCampaignId = abVersionModelImpl._campaignId;

		abVersionModelImpl._setOriginalCampaignId = false;

		abVersionModelImpl._originalAlias = abVersionModelImpl._alias;

		abVersionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ABVersion> toCacheModel() {
		ABVersionCacheModel abVersionCacheModel = new ABVersionCacheModel();

		abVersionCacheModel.abversionId = getAbversionId();

		abVersionCacheModel.campaignId = getCampaignId();

		abVersionCacheModel.alias = getAlias();

		String alias = abVersionCacheModel.alias;

		if ((alias != null) && (alias.length() == 0)) {
			abVersionCacheModel.alias = null;
		}

		abVersionCacheModel.viewsCount = getViewsCount();

		abVersionCacheModel.goalCount = getGoalCount();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			abVersionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			abVersionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return abVersionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{abversionId=");
		sb.append(getAbversionId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", alias=");
		sb.append(getAlias());
		sb.append(", viewsCount=");
		sb.append(getViewsCount());
		sb.append(", goalCount=");
		sb.append(getGoalCount());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>abversionId</column-name><column-value><![CDATA[");
		sb.append(getAbversionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>alias</column-name><column-value><![CDATA[");
		sb.append(getAlias());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewsCount</column-name><column-value><![CDATA[");
		sb.append(getViewsCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>goalCount</column-name><column-value><![CDATA[");
		sb.append(getGoalCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ABVersion.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ABVersion.class
		};
	private long _abversionId;
	private long _campaignId;
	private long _originalCampaignId;
	private boolean _setOriginalCampaignId;
	private String _alias;
	private String _originalAlias;
	private int _viewsCount;
	private int _goalCount;
	private Date _modifiedDate;
	private long _columnBitmask;
	private ABVersion _escapedModel;
}