package com.roadbuddies.rbapi.service;

import java.util.List;

import com.roadbuddies.rbapi.model.Account;

public interface AccountService {

	Account getAccountById(Long id);
	Account saveAccount(Account account);
	Account updateAccount(Account account, Long id);
	void deleteAccount(Long id);
	Account getAccountByUsername(String username, String password);
	List<Account> getAllAccounts();
}
