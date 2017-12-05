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
import org.springframework.transaction.annotation.Transactional;
import com.bti.model.ItemCategorySetUp;
/**
 * Name of Project: BTI 
 * Description: Interface for RepositoryItem Category Setup
 * Created on: NOVEMBER 8, 2017
 * Modified on:
 * @author goodtech
 * version :
 */
public interface RepositoryItemCategorySetUp extends JpaRepository<ItemCategorySetUp, Integer>{

	/**
	 * @param pageable
	 * @return
	 */
	public List<ItemCategorySetUp> findBy(Pageable pageable);

	/**
	 * @param
	 * @return
	 */
	public List<ItemCategorySetUp> findByOrderByCreateDateDesc(boolean status);
	
	/**
	 * @param itemCategory
	 * @return
	 */
	@Query("select itemcategorysetup from ItemCategorySetUp itemcategorysetup where itemcategorysetup.itemCategory =:itemCategory and itemcategorysetup.status =false")
	public List<ItemCategorySetUp> findByCategory(@Param("itemCategory") String itemCategory);
	
	/**
	 * @param status
	 * @param itemCategoryIndex
	 */
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update ItemCategorySetUp itemcategorysetup set itemcategorysetup.status =:status where itemcategorysetup.itemCategoryIndex =:itemCategoryIndex ")
	public void deleteItemCategorySetupByValueCategory(@Param("status") Boolean status, @Param("itemCategoryIndex") Integer itemCategoryIndex);
}
