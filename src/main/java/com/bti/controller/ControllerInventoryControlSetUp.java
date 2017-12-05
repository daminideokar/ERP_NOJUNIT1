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
import com.bti.model.dto.DtoInventoryControlSetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.service.ServiceInventoryControlSetUp;
import com.bti.service.ServiceResponse;

/**
 * Description: Controller Inventory Control SetUp 
 * Name of Project: BTI 
 * Created on:NOVEMBER 09, 2017 
 * Modified on: 
 * @author GoodTech
 * Version:
 */

@RestController
@RequestMapping(value = "/inventory")
public class ControllerInventoryControlSetUp {
	@Autowired
	private ServiceInventoryControlSetUp serviceInventoryControlSetUp;
	@Autowired
	private ServiceResponse serviceResponse;

	/**
	 * @description : create InventoryControlSetup
	 * @param request
	 * @param dtoInventoryControlSetUp
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveInventorySetup(HttpServletRequest request,
			@RequestBody DtoInventoryControlSetUp dtoInventoryControlSetup) {

		ResponseMessage responseMessage = null;

		DtoInventoryControlSetUp dtoInventoryControlSetupRes = serviceInventoryControlSetUp
				.saveOrUpdate(dtoInventoryControlSetup);

		if (dtoInventoryControlSetupRes.getKeySetupId() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_CREATED", false),
					dtoInventoryControlSetupRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false),
					dtoInventoryControlSetupRes);

		}
		return responseMessage;
	}

	/**
	 * @description : getall InventoryControlSetup
	 * @param request
	 * @param dtoInventoryControlSetUp
	 * @return
	 */

	@RequestMapping(value = "/getall", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getInventorySetup(HttpServletRequest request,
			@RequestBody DtoInventoryControlSetUp dtoInventoryControlSetup) {
		ResponseMessage responseMessage = null;
		System.out.println("in controller :" + dtoInventoryControlSetup.getUserCategoryName1());
		DtoSearch dtoSearch = serviceInventoryControlSetUp.getAllInventorySetup(dtoInventoryControlSetup);
		System.out.println("hello %%%%%%" + dtoInventoryControlSetup.getUserCategoryName1());

		if (dtoSearch.getRecords() != null) {
			System.out.println("in if controller :" + dtoInventoryControlSetup.getUserCategoryName3());
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CONTROL_GET_ALL", false), dtoSearch);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CONTROL_NOT_GETTING", false));
		}

		return responseMessage;
	}

	/**
	 * @description : update InventoryControlSetup
	 * @param request
	 * @param dtoItemLotCategorySetup
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage updateInventoryControlSetup(HttpServletRequest httpServletRequest,
			@RequestBody DtoInventoryControlSetUp dtoInventoryControlSetup) {
		ResponseMessage responseMessage = null;
		DtoInventoryControlSetUp dtoItemLotCategorySetupRes = serviceInventoryControlSetUp
				.saveOrUpdate(dtoInventoryControlSetup);

		if (dtoInventoryControlSetup.getKeySetupId() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CONTROL_SET_UP_CREATED", false),
					dtoItemLotCategorySetupRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CONTROL_SET_UP_CREATED_NOT_CREATED",
							false));
		}
		return responseMessage;

	}

	/**
	 * @description : Delete DtoInventoryControlSetup
	 * @param request
	 * @param DtoInventoryControlSetUp
	 * @return
	 */

	@RequestMapping(value = "/delete", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage deleteInventoryControlSetupByValueCategory(HttpServletRequest request,
			@RequestBody DtoInventoryControlSetUp dtoInventoryControlSetup) {
		ResponseMessage responseMessage = null;
		if (dtoInventoryControlSetup.getKeySetupId() != 0) {

			DtoInventoryControlSetUp dtoInventoryControlSetupRes = serviceInventoryControlSetUp
					.deleteInventorySetupByValueCategory(dtoInventoryControlSetup.getKeySetupId());
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CONTROL_VALUE_DELETED", false),
					dtoInventoryControlSetupRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CONTROL_VALUE_NOT_DELETED", false));

		}
		return responseMessage;
	}

}
