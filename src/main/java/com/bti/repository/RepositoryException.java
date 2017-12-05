/**
 * BTI - BAAN for Technology And Trade IntL. 
 * Copyright � 2017 BTI. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF BTI. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF BTI.
 */
package com.bti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bti.model.BtiMessage;

/**
 * Name of Project: BTI 
 * Description: Interface for RepositoryException
 * Created on: NOVEMBER 1, 2017
 * Modified on:
 * @author goodtech
 * version :
 */

@Repository("repositoryException")
public interface RepositoryException extends JpaRepository<BtiMessage, Integer> {

	/**
	 * @param message
	 * @param deleted
	 * @return
	 */
	public BtiMessage findByMessageShortAndIsDeleted(String message, boolean deleted);
}
