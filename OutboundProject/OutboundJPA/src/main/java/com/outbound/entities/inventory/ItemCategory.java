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

@Entity
@Table(name = "item_category")
public class ItemCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "type_name")
	private String typeName;

//	------------------------ RELATIONSHIP FIELDS -----------------

	@OneToMany(mappedBy = "category")
	private List<Item> items;

	
	@OneToMany(mappedBy="category")
	private List<WeaponType> weaponTypes;
	
	
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

//	------------- GETTERS / SETTERS -----------------


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGearType() {
		return typeName;
	}

	public void setGearType(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	// ------------- TO STRING -----------------
	@Override
	public String toString() {
		return "ItemCategory [id=" + id + ", gearType=" + typeName + "]";
	}

//	------------- HASHCODE & EQUALS -----------------

	@Override
	public int hashCode() {
		return Objects.hash(typeName, id);
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
		return Objects.equals(typeName, other.typeName) && Objects.equals(id, other.id);
	}

}
