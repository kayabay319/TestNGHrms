package com.hrms.testcases;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.scanner.Constant;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {

	@Test(dataProvider = "userDataFromExcel", groups = { "homework", "addEmp", "regression" })
	public void addEmployee(String firstName, String lastName, String username, String password) {
		// System.out.println(firstName + " " + lastName + " " + username + " " +
		// password);

		// login into HRMS
		login.loginpar(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		// navigate to Add Employee page
		dashboard.navigateToAddEmployee();
		wait(1);

		// add employee information
		sendText(addEmp.empFirstname, firstName);
		sendText(addEmp.empLastname, lastName);
		// get EmployeeID
		String expectedEmpId = addEmp.empId.getAttribute("value");

		// click on Create Login Details
		click(addEmp.chkLoginDetails);
		wait(1);
		sendText(addEmp.userName, username);
		sendText(addEmp.confirmPassword, password);
		sendText(addEmp.confirmPassword, password);
		wait(1);
		jsClick(addEmp.save);
		wait(1);

		// validation
		waitForVisibility(pdetails.lblPersonalDetails);
		String actualEmpId = pdetails.employeeId.getAttribute("value");
		Assert.assertEquals(actualEmpId, expectedEmpId, "Employee ID did not match!");

		// take screenshot
		takeScreenshot(firstName + "_" + lastName);
	}

	@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] data = { { "Rajma", "Capoora", "raj123435345", "AmirKhan_@123" },
				{ "John", "Smith", "john123", "AmirKhan_@123" }, { "Mary", "Ann", "mary123", "AmirKhan_@123" },
				{ "Rohani", "Sakhi", "rohani123", "AmirKhan_@123" }, { "Ali", "Tarlaci", "ali123", "AmirKhan_@123" }, };
		return data;
	}

	@DataProvider(name = "userDataFromExcel")
	public Object[][] getData2() {
		return ExcelUtility.excelIntoArray(Constants.TESTDATA_FILEPATH, "EmployeeLoginCredentials");
	}
}