package com.user.services;

import com.user.domain.model.Account;
import com.user.domain.model.Transaction;
import com.user.web.dto.request.AccountRequest;

public interface AccountService {
	
	Account findById(Long id);

	Account create(AccountRequest accRequest);
	
	void deposit(Transaction deposit);
	
	void withdraw(Transaction withdraw);

	void transfer(Transaction transfer);
	
}
