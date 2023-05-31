package com.roadbuddies.rbapi.service;

import com.roadbuddies.rbapi.model.User;

public interface UserService {

	public User getUserById(Long id);
	public User saveUser(User user);
	public User updateUser(User user, Long id);
	public void deleteUser(Long id);
}
