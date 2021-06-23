package com.vtiger.tests;

import org.testng.annotations.Test;
import com.vtiger.pages.ContactsPage;


public class ContactsTest extends BaseTest{
	
	@Test (priority=0)
	public void CreateNewContact_TC01() throws InterruptedException
	{		
		logger = extent.createTest("verify Create New Contact_TC01");
		ContactsPage cp = new ContactsPage(driver);
		cp.CreateNewContact("Mr.", "Glen", "Tucker","Public Relations","President","glen.tucker@gmail.com","(508)242-6089", "(601)711-4368", "(918)453-0462", "1990-06-01");
		extent.flush();
	}
	@Test (priority=0)
	public void ContactSearchAndDelete_TC02() throws InterruptedException
	{		
		logger = extent.createTest("verify Contact Search And Delete_TC02");
		ContactsPage cp = new ContactsPage(driver);
		cp.ContactSearchAndDelete("Glen", "Tucker", "EDFG Group Limited");
		extent.flush();
	}

}
