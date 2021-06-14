package com.vtiger.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.vtiger.lib.logincommonfunctions;


public class LoginPage extends HeaderPage{
	
	public WebDriver driver;
	logincommonfunctions lcm = new logincommonfunctions();
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name") 
	WebElement eleUserid;
	
	@FindBy(name="user_password")
	WebElement elepwd;
	
	@FindBy(name="Login") 
	WebElement eleBtn;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
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
		lcm.EnterValue(driver,eleUserid, userid,"Username");
		lcm.EnterValue(driver,elepwd, pwd,"Password");
		lcm.ClickElement(driver,eleBtn,"Login Button");
		lcm.ClickElement(driver, logout, "Logout Button");
	}
	
	public boolean InvalidLogin(String userid, String pwd) 
	{
		lcm.EnterValue(driver,eleUserid, userid,"Username");
		lcm.EnterValue(driver,elepwd, pwd,"Password");
		lcm.ClickElement(driver,eleBtn,"Login Button");
		return lcm.IsElementPresent(driver, inlavidmsg,"Inlavid Login message");
	}
	
	public boolean verifylogo()
	{
		return lcm.IsElementPresent(driver, elelogo,"Logo");
	}
	public boolean verifytextKeyModules()
	{
		return lcm.IsElementPresent(driver, keytext,"Key Modules");
	}
	public boolean Vtigercustomerportal()
	{
		return lcm.IsElementPresent(driver, customerportal,"Vtiger Customer Portal link");
	}
	
	
	
	
	
	
	

	

	

}
