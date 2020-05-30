package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class OrangeHRMSelfPage extends CommonMethods {

	@FindBy(id = "txtUsername")
	public WebElement txtUsername;

	@FindBy(id = "txtPassword")
	public WebElement txtPassword;

	@FindBy(id = "btnLogin")
	public WebElement loginBtn;

	@FindBy(id = "spanMessage")
	public WebElement errMsg;

	public OrangeHRMSelfPage() {
		PageFactory.initElements(driver, this);
	}

}
