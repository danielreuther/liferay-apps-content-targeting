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

package com.liferay.content.targeting.report.campaign.newsletter.service.persistence;

import com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the a b version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ABVersionPersistenceImpl
 * @see ABVersionUtil
 * @generated
 */
public interface ABVersionPersistence extends BasePersistence<ABVersion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ABVersionUtil} to access the a b version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the a b versions where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching a b versions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion> findByCampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the a b versions where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of a b versions
	* @param end the upper bound of the range of a b versions (not inclusive)
	* @return the range of matching a b versions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion> findByCampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the a b versions where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of a b versions
	* @param end the upper bound of the range of a b versions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching a b versions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion> findByCampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first a b version in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a b version
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a matching a b version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion findByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first a b version in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a b version, or <code>null</code> if a matching a b version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion fetchByCampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last a b version in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a b version
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a matching a b version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion findByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last a b version in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a b version, or <code>null</code> if a matching a b version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion fetchByCampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a b versions before and after the current a b version in the ordered set where campaignId = &#63;.
	*
	* @param abversionId the primary key of the current a b version
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next a b version
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a a b version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion[] findByCampaignId_PrevAndNext(
		long abversionId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the a b versions where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of a b versions where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching a b versions
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a b version where campaignId = &#63; and alias = &#63; or throws a {@link com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @return the matching a b version
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a matching a b version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion findByC_D(
		long campaignId, java.lang.String alias)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a b version where campaignId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @return the matching a b version, or <code>null</code> if a matching a b version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion fetchByC_D(
		long campaignId, java.lang.String alias)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a b version where campaignId = &#63; and alias = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching a b version, or <code>null</code> if a matching a b version could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion fetchByC_D(
		long campaignId, java.lang.String alias, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the a b version where campaignId = &#63; and alias = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @return the a b version that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion removeByC_D(
		long campaignId, java.lang.String alias)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of a b versions where campaignId = &#63; and alias = &#63;.
	*
	* @param campaignId the campaign ID
	* @param alias the alias
	* @return the number of matching a b versions
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_D(long campaignId, java.lang.String alias)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the a b version in the entity cache if it is enabled.
	*
	* @param abVersion the a b version
	*/
	public void cacheResult(
		com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion abVersion);

	/**
	* Caches the a b versions in the entity cache if it is enabled.
	*
	* @param abVersions the a b versions
	*/
	public void cacheResult(
		java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion> abVersions);

	/**
	* Creates a new a b version with the primary key. Does not add the a b version to the database.
	*
	* @param abversionId the primary key for the new a b version
	* @return the new a b version
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion create(
		long abversionId);

	/**
	* Removes the a b version with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param abversionId the primary key of the a b version
	* @return the a b version that was removed
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a a b version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion remove(
		long abversionId)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion updateImpl(
		com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion abVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a b version with the primary key or throws a {@link com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException} if it could not be found.
	*
	* @param abversionId the primary key of the a b version
	* @return the a b version
	* @throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException if a a b version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion findByPrimaryKey(
		long abversionId)
		throws com.liferay.content.targeting.report.campaign.newsletter.NoSuchABVersionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the a b version with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param abversionId the primary key of the a b version
	* @return the a b version, or <code>null</code> if a a b version with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion fetchByPrimaryKey(
		long abversionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the a b versions.
	*
	* @return the a b versions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the a b versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of a b versions
	* @param end the upper bound of the range of a b versions (not inclusive)
	* @return the range of a b versions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the a b versions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.newsletter.model.impl.ABVersionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of a b versions
	* @param end the upper bound of the range of a b versions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of a b versions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.content.targeting.report.campaign.newsletter.model.ABVersion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the a b versions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of a b versions.
	*
	* @return the number of a b versions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}