package com.niit.bokayflorist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Dao.UserDao;
import com.Model.User;

public class UserController {
	
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	
	
	@RequestMapping("/addUser")
	public String addUser(@RequestParam Map<String,String> user1,Model m) {
		
	    
		user.setEmail(user1.get("email"));
		user.setAddress(user1.get("address"));
		user.setCountry(user1.get("country"));
		user.setGender(user1.get("gender"));
		user.setName(user1.get("name"));
		user.setPassword(user1.get("password"));
		user.setPhone(user1.get("phone"));
		
		if(userDao.add(user))
			return "redirect:login?id=3";
		return "register";
	}
}
