package com.outbound.service.inventory;

import java.util.List;

import com.outbound.entities.inventory.ItemCategory;

public interface ItemCategoryService {

	
	 List<ItemCategory> indexAllItemCategories(String username);
	
	 ItemCategory findById(String username, int itemCatId);
	 
	 ItemCategory createCategory(String username, ItemCategory itemCat);
	 
	 ItemCategory updateCategory(String username, int itemCatId, ItemCategory itemCat);
	 
	 ItemCategory disableCategory(String username, int itemCatId, ItemCategory itemCat);
	 
	 List<ItemCategory> findByType(String username, String keyword);

	 boolean deleteCategory(String username, int itemCatId);
	 
	 
	
	
	
	
}
