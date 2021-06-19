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
	
	@FindBy(linkText="Contacts")
	WebElement Contacts;
	
	@FindBy(linkText="Potentials")
	WebElement Potentials;
	
	@FindBy(linkText="Notes")
	WebElement Notes;
	
	@FindBy(linkText="Emails")
	WebElement Emails;
	
	@FindBy(linkText="HelpDesk")
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
	
	@FindBy(linkText="New Account")
	WebElement NewAccount;
	
	@FindBy(linkText="New Lead")
	WebElement newlead;
	
	@FindBy(linkText="New Event")
	WebElement NewEvent;
	
	@FindBy(linkText="New Product")
	WebElement NewProduct;
	
	@FindBy(linkText="New Contact")
	WebElement NewContact;
	
	@FindBy(xpath="(//input[@name='button'])[2]")
	WebElement searchbutton;
	
	@FindBy(xpath="(//input[@name='button'])[3]")
	WebElement savebutton;
	
	@FindBy(xpath=("(//input[@type='submit'])[3]"))
	WebElement deletebutton;
	
	public void ClickDeleteButton()
	{
		cm.ClickElement(driver, deletebutton, "Delete button");
	}
	public void ClickSaveButton() 
	{
		cm.ClickElement(driver, savebutton, "Save button");
	}
	public void ClickSearchButton() 
	{
		cm.ClickElement(driver, searchbutton, "Search button");
	}
	public void ClickNewContact() 
	{
		cm.ClickElement(driver, NewContact, "New Contact link");
	}
	public void ClickNewAccount() 
	{
		cm.ClickElement(driver, NewAccount, "New Account link");
	}
	public void ClickQuotes() 
	{
		cm.ClickElement(driver, Quotes, "Quotes menu");
	}
	public void ClickOrders() 
	{
		cm.ClickElement(driver, Orders, "Orders menu");
	}
	public void ClickInvoice() 
	{
		cm.ClickElement(driver, Invoice, "Invoice menu");
	}
	public void ClickRSS() 
	{
		cm.ClickElement(driver, RSS, "RSS menu");
	}
	public void ClickReports() 
	{
		cm.ClickElement(driver, Reports, "Reports menu");
	}
	public void ClickContacts() 
	{
		cm.ClickElement(driver, Contacts, "Contacts menu");
	}
	public void ClickPotentials() 
	{
		cm.ClickElement(driver, Potentials, "Potentials");
	}
	public void ClickNotes() 
	{
		cm.ClickElement(driver, Notes, "Notes menu");
	}
	public void ClickEmails() 
	{
		cm.ClickElement(driver, Emails, "Emails menu");
	}
	public void ClickHelpDesk() 
	{
		cm.ClickElement(driver, HelpDesk, "HelpDesk menu");
	}
	public void ClickDashboard() 
	{
		cm.ClickElement(driver, Dashboard, "Dashboard menu");
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
