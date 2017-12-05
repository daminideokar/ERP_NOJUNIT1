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
import org.springframework.stereotype.Repository;

import com.bti.model.InventoryClassSetUpCurrency;
import com.bti.model.ItemClassAccountTableSetUp;

/**
 * Description: interface for the Repository Item Class Account Teble SetUp
 * Name of Project: BTI 
 * Created on: NOVEMBER 13, 2017 
 * Modified on:
 * @author GoodTech Version:
 */
@Repository("IV40402")
public interface RepositoryItemClassAccountTableSetup extends JpaRepository<ItemClassAccountTableSetUp, Integer> {

	public List<ItemClassAccountTableSetUp> findBy(Pageable pageable);

	public List<ItemClassAccountTableSetUp> findByOrderByCreateDateDesc();

	public List<ItemClassAccountTableSetUp> findByStatusOrderByCreateDateDesc(Boolean status);
}
