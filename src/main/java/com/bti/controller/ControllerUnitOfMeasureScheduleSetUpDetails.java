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
import com.bti.model.dto.DtoSearch;

import com.bti.model.dto.DtoUnitOfMeasureScheduleSetUpDetails;
import com.bti.service.ServiceResponse;
import com.bti.service.ServiceUnitOfMeasureScheduleSetUpDetails;


/**
 * Name of Project: BTI
 * Description: Controller UnitOfMeasureScheduleSetUpDetails  
 * Created on:NOVEMBER 14,2017
 * Modified on:
 * 
 * @author goodtech
 */
@RestController
@RequestMapping("/unitOfMeasureScheduleSetUpDetails")
public class ControllerUnitOfMeasureScheduleSetUpDetails {

	@Autowired
	private ServiceUnitOfMeasureScheduleSetUpDetails serviceUnitOfMeasureScheduleSetUpDetails;

	@Autowired
	private ServiceResponse serviceResponse;

	/**
	 * @description : Create UnitOfMeasureScheduleSetUpDetails
	 * @param request
	 * @param dtoUnitOfMeasureScheduleSetUpDetails
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveUnitOfMeasureScheduleSetUpDetails(HttpServletRequest request,
			@RequestBody DtoUnitOfMeasureScheduleSetUpDetails dtoUnitOfMeasureScheduleSetUpDetails) {

		ResponseMessage responseMessage = null;

		DtoUnitOfMeasureScheduleSetUpDetails dtoUnitOfMeasureScheduleSetUpDetailsRes = serviceUnitOfMeasureScheduleSetUpDetails
				.saveOrUpdateUnitOfMeasureScheduleSetUpDetails(dtoUnitOfMeasureScheduleSetUpDetails);

		if (dtoUnitOfMeasureScheduleSetUpDetailsRes.getIndex() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_CREATED", false),
					dtoUnitOfMeasureScheduleSetUpDetailsRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_NOT_CREATED", false),
					dtoUnitOfMeasureScheduleSetUpDetailsRes);

		}
		return responseMessage;
	}

	/**
	 * @description : Update UnitOfMeasureScheduleSetUpDetails
	 * @param request
	 * @param dtoUnitOfMeasureScheduleSetUpDetails
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage updateUnitOfMeasureScheduleSetUpDetails(HttpServletRequest request,
			@RequestBody DtoUnitOfMeasureScheduleSetUpDetails dtoUnitOfMeasureScheduleSetUpDetails) {

		ResponseMessage responseMessage = null;

		DtoUnitOfMeasureScheduleSetUpDetails dtoUnitOfMeasureScheduleSetUpDetailsRes = serviceUnitOfMeasureScheduleSetUpDetails
				.saveOrUpdateUnitOfMeasureScheduleSetUpDetails(dtoUnitOfMeasureScheduleSetUpDetails);

		if (dtoUnitOfMeasureScheduleSetUpDetailsRes.getIndex() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_CREATED", false),
					dtoUnitOfMeasureScheduleSetUpDetailsRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_NOT_CREATED", false),
					dtoUnitOfMeasureScheduleSetUpDetailsRes);

		}
		return responseMessage;
	}

	/**
	 * @description : getall UnitOfMeasureScheduleSetUpDetails
	 * @param request
	 * @param dtoUnitOfMeasureScheduleSetUpDetails
	 * @return
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getAllUnitOfMeasureScheduleSetUpDetails(HttpServletRequest request,
			@RequestBody DtoUnitOfMeasureScheduleSetUpDetails dtoUnitOfMeasureScheduleSetUpDetails) {
		ResponseMessage responseMessage = null;

		DtoSearch dtoSearch = serviceUnitOfMeasureScheduleSetUpDetails
				.getAllUnitOfMeasureScheduleSetUpDetails(dtoUnitOfMeasureScheduleSetUpDetails);

		if (dtoSearch.getRecords() != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_GET_ALL", false),
					dtoSearch);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_LIST_NOT_GETTING",
							false));
		}

		return responseMessage;
	}

	/**
	 * @description : Delete UnitOfMeasureScheduleSetUpDetails
	 * @param request
	 * @param dtoUnitOfMeasureScheduleSetUpDetails
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage deleteBillOfMaterialSetupDetails(HttpServletRequest request,
			@RequestBody DtoUnitOfMeasureScheduleSetUpDetails dtoUnitOfMeasureScheduleSetUpDetails) {

		ResponseMessage responseMessage = null;
		DtoUnitOfMeasureScheduleSetUpDetails dtoUnitOfMeasureScheduleSetUpDetailsRes = serviceUnitOfMeasureScheduleSetUpDetails
				.delete(dtoUnitOfMeasureScheduleSetUpDetails);

		if (dtoUnitOfMeasureScheduleSetUpDetailsRes != null) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_CREATED", false),
					dtoUnitOfMeasureScheduleSetUpDetailsRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false),
					dtoUnitOfMeasureScheduleSetUpDetailsRes);

		}
		return responseMessage;
	}

}
