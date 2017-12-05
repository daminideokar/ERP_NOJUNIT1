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
import com.bti.model.InventoryUnitOfMeasureScheduleSetUp;

/**
 * Name of Project: BTI 
 * Description: Repository Unit Of Measure Schedule SetUp
 * Created on:NOVEMBER 13,2017
 * Modified on:
 * 
 * @author goodtech
 */
public interface RepositoryUnitOfMeasureScheduleSetUp extends JpaRepository<InventoryUnitOfMeasureScheduleSetUp, Integer>{


	/**
	 * @param pageable
	 * @return
	 */
	public List<InventoryUnitOfMeasureScheduleSetUp> findByStatus(Boolean status,Pageable pageable);

	/**
	 * @param status
	 * @return
	 */
	public List<InventoryUnitOfMeasureScheduleSetUp> findByStatusOrderByCreateDateDesc(Boolean status);

	
	public InventoryUnitOfMeasureScheduleSetUp findByUominx(int uominx);
	

	/**
	 * @param unitOfMeasureId
	 * @param status
	 * @return
	 */
	public InventoryUnitOfMeasureScheduleSetUp findByUnitOfMeasureIdAndStatus(String unitOfMeasureId, Boolean status);

}
