package com.xem.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xem.qa.base.TestBase;
import com.xem.qa.pages.DataStrategyPage;
import com.xem.qa.pages.HomePage;
import com.xem.qa.pages.LoginPage;
import com.xem.qa.util.TestUtil;

public class IngestClassAndSubclassTest extends TestBase  {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
    DataStrategyPage dataStrategyPage;
    
	public IngestClassAndSubclassTest()
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
	
	@Test
	public void VerifyCreateNewClass() throws Exception {
	
		dataStrategyPage=new DataStrategyPage();
		dataStrategyPage.createNewIngestClass();
		//testLog();
	}
	
	/*
	 * @AfterMethod public void close() { tearDown(); }
	 */
	@AfterMethod
	public void flush() {
		driver.quit();
		
	}
	
	
	
}
