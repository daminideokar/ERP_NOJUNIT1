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

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Description: class for the -	ITEM CLASS SETUP - database table. 
 * Name of Project: BTI 
 * Created on: NOVEMBER 7, 2017
 * Modified on: 
 * @author :GoodTech 
 * Version:
 */

@Entity
@Table(name = "Iv40400")
//@NamedQuery(name = "ItemClassSetUp.findAll", query = "SELECT i FROM ItemClassSetUp i")
public class ItemClassSetUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITMCLSINDX")
	private int itemClassIndex;

	@Column(name = "ACCTABLID")
	private Integer accountTableRowIndex;

	@Column(name = "ALLBAKORD")
	private Byte allowBackOrders;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserId;

	@Column(name = "CREATDDT")
	private Date createDate;

	@Column(name = "DEX_ROW_ID", length = 15)
	private Integer rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "ITMCLSDSC", length = 51)
	private String itemClassDescription;

	@Column(name = "ITMCLSDSCA", length = 61)
	private String itemClassDescriptionArabic;

	@Column(name = "ITMCLSID", length = 10)
	private String itemClassId;

	@Column(name = "ITMGENDSC", length = 31)
	private String itemGenericDescription;

	@Column(name = "ITMGENDSCA", length = 61)
	private String itemGenericDescriptionArabic;

	@Column(name = "ITMTYPE")
	private Short itemType;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@Column(name = "NOFDAYS")
	private Integer warningNumberOfDays;

	@Column(name = "PRCMETHD")
	private Short priceMethod;

	@Column(name = "QTYDCML")
	private Integer quantityDecimals;

	@Column(name = "REVINVCOT")
	private Byte revalueInventoryForCostVariance;

	/*@Column(name = "TAXSCHDIDP", length = 15)
	private String taxScheduleIdForPurchase;

	@Column(name = "TAXSCHDIDS", length = 15)
	private String taxScheduleIdForSales;*/

	@Column(name = "TOTPERCNT")
	private BigDecimal tolerancePercentage;

	@Column(name = "TRAKVAL")
	private Short track;

	@Column(name = "USCATIV1", length = 15)
	private String userCategoryName1;

	@Column(name = "USCATIV2", length = 15)
	private String userCategoryName2;

	@Column(name = "USCATIV3", length = 15)
	private String userCategoryName3;

	@Column(name = "USCATIV4", length = 15)
	private String userCategoryName4;

	@Column(name = "USCATIV5", length = 15)
	private String userCategoryName5;

	@Column(name = "USCATIV6", length = 15)
	private String userCategoryName6;

	@Column(name = "valmethd")
	private Short valuationMethod;

	@Column(name = "WARNVAL")
	private Byte warningFeature;

	@Column(name = "STATUS")
	private Boolean status;

	// bi-directional many-to-one association to Iv40001
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "LOTCATID", referencedColumnName = "LOTCATID")
	private ItemLotCategorySetUp iv40001;

	// bi-directional many-to-one association to Iv40100
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "UOMID", referencedColumnName = "UOMID")
	private InventoryUnitOfMeasureScheduleSetUp iv40100;

	// bi-directional many-to-one association to Iv40300
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PRCLEVLID", referencedColumnName = "PRCLEVLID")
	private PriceLevelSetUp iv40300;

	// bi-directional many-to-one association to Iv40301
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PRCGRPID", referencedColumnName = "PRCGRPID")
	private PriceGroupSetUp iv40301;

	// bi-directional many-to-one association to Iv40401
	@OneToMany(mappedBy = "iv40400")
	private List<InventoryClassSetUpCurrency> iv40401s;

	// bi-directional many-to-one association to Iv40402
	@OneToMany(mappedBy = "iv40400")
	private List<ItemClassAccountTableSetUp> iv40402s;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "TAXSCHDIDP", referencedColumnName = "TAXSCHDID")
	private VatSetUp SY03600P;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "TAXSCHDIDS", referencedColumnName = "TAXSCHDID")
	private VatSetUp SY03600S;


	public ItemClassSetUp() {
	}

	
	/**
	 * @param accountTableRowIndex
	 * @param allowBackOrders
	 * @param modifyByUserId
	 * @param createDate
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param itemClassDescription
	 * @param itemClassDescriptionArabic
	 * @param itemClassId
	 * @param itemGenericDescription
	 * @param itemGenericDescriptionArabic
	 * @param itemType
	 * @param modifyDate
	 * @param warningNumberOfDays
	 * @param priceMethod
	 * @param quantityDecimals
	 * @param revalueInventoryForCostVariance
	 * @param tolerancePercentage
	 * @param track
	 * @param userCategoryName1
	 * @param userCategoryName2
	 * @param userCategoryName3
	 * @param userCategoryName4
	 * @param userCategoryName5
	 * @param userCategoryName6
	 * @param valuationMethod
	 * @param warningFeature
	 * @param status
	 * @param iv40001
	 * @param iv40100
	 * @param iv40300
	 * @param iv40301
	 * @param iv40401s
	 * @param iv40402s
	 
	 */
	public ItemClassSetUp(int accountTableRowIndex, Byte allowBackOrders, String modifyByUserId, Date createDate,
			Integer rowIdIndexing, Date rowDateIndexing, String itemClassDescription, String itemClassDescriptionArabic,
			String itemClassId, String itemGenericDescription, String itemGenericDescriptionArabic, Short itemType,
			Date modifyDate, Integer warningNumberOfDays, Short priceMethod, Integer quantityDecimals,
			Byte revalueInventoryForCostVariance, BigDecimal tolerancePercentage, Short track, String userCategoryName1,
			String userCategoryName2, String userCategoryName3, String userCategoryName4, String userCategoryName5,
			String userCategoryName6, Short valuationMethod, Byte warningFeature, Boolean status,
			ItemLotCategorySetUp iv40001, InventoryUnitOfMeasureScheduleSetUp iv40100, PriceLevelSetUp iv40300,
			PriceGroupSetUp iv40301, List<InventoryClassSetUpCurrency> iv40401s,
			List<ItemClassAccountTableSetUp> iv40402s) {
		super();
		this.accountTableRowIndex = accountTableRowIndex;
		this.allowBackOrders = allowBackOrders;
		this.modifyByUserId = modifyByUserId;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.itemClassDescription = itemClassDescription;
		this.itemClassDescriptionArabic = itemClassDescriptionArabic;
		this.itemClassId = itemClassId;
		this.itemGenericDescription = itemGenericDescription;
		this.itemGenericDescriptionArabic = itemGenericDescriptionArabic;
		this.itemType = itemType;
		this.modifyDate = modifyDate;
		this.warningNumberOfDays = warningNumberOfDays;
		this.priceMethod = priceMethod;
		this.quantityDecimals = quantityDecimals;
		this.revalueInventoryForCostVariance = revalueInventoryForCostVariance;
		this.tolerancePercentage = tolerancePercentage;
		this.track = track;
		this.userCategoryName1 = userCategoryName1;
		this.userCategoryName2 = userCategoryName2;
		this.userCategoryName3 = userCategoryName3;
		this.userCategoryName4 = userCategoryName4;
		this.userCategoryName5 = userCategoryName5;
		this.userCategoryName6 = userCategoryName6;
		this.valuationMethod = valuationMethod;
		this.warningFeature = warningFeature;
		this.status = status;
		this.iv40001 = iv40001;
		this.iv40100 = iv40100;
		this.iv40300 = iv40300;
		this.iv40301 = iv40301;
		this.iv40401s = iv40401s;
		this.iv40402s = iv40402s;
		
	}

	
	public ItemClassSetUp(int itemClassIndex, Integer accountTableRowIndex, 
			Byte allowBackOrders, String modifyByUserId,
			Date createDate, Integer rowIdIndexing, Date rowDateIndexing, String itemClassDescription,
			String itemClassDescriptionArabic, String itemClassId, String itemGenericDescription,
			String itemGenericDescriptionArabic, Short itemType, Date modifyDate, Integer warningNumberOfDays,
			Short priceMethod, Integer quantityDecimals, Byte revalueInventoryForCostVariance,
			BigDecimal tolerancePercentage, Short track, String userCategoryName1, String userCategoryName2,
			String userCategoryName3, String userCategoryName4, String userCategoryName5, String userCategoryName6,
			Short valuationMethod, Byte warningFeature, Boolean status, ItemLotCategorySetUp iv40001,
			InventoryUnitOfMeasureScheduleSetUp iv40100, PriceLevelSetUp iv40300, PriceGroupSetUp iv40301,
			List<InventoryClassSetUpCurrency> iv40401s, List<ItemClassAccountTableSetUp> iv40402s) {
		super();
		this.itemClassIndex = itemClassIndex;
		this.accountTableRowIndex = accountTableRowIndex;
		this.allowBackOrders = allowBackOrders;
		this.modifyByUserId = modifyByUserId;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.itemClassDescription = itemClassDescription;
		this.itemClassDescriptionArabic = itemClassDescriptionArabic;
		this.itemClassId = itemClassId;
		this.itemGenericDescription = itemGenericDescription;
		this.itemGenericDescriptionArabic = itemGenericDescriptionArabic;
		this.itemType = itemType;
		this.modifyDate = modifyDate;
		this.warningNumberOfDays = warningNumberOfDays;
		this.priceMethod = priceMethod;
		this.quantityDecimals = quantityDecimals;
		this.revalueInventoryForCostVariance = revalueInventoryForCostVariance;
		this.tolerancePercentage = tolerancePercentage;
		this.track = track;
		this.userCategoryName1 = userCategoryName1;
		this.userCategoryName2 = userCategoryName2;
		this.userCategoryName3 = userCategoryName3;
		this.userCategoryName4 = userCategoryName4;
		this.userCategoryName5 = userCategoryName5;
		this.userCategoryName6 = userCategoryName6;
		this.valuationMethod = valuationMethod;
		this.warningFeature = warningFeature;
		this.status = status;
		this.iv40001 = iv40001;
		this.iv40100 = iv40100;
		this.iv40300 = iv40300;
		this.iv40301 = iv40301;
		this.iv40401s = iv40401s;
		this.iv40402s = iv40402s;
	}





	public int getItemClassIndex() {
		return itemClassIndex;
	}


	public void setItemClassIndex(int itemClassIndex) {
		this.itemClassIndex = itemClassIndex;
	}


	public Integer getAccountTableRowIndex() {
		return accountTableRowIndex;
	}


	public void setAccountTableRowIndex(Integer accountTableRowIndex) {
		this.accountTableRowIndex = accountTableRowIndex;
	}


	public Byte getAllowBackOrders() {
		return allowBackOrders;
	}


	public void setAllowBackOrders(Byte allowBackOrders) {
		this.allowBackOrders = allowBackOrders;
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


	public String getItemClassDescription() {
		return itemClassDescription;
	}


	public void setItemClassDescription(String itemClassDescription) {
		this.itemClassDescription = itemClassDescription;
	}


	public String getItemClassDescriptionArabic() {
		return itemClassDescriptionArabic;
	}


	public void setItemClassDescriptionArabic(String itemClassDescriptionArabic) {
		this.itemClassDescriptionArabic = itemClassDescriptionArabic;
	}


	public String getItemClassId() {
		return itemClassId;
	}


	public void setItemClassId(String itemClassId) {
		this.itemClassId = itemClassId;
	}


	public String getItemGenericDescription() {
		return itemGenericDescription;
	}


	public void setItemGenericDescription(String itemGenericDescription) {
		this.itemGenericDescription = itemGenericDescription;
	}


	public String getItemGenericDescriptionArabic() {
		return itemGenericDescriptionArabic;
	}


	public void setItemGenericDescriptionArabic(String itemGenericDescriptionArabic) {
		this.itemGenericDescriptionArabic = itemGenericDescriptionArabic;
	}


	public Short getItemType() {
		return itemType;
	}


	public void setItemType(Short itemType) {
		this.itemType = itemType;
	}


	public Date getModifyDate() {
		return modifyDate;
	}


	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}


	public Integer getWarningNumberOfDays() {
		return warningNumberOfDays;
	}


	public void setWarningNumberOfDays(Integer warningNumberOfDays) {
		this.warningNumberOfDays = warningNumberOfDays;
	}


	public Short getPriceMethod() {
		return priceMethod;
	}


	public void setPriceMethod(Short priceMethod) {
		this.priceMethod = priceMethod;
	}


	public Integer getQuantityDecimals() {
		return quantityDecimals;
	}


	public void setQuantityDecimals(Integer quantityDecimals) {
		this.quantityDecimals = quantityDecimals;
	}


	public Byte getRevalueInventoryForCostVariance() {
		return revalueInventoryForCostVariance;
	}


	public void setRevalueInventoryForCostVariance(Byte revalueInventoryForCostVariance) {
		this.revalueInventoryForCostVariance = revalueInventoryForCostVariance;
	}


	public BigDecimal getTolerancePercentage() {
		return tolerancePercentage;
	}


	public void setTolerancePercentage(BigDecimal tolerancePercentage) {
		this.tolerancePercentage = tolerancePercentage;
	}


	public Short getTrack() {
		return track;
	}


	public void setTrack(Short track) {
		this.track = track;
	}


	public String getUserCategoryName1() {
		return userCategoryName1;
	}


	public void setUserCategoryName1(String userCategoryName1) {
		this.userCategoryName1 = userCategoryName1;
	}


	public String getUserCategoryName2() {
		return userCategoryName2;
	}


	public void setUserCategoryName2(String userCategoryName2) {
		this.userCategoryName2 = userCategoryName2;
	}


	public String getUserCategoryName3() {
		return userCategoryName3;
	}


	public void setUserCategoryName3(String userCategoryName3) {
		this.userCategoryName3 = userCategoryName3;
	}


	public String getUserCategoryName4() {
		return userCategoryName4;
	}


	public void setUserCategoryName4(String userCategoryName4) {
		this.userCategoryName4 = userCategoryName4;
	}


	public String getUserCategoryName5() {
		return userCategoryName5;
	}


	public void setUserCategoryName5(String userCategoryName5) {
		this.userCategoryName5 = userCategoryName5;
	}


	public String getUserCategoryName6() {
		return userCategoryName6;
	}


	public void setUserCategoryName6(String userCategoryName6) {
		this.userCategoryName6 = userCategoryName6;
	}


	public Short getValuationMethod() {
		return valuationMethod;
	}


	public void setValuationMethod(Short valuationMethod) {
		this.valuationMethod = valuationMethod;
	}


	public Byte getWarningFeature() {
		return warningFeature;
	}


	public void setWarningFeature(Byte warningFeature) {
		this.warningFeature = warningFeature;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	// bi-directional many-to-one association to Iv40001
	@ManyToOne
	@JoinColumn(name = "LOTCATID")
	public ItemLotCategorySetUp getIv40001() {
		return this.iv40001;
	}

	public void setIv40001(ItemLotCategorySetUp iv40001) {
		this.iv40001 = iv40001;
	}

	// bi-directional many-to-one association to Iv40100
	@ManyToOne
	@JoinColumn(name = "UOMID")
	public InventoryUnitOfMeasureScheduleSetUp getIv40100() {
		return this.iv40100;
	}

	public void setIv40100(InventoryUnitOfMeasureScheduleSetUp iv40100) {
		this.iv40100 = iv40100;
	}

	// bi-directional many-to-one association to Iv40300
	@ManyToOne
	@JoinColumn(name = "PRCLEVLID")
	public PriceLevelSetUp getIv40300() {
		return this.iv40300;
	}

	public void setIv40300(PriceLevelSetUp iv40300) {
		this.iv40300 = iv40300;
	}

	// bi-directional many-to-one association to Iv40301
	@ManyToOne
	@JoinColumn(name = "PRCGRPID")
	public PriceGroupSetUp getIv40301() {
		return this.iv40301;
	}

	public void setIv40301(PriceGroupSetUp iv40301) {
		this.iv40301 = iv40301;
	}

	// bi-directional many-to-one association to Iv40401
	@OneToMany(mappedBy = "iv40400")
	public List<InventoryClassSetUpCurrency> getIv40401s() {
		return this.iv40401s;
	}

	public void setIv40401s(List<InventoryClassSetUpCurrency> iv40401s) {
		this.iv40401s = iv40401s;
	}

	public InventoryClassSetUpCurrency addIv40401(InventoryClassSetUpCurrency iv40401) {
		getIv40401s().add(iv40401);
		iv40401.setIv40400(this);

		return iv40401;
	}

	public InventoryClassSetUpCurrency removeIv40401(InventoryClassSetUpCurrency iv40401) {
		getIv40401s().remove(iv40401);
		iv40401.setIv40400(null);

		return iv40401;
	}

	// bi-directional many-to-one association to Iv40402
	@OneToMany(mappedBy = "iv40400")
	public List<ItemClassAccountTableSetUp> getIv40402s() {
		return this.iv40402s;
	}

	public void setIv40402s(List<ItemClassAccountTableSetUp> iv40402s) {
		this.iv40402s = iv40402s;
	}

	public ItemClassAccountTableSetUp addIv40402(ItemClassAccountTableSetUp iv40402) {
		getIv40402s().add(iv40402);
		iv40402.setIv40400(this);

		return iv40402;
	}

	public ItemClassAccountTableSetUp removeIv40402(ItemClassAccountTableSetUp iv40402) {
		getIv40402s().remove(iv40402);
		iv40402.setIv40400(null);

		return iv40402;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SY03600P == null) ? 0 : SY03600P.hashCode());
		result = prime * result + ((SY03600S == null) ? 0 : SY03600S.hashCode());
		result = prime * result + accountTableRowIndex;
		result = prime * result + allowBackOrders;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((itemClassDescription == null) ? 0 : itemClassDescription.hashCode());
		result = prime * result + ((itemClassDescriptionArabic == null) ? 0 : itemClassDescriptionArabic.hashCode());
		result = prime * result + ((itemClassId == null) ? 0 : itemClassId.hashCode());
		result = prime * result + itemClassIndex;
		result = prime * result + ((itemGenericDescription == null) ? 0 : itemGenericDescription.hashCode());
		result = prime * result
				+ ((itemGenericDescriptionArabic == null) ? 0 : itemGenericDescriptionArabic.hashCode());
		result = prime * result + itemType;
		result = prime * result + ((iv40001 == null) ? 0 : iv40001.hashCode());
		result = prime * result + ((iv40100 == null) ? 0 : iv40100.hashCode());
		result = prime * result + ((iv40300 == null) ? 0 : iv40300.hashCode());
		result = prime * result + ((iv40301 == null) ? 0 : iv40301.hashCode());
		result = prime * result + ((iv40401s == null) ? 0 : iv40401s.hashCode());
		result = prime * result + ((iv40402s == null) ? 0 : iv40402s.hashCode());
		result = prime * result + ((modifyByUserId == null) ? 0 : modifyByUserId.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + priceMethod;
		result = prime * result + quantityDecimals;
		result = prime * result + revalueInventoryForCostVariance;
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + ((rowIdIndexing == null) ? 0 : rowIdIndexing.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tolerancePercentage == null) ? 0 : tolerancePercentage.hashCode());
		result = prime * result + track;
		result = prime * result + ((userCategoryName1 == null) ? 0 : userCategoryName1.hashCode());
		result = prime * result + ((userCategoryName2 == null) ? 0 : userCategoryName2.hashCode());
		result = prime * result + ((userCategoryName3 == null) ? 0 : userCategoryName3.hashCode());
		result = prime * result + ((userCategoryName4 == null) ? 0 : userCategoryName4.hashCode());
		result = prime * result + ((userCategoryName5 == null) ? 0 : userCategoryName5.hashCode());
		result = prime * result + ((userCategoryName6 == null) ? 0 : userCategoryName6.hashCode());
		result = prime * result + valuationMethod;
		result = prime * result + warningFeature;
		result = prime * result + warningNumberOfDays;
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
		ItemClassSetUp other = (ItemClassSetUp) obj;
		if (SY03600P == null) {
			if (other.SY03600P != null)
				return false;
		} else if (!SY03600P.equals(other.SY03600P))
			return false;
		if (SY03600S == null) {
			if (other.SY03600S != null)
				return false;
		} else if (!SY03600S.equals(other.SY03600S))
			return false;
		if (accountTableRowIndex != other.accountTableRowIndex)
			return false;
		if (allowBackOrders != other.allowBackOrders)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (itemClassDescription == null) {
			if (other.itemClassDescription != null)
				return false;
		} else if (!itemClassDescription.equals(other.itemClassDescription))
			return false;
		if (itemClassDescriptionArabic == null) {
			if (other.itemClassDescriptionArabic != null)
				return false;
		} else if (!itemClassDescriptionArabic.equals(other.itemClassDescriptionArabic))
			return false;
		if (itemClassId == null) {
			if (other.itemClassId != null)
				return false;
		} else if (!itemClassId.equals(other.itemClassId))
			return false;
		if (itemClassIndex != other.itemClassIndex)
			return false;
		if (itemGenericDescription == null) {
			if (other.itemGenericDescription != null)
				return false;
		} else if (!itemGenericDescription.equals(other.itemGenericDescription))
			return false;
		if (itemGenericDescriptionArabic == null) {
			if (other.itemGenericDescriptionArabic != null)
				return false;
		} else if (!itemGenericDescriptionArabic.equals(other.itemGenericDescriptionArabic))
			return false;
		if (itemType != other.itemType)
			return false;
		if (iv40001 == null) {
			if (other.iv40001 != null)
				return false;
		} else if (!iv40001.equals(other.iv40001))
			return false;
		if (iv40100 == null) {
			if (other.iv40100 != null)
				return false;
		} else if (!iv40100.equals(other.iv40100))
			return false;
		if (iv40300 == null) {
			if (other.iv40300 != null)
				return false;
		} else if (!iv40300.equals(other.iv40300))
			return false;
		if (iv40301 == null) {
			if (other.iv40301 != null)
				return false;
		} else if (!iv40301.equals(other.iv40301))
			return false;
		if (iv40401s == null) {
			if (other.iv40401s != null)
				return false;
		} else if (!iv40401s.equals(other.iv40401s))
			return false;
		if (iv40402s == null) {
			if (other.iv40402s != null)
				return false;
		} else if (!iv40402s.equals(other.iv40402s))
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
		if (priceMethod != other.priceMethod)
			return false;
		if (quantityDecimals != other.quantityDecimals)
			return false;
		if (revalueInventoryForCostVariance != other.revalueInventoryForCostVariance)
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
		if (tolerancePercentage == null) {
			if (other.tolerancePercentage != null)
				return false;
		} else if (!tolerancePercentage.equals(other.tolerancePercentage))
			return false;
		if (track != other.track)
			return false;
		if (userCategoryName1 == null) {
			if (other.userCategoryName1 != null)
				return false;
		} else if (!userCategoryName1.equals(other.userCategoryName1))
			return false;
		if (userCategoryName2 == null) {
			if (other.userCategoryName2 != null)
				return false;
		} else if (!userCategoryName2.equals(other.userCategoryName2))
			return false;
		if (userCategoryName3 == null) {
			if (other.userCategoryName3 != null)
				return false;
		} else if (!userCategoryName3.equals(other.userCategoryName3))
			return false;
		if (userCategoryName4 == null) {
			if (other.userCategoryName4 != null)
				return false;
		} else if (!userCategoryName4.equals(other.userCategoryName4))
			return false;
		if (userCategoryName5 == null) {
			if (other.userCategoryName5 != null)
				return false;
		} else if (!userCategoryName5.equals(other.userCategoryName5))
			return false;
		if (userCategoryName6 == null) {
			if (other.userCategoryName6 != null)
				return false;
		} else if (!userCategoryName6.equals(other.userCategoryName6))
			return false;
		if (valuationMethod != other.valuationMethod)
			return false;
		if (warningFeature != other.warningFeature)
			return false;
		if (warningNumberOfDays != other.warningNumberOfDays)
			return false;
		return true;
	}

	
	
}