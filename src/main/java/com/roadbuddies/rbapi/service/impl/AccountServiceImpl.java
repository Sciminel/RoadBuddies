package com.roadbuddies.rbapi.service.impl;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadbuddies.rbapi.model.Account;
import com.roadbuddies.rbapi.repository.AccountRepository;
import com.roadbuddies.rbapi.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account getAccountById(Long id) {
		// TODO Auto-generated method stub
		// L'utilisation d'un getById genere une erreur hibernate... Get recupere en lazy et findBy en eager (A REVOIR) 
		//return userRepository.getById(id);
		return accountRepository.findById(id).get();
	}

	@Override
	public Account saveAccount(Account user) {
		// TODO Auto-generated method stub
		return accountRepository.save(user);
	}

	@Override
	public Account updateAccount(Account user, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(id);
	}
	
	
	
}
