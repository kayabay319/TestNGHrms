package com.hrms.testcases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {

	@Test(priority =1)
	public void methodOne() {
	String expectTitle = "HRMS";
	String actualTitle = "HRMS";
	
	boolean tflag= true;
	boolean fflag=false;
	
	ArrayList<String> list1 = new ArrayList<>();
	list1.add("a");
	list1.add("b");
	

	ArrayList<String> list2 = new ArrayList<>();
	list2.add("a");
	list2.add("b");
	
	Assert.assertEquals(list1, list2,  "List are not equal");
	
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(actualTitle, expectTitle);
	sa.assertAll();//it will collect all the reports that fails
	
//	//first way to do
//	Assert.assertEquals(actualTitle, expectTitle);
//	
//	//2nd way if condition ile 
//	if(expectTitle.equals(actualTitle)) {
//		Assert.assertTrue(true);
//	}else {
//		Assert.assertTrue(false);
//	}
}
}