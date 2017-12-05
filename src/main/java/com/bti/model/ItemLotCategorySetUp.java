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
 * Description: The persistent class for the Item Lot Category Setup database
 * table.
 * Name of Project: BTI
 * @author Goodtech 
 * Created on: NOVEMBER 08, 2017 
 * Modified on: Version:
 */
@Entity
@Table(name = "Iv40001")
public class ItemLotCategorySetUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	@Column(name = "LOTINXD")
	private int lotItemCategoryIndex;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserID;

	@Column(name = "CREATDDT")
	private Date createdDate;

	@Column(name = "DEX_ROW_ID")
	private Integer rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "LOTATTRI1", length = 21)
	private String lotAttribute1;

	@Column(name = "LOTATTRI2", length = 21)
	private String lotAttribute2;

	@Column(name = "LOTATTRI3", length = 21)
	private String lotAttribute3;

	@Column(name = "LOTATTRI4", length = 21)
	private String lotAttribute4;

	@Column(name = "LOTATTRI5", length = 21)
	private String lotAttribute5;

	@Column(name = "LOTCATID", unique = true, nullable = false)
	private String lotItemCategoryId;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@Column(name = "STATUS")
	private Boolean status;
	
	// bi-directional many-to-one association to Iv40400
	@OneToMany(mappedBy = "iv40001")
	private List<ItemClassSetUp> iv40400s;

	public ItemLotCategorySetUp() {
	}

	/**
	 * @param modifyByUserID
	 * @param createdDate
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param lotAttribute1
	 * @param lotAttribute2
	 * @param lotAttribute3
	 * @param lotAttribute4
	 * @param lotAttribute5
	 * @param lotItemCategoryId
	 * @param modifyDate
	 * @param status
	 * @param iv40400s
	 */

	public ItemLotCategorySetUp(String modifyByUserID, Date createdDate, Integer rowIdIndexing, Date rowDateIndexing,
			String lotAttribute1, String lotAttribute2, String lotAttribute3, String lotAttribute4,
			String lotAttribute5, String lotItemCategoryId, Date modifyDate, Boolean status,
			List<ItemClassSetUp> iv40400s) {
		super();
		this.modifyByUserID = modifyByUserID;
		this.createdDate = createdDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.lotAttribute1 = lotAttribute1;
		this.lotAttribute2 = lotAttribute2;
		this.lotAttribute3 = lotAttribute3;
		this.lotAttribute4 = lotAttribute4;
		this.lotAttribute5 = lotAttribute5;
		this.lotItemCategoryId = lotItemCategoryId;
		this.modifyDate = modifyDate;
		this.status = status;
		this.iv40400s = iv40400s;
	}

	/**
	 * @param lotItemCategoryIndex
	 * @param lotAttribute1
	 * @param lotAttribute2
	 * @param lotAttribute3
	 * @param lotAttribute4
	 * @param lotAttribute5
	 * @param lotItemCategoryId
	 * @param status
	 */
	public ItemLotCategorySetUp(int lotItemCategoryIndex, String lotAttribute1, String lotAttribute2,
			String lotAttribute3, String lotAttribute4, String lotAttribute5, String lotItemCategoryId,
			Boolean status) {
		super();
		this.lotItemCategoryIndex = lotItemCategoryIndex;
		this.lotAttribute1 = lotAttribute1;
		this.lotAttribute2 = lotAttribute2;
		this.lotAttribute3 = lotAttribute3;
		this.lotAttribute4 = lotAttribute4;
		this.lotAttribute5 = lotAttribute5;
		this.lotItemCategoryId = lotItemCategoryId;
		this.status = status;
	}

	public int getLotItemCategoryIndex() {
		return lotItemCategoryIndex;
	}

	public void setLotItemCategoryIndex(int lotItemCategoryIndex) {
		this.lotItemCategoryIndex = lotItemCategoryIndex;
	}

	public String getModifyByUserID() {
		return modifyByUserID;
	}

	public void setModifyByUserID(String modifyByUserID) {
		this.modifyByUserID = modifyByUserID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public String getLotAttribute1() {
		return lotAttribute1;
	}

	public void setLotAttribute1(String lotAttribute1) {
		this.lotAttribute1 = lotAttribute1;
	}

	public String getLotAttribute2() {
		return lotAttribute2;
	}

	public void setLotAttribute2(String lotAttribute2) {
		this.lotAttribute2 = lotAttribute2;
	}

	public String getLotAttribute3() {
		return lotAttribute3;
	}

	public void setLotAttribute3(String lotAttribute3) {
		this.lotAttribute3 = lotAttribute3;
	}

	public String getLotAttribute4() {
		return lotAttribute4;
	}

	public void setLotAttribute4(String lotAttribute4) {
		this.lotAttribute4 = lotAttribute4;
	}

	public String getLotAttribute5() {
		return lotAttribute5;
	}

	public void setLotAttribute5(String lotAttribute5) {
		this.lotAttribute5 = lotAttribute5;
	}

	public String getLotItemCategoryId() {
		return lotItemCategoryId;
	}

	public void setLotItemCategoryId(String lotItemCategoryId) {
		this.lotItemCategoryId = lotItemCategoryId;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

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
	@OneToMany(mappedBy = "iv40001")
	public List<ItemClassSetUp> getIv40400s() {
		return this.iv40400s;
	}

	public void setIv40400s(List<ItemClassSetUp> iv40400s) {
		this.iv40400s = iv40400s;
	}

	public ItemClassSetUp addIv40400(ItemClassSetUp iv40400) {
		getIv40400s().add(iv40400);
		iv40400.setIv40001(this);

		return iv40400;
	}

	public ItemClassSetUp removeIv40400(ItemClassSetUp iv40400) {
		getIv40400s().remove(iv40400);
		iv40400.setIv40001(null);

		return iv40400;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((iv40400s == null) ? 0 : iv40400s.hashCode());
		result = prime * result + ((lotAttribute1 == null) ? 0 : lotAttribute1.hashCode());
		result = prime * result + ((lotAttribute2 == null) ? 0 : lotAttribute2.hashCode());
		result = prime * result + ((lotAttribute3 == null) ? 0 : lotAttribute3.hashCode());
		result = prime * result + ((lotAttribute4 == null) ? 0 : lotAttribute4.hashCode());
		result = prime * result + ((lotAttribute5 == null) ? 0 : lotAttribute5.hashCode());
		result = prime * result + ((lotItemCategoryId == null) ? 0 : lotItemCategoryId.hashCode());
		result = prime * result + lotItemCategoryIndex;
		result = prime * result + ((modifyByUserID == null) ? 0 : modifyByUserID.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
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
		ItemLotCategorySetUp other = (ItemLotCategorySetUp) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (iv40400s == null) {
			if (other.iv40400s != null)
				return false;
		} else if (!iv40400s.equals(other.iv40400s))
			return false;
		if (lotAttribute1 == null) {
			if (other.lotAttribute1 != null)
				return false;
		} else if (!lotAttribute1.equals(other.lotAttribute1))
			return false;
		if (lotAttribute2 == null) {
			if (other.lotAttribute2 != null)
				return false;
		} else if (!lotAttribute2.equals(other.lotAttribute2))
			return false;
		if (lotAttribute3 == null) {
			if (other.lotAttribute3 != null)
				return false;
		} else if (!lotAttribute3.equals(other.lotAttribute3))
			return false;
		if (lotAttribute4 == null) {
			if (other.lotAttribute4 != null)
				return false;
		} else if (!lotAttribute4.equals(other.lotAttribute4))
			return false;
		if (lotAttribute5 == null) {
			if (other.lotAttribute5 != null)
				return false;
		} else if (!lotAttribute5.equals(other.lotAttribute5))
			return false;
		if (lotItemCategoryId == null) {
			if (other.lotItemCategoryId != null)
				return false;
		} else if (!lotItemCategoryId.equals(other.lotItemCategoryId))
			return false;
		if (lotItemCategoryIndex != other.lotItemCategoryIndex)
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