package com.roadbuddies.rbapi.service;

import com.roadbuddies.rbapi.model.Account;

public interface AccountService {

	Account getAccountById(Long id);
	Account saveAccount(Account user);
	Account updateAccount(Account user, Long id);
	void deleteAccount(Long id);
	Account findByUsername(String username);
}
