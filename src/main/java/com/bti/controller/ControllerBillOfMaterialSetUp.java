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
import com.bti.model.dto.DtoBillOfMaterialSetUp;
import com.bti.service.ServiceBillOfMaterialSetUp;
import com.bti.service.ServiceResponse;

/**
 * Name of Project: BTI
 * Description: Controller BillOfMaterialSetup 
 * Created on:NOVEMBER 8,2017
 * Modified on:
 * 
 * @author goodtech
 */
@RestController
@RequestMapping("/billOfMaterial")
public class ControllerBillOfMaterialSetUp {

	@Autowired
	private ServiceBillOfMaterialSetUp serviceBillOfMaterialSetUp;

	@Autowired
	ServiceResponse serviceResponse;

	/**
	 * @description : Create BillOfMaterialSetUp
	 * @param request
	 * @param dtoBillOfMaterialSetUp
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveBillOfMaterialSetup(HttpServletRequest request,
			@RequestBody DtoBillOfMaterialSetUp dtoBillOfMaterialSetUp) {

		ResponseMessage responseMessage = null;

		DtoBillOfMaterialSetUp dtoBillOfMaterialMaintainanceRes = serviceBillOfMaterialSetUp
				.saveOrUpdateBillOfMaterialSetup(dtoBillOfMaterialSetUp);

		if (dtoBillOfMaterialMaintainanceRes.getId() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_CREATED", false),
					dtoBillOfMaterialMaintainanceRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false),
					dtoBillOfMaterialMaintainanceRes);

		}
		return responseMessage;
	}

	/**
	 * @description : Update BillOfMaterialSetUp
	 * @param request
	 * @param dtoBillOfMaterialSetUp
	 * @return
	 */

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage updateBillOfMateialSetup(HttpServletRequest request,
			@RequestBody DtoBillOfMaterialSetUp dtoBillOfMaterialSetUp) {

		ResponseMessage responseMessage = null;

		DtoBillOfMaterialSetUp dtoBillOfMaterialMaintainanceRes = serviceBillOfMaterialSetUp
				.saveOrUpdateBillOfMaterialSetup(dtoBillOfMaterialSetUp);

		if (dtoBillOfMaterialMaintainanceRes.getId() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_CREATED", false),
					dtoBillOfMaterialMaintainanceRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false),
					dtoBillOfMaterialMaintainanceRes);

		}
		return responseMessage;
	}

	/**
	 * @description : Get BillOfMaterialSetUP By NextDocumentNumber
	 * @param request
	 * @param dtoBillOfMaterialSetUp
	 * @return
	 */
	@RequestMapping(value = "/getByNextDocumentNumber", method = RequestMethod.POST, produces = "application/json")
	public ResponseMessage getBillOfMaterialSetUpByNextDocumentNumber(HttpServletRequest request,
			@RequestBody DtoBillOfMaterialSetUp dtoBillOfMaterialSetUp) {

		ResponseMessage responseMessage = null;

		DtoBillOfMaterialSetUp dtoBillOfMaterialMaintainanceRes = serviceBillOfMaterialSetUp
				.getBillOfMaterialByNextDocumentNumber(dtoBillOfMaterialSetUp);

		if (dtoBillOfMaterialMaintainanceRes != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("GET_SiteSetUp", false),
					dtoBillOfMaterialMaintainanceRes);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false),
					dtoBillOfMaterialMaintainanceRes);

		}

		return responseMessage;
	}

	/**
	 * @description : Delete BillOfMaterialSetUp
	 * @param request
	 * @param dtoBillOfMaterialSetUp
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage deleteBillOfMaterialSetup(HttpServletRequest request,
			@RequestBody DtoBillOfMaterialSetUp dtoBillOfMaterialSetUp) {

		ResponseMessage responseMessage = null;

		DtoBillOfMaterialSetUp dtoBillOfMaterialMaintainanceRes = serviceBillOfMaterialSetUp
				.deleteByNextDocumentNumber(dtoBillOfMaterialSetUp);

		if (dtoBillOfMaterialMaintainanceRes != null) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_CREATED", false),
					dtoBillOfMaterialMaintainanceRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false),
					dtoBillOfMaterialMaintainanceRes);

		}
		return responseMessage;
	}

}
