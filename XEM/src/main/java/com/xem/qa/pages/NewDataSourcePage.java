package com.xem.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.xem.qa.base.TestBase;
import com.xem.qa.util.TestUtil;

public class NewDataSourcePage extends TestBase {

	
	String ActualTitle = "New Source";
	WebDriverWait wait;
	DataStrategyPage dataStrategyPage;
	static TestUtil testUtil;
	String names=prop.getProperty("namefromIngestClass");
	
	
	@FindBy(xpath = "//a/span[contains(text(),'Data Sources')]")
	WebElement DataSourceLink;

	// @FindBy (xpath="//div[@class='digest-sources popup-inner-block-bg altStyle
	// height-stretch scroll-x']/preceding::/div[1]")
	// WebElement AddNewDataSource;

	// @FindBy(xpath = "//*[normalize-space(text()'Add'])[5]/following::div[11]")
	@FindBy(xpath = "/html/body/div[2]/div[5]/div/div/main/section[46]/div[5]/div[1]/div[2]/div/div[1]/div[1]")
	WebElement AddNewDataSource;

//verify page text New source	
	@FindBy(xpath = "//div/h4[contains(text(),'New Source')]")
	WebElement NewDataSource;

//
	@FindBy(xpath = "//input[@name='taskJobName']")
	WebElement NewDataSourceName;

	@FindBy(xpath = "//textarea[@name='taskJobDescription']")
	WebElement NewDataSouceDiscription;

	@FindBy(xpath = "//section[@id='digestSourceComposeWidget']/div[2]/div/div[2]/div[2]/form/div[5]/div/span")
	WebElement DoNotPerformMatchingforthisDataSourceRadioBtn;

	@FindBy(xpath = "//input[@name='taskJobCronExpression']")
	WebElement setFrequency;

	// select Expected Frequency
	@FindBy(xpath = "//section[@id='digestSourceComposeWidget']/div[2]/div/div[2]/div[2]/form/div[7]/div/select")
	WebElement selectExpectedFrequency;

	// Enter Email Adress
	@FindBy(xpath = "//input[@name='emailAddresses']")
	WebElement EmailAdress;

	// Select Sample File

	@FindBy(xpath = "//div/label[contains(text(),'Sample File')]/following::div[2]")
	WebElement SelectSampleFile;
	
	

	
//Select Data Source file from Archive
	public void SelectDataSourceFile() throws InterruptedException {

		try {
		List<WebElement> FileList = driver.findElements(By.xpath("//div[@class='name']"));
		

		for (int i = 0; i < FileList.size(); i++) {
			String SampleFileName = FileList.get(i).getText();
			if (SampleFileName.equals("--Selenium Data Source")) {
				FileList.get(i).click();
				Thread.sleep(5000);
			}
			List<WebElement> ArchiveList = driver.findElements(By.xpath("//div[@class='name']"));

			for (int j = 0; j < ArchiveList.size(); j++) {
				String ArchiveList1 = ArchiveList.get(j).getText();
				if (ArchiveList1.equals("SeleniumDataSource.csv")) {
					ArchiveList.get(j).click();
					break;
				}

			}
		}
	}catch(StaleElementReferenceException e) {
	}
	}
	
	@FindBy(xpath = "//div/button[contains(text(),'Ok')]")
	WebElement PreviewOkBtn;
	
	@FindBy(xpath = "//div/button[contains(text(),'Done')]")
	WebElement DoneBtn;
	
	@FindBy(xpath = "//div[@title='Next']")
	WebElement nextBtn;
	
	@FindBy(xpath="//h4[contains(text(),'Things')]/parent::div")
	WebElement thingsBtn;
	
	

	@FindBy(xpath = "//select[@name='classSets']")
	WebElement selectDataset;
	
	
	@FindBy(xpath = "//div/button[contains(text(),'Create')]")
	WebElement CreatClassBtn;
	

	public NewDataSourcePage() {
		PageFactory.initElements(driver, this);
	}

	public void CreateNewDataSourcePage() throws InterruptedException {

		
		Thread.sleep(5000);
		DataSourceLink.click();

		Thread.sleep(5000);
		AddNewDataSource.click();

		Thread.sleep(3000);
		NewDataSourceName.getText();

		Thread.sleep(3000);
		NewDataSourceName.sendKeys("SeleniumTest");

		Thread.sleep(3000);
		NewDataSouceDiscription.sendKeys("Selenium Data Source File");

		Thread.sleep(3000);
		DoNotPerformMatchingforthisDataSourceRadioBtn.click();

		Thread.sleep(3000);
		setFrequency.sendKeys("");

		Thread.sleep(3000);
		Select drop = new Select(selectExpectedFrequency);
		drop.selectByVisibleText("DAILY");

		EmailAdress.sendKeys("uwatane@r4.ai");

		Thread.sleep(5000);
		SelectSampleFile.click();

		Thread.sleep(5000);
		SelectDataSourceFile();

		Thread.sleep(5000);
		PreviewOkBtn.click();

		Thread.sleep(5000);
		DoneBtn.click();
		

		Thread.sleep(5000);
		nextBtn.click();
		
		Thread.sleep(5000);
		thingsBtn.click();
		
		Thread.sleep(5000);
		Select classSet=new Select(selectDataset);
	
		classSet.selectByVisibleText(names);
		Thread.sleep(2000);
		
		
//		Select storage=new Select(selectDataset);
//		storage.selectByVisibleText("SubclassForDataSource");
//		
		Thread.sleep(2000);
		CreatClassBtn.click();

	

	}

}
