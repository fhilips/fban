package com.transaction.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.transaction.domain.model.Account;
import com.transaction.web.dto.request.TransactionRequest;

@Component
@FeignClient(name = "fban-user", path = "/accounts")
public interface AccountFeignClient {

	@GetMapping(value = "{id}")
	ResponseEntity<Account> findById(@RequestParam Long id);
	
	@PostMapping(value = "deposit")
	ResponseEntity<?> deposit(@RequestBody TransactionRequest transaction);

	@PostMapping(value = "withdraw")
	ResponseEntity<?> withdraw(TransactionRequest transaction);
	
	@PostMapping(value = "transfer")
	ResponseEntity<?> transfer(TransactionRequest transaction);
	
}
