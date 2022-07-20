package com.outbound.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outbound.entities.inventory.Item;
import com.outbound.entities.inventory.ItemCategory;
import com.outbound.entities.inventory.WeaponType;
import com.outbound.service.ItemCategoryService;
import com.outbound.service.ItemService;
import com.outbound.service.WeaponTypeService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:8096" })
public class ItemController {

	@Autowired
	private ItemService itemServ;

	@Autowired
	private ItemCategoryService itemCatServ;

	@Autowired
	private WeaponTypeService weaponServ;

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
	public List<Item> searchByCategory(@PathVariable("catId") int catId, Principal principal, HttpServletResponse res) {
		return itemServ.findByCatId(principal.getName(), catId);

	}

	@GetMapping("items/categorysearch/{typeName}")
	public List<Item> findByCatName(@PathVariable("typeName") String typeName, Principal principal,
			HttpServletResponse res) {
		return itemServ.findByCategoryName(principal.getName(), typeName);
	}

//	------------------------------------------------------------------------------------------------------------

//	Item Category Methods Below 

	@GetMapping("itemcategories")
	public List<ItemCategory> indexAllCategories(Principal principal, HttpServletResponse res) {

		return itemCatServ.indexAllItemCategories(principal.getName());

	}

	@GetMapping("itemcategories/{itemCatId}")
	public ItemCategory findByCatById(@PathVariable("itemCatId") int itemCatId, Principal principal,
			HttpServletResponse res) {

		return itemCatServ.findById(principal.getName(), itemCatId);
	}

	@PostMapping("itemcategories")
	public ItemCategory createCategory(@RequestBody ItemCategory itemCat, Principal principal,
			HttpServletResponse res) {

		return itemCatServ.createCategory(principal.getName(), itemCat);
	}

	@PutMapping("itemcategories/{itemCatId}")
	public ItemCategory updateCategory(@PathVariable("itemCatId") int itemCatId, @RequestBody ItemCategory itemCat,
			Principal principal, HttpServletResponse res) {

		return itemCatServ.updateCategory(principal.getName(), itemCatId, itemCat);
	}

	@PutMapping("itemcategories/disable/{itemCatId}")
	public ItemCategory disableCategory(@PathVariable("itemCatId") int itemCatId, @RequestBody ItemCategory itemCat,
			Principal principal, HttpServletResponse res) {

		return itemCatServ.disableCategory(principal.getName(), itemCatId, itemCat);
	}

	@DeleteMapping("itemcategories/{itemCatId}")
	public void deleteCategory(@PathVariable("itemCatId") int itemCatId, Principal principal, HttpServletResponse res) {

		itemCatServ.deleteCategory(principal.getName(), itemCatId);

	}

//	------------- Weapon Type Methods Below ----------------------------------------------------------------------

	@GetMapping("weapontypes")
	public List<WeaponType> indexAllTypes(Principal principal, HttpServletResponse res) {

		return weaponServ.indexAllWeaponTypes(principal.getName());
	}

	@GetMapping("weapontypes/{id}")
	public WeaponType findByWeaponId(@PathVariable("id") int weaponTypeId, Principal principal,
			HttpServletResponse res) {

		return weaponServ.findById(principal.getName(), weaponTypeId);

	}

	@PostMapping("weapontypes")
	public WeaponType createWeaponType(@RequestBody WeaponType weaponType, Principal principal,
			HttpServletResponse res) {

		return weaponServ.createWeaponType(principal.getName(), weaponType);

	}

	@PutMapping("weapontypes/{id}")
	public WeaponType updateWeaponType(@PathVariable("id") int weaponTypeId, @RequestBody WeaponType weaponType,
			Principal principal, HttpServletResponse res) {

		return weaponServ.updateWeaponType(principal.getName(), weaponTypeId, weaponType);

	}

	@PutMapping("weapontypes/disable/{id}")
	public WeaponType disableWeaponType(@PathVariable("id") int weaponTypeId, @RequestBody WeaponType weaponType,
			Principal principal, HttpServletResponse res) {

		return weaponServ.disableWeaponType(principal.getName(), weaponTypeId, weaponType);

	}
	
	@DeleteMapping("weapontypes/{id}")
	public void deleteWeaponType(@PathVariable("id")int weaponTypeId, Principal principal, HttpServletResponse res) {
		
			weaponServ.deleteWeaponType(principal.getName(), weaponTypeId);
		
	}
	
	@GetMapping("weapontypes/search/{keyword}")
	public List<WeaponType> searchWeaponTypes(@PathVariable("keyword") String keyword, Principal principal, HttpServletResponse res) {
		
		return weaponServ.findByTypeName(principal.getName(), keyword);
	}
	

}
