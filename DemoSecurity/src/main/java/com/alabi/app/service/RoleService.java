//Bismillahi Rahmani Raheem
package com.alabi.app.service;

import java.util.List;

import com.alabi.app.entity.Role;

public interface RoleService {

	Role createRole(Role role);
	List<Role> readAllRoles();
	Role findRoleById(Integer id);
	void deleteRoleById(Integer id);
}
