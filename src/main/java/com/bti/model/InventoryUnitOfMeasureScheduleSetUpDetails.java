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
 * Name of Project: BTI 
 * Description:The persistent class for the -UNIT OF MEASURE SCHEDULE SETUP DETAILS-database table. 
 * Created on:NOVEMBER 13,2017
 * Modified on:
 * 
 * @author goodtech
 */

@Entity
@Table(name = "Iv40101")
//@NamedQuery(name = "InventoryUnitOfMeasureScheduleSetUpDetails.findAll", query = "SELECT i FROM InventoryUnitOfMeasureScheduleSetUpDetails i")
public class InventoryUnitOfMeasureScheduleSetUpDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "INDEX", length = 15)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "`INDEX`")
	private int index;
	
	@Column(name = "UOFM", length = 15)
	private String UnitOfMeasure;


	@Column(name = "BAOFM", length = 10)
	private String baseUnitOfMeasure;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserId;

	@Column(name = "CREATDDT")
	private Date createDate;

	@Column(name = "DEX_ROW_ID")
	private int rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "EQVLNT", length = 15)
	private String equivalentUnitOfMeasure;

	@Column(name = "EQVLNTQTY")
	private int equivalentUnitOfMeasureQty;

	@Column(name = "LNGDSCR", length = 61)
	private String moreDescriptionForUOfMInDetailLevel;

	@Column(name = "MODIFDT")
	private Date modifdt;

	@Column(name = "QTYBASE")
	private int qtyInBaseUnitOfMeasure;

	@Column(name = "UOFMSEQ")
	private int unitOfMeasureSequence;

	@Column(name = "STATUS")
	private Boolean status;

	// bi-directional many-to-one association to Iv40100
	@ManyToOne
	@JoinColumn(name = "UOMID", referencedColumnName = "UOMID")
	private InventoryUnitOfMeasureScheduleSetUp iv401001;

	public InventoryUnitOfMeasureScheduleSetUpDetails() {
	}

	/**
	 * @param index
	 * @param baseUnitOfMeasure
	 * @param modifyByUserId
	 * @param createDate
	 * @param rowIdIndexing
	 * @param rowDateIndexing
	 * @param equivalentUnitOfMeasure
	 * @param equivalentUnitOfMeasureQty
	 * @param moreDescriptionForUOfMInDetailLevel
	 * @param modifdt
	 * @param qtyInBaseUnitOfMeasure
	 * @param unitOfMeasureSequence
	 * @param status
	 * @param iv401001
	 * @param unitOfMeasureId
	 */
	public InventoryUnitOfMeasureScheduleSetUpDetails(int index, String baseUnitOfMeasure, String modifyByUserId,
			Date createDate, int rowIdIndexing, Date rowDateIndexing, String equivalentUnitOfMeasure,
			int equivalentUnitOfMeasureQty, String moreDescriptionForUOfMInDetailLevel, Date modifdt,
			int qtyInBaseUnitOfMeasure, int unitOfMeasureSequence, Boolean status,
			InventoryUnitOfMeasureScheduleSetUp iv401001, String unitOfMeasureId) {
		super();
		this.index = index;
		this.baseUnitOfMeasure = baseUnitOfMeasure;
		this.modifyByUserId = modifyByUserId;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.equivalentUnitOfMeasure = equivalentUnitOfMeasure;
		this.equivalentUnitOfMeasureQty = equivalentUnitOfMeasureQty;
		this.moreDescriptionForUOfMInDetailLevel = moreDescriptionForUOfMInDetailLevel;
		this.modifdt = modifdt;
		this.qtyInBaseUnitOfMeasure = qtyInBaseUnitOfMeasure;
		this.unitOfMeasureSequence = unitOfMeasureSequence;
		this.status = status;
		this.iv401001 = iv401001;

	}

	/**
	 * @param index
	 * @param baseUnitOfMeasure
	 * @param equivalentUnitOfMeasure
	 * @param equivalentUnitOfMeasureQty
	 * @param moreDescriptionForUOfMInDetailLevel
	 * @param qtyInBaseUnitOfMeasure
	 * @param unitOfMeasureSequence
	 * @param status
	 * @param iv401001
	 * @param iv401002
	 */
	public InventoryUnitOfMeasureScheduleSetUpDetails(int index, String baseUnitOfMeasure,
			String equivalentUnitOfMeasure, int equivalentUnitOfMeasureQty, String moreDescriptionForUOfMInDetailLevel,
			int qtyInBaseUnitOfMeasure, int unitOfMeasureSequence, Boolean status,
			InventoryUnitOfMeasureScheduleSetUp iv401001) {
		super();
		this.index = index;
		this.baseUnitOfMeasure = baseUnitOfMeasure;
		this.equivalentUnitOfMeasure = equivalentUnitOfMeasure;
		this.equivalentUnitOfMeasureQty = equivalentUnitOfMeasureQty;
		this.moreDescriptionForUOfMInDetailLevel = moreDescriptionForUOfMInDetailLevel;
		this.qtyInBaseUnitOfMeasure = qtyInBaseUnitOfMeasure;
		this.unitOfMeasureSequence = unitOfMeasureSequence;
		this.status = status;
		this.iv401001 = iv401001;

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
	 * @return the baseUnitOfMeasure
	 */
	public String getBaseUnitOfMeasure() {
		return baseUnitOfMeasure;
	}

	/**
	 * @param baseUnitOfMeasure
	 *            the baseUnitOfMeasure to set
	 */
	public void setBaseUnitOfMeasure(String baseUnitOfMeasure) {
		this.baseUnitOfMeasure = baseUnitOfMeasure;
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
	 * @return the equivalentUnitOfMeasure
	 */
	public String getEquivalentUnitOfMeasure() {
		return equivalentUnitOfMeasure;
	}

	/**
	 * @param equivalentUnitOfMeasure
	 *            the equivalentUnitOfMeasure to set
	 */
	public void setEquivalentUnitOfMeasure(String equivalentUnitOfMeasure) {
		this.equivalentUnitOfMeasure = equivalentUnitOfMeasure;
	}

	/**
	 * @return the equivalentUnitOfMeasureQty
	 */
	public int getEquivalentUnitOfMeasureQty() {
		return equivalentUnitOfMeasureQty;
	}

	/**
	 * @param equivalentUnitOfMeasureQty
	 *            the equivalentUnitOfMeasureQty to set
	 */
	public void setEquivalentUnitOfMeasureQty(int equivalentUnitOfMeasureQty) {
		this.equivalentUnitOfMeasureQty = equivalentUnitOfMeasureQty;
	}

	/**
	 * @return the moreDescriptionForUOfMInDetailLevel
	 */
	public String getMoreDescriptionForUOfMInDetailLevel() {
		return moreDescriptionForUOfMInDetailLevel;
	}

	/**
	 * @param moreDescriptionForUOfMInDetailLevel
	 *            the moreDescriptionForUOfMInDetailLevel to set
	 */
	public void setMoreDescriptionForUOfMInDetailLevel(String moreDescriptionForUOfMInDetailLevel) {
		this.moreDescriptionForUOfMInDetailLevel = moreDescriptionForUOfMInDetailLevel;
	}

	/**
	 * @return the modifdt
	 */
	public Date getModifdt() {
		return modifdt;
	}

	/**
	 * @param modifdt
	 *            the modifdt to set
	 */
	public void setModifdt(Date modifdt) {
		this.modifdt = modifdt;
	}

	/**
	 * @return the qtyInBaseUnitOfMeasure
	 */
	public int getQtyInBaseUnitOfMeasure() {
		return qtyInBaseUnitOfMeasure;
	}

	/**
	 * @param qtyInBaseUnitOfMeasure
	 *            the qtyInBaseUnitOfMeasure to set
	 */
	public void setQtyInBaseUnitOfMeasure(int qtyInBaseUnitOfMeasure) {
		this.qtyInBaseUnitOfMeasure = qtyInBaseUnitOfMeasure;
	}

	/**
	 * @return the unitOfMeasureSequence
	 */
	public int getUnitOfMeasureSequence() {
		return unitOfMeasureSequence;
	}

	/**
	 * @param unitOfMeasureSequence
	 *            the unitOfMeasureSequence to set
	 */
	public void setUnitOfMeasureSequence(int unitOfMeasureSequence) {
		this.unitOfMeasureSequence = unitOfMeasureSequence;
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

	// bi-directional many-to-one association to Iv40100
	@ManyToOne
	@JoinColumn(name = "UOMID")
	public InventoryUnitOfMeasureScheduleSetUp getIv401001() {
		return this.iv401001;
	}

	public void setIv401001(InventoryUnitOfMeasureScheduleSetUp iv401001) {
		this.iv401001 = iv401001;
	}

	
}