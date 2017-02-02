package com.hcl.TestProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.TestProject.service.User;
import com.hcl.TestProject.service.UserService;

@Controller
public class UserAccessController {

	private static final Logger logger = LoggerFactory.getLogger(UserAccessController.class);

	@Resource(name = "UserService")
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@ResponseBody
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces="application/json")
	public String updateUser(@RequestParam String username, @RequestParam String password) {
		logger.info("Username {} and password {} is updating", new Object[] { username, password });
		System.out.println(userService);
		String ss = userService.UpdateUserDetails(username);
		return ss;
	}

	@ResponseBody
	@RequestMapping(value = "/getUser/user/{userName}", method = RequestMethod.GET)
	public List<User> getUser(@PathVariable String userName) {
		logger.info("Getting the data of the user: {}", userName);
		List<User> user = new ArrayList<>();
		user = userService.getUser(userName);
		return user;
	}
	
	@ResponseBody
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		users = userService.getUsers();
		return users;
	}

}
