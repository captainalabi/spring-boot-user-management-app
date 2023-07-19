//Bismillahi Rahmani Raheem
package com.alabi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alabi.app.entity.Role;
import com.alabi.app.entity.User;
import com.alabi.app.service.RoleService;
import com.alabi.app.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	private RoleService roleService;
	
	@Autowired
	public UserController(UserService userService, RoleService roleService) {
		super();
		this.userService = userService;
		this.roleService = roleService;
	}
	/*
	 * link to list of all users
	 */
	@GetMapping("/all/users")
	public String allUsers(Model model) {
		List<User> userslist = userService.listAllUsers();
		
		model.addAttribute("userslist", userslist);
		return "all_users_list";
	}
	/*
	 * link to form creating new user
	 */
	@GetMapping("/new/user")
	public String createUserForm(Model model) {
		model.addAttribute("roleList", roleService.readAllRoles());
		model.addAttribute("user", new User());
		return "new_user_form";
	}
	/*
	 * link to create a new user method
	 */
	@PostMapping("/user/save")
	public String createUser(@ModelAttribute User user, Model model) {
		//initialize success Message
		String successMessage = "";
		//check duplicate entry
		try {
		userService.createUser(user);
		successMessage = "User successfully created";
		}catch(DataIntegrityViolationException e) {
			successMessage = "The User already exists";
		}
		model.addAttribute("successMessage", successMessage);
		return "redirect:/all/users";
	}
	/*
	 * link to form editing a user
	 */
	@GetMapping("/user/edit/{id}")
	public String editUser(@PathVariable("id") Integer id, Model model) {
		List<Role> rolesList = roleService.readAllRoles();
		model.addAttribute("rolesList", rolesList);
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "new_user_form";
	} 
	
	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUserById(id);
		return "redirect:/all/users";
	} 
}
