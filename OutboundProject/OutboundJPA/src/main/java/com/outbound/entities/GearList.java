package com.outbound.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.outbound.entities.inventory.Inventory;

@Entity
@Table(name = "gear_list")
public class GearList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	private boolean active;

//	------------------------ RELATIONSHIP FIELDS -----------------

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;

//	------------- CONSTRUCTORS -----------------

	public GearList() {
	
	}

//	------------------------ RELATIONAL MAPPING -----------------

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "GearList [id=" + id + ", description=" + description + ", user=" + user + ", inventory=" + inventory
				+ "]";
	}

//	------------- HASHCODE & EQUALS -----------------

	@Override
	public int hashCode() {
		return Objects.hash(active, description, id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GearList other = (GearList) obj;
		return active == other.active && Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}

}
