package com.outbound.service.inventory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.User;
import com.outbound.entities.inventory.ClothingCategory;
import com.outbound.repository.ClothingCategoryRepository;
import com.outbound.service.AuthService;

@Service
public class ClothingCategoryServiceImpl implements ClothingCategoryService {

	@Autowired
	private ClothingCategoryRepository catRepo;

	@Autowired
	AuthService authServ;

	@Override
	public List<ClothingCategory> indexAllItemCategories(String username) {
		User user = authServ.getUserByUsername(username);

		if (user != null) {
			
			List<ClothingCategory> categories = catRepo.findAll();
			return categories;
		}

		return null;
	}

	@Override
	public ClothingCategory findById(String username, int catId) {
		User user = authServ.getUserByUsername(username);

		if (user != null) {
			Optional<ClothingCategory> catOp = catRepo.findById(catId);

			if (catOp.isPresent()) {
				ClothingCategory cat = catOp.get();
				return cat;

			}

		}

		return null;
	}

	@Override
	public ClothingCategory createCategory(String username, ClothingCategory cat) {

		User user = authServ.getUserByUsername(username);

		if (user != null) {
			ClothingCategory newCat = catRepo.saveAndFlush(cat);
			return newCat;

		}
		return null;
	}

	@Override
	public ClothingCategory updateCategory(String username, int catId, ClothingCategory cat) {
		User user = authServ.getUserByUsername(username);

		if (user != null) {
			Optional<ClothingCategory> catOp = catRepo.findById(catId);

			if (catOp.isPresent()) {
				ClothingCategory managed = catOp.get();
				managed.setType(cat.getType());
				catRepo.saveAndFlush(managed);
				return managed;

			}

		}

		return null;
	}


	@Override
	public boolean deleteCategory(String username, int catId) {
		boolean deleted = false;
		User user = authServ.getUserByUsername(username);

		if (user != null) {
			Optional<ClothingCategory> catOp = catRepo.findById(catId);

			if (catOp.isPresent()) {
				ClothingCategory toBeDeleted = catOp.get();
					
				catRepo.delete(toBeDeleted);
				deleted = true;
				System.out.println("delete worked");
				return deleted;
			}
		}
		
		System.out.println("delete didnt work");
		return false;
	}

	@Override
	public List<ClothingCategory> findByType(String username, String keyword) {

		User user = authServ.getUserByUsername(username);

		if (user != null) {
		String search = "%" + keyword + "%";
		
		List<ClothingCategory> searchResults = catRepo.findByTypeLike(username, search);
		
		return searchResults;
		}
		
		
		return null;
	}
}
