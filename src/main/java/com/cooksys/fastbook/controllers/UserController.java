package com.cooksys.fastbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.fastbook.dao.UserDao;
import com.cooksys.fastbook.models.Friend;
import com.cooksys.fastbook.models.User;

@RestController
@RequestMapping(value = "/users")
public class UserController 
{
	@Autowired
	private UserDao userDao;
	
	// fastbook/api/users/
	@RequestMapping(method = RequestMethod.GET)
	public List<User> index()
	{
		return userDao.index();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public User addUser(@RequestBody User user)
	{
		return userDao.add(user);
	}
	
	// fastbook/api/users/{id}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Integer id)
	{
		return userDao.get(id);
	}
	
	// fastbook/api/users/find/{name}
	@RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
	public List<User> queryUsers(@PathVariable String name)
	{
		return userDao.queryUsers(name);
	}
	
	// fastbook/api/users/{id}/friends
	@RequestMapping(value = "/{id}/friends", method = RequestMethod.GET)
	public List<User> getFriends(@PathVariable Integer id)
	{
		return userDao.getFriends(id);
	}
	
	// fastbook/api/users/{id}/my_pending_requests
	@RequestMapping(value = "/{id}/my_pending_requests", method = RequestMethod.GET)
	public List<Friend> getMyPendingRequests(@PathVariable Integer id)
	{
		return userDao.getMyPendingRequests(id);
	}
	
	// fastbook/api/users/{id}/requests
	// Request body contains logged in user
	@RequestMapping(value = "/{id}/requests", method = RequestMethod.PUT)
	public Friend addFriendRequest(@PathVariable Integer id, @RequestBody User user)
	{
		return userDao.addFriendRequest(id, user);
	}
	
	@RequestMapping(value = "/{id}/requests", method = RequestMethod.PATCH)
	public List<Friend> acceptFriendRequestFromList(@PathVariable Integer id, @RequestBody Friend friend)
	{
		return userDao.acceptFriendRequestFromList(id, friend);
	}
	
	@RequestMapping(value = "/{id}/requests", method = RequestMethod.DELETE)
	public List<Friend> denyFriendRequestFromList(@PathVariable Integer id, @RequestBody Friend friend)
	{
		return userDao.denyFriendRequestFromList(id, friend);
	}
	
	// fastbook/api/users/{id}/request/{loggedInid}
	@RequestMapping(value = "/{profileId}/request/{loggedInid}", method = RequestMethod.GET)
	public Friend getFriendRelation(@PathVariable Integer profileId, @PathVariable Integer loggedInid)
	{
		return userDao.getFriendRelation(profileId, loggedInid);
	}
	@RequestMapping(value = "/{id}/request", method = RequestMethod.PATCH)
	public Friend acceptFriendRequest(@PathVariable Integer id, @RequestBody Friend friend)
	{
		return userDao.acceptFriendRequest(id, friend);
	}
	
	@RequestMapping(value = "/{id}/request", method = RequestMethod.DELETE)
	public Friend denyFriendRequest(@PathVariable Integer id, @RequestBody Friend friend)
	{
		return userDao.denyFriendRequest(id, friend);
	}
}