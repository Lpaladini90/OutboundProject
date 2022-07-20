package com.outbound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.outbound.entities.inventory.WeaponType;

public interface WeaponTypeRepository extends JpaRepository<WeaponType, Integer> {

	List<WeaponType> findByNameLikeOrDescriptionLike(@Param("k") String keyword1, @Param("k") String keyword2);
	
	
}
