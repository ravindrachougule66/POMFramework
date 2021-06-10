package com.vtiger.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	public static WebDriver driver;
	public Properties prop;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void readSetting() throws IOException
	{
		System.out.println("Test Git");
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/vtiger/config/setting.properties");
		prop.load(fis);
		createReport();
		LaunchApplication();
	}
	
	public void LaunchApplication()
		{
			logger = extent.createTest("Browser Application launched");
			if(prop.getProperty("browser").equals("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
			if(prop.getProperty("browser").equals("edge"))
				{
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}
			else if(prop.getProperty("browser").equals("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			int time = Integer.parseInt(prop.getProperty("wait"));
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
			LoginPage lp = new LoginPage(driver);
			lp.Login(prop.getProperty("userid"), prop.getProperty("pwd"));
			extent.flush();
		}
	
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
	
	@AfterSuite
	public void CloseBrowser()
	{
		logger = extent.createTest("Closing the Browser");
		HeaderPage hp = new HeaderPage(driver);
		hp.Logout();
		driver.quit();
		extent.flush();
	}

}
