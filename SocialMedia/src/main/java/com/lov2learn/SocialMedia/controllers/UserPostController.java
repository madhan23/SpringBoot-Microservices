package com.lov2learn.SocialMedia.controllers;

import java.util.List;

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

import com.lov2learn.SocialMedia.models.Post;
import com.lov2learn.SocialMedia.services.PostImplServices;


@RestController
@RequestMapping("/api")
public class UserPostController {

	@Autowired
	PostImplServices postImplServices;

	@GetMapping(value = "/user/{id}/post")
	private ResponseEntity getAllUsers(@PathVariable("id") Integer userId) {
		System.out.println("Yes");
		List<Post> posts = postImplServices.getUserAllpost(userId);
		return new ResponseEntity(posts, HttpStatus.OK);

	}

	@GetMapping(value = "/user/{id}/post/{postId}")
	private ResponseEntity<Post> getSingleuserinfo(@PathVariable("id") Integer userId,
			@PathVariable("postId") Integer postId) {

		Post post = postImplServices.getUserPost(userId, postId);

		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}

	@PostMapping(value = "/user/{id}/post")
	private ResponseEntity<Post> postUpload(@PathVariable("id") Integer userId, @RequestBody Post post) {
		System.out.println(post);
		Post posts = postImplServices.userPostUpload(userId, post);
		return new ResponseEntity<Post>(posts, HttpStatus.CREATED);

	}

	@PostMapping(value = "/user/{id}/post/{postId}")
	private ResponseEntity<Post> userPostUpdate(@PathVariable("id") Integer userId,
			@PathVariable("postId") Integer postId, @RequestBody Post postdetails) {

		Post post = postImplServices.userPostUpdate(userId, postId, postdetails);

		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/user/{id}/post/{postId}")
	private ResponseEntity  userPostDelete(@PathVariable("id") Integer userId,
			@PathVariable("postId") Integer postId, @RequestBody Post postdetails) {

		postImplServices.userPostDelete(userId, postId, postdetails);

		return new ResponseEntity("Post Deleted Successfully ", HttpStatus.NO_CONTENT);
	}
}
