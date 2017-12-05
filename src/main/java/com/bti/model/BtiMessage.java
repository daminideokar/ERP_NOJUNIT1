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
package com.bti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Name of Project: BTI 
 * Description: The persistent class for the bti_message database table.
 * Created on: NOVEMBER 1, 2017
 * Modified on:
 * @author goodtech
 * version :
 */
@Entity @org.hibernate.annotations.Entity(dynamicInsert = true)
@Table(name="bti_message")
@NamedQuery(name="BtiMessage.findAll", query="SELECT b FROM BtiMessage b")
public class BtiMessage extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bti_message_id")
	private int btiMessageId;

	@Column(name="message_primary")
	private String messagePrimary;
	
	@Column(name="message_secondary")
	private String messageSecondary;

	@Column(name="message_short")
	private String messageShort;

	public BtiMessage() {
	}

	public int getBtiMessageId() {
		return this.btiMessageId;
	}

	public void setBtiMessageId(int btiMessageId) {
		this.btiMessageId = btiMessageId;
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

	public String getMessageShort() {
		return this.messageShort;
	}

	public void setMessageShort(String messageShort) {
		this.messageShort = messageShort;
	}


}