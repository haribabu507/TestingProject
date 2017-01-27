package com.hcl.TestProject.DAO;

import java.util.List;

import com.hcl.TestProject.service.User;

public interface UserDAO {

	String insertUser(User user);
	
	List<User> getUser(String userName);
	
	List<User> getUsers();

}