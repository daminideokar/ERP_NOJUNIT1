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

import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.Assertions.setAllowComparingPrivateFields;
import static org.mockito.Matchers.intThat;

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
import com.bti.model.FinancialDimensionsTable;
import com.bti.model.InventoryControlSetUp;
import com.bti.model.dto.DtoInventoryControlSetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.repository.RepositoryFinancialDimensionsTable;
import com.bti.repository.RepositoryInventoryControlSetup;
import com.bti.service.ServiceResponse;
import com.bti.util.UtilDateAndTime;

/**
 * Description:Service Inventory Control SetUp
 * Name of Project: BTI 
 * Created on: Nov 16, 2017 
 * Modified on: 
 * @author GoodTech 
 * Version:
 */
@Service
public class ServiceInventoryControlSetUp {

	@Autowired
	private RepositoryInventoryControlSetup repositoryInventoryControlSetUp;
	@Autowired
	private RepositoryFinancialDimensionsTable repositoryFinancialDimensionsTable;
	@Autowired
	private ServiceResponse serviceResponse;
	private static final Log LOG = LogFactory.getLog(ServicePriceLevelSetUp.class);

	/**
	 * @param keySetupId
	 * @return
	 */

	public DtoInventoryControlSetUp deleteInventorySetupByValueCategory(int keySetupId) {
		LOG.info("in delete InventoryControlSetup");
		DtoInventoryControlSetUp dtoInventoryControlSetup = new DtoInventoryControlSetUp();
		dtoInventoryControlSetup.setDeleteMessage(
				serviceResponse.getStringMessageByShortAndIsDeleted("INVENTORY_CONTRIOL_DELETED", false));
		InventoryControlSetUp inventoryControlSetUp = repositoryInventoryControlSetUp.findOne(keySetupId);
		repositoryInventoryControlSetUp.deleteInventoryControlSetupByValueCategory(true, keySetupId);
		dtoInventoryControlSetup.setKeySetupId(keySetupId);
		dtoInventoryControlSetup.setStatus(true);
		return dtoInventoryControlSetup;
	}

	/**
	 * @param dtoInventoryControlSetUp
	 * @return
	 */

	public DtoSearch getAllInventorySetup(DtoInventoryControlSetUp dtoInventoryControlSetUp) {
		LOG.info("in get all InventoryControlSetup");
		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoInventoryControlSetUp.getPageNumber());
		dtoSearch.setPageSize(dtoInventoryControlSetUp.getPageSize());
		dtoSearch.setTotalCount((int) repositoryInventoryControlSetUp.count());

		List<InventoryControlSetUp> inventoryControlSetUpList = new ArrayList<>();
		if (dtoInventoryControlSetUp.getPageNumber() != null && dtoInventoryControlSetUp.getPageSize() != null) {

			Pageable pageable = new PageRequest(dtoInventoryControlSetUp.getPageNumber(),
					dtoInventoryControlSetUp.getPageSize(), Direction.DESC, "createdDate");
			inventoryControlSetUpList = repositoryInventoryControlSetUp.findBy(pageable);
		} else {
			inventoryControlSetUpList = repositoryInventoryControlSetUp.findByStatus(false);
		}
		List<DtoInventoryControlSetUp> dtoInventoryControlSetupList = new ArrayList<>();
		if (inventoryControlSetUpList != null && inventoryControlSetUpList.size() > 0) {
			for (InventoryControlSetUp inventoryControlSetUp : inventoryControlSetUpList) {
				dtoInventoryControlSetUp = new DtoInventoryControlSetUp(inventoryControlSetUp);
				dtoInventoryControlSetupList.add(dtoInventoryControlSetUp);
			}
			dtoSearch.setRecords(dtoInventoryControlSetupList);
		}
		return dtoSearch;

	}

	/**
	 * @param dtoInventoryControlSetUp
	 * @return
	 */

	public DtoInventoryControlSetUp saveOrUpdate(DtoInventoryControlSetUp dtoInventoryControlSetUp) {
		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();
		InventoryControlSetUp inventoryControlSetUp = new InventoryControlSetUp();
		LOG.info("In save or update Item Class Setup Service");
		FinancialDimensionsTable financialDimensionsTable = repositoryFinancialDimensionsTable
				.findBy(dtoInventoryControlSetUp.getDimensionDescription());

		if (dtoInventoryControlSetUp.getKeySetupId() == 0) {

			BeanUtils.copyProperties(dtoInventoryControlSetUp, inventoryControlSetUp);
			inventoryControlSetUp.setStatus(false);
			if (financialDimensionsTable != null) {
				inventoryControlSetUp.setGl00102(financialDimensionsTable);

			}

		} else {

			inventoryControlSetUp = repositoryInventoryControlSetUp.findOne(dtoInventoryControlSetUp.getKeySetupId());
			inventoryControlSetUp.setUserCategoryName1(dtoInventoryControlSetUp.getUserCategoryName1());
			inventoryControlSetUp.setUserCategoryName2(dtoInventoryControlSetUp.getUserCategoryName2());
			inventoryControlSetUp.setUserCategoryName3(dtoInventoryControlSetUp.getUserCategoryName3());
			inventoryControlSetUp.setUserCategoryName4(dtoInventoryControlSetUp.getUserCategoryName4());
			inventoryControlSetUp.setUserCategoryName5(dtoInventoryControlSetUp.getUserCategoryName5());
			inventoryControlSetUp.setUserCategoryName6(dtoInventoryControlSetUp.getUserCategoryName6());

			inventoryControlSetUp.setModifyByUserID(dtoInventoryControlSetUp.getModifyByUserID());
			inventoryControlSetUp.setModifyDate(utilDateAndTime.localToUTC());
			inventoryControlSetUp.setPasswordForUsingExpireLotInAdjustmentOrTransfer(
					dtoInventoryControlSetUp.getPasswordForUsingExpireLotInAdjustmentOrTransfer());
			inventoryControlSetUp.setPasswordForUsingExpireLotInOtherInventoryTransactions(
					dtoInventoryControlSetUp.getPasswordForUsingExpireLotInOtherInventoryTransactions());

			inventoryControlSetUp.setAutoAssignLotNumbers(dtoInventoryControlSetUp.getAutoAssignLotNumbers());
			inventoryControlSetUp.setAllowTransferOverrides(dtoInventoryControlSetUp.getAllowTransferOverrides());
			inventoryControlSetUp.setAllowVarianceOverrides(dtoInventoryControlSetUp.getAllowVarianceOverrides());
			inventoryControlSetUp.setAllowAdjustmentOverrides(dtoInventoryControlSetUp.getAllowAdjustmentOverrides());
			inventoryControlSetUp
					.setAllowCostForDecreaseAdjustments(dtoInventoryControlSetUp.getAllowCostForDecreaseAdjustments());
			inventoryControlSetUp.setCurrencyDecimal(dtoInventoryControlSetUp.getCurrencyDecimal());

			inventoryControlSetUp.setQuantityDecimals(dtoInventoryControlSetUp.getQuantityDecimals());
			inventoryControlSetUp
					.setNextAdjustmentDocumentNumber(dtoInventoryControlSetUp.getNextAdjustmentDocumentNumber());
			inventoryControlSetUp.setNextInTransitTransferDocumentNumber(
					dtoInventoryControlSetUp.getNextInTransitTransferDocumentNumber());
			inventoryControlSetUp
					.setNextProductionDocumentNumber(dtoInventoryControlSetUp.getNextProductionDocumentNumber());
			inventoryControlSetUp
					.setNextTransferDocumentNumber(dtoInventoryControlSetUp.getNextTransferDocumentNumber());
			inventoryControlSetUp
					.setNextVarianceDocumentNumber(dtoInventoryControlSetUp.getNextVarianceDocumentNumber());

			inventoryControlSetUp
					.setExpiredLotsinOtherTransactions(dtoInventoryControlSetUp.getExpiredLotsinOtherTransactions());
			inventoryControlSetUp.setExpLotsInInventoryAdjustmentAndTransfer(
					dtoInventoryControlSetUp.getExpLotsInInventoryAdjustmentAndTransfer());
		}

		inventoryControlSetUp.setModifyDate(utilDateAndTime.localToUTC());
		inventoryControlSetUp = repositoryInventoryControlSetUp.save(inventoryControlSetUp);
		BeanUtils.copyProperties(inventoryControlSetUp, dtoInventoryControlSetUp);
		return dtoInventoryControlSetUp;

	}
}
