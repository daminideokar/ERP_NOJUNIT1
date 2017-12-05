package com.bti.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bti.model.ItemKits;
import com.bti.model.ItemMaintenance;

public interface RepositoryItemMaintainance extends JpaRepository<ItemMaintenance, Integer> {

	public ItemMaintenance findByItemNumberAndItemType(String itemKitNumber,short itemType);
	
	@Query("select sum(standardCost) from ItemMaintenance itemMaintenance where itemMaintenance.status=:status")
	public BigDecimal sumOfStandardCost(@Param("status")Boolean status);
	
	@Query("select sum(currentCost) from ItemMaintenance itemMaintenance where itemMaintenance.status=:status")
	public BigDecimal sumOfCurrentCost(@Param("status")Boolean status);
}
