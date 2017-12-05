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
 * Description: class for the - Item Class Account Table SetUp table. 
 * Name of Project: BTI 
 * Created on: NOVEMBER 15,2017
 * Modified on: 
 * @author :GoodTech 
 * Version:
 */
@Entity
@Table(name = "Iv40402")
//@NamedQuery(name = "ItemClassAccountTableSetup.findAll", query = "SELECT i FROM ItemClassAccountTableSetup i")
public class ItemClassAccountTableSetUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACCTTABINDX")
	private int itemClassAccountTableSetupIndex; // A New Primary Key is added

	@Column(name = "ACCTABLID")
	private Integer accountIvTableRowIndex;
	
	@Column(name = "ACCTCTTYPID")
	private Integer accountType;

	@Column(name = "ACTROWID")
	private Integer accountTableRowIndex;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserId;

	@Column(name = "CREATDDT")
	private Date createDate;

	@Column(name = "DEX_ROW_ID")
	private Integer rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@Column(name = "STATUS")
	private Boolean status;

	// bi-directional many-to-one association to Iv40400
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ITMCLSID",referencedColumnName="ITMCLSID")
	private ItemClassSetUp iv40400;

	public ItemClassAccountTableSetUp() {
	}

	public ItemClassAccountTableSetUp(Integer accountIvTableRowIndex, Integer accountType, Integer accountTableRowIndex,
			String modifyByUserId, Date createDate, Integer rowIdIndexing, Date rowDateIndexing, Date modifyDate,
			Boolean status, ItemClassSetUp iv40400) {
		super();
		this.accountIvTableRowIndex = accountIvTableRowIndex;
		this.accountType = accountType;
		this.accountTableRowIndex = accountTableRowIndex;
		this.modifyByUserId = modifyByUserId;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.modifyDate = modifyDate;
		this.status = status;
		this.iv40400 = iv40400;
	}	
	
	
	
	/**
	 * @param accttabindx
	 * @param modifyByUserId
	 * @param status
	 * @param iv40400
	 */
	public ItemClassAccountTableSetUp(int accttabindx, String modifyByUserId, Boolean status, ItemClassSetUp iv40400) {
		super();
		this.itemClassAccountTableSetupIndex = itemClassAccountTableSetupIndex;
		this.modifyByUserId = modifyByUserId;
		this.status = status;
		this.iv40400 = iv40400;
	}

	/**
	 * @return the itemClassAccountTableSetupIndex
	 */
	public int getItemClassAccountTableSetupIndex() {
		return itemClassAccountTableSetupIndex;
	}

	/**
	 * @param itemClassAccountTableSetupIndex the itemClassAccountTableSetupIndex to set
	 */
	public void setItemClassAccountTableSetupIndex(int itemClassAccountTableSetupIndex) {
		this.itemClassAccountTableSetupIndex = itemClassAccountTableSetupIndex;
	}

	public Integer getAccountIvTableRowIndex() {
		return accountIvTableRowIndex;
	}

	public void setAccountIvTableRowIndex(Integer accountIvTableRowIndex) {
		this.accountIvTableRowIndex = accountIvTableRowIndex;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Integer getAccountTableRowIndex() {
		return accountTableRowIndex;
	}

	public void setAccountTableRowIndex(Integer accountTableRowIndex) {
		this.accountTableRowIndex = accountTableRowIndex;
	}

	public String getModifyByUserId() {
		return modifyByUserId;
	}

	public void setModifyByUserId(String modifyByUserId) {
		this.modifyByUserId = modifyByUserId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountIvTableRowIndex;
		result = prime * result + accountTableRowIndex;
		result = prime * result + accountType;
		result = prime * result + itemClassAccountTableSetupIndex;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((iv40400 == null) ? 0 : iv40400.hashCode());
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
		ItemClassAccountTableSetUp other = (ItemClassAccountTableSetUp) obj;
		if (accountIvTableRowIndex != other.accountIvTableRowIndex)
			return false;
		if (accountTableRowIndex != other.accountTableRowIndex)
			return false;
		if (accountType != other.accountType)
			return false;
		if (itemClassAccountTableSetupIndex != other.itemClassAccountTableSetupIndex)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (iv40400 == null) {
			if (other.iv40400 != null)
				return false;
		} else if (!iv40400.equals(other.iv40400))
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