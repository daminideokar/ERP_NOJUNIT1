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
package com.bti.model.dto;

import com.bti.constant.ConfigSetting;
import com.bti.model.BtiMessage;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Name of Project: BTI 
 * Description: The DTO class for Search Operations
 * Created on: NOVEMBER 1, 2017
 * Modified on:
 * @author goodtech
 * version :
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoBtiMessage {
	private String messagePrimary;
	private String messageSecondary;
	private String message;
	private String messageShort;

	
	
	/**
	 * 
	 */
	public DtoBtiMessage() {
		super();
	}

	public DtoBtiMessage(BtiMessage btiMessage, String langId) {
		if (btiMessage != null) {
			this.setMessageShort(btiMessage.getMessageShort());
			if (ConfigSetting.PRIMARY.equalsIgnoreCase(langId)) {
				this.message = btiMessage.getMessagePrimary();
			} else if (ConfigSetting.SECONDARY.equalsIgnoreCase(langId)) {
				this.message = btiMessage.getMessageSecondary();
			}
		} else {
			this.setMessageShort("N/A");
			this.message = "N/A";
		}
	}

	public String getMessagePrimary() {
		return messagePrimary;
	}

	public void setMessagePrimary(String messagePrimary) {
		this.messagePrimary = messagePrimary;
	}

	public String getMessageSecondary() {
		return messageSecondary;
	}

	public void setMessageSecondary(String messageSecondary) {
		this.messageSecondary = messageSecondary;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageShort() {
		return messageShort;
	}

	public void setMessageShort(String messageShort) {
		this.messageShort = messageShort;
	}

}
