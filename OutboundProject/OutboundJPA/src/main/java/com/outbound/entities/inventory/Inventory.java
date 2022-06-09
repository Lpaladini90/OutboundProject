package com.outbound.entities.inventory;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.outbound.entities.GearList;
import com.outbound.entities.User;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	------------------------ RELATIONSHIP FIELDS -----------------

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "inventory")
	private List<Item> items;

//	------------- CONSTRUCTORS -----------------

	public Inventory() {
		super();
	}

//	------------- RELATIONAL MAPPING -----------------

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	------------- GETTERS / SETTERS -----------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	------------- TO STRING -----------------

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", user=" + user + ", items=" + items + "]";
	}

//	------------- HASHCODE & EQUALS -----------------

	@Override
	public int hashCode() {
		return Objects.hash(id, items, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return Objects.equals(id, other.id) && Objects.equals(items, other.items) && Objects.equals(user, other.user);
	}

}
