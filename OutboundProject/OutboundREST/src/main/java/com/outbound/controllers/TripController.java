package com.outbound.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outbound.entities.Trip;
import com.outbound.service.TripService;
import com.outbound.service.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:8096" })
public class TripController {

	@Autowired
	private TripService tripServ;
	
	@Autowired
	private UserService userServ;

	@GetMapping("users/trips")
	public List<Trip> indexByUser(Principal principal, HttpServletResponse res) {
		List<Trip> trips = tripServ.indexAll(principal.getName());
		if (trips != null) {
			res.setStatus(200);
			return trips;
		} else {
			res.setStatus(404);
			return trips;
		}

	}

	@GetMapping("users/trips/{id}")
	public Trip findTripByIdAndUser(Principal principal, @PathVariable("id") int tripId, HttpServletResponse res) {
			Trip trip = tripServ.findTripById(tripId, principal.getName());
			if (trip != null) {
				res.setStatus(200);
				return trip;
			} else {
				res.setStatus(404);
				return null;
			}
		
	
	}
	
	

}
