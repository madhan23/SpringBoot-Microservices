package com.lov2learn.SocialMedia.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lov2learn.SocialMedia.models.User;
import com.lov2learn.SocialMedia.services.UserImplServices;


@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserImplServices userImpServices;

	User userdetails=null;
	
	@GetMapping(value="/user")
	private ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userImpServices.getAllUserDetails();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/user/{id}")
	private ResponseEntity<User> getSingleuserinfo(@PathVariable("id") Integer userId) {
		
		 userdetails=userImpServices.getUser(userId);

		return new ResponseEntity<User>(userdetails,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping(value = "/user")
	private ResponseEntity<User> userRegister(@Valid @RequestBody User user) {
		
		 userdetails=userImpServices.saveUserDetails(user);

		return new ResponseEntity<User>(userdetails,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping(value = "/user/{id}")
	private ResponseEntity<User> userUpdate(@PathVariable("id") Integer userId, @Valid @RequestBody User user) {
		
		 userdetails=userImpServices.updateUser(userId,user);

		return new ResponseEntity<User>(userdetails,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping(value="/user/delete/{id}")
	private ResponseEntity<User> userRemove(@PathVariable("id") Integer userId) {
		userImpServices.deleteUser(userId);
		return new ResponseEntity<User>(userdetails,HttpStatus.NO_CONTENT);
	}
	
	
}
