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
    @Query(value = "SELECT * FROM driver WHERE nic NOT IN (SELECT dr_id FROM rent WHERE (:pikupDate BETWEEN from_date AND to_date AND :returnDate BETWEEN from_date AND to_date))", nativeQuery = true)
    List<Driver> searchAvailableDrivers(@Param("pikupDate") Date pikupDate, @Param("returnDate") Date returnDate);
}
