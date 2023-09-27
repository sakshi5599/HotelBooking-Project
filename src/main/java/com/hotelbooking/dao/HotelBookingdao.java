package com.hotelbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbooking.entity.HotelBooking;

@Repository
public interface HotelBookingdao extends JpaRepository<HotelBooking, Integer> {

}
