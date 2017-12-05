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
import com.bti.model.InventoryUnitOfMeasureScheduleSetUpDetails;
import com.bti.model.dto.DtoSearch;
import com.bti.model.dto.DtoUnitOfMeasureScheduleSetUpDetails;
import com.bti.repository.RepositoryUnitOfMeasureScheduleSetUp;
import com.bti.repository.RepositoryUnitOfMeasureScheduleSetUpDetails;
import com.bti.util.UtilDateAndTime;

/**
 * Name of Project: BTI 
 * Description: Service Unit Of Measure Schedule SetUp Details  
 * Created on:NOVEMBER 14,2017
 * Modified on:
 * 
 * @author goodtech
 */
@Service
public class ServiceUnitOfMeasureScheduleSetUpDetails  {

	private static final Log LOG = LogFactory.getLog(ServiceUnitOfMeasureScheduleSetUpDetails.class);
	
	@Autowired
	private RepositoryUnitOfMeasureScheduleSetUpDetails repositoryUnitOfMeasureScheduleSetUpDetails;

	@Autowired
	private RepositoryUnitOfMeasureScheduleSetUp repositoryUnitOfMeasureScheduleSetUp;


	/**
	 * @param dtoUnitOfMeasureScheduleSetUpDetails
	 * @return
	 */
	
	public DtoUnitOfMeasureScheduleSetUpDetails saveOrUpdateUnitOfMeasureScheduleSetUpDetails(
			DtoUnitOfMeasureScheduleSetUpDetails dtoUnitOfMeasureScheduleSetUpDetails) {

		LOG.info("In save or update method of unit of measure schedule setup details");
		
		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();

		InventoryUnitOfMeasureScheduleSetUpDetails inventoryUnitOfMeasureScheduleSetUpDetails = new InventoryUnitOfMeasureScheduleSetUpDetails();;
		if (dtoUnitOfMeasureScheduleSetUpDetails.getIndex() == 0) {
			
			InventoryUnitOfMeasureScheduleSetUp inventoryUnitOfMeasureScheduleSetUp = repositoryUnitOfMeasureScheduleSetUp
					.findByUnitOfMeasureIdAndStatus(dtoUnitOfMeasureScheduleSetUpDetails.getUnitOfMeasureId(), false);
			
			if(inventoryUnitOfMeasureScheduleSetUp != null)
			{
				
				BeanUtils.copyProperties(dtoUnitOfMeasureScheduleSetUpDetails, inventoryUnitOfMeasureScheduleSetUpDetails);
				inventoryUnitOfMeasureScheduleSetUpDetails.setCreateDate(utilDateAndTime.localToUTC());
				inventoryUnitOfMeasureScheduleSetUpDetails.setStatus(false);
				inventoryUnitOfMeasureScheduleSetUpDetails.setBaseUnitOfMeasure(inventoryUnitOfMeasureScheduleSetUp.getBaseUnitOfMeasure());
				inventoryUnitOfMeasureScheduleSetUpDetails.setIv401001(inventoryUnitOfMeasureScheduleSetUp);
			}
	
		} else {
			inventoryUnitOfMeasureScheduleSetUpDetails = new InventoryUnitOfMeasureScheduleSetUpDetails();
			inventoryUnitOfMeasureScheduleSetUpDetails = repositoryUnitOfMeasureScheduleSetUpDetails
					.findOne(dtoUnitOfMeasureScheduleSetUpDetails.getIndex());
			if (inventoryUnitOfMeasureScheduleSetUpDetails.getStatus() == false) {
				inventoryUnitOfMeasureScheduleSetUpDetails
						.setQtyInBaseUnitOfMeasure(dtoUnitOfMeasureScheduleSetUpDetails.getQtyInBaseUnitOfMeasure());
				inventoryUnitOfMeasureScheduleSetUpDetails
						.setEquivalentUnitOfMeasure(dtoUnitOfMeasureScheduleSetUpDetails.getEquivalentUnitOfMeasure());
				inventoryUnitOfMeasureScheduleSetUpDetails.setMoreDescriptionForUOfMInDetailLevel(
						dtoUnitOfMeasureScheduleSetUpDetails.getMoreDescriptionForUOfMInDetailLevel());
				inventoryUnitOfMeasureScheduleSetUpDetails.setModifdt(utilDateAndTime.localToUTC());
			}

			else {
				return dtoUnitOfMeasureScheduleSetUpDetails;
			}
		}
		inventoryUnitOfMeasureScheduleSetUpDetails = repositoryUnitOfMeasureScheduleSetUpDetails.save(inventoryUnitOfMeasureScheduleSetUpDetails);
		BeanUtils.copyProperties(inventoryUnitOfMeasureScheduleSetUpDetails, dtoUnitOfMeasureScheduleSetUpDetails);

		return dtoUnitOfMeasureScheduleSetUpDetails;

	}

	/**
	 * @param dtoUnitOfMeasureScheduleSetUpDetails
	 * @return
	 */

	public DtoSearch getAllUnitOfMeasureScheduleSetUpDetails(
			DtoUnitOfMeasureScheduleSetUpDetails dtoUnitOfMeasureScheduleSetUpDetails) {

		LOG.info("In getall method of unit of measure schedule setup details");

		
		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoUnitOfMeasureScheduleSetUpDetails.getPageNumber());
		dtoSearch.setPageSize(dtoUnitOfMeasureScheduleSetUpDetails.getPageSize());
		dtoSearch.setTotalCount((int) repositoryUnitOfMeasureScheduleSetUpDetails.count());

		List<InventoryUnitOfMeasureScheduleSetUpDetails> inventoryUnitOfMeasureScheduleSetupDetailsList;
		if (dtoUnitOfMeasureScheduleSetUpDetails.getPageNumber() != null
				&& dtoUnitOfMeasureScheduleSetUpDetails.getPageSize() != null) {
			Pageable pageable = new PageRequest(dtoUnitOfMeasureScheduleSetUpDetails.getPageNumber(),
					dtoUnitOfMeasureScheduleSetUpDetails.getPageSize(), Direction.DESC, "createDate");
			inventoryUnitOfMeasureScheduleSetupDetailsList = repositoryUnitOfMeasureScheduleSetUpDetails
					.findByStatus(false, pageable);
		} else {
			inventoryUnitOfMeasureScheduleSetupDetailsList = repositoryUnitOfMeasureScheduleSetUpDetails
					.findByStatusOrderByCreateDateDesc(false);
		}

		List<DtoUnitOfMeasureScheduleSetUpDetails> dtoUnitOfMeasureScheduleSetUpDetailsList = new ArrayList<>();
		if (inventoryUnitOfMeasureScheduleSetupDetailsList != null
				&& inventoryUnitOfMeasureScheduleSetupDetailsList.size() > 0) {
			for (InventoryUnitOfMeasureScheduleSetUpDetails inventoryUnitOfMeasureScheduleSetUpDetails : inventoryUnitOfMeasureScheduleSetupDetailsList) {
				dtoUnitOfMeasureScheduleSetUpDetails = new DtoUnitOfMeasureScheduleSetUpDetails(
						inventoryUnitOfMeasureScheduleSetUpDetails);
				dtoUnitOfMeasureScheduleSetUpDetailsList.add(dtoUnitOfMeasureScheduleSetUpDetails);

			}
			dtoSearch.setRecords(dtoUnitOfMeasureScheduleSetUpDetailsList);
		}
		return dtoSearch;

	}

	/**
	 * @param dtoUnitOfMeasureScheduleSetUpDetails
	 * @return
	 */
	
	public DtoUnitOfMeasureScheduleSetUpDetails delete(
			DtoUnitOfMeasureScheduleSetUpDetails dtoUnitOfMeasureScheduleSetUpDetails) {

		LOG.info("In delete method of unit of measure schedule setup details");
		
		InventoryUnitOfMeasureScheduleSetUpDetails inventoryUnitOfMeasureScheduleSetUpDetails = repositoryUnitOfMeasureScheduleSetUpDetails
				.findOne(dtoUnitOfMeasureScheduleSetUpDetails.getIndex());
		if (inventoryUnitOfMeasureScheduleSetUpDetails != null) {
			inventoryUnitOfMeasureScheduleSetUpDetails.setStatus(true);
			inventoryUnitOfMeasureScheduleSetUpDetails = repositoryUnitOfMeasureScheduleSetUpDetails
					.save(inventoryUnitOfMeasureScheduleSetUpDetails);
			BeanUtils.copyProperties(inventoryUnitOfMeasureScheduleSetUpDetails, dtoUnitOfMeasureScheduleSetUpDetails);
			return dtoUnitOfMeasureScheduleSetUpDetails;
		}

		return dtoUnitOfMeasureScheduleSetUpDetails;

	}

}
