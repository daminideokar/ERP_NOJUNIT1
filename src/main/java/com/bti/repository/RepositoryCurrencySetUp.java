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
import org.springframework.stereotype.Repository;
import com.bti.model.CurrencySetUp;

/**
 * Description: class for the Repository Currency SetUp
 * Name of Project: BTI
 * Created on: NOVEMBER 13, 2017   
 * Modified on:
 * @author GoodTech 
 * Version:
 */

@Repository("Mc40200")
public interface RepositoryCurrencySetUp extends JpaRepository<CurrencySetUp, Integer> {

	@Query("select currencyId from CurrencySetUp currencyId where currencyId.currencyId =:currencyId ")
	public CurrencySetUp getCurrencyById(@Param("currencyId")String currencyId);
	
	public List<CurrencySetUp> findBy(Pageable pageable);

}