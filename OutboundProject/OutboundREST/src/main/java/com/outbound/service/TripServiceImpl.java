package com.outbound.service;

import java.util.List;

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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Trip addTrip(Trip trip, String username) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Trip updateTrip(int tripId, Trip trip, String username) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Trip disableTrip(int tripId, Trip trip, String username) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Trip> indexByUsername(String username) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Trip> listBySuccess(boolean success, String username) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Trip> listTripByKeywordOrDescription(String keyword) {
			// TODO Auto-generated method stub
			return null;
		}

	
	
}
