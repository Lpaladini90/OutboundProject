package com.outbound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outbound.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {


	@Autowired
	private UserService userServ;
	
	@GetMapping("ping")
	public String getPing() {
		return "pong";
	}
	
	
	
	
}
