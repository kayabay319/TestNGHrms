package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.DefinedPredefinedReports;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;


//initialize all pages class  and  stores refrences in static variables (give global access to all)
//that will be called/used in test classes
public class PageInitializer extends BaseClass {  //it initialize all the pages. We will be reusaing in our test classes

	//give a global access to visibility to our objects by using public static
	public static LoginPageElements login; //declare the variables 
	public static AddEmployeePageElements addEmp;
	public static DashboardPageElements dashboard;
	public static PersonalDetailsPageElements pdetails;
	public static DefinedPredefinedReports reports;
	
	public static void initialize () { //calling this method will be initialize the all of the pages
	    //inside the method here varaibles are initilazing
		login = new LoginPageElements(); //create an object oj loginpage and intantiate
		addEmp = new AddEmployeePageElements();
	    dashboard = new DashboardPageElements();
	    pdetails = new PersonalDetailsPageElements();
	    reports= new DefinedPredefinedReports ();
	
	}	
}
