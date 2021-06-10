package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class ActivitiesPage extends HeaderPage{
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	
	public ActivitiesPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="subject")
	WebElement subject;
	
	@FindBy(name="name")
	WebElement name;
	
	@FindBy(xpath="//input[@name='date_start']")
	WebElement datestart;
	
	@FindBy(xpath="//input[@name='time_start']")
	WebElement timestart;
	
	@FindBy(xpath="//input[@name='due_date']")
	WebElement duedate;
	
	@FindBy(xpath="(//input[@name='button'])[2]")
	WebElement btn;
	
	@FindBy(name="Duplicate")
	WebElement Duplicate;
	
	@FindBy(xpath="(//input[@name='button'])[3]")
	WebElement searchbtn;
	
	@FindBy(xpath="(//input[@name='selected_id'])[1]")
	WebElement selevent;
	
	@FindBy(xpath="(//input[@name='selected_id'])[8]")
	WebElement sel;
	
	@FindBy(xpath="(//input[@type='submit'])[4]")
	WebElement delbtn;
	
	@FindBy(linkText="Client Meeting")
	WebElement ClientMeeting;
	
	public void createNewEvent(String sub) throws InterruptedException
	{
		ClickNewEvent();
		cm.EnterValue(driver, subject, sub,"Subject");
		cm.ClickElement(driver, datestart,"Start date");
		cm.ClickElement(driver, timestart,"Start time");
		cm.ClickElement(driver, duedate,"End date");
		cm.ClickElement(driver, btn,"Save Button");
	}
	
	public void SearchActivities(String nam)
	{
		ClickActivities();
		cm.EnterValue(driver, name, nam,"Name");
		cm.ClickElement(driver, searchbtn,"Search Button");	
	}
	
	public void DeleteActivities()
	{
		ClickActivities();
		cm.ClickElement(driver, sel,"Select Button");
		cm.ClickElement(driver, delbtn,"Delete Button");	
	}
	
	public void DuplicateActivity()
	{
		cm.ClickElement(driver, ClientMeeting,"'Client Meeting'");
		cm.ClickElement(driver, Duplicate,"Duplicate Button");
		cm.ClickElement(driver, btn,"Save Button");	
	}

}
