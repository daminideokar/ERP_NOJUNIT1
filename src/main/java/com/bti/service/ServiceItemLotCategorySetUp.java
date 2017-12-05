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

import java.time.LocalDate;
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
import com.bti.model.ItemLotCategorySetUp;
import com.bti.model.dto.DtoItemLotCategorySetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.repository.RepositoryItemLotCategorySetUp;
import com.bti.service.ServiceResponse;
import com.bti.util.UtilDateAndTime;

/**
 * Description:Service Item Lot Category SetUp
 * Name of Project: BTI 
 * Created on: NOVEMBER 08, 2017
 * Modified on:
 * @author GoodTech Version:
 */
@Service
public class ServiceItemLotCategorySetUp {

	@Autowired
	private ServiceResponse serviceResponse;

	@Autowired
	private RepositoryItemLotCategorySetUp repositoryItemLotCategorySetup;

	private static final Log LOG = LogFactory.getLog(ServiceItemLotCategorySetUp.class);

	/**
	 * @param dtoItemCategorySetup
	 * @return
	 */

	public DtoItemLotCategorySetUp saveOrUpdateItemLotCategorySetup(DtoItemLotCategorySetUp dtoItemLotCategorySetup) {
		LOG.info("in save or update of ItemLotCategorySetup");
		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();
		
		ItemLotCategorySetUp itemLotCategorySetup;
		if (dtoItemLotCategorySetup.getLotItemCategoryIndex() == 0) {
			itemLotCategorySetup = new ItemLotCategorySetUp();
			BeanUtils.copyProperties(dtoItemLotCategorySetup, itemLotCategorySetup);
			itemLotCategorySetup.setCreatedDate(utilDateAndTime.localToUTC());
		} else {
			itemLotCategorySetup = repositoryItemLotCategorySetup
					.findOne(dtoItemLotCategorySetup.getLotItemCategoryIndex());
			itemLotCategorySetup.setLotAttribute1(dtoItemLotCategorySetup.getLotAttribute1());
			itemLotCategorySetup.setLotAttribute2(dtoItemLotCategorySetup.getLotAttribute2());
			itemLotCategorySetup.setLotAttribute3(dtoItemLotCategorySetup.getLotAttribute3());
			itemLotCategorySetup.setLotAttribute4(dtoItemLotCategorySetup.getLotAttribute4());
			itemLotCategorySetup.setLotAttribute5(dtoItemLotCategorySetup.getLotAttribute5());
			itemLotCategorySetup.setModifyDate(utilDateAndTime.localToUTC());
		}
		itemLotCategorySetup = repositoryItemLotCategorySetup.save(itemLotCategorySetup);
		BeanUtils.copyProperties(itemLotCategorySetup, dtoItemLotCategorySetup);
		return dtoItemLotCategorySetup;
	}

	/**
	 * @param dtoItemCategorySetup
	 * @return
	 */

	public DtoSearch getItemLotCategorySetupByLotCategory(DtoItemLotCategorySetUp dtoItemLotCategorySetup) {
		LOG.info(" getItemLotCategorySetup by id");
		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoItemLotCategorySetup.getPageNumber());
		dtoSearch.setPageSize(dtoItemLotCategorySetup.getPageSize());
		dtoSearch.setTotalCount((int) repositoryItemLotCategorySetup.count());
		List<ItemLotCategorySetUp> itemLotCategorySetupList;
		if (dtoItemLotCategorySetup.getPageNumber() != null && dtoItemLotCategorySetup.getPageSize() != null) {
			Pageable pageable = new PageRequest(dtoItemLotCategorySetup.getPageNumber(),
					dtoItemLotCategorySetup.getPageSize(), Direction.DESC, "createdDate");
			itemLotCategorySetupList = repositoryItemLotCategorySetup.findByStatus(false, pageable);
		} else {
			itemLotCategorySetupList = repositoryItemLotCategorySetup
					.findByCategory(dtoItemLotCategorySetup.getLotItemCategoryId());
		}
		List<DtoItemLotCategorySetUp> dtoItemLotCategorySetupList = new ArrayList<>();
		if (itemLotCategorySetupList != null && itemLotCategorySetupList.size() > 0) {
			for (ItemLotCategorySetUp itemLotCategorySetup : itemLotCategorySetupList) {
				dtoItemLotCategorySetup = new DtoItemLotCategorySetUp(itemLotCategorySetup);
				dtoItemLotCategorySetupList.add(dtoItemLotCategorySetup);
			}
			dtoSearch.setRecords(dtoItemLotCategorySetupList);
		}

		return dtoSearch;
	}

	/*
	 * @param dtoItemLotCategorySetup
	 * 
	 * @return
	 */

	public DtoSearch getAllItemLotCategory(DtoItemLotCategorySetUp dtoItemLotCategorySetup) {
		LOG.info("in  get all from ItemLotCategorySetup");
		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoItemLotCategorySetup.getPageNumber());
		dtoSearch.setPageSize(dtoItemLotCategorySetup.getPageSize());
		dtoSearch.setTotalCount((int) repositoryItemLotCategorySetup.count());

		List<ItemLotCategorySetUp> itemLotCategorySetupList;
		if (dtoItemLotCategorySetup.getPageNumber() != null && dtoItemLotCategorySetup.getPageSize() != null) {
			Pageable pageable = new PageRequest(dtoItemLotCategorySetup.getPageNumber(),
					dtoItemLotCategorySetup.getPageSize(), Direction.DESC, "createdDate");
			itemLotCategorySetupList = repositoryItemLotCategorySetup.findByStatus(true, pageable);

		} else {
			itemLotCategorySetupList = repositoryItemLotCategorySetup.findByStatusOrderByCreatedDateDesc(false);

		}
		List<DtoItemLotCategorySetUp> dtoItemLotCategorySetupList = new ArrayList<>();
		if (itemLotCategorySetupList != null && itemLotCategorySetupList.size() > 0) {
			for (ItemLotCategorySetUp itemLotCategorySetup : itemLotCategorySetupList) {
				dtoItemLotCategorySetup = new DtoItemLotCategorySetUp(itemLotCategorySetup);
				dtoItemLotCategorySetupList.add(dtoItemLotCategorySetup);
			}
			dtoSearch.setRecords(dtoItemLotCategorySetupList);
		}
		return dtoSearch;
	}

	/*
	 * @param lotItemCategoryIndex
	 * 
	 * @return
	 */

	public DtoItemLotCategorySetUp deleteItemLotCategorySetupByValueCategory(int lotItemCategoryIndex) {
		LOG.info("in delete of ItemLotCategorySetup");
		DtoItemLotCategorySetUp dtoItemLotCategorySetup = new DtoItemLotCategorySetUp();
		dtoItemLotCategorySetup.setDeleteMessage(
				serviceResponse.getStringMessageByShortAndIsDeleted("ITEM_LOT_CATEGORY_VALUE_DELETED", false));

		ItemLotCategorySetUp itemLotCategorySetup = repositoryItemLotCategorySetup.findOne(lotItemCategoryIndex);
		repositoryItemLotCategorySetup.deleteItemLotCategorySetupByValueCategory(true, lotItemCategoryIndex);
		dtoItemLotCategorySetup.setLotItemCategoryIndex(lotItemCategoryIndex);
		dtoItemLotCategorySetup.setStatus(true);

		return dtoItemLotCategorySetup;
	}

}
