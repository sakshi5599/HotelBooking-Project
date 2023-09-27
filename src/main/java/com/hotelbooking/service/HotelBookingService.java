package com.hotelbooking.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.dao.HotelBookingdao;
import com.hotelbooking.dao.Hoteldao;
import com.hotelbooking.dao.UserRepository;
import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.HotelBooking;
import com.hotelbooking.entity.User;

@Service
public class HotelBookingService {
	
	@Autowired
	HotelBookingdao hotelbookingdao;
	
	@Autowired
	Hoteldao hoteldao;
	
	@Autowired
	UserRepository userrepository;
	

	public void Hotelbooking(int hotelId, int userId, String checkInDate, int noOfDays, int noOfrooms) throws ParseException {
		HotelBooking hb=new HotelBooking();
		
//		Hotel hotel =hoteldao.findById(hotelId).get();
//		hb.setHotel(hotel);
//		
		User user=userrepository.findById(userId).get();
		hb.setUser(user);
		
	//hb.setBookingDate(new Date());
		
	Date d=  new SimpleDateFormat("dd/MM/yyyy").parse(checkInDate);
	
		hb.setCheckInDate(d);
	
		hb.setNoOfDays(noOfDays);
		
		hb.setNoOfrooms(noOfrooms);
		
		
		Hotel hotel =hoteldao.findById(hotelId).get();
		hotel.setAvailablerooms(hotel.getAvailablerooms()-noOfrooms);
		hoteldao.save(hotel);
		hb.setHotel(hotel);
		
		hb.setPrice(hotel.getPrice()*noOfrooms*noOfDays);
		
		
		
		hb.setBookingStatus("Booked");
		hotelbookingdao.save(hb);
	}


	public List<HotelBooking> GetAllBookings() {
		return hotelbookingdao.findAll();
		

	}


	public List<HotelBooking> GetBookingByHotel(int hotelId) {
		List<HotelBooking>list=new ArrayList<>();
		List<HotelBooking>bookinglist=hotelbookingdao.findAll();
		for(HotelBooking hb:bookinglist) {
			if(hb.getHotel().getHotelId()==hotelId) {
				list.add(hb);
			}
		}
		return list;
	}


	public void UpdateBooking(int bookingId, Integer hotelId, String checkInDate, Integer noOfDays, Integer noOfrooms) throws ParseException {
		HotelBooking hb=hotelbookingdao.findById(bookingId).get();
		
		if(Optional.ofNullable(checkInDate).isPresent()) {
		Date d= (Date) new SimpleDateFormat("dd/MM/yyyy").parse(checkInDate);
             hb.setCheckInDate(d);
		}
		
		if(Optional.ofNullable(noOfDays).isPresent()) {
              hb.setNoOfDays(noOfDays);
		}
		
		if(Optional.ofNullable(hotelId).isPresent()) {
		Hotel ht=hoteldao.findById(hotelId).get();
		hb.setHotel(ht);
		}
		
		if(Optional.ofNullable(noOfrooms).isPresent()) {
			Hotel ht=hoteldao.findById(hb.getHotel().getHotelId()).get();
			
		if(noOfrooms>hb.getNoOfrooms()) {
            ht.setAvailablerooms(ht.getAvailablerooms()-(noOfrooms-hb.getNoOfrooms()));
		
		}
		else {
            ht.setAvailablerooms(ht.getAvailablerooms()+(hb.getNoOfrooms()-noOfrooms));

		}
		hoteldao.save(ht);
			hb.setNoOfrooms(noOfrooms);	
			
		}
		hotelbookingdao.save(hb);
		
	}

}
