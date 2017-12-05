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
import org.springframework.stereotype.Repository;

import com.bti.model.FinancialDimensionsTable;
/**
 * Description: interface for the Repository Financial Dimension Table
 * Name of Project: BTI
 * Created on: Nov 16, 2017
 * Modified on:
 * @author GoodTech 
 * Version:
 */

@Repository("Gl00102")
public interface RepositoryFinancialDimensionsTable extends JpaRepository<FinancialDimensionsTable, Integer> {

	
	@Query("select dimensionDescription from FinancialDimensionsTable dimensionDescription where dimensionDescription.dimensionDescription =:dimensionDescription")
	public FinancialDimensionsTable findBy(@Param("dimensionDescription")String dimensionDescription);
}
