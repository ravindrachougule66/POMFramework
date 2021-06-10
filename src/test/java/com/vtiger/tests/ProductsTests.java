package com.vtiger.tests;

import org.testng.annotations.Test;

import com.vtiger.pages.ProductsPage;


public class ProductsTests extends BaseTests{
	
	
	@Test
	public void verifyCreateNewProduct_TC01()
	{
		logger = extent.createTest("Verify Create New Product_TC01");
		ProductsPage pp = new ProductsPage(driver);
		pp.CreateNewProduct("Vtiger 15 Users Pack", "004", "0.000",2);
		extent.flush();
	}
	@Test
	public void verifySubMenusOnProductsPage_TC02()
	{
		logger = extent.createTest("verify New Event_TC02");
		ProductsPage pp = new ProductsPage(driver);
		pp.ClickProducts();
		pp.IssubMenuProductsDisplay();
		pp.IssubMenuVendorsDisplay();
		pp.IssubMenuPriceBooksDisplay();
		extent.flush();
	}
	
	

}
