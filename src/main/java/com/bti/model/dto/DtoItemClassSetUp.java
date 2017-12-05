package com.bti.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import com.bti.model.InventoryClassSetUpCurrency;
import com.bti.model.InventoryUnitOfMeasureScheduleSetUp;
import com.bti.model.ItemClassAccountTableSetUp;
import com.bti.model.ItemClassSetUp;
import com.bti.model.ItemLotCategorySetUp;
import com.bti.model.PriceGroupSetUp;
import com.bti.model.PriceLevelSetUp;
import com.bti.model.VatSetUp;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Name of Project: BTI
 *  Description: DTO DtoItemClassSetup class having getter and setter for fields (POJO) Name 
 *  Created on: NOVEMBER 10, 2017 
 *  Modified on:
 * 
 * @author goodtech version :
 */
@JsonInclude(Include.NON_EMPTY)
public class DtoItemClassSetUp extends ItemClassSetUp {

	private Integer pageNumber;
	private Integer pageSize;
	private String deleteMessage;
	private String lotItemCategoryId;
	private String unitOfMeasureId;
	private String priceLevelId;
	private String priceGroupId;
	private String salesId;
	private String purchaseId;

	public DtoItemClassSetUp() {

	}

	/**
	 * @param pageNumber
	 * @param pageSize
	 * @param deleteMessage
	 * @param lotItemCategoryId
	 * @param unitOfMeasureId
	 * @param priceLevelId
	 * @param priceGroupId
	 * @param salesId
	 * @param purchaseId
	 */
	public DtoItemClassSetUp(Integer pageNumber, Integer pageSize, String deleteMessage, String lotItemCategoryId,
			String unitOfMeasureId, String priceLevelId, String priceGroupId, String salesId, String purchaseId) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.deleteMessage = deleteMessage;
		this.lotItemCategoryId = lotItemCategoryId;
		this.unitOfMeasureId = unitOfMeasureId;
		this.priceLevelId = priceLevelId;
		this.priceGroupId = priceGroupId;
		this.salesId = salesId;
		this.purchaseId = purchaseId;
	}

	

	public DtoItemClassSetUp(ItemClassSetUp itemClassSetUp) {
		super(itemClassSetUp.getItemClassIndex(),itemClassSetUp.getAccountTableRowIndex(), itemClassSetUp.getAllowBackOrders(),
				itemClassSetUp.getModifyByUserId(), itemClassSetUp.getCreateDate(), itemClassSetUp.getRowIdIndexing(),
				itemClassSetUp.getRowDateIndexing(), itemClassSetUp.getItemClassDescription(),
				itemClassSetUp.getItemClassDescriptionArabic(), itemClassSetUp.getItemClassId(),
				itemClassSetUp.getItemGenericDescription(), itemClassSetUp.getItemGenericDescriptionArabic(),
				itemClassSetUp.getItemType(), itemClassSetUp.getModifyDate(), itemClassSetUp.getWarningNumberOfDays(),
				itemClassSetUp.getPriceMethod(), itemClassSetUp.getQuantityDecimals(),
				itemClassSetUp.getRevalueInventoryForCostVariance(), itemClassSetUp.getTolerancePercentage(),
				itemClassSetUp.getTrack(), itemClassSetUp.getUserCategoryName1(), itemClassSetUp.getUserCategoryName2(),
				itemClassSetUp.getUserCategoryName3(), itemClassSetUp.getUserCategoryName4(),
				itemClassSetUp.getUserCategoryName5(), itemClassSetUp.getUserCategoryName6(),
				itemClassSetUp.getValuationMethod(),
				itemClassSetUp.getWarningFeature(), itemClassSetUp.getStatus(), itemClassSetUp.getIv40001(),
				itemClassSetUp.getIv40100(), itemClassSetUp.getIv40300(), itemClassSetUp.getIv40301(),
				itemClassSetUp.getIv40401s(), itemClassSetUp.getIv40402s());

	}

	/**
	 * @param itemClassIndex
	 * @param itemClassDescription
	 * @param itemClassDescriptionArabic
	 * @param itemClassId
	 * @param iv40100
	 *//*
		 * public DtoItemClassSetup(ItemClassSetUp itemClassSetup) {
		 * super(itemClassSetup.getItemClassIndex(),
		 * itemClassSetup.getItemClassDescription(),
		 * itemClassSetup.getItemClassDescriptionArabic(),
		 * itemClassSetup.getItemClassId(),itemClassSetup.getIv40100()); // TODO
		 * Auto-generated constructor stub }
		 */

	/**
	 * @return the lotItemCategoryId
	 */
	public String getLotItemCategoryId() {
		return lotItemCategoryId;
	}

	/**
	 * @return the salesId
	 */
	public String getSalesId() {
		return salesId;
	}

	/**
	 * @param salesId
	 *            the salesId to set
	 */
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}

	/**
	 * @return the purchaseId
	 */
	public String getPurchaseId() {
		return purchaseId;
	}

	/**
	 * @param purchaseId
	 *            the purchaseId to set
	 */
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	/**
	 * @param lotItemCategoryId
	 *            the lotItemCategoryId to set
	 */
	public void setLotItemCategoryId(String lotItemCategoryId) {
		this.lotItemCategoryId = lotItemCategoryId;
	}

	/**
	 * @return the unitOfMeasureId
	 */
	public String getUnitOfMeasureId() {
		return unitOfMeasureId;
	}

	/**
	 * @param unitOfMeasureId
	 *            the unitOfMeasureId to set
	 */
	public void setUnitOfMeasureId(String unitOfMeasureId) {
		this.unitOfMeasureId = unitOfMeasureId;
	}

	/**
	 * @return the priceLevelId
	 */
	public String getPriceLevelId() {
		return priceLevelId;
	}

	/**
	 * @param priceLevelId
	 *            the priceLevelId to set
	 */
	public void setPriceLevelId(String priceLevelId) {
		this.priceLevelId = priceLevelId;
	}

	/**
	 * @return the priceGroupId
	 */
	public String getPriceGroupId() {
		return priceGroupId;
	}

	/**
	 * @param priceGroupId
	 *            the priceGroupId to set
	 */
	public void setPriceGroupId(String priceGroupId) {
		this.priceGroupId = priceGroupId;
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
		result = prime * result + ((lotItemCategoryId == null) ? 0 : lotItemCategoryId.hashCode());
		result = prime * result + ((pageNumber == null) ? 0 : pageNumber.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((priceGroupId == null) ? 0 : priceGroupId.hashCode());
		result = prime * result + ((priceLevelId == null) ? 0 : priceLevelId.hashCode());
		result = prime * result + ((unitOfMeasureId == null) ? 0 : unitOfMeasureId.hashCode());
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
		DtoItemClassSetUp other = (DtoItemClassSetUp) obj;
		if (deleteMessage == null) {
			if (other.deleteMessage != null)
				return false;
		} else if (!deleteMessage.equals(other.deleteMessage))
			return false;
		if (lotItemCategoryId == null) {
			if (other.lotItemCategoryId != null)
				return false;
		} else if (!lotItemCategoryId.equals(other.lotItemCategoryId))
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
		if (priceGroupId == null) {
			if (other.priceGroupId != null)
				return false;
		} else if (!priceGroupId.equals(other.priceGroupId))
			return false;
		if (priceLevelId == null) {
			if (other.priceLevelId != null)
				return false;
		} else if (!priceLevelId.equals(other.priceLevelId))
			return false;
		if (unitOfMeasureId == null) {
			if (other.unitOfMeasureId != null)
				return false;
		} else if (!unitOfMeasureId.equals(other.unitOfMeasureId))
			return false;
		return true;
	}

}
