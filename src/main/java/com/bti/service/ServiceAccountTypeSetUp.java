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
package com.bti.service;

import java.util.ArrayList;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bti.model.AccountTypeSetUp;

import com.bti.model.dto.DtoAccountTypeSetUp;

import com.bti.model.dto.DtoSearch;
import com.bti.repository.RepositoryAccountTypeSetUp;
import com.bti.util.UtilDateAndTime;
import com.example.Api;

/**
 * Name of Project: BTI 
 * Description: Service AccountTypeSetUp Implementation
 * Created on: NOVEMBER 11,2017
 * Modified on:
 * 
 * @author goodtech
 */
@Service
public class ServiceAccountTypeSetUp{

	private static final Log LOG = LogFactory.getLog(ServiceAccountTypeSetUp.class);
	
	@Autowired
	private RepositoryAccountTypeSetUp repositoryAccountTypeSetUp;

	/**
	 * @param dtoAccountTypeSetUp
	 * @return
	 */
	
	public DtoAccountTypeSetUp saveOrUpdateAccountTypeSetUp(DtoAccountTypeSetUp dtoAccountTypeSetUp) {
		
		System.out.println("Api......"+Api.twoTimes(10));
		
		LOG.info("In save or update method of Account Type SetUp");
		
		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();

		AccountTypeSetUp accountTypeSetUp;
		if (dtoAccountTypeSetUp.getAccountTypeCode() == 0) {

			accountTypeSetUp = new AccountTypeSetUp();
			BeanUtils.copyProperties(dtoAccountTypeSetUp, accountTypeSetUp);
			accountTypeSetUp.setCreateDate(utilDateAndTime.localToUTC());
			accountTypeSetUp.setStatus(false);
		} else {

			accountTypeSetUp = repositoryAccountTypeSetUp.findOne(dtoAccountTypeSetUp.getAccountTypeCode());
			if (accountTypeSetUp.getStatus() == false) {
				accountTypeSetUp.setAccountType(dtoAccountTypeSetUp.getAccountType());
				accountTypeSetUp.setModifDt(utilDateAndTime.localToUTC());
			}
			else{
				return null;
			}

		}
		accountTypeSetUp = repositoryAccountTypeSetUp.save(accountTypeSetUp);
		BeanUtils.copyProperties(accountTypeSetUp, dtoAccountTypeSetUp);

		return dtoAccountTypeSetUp;
	}

	/**
	 * @param dtoAccountTypeSetUp
	 * @return
	 */
	
	public DtoSearch getAllAccountTypeSetUp(DtoAccountTypeSetUp dtoAccountTypeSetUp) {

		
		LOG.info("In getall method of Account Type SetUp");
		
		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoAccountTypeSetUp.getPageNumber());
		dtoSearch.setPageSize(dtoAccountTypeSetUp.getPageSize());
		dtoSearch.setTotalCount((int) repositoryAccountTypeSetUp.count());

		List<AccountTypeSetUp> accountTypeSetUpList;
		if (dtoAccountTypeSetUp.getPageNumber() != null && dtoAccountTypeSetUp.getPageSize() != null) {
			Pageable pageable = new PageRequest(dtoAccountTypeSetUp.getPageNumber(), dtoAccountTypeSetUp.getPageSize(),
					Direction.DESC, "createDate");
			accountTypeSetUpList = repositoryAccountTypeSetUp.findByStatus(false,pageable);
		} else {
			accountTypeSetUpList = repositoryAccountTypeSetUp.findByStatusOrderByCreateDateDesc(false);
		}

		List<DtoAccountTypeSetUp> dtoAccountTypeSetUpList = new ArrayList<>();
		if (accountTypeSetUpList != null && accountTypeSetUpList.size() > 0) {
			for (AccountTypeSetUp accountTypeSetUp : accountTypeSetUpList) {
				dtoAccountTypeSetUp = new DtoAccountTypeSetUp(accountTypeSetUp);
				dtoAccountTypeSetUpList.add(dtoAccountTypeSetUp);

			}
			dtoSearch.setRecords(dtoAccountTypeSetUpList);
		}
		return dtoSearch;

	}

}
