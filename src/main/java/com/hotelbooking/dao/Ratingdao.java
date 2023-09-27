package com.hotelbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbooking.entity.Rating;
@Repository
public interface Ratingdao extends JpaRepository<Rating,Integer> {

}
