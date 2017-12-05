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
package com.bti.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.bti.model.PriceGroupSetUp;
import com.bti.model.PriceLevelSetUp;

/**
 * Description: interface for the Repository Price Level SetUp
 * Name of Project: BTI
 * Created on:  Nov 07, 2017 
 * Modified on: 
 * @author GoodTech
 * Version: 
 */
@Repository("Iv40300")
public interface RepositoryPriceLevelSetUp extends JpaRepository<PriceLevelSetUp, Integer>{

	public PriceLevelSetUp findByPriceLevelId(String priceLevelId);
	public List<PriceLevelSetUp> findBy(Pageable pageable);
	public List<PriceLevelSetUp> findByStatusOrderByCreatedDateDesc(Boolean status);

	/**
	 * @param priceLevelId
	 * @return
	 */
	@Query("select priceLevelSetUp from PriceLevelSetUp priceLevelSetUp where priceLevelSetUp.priceLevelId =:priceLevelId")
	public PriceLevelSetUp findBy(@Param("priceLevelId") String priceLevelId);

	
}
