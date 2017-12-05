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

/**
 * Description: The persistent class for the Price Level SetUp database table.
 * Name of Project: BTI 
 * @author Goodtech 
 * Created on: NOVEMBER 07, 2017 
 * Modified on: 
 * Version:
 */
@Entity
@Table(name = "Iv40300")
//@NamedQuery(name = "PriceLevelSetup.findAll", query = "SELECT i FROM PriceLevelSetup i")
public class PriceLevelSetUp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRCLEVLINX")
	private int priceLevelIndex;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserId;

	@Column(name = "CREATDDT")
	private Date createdDate;

	@Column(name = "DEX_ROW_ID")
	private Integer rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@Column(name = "PRCLEVLDSRC", length = 31)
	private String priceLevelDescription;

	@Column(name = "PRCLEVLDSRCA", length = 61)
	private String priceLevelDescriptionArabic;

	@Column(name = "PRCLEVLID", length = 10, unique = true)
	private String priceLevelId;

	@Column(name = "STATUS")
	private Boolean status;

	/**
	 * 
	 */
	public PriceLevelSetUp() {
		super();
	}

	/**
	 * @param modifyByUserId
	 * @param createDate
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param modifyDate
	 * @param priceLevelDescription
	 * @param priceLevelDescriptionArabic
	 * @param priceLevelId
	 * @param status
	 */
	public PriceLevelSetUp(String modifyByUserId, Date createDate, Integer rowIdIndexing, Date rowDateIndexing,
			Date modifyDate, String priceLevelDescription, String priceLevelDescriptionArabic, String priceLevelId,
			Boolean status) {
		super();
		this.modifyByUserId = modifyByUserId;
		this.createdDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.modifyDate = modifyDate;
		this.priceLevelDescription = priceLevelDescription;
		this.priceLevelDescriptionArabic = priceLevelDescriptionArabic;
		this.priceLevelId = priceLevelId;
		this.status = status;
	}

	/**
	 * @param priceLevelIndex
	 * @param priceLevelDescription
	 * @param priceLevelDescriptionArabic
	 * @param priceLevelId
	 * @param status
	 */
	public PriceLevelSetUp(int priceLevelIndex, String priceLevelDescription, String priceLevelDescriptionArabic,
			String priceLevelId, Boolean status) {
		
		super();
		this.priceLevelIndex = priceLevelIndex;
		this.priceLevelDescription = priceLevelDescription;
		this.priceLevelDescriptionArabic = priceLevelDescriptionArabic;
		this.priceLevelId = priceLevelId;
		this.status = status;
	}

	/**
	 * @return the priceLevelIndex
	 */
	public int getPriceLevelIndex() {
		return priceLevelIndex;
	}

	/**
	 * @param priceLevelIndex
	 *            the priceLevelIndex to set
	 */
	public void setPriceLevelIndex(int priceLevelIndex) {
		this.priceLevelIndex = priceLevelIndex;
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
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	

	public Integer getRowIdIndexing() {
		return rowIdIndexing;
	}

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
	 * @return the priceLevelDescription
	 */
	public String getPriceLevelDescription() {
		return priceLevelDescription;
	}

	/**
	 * @param priceLevelDescription
	 *            the priceLevelDescription to set
	 */
	public void setPriceLevelDescription(String priceLevelDescription) {
		this.priceLevelDescription = priceLevelDescription;
	}

	/**
	 * @return the priceLevelDescriptionArabic
	 */
	public String getPriceLevelDescriptionArabic() {
		return priceLevelDescriptionArabic;
	}

	/**
	 * @param priceLevelDescriptionArabic
	 *            the priceLevelDescriptionArabic to set
	 */
	public void setPriceLevelDescriptionArabic(String priceLevelDescriptionArabic) {
		this.priceLevelDescriptionArabic = priceLevelDescriptionArabic;
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

	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((modifyByUserId == null) ? 0 : modifyByUserId.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((priceLevelDescription == null) ? 0 : priceLevelDescription.hashCode());
		result = prime * result + ((priceLevelDescriptionArabic == null) ? 0 : priceLevelDescriptionArabic.hashCode());
		result = prime * result + ((priceLevelId == null) ? 0 : priceLevelId.hashCode());
		result = prime * result + priceLevelIndex;
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + ((rowIdIndexing == null) ? 0 : rowIdIndexing.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		PriceLevelSetUp other = (PriceLevelSetUp) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
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
		if (priceLevelDescription == null) {
			if (other.priceLevelDescription != null)
				return false;
		} else if (!priceLevelDescription.equals(other.priceLevelDescription))
			return false;
		if (priceLevelDescriptionArabic == null) {
			if (other.priceLevelDescriptionArabic != null)
				return false;
		} else if (!priceLevelDescriptionArabic.equals(other.priceLevelDescriptionArabic))
			return false;
		if (priceLevelId == null) {
			if (other.priceLevelId != null)
				return false;
		} else if (!priceLevelId.equals(other.priceLevelId))
			return false;
		if (priceLevelIndex != other.priceLevelIndex)
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
		return true;
	}

	

}