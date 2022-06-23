package com.outbound.service;

import java.util.List;

import com.outbound.entities.GearList;
import com.outbound.entities.inventory.Item;

public interface GearListService {

	List<GearList> indexByUser(String username);
	
	GearList findById(String username, int listId);
	
	GearList createList(String username, GearList list);
	
	GearList updateList(String username, GearList list, int listId);
	
	GearList disableList(String username, GearList list, int listId);
	
	GearList addItemToGearList(String username, int gearListId, int itemId);
	
	List<GearList> findGearListsByKeyword(String keyword, String username);
	
	
}
