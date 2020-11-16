package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProDemo {
	
	//@DataProvider("getData") // or you can just past the dataprovider inside your @Test
	
	@Test(dataProvider = "getData")
	public void addEmp (String fName, String mName, String lName) {
		System.out.println(fName+" "+mName+" "+lName);
	}
	
	
	@DataProvider     //you can give a name also to @DataProvider (name="test")
	public Object [][] getData() {
		
		Object [][] data = {
				{"Sarmed", "H", "Halabi"}, //1 set of data
				{"Fadwa", "A", "Fadwa"},
				{"Adile", "K", "Karadeniz"}	
		};
		
		return data;
	}
}
