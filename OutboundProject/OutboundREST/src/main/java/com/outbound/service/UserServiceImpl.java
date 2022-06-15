package com.outbound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.User;
import com.outbound.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepo;
	
		
	
	@Override
	public List<User> indexAll() {
		return userRepo.findAll();
	}

	
	
	
}
