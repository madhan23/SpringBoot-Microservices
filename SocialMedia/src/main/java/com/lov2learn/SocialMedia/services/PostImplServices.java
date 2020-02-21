package com.lov2learn.SocialMedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lov2learn.SocialMedia.Dao.PostRepository;
import com.lov2learn.SocialMedia.models.Post;
import com.lov2learn.SocialMedia.models.User;

@Service
public class PostImplServices {

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserImplServices userImplServices;

	private User user;
	private Post post;

	private User checkValidUser(Integer userId) {
		
		User user = userImplServices.getUser(userId);
		return user;
	}

	@Transactional
	public List<Post> getUserAllpost(Integer userId) {
System.out.println("***");
		user = checkValidUser(userId);

		if (user != null)

			return user.getPosts();

		return null;
	}

	@Transactional
	public Post getUserPost(Integer userId, Integer postId) {

		Optional<Post> post = null;
		user = checkValidUser(userId);
		if (user != null) {
			post = postRepository.findById(postId);
			if (!post.isPresent())
				return null;
		}

		return post.get();

	}

	@Transactional
	public Post userPostUpdate(Integer userId, Integer postId, Post postdetails) {
		user = checkValidUser(userId);
		if (user != null) {
			Optional<Post> posts = postRepository.findById(postId);
			if (posts.isPresent()) {
				postdetails.setUser(user);
				postdetails.setPostId(postId);
				post = postRepository.save(postdetails);
				return post;
			}

		}

		return null;
	}

	@Transactional
	public Post userPostUpload(Integer userId, Post postdetails) {
		user = checkValidUser(userId);
		System.out.println(user);
		if (user != null) {
			postdetails.setUser(user);
			post = postRepository.save(postdetails);
			return post;
		}
		return null;
	}

	@Transactional
	public void userPostDelete(Integer userId, Integer postId, Post postdetails) {
		user = checkValidUser(userId);
		if (user != null) {
			Optional<Post> posts = postRepository.findById(postId);
			if (posts.isPresent())
				postRepository.deleteById(postId);

		}

	}

}
