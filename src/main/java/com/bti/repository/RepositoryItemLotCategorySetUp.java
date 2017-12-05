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
import com.bti.model.ItemLotCategorySetUp;

/**
 * Description: interface for the Repository Item Lot Category SetUp
 * Name of Project: BTI 
 * Created on: NOVEMBER 08, 2017 
 * Modified on: 
 * @author GoodTech 
 * Version:
 */
@Repository("Iv40001")
public interface RepositoryItemLotCategorySetUp extends JpaRepository<ItemLotCategorySetUp, Integer> {

	/**
	 * @param pageable
	 * @return
	 */
	public List<ItemLotCategorySetUp> findByStatus(Boolean status, Pageable pageable);

	/**
	 * @param
	 * @return
	 */
	public List<ItemLotCategorySetUp> findByStatusOrderByCreatedDateDesc(Boolean status);

	/**
	 * @param lotItemCategoryId
	 * @return
	 */
	@Query("select itemLotCategorySetup from ItemLotCategorySetUp itemLotCategorySetup where itemLotCategorySetup.lotItemCategoryId =:lotItemCategoryId and itemLotCategorySetup.status =false")
	public List<ItemLotCategorySetUp> findByCategory(@Param("lotItemCategoryId") String lotItemCategoryId);

	/**
	 * @param status
	 * @param lotItemCategoryIndex
	 */
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update ItemLotCategorySetUp itemLotCategorySetup set itemLotCategorySetup.status =:status where itemLotCategorySetup.lotItemCategoryIndex =:lotItemCategoryIndex ")
	public void deleteItemLotCategorySetupByValueCategory(@Param("status") Boolean status,
			@Param("lotItemCategoryIndex") Integer lotItemCategoryIndex);
	

	/**
	 * @param lotCatId
	 * @return
	 */
	@Query("select itemLotCategorySetup from ItemLotCategorySetUp itemLotCategorySetup where itemLotCategorySetup.lotItemCategoryId =:lotCatId")
	public ItemLotCategorySetUp findBy(@Param("lotCatId") String lotCatId);
}
