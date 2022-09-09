package com.boltion.carsys.services;

import com.boltion.carsys.dto.CustomerDTO;
import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

public interface CustomerService {
    boolean saveCustomer(CustomerDTO dto);

    boolean updateCustomer(CustomerDTO dto);

    CustomerDTO searchCustomer(String id);

    boolean deleteCustomer(String id);

    List<CustomerDTO> getAllCustomers();
}
