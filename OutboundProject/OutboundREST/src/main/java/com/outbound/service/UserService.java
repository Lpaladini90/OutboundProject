package com.outbound.service;

import java.util.Set;

import com.outbound.entities.User;

public interface UserService {

	User getUserById(int userId);
	
	public Set<User> findUserWithUsernameLike(String keyword);
	
	public User updateUser(User user, String username); 
	
	
}
