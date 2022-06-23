package com.outbound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.outbound.entities.GearList;

public interface GearListRepository extends JpaRepository<GearList, Integer> {

	GearList findByTitleLikeOrDescriptionLike(@Param("k") String keyword1, @Param("k") String keyword2);
	
	List<GearList> findByUser_Username(String username);
	
	
}
