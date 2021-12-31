package com.user.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
