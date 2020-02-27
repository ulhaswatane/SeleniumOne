package com.xem.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xem.qa.base.TestBase;
import com.xem.qa.pages.DataStrategyPage;
import com.xem.qa.pages.HomePage;
import com.xem.qa.pages.LoginPage;
import com.xem.qa.util.Log4jDemo;
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
	public void createNewClass() throws Exception {
		TestUtil.IMPLICIT_WAIT=60;
		dataStrategyPage=new DataStrategyPage();
		dataStrategyPage.createNewIngestClass();
		testLog();
	}
	
	/*
	 * @AfterMethod public void close() { tearDown(); }
	 */
	
	
	
	
}
