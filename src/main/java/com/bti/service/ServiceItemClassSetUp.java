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
import com.bti.model.InventoryUnitOfMeasureScheduleSetUp;
import com.bti.model.ItemClassSetUp;
import com.bti.model.ItemLotCategorySetUp;
import com.bti.model.PriceGroupSetUp;
import com.bti.model.PriceLevelSetUp;
import com.bti.model.dto.DtoItemClassSetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.repository.RepositoryItemClassSetUp;
import com.bti.repository.RepositoryItemLotCategorySetUp;
import com.bti.repository.RepositoryPriceGroupSetup;
import com.bti.repository.RepositoryPriceLevelSetUp;
import com.bti.repository.RepositoryUnitOfMeasureScheduleSetUp;
import com.bti.repository.RepositoryVatSetUp;
import com.bti.service.ServiceResponse;
import com.bti.util.UtilDateAndTime;

/*
 * int => Integer
 * boolean => Boolean
 * 
 * */

/**
 * Description: Service Item Class Setup 
 * Name of Project: BTI 
 * Created on:NOVEMBER 10, 2017 
 * Modified on:
 * 
 * @author goodtech Version:
 */
@Service
public class ServiceItemClassSetUp {
	private static final Log LOG = LogFactory.getLog(ServiceItemClassSetUp.class);

	@Autowired
	RepositoryItemClassSetUp repositoryItemClassSetup;

	@Autowired
	RepositoryItemLotCategorySetUp repositoryItemLotCategorySetup;

	@Autowired
	private RepositoryUnitOfMeasureScheduleSetUp repositoryUnitOfMeasureScheduleSetUp;

	@Autowired
	RepositoryPriceGroupSetup repositoryPriceGroupSetup;

	@Autowired
	RepositoryPriceLevelSetUp repositoryPriceLevelSetup;

	@Autowired
	ServiceResponse serviceResponse;
	
	@Autowired
	RepositoryVatSetUp repositoryVatSetUp;

	/**
	 * @param dtoItemClassSetup
	 * @return
	 */
	
	public DtoItemClassSetUp saveOrUpdateItemClassSetup(DtoItemClassSetUp dtoItemClassSetup) {
		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();
		ItemClassSetUp itemClassSetup = new ItemClassSetUp();
		LOG.info("In save or update Item Class Setup Service");
		ItemLotCategorySetUp itemLotCategorySetUp = repositoryItemLotCategorySetup
				.findBy(dtoItemClassSetup.getLotItemCategoryId());
		InventoryUnitOfMeasureScheduleSetUp inventoryUnitOfMeasureScheduleSetUp = repositoryUnitOfMeasureScheduleSetUp
				.findByUnitOfMeasureIdAndStatus(dtoItemClassSetup.getUnitOfMeasureId(),false);

		PriceGroupSetUp priceGroupSetUp = repositoryPriceGroupSetup.getByPriceGroupId(dtoItemClassSetup.getPriceGroupId());
		PriceLevelSetUp priceLevelSetUp = repositoryPriceLevelSetup.findBy(dtoItemClassSetup.getPriceLevelId());

		if (itemLotCategorySetUp != null && inventoryUnitOfMeasureScheduleSetUp != null && priceGroupSetUp != null
				&& priceLevelSetUp != null ) {

			dtoItemClassSetup.setIv40001(itemLotCategorySetUp);
			dtoItemClassSetup.setIv40100(inventoryUnitOfMeasureScheduleSetUp);
			dtoItemClassSetup.setIv40301(priceGroupSetUp);
			dtoItemClassSetup.setIv40300(priceLevelSetUp);
			

			if (dtoItemClassSetup.getItemClassIndex() == 0) {
				BeanUtils.copyProperties(dtoItemClassSetup, itemClassSetup);
				itemClassSetup.setCreateDate(utilDateAndTime.localToUTC());

			} else {

				itemClassSetup = repositoryItemClassSetup.findOne(dtoItemClassSetup.getItemClassIndex());
				itemClassSetup.setItemClassId(dtoItemClassSetup.getItemClassId());
				itemClassSetup.setItemClassDescription(dtoItemClassSetup.getItemClassDescription());
				itemClassSetup.setItemClassDescriptionArabic(dtoItemClassSetup.getItemClassDescriptionArabic());
				itemClassSetup.setItemGenericDescription(dtoItemClassSetup.getItemGenericDescription());
				itemClassSetup.setItemGenericDescriptionArabic(dtoItemClassSetup.getItemGenericDescriptionArabic());
				itemClassSetup.setItemType(dtoItemClassSetup.getItemType());
				itemClassSetup.setValuationMethod(dtoItemClassSetup.getValuationMethod());
				itemClassSetup.setTrack(dtoItemClassSetup.getTrack());
				itemClassSetup.setWarningFeature(dtoItemClassSetup.getWarningFeature());
				itemClassSetup.setAllowBackOrders(dtoItemClassSetup.getAllowBackOrders());
				itemClassSetup
						.setRevalueInventoryForCostVariance(dtoItemClassSetup.getRevalueInventoryForCostVariance());
				itemClassSetup.setQuantityDecimals(dtoItemClassSetup.getQuantityDecimals());
				itemClassSetup.setPriceMethod(dtoItemClassSetup.getPriceMethod());
				

			}
			itemClassSetup.setStatus(false);
			itemClassSetup.setModifyDate(utilDateAndTime.localToUTC());
			itemClassSetup = repositoryItemClassSetup.save(itemClassSetup);
			BeanUtils.copyProperties(itemClassSetup, dtoItemClassSetup);
			return dtoItemClassSetup;
		} else {
			return dtoItemClassSetup;

		}

	}
	/**
	 * @param dtoItemClassSetup
	 * @return
	 */
	
	public DtoItemClassSetUp getByItemClassId(DtoItemClassSetUp dtoItemClassSetup) {
	
		ItemClassSetUp itemClassSetUp = repositoryItemClassSetup.findBy(dtoItemClassSetup.getItemClassId());
	
		if (itemClassSetUp == null) {
			return null ;
			
		}
		BeanUtils.copyProperties(itemClassSetUp, dtoItemClassSetup);
		
		return dtoItemClassSetup;
	}
	/**
	 * @param dtoItemClassSetup
	 * @return
	 */
	public DtoSearch getItemClassSetup(DtoItemClassSetUp dtoItemClassSetup) {
		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoItemClassSetup.getPageNumber());
		dtoSearch.setPageSize(dtoItemClassSetup.getPageSize());
		dtoSearch.setTotalCount((int) repositoryItemClassSetup.count());
		LOG.info("In get Item Class Setup Service");

		List<ItemClassSetUp> itemClassSetupList;
		if (dtoItemClassSetup.getPageNumber() != null && dtoItemClassSetup.getPageSize() != null) {
			Pageable pageable = new PageRequest(dtoItemClassSetup.getPageNumber(), dtoItemClassSetup.getPageSize(),
					Direction.ASC, "createDate");
			itemClassSetupList = repositoryItemClassSetup.findBy(pageable);
		} else {

			itemClassSetupList = repositoryItemClassSetup.findByStatusOrderByCreateDateDesc(false);
		}
		List<DtoItemClassSetUp> dtoItemClassSetupList = new ArrayList<>();
		if (itemClassSetupList != null && itemClassSetupList.size() > 0) {

			for (ItemClassSetUp itemClassSetup : itemClassSetupList) {

				dtoItemClassSetup = new DtoItemClassSetUp(itemClassSetup);
				dtoItemClassSetupList.add(dtoItemClassSetup);
			}
			dtoSearch.setRecords(dtoItemClassSetupList);
		}
		return dtoSearch;
	}

	/**
	 * @param itemClassIndex
	 * @return
	 */

	public DtoItemClassSetUp deleteItemClassSetup(int itemClassIndex) {

		DtoItemClassSetUp dtoItemClassSetup = new DtoItemClassSetUp();
		dtoItemClassSetup
				.setDeleteMessage(serviceResponse.getStringMessageByShortAndIsDeleted("Item_Class_DELETED", false));
		LOG.info("In delete Item Class Setup Service");

		ItemClassSetUp ItemClassSetup = repositoryItemClassSetup.findOne(itemClassIndex);
		if (ItemClassSetup.getItemClassIndex() == 0) {
			dtoItemClassSetup.setItemClassIndex(0);
		} else {

			repositoryItemClassSetup.deleteItemClassSetup(true, itemClassIndex);
			dtoItemClassSetup.setItemClassIndex(itemClassIndex);
			dtoItemClassSetup.setStatus(true);

		}
		return dtoItemClassSetup;
	}

}
