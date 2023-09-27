package com.hotelbooking.controller;

import java.util.List;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.entity.User;
import com.hotelbooking.service.UserService;

@RestController
public class UserController {
	
	@Autowired()
	UserService userservice;
	
	@PostMapping("/AddUser")
	public String AddUser(@RequestBody User user) {
		
		return userservice.AddUser(user);
		
		}
	
	    @GetMapping("/getAllUsers")
	    public List<User>getAllusers(){
	    	return userservice.getAllusers();
	    }
	    
	    @GetMapping("/GetUserById/{userid}")
	    public User getUserById(@PathVariable int userid) {
	    	return userservice.getUserById(userid);
	    }
	    
	    @PutMapping("/EditUser/{userid}")
	    public void EditUser(@PathVariable int userid, @RequestBody User u){
	    	userservice.EditUser(userid,u);
	    }
	    
	    @PatchMapping("/UpdateUser/{userid}")
	    public void UpdateUser(@PathVariable int userid,
	    	@PathParam(value = "username") String username,
	    	@PathParam(value = "address") String address,
	    	@PathParam(value = "email") String email,
	    	@PathParam(value = "password") String password, 
	    	@PathParam(value = "contact") String contact) 
	    {
	    	userservice.UpdateUser(userid,username,address,email,password,contact);
	    	
	    	
	    }
	   
	    @DeleteMapping("/deleteUser/{userid}")
	    public void DeleteUser(@PathVariable int userid) {
	    	
	    	userservice.DeleteUser(userid);
	    }
	}


