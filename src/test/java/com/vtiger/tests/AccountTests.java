package com.vtiger.tests;

import org.testng.annotations.Test;
import com.vtiger.pages.AccountPage;


public class AccountTests extends BaseTests{
	
	@Test (priority=2)
	public void verifyAccountSearch_TC03()
	{		
		logger = extent.createTest("verify Account Search_TC01");
		AccountPage ap = new AccountPage(driver);
		ap.searchAccount("vtiger");
		extent.flush();
	}
	
	@Test (priority=0)
	public void verifyCreateNewAccountWithMandatoryFields_TC01()
	{		
		logger = extent.createTest("Verify Create New Account With Mandatory Fields_TC03");
		AccountPage ap = new AccountPage(driver);
		ap.CreateNewAccountWithMandatoryField("vtiger CRM");
		extent.flush();
	}
	
	@Test (priority=1)
	public void verifyCreateNewAccountWithAllFields_TC02() throws InterruptedException
	{		
		logger = extent.createTest("Verify Create New Account With All Fields_TC03");
		AccountPage ap = new AccountPage(driver);
		ap.CreateNewAccountWithAllField("vtiger", "(530) 707-9476)", "www.vtiger.com", "San Francisco");
		extent.flush();
	}
	

}
