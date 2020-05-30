package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;

public class OrangeHRMSelfPageTest extends CommonMethods {
	
	@Test(dataProvider= "dataProvider")
	public void loginToOrangeHrms (String username, String password) {
     sendText(orangeHrmsPage.txtUsername, username);
     sendText(orangeHrmsPage.txtPassword, password);
     click(orangeHrmsPage.loginBtn);
     wait(2);
     if(username.equals("Username cannot be empty")) {
  	   Assert.assertTrue(orangeHrmsPage.errMsg.isDisplayed());
     }}
  	   //else {
//     Assert.assertTrue(orangeHrmsPage.headerText.isDisplayed());
//	}
     
     @DataProvider(name="dataProvider")
     public Object[][] setUpData() {
		Object[][]data= { { "Admin", "admin123"}, 
				         {"Admin", "Adim123"}
                          };
     return data;
     }
    
     }
     
	
