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

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bti.model.CurrencySetUp;
import com.bti.model.PriceLevelSetUp;
import com.bti.model.dto.DtoCurrencySetUp;

import com.bti.repository.RepositoryCurrencySetUp;


/**
 * Description:Service Currency SetUp 
 * Name of Project: BTI
 * Created on: NOVEMBER 13, 2017 
 * Modified on:
 * @author GoodTech 
 * Version:
 */
@Service
public class ServiceCurrencySetUp {

	@Autowired
	private RepositoryCurrencySetUp repositoryCurrencySetUp;

	/**
	 * @param dtoCurrencySetUp
	 * @return
	 */

	public DtoCurrencySetUp getByCurrencyId(DtoCurrencySetUp dtoCurrencySetUp) {

		CurrencySetUp currencySetUp = repositoryCurrencySetUp.getCurrencyById(dtoCurrencySetUp.getCurrencyId());

		if (currencySetUp == null) {

			return null;

		}
		BeanUtils.copyProperties(currencySetUp, dtoCurrencySetUp);
		return dtoCurrencySetUp;
	}

	

}
