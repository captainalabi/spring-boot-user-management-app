package com.alabi.app.service;

import java.util.List;

import com.alabi.app.entity.User;

public interface UserService{

	User createUser(User user);
	List<User> listAllUsers();
	User updateUser(User user);
	void deleteUserById(Integer id);
	User findUserById(Integer id);
}
