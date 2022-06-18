package com.outbound.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.outbound.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
	Set<User> findByUsernameLike(@Param("keyword") String keyword); 
	

}
