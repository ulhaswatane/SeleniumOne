package com.xem.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.xem.qa.base.TestBase;
import com.xem.qa.pages.HomePage;
import com.xem.qa.pages.LoginPage;
import com.xem.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	test = report.startTest("ExtentDemo");
	}
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil =new TestUtil();
		loginPage = new LoginPage();
		homePage = 	loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=0)
	public void searchTest() throws IOException
	{
	
		testUtil.getScreenshot();
		homePage.Search();
		
	}
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
}
