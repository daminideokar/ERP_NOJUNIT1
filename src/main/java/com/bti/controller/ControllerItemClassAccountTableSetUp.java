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
import com.bti.model.dto.DtoInventoryClassSetupCurrency;
import com.bti.model.dto.DtoItemClassAccountTableSetUp;
import com.bti.service.ServiceItemClassAccountTableSetUp;
import com.bti.service.ServiceResponse;

/**
 * Description:  Controller Item Class Aaccount Table SetUp
 * Name of Project: BTI
 * Created on: NOVEMBER 15,2017
 * Modified on: 
 * @author :GoodTech Version:
 */

@RestController
@RequestMapping(value = "/itemAccountTableSetUp")
public class ControllerItemClassAccountTableSetUp {
	@Autowired
	private ServiceItemClassAccountTableSetUp serviceItemClassAccountTableSetup;
	@Autowired
	private ServiceResponse serviceResponse;

	/**
	 * @description : save ItemClassAccountTableSetup
	 * @param request
	 * @param dtoItemClassAccountTableSetup
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage saveAccountTableSetUp(HttpServletRequest httpServletRequest,
			@RequestBody DtoItemClassAccountTableSetUp dtoItemClassAccountTableSetup) {

		ResponseMessage responseMessage = null;
		DtoItemClassAccountTableSetUp dtoItemClassAccountTableSetupRes = serviceItemClassAccountTableSetup
				.saveOrUpdateAccountTableSetUp(dtoItemClassAccountTableSetup);
		System.out.println("in controller ::" + dtoItemClassAccountTableSetup.getItemClassId());
		if (dtoItemClassAccountTableSetupRes.getItemClassId() != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_ACCOUNT_TABLE_CREATED", false),
					dtoItemClassAccountTableSetupRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_ACCOUNT_TABLE_SET_UP_NOT_CREATED", false),
					dtoItemClassAccountTableSetupRes);
		}

		return responseMessage;
	}

	/**
	 * @description : update ItemClassAccountTableSetup
	 * @param request
	 * @param dtoItemClassAccountTableSetup
	 * @return
	 */

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage updateAccountTableSetUp(HttpServletRequest httpServletRequest,
			@RequestBody DtoItemClassAccountTableSetUp dtoItemClassAccountTableSetup) {

		ResponseMessage responseMessage = null;
		DtoItemClassAccountTableSetUp dtoItemClassAccountTableSetupRes = serviceItemClassAccountTableSetup
				.saveOrUpdateAccountTableSetUp(dtoItemClassAccountTableSetup);
		System.out.println("in controller ::" + dtoItemClassAccountTableSetup.getItemClassId());
		if (dtoItemClassAccountTableSetupRes.getItemClassId() != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_ACCOUNT_TABLE_CREATED", false),
					dtoItemClassAccountTableSetupRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_ACCOUNT_TABLE_SET_UP_NOT_CREATED", false),
					dtoItemClassAccountTableSetupRes);
		}

		return responseMessage;
	}
}
