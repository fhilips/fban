package com.transaction.service;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public interface TransactionService {

	User deposit(User user);

	User withdraw(User user);

	User transfer(User user);

}
