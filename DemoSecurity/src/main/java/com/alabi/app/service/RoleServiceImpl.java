//Bismillahi Rahmani Raheem
package com.alabi.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alabi.app.entity.Role;
import com.alabi.app.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> readAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public void deleteRoleById(Integer id) {
		roleRepository.deleteById(id);
	}

	@Override
	public Role findRoleById(Integer id) {
		return roleRepository.findById(id).get();
	}
}
