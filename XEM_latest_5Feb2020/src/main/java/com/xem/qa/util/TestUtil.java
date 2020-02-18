package com.xem.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.xem.qa.base.TestBase;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT= 20;
	public static long IMPLICIT_WAIT= 30;
	
	public static String TESTDATA_SHEET_PATH="";
	static Workbook book;
	static Sheet sheet;
	
	public void getScreenshot() throws IOException
	{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("C:\\Users\\uwatane\\eclipse-workspace\\XEM_latest_5Feb2020\\screenshot.png"));
         
	
            
	}
	public static String getCurrentDateTimeInGivenTimeZone(String timeZone) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        //System.out.println("UTC Time is: " + dateFormat.format(date));
        return dateFormat.format(date).toString();
    }
	
	
	public static Object[][] getTestData(String SheetName){
		FileInputStream file=null;
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=book.getSheet(SheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getRow(0).getLastCellNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
			
		}
		return data;
	}
}
