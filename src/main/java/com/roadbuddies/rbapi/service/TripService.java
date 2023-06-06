package com.roadbuddies.rbapi.service;

import java.util.List;

import com.roadbuddies.rbapi.model.Trip;

public interface TripService {

	List<Trip> getAllTrips();
	Trip getTripById(Long id);
	Trip saveTrip(Trip trip);
	Trip updateTrip(Trip trip, Long id);
	void deleteTripById(Long id);
}
