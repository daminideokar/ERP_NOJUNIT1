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
import com.bti.model.dto.DtoAccountTypeSetUp;
import com.bti.model.dto.DtoBillOfMaterialSetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.model.dto.DtoUnitOfMeasureScheduleSetUp;
import com.bti.service.ServiceResponse;
import com.bti.service.ServiceUnitOfMeasureScheduleSetUp;

/**
 * Name of Project: BTI
 * Description: Controller UnitOfMeasureScheduleSetUp  
 * Created on:NOVEMBER 13,2017
 * Modified on:
 * 
 * @author goodtech
 */
@RestController
@RequestMapping("/unitOfMeasureScheduleSetUp")
public class ControllerUnitOfMeasureScheduleSetUp {
	
	@Autowired
	private ServiceUnitOfMeasureScheduleSetUp serviceUnitOfMeasureScheduleSetUp;
	
	@Autowired
	private ServiceResponse serviceResponse;

	/**
	 * @description : Create UnitOfMeasureScheduleSetUp
	 * @param request
	 * @param dtoUnitOfMeasureScheduleSetUp
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveUnitOfMeasureScheduleSetUp(HttpServletRequest request,
			@RequestBody DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUp) {

		ResponseMessage responseMessage = null;

		DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUpRes = serviceUnitOfMeasureScheduleSetUp
				.saveOrUpdateUnitOfMeasureScheduleSetUp(dtoUnitOfMeasureScheduleSetUp);

		if (dtoUnitOfMeasureScheduleSetUpRes.getUominx() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_CREATED", false), dtoUnitOfMeasureScheduleSetUpRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_NOT_CREATED", false),
					dtoUnitOfMeasureScheduleSetUpRes);

		}
		return responseMessage;
	}	
	
	/**
	 * @description : Update UnitOfMeasureScheduleSetUp
	 * @param request
	 * @param dtoUnitOfMeasureScheduleSetUp
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage updateUnitOfMeasureScheduleSetUp(HttpServletRequest request,
			@RequestBody DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUp) {
		ResponseMessage responseMessage = null;

		DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUpRes = serviceUnitOfMeasureScheduleSetUp
				.saveOrUpdateUnitOfMeasureScheduleSetUp(dtoUnitOfMeasureScheduleSetUp);

		if (dtoUnitOfMeasureScheduleSetUpRes.getUominx() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_UPDATED", false), dtoUnitOfMeasureScheduleSetUpRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					null,
					dtoUnitOfMeasureScheduleSetUpRes);

		}
		return responseMessage;
	}	
	
	/**
	 * @description : getall UnitOfMeasureScheduleSetUp
	 * @param request
	 * @param dtoUnitOfMeasureScheduleSetUp
	 * @return
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getAllAccountTypeSetUp(HttpServletRequest request,
			@RequestBody DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUp) {
		ResponseMessage responseMessage = null;

		DtoSearch dtoSearch = serviceUnitOfMeasureScheduleSetUp.getAllUnitOfMeasureScheduleSetUp(dtoUnitOfMeasureScheduleSetUp);

		if (dtoSearch.getRecords() != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_GET_ALL", false), dtoSearch);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_LIST_NOT_GETTING", false));
		}

		return responseMessage;
	}
	
	/**
	 * @description : getByUnitOfMeasureId UnitOfMeasureScheduleSetUp
	 * @param request
	 * @param dtoUnitOfMeasureScheduleSetUp
	 * @return
	 */
	@RequestMapping(value = "/getByUnitOfMeasureId", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage getByUnitOfMeasureId(HttpServletRequest request,
			@RequestBody DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUp) {

		ResponseMessage responseMessage = null;

		DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUpRes = serviceUnitOfMeasureScheduleSetUp
				.getUnitOfMeasureScheduleSetUpByUOfMId(dtoUnitOfMeasureScheduleSetUp);

		if (dtoUnitOfMeasureScheduleSetUpRes != null) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_CREATED", false), dtoUnitOfMeasureScheduleSetUpRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("UnitOfMeasureScheduleSetUp_NOT_CREATED", false),
					dtoUnitOfMeasureScheduleSetUpRes);

		}
		return responseMessage;
	}	
	
	/**
	 * @description : Delete UnitOfMeasureScheduleSetUp
	 * @param request
	 * @param dtoUnitOfMeasureScheduleSetUp
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage deleteBillOfMaterialSetup(HttpServletRequest request,
			@RequestBody DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUp) {

		ResponseMessage responseMessage = null;

		DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUpRes = serviceUnitOfMeasureScheduleSetUp
				.delete(dtoUnitOfMeasureScheduleSetUp);

		if (dtoUnitOfMeasureScheduleSetUpRes != null) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_CREATED", false),
					dtoUnitOfMeasureScheduleSetUpRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false),
					dtoUnitOfMeasureScheduleSetUpRes);

		}
		return responseMessage;
	}

	
	
	


}
