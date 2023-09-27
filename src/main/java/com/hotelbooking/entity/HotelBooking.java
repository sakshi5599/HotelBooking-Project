package com.hotelbooking.entity;

import java.util.Date;

//import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class HotelBooking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	
	@OneToOne
	//@JoinColumn(name="hotelId" ,unique=false)
	private Hotel hotel;
	
	@OneToOne
	//@JoinColumn(name="hotelId" ,unique=false)
	private User user;
	
	@CreationTimestamp
	 @JsonFormat(pattern = "dd/MM/yyyy")
	private Date bookingDate;
	
	@CreationTimestamp
	 @JsonFormat(pattern = "dd/MM/yyyy")
	private Date checkInDate;
	
	private int noOfDays;
	
	private int noOfrooms;
	
	private int price;
	
	private String bookingStatus;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User userId) {
		this.user = userId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getNoOfrooms() {
		return noOfrooms;
	}

	public void setNoOfrooms(int noOfrooms) {
		this.noOfrooms = noOfrooms;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	
}
