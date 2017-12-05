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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Description: The persistent class for the - VAT SET UP-database table. 
 * Name of Project: BTI  
 * Created on: 
 * Modified on:
 * 
 * @author :GoodTech Version:
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true)
@Table(name = "SY03600", catalog = "bti")
public class VatSetUp implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TAXSCHDID", length = 15)
	private int taxSchdId; 

	@Column(name = "DSCRIPTN", length = 31)
	private String vatDescription;

	@Column(name = "DSCRIPTNA ", length = 61)
	private String vatDescriptionArabic;

	@Column(name = "VATYP")
	private Short vatSeriesType;

	@Column(name = "VATIDNUM")
	private int vatIdNumber;

	@Column(name = "ACTROWID")
	private long accountTableRowIndex;

	@Column(name = "BASDID")
	private int vatBasedOnListedOnOneTable;

	@Column(name = "BASPERCT", precision = 10, scale = 2)
	private float percentageBasedOn;

	@Column(name = "MINVATAMT", precision = 10, scale = 2)
	private float minimumVatAmount;

	@Column(name = "MAXVATAMT", precision = 10, scale = 2)
	private float maximumVatAmount;

	@Column(name = "YTDTOTSAL", precision = 10, scale = 2)
	private float ytdTotalSalesPurchase;

	@Column(name = "YTDTOTVAT", precision = 10, scale = 2)
	private float ytdTotalTaxableSalesPurchase;

	@Column(name = "YTDTOTTAX", precision = 10, scale = 2)
	private float ytdTotalSalesPurchaseTaxes;

	@Column(name = "LSTTOTSAL", precision = 10, scale = 2)
	private float lastYearTotalSalesPurchase;

	@Column(name = "LSTTOTVAT", precision = 10, scale = 2)
	private float lastYearTaxableSalesPurchase;

	@Column(name = "LSTTOTTAX", precision = 10, scale = 2)
	private float lastYearSalesPurchaseTaxes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATDDT", length = 19)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFDT", length = 19)
	private Date modifyDate;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEX_ROW_TS", length = 19)
	private Date rowDateIndex;

	@Column(name = "DEX_ROW_ID")
	private Integer rowIdIndex;
	
	@Column(name="STATUS")
	private boolean status;

	public VatSetUp() {
		super();
	}

	/**
	 * @param vatDescription
	 * @param vatDescriptionArabic
	 * @param vatSeriesType
	 * @param vatIdNumber
	 * @param accountTableRowIndex
	 * @param vatBasedOnListedOnOneTable
	 * @param percentageBasedOn
	 * @param minimumVatAmount
	 * @param maximumVatAmount
	 * @param ytdTotalSalesPurchase
	 * @param ytdTotalTaxableSalesPurchase
	 * @param ytdTotalSalesPurchaseTaxes
	 * @param lastYearTotalSalesPurchase
	 * @param lastYearTaxableSalesPurchase
	 * @param lastYearSalesPurchaseTaxes
	 * @param createDate
	 * @param modifyDate
	 * @param modifyByUserID
	 * @param rowDateIndex
	 * @param rowIdIndex
	 */
	

	/**
	 * @return the taxSchdId
	 */
	public int getTaxSchdId() {
		return taxSchdId;
	}

	public VatSetUp(String vatDescription, String vatDescriptionArabic, Short vatSeriesType, int vatIdNumber,
			long accountTableRowIndex, int vatBasedOnListedOnOneTable, float percentageBasedOn, float minimumVatAmount,
			float maximumVatAmount, float ytdTotalSalesPurchase, float ytdTotalTaxableSalesPurchase,
			float ytdTotalSalesPurchaseTaxes, float lastYearTotalSalesPurchase, float lastYearTaxableSalesPurchase,
			float lastYearSalesPurchaseTaxes, Date createDate, Date modifyDate, String modifyByUserID,
			Date rowDateIndex, Integer rowIdIndex, boolean status) {
		super();
		this.vatDescription = vatDescription;
		this.vatDescriptionArabic = vatDescriptionArabic;
		this.vatSeriesType = vatSeriesType;
		this.vatIdNumber = vatIdNumber;
		this.accountTableRowIndex = accountTableRowIndex;
		this.vatBasedOnListedOnOneTable = vatBasedOnListedOnOneTable;
		this.percentageBasedOn = percentageBasedOn;
		this.minimumVatAmount = minimumVatAmount;
		this.maximumVatAmount = maximumVatAmount;
		this.ytdTotalSalesPurchase = ytdTotalSalesPurchase;
		this.ytdTotalTaxableSalesPurchase = ytdTotalTaxableSalesPurchase;
		this.ytdTotalSalesPurchaseTaxes = ytdTotalSalesPurchaseTaxes;
		this.lastYearTotalSalesPurchase = lastYearTotalSalesPurchase;
		this.lastYearTaxableSalesPurchase = lastYearTaxableSalesPurchase;
		this.lastYearSalesPurchaseTaxes = lastYearSalesPurchaseTaxes;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.modifyByUserID = modifyByUserID;
		this.rowDateIndex = rowDateIndex;
		this.rowIdIndex = rowIdIndex;
		this.status = status;
	}

	/**
	 * @param taxSchdId
	 *            the taxSchdId to set
	 */
	public void setTaxSchdId(int taxSchdId) {
		this.taxSchdId = taxSchdId;
	}

	/**
	 * @return the vatDescription
	 */
	public String getVatDescription() {
		return vatDescription;
	}

	/**
	 * @param vatDescription
	 *            the vatDescription to set
	 */
	public void setVatDescription(String vatDescription) {
		this.vatDescription = vatDescription;
	}

	/**
	 * @return the vatDescriptionArabic
	 */
	public String getVatDescriptionArabic() {
		return vatDescriptionArabic;
	}

	/**
	 * @param vatDescriptionArabic
	 *            the vatDescriptionArabic to set
	 */
	public void setVatDescriptionArabic(String vatDescriptionArabic) {
		this.vatDescriptionArabic = vatDescriptionArabic;
	}

	/**
	 * @return the vatSeriesType
	 */
	public Short getVatSeriesType() {
		return vatSeriesType;
	}

	/**
	 * @param vatSeriesType
	 *            the vatSeriesType to set
	 */
	public void setVatSeriesType(Short vatSeriesType) {
		this.vatSeriesType = vatSeriesType;
	}

	/**
	 * @return the vatIdNumber
	 */
	public int getVatIdNumber() {
		return vatIdNumber;
	}

	/**
	 * @param vatIdNumber
	 *            the vatIdNumber to set
	 */
	public void setVatIdNumber(int vatIdNumber) {
		this.vatIdNumber = vatIdNumber;
	}

	/**
	 * @return the accountTableRowIndex
	 */
	public long getAccountTableRowIndex() {
		return accountTableRowIndex;
	}

	/**
	 * @param accountTableRowIndex
	 *            the accountTableRowIndex to set
	 */
	public void setAccountTableRowIndex(long accountTableRowIndex) {
		this.accountTableRowIndex = accountTableRowIndex;
	}

	/**
	 * @return the vatBasedOnListedOnOneTable
	 */
	public int getVatBasedOnListedOnOneTable() {
		return vatBasedOnListedOnOneTable;
	}

	/**
	 * @param vatBasedOnListedOnOneTable
	 *            the vatBasedOnListedOnOneTable to set
	 */
	public void setVatBasedOnListedOnOneTable(int vatBasedOnListedOnOneTable) {
		this.vatBasedOnListedOnOneTable = vatBasedOnListedOnOneTable;
	}

	/**
	 * @return the percentageBasedOn
	 */
	public float getPercentageBasedOn() {
		return percentageBasedOn;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @param percentageBasedOn
	 *            the percentageBasedOn to set
	 */
	public void setPercentageBasedOn(float percentageBasedOn) {
		this.percentageBasedOn = percentageBasedOn;
	}

	/**
	 * @return the minimumVatAmount
	 */
	public float getMinimumVatAmount() {
		return minimumVatAmount;
	}

	/**
	 * @param minimumVatAmount
	 *            the minimumVatAmount to set
	 */
	public void setMinimumVatAmount(float minimumVatAmount) {
		this.minimumVatAmount = minimumVatAmount;
	}

	/**
	 * @return the maximumVatAmount
	 */
	public float getMaximumVatAmount() {
		return maximumVatAmount;
	}

	/**
	 * @param maximumVatAmount
	 *            the maximumVatAmount to set
	 */
	public void setMaximumVatAmount(float maximumVatAmount) {
		this.maximumVatAmount = maximumVatAmount;
	}

	/**
	 * @return the ytdTotalSalesPurchase
	 */
	public float getYtdTotalSalesPurchase() {
		return ytdTotalSalesPurchase;
	}

	/**
	 * @param ytdTotalSalesPurchase
	 *            the ytdTotalSalesPurchase to set
	 */
	public void setYtdTotalSalesPurchase(float ytdTotalSalesPurchase) {
		this.ytdTotalSalesPurchase = ytdTotalSalesPurchase;
	}

	/**
	 * @return the ytdTotalTaxableSalesPurchase
	 */
	public float getYtdTotalTaxableSalesPurchase() {
		return ytdTotalTaxableSalesPurchase;
	}

	/**
	 * @param ytdTotalTaxableSalesPurchase
	 *            the ytdTotalTaxableSalesPurchase to set
	 */
	public void setYtdTotalTaxableSalesPurchase(float ytdTotalTaxableSalesPurchase) {
		this.ytdTotalTaxableSalesPurchase = ytdTotalTaxableSalesPurchase;
	}

	/**
	 * @return the ytdTotalSalesPurchaseTaxes
	 */
	public float getYtdTotalSalesPurchaseTaxes() {
		return ytdTotalSalesPurchaseTaxes;
	}

	/**
	 * @param ytdTotalSalesPurchaseTaxes
	 *            the ytdTotalSalesPurchaseTaxes to set
	 */
	public void setYtdTotalSalesPurchaseTaxes(float ytdTotalSalesPurchaseTaxes) {
		this.ytdTotalSalesPurchaseTaxes = ytdTotalSalesPurchaseTaxes;
	}

	/**
	 * @return the lastYearTotalSalesPurchase
	 */
	public float getLastYearTotalSalesPurchase() {
		return lastYearTotalSalesPurchase;
	}

	/**
	 * @param lastYearTotalSalesPurchase
	 *            the lastYearTotalSalesPurchase to set
	 */
	public void setLastYearTotalSalesPurchase(float lastYearTotalSalesPurchase) {
		this.lastYearTotalSalesPurchase = lastYearTotalSalesPurchase;
	}

	/**
	 * @return the lastYearTaxableSalesPurchase
	 */
	public float getLastYearTaxableSalesPurchase() {
		return lastYearTaxableSalesPurchase;
	}

	/**
	 * @param lastYearTaxableSalesPurchase
	 *            the lastYearTaxableSalesPurchase to set
	 */
	public void setLastYearTaxableSalesPurchase(float lastYearTaxableSalesPurchase) {
		this.lastYearTaxableSalesPurchase = lastYearTaxableSalesPurchase;
	}

	/**
	 * @return the lastYearSalesPurchaseTaxes
	 */
	public float getLastYearSalesPurchaseTaxes() {
		return lastYearSalesPurchaseTaxes;
	}

	/**
	 * @param lastYearSalesPurchaseTaxes
	 *            the lastYearSalesPurchaseTaxes to set
	 */
	public void setLastYearSalesPurchaseTaxes(float lastYearSalesPurchaseTaxes) {
		this.lastYearSalesPurchaseTaxes = lastYearSalesPurchaseTaxes;
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
	 * @return the rowDateIndex
	 */
	public Date getRowDateIndex() {
		return rowDateIndex;
	}

	/**
	 * @param rowDateIndex
	 *            the rowDateIndex to set
	 */
	public void setRowDateIndex(Date rowDateIndex) {
		this.rowDateIndex = rowDateIndex;
	}

	/**
	 * @return the rowIdIndex
	 */
	public Integer getRowIdIndex() {
		return rowIdIndex;
	}

	/**
	 * @param rowIdIndex
	 *            the rowIdIndex to set
	 */
	public void setRowIdIndex(Integer rowIdIndex) {
		this.rowIdIndex = rowIdIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountTableRowIndex ^ (accountTableRowIndex >>> 32));
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + Float.floatToIntBits(lastYearSalesPurchaseTaxes);
		result = prime * result + Float.floatToIntBits(lastYearTaxableSalesPurchase);
		result = prime * result + Float.floatToIntBits(lastYearTotalSalesPurchase);
		result = prime * result + Float.floatToIntBits(maximumVatAmount);
		result = prime * result + Float.floatToIntBits(minimumVatAmount);
		result = prime * result + ((modifyByUserID == null) ? 0 : modifyByUserID.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + Float.floatToIntBits(percentageBasedOn);
		result = prime * result + ((rowDateIndex == null) ? 0 : rowDateIndex.hashCode());
		result = prime * result + ((rowIdIndex == null) ? 0 : rowIdIndex.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + taxSchdId;
		result = prime * result + vatBasedOnListedOnOneTable;
		result = prime * result + ((vatDescription == null) ? 0 : vatDescription.hashCode());
		result = prime * result + ((vatDescriptionArabic == null) ? 0 : vatDescriptionArabic.hashCode());
		result = prime * result + vatIdNumber;
		result = prime * result + ((vatSeriesType == null) ? 0 : vatSeriesType.hashCode());
		result = prime * result + Float.floatToIntBits(ytdTotalSalesPurchase);
		result = prime * result + Float.floatToIntBits(ytdTotalSalesPurchaseTaxes);
		result = prime * result + Float.floatToIntBits(ytdTotalTaxableSalesPurchase);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VatSetUp other = (VatSetUp) obj;
		if (accountTableRowIndex != other.accountTableRowIndex)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (Float.floatToIntBits(lastYearSalesPurchaseTaxes) != Float.floatToIntBits(other.lastYearSalesPurchaseTaxes))
			return false;
		if (Float.floatToIntBits(lastYearTaxableSalesPurchase) != Float
				.floatToIntBits(other.lastYearTaxableSalesPurchase))
			return false;
		if (Float.floatToIntBits(lastYearTotalSalesPurchase) != Float.floatToIntBits(other.lastYearTotalSalesPurchase))
			return false;
		if (Float.floatToIntBits(maximumVatAmount) != Float.floatToIntBits(other.maximumVatAmount))
			return false;
		if (Float.floatToIntBits(minimumVatAmount) != Float.floatToIntBits(other.minimumVatAmount))
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
		if (Float.floatToIntBits(percentageBasedOn) != Float.floatToIntBits(other.percentageBasedOn))
			return false;
		if (rowDateIndex == null) {
			if (other.rowDateIndex != null)
				return false;
		} else if (!rowDateIndex.equals(other.rowDateIndex))
			return false;
		if (rowIdIndex == null) {
			if (other.rowIdIndex != null)
				return false;
		} else if (!rowIdIndex.equals(other.rowIdIndex))
			return false;
		if (status != other.status)
			return false;
		if (taxSchdId != other.taxSchdId)
			return false;
		if (vatBasedOnListedOnOneTable != other.vatBasedOnListedOnOneTable)
			return false;
		if (vatDescription == null) {
			if (other.vatDescription != null)
				return false;
		} else if (!vatDescription.equals(other.vatDescription))
			return false;
		if (vatDescriptionArabic == null) {
			if (other.vatDescriptionArabic != null)
				return false;
		} else if (!vatDescriptionArabic.equals(other.vatDescriptionArabic))
			return false;
		if (vatIdNumber != other.vatIdNumber)
			return false;
		if (vatSeriesType == null) {
			if (other.vatSeriesType != null)
				return false;
		} else if (!vatSeriesType.equals(other.vatSeriesType))
			return false;
		if (Float.floatToIntBits(ytdTotalSalesPurchase) != Float.floatToIntBits(other.ytdTotalSalesPurchase))
			return false;
		if (Float.floatToIntBits(ytdTotalSalesPurchaseTaxes) != Float.floatToIntBits(other.ytdTotalSalesPurchaseTaxes))
			return false;
		if (Float.floatToIntBits(ytdTotalTaxableSalesPurchase) != Float
				.floatToIntBits(other.ytdTotalTaxableSalesPurchase))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	

}
