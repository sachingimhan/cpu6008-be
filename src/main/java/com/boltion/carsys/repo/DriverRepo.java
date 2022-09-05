package com.boltion.carsys.repo;

import com.boltion.carsys.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

public interface DriverRepo extends JpaRepository<Driver, String> {
    @Query(value = "SELECT * FROM driver WHERE nic NOT IN (SELECT DrId FROM rent WHERE (:pikupDate BETWEEN fromDate AND toDate AND :returnDate BETWEEN fromDate AND toDate))", nativeQuery = true)
    List<Driver> searchAvailableDrivers(@Param("pikupDate") Date pikupDate, @Param("returnDate") Date returnDate);
}
