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
 * Description: The persistent class for the StockCalendarExceptionDaysSetup database table. 
 * Created on: 
 * Modified on:
 * 
 * @author goodtech version :
 */

@Entity
@Table(name = "Iv40501")
//@NamedQuery(name = "StockCalendarExceptionDaysSetup.findAll", query = "SELECT i FROM StockCalendarExceptionDaysSetUp i")
public class StockCalendarExceptionDaysSetUp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int idStock;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserID;

	@Column(name = "CREATDDT")
	private Date createDate;

	@Column(name = "DEX_ROW_ID")
	private int rowIdIndexing;

	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "EXCPTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date exceptionDate;

	public StockCalendarExceptionDaysSetUp() {
	}

	public StockCalendarExceptionDaysSetUp(int idStock, String modifyByUserID, Date createDate, int rowIdIndexing,
			Date rowDateIndexing, Date exceptionDate) {
		super();
		this.idStock = idStock;
		this.modifyByUserID = modifyByUserID;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.exceptionDate = exceptionDate;
	}

	public StockCalendarExceptionDaysSetUp(int idStock, Date exceptionDate) {
		super();
		this.idStock = idStock;
		this.exceptionDate = exceptionDate;
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public String getModifyByUserID() {
		return modifyByUserID;
	}

	public void setModifyByUserID(String modifyByUserID) {
		this.modifyByUserID = modifyByUserID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getRowIdIndexing() {
		return rowIdIndexing;
	}

	public void setRowIdIndexing(int rowIdIndexing) {
		this.rowIdIndexing = rowIdIndexing;
	}

	public Date getRowDateIndexing() {
		return rowDateIndexing;
	}

	public void setRowDateIndexing(Date rowDateIndexing) {
		this.rowDateIndexing = rowDateIndexing;
	}

	public Date getExceptionDate() {
		return exceptionDate;
	}

	public void setExceptionDate(Date exceptionDate) {
		this.exceptionDate = exceptionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((exceptionDate == null) ? 0 : exceptionDate.hashCode());
		result = prime * result + idStock;
		result = prime * result + ((modifyByUserID == null) ? 0 : modifyByUserID.hashCode());
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + rowIdIndexing;
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
		StockCalendarExceptionDaysSetUp other = (StockCalendarExceptionDaysSetUp) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (exceptionDate == null) {
			if (other.exceptionDate != null)
				return false;
		} else if (!exceptionDate.equals(other.exceptionDate))
			return false;
		if (idStock != other.idStock)
			return false;
		if (modifyByUserID == null) {
			if (other.modifyByUserID != null)
				return false;
		} else if (!modifyByUserID.equals(other.modifyByUserID))
			return false;
		if (rowDateIndexing == null) {
			if (other.rowDateIndexing != null)
				return false;
		} else if (!rowDateIndexing.equals(other.rowDateIndexing))
			return false;
		if (rowIdIndexing != other.rowIdIndexing)
			return false;
		return true;
	}

	
}