package com.vtiger.tests;

import org.testng.annotations.Test;

import com.vtiger.pages.ProductsPage;


public class ProductsTests extends BaseTests{
	
	public ProductsPage pp;
	
	@Test (priority=3)
	public void verifyCreateNewPriceBook_TC04()
	{
		logger = extent.createTest("Verify Create New Price Book_TC04");
		pp = new ProductsPage(driver);
		pp.CreateNewPriceBook("Internet Sales","New Internet sales price book added");
		extent.flush();
	}
	@Test (priority=2)
	public void verifyCreateNewVendor_TC03()
	{
		logger = extent.createTest("Verify Create New Vendor_TC03");
		pp = new ProductsPage(driver);
		pp.CreateNewVendor("Mark","(095)859-7757","mark@company.com","www.vtigercrm.com","306-Internet Sales","999 Baker Way","San Jose","CA","77899","USA");
		extent.flush();
	}
	@Test (priority=1)
	public void verifyCreateNewProduct_TC02()
	{
		logger = extent.createTest("Verify Create New Product_TC02");
		pp = new ProductsPage(driver);
		pp.CreateNewProduct("Vtiger 15 Users Pack","004","MetBeat Corp","5");
		extent.flush();
	}
	@Test (priority=0)
	public void verifySubMenusOnProductsPage_TC01()
	{
		logger = extent.createTest("Verify SubMenus On Products Page_TC01");
		pp = new ProductsPage(driver);
		pp.ClickProducts();
		pp.IssubMenuProductsDisplay();
		pp.IssubMenuVendorsDisplay();
		pp.IssubMenuPriceBooksDisplay();
		extent.flush();
	}
	
	

}
