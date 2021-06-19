package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class ContactsPage extends HeaderPage{
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public ContactsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="salutationtype")
	WebElement sal;
	
	@FindBy(name="firstname")
	WebElement firstname;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="accountname")
	WebElement accountname;
	
	@FindBy(xpath="(//input[@name='firstname'])[2]")
	WebElement sfname;
	
	@FindBy(xpath="(//input[@name='lastname'])[2]")
	WebElement slname;
	
	@FindBy(xpath="//input[@name='btn1']")
	WebElement changebtn;
	
	@FindBy(linkText="EDFG Group Limited")
	WebElement acctname;
	
	@FindBy(name="leadsource")
	WebElement leadsource;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="mobile")
	WebElement mobile;
	
	@FindBy(name="homephone")
	WebElement homephone;
	
	@FindBy(xpath="(//input[@name='selected_id'])[1]")
	WebElement select;
	
	@FindBy(name="birthday")
	WebElement birthday;
	
	public void CreateNewContact(String salutation, String fname, String lname, String lsource, String tit, String mail, String ph, String mob, String hphone, String bday) throws InterruptedException
	{
		ClickNewContact();
		cm.SelectByValue(driver, sal, salutation, "Salutation type");
		cm.EnterValue(driver, firstname, fname, "First Name");
		cm.EnterValue(driver, lastname, lname, "Last Name");
		cm.ClickElement(driver, changebtn, "Chnage button");		
		Thread.sleep(1000);		
		cm.ActionOnPopUpWindows(driver, acctname,"EDFG Group Limited");
		cm.SelectByValue(driver, leadsource, lsource, "Lead Source");
		cm.EnterValue(driver, title, tit, "Title");
		cm.EnterValue(driver, email, mail, "Email");
		cm.EnterValue(driver, phone, ph, "Phone");
		cm.EnterValue(driver, mobile, mob, "Mobile");
		cm.EnterValue(driver, homephone, hphone, "Home Phone");
		cm.EnterValue(driver, birthday, bday, "Date of Birth");
		ClickSaveButton();
		
	}
	public void ContactSearchAndDelete(String fname, String lname, String aname)
	{
		ClickContacts();
		cm.EnterValue(driver, sfname, fname, "First Name");
		cm.EnterValue(driver, slname, lname, "Last Name");
		cm.EnterValue(driver, accountname, aname, "Account Name");
		ClickSearchButton();
		cm.ClickElement(driver, select, "Contact checkbox");
		ClickDeleteButton();
		
	}
	

}
