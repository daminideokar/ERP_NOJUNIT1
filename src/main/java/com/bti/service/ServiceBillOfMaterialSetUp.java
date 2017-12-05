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

import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bti.model.BillOfMaterialSetUp;
import com.bti.model.dto.DtoBillOfMaterialSetUp;
import com.bti.repository.RepositoryBillOfMaterialSetUp;
import com.bti.util.UtilDateAndTime;

/**
 * Description: Service Bill Of Material SetUp Implementation
 * Name of Project: BTI
 * Created on: NOVEMBER 8,2017
 * Modified on:
 * 
 * @author goodtech
 * Version:
 */

@Service
public class ServiceBillOfMaterialSetUp {

	private static final Log LOG = LogFactory.getLog(ServiceBillOfMaterialSetUp.class);
	
	@Autowired
	private RepositoryBillOfMaterialSetUp repositoryBillOfMaterialSetUp;

	/**
	 * @param dtoBillOfMaterialSetUp
	 * @return
	 */
	
	public DtoBillOfMaterialSetUp saveOrUpdateBillOfMaterialSetup(DtoBillOfMaterialSetUp dtoBillOfMaterialSetUp) {

		LOG.info("In save or update method of Bill Of Material SetUp");
		
		UtilDateAndTime utilDateAndTime = new UtilDateAndTime();

		BillOfMaterialSetUp billOfMaterialSetUp;
		if (dtoBillOfMaterialSetUp.getId() == 0) {

			billOfMaterialSetUp = new BillOfMaterialSetUp();
			BeanUtils.copyProperties(dtoBillOfMaterialSetUp, billOfMaterialSetUp);
			billOfMaterialSetUp.setCreatDdt(utilDateAndTime.localToUTC());
			billOfMaterialSetUp.setStatus(false);
		} else {

			billOfMaterialSetUp = repositoryBillOfMaterialSetUp.findOne(dtoBillOfMaterialSetUp.getId());
			if (billOfMaterialSetUp.getStatus() == false) {
				billOfMaterialSetUp.setUserDefinedField1(dtoBillOfMaterialSetUp.getUserDefinedField1());
				billOfMaterialSetUp.setUserDefinedField2(dtoBillOfMaterialSetUp.getUserDefinedField2());
				billOfMaterialSetUp.setUserDefinedField3(dtoBillOfMaterialSetUp.getUserDefinedField3());
				billOfMaterialSetUp.setUserDefinedField4(dtoBillOfMaterialSetUp.getUserDefinedField4());
				billOfMaterialSetUp.setModifDt(utilDateAndTime.localToUTC());
			}
			else{
				return dtoBillOfMaterialSetUp;
			}
			
		}
		
		try{
		billOfMaterialSetUp = repositoryBillOfMaterialSetUp.save(billOfMaterialSetUp);
		}
		catch (ConstraintViolationException e) {
			System.out.println("History already exist");
			e.printStackTrace();
		}
		BeanUtils.copyProperties(billOfMaterialSetUp, dtoBillOfMaterialSetUp);

	return dtoBillOfMaterialSetUp;

	}

	/**
	 * @param dtoBillOfMaterialSetUp
	 * @return
	 */

	public DtoBillOfMaterialSetUp getBillOfMaterialByNextDocumentNumber(DtoBillOfMaterialSetUp dtoBillOfMaterialSetUp) {

		LOG.info("In getBillOfMaterialByNextDocumentNumber method of Bill Of Material SetUp");
		
		BillOfMaterialSetUp billOfMaterialSetUp = repositoryBillOfMaterialSetUp
				.findByNextDocumentNumberAndStatus(dtoBillOfMaterialSetUp.getNextDocumentNumber(), false);

		if (billOfMaterialSetUp != null) {
			BeanUtils.copyProperties(billOfMaterialSetUp, dtoBillOfMaterialSetUp);
			return dtoBillOfMaterialSetUp;
		} else {
			return null;
		}

	}

	/**
	 * @param dtoBillOfMaterialSetUp
	 * @return
	 */

	public DtoBillOfMaterialSetUp deleteByNextDocumentNumber(DtoBillOfMaterialSetUp dtoBillOfMaterialSetUp) {

		LOG.info("In deleteByNextDocumentNumber method of Bill Of Material SetUp");
		
		BillOfMaterialSetUp billOfMaterialSetUp = repositoryBillOfMaterialSetUp
				.findByNextDocumentNumber(dtoBillOfMaterialSetUp.getNextDocumentNumber());

		if (billOfMaterialSetUp != null) {
			billOfMaterialSetUp.setStatus(true);
			billOfMaterialSetUp = repositoryBillOfMaterialSetUp.save(billOfMaterialSetUp);
			BeanUtils.copyProperties(billOfMaterialSetUp, dtoBillOfMaterialSetUp);
			return dtoBillOfMaterialSetUp;
		}

		return null;
	}

}
