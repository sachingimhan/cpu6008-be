package com.boltion.carsys.repo;

import com.boltion.carsys.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

public interface RentRepo extends JpaRepository<Rent, Integer> {
    @Query(value = "SELECT * FROM rent WHERE cust_nic=:nic ", nativeQuery = true)
    List<Rent> getAllRequestFromCustomer(@Param("nic") String nic);

    @Modifying
    @Query(value = "UPDATE rent SET state=:val2, reason=:val3 WHERE req_id=:val1 ", nativeQuery = true)
    void changeRequestState(@Param("val1") String req, @Param("val2") String state, @Param("val3") String reason);
}
