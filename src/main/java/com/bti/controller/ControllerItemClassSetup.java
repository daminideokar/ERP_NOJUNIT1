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
import com.bti.model.dto.DtoItemCategorySetUp;
import com.bti.model.dto.DtoItemClassSetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.service.ServiceItemClassSetUp;
import com.bti.service.ServiceResponse;

/**
 * Description: Controller Item Class Setup
 * Name of Project: BTI
 * Created on: NoVEMBER 10, 2017
 * Modified on: 
 * @author goodtech
 * Version:	
 */

@RestController
@RequestMapping("/itemClassSetup")
public class ControllerItemClassSetup {

	@Autowired
	ServiceResponse serviceResponse;
	
	@Autowired
	ServiceItemClassSetUp serviceItemClassSetup;
	
	/**
	 * @description : Create ItemClassSetup
	 * @param request
	 * @param dtoItemClassSetup
	 * @return
	 */
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveItemClassSetup(HttpServletRequest request,
			@RequestBody DtoItemClassSetUp dtoItemClassSetup) {
		ResponseMessage responseMessage = null;

		DtoItemClassSetUp dtoItemClassSetupResult = serviceItemClassSetup
				.saveOrUpdateItemClassSetup(dtoItemClassSetup);

		if (dtoItemClassSetupResult.getItemClassIndex() != 0) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ItemClassSetup_CREATED", false),
					dtoItemClassSetupResult);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ItemClassSetup_NOT_CREATED", false));
		}

		return responseMessage;
	}
	
	
	/**
	 * @description : Get ItemClassSetup
	 * @param request
	 * @param dtoItemClassSetup
	 * @return
	 */ 
	
	@RequestMapping(value = "/get", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getItemClassSetup(HttpServletRequest request,
			@RequestBody DtoItemClassSetUp dtoItemClassSetup) {
		ResponseMessage responseMessage = null;
		DtoSearch dtoSearch = serviceItemClassSetup.getItemClassSetup(dtoItemClassSetup);
		if (dtoSearch.getRecords() != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("GET_ALL", false), dtoSearch);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("LIST_NOT_GETTING", false));
		}

		return responseMessage;

	}
	
	/**
	 * @description : Delete ItemClassSetup
	 * @param request
	 * @param dtoItemClassSetup
	 * @return
	 */ 
	
	@RequestMapping(value = "/delete", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage deleteItemClassSetup(HttpServletRequest request,@RequestBody DtoItemClassSetUp dtoItemClassSetup) {
		ResponseMessage responseMessage = null;
		if(dtoItemClassSetup.getItemClassIndex() != 0) {
			
			DtoItemClassSetUp dtoItemClassSetupResult = serviceItemClassSetup.deleteItemClassSetup(dtoItemClassSetup.getItemClassIndex());
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_CLASS_DELETED", false), dtoItemClassSetupResult);
		}else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_CLASS_NOT_DELETED", false));
		
		}
		return responseMessage;
	}


	/**
	 * @description : get By item class Id
	 * @param request
	 * @param dtoItemClassSetup
	 * @return
	 */
	@RequestMapping(value = "/getbyitemclassid", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getByItemClassId(HttpServletRequest request,
			@RequestBody DtoItemClassSetUp dtoItemClassSetup) {

		ResponseMessage responseMessage = null;

		DtoItemClassSetUp dtoItemClassSetup2 = serviceItemClassSetup.getByItemClassId(dtoItemClassSetup);
		if (dtoItemClassSetup != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("GET_ITEM_CLASS_SET_UP", false), dtoItemClassSetup2);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("GET_ITEM_CLASS_SET_UP_NOT_CREATED", false),
					dtoItemClassSetup2);

		}

		return responseMessage;
	}

}
