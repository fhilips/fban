package com.user.domain.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user_details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
  
	@Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;
    
    @Column(name = "cellphone")
    private String cellphone;
       
    @OneToOne   
    @MapsId
    private User user;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

}