package com.bti.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the iv00101 database table.
 * 
 */
@Entity
@JsonInclude(Include.NON_EMPTY)
@Table(name="Iv00101")
//@NamedQuery(name = "ItemMaintenance.findAll", query = "SELECT i FROM ItemMaintenance i")
public class ItemMaintenance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ITEMNMBR", length = 31,unique=true)
	private String itemNumber;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserId;

	@Column(name = "CREATDDT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "CURTCOST")
	private BigDecimal currentCost;

	@Column(name = "DEX_ROW_ID")
	private int rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date rowDateIndexing;

	@Column(name = "INACTIVE")
	private byte inactiveItem;

	@Column(name = "ITEMDSCR", length = 61)
	private String itemDescription;

	@Column(name = "ITEMDSCRA")
	private String itemDescriptionArabic;

	@Column(name = "ITEMSHRT", length = 31)
	private String itemShortDescription;

	@Column(name = "ITMGENDSC", length = 31)
	private String itemGenericDescription;

	@Column(name = "ITMGENDSCA")
	private String itemGenericDescriptionArabic;

	@Column(name = "ITMTYPE")
	private short itemType;

	@Column(name = "MODIFDT")
	private Date modifyDate;

	@Column(name = "SHIPWEIGH")
	private BigDecimal shippingWeight;

	@Column(name = "STNDCOST")
	private BigDecimal standardCost;

	@Column(name = "VALMETHD")
	private short valuationMethod;

	@Column(name = "STATUS")
	private Boolean status;

	// bi-directional many-to-one association to Iv00104
	@JsonIgnore
	@OneToMany(mappedBy = "iv001011")
	private List<ItemKits> iv00104s1;

	@JsonIgnore
	@OneToMany(mappedBy = "iv001012")
	private List<ItemKits> iv00104s2;

	
	
	// bi-directional many-to-one association to Iv40400
	@ManyToOne
	@JoinColumn(name = "ITMCLSID")
	private ItemClassSetUp iv40400;

	// bi-directional many-to-one association to Iv40100
	@ManyToOne
	@JoinColumn(name = "UOMID",referencedColumnName="UOMID")
	private InventoryUnitOfMeasureScheduleSetUp iv40100;

	// bi-directional many-to-one association to Sy03600
	@ManyToOne
	@JoinColumn(name = "TAXSCHDIDS")
	private VatSetUp sy036001;

	// bi-directional many-to-one association to Sy03600
	@ManyToOne
	@JoinColumn(name = "TAXSCHDIDP")
	private VatSetUp sy036002;

	public ItemMaintenance() {
	}

	

	/**
	 * @param modifyByUserId
	 * @param createDate
	 * @param currentCost
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param inactiveItem
	 * @param itemDescription
	 * @param itemDescriptionArabic
	 * @param itemShortDescription
	 * @param itemGenericDescription
	 * @param itemGenericDescriptionArabic
	 * @param itemType
	 * @param modifyDate
	 * @param shippingWeight
	 * @param standardCost
	 * @param valuationMethod
	 * @param status
	 * @param iv00104s1
	 * @param iv00104s2
	 * @param iv40400
	 * @param iv40100
	 * @param sy036001
	 * @param sy036002
	 */
	public ItemMaintenance(String modifyByUserId, Date createDate, BigDecimal currentCost, int rowIdIndexing,
			Date rowDateIndexing, byte inactiveItem, String itemDescription, String itemDescriptionArabic,
			String itemShortDescription, String itemGenericDescription, String itemGenericDescriptionArabic,
			short itemType, Date modifyDate, BigDecimal shippingWeight, BigDecimal standardCost, short valuationMethod,
			Boolean status, List<ItemKits> iv00104s1, List<ItemKits> iv00104s2, ItemClassSetUp iv40400,
			InventoryUnitOfMeasureScheduleSetUp iv40100, VatSetUp sy036001, VatSetUp sy036002) {
		super();
		this.modifyByUserId = modifyByUserId;
		this.createDate = createDate;
		this.currentCost = currentCost;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.inactiveItem = inactiveItem;
		this.itemDescription = itemDescription;
		this.itemDescriptionArabic = itemDescriptionArabic;
		this.itemShortDescription = itemShortDescription;
		this.itemGenericDescription = itemGenericDescription;
		this.itemGenericDescriptionArabic = itemGenericDescriptionArabic;
		this.itemType = itemType;
		this.modifyDate = modifyDate;
		this.shippingWeight = shippingWeight;
		this.standardCost = standardCost;
		this.valuationMethod = valuationMethod;
		this.status = status;
		this.iv00104s1 = iv00104s1;
		this.iv00104s2 = iv00104s2;
		this.iv40400 = iv40400;
		this.iv40100 = iv40100;
		this.sy036001 = sy036001;
		this.sy036002 = sy036002;
	}



	public ItemMaintenance(BigDecimal currentCost, String itemDescription, List<ItemKits> iv00104s2,
			InventoryUnitOfMeasureScheduleSetUp iv40100) {
		super();
		this.currentCost = currentCost;
		this.itemDescription = itemDescription;
		this.iv00104s2 = iv00104s2;
		this.iv40100 = iv40100;
	}



	/**
	 * @return the itemNumber
	 */
	public String getItemNumber() {
		return itemNumber;
	}

	/**
	 * @param itemNumber the itemNumber to set
	 */
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	/**
	 * @return the modifyByUserId
	 */
	public String getModifyByUserId() {
		return modifyByUserId;
	}

	/**
	 * @param modifyByUserId the modifyByUserId to set
	 */
	public void setModifyByUserId(String modifyByUserId) {
		this.modifyByUserId = modifyByUserId;
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
	 * @return the currentCost
	 */
	public BigDecimal getCurrentCost() {
		return currentCost;
	}

	/**
	 * @param currentCost the currentCost to set
	 */
	public void setCurrentCost(BigDecimal currentCost) {
		this.currentCost = currentCost;
	}

	/**
	 * @return the rowIdIndexing
	 */
	public int getRowIdIndexing() {
		return rowIdIndexing;
	}

	/**
	 * @param rowIdIndexing the rowIdIndexing to set
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
	 * @param rowDateIndexing the rowDateIndexing to set
	 */
	public void setRowDateIndexing(Date rowDateIndexing) {
		this.rowDateIndexing = rowDateIndexing;
	}

	/**
	 * @return the inactiveItem
	 */
	public byte getInactiveItem() {
		return inactiveItem;
	}

	/**
	 * @param inactiveItem the inactiveItem to set
	 */
	public void setInactiveItem(byte inactiveItem) {
		this.inactiveItem = inactiveItem;
	}

	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * @param itemDescription the itemDescription to set
	 */
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	/**
	 * @return the itemDescriptionArabic
	 */
	public String getItemDescriptionArabic() {
		return itemDescriptionArabic;
	}

	/**
	 * @param itemDescriptionArabic the itemDescriptionArabic to set
	 */
	public void setItemDescriptionArabic(String itemDescriptionArabic) {
		this.itemDescriptionArabic = itemDescriptionArabic;
	}

	/**
	 * @return the itemShortDescription
	 */
	public String getItemShortDescription() {
		return itemShortDescription;
	}

	/**
	 * @param itemShortDescription the itemShortDescription to set
	 */
	public void setItemShortDescription(String itemShortDescription) {
		this.itemShortDescription = itemShortDescription;
	}

	/**
	 * @return the itemGenericDescription
	 */
	public String getItemGenericDescription() {
		return itemGenericDescription;
	}

	/**
	 * @param itemGenericDescription the itemGenericDescription to set
	 */
	public void setItemGenericDescription(String itemGenericDescription) {
		this.itemGenericDescription = itemGenericDescription;
	}

	/**
	 * @return the itemGenericDescriptionArabic
	 */
	public String getItemGenericDescriptionArabic() {
		return itemGenericDescriptionArabic;
	}

	/**
	 * @param itemGenericDescriptionArabic the itemGenericDescriptionArabic to set
	 */
	public void setItemGenericDescriptionArabic(String itemGenericDescriptionArabic) {
		this.itemGenericDescriptionArabic = itemGenericDescriptionArabic;
	}

	/**
	 * @return the itemType
	 */
	public short getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(short itemType) {
		this.itemType = itemType;
	}

	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * @return the shippingWeight
	 */
	public BigDecimal getShippingWeight() {
		return shippingWeight;
	}

	/**
	 * @param shippingWeight the shippingWeight to set
	 */
	public void setShippingWeight(BigDecimal shippingWeight) {
		this.shippingWeight = shippingWeight;
	}

	/**
	 * @return the standardCost
	 */
	public BigDecimal getStandardCost() {
		return standardCost;
	}

	/**
	 * @param standardCost the standardCost to set
	 */
	public void setStandardCost(BigDecimal standardCost) {
		this.standardCost = standardCost;
	}

	/**
	 * @return the valuationMethod
	 */
	public short getValuationMethod() {
		return valuationMethod;
	}

	/**
	 * @param valuationMethod the valuationMethod to set
	 */
	public void setValuationMethod(short valuationMethod) {
		this.valuationMethod = valuationMethod;
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

	

	public List<ItemKits> getIv00104s1() {
		return iv00104s1;
	}



	public void setIv00104s1(List<ItemKits> iv00104s1) {
		this.iv00104s1 = iv00104s1;
	}



	public List<ItemKits> getIv00104s2() {
		return iv00104s2;
	}



	public void setIv00104s2(List<ItemKits> iv00104s2) {
		this.iv00104s2 = iv00104s2;
	}



	/**
	 * @return the iv40400
	 */
	public ItemClassSetUp getIv40400() {
		return iv40400;
	}

	/**
	 * @param iv40400 the iv40400 to set
	 */
	public void setIv40400(ItemClassSetUp iv40400) {
		this.iv40400 = iv40400;
	}

	/**
	 * @return the iv40100
	 */
	public InventoryUnitOfMeasureScheduleSetUp getIv40100() {
		return iv40100;
	}

	/**
	 * @param iv40100 the iv40100 to set
	 */
	public void setIv40100(InventoryUnitOfMeasureScheduleSetUp iv40100) {
		this.iv40100 = iv40100;
	}

	/**
	 * @return the sy036001
	 */
	public VatSetUp getSy036001() {
		return sy036001;
	}

	/**
	 * @param sy036001 the sy036001 to set
	 */
	public void setSy036001(VatSetUp sy036001) {
		this.sy036001 = sy036001;
	}

	/**
	 * @return the sy036002
	 */
	public VatSetUp getSy036002() {
		return sy036002;
	}

	/**
	 * @param sy036002 the sy036002 to set
	 */
	public void setSy036002(VatSetUp sy036002) {
		this.sy036002 = sy036002;
	}



	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((currentCost == null) ? 0 : currentCost.hashCode());
		result = prime * result + inactiveItem;
		
		result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
		result = prime * result + ((itemDescriptionArabic == null) ? 0 : itemDescriptionArabic.hashCode());
		result = prime * result + ((itemGenericDescription == null) ? 0 : itemGenericDescription.hashCode());
		result = prime * result
				+ ((itemGenericDescriptionArabic == null) ? 0 : itemGenericDescriptionArabic.hashCode());
		result = prime * result + ((itemNumber == null) ? 0 : itemNumber.hashCode());
		result = prime * result + ((itemShortDescription == null) ? 0 : itemShortDescription.hashCode());
		result = prime * result + itemType;
		result = prime * result + ((iv00104s1 == null) ? 0 : iv00104s1.hashCode());
		result = prime * result + ((iv00104s2 == null) ? 0 : iv00104s2.hashCode());
		result = prime * result + ((iv40100 == null) ? 0 : iv40100.hashCode());
		result = prime * result + ((iv40400 == null) ? 0 : iv40400.hashCode());
		result = prime * result + ((modifyByUserId == null) ? 0 : modifyByUserId.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + rowIdIndexing;
		result = prime * result + ((shippingWeight == null) ? 0 : shippingWeight.hashCode());
		result = prime * result + ((standardCost == null) ? 0 : standardCost.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((sy036001 == null) ? 0 : sy036001.hashCode());
		result = prime * result + ((sy036002 == null) ? 0 : sy036002.hashCode());
		result = prime * result + valuationMethod;
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
		ItemMaintenance other = (ItemMaintenance) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (currentCost == null) {
			if (other.currentCost != null)
				return false;
		} else if (!currentCost.equals(other.currentCost))
			return false;
		if (inactiveItem != other.inactiveItem)
			return false;
		
		if (itemDescription == null) {
			if (other.itemDescription != null)
				return false;
		} else if (!itemDescription.equals(other.itemDescription))
			return false;
		if (itemDescriptionArabic == null) {
			if (other.itemDescriptionArabic != null)
				return false;
		} else if (!itemDescriptionArabic.equals(other.itemDescriptionArabic))
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
		if (itemNumber == null) {
			if (other.itemNumber != null)
				return false;
		} else if (!itemNumber.equals(other.itemNumber))
			return false;
		if (itemShortDescription == null) {
			if (other.itemShortDescription != null)
				return false;
		} else if (!itemShortDescription.equals(other.itemShortDescription))
			return false;
		if (itemType != other.itemType)
			return false;
		if (iv00104s1 == null) {
			if (other.iv00104s1 != null)
				return false;
		} else if (!iv00104s1.equals(other.iv00104s1))
			return false;
		if (iv00104s2 == null) {
			if (other.iv00104s2 != null)
				return false;
		} else if (!iv00104s2.equals(other.iv00104s2))
			return false;
		if (iv40100 == null) {
			if (other.iv40100 != null)
				return false;
		} else if (!iv40100.equals(other.iv40100))
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
		if (shippingWeight == null) {
			if (other.shippingWeight != null)
				return false;
		} else if (!shippingWeight.equals(other.shippingWeight))
			return false;
		if (standardCost == null) {
			if (other.standardCost != null)
				return false;
		} else if (!standardCost.equals(other.standardCost))
			return false;
		if (status != other.status)
			return false;
		if (sy036001 == null) {
			if (other.sy036001 != null)
				return false;
		} else if (!sy036001.equals(other.sy036001))
			return false;
		if (sy036002 == null) {
			if (other.sy036002 != null)
				return false;
		} else if (!sy036002.equals(other.sy036002))
			return false;
		if (valuationMethod != other.valuationMethod)
			return false;
		return true;
	}



	

}