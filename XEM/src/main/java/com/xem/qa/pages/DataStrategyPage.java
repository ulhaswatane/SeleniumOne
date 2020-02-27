package com.xem.qa.pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.xem.qa.base.TestBase;
import com.xem.qa.util.Log4jDemo;
import com.xem.qa.util.TestUtil;

public class DataStrategyPage extends TestBase{
	static Logger Log=LogManager.getLogger(Log4jDemo.class);
	static TestUtil testUtil;
	static String name;
	
	@FindBy (xpath="//span[contains(text(),'Data Strategy')]")
	WebElement dataStrategyLink;
	
	@FindBy (xpath="//*[@id=\"digestDataMapWidget\"]/div[2]/div/div[2]/button[1]")
	WebElement createNodeBtn;
	
	@FindBy (xpath="//body")
	WebElement openSpace;
	
	@FindBy (xpath="//span[text()='Name']//following::input[1]")
	WebElement newClassName;
	
	@FindBy (xpath="//span[text()='Name']//following::input[2]")
	WebElement newClassDescription;
	
	@FindBy(name="dialogMixedArray")
    WebElement newClassCatagory;
	
	@FindBy (xpath="//button[1][contains(text(),'OK')]")
	WebElement okBtn;
	
	@FindBy (xpath="//button[1][contains(text(),'Cancel')]")
	WebElement cancelBtn;
	
	public WebElement configureNodeBtn(String name) {

		String xpath = "//*[local-name()='svg'][1]//*[local-name()='g']/*[text()='"+name+"']//following-sibling::*[@class='dataMapNodeGear']//*[@class='configGearIconWrapper']";
		return driver.findElement(By.xpath(xpath));	
	}
	
	public WebElement addSubClassBtn(String name) {

		String xpath = "//*[local-name()='svg'][1]//*[local-name()='g']/*[text()='"+name+"']//following-sibling::*[@class='dataMapNodeGear toggleGearMenu']//child::*[@class='configGearMenu']//child::*[@class='configGearIcon'][2]";
		return driver.findElement(By.xpath(xpath));	
	}
	
	@FindBy (xpath="//*[@placeholder='Name for new Storage']")
	WebElement storageName;
	
	@FindBy (xpath="//span[contains(text(),'Select Storage type: ')]//following-sibling::*[@class='form-control dialog-bind']")
	WebElement storageType;
	
	@FindBy (xpath="//span[contains(text(),'Select exist Storage: ')]//following-sibling::*[@class='form-control dialog-bind']")
	WebElement existingStorageType;
	
	@FindBy (xpath="//div/button[contains(text(),'Create')]")
	WebElement createBtn;
	
	@FindBy (xpath="//button[contains(text(),'Select')]")
	WebElement selectBtn;

	public DataStrategyPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void createNewIngestClass() throws InterruptedException, IOException
	{
		name = TestUtil.getClassName();
		Thread.sleep(5000);
		dataStrategyLink.click();
		Log.info("successfully redirected to Data Strategy page");
		Thread.sleep(2000);
		
		createNodeBtn.click();
		Thread.sleep(2000);
		
		openSpace.click();
		Thread.sleep(2000);
		
		newClassName.sendKeys(name);
		Thread.sleep(2000);
		
		newClassDescription.sendKeys(name);
		Thread.sleep(2000);
		
		Select select=new Select(newClassCatagory);
		select.selectByIndex(2);
		Thread.sleep(2000);
		
		okBtn.click();
		Thread.sleep(5000);
		
		
		Actions action = new Actions(driver);
		action.moveToElement(configureNodeBtn(name)).click().perform();
		Thread.sleep(5000);
		action.moveToElement(addSubClassBtn(name)).click().perform();
		Thread.sleep(5000);
		driver.switchTo().activeElement();
		Thread.sleep(5000);
		storageName.sendKeys(name);

		
		Select selectStorage=new Select(storageType);
		selectStorage.selectByIndex(0);
		Thread.sleep(2000);
		
		createBtn.click();
		//Select existing Storage Type
		//Select selectExistingStorage=new Select(existingStorageType);
		//selectExistingStorage.selectByIndex(1);
		//Thread.sleep(2000);
		
		//selectBtn.click();
		Log.info("Ingest class created successfully");
	}
	

    
}
