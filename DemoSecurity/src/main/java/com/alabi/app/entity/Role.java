//Bismillahi Rahmani Raheem
package com.alabi.app.entity;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="roleName", unique = true)
	private String roleName;
	
	@ManyToMany
	List <User> user;
	
	public Role(Integer id, String roleName, List<User> user) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.user = user;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "roleName";
	}
	
}
