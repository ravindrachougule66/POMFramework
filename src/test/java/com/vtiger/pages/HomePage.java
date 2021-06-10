package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class HomePage extends HeaderPage{
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'My Upcoming and Pending')]")
	WebElement myupcomingandpending;
	
	
	public boolean VerifyMyUpcomingandPending()
	{
		return cm.IsElementPresent(driver, myupcomingandpending,"My Upcoming and Pending Activities");
	}
	
}
