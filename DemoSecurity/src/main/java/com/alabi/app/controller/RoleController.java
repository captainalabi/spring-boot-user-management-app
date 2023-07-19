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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.alabi.app.entity.Role;
import com.alabi.app.service.RoleService;



@Controller
public class RoleController {

	private RoleService roleService;

	@Autowired
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}
	
	/*
	 * link to list of all roles page
	 */
	@GetMapping("/all/role")
	public String listAllRoles(Model model) {
		List<Role> roleslist = roleService.readAllRoles();
		model.addAttribute("roleslist", roleslist);
		return "all_roles_list";
	}
	
	/*
	 * link to form creating new role
	 */
	@GetMapping("/new/role")
	public String newRoleForm(Model model) {
		model.addAttribute("role", new Role());
		return "new_role_form";
	}
	
	/*
	 * link to create a new role
	 */
	@PostMapping("/save/role")
	public String createNewRole(@ModelAttribute Role role, RedirectAttributes redirectAttributes) {
		//set success message
		String successMessage = "";		
		//check if role already exists
		try {
			roleService.createRole(role);
			successMessage = "Role successfully created!";
		}catch(DataIntegrityViolationException e) {
			successMessage = "This role already exists!";
		}		
		redirectAttributes.addFlashAttribute("successMessage", successMessage);
		return "redirect:/all/role";
	}
	
	@GetMapping("/role/delete/{id}")
	public String deleteRoleById(@PathVariable("id") Integer id) {
		roleService.deleteRoleById(id);
		return "redirect:/all/role";
	}
	
	@GetMapping("/role/edit/{id}")
	public String editRoleById(@PathVariable("id") Integer id, Model model) {
		Role role = roleService.findRoleById(id);
		model.addAttribute("role", role);
		
		return "new_role_form";
	}
}
