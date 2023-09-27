package com.hotelbooking.controller;

import java.util.List;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.service.HotelService;


@RestController
public class HotelController {
	@Autowired
	HotelService hotelservice;
	
	
	@PostMapping("/AddHotel")
	public void AddHotel(@RequestBody Hotel hotel) {
		
		hotelservice.AddHotel(hotel);
		
	}
	@GetMapping("/GetAllHotels")
	public  List<Hotel>GetAllHotels(){
		return hotelservice.GetAllHotels();
		
	}
	@GetMapping("/GetHotelById/{hotelId}")
	public ResponseEntity<?>GetHotelById(@PathVariable int hotelId){
		return hotelservice.GetHotelById(hotelId);
	}
	
	@GetMapping("/GetHotelByName/{hotelName}")
	public ResponseEntity<?>GetHotelByName(@PathVariable String hotelName){
		return hotelservice.GetHotelByName(hotelName);
	}
	
	@GetMapping("/GetHotelByAddress/{address}")
	public List<Hotel>GetHotelByAddress(@PathVariable String address){
		return hotelservice.GetHotelByAddress(address);
	}
	
	@PutMapping("/EditHotel/{hotelId}")
	public ResponseEntity<?>EditHotel(@PathVariable int hotelId,@RequestBody Hotel hotel){
		return hotelservice.EditHotel(hotelId,hotel);
	}
	
	@PatchMapping("/UpdateHotel/{hotelId}")
	public ResponseEntity<?>UpdateHotel(@PathVariable int hotelId,
			@PathParam (value="hotelName")String hotelName,
			@PathParam(value="address") String address,
			@PathParam(value="totalrooms")Integer totalrooms,
			@PathParam(value="availablerooms")Integer availablerooms,
			@PathParam(value="price")Integer price,
			@PathParam(value="facilities")String[]facilities
			){
		return hotelservice.UpdateHotel(hotelId,hotelName,address,totalrooms,availablerooms,price,facilities);
	}
	
	@DeleteMapping("/DeleteHotel/{hotelId}")
	public void Deletehotel(@PathVariable int hotelId) {
		hotelservice.Deletehotel(hotelId);
	}
	

}
