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

import com.roadbuddies.rbapi.model.Trip;
import com.roadbuddies.rbapi.service.TripService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api/trip")
public class TripController {

	
	@Autowired
	private TripService tripService;
	
	/**
	 * Get all trips
	 * @return
	 */
	@GetMapping(path = "/trips")
	@Operation(
			summary = "Method getAllTrips" , 
			description = "GET method to get all trips"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	public ResponseEntity<List<Trip>> getAllTrips() {
		List<Trip> trips = this.tripService.getAllTrips();
		return ResponseEntity.ok(trips);
	}
	
	/**
	 * Get trip by id
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/{id}", produces = "application/json")
	@Operation(
			summary = "Method getTripById" , 
			description = "GET method to get a trip by id"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@Parameter(name = "id", required = true, description = " \t Id to identified a trip")
	public Trip getTripById(@PathVariable Long id) {
		return this.tripService.getTripById(id);
	}
	
	/**
	 * Save a new trip
	 * @param trip
	 * @return
	 */
	@PostMapping(path = "/create")
	@Operation(
			summary = "Method saveTrip" , 
			description = "POST method to add a new trip"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	public Trip saveTrip (@RequestBody Trip trip) {	
		return this.tripService.saveTrip(trip);
	}
	
	/**
	 * Update a trip 
	 * @param id
	 * @param car
	 * @return
	 */
	@PutMapping(path = "/update/{id}")
	@Operation(
			summary = "Method updateTrip" , 
			description = "PUT method to update a trip"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	public Trip updateTrip (@PathVariable Long id, @RequestBody Trip trip) {
		return this.tripService.updateTrip(trip, id);
	}
	
	/**
	 * delete trip by id
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	@Operation(
			summary = "Method deleteTrip" , 
			description = "DELETE method to delete a trip by id"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@Parameter(name = "id", required = true, description = " \t Id to identified a trip")
	public void deleteTripById (@PathVariable Long id) {
		this.tripService.deleteTripById(id);
	}
	
}
