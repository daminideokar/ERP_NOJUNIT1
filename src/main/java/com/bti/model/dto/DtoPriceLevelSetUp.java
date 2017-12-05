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
package com.bti.model.dto;


import com.bti.model.PriceLevelSetUp;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Description: class for Dto Price Level SetUp 
 * Name of Project: BTI
 * Created on: NOVEMBER 07, 2017 
 * Modified on:
 * @author GoodTech Version:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoPriceLevelSetUp extends PriceLevelSetUp {

	private Integer pageNumber;
	private Integer pageSize;
	private String deleteMessage;
	private String associateMessage;

	public DtoPriceLevelSetUp() {
		super();
	}

	/**
	 * @param priceLevelDescription
	 * @param priceLevelDescriptionArabic
	 * @param priceLevelId
	 */

	public DtoPriceLevelSetUp(PriceLevelSetUp priceLevelSetup) {
		super(priceLevelSetup.getPriceLevelIndex(), priceLevelSetup.getPriceLevelDescription(),
				priceLevelSetup.getPriceLevelDescriptionArabic(), priceLevelSetup.getPriceLevelId(),
				priceLevelSetup.getStatus());
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pageNumber
	 * @param pageSize
	 */
	public DtoPriceLevelSetUp(Integer pageNumber, Integer pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 *            the pageNumber to set
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @param pageNumber
	 * @param pageSize
	 * @param deleteMessage
	 * @param associateMessage
	 */
	public DtoPriceLevelSetUp(Integer pageNumber, Integer pageSize, String deleteMessage, String associateMessage) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.deleteMessage = deleteMessage;
		this.associateMessage = associateMessage;
	}

	/**
	 * @return the deleteMessage
	 */
	public String getDeleteMessage() {
		return deleteMessage;
	}

	/**
	 * @param deleteMessage the deleteMessage to set
	 */
	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}

	/**
	 * @return the associateMessage
	 */
	public String getAssociateMessage() {
		return associateMessage;
	}

	/**
	 * @param associateMessage the associateMessage to set
	 */
	public void setAssociateMessage(String associateMessage) {
		this.associateMessage = associateMessage;
	}

}
