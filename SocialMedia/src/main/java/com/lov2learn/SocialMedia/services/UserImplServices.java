package com.lov2learn.SocialMedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lov2learn.SocialMedia.Dao.UserRepository;
import com.lov2learn.SocialMedia.excep.RecordNotFoundException;
import com.lov2learn.SocialMedia.models.User;

@Service
public class UserImplServices {

	@Autowired
	UserRepository userRepository;

	@Transactional
	public User saveUserDetails(User user) {

		User userinfo = userRepository.save(user);

		return userinfo;
	}

	@Transactional
	public List<User> getAllUserDetails() {
		List<User> user = userRepository.findAll();
		return user;
	}

	@Transactional
	public User updateUser(Integer userId, User userDetails) {
		Optional<User> user = userRepository.findById(userId);

		if (!user.isPresent())
			throw new RecordNotFoundException("No user Found*");
		
		userDetails.setUserId(userId);
		userRepository.save(userDetails);

		return userDetails;
	}

	@Transactional
	public User getUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent())
			throw new RecordNotFoundException("No user Found");

		return user.get();
	}

	@Transactional
	public User deleteUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
		return null;
		}
				
		User userDetails = user.get();
		userRepository.deleteById(userDetails.getUserId());
		return userDetails;
	}
}
