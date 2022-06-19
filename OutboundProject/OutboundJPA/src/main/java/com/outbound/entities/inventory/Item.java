package com.outbound.entities.inventory;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String brand;
	
	@Column(name="model_name")
	private String modelName;
	
	private String description;
	
	private double weight;
	
	private boolean active;
//	------------------------ RELATIONSHIP FIELDS -----------------

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="inventory_id")
	private Inventory inventory;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="item_category_id")
	private ItemCategory category;

	
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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
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

	
	

//	------------- TO STRING -----------------

	
	@Override
	public String toString() {
		return "Item [id=" + id + ", brand=" + brand + ", modelName=" + modelName + ", description=" + description
				+ ", weight=" + weight + ", active=" + active + ", inventory=" + inventory + ", category=" + category
				+ "]";
	}

//	------------- HASHCODE & EQUALS -----------------

	@Override
	public int hashCode() {
		return Objects.hash(brand, description, id, inventory, modelName, weight);
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
		return Objects.equals(brand, other.brand) && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(inventory, other.inventory) && Objects.equals(modelName, other.modelName)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}
	
	
	
	
}
