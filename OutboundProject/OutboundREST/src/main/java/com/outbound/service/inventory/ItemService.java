package com.outbound.service.inventory;

import java.util.List;

import com.outbound.entities.inventory.Item;

public interface ItemService {

	List<Item> indexAllItems(String username);
	
	Item findUserItemById(String username,int itemId);
	
	Item addItem(String username, Item item);
	
	Item updateItem(String username, Item item, int itemId);
	
	Item disableItem(String username, Item item, int itemId);
	
	List<Item> findByCategoryName(String username, String typeName);
	
	List<Item> findItemsByKeyword(String keyword, String username);
	
	List<Item> findByCatId(String username, int catId);
	
}
