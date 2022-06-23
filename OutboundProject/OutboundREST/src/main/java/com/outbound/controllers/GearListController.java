package com.outbound.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outbound.entities.GearList;
import com.outbound.entities.inventory.Item;
import com.outbound.service.GearListService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:8096" })
public class GearListController {

	@Autowired
	private GearListService listServ;

	@GetMapping("gearlists")
	public List<GearList> indexAllUserLists(Principal principal, HttpServletResponse res) {

		return listServ.indexByUser(principal.getName());
	}

	@GetMapping("gearlists/{listId}")
	public GearList findById(Principal principal, @PathVariable("listId") int listId) {

		return listServ.findById(principal.getName(), listId);
	}
	
	
	@GetMapping("gearlists/search/{keyword}")
	public List<GearList> findByKeyword(@PathVariable("keyword") String keyword, Principal principal, HttpServletResponse res){
		
		return listServ.findGearListsByKeyword(keyword,principal.getName());
	}
	
	

	@PostMapping("gearlists")
	public GearList createList(@RequestBody GearList list, HttpServletResponse res, Principal principal) {

		GearList newGearList = listServ.createList(principal.getName(), list);

		try {
			if (newGearList != null) {
				res.setStatus(201);
				return newGearList;
			}
		} catch (Exception e) {
			res.setStatus(404);
			e.printStackTrace();
		}

		return null;
	}

	@PutMapping("gearlists/{gearListId}/item/{itemId}")
	public GearList addItemToGearList(@PathVariable("gearListId") int gearListId,
			@PathVariable("itemId") int itemId,
			HttpServletResponse res, 
			Principal principal) {

		GearList gearList = listServ.addItemToGearList(principal.getName(), 
				gearListId, itemId);

		try {
			if (gearList != null) {

				res.setStatus(201);
				return gearList;

			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
		}

		return null;

	}

	
	@PutMapping("gearlists/{gearListId}")
	public GearList updateGearList(@PathVariable("gearListId") int listId,
			@RequestBody GearList list,
			HttpServletResponse res,
			Principal principal) {
		
		GearList gearList = listServ.updateList(principal.getName(), list, listId);
		try {
			if (gearList != null) {
				res.setStatus(201);
				return gearList;

			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
		}
		
		return null;
	}
	
	@PutMapping("gearlists/disable/{gearListId}")
	public GearList disableGearList(@PathVariable("gearListId") int listId,
			@RequestBody GearList list,
			HttpServletResponse res,
			Principal principal) {
		
		GearList gearList = listServ.disableList(principal.getName(), list, listId);
		try {
			if (gearList != null) {
				res.setStatus(201);
				return gearList;

			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
		}
		
		return null;
	}
	
	
	
	
	
}
