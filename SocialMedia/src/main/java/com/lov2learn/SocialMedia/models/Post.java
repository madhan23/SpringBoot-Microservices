package com.lov2learn.SocialMedia.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Post")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer  postId;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Description")
	private String Description;
	
	@Column(name="Breed")
	private String breed;
	

	@Column(name="Price")
	private Integer price;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private User user;

	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	Post() {

	}
	public Integer getPostId() {
		return postId;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", Description=" + Description + ", breed=" + breed
				+ ", price=" + price + ", user=" + user + "]";
	}

}
