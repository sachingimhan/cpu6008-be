package com.boltion.carsys.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@RestController
@RequestMapping("*")
@CrossOrigin
public class WildCardController {

    @RequestMapping
    public String wildcard() {
        return "Server is UP and Running! V 1.0.8";
    }
}
