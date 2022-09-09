package com.boltion.carsys.services;

import com.boltion.carsys.dto.DriverDTO;

import java.sql.Date;
import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

public interface DriverService {
    boolean saveDriver(DriverDTO dto);

    boolean updateDriver(DriverDTO dto);

    DriverDTO searchDriver(String id);

    boolean deleteDriver(String id);

    List<DriverDTO> getAllDrivers();

    List<DriverDTO> searchAvailableDrivers(Date from, Date to);
}
