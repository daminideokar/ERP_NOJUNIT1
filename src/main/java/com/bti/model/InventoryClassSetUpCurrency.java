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
 * Description: class for the Inventory class SetUp Currency 
 * Name of Project: BTI 
 * Created on: NOVEMBER 13, 2017
 * Modified on:
 * 
 * @author GoodTech Version:
 */
@Entity
@Table(name = "Iv40401")
//@NamedQuery(name = "InventoryClassSetUpCurrency.findAll", query = "SELECT i FROM InventoryClassSetUpCurrency i")
public class InventoryClassSetUpCurrency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IVINX")
	private int inventoryClassSetUpCurrencyIndex;

	@Column(name = "CHANGEBY")
	private String modifyByUserID;

	@Column(name = "CREATDDT")
	private Date createDate;

	@Column(name = "CURNCYID", length = 15)
	private String currencyId;

	@Column(name = "CURNDECLM")
	private int currencyDecimal;

	@Column(name = "DEX_ROW_ID")
	private int rowIdIndexing;

	@Column(name = "DEX_ROW_TS ")
	private Date rowDateIndexing;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@Column(name = "STATUS")
	private Boolean status;

	// bi-directional many-to-one association to Iv40400
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ITMCLSID", referencedColumnName = "ITMCLSID")
	private ItemClassSetUp iv40400;

	// bi-directional many-to-one association to Mc40200
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CURNCYID", insertable = false, updatable = false)
	private CurrencySetUp mc40200;

	public InventoryClassSetUpCurrency() {
	}

	/**
	 * @param modifyByUserID
	 * @param createDate
	 * @param currencyId
	 * @param currencyDecimal
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param modifyDate
	 * @param status
	 * @param iv40400
	 */
	public InventoryClassSetUpCurrency(String modifyByUserID, Date createDate, String currencyId, int currencyDecimal,
			int rowIdIndexing, Date rowDateIndexing, Date modifyDate, Boolean status, ItemClassSetUp iv40400) {
		super();
		this.modifyByUserID = modifyByUserID;
		this.createDate = createDate;
		this.currencyId = currencyId;
		this.currencyDecimal = currencyDecimal;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.modifyDate = modifyDate;
		this.status = status;
		this.iv40400 = iv40400;
	}

	public InventoryClassSetUpCurrency(int invinx2, String modifyByUserID2, String currencyId2, Boolean status2,
			ItemClassSetUp iv404002, CurrencySetUp mc402002) {

	}

	/**
	 * @return the inventoryClassSetUpCurrencyIndex
	 */
	public int getInventoryClassSetUpCurrencyIndex() {
		return inventoryClassSetUpCurrencyIndex;
	}

	/**
	 * @param inventoryClassSetUpCurrencyIndex
	 *            the inventoryClassSetUpCurrencyIndex to set
	 */
	public void setInventoryClassSetUpCurrencyIndex(int inventoryClassSetUpCurrencyIndex) {
		this.inventoryClassSetUpCurrencyIndex = inventoryClassSetUpCurrencyIndex;
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
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	 * @return the currencyDecimal
	 */
	public int getCurrencyDecimal() {
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
	 * @return the rowIdIndexing
	 */
	public int getRowIdIndexing() {
		return rowIdIndexing;
	}

	/**
	 * @param rowIdIndexing
	 *            the rowIdIndexing to set
	 */
	public void setRowIdIndexing(int rowIdIndexing) {
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

	

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	// bi-directional many-to-one association to Iv40400
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ITMCLSID")
	public ItemClassSetUp getIv40400() {
		return this.iv40400;
	}

	public void setIv40400(ItemClassSetUp iv40400) {
		this.iv40400 = iv40400;
	}

	// bi-directional many-to-one association to Mc40200
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CURNCYID")
	public CurrencySetUp getMc40200() {
		return this.mc40200;
	}

	public void setMc40200(CurrencySetUp mc40200) {
		this.mc40200 = mc40200;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + currencyDecimal;
		result = prime * result + ((currencyId == null) ? 0 : currencyId.hashCode());
		result = prime * result + inventoryClassSetUpCurrencyIndex;
		result = prime * result + ((iv40400 == null) ? 0 : iv40400.hashCode());
		result = prime * result + ((modifyByUserID == null) ? 0 : modifyByUserID.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + rowIdIndexing;
		result = prime * result + (status ? 1231 : 1237);
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryClassSetUpCurrency other = (InventoryClassSetUpCurrency) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (currencyDecimal != other.currencyDecimal)
			return false;
		if (currencyId == null) {
			if (other.currencyId != null)
				return false;
		} else if (!currencyId.equals(other.currencyId))
			return false;
		if (inventoryClassSetUpCurrencyIndex != other.inventoryClassSetUpCurrencyIndex)
			return false;
		if (iv40400 == null) {
			if (other.iv40400 != null)
				return false;
		} else if (!iv40400.equals(other.iv40400))
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
		if (rowDateIndexing == null) {
			if (other.rowDateIndexing != null)
				return false;
		} else if (!rowDateIndexing.equals(other.rowDateIndexing))
			return false;
		if (rowIdIndexing != other.rowIdIndexing)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
