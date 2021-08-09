package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vtiger.lib.commonfunctions;

public class NotesPage extends HeaderPage{
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public NotesPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@title='Change']")
	WebElement changebtn1;
	
	@FindBy(linkText="Elizabeth Brown")
	WebElement brown;
	
	@FindBy(linkText="Linda Williams")
	WebElement Linda;
	
	@FindBy(xpath="//input[@title='Change [Alt+G]']")
	WebElement changebtn2;
	
	@FindBy(name="title")
	WebElement subject;
	
	@FindBy(name="notecontent")
	WebElement notes;
	
	@FindBy(xpath="(//input[@name='button'])[2]")
	WebElement savebutton;
	
	public void CreateNewNote(String sub,String note)
	{
		ClickNewNote();
		cm.ClickElement(driver,changebtn1,"Change button");
		cm.ActionOnPopUpWindows(driver,brown,"Elizabeth Brown");
		cm.ClickElement(driver,changebtn2,"Change button");
		cm.ActionOnPopUpWindows(driver,Linda,"Linda Williams");
		cm.EnterValue(driver,subject,sub,"Subject");
		cm.EnterValue(driver,notes,note,"Note");
		cm.ClickElement(driver,savebutton,"save button");
	}

}
