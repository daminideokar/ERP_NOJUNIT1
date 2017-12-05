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
package com.bti.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
/**
 * Description: class for the Inventory Ccontrol Setup 
 * Name of Project: BTI
 * Created on: NOVEMBER 16, 2017
 * Modified on:
 * @author GoodTech 
 * Version:
 */
@Entity
@Table(name = "Iv40000")
//@NamedQuery(name = "InventoryControlSetUp.findAll", query = "SELECT i FROM InventoryControlSetUp i")
public class InventoryControlSetUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int keySetupId;

	@Column(name = "ALLADJOVR")
	private Byte allowAdjustmentOverrides; // (True=1, False=0)

	@Column(name = "ALLDECCOST")
	private Byte allowCostForDecreaseAdjustments; // (True=1, False=0)

	@Column(name = "ALLTRFOVR")
	private Byte allowTransferOverrides; // (True=1, False=0)

	@Column(name = "ALLVAROVR")
	private Byte allowVarianceOverrides; // (True=1, False=0)

	@Column(name = "AUTOASLOTN")
	/* based on (Receipt Date=1,Expiration Date=2 */
	private Short autoAssignLotNumbers;

	@Column(name = "AUTOSTKVAR")
	private Byte autoPostStockCountVariances; // (True=1, False=0)

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserID;

	@Column(name = "DEX_ROW_ID")
	private Integer rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "EXPASSINORT", length = 15)
	private String passwordForUsingExpireLotInOtherInventoryTransactions;

	@Column(name = "EXPASSINVTRX", length = 15)
	private String passwordForUsingExpireLotInAdjustmentOrTransfer;

	@Column(name = "IVADJNXT")
	private Integer nextAdjustmentDocumentNumber;

	@Column(name = "IVINTNXT")
	private Integer nextInTransitTransferDocumentNumber;

	@Column(name = "IVPRONXT")
	private Integer nextProductionDocumentNumber;

	@Column(name = "IVTRFNXT")
	private Integer nextTransferDocumentNumber;

	@Column(name = "IVVARNXT")
	private Integer nextVarianceDocumentNumber;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@Column(name = "USCATIV1", length = 15)
	private String userCategoryName1;

	@Column(name = "USCATIV2", length = 15)
	private String userCategoryName2;

	@Column(name = "USCATIV3", length = 15)
	private String userCategoryName3;

	@Column(name = "USCATIV4", length = 15)
	private String userCategoryName4;

	@Column(name = "USCATIV5", length = 15)
	private String userCategoryName5;

	@Column(name = "USCATIV6", length = 15)
	private String userCategoryName6;

	@Column(name = "STATUS")
	private Boolean status;

	@Column(name = "QTYDCML")
	private Integer quantityDecimals;

	@Column(name = "CURDECLM")
	private Integer currencyDecimal;
	
	@Column(name = "EXPLOTINVAT")
	private Byte expLotsInInventoryAdjustmentAndTransfer ; // (True=1, False=0)


	@Column(name = "EXPLOTTR")
	private Byte expiredLotsinOtherTransactions ; 
	
	// bi-directional many-to-one association to Gl00102
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "DIMNAME", referencedColumnName = "DIMNAME")
	private FinancialDimensionsTable gl00102;

	public InventoryControlSetUp() {
	}

	/**
	 * @return the keySetupId
	 */
	public int getKeySetupId() {
		return keySetupId;
	}

	/**
	 * @param keySetupId
	 *            the keySetupId to set
	 */
	public void setKeySetupId(int keySetupId) {
		this.keySetupId = keySetupId;
	}

	/**
	 * @return the allowAdjustmentOverrides
	 */
	public Byte getAllowAdjustmentOverrides() {
		return allowAdjustmentOverrides;
	}

	/**
	 * @param allowAdjustmentOverrides
	 *            the allowAdjustmentOverrides to set
	 */
	public void setAllowAdjustmentOverrides(Byte allowAdjustmentOverrides) {
		this.allowAdjustmentOverrides = allowAdjustmentOverrides;
	}

	/**
	 * @return the allowCostForDecreaseAdjustments
	 */
	public Byte getAllowCostForDecreaseAdjustments() {
		return allowCostForDecreaseAdjustments;
	}

	/**
	 * @param allowCostForDecreaseAdjustments
	 *            the allowCostForDecreaseAdjustments to set
	 */
	public void setAllowCostForDecreaseAdjustments(Byte allowCostForDecreaseAdjustments) {
		this.allowCostForDecreaseAdjustments = allowCostForDecreaseAdjustments;
	}

	/**
	 * @return the allowTransferOverrides
	 */
	public Byte getAllowTransferOverrides() {
		return allowTransferOverrides;
	}

	/**
	 * @param allowTransferOverrides
	 *            the allowTransferOverrides to set
	 */
	public void setAllowTransferOverrides(Byte allowTransferOverrides) {
		this.allowTransferOverrides = allowTransferOverrides;
	}

	/**
	 * @return the allowVarianceOverrides
	 */
	public Byte getAllowVarianceOverrides() {
		return allowVarianceOverrides;
	}

	/**
	 * @param allowVarianceOverrides
	 *            the allowVarianceOverrides to set
	 */
	public void setAllowVarianceOverrides(Byte allowVarianceOverrides) {
		this.allowVarianceOverrides = allowVarianceOverrides;
	}

	/**
	 * @return the autoAssignLotNumbers
	 */
	public Short getAutoAssignLotNumbers() {
		return autoAssignLotNumbers;
	}

	/**
	 * @param autoAssignLotNumbers
	 *            the autoAssignLotNumbers to set
	 */
	public void setAutoAssignLotNumbers(Short autoAssignLotNumbers) {
		this.autoAssignLotNumbers = autoAssignLotNumbers;
	}

	/**
	 * @return the autoPostStockCountVariances
	 */
	public Byte getAutoPostStockCountVariances() {
		return autoPostStockCountVariances;
	}

	/**
	 * @param autoPostStockCountVariances
	 *            the autoPostStockCountVariances to set
	 */
	public void setAutoPostStockCountVariances(Byte autoPostStockCountVariances) {
		this.autoPostStockCountVariances = autoPostStockCountVariances;
	}

	/**
	 * @return the modifyByUserID
	 */
	public String getModifyByUserID() {
		return modifyByUserID;
	}

	/**
	 * @param modifyByUserID
	 *            the modifyByUserID to set
	 */
	public void setModifyByUserID(String modifyByUserID) {
		this.modifyByUserID = modifyByUserID;
	}

	/**
	 * @return the rowIdIndexing
	 */
	public Integer getRowIdIndexing() {
		return rowIdIndexing;
	}

	/**
	 * @param rowIdIndexing
	 *            the rowIdIndexing to set
	 */
	public void setRowIdIndexing(Integer rowIdIndexing) {
		this.rowIdIndexing = rowIdIndexing;
	}

	/**
	 * @return the rowDateIndexing
	 */
	public Date getRowDateIndexing() {
		return rowDateIndexing;
	}

	/**
	 * @param rowDateIndexing
	 *            the rowDateIndexing to set
	 */
	public void setRowDateIndexing(Date rowDateIndexing) {
		this.rowDateIndexing = rowDateIndexing;
	}

	/**
	 * @return the passwordForUsingExpireLotInOtherInventoryTransactions
	 */
	public String getPasswordForUsingExpireLotInOtherInventoryTransactions() {
		return passwordForUsingExpireLotInOtherInventoryTransactions;
	}

	/**
	 * @param passwordForUsingExpireLotInOtherInventoryTransactions
	 *            the passwordForUsingExpireLotInOtherInventoryTransactions to set
	 */
	public void setPasswordForUsingExpireLotInOtherInventoryTransactions(
			String passwordForUsingExpireLotInOtherInventoryTransactions) {
		this.passwordForUsingExpireLotInOtherInventoryTransactions = passwordForUsingExpireLotInOtherInventoryTransactions;
	}

	/**
	 * @return the passwordForUsingExpireLotInAdjustmentOrTransfer
	 */
	public String getPasswordForUsingExpireLotInAdjustmentOrTransfer() {
		return passwordForUsingExpireLotInAdjustmentOrTransfer;
	}

	/**
	 * @param passwordForUsingExpireLotInAdjustmentOrTransfer
	 *            the passwordForUsingExpireLotInAdjustmentOrTransfer to set
	 */
	public void setPasswordForUsingExpireLotInAdjustmentOrTransfer(
			String passwordForUsingExpireLotInAdjustmentOrTransfer) {
		this.passwordForUsingExpireLotInAdjustmentOrTransfer = passwordForUsingExpireLotInAdjustmentOrTransfer;
	}

	/**
	 * @return the nextAdjustmentDocumentNumber
	 */
	public Integer getNextAdjustmentDocumentNumber() {
		return nextAdjustmentDocumentNumber;
	}

	/**
	 * @param nextAdjustmentDocumentNumber
	 *            the nextAdjustmentDocumentNumber to set
	 */
	public void setNextAdjustmentDocumentNumber(int nextAdjustmentDocumentNumber) {
		this.nextAdjustmentDocumentNumber = nextAdjustmentDocumentNumber;
	}

	/**
	 * @return the nextInTransitTransferDocumentNumber
	 */
	public Integer getNextInTransitTransferDocumentNumber() {
		return nextInTransitTransferDocumentNumber;
	}

	/**
	 * @param nextInTransitTransferDocumentNumber
	 *            the nextInTransitTransferDocumentNumber to set
	 */
	public void setNextInTransitTransferDocumentNumber(int nextInTransitTransferDocumentNumber) {
		this.nextInTransitTransferDocumentNumber = nextInTransitTransferDocumentNumber;
	}

	/**
	 * @return the nextProductionDocumentNumber
	 */
	public Integer getNextProductionDocumentNumber() {
		return nextProductionDocumentNumber;
	}

	/**
	 * @param nextProductionDocumentNumber
	 *            the nextProductionDocumentNumber to set
	 */
	public void setNextProductionDocumentNumber(int nextProductionDocumentNumber) {
		this.nextProductionDocumentNumber = nextProductionDocumentNumber;
	}

	/**
	 * @return the nextTransferDocumentNumber
	 */
	public Integer getNextTransferDocumentNumber() {
		return nextTransferDocumentNumber;
	}

	/**
	 * @param nextTransferDocumentNumber
	 *            the nextTransferDocumentNumber to set
	 */
	public void setNextTransferDocumentNumber(int nextTransferDocumentNumber) {
		this.nextTransferDocumentNumber = nextTransferDocumentNumber;
	}

	/**
	 * @return the nextVarianceDocumentNumber
	 */
	public Integer getNextVarianceDocumentNumber() {
		return nextVarianceDocumentNumber;
	}

	/**
	 * @param nextVarianceDocumentNumber
	 *            the nextVarianceDocumentNumber to set
	 */
	public void setNextVarianceDocumentNumber(int nextVarianceDocumentNumber) {
		this.nextVarianceDocumentNumber = nextVarianceDocumentNumber;
	}

	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate
	 *            the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * @return the userCategoryName1
	 */
	public String getUserCategoryName1() {
		return userCategoryName1;
	}

	/**
	 * @param userCategoryName1
	 *            the userCategoryName1 to set
	 */
	public void setUserCategoryName1(String userCategoryName1) {
		this.userCategoryName1 = userCategoryName1;
	}

	/**
	 * @return the userCategoryName2
	 */
	public String getUserCategoryName2() {
		return userCategoryName2;
	}

	/**
	 * @param userCategoryName2
	 *            the userCategoryName2 to set
	 */
	public void setUserCategoryName2(String userCategoryName2) {
		this.userCategoryName2 = userCategoryName2;
	}

	/**
	 * @return the userCategoryName3
	 */
	public String getUserCategoryName3() {
		return userCategoryName3;
	}

	/**
	 * @param userCategoryName3
	 *            the userCategoryName3 to set
	 */
	public void setUserCategoryName3(String userCategoryName3) {
		this.userCategoryName3 = userCategoryName3;
	}

	/**
	 * @return the userCategoryName4
	 */
	public String getUserCategoryName4() {
		return userCategoryName4;
	}

	/**
	 * @param userCategoryName4
	 *            the userCategoryName4 to set
	 */
	public void setUserCategoryName4(String userCategoryName4) {
		this.userCategoryName4 = userCategoryName4;
	}

	/**
	 * @return the userCategoryName5
	 */
	public String getUserCategoryName5() {
		return userCategoryName5;
	}

	/**
	 * @param userCategoryName5
	 *            the userCategoryName5 to set
	 */
	public void setUserCategoryName5(String userCategoryName5) {
		this.userCategoryName5 = userCategoryName5;
	}

	/**
	 * @return the userCategoryName6
	 */
	public String getUserCategoryName6() {
		return userCategoryName6;
	}

	/**
	 * @param userCategoryName6
	 *            the userCategoryName6 to set
	 */
	public void setUserCategoryName6(String userCategoryName6) {
		this.userCategoryName6 = userCategoryName6;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the quantityDecimals
	 */
	public Integer getQuantityDecimals() {
		return quantityDecimals;
	}

	/**
	 * @param quantityDecimals
	 *            the quantityDecimals to set
	 */
	public void setQuantityDecimals(int quantityDecimals) {
		this.quantityDecimals = quantityDecimals;
	}

	/**
	 * @return the currencyDecimal
	 */
	public Integer getCurrencyDecimal() {
		return currencyDecimal;
	}

	/**
	 * @param currencyDecimal
	 *            the currencyDecimal to set
	 */
	public void setCurrencyDecimal(int currencyDecimal) {
		this.currencyDecimal = currencyDecimal;
	}

	/**
	 * @return the gl00102
	 */
	public FinancialDimensionsTable getGl00102() {
		return gl00102;
	}
	

	/**
	 * @param gl00102
	 *            the gl00102 to set
	 */
	public void setGl00102(FinancialDimensionsTable gl00102) {
		this.gl00102 = gl00102;
	}
	
	

	/**
	 * @return the lotsInInventoryAdjustmentAndTransfer
	 */
	public Byte getExpLotsInInventoryAdjustmentAndTransfer() {
		return expLotsInInventoryAdjustmentAndTransfer;
	}

	/**
	 * @param lotsInInventoryAdjustmentAndTransfer the lotsInInventoryAdjustmentAndTransfer to set
	 */
	public void setExpLotsInInventoryAdjustmentAndTransfer(Byte lotsInInventoryAdjustmentAndTransfer) {
		this.expLotsInInventoryAdjustmentAndTransfer = lotsInInventoryAdjustmentAndTransfer;
	}

	/**
	 * @return the expiredLotsinOtherTransactions
	 */
	public Byte getExpiredLotsinOtherTransactions() {
		return expiredLotsinOtherTransactions;
	}

	/**
	 * @param expiredLotsinOtherTransactions the expiredLotsinOtherTransactions to set
	 */
	public void setExpiredLotsinOtherTransactions(Byte expiredLotsinOtherTransactions) {
		this.expiredLotsinOtherTransactions = expiredLotsinOtherTransactions;
	}

	
	
	

	/**
	 * @param allowAdjustmentOverrides
	 * @param allowCostForDecreaseAdjustments
	 * @param allowTransferOverrides
	 * @param allowVarianceOverrides
	 * @param autoAssignLotNumbers
	 * @param autoPostStockCountVariances
	 * @param modifyByUserID
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param passwordForUsingExpireLotInOtherInventoryTransactions
	 * @param passwordForUsingExpireLotInAdjustmentOrTransfer
	 * @param nextAdjustmentDocumentNumber
	 * @param nextInTransitTransferDocumentNumber
	 * @param nextProductionDocumentNumber
	 * @param nextTransferDocumentNumber
	 * @param nextVarianceDocumentNumber
	 * @param modifyDate
	 * @param userCategoryName1
	 * @param userCategoryName2
	 * @param userCategoryName3
	 * @param userCategoryName4
	 * @param userCategoryName5
	 * @param userCategoryName6
	 * @param status
	 * @param quantityDecimals
	 * @param currencyDecimal
	 * @param expLotsInInventoryAdjustmentAndTransfer
	 * @param expiredLotsinOtherTransactions
	 * @param gl00102
	 */
	public InventoryControlSetUp(Byte allowAdjustmentOverrides, Byte allowCostForDecreaseAdjustments,
			Byte allowTransferOverrides, Byte allowVarianceOverrides, Short autoAssignLotNumbers,
			Byte autoPostStockCountVariances, String modifyByUserID, Integer rowIdIndexing, Date rowDateIndexing,
			String passwordForUsingExpireLotInOtherInventoryTransactions,
			String passwordForUsingExpireLotInAdjustmentOrTransfer, int nextAdjustmentDocumentNumber,
			int nextInTransitTransferDocumentNumber, int nextProductionDocumentNumber, int nextTransferDocumentNumber,
			int nextVarianceDocumentNumber, Date modifyDate, String userCategoryName1, String userCategoryName2,
			String userCategoryName3, String userCategoryName4, String userCategoryName5, String userCategoryName6,
			Boolean status, int quantityDecimals, int currencyDecimal, Byte expLotsInInventoryAdjustmentAndTransfer,
			Byte expiredLotsinOtherTransactions, FinancialDimensionsTable gl00102) {
		super();
		this.allowAdjustmentOverrides = allowAdjustmentOverrides;
		this.allowCostForDecreaseAdjustments = allowCostForDecreaseAdjustments;
		this.allowTransferOverrides = allowTransferOverrides;
		this.allowVarianceOverrides = allowVarianceOverrides;
		this.autoAssignLotNumbers = autoAssignLotNumbers;
		this.autoPostStockCountVariances = autoPostStockCountVariances;
		this.modifyByUserID = modifyByUserID;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.passwordForUsingExpireLotInOtherInventoryTransactions = passwordForUsingExpireLotInOtherInventoryTransactions;
		this.passwordForUsingExpireLotInAdjustmentOrTransfer = passwordForUsingExpireLotInAdjustmentOrTransfer;
		this.nextAdjustmentDocumentNumber = nextAdjustmentDocumentNumber;
		this.nextInTransitTransferDocumentNumber = nextInTransitTransferDocumentNumber;
		this.nextProductionDocumentNumber = nextProductionDocumentNumber;
		this.nextTransferDocumentNumber = nextTransferDocumentNumber;
		this.nextVarianceDocumentNumber = nextVarianceDocumentNumber;
		this.modifyDate = modifyDate;
		this.userCategoryName1 = userCategoryName1;
		this.userCategoryName2 = userCategoryName2;
		this.userCategoryName3 = userCategoryName3;
		this.userCategoryName4 = userCategoryName4;
		this.userCategoryName5 = userCategoryName5;
		this.userCategoryName6 = userCategoryName6;
		this.status = status;
		this.quantityDecimals = quantityDecimals;
		this.currencyDecimal = currencyDecimal;
		this.expLotsInInventoryAdjustmentAndTransfer = expLotsInInventoryAdjustmentAndTransfer;
		this.expiredLotsinOtherTransactions = expiredLotsinOtherTransactions;
		this.gl00102 = gl00102;
	}

	
	
	/**
	 * @param keySetupId
	 * @param modifyByUserID
	 * @param passwordForUsingExpireLotInOtherInventoryTransactions
	 * @param passwordForUsingExpireLotInAdjustmentOrTransfer
	 * @param nextAdjustmentDocumentNumber
	 * @param nextInTransitTransferDocumentNumber
	 * @param nextProductionDocumentNumber
	 * @param nextTransferDocumentNumber
	 * @param nextVarianceDocumentNumber
	 * @param userCategoryName1
	 * @param userCategoryName2
	 * @param userCategoryName3
	 * @param userCategoryName4
	 * @param userCategoryName5
	 * @param userCategoryName6
	 * @param status
	 * @param quantityDecimals
	 * @param currencyDecimal
	 * @param expLotsInInventoryAdjustmentAndTransfer
	 * @param expiredLotsinOtherTransactions
	 * @param gl00102
	 */
	public InventoryControlSetUp(int keySetupId, String modifyByUserID,
			String passwordForUsingExpireLotInOtherInventoryTransactions,
			String passwordForUsingExpireLotInAdjustmentOrTransfer, int nextAdjustmentDocumentNumber,
			int nextInTransitTransferDocumentNumber, int nextProductionDocumentNumber, int nextTransferDocumentNumber,
			int nextVarianceDocumentNumber, String userCategoryName1, String userCategoryName2,
			String userCategoryName3, String userCategoryName4, String userCategoryName5, String userCategoryName6,
			Boolean status, int quantityDecimals, int currencyDecimal, Byte expLotsInInventoryAdjustmentAndTransfer,
			Byte expiredLotsinOtherTransactions, FinancialDimensionsTable gl00102) {
		super();
		this.keySetupId = keySetupId;
		this.modifyByUserID = modifyByUserID;
		this.passwordForUsingExpireLotInOtherInventoryTransactions = passwordForUsingExpireLotInOtherInventoryTransactions;
		this.passwordForUsingExpireLotInAdjustmentOrTransfer = passwordForUsingExpireLotInAdjustmentOrTransfer;
		this.nextAdjustmentDocumentNumber = nextAdjustmentDocumentNumber;
		this.nextInTransitTransferDocumentNumber = nextInTransitTransferDocumentNumber;
		this.nextProductionDocumentNumber = nextProductionDocumentNumber;
		this.nextTransferDocumentNumber = nextTransferDocumentNumber;
		this.nextVarianceDocumentNumber = nextVarianceDocumentNumber;
		this.userCategoryName1 = userCategoryName1;
		this.userCategoryName2 = userCategoryName2;
		this.userCategoryName3 = userCategoryName3;
		this.userCategoryName4 = userCategoryName4;
		this.userCategoryName5 = userCategoryName5;
		this.userCategoryName6 = userCategoryName6;
		this.status = status;
		this.quantityDecimals = quantityDecimals;
		this.currencyDecimal = currencyDecimal;
		this.expLotsInInventoryAdjustmentAndTransfer = expLotsInInventoryAdjustmentAndTransfer;
		this.expiredLotsinOtherTransactions = expiredLotsinOtherTransactions;
		this.gl00102 = gl00102;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allowAdjustmentOverrides == null) ? 0 : allowAdjustmentOverrides.hashCode());
		result = prime * result
				+ ((allowCostForDecreaseAdjustments == null) ? 0 : allowCostForDecreaseAdjustments.hashCode());
		result = prime * result + ((allowTransferOverrides == null) ? 0 : allowTransferOverrides.hashCode());
		result = prime * result + ((allowVarianceOverrides == null) ? 0 : allowVarianceOverrides.hashCode());
		result = prime * result + ((autoAssignLotNumbers == null) ? 0 : autoAssignLotNumbers.hashCode());
		result = prime * result + ((autoPostStockCountVariances == null) ? 0 : autoPostStockCountVariances.hashCode());
		result = prime * result + currencyDecimal;
		result = prime * result + ((expLotsInInventoryAdjustmentAndTransfer == null) ? 0
				: expLotsInInventoryAdjustmentAndTransfer.hashCode());
		result = prime * result
				+ ((expiredLotsinOtherTransactions == null) ? 0 : expiredLotsinOtherTransactions.hashCode());
		result = prime * result + ((gl00102 == null) ? 0 : gl00102.hashCode());
		result = prime * result + keySetupId;
		result = prime * result + ((modifyByUserID == null) ? 0 : modifyByUserID.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + nextAdjustmentDocumentNumber;
		result = prime * result + nextInTransitTransferDocumentNumber;
		result = prime * result + nextProductionDocumentNumber;
		result = prime * result + nextTransferDocumentNumber;
		result = prime * result + nextVarianceDocumentNumber;
		result = prime * result + ((passwordForUsingExpireLotInAdjustmentOrTransfer == null) ? 0
				: passwordForUsingExpireLotInAdjustmentOrTransfer.hashCode());
		result = prime * result + ((passwordForUsingExpireLotInOtherInventoryTransactions == null) ? 0
				: passwordForUsingExpireLotInOtherInventoryTransactions.hashCode());
		result = prime * result + quantityDecimals;
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + ((rowIdIndexing == null) ? 0 : rowIdIndexing.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userCategoryName1 == null) ? 0 : userCategoryName1.hashCode());
		result = prime * result + ((userCategoryName2 == null) ? 0 : userCategoryName2.hashCode());
		result = prime * result + ((userCategoryName3 == null) ? 0 : userCategoryName3.hashCode());
		result = prime * result + ((userCategoryName4 == null) ? 0 : userCategoryName4.hashCode());
		result = prime * result + ((userCategoryName5 == null) ? 0 : userCategoryName5.hashCode());
		result = prime * result + ((userCategoryName6 == null) ? 0 : userCategoryName6.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		InventoryControlSetUp other = (InventoryControlSetUp) obj;
		if (allowAdjustmentOverrides == null) {
			if (other.allowAdjustmentOverrides != null)
				return false;
		} else if (!allowAdjustmentOverrides.equals(other.allowAdjustmentOverrides))
			return false;
		if (allowCostForDecreaseAdjustments == null) {
			if (other.allowCostForDecreaseAdjustments != null)
				return false;
		} else if (!allowCostForDecreaseAdjustments.equals(other.allowCostForDecreaseAdjustments))
			return false;
		if (allowTransferOverrides == null) {
			if (other.allowTransferOverrides != null)
				return false;
		} else if (!allowTransferOverrides.equals(other.allowTransferOverrides))
			return false;
		if (allowVarianceOverrides == null) {
			if (other.allowVarianceOverrides != null)
				return false;
		} else if (!allowVarianceOverrides.equals(other.allowVarianceOverrides))
			return false;
		if (autoAssignLotNumbers == null) {
			if (other.autoAssignLotNumbers != null)
				return false;
		} else if (!autoAssignLotNumbers.equals(other.autoAssignLotNumbers))
			return false;
		if (autoPostStockCountVariances == null) {
			if (other.autoPostStockCountVariances != null)
				return false;
		} else if (!autoPostStockCountVariances.equals(other.autoPostStockCountVariances))
			return false;
		if (currencyDecimal != other.currencyDecimal)
			return false;
		if (expLotsInInventoryAdjustmentAndTransfer == null) {
			if (other.expLotsInInventoryAdjustmentAndTransfer != null)
				return false;
		} else if (!expLotsInInventoryAdjustmentAndTransfer.equals(other.expLotsInInventoryAdjustmentAndTransfer))
			return false;
		if (expiredLotsinOtherTransactions == null) {
			if (other.expiredLotsinOtherTransactions != null)
				return false;
		} else if (!expiredLotsinOtherTransactions.equals(other.expiredLotsinOtherTransactions))
			return false;
		if (gl00102 == null) {
			if (other.gl00102 != null)
				return false;
		} else if (!gl00102.equals(other.gl00102))
			return false;
		if (keySetupId != other.keySetupId)
			return false;
		if (modifyByUserID == null) {
			if (other.modifyByUserID != null)
				return false;
		} else if (!modifyByUserID.equals(other.modifyByUserID))
			return false;
		if (modifyDate == null) {
			if (other.modifyDate != null)
				return false;
		} else if (!modifyDate.equals(other.modifyDate))
			return false;
		if (nextAdjustmentDocumentNumber != other.nextAdjustmentDocumentNumber)
			return false;
		if (nextInTransitTransferDocumentNumber != other.nextInTransitTransferDocumentNumber)
			return false;
		if (nextProductionDocumentNumber != other.nextProductionDocumentNumber)
			return false;
		if (nextTransferDocumentNumber != other.nextTransferDocumentNumber)
			return false;
		if (nextVarianceDocumentNumber != other.nextVarianceDocumentNumber)
			return false;
		if (passwordForUsingExpireLotInAdjustmentOrTransfer == null) {
			if (other.passwordForUsingExpireLotInAdjustmentOrTransfer != null)
				return false;
		} else if (!passwordForUsingExpireLotInAdjustmentOrTransfer
				.equals(other.passwordForUsingExpireLotInAdjustmentOrTransfer))
			return false;
		if (passwordForUsingExpireLotInOtherInventoryTransactions == null) {
			if (other.passwordForUsingExpireLotInOtherInventoryTransactions != null)
				return false;
		} else if (!passwordForUsingExpireLotInOtherInventoryTransactions
				.equals(other.passwordForUsingExpireLotInOtherInventoryTransactions))
			return false;
		if (quantityDecimals != other.quantityDecimals)
			return false;
		if (rowDateIndexing == null) {
			if (other.rowDateIndexing != null)
				return false;
		} else if (!rowDateIndexing.equals(other.rowDateIndexing))
			return false;
		if (rowIdIndexing == null) {
			if (other.rowIdIndexing != null)
				return false;
		} else if (!rowIdIndexing.equals(other.rowIdIndexing))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userCategoryName1 == null) {
			if (other.userCategoryName1 != null)
				return false;
		} else if (!userCategoryName1.equals(other.userCategoryName1))
			return false;
		if (userCategoryName2 == null) {
			if (other.userCategoryName2 != null)
				return false;
		} else if (!userCategoryName2.equals(other.userCategoryName2))
			return false;
		if (userCategoryName3 == null) {
			if (other.userCategoryName3 != null)
				return false;
		} else if (!userCategoryName3.equals(other.userCategoryName3))
			return false;
		if (userCategoryName4 == null) {
			if (other.userCategoryName4 != null)
				return false;
		} else if (!userCategoryName4.equals(other.userCategoryName4))
			return false;
		if (userCategoryName5 == null) {
			if (other.userCategoryName5 != null)
				return false;
		} else if (!userCategoryName5.equals(other.userCategoryName5))
			return false;
		if (userCategoryName6 == null) {
			if (other.userCategoryName6 != null)
				return false;
		} else if (!userCategoryName6.equals(other.userCategoryName6))
			return false;
		return true;
	}


}
