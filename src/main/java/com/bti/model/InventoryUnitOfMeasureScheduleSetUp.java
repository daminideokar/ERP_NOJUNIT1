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
import java.util.List;

/**
 * Name of Project: BTI
 * Description:The persistent class for the -UNIT OF MEASURE SCHEDULE SETUP-database table. 
 * Created on: NOVEMBER 13,2017
 * Modified on:
 * 
 * @author goodtech
 */
/**
 * The persistent class for the iv40100 database table.
 * 
 */
@Entity
@Table(name="Iv40100")
//@NamedQuery(name = "InventoryUnitOfMeasureScheduleSetUp.findAll", query = "SELECT i FROM InventoryUnitOfMeasureScheduleSetUp i")
public class InventoryUnitOfMeasureScheduleSetUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UOMINX")
	private int uominx;

	@Column(name = "BAOFM", length = 10)
	private String baseUnitOfMeasure;

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

	@Column(name = "QTYDECPL")
	private Integer decimalPlacesQty;

	@Column(name = "UOMDESC", length = 31)
	private String unitOfMeasureDescription;

	@Column(name = "UOMDESCA", length = 61)
	private String unitOfMeasureDescriptionArabic;

	@Column(name = "UOMID", length = 15)
	private String unitOfMeasureId;

	@Column(name = "STATUS")
	private Boolean status;

	// bi-directional many-to-one association to Iv40101
	@JsonIgnore
	@OneToMany(mappedBy = "iv401001")
	private List<InventoryUnitOfMeasureScheduleSetUpDetails> iv40101s1;


	// bi-directional many-to-one association to Iv40400
	@JsonIgnore
	@OneToMany(mappedBy = "iv40100")
	private List<ItemClassSetUp> iv40400s;

	
	public InventoryUnitOfMeasureScheduleSetUp() {
	}

	/**
	 * @param baseUnitOfMeasure
	 * @param modifyByUserID
	 * @param createDate
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param modifyDate
	 * @param decimalPlacesQty
	 * @param unitOfMeasureDescription
	 * @param unitOfMeasureDescriptionArabic
	 * @param unitOfMeasureId
	 * @param status
	 * @param iv40101s1
	 * @param iv40101s2
	 * @param iv40400s
	 */
	public InventoryUnitOfMeasureScheduleSetUp(String baseUnitOfMeasure, String modifyByUserID, Date createDate, Integer rowIdIndexing,
			Date rowDateIndexing, Date modifyDate, Integer decimalPlacesQty, String unitOfMeasureDescription,
			String unitOfMeasureDescriptionArabic, String unitOfMeasureId, boolean status, List<InventoryUnitOfMeasureScheduleSetUpDetails> iv40101s1,
 List<ItemClassSetUp> iv40400s) {
		super();
		this.baseUnitOfMeasure = baseUnitOfMeasure;
		this.modifyByUserID = modifyByUserID;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.modifyDate = modifyDate;
		this.decimalPlacesQty = decimalPlacesQty;
		this.unitOfMeasureDescription = unitOfMeasureDescription;
		this.unitOfMeasureDescriptionArabic = unitOfMeasureDescriptionArabic;
		this.unitOfMeasureId = unitOfMeasureId;
		this.status = status;
		this.iv40101s1 = iv40101s1;
		this.iv40400s = iv40400s;
	}

	
	
	
	
	
	/**
	 * @param uominx
	 * @param baseUnitOfMeasure
	 * @param decimalPlacesQty
	 * @param unitOfMeasureDescription
	 * @param unitOfMeasureDescriptionArabic
	 * @param unitOfMeasureId
	 * @param status
	 */
	public InventoryUnitOfMeasureScheduleSetUp(int uominx, String baseUnitOfMeasure, int decimalPlacesQty,
			String unitOfMeasureDescription, String unitOfMeasureDescriptionArabic, String unitOfMeasureId,
			boolean status) {
		super();
		this.uominx = uominx;
		this.baseUnitOfMeasure = baseUnitOfMeasure;
		this.decimalPlacesQty = decimalPlacesQty;
		this.unitOfMeasureDescription = unitOfMeasureDescription;
		this.unitOfMeasureDescriptionArabic = unitOfMeasureDescriptionArabic;
		this.unitOfMeasureId = unitOfMeasureId;
		this.status = status;
	}

	/**
	 * @return the uominx
	 */
	public int getUominx() {
		return uominx;
	}

	/**
	 * @param uominx
	 *            the uominx to set
	 */
	public void setUominx(int uominx) {
		this.uominx = uominx;
	}

	/**
	 * @return the baseUnitOfMeasure
	 */
	public String getBaseUnitOfMeasure() {
		return baseUnitOfMeasure;
	}

	/**
	 * @param baseUnitOfMeasure
	 *            the baseUnitOfMeasure to set
	 */
	public void setBaseUnitOfMeasure(String baseUnitOfMeasure) {
		this.baseUnitOfMeasure = baseUnitOfMeasure;
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
	 * @return the decimalPlacesQty
	 */
	public Integer getDecimalPlacesQty() {
		return decimalPlacesQty;
	}

	/**
	 * @param decimalPlacesQty
	 *            the decimalPlacesQty to set
	 */
	public void setDecimalPlacesQty(Integer decimalPlacesQty) {
		this.decimalPlacesQty = decimalPlacesQty;
	}

	/**
	 * @return the unitOfMeasureDescription
	 */
	public String getUnitOfMeasureDescription() {
		return unitOfMeasureDescription;
	}

	/**
	 * @param unitOfMeasureDescription
	 *            the unitOfMeasureDescription to set
	 */
	public void setUnitOfMeasureDescription(String unitOfMeasureDescription) {
		this.unitOfMeasureDescription = unitOfMeasureDescription;
	}

	/**
	 * @return the unitOfMeasureDescriptionArabic
	 */
	public String getUnitOfMeasureDescriptionArabic() {
		return unitOfMeasureDescriptionArabic;
	}

	/**
	 * @param unitOfMeasureDescriptionArabic
	 *            the unitOfMeasureDescriptionArabic to set
	 */
	public void setUnitOfMeasureDescriptionArabic(String unitOfMeasureDescriptionArabic) {
		this.unitOfMeasureDescriptionArabic = unitOfMeasureDescriptionArabic;
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

	// bi-directional many-to-one association to Iv40101
	@OneToMany(mappedBy = "iv401001")
	public List<InventoryUnitOfMeasureScheduleSetUpDetails> getIv40101s1() {
		return this.iv40101s1;
	}

	public void setIv40101s1(List<InventoryUnitOfMeasureScheduleSetUpDetails> iv40101s1) {
		this.iv40101s1 = iv40101s1;
	}

	public InventoryUnitOfMeasureScheduleSetUpDetails addIv40101s1(InventoryUnitOfMeasureScheduleSetUpDetails iv40101s1) {
		getIv40101s1().add(iv40101s1);
		iv40101s1.setIv401001(this);

		return iv40101s1;
	}

	public InventoryUnitOfMeasureScheduleSetUpDetails removeIv40101s1(InventoryUnitOfMeasureScheduleSetUpDetails iv40101s1) {
		getIv40101s1().remove(iv40101s1);
		iv40101s1.setIv401001(null);

		return iv40101s1;
	}

	
	

	// bi-directional many-to-one association to Iv40400
	@OneToMany(mappedBy = "iv40100")
	public List<ItemClassSetUp> getIv40400s() {
		return this.iv40400s;
	}

	public void setIv40400s(List<ItemClassSetUp> iv40400s) {
		this.iv40400s = iv40400s;
	}

	public ItemClassSetUp addIv40400(ItemClassSetUp iv40400) {
		getIv40400s().add(iv40400);
		iv40400.setIv40100(this);

		return iv40400;
	}

	public ItemClassSetUp removeIv40400(ItemClassSetUp iv40400) {
		getIv40400s().remove(iv40400);
		iv40400.setIv40100(null);

		return iv40400;
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
		result = prime * result + ((baseUnitOfMeasure == null) ? 0 : baseUnitOfMeasure.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + decimalPlacesQty;
		result = prime * result + ((iv40101s1 == null) ? 0 : iv40101s1.hashCode());
		
		result = prime * result + ((iv40400s == null) ? 0 : iv40400s.hashCode());
		result = prime * result + ((modifyByUserID == null) ? 0 : modifyByUserID.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + rowIdIndexing;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((unitOfMeasureDescription == null) ? 0 : unitOfMeasureDescription.hashCode());
		result = prime * result
				+ ((unitOfMeasureDescriptionArabic == null) ? 0 : unitOfMeasureDescriptionArabic.hashCode());
		result = prime * result + ((unitOfMeasureId == null) ? 0 : unitOfMeasureId.hashCode());
		result = prime * result + uominx;
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
		InventoryUnitOfMeasureScheduleSetUp other = (InventoryUnitOfMeasureScheduleSetUp) obj;
		if (baseUnitOfMeasure == null) {
			if (other.baseUnitOfMeasure != null)
				return false;
		} else if (!baseUnitOfMeasure.equals(other.baseUnitOfMeasure))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (decimalPlacesQty != other.decimalPlacesQty)
			return false;
		if (iv40101s1 == null) {
			if (other.iv40101s1 != null)
				return false;
		} else if (!iv40101s1.equals(other.iv40101s1))
			return false;
	
		if (iv40400s == null) {
			if (other.iv40400s != null)
				return false;
		} else if (!iv40400s.equals(other.iv40400s))
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
		if (unitOfMeasureDescription == null) {
			if (other.unitOfMeasureDescription != null)
				return false;
		} else if (!unitOfMeasureDescription.equals(other.unitOfMeasureDescription))
			return false;
		if (unitOfMeasureDescriptionArabic == null) {
			if (other.unitOfMeasureDescriptionArabic != null)
				return false;
		} else if (!unitOfMeasureDescriptionArabic.equals(other.unitOfMeasureDescriptionArabic))
			return false;
		if (unitOfMeasureId == null) {
			if (other.unitOfMeasureId != null)
				return false;
		} else if (!unitOfMeasureId.equals(other.unitOfMeasureId))
			return false;
		if (uominx != other.uominx)
			return false;
		return true;
	}

}