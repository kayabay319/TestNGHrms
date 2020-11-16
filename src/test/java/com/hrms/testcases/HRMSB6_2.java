package com.hrms.testcases;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class HRMSB6_2 extends CommonMethods {
	
	@Test(dataProvider="getDataExcel")
	public void DefiningReport(String reportName, String selection, String selected, String fieldgroup, String displayfields) {
		test.info("Entering Valid Admin credentials");
		login.login();
		test.info("navigating to reports");
		dashboard.navigateToReports();
		test.info("defining 3 reports");
		reports.addrE.click();
		reports.reportName.sendKeys(reportName);
		reports.selectioncriteria.sendKeys(selection);
		wait(3);
		Select select = new Select (reports.selectedcriteriainclude);
	    select.selectByVisibleText(selected);
		
		//reports.selectDdValue(reports.selectedcriteriainclude, "Current and Past Employees");
		reports.displayFGroups.sendKeys(fieldgroup);
		reports.displayFields.sendKeys(displayfields);
		reports.addDisplayField.click();
        reports.btnsave.click();
	}  
	//@DataProvider
	public Object[][] getDataExcel() {
		return ExcelUtility.excelIntoArray(Constants.TESTDATA_FILEPATH, "AddReport");
	}
}


