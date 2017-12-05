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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bti.model.PriceGroupSetUp;

/**
 * Description: Interface for RepositoryPriceGroupSetup 
 * Name of Project: BTI
 * Created on:NOVEMBER 6,2017
 * Modified on:
 * 
 * @author goodtech Version:
 */
public interface RepositoryPriceGroupSetup extends JpaRepository<PriceGroupSetUp, Integer> {
	/**
	 * @param priceGroupId
	 * @return
	 */
	@Query("select priceGroupSetUp from PriceGroupSetUp priceGroupSetUp where priceGroupSetUp.priceGroupId=:priceGroupId")
	public PriceGroupSetUp getByPriceGroupId(@Param("priceGroupId") String priceGroupId);

	/**
	 * @param pageable
	 * @return
	 */
	public List<PriceGroupSetUp> findBy(Pageable pageable);

	public List<PriceGroupSetUp> findByOrderByCreateDateDesc();

}
