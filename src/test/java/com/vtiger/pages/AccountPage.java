package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class AccountPage extends HeaderPage{
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public AccountPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@name='accountname'])[2]")
	WebElement accountname;
	
	@FindBy(xpath="//a[@id='showSubMenu']")
	WebElement showSubMenu;
	
	@FindBy(linkText="New PriceBook")
	WebElement NewPriceBook;
	
	@FindBy(name="bookname")
	WebElement bookname;
	
	@FindBy(xpath="(//input[@name='button'])[3]")
	WebElement savebtn;
	
	@FindBy(xpath="(//input[@name='button'])[2]")
	WebElement searchbtn;
	
	@FindBy(xpath="//input[@name='btn1']")
	WebElement changebtn;
	
	@FindBy(name="accountname")
	WebElement actname;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="website")
	WebElement website;
	
	@FindBy(name="bill_city")
	WebElement billcity;
	
	@FindBy(linkText="EDFG Group Limited")
	WebElement EDFGgroup;
	
	@FindBy(name="name")
	WebElement aname;
	
	public void searchAccount(String acc)
	{
		ClickAccounts();
		cm.EnterValue(driver, accountname, acc,"Account Name");
		cm.ClickElement(driver, searchbtn, "Search button");
	}
	public void CreateNewAccountWithMandatoryField(String aname)
	{
		ClickNewAccount();
		cm.EnterValue(driver, actname, aname, "Account name");
		cm.ClickElement(driver, savebtn, "Save button");
	}
	
	public void CreateNewAccountWithAllField(String aname,String ph, String web, String bcity) throws InterruptedException
	{
		ClickNewAccount();
		cm.EnterValue(driver, actname, aname, "Account name");
		cm.EnterValue(driver, phone, ph, "Phone");
		cm.EnterValue(driver, website, web, "Website");
		cm.ClickElement(driver, changebtn, "Change button");
		cm.ActionOnPopUpWindows(driver, EDFGgroup, "EDFG Group Limited");
		cm.EnterValue(driver, billcity, bcity, "City");
		cm.ClickElement(driver, savebtn, "Save button");
	}

}
