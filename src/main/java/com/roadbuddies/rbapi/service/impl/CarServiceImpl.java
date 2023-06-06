package com.roadbuddies.rbapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roadbuddies.rbapi.model.Car;
import com.roadbuddies.rbapi.repository.CarRepository;
import com.roadbuddies.rbapi.service.CarService;
import com.roadbuddies.rbapi.util.EntityUpdater;


@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getAllCars() {
		return this.carRepository.findAll();
	}

	@Override
	public Car getCarById(Long id) {
		return this.carRepository.findById(id).get();
	}

	@Override
	public Car saveCar(Car car) {
		return this.carRepository.save(car);
	}

	@Override
	public Car updateCar(Car car, Long id) {
		Car existingCar = this.carRepository.findById(id).get();
		existingCar = EntityUpdater.updateEntity(existingCar, car);
		return this.carRepository.save(existingCar);
	}

	@Override
	public void deleteCarById(Long id) {
		this.carRepository.deleteById(id);
	}

		
	
}
