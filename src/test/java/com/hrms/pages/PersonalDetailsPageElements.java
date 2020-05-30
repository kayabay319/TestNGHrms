package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {

	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;

	@FindBy(name = "personal[optGender]") // male ve female both have common name when we inspect we use by name
	public List<WebElement> genderRadioGroup; // store as in list

	
	@FindBy(xpath="//div[@id='pdMainContainer']/div[1]/h1")
	public WebElement lblPersonalDetails;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement employeeId;
	
	
	
	public PersonalDetailsPageElements() { // constructor to initialize elements
		PageFactory.initElements(BaseClass.driver, this); // we initialize all elements at once by help of
															// PageFactory(is aclass supports POM)
	}

}  

