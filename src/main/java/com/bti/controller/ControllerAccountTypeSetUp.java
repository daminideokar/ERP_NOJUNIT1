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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bti.config.ResponseMessage;
import com.bti.model.PriceGroupSetUp;
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
	
	private RestTemplate restTemplate;
	
	

	public ControllerAccountTypeSetUp() {
		super();
	this.restTemplate=new RestTemplate();
	}

	/**
	 * @description : Create AccountTypeSetUp
	 * @param request
	 * @param dtoAccountTypeSetUp
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
	public ResponseMessage saveAccountTypeSetUp(HttpServletRequest request,
			@RequestBody DtoAccountTypeSetUp dtoAccountTypeSetUp) {
//RESTTEMPLATE code
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
	 *//*
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
*/
	//get data from another application by ResponseEntity
	
/*	*//**
	 * @description : GetAll AccountTypeSetUp
	 * @param request
	 * @param dtoAccountTypeSetUp
	 * @return
	 *//*
	@RequestMapping(value = "/getall/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<PriceGroupSetUp> getAllAccountTypeSetUp(@PathVariable("id") String id) {
		
		String getUrl="http://localhost:8083/priceGroupSetup/getByPriceGroupId/"+id;
		System.out.println("url=:"+getUrl);

		ResponseEntity<PriceGroupSetUp> getRes=restTemplate.getForEntity(getUrl,PriceGroupSetUp.class);
		
		System.out.println("myResponse"+getRes.getBody().getPriceGroupId());

		if (getRes.getBody() != null) {
			System.out.println("GET"+getRes.getBody().getPriceGroupIndex());
			return new ResponseEntity<PriceGroupSetUp>(getRes.getBody(), HttpStatus.CREATED);
		} else {
			System.out.println("SORRYY.............");
			return new ResponseEntity<PriceGroupSetUp>(getRes.getBody(), HttpStatus.BAD_REQUEST);
		}

		
	}*/

	
	
	
	//get data from another application by ResponseEntity
	
	/**
	 * @description : GetAll AccountTypeSetUp
	 * @param request
	 * @param dtoAccountTypeSetUp
	 * @return
	 */
		@RequestMapping(value = "/getall/{id}", method = RequestMethod.GET, produces = "application/json")
		public ResponseMessage getAllAccountTypeSetUp(@PathVariable("id") String id) {
			ResponseMessage responseMessage = null;
			String getUrl="http://localhost:8083/priceGroupSetup/getByPriceGroupId/"+id;
			System.out.println("url=:"+getUrl);

			ResponseEntity<PriceGroupSetUp> getRes=restTemplate.getForEntity(getUrl,PriceGroupSetUp.class);
			
			System.out.println("myResponse"+getRes.getBody().getPriceGroupId());

			if (getRes.getBody() != null) {
				System.out.println("GET"+getRes.getBody().getPriceGroupIndex());
				responseMessage = new ResponseMessage(HttpStatus.CREATED.value(), HttpStatus.CREATED,
						serviceResponse.getMessageByShortAndIsDeleted("COMPANY_GET_ALL", false), getRes.getBody());
			} else {
				System.out.println("SORRYY.............");
				responseMessage = new ResponseMessage(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
						serviceResponse.getMessageByShortAndIsDeleted("COMPANY_LIST_NOT_GETTING", false));
			}

			return responseMessage;
			
		}

	
	
	
	
	
	
}
