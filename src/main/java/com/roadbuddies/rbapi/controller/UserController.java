package com.roadbuddies.rbapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roadbuddies.rbapi.model.User;
import com.roadbuddies.rbapi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public User getUserById (@PathVariable Long id) {
		
		return userService.getUserById(id);
	}
	
	
}
