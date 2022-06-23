package com.outbound.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outbound.entities.GearList;
import com.outbound.service.GearListService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:8096" })
public class GearListController {

	
	@Autowired
	private GearListService listServ;
	
	
	@GetMapping("gearlists")
	public List<GearList> indexAllUserLists(Principal principal, HttpServletResponse res){
		 
		return listServ.indexByUser(principal.getName());
	}
	
	@GetMapping("gearlists/{listId}")
	public GearList findById(Principal principal, @PathVariable("listId") int listId) {
		
		return listServ.findById(principal.getName(), listId);
	}
	 
	
	
}
