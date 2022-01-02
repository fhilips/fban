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

import com.user.domain.model.Account;
import com.user.domain.model.Transaction;
import com.user.domain.model.UserDetails;
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
	
	@PostMapping(value = "/deposit")
	public ResponseEntity<?> deposit(@Valid @RequestBody Transaction deposit) {
		service.deposit(deposit);
		return ResponseEntity.ok().body(null);
	}
	
	@PostMapping(value = "/withdraw")
	public ResponseEntity<?> withdraw(@Valid @RequestBody Transaction withdraw) {
		service.withdraw(withdraw);
		return ResponseEntity.ok().body(null);
	}
	
	@PostMapping(value = "/transfer")
	public ResponseEntity<?> transfer(@Valid @RequestBody Transaction transfer) {
		service.transfer(transfer);
		return ResponseEntity.ok().body(null);
	}
}