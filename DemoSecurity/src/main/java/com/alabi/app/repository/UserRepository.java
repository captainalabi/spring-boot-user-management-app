//Bismillahi Rahmani Raheem
package com.alabi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alabi.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
