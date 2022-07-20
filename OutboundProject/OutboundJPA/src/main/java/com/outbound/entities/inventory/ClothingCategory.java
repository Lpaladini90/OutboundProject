package com.outbound.entities.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

@Entity
@Table(name="clothing_category")
public class ClothingCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String type;
	
	private boolean active;
	
//	------------------------ RELATIONSHIP FIELDS -----------------

	
	@ManyToOne
	@JoinColumn(name="item_category_id")
	private ItemCategory category;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "clothing_category_has_clothing_layer",
	joinColumns = @JoinColumn(name= "clothing_category_id"),
	inverseJoinColumns =  @JoinColumn(name="clothing_layer_id"))
	private List<ClothingLayer> layers;
	
//	------------- CONSTRUCTORS -----------------

	
	
	public ClothingCategory() {
		super();
	}
	
	
	public void addLayer(ClothingLayer layer) {
		if(layers == null) {
			layers = new ArrayList<>();
			if(!layers.contains(layer)) {
				layers.add(layer);
				layer.addCategory(this);
			}
		}
		else {
			if(!layers.contains(layer)) {
				layers.add(layer);
				layer.addCategory(this);
			}
		}
		
	}
	
	public void removeLayer(ClothingLayer layer) {
		if(layers != null && layers.contains(layer)) {
			layers.remove(layer);
			layer.removeCategory(this);
		}
	}
	
	
//	------------------------ RELATIONAL MAPPING -----------------

	public ItemCategory getCategory() {
		return category;
	}

	public void setCategory(ItemCategory category) {
		this.category = category;
	}

	public List<ClothingLayer> getLayers() {
		return layers;
	}

	public void setLayers(List<ClothingLayer> layers) {
		this.layers = layers;
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
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
//	------------- TO STRING -----------------

	@Override
	public String toString() {
		return "ClothingCategory [id=" + id + ", type=" + type + "]";
	}
	
//	------------- HASHCODE & EQUALS -----------------


	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClothingCategory other = (ClothingCategory) obj;
		return Objects.equals(id, other.id) && Objects.equals(type, other.type);
	}
	
	
	
}
