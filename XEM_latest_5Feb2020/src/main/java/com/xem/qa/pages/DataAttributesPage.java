package com.xem.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.xem.qa.base.TestBase;
import com.xem.qa.util.TestUtil;

public class DataAttributesPage extends TestBase {
	// static TestUtil testUtil;

	@FindBy(xpath = "//span[text()='Data Attributes']")
	WebElement dataAtrritutes;

	@FindBy(xpath = "//div[@click-bind='newModel()']")
	WebElement newModel;

	@FindBy(xpath = "//h4[text()='Things']")
	WebElement modelClassThings;

	@FindBy(xpath = "//span[text()='CREATE A MODEL']/following::input")
	WebElement modelName;

	@FindBy(xpath = "//select[@placeholder='Select Class Set']")
	WebElement classSet;

	@FindBy(xpath = "//select[@placeholder='Select Dimension Type']")
	WebElement vectorType;

	@FindBy(xpath = "//div/button[contains(text(), 'Create')]")
	WebElement createBtn;

	public DataAttributesPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement clickOnDataAttributes() {
		return dataAtrritutes;
	}

	public WebElement clickOnNewModel() {
		return newModel;
	}

	public WebElement selectModelClass() {
		return modelClassThings;
	}

	public WebElement setMedelName() {
		return modelName;
	}

	public WebElement selectClassSet() {

		Select sel = new Select(classSet);
		sel.selectByVisibleText("NewSelenium");
		return classSet;
	}

	public WebElement selectVectorType() {

		Select sel = new Select(vectorType);
		sel.selectByVisibleText("Entity Vector");
		return vectorType;
	}

	public WebElement clickonCreate() {
	boolean actualValue=createBtn.isEnabled();
	if (actualValue) {
		System.out.println("Button is Enabled");
	}	else 
			{System.out.println("Button is Desabled");}
			
		return createBtn;
	}

}
