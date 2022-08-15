package com.outbound.service.inventory;

import java.util.List;

import com.outbound.entities.inventory.ClothingCategory;

public interface ClothingCategoryService {
	
	 List<ClothingCategory> indexAllItemCategories(String username);
	
	 ClothingCategory findById(String username, int catId);
	 
	 ClothingCategory createCategory(String username, ClothingCategory cat);
	 
	 ClothingCategory updateCategory(String username, int catId, ClothingCategory cat);
	 
	 
	 List<ClothingCategory> findByType(String username, String keyword);

	 boolean deleteCategory(String username, int catId);
}
