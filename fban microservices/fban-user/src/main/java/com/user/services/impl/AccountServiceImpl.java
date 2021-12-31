package com.user.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.domain.model.Account;
import com.user.domain.repositories.AccountRepository;
import com.user.services.AccountService;
import com.user.services.UserDetailsService;
import com.user.web.dto.request.AccountRequest;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public Account findById(Long id) {
		
		return repository.findById(id).orElseThrow();
	}

	@Override
	public Account create(AccountRequest accRequest) {
		Account newAccount = Account.builder()
									.accountDigit(accRequest.getAccountDigit())
									.accountNumber(accRequest.getAccountNumber())
									.agencyNumber(accRequest.getAgencyNumber())
									.balance(accRequest.getBalance())
									.user(userDetailsService.findById(accRequest.getUserId()))
									.build();
		
		return repository.save(newAccount);
	}
	

	
}
