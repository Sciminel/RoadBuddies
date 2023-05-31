package com.roadbuddies.rbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roadbuddies.rbapi.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	Account findByUsername(final String username);
	void deleteById(Long id);

}
