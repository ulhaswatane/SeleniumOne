package com.xem.qa.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.xem.qa.base.TestBase;

import org.apache.commons.io.FileUtils;


public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT= 20;
	public static long IMPLICIT_WAIT= 10;
	//public static Properties prop;
	
	
	public void getScreenshot() throws IOException
	{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("C:\\Users\\uwatane\\eclipse-workspace\\XEM_latest_30jan2020\\screenshot.png"));
         
	
            
	}
	public static String getCurrentDateTimeInGivenTimeZone(String timeZone) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		//System.out.println("UTC Time is: " + dateFormat.format(date));
		return dateFormat.format(date).toString();
	}

	public static String getClassName() throws IOException {
		String name = "NewSelenium "+getCurrentDateTimeInGivenTimeZone("EST");
		FileOutputStream op=new FileOutputStream("C:\\Users\\sshejwal\\OneDrive - R4 Technologies, LLC\\Desktop\\XEM_latest_30jan2020\\src\\main\\java\\com\\xem\\qa\\config\\config.properties");
		prop.setProperty("namefromIngestClass", name);
		prop.store(op, null);
		op.close();
		return name;
	}
	
	public static String getSubClassName(String name)	{
		String subClassName = "Sub Class "+name;
		return subClassName;
	}
}
