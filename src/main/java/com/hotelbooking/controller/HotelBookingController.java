package com.hotelbooking.controller;

import java.text.ParseException;
import java.util.List;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.entity.HotelBooking;
import com.hotelbooking.service.HotelBookingService;

@RestController
public class HotelBookingController {
     
	@Autowired
	HotelBookingService hotelbookingservice;
	
	@PostMapping("/Hotelbooking")
	public void Hotelbooking(@RequestParam int hotelId,@RequestParam int userId,@RequestParam String checkInDate,
			@RequestParam int noOfDays, @RequestParam int noOfrooms) throws ParseException {
		
		hotelbookingservice.Hotelbooking(hotelId,userId,checkInDate,noOfDays,noOfrooms);
	}
	
	@GetMapping("/GetAllBookings")
	public List<HotelBooking>GetAllBookings(){
		return hotelbookingservice.GetAllBookings();
	}
	
	@GetMapping("/GetBookingByHotel/{hotelId}")
	public List<HotelBooking>GetBookingByHotel(@PathVariable int hotelId){
		return hotelbookingservice.GetBookingByHotel(hotelId);
	}
	
	@PatchMapping("/UpdateBooking/{bookingId}")
	public void UpdateBooking(@PathVariable int bookingId,@PathParam(value="hotelId")Integer hotelId,
			@PathParam(value=" checkInDate")String checkInDate,
			@PathParam(value="noOfDays")Integer noOfDays,
			@PathParam(value="noOfrooms")Integer noOfrooms) throws ParseException {
		hotelbookingservice.UpdateBooking(bookingId,hotelId,checkInDate,noOfDays,noOfrooms);
	}

}
