package com.outbound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.Trip;
import com.outbound.repository.TripRepository;

@Service
public class TripServiceImpl implements TripService {

	
		@Autowired
		private TripRepository tripRepo;

		@Override
		public List<Trip> indexAll() {
			return tripRepo.findAll();
		}
		
		
	
	
}
