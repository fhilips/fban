package com.user.domain.service;

import com.user.domain.model.User;

public interface UserService {

	public User findById(Long id);

	public User findByEmail(String email);
	
	public User create(User user);
	
}
