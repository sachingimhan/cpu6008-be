package com.boltion.carsys.services.impl;

import com.boltion.carsys.dto.CarDTO;
import com.boltion.carsys.entity.Car;
import com.boltion.carsys.repo.CarRepo;
import com.boltion.carsys.services.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class CarServiceImpl implements CarService {

    private CarRepo repo;
    private ModelMapper mapper;

    @Autowired
    public CarServiceImpl(CarRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public boolean saveCar(CarDTO dto) {
        if (!repo.existsById(dto.getRegNo())) {
            dto.setStates("active");
            repo.save(mapper.map(dto, Car.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCar(CarDTO dto) {
        if (repo.existsById(dto.getRegNo())) {
            repo.save(mapper.map(dto, Car.class));
            return true;
        }
        return false;
    }

    @Override
    public CarDTO searchCar(String id) {
        if (id != null) {
            Optional<Car> car = repo.findById(id);
            if (car.isPresent()) {
                return mapper.map(car.get(), CarDTO.class);
            }
        }
        return null;
    }

    @Override
    public boolean deleteCar(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> all = repo.findAll();
        if (all.size() > 0) {
            return mapper.map(all, new TypeToken<List<CarDTO>>() {
            }.getType());
        }
        return null;
    }

    @Override
    public Page<CarDTO> getAllCars(int page, int size) {
        Pageable req = PageRequest.of(page - 1, size);
        Page<Car> all = repo.findAll(req);
        return mapper.map(all, new TypeToken<Page<CarDTO>>() {
        }.getType());
    }

    @Override
    public List<CarDTO> getCars(Date from, Date to, String type) {
        List<Car> cars = repo.searchCar(from, to, type);
        if (cars.size() > 0) {
            return mapper.map(cars, new TypeToken<List<CarDTO>>() {
            }.getType());
        }
        return null;
    }
}
