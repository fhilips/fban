package com.transaction.web.dto.request;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.transaction.domain.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

	    private Long originAccount;

	    private Long destinationAccount;

	    @Enumerated(EnumType.STRING)
	    private TransactionType type;

	    private BigDecimal amount;

	    private Instant createdAt;
	    
}
	    