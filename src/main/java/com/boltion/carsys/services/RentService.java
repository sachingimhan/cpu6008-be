package com.boltion.carsys.service;

import com.boltion.carsys.dto.RentDTO;

import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */


public interface RentService {
    boolean saveRent(RentDTO dto);

    boolean updateRent(RentDTO dto);

    List<RentDTO> searchRent(String id);

    boolean deleteRent(int id);

    List<RentDTO> getAllRents();

    boolean requestStateChange(String reqId, String state, String reason);
}
