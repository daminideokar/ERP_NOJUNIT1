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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bti.config.ResponseMessage;
import com.bti.model.ItemKits;
import com.bti.model.ItemMaintenance;
import com.bti.model.dto.DtoItemKits;
import com.bti.model.dto.DtoItemMaintenece;
import com.bti.model.dto.DtoSearch;
import com.bti.service.ServiceItemKits;
import com.bti.service.ServiceResponse;

/**
 * Name of Project: BTI 
 * Description: Controller ItemKits 
 * Created on:NOVEMBER 24,2017
 * Modified on:
 * 
 * @author goodtech
 */
@RestController
@RequestMapping("/itemKits")
public class ControllerItemKits {

	@Autowired
	private ServiceItemKits serviceItemKits;
	
	@Autowired
	private ServiceResponse serviceResponse;
	
	/**
	 * @description : Create and Update ItemKits
	 * @param request
	 * @param dtoAccountTypeSetUp
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveItemKits(HttpServletRequest request,
			@RequestBody DtoItemKits dtoItemKits) {

		ResponseMessage responseMessage = null;

		DtoItemKits dtoItemKitsRes = serviceItemKits.saveOrUpdateItemKits(dtoItemKits);

		if (dtoItemKitsRes.getIndex() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("ItemKit_CREATED", false), dtoItemKitsRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("ItemKit_NOT_CREATED", false),
					dtoItemKitsRes);

		}
		return responseMessage;
	}

	
	/**
	 * @description : Get all Item kits component
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/getcomponents", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getItemKitComponents(HttpServletRequest request, @RequestBody DtoItemKits dtoItemKits) {
		System.out.println("Controller");
		ResponseMessage responseMessage = null;
		DtoItemMaintenece itemKitListRes = serviceItemKits.getComponentByItemKitNumber(dtoItemKits);
		System.out.println("Controller"+itemKitListRes.getIv00104s2().size());
		if (itemKitListRes != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_GET_ALL", false), itemKitListRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_LIST_NOT_GETTING", false));
		}
		return responseMessage;

	}
	
	
	
	/**
	 * @description : Get all Item kits component
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/getItemkits", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getByItemKitNumber(HttpServletRequest request, @RequestBody DtoItemKits dtoItemKits) {
		System.out.println("Controller");
		ResponseMessage responseMessage = null;
		ItemMaintenance itemMaintenanceRes = serviceItemKits.getByItemKitNumber(dtoItemKits);
		if (itemMaintenanceRes != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_GET_ALL", false), itemMaintenanceRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteBinsSetup_LIST_NOT_GETTING", false));
		}
		return responseMessage;

	}
	
	
	
	
	/**
	 * @description : Delete ItemKits
	 * @param request
	 * @param dtoItemKits
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage delete(HttpServletRequest request,
			@RequestBody DtoItemKits dtoItemKits) {

		ResponseMessage responseMessage = null;

		DtoItemKits dtoItemKitsRes = serviceItemKits.delete(dtoItemKits);

		if (dtoItemKitsRes != null) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("BillOfMaterialSetUp_DELETED", false),
					dtoItemKitsRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("BillOfMaterialSetUp_NOT_DELETED", false));

		}
		return responseMessage;
	}

	
}
