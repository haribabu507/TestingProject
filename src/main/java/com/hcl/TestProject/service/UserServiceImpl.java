package com.hcl.TestProject.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.TestProject.DAO.UserDAO;


@Component(value="UserService")
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	User u;
	
	@Autowired
	UserDAO userDao;
	
	@Override
	public String UpdateUserDetails(String userName) {
		String aa = "No Success";
		if (null != u) {
			u.setUserName(userName);
			u.setCity("Chennai");
			u.setEmail("haribabu-s@hcl.com");
			u.setId(UUID.randomUUID().toString());
			
			aa = userDao.insertUser(u);
		}
		return aa;
	}

}
