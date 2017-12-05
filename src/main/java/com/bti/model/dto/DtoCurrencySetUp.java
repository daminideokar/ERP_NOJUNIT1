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
package com.bti.model.dto;

import java.util.List;
import com.bti.model.CurrencySetUp;
import com.bti.model.InventoryClassSetUpCurrency;
import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * Description: class for the Dto Currency SetUp
 * Name of Project: BTI 
 * Created on: NOVEMBER 13, 2017 
 * Modified on:
 * 
 * @author GoodTech Version:
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoCurrencySetUp extends CurrencySetUp{

	public DtoCurrencySetUp() {
		
	}
	
	public DtoCurrencySetUp(CurrencySetUp currencySetUp1) {
		super(currencySetUp1.getCurrencyId(),currencySetUp1.getCurrencyDescription(),currencySetUp1.getCurrencyDescriptionArabic(),currencySetUp1.getCurrencyIndex(),currencySetUp1.getStatus());
	
	}

	
}
