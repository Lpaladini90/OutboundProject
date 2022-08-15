package com.outbound.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.outbound.entities.inventory.Item;



@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String username;

	private String password; 

	private String email;

	private String role;

	private String biography;
	
	private boolean enabled;
	
	@Column(name = "image_url")
	private String imageUrl;

//	------------------------ RELATIONSHIP FIELDS -----------------
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Trip> trips;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<GearList> lists;

	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Item> items;
	
//	------------------------ CONSTRUCTORS -----------------
 
	public User() {
		super();
	}

//	------------------------ RELATIONAL MAPPING -----------------

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
		
	}
	
	
	

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<GearList> getLists() {
		return lists;
	}

	public void setLists(List<GearList> lists) {
		this.lists = lists;
	}

//	------------------------ GETTERS/SETTERS -----------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
//	------------- TO STRING -----------------


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", role=" + role + ", biography=" + biography
				+ ", enabled=" + enabled + ", imageUrl=" + imageUrl + ", trips=" + trips + ", lists=" + lists + "]";
	}
	
//	------------- HASHCODE & EQUALS -----------------

	@Override
	public int hashCode() {
		return Objects.hash(biography, email, enabled, firstName, id, imageUrl, lastName, lists, password, role, trips,
				username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(biography, other.biography) && Objects.equals(email, other.email)
				&& enabled == other.enabled && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(lists, other.lists) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(trips, other.trips)
				&& Objects.equals(username, other.username);
	}

}
