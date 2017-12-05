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

package com.bti.service;

import java.time.LocalDateTime;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bti.repository.RepositoryStockCalenderException;
import com.bti.service.ServiceResponse;
import com.bti.model.ItemCategorySetUp;
import com.bti.model.StockCalendarExceptionDaysSetUp;
import com.bti.model.dto.DtoItemCategorySetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.model.dto.DtoStockCalenderException;
import com.bti.util.UtilDateAndTime;

/**
 * Name of Project: BTI 
 * Description: Service ServiceStockCalenderExceptionImpl
 * Created on: 
 * Modified on:
 * @author goodtech
 * version :
 */

@Service
public class ServiceStockCalenderException {
	private static final Log LOG = LogFactory.getLog(ServiceStockCalenderException.class);

	@Autowired
	private RepositoryStockCalenderException repositoryStockCalenderException;

	@Autowired
	ServiceResponse serviceResponse;

	/**
	 * @param dtoStockCalenderException
	 * @return
	 */

	
	public DtoStockCalenderException saveorUpdateStockCalenderexception(
			DtoStockCalenderException dtoStockCalenderException) {
		LOG.info("In save or update Stock Exception Setup Service");

		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();
		StockCalendarExceptionDaysSetUp stockCalendarExceptionDaysSetup = new StockCalendarExceptionDaysSetUp();
		Date datecreated = dtoStockCalenderException.getExceptionDate();
		dtoStockCalenderException.setExceptionDate(datecreated);
		if (dtoStockCalenderException.getIdStock() == 0) {
			BeanUtils.copyProperties(dtoStockCalenderException, stockCalendarExceptionDaysSetup);
			stockCalendarExceptionDaysSetup.setCreateDate(utilDateAndTime.localToUTC());
		} else {
			stockCalendarExceptionDaysSetup = repositoryStockCalenderException
					.findOne(dtoStockCalenderException.getStockExceptionId());

		}

		stockCalendarExceptionDaysSetup = repositoryStockCalenderException.save(stockCalendarExceptionDaysSetup);
		BeanUtils.copyProperties(stockCalendarExceptionDaysSetup, dtoStockCalenderException);
		return dtoStockCalenderException;
	}

	/**
	 * @param dtoStockCalenderException
	 * @return
	 */
	
	public DtoSearch getStockException(DtoStockCalenderException dtoStockCalenderException) {

		LOG.info("In get Stock Exception Setup Service");

		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoStockCalenderException.getPageNumber());
		dtoSearch.setPageSize(dtoStockCalenderException.getPageSize());
		dtoSearch.setTotalCount((int) repositoryStockCalenderException.count());

		List<StockCalendarExceptionDaysSetUp> stockCalendarExceptionDaysSetupList;

		if (dtoStockCalenderException.getPageNumber() != null && dtoStockCalenderException.getPageSize() != null) {
			Pageable pageable = new PageRequest(dtoStockCalenderException.getPageNumber(),
					dtoStockCalenderException.getPageSize(), Direction.DESC, "createDate");

			stockCalendarExceptionDaysSetupList = repositoryStockCalenderException.findBy(pageable);
		} else {
			stockCalendarExceptionDaysSetupList = repositoryStockCalenderException.findByOrderByCreateDateDesc();
		}

		List<DtoStockCalenderException> dtoStockCalenderExceptionList = new ArrayList<>();
		if (stockCalendarExceptionDaysSetupList != null && stockCalendarExceptionDaysSetupList.size() > 0)

		{
			for (StockCalendarExceptionDaysSetUp stockCalendarExceptionDaysSetup : stockCalendarExceptionDaysSetupList) {
				dtoStockCalenderException = new DtoStockCalenderException(stockCalendarExceptionDaysSetup);
				dtoStockCalenderExceptionList.add(dtoStockCalenderException);
			}
			dtoSearch.setRecords(dtoStockCalenderExceptionList);

		}
		return dtoSearch;
	}

	/**
	 * @param idStock
	 * @return
	 */

	
	public DtoStockCalenderException deleteStockcalenderException(int idStock) {
		
		LOG.info("In delete Stock Exception Setup Service");

		DtoStockCalenderException dtoStockCalenderException = new DtoStockCalenderException();
		dtoStockCalenderException.setDeleteMessage(
				serviceResponse.getStringMessageByShortAndIsDeleted("StockCalenderException_DELETED", false));

		if(idStock != 0) {
		repositoryStockCalenderException.deleteStockcalenderException(idStock);
		dtoStockCalenderException.setIdStock(idStock);
		}
		return dtoStockCalenderException;
	}

}
