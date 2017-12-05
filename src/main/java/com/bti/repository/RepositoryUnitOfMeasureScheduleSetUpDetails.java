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
import com.bti.model.InventoryUnitOfMeasureScheduleSetUpDetails;

/**
 * Name of Project: BTI 
 * Description: Repository Unit Of Measure Schedule SetUp Details
 * Created on:NOVEMBER 14,2017
 * Modified on:
 * 
 * @author goodtech
 */
public interface RepositoryUnitOfMeasureScheduleSetUpDetails extends JpaRepository<InventoryUnitOfMeasureScheduleSetUpDetails, Integer>{


	/**
	 * @param pageable
	 * @return
	 */
	public List<InventoryUnitOfMeasureScheduleSetUpDetails> findByStatus(Boolean status,Pageable pageable);

	/**
	 * @param status
	 * @return
	 */
	public List<InventoryUnitOfMeasureScheduleSetUpDetails> findByStatusOrderByCreateDateDesc(Boolean status);

}
