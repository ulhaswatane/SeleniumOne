package com.xem.qa.testcases;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.xem.qa.base.TestBase;
import com.xem.qa.pages.DataAttributesPage;
import com.xem.qa.pages.HomePage;
import com.xem.qa.pages.LoginPage;

import com.xem.qa.util.Log4jUtil;
import com.xem.qa.util.TestUtil;

public class dataAttributesTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DataAttributesPage dataAttributes;
	ExtentReporter extendreport;
	static Logger logger=LogManager.getLogger(Log4jUtil.class);
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil =new TestUtil();
		loginPage = new LoginPage();
		homePage = 	loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("Login Successfully");
	}
	
	@Test
	public void VerefyCreationOfNewDataAttributes() {
		
		dataAttributes = new  DataAttributesPage ();
		
		dataAttributes.clickOnDataAttributes().click();
		logger.info("Clicked on DataAttribute");
		
		dataAttributes.clickOnNewModel().click();
		logger.info("Clicked on NewModel link");
		
		dataAttributes.selectModelClass().click();
		logger.info("Clicked on model class");
		
				
		dataAttributes.setMedelName().sendKeys("Selenium Test Oject2");
		logger.info("New Model Name inserted");
		
		dataAttributes.selectClassSet();
		logger.info("Class set selected from list");
		
		dataAttributes.selectVectorType();
		logger.info("Vector Type Selected fromlist ");
		
		dataAttributes.clickonCreate().click();
		logger.info("New Attribute successfully created");
	}
	
	@AfterMethod
	public void flush() {
		driver.quit();
		
	}
}
