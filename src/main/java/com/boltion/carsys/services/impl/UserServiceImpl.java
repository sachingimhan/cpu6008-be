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
        if (!repo.existsByEmail(dto.getEmail())) {
            dto.setRole("User");
            repo.save(mapper.map(dto, UserLogin.class));
            customerRepo.save(mapper.map(dto.getCustomer(), Customer.class));
            return true;
        }
        return false;
    }

    @Override
    public UserLoginDTO userLogin(String email, String password) {
        if (repo.existsByEmail(email)) {
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
        if (repo.existsByEmail(dto.getEmail())) {
            repo.save(mapper.map(dto, UserLogin.class));
            return true;
        }
        return false;
    }
}
