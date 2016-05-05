package com.cooksys.fastbook.models;

// Generated May 4, 2016 4:12:00 PM by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Group generated by hbm2java
 */
@Entity
@Table(name = "group", catalog = "fastbook")
public class Group implements java.io.Serializable {

	private Integer id;
	private User user;
	private String name;
	
	@JsonIgnore
	private Set<Post> posts = new HashSet<Post>(0);
	
	@JsonIgnore
	private Set<User> users = new HashSet<User>(0);

	public Group()
	{
	}

	public Group(User user, String name)
	{
		this.user = user;
		this.name = name;
	}

	public Group(User user, String name, Set<Post> posts, Set<User> users)
	{
		this.user = user;
		this.name = name;
		this.posts = posts;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "owner", nullable = false)
	public User getUser()
	{
		return this.user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "post_group", catalog = "fastbook", joinColumns = { @JoinColumn(name = "group_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "post_id", nullable = false, updatable = false) })
	public Set<Post> getPosts()
	{
		return this.posts;
	}

	public void setPosts(Set<Post> posts)
	{
		this.posts = posts;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "group_user", catalog = "fastbook", joinColumns = { @JoinColumn(name = "group_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
	public Set<User> getUsers()
	{
		return this.users;
	}

	public void setUsers(Set<User> users)
	{
		this.users = users;
	}

}