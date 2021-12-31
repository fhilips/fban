package com.user.web.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
	
	    private Long agencyNumber;

	    private Long accountNumber;

	    private Character accountDigit;

	    private BigDecimal balance;

	    private Long userId;
}
