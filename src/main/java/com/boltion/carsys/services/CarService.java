package com.boltion.carsys.service;

import com.boltion.carsys.dto.CarDTO;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

public interface CarService {
    boolean saveCar(CarDTO dto);

    boolean updateCar(CarDTO dto);

    CarDTO searchCar(String id);

    boolean deleteCar(String id);

    List<CarDTO> getAllCars();

    Page<CarDTO> getAllCars(int page, int size);

    List<CarDTO> getCars(Date from, Date to, String type);
}
