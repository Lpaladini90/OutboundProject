package com.outbound.entities.inventory;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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
	
//	------------------------ RELATIONSHIP FIELDS -----------------

	
	@ManyToOne
	@JoinColumn(name="inventory_id")
	private Inventory inventory;
	

	
//	------------- CONSTRUCTORS -----------------
	public Item() {
		super();
	}
	
//	------------- RELATIONAL MAPPING -----------------
	

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

//	------------- RELATIONAL MAPPING GETTERS / SETTERS -----------------


	
@Override
	public String toString() {
		return "Item [id=" + id + ", brand=" + brand + ", modelName=" + modelName + ", description=" + description
				+ ", weight=" + weight + ", inventory=" + inventory + "]";
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
