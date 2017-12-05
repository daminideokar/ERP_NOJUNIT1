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

package com.bti.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bti.model.SiteSetup;
import com.bti.model.VatSetUp;
import com.bti.repository.RepositorySiteSetup;
import com.bti.repository.RepositoryVatSetUp;


/**
 * Name of Project: BTI 
 * Description: Service ServiceSiteSetUp
 * Created on: OCTOMBER 24, 2017
 * Modified on:
 * @author goodtech
 * version :
 */

@Service
public class ServiceSiteSetUp  {

	@Autowired
	RepositorySiteSetup repositorySiteSetup;

	@Autowired
	RepositoryVatSetUp repositoryVatSetUp;

	/**
	 * Description: this method returns list of SiteSetup
	 * 
	 * @return
	 */
	
	public List<SiteSetup> getSiteSetup() {

		List<SiteSetup> listOfSiteSetup = repositorySiteSetup.findAll();

		return listOfSiteSetup;
	}

	/**
	 * Description: this method gives object of SiteSetup by locationCode
	 * 
	 * @param locationCode
	 * @return
	 */

	
	public SiteSetup getSiteSetupById(String locationCode) {

		SiteSetup siteSetupObj = repositorySiteSetup.findBy(locationCode);

		return siteSetupObj;
	}

	/**
	 * Description: this method gives boolean response by checking vatSeriesType
	 * from VatSetup
	 * 
	 * @param taxScheduleIdForSale
	 * @return
	 */
	
	public Boolean getTaxScheduleIdForSale(int taxScheduleIdForSale) {

		VatSetUp vatSetup = repositoryVatSetUp.findBy(taxScheduleIdForSale);
		if (vatSetup.getVatSeriesType() == 1) {

			return true;
		} else {

			return false;
		}

	}

	/**
	 * Description: this method gives boolean response by checking vatSeriesType
	 * from VatSetup
	 * 
	 * @param taxScheduleIdForPurchase
	 * @return
	 */

	public Boolean getTaxScheduleIdForPurchase(int taxScheduleIdForPurchase) {

		VatSetUp vatSetup = repositoryVatSetUp.findBy(taxScheduleIdForPurchase);
		if (vatSetup.getVatSeriesType() == 2) {

			return true;
		} else {

			return false;
		}

	}

	/**
	 * Description: this method deletes row of SiteSetup by locationCode
	 * 
	 * @param locationCode
	 * @return
	 */

	
	public SiteSetup deleteSiteSetupById(String locationCode) {

		SiteSetup SiteSetup = new SiteSetup();
		SiteSetup = repositorySiteSetup.findBy(locationCode);
		int rowsAffected = repositorySiteSetup.deleteBy(locationCode);

		if (rowsAffected > 0) {

			return SiteSetup;
		}

		return null;

	}

	/**
	 * Description: this method updates the record of SiteSetup
	 * 
	 * @param locationCode
	 * @param siteSetup
	 * @return
	 */

	
	public SiteSetup saveOrUpdate(SiteSetup siteSetup) {
		Date date = new Date();
		if (siteSetup.getLocationIndex() == 0) {
			siteSetup.setCreateDate(date);
			return repositorySiteSetup.save(siteSetup);

		} else {
			SiteSetup SiteSetupGet = repositorySiteSetup.findOne(siteSetup.getLocationIndex());
			siteSetup.setLocationDescription(siteSetup.getLocationDescription());
			siteSetup.setLocationDescriptionArabic(siteSetup.getLocationDescriptionArabic());
			siteSetup.setLocationAddress(siteSetup.getLocationAddress());
			siteSetup.setLocationAddressArabic(siteSetup.getLocationAddressArabic());
			siteSetup.setCity(siteSetup.getCity());
			siteSetup.setCountry(siteSetup.getCountry());
			siteSetup.setFaxNumber(siteSetup.getFaxNumber());
			siteSetup.setPhoneNumber(siteSetup.getPhoneNumber());
			return repositorySiteSetup.save(siteSetup);

		}
	}

}
