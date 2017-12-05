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
import com.bti.model.dto.DtoFinancialDimensionsTable;
import com.bti.model.dto.DtoItemClassSetUp;
import com.bti.service.ServiceFinancialDimensionsTable;
import com.bti.service.ServiceResponse;

/**
 * Description: Controller financial dimensions table
 * Name of Project: BTI
 * Created on:NOVEMBER 16, 2017
 * Modified on:
 * @author GoodTech Version:
 */
@RestController
@RequestMapping(value = "/finance")
public class ControllerFinancialDimensionsTable {

	@Autowired
	private ServiceFinancialDimensionsTable serviceFinancialDimensionsTable;
	@Autowired
	private ServiceResponse serviceResponse;

	/**
	 * @description : get By item class Id
	 * @param request
	 * @param dtoItemClassSetup
	 * @return
	 */
	@RequestMapping(value = "/getbyfinanceid", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getByFinanceId(HttpServletRequest request,
			@RequestBody DtoFinancialDimensionsTable dtoFinancialDimensionsTable) {

		ResponseMessage responseMessage = null;

		DtoFinancialDimensionsTable dtoFinancialDimensionsTableRes = serviceFinancialDimensionsTable
				.getByFinacialClassId(dtoFinancialDimensionsTable);
		if (dtoFinancialDimensionsTable != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("GET_FINANCE_SET_UP", false),
					dtoFinancialDimensionsTableRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("FINANCE_SET_UP_NOT_CREATED", false),
					dtoFinancialDimensionsTableRes);

		}

		return responseMessage;
	}

}
