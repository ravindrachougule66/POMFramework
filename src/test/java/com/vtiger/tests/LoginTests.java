package com.vtiger.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests{
	
	public WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	
	
	public void createReport() 
	{
		DateFormat f = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		Date d = new Date();
		String str = f.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+str+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Ravi");
		extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Ravindra");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD); 
	}
	
	@BeforeSuite
	public void report()
	{
		createReport();
	}
	
	
	@Test (priority=0)
	public void verifyValidLogin_TC01()
	{
		logger = extent.createTest("verify Valid Login_TC01");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.Login("admin", "admin");
		HeaderPage hp = new HeaderPage(driver);
		hp.Logout();
		driver.quit();
		extent.flush();
	}
	
	@Test (priority=1)
	public void verifyInvalidLogin_TC02()
	{
		logger = extent.createTest("verify Invalid Login_TC02");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.Login("admin123", "admin123");
		driver.quit();
		extent.flush();
	}
	
	@Test (priority=2)
	public void verifyElementsOnLoginPage_TC03()
	{
		logger = extent.createTest("verify Elements On Login Page_TC03");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.verifylogo();
		lp.verifytextKeyModules();
		lp.Vtigercustomerportal();
		driver.quit();
		extent.flush();
	}


}
