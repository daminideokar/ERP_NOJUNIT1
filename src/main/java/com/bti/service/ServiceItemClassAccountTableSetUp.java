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
package com.bti.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bti.model.CurrencySetUp;
import com.bti.model.InventoryClassSetUpCurrency;
import com.bti.model.ItemClassAccountTableSetUp;
import com.bti.model.ItemClassSetUp;
import com.bti.model.dto.DtoInventoryClassSetupCurrency;
import com.bti.model.dto.DtoItemClassAccountTableSetUp;
import com.bti.repository.RepositoryItemClassAccountTableSetup;
import com.bti.repository.RepositoryItemClassSetUp;
import com.bti.util.UtilDateAndTime;

/**
 * Description:Service Item CLass Account Table SetUp
 * Name of Project: BTI
 * Created on: NOVEMBER 15, 2017
 * Modified on:
 * @author GoodTech
 * Version:
 */
@Service
public class ServiceItemClassAccountTableSetUp {
	@Autowired
	private RepositoryItemClassAccountTableSetup repositoryItemClassAccountTableSetup;

	@Autowired
	private RepositoryItemClassSetUp repositoryItemClassSetup;

	public DtoItemClassAccountTableSetUp saveOrUpdateAccountTableSetUp(
			DtoItemClassAccountTableSetUp dtoItemClassAccountTableSetup) {

		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();

		ItemClassSetUp itemClassSetUp = repositoryItemClassSetup.findBy(dtoItemClassAccountTableSetup.getItemClassId());
		ItemClassAccountTableSetUp itemClassAccountTableSetup = new ItemClassAccountTableSetUp();
		if (dtoItemClassAccountTableSetup.getItemClassAccountTableSetupIndex() == 0) {
			if (itemClassSetUp != null) {
				BeanUtils.copyProperties(dtoItemClassAccountTableSetup, itemClassAccountTableSetup);
				itemClassAccountTableSetup.setCreateDate(utilDateAndTime.localToUTC());
				itemClassAccountTableSetup.setStatus(false);
				itemClassAccountTableSetup.setIv40400(itemClassSetUp);
			}
		} else {
			itemClassAccountTableSetup = new ItemClassAccountTableSetUp();
			itemClassAccountTableSetup = repositoryItemClassAccountTableSetup
					.findOne(dtoItemClassAccountTableSetup.getItemClassAccountTableSetupIndex());
			if (itemClassAccountTableSetup.getStatus() == false) {
				itemClassAccountTableSetup.setIv40400(itemClassSetUp);
				itemClassAccountTableSetup.setModifyByUserId(dtoItemClassAccountTableSetup.getModifyByUserId());
				itemClassAccountTableSetup.setModifyDate(utilDateAndTime.localToUTC());
			} else {
				return dtoItemClassAccountTableSetup;
			}
		}
		itemClassAccountTableSetup = repositoryItemClassAccountTableSetup.save(itemClassAccountTableSetup);
		BeanUtils.copyProperties(itemClassAccountTableSetup, dtoItemClassAccountTableSetup);
		return dtoItemClassAccountTableSetup;
	}

}
