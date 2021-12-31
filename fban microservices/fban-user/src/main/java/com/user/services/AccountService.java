package com.user.services;

import com.user.domain.model.Account;
import com.user.web.dto.request.AccountRequest;

public interface AccountService {
	
	Account findById(Long id);

	Account create(AccountRequest accRequest);
	
}
