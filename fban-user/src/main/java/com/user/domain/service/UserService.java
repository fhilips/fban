package com.user.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.domain.model.User;
import com.user.domain.repositories.UserRepository;

@Service	
public class UserService {

	@Autowired
	private UserRepository repository;

	public User findById(Long id) {		
		return repository.findById(id).orElseThrow();
	}

	public User findByEmail(String email) {		
		return repository.findByEmail(email);
	}
	
	
}
