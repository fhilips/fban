package com.user.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.domain.model.Account;
import com.user.domain.model.Transaction;
import com.user.domain.model.enums.AccountStatus;
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

	@Override
	public void deposit(Transaction deposit) {
		Account acc = findById(deposit.getOriginAccount());
		isAccountStatusInactive(acc.getStatus());	
		acc.setBalance(acc.getBalance().add(deposit.getAmount()));	
		
		repository.save(acc);
	}	

	@Override
	public void withdraw(Transaction withdraw) {
		Account acc = findById(withdraw.getOriginAccount());
		isAccountStatusInactive(acc.getStatus());		
		isAmountBiggerThanBalance(withdraw.getAmount(), acc.getBalance());
		acc.setBalance(acc.getBalance().subtract(withdraw.getAmount()));		
		repository.save(acc);
		
	}	
	
	@Override
	public void transfer(Transaction transfer) {
		Account originAcc = findById(transfer.getOriginAccount());	
		isAccountStatusInactive(originAcc.getStatus());	
		isAmountBiggerThanBalance(transfer.getAmount(), originAcc.getBalance());
		
		Account destinationAcc = findById(transfer.getDestinationAccount());	
		isAccountStatusInactive(destinationAcc.getStatus());
		
		originAcc.setBalance(originAcc.getBalance().subtract(transfer.getAmount()));
		
		destinationAcc.setBalance(destinationAcc.getBalance().add(transfer.getAmount()));
		
		repository.save(originAcc);
		repository.save(destinationAcc);
		
	}
	
	private void isAccountStatusInactive(AccountStatus status) {		
		if(status.equals(AccountStatus.INACTIVE)) {
			throw new Error("Account is inactive");
		}		
	}
	
	private void isAmountBiggerThanBalance(BigDecimal amount, BigDecimal balance) {
		if(amount.compareTo(balance) > 1) {
			throw new Error("Amount is bigger than balance!");
		}		
	}
	
}
