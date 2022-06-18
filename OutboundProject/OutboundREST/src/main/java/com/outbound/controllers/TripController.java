package com.outbound.controllers;


import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outbound.entities.Trip;
import com.outbound.service.TripService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:8096" })
public class TripController {
	
	
	@Autowired
	private TripService tripServ;

	
	@GetMapping("users/trips")
	public List<Trip> indexByUser(Principal principal, HttpServletResponse res){
		
		return tripServ.indexAll(principal.getName());
		
	}
	
}
