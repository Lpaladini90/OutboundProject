package com.outbound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outbound.entities.inventory.ItemCategory;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer> {
	
	List<ItemCategory> findByTypeLike( String keyword);
	

}
