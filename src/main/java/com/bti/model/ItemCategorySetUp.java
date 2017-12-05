
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
 * Description: The persistent class for the ItemCategorySetup database table.
 * Name of Project: BTI
 * Created on: NOVEMBER 8, 2017
 * Modified on: 
 * @author goodtech
 * Version: 
 */
@Entity
@Table(name = "Iv40002")
//@NamedQuery(name = "ItemCategorySetup.findAll", query = "SELECT i FROM ItemCategorySetUp i")
public class ItemCategorySetUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEMCATID")
	private int itemCategoryIndex;

	@Column(name = "CHANGEBY", length = 15)
	private String modifybyUserId;

	@Column(name = "CREATDDT")
	private Date createDate;

	@Column(name = "DEX_ROW_ID")
	private int rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@Column(name = "USCATIV", length = 15)
	private String itemCategory;

	@Column(name = "USCATVALDSCR", length = 61)
	private String itemCategoryValueDescription;

	@Column(name = "USCATVALDSCRA", length = 120)
	private String itemCategoryValueDescriptionArabic;

	@Column(name = "USCATVALE", length = 31)
	private String itemCategoryValue;

	@Column(name = "STATUS")
	private Boolean status;

	public ItemCategorySetUp() {

	}

	public ItemCategorySetUp(String modifybyUserId, Date createDate, int rowIdIndexing, Date rowDateIndexing,
			Date modifyDate, String itemCategory, String itemCategoryValueDescription,
			String itemCategoryValueDescriptionArabic, Boolean status, String itemCategoryValue) {
		super();

		this.modifybyUserId = modifybyUserId;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.modifyDate = modifyDate;
		this.itemCategory = itemCategory;
		this.itemCategoryValueDescription = itemCategoryValueDescription;
		this.itemCategoryValueDescriptionArabic = itemCategoryValueDescriptionArabic;
		this.status = status;
		this.itemCategoryValue = itemCategoryValue;
	}

	public ItemCategorySetUp(int itemCategoryIndex, String itemCategory, String itemCategoryValueDescription,
			String itemCategoryValueDescriptionArabic, Boolean status, String itemCategoryValue) {
		super();
		this.itemCategoryIndex = itemCategoryIndex;
		this.itemCategory = itemCategory;
		this.itemCategoryValueDescription = itemCategoryValueDescription;
		this.itemCategoryValueDescriptionArabic = itemCategoryValueDescriptionArabic;
		this.status = status;
		this.itemCategoryValue = itemCategoryValue;
	}

	public int getItemCategoryIndex() {
		return itemCategoryIndex;
	}

	public void setItemCategoryIndex(int itemCategoryIndex) {
		this.itemCategoryIndex = itemCategoryIndex;
	}

	public String getModifybyUserId() {
		return modifybyUserId;
	}

	public void setModifybyUserId(String modifybyUserId) {
		this.modifybyUserId = modifybyUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getRowIdIndexing() {
		return rowIdIndexing;
	}

	public void setRowIdIndexing(int rowIdIndexing) {
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

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemCategoryValueDescription() {
		return itemCategoryValueDescription;
	}

	public void setItemCategoryValueDescription(String itemCategoryValueDescription) {
		this.itemCategoryValueDescription = itemCategoryValueDescription;
	}

	public String getItemCategoryValueDescriptionArabic() {
		return itemCategoryValueDescriptionArabic;
	}

	public void setItemCategoryValueDescriptionArabic(String itemCategoryValueDescriptionArabic) {
		this.itemCategoryValueDescriptionArabic = itemCategoryValueDescriptionArabic;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getItemCategoryValue() {
		return itemCategoryValue;
	}

	public void setItemCategoryValue(String itemCategoryValue) {
		this.itemCategoryValue = itemCategoryValue;
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
		result = prime * result + ((itemCategory == null) ? 0 : itemCategory.hashCode());
		result = prime * result + itemCategoryIndex;
		result = prime * result + ((itemCategoryValue == null) ? 0 : itemCategoryValue.hashCode());
		result = prime * result
				+ ((itemCategoryValueDescription == null) ? 0 : itemCategoryValueDescription.hashCode());
		result = prime * result
				+ ((itemCategoryValueDescriptionArabic == null) ? 0 : itemCategoryValueDescriptionArabic.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((modifybyUserId == null) ? 0 : modifybyUserId.hashCode());
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
		ItemCategorySetUp other = (ItemCategorySetUp) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (itemCategory == null) {
			if (other.itemCategory != null)
				return false;
		} else if (!itemCategory.equals(other.itemCategory))
			return false;
		if (itemCategoryIndex != other.itemCategoryIndex)
			return false;
		if (itemCategoryValue == null) {
			if (other.itemCategoryValue != null)
				return false;
		} else if (!itemCategoryValue.equals(other.itemCategoryValue))
			return false;
		if (itemCategoryValueDescription == null) {
			if (other.itemCategoryValueDescription != null)
				return false;
		} else if (!itemCategoryValueDescription.equals(other.itemCategoryValueDescription))
			return false;
		if (itemCategoryValueDescriptionArabic == null) {
			if (other.itemCategoryValueDescriptionArabic != null)
				return false;
		} else if (!itemCategoryValueDescriptionArabic.equals(other.itemCategoryValueDescriptionArabic))
			return false;
		if (modifyDate == null) {
			if (other.modifyDate != null)
				return false;
		} else if (!modifyDate.equals(other.modifyDate))
			return false;
		if (modifybyUserId == null) {
			if (other.modifybyUserId != null)
				return false;
		} else if (!modifybyUserId.equals(other.modifybyUserId))
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