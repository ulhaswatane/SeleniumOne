package com.xem.qa.testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class sauceLabDemo {

	
	public static final String USERNAME="suraj.shejwal";
	public static final String ACCESS_KEY="c2a286dc-b61c-4d49-91fe-85eec44d9e38";
	public static final String URL="http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	public static void main(String[] args) throws Exception {
		
		ChromeOptions caps = new ChromeOptions();
	    caps.setCapability("platform", "Windows 7");
	    caps.setCapability("version", "64.0");
	    caps.setCapability("name", "loginTest");
	    
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    driver.get("https://r4-qa.r4cloud.com/R4Portal/Wilbur/portal.html");
	    driver.findElement(By.xpath("//input[@id='login_name']")).sendKeys("testuser-admin");
	    driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("QAPasscode 123!");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[@value='login']")).click();
	    driver.quit();
	    System.out.println("Test is completed");
	}

}
