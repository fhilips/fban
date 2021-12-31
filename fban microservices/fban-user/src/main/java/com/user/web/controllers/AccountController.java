package com.user.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.domain.model.Account;
import com.user.services.AccountService;
import com.user.web.dto.request.AccountRequest;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
			
	@Autowired
	private AccountService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Account> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
		
	@PostMapping(value = "/register")
	public ResponseEntity<Account> create(@Valid @RequestBody AccountRequest accountRequest) {
		return ResponseEntity.created(null).body(service.create(accountRequest));
	}
	
}