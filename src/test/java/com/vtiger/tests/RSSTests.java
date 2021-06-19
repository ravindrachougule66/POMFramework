package com.vtiger.tests;

import org.testng.annotations.Test;
import com.vtiger.pages.RSSPage;

public class RSSTests extends BaseTests{
	
	@Test (priority=0)
	public void VerifyRSSHomePage_TC01()
	{		
		logger = extent.createTest("Verify RSS Home Page_TC01");
		RSSPage rp = new RSSPage(driver);
		rp.RSSHomePage();
		extent.flush();
	}
	
	@Test (priority=1)
	public void VerifyRSSLinksPresentOnPage_TC02()
	{		
		logger = extent.createTest("Verify RSS Links Present On Page_TC02");
		RSSPage rp = new RSSPage(driver);
		rp.RSSLinksPresentOnPage();
		extent.flush();
	}
	
	@Test (priority=2)
	public void VerifyAddRSSFeed_TC02()
	{		
		logger = extent.createTest("Verify Add RSS Feed_TC03");
		RSSPage rp = new RSSPage(driver);
		rp.AddRSSFeed("http://localhost:100/");
		extent.flush();
	}

}
