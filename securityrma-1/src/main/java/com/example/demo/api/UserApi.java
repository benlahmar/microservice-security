package com.example.demo.api;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repo.IUser;
@RestController
public class UserApi {
	@Autowired
	IUser urepo;
	
	@GetMapping("/users")
	public List<User> getuser()
	{
		return urepo.findAll();
	}
	
	@GetMapping("/test")
	public String tt()
	{
		return "hello";
	}
	
	
}
