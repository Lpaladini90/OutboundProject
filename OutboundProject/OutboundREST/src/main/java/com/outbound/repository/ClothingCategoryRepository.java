package com.outbound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.outbound.entities.inventory.ClothingCategory;

public interface ClothingCategoryRepository extends JpaRepository<ClothingCategory, Integer> {

	
	List<ClothingCategory> findByTypeLike(String username, String keyword);
}
