package com.boltion.carsys.controller;

import com.boltion.carsys.dto.RentDTO;
import com.boltion.carsys.service.RentService;
import com.boltion.carsys.util.StrandedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@RestController
@RequestMapping("/api/v1/rent")
@CrossOrigin
public class RentController {


    private RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping("/")
    public ResponseEntity<?> saveCar(@RequestBody RentDTO dto) {
        boolean b = rentService.saveRent(dto);
        if (b) {
            return new ResponseEntity<>(new StrandedResponse(b, "Rent Saved.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(b, "Rent Not Saved.!"), HttpStatus.OK);
        }

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCar(@RequestBody RentDTO dto) {
        boolean b = rentService.updateRent(dto);
        if (b) {
            return new ResponseEntity<>(new StrandedResponse(b, "Rent Updated.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(b, "Rent Not Updated.!"), HttpStatus.OK);
        }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<?> deleteCar(@RequestParam("id") int id) {
        boolean b = rentService.deleteRent(id);
        if (b) {
            return new ResponseEntity<>(new StrandedResponse(b, "Rent Deleted.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(b, "Rent Not Deleted.!"), HttpStatus.OK);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> searchCar(@PathVariable("id") String id) {
        List<RentDTO> rentDTOS = rentService.searchRent(id);
        if (rentDTOS != null) {
            return new ResponseEntity<>(new StrandedResponse(true, "Rent Found.!", rentDTOS), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(false, "Rent Not Found.!"), HttpStatus.OK);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCars() {
        List<RentDTO> allRents = rentService.getAllRents();
        if (allRents != null) {
            return new ResponseEntity<>(new StrandedResponse(true, "Rents Found.!", allRents), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(false, "Rents Not Found.!"), HttpStatus.OK);
        }
    }

    @PutMapping("/status/change")
    public ResponseEntity<?> changeRequestState(@RequestParam("reqId") String reqId, @RequestParam("state") String state, @RequestParam("reason") String reason) {
        boolean b = rentService.requestStateChange(reqId, state, reason);
        if (b) {
            return new ResponseEntity<>(new StrandedResponse(b, "Rent State Updated.!"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new StrandedResponse(b, "Rent State Not Updated.!"), HttpStatus.OK);
        }
    }

}
