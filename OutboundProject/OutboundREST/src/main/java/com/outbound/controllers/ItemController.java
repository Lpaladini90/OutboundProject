package com.outbound.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outbound.entities.inventory.Item;
import com.outbound.service.ItemService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:8096" })
public class ItemController {

	
	@Autowired
	private ItemService itemServ;
	
	
	@GetMapping("items")
	public List<Item> indexAllItems(Principal principal, HttpServletResponse res){
		
		
		return itemServ.indexAllItems(principal.getName());
		
	}
	
	@GetMapping("items/{itemId}")
	public Item findById(@PathVariable("itemId")int itemId,
			Principal principal,
			HttpServletResponse res) {
		
		return itemServ.findUserItemById(principal.getName(), itemId);
	}
	
	@PostMapping("items")
	public Item createItem(@RequestBody Item item  ,Principal principal,
			HttpServletResponse res) {
		
		
		return itemServ.addItem(principal.getName(), item);
		
	}
	
	
	
}
