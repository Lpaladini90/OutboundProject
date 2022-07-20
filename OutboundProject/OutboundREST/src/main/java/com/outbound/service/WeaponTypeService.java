package com.outbound.service;

import java.util.List;

import com.outbound.entities.inventory.WeaponType;

public interface WeaponTypeService {

	
	 List<WeaponType> indexAllWeaponTypes(String username);
		
	 WeaponType findById(String username, int weaponTypeId);
	  
	 WeaponType  createWeaponType(String username, WeaponType weaponType);
	 
	 WeaponType updateWeaponType(String username, int weaponTypeId, WeaponType weaponType);
	 
	 WeaponType disableWeaponType(String username, int weaponTypeId, WeaponType weaponType);
	 
	
	 
	 List<WeaponType> findByTypeName(String username, String keyword);

	boolean deleteWeaponType(String username, int weaponTypeId);
	
}
