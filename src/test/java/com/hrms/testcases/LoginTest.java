package com.hrms.testcases;



//import org.testng.annotations.*;
//import org.testng.annotations.Test;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.hrms.pages.LoginPageElements;
//import com.hrms.utils.CommonMethods;
//import com.hrms.utils.ConfigsReader;
//
//public class LoginTest extends CommonMethods {
//	//in ervey single test case we have to use assertion
//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();   //initialze all pages at once
//	} 
//	
//	@AfterMethod
//    public void closeBrowser() {
//	tearDown();
//	}
//	
//	@Test(groups="smoke")
//	public void validAdminLogin() {
//		wait(10);
//		//LoginPageElements login = new LoginPageElements();
//		sendText(login.username, ConfigsReader.getProperty("username"));
//		sendText(login.password, ConfigsReader.getProperty("password"));
//		click(login.loginBtn);
//		
//		//DashboardPageElements dashboard = new DashboardPageElements();
//		String expectedUser ="Welcome Admin"; //the one should be inside the webpage
//		String actualUser = dashboard.welcome.getText(); //actual comes from our application
//		Assert.assertEquals(actualUser, expectedUser, "Admin NOT Logged in");//verify string
//		//verify boolean
//		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username"))); //actual user username i iceriyorsa 	
//	}
//	@Test(groups="regression")
//	public void invalidPasswordLogin () {  //Negative Login
//		//LoginPageElements login = new LoginPageElements();
//		sendText(login.username, ConfigsReader.getProperty("username"));
//		sendText(login.password, "glglhf");
//		click(login.loginBtn);
//		
//		String expected = "Invalid credentials";
//		
//		//actual coming from the application , expected always comes from the userstory
//		Assert.assertEquals(login.errorMsg.getText(), expected,"Error message text is NOT matched");
//	}
//	
//	//Negative Login 
//	@Test(enabled=true)  
//	public void emptyUsernameLogin () { //live the username empty, write valid password then click login
//		LoginPageElements login = new LoginPageElements();
//		sendText(login.password, ConfigsReader.getProperty("password"));
//		click(login.loginBtn);
//		
//		String expected ="Username cannot be empty";
//		Assert.assertEquals(login.errorMsg.getText(),expected, "Error message text is NOT matched");
//		
//	}
//	
//	
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	//@Test(groups="smoke")
	public void validAdminLogin() {
		test.info("Entering valid admin credentilas");
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		// DashboardPageElements dashboard = new DashboardPageElements();
		test.info("Verifying valid username shows with welcome text");
		String expectedUser = "Welcome Admins";
		String actualUser = dashboard.welcome.getText();
		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}

	//@Test(groups="regression")
	public void invalidPasswordLogin() {
		test.info("Adding valid username and invalid password");
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "uiuguig");
		click(login.loginBtn);
		test.info("Validating Invalid credentials error message is displayed");
		String expected = "Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}

	//@Test(groups="regression")
	public void emptyUsernameLogin() {
		// LoginPageElements login = new LoginPageElements();
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		String expected = "Username cannot be empty";

		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}
	
	@Test
	public void timeStamp() {
		Date d=new Date();
		System.out.println(d.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		System.out.println(sdf.format(d.getTime()));
		
	}
}