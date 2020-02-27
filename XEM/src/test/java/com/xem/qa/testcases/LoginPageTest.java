package com.xem.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xem.qa.base.TestBase;
import com.xem.qa.pages.LoginPage;
import com.xem.qa.util.Log4jDemo;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	//HomePage homePage;
	static Logger Log=LogManager.getLogger(Log4jDemo.class);
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginTest()
	{
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Log.info("browser launched successfully");
	}
}
