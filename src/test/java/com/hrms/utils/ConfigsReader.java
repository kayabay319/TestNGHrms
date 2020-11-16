package com.hrms.utils;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader { // bring fileinputstream

	public static Properties prop;

	/**
	 * This method will read properties file
	 * 
	 * @param filePath
	 */

	 
	public static void readProperties(String filePath) { // this method read our properties files
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties(); // this prop holds key and value
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { // incase fis is close IQ Exception occurs
			e.printStackTrace();
		}

	}  

	/**
	 * This method will return value of specified key
	 * 
	 * @param String key
	 * @return String value
	 * 
	 */

	public static String getProperty(String key) { // I want this method returns me

		return prop.getProperty(key); // to return the value of that key

	}

}