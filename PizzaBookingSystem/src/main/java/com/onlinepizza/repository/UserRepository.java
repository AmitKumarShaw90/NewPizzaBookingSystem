package com.onlinepizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinepizza.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String userName);

}
