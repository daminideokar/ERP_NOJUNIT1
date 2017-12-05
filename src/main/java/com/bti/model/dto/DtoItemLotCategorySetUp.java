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

import com.bti.model.ItemLotCategorySetUp;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Description: class for Dto Item Lot Category SetUp
 * Name of Project: BTI
 * Created on: NOVEMBER 08, 2017 
 * Modified on:
 * @author GoodTech Version:
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoItemLotCategorySetUp extends ItemLotCategorySetUp {

	private static final long serialVersionUID = 1L;
	private Integer pageNumber;
	private Integer pageSize;
	private String deleteMessage;

	public DtoItemLotCategorySetUp() {
		super();
	}

	public DtoItemLotCategorySetUp(Integer pageNumber, Integer pageSize, String deleteMessage) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.deleteMessage = deleteMessage;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @param lotItemCategoryIndex
	 * @param lotAttribute1
	 * @param lotAttribute2
	 * @param lotAttribute3
	 * @param lotAttribute4
	 * @param lotAttribute5
	 * @param lotItemCategoryId
	 * @param status
	 */

	public DtoItemLotCategorySetUp(int lotItemCategoryIndex, String lotAttribute1, String lotAttribute2,
			String lotAttribute3, String lotAttribute4, String lotAttribute5, String lotItemCategoryId,
			boolean status) {
		super(lotItemCategoryIndex, lotAttribute1, lotAttribute2, lotAttribute3, lotAttribute4, lotAttribute5,
				lotItemCategoryId, status);
		}

	public DtoItemLotCategorySetUp(ItemLotCategorySetUp itemLotCategorySetup) {
		super(itemLotCategorySetup.getLotItemCategoryIndex(), itemLotCategorySetup.getLotAttribute1(),
				itemLotCategorySetup.getLotAttribute2(), itemLotCategorySetup.getLotAttribute3(),
				itemLotCategorySetup.getLotAttribute4(), itemLotCategorySetup.getLotAttribute5(),
				itemLotCategorySetup.getLotItemCategoryId(), itemLotCategorySetup.getStatus());
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
