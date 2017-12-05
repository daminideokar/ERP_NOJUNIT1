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

import com.bti.model.AccountTypeSetUp;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Name of Project: BTI 
 * Description: Dto AccountTypeSetUp 
 * Created on: NOVEMBER 11,2017
 * Modified on:
 * 
 * @author goodtech
 */
@JsonInclude(Include.NON_EMPTY)
public class DtoAccountTypeSetUp extends AccountTypeSetUp {

	private Integer pageNumber;
	private Integer pageSize;

	/**
	 * @param pageNumber
	 * @param pageSize
	 */

	public DtoAccountTypeSetUp(Integer pageNumber, Integer pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	/**
	 * 
	 */
	public DtoAccountTypeSetUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param accountTypeCode
	 * @param accountType
	 * @param status
	 */
	public DtoAccountTypeSetUp(AccountTypeSetUp accountTypeSetUp) {
		super(accountTypeSetUp.getAccountTypeCode(), accountTypeSetUp.getAccountType(),
				accountTypeSetUp.getStatus());
		// TODO Auto-generated constructor stub
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
		DtoAccountTypeSetUp other = (DtoAccountTypeSetUp) obj;
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
