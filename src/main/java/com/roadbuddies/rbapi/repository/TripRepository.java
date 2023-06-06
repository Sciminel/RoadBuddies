package com.roadbuddies.rbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roadbuddies.rbapi.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{

	
}
