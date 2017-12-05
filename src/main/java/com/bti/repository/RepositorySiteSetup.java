/**
 * BTI - BAAN for Technology And Trade IntL. 
 * Copyright © 2017 BTI. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF BTI. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF BTI.
 */

package com.bti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.bti.model.SiteSetup;

/**
 * Name of Project: BTI 
 * Description: Interface for RepositorySiteSetup
 * Created on: OCTOMBER 23, 2017
 * Modified on:
 * @author goodtech
 * version :
 */

public interface RepositorySiteSetup extends JpaRepository<SiteSetup, Integer> {

	/**
	 * @param locationId
	 * @return
	 */
	@Query("select siteSetup from SiteSetup siteSetup where siteSetup.locationId =:locationId")
	public SiteSetup findBy(@Param("locationId") String locationId);

	/**
	 * @param locationId
	 * @return
	 */
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("delete from SiteSetup siteSetup where siteSetup.locationId=:locationId")
	public int deleteBy(@Param("locationId") String locationId);

	/**
	 * @param locationId
	 * @param locationDescription
	 * @param locationDescriptionArabic
	 * @param locationAddress
	 * @param locationAddressArabic
	 * @param city
	 * @param country
	 * @param phoneNumber
	 * @param faxNumber
	 * 
	 * @return
	 */
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update SiteSetup siteSetup set siteSetup.locationDescription=:locationDescription,siteSetup.locationDescriptionArabic=:locationDescriptionArabic,siteSetup.locationAddress=:locationAddress,siteSetup.locationAddressArabic=:locationAddressArabic,siteSetup.city=:city,siteSetup.country=:country,siteSetup.phoneNumber=:phoneNumber,siteSetup.faxNumber=:faxNumber where siteSetup.locationId=:locationId")
	public int updateSiteSetup(@Param("locationId") String locationId,
			@Param("locationDescription") String locationDescription,
			@Param("locationDescriptionArabic") String locationDescriptionArabic,
			@Param("locationAddress") String locationAddress,
			@Param("locationAddressArabic") String locationAddressArabic, @Param("city") String city,
			@Param("country") String country, @Param("phoneNumber") String phoneNumber,
			@Param("faxNumber") String faxNumber);

}
