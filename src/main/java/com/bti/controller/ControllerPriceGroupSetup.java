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

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bti.config.ResponseMessage;
import com.bti.model.dto.DtoPriceGroupSetup;
import com.bti.model.dto.DtoSearch;
import com.bti.service.ServicePriceGroupSetUp;
import com.bti.service.ServiceResponse;

/**
 * Name of Project: BTI
 * Description: Controller PriceGroupSetup  
 * Created on:NOVEMBER 6,2017
 * Modified on:
 * 
 * @author goodtech
 */
@RestController
@RequestMapping("/priceGroupSetup")
public class ControllerPriceGroupSetup {

	@Autowired
	private ServicePriceGroupSetUp servicePriceGroupSetUp;

	@Autowired
	ServiceResponse serviceResponse;

	/**
	 * @description : Get all PriceGroupSetup
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getSiteSetup(HttpServletRequest request,
			@RequestBody DtoPriceGroupSetup dtoPriceGroupSetup) {
		ResponseMessage responseMessage = null;

		DtoSearch dtoSearch = servicePriceGroupSetUp.getAllPriceGroupSetup(dtoPriceGroupSetup);

		if (dtoSearch.getRecords() != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("COMPANY_GET_ALL", false), dtoSearch);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("COMPANY_LIST_NOT_GETTING", false));
		}

		return responseMessage;
	}

	/**
	 * @description : Create PriceGroupSetUp
	 * @param request
	 * @param dtoPriceGroupSetup
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage savePriceGroupSetup(HttpServletRequest request,
			@RequestBody DtoPriceGroupSetup dtoPriceGroupSetup) {

		ResponseMessage responseMessage = null;

		DtoPriceGroupSetup dtoPriceGroupSetupRes = servicePriceGroupSetUp
				.saveOrUpdatePriceGroupSetup(dtoPriceGroupSetup);

		if (dtoPriceGroupSetupRes.getPriceGroupIndex() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_CREATED", false), dtoPriceGroupSetupRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false),
					dtoPriceGroupSetupRes);

		}
		return responseMessage;
	}

	/**
	 * @description : Update PriceGroupSetup
	 * @param request
	 * @param dtoPriceGroupSetup
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage updateSiteBinsSetup(HttpServletRequest request,
			@RequestBody DtoPriceGroupSetup dtoPriceGroupSetup) {
		ResponseMessage responseMessage = null;

		DtoPriceGroupSetup dtoPriceGroupSetupRes = servicePriceGroupSetUp
				.saveOrUpdatePriceGroupSetup(dtoPriceGroupSetup);
		if (dtoPriceGroupSetupRes.getPriceGroupIndex() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetup_UPDATE_SUCCESS", false),
					dtoPriceGroupSetupRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetup_NOT_UPDATE", false),
					dtoPriceGroupSetupRes);
		}

		return responseMessage;
	}

	/**
	 * @description : Get PriceGroupSetup By PricegroupId
	 * @param request
	 * @param dtoPriceGroupSetup
	 * @return
	 */
	@RequestMapping(value = "/getByPriceGroupId", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getSiteSetupById(HttpServletRequest request,
			@RequestBody DtoPriceGroupSetup dtoPriceGroupSetup) {

		ResponseMessage responseMessage = null;

		DtoPriceGroupSetup dtoPriceGroupSetupRes = servicePriceGroupSetUp.getPriceGroupById(dtoPriceGroupSetup);

		responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
				serviceResponse.getMessageByShortAndIsDeleted("GET_SiteSetUp", false), dtoPriceGroupSetupRes);

		return responseMessage;
	}

}
