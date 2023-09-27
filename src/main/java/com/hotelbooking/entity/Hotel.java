package com.hotelbooking.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderColumn;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hotelId;
	private String hotelName;
	private String address;
	private int totalrooms;
	private int availablerooms;
	private int price;
	
	@OrderColumn(name="position")
	@ElementCollection
	private String[]facilities;
	
	@OneToMany(mappedBy = "hotel", cascade= CascadeType.ALL)
	@JsonManagedReference
	private List<Rating>rating;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotalrooms() {
		return totalrooms;
	}

	public void setTotalrooms(int totalrooms) {
		this.totalrooms = totalrooms;
	}

	public int getAvailablerooms() {
		return availablerooms;
	}

	public void setAvailablerooms(int availablerooms) {
		this.availablerooms = availablerooms;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String[] getFacilities() {
		return facilities;
	}

	public void setFacilities(String[] facilities) {
		this.facilities = facilities;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
	
	

}
