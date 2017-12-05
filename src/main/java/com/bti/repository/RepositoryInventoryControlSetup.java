
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
import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bti.model.InventoryControlSetUp;
import com.bti.model.PriceLevelSetUp;
/**
 * Description: class for the Repository Inventory Control SetUp
 * Name of Project: BTI
 * Created on: NOVEMBER 16, 2017
 * Modified on:
 * @author GoodTech 
 * Version:
 */

@Repository("Iv40000")
public interface RepositoryInventoryControlSetup extends JpaRepository<InventoryControlSetUp, Integer>{

	
	/**
	 * @param keySetupId
	 * @return
	 */
	
	@Query("select inventoryControlSetUp from InventoryControlSetUp inventoryControlSetUp where inventoryControlSetUp.keySetupId =:keySetupId")
	public InventoryControlSetUp findBy(@Param ("keySetupId") int keySetupId);
	
	/**
	 * @param pageable
	 */
	public List<InventoryControlSetUp> findBy(Pageable pageable);
	public List<InventoryControlSetUp> findByStatus(Boolean status);
		
	/**
	 * @param status
	 * @param keySetupId
	 */
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update InventoryControlSetUp inventoryControlSetUp set inventoryControlSetUp.status =:status where inventoryControlSetUp.keySetupId =:keySetupId ")
	public void deleteInventoryControlSetupByValueCategory(@Param("status") Boolean status,
			@Param("keySetupId") Integer keySetupId);
}
