package com.roadbuddies.rbapi.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roadbuddies.rbapi.exception.AccountException;
import com.roadbuddies.rbapi.model.Account;
import com.roadbuddies.rbapi.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping(path = "/accounts")
	public ResponseEntity<List<Account>> getAllAccounts () {
		List<Account> accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}
	
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public Account getAccountById (@PathVariable Long id) {
		
		return accountService.getAccountById(id);
	}
	
	@PostMapping(path = "/login")
	@Parameters({
		@Parameter(name = "username", required = true, description = "Entre ton username "),
		@Parameter(name = "password", required = true, description = "Entre ton mot de passe")
	})
	public Account getAccountByUsername (@RequestBody String username, String password){
		
		Account account = accountService.getAccountByUsername(username, password);

		return account;
	}
	

	@PostMapping(path = "/signup")
	@Operation(
			summary = "Method saveAccount" , 
			description = "Post method to add a new account"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	public ResponseEntity<Account> saveAccount (@RequestBody Account account) {

		Account newEntity;

		try {
			newEntity = accountService.saveAccount(account);
		}catch (AccountException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(account);
	}
	
	@PutMapping(path = "/{id}", produces = "application/json")
	public Account updateAccount (@PathVariable Long id) {
		
		
		
		
		return this.getAccountById(id);
	}
	


	
}
