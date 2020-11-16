package com.hrms.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility { // reads from excel and return as like map, or array

	//class variables
	private static Workbook book;
	private static Sheet sheet;

	// to open the excel //String filePath
	private static void openExcel(String filePath) {
		try {
		FileInputStream fileIS = new FileInputStream(filePath);//create an InputStream
		book = new XSSFWorkbook(fileIS);   //load and read the fileIS and stored into a sheet
		}catch(IOException e) { //this IOEXception will catch both of FileInput and FileIs
			e.printStackTrace();
		}
	}
    
	private static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	//gives Number of Rows
	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
    //how many cols or cells in that specific row
	private static int colsCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum(); // it will return me how many cell and rows in it
	}

	// to get or return me a specific a cell data(exp;I need 2.row, 4th cols data)
	private static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	// return me 2D Array of data. This will read the excel,
	public static Object[][] excelIntoArray(String filePath, String sheetName) { //to open a specific file we need fileName(path), sheetname)
    	//to read the excell
		openExcel(filePath); 
		//load the sheet inside this excel file
    	loadSheet(sheetName);
    	 
    	int rows =rowCount();
    	int cols = colsCount(0);
    	
    	Object[][]data = new Object[rows-1][cols]; //rows-1 taking out the header
    	//iterate all rows
    	for(int i=1; i<rows; i++) {
    		
			// iterate cols
			for (int j = 0; j < cols; j++) {
				//data has to start from 0
				data[i - 1][j] = cellData(i, j);
			}
		}
		return data;
	}
	//hw create a method that will return a List of Maps
}
