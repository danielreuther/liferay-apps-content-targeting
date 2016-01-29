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

package com.liferay.content.targeting.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.model.ReportInstance;
import com.liferay.content.targeting.service.ReportInstanceLocalService;
import com.liferay.content.targeting.service.persistence.AnonymousUserUserSegmentPersistence;
import com.liferay.content.targeting.service.persistence.CampaignFinder;
import com.liferay.content.targeting.service.persistence.CampaignPersistence;
import com.liferay.content.targeting.service.persistence.ChannelInstancePersistence;
import com.liferay.content.targeting.service.persistence.ReportInstancePersistence;
import com.liferay.content.targeting.service.persistence.RuleInstancePersistence;
import com.liferay.content.targeting.service.persistence.TacticPersistence;
import com.liferay.content.targeting.service.persistence.TrackingActionInstancePersistence;
import com.liferay.content.targeting.service.persistence.UserSegmentPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.service.persistence.ClassNamePersistence;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.exportimport.lar.ExportImportHelperUtil;
import com.liferay.portlet.exportimport.lar.ManifestSummary;
import com.liferay.portlet.exportimport.lar.PortletDataContext;
import com.liferay.portlet.exportimport.lar.StagedModelDataHandlerUtil;
import com.liferay.portlet.exportimport.lar.StagedModelType;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the report instance local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.content.targeting.service.impl.ReportInstanceLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.service.impl.ReportInstanceLocalServiceImpl
 * @see com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class ReportInstanceLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ReportInstanceLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil} to access the report instance local service.
	 */

	/**
	 * Adds the report instance to the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportInstance the report instance
	 * @return the report instance that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ReportInstance addReportInstance(ReportInstance reportInstance) {
		reportInstance.setNew(true);

		return reportInstancePersistence.update(reportInstance);
	}

	/**
	 * Creates a new report instance with the primary key. Does not add the report instance to the database.
	 *
	 * @param reportInstanceId the primary key for the new report instance
	 * @return the new report instance
	 */
	@Override
	public ReportInstance createReportInstance(long reportInstanceId) {
		return reportInstancePersistence.create(reportInstanceId);
	}

	/**
	 * Deletes the report instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportInstanceId the primary key of the report instance
	 * @return the report instance that was removed
	 * @throws PortalException if a report instance with the primary key could not be found
	 * @throws SystemException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ReportInstance deleteReportInstance(long reportInstanceId)
		throws PortalException, SystemException {
		return reportInstancePersistence.remove(reportInstanceId);
	}

	/**
	 * Deletes the report instance from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportInstance the report instance
	 * @return the report instance that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ReportInstance deleteReportInstance(ReportInstance reportInstance) {
		return reportInstancePersistence.remove(reportInstance);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ReportInstance.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return reportInstancePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return reportInstancePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return reportInstancePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return reportInstancePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return reportInstancePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ReportInstance fetchReportInstance(long reportInstanceId) {
		return reportInstancePersistence.fetchByPrimaryKey(reportInstanceId);
	}

	/**
	 * Returns the report instance matching the UUID and group.
	 *
	 * @param uuid the report instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching report instance, or <code>null</code> if a matching report instance could not be found
	 */
	@Override
	public ReportInstance fetchReportInstanceByUuidAndGroupId(String uuid,
		long groupId) {
		return reportInstancePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the report instance with the primary key.
	 *
	 * @param reportInstanceId the primary key of the report instance
	 * @return the report instance
	 * @throws PortalException if a report instance with the primary key could not be found
	 */
	@Override
	public ReportInstance getReportInstance(long reportInstanceId)
		throws PortalException {
		return reportInstancePersistence.findByPrimaryKey(reportInstanceId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil.getService());
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ReportInstance.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("reportInstanceId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil.getService());
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ReportInstance.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"reportInstanceId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(com.liferay.content.targeting.service.ReportInstanceLocalServiceUtil.getService());
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ReportInstance.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("reportInstanceId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<ReportInstance>() {
				@Override
				public void performAction(ReportInstance reportInstance)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						reportInstance);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(ReportInstance.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return reportInstanceLocalService.deleteReportInstance((ReportInstance)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return reportInstancePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the report instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the report instances
	 * @param companyId the primary key of the company
	 * @return the matching report instances, or an empty list if no matches were found
	 */
	@Override
	public List<ReportInstance> getReportInstancesByUuidAndCompanyId(
		String uuid, long companyId) {
		return reportInstancePersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of report instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the report instances
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching report instances, or an empty list if no matches were found
	 */
	@Override
	public List<ReportInstance> getReportInstancesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ReportInstance> orderByComparator) {
		return reportInstancePersistence.findByUuid_C(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	 * Returns the report instance matching the UUID and group.
	 *
	 * @param uuid the report instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching report instance
	 * @throws PortalException if a matching report instance could not be found
	 */
	@Override
	public ReportInstance getReportInstanceByUuidAndGroupId(String uuid,
		long groupId) throws PortalException {
		return reportInstancePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the report instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of report instances
	 * @param end the upper bound of the range of report instances (not inclusive)
	 * @return the range of report instances
	 */
	@Override
	public List<ReportInstance> getReportInstances(int start, int end) {
		return reportInstancePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of report instances.
	 *
	 * @return the number of report instances
	 */
	@Override
	public int getReportInstancesCount() {
		return reportInstancePersistence.countAll();
	}

	/**
	 * Updates the report instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param reportInstance the report instance
	 * @return the report instance that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ReportInstance updateReportInstance(ReportInstance reportInstance) {
		return reportInstancePersistence.update(reportInstance);
	}

	/**
	 * Returns the anonymous user user segment local service.
	 *
	 * @return the anonymous user user segment local service
	 */
	public com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService getAnonymousUserUserSegmentLocalService() {
		return anonymousUserUserSegmentLocalService;
	}

	/**
	 * Sets the anonymous user user segment local service.
	 *
	 * @param anonymousUserUserSegmentLocalService the anonymous user user segment local service
	 */
	public void setAnonymousUserUserSegmentLocalService(
		com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService anonymousUserUserSegmentLocalService) {
		this.anonymousUserUserSegmentLocalService = anonymousUserUserSegmentLocalService;
	}

	/**
	 * Returns the anonymous user user segment persistence.
	 *
	 * @return the anonymous user user segment persistence
	 */
	public AnonymousUserUserSegmentPersistence getAnonymousUserUserSegmentPersistence() {
		return anonymousUserUserSegmentPersistence;
	}

	/**
	 * Sets the anonymous user user segment persistence.
	 *
	 * @param anonymousUserUserSegmentPersistence the anonymous user user segment persistence
	 */
	public void setAnonymousUserUserSegmentPersistence(
		AnonymousUserUserSegmentPersistence anonymousUserUserSegmentPersistence) {
		this.anonymousUserUserSegmentPersistence = anonymousUserUserSegmentPersistence;
	}

	/**
	 * Returns the campaign local service.
	 *
	 * @return the campaign local service
	 */
	public com.liferay.content.targeting.service.CampaignLocalService getCampaignLocalService() {
		return campaignLocalService;
	}

	/**
	 * Sets the campaign local service.
	 *
	 * @param campaignLocalService the campaign local service
	 */
	public void setCampaignLocalService(
		com.liferay.content.targeting.service.CampaignLocalService campaignLocalService) {
		this.campaignLocalService = campaignLocalService;
	}

	/**
	 * Returns the campaign persistence.
	 *
	 * @return the campaign persistence
	 */
	public CampaignPersistence getCampaignPersistence() {
		return campaignPersistence;
	}

	/**
	 * Sets the campaign persistence.
	 *
	 * @param campaignPersistence the campaign persistence
	 */
	public void setCampaignPersistence(CampaignPersistence campaignPersistence) {
		this.campaignPersistence = campaignPersistence;
	}

	/**
	 * Returns the campaign finder.
	 *
	 * @return the campaign finder
	 */
	public CampaignFinder getCampaignFinder() {
		return campaignFinder;
	}

	/**
	 * Sets the campaign finder.
	 *
	 * @param campaignFinder the campaign finder
	 */
	public void setCampaignFinder(CampaignFinder campaignFinder) {
		this.campaignFinder = campaignFinder;
	}

	/**
	 * Returns the channel instance local service.
	 *
	 * @return the channel instance local service
	 */
	public com.liferay.content.targeting.service.ChannelInstanceLocalService getChannelInstanceLocalService() {
		return channelInstanceLocalService;
	}

	/**
	 * Sets the channel instance local service.
	 *
	 * @param channelInstanceLocalService the channel instance local service
	 */
	public void setChannelInstanceLocalService(
		com.liferay.content.targeting.service.ChannelInstanceLocalService channelInstanceLocalService) {
		this.channelInstanceLocalService = channelInstanceLocalService;
	}

	/**
	 * Returns the channel instance persistence.
	 *
	 * @return the channel instance persistence
	 */
	public ChannelInstancePersistence getChannelInstancePersistence() {
		return channelInstancePersistence;
	}

	/**
	 * Sets the channel instance persistence.
	 *
	 * @param channelInstancePersistence the channel instance persistence
	 */
	public void setChannelInstancePersistence(
		ChannelInstancePersistence channelInstancePersistence) {
		this.channelInstancePersistence = channelInstancePersistence;
	}

	/**
	 * Returns the report instance local service.
	 *
	 * @return the report instance local service
	 */
	public ReportInstanceLocalService getReportInstanceLocalService() {
		return reportInstanceLocalService;
	}

	/**
	 * Sets the report instance local service.
	 *
	 * @param reportInstanceLocalService the report instance local service
	 */
	public void setReportInstanceLocalService(
		ReportInstanceLocalService reportInstanceLocalService) {
		this.reportInstanceLocalService = reportInstanceLocalService;
	}

	/**
	 * Returns the report instance persistence.
	 *
	 * @return the report instance persistence
	 */
	public ReportInstancePersistence getReportInstancePersistence() {
		return reportInstancePersistence;
	}

	/**
	 * Sets the report instance persistence.
	 *
	 * @param reportInstancePersistence the report instance persistence
	 */
	public void setReportInstancePersistence(
		ReportInstancePersistence reportInstancePersistence) {
		this.reportInstancePersistence = reportInstancePersistence;
	}

	/**
	 * Returns the rule instance local service.
	 *
	 * @return the rule instance local service
	 */
	public com.liferay.content.targeting.service.RuleInstanceLocalService getRuleInstanceLocalService() {
		return ruleInstanceLocalService;
	}

	/**
	 * Sets the rule instance local service.
	 *
	 * @param ruleInstanceLocalService the rule instance local service
	 */
	public void setRuleInstanceLocalService(
		com.liferay.content.targeting.service.RuleInstanceLocalService ruleInstanceLocalService) {
		this.ruleInstanceLocalService = ruleInstanceLocalService;
	}

	/**
	 * Returns the rule instance persistence.
	 *
	 * @return the rule instance persistence
	 */
	public RuleInstancePersistence getRuleInstancePersistence() {
		return ruleInstancePersistence;
	}

	/**
	 * Sets the rule instance persistence.
	 *
	 * @param ruleInstancePersistence the rule instance persistence
	 */
	public void setRuleInstancePersistence(
		RuleInstancePersistence ruleInstancePersistence) {
		this.ruleInstancePersistence = ruleInstancePersistence;
	}

	/**
	 * Returns the tactic local service.
	 *
	 * @return the tactic local service
	 */
	public com.liferay.content.targeting.service.TacticLocalService getTacticLocalService() {
		return tacticLocalService;
	}

	/**
	 * Sets the tactic local service.
	 *
	 * @param tacticLocalService the tactic local service
	 */
	public void setTacticLocalService(
		com.liferay.content.targeting.service.TacticLocalService tacticLocalService) {
		this.tacticLocalService = tacticLocalService;
	}

	/**
	 * Returns the tactic persistence.
	 *
	 * @return the tactic persistence
	 */
	public TacticPersistence getTacticPersistence() {
		return tacticPersistence;
	}

	/**
	 * Sets the tactic persistence.
	 *
	 * @param tacticPersistence the tactic persistence
	 */
	public void setTacticPersistence(TacticPersistence tacticPersistence) {
		this.tacticPersistence = tacticPersistence;
	}

	/**
	 * Returns the tracking action instance local service.
	 *
	 * @return the tracking action instance local service
	 */
	public com.liferay.content.targeting.service.TrackingActionInstanceLocalService getTrackingActionInstanceLocalService() {
		return trackingActionInstanceLocalService;
	}

	/**
	 * Sets the tracking action instance local service.
	 *
	 * @param trackingActionInstanceLocalService the tracking action instance local service
	 */
	public void setTrackingActionInstanceLocalService(
		com.liferay.content.targeting.service.TrackingActionInstanceLocalService trackingActionInstanceLocalService) {
		this.trackingActionInstanceLocalService = trackingActionInstanceLocalService;
	}

	/**
	 * Returns the tracking action instance persistence.
	 *
	 * @return the tracking action instance persistence
	 */
	public TrackingActionInstancePersistence getTrackingActionInstancePersistence() {
		return trackingActionInstancePersistence;
	}

	/**
	 * Sets the tracking action instance persistence.
	 *
	 * @param trackingActionInstancePersistence the tracking action instance persistence
	 */
	public void setTrackingActionInstancePersistence(
		TrackingActionInstancePersistence trackingActionInstancePersistence) {
		this.trackingActionInstancePersistence = trackingActionInstancePersistence;
	}

	/**
	 * Returns the user segment local service.
	 *
	 * @return the user segment local service
	 */
	public com.liferay.content.targeting.service.UserSegmentLocalService getUserSegmentLocalService() {
		return userSegmentLocalService;
	}

	/**
	 * Sets the user segment local service.
	 *
	 * @param userSegmentLocalService the user segment local service
	 */
	public void setUserSegmentLocalService(
		com.liferay.content.targeting.service.UserSegmentLocalService userSegmentLocalService) {
		this.userSegmentLocalService = userSegmentLocalService;
	}

	/**
	 * Returns the user segment persistence.
	 *
	 * @return the user segment persistence
	 */
	public UserSegmentPersistence getUserSegmentPersistence() {
		return userSegmentPersistence;
	}

	/**
	 * Sets the user segment persistence.
	 *
	 * @param userSegmentPersistence the user segment persistence
	 */
	public void setUserSegmentPersistence(
		UserSegmentPersistence userSegmentPersistence) {
		this.userSegmentPersistence = userSegmentPersistence;
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
	 * Returns the group local service.
	 *
	 * @return the group local service
	 */
	public com.liferay.portal.service.GroupLocalService getGroupLocalService() {
		return groupLocalService;
	}

	/**
	 * Sets the group local service.
	 *
	 * @param groupLocalService the group local service
	 */
	public void setGroupLocalService(
		com.liferay.portal.service.GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	/**
	 * Returns the group persistence.
	 *
	 * @return the group persistence
	 */
	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	/**
	 * Sets the group persistence.
	 *
	 * @param groupPersistence the group persistence
	 */
	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
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
		persistedModelLocalServiceRegistry.register("com.liferay.content.targeting.model.ReportInstance",
			reportInstanceLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.content.targeting.model.ReportInstance");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ReportInstanceLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ReportInstance.class;
	}

	protected String getModelClassName() {
		return ReportInstance.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = reportInstancePersistence.getDataSource();

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

	@BeanReference(type = com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService.class)
	protected com.liferay.content.targeting.service.AnonymousUserUserSegmentLocalService anonymousUserUserSegmentLocalService;
	@BeanReference(type = AnonymousUserUserSegmentPersistence.class)
	protected AnonymousUserUserSegmentPersistence anonymousUserUserSegmentPersistence;
	@BeanReference(type = com.liferay.content.targeting.service.CampaignLocalService.class)
	protected com.liferay.content.targeting.service.CampaignLocalService campaignLocalService;
	@BeanReference(type = CampaignPersistence.class)
	protected CampaignPersistence campaignPersistence;
	@BeanReference(type = CampaignFinder.class)
	protected CampaignFinder campaignFinder;
	@BeanReference(type = com.liferay.content.targeting.service.ChannelInstanceLocalService.class)
	protected com.liferay.content.targeting.service.ChannelInstanceLocalService channelInstanceLocalService;
	@BeanReference(type = ChannelInstancePersistence.class)
	protected ChannelInstancePersistence channelInstancePersistence;
	@BeanReference(type = com.liferay.content.targeting.service.ReportInstanceLocalService.class)
	protected ReportInstanceLocalService reportInstanceLocalService;
	@BeanReference(type = ReportInstancePersistence.class)
	protected ReportInstancePersistence reportInstancePersistence;
	@BeanReference(type = com.liferay.content.targeting.service.RuleInstanceLocalService.class)
	protected com.liferay.content.targeting.service.RuleInstanceLocalService ruleInstanceLocalService;
	@BeanReference(type = RuleInstancePersistence.class)
	protected RuleInstancePersistence ruleInstancePersistence;
	@BeanReference(type = com.liferay.content.targeting.service.TacticLocalService.class)
	protected com.liferay.content.targeting.service.TacticLocalService tacticLocalService;
	@BeanReference(type = TacticPersistence.class)
	protected TacticPersistence tacticPersistence;
	@BeanReference(type = com.liferay.content.targeting.service.TrackingActionInstanceLocalService.class)
	protected com.liferay.content.targeting.service.TrackingActionInstanceLocalService trackingActionInstanceLocalService;
	@BeanReference(type = TrackingActionInstancePersistence.class)
	protected TrackingActionInstancePersistence trackingActionInstancePersistence;
	@BeanReference(type = com.liferay.content.targeting.service.UserSegmentLocalService.class)
	protected com.liferay.content.targeting.service.UserSegmentLocalService userSegmentLocalService;
	@BeanReference(type = UserSegmentPersistence.class)
	protected UserSegmentPersistence userSegmentPersistence;
	@ServiceReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.service.ClassNameLocalService.class)
	protected com.liferay.portal.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.service.GroupLocalService.class)
	protected com.liferay.portal.service.GroupLocalService groupLocalService;
	@ServiceReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@ServiceReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}