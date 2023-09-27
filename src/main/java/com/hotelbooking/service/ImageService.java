package com.hotelbooking.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hotelbooking.dao.ImgRepo;
import com.hotelbooking.entity.Image;

@Service
public class ImageService {
	
	@Autowired
	ImgRepo imgrepo;

	public void UploadImage(MultipartFile img) throws IOException {

		Image i=new Image();
		i.setPname(img.getOriginalFilename());
		i.setType(img.getContentType());
		i.setImg(ImageUtil.compressImage(img.getBytes()));
		imgrepo.save(i);
	}

	public ResponseEntity<?> getImage(Integer pid) {

		Image i=imgrepo.findById(pid).get();
		
		return  ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(ImageUtil.decompressImage(i.getImg()));
	}

	public List<Image> getAlImage() {
		return imgrepo.findAll();
	}

	public ResponseEntity<?> getImageByName(String pname) {
		Image i=imgrepo.findBypname(pname);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(ImageUtil.decompressImage(i.getImg()));
	};
	}
	


