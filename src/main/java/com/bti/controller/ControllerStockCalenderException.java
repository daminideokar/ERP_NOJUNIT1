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
import com.bti.model.StockCalendarExceptionDaysSetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.model.dto.DtoStockCalenderException;
import com.bti.service.ServiceResponse;
import com.bti.service.ServiceStockCalenderException;

/**
 * Name of Project: BTI Description: Controller ControllerStockCalenderException
 * Created on:
 * Modified on:
 * @author goodtech 
 * version :
 */

@RestController
@RequestMapping("/stockCalenderException")
public class ControllerStockCalenderException {
	@Autowired
	ServiceResponse serviceResponse;

	@Autowired
	ServiceStockCalenderException serviceStockCalenderException;

	public void setServiceStockCalenderSetup(ServiceStockCalenderException serviceStockCalenderException) {
		this.serviceStockCalenderException = serviceStockCalenderException;
	}

	/**
	 * @description : Get StockCalenderException
	 * @param request
	 * @param dtoStockCalenderException
	 * @return
	 */

	@RequestMapping(value = "/getall", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getStockCalenderException(HttpServletRequest request,
			@RequestBody DtoStockCalenderException dtoStockCalenderException) {
		ResponseMessage responseMessage = null;
		DtoSearch dtoSearch = serviceStockCalenderException.getStockException(dtoStockCalenderException);
		if (dtoSearch.getRecords() != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("GET_ALL", false), dtoSearch);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("StockCalenderException_LIST_NOT_GETTING", false));
		}

		return responseMessage;

	}

	/**
	 * @description : Save StockCalenderException
	 * @param request
	 * @param dtoStockCalenderException
	 * @return
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveStockCalenderException(HttpServletRequest request,
			@RequestBody DtoStockCalenderException dtoStockCalenderException) {
		ResponseMessage responseMessage = null;
		DtoStockCalenderException dtoStockCalenderExceptionResult = serviceStockCalenderException
				.saveorUpdateStockCalenderexception(dtoStockCalenderException);

		if (dtoStockCalenderExceptionResult.getIdStock() != 0) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("StockCalenderException_CREATED", false),
					dtoStockCalenderExceptionResult);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("StockCalenderException_NOT_CREATED", false));
		}

		return responseMessage;
	}

	/**
	 * @description : Delete StockCalenderException
	 * @param request
	 * @param dtoStockCalenderException
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage deleteStockCalenderException(HttpServletRequest request,
			@RequestBody DtoStockCalenderException dtoStockCalenderException) {
		ResponseMessage responseMessage = null;
		System.out.println("First#" +dtoStockCalenderException.getIdStock());
		if (dtoStockCalenderException.getIdStock() != 0) {
			DtoStockCalenderException dtoStockCalenderExceptionResult = serviceStockCalenderException
					.deleteStockcalenderException(dtoStockCalenderException.getIdStock());

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("STOCK_CALENDER_EXCEPTION_DELETED", false),
					dtoStockCalenderExceptionResult);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("STOCK_CALENDER_EXCEPTION_NOT_DELETED", false));
		}
		
		return responseMessage;
	}
}
