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

package com.liferay.content.targeting.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.model.ShardedModel;
import com.liferay.portal.model.StagedAuditedModel;
import com.liferay.portal.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the TrackingActionInstance service. Represents a row in the &quot;CT_TrackingActionInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.content.targeting.model.impl.TrackingActionInstanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TrackingActionInstance
 * @see com.liferay.content.targeting.model.impl.TrackingActionInstanceImpl
 * @see com.liferay.content.targeting.model.impl.TrackingActionInstanceModelImpl
 * @generated
 */
@ProviderType
public interface TrackingActionInstanceModel extends BaseModel<TrackingActionInstance>,
	GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tracking action instance model instance should use the {@link TrackingActionInstance} interface instead.
	 */

	/**
	 * Returns the primary key of this tracking action instance.
	 *
	 * @return the primary key of this tracking action instance
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tracking action instance.
	 *
	 * @param primaryKey the primary key of this tracking action instance
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this tracking action instance.
	 *
	 * @return the uuid of this tracking action instance
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this tracking action instance.
	 *
	 * @param uuid the uuid of this tracking action instance
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the tracking action instance ID of this tracking action instance.
	 *
	 * @return the tracking action instance ID of this tracking action instance
	 */
	public long getTrackingActionInstanceId();

	/**
	 * Sets the tracking action instance ID of this tracking action instance.
	 *
	 * @param trackingActionInstanceId the tracking action instance ID of this tracking action instance
	 */
	public void setTrackingActionInstanceId(long trackingActionInstanceId);

	/**
	 * Returns the group ID of this tracking action instance.
	 *
	 * @return the group ID of this tracking action instance
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this tracking action instance.
	 *
	 * @param groupId the group ID of this tracking action instance
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this tracking action instance.
	 *
	 * @return the company ID of this tracking action instance
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this tracking action instance.
	 *
	 * @param companyId the company ID of this tracking action instance
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this tracking action instance.
	 *
	 * @return the user ID of this tracking action instance
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this tracking action instance.
	 *
	 * @param userId the user ID of this tracking action instance
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this tracking action instance.
	 *
	 * @return the user uuid of this tracking action instance
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this tracking action instance.
	 *
	 * @param userUuid the user uuid of this tracking action instance
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this tracking action instance.
	 *
	 * @return the user name of this tracking action instance
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this tracking action instance.
	 *
	 * @param userName the user name of this tracking action instance
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this tracking action instance.
	 *
	 * @return the create date of this tracking action instance
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this tracking action instance.
	 *
	 * @param createDate the create date of this tracking action instance
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this tracking action instance.
	 *
	 * @return the modified date of this tracking action instance
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this tracking action instance.
	 *
	 * @param modifiedDate the modified date of this tracking action instance
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the tracking action key of this tracking action instance.
	 *
	 * @return the tracking action key of this tracking action instance
	 */
	@AutoEscape
	public String getTrackingActionKey();

	/**
	 * Sets the tracking action key of this tracking action instance.
	 *
	 * @param trackingActionKey the tracking action key of this tracking action instance
	 */
	public void setTrackingActionKey(String trackingActionKey);

	/**
	 * Returns the campaign ID of this tracking action instance.
	 *
	 * @return the campaign ID of this tracking action instance
	 */
	public long getCampaignId();

	/**
	 * Sets the campaign ID of this tracking action instance.
	 *
	 * @param campaignId the campaign ID of this tracking action instance
	 */
	public void setCampaignId(long campaignId);

	/**
	 * Returns the report instance ID of this tracking action instance.
	 *
	 * @return the report instance ID of this tracking action instance
	 */
	public long getReportInstanceId();

	/**
	 * Sets the report instance ID of this tracking action instance.
	 *
	 * @param reportInstanceId the report instance ID of this tracking action instance
	 */
	public void setReportInstanceId(long reportInstanceId);

	/**
	 * Returns the alias of this tracking action instance.
	 *
	 * @return the alias of this tracking action instance
	 */
	@AutoEscape
	public String getAlias();

	/**
	 * Sets the alias of this tracking action instance.
	 *
	 * @param alias the alias of this tracking action instance
	 */
	public void setAlias(String alias);

	/**
	 * Returns the referrer class name of this tracking action instance.
	 *
	 * @return the referrer class name of this tracking action instance
	 */
	@AutoEscape
	public String getReferrerClassName();

	/**
	 * Sets the referrer class name of this tracking action instance.
	 *
	 * @param referrerClassName the referrer class name of this tracking action instance
	 */
	public void setReferrerClassName(String referrerClassName);

	/**
	 * Returns the referrer class p k of this tracking action instance.
	 *
	 * @return the referrer class p k of this tracking action instance
	 */
	public long getReferrerClassPK();

	/**
	 * Sets the referrer class p k of this tracking action instance.
	 *
	 * @param referrerClassPK the referrer class p k of this tracking action instance
	 */
	public void setReferrerClassPK(long referrerClassPK);

	/**
	 * Returns the element ID of this tracking action instance.
	 *
	 * @return the element ID of this tracking action instance
	 */
	@AutoEscape
	public String getElementId();

	/**
	 * Sets the element ID of this tracking action instance.
	 *
	 * @param elementId the element ID of this tracking action instance
	 */
	public void setElementId(String elementId);

	/**
	 * Returns the event type of this tracking action instance.
	 *
	 * @return the event type of this tracking action instance
	 */
	@AutoEscape
	public String getEventType();

	/**
	 * Sets the event type of this tracking action instance.
	 *
	 * @param eventType the event type of this tracking action instance
	 */
	public void setEventType(String eventType);

	/**
	 * Returns the type settings of this tracking action instance.
	 *
	 * @return the type settings of this tracking action instance
	 */
	@AutoEscape
	public String getTypeSettings();

	/**
	 * Sets the type settings of this tracking action instance.
	 *
	 * @param typeSettings the type settings of this tracking action instance
	 */
	public void setTypeSettings(String typeSettings);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.liferay.content.targeting.model.TrackingActionInstance trackingActionInstance);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.content.targeting.model.TrackingActionInstance> toCacheModel();

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance toEscapedModel();

	@Override
	public com.liferay.content.targeting.model.TrackingActionInstance toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}