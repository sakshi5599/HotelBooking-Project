package com.hotelbooking.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hotelbooking.entity.Image;
import com.hotelbooking.service.ImageService;

import jakarta.websocket.server.PathParam;

@RestController
public class ImageController {

	@Autowired
	ImageService imgservice;

	@PostMapping("/UploadImage")
	public  void UploadImage(@RequestParam MultipartFile img) throws IOException {
		imgservice.UploadImage(img);
	}
	
	@GetMapping("/getImage")
	public ResponseEntity<?>getImage(@PathParam(value = "pid") Integer pid){
		return imgservice.getImage(pid);
	}
	
	@GetMapping("/getAllImage")
	public List<Image>getAllImage(){
		return imgservice.getAlImage();
	}
	
	@GetMapping("/getImageByName")
	public ResponseEntity<?>getImageByName(@PathParam(value = "pname") String pname){
		return imgservice.getImageByName(pname);
	}
}
