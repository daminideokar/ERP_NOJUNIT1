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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bti.model.BillOfMaterialSetUp;

/**
 * Description: Interface for RepositoryBillOfMaterialSetUp
 * Name of Project: BTI
 * Created on: NOVEMBER 8,2017 
 * Modified on:
 * 
 * @author goodtech Version:
 */

public interface RepositoryBillOfMaterialSetUp extends JpaRepository<BillOfMaterialSetUp, Integer> {

	/**
	 * @param nextDocumentNumber
	 * @param status
	 * @return
	 */
	public BillOfMaterialSetUp findByNextDocumentNumberAndStatus(int nextDocumentNumber, Boolean status);

	/**
	 * @param nextDocumentNumber
	 * @return
	 */
	public BillOfMaterialSetUp findByNextDocumentNumber(int nextDocumentNumber);
	
	
	/**
	 * @param deleted
	 * @param updateById
	 * @param companyId
	 */
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update BillOfMaterialSetUp billOfMaterialSetUp set billOfMaterialSetUp.status =:status  where billOfMaterialSetUp.nextDocumentNumber =:nextDocumentNumber ")
	public void deleteSingleRecord(@Param("status") Boolean status,
			@Param("nextDocumentNumber") int nextDocumentNumber);
}
