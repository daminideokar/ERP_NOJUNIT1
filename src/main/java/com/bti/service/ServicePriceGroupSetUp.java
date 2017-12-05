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
import org.springframework.data.domain.PageRequest;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.bti.model.PriceGroupSetUp;
import com.bti.model.dto.DtoPriceGroupSetup;
import com.bti.model.dto.DtoSearch;
import com.bti.repository.RepositoryPriceGroupSetup;
import com.bti.util.UtilDateAndTime;


/**
 * Name of Project: BTI 
 * Description: Service PriceGroupSetup
 * Created on: NOVEMBER 6,2017
 * Modified on:
 * 
 * @author goodtech
 */
@Service
public class ServicePriceGroupSetUp {

	private static final Log LOG = LogFactory.getLog(ServicePriceGroupSetUp.class);
	
	@Autowired
	private RepositoryPriceGroupSetup repositoryPriceGroupSetup;

	/**
	 * @param dtoPriceGroupSetup
	 * @return
	 */

	public DtoSearch getAllPriceGroupSetup(DtoPriceGroupSetup dtoPriceGroupSetup) {

		LOG.info("In getall method of Price Group SetUp SetUp");
		
		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoPriceGroupSetup.getPageNumber());
		dtoSearch.setPageSize(dtoPriceGroupSetup.getPageSize());
		dtoSearch.setTotalCount((int) repositoryPriceGroupSetup.count());

		List<PriceGroupSetUp> priceGroupSetUpList;
		if (dtoPriceGroupSetup.getPageNumber() != null && dtoPriceGroupSetup.getPageSize() != null) {
			Pageable pageable = new PageRequest(dtoPriceGroupSetup.getPageNumber(), dtoPriceGroupSetup.getPageSize(),
					Direction.DESC, "createDate");
			priceGroupSetUpList = repositoryPriceGroupSetup.findBy(pageable);
		} else {
			priceGroupSetUpList = repositoryPriceGroupSetup.findByOrderByCreateDateDesc();
		}

		List<DtoPriceGroupSetup> dtoPriceGroupSetupList = new ArrayList<>();
		if (priceGroupSetUpList != null && priceGroupSetUpList.size() > 0) {
			for (PriceGroupSetUp priceGroupSetUp : priceGroupSetUpList) {
				dtoPriceGroupSetup = new DtoPriceGroupSetup(priceGroupSetUp);
				dtoPriceGroupSetupList.add(dtoPriceGroupSetup);
			}
			dtoSearch.setRecords(dtoPriceGroupSetupList);
		}
		return dtoSearch;
	}

	/**
	 * @param dtoPriceGroupSetup
	 * @return
	 */
	
	public DtoPriceGroupSetup saveOrUpdatePriceGroupSetup(DtoPriceGroupSetup dtoPriceGroupSetup) {

		LOG.info("In Save Or Update method of Price Group SetUp SetUp");
		
		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();

		PriceGroupSetUp priceGroupSetUp;
		if (dtoPriceGroupSetup.getPriceGroupIndex() == 0) {

			priceGroupSetUp = new PriceGroupSetUp();
			BeanUtils.copyProperties(dtoPriceGroupSetup, priceGroupSetUp);
			priceGroupSetUp.setCreateDate(utilDateAndTime.localToUTC());
		} else {

			priceGroupSetUp = repositoryPriceGroupSetup.findOne(dtoPriceGroupSetup.getPriceGroupIndex());
			priceGroupSetUp.setPriceGroupDescription(dtoPriceGroupSetup.getPriceGroupDescription());
			priceGroupSetUp.setPriceGroupDescriptionArabic(dtoPriceGroupSetup.getPriceGroupDescriptionArabic());
			priceGroupSetUp.setModifyDate(utilDateAndTime.localToUTC());

		}
		priceGroupSetUp = repositoryPriceGroupSetup.save(priceGroupSetUp);
		BeanUtils.copyProperties(priceGroupSetUp, dtoPriceGroupSetup);

		return dtoPriceGroupSetup;
	}

	/**
	 * @param dtoPriceGroupSetup
	 * @return
	 */
	
	public DtoPriceGroupSetup getPriceGroupById(DtoPriceGroupSetup dtoPriceGroupSetup) {

		LOG.info("In getPriceGroupById method of Price Group SetUp SetUp");
		
		PriceGroupSetUp priceGroupSetUp = repositoryPriceGroupSetup.getByPriceGroupId(dtoPriceGroupSetup.getPriceGroupId());
		if (priceGroupSetUp == null) {
			return null;
	     }

		BeanUtils.copyProperties(priceGroupSetUp, dtoPriceGroupSetup);
		return dtoPriceGroupSetup;
	}

}
