package com.outbound.entities.inventory;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="weapon_type")
public class WeaponType {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String type;
	
	private String description;
	
	private boolean active;

//	------------------------ RELATIONSHIP FIELDS -----------------

	@ManyToOne
	@JoinColumn(name="item_category_id")
	private ItemCategory category; 
	
	
//	------------- CONSTRUCTORS -----------------

	
	public WeaponType() {
		super();
	}

//	------------- RELATIONAL MAPPING -----------------

	public ItemCategory getCategory() {
		return category;
	}
	
	public void setCategory(ItemCategory category) {
		this.category = category;
	}
	
//	------------- GETTERS / SETTERS -----------------

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return type;
	}

	public void setName(String name) {
		this.type = name;
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

	@Override
	public String toString() {
		return "WeaponType [id=" + id + ", name=" + type + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeaponType other = (WeaponType) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(type, other.type);
	}
	
	
	
	
}
