package com.vtiger.tests;

import org.testng.annotations.Test;

import com.vtiger.pages.NotesPage;

public class NotesTest extends BaseTest{
	
	public NotesPage np;
	
	@Test (priority=0)
	public void verifyCreateNewNote_TC01()
	{
		logger = extent.createTest("Verify Create New Note_TC01");
		np = new NotesPage(driver);
		np.CreateNewNote("Online","Need to take follow up");
	}

}
