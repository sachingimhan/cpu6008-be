package com.boltion.carsys.repo;

import com.boltion.carsys.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @auther sachin
 * @date 2022-09-05
 */
public interface CustomerRepo extends JpaRepository<Customer,String> {
}
