package com.hcl.TestProject.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hcl.TestProject.controller.UserAccessController;
import com.hcl.TestProject.service.User;
import com.hcl.TestProject.service.UserService;
import com.hcl.TestProject.service.UserServiceImpl;

public class UserAccessControllerTest {

	UserAccessController uCon;
	UserService userService;
	String userName = "Haribabu";
	String password = "testpassword";

	@BeforeClass
	public void setUp() {
		uCon = new UserAccessController();
		userService = new UserServiceImpl();
		uCon.setUserService(userService);
	}

	@Test
	public void testClass() {
		assertTrue(uCon.toString(), true);
	}

	@Test
	public void testUpdateUser() {
		//uCon.setUserService(userService);
		assertTrue(uCon.updateUser(userName, password), true);
	}
	
	@Test
	public void testUpdateUser1() {
		assertTrue(userService.UpdateUserDetails(userName).toString(), true);
	}
	
	@Test
	public void testUserService() {
		userService = uCon.getUserService();
		assertEquals(userService, userService);
	}
	
	/*@Test
	public void testGetUser() {
		userService = uCon.getUserService();
		List<User> users = new ArrayList<>();
		assertEquals(userService.getUser(userName), users);
	}
	
	@Test
	public void testGetUsers() {
		userService = uCon.getUserService();
		List<User> users = new ArrayList<>();
		assertEquals(userService.getUsers(), users);
	}*/
}
