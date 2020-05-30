package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {

	@BeforeMethod
	public void openBrowser() {
		setUp();
		initialize();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
	@Test
	public void addEmployeePage() {
	login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password")); //(String username, String pwd)
	//login-->obj of class, login()-->method
	dashboard.navigateToAddEmployee();
	wait(7);

	
//		sendText(addEmp.firstN, ConfigsReader.getProperty("empFirstname"));
//		sendText(login.password, ConfigsReader.getProperty("empLastname"));
//		sendText(addEmp.choosePhoto,ConfigsReader.getProperty("filePath"));
//		click(addEmp.saveBtn);
//		
	//Add assertion to verify that employee has been added successfully
	
	}

	
		
	}
	
