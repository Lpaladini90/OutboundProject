package com.outbound.entities.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.outbound.entities.GearList;
import com.outbound.entities.User;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String brand;

	@Column(name = "model_name")
	private String modelName;

	private String description;

	private double weight;

	private boolean active;
//	------------------------ RELATIONSHIP FIELDS -----------------

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "item_category_id")
	private ItemCategory category;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@JsonIgnore
	@ManyToMany(mappedBy = "items")
	private List<GearList> gearLists;

//	------------- CONSTRUCTORS -----------------
	public Item() {
		super();
	}

//	------------- RELATIONAL MAPPING -----------------

	public ItemCategory getCategory() {
		return category;
	}

	public void setCategory(ItemCategory category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<GearList> getGearLists() {
		return gearLists;
	}

	public void setGearLists(List<GearList> gearLists) {
		this.gearLists = gearLists;
	}

	public void addGearList(GearList list) {
		if (gearLists == null) {
			gearLists = new ArrayList<>();
			if (!gearLists.contains(list)) {
				gearLists.add(list);
				list.addItems(this);
			}
		}
	}

	public void removeGearList(GearList list) {

		if(gearLists != null && gearLists.contains(list)) {
			gearLists.remove(list);
			list.removeItems(this);
		}
	}

//	------------- GETTERS / SETTERS -----------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

//	------------- TO STRING -----------------

	@Override
	public String toString() {
		return "Item [id=" + id + ", brand=" + brand + ", modelName=" + modelName + ", description=" + description
				+ ", weight=" + weight + ", active=" + active + ", category=" + category + "]";
	}

//	------------- HASHCODE & EQUALS -----------------

	@Override
	public int hashCode() {
		return Objects.hash(active, brand, category, description, id, modelName, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return active == other.active && Objects.equals(brand, other.brand) && Objects.equals(category, other.category)
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(modelName, other.modelName)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

}
