package com.hotelbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ratingId;
	private int star;
	private String feedback;
	
	@ManyToOne
	@JoinColumn(name="HotelId")
	@JsonBackReference
	private Hotel hotel;

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", star=" + star + ", feedback=" + feedback + ", hotel=" + hotel + "]";
	}
	
	

}
