package com.roadbuddies.rbapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roadbuddies.rbapi.model.Account;
import com.roadbuddies.rbapi.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public Account getAccountById (@PathVariable Long id) {
		
		return accountService.getAccountById(id);
	}
	
	// Revoir comment appeler la methode qui permet de recup en BDD un user
	@PostMapping(path = "/login")
	public Account getAccountByUsername (@RequestBody Account account) {
		System.out.println("Trouvé : " + account);
		return accountService.findByUsername(account.getUsername());
	}
	
	//
	@PostMapping(path = "/signup")
	public Account createAccount (@RequestBody Account account) {
		
		System.out.println("Trouvé : " + account);
		return accountService.saveAccount(account);
	}
	
}
