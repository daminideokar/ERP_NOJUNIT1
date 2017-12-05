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

import static org.assertj.core.api.Assertions.in;

import com.bti.model.InventoryControlSetUp;

/**
 * Description: class for the Dto Inventory Control SetUp
 * Name of Project: BTI
 * @author Goodtech 
 * Created on: NOVEMBER 16, 2017 
 * Modified on: 
 * Version:
 */

public class DtoInventoryControlSetUp extends InventoryControlSetUp {

	private Integer pageNumber;
	private Integer pageSize;
	private String deleteMessage;
	private String associateMessage;
	private String dimensionDescription;

	public DtoInventoryControlSetUp() {

	}

	/**
	 * @param pageNumber
	 * @param pageSize
	 * @param deleteMessage
	 * @param associateMessage
	 * @param dimensionDescription
	 */
	public DtoInventoryControlSetUp(Integer pageNumber, Integer pageSize, String deleteMessage, String associateMessage,
			String dimensionDescription) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.deleteMessage = deleteMessage;
		this.associateMessage = associateMessage;
		this.dimensionDescription = dimensionDescription;
	}

	public DtoInventoryControlSetUp(InventoryControlSetUp inventoryControlSetUp) {
		super(inventoryControlSetUp.getKeySetupId(), inventoryControlSetUp.getModifyByUserID(),
				inventoryControlSetUp.getPasswordForUsingExpireLotInAdjustmentOrTransfer(),

				inventoryControlSetUp.getPasswordForUsingExpireLotInOtherInventoryTransactions(),
				inventoryControlSetUp.getNextAdjustmentDocumentNumber(),
				inventoryControlSetUp.getNextInTransitTransferDocumentNumber(),
				inventoryControlSetUp.getNextProductionDocumentNumber(),
				inventoryControlSetUp.getNextTransferDocumentNumber(),
				inventoryControlSetUp.getNextVarianceDocumentNumber(), inventoryControlSetUp.getUserCategoryName1(),
				inventoryControlSetUp.getUserCategoryName2(), inventoryControlSetUp.getUserCategoryName3(),
				inventoryControlSetUp.getUserCategoryName4(), inventoryControlSetUp.getUserCategoryName5(),
				inventoryControlSetUp.getUserCategoryName6(), inventoryControlSetUp.getStatus(),
				inventoryControlSetUp.getQuantityDecimals(), inventoryControlSetUp.getCurrencyDecimal(),
				inventoryControlSetUp.getExpLotsInInventoryAdjustmentAndTransfer(),
				inventoryControlSetUp.getExpLotsInInventoryAdjustmentAndTransfer(), inventoryControlSetUp.getGl00102());
	}

	/**
	 * @return the dimensionDescription
	 */
	public String getDimensionDescription() {
		return dimensionDescription;
	}

	/**
	 * @param dimensionDescription
	 *            the dimensionDescription to set
	 */
	public void setDimensionDescription(String dimensionDescription) {
		this.dimensionDescription = dimensionDescription;
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

	/**
	 * @return the associateMessage
	 */
	public String getAssociateMessage() {
		return associateMessage;
	}

	/**
	 * @param associateMessage
	 *            the associateMessage to set
	 */
	public void setAssociateMessage(String associateMessage) {
		this.associateMessage = associateMessage;
	}

}
