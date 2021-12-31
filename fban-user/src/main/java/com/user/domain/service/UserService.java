package com.user.domain.service;

import org.springframework.stereotype.Service;

import com.user.domain.model.User;

@Service	
public interface UserService {

	public User findById(Long id);

	public User findByEmail(String email);
	
}
