package com.user.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.domain.model.User;
import com.user.domain.repositories.UserRepository;
import com.user.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired	
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User findById(Long id) {		
		return repository.findById(id).orElseThrow();
	}
	@Override
	public User findByEmail(String email) {		
		return repository.findByEmail(email);
	}

	@Override
	public User create(User user) {
		
		User newUser = User.builder()
							.username(user.getUsername())			
							.email(user.getEmail())
							.password(passwordEncoder.encode(user.getPassword()))
							.roles(user.getRoles())
							.build();
		
		return repository.save(newUser);		
	}	
	
}
