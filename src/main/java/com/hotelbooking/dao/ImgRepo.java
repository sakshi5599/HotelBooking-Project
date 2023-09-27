package com.hotelbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.hotelbooking.entity.Image;

@Repository
public interface ImgRepo extends JpaRepository<Image, Integer>{

	
	public Image findBypname(String pname);
}
