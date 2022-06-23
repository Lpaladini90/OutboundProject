
package com.outbound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.GearList;
import com.outbound.entities.User;
import com.outbound.entities.inventory.Item;
import com.outbound.repository.GearListRepository;
import com.outbound.repository.ItemRepository;
import com.outbound.repository.UserRepository;

@Service
public class GearListServiceImpl implements GearListService {

	@Autowired
	private GearListRepository gearRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ItemRepository itemRepo;

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
	public GearList addItemToGearList(String username, int gearListId, int itemId) {
		User user = userRepo.findByUsername(username);
		if (user != null) {
			System.out.println("gear list id: " + gearListId);
			GearList managed = gearRepo.findByUser_UsernameAndId(username, gearListId);
			System.out.println(managed.getId());
			if (managed != null && managed.getUser().getUsername().equals(username)) {

				Optional<Item> op = itemRepo.findById(itemId);
				System.out.println(itemId);

				if (op.isPresent()) {

					Item item = op.get();
					System.out.println("item is: " + item);

					managed.addItems(item);
					System.out.println(managed.getItems());
					gearRepo.saveAndFlush(managed);
					return managed;

				}
			}

		}

		return null;
	}

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
