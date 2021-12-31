package com.user.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.domain.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
