package com.hrms.testbase;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass {

	public static WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)   //To make this method run before every @Test method
	public static WebDriver setUp() { // initialize driver and navigate to specific url

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH); // Constants class gives access to Congif
	    
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");															// FilePath to read our property file

	    
		switch (ConfigsReader.getProperty("browser").toLowerCase()) { // to get my browser before I need to read my
																		// properties file

		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko,driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supperted");
		}
		

		driver.manage().window().maximize(); //fullscreen 
		//set implicit wait
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url")); // to get the url
	
       // driver.manage().deleteAllCookies(); //ben kendim ekledim
		
		//initialize all page objects as part of set up
		PageInitializer.initialize();    //PageInitializer is a class and has a method initialize we called by the claas name bec it is static
		
		return driver;  //return statement has to be last
      
		
	}
    //this alwaysRun regardless of the condition will run
	@AfterMethod(alwaysRun=true)  //To make this method run after every @Test method
	public static void tearDown() { // to clean our browser . Everytime when we open browser we want to close it.

		if (driver != null) { // i dont want to get NullPointer Exception, so I wnat to verify
			driver.quit();
		}
	}
	
//	public static void ChromeLogProperty() {
//	System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
//	}
}