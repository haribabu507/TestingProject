package com.hcl.TestProject.service;

import java.util.List;

public interface UserService {

	String UpdateUserDetails(String userName);
	
	List<User> getUser(String username);
	
	List<User> getUsers();

}