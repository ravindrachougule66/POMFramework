package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
		
		@FindBy(name="potentialname")
		WebElement potentialname;
		
		@FindBy(name="amount")
		WebElement amount;
		
		@FindBy(name="closingdate")
		WebElement closingdate;
		
		@FindBy(name="opportunity_type")
		WebElement opportunity_type;
		
		@FindBy(name="leadsource")
		WebElement leadsource;
		
		@FindBy(name="nextstep")
		WebElement nextstep;
		
		@FindBy(name="sales_stage")
		WebElement sales_stage;
		
		@FindBy(name="btn1")
		WebElement btn1;
		
		@FindBy(linkText="vtiger")
		WebElement vtiger;
		
		public void CreateNewPotential(String pname,String amt,String cdate,String otype,String nstep,String lsource,String sstage)
		{
			ClickNewPotential();
			cm.EnterValue(driver,potentialname,pname,"Potential name");
			cm.EnterValue(driver,amount,amt,"Amount");
			cm.ClickElement(driver,btn1,"Change button");
			cm.ActionOnPopUpWindows(driver,vtiger,"vtiger");
			cm.EnterValue(driver,closingdate,cdate,"Closing date");
			cm.SelectByValue(driver, opportunity_type, otype, "Business type");
			cm.EnterValue(driver, nextstep, nstep, "Next step");
			cm.SelectByValue(driver, leadsource, lsource, "Lead source");
			cm.SelectByValue(driver, sales_stage, sstage, "Sales stage");
			ClickSaveButton();
		}

}
