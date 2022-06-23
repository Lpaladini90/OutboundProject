package com.outbound.entities;


import java.time.LocalDate;
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
public class Trip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	private boolean success;
	
	private boolean enabled;
	
	@Column(name = "image_url")
	private String imageUrl;

	
//	------------------------ RELATIONSHIP FIELDS -----------------

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	 
//	------------------------ CONSTRUCTORS -----------------

	
	
	
	public Trip() {
		super();
	}
	
//	------------------------ RELATIONAL MAPPING -----------------


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	------------------------ GETTERS/SETTERS -----------------

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	
	
	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", success=" + success + ", enabled=" + enabled + ", imageUrl=" + imageUrl
				+ ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, enabled, endDate, id, imageUrl, name, startDate, success, user);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trip other = (Trip) obj;
		return Objects.equals(description, other.description) && enabled == other.enabled
				&& Objects.equals(endDate, other.endDate) && id == other.id && Objects.equals(imageUrl, other.imageUrl)
				&& Objects.equals(name, other.name) && Objects.equals(startDate, other.startDate)
				&& success == other.success && Objects.equals(user, other.user);
	}

	
	
}