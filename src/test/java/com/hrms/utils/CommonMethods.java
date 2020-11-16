package com.hrms.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer { // we need the object of webDriver so we extends from BaseClass

	/**
	 * Method that clears and sends keys
	 * 
	 * @param element
	 * @param text
	 */

	// function to send keys and text
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method checks if radio/checkbox is enabled and clicks it
	 * 
	 * @param radioOrcheckbox
	 * @param value
	 */

	// click radio or checkbox
	public static void clickRadioOrCheckbox(List<WebElement> radioOrcheckbox, String value) { // String value-->expected
																								// value(clicklememmiz
																								// gereken deger)

		String actualValue; // actualValue-->coming from our actual element

		for (WebElement el : radioOrcheckbox) {
			actualValue = el.getAttribute("value").trim(); // retrieve value then compare value match (value='Option1')
			if (el.isEnabled() && actualValue.equals(value)) { // if the actualValue = to value that we pass as a
																// parameter)
				el.click();
				break;
			}

		}
	}

	/**
	 * Method that checks if text is there and selects it
	 * 
	 * @param element
	 * @param textToSelect
	 */

	// selecting dropdown values using text

	public static void selectDdValue(WebElement element, String textToSelect) {

		try { // if I do not want to get UnExpectedTagNameException i have to inlcude try and
				// catch exception
			Select select = new Select(element); // once we have the element and pass it here
			List<WebElement> options = select.getOptions(); // get all the options

			// loop through each option and get text from each option
			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect); // preferable selectByVisibleText inside the options
																// because all options are writtena as text and this one
																// is tercih edilir
					break;

				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Method that selects value by index
	 * 
	 * @param element
	 * @param index
	 */

	// selecting dropdown values using index

	public static void selectDdValue(WebElement element, int index) { // index is last choice if dd dont have value
																		// oldugunda en son secim olmali

		try {

			Select select = new Select(element);
			int size = select.getOptions().size();

			if (size > index) { // eliminating NoSuchElementException istemedigimiz icin
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methods that accept alerts and catches exception if alert is not present
	 */

	// Handle Alerts
	public static void acceptAlert() {

		try { // I am going to switch to alert , if alert is not there catch the exception
			Alert alert = driver.switchTo().alert();
			alert.accept(); // if the alert is not there so we can handle the exception by try ad catch
							// block

		} catch (NoAlertPresentException e) { // if the alert is not there it will give exception
			e.printStackTrace();
		}
	}

	/**
	 * Methods that dismiss alerts and catches exception if alert is not present
	 * 
	 */

	public static void dismissAlert() {      //clicking cancel gibi 

		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss(); // if the alert is not there we can dismiss the alert

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Methods that gets text of alert and catches exception if alert is not present
	 *  
	 * @return String alert text
	 * 
	 */

	// get text alert
	public static String getAlertText() {

		String alertText = null; // declare here (local variable becuse inside the method)

		try {
			Alert alert = driver.switchTo().alert(); // switch to alert
			alertText = alert.getText(); // if alert is there get the text and store it into alerText;
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;

	}

	/**
	 * 
	 * Methods that sends text to alert and catches exception if alert is not
	 * present
	 * 
	 */

//send text alert  
	public static void sendAlertText(String text) {

		try {
			Alert alert = driver.switchTo().alert(); // switch to alert
			alert.sendKeys(text); // if alert is there get the text and store it into alerText;
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();

		}

	}

	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();

		}
	}

//switch to frame by index
	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();

		}
	}

	/**
	 * This method switches focus to child window
	 */

	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();   //get the iD=handle of Parent window
		Set<String> windows = driver.getWindowHandles(); //store all the child windows handles into set and loop through each child window handle or ID
		for (String window : windows) {
			if (!window.equals(mainWindow)) {   //if window is not = Parent window then switch to that child window
				driver.switchTo().window(window);
				break;
			}
		}
	}
   
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME); // create the obj of WebDriverWait
																						// and return as WebDriverWait
		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {  //wait until clickable
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForVisibility(WebElement element) {  //wait until element visible
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	           //get the WebDriver wait.until(ExpectedConditions)
	}

	public static void click(WebElement element) {
		waitForClickability(element); // call the method waitForClickability
		element.click();

	}
	/**
	 * This method will create object of a JavaSriptExecutor and downcasting driver.
	 * @return
	 */
	//create the obj of JavaScript Type
	public static JavascriptExecutor getJSObject() {  //this methods gives-->obj of JavaScriptExecutor
		JavascriptExecutor js =(JavascriptExecutor)driver;   //create obj of JSExecutor and downcasting driver
		return js;
	}
	
	/**
	 * This method will click the desired element.
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();",element); //take this element with argument[0] index and clcik
	}
	
	/**
	 * This method will go or to the desired element
	 * @param element
	 */
	public static void scrollToElement(WebElement element) {  //scroll to element
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}	
	
	
    /**
     * Method that will scroll the page down based on the passed pixel parameters
     * @param pixel
     */

	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," +pixel+ ")");
	}
	
	
	 /**
     * Method that will scroll the page up based on the passed pixel parameters
     * @param pixel
     */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" +pixel+ ")");
	}	
	
	
	/**
	 * This method will take a screenshot
	 * @param filename
	 */
	
	public static String takeScreenshot(String filename) { // we need a file
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE); //we have file 
		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp()+" .png";//where is my file. we want to place in destinationfile
		
		try {
			FileUtils.copyFile(file, new File(destinationFile));//attached the screenshot to destinatinFile here
		} catch (Exception ex) {
			System.out.println("Cannot take acreenshot!");
		}
		return destinationFile;
	}
	
	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
	}
	

	/**
	 * This method handles Thread.sleep and wait in desired seconds
	 * @param second
	 */
	public static void wait(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void isDisplay(WebElement element) { //i did this function
		boolean displayText = element.isDisplayed();
		String text = element.getText();
		if (displayText) {
			System.out.println(text + " is displayed. Test case is pass.");
		} else {
			System.out.println(text + " is NOT display. Test case is fails.");
		}
	}
}
	
