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
import com.bti.model.PriceLevelSetUp;
import com.bti.model.dto.DtoPriceLevelSetUp;
import com.bti.model.dto.DtoSearch;
import com.bti.repository.RepositoryPriceLevelSetUp;
import com.bti.service.ServiceResponse;
import com.bti.util.UtilDateAndTime;

/**
 * Description:Service Price Level SetUp
 * Name ofProject:BTI
 * Created on: NOVEMBER 07, 2017 
 * Modified on:
 * @author GoodTech 
 * Version:
 */
@Service
public class ServicePriceLevelSetUp {

	@Autowired
	private RepositoryPriceLevelSetUp repositoryPriceLevelSetUp;

	@Autowired
	private ServiceResponse serviceResponse;

	private static final Log LOG = LogFactory.getLog(ServicePriceLevelSetUp.class);

	/**
	 * @param dtoPriceLevelSetUp
	 * @return
	 */

	public DtoSearch getAllPriceLevelSetUp(DtoPriceLevelSetUp dtoPriceLevelSetUp) {

		LOG.info(" in get all priceLevelSetUp");
		DtoSearch dtoSearch = new DtoSearch();
		dtoSearch.setPageNumber(dtoPriceLevelSetUp.getPageNumber());
		dtoSearch.setPageSize(dtoPriceLevelSetUp.getPageSize());
		dtoSearch.setTotalCount((int) repositoryPriceLevelSetUp.count());

		List<PriceLevelSetUp> priceLevelSetupList = new ArrayList<>();
		if (dtoPriceLevelSetUp.getPageNumber() != null && dtoPriceLevelSetUp.getPageSize() != null) {

			Pageable pageable = new PageRequest(dtoPriceLevelSetUp.getPageNumber(), dtoPriceLevelSetUp.getPageSize(),
					Direction.DESC, "createdDate");
			priceLevelSetupList = repositoryPriceLevelSetUp.findBy(pageable);
		} else {
			priceLevelSetupList = repositoryPriceLevelSetUp.findByStatusOrderByCreatedDateDesc(false);
		}
		List<DtoPriceLevelSetUp> dtoPriceLevelSetUpList = new ArrayList<>();
		if (priceLevelSetupList != null && priceLevelSetupList.size() > 0) {
			for (PriceLevelSetUp priceLevelSetup : priceLevelSetupList) {
				dtoPriceLevelSetUp = new DtoPriceLevelSetUp(priceLevelSetup);
				dtoPriceLevelSetUpList.add(dtoPriceLevelSetUp);
			}
			dtoSearch.setRecords(dtoPriceLevelSetUpList);
		}
		return dtoSearch;

	}

	/**
	 * @param dtoPriceLevelSetUp
	 * @return
	 */

	public DtoPriceLevelSetUp saveOrUpdatePricelevelSetUp(DtoPriceLevelSetUp dtoPriceLevelSetUp) {
		LOG.info(" in save or update priceLevelSetUp");
		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();
		PriceLevelSetUp priceLevelSetup;
		if (dtoPriceLevelSetUp.getPriceLevelIndex() == 0) {
			priceLevelSetup = new PriceLevelSetUp();
			BeanUtils.copyProperties(dtoPriceLevelSetUp, priceLevelSetup);
			priceLevelSetup.setCreatedDate(utilDateAndTime.localToUTC());
			priceLevelSetup.setStatus(false);

		} else {
			priceLevelSetup = repositoryPriceLevelSetUp.findOne(dtoPriceLevelSetUp.getPriceLevelIndex());
			if (priceLevelSetup.getStatus() == false) {
				priceLevelSetup.setPriceLevelDescription(dtoPriceLevelSetUp.getPriceLevelDescription());
				priceLevelSetup.setPriceLevelDescriptionArabic(dtoPriceLevelSetUp.getPriceLevelDescriptionArabic());
				priceLevelSetup.setModifyByUserId(dtoPriceLevelSetUp.getModifyByUserId());
				priceLevelSetup.setModifyDate(utilDateAndTime.localToUTC());
			} else {
				return null;
			}
		}
		priceLevelSetup = repositoryPriceLevelSetUp.save(priceLevelSetup);
		BeanUtils.copyProperties(priceLevelSetup, dtoPriceLevelSetUp);

		return dtoPriceLevelSetUp;
	}

	/**
	 * @param dtoPriceLevelSetUp
	 * @return
	 */

	public DtoPriceLevelSetUp getPriceLevelSetUpById(DtoPriceLevelSetUp dtoPriceLevelSetUp) {
		LOG.info(" in get by id PriceLevelSetUp");
		PriceLevelSetUp priceLevelSetup = repositoryPriceLevelSetUp
				.findByPriceLevelId(dtoPriceLevelSetUp.getPriceLevelId());
		if (priceLevelSetup != null) {
			BeanUtils.copyProperties(priceLevelSetup, dtoPriceLevelSetUp);
			return dtoPriceLevelSetUp;
		}

		else {
			return null;
		}
	}

}
