
package com.outbound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.GearList;
import com.outbound.entities.User;
import com.outbound.entities.inventory.Item;
import com.outbound.repository.GearListRepository;
import com.outbound.repository.UserRepository;

@Service
public class GearListServiceImpl implements GearListService {

	@Autowired
	private GearListRepository gearRepo;

	@Autowired
	private UserRepository userRepo;

	

	@Override
	public List<GearList> indexByUser(String username) {

		return gearRepo.findByUser_Username(username);

	}

	@Override
	public GearList findById(String username, int listId) {
		Optional<GearList> listOp = gearRepo.findById(listId);

		if (listOp.isPresent()) {
			GearList list = listOp.get();
			if (list.getUser().getUsername().equals(username)) {

				return list;
			}
		}
		return null;
	}

	@Override
	public GearList createList(String username, GearList list) {
		User user = userRepo.findByUsername(username);
		if (user != null) {
			list.setUser(user);
			list = gearRepo.saveAndFlush(list);
			return list;
		}

		return null;
	}

	

	
	
	
	@Override
	public GearList addItemsToGearList(String username, int gearListId, List<Item> items) {
		User user = userRepo.findByUsername(username);
		if (user != null) {

			// Find the gear list that is going to be edited
			GearList managed = gearRepo.findByUser_UsernameAndId(username, gearListId);
			// if the list was created by the same person logged in then..
			if (managed != null && managed.getUser().getUsername().equals(username)) {

			List<Item> currentInventory = managed.getItems();
			
			for(Item item : items) {
				
				currentInventory.add(item);
			}
			managed.setItems(currentInventory);
			gearRepo.saveAndFlush(managed);
			return managed;

		}
	}
		return null;
	}
//	@Override
//	public GearList addItemsToGearList(String username, int gearListId, int itemId) {
//		User user = userRepo.findByUsername(username);
//		if (user != null) {
//			GearList managed = gearRepo.findByUser_UsernameAndId(username, gearListId);
//			if (managed != null && managed.getUser().getUsername().equals(username)) {
//				
//				Optional<Item> op = itemRepo.findById(itemId);
//				
//				if (op.isPresent()) {
//					
//					Item item = op.get();
//					
//					managed.addItems(item);
//					gearRepo.saveAndFlush(managed);
//					return managed;
//					
//				}
//			}
//			
//		}
//		
//		return null;
//	}

	@Override
	public GearList updateList(String username, GearList list, int listId) {
		User user = userRepo.findByUsername(username);

		if (user != null) {

			Optional<GearList> gearOP = gearRepo.findById(listId);
			if (gearOP.isPresent()) {
				GearList managed = gearOP.get();

				managed.setDescription(list.getDescription());
				managed.setTitle(list.getTitle());
				managed.setActive(list.isActive());

				gearRepo.saveAndFlush(managed);

				return managed;

			}

		}

		return null;
	}

	@Override
	public GearList disableList(String username, GearList list, int listId) {
		User user = userRepo.findByUsername(username);

		if (user != null) {

			Optional<GearList> gearOP = gearRepo.findById(listId);
			if (gearOP.isPresent()) {
				GearList managed = gearOP.get();
				managed.setActive(false);
				gearRepo.saveAndFlush(managed);
				return managed;
			}
		}
		return null;

	}

	@Override
	public List<GearList> findGearListsByKeyword(String keyword, String username) {
		keyword = "%" + keyword + "%";

		User user = userRepo.findByUsername(username);

		if (user != null) {

			return gearRepo.findByTitleLikeOrDescriptionLike(keyword, keyword);
		}

		return null;

	}

}
