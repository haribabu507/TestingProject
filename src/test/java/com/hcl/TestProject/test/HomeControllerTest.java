package com.hcl.TestProject.test;

import static org.junit.Assert.assertTrue;
import java.util.Locale;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hcl.TestProject.HomeController;

public class HomeControllerTest {

	HomeController c;
	Locale locale;
	Model model;
	
	@BeforeClass
	public void setUp() {
		c = new HomeController();
		locale = Locale.ENGLISH;
		model = new RedirectAttributesModelMap();
	}
	
	@Test
	public void homeTesting() {
		System.out.println("I am testing you");
		assertTrue(c.toString(), true);
	}
	
	@Test
	public void testString() {
		System.out.println("Testing the String");
		assertTrue(c.getString(), true);
	}
	
	@Test
	public void testHome(){
		assertTrue(c.home(locale, model), true);
	}
	
}
