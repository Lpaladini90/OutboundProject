package com.outbound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.GearList;
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
		
		
		
		
		if(listOp.isPresent()) {
			GearList list = listOp.get();
			if(list.getUser().getUsername().equals(username)) {
				
					return list;
			}
		}
		return null;
	}

	@Override
	public GearList createList(String username, GearList list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GearList updateList(String username, GearList list, int listId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GearList disableList(String username, GearList list, int listId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
