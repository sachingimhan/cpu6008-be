package com.boltion.carsys.repo;

import com.boltion.carsys.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}
