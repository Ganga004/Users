package com.userdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userdata.entity.User;
import com.userdata.service.UserService;
import com.userdata.valueobject.ResponseTemplateVO;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/allusers")
	public List<User> getAllRecords(@RequestBody User user)
	{
		return userservice.getAllData(user);
	}
		
	@PostMapping("/adddata")
	public User saveData(@RequestBody User user)
	{
		if(user instanceof User) {
		
		}
		//Check user authentication
		return userservice.saveUserData(user);
		
	}
	
	@GetMapping("/bothdata/{id}")
	public ResponseTemplateVO getResponse(@PathVariable("id") Long userId)
	{
		return userservice.getDatafromBothEntity(userId);
		
	}
}
