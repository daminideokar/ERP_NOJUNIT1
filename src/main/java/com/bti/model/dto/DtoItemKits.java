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

import java.math.BigDecimal;

import com.bti.model.ItemKits;
import com.bti.model.ItemMaintenance;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * Name of Project: BTI 
 * Description: Dto ItemKitSetUp 
 * Created on: NOVEMBER 24,2017
 * Modified on:
 * 
 * @author goodtech
 */
@JsonInclude(Include.NON_EMPTY)
public class DtoItemKits extends ItemKits {

	private Integer pageNumber;
	private Integer pageSize;
	private String  itemNumberComponent;
	private String  itemKitNumber;
	private BigDecimal componentItemQuantity;
	private String itemDescription;
	private String unitOfMeasure;
	private BigDecimal currentCost;
	
	/**
	 * 
	 */
	public DtoItemKits() {
		super();
	}
	
	
	
	
	



	/**
	 * @param pageNumber
	 * @param pageSize
	 * @param itemNumberComponent
	 * @param itemKitNumber
	 * @param componentItemQuantity
	 * @param itemDescription
	 * @param unitOfMeasure
	 * @param currentCost
	 *//*
	public DtoItemKits(Integer pageNumber, Integer pageSize, String itemNumberComponent, String itemKitNumber,
			BigDecimal componentItemQuantity, String itemDescription, String unitOfMeasure, BigDecimal currentCost) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.itemNumberComponent = itemNumberComponent;
		this.itemKitNumber = itemKitNumber;
		this.componentItemQuantity = componentItemQuantity;
		this.itemDescription = itemDescription;
		this.unitOfMeasure = unitOfMeasure;
		this.currentCost = currentCost;
	}


*/
/*
	*//**
	 * @param index
	 * @param componentItemQuantity
	 * @param itemKitUnitMeasure
	 * @param iv001011
	 * @param status
	 *//*
	public DtoItemKits(ItemKits itemKits) {
		super(itemKits.getIndex(), itemKits.getComponentItemQuantity(), itemKits.getItemKitUnitMeasure(), itemKits.getIv001011(), itemKits.getStatus());
	}
*/



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
	public String getItemNumberComponent() {
		return itemNumberComponent;
	}
	public void setItemNumberComponent(String itemNumberComponent) {
		this.itemNumberComponent = itemNumberComponent;
	}
	public String getItemKitNumber() {
		return itemKitNumber;
	}
	public void setItemKitNumber(String itemKitNumber) {
		this.itemKitNumber = itemKitNumber;
	}
	
	
	
	public BigDecimal getComponentItemQuantity() {
		return componentItemQuantity;
	}




	public void setComponentItemQuantity(BigDecimal componentItemQuantity) {
		this.componentItemQuantity = componentItemQuantity;
	}




	public String getItemDescription() {
		return itemDescription;
	}




	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}




	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}




	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}




	public BigDecimal getCurrentCost() {
		return currentCost;
	}




	public void setCurrentCost(BigDecimal currentCost) {
		this.currentCost = currentCost;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((componentItemQuantity == null) ? 0 : componentItemQuantity.hashCode());
		result = prime * result + ((currentCost == null) ? 0 : currentCost.hashCode());
		result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
		result = prime * result + ((itemKitNumber == null) ? 0 : itemKitNumber.hashCode());
		result = prime * result + ((itemNumberComponent == null) ? 0 : itemNumberComponent.hashCode());
		result = prime * result + ((pageNumber == null) ? 0 : pageNumber.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((unitOfMeasure == null) ? 0 : unitOfMeasure.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoItemKits other = (DtoItemKits) obj;
		if (componentItemQuantity == null) {
			if (other.componentItemQuantity != null)
				return false;
		} else if (!componentItemQuantity.equals(other.componentItemQuantity))
			return false;
		if (currentCost == null) {
			if (other.currentCost != null)
				return false;
		} else if (!currentCost.equals(other.currentCost))
			return false;
		if (itemDescription == null) {
			if (other.itemDescription != null)
				return false;
		} else if (!itemDescription.equals(other.itemDescription))
			return false;
		if (itemKitNumber == null) {
			if (other.itemKitNumber != null)
				return false;
		} else if (!itemKitNumber.equals(other.itemKitNumber))
			return false;
		if (itemNumberComponent == null) {
			if (other.itemNumberComponent != null)
				return false;
		} else if (!itemNumberComponent.equals(other.itemNumberComponent))
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
		if (unitOfMeasure == null) {
			if (other.unitOfMeasure != null)
				return false;
		} else if (!unitOfMeasure.equals(other.unitOfMeasure))
			return false;
		return true;
	}




	
	
}
