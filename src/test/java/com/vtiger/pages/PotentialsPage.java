package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.vtiger.lib.commonfunctions;

public class PotentialsPage extends HeaderPage{
		
		public WebDriver driver;
		commonfunctions cm = new commonfunctions();
		
		public PotentialsPage(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

}
