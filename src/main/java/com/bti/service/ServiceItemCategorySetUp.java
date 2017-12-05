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
import com.bti.model.ItemCategorySetUp;
import com.bti.model.dto.DtoItemCategorySetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.repository.RepositoryItemCategorySetUp;
import com.bti.service.ServiceResponse;
import com.bti.util.UtilDateAndTime;

/**
 * Description: Service Item Category Setup
 * Name of Project: BTI 
 * Created on:NOVEMBER 8, 2017 
 * Modified on:
 * @author goodtech 
 * Version:
 */

@Service
public class ServiceItemCategorySetUp {

	private static final Log LOG = LogFactory.getLog(ServiceItemCategorySetUp.class);

	@Autowired
	RepositoryItemCategorySetUp repositoryItemCategorySetup;

	@Autowired
	ServiceResponse serviceResponse;

	/**
	 * @param dtoItemCategorySetup
	 * @return
	 */
	
	public DtoItemCategorySetUp saveOrUpdateItemCategorySetup(DtoItemCategorySetUp dtoItemCategorySetup) {

		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();
		ItemCategorySetUp itemCategorySetup;
		LOG.info("In save or update Item Category Setup Service");
		if (dtoItemCategorySetup.getItemCategoryIndex() == 0) {

			itemCategorySetup = new ItemCategorySetUp();
			BeanUtils.copyProperties(dtoItemCategorySetup, itemCategorySetup);
			itemCategorySetup.setCreateDate(utilDateAndTime.localToUTC());

		} else {

			itemCategorySetup = repositoryItemCategorySetup.findOne(dtoItemCategorySetup.getItemCategoryIndex());
			itemCategorySetup.setModifyDate(utilDateAndTime.localToUTC());
			itemCategorySetup.setItemCategoryValueDescription(dtoItemCategorySetup.getItemCategoryValueDescription());
			itemCategorySetup.setItemCategoryValueDescriptionArabic(
					dtoItemCategorySetup.getItemCategoryValueDescriptionArabic());

		}
		itemCategorySetup.setModifyDate(utilDateAndTime.localToUTC());
		itemCategorySetup = repositoryItemCategorySetup.save(itemCategorySetup);
		BeanUtils.copyProperties(itemCategorySetup, dtoItemCategorySetup);
		return dtoItemCategorySetup;
	}

	/**
	 * @param dtoItemCategorySetup
	 * @return
	 */


	public DtoSearch getItemCategorySetupByCategory(DtoItemCategorySetUp dtoItemCategorySetup) {
		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoItemCategorySetup.getPageNumber());
		dtoSearch.setPageSize(dtoItemCategorySetup.getPageSize());
		dtoSearch.setTotalCount((int) repositoryItemCategorySetup.count());
		LOG.info("In get Item Category Setup Service");
		List<ItemCategorySetUp> itemCategorySetupList;
		if (dtoItemCategorySetup.getPageNumber() != null && dtoItemCategorySetup.getPageSize() != null) {
			Pageable pageable = new PageRequest(dtoItemCategorySetup.getPageNumber(),
					dtoItemCategorySetup.getPageSize(), Direction.DESC, "createDate");

			itemCategorySetupList = repositoryItemCategorySetup.findBy(pageable);
		} else {
			itemCategorySetupList = repositoryItemCategorySetup.findByCategory(dtoItemCategorySetup.getItemCategory());
		}
		List<DtoItemCategorySetUp> dtoItemCategorySetupList = new ArrayList<>();
		if (itemCategorySetupList != null && itemCategorySetupList.size() > 0) {

			for (ItemCategorySetUp ItemCategorySetup : itemCategorySetupList) {

				dtoItemCategorySetup = new DtoItemCategorySetUp(ItemCategorySetup);
				dtoItemCategorySetupList.add(dtoItemCategorySetup);
			}
			dtoSearch.setRecords(dtoItemCategorySetupList);
		}

		return dtoSearch;
	}

	/**
	 * @param itemCategoryIndex
	 * @return
	 */
	
	public DtoItemCategorySetUp deleteItemCategorySetupByValueCategory(int itemCategoryIndex) {

		DtoItemCategorySetUp dtoItemCategorySetup = new DtoItemCategorySetUp();
		LOG.info("In delete Item Category Setup Service");
		dtoItemCategorySetup
				.setDeleteMessage(serviceResponse.getStringMessageByShortAndIsDeleted("Category_Value_DELETED", false));
		ItemCategorySetUp itemCategorySetup = repositoryItemCategorySetup.findOne(itemCategoryIndex);
		if (itemCategorySetup.getItemCategoryIndex() == 0) {
			dtoItemCategorySetup.setItemCategoryIndex(0);
		} else {
			
			repositoryItemCategorySetup.deleteItemCategorySetupByValueCategory(true, itemCategoryIndex);
			dtoItemCategorySetup.setItemCategoryIndex(itemCategoryIndex);
			dtoItemCategorySetup.setStatus(true);
		}
		return dtoItemCategorySetup;
	}

}
