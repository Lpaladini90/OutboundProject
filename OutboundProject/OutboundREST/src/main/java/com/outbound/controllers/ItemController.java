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

import com.outbound.entities.inventory.Item;
import com.outbound.entities.inventory.ItemCategory;
import com.outbound.service.ItemCategoryService;
import com.outbound.service.ItemService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:8096" })
public class ItemController {

	@Autowired
	private ItemService itemServ;
	
	@Autowired
	private ItemCategoryService itemCatServ;

	@GetMapping("items")
	public List<Item> indexAllItems(Principal principal, HttpServletResponse res) {

		return itemServ.indexAllItems(principal.getName());

	}

	@GetMapping("items/{itemId}")
	public Item findById(@PathVariable("itemId") int itemId, Principal principal, HttpServletResponse res) {

		return itemServ.findUserItemById(principal.getName(), itemId);
	}

	@PostMapping("items")
	public Item createItem(@RequestBody Item item, Principal principal, HttpServletResponse res) {

		return itemServ.addItem(principal.getName(), item);

	}

	@PutMapping("items/{itemId}")
	public Item updateItem(@RequestBody Item item, @PathVariable("itemId") int itemId, Principal principal,
			HttpServletResponse res) {

		return itemServ.updateItem(principal.getName(), item, itemId);
	}

	@PutMapping("items/disable/{itemId}")
	public Item disableItem(@RequestBody Item item, @PathVariable("itemId") int itemId, Principal principal,
			HttpServletResponse res) {

		Item disableItem = itemServ.disableItem(principal.getName(), item, itemId);

		return disableItem;
	}

	@GetMapping("items/search/{keyword}")
	public List<Item> findByKeyword(@PathVariable("keyword") String keyword, Principal principal,
			HttpServletResponse res) {

		return itemServ.findItemsByKeyword(keyword, principal.getName());

	}

	@GetMapping("items/category/{catId}")
	public List<Item> searchByCategory(@PathVariable("catId") int catId, Principal principal,
			HttpServletResponse res) {
		return itemServ.findByCatId(principal.getName(), catId);
				 

	}
	
	@GetMapping("items/categorysearch/{typeName}")
	public List<Item> findByCatName(@PathVariable("typeName")String typeName,
			Principal principal, 
			HttpServletResponse res){
		return itemServ.findByCategoryName(principal.getName(), typeName);
	}

	
//	------------------------------------------------------------------------------------------------------------
	
	
//	Item Category Methods Below 
	
	
	
	@GetMapping("itemcategories")
	public List<ItemCategory> indexAllCategories(Principal principal, HttpServletResponse res){
		
		return itemCatServ.indexAllItemCategories(principal.getName());
		
	}
	
	
	
	
	
	
	
	
}
