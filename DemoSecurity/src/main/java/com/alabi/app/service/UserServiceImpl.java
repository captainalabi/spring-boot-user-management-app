package com.alabi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alabi.app.entity.User;
import com.alabi.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService  {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public List<User> listAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findUserById(Integer id) {
		User user = userRepository.findById(id).get();
		return user;
	}

}
