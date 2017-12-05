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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bti.model.CurrencySetUp;
import com.bti.model.InventoryClassSetUpCurrency;
import com.bti.model.ItemClassSetUp;
import com.bti.model.dto.DtoInventoryClassSetupCurrency;
import com.bti.model.dto.DtoSearch;
import com.bti.repository.RepositoryCurrencySetUp;
import com.bti.repository.RepositoryInventoryClassSetupCurrency;
import com.bti.repository.RepositoryItemClassSetUp;
import com.bti.util.UtilDateAndTime;

/**
 * Description:Service Inventory Class SetUp Currency
 * Name of Project: BTI 
 * Created on: Nov 07, 2017 
 * Modified on:
 * @author GoodTech
 * Version:
 */
@Service
public class ServiceInventoryClassSetupCurrency {
	@Autowired
	private RepositoryInventoryClassSetupCurrency repositoryInventoryClassSetupCurrency;
	@Autowired
	private RepositoryItemClassSetUp repositoryItemClassSetup;

	@Autowired
	private RepositoryCurrencySetUp repositoryCurrencySetUp;

	public DtoInventoryClassSetupCurrency saveOrUpdateCurrency(
			DtoInventoryClassSetupCurrency dtoInventoryClassSetupCurrency) {
		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();
		ItemClassSetUp itemClassSetUp = repositoryItemClassSetup
				.findBy(dtoInventoryClassSetupCurrency.getItemClassId());

		CurrencySetUp currencySetUp = repositoryCurrencySetUp
				.getCurrencyById(dtoInventoryClassSetupCurrency.getCurrencyId());
		InventoryClassSetUpCurrency inventoryClassSetUpCurrency = new InventoryClassSetUpCurrency();
		if (dtoInventoryClassSetupCurrency.getInventoryClassSetUpCurrencyIndex() == 0) {

			if (itemClassSetUp != null && currencySetUp != null) {

				BeanUtils.copyProperties(dtoInventoryClassSetupCurrency, inventoryClassSetUpCurrency);
				inventoryClassSetUpCurrency.setCreateDate(utilDateAndTime.localToUTC());
				inventoryClassSetUpCurrency.setStatus(false);
				inventoryClassSetUpCurrency.setIv40400(itemClassSetUp);
				inventoryClassSetUpCurrency.setMc40200(currencySetUp);
			}

		} else {
			inventoryClassSetUpCurrency = new InventoryClassSetUpCurrency();
			inventoryClassSetUpCurrency = repositoryInventoryClassSetupCurrency
					.findOne(dtoInventoryClassSetupCurrency.getInventoryClassSetUpCurrencyIndex());
			if (inventoryClassSetUpCurrency.getStatus() == false) {

				inventoryClassSetUpCurrency.setCurrencyDecimal(dtoInventoryClassSetupCurrency.getCurrencyDecimal());
				inventoryClassSetUpCurrency.setModifyDate(utilDateAndTime.localToUTC());

			} else {
				return dtoInventoryClassSetupCurrency;
			}
		}
		inventoryClassSetUpCurrency = repositoryInventoryClassSetupCurrency.save(inventoryClassSetUpCurrency);
		BeanUtils.copyProperties(inventoryClassSetUpCurrency, dtoInventoryClassSetupCurrency);

		return dtoInventoryClassSetupCurrency;

	}

	public DtoSearch getAllInventoryCurrencySetUp(DtoInventoryClassSetupCurrency dtoInventoryClassSetupCurrency) {

		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoInventoryClassSetupCurrency.getPageNumber());
		dtoSearch.setPageSize(dtoInventoryClassSetupCurrency.getPageSize());
		dtoSearch.setTotalCount((int) repositoryInventoryClassSetupCurrency.count());

		List<InventoryClassSetUpCurrency> inventoryClassSetUpCurrencyList;
		if (dtoInventoryClassSetupCurrency.getPageNumber() != null
				&& dtoInventoryClassSetupCurrency.getPageSize() != null) {
			Pageable pageable = new PageRequest(dtoInventoryClassSetupCurrency.getPageNumber(),
					dtoInventoryClassSetupCurrency.getPageSize(), Direction.DESC, "createDate");
			inventoryClassSetUpCurrencyList = repositoryInventoryClassSetupCurrency.findBy(pageable);
		} else {
			inventoryClassSetUpCurrencyList = repositoryInventoryClassSetupCurrency
					.findByStatusOrderByCreateDateDesc(false);
		}

		List<DtoInventoryClassSetupCurrency> dtoInventoryClassSetupCurrencies = new ArrayList<>();
		if (inventoryClassSetUpCurrencyList != null && inventoryClassSetUpCurrencyList.size() > 0) {
			for (InventoryClassSetUpCurrency inventoryClassSetUpCurrency : inventoryClassSetUpCurrencyList) {

				dtoInventoryClassSetupCurrency = new DtoInventoryClassSetupCurrency(inventoryClassSetUpCurrency);
				dtoInventoryClassSetupCurrencies.add(dtoInventoryClassSetupCurrency);

			}

			dtoSearch.setRecords(dtoInventoryClassSetupCurrencies);
		}
		return dtoSearch;
	}

}
