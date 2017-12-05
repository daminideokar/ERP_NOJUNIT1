package com.bti.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bti.model.FinancialDimensionsTable;
import com.bti.model.dto.DtoFinancialDimensionsTable;
import com.bti.repository.RepositoryFinancialDimensionsTable;

/**
 * Description:Service Financial Dimension Table
 * Name of Project: BTI 
 * Created on: NOVEMBER 16, 2017 
 * Modified on:
 * @author GoodTech 
 * Version:
 */
@Service
public class ServiceFinancialDimensionsTable  {

	
	@Autowired
	private RepositoryFinancialDimensionsTable repositoryFinancialDimensionsTable ;

	/**
	 * @param dtoFinancialDimensionsTable
	 * @return
	 */
	
	public DtoFinancialDimensionsTable getByFinacialClassId(DtoFinancialDimensionsTable dtoFinancialDimensionsTable) {
		
		FinancialDimensionsTable financialDimensionsTable = repositoryFinancialDimensionsTable.findBy(dtoFinancialDimensionsTable.getDimensionDescription());
		
		if (financialDimensionsTable == null) {
			return null ;
		}
		 BeanUtils.copyProperties(financialDimensionsTable, dtoFinancialDimensionsTable);
		return dtoFinancialDimensionsTable;
	}
	
	
}
