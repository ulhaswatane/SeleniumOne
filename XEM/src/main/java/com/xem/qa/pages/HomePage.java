package com.xem.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xem.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy (xpath="(.//*[normalize-space(text()) and normalize-space(.)='Data Attributes'])[1]/following::span[1]")
	WebElement searchLink;
	
	@FindBy (xpath="//div[@title='advanced search']")
	WebElement advanchSearch	;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public SearchPage Search()
	{
		searchLink.click();
		advanchSearch.click();
		
		return new SearchPage();
	}

}
