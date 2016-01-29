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

package com.liferay.content.targeting.analytics.service.base;

import com.liferay.content.targeting.analytics.model.AnalyticsEvent;
import com.liferay.content.targeting.analytics.service.AnalyticsEventService;
import com.liferay.content.targeting.analytics.service.persistence.AnalyticsEventFinder;
import com.liferay.content.targeting.analytics.service.persistence.AnalyticsEventPersistence;
import com.liferay.content.targeting.analytics.service.persistence.AnalyticsReferrerPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.ClassNamePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.portal.util.PortalUtil;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the analytics event remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.content.targeting.analytics.service.impl.AnalyticsEventServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.analytics.service.impl.AnalyticsEventServiceImpl
 * @see com.liferay.content.targeting.analytics.service.AnalyticsEventServiceUtil
 * @generated
 */
public abstract class AnalyticsEventServiceBaseImpl extends BaseServiceImpl
	implements AnalyticsEventService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.content.targeting.analytics.service.AnalyticsEventServiceUtil} to access the analytics event remote service.
	 */

	/**
	 * Returns the analytics event local service.
	 *
	 * @return the analytics event local service
	 */
	public com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService getAnalyticsEventLocalService() {
		return analyticsEventLocalService;
	}

	/**
	 * Sets the analytics event local service.
	 *
	 * @param analyticsEventLocalService the analytics event local service
	 */
	public void setAnalyticsEventLocalService(
		com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService analyticsEventLocalService) {
		this.analyticsEventLocalService = analyticsEventLocalService;
	}

	/**
	 * Returns the analytics event remote service.
	 *
	 * @return the analytics event remote service
	 */
	public AnalyticsEventService getAnalyticsEventService() {
		return analyticsEventService;
	}

	/**
	 * Sets the analytics event remote service.
	 *
	 * @param analyticsEventService the analytics event remote service
	 */
	public void setAnalyticsEventService(
		AnalyticsEventService analyticsEventService) {
		this.analyticsEventService = analyticsEventService;
	}

	/**
	 * Returns the analytics event persistence.
	 *
	 * @return the analytics event persistence
	 */
	public AnalyticsEventPersistence getAnalyticsEventPersistence() {
		return analyticsEventPersistence;
	}

	/**
	 * Sets the analytics event persistence.
	 *
	 * @param analyticsEventPersistence the analytics event persistence
	 */
	public void setAnalyticsEventPersistence(
		AnalyticsEventPersistence analyticsEventPersistence) {
		this.analyticsEventPersistence = analyticsEventPersistence;
	}

	/**
	 * Returns the analytics event finder.
	 *
	 * @return the analytics event finder
	 */
	public AnalyticsEventFinder getAnalyticsEventFinder() {
		return analyticsEventFinder;
	}

	/**
	 * Sets the analytics event finder.
	 *
	 * @param analyticsEventFinder the analytics event finder
	 */
	public void setAnalyticsEventFinder(
		AnalyticsEventFinder analyticsEventFinder) {
		this.analyticsEventFinder = analyticsEventFinder;
	}

	/**
	 * Returns the analytics referrer local service.
	 *
	 * @return the analytics referrer local service
	 */
	public com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalService getAnalyticsReferrerLocalService() {
		return analyticsReferrerLocalService;
	}

	/**
	 * Sets the analytics referrer local service.
	 *
	 * @param analyticsReferrerLocalService the analytics referrer local service
	 */
	public void setAnalyticsReferrerLocalService(
		com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalService analyticsReferrerLocalService) {
		this.analyticsReferrerLocalService = analyticsReferrerLocalService;
	}

	/**
	 * Returns the analytics referrer remote service.
	 *
	 * @return the analytics referrer remote service
	 */
	public com.liferay.content.targeting.analytics.service.AnalyticsReferrerService getAnalyticsReferrerService() {
		return analyticsReferrerService;
	}

	/**
	 * Sets the analytics referrer remote service.
	 *
	 * @param analyticsReferrerService the analytics referrer remote service
	 */
	public void setAnalyticsReferrerService(
		com.liferay.content.targeting.analytics.service.AnalyticsReferrerService analyticsReferrerService) {
		this.analyticsReferrerService = analyticsReferrerService;
	}

	/**
	 * Returns the analytics referrer persistence.
	 *
	 * @return the analytics referrer persistence
	 */
	public AnalyticsReferrerPersistence getAnalyticsReferrerPersistence() {
		return analyticsReferrerPersistence;
	}

	/**
	 * Sets the analytics referrer persistence.
	 *
	 * @param analyticsReferrerPersistence the analytics referrer persistence
	 */
	public void setAnalyticsReferrerPersistence(
		AnalyticsReferrerPersistence analyticsReferrerPersistence) {
		this.analyticsReferrerPersistence = analyticsReferrerPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AnalyticsEventService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AnalyticsEvent.class;
	}

	protected String getModelClassName() {
		return AnalyticsEvent.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = analyticsEventPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService.class)
	protected com.liferay.content.targeting.analytics.service.AnalyticsEventLocalService analyticsEventLocalService;
	@BeanReference(type = com.liferay.content.targeting.analytics.service.AnalyticsEventService.class)
	protected AnalyticsEventService analyticsEventService;
	@BeanReference(type = AnalyticsEventPersistence.class)
	protected AnalyticsEventPersistence analyticsEventPersistence;
	@BeanReference(type = AnalyticsEventFinder.class)
	protected AnalyticsEventFinder analyticsEventFinder;
	@BeanReference(type = com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalService.class)
	protected com.liferay.content.targeting.analytics.service.AnalyticsReferrerLocalService analyticsReferrerLocalService;
	@BeanReference(type = com.liferay.content.targeting.analytics.service.AnalyticsReferrerService.class)
	protected com.liferay.content.targeting.analytics.service.AnalyticsReferrerService analyticsReferrerService;
	@BeanReference(type = AnalyticsReferrerPersistence.class)
	protected AnalyticsReferrerPersistence analyticsReferrerPersistence;
	@ServiceReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.service.ClassNameLocalService.class)
	protected com.liferay.portal.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.service.ClassNameService.class)
	protected com.liferay.portal.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}