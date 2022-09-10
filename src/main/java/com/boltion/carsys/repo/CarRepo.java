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
    @Query(value = "SELECT * FROM car WHERE reg_no NOT IN (SELECT rent.reg_no FROM rent WHERE (:pikupDate BETWEEN from_date AND to_date AND :returnDate BETWEEN from_date AND to_date)) AND states='active'", nativeQuery = true)
    List<Car> searchCar(@Param("pikupDate") Date pikupDate, @Param("returnDate") Date returnDate);
}
