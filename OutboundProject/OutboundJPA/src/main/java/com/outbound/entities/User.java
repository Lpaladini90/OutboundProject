package com.outbound.entities;

import java.util.List;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.outbound.entities.inventory.Inventory;


//mysql> desc user;
//+-------------+---------------+------+-----+---------+----------------+
//| Field       | Type          | Null | Key | Default | Extra          |
//+-------------+---------------+------+-----+---------+----------------+
//| id          | int(11)       | NO   | PRI | NULL    | auto_increment |
//| username    | varchar(45)   | NO   | UNI | NULL    |                |
//| password    | varchar(2000) | NO   |     | NULL    |                |
//| first_name  | varchar(45)   | YES  |     | NULL    |                |
//| last_name   | varchar(45)   | YES  |     | NULL    |                |
//| email       | varchar(200)  | YES  |     | NULL    |                |
//| role        | varchar(45)   | YES  |     | NULL    |                |
//| description | text          | YES  |     | NULL    |                |
//| phone       | varchar(200)  | YES  |     | NULL    |                |
//| enabled     | tinyint(4)    | NO   |     | 1       |                |
//| biography   | text          | YES  |     | NULL    |                |
//| image_url   | text          | YES  |     | NULL    |                |
//+-------------+---------------+------+-----+---------+----------------+
//12 rows in set (0.00 sec)


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
	
	private String imageUrl;

//	------------------------ RELATIONSHIP FIELDS -----------------

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Trip> trips;
	
		
	@OneToOne(mappedBy="user")
	private Inventory inventory;

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
	
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
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
				+ ", enabled=" + enabled + ", imageUrl=" + imageUrl + ", trips=" + trips + ", inventory=" + inventory
				+ "]";
	}
	
//	------------- HASHCODE & EQUALS -----------------

	@Override
	public int hashCode() {
		return Objects.hash(biography, email, enabled, firstName, id, imageUrl, inventory, lastName, password, role,
				trips, username);
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
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(inventory, other.inventory)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(trips, other.trips)
				&& Objects.equals(username, other.username);
	}

}
