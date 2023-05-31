package com.roadbuddies.rbapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadbuddies.rbapi.model.User;
import com.roadbuddies.rbapi.repository.UserRepository;
import com.roadbuddies.rbapi.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		// L'utilisation d'un getById genere une erreur hibernate... Get recupere en lazy et findBy en eager (A REVOIR) 
		//return userRepository.getById(id);
		return userRepository.findById(id).get();
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	
	
	
}
