package com.transaction.service.impl;


import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transaction.domain.enums.TransactionType;
import com.transaction.domain.model.Transaction;
import com.transaction.domain.repositories.TransactionRepository;
import com.transaction.service.TransactionService;
import com.transaction.web.dto.request.TransactionRequest;
import com.transaction.web.feign.AccountFeignClient;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private AccountFeignClient accFeignClient;
	
	@Override
	public Transaction deposit(TransactionRequest transactionRequest) {
		accFeignClient.findById(transactionRequest.getOriginAccount()).getBody();	
		accFeignClient.deposit(transactionRequest);	
		
		Transaction transaction = Transaction.builder()
											 .type(TransactionType.DEPOSIT)
								             .amount(transactionRequest.getAmount())
								             .createdAt(Instant.now())
								             .destinationAccount(transactionRequest.getDestinationAccount())
								             .originAccount(transactionRequest.getOriginAccount())
								             .build();
		return repository.save(transaction);
	}

	@Override
	public Transaction withdraw(TransactionRequest transactionRequest) {		
		accFeignClient.findById(transactionRequest.getOriginAccount()).getBody();	
		accFeignClient.withdraw(transactionRequest);	
		Transaction transaction = Transaction.builder()
								 .type(TransactionType.WITHDRAW)
					             .amount(transactionRequest.getAmount())
					             .createdAt(Instant.now())
					             .destinationAccount(transactionRequest.getDestinationAccount())
					             .originAccount(transactionRequest.getOriginAccount())
					             .build();
		return repository.save(transaction);
	}

	@Override
	public Transaction transfer(TransactionRequest transactionRequest) {
		accFeignClient.findById(transactionRequest.getOriginAccount()).getBody();	
		accFeignClient.findById(transactionRequest.getDestinationAccount()).getBody();	
		accFeignClient.transfer(transactionRequest);	

		Transaction transaction = Transaction.builder()
								 .type(TransactionType.TRANSFER)
					             .amount(transactionRequest.getAmount())
					             .createdAt(Instant.now())
					             .destinationAccount(transactionRequest.getDestinationAccount())
					             .originAccount(transactionRequest.getOriginAccount())
					             .build();
		return repository.save(transaction);
		
	}

}
