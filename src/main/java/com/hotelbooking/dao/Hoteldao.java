package com.hotelbooking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbooking.entity.Hotel;

@Repository
public interface Hoteldao extends JpaRepository<Hotel, Integer> {

	public Hotel findByHotelName(String HotelName);
	public List<Hotel>findByAddress(String address);
}
