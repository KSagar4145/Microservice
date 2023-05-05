package com.lced.user.service.service;

import java.util.List;

import com.lced.user.service.entities.User;

public interface IUserService {

	public User saveUser(User user);

	public List<User> getAllUser();

	public User getUser(String userId);

	// update
	// delete

}
