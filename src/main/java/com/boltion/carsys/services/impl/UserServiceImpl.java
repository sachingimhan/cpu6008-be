package com.boltion.carsys.services.impl;

import com.boltion.carsys.dto.UserLoginDTO;
import com.boltion.carsys.entity.Customer;
import com.boltion.carsys.entity.UserLogin;
import com.boltion.carsys.repo.CustomerRepo;
import com.boltion.carsys.repo.UserLoginRepo;
import com.boltion.carsys.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserLoginRepo repo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public boolean registration(UserLoginDTO dto) {
        if (!repo.findByEmail(dto.getEmail()).isPresent()) {
            dto.setRole("User");
            UserLogin login = mapper.map(dto, UserLogin.class);
            repo.save(login);
            Customer customer = mapper.map(dto.getCustomer(), Customer.class);
            customer.setLoginId(login.getId());
            customerRepo.save(customer);
            return true;
        }else {
            throw new RuntimeException("User Already exist.!");
        }
    }

    @Override
    public UserLoginDTO userLogin(String email, String password) {
        if (repo.findByEmail(email).isPresent()) {
            UserLogin user = repo.checkLogin(email, password);
            if (user != null) {
                return mapper.map(user, UserLoginDTO.class);
            } else {
                throw new RuntimeException("Incorrect Password");
            }
        } else {
            throw new RuntimeException("Incorrect Email or Password");
        }
    }

    @Override
    public boolean updateUserDetails(UserLoginDTO dto) {
        if (repo.findByEmail(dto.getEmail()).isPresent()) {
            repo.save(mapper.map(dto, UserLogin.class));
            return true;
        }
        return false;
    }
}
