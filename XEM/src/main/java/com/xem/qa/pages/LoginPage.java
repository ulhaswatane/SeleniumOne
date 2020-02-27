package com.xem.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xem.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy (xpath="//input[@id='login_name']")
	WebElement username;
	
	@FindBy (xpath="//input[@id='login_password']")
	WebElement password	;
	
	@FindBy (xpath="//button[@value='login']")
	WebElement loginBtn	;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname,String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
}
