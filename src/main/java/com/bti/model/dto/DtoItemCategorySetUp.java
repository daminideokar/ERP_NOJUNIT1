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

import com.bti.model.ItemCategorySetUp;
import com.bti.model.StockCalendarExceptionDaysSetUp;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Name of Project: BTI Description: DTO DtoItemCategorySetup class having
 * getter and setter for fields (POJO) Name 
 * Created on: NOVEMBER 8, 2017
 * Modified on:
 * @author goodtech 
 * version :
 */
@JsonInclude(Include.NON_EMPTY)
public class DtoItemCategorySetUp extends ItemCategorySetUp {

	private Integer pageNumber;
	private Integer pageSize;
	private String deleteMessage;

	public DtoItemCategorySetUp() {

	}

	public DtoItemCategorySetUp(ItemCategorySetUp itemCategorySetup) {
		super(itemCategorySetup.getItemCategoryIndex(), itemCategorySetup.getItemCategory(),
				itemCategorySetup.getItemCategoryValueDescription(),
				itemCategorySetup.getItemCategoryValueDescriptionArabic(), itemCategorySetup.getStatus(),
				itemCategorySetup.getItemCategoryValue());
	}

	public DtoItemCategorySetUp(Integer pageNumber, Integer pageSize, String deleteMessage) {
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

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getDeleteMessage() {
		return deleteMessage;
	}

	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pageNumber == null) ? 0 : pageNumber.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		DtoItemCategorySetUp other = (DtoItemCategorySetUp) obj;
		if (pageNumber == null) {
			if (other.pageNumber != null)
				return false;
		} else if (!pageNumber.equals(other.pageNumber))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		return true;
	}

}
