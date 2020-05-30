package com.hrms.testcases;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	//in ervey single test case we have to use assertion
	@BeforeMethod
	public void openBrowser() {
		setUp();
		initialize();   //initialze all pages at once
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	
	@Test(groups="smoke")
	public void validAdminLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		//DashboardPageElements dashboard = new DashboardPageElements();
		String expectedUser ="Welcome Admin"; //the one should be inside the webpage
		String actualUser = dashboard.welcome.getText(); //actual comes from our application
		Assert.assertEquals(actualUser, expectedUser, "Admin NOT Logged in");//verify string
		//verify boolean
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username"))); //actual user username i iceriyorsa 	
	}
	@Test(groups="regression")
	public void invalidPasswordLogin () {  //Negative Login
		//LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "glglhf");
		click(login.loginBtn);
		
		String expected = "Invalid credentials";
		
		//actual coming from the application , expected always comes from the userstory
		Assert.assertEquals(login.errorMsg.getText(), expected,"Error message text is NOT matched");
	}
	
	//Negative Login 
	@Test(enabled=true)  
	public void emptyUsernameLogin () { //live the username empty, write valid password then click login
		LoginPageElements login = new LoginPageElements();
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		String expected ="Username cannot be empty";
		Assert.assertEquals(login.errorMsg.getText(),expected, "Error message text is NOT matched");
		
	}
	
}
