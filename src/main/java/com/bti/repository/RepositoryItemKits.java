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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bti.model.ItemKits;
import com.bti.model.ItemMaintenance;
import com.bti.model.dto.DtoItemKits;
/**
 * Name of Project: BTI 
 * Description: Repository ItemKitSetUp 
 * Created on:NOVEMBER 24,2017
 * Modified on:
 * 
 * @author goodtech
 */
public interface RepositoryItemKits extends JpaRepository<ItemKits, Integer>{


	/**
	 * @param status
	 * @return
	 */
	@Query("select itemKits from ItemKits itemKits where itemKits.iv001012=:iv001012 and itemKits.status=:status")
	public List<ItemKits> findByiv001012AndStatus(@Param("iv001012")ItemMaintenance iv001012,@Param("status")Boolean status);
	

	/**
	 * @param status
	 * @return
	 */
	@Query("select count(iv001011) from ItemKits itemKits where itemKits.status=:status and itemKits.iv001011=:iv001011")
	public int getCount(@Param("iv001011")ItemMaintenance iv001011, @Param("status")Boolean status);
	
	
	
}
