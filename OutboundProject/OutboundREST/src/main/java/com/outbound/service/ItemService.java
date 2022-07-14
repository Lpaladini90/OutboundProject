package com.outbound.service;

import java.util.List;

import com.outbound.entities.inventory.Item;

public interface ItemService {

	List<Item> indexAllItems(String username);
	
	Item findUserItemById(String username,int itemId);
	
	Item addItem(String username, Item item);
	
	Item updateItem(String username, Item item, int itemId);
	
	Item disableItem(String username, int itemId);
	
	List<Item> findByCategory(String username, String keyword);
	
	List<Item> findItemsByKeyword(String keyword, String username);
	
	
	
}
