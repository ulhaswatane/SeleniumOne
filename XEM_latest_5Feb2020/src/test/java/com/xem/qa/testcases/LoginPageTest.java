package com.xem.qa.testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xem.qa.base.TestBase;
import com.xem.qa.pages.HomePage;
import com.xem.qa.pages.LoginPage;

import com.xem.qa.util.Log4jUtil;


public class LoginPageTest extends TestBase{
	static Logger Log=LogManager.getLogger(Log4jUtil.class);
	LoginPage loginPage;
	//HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		//Log.info("Browser is initialze");
		
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginTest()
	{
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Log.info("successfully login");
	}
	
	
}
