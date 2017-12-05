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
import com.bti.model.dto.DtoSearch;
import com.bti.service.ServiceItemCategorySetUp;
import com.bti.service.ServiceResponse;

/**
 * Description: Controller Item Category Setup
 * Name of Project: BTI
 * Created on: NOVEMBER 8, 2017
 * Modified on: 
 * @author goodtech
 * Version: 
 */

@RestController
@RequestMapping("/itemCategorySetup")
public class ControllerItemCategorySetup {

	@Autowired
	ServiceResponse serviceResponse;

	@Autowired
	ServiceItemCategorySetUp serviceItemCategorySetup;

	/**
	 * @description : Create ItemCategorySetup
	 * @param request
	 * @param dtoItemCategorySetup
	 * @return
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveItemCategorySetup(HttpServletRequest request,
			@RequestBody DtoItemCategorySetUp dtoItemCategorySetup) {
		ResponseMessage responseMessage = null;
		DtoItemCategorySetUp DtoItemCategorySetupResult = serviceItemCategorySetup
				.saveOrUpdateItemCategorySetup(dtoItemCategorySetup);

		if (DtoItemCategorySetupResult.getItemCategoryIndex() != 0) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ItemCategorySetup_CREATED", false),
					DtoItemCategorySetupResult);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ItemCategorySetup_NOT_CREATED", false));
		}

		return responseMessage;
	}

	/**
	 * @description : Get ItemCategorySetup
	 * @param request
	 * @param dtoItemCategorySetup
	 * @return
	 */ 
	
	@RequestMapping(value = "/getbycategory", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getItemCategorySetup(HttpServletRequest request,
			@RequestBody DtoItemCategorySetUp dtoItemCategorySetup) {
		ResponseMessage responseMessage = null;
		DtoSearch dtoSearch = serviceItemCategorySetup.getItemCategorySetupByCategory(dtoItemCategorySetup);
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
	 * @description : Delete ItemCategorySetupByValueCategory
	 * @param request
	 * @param dtoItemCategorySetup
	 * @return
	 */ 
	
	@RequestMapping(value = "/delete", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage deleteItemCategorySetupByValueCategory(HttpServletRequest request,@RequestBody DtoItemCategorySetUp dtoItemCategorySetup) {
		ResponseMessage responseMessage = null;
		if(dtoItemCategorySetup.getItemCategoryIndex() != 0) {
			
			DtoItemCategorySetUp dtoItemCategorySetupResult = serviceItemCategorySetup.deleteItemCategorySetupByValueCategory(dtoItemCategorySetup.getItemCategoryIndex());
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_CATEGORY_VALUE_DELETED", false), dtoItemCategorySetupResult);
		}else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_CATEGORY_VALUE_NOT_DELETED", false));
		
		}
		return responseMessage;
	}
	
	
}
