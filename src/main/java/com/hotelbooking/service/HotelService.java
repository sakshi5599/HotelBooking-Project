package com.hotelbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelbooking.dao.Hoteldao;
import com.hotelbooking.entity.Hotel;

@Service
public class HotelService {
	
	@Autowired
	Hoteldao hoteldao;

	public void AddHotel(Hotel hotel) {
		hoteldao.save(hotel);
	}

	public List<Hotel> GetAllHotels() {
		return hoteldao.findAll();
	}

	
	public ResponseEntity<?> GetHotelById(int hotelId) {
		try {
		Hotel ht=hoteldao.findById(hotelId).get();
		
		return new ResponseEntity<>(ht,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Given Id is Not Present in Database",HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> GetHotelByName(String hotelName) {
		try {
			Hotel ht=hoteldao.findByHotelName(hotelName);
			
			return new ResponseEntity<>(ht,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>("Given Name is Not Present in Database",HttpStatus.BAD_REQUEST);
			}
	}

	public List<Hotel> GetHotelByAddress(String address) {
		return hoteldao.findByAddress(address);
	}

	public ResponseEntity<?>EditHotel(int hotelId, Hotel hotel) {
		try {
		Hotel h=hoteldao.findById(hotelId).get();
		h.setHotelName(hotel.getHotelName());
		h.setAddress(hotel.getAddress());
		h.setTotalrooms(hotel.getTotalrooms());
		h.setAvailablerooms(hotel.getAvailablerooms());
		h.setPrice(hotel.getPrice());

		h.setFacilities(hotel.getFacilities());
	//	h.setRating(hotel.getRating());
		Hotel ht=hoteldao.save(h);
		return new ResponseEntity<>(ht,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Unable to Upate because Given HotelId is NOT present",HttpStatus.BAD_REQUEST);
		}
		
		
	}

	public ResponseEntity<?> UpdateHotel(int hotelId, String hotelName, String address, Integer totalrooms,
		Integer availablerooms, Integer price, String[] facilities) {

	try {
		Hotel h=hoteldao.findById(hotelId).get();
		
		if(Optional.ofNullable(hotelName).isPresent()) 
		{
			h.setHotelName(hotelName);
		}
		if(Optional.ofNullable(address).isPresent())
		{
			h.setAddress(address);
		}
		if(Optional.ofNullable(totalrooms).isPresent())
		{
			h.setTotalrooms(totalrooms);
		}
		if(Optional.ofNullable(availablerooms).isPresent())
		{
			h.setAvailablerooms(availablerooms);
		}
		if(Optional.ofNullable(price).isPresent())
		{
			h.setPrice(price);
		}
		if(Optional.ofNullable(facilities).isPresent())
		{
			h.setFacilities(facilities);
		}
		Hotel ht=hoteldao.save(h);
		return new ResponseEntity<>(ht,HttpStatus.OK);
	
	}
	catch(Exception e) {
		return new ResponseEntity<>("Unable to Update",HttpStatus.BAD_REQUEST);

	}
	}

	public void Deletehotel(int hotelId) {
		hoteldao.deleteById(hotelId);
		
	}
	

}
