package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

//Automate user stories below:
//US 12678 As an Admin I should be able to create login credentials while adding employee
//
//US 67789 As an admin while adding employee if I leave required fields empty I should see “Required” message
//Note: first name and last name are required fields 

public class createLginCredentialsTest extends CommonMethods {
	
	@Test
	public void loginCredentials() {
	login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	dashboard.navigateToAddEmployee();
	addEmp.addEmployeeDetails(ConfigsReader.getProperty("firstName"),ConfigsReader.getProperty("lastName"),ConfigsReader.getProperty("empId"));
	addEmp.createLoginDetails();
	click(addEmp.createLogin);
	}
	
	@Test
	public void invalidLoginCredentials () {
	login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	dashboard.navigateToAddEmployee();
	addEmp.addEmployeeDetails(ConfigsReader.getProperty("firstName"),ConfigsReader.getProperty("lastName"),ConfigsReader.getProperty("empId"));
	
	click(addEmp.saveBtn);
	String expected = "Required";
	String actualFirst = addEmp.requiredFirstNameErrMsg.getText();
    String actualLast=addEmp.requiredLastNameErrMsg.getText();
    Assert.assertEquals(actualFirst, expected, "Error messages DO NOT Match.");
    Assert.assertEquals(actualLast, expected, "Error message Do NOT Match.");
	}
}
