package com.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outbound.entities.inventory.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	
	Item findByUser_UsernameAndId(String username, int itemId);
	
}
