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
package com.bti.config;

import com.bti.model.dto.DtoBtiMessage;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Name of Project: BTI 
 * Description: Service ServiceStockCalenderExceptionImpl
 * Created on: NOVEMBER 1, 2017
 * Modified on:
 * @author goodtech
 * version :
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessage {

	private int code;
	private org.springframework.http.HttpStatus status;
	private String message;
	private Object result;
	private Object btiMessage;

	public ResponseMessage() {
	}

	/**
	 * @param code
	 * @param status
	 * @param message
	 */
	public ResponseMessage(int code, org.springframework.http.HttpStatus status, String message) {
		this.code = code;
		this.status = status;
		this.message = message;
	}

	/**
	 * @param code
	 * @param status
	 * @param message
	 */
	public ResponseMessage(int code, org.springframework.http.HttpStatus status, DtoBtiMessage message) {
		this.code = code;
		this.status = status;
		this.btiMessage = message;
	}

	/**
	 * @param code
	 * @param status
	 * @param message
	 * @param result
	 */
	public ResponseMessage(int code, org.springframework.http.HttpStatus status, DtoBtiMessage message, Object result) {
		this.code = code;
		this.status = status;
		this.btiMessage = message;
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public org.springframework.http.HttpStatus getStatus() {
		return status;
	}

	public void setStatus(org.springframework.http.HttpStatus status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Object getBtiMessage() {
		return btiMessage;
	}

	public void setBtiMessage(Object btiMessage) {
		this.btiMessage = btiMessage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((btiMessage == null) ? 0 : btiMessage.hashCode());
		result = prime * result + code;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseMessage other = (ResponseMessage) obj;
		if (btiMessage == null) {
			if (other.btiMessage != null)
				return false;
		} else if (!btiMessage.equals(other.btiMessage))
			return false;
		if (code != other.code)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	

}

