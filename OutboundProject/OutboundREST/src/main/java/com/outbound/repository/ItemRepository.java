package com.outbound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.outbound.entities.inventory.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	
	Item findByUser_UsernameAndId(String username, int itemId);
	
	List<Item> findByBrandLikeOrModelNameLike(@Param("k") String keyword1, @Param("k") String keyword2);
	
	
	
	
}
