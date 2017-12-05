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

import java.util.List;

import com.bti.model.FinancialDimensionsTable;
import com.bti.model.InventoryControlSetUp;

/**
 * Description: class for the Dto Financial Dimensions Table
 * Name of Project:BTI 
 * Created on: NOVEMBER 16, 2017
 * Modified on:
 * @author GoodTech
 * Version:
 */
public class DtoFinancialDimensionsTable extends FinancialDimensionsTable {

	private Integer pageNumber;
	private Integer pageSize;
	private String deleteMessage;

	public DtoFinancialDimensionsTable() {

	}

	/**
	 * @param pageNumber
	 * @param pageSize
	 * @param deleteMessage
	 */
	public DtoFinancialDimensionsTable(Integer pageNumber, Integer pageSize, String deleteMessage) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.deleteMessage = deleteMessage;
	}

	/**
	 * @param dimensionIndex
	 * @param modifyByUserId
	 * @param dimensionDescription
	 * @param dimensionDescriptionArabic
	 * @param iv40000s
	 */
	public DtoFinancialDimensionsTable(int dimensionIndex, String modifyByUserId, String dimensionDescription,
			String dimensionDescriptionArabic, List<InventoryControlSetUp> iv40000s) {
		super(dimensionIndex, modifyByUserId, dimensionDescription, dimensionDescriptionArabic, iv40000s);
		
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
	 * @return the deleteMessage
	 */
	public String getDeleteMessage() {
		return deleteMessage;
	}

	/**
	 * @param deleteMessage
	 *            the deleteMessage to set
	 */
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
		int result = super.hashCode();
		result = prime * result + ((deleteMessage == null) ? 0 : deleteMessage.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoFinancialDimensionsTable other = (DtoFinancialDimensionsTable) obj;
		if (deleteMessage == null) {
			if (other.deleteMessage != null)
				return false;
		} else if (!deleteMessage.equals(other.deleteMessage))
			return false;
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
