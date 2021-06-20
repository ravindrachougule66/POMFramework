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
	@FindBy(name="vendorname")
	WebElement vendorname;
	@FindBy(name="phone")
	WebElement phone;
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="website")
	WebElement website;
	@FindBy(name="glacct")
	WebElement glacct;
	@FindBy(name="treet")
	WebElement treet;
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	@FindBy(name="state")
	WebElement state;
	@FindBy(name="postalcode")
	WebElement postalcode;
	@FindBy(name="country")
	WebElement country;
	@FindBy(name="bookname")
	WebElement bookname;
	@FindBy(name="description")
	WebElement description;
	@FindBy(name="active")
	WebElement active;
	@FindBy(xpath="(//input[@name='button'])[4]")
	WebElement savebtn;
	
	public void CreateNewPriceBook(String bname,String des)
	{
		ClickNewPriceBook();
		cm.EnterValue(driver,bookname,bname,"Price Book name");
		cm.ClickElement(driver,active,"Active checkbox");
		cm.EnterValue(driver,description,des,"Description");
		ClickSaveButton();
	}
	public void CreateNewVendor(String vname,String ph,String mail,String web,String gacct,String street,String cit,String stat,String pcode,String count)
	{
		ClickNewVendor();
		cm.EnterValue(driver,vendorname,vname,"Vendor name");
		cm.EnterValue(driver,phone,ph,"Phone");
		cm.EnterValue(driver,email,mail,"Email");
		cm.EnterValue(driver,website,web,"Website");
		cm.SelectByValue(driver,glacct,gacct,"GL Account");
		cm.EnterValue(driver,treet,street,"Street");
		cm.EnterValue(driver,city,cit,"City");
		cm.EnterValue(driver,state,stat,"State");
		cm.EnterValue(driver,postalcode,pcode,"Postal code");
		cm.EnterValue(driver,country,count,"Country");
		ClickSaveButton();
	}
	public void CreateNewProduct(String pname,String Pcode,String manufact,String crate)
	{
		ClickNewProduct();
		cm.EnterValue(driver, productname, pname, "Product Name");
		cm.EnterValue(driver, productcode, Pcode, "Product Code");
		cm.ClickElement(driver, discontinued, "Product Active");
		cm.SelectByValue(driver,manufacturer,manufact,"Manufacturer");
		cm.EnterValue(driver, commissionrate, crate, "Commission Rate");
		cm.ClickElement(driver, savebtn, "Save button");
		cm.AlertHandler(driver);
		driver.switchTo().alert().accept();
		ClickCancelbutton();		
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
