package com.outbound.entities;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.outbound.entities.inventory.Item;

@Entity
@Table(name = "gear_list")
public class GearList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String description;

	private boolean active;
	
	@Column(name="image_url")
	private String imageUrl;
	
	private double totalWeight;

//	------------------------ RELATIONSHIP FIELDS -----------------

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany
	@JoinTable(name = "gear_list_has_item", 
	joinColumns = @JoinColumn(name = "gear_list_id"), 
	inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items;

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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void addItems(Item item) {
		if (items == null) {
			items = new ArrayList<>();
			if (!items.contains(item)) {
				items.add(item);
				item.addGearList(this);
			}

		}
		
		else {
			if(!items.contains(item)) {
				items.add(item);
				item.addGearList(this);
			}
			
		}

	}

	public void removeItems(Item item) {
		if(items != null && items.contains(item)) {
			items.remove(item);
			item.removeGearList(this);
		}
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

//	------------- TO STRING -----------------

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	@Override
	public String toString() {
		return "GearList [id=" + id + ", title=" + title + ", description=" + description + ", active=" + active
				+ ", user=" + user + "]";
	}

//	------------- HASHCODE & EQUALS -----------------

	@Override
	public int hashCode() {
		return Objects.hash(active, description, id, title, user);
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
		return active == other.active && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(title, other.title) && Objects.equals(user, other.user);
	}

}
