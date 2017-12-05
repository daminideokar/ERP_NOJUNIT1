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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Description: The persistent class for the - BILL OF MATERIAL SETUP-database table. 
 * Name of Project: BTI 
 * Created on: NOVEMBER 7,2017
 * Modified on:
 * 
 * @author :GoodTech Version:
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true)
@DynamicUpdate(value=true)
@JsonInclude(Include.NON_EMPTY)
@Table(name = "IV40600")

public class BillOfMaterialSetUp implements Serializable {
	@Id
	@GeneratedValue()
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NXTNMBR",unique=true)
	private int nextDocumentNumber;
	
	@Column(name = "DOCDATE")
	private short documentDate;
	
	@Column(name = "USRDEFIND1", length = 21)
	private String userDefinedField1;
	
	@Column(name = "USRDEFIND2", length = 21)
	private String userDefinedField2;
	
	@Column(name = "USRDEFIND3", length = 21)
	private String userDefinedField3;
	
	@Column(name = "USRDEFIND4", length = 21)
	private String userDefinedField4;
	
	@Column(name = "ALWOVRQTY")
	private Boolean allowOverrideonQuantityShortage;
	
	@Column(name = "ALWOLIKCOM")
	private Boolean allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATDDT", length = 19)
	private Date creatDdt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFDT", length = 19)
	private Date modifDt;

	@Column(name = "CHANGEBY", length = 15)
	private String changeBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEXROWTS", length = 19)
	private Date dexRowTs;

	@Column(name = "DEX_ROW_ID")
	private Integer dexRowId;
	
	@Column(name = "STATUS")
	private Boolean status;
	
	public BillOfMaterialSetUp() {
		super();
	}

	/**
	 * @param nextDocumentNumber
	 * @param documentDate
	 * @param userDefinedField1
	 * @param userDefinedField2
	 * @param userDefinedField3
	 * @param userDefinedField4
	 * @param allowOverrideonQuantityShortage
	 * @param allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers
	 * @param creatDdt
	 * @param modifDt
	 * @param changeBy
	 * @param dexRowTs
	 * @param dexRowId
	 * @param status
	 */
	public BillOfMaterialSetUp(int nextDocumentNumber, short documentDate, String userDefinedField1,
			String userDefinedField2, String userDefinedField3, String userDefinedField4,
			Boolean allowOverrideonQuantityShortage, Boolean allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers,
			Date creatDdt, Date modifDt, String changeBy, Date dexRowTs, Integer dexRowId, Boolean status) {
		super();
		this.nextDocumentNumber = nextDocumentNumber;
		this.documentDate = documentDate;
		this.userDefinedField1 = userDefinedField1;
		this.userDefinedField2 = userDefinedField2;
		this.userDefinedField3 = userDefinedField3;
		this.userDefinedField4 = userDefinedField4;
		this.allowOverrideonQuantityShortage = allowOverrideonQuantityShortage;
		this.allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers = allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers;
		this.creatDdt = creatDdt;
		this.modifDt = modifDt;
		this.changeBy = changeBy;
		this.dexRowTs = dexRowTs;
		this.dexRowId = dexRowId;
		this.status = status;
	}

	

	/**
	 * @param id
	 * @param nextDocumentNumber
	 * @param documentDate
	 * @param userDefinedField1
	 * @param userDefinedField2
	 * @param userDefinedField3
	 * @param userDefinedField4
	 * @param allowOverrideonQuantityShortage
	 * @param allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers
	 * @param status
	 */
	public BillOfMaterialSetUp(int id, int nextDocumentNumber, short documentDate, String userDefinedField1,
			String userDefinedField2, String userDefinedField3, String userDefinedField4,
			Boolean allowOverrideonQuantityShortage, Boolean allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers,
			Boolean status) {
		super();
		this.id = id;
		this.nextDocumentNumber = nextDocumentNumber;
		this.documentDate = documentDate;
		this.userDefinedField1 = userDefinedField1;
		this.userDefinedField2 = userDefinedField2;
		this.userDefinedField3 = userDefinedField3;
		this.userDefinedField4 = userDefinedField4;
		this.allowOverrideonQuantityShortage = allowOverrideonQuantityShortage;
		this.allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers = allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nextDocumentNumber
	 */
	public int getNextDocumentNumber() {
		return nextDocumentNumber;
	}

	/**
	 * @param nextDocumentNumber the nextDocumentNumber to set
	 */
	public void setNextDocumentNumber(int nextDocumentNumber) {
		this.nextDocumentNumber = nextDocumentNumber;
	}

	/**
	 * @return the documentDate
	 */
	public short getDocumentDate() {
		return documentDate;
	}

	/**
	 * @param documentDate the documentDate to set
	 */
	public void setDocumentDate(short documentDate) {
		this.documentDate = documentDate;
	}

	/**
	 * @return the userDefinedField1
	 */
	public String getUserDefinedField1() {
		return userDefinedField1;
	}

	/**
	 * @param userDefinedField1 the userDefinedField1 to set
	 */
	public void setUserDefinedField1(String userDefinedField1) {
		this.userDefinedField1 = userDefinedField1;
	}

	/**
	 * @return the userDefinedField2
	 */
	public String getUserDefinedField2() {
		return userDefinedField2;
	}

	/**
	 * @param userDefinedField2 the userDefinedField2 to set
	 */
	public void setUserDefinedField2(String userDefinedField2) {
		this.userDefinedField2 = userDefinedField2;
	}

	/**
	 * @return the userDefinedField3
	 */
	public String getUserDefinedField3() {
		return userDefinedField3;
	}

	/**
	 * @param userDefinedField3 the userDefinedField3 to set
	 */
	public void setUserDefinedField3(String userDefinedField3) {
		this.userDefinedField3 = userDefinedField3;
	}

	/**
	 * @return the userDefinedField4
	 */
	public String getUserDefinedField4() {
		return userDefinedField4;
	}

	/**
	 * @param userDefinedField4 the userDefinedField4 to set
	 */
	public void setUserDefinedField4(String userDefinedField4) {
		this.userDefinedField4 = userDefinedField4;
	}

	/**
	 * @return the allowOverrideonQuantityShortage
	 */
	public Boolean getAllowOverrideonQuantityShortage() {
		return allowOverrideonQuantityShortage;
	}

	/**
	 * @param allowOverrideonQuantityShortage the allowOverrideonQuantityShortage to set
	 */
	public void setAllowOverrideonQuantityShortage(Boolean allowOverrideonQuantityShortage) {
		this.allowOverrideonQuantityShortage = allowOverrideonQuantityShortage;
	}

	/**
	 * @return the allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers
	 */
	public Boolean getAllowLinkingOfComponentandFinishedGoodSerialAndLotNumbers() {
		return allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers;
	}

	/**
	 * @param allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers the allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers to set
	 */
	public void setAllowLinkingOfComponentandFinishedGoodSerialAndLotNumbers(
			Boolean allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers) {
		this.allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers = allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers;
	}

	/**
	 * @return the creatDdt
	 */
	public Date getCreatDdt() {
		return creatDdt;
	}

	/**
	 * @param creatDdt the creatDdt to set
	 */
	public void setCreatDdt(Date creatDdt) {
		this.creatDdt = creatDdt;
	}

	/**
	 * @return the modifDt
	 */
	public Date getModifDt() {
		return modifDt;
	}

	/**
	 * @param modifDt the modifDt to set
	 */
	public void setModifDt(Date modifDt) {
		this.modifDt = modifDt;
	}

	/**
	 * @return the changeBy
	 */
	public String getChangeBy() {
		return changeBy;
	}

	/**
	 * @param changeBy the changeBy to set
	 */
	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	/**
	 * @return the dexRowTs
	 */
	public Date getDexRowTs() {
		return dexRowTs;
	}

	/**
	 * @param dexRowTs the dexRowTs to set
	 */
	public void setDexRowTs(Date dexRowTs) {
		this.dexRowTs = dexRowTs;
	}

	/**
	 * @return the dexRowId
	 */
	public Integer getDexRowId() {
		return dexRowId;
	}

	/**
	 * @param dexRowId the dexRowId to set
	 */
	public void setDexRowId(Integer dexRowId) {
		this.dexRowId = dexRowId;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers == null) ? 0
				: allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers.hashCode());
		result = prime * result
				+ ((allowOverrideonQuantityShortage == null) ? 0 : allowOverrideonQuantityShortage.hashCode());
		result = prime * result + ((changeBy == null) ? 0 : changeBy.hashCode());
		result = prime * result + ((creatDdt == null) ? 0 : creatDdt.hashCode());
		result = prime * result + ((dexRowId == null) ? 0 : dexRowId.hashCode());
		result = prime * result + ((dexRowTs == null) ? 0 : dexRowTs.hashCode());
		result = prime * result + documentDate;
		result = prime * result + id;
		result = prime * result + ((modifDt == null) ? 0 : modifDt.hashCode());
		result = prime * result + nextDocumentNumber;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userDefinedField1 == null) ? 0 : userDefinedField1.hashCode());
		result = prime * result + ((userDefinedField2 == null) ? 0 : userDefinedField2.hashCode());
		result = prime * result + ((userDefinedField3 == null) ? 0 : userDefinedField3.hashCode());
		result = prime * result + ((userDefinedField4 == null) ? 0 : userDefinedField4.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		BillOfMaterialSetUp other = (BillOfMaterialSetUp) obj;
		if (allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers == null) {
			if (other.allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers != null)
				return false;
		} else if (!allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers
				.equals(other.allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers))
			return false;
		if (allowOverrideonQuantityShortage == null) {
			if (other.allowOverrideonQuantityShortage != null)
				return false;
		} else if (!allowOverrideonQuantityShortage.equals(other.allowOverrideonQuantityShortage))
			return false;
		if (changeBy == null) {
			if (other.changeBy != null)
				return false;
		} else if (!changeBy.equals(other.changeBy))
			return false;
		if (creatDdt == null) {
			if (other.creatDdt != null)
				return false;
		} else if (!creatDdt.equals(other.creatDdt))
			return false;
		if (dexRowId == null) {
			if (other.dexRowId != null)
				return false;
		} else if (!dexRowId.equals(other.dexRowId))
			return false;
		if (dexRowTs == null) {
			if (other.dexRowTs != null)
				return false;
		} else if (!dexRowTs.equals(other.dexRowTs))
			return false;
		if (documentDate != other.documentDate)
			return false;
		if (id != other.id)
			return false;
		if (modifDt == null) {
			if (other.modifDt != null)
				return false;
		} else if (!modifDt.equals(other.modifDt))
			return false;
		if (nextDocumentNumber != other.nextDocumentNumber)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userDefinedField1 == null) {
			if (other.userDefinedField1 != null)
				return false;
		} else if (!userDefinedField1.equals(other.userDefinedField1))
			return false;
		if (userDefinedField2 == null) {
			if (other.userDefinedField2 != null)
				return false;
		} else if (!userDefinedField2.equals(other.userDefinedField2))
			return false;
		if (userDefinedField3 == null) {
			if (other.userDefinedField3 != null)
				return false;
		} else if (!userDefinedField3.equals(other.userDefinedField3))
			return false;
		if (userDefinedField4 == null) {
			if (other.userDefinedField4 != null)
				return false;
		} else if (!userDefinedField4.equals(other.userDefinedField4))
			return false;
		return true;
	}

	

	
}
