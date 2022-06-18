package com.outbound.service;

import java.util.List;

import com.outbound.entities.Trip;

public interface TripService {

	public List<Trip> indexAll(String username);
	
	public Trip findTripById(int tripId, String username);
	
	public Trip addTrip(Trip trip, String username);
	
	public Trip updateTrip(int tripId, Trip trip, String username);
	
	public Trip disableTrip(int tripId, Trip trip, String username);

	public List<Trip> indexByUsername(String username);
	
	public List<Trip> listBySuccess(boolean success, String username); 
	
	public List<Trip> listTripByKeywordOrDescription(String keyword);
	
}
