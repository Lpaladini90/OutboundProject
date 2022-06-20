package com.outbound.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("trips")
	public List<Trip> indexByUser(Principal principal, HttpServletResponse res) {
	
		return 	tripServ.indexAll(principal.getName());
	}

	@GetMapping("trips/{id}")
	public Trip findTripByIdAndUser(Principal principal,
			@PathVariable("id") int tripId,
			HttpServletResponse res) {
			Trip trip = tripServ.findTripById(tripId, principal.getName());
			try {
				if (trip != null) {
					res.setStatus(200);
					return trip;
				} 
			} catch (Exception e) {
				res.setStatus(404);
				e.printStackTrace();
			}
		
			return null;
	
	}
	
	
	@PostMapping("trips")
	public Trip addTrip(@RequestBody Trip trip,
			HttpServletResponse res,
			Principal principal,
			HttpServletRequest req) {
		Trip newTrip = tripServ.addTrip(trip, principal.getName());
		try {
			if(newTrip !=null) {
				res.setStatus(201);
				StringBuffer url = req.getRequestURL();
				url.append("/").append(trip.getId());
				res.setHeader("Location", url.toString());
				
				return newTrip;
			}
		} catch (Exception e) {
			res.setStatus(404);
			e.printStackTrace();
		}
	
		
		return null;
	}
	
	
	@PutMapping("trips/{id}")
	public Trip updateTrip(@RequestBody Trip trip,
			@PathVariable("id") int tripId,
			HttpServletResponse res,
			Principal principal,
			HttpServletRequest req) {
		
		Trip updatedTrip = tripServ.updateTrip(tripId, trip, principal.getName());
		
		try {
			if(updatedTrip !=null) {
				res.setStatus(205);
				return updatedTrip;
			}
		} catch (Exception e) {
			
			res.setStatus(404);
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
//	@PutMapping("users/trips/disable/{id}")
//	public Trip disableTrip(@RequestBody Trip trip,
//			@PathVariable("id") int tripId,
//			HttpServletResponse res,
//			Principal principal,
//			HttpServletRequest req) {
//		System.out.println("this is the trip: " + trip);
//		System.out.println("this is the user: " + principal);
//	Trip disableTrip = tripServ.disableTrip(tripId, trip, principal.getName());
//	
//	System.out.println("disabled Trip: "+disableTrip);
//		try {
//			if(disableTrip !=null) { 
//				res.setStatus(205);
//				return disableTrip;
//			}
//		} catch (Exception e) {
//			
//			res.setStatus(404);
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
	
	
	
	

}
