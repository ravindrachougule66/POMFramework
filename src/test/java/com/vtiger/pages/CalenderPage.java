package com.vtiger.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class CalenderPage extends HeaderPage{
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public CalenderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	WebElement daybtn;
	
	@FindBy(xpath="(//input[@name='button'])[2]")
	WebElement weekbtn;
	
	@FindBy(xpath="(//input[@name='button'])[3]")
	WebElement monthtn;
	
	@FindBy(xpath="//td[@class='calhead']")
	WebElement calhead;
	
	@FindBy(linkText="08:00")
	WebElement appointment;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	WebElement Meeting;
	
	@FindBy(name="subject")
	WebElement sub;
	
	@FindBy(xpath="(//input[@name='button'])[4]")
	WebElement savebtn;
	
	
	public void SelectDayOfMonth()
	{
		ClickCalender();
		//cm.ClickElement(driver, daybtn, "Day");
		String val = calhead.getText();
		System.out.println(val);
	}
	public void SelectDWeekOfMonth()
	{
		cm.ClickElement(driver, weekbtn, "Week");
		String val = calhead.getText();
		System.out.println(val);
	}
	public void SelectMonthOfYear()
	{
		cm.ClickElement(driver, monthtn, "Month");
		String val = calhead.getText();
		System.out.println(val);
	}
	public void CreateNewAppointment(String subject)
	{
		cm.ClickElement(driver, appointment, "Create New Appointment");
		cm.ClickElement(driver, Meeting, "Meeting");
		cm.EnterValue(driver, sub, subject, "Subject");
		cm.ClickElement(driver, savebtn, "save button");
	}
}
