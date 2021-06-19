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
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	WebElement changebtn;
	
	@FindBy(name="Duplicate")
	WebElement Duplicate;
	
	@FindBy(name="Edit")
	WebElement Edit;
	
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
	
	@FindBy(linkText="EDFG Group Limited")
	WebElement acctname;
	
	@FindBy(linkText="Elizabeth Brown")
	WebElement contname;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	WebElement agnbtn;
	
	@FindBy(name="recurringtype")
	WebElement rtype;
	
	@FindBy(name="duration_hours")
	WebElement hours;
	
	@FindBy(name="parent_type")
	WebElement parent_type;
	
	@FindBy(name="eventstatus")
	WebElement eventstatus;
	
	@FindBy(name="Button")
	WebElement cbtn;
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement description;
	
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
		cm.EnterValue(driver, name, nam,"Contact name");
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
	
	public void EditActivity(String val, String hval, String ptype, String estatus, String des) throws InterruptedException
	{
		cm.ClickElement(driver, ClientMeeting,"'Client Meeting'");
		cm.ClickElement(driver, Edit,"Edit Button");
		cm.ClickElement(driver, agnbtn, "Assinged to Team");
		cm.SelectByValue(driver, rtype, val, "Recurring Event");
		cm.EnterValue(driver, hours, hval, "Duration");
		cm.SelectByValue(driver, parent_type, ptype, "Parent type");
		Thread.sleep(2000);
		cm.ClickElement(driver, changebtn, "Change button");
		Thread.sleep(2000);
		cm.ActionOnPopUpWindows(driver, acctname,"EDFG Group Limited");
		cm.SelectByVisibleText(driver, eventstatus, estatus, "Event Status");
		cm.ClickElement(driver, cbtn, "Change contact button");
		Thread.sleep(2000);
		cm.ActionOnPopUpWindows(driver, contname, "Elizabeth Brown");
		cm.EnterValue(driver, description, des, "Description");
		cm.ClickElement(driver, btn,"Save Button");
		cm.AlertHandler(driver);
	}

}
