package com.roadbuddies.rbapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roadbuddies.rbapi.model.Car;
import com.roadbuddies.rbapi.service.CarService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/car")
public class CarController {

	@Autowired
	private CarService carService;
	
	/**
	 * Get all cars
	 * @return
	 */
	@GetMapping(path = "/cars")
	@Operation(
			summary = "Method GetAllCars" , 
			description = "GET method to get all cars"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	public ResponseEntity<List<Car>> getAllCars() {
		List<Car> cars = this.carService.getAllCars();
		return ResponseEntity.ok(cars);
	}
	
	/**
	 * Get car by id
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/{id}", produces = "application/json")
	@Operation(
			summary = "Method getCarById" , 
			description = "GET method to get a car by id"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@Parameter(name = "id", required = true, description = " \t Id to identified a car")
	public Car getCarById(@PathVariable Long id) {
		return this.carService.getCarById(id);
	}
	
	/**
	 * Save a new car
	 * @param car
	 * @return
	 */
	@PostMapping(path = "/create")
	@Operation(
			summary = "Method saveCar" , 
			description = "POST method to add a new car"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	public Car saveCar (@RequestBody Car car) {	
		return this.carService.saveCar(car);
	}
	
	/**
	 * Update a car 
	 * @param id
	 * @param car
	 * @return
	 */
	@PutMapping(path = "/update/{id}")
	@Operation(
			summary = "Method updateCar" , 
			description = "PUT method to update a car"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	public Car updateCar (@PathVariable Long id, @RequestBody Car car) {
		return this.carService.updateCar(car, id);
	}
	
	/**
	 * Delete car by id
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	@Operation(
			summary = "Method deleteCar" , 
			description = "DELETE method to delete a by id"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@Parameter(name = "id", required = true, description = " \t Id to identified an acocunt")
	public void deleteCarById (@PathVariable Long id) {
		this.carService.deleteCarById(id);
	}
	
}
