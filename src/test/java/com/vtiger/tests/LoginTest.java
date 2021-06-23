package com.vtiger.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.vtiger.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest{
	
	public WebDriver driver;

	
	//@Test (priority=0)
	public void verifyValidLogin_TC01()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.Login("admin", "admin");
		driver.quit();
	}
	
	//@Test (priority=1)
	public void verifyInvalidLogin_TC02()
	{	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.Login("admin123", "admin123");
		driver.quit();
	}
	
	//@Test (priority=2)
	public void verifyElementsOnLoginPage_TC03()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.verifylogo();
		lp.verifytextKeyModules();
		lp.Vtigercustomerportal();
		driver.quit();
	}


}
