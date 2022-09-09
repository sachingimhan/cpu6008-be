package com.boltion.carsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@RestController
@RequestMapping("*")
public class WildCardController {

    @RequestMapping
    public String wildcard() {
        return "Server is UP and Running!";
    }
}
