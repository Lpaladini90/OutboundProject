package com.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outbound.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
}
