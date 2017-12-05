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
import java.time.LocalDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Description: The persistent class for the - PRICE GROUP SET UP-database table. 
 * Name of Project: BTI 
 * Created on:NOVEMBER 5,2017
 * Modified on:
 * 
 * @author :GoodTech Version:
 */

@Entity
@Table(name = "Iv40301")
// @NamedQuery(name="PriceGroupSetUp.findAll", query="SELECT i FROM
// PriceGroupSetUp i")
public class PriceGroupSetUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRCGRPINX")
	private int priceGroupIndex;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserID;

	@Column(name = "CREATDDT")
	private Date createDate;

	@Column(name = "DEX_ROW_ID")
	private Integer rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@Column(name = "PRCGRPDSCRA", length = 61)
	private String priceGroupDescriptionArabic;

	@Column(name = "PRCGRPDSRC", length = 31)
	private String priceGroupDescription;

	@Column(name = "PRCGRPID", length = 10)
	private String priceGroupId;

	public PriceGroupSetUp() {
	}

	/**
	 * @param priceGroupIndex
	 * @param priceGroupDescriptionArabic
	 * @param priceGroupDescription
	 * @param priceGroupId
	 */
	public PriceGroupSetUp(int priceGroupIndex, String priceGroupDescriptionArabic, String priceGroupDescription,
			String priceGroupId) {
		super();
		this.priceGroupIndex = priceGroupIndex;
		this.priceGroupDescriptionArabic = priceGroupDescriptionArabic;
		this.priceGroupDescription = priceGroupDescription;
		this.priceGroupId = priceGroupId;
	}

	/**
	 * @param modifyByUserID
	 * @param createDate
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param modifyDate
	 * @param priceGroupDescriptionArabic
	 * @param priceGroupDescription
	 * @param priceGroupId
	 */
	public PriceGroupSetUp(String modifyByUserID, Date createDate, int rowIdIndexing, Date rowDateIndexing,
			Date modifyDate, String priceGroupDescriptionArabic, String priceGroupDescription, String priceGroupId) {
		super();
		this.modifyByUserID = modifyByUserID;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.modifyDate = modifyDate;
		this.priceGroupDescriptionArabic = priceGroupDescriptionArabic;
		this.priceGroupDescription = priceGroupDescription;
		this.priceGroupId = priceGroupId;
	}

	public int getPriceGroupIndex() {
		return priceGroupIndex;
	}

	public void setPriceGroupIndex(int priceGroupIndex) {
		this.priceGroupIndex = priceGroupIndex;
	}

	public String getModifyByUserID() {
		return modifyByUserID;
	}

	public void setModifyByUserID(String modifyByUserID) {
		this.modifyByUserID = modifyByUserID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getRowIdIndexing() {
		return rowIdIndexing;
	}

	public void setRowIdIndexing(Integer rowIdIndexing) {
		this.rowIdIndexing = rowIdIndexing;
	}

	public Date getRowDateIndexing() {
		return rowDateIndexing;
	}

	public void setRowDateIndexing(Date rowDateIndexing) {
		this.rowDateIndexing = rowDateIndexing;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getPriceGroupDescriptionArabic() {
		return priceGroupDescriptionArabic;
	}

	public void setPriceGroupDescriptionArabic(String priceGroupDescriptionArabic) {
		this.priceGroupDescriptionArabic = priceGroupDescriptionArabic;
	}

	public String getPriceGroupDescription() {
		return priceGroupDescription;
	}

	public void setPriceGroupDescription(String priceGroupDescription) {
		this.priceGroupDescription = priceGroupDescription;
	}

	public String getPriceGroupId() {
		return priceGroupId;
	}

	public void setPriceGroupId(String priceGroupId) {
		this.priceGroupId = priceGroupId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((modifyByUserID == null) ? 0 : modifyByUserID.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((priceGroupDescription == null) ? 0 : priceGroupDescription.hashCode());
		result = prime * result + ((priceGroupDescriptionArabic == null) ? 0 : priceGroupDescriptionArabic.hashCode());
		result = prime * result + ((priceGroupId == null) ? 0 : priceGroupId.hashCode());
		result = prime * result + priceGroupIndex;
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + ((rowIdIndexing == null) ? 0 : rowIdIndexing.hashCode());
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
		PriceGroupSetUp other = (PriceGroupSetUp) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
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
		if (priceGroupDescription == null) {
			if (other.priceGroupDescription != null)
				return false;
		} else if (!priceGroupDescription.equals(other.priceGroupDescription))
			return false;
		if (priceGroupDescriptionArabic == null) {
			if (other.priceGroupDescriptionArabic != null)
				return false;
		} else if (!priceGroupDescriptionArabic.equals(other.priceGroupDescriptionArabic))
			return false;
		if (priceGroupId == null) {
			if (other.priceGroupId != null)
				return false;
		} else if (!priceGroupId.equals(other.priceGroupId))
			return false;
		if (priceGroupIndex != other.priceGroupIndex)
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
		return true;
	}

}