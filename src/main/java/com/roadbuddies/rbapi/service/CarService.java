package com.roadbuddies.rbapi.service;

import java.util.List;

import com.roadbuddies.rbapi.model.Car;

public interface CarService {

	Car getCarById(Long id);
	Car saveCar(Car car);
	Car updateCar(Car car, Long id);
	void deleteCarById(Long id);
	List<Car> getAllCars();
	
}
