package com.transaction.domain.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.transaction.domain.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_transaction")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long originAccount;

    private Long destinationAccount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    private Instant createdAt;
    
}