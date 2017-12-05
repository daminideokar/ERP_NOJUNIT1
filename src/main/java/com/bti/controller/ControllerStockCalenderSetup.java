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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bti.config.ResponseMessage;
import com.bti.model.dto.DtoStockCalenderSetUp;
import com.bti.service.ServiceResponse;
import com.bti.service.ServiceStockCalenderSetUp;

/**
 * Name of Project: BTI 
 * Description: Controller ControllerStockCalenderSetup
 * Created on: 
 * Modified on:
 * @author goodtech
 * version :
 */

@RestController
@RequestMapping("/stockCalenderSetup")
public class ControllerStockCalenderSetup {
	@Autowired
	ServiceResponse serviceResponse;

	@Autowired
	ServiceStockCalenderSetUp serviceStockCalenderSetup;

	public void setServiceStockCalenderSetup(ServiceStockCalenderSetUp serviceStockCalenderSetup) {
		this.serviceStockCalenderSetup = serviceStockCalenderSetup;
	}

	
	/**
	 * @description : Save StockCalenderSetup
	 * @param request
	 * @param dtoStockCalenderSetup
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveStockCalenderSetup(HttpServletRequest request,
			@RequestBody DtoStockCalenderSetUp dtoStockCalenderSetup) {
		ResponseMessage responseMessage = null;
		DtoStockCalenderSetUp dtoStockCalenderSetupResult = serviceStockCalenderSetup
				.saveorUpdateStockCalenderSetup(dtoStockCalenderSetup);

		if (dtoStockCalenderSetupResult.getIdSetup() != 0) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("StockCalenderSetup_CREATED", false),
					dtoStockCalenderSetupResult);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("StockCalenderSetup_NOT_CREATED", false));
		}

		return responseMessage;
	}
}
