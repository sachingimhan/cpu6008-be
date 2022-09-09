package com.boltion.carsys.services.impl;

import com.boltion.carsys.dto.RentDTO;
import com.boltion.carsys.entity.Rent;
import com.boltion.carsys.repo.CarRepo;
import com.boltion.carsys.repo.DriverRepo;
import com.boltion.carsys.repo.RentRepo;
import com.boltion.carsys.services.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@Service
@Transactional
public class RentServiceImpl implements RentService {
    @Autowired
    RentRepo repo;
    @Autowired
    ModelMapper mapper;
    @Autowired
    CarRepo carRepo;
    @Autowired
    DriverRepo driverRepo;

    @Override
    public boolean saveRent(RentDTO dto) {
        Rent map = mapper.map(dto, Rent.class);
        Rent save = repo.save(map);
        return save != null;
    }

    @Override
    public boolean updateRent(RentDTO dto) {
        if (repo.existsById(dto.getReqId())) {
            repo.save(mapper.map(dto, Rent.class));
            return true;
        }
        return false;
    }

    @Override
    public List<RentDTO> searchRent(String id) {
        List<Rent> allByCustomer = repo.getAllRequestFromCustomer(id);
        if (allByCustomer.size() > 0) {
            return mapper.map(allByCustomer, new TypeToken<List<RentDTO>>() {
            }.getType());
        }
        return null;
    }

    @Override
    public boolean deleteRent(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<RentDTO> getAllRents() {
        Sort sort = Sort.by(Sort.Order.desc("palaceDate"));
        List<Rent> all = repo.findAll(sort);
        if (all.size() > 0) {
            return mapper.map(all, new TypeToken<List<RentDTO>>() {
            }.getType());
        }
        return null;
    }

    @Override
    public boolean requestStateChange(String reqId, String state, String reason) {
        repo.changeRequestState(reqId, state, reason);
        return true;
    }
}
