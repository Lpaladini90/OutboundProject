package com.outbound.service;

import java.util.List;

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
			
			if(user != null) {
				
				
			}
			
			
			return itemRepo.findAll();
		}

		@Override
		public Item findUserItemById(String username, int itemId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Item addItem(String username, Item item) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Item updateItem(String username, Item item, int itemId) {
			// TODO Auto-generated method stub
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
