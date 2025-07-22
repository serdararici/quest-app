package com.example.questapp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String userName);

}
