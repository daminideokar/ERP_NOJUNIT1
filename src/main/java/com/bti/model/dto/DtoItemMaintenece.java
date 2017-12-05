package com.bti.model.dto;


import java.util.ArrayList;
import java.util.List;

import com.bti.model.InventoryUnitOfMeasureScheduleSetUp;
import com.bti.model.ItemKits;
import com.bti.model.ItemMaintenance;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class DtoItemMaintenece extends ItemMaintenance {

	List<DtoItemKits> itemKitList = new ArrayList<DtoItemKits>();
	public DtoItemMaintenece() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param currentCost
	 * @param itemDescription
	 * @param iv00104s2
	 * @param iv40100
	 */
	public DtoItemMaintenece(ItemMaintenance itemMaintenance ,List<DtoItemKits> itemKitList1) {
		super(itemMaintenance.getCurrentCost(), itemMaintenance.getItemDescription(), itemMaintenance.getIv00104s2(), itemMaintenance.getIv40100());
		// TODO Auto-generated constructor stub
		
		this.itemKitList = itemKitList1;
	
	}

	public List<DtoItemKits> getItemKitList() {
		return itemKitList;
	}

	public void setItemKitList(List<DtoItemKits> itemKitList) {
		this.itemKitList = itemKitList;
	}

	
	
	
	

}
