/**
 * BTI - BAAN for Technology And Trade IntL. 
 * Copyright � 2017 BTI. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF BTI. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF BTI.
 */
package com.bti.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bti.model.AccountTypeSetUp;
import com.bti.model.InventoryClassSetUpCurrency;
import com.bti.model.PriceGroupSetUp;

/**
 * Description: interface for the Repository Inventory Class SetUp Currency
 * Name of Project: BTI 
 * Created on: NOVEMBER 12, 2017 
 * Modified on:
 * 
 * @author GoodTech Version:
 */
public interface RepositoryInventoryClassSetupCurrency extends JpaRepository<InventoryClassSetUpCurrency, Integer> {

	public List<InventoryClassSetUpCurrency> findBy(Pageable pageable);

	public List<InventoryClassSetUpCurrency> findByOrderByCreateDateDesc();

	public List<InventoryClassSetUpCurrency> findByStatusOrderByCreateDateDesc(Boolean status);
}
