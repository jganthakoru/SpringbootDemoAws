package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repo.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	//get all users
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return  userRepo.findAll();
	}
	
	//get user by id
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable long id) {
		return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Existed "+id));
	}
	
	//save or create user
	@PostMapping("/saveUser")
	public User createUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	//update user
	@PostMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user, @PathVariable long id) {
		User existUser = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Existed "+id));
		existUser.setEmail(user.getEmail());
		return userRepo.save(existUser);
	}
	
	//delete user by id
	@DeleteMapping("/deleteUserById/{id}")
	public void deleteUser(@PathVariable long id) {
		User existUser = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Existed "+id));
		userRepo.delete(existUser);
	}
}