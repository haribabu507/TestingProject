package com.hcl.TestProject.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hcl.TestProject.controller.UserAccessController;
import com.hcl.TestProject.service.UserService;
import com.hcl.TestProject.service.UserServiceImpl;

public class UserAccessControllerTest {

	UserAccessController uCon;
	UserService userService;
	String userName = "Haribabu";

	@BeforeClass
	public void setUp() {
		uCon = new UserAccessController();
		userService = new UserServiceImpl();
	}

	@Test
	public void testClass() {
		assertTrue(uCon.toString(), true);
	}

	@Test
	public void testUpdateUser() {
		uCon.setUserService(userService);
		assertTrue(uCon.updateUser(userName), true);
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
}
