package com.vtiger.lib;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.vtiger.tests.BaseTest;



public class commonfunctions {
	
	public WebDriverWait w;
	//Enter value in text box
	public void EnterValue(WebDriver driver,WebElement elm, String val, String fieldname)
	{
		w = new WebDriverWait(driver,30);
		try
		{
		w.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(val);
		BaseTest.logger.pass(val+ " has been entered in "+fieldname+" field");
		}
		catch(Exception e)
		{
			BaseTest.logger.fail(val+ " has not been entered in "+fieldname+" field");
			BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
			System.out.println(e.getMessage());
		}
	}
	//Select value from Drop-down by index
	public void SelectByIndex(WebDriver driver,WebElement elm, int val, String fieldname)
	{
		w = new WebDriverWait(driver,30);
		try
		{
		w.until(ExpectedConditions.visibilityOf(elm));
		Select sel = new Select(elm);
		sel.selectByIndex(val);
		BaseTest.logger.pass("Option "+val+ " has been selected from "+fieldname);
		}
		catch(Exception e)
		{
			BaseTest.logger.fail("Option "+val+ " has not been selected from "+fieldname);
			BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
			System.out.println(e.getMessage());
		}
	}
	//Select value from Drop-down by value
	public void SelectByValue(WebDriver driver,WebElement elm, String val, String fieldname)
	{
		w = new WebDriverWait(driver,30);
		try
		{
		w.until(ExpectedConditions.visibilityOf(elm));
		Select sel = new Select(elm);
		sel.selectByValue(val);
		BaseTest.logger.pass(val+ " has been selected from "+fieldname);
		}
		catch(Exception e)
		{
			BaseTest.logger.fail(val+ " has not been selected from "+fieldname);
			BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
			System.out.println(e.getMessage());
		}
	}
	//Select visible value from Drop-down
	public void SelectByVisibleText(WebDriver driver,WebElement elm, String val, String fieldname)
	{
		w = new WebDriverWait(driver,30);
		try
		{
		w.until(ExpectedConditions.visibilityOf(elm));
		Select sel = new Select(elm);
		sel.selectByVisibleText(val);
		BaseTest.logger.pass(val+ " has been selected from "+fieldname);
		}
		catch(Exception e)
		{
			BaseTest.logger.fail(val+ " has not been selected from "+fieldname);
			BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
			System.out.println(e.getMessage());
		}
	}
	//Alert Handler-Accept
	public void AlertHandler(WebDriver driver)
	{
		String val = "None";
		w = new WebDriverWait(driver,30);
		try
		{
		w.until(ExpectedConditions.alertIsPresent());
		val = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		BaseTest.logger.pass("Getting alert "+val + " then clicked 'OK'");
		}
		catch(Exception e)
		{
			BaseTest.logger.fail("Getting alert "+val + " not clicked 'OK'");
			BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
			System.out.println(e.getMessage());
		}
	}
	//Alert Handler-dismiss
	public void AlertHandlerDismiss(WebDriver driver)
	{
		String val = "None";
		w = new WebDriverWait(driver,30);
		try
		{
		w.until(ExpectedConditions.alertIsPresent());
		val = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		BaseTest.logger.pass("Getting alert "+val + " then clicked 'Cancel'");
		}
		catch(Exception e)
		{
			BaseTest.logger.fail("Getting alert "+val + " not clicked 'Cancel'");
			BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
			System.out.println(e.getMessage());
		}
	}
	//Click on element
	public void ClickElement(WebDriver driver,WebElement elm, String fieldname)
	{
		w = new WebDriverWait(driver,30);
		try
		{
		w.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		BaseTest.logger.pass(fieldname+ " has been Clicked");
		}
		catch(Exception e)
		{
			BaseTest.logger.fail(fieldname+ " did not Clicked");
			BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
			System.out.println(e.getMessage());
		}
	}
	//Move to element by mouse
	public void MoveToElement(WebDriver driver,WebElement elm,String fieldname)
	{
		w = new WebDriverWait(driver,30);
		try
		{
		w.until(ExpectedConditions.elementToBeClickable(elm));
		Actions act = new Actions(driver);
		act.moveToElement(elm).build().perform();
		BaseTest.logger.pass("Mouse has been moved to "+fieldname);
		}
		catch(Exception e)
		{
			BaseTest.logger.fail(fieldname+ " did not Clicked");
			System.out.println(e.getMessage());
		}
	}
		//verify element present
		public boolean IsElementPresent(WebDriver driver,WebElement elm, String fieldname)
		{
			w = new WebDriverWait(driver,30);
			boolean val = false;
			try
			{
			w.until(ExpectedConditions.visibilityOf(elm));
			val = elm.isDisplayed();
			BaseTest.logger.pass(fieldname+ " Displayed successfully");			
			}
			catch(Exception e)
			{
				BaseTest.logger.fail(fieldname+ " not found");
				BaseTest.logger.info("Screenshot captured: <a href="+getScreenshot(driver,"file")+">Screenshot</a>");
				System.out.println(e.getMessage());
			}
			return val;
		}
		//Captured Screenshot
		public static String getScreenshot(WebDriver driver, String screenshotName)  
		{
			//below line is just to append the date format with the screenshot name to avoid duplicate names		
		    String destination=null;
			try
			{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			//after execution, you could see a folder "FailedTestsScreenshots" under src folder
			destination = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//Returns the captured file path
			return destination;
		}
		//Select value from present items on popup window
		public void ActionOnPopUpWindows(WebDriver driver, WebElement elm, String fieldname)
		{
			w = new WebDriverWait(driver,30);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Set<String> set = driver.getWindowHandles();
			Iterator <String> iter = set.iterator();
			String fwindow = iter.next();
			String swindow = iter.next();
			driver.switchTo().window(swindow);
			elm.click();
			driver.switchTo().window(fwindow);
			BaseTest.logger.pass(fieldname+ " has been Selected");
		}
		//Enter value in text box on popup window	
		public void ActionOnPopUpWindowsEnterValue(WebDriver driver, WebElement elm1,WebElement elm2,String val,String fieldname)
		{
			w = new WebDriverWait(driver,30);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Set<String> set = driver.getWindowHandles();
			Iterator <String> iter = set.iterator();
			String fwindow = iter.next();
			String swindow = iter.next();
			driver.switchTo().window(swindow);
			elm1.clear();
			elm1.sendKeys(val);
			elm2.click();
			driver.close();
			driver.switchTo().window(fwindow);
			BaseTest.logger.pass(fieldname+ " has been Entered and submitted");
		}	
}
		
	
	


