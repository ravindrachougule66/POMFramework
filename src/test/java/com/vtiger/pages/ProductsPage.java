package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.lib.commonfunctions;

public class ProductsPage extends HeaderPage{
	
	public WebDriver driver;
	commonfunctions cm = new commonfunctions();
	
	
	public ProductsPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(linkText="Products")
	WebElement Products;
	
	@FindBy(linkText="Vendors")
	WebElement Vendors;
	
	@FindBy(linkText="Price Books")
	WebElement PriceBooks;
	
	@FindBy(name="productname")
	WebElement productname;
	
	@FindBy(name="productcode")
	WebElement productcode;
	
	@FindBy(name="discontinued")
	WebElement discontinued;
	
	@FindBy(name="manufacturer")
	WebElement manufacturer;
	
	@FindBy(name="commissionrate")
	WebElement commissionrate;
	
	@FindBy(xpath="(//input[@name='button'])[4]")
	WebElement save;
	
	
	public void CreateNewProduct(String pname, String Pcode,String crate, int manufact)
	{
		ClickNewProduct();
		cm.EnterValue(driver, productname, pname, "Product Name");
		cm.EnterValue(driver, productcode, Pcode, "Product Code");
		cm.ClickElement(driver, discontinued, "Product Active");
		cm.SelectByIndex(driver, manufacturer, manufact, "Manufacturer");
		cm.EnterValue(driver, commissionrate, crate, "Commission Rate");
		cm.ClickElement(driver, save, "Save button");
		cm.AlertHandler(driver);
		driver.switchTo().alert().accept();	
	}
	public boolean IssubMenuProductsDisplay()
	{
		return cm.IsElementPresent(driver, Products, "Products");
	}
	public boolean IssubMenuVendorsDisplay()
	{
		return cm.IsElementPresent(driver, Vendors, "Vendors");
	}
	public boolean IssubMenuPriceBooksDisplay()
	{
		return cm.IsElementPresent(driver, PriceBooks, "Price Books");
	}

}
