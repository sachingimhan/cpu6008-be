package com.boltion.carsys.repo;

import com.boltion.carsys.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

public interface CarRepo extends JpaRepository<Car, String> {
    @Query(value = "SELECT * FROM car WHERE regNo NOT IN (SELECT RegNo FROM rent WHERE (:pikupDate BETWEEN fromDate AND toDate AND :returnDate BETWEEN fromDate AND toDate)) AND type=:cType AND states='active'", nativeQuery = true)
    List<Car> searchCar(@Param("pikupDate") Date pikupDate, @Param("returnDate") Date returnDate, @Param("cType") String cType);
}
