package com.bti.model.dto;

import java.util.List;

import com.bti.model.StockCalendarExceptionDaysSetUp;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Name of Project: BTI 
 * Description: DTO StockCalenderException class having getter and setter for fields (POJO) Name 
 * Created on: 
 * Modified on:
 * 
 * @author goodtech
 *  version :
 */
@JsonInclude(Include.NON_EMPTY)
public class DtoStockCalenderException extends StockCalendarExceptionDaysSetUp {

	private Integer pageNumber;
	private Integer pageSize;
	private String deleteMessage;
	private Integer stockExceptionId;

	public DtoStockCalenderException() {
		super();
	}

	public DtoStockCalenderException(StockCalendarExceptionDaysSetUp stockCalendarExceptionDaysSetup) {
		super(stockCalendarExceptionDaysSetup.getIdStock(), stockCalendarExceptionDaysSetup.getExceptionDate());
	}

	public Integer getStockExceptionId() {
		return stockExceptionId;
	}

	public void setStockExceptionId(Integer stockExceptionId) {
		this.stockExceptionId = stockExceptionId;
	}

	public String getDeleteMessage() {
		return deleteMessage;
	}

	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((deleteMessage == null) ? 0 : deleteMessage.hashCode());
		result = prime * result + ((pageNumber == null) ? 0 : pageNumber.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((stockExceptionId == null) ? 0 : stockExceptionId.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoStockCalenderException other = (DtoStockCalenderException) obj;
		if (deleteMessage == null) {
			if (other.deleteMessage != null)
				return false;
		} else if (!deleteMessage.equals(other.deleteMessage))
			return false;

		if (pageNumber == null) {
			if (other.pageNumber != null)
				return false;
		} else if (!pageNumber.equals(other.pageNumber))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		if (stockExceptionId == null) {
			if (other.stockExceptionId != null)
				return false;
		} else if (!stockExceptionId.equals(other.stockExceptionId))
			return false;
		return true;
	}

}
