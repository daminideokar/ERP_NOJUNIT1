
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
import java.util.Date;
import java.util.List;

/**
 * Description: class for the FINANCIAL DIMENSION - table
 * Name of Project: BTI
 * Created on: NOVEMBER 16, 2017 
 * Modified on:
 * @author GoodTech Version:
 */
@Entity
@Table(name = "Gl00102")
//@NamedQuery(name = "FinancialDimensionsTable.findAll", query = "SELECT g FROM FinancialDimensionsTable g")
public class FinancialDimensionsTable implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DIMINXD")
	private int dimensionIndex;

	@Column(name = "CHANGEBY")
	private String modifyByUserId;

	@Column(name = "CREATDDT")
	private Date createDate;

	@Column(name = "DEX_ROW_ID")
	private Integer rowIdIndex;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndex;

	@Column(name = "DIMCOLNAME")
	private String dimensionColumnName;

	@Column(name = "DIMMASK")
	private String dimensionMask;

	@Column(name = "DIMNAME")
	private String dimensionDescription;

	@Column(name = "DIMNAMEA")
	private String dimensionDescriptionArabic;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@OneToMany(mappedBy = "gl00102")
	private List<InventoryControlSetUp> iv40000s;

	public FinancialDimensionsTable() {
	}

	/**
	 * @param dimensionIndex
	 * @param modifyByUserId
	 * @param createDate
	 * @param rowIdIndex
	 * @param rowDateIndex
	 * @param dimensionColumnName
	 * @param dimensionMask
	 * @param dimensionDescription
	 * @param dimensionDescriptionArabic
	 * @param modifyDate
	 * @param iv40000s
	 */
	public FinancialDimensionsTable(int dimensionIndex, String modifyByUserId, Date createDate, int rowIdIndex,
			Date rowDateIndex, String dimensionColumnName, String dimensionMask, String dimensionDescription,
			String dimensionDescriptionArabic, Date modifyDate, List<InventoryControlSetUp> iv40000s) {
		super();
		this.dimensionIndex = dimensionIndex;
		this.modifyByUserId = modifyByUserId;
		this.createDate = createDate;
		this.rowIdIndex = rowIdIndex;
		this.rowDateIndex = rowDateIndex;
		this.dimensionColumnName = dimensionColumnName;
		this.dimensionMask = dimensionMask;
		this.dimensionDescription = dimensionDescription;
		this.dimensionDescriptionArabic = dimensionDescriptionArabic;
		this.modifyDate = modifyDate;
		this.iv40000s = iv40000s;
	}

	/**
	 * @param dimensionIndex
	 * @param modifyByUserId
	 * @param dimensionDescription
	 * @param dimensionDescriptionArabic
	 * @param iv40000s
	 */
	public FinancialDimensionsTable(int dimensionIndex, String modifyByUserId, String dimensionDescription,
			String dimensionDescriptionArabic, List<InventoryControlSetUp> iv40000s) {
		super();
		this.dimensionIndex = dimensionIndex;
		this.modifyByUserId = modifyByUserId;
		this.dimensionDescription = dimensionDescription;
		this.dimensionDescriptionArabic = dimensionDescriptionArabic;
		this.iv40000s = iv40000s;
	}

	/**
	 * @return the dimensionIndex
	 */
	public int getDimensionIndex() {
		return dimensionIndex;
	}

	/**
	 * @param dimensionIndex
	 *            the dimensionIndex to set
	 */
	public void setDimensionIndex(int dimensionIndex) {
		this.dimensionIndex = dimensionIndex;
	}

	/**
	 * @return the modifyByUserId
	 */
	public String getModifyByUserId() {
		return modifyByUserId;
	}

	/**
	 * @param modifyByUserId
	 *            the modifyByUserId to set
	 */
	public void setModifyByUserId(String modifyByUserId) {
		this.modifyByUserId = modifyByUserId;
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
	 * @return the rowIdIndex
	 */
	public Integer getRowIdIndex() {
		return rowIdIndex;
	}

	/**
	 * @param rowIdIndex
	 *            the rowIdIndex to set
	 */
	public void setRowIdIndex(int rowIdIndex) {
		this.rowIdIndex = rowIdIndex;
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
	 * @return the dimensionColumnName
	 */
	public String getDimensionColumnName() {
		return dimensionColumnName;
	}

	/**
	 * @param dimensionColumnName
	 *            the dimensionColumnName to set
	 */
	public void setDimensionColumnName(String dimensionColumnName) {
		this.dimensionColumnName = dimensionColumnName;
	}

	/**
	 * @return the dimensionMask
	 */
	public String getDimensionMask() {
		return dimensionMask;
	}

	/**
	 * @param dimensionMask
	 *            the dimensionMask to set
	 */
	public void setDimensionMask(String dimensionMask) {
		this.dimensionMask = dimensionMask;
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
	 * @return the dimensionDescriptionArabic
	 */
	public String getDimensionDescriptionArabic() {
		return dimensionDescriptionArabic;
	}

	/**
	 * @param dimensionDescriptionArabic
	 *            the dimensionDescriptionArabic to set
	 */
	public void setDimensionDescriptionArabic(String dimensionDescriptionArabic) {
		this.dimensionDescriptionArabic = dimensionDescriptionArabic;
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
	 * @return the iv40000s
	 */// bi-directional many-to-one association to Iv40000
	@OneToMany(mappedBy = "gl00102")
	public List<InventoryControlSetUp> getIv40000s() {
		return iv40000s;
	}

	/**
	 * @param iv40000s
	 *            the iv40000s to set
	 */
	public void setIv40000s(List<InventoryControlSetUp> iv40000s) {
		this.iv40000s = iv40000s;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		result = prime * result + ((dimensionColumnName == null) ? 0 : dimensionColumnName.hashCode());
		result = prime * result + ((dimensionDescription == null) ? 0 : dimensionDescription.hashCode());
		result = prime * result + ((dimensionDescriptionArabic == null) ? 0 : dimensionDescriptionArabic.hashCode());
		result = prime * result + dimensionIndex;
		result = prime * result + ((dimensionMask == null) ? 0 : dimensionMask.hashCode());
		result = prime * result + ((iv40000s == null) ? 0 : iv40000s.hashCode());
		result = prime * result + ((modifyByUserId == null) ? 0 : modifyByUserId.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((rowDateIndex == null) ? 0 : rowDateIndex.hashCode());
		result = prime * result + rowIdIndex;
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
		FinancialDimensionsTable other = (FinancialDimensionsTable) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (dimensionColumnName == null) {
			if (other.dimensionColumnName != null)
				return false;
		} else if (!dimensionColumnName.equals(other.dimensionColumnName))
			return false;
		if (dimensionDescription == null) {
			if (other.dimensionDescription != null)
				return false;
		} else if (!dimensionDescription.equals(other.dimensionDescription))
			return false;
		if (dimensionDescriptionArabic == null) {
			if (other.dimensionDescriptionArabic != null)
				return false;
		} else if (!dimensionDescriptionArabic.equals(other.dimensionDescriptionArabic))
			return false;
		if (dimensionIndex != other.dimensionIndex)
			return false;
		if (dimensionMask == null) {
			if (other.dimensionMask != null)
				return false;
		} else if (!dimensionMask.equals(other.dimensionMask))
			return false;
		if (iv40000s == null) {
			if (other.iv40000s != null)
				return false;
		} else if (!iv40000s.equals(other.iv40000s))
			return false;
		if (modifyByUserId == null) {
			if (other.modifyByUserId != null)
				return false;
		} else if (!modifyByUserId.equals(other.modifyByUserId))
			return false;
		if (modifyDate == null) {
			if (other.modifyDate != null)
				return false;
		} else if (!modifyDate.equals(other.modifyDate))
			return false;
		if (rowDateIndex == null) {
			if (other.rowDateIndex != null)
				return false;
		} else if (!rowDateIndex.equals(other.rowDateIndex))
			return false;
		if (rowIdIndex != other.rowIdIndex)
			return false;
		return true;
	}

	
}
