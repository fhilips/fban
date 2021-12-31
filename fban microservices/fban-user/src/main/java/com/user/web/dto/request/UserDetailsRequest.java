package com.user.web.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsRequest {

	private Long id;
    private String name;
    private LocalDate birthDate;    
    private String cellphone;
    private Long userId;
}
