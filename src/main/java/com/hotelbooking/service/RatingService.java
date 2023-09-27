package com.hotelbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelbooking.dao.Hoteldao;
import com.hotelbooking.dao.Ratingdao;
import com.hotelbooking.entity.Hotel;
import com.hotelbooking.entity.Rating;

@Service
public class RatingService {
	
	@Autowired
	Ratingdao ratingdao;
	
	@Autowired
	Hoteldao hoteldao;

	public void addRating(Rating rating) {
           ratingdao.save(rating);		
	}

	public List<Rating> GetAllRatings() {
		// TODO Auto-generated method stub
		return ratingdao.findAll();
	}

	public ResponseEntity<?> GetRatingById(int ratingId) {
		try {
			Rating rt=ratingdao.findById(ratingId).get();
			return new ResponseEntity<>(rt,HttpStatus.OK);
			
		}
		catch(Exception e){
			return new ResponseEntity<>("given id is not present",HttpStatus.BAD_REQUEST);

			
		}
	}

	public ResponseEntity<?> EditRating(int ratingId, Rating r) {
		try {
		Rating rt=ratingdao.findById(ratingId).get();
		rt.setStar(r.getStar());
		rt.setFeedback(r.getFeedback());
		
		rt.setHotel(r.getHotel());
		Rating rating=ratingdao.save(rt);
		return new ResponseEntity<>(rating,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Record is not Updated because Id is  not present",HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> UpdateRating(int ratingId, Integer star, String feedback,Integer hotelId) {
		try {
			
			Rating r= ratingdao.findById(ratingId).get();
			if(Optional.ofNullable(star).isPresent()) {
				r.setStar(star);
			}
			if(Optional.ofNullable(feedback).isPresent()) {
				r.setFeedback(feedback);
			}
			if(Optional.ofNullable(hotelId).isPresent()) {
				Hotel h=hoteldao.findById(hotelId).get();
				r.setHotel(h);
			}
			
			
			Rating rt=ratingdao.save(r);
			return new ResponseEntity<>(rt,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Unable to Updata data",HttpStatus.BAD_REQUEST);

		}
		
		
	}

	public ResponseEntity<?> DeleteRating(int ratingId) {
		

     ratingdao.deleteById(ratingId);
 	return new ResponseEntity<>("this id is  deleted", HttpStatus.OK);

	}
//	return new ResponseEntity<>("this id is not deleted", HttpStatus.BAD_REQUEST);



}
