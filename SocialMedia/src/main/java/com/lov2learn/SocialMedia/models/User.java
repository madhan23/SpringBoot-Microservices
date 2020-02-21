package com.lov2learn.SocialMedia.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer UserId;

	@NotEmpty(message = "Username must not be empty")

	@Column(name = "Username")
	private String Name;
	
	@NotNull(message = "Age must not be empty")
	@Column(name = "Age")
	private int age;
	

	@NotNull(message = "MobileNumber must not be empty")
	@Column(name = "MobileNumber")
	private Long phoneNumber;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Post> posts;

	public User() {
		super();
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public Integer getUserId() {
		return UserId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", Name=" + Name + ", age=" + age + ", phoneNumber=" + phoneNumber
				+ ", posts=" + posts + "]";
	}
}
