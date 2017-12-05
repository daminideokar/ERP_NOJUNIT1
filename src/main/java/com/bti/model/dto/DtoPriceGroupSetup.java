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



import com.bti.model.PriceGroupSetUp;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Description: The DTO class for PriceGroup Operations 
 * Name of Project: BTI
 * Created on:NOVEMBER 6,2017
 * Modified on: 
 * @author goodtech
 * Version: 
 */

@JsonInclude(Include.NON_EMPTY)
public class DtoPriceGroupSetup extends PriceGroupSetUp {

	private Integer pageNumber;
	private Integer pageSize;

	/**
	 * 
	 */
	public DtoPriceGroupSetup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param priceGroupDescriptionArabic
	 * @param priceGroupDescription
	 * @param priceGroupId
	 */
	public DtoPriceGroupSetup(PriceGroupSetUp priceGroupSetUp) {
		super(priceGroupSetUp.getPriceGroupIndex(), priceGroupSetUp.getPriceGroupDescriptionArabic(),
				priceGroupSetUp.getPriceGroupDescription(), priceGroupSetUp.getPriceGroupId());
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		DtoPriceGroupSetup other = (DtoPriceGroupSetup) obj;
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
