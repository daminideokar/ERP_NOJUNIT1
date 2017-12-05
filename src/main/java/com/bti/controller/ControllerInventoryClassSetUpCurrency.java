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
import com.bti.model.dto.DtoCurrencySetUp;
import com.bti.model.dto.DtoInventoryClassSetupCurrency;
import com.bti.model.dto.DtoItemClassSetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.service.ServiceCurrencySetUp;
import com.bti.service.ServiceInventoryClassSetupCurrency;
import com.bti.service.ServiceItemClassSetUp;
import com.bti.service.ServiceResponse;

/**
 * Description: Controller Inventory Class SetUp 
 * Name of Project: BTI 
 * Created on: NOVEMBER 13, 2017
 * Modified on: 
 * @author GoodTech
 * Version:
 */
@RestController
@RequestMapping(value = "/classSetUpCurrencySetUp")
public class ControllerInventoryClassSetUpCurrency {
	@Autowired
	private ServiceItemClassSetUp serviceItemClassSetup;

	@Autowired
	private ServiceInventoryClassSetupCurrency serviceInventoryClassSetupCurrency;

	@Autowired
	private ServiceResponse serviceResponse;
	@Autowired
	private ServiceCurrencySetUp serviceCurrencySetUp;

	/**
	 * @description : create InventoryClassSetupCurrency
	 * @param request
	 * @param dtoInventoryClassSetupCurrency
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveInventrolCurrency(HttpServletRequest request,
			@RequestBody DtoInventoryClassSetupCurrency dtoInventoryClassSetupCurrency) {

		ResponseMessage responseMessage = null;
		DtoInventoryClassSetupCurrency dtoInventoryClassSetupCurrencyRes = serviceInventoryClassSetupCurrency
				.saveOrUpdateCurrency(dtoInventoryClassSetupCurrency);
		System.out.println("in controller : " + dtoInventoryClassSetupCurrency.getIv40400());
		if (dtoInventoryClassSetupCurrencyRes.getItemClassId() != null
				&& dtoInventoryClassSetupCurrencyRes.getCurrencyId() != null) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CONTROL_CREATED", false),
					dtoInventoryClassSetupCurrencyRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CONTROL_NOT_CREATED", false),
					dtoInventoryClassSetupCurrencyRes);

		}
		return responseMessage;
	}

	/**
	 * @description :get all inventory currency set up
	 * @param request
	 * @param dtoInventoryClassSetupCurrency
	 * @return
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getallinventoryCurrency(HttpServletRequest request,
			@RequestBody DtoInventoryClassSetupCurrency dtoInventoryClassSetupCurrency) {
		ResponseMessage responseMessage = null;

		DtoSearch dtoSearch = serviceInventoryClassSetupCurrency
				.getAllInventoryCurrencySetUp(dtoInventoryClassSetupCurrency);

		if (dtoSearch.getRecords() != null) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CURRENCY_GET_ALL", false), dtoSearch);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CURRENCY_LIST_NOT_GETTING", false));
		}

		return responseMessage;
	}

	/**
	 * @description :update inventory currency set up
	 * @param request
	 * @param dtoInventoryClassSetupCurrency
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage updateCurrencySetUp(HttpServletRequest request,
			@RequestBody DtoInventoryClassSetupCurrency dtoInventoryClassSetupCurrency) {

		ResponseMessage responseMessage = null;
		DtoInventoryClassSetupCurrency dtoInventoryClassSetupCurrencyRes = serviceInventoryClassSetupCurrency
				.saveOrUpdateCurrency(dtoInventoryClassSetupCurrency);
		
		if (dtoInventoryClassSetupCurrencyRes != null) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CONTROL_CREATED", false),
					dtoInventoryClassSetupCurrencyRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("INVENTORY_CONTROL_NOT_CREATED", false));

		}
		return responseMessage;
	}

}