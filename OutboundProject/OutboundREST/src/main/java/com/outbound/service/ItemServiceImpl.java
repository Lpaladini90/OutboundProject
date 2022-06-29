package com.outbound.service;

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
			
			if(itemOP.isPresent()) {
				Item item = itemOP.get();
				if(item!=null) {
					return item;
				}
				
			}

		}
		return null;
		
	}

	@Override
	public Item addItem(String username, Item item) {
		User user = userRepo.findByUsername(username);

		if (user != null) {
			Item newItem = item;
			newItem.setUser(user);
			return newItem;
			
			
			
		}
		
		return null;
	}

	@Override
	public Item updateItem(String username, Item item, int itemId) {
		User user = userRepo.findByUsername(username);
		
		Item managed = itemRepo.findByUser_UsernameAndId(username, itemId);
		if(managed != null) {
			
			managed.setUser(user);
			managed.setBrand(item.getBrand());
			managed.setModelName(item.getModelName());
			managed.setDescription(item.getDescription());
			managed.setWeight(item.getWeight());
			
			
			managed.setCategory(item.getCategory());
			
		}
		
		
		return null;
	}

	@Override
	public boolean deleteItem(String username, int itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> findByCategory(String username, int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
