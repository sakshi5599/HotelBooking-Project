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

import com.hotelbooking.dao.Hoteldao;
import com.hotelbooking.entity.Rating;
import com.hotelbooking.service.RatingService;

@RestController
public class RatingController {
	@Autowired
	RatingService ratingservice;
	
	
	
	
	@PostMapping("/addRating")
	public void addRating (@RequestBody Rating rating) {
		
		ratingservice.addRating(rating);
	}
	
	@GetMapping("/GetAllRatings")
	public List<Rating>GetAllRatings(){
		return ratingservice.GetAllRatings();
		
	}
	
	@GetMapping("/GetRatingById/{ratingId}")
	public ResponseEntity<?> GetRatingById(@PathVariable int ratingId) {
		return ratingservice.GetRatingById(ratingId);
	}
	
	@PutMapping("/EditRating/{ratingId}")
	public ResponseEntity<?>EditRating(@PathVariable int ratingId,@RequestBody Rating r){
		return ratingservice.EditRating(ratingId,r);
	}
	
	@PatchMapping("/UpdateRating/{ratingId}")
	public ResponseEntity<?>UpdateRating(@PathVariable int ratingId,
			@PathParam (value="star") Integer star,
			@PathParam(value="feedback")String feedback,
			@PathParam (value="hotel") Integer hotelId){
		return ratingservice.UpdateRating(ratingId,star,feedback,hotelId);
		
	}
	
	@DeleteMapping("/DeleteRating/{ratingId}")
	public  ResponseEntity<?> DeleteRating(@PathVariable int ratingId){
		 return ratingservice.DeleteRating(ratingId);
	}
	
	
}
