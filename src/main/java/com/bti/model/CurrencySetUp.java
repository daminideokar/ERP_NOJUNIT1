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
 * Description: class for the CURRENCY SETUP
 * Name of Project: BTI 
 * Created on: NOVEMBER 13, 2017 
 * Modified on: 
 * @author GoodTech 
 * Version:
 */
@Entity
@Table(name = "Mc40200")
public class CurrencySetUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CURNCYID", length = 15)
	private String currencyId;

	@Column(name = "CRNCYDSC", length = 31)
	private String currencyDescription;

	@Column(name = "CRNCYDSCA", length = 61)
	private String currencyDescriptionArabic;

	@Column(name = "CRNCYSYM", length = 3)
	private String currencySymbol;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CURRNIDX", unique = true)
	private Integer currencyIndex;

	@Column(name = "CURTEXT_1", length = 25)
	private String currencyUnit;

	@Column(name = "CURTEXT_2", length = 25)
	private String unitSubunitConnector;

	@Column(name = "CURTEXT_3", length = 25)
	private String currencySubunit;

	@Column(name = "CURTEXTA_1", length = 55)
	private String currencyUnitArabic;

	@Column(name = "CURTEXTA_2", length = 55)
	private String unitSubunitConnectorArabic;

	@Column(name = "CURTEXTA_3", length = 55)
	private String currencySubunitArabic;

	@Column(name = "DECSYMBL")
	private Short separatorsDecimal;

	@Column(name = "DEX_ROW_ID")
	private Integer rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "INCLSPAC")
	private Byte includeSpaceAfterCurrencySymbol;

	private String MC40200col;

	@Column(name = "NEGSYMBL")
	private Short negativeSymbol;

	@Column(name = "NGSMAMPC")
	private Short displayNegativeSymbolSign;

	@Column(name = "THOUSSYM")
	private Short separatorsThousands;

	@Column(name = "STATUS")
	private Boolean status;

	// bi-directional many-to-one association to Iv40401
	@JsonIgnore
	@OneToMany(mappedBy = "mc40200")
	private List<InventoryClassSetUpCurrency> iv40401s;

	public CurrencySetUp() {
	}

	/**
	 * @param currencyDescription
	 * @param currencyDescriptionArabic
	 * @param currencySymbol
	 * @param currencyIndex
	 * @param currencyUnit
	 * @param unitSubunitConnector
	 * @param currencySubunit
	 * @param currencyUnitArabic
	 * @param unitSubunitConnectorArabic
	 * @param currencySubunitArabic
	 * @param separatorsDecimal
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param includeSpaceAfterCurrencySymbol
	 * @param mC40200col
	 * @param negativeSymbol
	 * @param displayNegativeSymbolSign
	 * @param separatorsThousands
	 * @param status
	 * @param iv40401s
	 */
	public CurrencySetUp(String currencyDescription, String currencyDescriptionArabic, String currencySymbol,
			Integer currencyIndex, String currencyUnit, String unitSubunitConnector, String currencySubunit,
			String currencyUnitArabic, String unitSubunitConnectorArabic, String currencySubunitArabic,
			Short separatorsDecimal, Integer rowIdIndexing, Date rowDateIndexing, Byte includeSpaceAfterCurrencySymbol,
			String mC40200col, Short negativeSymbol, Short displayNegativeSymbolSign, Short separatorsThousands,
			Boolean status, List<InventoryClassSetUpCurrency> iv40401s) {
		super();
		this.currencyDescription = currencyDescription;
		this.currencyDescriptionArabic = currencyDescriptionArabic;
		this.currencySymbol = currencySymbol;
		this.currencyIndex = currencyIndex;
		this.currencyUnit = currencyUnit;
		this.unitSubunitConnector = unitSubunitConnector;
		this.currencySubunit = currencySubunit;
		this.currencyUnitArabic = currencyUnitArabic;
		this.unitSubunitConnectorArabic = unitSubunitConnectorArabic;
		this.currencySubunitArabic = currencySubunitArabic;
		this.separatorsDecimal = separatorsDecimal;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.includeSpaceAfterCurrencySymbol = includeSpaceAfterCurrencySymbol;
		MC40200col = mC40200col;
		this.negativeSymbol = negativeSymbol;
		this.displayNegativeSymbolSign = displayNegativeSymbolSign;
		this.separatorsThousands = separatorsThousands;
		this.status = status;
		this.iv40401s = iv40401s;
	}

	/**
	 * @param currencyId
	 * @param currencyDescription
	 * @param currencyIndex
	 */
	public CurrencySetUp(String currencyDescription) {
		super();

		this.currencyDescription = currencyDescription;

	}

	/**
	 * @param currencyId
	 * @param currencyDescription
	 * @param currencyDescriptionArabic
	 * @param currencyIndex
	 * @param status
	 */
	public CurrencySetUp(String currencyId, String currencyDescription, String currencyDescriptionArabic,
			int currencyIndex, Boolean status) {
		super();
		this.currencyId = currencyId;
		this.currencyDescription = currencyDescription;
		this.currencyDescriptionArabic = currencyDescriptionArabic;
		this.currencyIndex = currencyIndex;
		this.status = status;
	}

	/**
	 * @return the currencyId
	 */
	public String getCurrencyId() {
		return currencyId;
	}

	/**
	 * @param currencyId
	 *            the currencyId to set
	 */
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	/**
	 * @return the currencyDescription
	 */
	public String getCurrencyDescription() {
		return currencyDescription;
	}

	/**
	 * @param currencyDescription
	 *            the currencyDescription to set
	 */
	public void setCurrencyDescription(String currencyDescription) {
		this.currencyDescription = currencyDescription;
	}

	/**
	 * @return the currencyDescriptionArabic
	 */
	public String getCurrencyDescriptionArabic() {
		return currencyDescriptionArabic;
	}

	/**
	 * @param currencyDescriptionArabic
	 *            the currencyDescriptionArabic to set
	 */
	public void setCurrencyDescriptionArabic(String currencyDescriptionArabic) {
		this.currencyDescriptionArabic = currencyDescriptionArabic;
	}

	/**
	 * @return the currencySymbol
	 */
	public String getCurrencySymbol() {
		return currencySymbol;
	}

	/**
	 * @param currencySymbol
	 *            the currencySymbol to set
	 */
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	/**
	 * @return the currencyIndex
	 */
	public Integer getCurrencyIndex() {
		return currencyIndex;
	}

	/**
	 * @param currencyIndex
	 *            the currencyIndex to set
	 */
	public void setCurrencyIndex(Integer currencyIndex) {
		this.currencyIndex = currencyIndex;
	}

	/**
	 * @return the currencyUnit
	 */
	public String getCurrencyUnit() {
		return currencyUnit;
	}

	/**
	 * @param currencyUnit
	 *            the currencyUnit to set
	 */
	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	/**
	 * @return the unitSubunitConnector
	 */
	public String getUnitSubunitConnector() {
		return unitSubunitConnector;
	}

	/**
	 * @param unitSubunitConnector
	 *            the unitSubunitConnector to set
	 */
	public void setUnitSubunitConnector(String unitSubunitConnector) {
		this.unitSubunitConnector = unitSubunitConnector;
	}

	/**
	 * @return the currencySubunit
	 */
	public String getCurrencySubunit() {
		return currencySubunit;
	}

	/**
	 * @param currencySubunit
	 *            the currencySubunit to set
	 */
	public void setCurrencySubunit(String currencySubunit) {
		this.currencySubunit = currencySubunit;
	}

	/**
	 * @return the currencyUnitArabic
	 */
	public String getCurrencyUnitArabic() {
		return currencyUnitArabic;
	}

	/**
	 * @param currencyUnitArabic
	 *            the currencyUnitArabic to set
	 */
	public void setCurrencyUnitArabic(String currencyUnitArabic) {
		this.currencyUnitArabic = currencyUnitArabic;
	}

	/**
	 * @return the unitSubunitConnectorArabic
	 */
	public String getUnitSubunitConnectorArabic() {
		return unitSubunitConnectorArabic;
	}

	/**
	 * @param unitSubunitConnectorArabic
	 *            the unitSubunitConnectorArabic to set
	 */
	public void setUnitSubunitConnectorArabic(String unitSubunitConnectorArabic) {
		this.unitSubunitConnectorArabic = unitSubunitConnectorArabic;
	}

	/**
	 * @return the currencySubunitArabic
	 */
	public String getCurrencySubunitArabic() {
		return currencySubunitArabic;
	}

	/**
	 * @param currencySubunitArabic
	 *            the currencySubunitArabic to set
	 */
	public void setCurrencySubunitArabic(String currencySubunitArabic) {
		this.currencySubunitArabic = currencySubunitArabic;
	}

	/**
	 * @return the separatorsDecimal
	 */
	public Short getSeparatorsDecimal() {
		return separatorsDecimal;
	}

	/**
	 * @param separatorsDecimal
	 *            the separatorsDecimal to set
	 */
	public void setSeparatorsDecimal(Short separatorsDecimal) {
		this.separatorsDecimal = separatorsDecimal;
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
	 * @return the includeSpaceAfterCurrencySymbol
	 */
	public Byte getIncludeSpaceAfterCurrencySymbol() {
		return includeSpaceAfterCurrencySymbol;
	}

	/**
	 * @param includeSpaceAfterCurrencySymbol
	 *            the includeSpaceAfterCurrencySymbol to set
	 */
	public void setIncludeSpaceAfterCurrencySymbol(Byte includeSpaceAfterCurrencySymbol) {
		this.includeSpaceAfterCurrencySymbol = includeSpaceAfterCurrencySymbol;
	}

	/**
	 * @return the mC40200col
	 */
	public String getMC40200col() {
		return MC40200col;
	}

	/**
	 * @param mC40200col
	 *            the mC40200col to set
	 */
	public void setMC40200col(String mC40200col) {
		MC40200col = mC40200col;
	}

	/**
	 * @return the negativeSymbol
	 */
	public Short getNegativeSymbol() {
		return negativeSymbol;
	}

	/**
	 * @param negativeSymbol
	 *            the negativeSymbol to set
	 */
	public void setNegativeSymbol(short negativeSymbol) {
		this.negativeSymbol = negativeSymbol;
	}

	/**
	 * @return the displayNegativeSymbolSign
	 */
	public Short getDisplayNegativeSymbolSign() {
		return displayNegativeSymbolSign;
	}

	/**
	 * @param displayNegativeSymbolSign
	 *            the displayNegativeSymbolSign to set
	 */
	public void setDisplayNegativeSymbolSign(Short displayNegativeSymbolSign) {
		this.displayNegativeSymbolSign = displayNegativeSymbolSign;
	}

	/**
	 * @return the separatorsThousands
	 */
	public Short getSeparatorsThousands() {
		return separatorsThousands;
	}

	/**
	 * @param separatorsThousands
	 *            the separatorsThousands to set
	 */
	public void setSeparatorsThousands(Short separatorsThousands) {
		this.separatorsThousands = separatorsThousands;
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

	// bi-directional many-to-one association to Iv40401
	@OneToMany(mappedBy = "mc40200")
	public List<InventoryClassSetUpCurrency> getIv40401s() {
		return this.iv40401s;
	}

	public void setIv40401s(List<InventoryClassSetUpCurrency> iv40401s) {
		this.iv40401s = iv40401s;
	}

	public InventoryClassSetUpCurrency addIv40401(InventoryClassSetUpCurrency iv40401) {
		getIv40401s().add(iv40401);
		iv40401.setMc40200(this);

		return iv40401;
	}

	public InventoryClassSetUpCurrency removeIv40401(InventoryClassSetUpCurrency iv40401) {
		getIv40401s().remove(iv40401);
		iv40401.setMc40200(null);

		return iv40401;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final Integer prime = 31;
		int result = 1;
		result = prime * result + ((MC40200col == null) ? 0 : MC40200col.hashCode());
		result = prime * result + ((currencyDescription == null) ? 0 : currencyDescription.hashCode());
		result = prime * result + ((currencyDescriptionArabic == null) ? 0 : currencyDescriptionArabic.hashCode());
		result = prime * result + ((currencyId == null) ? 0 : currencyId.hashCode());
		result = prime * result + currencyIndex;
		result = prime * result + ((currencySubunit == null) ? 0 : currencySubunit.hashCode());
		result = prime * result + ((currencySubunitArabic == null) ? 0 : currencySubunitArabic.hashCode());
		result = prime * result + ((currencySymbol == null) ? 0 : currencySymbol.hashCode());
		result = prime * result + ((currencyUnit == null) ? 0 : currencyUnit.hashCode());
		result = prime * result + ((currencyUnitArabic == null) ? 0 : currencyUnitArabic.hashCode());
		result = prime * result + displayNegativeSymbolSign;
		result = prime * result + includeSpaceAfterCurrencySymbol;
		result = prime * result + ((iv40401s == null) ? 0 : iv40401s.hashCode());
		result = prime * result + negativeSymbol;
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + rowIdIndexing;
		result = prime * result + separatorsDecimal;
		result = prime * result + separatorsThousands;
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((unitSubunitConnector == null) ? 0 : unitSubunitConnector.hashCode());
		result = prime * result + ((unitSubunitConnectorArabic == null) ? 0 : unitSubunitConnectorArabic.hashCode());
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
		CurrencySetUp other = (CurrencySetUp) obj;
		if (MC40200col == null) {
			if (other.MC40200col != null)
				return false;
		} else if (!MC40200col.equals(other.MC40200col))
			return false;
		if (currencyDescription == null) {
			if (other.currencyDescription != null)
				return false;
		} else if (!currencyDescription.equals(other.currencyDescription))
			return false;
		if (currencyDescriptionArabic == null) {
			if (other.currencyDescriptionArabic != null)
				return false;
		} else if (!currencyDescriptionArabic.equals(other.currencyDescriptionArabic))
			return false;
		if (currencyId == null) {
			if (other.currencyId != null)
				return false;
		} else if (!currencyId.equals(other.currencyId))
			return false;
		if (currencyIndex != other.currencyIndex)
			return false;
		if (currencySubunit == null) {
			if (other.currencySubunit != null)
				return false;
		} else if (!currencySubunit.equals(other.currencySubunit))
			return false;
		if (currencySubunitArabic == null) {
			if (other.currencySubunitArabic != null)
				return false;
		} else if (!currencySubunitArabic.equals(other.currencySubunitArabic))
			return false;
		if (currencySymbol == null) {
			if (other.currencySymbol != null)
				return false;
		} else if (!currencySymbol.equals(other.currencySymbol))
			return false;
		if (currencyUnit == null) {
			if (other.currencyUnit != null)
				return false;
		} else if (!currencyUnit.equals(other.currencyUnit))
			return false;
		if (currencyUnitArabic == null) {
			if (other.currencyUnitArabic != null)
				return false;
		} else if (!currencyUnitArabic.equals(other.currencyUnitArabic))
			return false;
		if (displayNegativeSymbolSign != other.displayNegativeSymbolSign)
			return false;
		if (includeSpaceAfterCurrencySymbol != other.includeSpaceAfterCurrencySymbol)
			return false;
		if (iv40401s == null) {
			if (other.iv40401s != null)
				return false;
		} else if (!iv40401s.equals(other.iv40401s))
			return false;
		if (negativeSymbol != other.negativeSymbol)
			return false;
		if (rowDateIndexing == null) {
			if (other.rowDateIndexing != null)
				return false;
		} else if (!rowDateIndexing.equals(other.rowDateIndexing))
			return false;
		if (rowIdIndexing != other.rowIdIndexing)
			return false;
		if (separatorsDecimal != other.separatorsDecimal)
			return false;
		if (separatorsThousands != other.separatorsThousands)
			return false;
		if (status != other.status)
			return false;
		if (unitSubunitConnector == null) {
			if (other.unitSubunitConnector != null)
				return false;
		} else if (!unitSubunitConnector.equals(other.unitSubunitConnector))
			return false;
		if (unitSubunitConnectorArabic == null) {
			if (other.unitSubunitConnectorArabic != null)
				return false;
		} else if (!unitSubunitConnectorArabic.equals(other.unitSubunitConnectorArabic))
			return false;
		return true;
	}

}