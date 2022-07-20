package com.outbound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outbound.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {

	List<Trip> findByUser_Username(String username);
	
	Trip findByUser_UsernameAndId(String username, int tripId);
	
}
