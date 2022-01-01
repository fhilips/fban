package com.transaction.service;

import com.transaction.domain.model.Transaction;
import com.transaction.web.dto.request.TransactionRequest;

public interface TransactionService {

	Transaction deposit(TransactionRequest transaction);

	Transaction withdraw(TransactionRequest transaction);

	Transaction transfer(TransactionRequest transaction);

}
