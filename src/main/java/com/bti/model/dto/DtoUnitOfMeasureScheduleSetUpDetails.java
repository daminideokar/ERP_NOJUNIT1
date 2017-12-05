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


import com.bti.model.InventoryUnitOfMeasureScheduleSetUpDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Description: The DTO class for Unit Of Measure Schedule SetUp Details Operations 
 * Name of Project: BTI
 * Created on:NOVEMBER 13,2017
 * Modified on: 
 * @author goodtech
 * Version: 
 */
@JsonInclude(Include.NON_EMPTY)
public class DtoUnitOfMeasureScheduleSetUpDetails extends InventoryUnitOfMeasureScheduleSetUpDetails{
	
	private Integer pageNumber;
	private Integer pageSize;
	private String unitOfMeasureId;
	
	
	
	/**
	 * @param pageNumber
	 * @param pageSize
	 * @param unitOfMeasureId
	 */
	public DtoUnitOfMeasureScheduleSetUpDetails(Integer pageNumber, Integer pageSize, String unitOfMeasureId) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.unitOfMeasureId = unitOfMeasureId;
	}



	/**
	 * 
	 */
	public DtoUnitOfMeasureScheduleSetUpDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	


	/**
	 * @return the pageNumber
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}
	
	
	
	

	/**
	 * @param index
	 * @param baseUnitOfMeasure
	 * @param equivalentUnitOfMeasure
	 * @param equivalentUnitOfMeasureQty
	 * @param moreDescriptionForUOfMInDetailLevel
	 * @param qtyInBaseUnitOfMeasure
	 * @param unitOfMeasureSequence
	 * @param status
	 * @param iv401001
	 * @param iv401002
	 */
	public DtoUnitOfMeasureScheduleSetUpDetails(InventoryUnitOfMeasureScheduleSetUpDetails inventoryUnitOfMeasureScheduleSetUpDetails ) {
		super(inventoryUnitOfMeasureScheduleSetUpDetails.getIndex(),inventoryUnitOfMeasureScheduleSetUpDetails.getBaseUnitOfMeasure(),inventoryUnitOfMeasureScheduleSetUpDetails.getEquivalentUnitOfMeasure(),inventoryUnitOfMeasureScheduleSetUpDetails.getEquivalentUnitOfMeasureQty(),inventoryUnitOfMeasureScheduleSetUpDetails.getMoreDescriptionForUOfMInDetailLevel(),inventoryUnitOfMeasureScheduleSetUpDetails.getQtyInBaseUnitOfMeasure(),inventoryUnitOfMeasureScheduleSetUpDetails.getUnitOfMeasureSequence(),inventoryUnitOfMeasureScheduleSetUpDetails.getStatus(),inventoryUnitOfMeasureScheduleSetUpDetails.getIv401001());
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param pageNumber the pageNumber to set
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
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	/**
	 * @return the unitOfMeasureId
	 */
	public String getUnitOfMeasureId() {
		return unitOfMeasureId;
	}



	/**
	 * @param unitOfMeasureId the unitOfMeasureId to set
	 */
	public void setUnitOfMeasureId(String unitOfMeasureId) {
		this.unitOfMeasureId = unitOfMeasureId;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pageNumber == null) ? 0 : pageNumber.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((unitOfMeasureId == null) ? 0 : unitOfMeasureId.hashCode());
		return result;
	}



	/* (non-Javadoc)
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
		DtoUnitOfMeasureScheduleSetUpDetails other = (DtoUnitOfMeasureScheduleSetUpDetails) obj;
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
		if (unitOfMeasureId == null) {
			if (other.unitOfMeasureId != null)
				return false;
		} else if (!unitOfMeasureId.equals(other.unitOfMeasureId))
			return false;
		return true;
	}



	
	

}
