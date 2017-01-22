package com.hcl.TestProject.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.TestProject.service.UserService;


@Controller
public class UserAccessController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAccessController.class);
	
	@Resource(name = "UserService")
	UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/updateUser/username/{username}", method=RequestMethod.GET, consumes="application/xml")
	public String updateUser(@PathVariable String username) {
		logger.info("Username {} is updating", new Object[] {username});
		
		String ss = userService.UpdateUserDetails(username);
		return ss;
	}

}
