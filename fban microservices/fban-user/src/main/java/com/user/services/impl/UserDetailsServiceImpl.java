package com.user.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.domain.model.UserDetails;
import com.user.domain.repositories.UserDetailsRepository;
import com.user.services.UserDetailsService;
import com.user.services.UserService;
import com.user.web.dto.request.UserDetailsRequest;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepository repository;
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails findById(Long id) {		
		return repository.findById(id).orElseThrow();
	}

	@Override
	public UserDetails create(UserDetailsRequest userDetailsRequest) {	
		
		UserDetails ud = UserDetails.builder()
									.cellphone(userDetailsRequest.getCellphone())
									.name(userDetailsRequest.getName())
									.user(userService.findById(userDetailsRequest.getUserId()))
									.build();	
		
		return repository.save(ud);
	}
	
		
}
