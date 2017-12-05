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
import java.util.Date;
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
import com.bti.model.dto.DtoSearch;
import com.bti.model.dto.DtoUnitOfMeasureScheduleSetUp;
import com.bti.repository.RepositoryUnitOfMeasureScheduleSetUp;
import com.bti.service.ServiceResponse;
import com.bti.util.UtilDateAndTime;

/**
 * Name of Project: BTI 
 * Description: Service Unit Of Measure Schedule SetUp 
 * Created on:NOVEMBER 13,2017
 * Modified on:
 * 
 * @author goodtech
 */
@Service
public class ServiceUnitOfMeasureScheduleSetUp  {

	private static final Log LOG = LogFactory.getLog(ServiceUnitOfMeasureScheduleSetUp.class);
	
	@Autowired
	private RepositoryUnitOfMeasureScheduleSetUp repositoryUnitOfMeasureScheduleSetUp;
	
	@Autowired
	ServiceResponse serviceResponse;

	/**
	 * @param dtoUnitOfMeasureScheduleSetUp
	 * @return
	 */
		public DtoUnitOfMeasureScheduleSetUp saveOrUpdateUnitOfMeasureScheduleSetUp(
			DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUp) {

		LOG.info("In save or update method of unit of measure schedule setup");
		
		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();
		InventoryUnitOfMeasureScheduleSetUp inventoryUnitOfMeasureScheduleSetUp;
		if (dtoUnitOfMeasureScheduleSetUp.getUominx() == 0) {
			inventoryUnitOfMeasureScheduleSetUp = new InventoryUnitOfMeasureScheduleSetUp();
			BeanUtils.copyProperties(dtoUnitOfMeasureScheduleSetUp, inventoryUnitOfMeasureScheduleSetUp);
			inventoryUnitOfMeasureScheduleSetUp.setCreateDate(utilDateAndTime.localToUTC());
			inventoryUnitOfMeasureScheduleSetUp.setStatus(false);
		} else {
			inventoryUnitOfMeasureScheduleSetUp = repositoryUnitOfMeasureScheduleSetUp
					.findOne(dtoUnitOfMeasureScheduleSetUp.getUominx());
			if (inventoryUnitOfMeasureScheduleSetUp.getStatus() == false) {
				inventoryUnitOfMeasureScheduleSetUp
						.setUnitOfMeasureDescription(dtoUnitOfMeasureScheduleSetUp.getUnitOfMeasureDescription());
				inventoryUnitOfMeasureScheduleSetUp.setUnitOfMeasureDescriptionArabic(
						dtoUnitOfMeasureScheduleSetUp.getUnitOfMeasureDescriptionArabic());
				inventoryUnitOfMeasureScheduleSetUp
						.setDecimalPlacesQty(dtoUnitOfMeasureScheduleSetUp.getDecimalPlacesQty());
				inventoryUnitOfMeasureScheduleSetUp
						.setBaseUnitOfMeasure(dtoUnitOfMeasureScheduleSetUp.getBaseUnitOfMeasure());

				inventoryUnitOfMeasureScheduleSetUp.setModifyDate(utilDateAndTime.localToUTC());
			}

			else {
				return dtoUnitOfMeasureScheduleSetUp;
			}
		}
		inventoryUnitOfMeasureScheduleSetUp = repositoryUnitOfMeasureScheduleSetUp
				.save(inventoryUnitOfMeasureScheduleSetUp);
		BeanUtils.copyProperties(inventoryUnitOfMeasureScheduleSetUp, dtoUnitOfMeasureScheduleSetUp);

		return dtoUnitOfMeasureScheduleSetUp;

	}

	/**
	 * @param dtoUnitOfMeasureScheduleSetUp
	 * @return
	 */
	
	public DtoSearch getAllUnitOfMeasureScheduleSetUp(DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUp) {

		LOG.info("In getall method of unit of measure schedule setup");
		
		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoUnitOfMeasureScheduleSetUp.getPageNumber());
		dtoSearch.setPageSize(dtoUnitOfMeasureScheduleSetUp.getPageSize());
		dtoSearch.setTotalCount((int) repositoryUnitOfMeasureScheduleSetUp.count());

		List<InventoryUnitOfMeasureScheduleSetUp> inventoryUnitOfMeasureScheduleSetupList;
		if (dtoUnitOfMeasureScheduleSetUp.getPageNumber() != null
				&& dtoUnitOfMeasureScheduleSetUp.getPageSize() != null) {
			Pageable pageable = new PageRequest(dtoUnitOfMeasureScheduleSetUp.getPageNumber(),
					dtoUnitOfMeasureScheduleSetUp.getPageSize(), Direction.DESC, "createDate");
			inventoryUnitOfMeasureScheduleSetupList = repositoryUnitOfMeasureScheduleSetUp.findByStatus(false,
					pageable);
		} else {
			inventoryUnitOfMeasureScheduleSetupList = repositoryUnitOfMeasureScheduleSetUp
					.findByStatusOrderByCreateDateDesc(false);
		}

		List<DtoUnitOfMeasureScheduleSetUp> dtoUnitOfMeasureScheduleSetUpList = new ArrayList<>();
		if (inventoryUnitOfMeasureScheduleSetupList != null && inventoryUnitOfMeasureScheduleSetupList.size() > 0) {
			for (InventoryUnitOfMeasureScheduleSetUp inventoryUnitOfMeasureScheduleSetUp : inventoryUnitOfMeasureScheduleSetupList) {
				dtoUnitOfMeasureScheduleSetUp = new DtoUnitOfMeasureScheduleSetUp(inventoryUnitOfMeasureScheduleSetUp);
				dtoUnitOfMeasureScheduleSetUpList.add(dtoUnitOfMeasureScheduleSetUp);

			}
			dtoSearch.setRecords(dtoUnitOfMeasureScheduleSetUpList);
		}
		return dtoSearch;

	}


	/**
	 * @param dtoUnitOfMeasureScheduleSetUp
	 * @return
	 */
	
	public DtoUnitOfMeasureScheduleSetUp delete(DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUp) {
		
		LOG.info("In delete method of unit of measure schedule setup");

		
		InventoryUnitOfMeasureScheduleSetUp inventoryUnitOfMeasureScheduleSetUp = repositoryUnitOfMeasureScheduleSetUp.findOne(dtoUnitOfMeasureScheduleSetUp.getUominx());
		if (inventoryUnitOfMeasureScheduleSetUp != null) {
			inventoryUnitOfMeasureScheduleSetUp.setStatus(true);
			inventoryUnitOfMeasureScheduleSetUp = repositoryUnitOfMeasureScheduleSetUp
					.save(inventoryUnitOfMeasureScheduleSetUp);
			BeanUtils.copyProperties(inventoryUnitOfMeasureScheduleSetUp, dtoUnitOfMeasureScheduleSetUp);
			return dtoUnitOfMeasureScheduleSetUp;
		}

		return null;
	}


	/**
	 * @param dtoUnitOfMeasureScheduleSetUp
	 * @return
	 */
	
	public DtoUnitOfMeasureScheduleSetUp getUnitOfMeasureScheduleSetUpByUOfMId(
			DtoUnitOfMeasureScheduleSetUp dtoUnitOfMeasureScheduleSetUp) {

		LOG.info("In getUnitOfMeasureScheduleSetUpByUOfMId method of unit of measure schedule setup");
		
		InventoryUnitOfMeasureScheduleSetUp inventoryUnitOfMeasureScheduleSetUp = repositoryUnitOfMeasureScheduleSetUp
				.findByUnitOfMeasureIdAndStatus(dtoUnitOfMeasureScheduleSetUp.getUnitOfMeasureId(), false);
		if (inventoryUnitOfMeasureScheduleSetUp != null && inventoryUnitOfMeasureScheduleSetUp.getStatus() != true) {
			BeanUtils.copyProperties(inventoryUnitOfMeasureScheduleSetUp, dtoUnitOfMeasureScheduleSetUp);
			return dtoUnitOfMeasureScheduleSetUp;
		}
		return dtoUnitOfMeasureScheduleSetUp;
	}

}
