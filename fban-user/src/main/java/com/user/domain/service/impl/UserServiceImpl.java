package com.user.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.user.domain.model.User;
import com.user.domain.repositories.UserRepository;

public class UserServiceImpl {
	
	@Autowired
	private UserRepository repository;

	public User findById(Long id) {		
		return repository.findById(id).orElseThrow();
	}

	public User findByEmail(String email) {		
		return repository.findByEmail(email);
	}	
	
}
