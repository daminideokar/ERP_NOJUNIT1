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

import com.bti.model.InventoryClassSetUpCurrency;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Description: class for the Dto Inventory Class Setup Currency
 * Name of Project: BTI 
 * Created on: NOVEMBER 12, 2017
 * Modified on: 
 * @author GoodTech Version:
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoInventoryClassSetupCurrency extends InventoryClassSetUpCurrency {

	private String itemClassId;
	private String currencyId;
	private Integer pageNumber;
	private Integer pageSize;

	public DtoInventoryClassSetupCurrency() {

	}

	/**
	 * @param itemClassId
	 * @param currencyId
	 * @param pageNumber
	 * @param pageSize
	 */
	public DtoInventoryClassSetupCurrency(String itemClassId, String currencyId, Integer pageNumber, Integer pageSize) {
		super();
		this.itemClassId = itemClassId;
		this.currencyId = currencyId;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public DtoInventoryClassSetupCurrency(InventoryClassSetUpCurrency inventoryClassSetupCurrency) {
		super(inventoryClassSetupCurrency.getInventoryClassSetUpCurrencyIndex(),
				inventoryClassSetupCurrency.getModifyByUserID(), inventoryClassSetupCurrency.getCurrencyId(),
				inventoryClassSetupCurrency.getStatus(), inventoryClassSetupCurrency.getIv40400(),
				inventoryClassSetupCurrency.getMc40200());
	}

	/**
	 * @return the itemClassId
	 */
	public String getItemClassId() {
		return itemClassId;
	}

	/**
	 * @param itemClassId
	 *            the itemClassId to set
	 */
	public void setItemClassId(String itemClassId) {
		this.itemClassId = itemClassId;
	}

	/**
	 * @return the currencyId
	 */
	public String getCurrencyId() {
		return currencyId;
	}

	/**
	 * @param currencyId
	 *            the currencyId to set
	 */
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((currencyId == null) ? 0 : currencyId.hashCode());
		result = prime * result + ((itemClassId == null) ? 0 : itemClassId.hashCode());
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
		DtoInventoryClassSetupCurrency other = (DtoInventoryClassSetupCurrency) obj;
		if (currencyId == null) {
			if (other.currencyId != null)
				return false;
		} else if (!currencyId.equals(other.currencyId))
			return false;
		if (itemClassId == null) {
			if (other.itemClassId != null)
				return false;
		} else if (!itemClassId.equals(other.itemClassId))
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
