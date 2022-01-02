package com.user.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.domain.model.Transaction;
import com.user.domain.model.UserDetails;
import com.user.services.UserDetailsService;
import com.user.web.dto.request.UserDetailsRequest;

@RestController
@RequestMapping(value = "/usersDetails")
public class UserDetailsController {
			
	@Autowired
	private UserDetailsService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDetails> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
		
	@PostMapping(value = "/create")
	public ResponseEntity<UserDetails> create(@Valid @RequestBody UserDetailsRequest userDetailsRequest) {
		return ResponseEntity.created(null).body(service.create(userDetailsRequest));
	}
	
}