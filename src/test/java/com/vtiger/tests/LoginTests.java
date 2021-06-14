package com.vtiger.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.lib.Xls_Reader;
import com.vtiger.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests{
	
	public WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public List<List<String>> ls;
	public LoginPage lp;
	

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
		lp = new LoginPage(driver);
		String path = System.getProperty("user.dir")+"/src/test/resources/TestData/vTigerTestData.xlsx";
		ls=ReadExcelDataIntoList(path, "Login");
		lp.Login(ls.get(1).get(1), ls.get(1).get(2));
		driver.quit();
		extent.flush();
		
	}
	
	@Test (priority=1)
	public void verifyInvalidLogin_TC02()
	{
		try
		{
		logger = extent.createTest("verify Invalid Login_TC02");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		String path = System.getProperty("user.dir")+"/src/test/resources/TestData/vTigerTestData.xlsx";
		ls=ReadExcelDataIntoList(path, "Login");
		lp.InvalidLogin(ls.get(2).get(1), ls.get(2).get(2));
		driver.quit();
		extent.flush();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			driver.quit();
		}
	}
	
	@Test (priority=2)
	public void verifyElementsOnLoginPage_TC03()
	{
		try
		{
		logger = extent.createTest("verify Elements On Login Page_TC03");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		lp.verifylogo();
		lp.verifytextKeyModules();
		lp.Vtigercustomerportal();
		driver.quit();
		extent.flush();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		driver.quit();
	}
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
	
	public List<List<String>> ReadExcelDataIntoList(String path, String sheet)
	{
		Xls_Reader xr = new Xls_Reader(path);
		int rowcount = xr.getRowCount(sheet);
		int colcount = xr.getColumnCount(sheet);
		List<List<String>> ls = new ArrayList<List<String>>();
		
		List<String> lst=null ;
		for(int i=1;i<=rowcount;i++)
		{
			 lst = new ArrayList<String>();
			 
			for(int j=0;j<=colcount;j++)
			{
				String data = xr.getCellData(sheet, j, i).trim();
				lst.add(data);
			}
			
			ls.add(lst);
		}
		return ls;
	}
	
	


}
