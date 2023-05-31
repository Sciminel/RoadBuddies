package com.roadbuddies.rbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roadbuddies.rbapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	void deleteById(Long id);

}
