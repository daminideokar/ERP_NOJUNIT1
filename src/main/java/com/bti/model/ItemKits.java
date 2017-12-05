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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description: The persistent class for the - ITEM KIT SETUP-database table. 
 * Name of Project: BTI 
 * Created on: NOVEMBER 23,2017
 * Modified on:
 * 
 * @author :GoodTech Version:
 */
@Entity
@JsonInclude(Include.NON_EMPTY)
@Table(name="Iv00104")
//@NamedQuery(name = "Iv00104.findAll", query = "SELECT i FROM ItemKits i")
public class ItemKits implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	@Column(name = "IKNX")
	private int index;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserId;

	@Column(name = "CMPITEMQTY")
	private BigDecimal componentItemQuantity;

	@Column(name = "CMPITEMSERI", length = 51)
	private String componentItemSerialNumber;

	@Column(name = "CREATDDT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "DEX_ROW_ID")
	private int rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date rowDateIndexing;

	@Column(name = "ITEMKITUOMID",length=15)
	private String itemKitUnitMeasure;

	@Column(name = "ITEMSEQN")
	private int itemNumberSequance;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@Column(name = "OPTCGS")
	private short costOfGoodsSold;

	// bi-directional many-to-one association to Iv00101
	
	@ManyToOne
	@JoinColumn(name = "ITEMNMBR",referencedColumnName="ITEMNMBR")
	private ItemMaintenance iv001011;
	
	
	@ManyToOne
	@JoinColumn(name = "ITEMKITNUM",referencedColumnName="ITEMNMBR")
	private ItemMaintenance iv001012;
	

	@Column(name = "STATUS")
	private boolean status;

	public ItemKits() {
	}

	
	
	
	/**
	 * @param modifyByUserId
	 * @param componentItemQuantity
	 * @param componentItemSerialNumber
	 * @param createDate
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param itemKitUnitMeasure
	 * @param itemNumberSequance
	 * @param modifyDate
	 * @param costOfGoodsSold
	 * @param iv001011
	 * @param iv001012
	 * @param status
	 */
	public ItemKits(String modifyByUserId, BigDecimal componentItemQuantity, String componentItemSerialNumber,
			Date createDate, int rowIdIndexing, Date rowDateIndexing, String itemKitUnitMeasure, int itemNumberSequance,
			Date modifyDate, short costOfGoodsSold, ItemMaintenance iv001011, ItemMaintenance iv001012,
			boolean status) {
		super();
		this.modifyByUserId = modifyByUserId;
		this.componentItemQuantity = componentItemQuantity;
		this.componentItemSerialNumber = componentItemSerialNumber;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.itemKitUnitMeasure = itemKitUnitMeasure;
		this.itemNumberSequance = itemNumberSequance;
		this.modifyDate = modifyDate;
		this.costOfGoodsSold = costOfGoodsSold;
		this.iv001011 = iv001011;
		this.iv001012 = iv001012;
		this.status = status;
	}




	/**
	 * @param index
	 * @param componentItemQuantity
	 * @param itemKitUnitMeasure
	 * @param iv001011
	 * @param status
	 */
	public ItemKits(int index, BigDecimal componentItemQuantity, String itemKitUnitMeasure, ItemMaintenance iv001011,
			boolean status) {
		super();
		this.index = index;
		this.componentItemQuantity = componentItemQuantity;
		this.itemKitUnitMeasure = itemKitUnitMeasure;
		this.iv001011 = iv001011;
		this.status = status;
	}




	/**
	 * @param index
	 * @param modifyByUserId
	 * @param componentItemQuantity
	 * @param componentItemSerialNumber
	 * @param createDate
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param itemKitUnitMeasure
	 * @param itemNumberSequance
	 * @param modifyDate
	 * @param costOfGoodsSold
	 * @param iv001011
	 * @param iv001012
	 * @param status
	 */
	public ItemKits(int index, String modifyByUserId, BigDecimal componentItemQuantity,
			String componentItemSerialNumber, Date createDate, int rowIdIndexing, Date rowDateIndexing,
			String itemKitUnitMeasure, int itemNumberSequance, Date modifyDate, short costOfGoodsSold,
			ItemMaintenance iv001011, ItemMaintenance iv001012, boolean status) {
		super();
		this.index = index;
		this.modifyByUserId = modifyByUserId;
		this.componentItemQuantity = componentItemQuantity;
		this.componentItemSerialNumber = componentItemSerialNumber;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.itemKitUnitMeasure = itemKitUnitMeasure;
		this.itemNumberSequance = itemNumberSequance;
		this.modifyDate = modifyDate;
		this.costOfGoodsSold = costOfGoodsSold;
		this.iv001011 = iv001011;
		this.iv001012 = iv001012;
		this.status = status;
	}




	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
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
	 * @return the componentItemQuantity
	 */
	public BigDecimal getComponentItemQuantity() {
		return componentItemQuantity;
	}

	/**
	 * @param componentItemQuantity
	 *            the componentItemQuantity to set
	 */
	public void setComponentItemQuantity(BigDecimal componentItemQuantity) {
		this.componentItemQuantity = componentItemQuantity;
	}

	/**
	 * @return the componentItemSerialNumber
	 */
	public String getComponentItemSerialNumber() {
		return componentItemSerialNumber;
	}

	/**
	 * @param componentItemSerialNumber
	 *            the componentItemSerialNumber to set
	 */
	public void setComponentItemSerialNumber(String componentItemSerialNumber) {
		this.componentItemSerialNumber = componentItemSerialNumber;
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
	 * @return the itemKitUnitMeasure
	 */
	public String getItemKitUnitMeasure() {
		return itemKitUnitMeasure;
	}

	/**
	 * @param itemKitUnitMeasure
	 *            the itemKitUnitMeasure to set
	 */
	public void setItemKitUnitMeasure(String itemKitUnitMeasure) {
		this.itemKitUnitMeasure = itemKitUnitMeasure;
	}

	/**
	 * @return the itemNumberSequance
	 */
	public int getItemNumberSequance() {
		return itemNumberSequance;
	}

	/**
	 * @param itemNumberSequance
	 *            the itemNumberSequance to set
	 */
	public void setItemNumberSequance(int itemNumberSequance) {
		this.itemNumberSequance = itemNumberSequance;
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
	 * @return the costOfGoodsSold
	 */
	public short getCostOfGoodsSold() {
		return costOfGoodsSold;
	}

	/**
	 * @param costOfGoodsSold
	 *            the costOfGoodsSold to set
	 */
	public void setCostOfGoodsSold(short costOfGoodsSold) {
		this.costOfGoodsSold = costOfGoodsSold;
	}

	/**
	 * @return the status
	 */
	public boolean getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	// bi-directional many-to-one association to Iv00101
	@ManyToOne
	@JoinColumn(name = "ITEMNMBR")
	public ItemMaintenance getIv001011() {
		return this.iv001011;
	}

	public void setIv001011(ItemMaintenance iv001011) {
		this.iv001011 = iv001011;
	}
	
	// bi-directional many-to-one association to Iv00101
		@ManyToOne
		@JoinColumn(name = "ITEMKITNUM")
		public ItemMaintenance getIv001012() {
			return this.iv001012;
		}

		public void setIv001012(ItemMaintenance iv001012) {
			this.iv001012 = iv001012;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((componentItemQuantity == null) ? 0 : componentItemQuantity.hashCode());
			result = prime * result + ((componentItemSerialNumber == null) ? 0 : componentItemSerialNumber.hashCode());
			result = prime * result + costOfGoodsSold;
			result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
			result = prime * result + index;
			result = prime * result + ((itemKitUnitMeasure == null) ? 0 : itemKitUnitMeasure.hashCode());
			result = prime * result + itemNumberSequance;
			result = prime * result + ((iv001011 == null) ? 0 : iv001011.hashCode());
			result = prime * result + ((iv001012 == null) ? 0 : iv001012.hashCode());
			result = prime * result + ((modifyByUserId == null) ? 0 : modifyByUserId.hashCode());
			result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
			result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
			result = prime * result + rowIdIndexing;
			result = prime * result + (status ? 1231 : 1237);
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
			ItemKits other = (ItemKits) obj;
			if (componentItemQuantity == null) {
				if (other.componentItemQuantity != null)
					return false;
			} else if (!componentItemQuantity.equals(other.componentItemQuantity))
				return false;
			if (componentItemSerialNumber == null) {
				if (other.componentItemSerialNumber != null)
					return false;
			} else if (!componentItemSerialNumber.equals(other.componentItemSerialNumber))
				return false;
			if (costOfGoodsSold != other.costOfGoodsSold)
				return false;
			if (createDate == null) {
				if (other.createDate != null)
					return false;
			} else if (!createDate.equals(other.createDate))
				return false;
			if (index != other.index)
				return false;
			if (itemKitUnitMeasure == null) {
				if (other.itemKitUnitMeasure != null)
					return false;
			} else if (!itemKitUnitMeasure.equals(other.itemKitUnitMeasure))
				return false;
			if (itemNumberSequance != other.itemNumberSequance)
				return false;
			if (iv001011 == null) {
				if (other.iv001011 != null)
					return false;
			} else if (!iv001011.equals(other.iv001011))
				return false;
			if (iv001012 == null) {
				if (other.iv001012 != null)
					return false;
			} else if (!iv001012.equals(other.iv001012))
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