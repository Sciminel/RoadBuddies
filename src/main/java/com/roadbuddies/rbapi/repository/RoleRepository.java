package com.roadbuddies.rbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roadbuddies.rbapi.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(final String name);
}
