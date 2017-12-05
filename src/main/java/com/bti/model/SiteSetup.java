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
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.DynamicUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Name of Project: BTI 
 * Description: The persistent class for the SiteSetup database table.
 * Created on: OCTOMBER 23, 2017
 * Modified on:
 * @author goodtech
 * version :
 */
@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true)
@JsonInclude(Include.NON_EMPTY)
@DynamicUpdate(value = true)
@Table(name = "IV40200")
public class SiteSetup implements Serializable {

	@Id
	@GeneratedValue()
	@Column(name = "LOCNCODIND", length = 31)
	private int locationIndex;

	@Column(name = "LOCNCODE", length = 7, unique = true)
	private String locationId;

	@Column(name = "LOCDSCR", length = 31)
	private String locationDescription;

	@Column(name = "LOCDSCRA", length = 61)
	private String locationDescriptionArabic;

	@Column(name = "LOCADDRESS", length = 120)
	private String locationAddress;

	@Column(name = "LOCADRESSA", length = 120)
	private String locationAddressArabic;

	@Column(name = "LOCCITY", length = 21)
	private String city;

	@Column(name = "LOCCONTRY", length = 31)
	private String country;

	@Column(name = "LOCPHONE", length = 21)
	private String phoneNumber;

	@Column(name = "LOCFAX", length = 21)
	private String faxNumber;

	@Column(name = "DIMINXVALUE")
	private Integer dimensionIndexValueFinanceSegmentValue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATDDT", length = 19)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFDT", length = 19)
	private Date modifyDate;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEX_ROW_TS", length = 19)
	private Date rowDateIndexing;

	@Column(name = "DEX_ROW_ID")
	private Integer rowIdIndexing;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fk_iv40200", cascade = CascadeType.ALL)
	private Set<SiteBinsSetup> siteBinsSetup;

	public SiteSetup() {
		super();
	}

	public SiteSetup(String locationId, String locationDescription, String locationDescriptionArabic,
			String locationAddress, String locationAddressArabic, String city, String country, String phoneNumber,
			String faxNumber, Integer dimensionIndexValueFinanceSegmentValue, Date createDate, Date modifyDate,
			String modifyByUserId, Date rowDateIndexing, Integer rowIdIndexing, Set<SiteBinsSetup> siteBinsSetup) {
		super();
		this.locationId = locationId;
		this.locationDescription = locationDescription;
		this.locationDescriptionArabic = locationDescriptionArabic;
		this.locationAddress = locationAddress;
		this.locationAddressArabic = locationAddressArabic;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.dimensionIndexValueFinanceSegmentValue = dimensionIndexValueFinanceSegmentValue;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.modifyByUserId = modifyByUserId;
		this.rowDateIndexing = rowDateIndexing;
		this.rowIdIndexing = rowIdIndexing;
		this.siteBinsSetup = siteBinsSetup;
	}

	public int getLocationIndex() {
		return locationIndex;
	}

	public void setLocationIndex(int locationIndex) {
		this.locationIndex = locationIndex;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getLocationDescriptionArabic() {
		return locationDescriptionArabic;
	}

	public void setLocationDescriptionArabic(String locationDescriptionArabic) {
		this.locationDescriptionArabic = locationDescriptionArabic;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public String getLocationAddressArabic() {
		return locationAddressArabic;
	}

	public void setLocationAddressArabic(String locationAddressArabic) {
		this.locationAddressArabic = locationAddressArabic;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public Integer getDimensionIndexValueFinanceSegmentValue() {
		return dimensionIndexValueFinanceSegmentValue;
	}

	public void setDimensionIndexValueFinanceSegmentValue(Integer dimensionIndexValueFinanceSegmentValue) {
		this.dimensionIndexValueFinanceSegmentValue = dimensionIndexValueFinanceSegmentValue;
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

	public String getModifyByUserId() {
		return modifyByUserId;
	}

	public void setModifyByUserId(String modifyByUserId) {
		this.modifyByUserId = modifyByUserId;
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

	public Set<SiteBinsSetup> getSiteBinsSetup() {
		return siteBinsSetup;
	}

	public void setSiteBinsSetup(Set<SiteBinsSetup> siteBinsSetup) {
		this.siteBinsSetup = siteBinsSetup;
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((dimensionIndexValueFinanceSegmentValue == null) ? 0
				: dimensionIndexValueFinanceSegmentValue.hashCode());
		result = prime * result + ((faxNumber == null) ? 0 : faxNumber.hashCode());
		result = prime * result + ((locationAddress == null) ? 0 : locationAddress.hashCode());
		result = prime * result + ((locationAddressArabic == null) ? 0 : locationAddressArabic.hashCode());
		result = prime * result + ((locationDescription == null) ? 0 : locationDescription.hashCode());
		result = prime * result + ((locationDescriptionArabic == null) ? 0 : locationDescriptionArabic.hashCode());
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		result = prime * result + locationIndex;
		result = prime * result + ((modifyByUserId == null) ? 0 : modifyByUserId.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + ((rowIdIndexing == null) ? 0 : rowIdIndexing.hashCode());
		result = prime * result + ((siteBinsSetup == null) ? 0 : siteBinsSetup.hashCode());
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
		SiteSetup other = (SiteSetup) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (dimensionIndexValueFinanceSegmentValue == null) {
			if (other.dimensionIndexValueFinanceSegmentValue != null)
				return false;
		} else if (!dimensionIndexValueFinanceSegmentValue.equals(other.dimensionIndexValueFinanceSegmentValue))
			return false;
		if (faxNumber == null) {
			if (other.faxNumber != null)
				return false;
		} else if (!faxNumber.equals(other.faxNumber))
			return false;
		if (locationAddress == null) {
			if (other.locationAddress != null)
				return false;
		} else if (!locationAddress.equals(other.locationAddress))
			return false;
		if (locationAddressArabic == null) {
			if (other.locationAddressArabic != null)
				return false;
		} else if (!locationAddressArabic.equals(other.locationAddressArabic))
			return false;
		if (locationDescription == null) {
			if (other.locationDescription != null)
				return false;
		} else if (!locationDescription.equals(other.locationDescription))
			return false;
		if (locationDescriptionArabic == null) {
			if (other.locationDescriptionArabic != null)
				return false;
		} else if (!locationDescriptionArabic.equals(other.locationDescriptionArabic))
			return false;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		if (locationIndex != other.locationIndex)
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
		if (siteBinsSetup == null) {
			if (other.siteBinsSetup != null)
				return false;
		} else if (!siteBinsSetup.equals(other.siteBinsSetup))
			return false;
		return true;
	}

}
