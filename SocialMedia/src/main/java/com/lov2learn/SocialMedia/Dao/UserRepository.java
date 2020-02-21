package com.lov2learn.SocialMedia.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lov2learn.SocialMedia.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
