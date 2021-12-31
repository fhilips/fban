package com.user.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.domain.model.User;
import com.user.domain.repositories.UserRepository;
import com.user.domain.service.UserService;

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
		System.out.println(user.getPassword());
		User newUser = User.builder()
			.username(user.getUsername())
			.client(user.getClient())
			.email(user.getEmail())
			.password(passwordEncoder.encode(user.getPassword()))
			.role(user.getRole())
			.build();
		
		return repository.save(newUser);		
	}	
	
}
