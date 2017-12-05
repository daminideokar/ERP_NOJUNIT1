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
import com.bti.model.dto.DtoCurrencySetUp;
import com.bti.service.ServiceCurrencySetUp;
import com.bti.service.ServiceResponse;
/**
 * Description: Controller Currency SetUp
 * Name of Project: BTI
 * Created on: NOVEMBER 13, 2017 
 * Modified on: 
 * @author GoodTech
 * Version: 
 */
@RestController
@RequestMapping(value="/currencysetup")
public class ControllerCurrencySetUp {
	
	@Autowired
	 ServiceCurrencySetUp serviceCurrencySetUp ;
	
	@Autowired
	 ServiceResponse serviceResponse; 
	
	
	/**
	 * @description : get By currency Level Id
	 * @param request
	 * @param dtoCurrencySetUp
	 * @return
	 */

	
	@RequestMapping(value = "/getByCurrencyId", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getCurrencySetUpById(HttpServletRequest request,
			@RequestBody DtoCurrencySetUp dtoCurrencySetUp) {

		ResponseMessage responseMessage = null;
		System.out.println("in controplleer ::"+dtoCurrencySetUp.getCurrencyId());

		DtoCurrencySetUp dtoCurrencySetUpRes = serviceCurrencySetUp.getByCurrencyId(dtoCurrencySetUp);
		 if(dtoCurrencySetUpRes != null) {
		responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
				serviceResponse.getMessageByShortAndIsDeleted("GET_CURRENCY_SET_UP", false), dtoCurrencySetUpRes);
		 }
		 else {
			 responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.BAD_REQUEST,
						serviceResponse.getMessageByShortAndIsDeleted("NOT_GETTING_CURRENCY_SET_UP", false), dtoCurrencySetUpRes);
		 }
		return responseMessage;
	}
	
	
}
