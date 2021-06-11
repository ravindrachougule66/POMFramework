package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vtiger.lib.commonfunctions;

public class LeadPage extends HeaderPage{
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public LeadPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	WebElement lname;
	
	@FindBy(name="company")
	WebElement comp;
	
	@FindBy(name="button")
	WebElement save;
	
	@FindBy(name="firstname")
	WebElement fname;
	
	@FindBy(name="salutationtype")
	WebElement sal;
	
	@FindBy(name="lead_status")
	WebElement lead_status;
	
	@FindBy(name="designation")
	WebElement designation;
	
	@FindBy(name="mobile")
	WebElement mobile;
	
	@FindBy(name="lane")
	WebElement lane;
	
	@FindBy(name="code")
	WebElement code;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="country")
	WebElement country;
	
	@FindBy(name="description")
	WebElement description;
	
	@FindBy(xpath=("(//input[@name='selected_id'])[10]"))
	WebElement select;
	
	@FindBy(xpath=("(//input[@type='submit'])[3]"))
	WebElement delete;
	
	@FindBy(xpath=("(//input[@type='submit'])[5]"))
	WebElement changestatus;
	
	@FindBy(xpath=("(//input[@name='firstname'])[2]"))
	WebElement searchfname;
	
	@FindBy(xpath=("(//input[@name='lastname'])[2]"))
	WebElement searchlname;
	
	@FindBy(xpath=("(//input[@type='submit'])[2]"))
	WebElement searchbtn;
	
	public void CreateLeadwithMandatoryField(String lastname, String company) 
	{
		ClickNewLead();
		cm.EnterValue(driver, lname, lastname,"Lastname");
		cm.EnterValue(driver, comp, company,"Company");
		cm.ClickElement(driver, save,"Save Button");
	}
	
	public void CreateLeadwithAllField(String salutation,String firstname,String lastname,String company,String design,String mob) 
	{
		ClickNewLead();
		cm.SelectByValue(driver, sal, salutation, "Salutationtype");
		cm.EnterValue(driver, fname, firstname,"Firstname");
		cm.EnterValue(driver, lname, lastname,"Lastname");
		cm.EnterValue(driver, comp, company,"Company");
		cm.EnterValue(driver, designation, design,"Designation");
		cm.EnterValue(driver, mobile, mob,"Mobile Number");
	}
	
	public void AddressDescription(String lan, String cod, String stat,String coun,String des) 
	{
		cm.EnterValue(driver,lane,lan,"Street");	
		cm.EnterValue(driver,code,cod,"Pincode");
		cm.EnterValue(driver,state,stat,"State");
		cm.EnterValue(driver,country,coun,"Country");
		cm.EnterValue(driver, description, des,"Description");
		cm.ClickElement(driver, save,"Save Button");
	}
	
	public void DeleteLead()
	{
		ClickLeads();
		cm.ClickElement(driver, select,"To Select 'lead' checkbox");
		cm.ClickElement(driver, delete,"Delete Button");
	}
	
	public void ChangeStatus()
	{
		cm.ClickElement(driver, select,"To Select 'lead' checkbox");
		cm.ClickElement(driver, changestatus,"Change Status Button");
		cm.SelectByIndex(driver, lead_status, 1, "Lead Status");		
	}
	
	public void SearchName()
	{
		ClickLeads();
		cm.EnterValue(driver, searchfname, "Pratik","search first name");
		cm.EnterValue(driver, searchlname, "Gedam","search last name");
		cm.ClickElement(driver, searchbtn,"Search Button");
	}






}
