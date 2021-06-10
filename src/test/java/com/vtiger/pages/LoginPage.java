package com.vtiger.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vtiger.lib.commonfunctions;


public class LoginPage {
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name") 
	WebElement eleUserid;
	
	@FindBy(name="user_password")
	WebElement elepwd;
	
	@FindBy(name="Login") 
	WebElement eleBtn;
	
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']") 
	WebElement elelogo;
	
	@FindBy(xpath="//font[text()='Key Modules']")
	WebElement keytext;
	
	@FindBy(linkText="vtiger Customer Portal")
	WebElement customerportal;
	
	@FindBy(xpath="//*[contains(text(),'You must specify a valid username and password')]")
	WebElement inlavidmsg;
	

	public void Login(String userid, String pwd) 
	{
		cm.EnterValue(driver,eleUserid, userid,"Username");
		cm.EnterValue(driver,elepwd, pwd,"Password");
		cm.ClickElement(driver,eleBtn,"Login Button");
	}
	
	public boolean InvalidLogin(String userid, String pwd) 
	{
		cm.EnterValue(driver,eleUserid, userid,"Username");
		cm.EnterValue(driver,elepwd, pwd,"Password");
		cm.ClickElement(driver,eleBtn,"Login Button");
		return cm.IsElementPresent(driver, inlavidmsg,"Inlavid Login message");
	}
	
	public boolean verifylogo()
	{
		return cm.IsElementPresent(driver, elelogo,"Logo");
	}
	public boolean verifytextKeyModules()
	{
		return cm.IsElementPresent(driver, keytext,"Key Modules");
	}
	public boolean Vtigercustomerportal()
	{
		return cm.IsElementPresent(driver, customerportal,"Vtiger Customer Portal link");
	}
	
	
	

	

	

}
