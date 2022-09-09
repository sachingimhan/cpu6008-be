package com.boltion.carsys.services.impl;

import com.boltion.carsys.dto.CustomerDTO;
import com.boltion.carsys.dto.DriverDTO;
import com.boltion.carsys.entity.Driver;
import com.boltion.carsys.repo.DriverRepo;
import com.boltion.carsys.services.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepo repo;
    @Autowired
    ModelMapper mapper;

    @Override
    public boolean saveDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getNic())) {
            repo.save(mapper.map(dto, Driver.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDriver(DriverDTO dto) {
        if (repo.existsById(dto.getNic())) {
            repo.save(mapper.map(dto, Driver.class));
            return true;
        }
        return false;
    }

    @Override
    public DriverDTO searchDriver(String id) {
        if (id != null) {
            Optional<Driver> driver = repo.findById(id);
            if (driver.isPresent()) {
                return mapper.map(driver.get(), DriverDTO.class);
            }
        }
        return null;
    }

    @Override
    public boolean deleteDriver(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<Driver> all = repo.findAll();
        if (all.size() > 0) {
            return mapper.map(all, new TypeToken<List<CustomerDTO>>() {
            }.getType());
        }
        return null;
    }

    @Override
    public List<DriverDTO> searchAvailableDrivers(Date from, Date to) {
        List<Driver> drivers = repo.searchAvailableDrivers(from, to);
        System.out.println(drivers.size());
        return mapper.map(drivers, new TypeToken<List<DriverDTO>>() {
        }.getType());
    }
}
