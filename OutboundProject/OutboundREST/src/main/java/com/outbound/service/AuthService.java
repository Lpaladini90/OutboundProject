package com.outbound.service;

import com.outbound.entities.User;



public interface AuthService{
	
	public User register(User user);
	public User getUserByUsername(String username);
	
}
