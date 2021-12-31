package com.user.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agency_number", nullable = false)
    private Long agencyNumber;

    @Column(name = "account_number", nullable = false)
    private Long accountNumber;

    @Column(name = "account_digit", nullable = false)
    private Character accountDigit;

    @Column(nullable = false, columnDefinition = "decimal(10, 2) default 0")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserDetails client;

}