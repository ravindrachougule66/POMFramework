package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vtiger.lib.commonfunctions;

public class RSSPage extends HeaderPage{
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public RSSPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(),' Home')]")
	WebElement rhome;
	
	@FindBy(linkText="Starred Feeds")
	WebElement StarredFeeds;
	
	@FindBy(linkText="vtiger Discussions")
	WebElement vtigerDiscussions;
	
	@FindBy(linkText="vtiger Wiki")
	WebElement vtigerWiki;
	
	@FindBy(linkText="Add")
	WebElement Add;
	
	@FindBy(name="rssurl")
	WebElement rssurl;
	
	@FindBy(name="Button")
	WebElement addbtn;
	
	@FindBy(xpath="//input[@type='button']")
	WebElement cancelbtn;
	
	
	public void RSSHomePage()
	{
		ClickRSS();
		cm.IsElementPresent(driver, rhome, "RSS: Home");
	}
	
	public void RSSLinksPresentOnPage()
	{
		cm.IsElementPresent(driver, StarredFeeds, "Starred Feeds");
		cm.IsElementPresent(driver, vtigerDiscussions, "vtiger Discussions");
		cm.IsElementPresent(driver, vtigerWiki, "vtiger Wiki");
	}
	
	public void AddRSSFeed(String url)
	{
		cm.ClickElement(driver, Add, "Add New RSS Feed");
		cm.ActionOnPopUpWindowsEnterValue(driver, rssurl,addbtn,url,"RSS URL");
	}

}
