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

import com.bti.model.AccountTypeSetUp;
import com.bti.model.PriceGroupSetUp;

/**
 * Name of Project: BTI 
 * Description: Repository AccountTypeSetUp 
 * Created on:NOVEMBER 11,2017
 * Modified on:
 * 
 * @author goodtech
 */
public interface RepositoryAccountTypeSetUp extends JpaRepository<AccountTypeSetUp, Integer> {

	/**
	 * @param pageable
	 * @return
	 */
	public List<AccountTypeSetUp> findByStatus(Boolean status,Pageable pageable);

	/**
	 * @param status
	 * @return
	 */
	public List<AccountTypeSetUp> findByStatusOrderByCreateDateDesc(Boolean status);

}
