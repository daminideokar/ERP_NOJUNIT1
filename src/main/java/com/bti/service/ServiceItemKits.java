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

import static org.mockito.Matchers.anyByte;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bti.model.AccountTypeSetUp;
import com.bti.model.BillOfMaterialSetUp;
import com.bti.model.ItemKits;
import com.bti.model.ItemMaintenance;
import com.bti.model.dto.DtoBillOfMaterialSetUp;
import com.bti.model.dto.DtoItemKits;
import com.bti.model.dto.DtoItemMaintenece;
import com.bti.model.dto.DtoSearch;
import com.bti.repository.RepositoryItemKits;
import com.bti.repository.RepositoryItemMaintainance;
import com.bti.service.ServiceItemKits;
/**
 * Name of Project: BTI 
 * Description: Service ItemKitSetUp
 * Created on: NOVEMBER 24,2017
 * Modified on:
 * 
 * @author goodtech
 */
@Service
public class ServiceItemKits {

	@Autowired
	private RepositoryItemKits repositoryItemKits;

	@Autowired
	private RepositoryItemMaintainance repositoryItemMaintainance;

	public enum CostOfGoodsSold{
		FromComponentItem(1),
		FromItemKit(2);
		
		int value;
		private CostOfGoodsSold(int value)
		{
			this.value=value;
		}
		public int getValue() {
			return value;
		}	
	}
	
	/**
	 * @param dtoItemKits
	 * @return
	 */
	public DtoItemKits saveOrUpdateItemKits(DtoItemKits dtoItemKits) {

		Date date = new Date();

		ItemKits itemKits = new ItemKits();
		if (dtoItemKits.getIndex() == 0) {

			short value = (short) 4;
			ItemMaintenance itemMaintenancekit = repositoryItemMaintainance
					.findByItemNumberAndItemType(dtoItemKits.getItemKitNumber(), value);
			
			ItemMaintenance itemMaintencomponent = repositoryItemMaintainance
					.findByItemNumberAndItemType(dtoItemKits.getItemNumberComponent(), value);
			
			if (itemMaintenancekit != null && itemMaintencomponent != null) {
				BeanUtils.copyProperties(dtoItemKits, itemKits);
				
				itemKits.setCreateDate(date);
				itemKits.setStatus(false);
				itemKits.setIv001012(itemMaintenancekit);
				itemKits.setIv001011(itemMaintencomponent);
				itemKits.setItemKitUnitMeasure(itemMaintenancekit.getIv40100().getUnitOfMeasureId());
				int count=repositoryItemKits.getCount(itemMaintencomponent,false);
				itemKits.setItemNumberSequance(count+1);

			} else {
				return dtoItemKits;
			}

		} else {

			itemKits = repositoryItemKits.findOne(dtoItemKits.getIndex());
			if (itemKits.getStatus() == false) {
				itemKits.setComponentItemQuantity(dtoItemKits.getComponentItemQuantity());
				itemKits.setModifyDate(date);
			} else {
				return dtoItemKits;
			}

		}
		itemKits = repositoryItemKits.save(itemKits);
		BeanUtils.copyProperties(itemKits, dtoItemKits);

		return dtoItemKits;
	}

	/**
	 * @param dtoItemKits
	 * @return
	 */
	public DtoItemMaintenece getComponentByItemKitNumber(DtoItemKits dtoItemKits) {
		short value = (short) 4;
		ItemMaintenance itemMaintenancekit = repositoryItemMaintainance
				.findByItemNumberAndItemType(dtoItemKits.getItemKitNumber(), value);
		DtoSearch dtoSearch=new DtoSearch();
		
		System.out.println("@@@@@@"+itemMaintenancekit.getIv00104s2().size());
		//List<ItemKits> list = repositoryItemKits.findByiv001012AndStatus(itemMaintenancekit, false);
		DtoItemKits dtoItemKitsRes=new DtoItemKits();
		List<DtoItemKits>dtoItemKitsList = new ArrayList<>();
		DtoItemMaintenece dtoItemMaintenece = new DtoItemMaintenece();
		if(itemMaintenancekit != null){
			List<DtoItemKits> itemKitsList = new ArrayList<DtoItemKits>();
			
			for(ItemKits itemKit:itemMaintenancekit.getIv00104s2())
			{
			
				//itemKitList.add(itemKit);
				DtoItemKits itemKitsRes=new DtoItemKits();
				itemKitsRes.setIndex(itemKit.getIndex());
				itemKitsRes.setComponentItemQuantity(itemKit.getComponentItemQuantity());
				itemKitsRes.setItemNumberComponent(itemKit.getIv001011().getItemNumber());
				
				
				itemKitsList.add(itemKitsRes);
			}
			
		 dtoItemMaintenece = new DtoItemMaintenece(itemMaintenancekit, itemKitsList );
		 System.out.println("###########"+dtoItemMaintenece.getIv00104s2().size());
			
		}
		
		
		/*if(list != null && list.size()>0)
		{
			for(ItemKits itemKits:list)
			{
				dtoItemKitsRes.setIndex(itemKits.getIndex());
				dtoItemKitsRes.setItemDescription(itemKits.getIv001011().getItemDescription());
				dtoItemKitsRes.setItemNumberComponent(itemKits.getIv001011().getItemNumber());
				dtoItemKitsRes.setItemKitUnitMeasure(itemKits.getIv001011().getIv40100().getUnitOfMeasureId());
				dtoItemKitsRes.setCurrentCost(itemKits.getIv001011().getCurrentCost());
				dtoItemKitsRes.setComponentItemQuantity(itemKits.getComponentItemQuantity());
				dtoItemKitsList.add(dtoItemKitsRes);
				
			}
		}*/
		return dtoItemMaintenece;
	}
	
	/**
	 * @param dtoItemKits
	 * @return
	 */

	public DtoItemKits delete(DtoItemKits dtoItemKits) {

		ItemKits itemKits = repositoryItemKits.findOne(dtoItemKits.getIndex());
		if (itemKits != null) {
			itemKits.setStatus(true);
			itemKits = repositoryItemKits.save(itemKits);
			BeanUtils.copyProperties(itemKits, dtoItemKits);
			return dtoItemKits;
		}

		return dtoItemKits;
	}
	
	
	public ItemMaintenance getByItemKitNumber(DtoItemKits dtoItemKits)
	{
		short value = (short) 4;
		ItemMaintenance itemMaintenancekit = repositoryItemMaintainance
				.findByItemNumberAndItemType(dtoItemKits.getItemKitNumber(), value);
		
		
		int ordinal=0;
		for(CostOfGoodsSold a:CostOfGoodsSold.values())
		{
			System.out.println("value is="+a.getValue());
			 ordinal=a.getValue();
			if(ordinal==1)
			{
				break;
			}
		}
		
		if(dtoItemKits.getCostOfGoodsSold()==ordinal)
		{
			BigDecimal standardCost=repositoryItemMaintainance.sumOfStandardCost(false);
			itemMaintenancekit.setStandardCost(standardCost);
			BigDecimal currentCost=repositoryItemMaintainance.sumOfCurrentCost(false);
			itemMaintenancekit.setCurrentCost(currentCost);	
		}
		
		return itemMaintenancekit;
	}

}
