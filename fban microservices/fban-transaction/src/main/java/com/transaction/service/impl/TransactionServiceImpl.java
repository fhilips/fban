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
	public Transaction deposit(TransactionRequest deposit) {
		accFeignClient.findById(deposit.getOriginAccount()).getBody();	
		accFeignClient.deposit(deposit);	
		
		Transaction transaction = Transaction.builder()
											 .type(TransactionType.DEPOSIT)
								             .amount(deposit.getAmount())
								             .createdAt(Instant.now())
								             .destinationAccount(deposit.getDestinationAccount())
								             .originAccount(deposit.getOriginAccount())
								             .build();
		return repository.save(transaction);
	}

	@Override
	public Transaction withdraw(TransactionRequest withdraw) {		
		accFeignClient.findById(withdraw.getOriginAccount()).getBody();	
		accFeignClient.withdraw(withdraw);	
		Transaction transaction = Transaction.builder()
								 .type(TransactionType.WITHDRAW)
					             .amount(withdraw.getAmount())
					             .createdAt(Instant.now())
					             .destinationAccount(withdraw.getDestinationAccount())
					             .originAccount(withdraw.getOriginAccount())
					             .build();
		return repository.save(transaction);
	}

	@Override
	public Transaction transfer(TransactionRequest transfer) {
		accFeignClient.findById(transfer.getOriginAccount()).getBody();	
		accFeignClient.findById(transfer.getDestinationAccount()).getBody();	
		accFeignClient.transfer(transfer);	

		Transaction transaction = Transaction.builder()
								 .type(TransactionType.TRANSFER)
					             .amount(transfer.getAmount())
					             .createdAt(Instant.now())
					             .destinationAccount(transfer.getDestinationAccount())
					             .originAccount(transfer.getOriginAccount())
					             .build();
		return repository.save(transaction);
		
	}

}
