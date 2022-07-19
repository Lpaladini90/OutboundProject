package com.outbound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.User;
import com.outbound.entities.inventory.ItemCategory;
import com.outbound.repository.ItemCategoryRepository;
import com.outbound.repository.UserRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

	@Autowired
	private ItemCategoryRepository itemCatRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<ItemCategory> indexAllItemCategories(String username) {
		User user = userRepo.findByUsername(username);

		if (user != null) {
			return itemCatRepo.findAll();

		}

		return null;
	}

	@Override
	public ItemCategory findById(String username, int itemCatId) {
		User user = userRepo.findByUsername(username);

		if (user != null) {
			Optional<ItemCategory> category = itemCatRepo.findById(itemCatId);
			if (category.isPresent()) {
				ItemCategory itemCat = category.get();
				return itemCat;

			}

		}

		return null;
	}

	@Override
	public ItemCategory createCategory(String username, ItemCategory itemCat) {
		User user = userRepo.findByUsername(username);

		if (user != null) {

			List<ItemCategory> cats = itemCatRepo.findAll();

			for (ItemCategory cat : cats) {

				if (cat.getTypeName().equals(itemCat.getTypeName())) {

					
					return null;

				}else {
					itemCatRepo.saveAndFlush(itemCat);
					return itemCat;
				}

			}

		}

		return null;
	}

	@Override
	public ItemCategory updateCategory(String username, int itemCatId, ItemCategory itemCat) {
		User user = userRepo.findByUsername(username);

		if (user != null) {
			
		}
		
		
		
		return null;
	}

	@Override
	public ItemCategory disableCategory(String username, int itemCatId, ItemCategory itemCat) {
		User user = userRepo.findByUsername(username);

		if (user != null) {	
		}return null;
		}
	}

	@Override
	public List<ItemCategory> findByType(String username, String keyword) {
		User user = userRepo.findByUsername(username);

		if (user != null) {
		}
		return null;
		}
	}

}
