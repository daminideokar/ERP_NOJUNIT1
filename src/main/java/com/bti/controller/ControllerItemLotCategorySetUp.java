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

import com.bti.model.dto.DtoItemLotCategorySetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.service.ServiceItemLotCategorySetUp;
import com.bti.service.ServiceResponse;
/**
 * Description:Controller Item Lot Category SetUp
 * Name of Project: BTI 
 * Created on: NOVEMBER 08, 2017 
 * Modified on:
 * @author GoodTech Version:
 */
@RestController
@RequestMapping(value = "/itemlot")
//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ControllerItemLotCategorySetUp {
	@Autowired
	private ServiceItemLotCategorySetUp serviceItemLotCategorySetup;

	@Autowired
	private ServiceResponse serviceResponse;

	/**
	 * @description : Get all ItemLotCategory
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getItemLotcategorySetUp(HttpServletRequest request,
			@RequestBody DtoItemLotCategorySetUp dtoItemLotCategorySetup) {
		ResponseMessage responseMessage = null;

		DtoSearch dtoSearch = serviceItemLotCategorySetup.getAllItemLotCategory(dtoItemLotCategorySetup);

		if (dtoSearch.getRecords() != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_LOT_GET_ALL", false), dtoSearch);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_LOT__LIST_NOT_GETTING", false));
		}

		return responseMessage;
	}

	/**
	 * @description : Create ItemLotCategorySetup
	 * @param request
	 * @param dtoItemLotCategorySetup
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveItemLotCategorySetup(HttpServletRequest httpServletRequest,
			@RequestBody DtoItemLotCategorySetUp dtoItemLotCategorySetup) {
		ResponseMessage responseMessage = null;
		DtoItemLotCategorySetUp dtoItemLotCategorySetupRes = serviceItemLotCategorySetup
				.saveOrUpdateItemLotCategorySetup(dtoItemLotCategorySetup);
		if (dtoItemLotCategorySetupRes.getLotItemCategoryIndex() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ItemLotCategorySetup_CREATED", false),
					dtoItemLotCategorySetupRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ItemLotCategorySetup_NOT_CREATED", false));
		}
		return responseMessage;
	}

	/**
	 * @description : update ItemLotCategorySetup
	 * @param request
	 * @param dtoItemLotCategorySetup
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage updateItemLotCategorySetup(HttpServletRequest httpServletRequest,
			@RequestBody DtoItemLotCategorySetUp dtoItemLotCategorySetup) {
		ResponseMessage responseMessage = null;
		DtoItemLotCategorySetUp dtoItemLotCategorySetupRes = serviceItemLotCategorySetup
				.saveOrUpdateItemLotCategorySetup(dtoItemLotCategorySetup);

		if (dtoItemLotCategorySetupRes.getLotItemCategoryIndex() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ItemLotCategorySetup_CREATED", false),
					dtoItemLotCategorySetupRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ItemLotCategorySetup_NOT_CREATED", false));
		}
		return responseMessage;

	}

	/**
	 * @description : Get by id ItemLotCategorySetup
	 * @param request
	 * @param dtoItemCategorySetup
	 * @return
	 */

	@RequestMapping(value = "/getbylotcategory", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getItemLotCategorySetup(HttpServletRequest request,
			@RequestBody DtoItemLotCategorySetUp dtoItemLotCategorySetup) {
		ResponseMessage responseMessage = null;
		DtoSearch dtoSearch = serviceItemLotCategorySetup.getItemLotCategorySetupByLotCategory(dtoItemLotCategorySetup);
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
	 * @description : Delete ItemLotCategorySetupByValueCategory
	 * @param request
	 * @param dtoItemLotCategorySetup
	 * @return
	 */

	@RequestMapping(value = "/delete", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage deleteItemLotCategorySetupByValueCategory(HttpServletRequest request,
			@RequestBody DtoItemLotCategorySetUp dtoItemLotCategorySetup) {
		ResponseMessage responseMessage = null;
		if (dtoItemLotCategorySetup.getLotItemCategoryIndex() != 0) {

			DtoItemLotCategorySetUp dtoItemLotCategorySetupRes = serviceItemLotCategorySetup
					.deleteItemLotCategorySetupByValueCategory(dtoItemLotCategorySetup.getLotItemCategoryIndex());
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_LOT_CATEGORY_VALUE_DELETED", false),
					dtoItemLotCategorySetupRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ITEM_LOT_CATEGORY_VALUE_NOT_DELETED", false));

		}
		return responseMessage;
	}

}
