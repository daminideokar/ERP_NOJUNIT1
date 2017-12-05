
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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Name of Project: BTI 
 * Description: The persistent class for the StockCalendarSetup database table.
 * Created on: 
 * Modified on:
 * @author goodtech
 * version :
 */
@Entity
@Table(name = "Iv40500")
//@NamedQuery(name = "StockCalendarSetup.findAll", query = "SELECT i FROM StockCalendarSetUp i")
public class StockCalendarSetUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSetup;

	@Column(name = "CHANGEBY", length = 15)
	private String modifyByUserId;

	@Column(name = "CREATDDT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "DEX_ROW_ID")
	private int rowIdIndexing;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEX_ROW_TS")
	private Date rowDateIndexing;

	@Column(name = "DWNWRK")
	private short downWorkDay;

	@Column(name = "HRSHIFT")
	private int hoursOfShifts;

	@Column(name = "MODIFDT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	@Column(name = "NUMOFSHIFT")
	private int numberOfShifts;

	@Column(name = "STRTIME")
	@Temporal(TemporalType.TIME)
	//@DateTimeFormat(style = "hh:mm a")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm a")
	private Date startTimeOfShift;

	public StockCalendarSetUp() {
	}

	public StockCalendarSetUp(String modifyByUserId, Date createDate, int rowIdIndexing, Date rowDateIndexing,
			short downWorkDay, int hoursOfShifts, Date modifyDate, int numberOfShifts, Date startTimeOfShift) {
		super();
		this.modifyByUserId = modifyByUserId;
		this.createDate = createDate;
		this.rowIdIndexing = rowIdIndexing;
		this.rowDateIndexing = rowDateIndexing;
		this.downWorkDay = downWorkDay;
		this.hoursOfShifts = hoursOfShifts;
		this.modifyDate = modifyDate;
		this.numberOfShifts = numberOfShifts;
		this.startTimeOfShift = startTimeOfShift;
	}

	public int getIdSetup() {
		return idSetup;
	}

	public void setIdSetup(int idSetup) {
		this.idSetup = idSetup;
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

	public short getDownWorkDay() {
		return downWorkDay;
	}

	public void setDownWorkDay(short downWorkDay) {
		this.downWorkDay = downWorkDay;
	}

	public int getHoursOfShifts() {
		return hoursOfShifts;
	}

	public void setHoursOfShifts(int hoursOfShifts) {
		this.hoursOfShifts = hoursOfShifts;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getNumberOfShifts() {
		return numberOfShifts;
	}

	public void setNumberOfShifts(int numberOfShifts) {
		this.numberOfShifts = numberOfShifts;
	}

	public Date getStartTimeOfShift() {
		return startTimeOfShift;
	}

	public void setStartTimeOfShift(Date startTimeOfShift) {
		this.startTimeOfShift = startTimeOfShift;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + downWorkDay;
		result = prime * result + hoursOfShifts;
		result = prime * result + idSetup;
		result = prime * result + ((modifyByUserId == null) ? 0 : modifyByUserId.hashCode());
		result = prime * result + ((modifyDate == null) ? 0 : modifyDate.hashCode());
		result = prime * result + numberOfShifts;
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + rowIdIndexing;
		result = prime * result + ((startTimeOfShift == null) ? 0 : startTimeOfShift.hashCode());
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
		StockCalendarSetUp other = (StockCalendarSetUp) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (downWorkDay != other.downWorkDay)
			return false;
		if (hoursOfShifts != other.hoursOfShifts)
			return false;
		if (idSetup != other.idSetup)
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
		if (numberOfShifts != other.numberOfShifts)
			return false;
		if (rowDateIndexing == null) {
			if (other.rowDateIndexing != null)
				return false;
		} else if (!rowDateIndexing.equals(other.rowDateIndexing))
			return false;
		if (rowIdIndexing != other.rowIdIndexing)
			return false;
		if (startTimeOfShift == null) {
			if (other.startTimeOfShift != null)
				return false;
		} else if (!startTimeOfShift.equals(other.startTimeOfShift))
			return false;
		return true;
	}
	

}