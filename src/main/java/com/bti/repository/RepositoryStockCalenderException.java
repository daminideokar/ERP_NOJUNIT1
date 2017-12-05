package com.bti.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bti.model.StockCalendarExceptionDaysSetUp;
/**
 * Name of Project: BTI 
 * Description: Interface for RepositoryStockCalenderException
 * Created on: 
 * Modified on:
 * @author goodtech
 * version :
 */
public interface RepositoryStockCalenderException extends JpaRepository<StockCalendarExceptionDaysSetUp, Integer>{

	
	/**
	 * @param pageable
	 * @return
	 */
	public List<StockCalendarExceptionDaysSetUp> findBy(Pageable pageable);
	
	/**
	 * @param
	 * @return
	 */
	public List<StockCalendarExceptionDaysSetUp> findByOrderByCreateDateDesc();
	
	
	/**
	 * @param deleted
	 * @param IdSetup
	 * @return
	 */
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("delete from StockCalendarExceptionDaysSetUp sce where sce.idStock=:idStock")
	public int deleteStockcalenderException(@Param("idStock") Integer idStock);

}
