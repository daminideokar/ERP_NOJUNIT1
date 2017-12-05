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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bti.model.PriceGroupSetUp;
import com.bti.model.VatSetUp;

/**
 * Name of Project: BTI 
 * Description: Repository Vat SetUp
 * Created on:NOVEMBER 14,2017
 * Modified on:
 * 
 * @author goodtech
 */
public interface RepositoryVatSetUp extends JpaRepository<VatSetUp, Integer>{

	/**
	 * @param priceGroupId
	 * @return
	 */
	@Query("select vatSetUp from VatSetUp vatSetUp where vatSetUp.taxSchdId =:taxSchdId")
	public VatSetUp findBy(@Param("taxSchdId") int taxSchdId);
}
