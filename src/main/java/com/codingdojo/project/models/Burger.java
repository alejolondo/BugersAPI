package com.codingdojo.project.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burges")
public class Burger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5, max= 100)
	private String burgerName;
	
	@NotNull
	@Size(min=5, max=100)
	private String restaurantName;
	
	@NotNull
	@Min(1)
	@Max(5)
	private int rating;
	
	@Size(min=10, max= 255)
	private String notes;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Burger() {
	}

	

	public Burger(@NotNull @Size(min = 5, max = 100) String burgerName,
			@NotNull @Size(min = 5, max = 100) String restaurantName, @NotNull @Min(1) @Max(5) int rating) {
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
	}
	
	



	public Burger(Long id, @NotNull @Size(min = 5, max = 100) String burgerName,
			@NotNull @Size(min = 5, max = 100) String restaurantName, @NotNull @Min(1) @Max(5) int rating) {
		this.id = id;
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int ranting) {
		this.rating = ranting;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	

}
