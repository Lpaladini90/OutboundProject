package com.outbound.entities.inventory;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "item_category")
public class ItemCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "type_name")
	private String typeName;

	private boolean active;
//	------------------------ RELATIONSHIP FIELDS -----------------
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Item> items;

	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<WeaponType> weaponTypes;
	
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<ClothingCategory> clothingCategories;
	
	
//	------------- CONSTRUCTORS -----------------

	public ItemCategory() {
		super();
	}
	
//	------------- RELATIONAL MAPPING -----------------
	
	
	
	public List<WeaponType> getWeaponTypes() {
		return weaponTypes;
	}

	public void setWeaponTypes(List<WeaponType> weaponTypes) {
		this.weaponTypes = weaponTypes;
	}

	public List<Item> getItems() {
		return items;
	} 
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	public List<ClothingCategory> getClothingCategories() {
		return clothingCategories;
	}
	
	public void setClothingCategories(List<ClothingCategory> clothingCategories) {
		this.clothingCategories = clothingCategories;
	}
	

//	------------- GETTERS / SETTERS -----------------



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "ItemCategory [id=" + id + ", typeName=" + typeName + ", active=" + active + ", items=" + items
				+ ", weaponTypes=" + weaponTypes + ", clothingCategories=" + clothingCategories + "]";
	}

//	------------- HASHCODE & EQUALS -----------------

	@Override
	public int hashCode() {
		return Objects.hash(active, clothingCategories, id, items, typeName, weaponTypes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCategory other = (ItemCategory) obj;
		return active == other.active && Objects.equals(clothingCategories, other.clothingCategories) && id == other.id
				&& Objects.equals(items, other.items) && Objects.equals(typeName, other.typeName)
				&& Objects.equals(weaponTypes, other.weaponTypes);
	}

}
