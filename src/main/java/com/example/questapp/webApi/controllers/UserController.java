package com.example.questapp.webApi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.questapp.business.responses.UserResponse;
import com.example.questapp.business.services.UserService;
import com.example.questapp.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public UserResponse getOneUser(@PathVariable Long userId) {
		//custom exception
		return new UserResponse(userService.getOneUserById(userId));
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		return userService.updateOneUser(userId, newUser);
	}
	
	@PutMapping("/{userId}/avatar")
	public User updateUserAvatar(@PathVariable Long userId, @RequestBody Map<String, Integer> body) {
	    Integer avatarId = body.get("avatarId");
	    if (avatarId == null) {
	        throw new IllegalArgumentException("avatarId is required");
	    }
	    return userService.updateUserAvatar(userId, avatarId);
	}



	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
	}
	
	@GetMapping("/activity/{userId}")
	public List<Object> getUserActivity(@PathVariable Long userId) {
		return userService.getUserActivity(userId);
	}
}





