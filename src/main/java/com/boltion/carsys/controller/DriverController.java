package com.boltion.carsys.controller;

import com.boltion.carsys.dto.DriverDTO;
import com.boltion.carsys.service.DriverService;
import com.boltion.carsys.util.StrandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@RestController
@RequestMapping("/api/v1/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService service;

    @PostMapping("/")
    public ResponseEntity<?> saveDriver(@RequestBody DriverDTO dto) {
        boolean b = service.saveDriver(dto);
        if (b) {
            return new ResponseEntity<>(new StrandedResponse(b, "Driver Saved.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(b, "Driver Not Saved.!"), HttpStatus.OK);
        }

    }

    @PutMapping("/")
    public ResponseEntity<?> updateDriver(@RequestBody DriverDTO dto) {
        boolean b = service.updateDriver(dto);
        if (b) {
            return new ResponseEntity<>(new StrandedResponse(b, "Driver Updated.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(b, "Driver Not Updated.!"), HttpStatus.OK);
        }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<?> deleteCar(@RequestParam("id") String id) {
        boolean b = service.deleteDriver(id);
        if (b) {
            return new ResponseEntity<>(new StrandedResponse(b, "Driver Deleted.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(b, "Driver Not Deleted.!"), HttpStatus.OK);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> searchCar(@PathVariable("id") String id) {
        DriverDTO driverDTO = service.searchDriver(id);
        if (driverDTO != null) {
            return new ResponseEntity<>(new StrandedResponse(true, "Driver Found.!", driverDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(false, "Driver Not Found.!"), HttpStatus.OK);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCars() {
        List<DriverDTO> allDrivers = service.getAllDrivers();
        if (allDrivers.size() > 0) {
            return new ResponseEntity<>(new StrandedResponse(true, "Driver Found.!", allDrivers), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(false, "Driver Not Found.!"), HttpStatus.OK);
        }
    }


    @GetMapping(path = "find", params = {"fromDate", "toDate"})
    public ResponseEntity<?> findCar(@RequestParam("fromDate") Date fromDate, @RequestParam("toDate") Date toDate) {
        List<DriverDTO> driverDTOS = service.searchAvailableDrivers(fromDate, toDate);
        if (driverDTOS.size() > 0) {
            return new ResponseEntity<>(new StrandedResponse(true, "Found", driverDTOS), HttpStatus.OK);
        }
        return new ResponseEntity<>(new StrandedResponse(false, "Not Found"), HttpStatus.OK);
    }

}
