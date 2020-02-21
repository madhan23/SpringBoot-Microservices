package com.lov2learn.SocialMedia.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lov2learn.SocialMedia.models.Post;

public interface PostRepository  extends JpaRepository<Post, Integer>{

}
