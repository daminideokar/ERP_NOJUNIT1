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
 * Description: The persistent class for the - ACCOUNT TYPE SETUP-database table. 
 * Name of Project: BTI 
 * Created on: NOVEMBER 10,2017
 * Modified on:
 * 
 * @author :GoodTech Version:
 */

@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true)
@DynamicUpdate(value = true)
@JsonInclude(Include.NON_EMPTY)
@Table(name = "IV40403")
public class AccountTypeSetUp implements Serializable {

	
    
	@Id
	@GeneratedValue()
	@Column(name = "ACTYPCD")
	private int accountTypeCode;

	@Column(name = "ACTYP", length = 30)
	private String accountType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATDDT", length = 19)
	private Date createDate;

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

	/**
	 * 
	 */
	public AccountTypeSetUp() {
		super();
	}

	/**
	 * @param accountTypeCode
	 * @param accountType
	 * @param createDate
	 * @param modifDt
	 * @param changeBy
	 * @param dexRowTs
	 * @param dexRowId
	 * @param status
	 */
	public AccountTypeSetUp(int accountTypeCode, String accountType, Date createDate, Date modifDt, String changeBy,
			Date dexRowTs, Integer dexRowId, Boolean status) {
		super();
		this.accountTypeCode = accountTypeCode;
		this.accountType = accountType;
		this.createDate = createDate;
		this.modifDt = modifDt;
		this.changeBy = changeBy;
		this.dexRowTs = dexRowTs;
		this.dexRowId = dexRowId;
		this.status = status;
	}

	/**
	 * @param accountTypeCode
	 * @param accountType
	 * @param status
	 */
	public AccountTypeSetUp(int accountTypeCode, String accountType, Boolean status) {
		super();
		this.accountTypeCode = accountTypeCode;
		this.accountType = accountType;
		this.status = status;
	}

	/**
	 * @return the accountTypeCode
	 */
	public int getAccountTypeCode() {
		return accountTypeCode;
	}

	/**
	 * @param accountTypeCode the accountTypeCode to set
	 */
	public void setAccountTypeCode(int accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + accountTypeCode;
		result = prime * result + ((changeBy == null) ? 0 : changeBy.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((dexRowId == null) ? 0 : dexRowId.hashCode());
		result = prime * result + ((dexRowTs == null) ? 0 : dexRowTs.hashCode());
		result = prime * result + ((modifDt == null) ? 0 : modifDt.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		AccountTypeSetUp other = (AccountTypeSetUp) obj;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (accountTypeCode != other.accountTypeCode)
			return false;
		if (changeBy == null) {
			if (other.changeBy != null)
				return false;
		} else if (!changeBy.equals(other.changeBy))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
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
		if (modifDt == null) {
			if (other.modifDt != null)
				return false;
		} else if (!modifDt.equals(other.modifDt))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	
	
}
