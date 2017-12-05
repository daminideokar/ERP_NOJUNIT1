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
import com.bti.model.dto.DtoSearch;
import com.bti.service.ServiceAccountTypeSetUp;
import com.bti.service.ServiceAccountTypeSetUp;
import com.bti.service.ServiceResponse;

/**
 * Name of Project: BTI 
 * Description: Controller AccountTypeSetUp 
 * Created on:NOVEMBER 11,2017
 * Modified on:
 * 
 * @author goodtech
 */
@RestController
@RequestMapping("/accountTypeSetUp")
public class ControllerAccountTypeSetUp {

	@Autowired
	private ServiceAccountTypeSetUp serviceAccountTypeSetUp;

	@Autowired
	private ServiceResponse serviceResponse;

	/**
	 * @description : Create AccountTypeSetUp
	 * @param request
	 * @param dtoAccountTypeSetUp
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveAccountTypeSetUp(HttpServletRequest request,
			@RequestBody DtoAccountTypeSetUp dtoAccountTypeSetUp) {

		ResponseMessage responseMessage = null;

		DtoAccountTypeSetUp dtoAccountTypeSetUpRes = serviceAccountTypeSetUp
				.saveOrUpdateAccountTypeSetUp(dtoAccountTypeSetUp);

		if (dtoAccountTypeSetUpRes.getAccountTypeCode() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_CREATED", false), dtoAccountTypeSetUpRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false),
					dtoAccountTypeSetUpRes);

		}
		return responseMessage;
	}

	/**
	 * @description : Update AccountTypeSetUp
	 * @param request
	 * @param dtoAccountTypeSetUp
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseMessage updateAccountTypeSetUp(HttpServletRequest request,
			@RequestBody DtoAccountTypeSetUp dtoAccountTypeSetUp) {

		ResponseMessage responseMessage = null;

		DtoAccountTypeSetUp dtoAccountTypeSetUpRes = serviceAccountTypeSetUp
				.saveOrUpdateAccountTypeSetUp(dtoAccountTypeSetUp);

		if (dtoAccountTypeSetUpRes.getAccountTypeCode() != 0) {

			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_CREATED", false), dtoAccountTypeSetUpRes);
		} else {

			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("SiteSetUp_NOT_CREATED", false),
					dtoAccountTypeSetUpRes);

		}
		return responseMessage;
	}

	/**
	 * @description : GetAll AccountTypeSetUp
	 * @param request
	 * @param dtoAccountTypeSetUp
	 * @return
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.PUT, produces = "application/json")
	public ResponseMessage getAllAccountTypeSetUp(HttpServletRequest request,
			@RequestBody DtoAccountTypeSetUp dtoAccountTypeSetUp) {
		ResponseMessage responseMessage = null;

		DtoSearch dtoSearch = serviceAccountTypeSetUp.getAllAccountTypeSetUp(dtoAccountTypeSetUp);

		if (dtoSearch.getRecords() != null) {
			responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
					serviceResponse.getMessageByShortAndIsDeleted("COMPANY_GET_ALL", false), dtoSearch);
		} else {
			responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
					serviceResponse.getMessageByShortAndIsDeleted("COMPANY_LIST_NOT_GETTING", false));
		}

		return responseMessage;
	}

}
