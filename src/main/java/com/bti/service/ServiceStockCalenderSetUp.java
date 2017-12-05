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

import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bti.repository.RepositoryStockCalenderSetUp;
import com.bti.model.StockCalendarSetUp;
import com.bti.model.dto.DtoStockCalenderSetUp;
import com.bti.util.UtilDateAndTime;

/**
 * Name of Project: BTI Description: Service ServiceStockCalenderSetup
 * Created on: 
 * Modified on:
 * @author goodtech
 * version :
 */

@Service
public class ServiceStockCalenderSetUp {
	private static final Log LOG = LogFactory.getLog(ServiceStockCalenderSetUp.class);

	@Autowired
	private RepositoryStockCalenderSetUp daoStockCalenderSetup;

	/**
	 * @param dtoStockCalenderSetup
	 * @return
	 */
	
	public DtoStockCalenderSetUp saveorUpdateStockCalenderSetup(DtoStockCalenderSetUp dtoStockCalenderSetup) {
		LOG.info("In save or update Item Category Setup Service");

		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();
		dtoStockCalenderSetup.setCreateDate(utilDateAndTime.localToUTC());
		dtoStockCalenderSetup.setModifyDate(utilDateAndTime.localToUTC());
		StockCalendarSetUp stockCalendarSetup = new StockCalendarSetUp();
		if (dtoStockCalenderSetup.getIdSetup() == 0) {
			BeanUtils.copyProperties(dtoStockCalenderSetup, stockCalendarSetup);
			stockCalendarSetup = daoStockCalenderSetup.save(stockCalendarSetup);
			BeanUtils.copyProperties(stockCalendarSetup, dtoStockCalenderSetup);
		}
		return dtoStockCalenderSetup;
	}

}
