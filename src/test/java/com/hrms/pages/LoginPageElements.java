package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class LoginPageElements extends CommonMethods {
	// Not using PageFactory, You have to extend CommonMethods or BaseClass
	// public WebElement username2=driver.findElement(By.id("txtUsername"));

	// Using PageFactory and @FindBy Annotation
	@FindBy(id = "txtUsername")
	public WebElement username;  //if I want to make private --->private WebElement username; olur.
                                 //Then if its private, I have to get-->public getters and setters metodunu(Line 39and 42)
	@FindBy(name = "txtPassword")
	public WebElement password;

	@FindBy(css = "input#btnLogin")
	public WebElement loginBtn;

	@FindBy(xpath = "//div[@id='divLogo']/img")
	public WebElement logo;

	@FindBy(id = "spanMessage")
	public WebElement errorMsg;

	public LoginPageElements() {        //initialtize the all the elements of LOginPageElements 
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	//if we would be keeping elements as private
	//Then we will need to create public getters and setters metodu
	//so we can access page elements from the test classes
	
	//setter 
	public void sendUsername(String uid) { 
		sendText(username, uid);
    }
	//getter
	public WebElement getUsername() {  
		return username;
	
    }	
	//this method is to login the HRMS website
	public void login(String uid, String pwd) { //to login we new username(uid) and password(pwd)
		sendText(username, uid);
		sendText(password, pwd);
		click(loginBtn);
		
	}
	
    }
