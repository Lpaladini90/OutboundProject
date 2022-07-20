package com.outbound.entities.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="clothing_layer")
public class ClothingLayer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String type;
	
	private String description;
	
	private boolean active;
	
//	------------------------ RELATIONSHIP FIELDS -----------------
	@JsonIgnore
	@ManyToMany(mappedBy="layers")
	private List<ClothingCategory> categories;

//	------------------------ CONSTRUCTORS -----------------
	public ClothingLayer() {
		super();

	}
	
	public void addCategory(ClothingCategory cat) {
		if(categories == null) {
			categories = new ArrayList<>();
			if(!categories.contains(cat)) {
				categories.add(cat);
				cat.addLayer(this);
			}
			
		}
		else {
			if(!categories.contains(cat)) {
				categories.add(cat);
				cat.addLayer(this);
			}
		}
		
		
	}
	
	public void removeCategory(ClothingCategory cat) {
		if(categories != null && categories.contains(cat)) {
			categories.remove(cat);
			cat.removeLayer(this);
		}
		
		
	}
	

//	------------------------ RELATIONAL MAPPING -----------------

	public List<ClothingCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ClothingCategory> categories) {
		this.categories = categories;
	}
	
	
//	------------- GETTERS / SETTERS -----------------

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return "ClothingLayer [id=" + id + ", type=" + type + ", description=" + description + "]";
	}
//	------------- HASHCODE & EQUALS -----------------

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
		ClothingLayer other = (ClothingLayer) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(type, other.type);
	}
	
	
	
}
