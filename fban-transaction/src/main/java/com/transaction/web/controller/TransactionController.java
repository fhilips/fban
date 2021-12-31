package com.transaction.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.service.MessageResponse;
import com.transaction.service.TransactionService;
import com.transaction.service.impl.MessageResponseImpl;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController implements MessageResponse{
	
	@Autowired
	private TransactionService service;
	
	@PostMapping("deposit")
    public ResponseEntity<MessageResponse> deposit(@RequestBody User user) {
        service.deposit(user);
        return ResponseEntity.created(null).body(createMessageResponse(1l,"Desposito feito com sucesso"));
    }
	
	@PostMapping("withdraw")
    public ResponseEntity<MessageResponse> withdraw(@RequestBody User user) {
		service.withdraw(user);
        return ResponseEntity.created(null).body(createMessageResponse(1l,"Retirada feita com sucesso"));
    }
	
	@PostMapping("transfer")
    public ResponseEntity<MessageResponse> tranfer(@RequestBody User user) {
		service.transfer(user);
		return ResponseEntity.created(null).body(createMessageResponse(1l,"Tranferencia criada com sucesso"));
    }

	@Override
	public MessageResponseImpl createMessageResponse(Long id, String text) {		
		return new MessageResponseImpl(text + " " + id); 
	}
}
