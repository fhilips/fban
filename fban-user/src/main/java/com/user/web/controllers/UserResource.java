package com.user.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.domain.model.User;
import com.user.domain.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
			
	@Autowired
	private UserService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		return ResponseEntity.ok(service.findByEmail(email));
	}
	
}