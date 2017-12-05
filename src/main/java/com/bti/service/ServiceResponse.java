/**
 * BTI - BAAN for Technology And Trade IntL. 
 * Copyright � 2017 BTI. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF BTI. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF BTI.
 */
package com.bti.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bti.constant.ConfigSetting;
import com.bti.model.BtiMessage;
import com.bti.model.dto.DtoBtiMessage;
import com.bti.repository.RepositoryException;

/**
 * Description: Service Response
 * Name of Project: BTI
 * Created on: NOVEMBER 1, 2017
 * Modified on: 
 * @author goodtech
 * Version: 
 */

@Service("ServiceResponse")
public class ServiceResponse {

	static Logger log = Logger.getLogger(ServiceResponse.class.getName());

	@Autowired
	RepositoryException repositoryException;

	@Autowired(required = false)
	HttpServletRequest httpServletRequest;

	/**
	 * @param message
	 * @param b
	 * @return
	 */
	public DtoBtiMessage getMessageByShortAndIsDeleted(String message, boolean b) {
		String langId = httpServletRequest.getHeader("langId");
		BtiMessage exceptionMessage = repositoryException.findByMessageShortAndIsDeleted(message, false);
		return new DtoBtiMessage(exceptionMessage, langId);
	}

	/**
	 * @param message
	 * @param b
	 * @return
	 */
	public String getStringMessageByShortAndIsDeleted(String message, boolean b) {
		String responseMessage = "";
		String langId = httpServletRequest.getHeader("langId");
		BtiMessage exceptionMessage = repositoryException.findByMessageShortAndIsDeleted(message, false);
		if (ConfigSetting.PRIMARY.equalsIgnoreCase(langId)) {
			responseMessage = exceptionMessage.getMessagePrimary();
		} else if (ConfigSetting.SECONDARY.equalsIgnoreCase(langId)) {
			responseMessage = exceptionMessage.getMessageSecondary();
		}

		return responseMessage;
	}

}
