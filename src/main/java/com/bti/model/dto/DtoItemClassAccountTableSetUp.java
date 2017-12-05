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

import com.bti.model.ItemClassAccountTableSetUp;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Description: class for the Dto Item Class Account Table SetUp
 * Name of Project: BTI 
 * Created on: NOVEMBER 12, 2017 
 * Modified on:
 * @author GoodTech
 * Version:
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoItemClassAccountTableSetUp extends ItemClassAccountTableSetUp {

	private String itemClassId;

	public DtoItemClassAccountTableSetUp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param itemClassId
	 */
	public DtoItemClassAccountTableSetUp(String itemClassId) {
		super();
		this.itemClassId = itemClassId;
	}

	public DtoItemClassAccountTableSetUp(ItemClassAccountTableSetUp itemClassAccountTableSetup) {
		super(itemClassAccountTableSetup.getItemClassAccountTableSetupIndex(), itemClassAccountTableSetup.getModifyByUserId(),
				itemClassAccountTableSetup.getStatus(), itemClassAccountTableSetup.getIv40400());
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((itemClassId == null) ? 0 : itemClassId.hashCode());
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
		DtoItemClassAccountTableSetUp other = (DtoItemClassAccountTableSetUp) obj;
		if (itemClassId == null) {
			if (other.itemClassId != null)
				return false;
		} else if (!itemClassId.equals(other.itemClassId))
			return false;
		return true;
	}

}
