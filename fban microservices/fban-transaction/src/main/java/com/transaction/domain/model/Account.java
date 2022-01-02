package com.transaction.domain.model;

import java.math.BigDecimal;

import com.transaction.domain.model.enuns.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;

    private Long agencyNumber;

    private Long accountNumber;

    private Character accountDigit;

    private BigDecimal balance;
    
    private AccountStatus status;

}