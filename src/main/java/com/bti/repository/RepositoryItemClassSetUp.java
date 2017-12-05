package com.bti.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bti.model.ItemClassSetUp;

/**
 * Name of Project: BTI 
 * Description: Interface for Repository Item Class Setup
 * Created on: NOVEMBER 10, 2017
 * Modified on:
 * @author goodtech
 * version :
 */
public interface RepositoryItemClassSetUp extends JpaRepository<ItemClassSetUp, Integer>{

	
	/**
	 * @param pageable
	 * @return
	 */
	public List<ItemClassSetUp> findBy(Pageable pageable);

	/**
	 * @param status
	 * @return
	 */
	public List<ItemClassSetUp> findByStatusOrderByCreateDateDesc(Boolean status);
	
	/**
	 * @param status
	 * @param itemClassIndex
	 */
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update ItemClassSetUp itemclasssetup set itemclasssetup.status =:status where itemclasssetup.itemClassIndex =:itemClassIndex ")
	public void deleteItemClassSetup(@Param("status") Boolean status, @Param("itemClassIndex") Integer itemClassIndex);

	@Query("select classId from ItemClassSetUp classId where classId.itemClassId =:itemClassId")
	public ItemClassSetUp findBy(@Param("itemClassId")String itemClassId);
}
