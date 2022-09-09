package com.boltion.carsys.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@RestController
@RequestMapping("*")
public class WildCardController {

    @RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity wildcard(){
        return ResponseEntity.status(HttpStatus.OK).body("API Server is UP and Running.!");
    }
}
