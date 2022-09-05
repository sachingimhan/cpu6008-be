package com.boltion.carsys.repo;

import com.boltion.carsys.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @auther sachin
 * @date 2022-09-05
 */
public interface UserLoginRepo extends JpaRepository<UserLogin,String> {
    boolean existsByEmail(String email);

    UserLogin findByEmail(String email);

    @Query(value = "SELECT * FROM userlogin WHERE email=:email AND password=:pass", nativeQuery = true)
    UserLogin checkLogin(@Param("email") String email, @Param("pass") String password);
}