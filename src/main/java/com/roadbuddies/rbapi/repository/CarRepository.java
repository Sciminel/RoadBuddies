package com.roadbuddies.rbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roadbuddies.rbapi.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

	void deleteById(Long id);
}
