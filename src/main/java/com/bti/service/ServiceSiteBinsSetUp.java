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

import java.util.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bti.repository.RepositorySiteBinsSetup;
import com.bti.repository.RepositorySiteSetup;
import com.bti.model.SiteBinsSetup;
import com.bti.model.SiteSetup;


/**
 * Name of Project: BTI 
 * Description: Service ServiceSiteBinsSetUp
 * Created on: OCTOMBER 28, 2017
 * Modified on:
 * @author goodtech
 * version :
 */

@Service
public class ServiceSiteBinsSetUp  {

	@Autowired
	private RepositorySiteBinsSetup daoSitebinsSetup;

	@Autowired
	private RepositorySiteSetup daoSiteSetup;

	/**
	 * @param siteBinsSetup
	 * @return
	 */
	public SiteBinsSetup saveSiteBinsSetup(SiteBinsSetup siteBinsSetup) {

		Date date = new Date();
		siteBinsSetup.setCreateDate(date);
		siteBinsSetup.setModifyDate(date);

		SiteSetup siteSetup = daoSiteSetup.findBy(siteBinsSetup.getLocationCode());
		if (siteSetup != null) {
			siteBinsSetup.setSiteSetup(siteSetup);
			;
			return daoSitebinsSetup.save(siteBinsSetup);
		} else {
			return siteBinsSetup;
		}
	}

	
	public List<SiteBinsSetup> getSiteBinsSetup() {

		List<SiteBinsSetup> allSiteBinsSetup = daoSitebinsSetup.findAll();

		return allSiteBinsSetup;
	}

	/**
	 * @param locationBinName
	 * @return
	 */
	
	public SiteBinsSetup getSiteBinsSetupByLocationBinName(String locationBinName) {

		SiteBinsSetup siteBinsSetup = daoSitebinsSetup.findBy(locationBinName);
		return siteBinsSetup;
	}
	
	/**
	 * @param locationBinName
	 * @return
	 */

	public SiteBinsSetup deleteSiteBinsSetupByLocationBinName(String locationBinName) {

		SiteBinsSetup siteBinsSetup = new SiteBinsSetup();
		siteBinsSetup = daoSitebinsSetup.findBy(locationBinName);
		int rowsAffected = daoSitebinsSetup.deleteBy(locationBinName);
		if (rowsAffected > 0) {

			return siteBinsSetup;
		}

		return null;
	}

	/**
	 * @param siteBinsSetup
	 * @return
	 */
	
	public SiteBinsSetup updateSiteBinsSetup(SiteBinsSetup siteBinsSetup) {

		int rowsAffected = daoSitebinsSetup.updateSiteBinsSetup(siteBinsSetup.getLocationBinName(),
				siteBinsSetup.getPhoneNumber(), siteBinsSetup.getFaxNumber());

		SiteBinsSetup siteBinsSetupResult;
		siteBinsSetupResult = daoSitebinsSetup.findBy(siteBinsSetup.getLocationBinName());

		if (rowsAffected > 0) {

			return siteBinsSetupResult;
		}

		return null;
	}

	/**
	 * @param siteBinsSetup
	 * @return
	 */
	
	public SiteBinsSetup saveorUpdateSiteBinsSetup(SiteBinsSetup siteBinsSetup) {

		Date date = new Date();
		if (siteBinsSetup.getSiteBinInd() == 0) {
			siteBinsSetup.setCreateDate(date);
			SiteSetup siteSetup = daoSiteSetup.findBy(siteBinsSetup.getLocationCode());
			if (siteSetup != null) {
				siteBinsSetup.setSiteSetup(siteSetup);
			}
			else {
			    return 	siteBinsSetup;
			}

		} else {
			
			SiteBinsSetup siteBinsSetupGet = daoSitebinsSetup.findOne(siteBinsSetup.getSiteBinInd());
			siteBinsSetupGet.setFaxNumber(siteBinsSetup.getFaxNumber());
			siteBinsSetupGet.setPhoneNumber(siteBinsSetup.getPhoneNumber());
			siteBinsSetupGet.setCreateDate(siteBinsSetup.getCreateDate());
		}
		siteBinsSetup.setModifyDate(date);
		return daoSitebinsSetup.save(siteBinsSetup);
	}

}
