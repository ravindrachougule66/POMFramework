package com.vtiger.tests;

import org.testng.annotations.Test;
import com.vtiger.pages.AccountPage;


public class AccountTests extends BaseTests{
	
	//@Test (priority=0)
	public void verifyAccountSearch_TC01()
	{		
		logger = extent.createTest("verify Account Search_TC01");
		AccountPage ap = new AccountPage(driver);
		ap.searchAccount("vtiger");
		extent.flush();
	}
	
	@Test (priority=1)
	public void verifySubMenu_TC02()
	{		
		logger = extent.createTest("verify Sub Menu_TC02");
		AccountPage ap = new AccountPage(driver);
		ap.showSubMenu("Inventary");
		extent.flush();
	}
	
	@Test (priority=2)
	public void verifyCreateNewAccountWithMandatoryFields_TC03()
	{		
		logger = extent.createTest("Verify Create New Account With Mandatory Fields_TC03");
		AccountPage ap = new AccountPage(driver);
		ap.CreateNewAccountWithMandatoryField("vtiger CRM");
		extent.flush();
	}
	
	@Test (priority=3)
	public void verifyCreateNewAccountWithAllFields_TC03() throws InterruptedException
	{		
		logger = extent.createTest("Verify Create New Account With All Fields_TC03");
		AccountPage ap = new AccountPage(driver);
		ap.CreateNewAccountWithAllField("vtiger", "(530) 707-9476)", "www.vtiger.com", "San Francisco");
		extent.flush();
	}
	

}
