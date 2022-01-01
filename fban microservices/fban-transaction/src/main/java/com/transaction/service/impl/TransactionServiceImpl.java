package com.transaction.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.domain.model.Transaction;
import com.transaction.domain.repositories.TransactionRepository;
import com.transaction.service.TransactionService;
import com.transaction.web.dto.request.TransactionRequest;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;
	
	@Override
	public Transaction deposit(TransactionRequest transactionRequest) {
		Transaction transaction = Transaction.builder()
								             .amount(null)
								             .createdAt(null)
								             .destinationAccount(null)
								             .originAccount(null)
								             .build();
		return repository.save(transaction);
	}

	@Override
	public Transaction withdraw(TransactionRequest transactionRequest) {
		
		return null;
	}

	@Override
	public Transaction transfer(TransactionRequest transactionRequest) {
	
		return null;
	}

}
