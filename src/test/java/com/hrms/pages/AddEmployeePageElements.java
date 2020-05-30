package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

//Automate user stories below:
//US 12678 As an Admin I should be able to create login credentials while adding employee
//
//US 67789 As an admin while adding employee if I leave required fields empty I should see “Required” message
//Note: first name and last name are required fields 
public class AddEmployeePageElements extends CommonMethods {

	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	public WebElement addEmployee;

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "employeeId")
	public WebElement employeeId;

	@FindBy(id = "photofile")
	public WebElement choosePhoto;

	@FindBy(id = "chkLogin")
	public WebElement checkboxLoginDetails;

	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "user_password")
	public WebElement password;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;

	@FindBy(xpath = "//img[@id='empPic']")
	public WebElement verify;

	@FindBy(name = "status")
	public WebElement status;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;

	@FindBy(xpath="//span[@for='firstName']")//"Required"
	public WebElement requiredFirstNameErrMsg;
	
	@FindBy(xpath="//span[@for='lastName']")
	public WebElement requiredLastNameErrMsg;
	
	//Errormaessage= "Should have at least 5 characters"
	@FindBy(xpath="//span[@for='user_name']")
	public WebElement usernameErrorMsg;
	//Should have at least 8 characters
	@FindBy(xpath="//span[@for='user_password']")
	public WebElement passwordErrorMsg;
	
	@FindBy(xpath="//span[@for='re_password']")
	public WebElement confirmErrorMsg;
	

	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

//	public void employeeDetails(String firstname, String lastname) {
//	CommonMethods.sendText(firstN, firstname);
//	CommonMethods.sendText(lastN, lastname);
//    }
//		
	public void addEmployeeDetails(String firstname, String lastname) {
		sendText(firstName, firstname);
		sendText(lastName, lastname);
		//sendText(empID, empId);
		sendText(addEmp.choosePhoto, ConfigsReader.getProperty("filePath"));
		click(checkboxLoginDetails);
	}

	public void createLoginDetails() {  //I created this
		sendText(username, ConfigsReader.getProperty("username"));
		sendText(password,ConfigsReader.getProperty("password"));
		sendText(confirmPassword, ConfigsReader.getProperty("repassword"));
		Select select = new Select (status);
		select.selectByVisibleText("Enabled");
		click(saveBtn);
	
	}
	}


