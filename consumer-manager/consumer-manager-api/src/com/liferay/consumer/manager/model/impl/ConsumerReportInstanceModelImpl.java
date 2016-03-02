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

package com.liferay.consumer.manager.model.impl;

import com.liferay.consumer.manager.model.ConsumerReportInstance;
import com.liferay.consumer.manager.model.ConsumerReportInstanceModel;
import com.liferay.consumer.manager.model.ConsumerReportInstanceSoap;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the ConsumerReportInstance service. Represents a row in the &quot;CM_ConsumerReportInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.consumer.manager.model.ConsumerReportInstanceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ConsumerReportInstanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsumerReportInstanceImpl
 * @see com.liferay.consumer.manager.model.ConsumerReportInstance
 * @see com.liferay.consumer.manager.model.ConsumerReportInstanceModel
 * @generated
 */
@JSON(strict = true)
public class ConsumerReportInstanceModelImpl extends BaseModelImpl<ConsumerReportInstance>
	implements ConsumerReportInstanceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a consumer report instance model instance should use the {@link com.liferay.consumer.manager.model.ConsumerReportInstance} interface instead.
	 */
	public static final String TABLE_NAME = "CM_ConsumerReportInstance";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "consumerReportInstanceId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "consumerId", Types.BIGINT },
			{ "reportCategoryKey", Types.VARCHAR },
			{ "reportKey", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "typeSettings", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table CM_ConsumerReportInstance (uuid_ VARCHAR(75) null,consumerReportInstanceId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,consumerId LONG,reportCategoryKey VARCHAR(75) null,reportKey VARCHAR(75) null,name STRING null,description STRING null,typeSettings VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table CM_ConsumerReportInstance";
	public static final String ORDER_BY_JPQL = " ORDER BY consumerReportInstance.reportKey DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CM_ConsumerReportInstance.reportKey DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.consumer.manager.model.ConsumerReportInstance"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.consumer.manager.model.ConsumerReportInstance"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.consumer.manager.model.ConsumerReportInstance"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long CONSUMERID_COLUMN_BITMASK = 2L;
	public static long REPORTCATEGORYKEY_COLUMN_BITMASK = 4L;
	public static long REPORTKEY_COLUMN_BITMASK = 8L;
	public static long UUID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ConsumerReportInstance toModel(
		ConsumerReportInstanceSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ConsumerReportInstance model = new ConsumerReportInstanceImpl();

		model.setUuid(soapModel.getUuid());
		model.setConsumerReportInstanceId(soapModel.getConsumerReportInstanceId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setConsumerId(soapModel.getConsumerId());
		model.setReportCategoryKey(soapModel.getReportCategoryKey());
		model.setReportKey(soapModel.getReportKey());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setTypeSettings(soapModel.getTypeSettings());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ConsumerReportInstance> toModels(
		ConsumerReportInstanceSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ConsumerReportInstance> models = new ArrayList<ConsumerReportInstance>(soapModels.length);

		for (ConsumerReportInstanceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.consumer.manager.model.ConsumerReportInstance"));

	public ConsumerReportInstanceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _consumerReportInstanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setConsumerReportInstanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _consumerReportInstanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ConsumerReportInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ConsumerReportInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("consumerReportInstanceId", getConsumerReportInstanceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("consumerId", getConsumerId());
		attributes.put("reportCategoryKey", getReportCategoryKey());
		attributes.put("reportKey", getReportKey());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("typeSettings", getTypeSettings());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long consumerReportInstanceId = (Long)attributes.get(
				"consumerReportInstanceId");

		if (consumerReportInstanceId != null) {
			setConsumerReportInstanceId(consumerReportInstanceId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long consumerId = (Long)attributes.get("consumerId");

		if (consumerId != null) {
			setConsumerId(consumerId);
		}

		String reportCategoryKey = (String)attributes.get("reportCategoryKey");

		if (reportCategoryKey != null) {
			setReportCategoryKey(reportCategoryKey);
		}

		String reportKey = (String)attributes.get("reportKey");

		if (reportKey != null) {
			setReportKey(reportKey);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String typeSettings = (String)attributes.get("typeSettings");

		if (typeSettings != null) {
			setTypeSettings(typeSettings);
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
	public long getConsumerReportInstanceId() {
		return _consumerReportInstanceId;
	}

	@Override
	public void setConsumerReportInstanceId(long consumerReportInstanceId) {
		_consumerReportInstanceId = consumerReportInstanceId;
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
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getConsumerId() {
		return _consumerId;
	}

	@Override
	public void setConsumerId(long consumerId) {
		_columnBitmask |= CONSUMERID_COLUMN_BITMASK;

		if (!_setOriginalConsumerId) {
			_setOriginalConsumerId = true;

			_originalConsumerId = _consumerId;
		}

		_consumerId = consumerId;
	}

	public long getOriginalConsumerId() {
		return _originalConsumerId;
	}

	@JSON
	@Override
	public String getReportCategoryKey() {
		if (_reportCategoryKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _reportCategoryKey;
		}
	}

	@Override
	public void setReportCategoryKey(String reportCategoryKey) {
		_columnBitmask |= REPORTCATEGORYKEY_COLUMN_BITMASK;

		if (_originalReportCategoryKey == null) {
			_originalReportCategoryKey = _reportCategoryKey;
		}

		_reportCategoryKey = reportCategoryKey;
	}

	public String getOriginalReportCategoryKey() {
		return GetterUtil.getString(_originalReportCategoryKey);
	}

	@JSON
	@Override
	public String getReportKey() {
		if (_reportKey == null) {
			return StringPool.BLANK;
		}
		else {
			return _reportKey;
		}
	}

	@Override
	public void setReportKey(String reportKey) {
		_columnBitmask = -1L;

		if (_originalReportKey == null) {
			_originalReportKey = _reportKey;
		}

		_reportKey = reportKey;
	}

	public String getOriginalReportKey() {
		return GetterUtil.getString(_originalReportKey);
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(LocalizationUtil.updateLocalization(nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDescription(), languageId,
			useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(String description, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale) {
		if (descriptionMap == null) {
			return;
		}

		setDescription(LocalizationUtil.updateLocalization(descriptionMap,
				getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getTypeSettings() {
		if (_typeSettings == null) {
			return StringPool.BLANK;
		}
		else {
			return _typeSettings;
		}
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ConsumerReportInstance.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ConsumerReportInstance.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(getDescription(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public ConsumerReportInstance toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ConsumerReportInstance)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ConsumerReportInstanceImpl consumerReportInstanceImpl = new ConsumerReportInstanceImpl();

		consumerReportInstanceImpl.setUuid(getUuid());
		consumerReportInstanceImpl.setConsumerReportInstanceId(getConsumerReportInstanceId());
		consumerReportInstanceImpl.setCompanyId(getCompanyId());
		consumerReportInstanceImpl.setUserId(getUserId());
		consumerReportInstanceImpl.setUserName(getUserName());
		consumerReportInstanceImpl.setCreateDate(getCreateDate());
		consumerReportInstanceImpl.setModifiedDate(getModifiedDate());
		consumerReportInstanceImpl.setConsumerId(getConsumerId());
		consumerReportInstanceImpl.setReportCategoryKey(getReportCategoryKey());
		consumerReportInstanceImpl.setReportKey(getReportKey());
		consumerReportInstanceImpl.setName(getName());
		consumerReportInstanceImpl.setDescription(getDescription());
		consumerReportInstanceImpl.setTypeSettings(getTypeSettings());

		consumerReportInstanceImpl.resetOriginalValues();

		return consumerReportInstanceImpl;
	}

	@Override
	public int compareTo(ConsumerReportInstance consumerReportInstance) {
		int value = 0;

		value = getReportKey().compareTo(consumerReportInstance.getReportKey());

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

		if (!(obj instanceof ConsumerReportInstance)) {
			return false;
		}

		ConsumerReportInstance consumerReportInstance = (ConsumerReportInstance)obj;

		long primaryKey = consumerReportInstance.getPrimaryKey();

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
		ConsumerReportInstanceModelImpl consumerReportInstanceModelImpl = this;

		consumerReportInstanceModelImpl._originalUuid = consumerReportInstanceModelImpl._uuid;

		consumerReportInstanceModelImpl._originalCompanyId = consumerReportInstanceModelImpl._companyId;

		consumerReportInstanceModelImpl._setOriginalCompanyId = false;

		consumerReportInstanceModelImpl._originalConsumerId = consumerReportInstanceModelImpl._consumerId;

		consumerReportInstanceModelImpl._setOriginalConsumerId = false;

		consumerReportInstanceModelImpl._originalReportCategoryKey = consumerReportInstanceModelImpl._reportCategoryKey;

		consumerReportInstanceModelImpl._originalReportKey = consumerReportInstanceModelImpl._reportKey;

		consumerReportInstanceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ConsumerReportInstance> toCacheModel() {
		ConsumerReportInstanceCacheModel consumerReportInstanceCacheModel = new ConsumerReportInstanceCacheModel();

		consumerReportInstanceCacheModel.uuid = getUuid();

		String uuid = consumerReportInstanceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			consumerReportInstanceCacheModel.uuid = null;
		}

		consumerReportInstanceCacheModel.consumerReportInstanceId = getConsumerReportInstanceId();

		consumerReportInstanceCacheModel.companyId = getCompanyId();

		consumerReportInstanceCacheModel.userId = getUserId();

		consumerReportInstanceCacheModel.userName = getUserName();

		String userName = consumerReportInstanceCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			consumerReportInstanceCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			consumerReportInstanceCacheModel.createDate = createDate.getTime();
		}
		else {
			consumerReportInstanceCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			consumerReportInstanceCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			consumerReportInstanceCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		consumerReportInstanceCacheModel.consumerId = getConsumerId();

		consumerReportInstanceCacheModel.reportCategoryKey = getReportCategoryKey();

		String reportCategoryKey = consumerReportInstanceCacheModel.reportCategoryKey;

		if ((reportCategoryKey != null) && (reportCategoryKey.length() == 0)) {
			consumerReportInstanceCacheModel.reportCategoryKey = null;
		}

		consumerReportInstanceCacheModel.reportKey = getReportKey();

		String reportKey = consumerReportInstanceCacheModel.reportKey;

		if ((reportKey != null) && (reportKey.length() == 0)) {
			consumerReportInstanceCacheModel.reportKey = null;
		}

		consumerReportInstanceCacheModel.name = getName();

		String name = consumerReportInstanceCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			consumerReportInstanceCacheModel.name = null;
		}

		consumerReportInstanceCacheModel.description = getDescription();

		String description = consumerReportInstanceCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			consumerReportInstanceCacheModel.description = null;
		}

		consumerReportInstanceCacheModel.typeSettings = getTypeSettings();

		String typeSettings = consumerReportInstanceCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			consumerReportInstanceCacheModel.typeSettings = null;
		}

		return consumerReportInstanceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", consumerReportInstanceId=");
		sb.append(getConsumerReportInstanceId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", consumerId=");
		sb.append(getConsumerId());
		sb.append(", reportCategoryKey=");
		sb.append(getReportCategoryKey());
		sb.append(", reportKey=");
		sb.append(getReportKey());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", typeSettings=");
		sb.append(getTypeSettings());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.consumer.manager.model.ConsumerReportInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consumerReportInstanceId</column-name><column-value><![CDATA[");
		sb.append(getConsumerReportInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
		sb.append(
			"<column><column-name>consumerId</column-name><column-value><![CDATA[");
		sb.append(getConsumerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportCategoryKey</column-name><column-value><![CDATA[");
		sb.append(getReportCategoryKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportKey</column-name><column-value><![CDATA[");
		sb.append(getReportKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeSettings</column-name><column-value><![CDATA[");
		sb.append(getTypeSettings());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ConsumerReportInstance.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ConsumerReportInstance.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _consumerReportInstanceId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _consumerId;
	private long _originalConsumerId;
	private boolean _setOriginalConsumerId;
	private String _reportCategoryKey;
	private String _originalReportCategoryKey;
	private String _reportKey;
	private String _originalReportKey;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _typeSettings;
	private long _columnBitmask;
	private ConsumerReportInstance _escapedModel;
}