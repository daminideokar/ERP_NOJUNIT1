package com.bti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bti.model.SiteBinsSetup;

public interface RepositorySiteBinsSetup extends JpaRepository<SiteBinsSetup, Integer> {

	/**
	 * @param locationBinName
	 * @return
	 */
	@Query("select sitebinssetup from SiteBinsSetup sitebinssetup where sitebinssetup.locationBinName =:locationBinName")
	public SiteBinsSetup findBy(@Param("locationBinName") String locationBinName);

	
	/**
	 * @param locationBinName
	 * @return
	 */
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("delete from SiteBinsSetup sitebinssetup where sitebinssetup.locationBinName=:locationBinName")
	public int deleteBy(@Param("locationBinName") String locationBinName);
	
	
	/**
	 * @param locationBinName
	 * @param phoneNumber
	 * @param faxNumber
	 * @return
	 */
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update SiteBinsSetup sitebinssetup set sitebinssetup.phoneNumber=:phoneNumber,sitebinssetup.faxNumber=:faxNumber where sitebinssetup.locationBinName=:locationBinName")
	public int updateSiteBinsSetup(@Param("locationBinName") String locationBinName,
			@Param("phoneNumber") String phoneNumber, @Param("faxNumber") String faxNumber);

}
