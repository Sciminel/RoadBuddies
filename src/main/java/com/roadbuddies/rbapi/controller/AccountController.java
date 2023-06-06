package com.roadbuddies.rbapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	/**
	 * Get all accounts 
	 * @return
	 */
	@GetMapping(path = "/accounts")
	@Operation(
			summary = "Method GetAllAccounts" , 
			description = "GET method to get all accounts"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	public ResponseEntity<List<Account>> getAllAccounts () {
		List<Account> accounts = this.accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}
	
	/**
	 * Get account by id
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/{id}", produces = "application/json")
	@Operation(
			summary = "Method getAccountById" , 
			description = "GET method to get an account by id"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@Parameter(name = "id", required = true, description = " \t Id to identified an acocunt")
	public Account getAccountById (@PathVariable Long id) {
		return this.accountService.getAccountById(id);
	}
	
	
	/**
	 * Log an user, search by user name and check password
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping(path = "/login")
	@Operation(
			summary = "Method getAccountByUsername" , 
			description = "GET method to get an account by username"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@Parameters({
		@Parameter(name = "username", required = true, description = " \t Entre ton username "),
		@Parameter(name = "password", required = true, description = " \t Entre ton mot de passe")
	})
	public Account getAccountByUsername (@RequestBody String username, String password){
		Account account = this.accountService.getAccountByUsername(username, password);
		return account;
	}
	

	/**
	 * Save a new account (user)
	 * @param account
	 * @return
	 */
	@PostMapping(path = "/signup")
	@Operation(
			summary = "Method saveAccount" , 
			description = "Post method to add a new account"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	public ResponseEntity<Account> saveAccount (@RequestBody Account account) {
		// Revoir si les methodes doivent renvoyer une ResponseEntity ou l'entité lui meme ( A VOIR !!! ) 		
		Account newEntity;
		try {
			newEntity = this.accountService.saveAccount(account);
		}catch (AccountException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(newEntity);
	}
	
	
	
	/**
	 * Update an account
	 * @param id
	 * @param account
	 * @return
	 */
	@PutMapping(path = "/update/{id}", produces = "application/json")
	@Operation(
			summary = "Method updateAccount" , 
			description = "PUT method to update an account"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "404", description = "Not Found"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})	
	@Parameter(name = "id", required = true, description = " \t Id to identified an acocunt")
	public Account updateAccount (@PathVariable Long id, @RequestBody Account account) {
		return this.accountService.updateAccount(account, id);
	}
	

	/**
	 * Delete account by id
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "/delete/{id}")
	@Operation(
			summary = "Method deleteAccount" , 
			description = "DELETE method to delete an account by id"
			)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK"),
	        @ApiResponse(responseCode = "400", description = "Bad Request"),
	        @ApiResponse(responseCode = "500", description = "Internal Server Error")
	})
	@Parameter(name = "id", required = true, description = " \t Id to identified an acocunt")
	public void deleteAccountById (@PathVariable Long id) {
		//Renvoyer une reponse comme quoi l'account a bien été deleted
		this.accountService.deleteAccountById(id);
	}

	
}
