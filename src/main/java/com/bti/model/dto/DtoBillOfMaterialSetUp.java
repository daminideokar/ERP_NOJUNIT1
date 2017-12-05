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
package com.bti.model.dto;

import java.util.Date;

import com.bti.model.BillOfMaterialSetUp;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Name of Project: BTI 
 * Description: Dto BillOfMaterialSetUp
 * Created on: NOVEMBER 8,2017
 * Modified on:
 * 
 * @author goodtech
 */
@JsonInclude(Include.NON_EMPTY)
public class DtoBillOfMaterialSetUp extends BillOfMaterialSetUp{

	
	
	/**
	 * 
	 */
	public DtoBillOfMaterialSetUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nextDocumentNumber
	 * @param documentDate
	 * @param userDefinedField1
	 * @param userDefinedField2
	 * @param userDefinedField3
	 * @param userDefinedField4
	 * @param allowOverrideonQuantityShortage
	 * @param allowLinkingOfComponentandFinishedGoodSerialAndLotNumbers
	 * @param status
	 */
	public DtoBillOfMaterialSetUp(BillOfMaterialSetUp billOfMaterialSetUp) {
		
		super(billOfMaterialSetUp.getId(),billOfMaterialSetUp.getNextDocumentNumber(),billOfMaterialSetUp.getDocumentDate(),billOfMaterialSetUp.getUserDefinedField1(),billOfMaterialSetUp.getUserDefinedField2(),billOfMaterialSetUp.getUserDefinedField3(),billOfMaterialSetUp.getUserDefinedField4(),billOfMaterialSetUp.getAllowOverrideonQuantityShortage(),billOfMaterialSetUp.getAllowLinkingOfComponentandFinishedGoodSerialAndLotNumbers(),billOfMaterialSetUp.getStatus());
	
	}

	

	
	

}
