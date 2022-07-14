package com.outbound.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.User;
import com.outbound.entities.inventory.Item;
import com.outbound.repository.ItemRepository;
import com.outbound.repository.UserRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Item> indexAllItems(String username) {
		User user = userRepo.findByUsername(username);

		if (user != null) {

			return itemRepo.findAll();

		}
		return null;

	}

	@Override
	public Item findUserItemById(String username, int itemId) {
		User user = userRepo.findByUsername(username);

		if (user != null) {

			Optional<Item> itemOP = itemRepo.findById(itemId);

			if (itemOP.isPresent()) {
				Item item = itemOP.get();
				if (item != null) {
					return item;
				}

			}

		}
		return null;

	}

	@Override
	public Item addItem(String username, Item item) {
		User user = userRepo.findByUsername(username);

		item.setUser(user);

		return itemRepo.saveAndFlush(item);
	}

	@Override
	public Item updateItem(String username, Item item, int itemId) {
		User user = userRepo.findByUsername(username);

		Item managed = itemRepo.findByUser_UsernameAndId(username, itemId);
		if (managed != null) {

			managed.setUser(user);
			managed.setBrand(item.getBrand());
			managed.setModelName(item.getModelName());
			managed.setDescription(item.getDescription());
			managed.setWeight(item.getWeight());
			managed.setCategory(item.getCategory());

			itemRepo.saveAndFlush(managed);
			return managed;

		}

		return null;
	}

	@Override
	public Item disableItem(String username, Item item, int itemId) {
		User user = userRepo.findByUsername(username);
		if (user != null) {

			Optional<Item> itemOp = itemRepo.findById(itemId);

			if (itemOp.isPresent()) {
				Item managed = itemOp.get();

				if (managed != null && managed.getUser().getUsername().equals(username)) {

					managed.setActive(false);
					itemRepo.saveAndFlush(managed);
					return managed;

				}

			}

		}

		return null;

	}

	@Override
	public List<Item> findByCategory(String username, String keyword) {
		
		
		User user = userRepo.findByUsername(username);

		return null;
	}

	@Override
	public List<Item> findItemsByKeyword(String keyword, String username) {
		User user = userRepo.findByUsername(username);
		String search = "%" + keyword + "%";
		if(user != null) {
		
			
			List<Item> items = new ArrayList<>();
			
			items = itemRepo.findByBrandLikeOrModelNameLike(search, search);
			
			return items;
			
		}
		
		
		
		return null;
	}
}
