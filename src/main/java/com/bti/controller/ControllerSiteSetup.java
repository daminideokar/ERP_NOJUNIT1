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

package com.bti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bti.config.ResponseMessage;
import com.bti.model.SiteSetup;
import com.bti.model.VatSetUp;
import com.bti.service.ServiceResponse;
import com.bti.service.ServiceSiteSetUp;


/**
 * Name of Project: BTI 
 * Description: Service ServiceStockCalenderExceptionImpl
 * Created on: 
 * Modified on:
 * @author goodtech
 * version :
 */

@RestController
@RequestMapping("/siteSetup")
public class ControllerSiteSetup {

	@Autowired
	ServiceSiteSetUp serviceSiteSetup;

	@Autowired
	ServiceResponse serviceResponse;

	public void setServicesitebinsetup(ServiceSiteSetUp serviceSiteSetup) {
		this.serviceSiteSetup = serviceSiteSetup;
	}

	/**
	 * @description : saves sitesetup object
	 * @param request
	 * @param siteSetup
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveSiteSetUp(HttpServletRequest request, @RequestBody SiteSetup siteSetup) {

		ResponseMessage responseMessage = null;

		SiteSetup siteSetupRes = serviceSiteSetup.saveOrUpdate(siteSetup);

		if (siteSetupRes.getLocationIndex() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_CREATED", false), siteSetupRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false), siteSetupRes);

		}
		return responseMessage;
	}

	/**
	 * @description : gives list of sitesetup
	 * @param request
	 * @param siteSetup
	 * @return
	 */

	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
	public ResponseMessage getSiteSetup(HttpServletRequest request, SiteSetup siteSetup) {
		ResponseMessage responseMessage = null;
		List<SiteSetup> listOfSiteSetup = serviceSiteSetup.getSiteSetup();

		responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
				serviceResponse.getMessageByShortAndIsDeleted("GET_ALL", false), listOfSiteSetup);

		return responseMessage;
	}

	/**
	 * @description : gives list of sitesetup by locationcode/locationId
	 * @param request
	 * @param locationId
	 * @return
	 */
	@RequestMapping(value = "/getBylocationcode", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getSiteSetupById(HttpServletRequest request, @RequestBody SiteSetup siteSetup) {

		ResponseMessage responseMessage = null;

		SiteSetup siteSetUpResult = serviceSiteSetup.getSiteSetupById(siteSetup.getLocationId());

		responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
				serviceResponse.getMessageByShortAndIsDeleted("GET_SiteSetUp", false), siteSetUpResult);

		return responseMessage;
	}

	/**
	 * @description : gives list of sitesetup by taxScheduleIdForSale
	 * @param request
	 * @param taxScheduleIdForSale
	 * @return
	 */
	@RequestMapping(value = "/getByTaxScheduleIdForSale", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getTaxScheduleIdForSale(HttpServletRequest request, @RequestBody VatSetUp vatSetup) {
		ResponseMessage responseMessage = null;
		boolean response = serviceSiteSetup.getTaxScheduleIdForSale(vatSetup.getTaxSchdId());

		responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
				serviceResponse.getMessageByShortAndIsDeleted("GET_SiteSetUp", false), response);

		return responseMessage;

	}

	/**
	 * @description : gives list of sitesetup by taxScheduleIdForPurchase
	 * @param request
	 * @param taxScheduleIdForPurchase
	 * @return
	 */

	@RequestMapping(value = "/getByTaxScheduleIdForPurchase", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getTaxScheduleIdForPurchase(HttpServletRequest request, @RequestBody VatSetUp vatSetup) {
		ResponseMessage responseMessage = null;
		boolean response = serviceSiteSetup.getTaxScheduleIdForSale(vatSetup.getTaxSchdId());

		responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
				serviceResponse.getMessageByShortAndIsDeleted("GET_SiteSetUp", false), response);

		return responseMessage;

	}

	/**
	 * @description : deletes object of sitesetup by locationId
	 * @param request
	 * @param locationId
	 * @return
	 */

	@RequestMapping(value = "/delete", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage deleteSiteSetupByLocationBinName(HttpServletRequest request,
			@RequestBody SiteSetup siteSetup) {

		ResponseMessage responseMessage = null;
		SiteSetup siteSetupRes = serviceSiteSetup.deleteSiteSetupById(siteSetup.getLocationId());
		if (siteSetupRes != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetup_DELETED", false), siteSetupRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetup_NOT_DELETED", false));
		}

		return responseMessage;

	}

	/**
	 * @description : updates object of sitesetup by locationId
	 * @param request
	 * @param locationId
	 * @return
	 */

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage updateSiteBinsSetup(HttpServletRequest request, @RequestBody SiteSetup siteSetup) {
		ResponseMessage responseMessage = null;

		SiteSetup siteSetupRes = serviceSiteSetup.saveOrUpdate(siteSetup);

		if (siteSetupRes.getLocationIndex() != 0) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetup_UPDATE_SUCCESS", false), siteSetup);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetup_NOT_UPDATE", false), siteSetup);
		}

		return responseMessage;
	}

}
