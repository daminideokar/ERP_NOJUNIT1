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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Description: The persistent class for the - SiteBinsSetup -database table.
 * Name of Project: BTI 
 * Created on:
 * Modified on:
 * 
 * @author :goodtech 
 * Version:
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true)
@JsonInclude(Include.NON_EMPTY)
@Table(name = "IV40201")
public class SiteBinsSetup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SITEBINSIND", length = 21)
	private int siteBinInd;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCNCODE", referencedColumnName = "LOCNCODE")
	private SiteSetup siteSetup;

	@Transient
	private String locationCode;

	@Transient
	@Column(name = "LOCNCODIND")
	private int locationIndex;

	@Column(name = "LOCBIN", length = 21)
	private String locationBinName;

	@Column(name = "LOCPHONE", length = 21)
	private String phoneNumber;

	@Column(name = "LOCFAX", length = 21)
	private String faxNumber;

	@Column(name = "LOCBINSEQ")
	private Integer locationBinSequence;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATDDT", length = 19)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFDT", length = 19)
	private Date modifyDate;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEX_ROW_TS", length = 19)
	private Date rowDateIndexing;

	@Column(name = "DEX_ROW_ID")
	private Integer rowIdIndexing;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_iv40200")
	private SiteSetup fk_iv40200;

	public SiteBinsSetup() {
		super();
	}

	public SiteBinsSetup(SiteSetup siteSetup, String locationCode, int locationIndex, String locationBinName,
			String phoneNumber, String faxNumber, Integer locationBinSequence, Date createDate, Date modifyDate,
			String modifyByUserID, Date rowDateIndexing, Integer rowIdIndexing, SiteSetup fk_iv40200) {
		super();
		this.siteSetup = siteSetup;
		this.locationCode = locationCode;
		this.locationIndex = locationIndex;
		this.locationBinName = locationBinName;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.locationBinSequence = locationBinSequence;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.modifyByUserID = modifyByUserID;
		this.rowDateIndexing = rowDateIndexing;
		this.rowIdIndexing = rowIdIndexing;
		this.fk_iv40200 = fk_iv40200;
	}

	public int getSiteBinInd() {
		return siteBinInd;
	}

	public void setSiteBinInd(int siteBinInd) {
		this.siteBinInd = siteBinInd;
	}

	public SiteSetup getSiteSetup() {
		return siteSetup;
	}

	public void setSiteSetup(SiteSetup siteSetup) {
		this.siteSetup = siteSetup;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public int getLocationIndex() {
		return locationIndex;
	}

	public void setLocationIndex(int locationIndex) {
		this.locationIndex = locationIndex;
	}

	public String getLocationBinName() {
		return locationBinName;
	}

	public void setLocationBinName(String locationBinName) {
		this.locationBinName = locationBinName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public Integer getLocationBinSequence() {
		return locationBinSequence;
	}

	public void setLocationBinSequence(Integer locationBinSequence) {
		this.locationBinSequence = locationBinSequence;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyByUserID() {
		return modifyByUserID;
	}

	public void setModifyByUserID(String modifyByUserID) {
		this.modifyByUserID = modifyByUserID;
	}

	public Date getRowDateIndexing() {
		return rowDateIndexing;
	}

	public void setRowDateIndexing(Date rowDateIndexing) {
		this.rowDateIndexing = rowDateIndexing;
	}

	public Integer getRowIdIndexing() {
		return rowIdIndexing;
	}

	public void setRowIdIndexing(Integer rowIdIndexing) {
		this.rowIdIndexing = rowIdIndexing;
	}

	public SiteSetup getFk_iv40200() {
		return fk_iv40200;
	}

	public void setFk_iv40200(SiteSetup fk_iv40200) {
		this.fk_iv40200 = fk_iv40200;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((faxNumber == null) ? 0 : faxNumber.hashCode());
		result = prime * result + ((fk_iv40200 == null) ? 0 : fk_iv40200.hashCode());
		result = prime * result + ((locationBinName == null) ? 0 : locationBinName.hashCode());
		result = prime * result + ((locationBinSequence == null) ? 0 : locationBinSequence.hashCode());
		result = prime * result + ((locationCode == null) ? 0 : locationCode.hashCode());
		result = prime * result + locationIndex;
		result = prime * result + ((modifyByUserID == null) ? 0 : modifyByUserID.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + ((rowIdIndexing == null) ? 0 : rowIdIndexing.hashCode());
		result = prime * result + siteBinInd;
		result = prime * result + ((siteSetup == null) ? 0 : siteSetup.hashCode());
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
		SiteBinsSetup other = (SiteBinsSetup) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (faxNumber == null) {
			if (other.faxNumber != null)
				return false;
		} else if (!faxNumber.equals(other.faxNumber))
			return false;
		if (fk_iv40200 == null) {
			if (other.fk_iv40200 != null)
				return false;
		} else if (!fk_iv40200.equals(other.fk_iv40200))
			return false;
		if (locationBinName == null) {
			if (other.locationBinName != null)
				return false;
		} else if (!locationBinName.equals(other.locationBinName))
			return false;
		if (locationBinSequence == null) {
			if (other.locationBinSequence != null)
				return false;
		} else if (!locationBinSequence.equals(other.locationBinSequence))
			return false;
		if (locationCode == null) {
			if (other.locationCode != null)
				return false;
		} else if (!locationCode.equals(other.locationCode))
			return false;
		if (locationIndex != other.locationIndex)
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
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
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
		if (siteBinInd != other.siteBinInd)
			return false;
		if (siteSetup == null) {
			if (other.siteSetup != null)
				return false;
		} else if (!siteSetup.equals(other.siteSetup))
			return false;
		return true;
	}
	

}