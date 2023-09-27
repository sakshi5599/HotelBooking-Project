package com.hotelbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.dao.UserRepository;
import com.hotelbooking.entity.User;

@Service
public class UserService {
	
	@Autowired()
	UserRepository  userrepository;

	public String AddUser(User user) {
		 userrepository.save(user);
		return "Add user";
		
		
	}

	public List<User> getAllusers() {
		return userrepository.findAll();
		
	}

	public User getUserById(int userid) {
		
		return userrepository.findById(userid).get();
	}

	public void EditUser(int userid, User u) {
		
		User user= userrepository.findById(userid).get();
		user.setUsername(u.getUsername());
		user.setAddress(u.getAddress());
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		user.setContact(u.getContact());
		
		userrepository.save(user);	
		
	}


	public void UpdateUser(int userid, String username, String address, String email, String password, String contact) {
		User user= userrepository.findById(userid).get();
		if(Optional.ofNullable(username).isPresent()) {
			user.setUsername(username);
		}
		
		if(Optional.ofNullable(address).isPresent()) {
			user.setAddress(address);
		}
		
		if(Optional.ofNullable(email).isPresent()) {
			user.setEmail(email);
		}
		if(Optional.ofNullable(password).isPresent()) {
			user.setPassword(password);
		}
		if(Optional.ofNullable(contact).isPresent()) {
			user.setContact(contact);
		}
		
		userrepository.save(user);	
	

	}

	public void DeleteUser(int userid) {

		userrepository.deleteById(userid);
	}

}
