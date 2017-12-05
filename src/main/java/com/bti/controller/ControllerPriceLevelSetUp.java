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
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bti.config.ResponseMessage;
import com.bti.model.dto.DtoPriceLevelSetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.service.ServicePriceLevelSetUp;
import com.bti.service.ServiceResponse;

/**
 * Description:Controller PriceLevel SetUp
 * Name of Project: BTI
 * Created on: NOVEMBER 07, 2017
 * Modified on:
 * @author GoodTech Version:
 */

@RestController
@RequestMapping(value = "/priceLevel")
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ControllerPriceLevelSetUp {

	@Autowired
	private ServicePriceLevelSetUp servicePriceLevelSetUp;

	@Autowired
	ServiceResponse serviceResponse;

	/**
	 * @description : Update PriceLevelSetUp
	 * @param request
	 * @param dtoPriceLevelSetUp
	 * @return
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getPriceLevelSetUP(HttpServletRequest request,
			@RequestBody DtoPriceLevelSetUp dtoPriceLevelSetUp) {
		ResponseMessage responseMessage = null;
		DtoSearch dtoSearch = servicePriceLevelSetUp.getAllPriceLevelSetUp(dtoPriceLevelSetUp);
		if (dtoSearch.getRecords() != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("PriceLevelSetup_GET_ALL", false), dtoSearch);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("PriceLevelSetup__NOT_GETTING", false));
		}
		return responseMessage;
	}

	/**
	 * @description : Update PriceLevelSetup
	 * @param request
	 * @param dtoPriceLevelSetup
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage updatePriceLevelSetUp(HttpServletRequest request,
			@RequestBody DtoPriceLevelSetUp dtoPriceLevelSetUp) {
		ResponseMessage responseMessage = null;
		DtoPriceLevelSetUp dtoPriceLevelSetUpRes = servicePriceLevelSetUp
				.saveOrUpdatePricelevelSetUp(dtoPriceLevelSetUp);
		if (dtoPriceLevelSetUpRes.getPriceLevelIndex() != 0) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("PriceLevelSetup_UPDATE_SUCCESS", false),
					dtoPriceLevelSetUpRes);
		}
		return responseMessage;
	}

	/**
	 * @description : create PriceLevelSetup
	 * @param request
	 * @param dtoPriceLevelSetup
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage savePriceLevelSetup(HttpServletRequest request,
			@RequestBody DtoPriceLevelSetUp dtoPriceLevelSetUp) {

		ResponseMessage responseMessage = null;

		DtoPriceLevelSetUp dtoPriceLevelSetUpRes = servicePriceLevelSetUp
				.saveOrUpdatePricelevelSetUp(dtoPriceLevelSetUp);

		if (dtoPriceLevelSetUpRes.getPriceLevelIndex() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("PRICE_LEVEL_SET_UP_CREATED", false),
					dtoPriceLevelSetUpRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("PRICE_LEVEL_SET_UP_NOT_CREATED", false),
					dtoPriceLevelSetUpRes);

		}
		return responseMessage;
	}

	/**
	 * @description : get By Price Level Id
	 * @param request
	 * @param dtoPriceLevelSetup
	 * @return
	 */
	@RequestMapping(value = "/getbypricelevelid", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getPriceLevelById(HttpServletRequest request,
			@RequestBody DtoPriceLevelSetUp dtoPriceLevelSetUp) {
		ResponseMessage responseMessage = null;
		DtoPriceLevelSetUp dtoPriceLevelSetUpRes = servicePriceLevelSetUp.getPriceLevelSetUpById(dtoPriceLevelSetUp);
		responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
				serviceResponse.getMessageByShortAndIsDeleted("GET_PRICE_LEVEL_SETUP", false), dtoPriceLevelSetUpRes);
		return responseMessage;
	}

}
