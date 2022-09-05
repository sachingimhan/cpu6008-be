package com.boltion.carsys.services;

import com.boltion.carsys.dto.UserLoginDTO;

/**
 * @auther sachin
 * @date 2022-09-05
 */
public interface UserService {
    boolean registration(UserLoginDTO dto);
    UserLoginDTO userLogin(String email,String password);
    boolean updateUserDetails(UserLoginDTO dto);
}
