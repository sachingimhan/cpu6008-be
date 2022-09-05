package com.boltion.carsys.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handler(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }
}
