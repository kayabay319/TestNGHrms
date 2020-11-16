package com.hrms.testbase;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrms.utils.CommonMethods;

public class Listener implements ITestListener {
//	@Override
//	public void onStart(ITestContext context) {//this listener executes based on <test> from xml file
//		System.out.println("Functionality Testing Start");
//
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		System.out.println("Functionality Testing Finished");
//	}

	@Override
	public void onTestStart(ITestResult result) {//this listener executes when @Test method starts
		System.out.println("Test Started " + result.getName());
		BaseClass.test = BaseClass.report.createTest(result.getName()); //every time we create a test will obj. of create test
	   
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed " + result.getName());
		BaseClass.test.pass("Test Case Pass "+result.getName());
		 try {//everytime when we takescreenshot it will go to commonmethods and get screenshot
				BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("passed/"+result.getName())); //get the screenshot and attach the screenshot path to the report
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed " + result.getName());
		BaseClass.test.fail("Test Case Failed "+result.getName());
		 try {//everytime when we takescreenshot it will go to commonmethods and get screenshot and will be put into 
				BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("failed/"+result.getName())); //passed folderin we take screenshot
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}

}