package com.boltion.carsys.services.impl;

import com.boltion.carsys.dto.CustomerDTO;
import com.boltion.carsys.entity.Customer;
import com.boltion.carsys.repo.CustomerRepo;
import com.boltion.carsys.repo.UserLoginRepo;
import com.boltion.carsys.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepo repo;
    private ModelMapper mapper;
    private UserLoginRepo loginRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo repo, ModelMapper mapper, UserLoginRepo loginRepo) {
        this.repo = repo;
        this.mapper = mapper;
        this.loginRepo = loginRepo;
    }

    @Override
    public boolean saveCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getNic())) {
            repo.save(mapper.map(dto, Customer.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getNic())) {
            repo.save(mapper.map(dto, Customer.class));
            return true;
        }
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (id != null) {
            Optional<Customer> customer = repo.findById(id);
            if (customer.isPresent()) {
                return mapper.map(customer.get(), CustomerDTO.class);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(String id) {
        if (id != null) {
            if (repo.existsById(id)) {
                repo.deleteById(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        if (all.size() != 0) {
            return mapper.map(all, new TypeToken<List<CustomerDTO>>() {
            }.getType());
        }
        return null;
    }
}
