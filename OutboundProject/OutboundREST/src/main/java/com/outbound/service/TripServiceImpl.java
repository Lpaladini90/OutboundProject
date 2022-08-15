package com.outbound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.Trip;
import com.outbound.entities.User;
import com.outbound.repository.TripRepository;
import com.outbound.repository.UserRepository;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository tripRepo;

	
	@Autowired
	private UserRepository userRepo;

	
	@Override
	public List<Trip> indexAll(String username) {
		return tripRepo.findByUser_Username(username);
	}

	
	@Override
	public Trip findTripById(int tripId, String username) {
		User user = userRepo.findByUsername(username);

		if (user != null) {
			Optional<Trip> op = tripRepo.findById(tripId);

			if (op.isPresent()) {
				Trip trip = op.get();

				if (trip.getUser().getUsername().equals(username)) {
					return trip;

				}
			}
		}
		return null;
	}

	@Override
	public Trip addTrip(Trip trip, String username) {
		User user = userRepo.findByUsername(username);
		trip.setUser(user);

		return tripRepo.saveAndFlush(trip);
	}

	@Override
	public Trip updateTrip(int tripId, Trip trip, String username) {

		User user = userRepo.findByUsername(username);

		if (user != null) {
			Trip managedTrip = tripRepo.findByUser_UsernameAndId(username, tripId);

			if (managedTrip != null) {
				managedTrip.setName(trip.getName());
				managedTrip.setDescription(trip.getDescription());
				managedTrip.setEndDate(trip.getEndDate());
				managedTrip.setStartDate(trip.getStartDate());
				managedTrip.setEnabled(trip.isEnabled());
				managedTrip.setSuccess(trip.isSuccess());
				managedTrip.setImageUrl(trip.getImageUrl());
				
				tripRepo.saveAndFlush(managedTrip);

			}
			return managedTrip;
		}
		return null;
	}

//	@Override
//	public Trip disableTrip(int tripId, Trip trip, String username) {
//
//		User user = userRepo.findByUsername(username);
//
//		if (user != null) {
//			Trip disabledTrip = tripRepo.findByUser_UsernameAndId(username, tripId);
//
//			if (disabledTrip != null && disabledTrip.getId() == tripId) {
//				disabledTrip.setName(trip.getName());
//				disabledTrip.setEnabled(false);
//				tripRepo.saveAndFlush(disabledTrip);
//
//			}
//			return disabledTrip;
//		}
//
//		return null;
//	}

	@Override
	public List<Trip> listBySuccess(boolean success, String username) {
		return null;
	}

	@Override
	public List<Trip> listTripByKeywordOrDescription(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
