package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class HeaderPage {
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public HeaderPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	@FindBy(linkText="New Account")
	WebElement NewAccount;
	
	@FindBy(linkText="New Lead")
	WebElement newlead;
	
	@FindBy(linkText="Accounts")
	WebElement Accounts;
	
	@FindBy(linkText="Products")
	WebElement Products;
	
	@FindBy(linkText="Calendar")
	WebElement Calender;
	
	@FindBy(linkText="Leads")
	WebElement leads;
	
	@FindBy(linkText="Activities")
	WebElement Activities;
	
	@FindBy(linkText="New Event")
	WebElement NewEvent;
	
	@FindBy(linkText="New Product")
	WebElement NewProduct;
	
	@FindBy(linkText="Contacts")
	WebElement Contacts;
	
	@FindBy(linkText="Potentials")
	WebElement Potentials;
	
	@FindBy(linkText="Notes")
	WebElement Notes;
	
	@FindBy(linkText="Emails")
	WebElement Emails;
	
	@FindBy(linkText="Help Desk")
	WebElement HelpDesk;
	
	@FindBy(linkText="Dashboard")
	WebElement Dashboard;
	
	@FindBy(linkText="Quotes")
	WebElement Quotes;
	
	@FindBy(linkText="Orders")
	WebElement Orders;
	
	@FindBy(linkText="Invoice")
	WebElement Invoice;
	
	@FindBy(linkText="RSS")
	WebElement RSS;
	
	@FindBy(linkText="Reports")
	WebElement Reports;
	
	public void ClickNewAccount() 
	{
		cm.ClickElement(driver, NewAccount, "New Account link");
	}
	public void ClickQuotes() 
	{
		cm.ClickElement(driver, Quotes, "Quotes");
	}
	public void ClickOrders() 
	{
		cm.ClickElement(driver, Orders, "Orders");
	}
	public void ClickInvoice() 
	{
		cm.ClickElement(driver, Invoice, "Invoice");
	}
	public void ClickRSS() 
	{
		cm.ClickElement(driver, RSS, "RSS");
	}
	public void ClickReports() 
	{
		cm.ClickElement(driver, Reports, "Reports");
	}
	public void ClickContacts() 
	{
		cm.ClickElement(driver, Contacts, "Contacts");
	}
	public void ClickPotentials() 
	{
		cm.ClickElement(driver, Potentials, "Potentials");
	}
	public void ClickNotes() 
	{
		cm.ClickElement(driver, Notes, "Notes");
	}
	public void ClickEmails() 
	{
		cm.ClickElement(driver, Emails, "Emails");
	}
	public void ClickHelpDesk() 
	{
		cm.ClickElement(driver, HelpDesk, "HelpDesk");
	}
	public void ClickDashboard() 
	{
		cm.ClickElement(driver, Dashboard, "Dashboard");
	}
	public void ClickProducts() 
	{
		cm.ClickElement(driver, Products, "Products menu");
	}
	public void ClickNewProduct() 
	{
		cm.ClickElement(driver, NewProduct, "New Product link");
	}
	public void ClickActivities() 
	{
		cm.ClickElement(driver, Activities, "Activities menu");
	}
	public void ClickNewEvent() 
	{
		cm.ClickElement(driver, NewEvent, "New Event link");
	}
	public void ClickLeads() 
	{
		cm.ClickElement(driver, leads, "Leads menu");
	}
	public void ClickCalender() 
	{
		cm.ClickElement(driver, Calender, "Calender menu");
	}
	public void ClickNewLead() 
	{
		cm.ClickElement(driver, newlead, "New Lead link");
	}
	public void ClickAccounts() 
	{
		cm.ClickElement(driver, Accounts, "Accounts menu");
	}
	public void Logout()
	{
		cm.ClickElement(driver, logout, "Logout link");
	}

}
