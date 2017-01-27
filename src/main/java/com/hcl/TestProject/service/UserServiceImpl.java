package com.hcl.TestProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.hcl.TestProject.DAO.UserDAO;


@Component(value="UserService")
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDao;
	
	@Override
	public String UpdateUserDetails(String userName) {
		String aa = "No Success";
		
		Faker f = new Faker();
		
		if (null != user) {
			if (userName.equals("Haribabu")) {
				user.setUserName(userName);
				user.setCity("Chennai");
				user.setEmail("haribabu-s@hcl.com");
				user.setId(UUID.randomUUID().toString());
			} else {
				user.setUserName(f.name().name().toString());
				user.setCity(f.address().city().toString());
				user.setEmail(f.internet().emailAddress().toString());
				user.setId(UUID.randomUUID().toString());
			}
			
			
			
			aa = userDao.insertUser(user);
		}
		return aa;
	}

	@Override
	public List<User> getUser(String username) {
		List<User> userList = new ArrayList<>();
		if (null != username) {
			userList = userDao.getUser(username);
		}
		return userList;
	}

	@Override
	public List<User> getUsers() {
		List<User> userList = new ArrayList<>();
		userList = userDao.getUsers();
		return userList;
	}

}
