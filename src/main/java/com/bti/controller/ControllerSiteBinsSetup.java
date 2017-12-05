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
import com.bti.model.SiteBinsSetup;
import com.bti.service.ServiceResponse;
import com.bti.service.ServiceSiteBinsSetUp;


/**
 * Name of Project: BTI 
 * Description: Controller ControllerSiteBinsSetup
 * Created on:  OCTOMBER 30, 2017
 * Modified on:
 * @author goodtech
 * version :
 */

@RestController
@RequestMapping("/siteBinsSetup")
public class ControllerSiteBinsSetup {

	@Autowired
	ServiceSiteBinsSetUp serviceSiteBinsSetup;

	@Autowired
	ServiceResponse serviceResponse;

	public void setServicesitebinsetup(ServiceSiteBinsSetUp serviceSiteBinsSetup) {
		this.serviceSiteBinsSetup = serviceSiteBinsSetup;
	}
	
	/**
	 * @description : Create Site Bins Setup
	 * @param request
	 * @param siteBinsSetup
	 * @return
	 */
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveSiteBinsSetUp(HttpServletRequest request, @RequestBody SiteBinsSetup siteBinsSetup) {
		ResponseMessage responseMessage = null;

		SiteBinsSetup siteBinsSetupResult = serviceSiteBinsSetup.saveSiteBinsSetup(siteBinsSetup);
		if (siteBinsSetupResult.getSiteBinInd() != 0) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_CREATED", false), siteBinsSetupResult);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_NOT_CREATED", false),
					siteBinsSetupResult);
		}

		return responseMessage;
	}

	/**
	 * @description : Get all Site Bins Setup
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
	public ResponseMessage getSiteBinsSetup(HttpServletRequest request, SiteBinsSetup siteBinsSetup) {
		ResponseMessage responseMessage = null;
		List<SiteBinsSetup> allSiteBinsSetup = serviceSiteBinsSetup.getSiteBinsSetup();
		if (allSiteBinsSetup != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_GET_ALL", false), allSiteBinsSetup);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_LIST_NOT_GETTING", false));
		}
		return responseMessage;

	}

	/**
	 * @description : Get Site Bins Setup By locationBinName
	 * @param request
	 * @param locationBinName
	 * @return
	 */

	@RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getSiteBinsSetupByLocationBinName(HttpServletRequest request,
			@RequestBody SiteBinsSetup siteBinsSetup) {
		ResponseMessage responseMessage = null;

		SiteBinsSetup siteBinsSetupResult = serviceSiteBinsSetup
				.getSiteBinsSetupByLocationBinName(siteBinsSetup.getLocationBinName());

		if (siteBinsSetupResult != null) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_GET", false), siteBinsSetupResult);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_NOT_GETTING", false),
					siteBinsSetupResult);
		}
		return responseMessage;
	}

	/**
	 * @description : Delete Site Bins Setup
	 * @param request
	 * @param locationBinName
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage deleteSiteBinsSetupByLocationBinName(HttpServletRequest request,
			@RequestBody SiteBinsSetup siteBinsSetup) {

		ResponseMessage responseMessage = null;
		SiteBinsSetup siteBinsSetupResult = serviceSiteBinsSetup
				.deleteSiteBinsSetupByLocationBinName(siteBinsSetup.getLocationBinName());
		if (siteBinsSetupResult != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_DELETED", false), siteBinsSetupResult);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_NOT_DELETED", false));
		}

		return responseMessage;

	}

	/**
	 * @description : Update Site Bins Setup
	 * @param request
	 * @param locationBinName
	 * @return
	 */

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage updateSiteBinsSetup(HttpServletRequest request, @RequestBody SiteBinsSetup siteBinsSetup) {
		ResponseMessage responseMessage = null;

		SiteBinsSetup siteBinsSetupRes = serviceSiteBinsSetup.saveorUpdateSiteBinsSetup(siteBinsSetup);

		responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
				serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_UPDATE_SUCCESS", false), siteBinsSetupRes);

		return responseMessage;
	}

}
