package com.user.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.domain.model.UserDetails;


public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

	
}
