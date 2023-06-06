package com.roadbuddies.rbapi.service;

import java.util.List;

import com.roadbuddies.rbapi.exception.AccountException;
import com.roadbuddies.rbapi.model.Account;

public interface AccountService {

	List<Account> getAllAccounts();
	Account getAccountById(Long id);
	Account saveAccount(Account account) throws AccountException;
	Account updateAccount(Account account, Long id);
	void deleteAccountById(Long id);
	Account getAccountByUsername(String username, String password);
}
